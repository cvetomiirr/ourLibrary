package exceptions;

public class MaxSizeReachedException extends RuntimeException {

    public MaxSizeReachedException(String message) {
        super(message);
    }
}
