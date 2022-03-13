package integerarrayssort;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SequentialSortTest {

    @Test
    void execute() {
        Integer[] integers = RandomNumbers.execute(10, 11000000);
        assertTrue(new SortCheck().check(SequentialSort.execute(integers)));
    }

    @Test
    void execute_ordered_array() {
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertArrayEquals(integers, SequentialSort.execute(integers));
    }

    @Test
    void sort_unordered_array() {
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertArrayEquals(integers, SequentialSort.execute(new Integer[]{1, 3, 2, 4, 7, 6, 5, 8, 9, 11, 10}));

        assertArrayEquals(integers, SequentialSort.execute(new Integer[]{6, 5, 8, 9, 11, 10,1, 3, 2, 4, 7}));
    }
}