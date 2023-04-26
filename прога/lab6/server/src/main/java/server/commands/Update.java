package server.commands;

import common.worker.Worker;
import common.exceptions.WrongArgumentsException;
import common.help.WorkerPacket;
import server.help.Loader;
import server.help.ResponseOutputer;

/**

 The Update class implements the ArgumentCommand interface and represents a command for updating an element in the collection

 with the specified key.
 */
public class Update implements Command {
    private Loader loader;
    public Update(Loader loader){
        this.loader = loader;
    }
    public Update (){}

    @Override
    public void execute(String argument, Object commandObjectArgument) {
        try {
            if (argument.isEmpty() || commandObjectArgument == null) throw new WrongArgumentsException();
            WorkerPacket workerPacket = (WorkerPacket) commandObjectArgument;
            Worker worker = new Worker(Integer.parseInt(argument),
                    workerPacket.getName(),
                    workerPacket.getCoordinates(),
                    workerPacket.getCreationDate(),
                    workerPacket.getSalary(),
                    workerPacket.getStartDate(),
                    workerPacket.getEndDate(),
                    workerPacket.getStatus(),
                    workerPacket.getOrganization());

            int id = Integer.parseInt(argument.trim());
            loader.updateByID(id, worker);
            ResponseOutputer.appendln("Замена успешно завершена!");
        } catch (WrongArgumentsException e) {
            ResponseOutputer.appendln(e.getMessage());
        } catch (NumberFormatException e) {
            ResponseOutputer.appendln("неправильный тип данных. Должен быть целочисленным");
        }
    }
    @Override
    public String toString(){
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }
}
