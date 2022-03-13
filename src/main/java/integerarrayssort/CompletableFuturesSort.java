package integerarrayssort;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import static integerarrayssort.Merger.merge;
import static integerarrayssort.Utils.divideUnsigned;
import static integerarrayssort.Utils.min;

public class CompletableFuturesSort {
	private final SortAlgorithm sortAlgorithm = new SortAlgorithm();

	public Integer[] execute(Integer[] integers) {
		System.out.println("integers size=" + integers.length);
		int maxThreads = 100;
        int threadsCount = min(maxThreads, divideUnsigned(2, integers.length));
		List<CompletableFuture<Void>> futuresList = new ArrayList<>();
		int blockSize = divideUnsigned(threadsCount, integers.length);
		int low = 0;
		int high = min(blockSize, integers.length);
		while (low < integers.length) {
			final Integer finalLow = low;
			final Integer finalHigh = high;
			futuresList.add(CompletableFuture.runAsync(() -> sortAlgorithm.sort(finalLow, finalHigh, integers)));
			low = low + blockSize;
			high = min(high + blockSize, integers.length);
		}
		CompletableFuture.allOf(toArray(futuresList))
				.join();
		return merge(integers, blockSize);
	}



    private CompletableFuture[] toArray(List<CompletableFuture<Void>> futuresList) {
		return futuresList.toArray(new CompletableFuture[ 0 ]);
	}

}
