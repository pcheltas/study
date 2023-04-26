package client.help;

import common.exceptions.InputException;
import common.exceptions.ScriptRecursionException;
import common.exceptions.IncorrectInputInScriptException;
import common.exceptions.WrongCommandException;
import common.help.Printer;
import common.help.Request;
import common.help.ServerResponse;
import common.help.WorkerPacket;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class RequestCreation {

    private Scanner chosenScanner;
    private Stack<File> scriptStack = new Stack<>();
    private Stack<Scanner> scannerStack = new Stack<>();

    public RequestCreation(Scanner userScanner){
        this.chosenScanner = userScanner;
    }

    private boolean scriptMode() {
        return !scannerStack.isEmpty();
    }

    private CorrectCode processCommand(String command, String commandArgument) {
        try {
            switch (command) {
                case "":
                    return CorrectCode.ERROR;
                case "clear":
                    if (!commandArgument.isEmpty()) throw new WrongCommandException();
                    break;
                case "execute_script":
                    if (commandArgument.isEmpty()) throw new WrongCommandException();
                    return CorrectCode.SCRIPT;
                case "exit":
                    if (!commandArgument.isEmpty()) throw new WrongCommandException();
                    System.exit(0);
                case "filter_greater_than_salary":
                    if (commandArgument.isEmpty()) throw new WrongCommandException();
                    break;
                case "help":
                    if (!commandArgument.isEmpty()) throw new WrongCommandException();
                    break;
                case "info":
                    if (!commandArgument.isEmpty()) throw new WrongCommandException();
                    break;
                case "insert":
                    if (!commandArgument.isEmpty()) throw new WrongCommandException();
                    return CorrectCode.OBJECT;
                case "print_field_descending_end_date":
                    if (!commandArgument.isEmpty()) throw new WrongCommandException();
                    break;
                case "remove_any_by_end_date":
                    if (commandArgument.isEmpty()) throw new WrongCommandException();
                    break;
                case "remove_if_greater":
                    if (!commandArgument.isEmpty()) throw new WrongCommandException();
                    return CorrectCode.OBJECT;
                case "remove_key":
                    if (commandArgument.isEmpty()) throw new WrongCommandException();
                    break;
                case "replace_if_greater":
                    if (commandArgument.isEmpty()) throw new WrongCommandException();
                    return CorrectCode.OBJECT;
                case "replace_if_lowe":
                    if (commandArgument.isEmpty()) throw new WrongCommandException();
                    return CorrectCode.OBJECT;
                case "show":
                    if (!commandArgument.isEmpty()) throw new WrongCommandException();
                    break;
                case "update_by_id":
                    if (commandArgument.isEmpty()) throw new WrongCommandException();
                    return CorrectCode.OBJECT;
                default:
                    Printer.println("Команда введена неверно");
                    return CorrectCode.ERROR;
            }
        } catch (WrongCommandException e) {
            System.out.println("Команда введена неверно");
            return CorrectCode.ERROR;
        }
        return CorrectCode.OK;
    }

    private WorkerPacket createWorker() throws InputException {
        ConsoleCreation consoleCreation = new ConsoleCreation(chosenScanner);
        if (scriptMode()) consoleCreation.setFileMode();
        return new WorkerPacket(
                consoleCreation.setName(),
                consoleCreation.setCoordinates(),
                consoleCreation.setCreationDate(),
                consoleCreation.setSalary(),
                consoleCreation.setStartDate(),
                consoleCreation.setEndDate(),
                consoleCreation.setStatus(),
                consoleCreation.setOrganization()
        );
    }

    public Request createRequest(ServerResponse responseCode){
        String userInput;
        String[] userCommand = new String[0];
        CorrectCode processingCode = null;
        try{
            do {
                try {
                    if (scriptMode() && (responseCode == ServerResponse.ERROR)){
                        throw new IncorrectInputInScriptException();}

                        while (scriptMode() && !chosenScanner.hasNextLine()) {
                            chosenScanner.close();
                            chosenScanner = scannerStack.pop();
                            Printer.println("Возвращаюсь к скрипту '" + scriptStack.pop().getName());
                        }
                        if (!chosenScanner.hasNextLine()) {
                            break; 
                        }
                        userInput = chosenScanner.nextLine();
                        if (scriptMode() && !userInput.isEmpty()) {
                            Printer.println(userInput);
                        }

                        userCommand = (userInput.trim() + " ").split(" ", 2);
                        userCommand[1] = userCommand[1].trim();
                        //System.out.println(userCommand[1]);
                } catch (NoSuchElementException | IllegalStateException e) {
                    Printer.printError("Ошибка при вводе команды!");
                    userCommand = new String[]{"", ""};
                }
                processingCode = processCommand(userCommand[0], userCommand[1]);

            } while (processingCode == CorrectCode.ERROR && !scriptMode() || userCommand[0].isEmpty());
            try {
                if (scriptMode() && (responseCode == ServerResponse.ERROR || processingCode == CorrectCode.ERROR))
                    throw new IncorrectInputInScriptException();
                switch (Objects.requireNonNull(processingCode)) {
                    case OBJECT:
                        WorkerPacket addWorker = createWorker();
                        return new Request(userCommand[0], userCommand[1], addWorker);
                    case SCRIPT:
                        File scriptFile = new File(userCommand[1]);
                        if (!scriptFile.exists()) throw new FileNotFoundException();
                        if (!scriptStack.isEmpty() && scriptStack.search(scriptFile) != -1)
                            throw new ScriptRecursionException();
                        scannerStack.push(chosenScanner);
                        scriptStack.push(scriptFile);
                        chosenScanner = new Scanner(scriptFile);
                        Printer.println("Исполняется скрипт '" + scriptFile.getName());
                        break;
                }
            } catch (FileNotFoundException e) {
                System.out.println(userCommand[1]);
                Printer.printError("Файл со скриптом не найден");
            } catch (ScriptRecursionException e) {
                Printer.printError("Обнаружена рекурсия");
                throw new IncorrectInputInScriptException();
            }
        } catch (InputException | IncorrectInputInScriptException e) {
            Printer.printError("Выполнение скрипта прервано");
            while (!scannerStack.isEmpty()) {
                chosenScanner.close();
                chosenScanner = scannerStack.pop();
            }
            scriptStack.clear();
            return new Request();
        }
        return new Request(userCommand[0], userCommand[1]);
    }


}
