package server.commands;
import common.exceptions.WrongArgumentsException;
import server.help.Loader;
import server.help.ResponseOutputer;


public class FilterGreaterSalary implements Command {
    Loader loader;
    public FilterGreaterSalary(Loader loader){
        this.loader = loader;
    }
    public FilterGreaterSalary(){}


    @Override
    public void execute(String argument, Object commandObjectArgument) {
        try {
            if (argument.isEmpty() || commandObjectArgument != null ) throw new WrongArgumentsException();
            Float salary = Float.parseFloat(argument);
            loader.filterGreaterSalary(salary);
        } catch (IllegalArgumentException e) {
            ResponseOutputer.appendln("Не является элементом Status");
        } catch (WrongArgumentsException e) {
            ResponseOutputer.appendln("Неверное кол-во аргументов...");
        }
    }

    @Override
    public String toString(){
        return "filter_greater_than_salary : вывести элементы, значение поля salary которых больше заданного";
    }
}
