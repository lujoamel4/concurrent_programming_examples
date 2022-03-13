package integerarrayssort;

import static integerarrayssort.Merger.merge;

public class PartialSort {

    public static Integer[] execute(Integer[] input) {
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
        int threadsCount = 4;
        Integer[] integers = input.clone();
        int blockSize = Integer.divideUnsigned(integers.length, threadsCount);
        for (int currentBlock = 0; currentBlock < threadsCount; currentBlock++) {
            int low = currentBlock * blockSize;
            int high = (currentBlock + 1) * blockSize;
            processBlock(integers, sortAlgorithm, threadsCount, currentBlock, low, high);
        }
        return merge(integers, blockSize);
    }

    private static void processBlock(Integer[] integers, SortAlgorithm sortAlgorithm, int threadsCount, int currentBlock, int low, int high) {
        if (currentBlock == threadsCount - 1) {
            sortAlgorithm.sort(low, integers.length, integers);
        } else {
            sortAlgorithm.sort(low, high, integers);
        }
    }
}
