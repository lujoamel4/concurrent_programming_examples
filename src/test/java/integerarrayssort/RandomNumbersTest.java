package integerarrayssort;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomNumbersTest {

    @Test
    void execute() {
        assertEquals(100000, RandomNumbers.execute(100000, 11000000).length);
    }
}