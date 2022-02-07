package edu.epam.jwd.exception;

public class NumberArrayException extends BaseRuntimeException {
    public NumberArrayException() {
        super();
    }

    public NumberArrayException(String message) {
        super(message);
    }

    public NumberArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumberArrayException(Throwable cause) {
        super(cause);
    }
}
