package Commands;

import static Reader.Loader.repo;

public class Update implements ArgumentCommand{
    private int key;


    @Override
    public void execute() {
        ConsoleCreation create = new ConsoleCreation();
        create.execute();
        create.getWorker().setId(key);
        repo.map.put(key, create.getWorker());
    }
    @Override
    public void getArgument(String arg){
        if (!(Integer.parseInt(arg)>0)) throw new IllegalArgumentException("Ключ должен быть больше 0");
        key = Integer.parseInt(arg);
        execute();
    }

    @Override
    public String toString(){
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }
}
