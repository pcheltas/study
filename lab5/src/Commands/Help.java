package Commands;

public class Help implements Command{

    @Override
    public void execute(){
        System.out.println(
        new Info().toString() + "\n" +
        new Show().toString() + "\n" +
        new Insert().toString() + "\n" +
        new Update().toString() + "\n" +
        new RemoveKey().toString()  + "\n" +
        new Clear().toString() + "\n" +
        new Save().toString() + "\n" +
        new ExecuteScript().toString() + "\n" +
        new Exit().toString() + "\n" +
        new ReplaceGreater().toString() + "\n" +
        new ReplaceLower().toString() + "\n" +
        new RemoveByEndDate().toString() + "\n" +
        new FilterGreaterSalary().toString() + "\n" +
        new PrintDesEndDate().toString() + "\n");
    }
}
