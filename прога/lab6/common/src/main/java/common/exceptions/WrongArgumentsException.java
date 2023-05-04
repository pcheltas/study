package common.exceptions;

import java.io.IOException;

public class WrongArgumentsException extends IOException {

    public WrongArgumentsException(String message) {
        super(message);
    }

    public WrongArgumentsException() {
        System.out.println("Неверное количество аргументов");
    }
}
