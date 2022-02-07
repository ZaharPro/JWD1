package edu.epam.jwd.exception;

public class SortArrayException extends BaseRuntimeException {
    public SortArrayException() {
        super();
    }

    public SortArrayException(String message) {
        super(message);
    }

    public SortArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public SortArrayException(Throwable cause) {
        super(cause);
    }
}
