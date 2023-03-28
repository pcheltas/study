package Commands;

import Worker.Worker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Reader.Loader.repo;

public class RemoveByEndDate implements ArgumentCommand{
    private LocalDateTime dateTime;

    @Override
    public void execute(){
        try{
            for (Worker worker : repo.map.values()){
                if (worker.getEndDate() != null && worker.getEndDate().equals(dateTime)){
                    repo.map.remove(worker.getId());
                    break;
                }
            }
        }catch (Exception e){
            e.getMessage();
        }

    }

    @Override
    public void getArgument(String arg){
        if (arg.isBlank()) throw new IllegalArgumentException("Дата не может быть пустой");
        try {
            String regex1 = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])t([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$";
            if (arg.matches(regex1)){
                this.dateTime = LocalDateTime.parse(arg);
            }else{
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException | DateTimeParseException e){
            System.out.println("Неверный формат ввода даты. Строгий вормат ввода даты: гггг-мм-ддtчч:mm:ss");
        }
        execute();
    }
    @Override
    public String toString(){
        return "remove_any_by_end_date : удалить из коллекции один элемент, значение поля endDate которого меньше " +
                "экввалентному. Строгий вормат ввода даты: гггг-мм-ддtчч:mm:ss";
    }
}
