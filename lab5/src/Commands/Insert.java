package Commands;

import Worker.Worker;

import static Reader.Loader.repo;

public class Insert implements Command{
    private int key;


    @Override
    public void execute() {
        ConsoleCreation create = new ConsoleCreation();
        create.execute();
        create.getWorker().setId(Worker.getCounter()+1);
        Worker.setCounter(Worker.getCounter()+1);
        while (repo.map.containsKey(Worker.getCounter())){
            create.getWorker().setId(Worker.getCounter()+1);
            Worker.setCounter(Worker.getCounter()+1);
        }

        repo.map.put(key, create.getWorker());
    }

    @Override
    public String toString(){
        return "insert null {element} : добавить новый элемент с заданным ключом";
    }
}