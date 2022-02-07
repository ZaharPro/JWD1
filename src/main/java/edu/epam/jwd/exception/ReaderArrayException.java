package edu.epam.jwd.exception;

public class ReaderArrayException extends BaseRuntimeException {
    public ReaderArrayException() {
        super();
    }

    public ReaderArrayException(String message) {
        super(message);
    }

    public ReaderArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReaderArrayException(Throwable cause) {
        super(cause);
    }
}
