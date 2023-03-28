package support;

import commands.*;

import java.io.IOException;
import java.util.HashMap;

/**

 The CommandReader class implements the ReadWithArgument interface, reads user input commands and executes corresponding actions.

 Has two HashMap: that stores commands that do not require arguments and that stores commands that require arguments.

 */
public class CommandReader implements ReadWithArgument {
    private HashMap<String, Command> noArgumentCommands;
    private HashMap<String, ArgumentCommand> argumentCommands;

    /**

     Reads user input commands and executes corresponding actions.

     @param command a string representing a user input command

     @return null
     */
    @Override
    public String read(String command) {
        noArgumentCommands = new HashMap<>();
        argumentCommands = new HashMap<>();


        noArgumentCommands.put("show", new Show());
        noArgumentCommands.put("clear", new Clear());
        noArgumentCommands.put("help", new Help());
        noArgumentCommands.put("insert", new Insert());
        noArgumentCommands.put("info", new Info());
        noArgumentCommands.put("save", new Save());
        noArgumentCommands.put("exit", new Exit());
        noArgumentCommands.put("replace_if_greater", new ReplaceGreater());
        noArgumentCommands.put("replace_if_lowe", new ReplaceLower());
        noArgumentCommands.put("remove_if_greater", new RemoveGreater());
        noArgumentCommands.put("print_field_descending_end_date", new PrintDesEndDate());
        argumentCommands.put("remove_key", new RemoveKey());
        argumentCommands.put("execute_script", new ExecuteScript());
        argumentCommands.put("update", new Update());
        argumentCommands.put("filter_greater_than_salary", new FilterGreaterSalary());
        argumentCommands.put("remove_any_by_end_date", new RemoveByEndDate());

        try {
            if (command.trim().toLowerCase().split(" ").length == 1 &&
                    noArgumentCommands.containsKey(command.trim().toLowerCase().split(" ")[0])) {
                noArgumentCommands.get(command.trim().toLowerCase().split(" ")[0]).execute();

            } else if (command.trim().toLowerCase().split(" ").length > 1 &&
                    argumentCommands.containsKey(command.trim().toLowerCase().split(" ")[0])) {
                argumentCommands.get(command.trim().toLowerCase().split(" ")[0]).getArgument(command.trim().toLowerCase().split(" ")[1]);
            } else {
                System.out.println("Команда " + command + " введена неверно");
                if (Loader.isExecuteHasNoProblems()){
                    Loader.setExecuteHasNoProblems();
                    throw new RuntimeException("Команда в файле некорректна");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
