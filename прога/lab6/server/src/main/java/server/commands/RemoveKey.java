package server.commands;

import server.help.Loader;
import server.help.ResponseOutputer;


public class RemoveKey implements Command{

    private int key;
    Loader loader;

    public RemoveKey (Loader loader){
        this.loader = loader;
    }
    public RemoveKey (){}

    @Override
    public void execute(String argument, Object commandObjectArgument){
        try{
            Integer key = Integer.parseInt(argument);
            loader.removeKey(key);
        }catch (Exception e){
            ResponseOutputer.appendln(e.getMessage());
        }
    }

    @Override
    public String toString(){
        return "remove_key {key}:  удалить элемент из коллекции по его ключу";
    }
}
