package telran.range.exception;

public class OutOfRangeMinException extends Exception {
    public OutOfRangeMinException(int min, int number) {
        super(String.format("Out of Range min: %d, number: %d",  min, number));
    }
}
