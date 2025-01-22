package Exceptions;

public class FearException extends Exception {
    public FearException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "FearException: " + super.getMessage();
    }
}
