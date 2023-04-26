package server;
import server.help.*;
import server.commands.*;


import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunServer {
    private static final Logger logger = LogManager.getLogger(RunServer.class);
    public static int port;
//    public static int port = 5041;

    public static void main(String[] args) {
        try {
            Loader loader = new Loader();
            CommandControl commandControl = new CommandControl(new Show(loader), new Clear(loader), new Help(loader),
                    new Insert(loader), new Info(loader), new Save(loader),
                    new ReplaceGreater(loader), new ReplaceLower(), new RemoveGreater(loader),
                    new PrintDesEndDate(loader), new RemoveKey(loader), new ExecuteScript(loader),
                    new Update(loader), new FilterGreaterSalary(loader), new RemoveByEndDate(loader), loader);
            RequestAccepter requestAccepter = new RequestAccepter(commandControl);
            System.out.println("Сервер запущен");
            Server server = new Server(Integer.parseInt(args[0]) , requestAccepter);
//            Server server = new Server(port , requestAccepter);
            server.connection();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Ошибка при работе с сокетом");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Неопределенная ошибка");
        }

    }
}
