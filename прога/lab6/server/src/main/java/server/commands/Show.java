package server.commands;

import common.exceptions.WrongArgumentsException;
import server.help.Loader;
import server.help.ResponseOutputer;


public class Show implements Command{
    Loader loader;
    public Show(Loader loader){
        this.loader = loader;
    }
    public Show(){}

    @Override
    public void execute(String argument, Object commandObjectArgument) {
        try{
            if (!argument.isEmpty() || commandObjectArgument != null) throw new WrongArgumentsException();
            loader.show();
        } catch (Exception e) {
            ResponseOutputer.appendln(e.getMessage());
        }

    }
    @Override
    public String toString(){
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}

