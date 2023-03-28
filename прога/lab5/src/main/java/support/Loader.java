package support;

import worker.Worker;
import worker.WorkerRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**

 The Loader class is responsible for loading collection from file and initializing the application.
 */
public class Loader {
    public static LineReader lineReader;
    public static WorkerRepository repo;
    public static LocalDateTime creation;
    //public static Loader loader;
    public static ObjectMapper objectMapper = new ObjectMapper();
    private static boolean executeWorks = false;
    private static boolean executeHasNoProblems = true;


    /**

     Constructor for the Loader class. It loads the repository from a file, creates a new LineReader class object,
     and sets the creation time to the current time.
     */
    public Loader(){
        this.repo = filling();
        this.lineReader = new LineReader();
        this.creation = LocalDateTime.now();
        for (Worker i : repo.map.values()){
            WorkerControl fileControl = new WorkerControl(i);
            fileControl.check();
            if (!fileControl.isCorrect()) throw new IllegalArgumentException();
        }
    }

    /**

     The working method is responsible for running the main loop of the application. It prompts the user
     for input and passes it to a CommandReader object to execute the appropriate command.
     */
    public void working(){
        System.out.println("Добро пожаловать! Для просмотра всех доступных команд введите \"help\"");
        while (true){
            System.out.println("Введите команду");
            String command = lineReader.read();
            new CommandReader().read(command);
        }
    }

    /**

     The filling method loads the repository from a file from the FILE_PATH environment variable and
     reads the contents of the file into a WorkerRepository object and returns it.
     @return The WorkerRepository object loaded from the file.
     @throws RuntimeException If there is an error reading the file or the contents of the file are invalid.
     */
    public WorkerRepository filling() {
        try {
            String filePath = System.getenv("FILE_PATH");
            //String filePath = System.getenv("FILE");
            Scanner scanner = new Scanner(new File(filePath));
            scanner.nextLine();
            objectMapper.registerModule(new JavaTimeModule());
            WorkerRepository repo = objectMapper.readValue(new File(filePath), WorkerRepository.class);
            return repo;
        }catch (JsonParseException | JsonMappingException e){
            System.out.println("Данные в файле некорректны. Измените содержимое файла и перезаупстите приложение");
            System.exit(1);
        }catch (NoSuchElementException e){
            System.out.println("Файл пуст. Создана путая коллекция");
            return new WorkerRepository();
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла проблема с файлом. Убедитесь, что файл существует, имеет достаточные права, " +
                    "и перезапустите приложение");
            System.exit(1);
        }
        return null;
    }

    public static LocalDateTime getCreation() {
        return creation;
    }

    public static boolean isExecuteHasNoProblems() {
        return executeHasNoProblems;
    }

    public static void setExecuteHasNoProblems() {
        Loader.executeHasNoProblems = !executeHasNoProblems;
    }

    public static boolean isExecuteWorks() {
        return executeWorks;
    }
    public static void setExecuteWorks(boolean work){
        Loader.executeWorks = work;
    }



    public static void setRepo(WorkerRepository repo) {
        Loader.repo = repo;
    }
}
