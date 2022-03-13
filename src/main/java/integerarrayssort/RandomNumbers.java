package integerarrayssort;

import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumbers {
    public static Integer[] execute(int length, int max) {
        Random r = new Random();
        return r.ints(length, 0, max).boxed().collect(Collectors.toList()).toArray(new Integer[ length ]);
    }

}
