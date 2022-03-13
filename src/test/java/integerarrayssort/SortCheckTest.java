package integerarrayssort;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SortCheckTest {


    private final SortCheck checker =  new SortCheck();


    @Test
    void check_true() {
        assertTrue(checker.check(new Integer[]{1}));
        assertTrue(checker.check(new Integer[]{1,2}));
        assertTrue(checker.check(new Integer[]{1,1}));
        assertTrue(checker.check(new Integer[]{1,1,1}));
        assertTrue(checker.check(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}));
    }

    @Test
    void check_false() {
        assertFalse(checker.check(new Integer[]{3, 2}));
        assertFalse(checker.check(new Integer[]{1, 3, 2, 4, 7, 6, 5, 8, 9, 11, 10}));
    }
}