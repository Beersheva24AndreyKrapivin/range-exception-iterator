package telran.range;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BrokenFloorTest {
 
    private int getMinimalBrokenFloor(BallBrokenFloor bbf) {
        // Using only method checkFloor to find out minimal broken floor by applying
        //binary search algorithm
        int res = -1;
        int first = 0;
        int last = Integer.MAX_VALUE;
        int middleIndex = (first + last) / 2;

        while (first <= last) {
            try {
                bbf.checkFloor(middleIndex);
                first = middleIndex + 1;
            } catch (Exception e) {
                last = middleIndex - 1;
                res = middleIndex;
            }
            middleIndex = (first + last) / 2;
        }

        return res == -1 ? -first - 1 : res;
    }

    @Test
    void minimalBrokenFloorTest() {
        int[] floors = {200, 17, 1001, 2000};
        for (int i = 0; i < floors.length; i++) {
            BallBrokenFloor bbf = new BallBrokenFloor(floors[i]);
            assertEquals(bbf.getMinBrokenFloor(), getMinimalBrokenFloor(bbf));
        }
    }

}

