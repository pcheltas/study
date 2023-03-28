package Commands;

import Worker.Worker;

import static Reader.Loader.repo;

public class RemoveGreater implements Command{

    @Override
    public void execute() {
        ConsoleCreation create = new ConsoleCreation();
        create.execute();
        for (Worker worker : repo.map.values()){
            if (worker.compareTo(create.getWorker()) < 0){
                create.getWorker().setId(worker.getId());
                repo.map.remove(worker.getId());
                break;
            }
        }
    }

    @Override
    public String toString(){
        return "remove_if_greater null {element} : удалить значение по ключу если новое значение больше старого";
    }
}
