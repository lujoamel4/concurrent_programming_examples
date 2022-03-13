package bignumbers.integerarrayssort;

import integerarrayssort.RandomNumbers;
import integerarrayssort.SequentialSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SequentialSortTest extends BigNumbersTest{
    @Test
    void execute_sequential() {
        Integer[] integers = RandomNumbers.execute(length, max);

        Integer[] result = SequentialSort.execute(integers);

        assertEquals(length, integers.length);
        assertEquals(length, result.length);
        assertTrue(sortCheck.check(result));
    }
}
