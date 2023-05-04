package server;

import server.commands.Save;
import server.help.Loader;
import server.help.RequestAccepter;
import common.help.*;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Server {
    private int port;
    private final BufferedReader serverReader = new BufferedReader(new InputStreamReader(System.in));
    private final byte[] BUFFER = new byte[4096];
    private Selector selector;
    private DatagramChannel datagramChannel;
    private RequestAccepter requestAccepter;
    private InetAddress host;
    private Loader loader;
    private static final Logger logger = LogManager.getLogger(RunServer.class);

    public Server(int port, RequestAccepter requestAccepter) throws IOException {
        this.port = port;
        this.loader = new Loader();
        this.requestAccepter = requestAccepter;
        this.selector = Selector.open();
        this.datagramChannel = DatagramChannel.open();
        this.datagramChannel.configureBlocking(false);
        this.datagramChannel.bind(new InetSocketAddress(this.port));
        this.datagramChannel.register(selector, SelectionKey.OP_READ);
    }


    public void connection() {
        logger.info("Инициализированно подключение");
        while (true) {
            try {
                if (selector.selectNow() > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isReadable()) {
                            acceptClientRequest(key);
                        }
                    }
                }

                if (System.in.available() > 0) {
                    String line = serverReader.readLine();
                    if (line.trim().equals("save")) {
                        Save save = new Save(loader);
                        save.execute("", null);
                        System.out.println("Коллекция успешно сохранена");
                    }
                } else {
                    Thread.sleep(100);
                }
            } catch (IOException e) {
                System.out.println("Error during I/O operations: " + e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted: " + e.getMessage());
            }
        }
    }

    private void acceptClientRequest(SelectionKey key) {
        DatagramChannel clientChannel = (DatagramChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(8192);

        try {
            // Получение запроса от клиента
            SocketAddress clientAddress = clientChannel.receive(buffer);
            buffer.flip();
            // Десериализация запроса
            ByteArrayInputStream ais = new ByteArrayInputStream(buffer.array());
            ObjectInputStream ois = new ObjectInputStream(ais);
            Request userRequest = (Request) ois.readObject();
            logger.info("Запрос клиента получен");
            // Обработка запроса
            Response response = requestAccepter.createResponse(userRequest);
            // Сериализация ответа
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(response);
            byte[] responseData = bos.toByteArray();
            // Отправление ответа клиенту
            buffer.clear();
            buffer.put(responseData);
            buffer.flip();
            clientChannel.send(buffer, clientAddress);
            logger.info("Ответ отправлен клиенту");

        } catch (IOException e) {
            logger.error("Ошибка с I/O потоками: " + e.getMessage());
            System.out.println("Ошибка с I/O потоками");
        } catch (ClassNotFoundException e) {
            logger.error("Объект не может быть сериализован: " + e.getMessage());
            System.out.println("Объект не может быть сериализован");
        }
    }
}