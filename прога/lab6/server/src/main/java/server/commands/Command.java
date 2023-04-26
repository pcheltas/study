package server.commands;

import java.io.IOException;

public interface Command {

    public void execute(String commandArgument, Object commandObjectArgument) throws IOException;
}
