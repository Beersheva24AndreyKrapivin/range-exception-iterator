package telran.range;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.range.exception.OutOfRangeMaxValueException;
import telran.range.exception.OutOfRangeMinException;

public class RangeTest {
    private static final int MIN = 50;
    private static final int MAX = 100;
    Range range = Range.getRange(MIN, MAX);

    @Test
    void wrongRangeCreatingTest() {
        assertThrowsExactly(IllegalArgumentException.class, () -> Range.getRange(MAX, MIN));
    }

    @Test
    void rightNumberTest() throws Exception {
        range.checkNumber(55);
    }

    @Test
    void wrongNumberTest() throws Exception {
        assertThrowsExactly(OutOfRangeMaxValueException.class, () -> range.checkNumber(MAX + 1));
        assertThrowsExactly(OutOfRangeMinException.class, () -> range.checkNumber(MIN-1));
    }

}
