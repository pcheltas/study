package Commands;

import Worker.Worker;
import static Reader.Loader.repo;

public class FilterGreaterSalary implements ArgumentCommand{
    private int salary;


    @Override
    public void execute() {
        for (Worker worker : repo.map.values()) {
            if (worker.getSalary() > salary){
                System.out.println(repo.map.get(worker.getId()).toString());
            }
        }
    }
    @Override
    public void getArgument(String arg){
        if (arg.isBlank()) throw new IllegalArgumentException("Значение зарплаты не может быть пустым");

        try {
            if (!(Integer.parseInt(arg)>0)) throw new IllegalArgumentException("Зарплата должна быть больше 0");
            salary = Integer.parseInt(arg);
        }catch (NumberFormatException e){
            System.out.println("Введенная зарплата должна быть числом");
        }catch (IllegalArgumentException e){
            e.getMessage();
        }
        execute();
    }
    @Override
    public String toString(){
        return "filter_greater_than_salary : вывести элементы, значение поля salary которых больше заданного";
    }
}
