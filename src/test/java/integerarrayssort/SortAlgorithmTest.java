package integerarrayssort;

import integerarrayssort.SortAlgorithm;

import static org.junit.jupiter.api.Assertions.*;

class SortAlgorithmTest {

    private final SortAlgorithm sorter = new SortAlgorithm();

    @org.junit.jupiter.api.Test
    void sort_ordered_array() {
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertArrayEquals(integers, sorter.sort(integers.clone()));

    }

    @org.junit.jupiter.api.Test
    void sort_unordered_array() {
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertArrayEquals(integers, sorter.sort(new Integer[]{1, 3, 2, 4, 7, 6, 5, 8, 9, 11, 10}));
    }
}