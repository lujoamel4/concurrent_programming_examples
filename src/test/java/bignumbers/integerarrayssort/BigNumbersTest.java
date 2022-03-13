package bignumbers.integerarrayssort;

import integerarrayssort.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BigNumbersTest {
    private final SortCheck sortCheck = new SortCheck();
    private final int max = 11000000;
    private final int length = 1000000;

    @Test
    void execute_parallel() {
        Integer[] integers = RandomNumbers.execute(length, max);

        Integer[] result = PartialSort.execute(integers);

        assertEquals(length, integers.length);
        assertEquals(length, result.length);
        assertTrue(sortCheck.check(result));
    }

    @Test
    void executeAsync_parallel() {
        Integer[] integers = RandomNumbers.execute(length, max);

        Integer[] result = ParallelSort.executeAsync(integers);

        assertEquals(length, integers.length);
        assertEquals(length, result.length);
        assertTrue(sortCheck.check(result));
    }

    @Test
    void execute_sequential() {
        Integer[] integers = RandomNumbers.execute(length, max);

        Integer[] result = SequentialSort.execute(integers);

        assertEquals(length, integers.length);
        assertEquals(length, result.length);
        assertTrue(sortCheck.check(result));
    }


}
