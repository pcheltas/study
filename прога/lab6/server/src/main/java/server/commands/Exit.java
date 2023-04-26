package server.commands;

import common.exceptions.WrongArgumentsException;
import server.help.Loader;
import server.help.ResponseOutputer;

/**
 * This class represents a command that exits the application.
 */
public class Exit implements Command {
    Loader loader;
    public Exit(Loader loader){this.loader = loader;}
    public Exit(){}
    @Override
    public void execute(String argument, Object commandObjectArgument) {
        try {
            if (!argument.isEmpty() || commandObjectArgument != null) throw new WrongArgumentsException();
            ResponseOutputer.appendln("terminating the program");
            System.exit(0);
        } catch (WrongArgumentsException e){
            ResponseOutputer.appendln("exceeded number of arguments");
        }
    }
    @Override
    public String toString(){
        return "exit : завершить программу (без сохранения в файл)";
    }



}
