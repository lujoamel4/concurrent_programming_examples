package integerarrayssort;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {

    public static int min(int a, int b) {
        return Math.min(a, b);
    }


    public static Integer[] sliceArray(Integer low, Integer high, Integer[] integers) {
        int blockSize = high - low;
        return IntStream.range(low, high).map(i -> integers[i]).boxed().collect(Collectors.toList()).toArray(new Integer[blockSize]);
    }
}
