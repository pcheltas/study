package client;

import client.help.RequestCreation;
import common.help.Printer;
import common.help.Request;
import common.help.Response;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Client {
    private String host;
    private int port;

    private RequestCreation requestCreate;
    private DatagramChannel datagramChannel = DatagramChannel.open();

    public Client(String host, int port, RequestCreation requestCreate) throws IOException {
        this.host = host;
        this.port = port;
        this.requestCreate = requestCreate;
        datagramChannel.configureBlocking(false);
    }

    private boolean processRequestToServer() {
        Request requestToServer = null;
        Response serverResponse = null;
        do {
            try {
                requestToServer = serverResponse != null ? requestCreate.createRequest(serverResponse.getResponseCode()) :
                        requestCreate.createRequest(null);
                if (requestToServer.isEmpty()) continue;
                ByteArrayOutputStream serverWriter = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(serverWriter);
                objectOutputStream.writeObject(requestToServer);
                byte[] bytes;
                bytes = serverWriter.toByteArray();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                buffer.put(bytes);
                buffer.flip();
                InetSocketAddress address = new InetSocketAddress(host, port);
                datagramChannel.send(buffer, address);
                if (requestToServer.getCommandName().equals("exit")) {
                    System.exit(0);
                }
                ByteBuffer receiveBuffer = ByteBuffer.allocate(8192);
                long timeout = 5000;
                long start = System.currentTimeMillis();
                while (datagramChannel.receive(receiveBuffer) == null && System.currentTimeMillis() - start < timeout) {

                    Thread.sleep(100);
                }
                if (System.currentTimeMillis() - start >= timeout) {
                    System.out.println("Превышено время ожидания ответа от сервера");
                    continue;
                }

                receiveBuffer.flip();
                byte[] data = new byte[receiveBuffer.limit()];
                receiveBuffer.get(data);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                Object deserializedObject = objectInputStream.readObject();
                serverResponse = (Response) deserializedObject;
                Printer.print(serverResponse.getResponseBody(), serverResponse.getResponseCode());
            } catch (NullPointerException e) {
                System.out.println("Недопустимый ввод");
                assert serverResponse != null;
                requestToServer = requestCreate.createRequest(serverResponse.getResponseCode());
            } catch (ClassNotFoundException e) {
                System.out.println("Ошибка при чтении пакета");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Непредвиденная ошибка при отправке данных");
            } catch (InterruptedException e) {
                System.out.println("Прервано ожидание ответа от сервера");
            }
        } while (!requestToServer.getCommandName().equals("exit"));

        return false;
    }

    public void run() {
        try {
            boolean processingStatus = true;
            while (processingStatus) {
                try {
                    processingStatus = processRequestToServer();
                } catch (Exception exception) {
                    System.out.println("Что-то пошло не так");
                }
                if (datagramChannel != null) datagramChannel.close();
                Printer.println("Работа клиента завершена");
                System.exit(0);
            }
        } catch (IOException e) {
            System.out.println("Возникла ошибка");
        }
    }
}




