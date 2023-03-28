package Commands;

import Worker.Worker;

import static Reader.Loader.repo;

public class ReplaceGreater implements Command{

    @Override
    public void execute() {
        ConsoleCreation create = new ConsoleCreation();
        create.execute();
        for (Worker worker : repo.map.values()){
            if (worker.compareTo(create.getWorker()) < 0){
                create.getWorker().setId(worker.getId());
                repo.map.put(worker.getId(), create.getWorker());
                break;
            }
        }
    }

    @Override
    public String toString(){
        return "replace_if_greater null {element} : заменить значение по ключу еслии новое значение больше старого";
    }
}
