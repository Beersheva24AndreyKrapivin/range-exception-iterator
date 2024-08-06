package telran.range.exception;

public class OutOfRangeMaxValueException extends Exception {
    public OutOfRangeMaxValueException(int max, int value) {
        super(String.format("Out of Range max: %d, number: %d", max, value));
    }
}
