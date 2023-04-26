package server.commands;

import common.exceptions.WrongArgumentsException;
import server.help.Loader;
import server.help.ResponseOutputer;
import java.io.FileNotFoundException;

public class ExecuteScript implements Command {
    Loader loader;
    public ExecuteScript(Loader loader){this.loader = loader;}
    public ExecuteScript(){}

    @Override
    public void execute(String argument, Object commandObjectArgument) throws FileNotFoundException {
        argument = argument.trim();
        try {
            if (argument.isEmpty() || commandObjectArgument != null) throw new WrongArgumentsException();
            ResponseOutputer.appendln("Скрипт выполняется");
        } catch (WrongArgumentsException e) {
            ResponseOutputer.appendln("неверные аргументы");
        }
    }
    @Override
    public String toString(){
        return "execute_script : считать и исполнить скрипт из указанного файла";
    }


}
