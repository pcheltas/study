package support;

public class ExecutionExeption extends Exception{
    public ExecutionExeption(String message){
        super(message);
    }
    public ExecutionExeption(){
        super("Возникла ошибка исполнения команд из файла");
    }
}
