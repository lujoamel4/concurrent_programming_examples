package integerarrayssort;

import java.util.ArrayList;
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

    public static Integer[] merge(Integer low, Integer middle, Integer high, Integer[] array) {
        List<Integer> result = new ArrayList();
        Integer count1 = low;
        Integer count2 = middle;
        while (count1 < middle && count2 < high) {
            if (array[count1] < array[count2]) {
                result.add(array[count1]);
                count1++;
                if (count1 >= middle) {
                    for (int index2 = count2; index2 < high; index2++) {
                        result.add(array[index2]);
                    }
                }
            } else {
                result.add(array[count2]);
                count2++;
                if (count2 >= high) {
                    for (int index1 = count1; index1 < middle; index1++) {
                        result.add(array[index1]);
                    }
                    count1 = middle; //terminate
                }
            }
        }

        return result.toArray(new Integer[result.size()]);
    }

    public static Integer[] merge(Integer[] integers, int blockSize) {
        Integer[] result = new Integer[0];

        Integer low = 0;
        Integer high = min(blockSize, integers.length);

        while (low < integers.length) {
            Integer[] sliceArray = sliceArray(low, high, integers);
            result = merge(sliceArray, result);
            low = low + blockSize;
            high = min(high + blockSize, integers.length);
        }
        return result;
    }


}
