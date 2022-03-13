package integerarrayssort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static integerarrayssort.Utils.min;
import static integerarrayssort.Utils.sliceArray;

public class Merger {
    public static Integer[] merge(Integer[] arr1, Integer[] arr2) {
        Integer[] result = new Integer[arr1.length + arr2.length];
        int arr1Index = 0;
        int arr2Index = 0;
        for (int resultIndex = 0; resultIndex < result.length; resultIndex++) {
            if (arr1Index < arr1.length && arr2Index < arr2.length) {
                if (arr1[arr1Index] < arr2[arr2Index]) {
                    result[resultIndex] = arr1[arr1Index];
                    arr1Index++;
                } else {
                    result[resultIndex] = arr2[arr2Index];
                    arr2Index++;
                }
            } else {
                if (arr1Index < arr1.length) {
                    result[resultIndex] = arr1[arr1Index];
                    arr1Index++;
                }
                if (arr2Index < arr2.length) {
                    result[resultIndex] = arr2[arr2Index];
                    arr2Index++;
                }
            }
        }
        return result;
    }

    public static Integer[] merge(Integer[] integers, int blockSize) {
        Integer[] result = new Integer[0];

        int low = 0;
        int high = min(blockSize, integers.length);

        while (low < integers.length) {
            Integer[] sliceArray = sliceArray(low, high, integers);
            result = merge(sliceArray, result);
            low = low + blockSize;
            high = min(high + blockSize, integers.length);
        }
        return result;
    }


}
