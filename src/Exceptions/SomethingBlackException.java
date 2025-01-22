package Exceptions;

public class SomethingBlackException extends RuntimeException {
    public SomethingBlackException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "SomethingBlackException: " + super.getMessage();
    }
}
