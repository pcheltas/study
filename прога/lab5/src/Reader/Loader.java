package Reader;

import Worker.WorkerRepository;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.TreeMap;

public class Loader {
    public static LineReader lineReader;
    public static WorkerRepository repo;
    public static LocalDateTime creation;

    public Loader(){
        this.repo = new WorkerRepository();
        this.lineReader = new LineReader();
        this.creation = LocalDateTime.now();
    }

    public void working(){
        System.out.println("Добро пожаловать! Для просмотра всех доступных команд введите \"help\"");
        while (true){
            System.out.println("Введите команду");
            String command = lineReader.read();
            new CommandReader().read(command);
        }
    }

    public static LocalDateTime getCreation() {
        return creation;
    }
}
