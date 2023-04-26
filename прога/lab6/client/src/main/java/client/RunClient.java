package client;

import client.help.RequestCreation;

import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class RunClient {
    private static String host = "localhost";
    private static int port;
//private static int port = 5041;





    public static void main(String[] args) {
        try {
            Scanner userScanner = new Scanner(System.in);
            RequestCreation requestCreation = new RequestCreation(userScanner);
            Client client = new Client(host, Integer.parseInt(args[0]) , requestCreation);
//            Client client = new Client(host, port , requestCreation);
            DatagramChannel datagramChannel = DatagramChannel.open();
            InetSocketAddress address = new InetSocketAddress(host, Integer.parseInt(args[0]));
//            InetSocketAddress address = new InetSocketAddress(host, port);
            datagramChannel.connect(address);
            System.out.println("Соединение выполнено" +"\nДобро пожаловать!");
            client.run();
            userScanner.close();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Возникла ошибка");
        }
    }

}