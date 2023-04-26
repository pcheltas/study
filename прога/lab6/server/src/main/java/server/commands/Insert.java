package server.commands;

import common.worker.Worker;
import common.exceptions.WrongArgumentsException;
import common.help.WorkerPacket;
import server.help.Loader;
import server.help.ResponseOutputer;

import static common.worker.Worker.getCounter;

public class Insert implements Command {
    Loader loader;
    public Insert (Loader loader){
        this.loader = loader;
    }
    public Insert(){}

    @Override
    public void execute(String argument, Object commandObjectArgument) {
        try {
            if (!argument.isEmpty() || commandObjectArgument == null) throw new WrongArgumentsException();
            WorkerPacket workerPacket = (WorkerPacket) commandObjectArgument;

            Worker.setCounter(getCounter()+1);
            Worker worker = new Worker(Worker.getCounter(), workerPacket.getName(),
                    workerPacket.getCoordinates(),
                    workerPacket.getCreationDate(), workerPacket.getSalary(),
                    workerPacket.getStartDate(), workerPacket.getEndDate(),
                    workerPacket.getStatus(), workerPacket.getOrganization());

            System.out.println(worker.toString());
            loader.addWorker(worker);

//            loader.addToCollection(new Worker(Worker.getCounter(), workerPacket.getName(),
//                    workerPacket.getCoordinates(),
//                    workerPacket.getCreationDate(), workerPacket.getSalary(),
//                    workerPacket.getStartDate(), workerPacket.getEndDate(),
//                    workerPacket.getStatus(), workerPacket.getOrganization()));
        } catch (WrongArgumentsException e) {
            ResponseOutputer.appendln(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return "insert null {element} : добавить новый элемент с заданным ключом";
    }
}