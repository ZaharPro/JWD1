package edu.epam.jwd.exception;

public class SuperException extends Exception {
    public SuperException() {
        super();
    }

    public SuperException(String message) {
        super(message);
    }

    public SuperException(String message, Throwable cause) {
        super(message, cause);
    }

    public SuperException(Throwable cause) {
        super(cause);
    }
}
