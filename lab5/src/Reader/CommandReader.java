package Reader;

import Commands.*;
import java.util.HashMap;


public class CommandReader implements ReadWithArgument {
    private HashMap<String, Command> noArgumentCommands;
    private HashMap<String, ArgumentCommand> argumentCommands;

    @Override
    public String read(String command) {
        noArgumentCommands = new HashMap<>();
        argumentCommands = new HashMap<>();


        noArgumentCommands.put("show", new Show());
        noArgumentCommands.put("clear", new Clear());
        noArgumentCommands.put("help", new Help());
        noArgumentCommands.put("insert", new Insert());
        noArgumentCommands.put("info", new Info());
        noArgumentCommands.put("replace_if_greater", new ReplaceGreater());
        noArgumentCommands.put("replace_if_lowe", new ReplaceLower());
        noArgumentCommands.put("remove_if_greater", new RemoveGreater());
        noArgumentCommands.put("print_field_descending_end_date", new PrintDesEndDate());
        argumentCommands.put("remove_key", new RemoveKey());
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
                System.out.println("Команда введена неверно");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
