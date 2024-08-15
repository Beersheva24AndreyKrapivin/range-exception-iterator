package telran.range;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

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

    @Test
    void iteratorTest() {

        Predicate<Integer> predicate1 = x -> x % 2 == 0;
        Integer[] expected1 = {-4, -2, 0, 2, 4};
        doIteratorTestForPredicate(predicate1, expected1);

        Predicate<Integer> predicate2 = x -> x < 0;
        Integer[] expected2 = {-5, -4, -3, -2, -1};
        doIteratorTestForPredicate(predicate2, expected2);

        Predicate<Integer> predicate3 = x -> x % 2 != 0;
        Integer[] expected3 = {-5, -3, -1, 1, 3, 5};
        doIteratorTestForPredicate(predicate3, expected3);

        Integer[] expected4 = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        doIteratorTestForPredicate(null, expected4);

    }

    private void doIteratorTestForPredicate(Predicate<Integer> predicate, Integer[] expected) {
        int index = 0;
        Range rangeIt = Range.getRange(-5, 5);
        rangeIt.setPredicate(predicate);

        Iterator<Integer> it = rangeIt.iterator();
        Integer[] actual = new Integer[expected.length];

        while (it.hasNext()) {
            actual[index++] = it.next();
        }

        assertArrayEquals(expected, actual);
        assertThrowsExactly(NoSuchElementException.class, it::next);    
    }

}
