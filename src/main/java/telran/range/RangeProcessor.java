package telran.range;

import telran.range.exception.OutOfRangeMaxValueException;
import telran.range.exception.OutOfRangeMinException;

public class RangeProcessor {
    private Range range;
    private int counterOfGreaterMax;
    private int counterOfLessMin;
    private int counterOfRightNumbers;

    public RangeProcessor(Range range) {
        this.range = range;
    }

    public void processNumber(int number) {
        try {
            range.checkNumber(number);
            counterOfRightNumbers++;    
        } catch (OutOfRangeMaxValueException e) {
            counterOfGreaterMax++;
        } catch (OutOfRangeMinException e) {
            counterOfLessMin++;
        }
    }

    public int getCounterOfGreaterMax() {
        return counterOfGreaterMax;
    }

    public int getcounterOfLessMin() {
        return counterOfLessMin;
    }

    public int getcounterOfRightNumbers() {
        return counterOfRightNumbers;
    }
}
