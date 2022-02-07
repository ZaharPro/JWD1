package edu.epam.jwd.exception;

public class CalculationArrayException extends BaseRuntimeException {
    public CalculationArrayException() {
        super();
    }

    public CalculationArrayException(String message) {
        super(message);
    }

    public CalculationArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalculationArrayException(Throwable cause) {
        super(cause);
    }
}
