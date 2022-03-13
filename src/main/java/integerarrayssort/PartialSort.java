package integerarrayssort;

import static integerarrayssort.Merger.merge;
import static integerarrayssort.Utils.divideUnsigned;
import static integerarrayssort.Utils.min;

public class PartialSort {

    public static Integer[] execute(Integer[] input) {
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
        int maxThreads = 100;
        int threadsCount = min(maxThreads, divideUnsigned(2, input.length));
        Integer[] integers = input.clone();
        int blockSize = divideUnsigned(threadsCount, integers.length);
        for (int currentBlock = 0; currentBlock < threadsCount; currentBlock++) {
            int low = currentBlock * blockSize;
            int high = Math.min((currentBlock + 1) * blockSize, integers.length);
            sortAlgorithm.sort(low, high, integers);
        }
        return merge(integers, blockSize);
    }

}
