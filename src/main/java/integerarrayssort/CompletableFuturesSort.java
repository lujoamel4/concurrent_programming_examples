package integerarrayssort;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static integerarrayssort.Merger.merge;
import static integerarrayssort.Utils.min;

public class CompletableFuturesSort {

    public static Integer[] execute(Integer[] integers) {
        System.out.println("integers size=" + integers.length);
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
        int threadsCount = 10;
        List<CompletableFuture<Void>> futuresList = new ArrayList<>();
        int blockSize = Integer.divideUnsigned(integers.length, threadsCount);
        Integer low = 0;
        Integer high = min(blockSize, integers.length);
        while (low < integers.length) {
            final Integer finalLow = low;
            final Integer finalHigh = high;
            futuresList.add(CompletableFuture.runAsync(() -> sortAlgorithm.sort(finalLow, finalHigh, integers)));
            low = low + blockSize;
            high = min(high + blockSize, integers.length);
        }
        CompletableFuture.allOf(toArray(futuresList)).join();
        return merge(integers, blockSize);
    }

    private static CompletableFuture[] toArray(List<CompletableFuture<Void>> futuresList) {
        return futuresList.toArray(new CompletableFuture[futuresList.size()]);
    }

}
