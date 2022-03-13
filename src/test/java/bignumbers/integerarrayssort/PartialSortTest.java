package bignumbers.integerarrayssort;

import integerarrayssort.PartialSort;
import integerarrayssort.RandomNumbers;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PartialSortTest extends BigNumbersTest{
    @Test
    void execute_parallel() {
        Integer[] integers = RandomNumbers.execute(length, max);

        Integer[] result = PartialSort.execute(integers);

        assertEquals(length, integers.length);
        assertEquals(length, result.length);
        assertTrue(sortCheck.check(result));
    }
}
