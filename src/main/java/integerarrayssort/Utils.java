package integerarrayssort;

import java.util.stream.Collectors;

public class Utils {

    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    public static int divideUnsigned(int divisor, int dividend) {
        return Integer.divideUnsigned(dividend, divisor);
    }

    public static Integer[] sliceArray(Integer low, Integer high, Integer[] integers) {
        int blockSize = high - low;
        return java.util.Arrays.stream(integers, low, high)
                .collect(Collectors.toList()).toArray(new Integer[blockSize]);
    }
}
