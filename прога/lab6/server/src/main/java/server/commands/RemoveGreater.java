package server.commands;


import common.worker.Worker;
import common.exceptions.WrongArgumentsException;
import common.help.WorkerPacket;
import server.help.Loader;
import server.help.ResponseOutputer;

import static common.worker.Worker.getCounter;

public class RemoveGreater implements Command{
    Loader loader;

    public RemoveGreater(Loader loader){
        this.loader = loader;
    }
    public RemoveGreater(){}

    @Override
    public void execute(String argument, Object commandObjectArgument) {
        try {
            if (!argument.isEmpty() || commandObjectArgument == null)
                throw new WrongArgumentsException("Необходимо ввести работника");
            WorkerPacket workerPacket = (WorkerPacket) commandObjectArgument;
            Worker.setCounter(getCounter() + 1);
            Worker worker = new Worker(Worker.getCounter(),
                    workerPacket.getName(),
                    workerPacket.getCoordinates(),
                    workerPacket.getCreationDate(),
                    workerPacket.getSalary(),
                    workerPacket.getStartDate(),
                    workerPacket.getEndDate(),
                    workerPacket.getStatus(),
                    workerPacket.getOrganization());
            loader.removeGreater(worker);
        }catch (Exception e){
            ResponseOutputer.appendln(e.getMessage());
        }
    }

    @Override
    public String toString(){
        return "remove_if_greater null {element} : удалить значение по ключу если новое значение больше старого";
    }
}
