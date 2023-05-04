package server.help;
import common.exceptions.WrongArgumentsException;
import common.help.Request;
import common.help.Response;
import common.help.ServerResponse;
import server.commands.Command;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class RequestAccepter {
    private String commandName;
    private String commandArgument;
    private CommandControl commandControl;
    public RequestAccepter(CommandControl commandControl){
        this.commandControl = commandControl;
    }
    public Response createResponse(Request request) {
        commandName = request.getCommandName().trim();
        commandArgument = request.getCommandStringArgument();
        try {
            HashMap<String, Command> commandHashMap = commandControl.getMapping();
            if (!commandHashMap.containsKey(commandName)) {
                throw new WrongArgumentsException();
            }
            for (String key : commandHashMap.keySet()) {
                if (key.equalsIgnoreCase(commandName)) {
                    commandHashMap.get(key).execute(commandArgument, request.getCommandObjectArgument());
                }
            }

        }catch (WrongArgumentsException | FileNotFoundException e){
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Response(ServerResponse.OK, ResponseOutputer.getAndClear());
    }
}
