package server.commands;


import server.help.Loader;


public class Clear implements Command {
    Loader loader;

    public Clear(Loader loader){
        this.loader = loader;
    }

    public Clear() {
    }

    @Override
    public void execute(String argument, Object commandObjectArgument) throws NullPointerException {
        try {
            loader.clear();
            System.out.println("Все элементы коллекции успешно удалены. Коллекция пуста");
        } catch (NullPointerException e) {
            System.out.println("Коллекция уже пуста");
        }
    }

    @Override
    public String toString(){
        return "clear: очистить коллекцию";
    }

}
