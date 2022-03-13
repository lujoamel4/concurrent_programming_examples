package integerarrayssort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PartialSortTest {
    private final SortCheck sortCheck = new SortCheck();

    @Test
    void execute() {
        Integer[] integers = PartialSort.execute(RandomNumbers.execute(10, 100));
        System.out.println("result = " + Arrays.stream(integers).map(String::valueOf).collect(Collectors.toList()));
        assertTrue(sortCheck.check(integers));
    }

    @Test
    void execute_ordered_array() {
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertArrayEquals(integers, PartialSort.execute(integers));
    }

    @Test
    void sort_unordered_array() {
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Integer[] result;

        result = PartialSort.execute(new Integer[]{1, 3, 2, 4, 7, 6, 5, 8, 9, 11, 10, 12});
        assertEquals(integers.length, result.length);
        assertTrue(sortCheck.check(result));
        assertArrayEquals(integers, result);

        result = PartialSort.execute(new Integer[]{12, 6, 5, 8, 9, 11, 10, 1, 3, 2, 4, 7});
        assertEquals(integers.length, result.length);
        assertTrue(sortCheck.check(result));
        assertArrayEquals(integers, result);
    }
}