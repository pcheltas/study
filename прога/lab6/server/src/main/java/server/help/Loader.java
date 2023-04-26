package server.help;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import common.worker.Worker;
import common.exceptions.InputException;


public class Loader {

    public static LocalDateTime creation;
    public static ObjectMapper objectMapper = new ObjectMapper();
    private WorkerRepository repo;

//    private TreeMap<Integer, Worker> map;


    public Loader(){
      this.repo = filling();
//      this.map = repo.getMap();
        this.creation = LocalDateTime.now();
        for (Worker i : repo.getMap().values()){
            WorkerControl fileControl = new WorkerControl(i);
            fileControl.check();
            if (!fileControl.isCorrect()) throw new IllegalArgumentException();
        }
    }

    public static LocalDateTime getCreation() {
        return creation;
    }


    public WorkerRepository filling() {
        try {
            String filePath = System.getenv("FILE_PATH");
//            String filePath = "C:\\Users\\Тасечка\\Desktop\\уник\\прога\\prog\\json";
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
    public void addWorker(Worker worker){
        repo.getMap().put(worker.getId(), worker);
    }

    public void info(){
        ResponseOutputer.appendln("Дата создания коллекции: " + getCreation() +
                "\nТип коллекции: TreeMap, хранит данные о работниках" +
                "\nКоличество элементов: " + this.repo.getMap().size());
    }
    public void clear(){
        this.repo.getMap().clear();
    }

    public void filterGreaterSalary(Float salary) throws IllegalArgumentException {
        try {
            repo.getMap().values().stream()
                    .filter(worker -> worker.getSalary() > salary)
                    .forEach(worker -> ResponseOutputer.appendln(worker.toString()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public void printDesEndDate(){
        Comparator<LocalDateTime> comparator = Collections.reverseOrder();
        ArrayList<LocalDateTime> endDates = new ArrayList<>();
        for (Worker worker : repo.getMap().values()) {
            if (worker.getEndDate() != null){
                endDates.add(worker.getEndDate());
            }
        }
        endDates.sort(comparator);
        ResponseOutputer.appendln(endDates);
    }

    public void removeByEndDate(LocalDateTime dateTime){
        for (Worker worker : repo.getMap().values()){
            if (worker.getEndDate() != null && worker.getEndDate().equals(dateTime)){
                repo.getMap().remove(worker.getId());
                break;
            }else throw new NullPointerException("Коллекция пуста");
        }
    }

    public void removeGreater(Worker worker){
        for (Worker i : repo.getMap().values()){
            if (i.compareTo(worker) < 0){
                repo.getMap().remove(worker.getId());
                break;
            }
        }
    }

    public void removeKey(Integer key){
        if (repo.getMap().get(key) != null && repo.getMap().containsKey(key)) {
            repo.getMap().remove(key);
            ResponseOutputer.appendln("Элемент коллекции успешно удален");
        }else throw new IllegalArgumentException("Коллекция не содержит такого ключа или ключ введен неверно");
    }

    public void replaceGreater(Worker worker){
        for (Worker i : repo.getMap().values()){
            if (i.compareTo(worker) < 0){
                repo.getMap().put(worker.getId(), worker);
                break;
            }
        }

    }
    public void replaceLowe(Worker worker){
        try {
            for (Worker i : repo.getMap().values()) {
                if (i.compareTo(worker) > 0) {
                    repo.getMap().put(worker.getId(), worker);
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();}

    }
    public void save() throws IOException {
        objectMapper.registerModule(new JavaTimeModule());
        //objectMapper.writeValue(new File(System.getenv("FILE")), Loader.repo);
//        String filePath = "C:\\Users\\Тасечка\\Desktop\\уник\\прога\\prog\\json";
//        objectMapper.writeValue(new File(filePath), repo);
        objectMapper.writeValue(new File(System.getenv("FILE_PATH")), repo);
        System.out.println("Коллекция успешно сохранена");
    }


    public void updateByID(int id, Worker worker) {
        try {
            if (id > repo.getMap().size()) throw new InputException();
            repo.getMap().put(id, worker);

        } catch (InputException e) {
            ResponseOutputer.appendln("Элемента коллекции с такими id не существует");
        }
    }
    public void show() {
        try {
            if (repo.getMap().size() ==0) throw new NullPointerException("Коллекция пуста");
            for (Integer key : repo.getMap().keySet()) {
                ResponseOutputer.appendln(repo.getMap().get(key));
            }
        } catch (Exception e) {
            System.out.println("jopa");
            e.printStackTrace();
        }
    }

    public WorkerRepository getRepo() {
        return repo;
    }
}
