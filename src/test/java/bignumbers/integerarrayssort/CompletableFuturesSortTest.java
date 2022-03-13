package bignumbers.integerarrayssort;

import integerarrayssort.CompletableFuturesSort;
import integerarrayssort.RandomNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompletableFuturesSortTest extends BigNumbersTest{
    @Test
    void executeAsync_parallel() {
        Integer[] integers = RandomNumbers.execute(length, max);

        Integer[] result = CompletableFuturesSort.execute(integers);

        assertEquals(length, integers.length);
        assertEquals(length, result.length);
        assertTrue(sortCheck.check(result));
    }
}
