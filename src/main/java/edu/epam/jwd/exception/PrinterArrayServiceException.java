package edu.epam.jwd.exception;

public class PrinterArrayServiceException extends BaseRuntimeException {
    public PrinterArrayServiceException() {
        super();
    }

    public PrinterArrayServiceException(String message) {
        super(message);
    }

    public PrinterArrayServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrinterArrayServiceException(Throwable cause) {
        super(cause);
    }
}

