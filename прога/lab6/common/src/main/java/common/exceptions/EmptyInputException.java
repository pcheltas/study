package common.exceptions;

import java.io.IOException;

public class EmptyInputException extends IOException {

    public EmptyInputException(String message) {
        super(message);
    }
}
