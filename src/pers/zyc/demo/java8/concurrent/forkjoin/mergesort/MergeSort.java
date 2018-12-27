package pers.zyc.demo.java8.concurrent.forkjoin.mergesort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.IntStream;

/**
 * @author zhangyancheng
 */
public class MergeSort {

	private final ForkJoinPool forkJoinPool;

	public MergeSort(int parallelism) {
		forkJoinPool = new ForkJoinPool(parallelism);
	}

	void sort(int[] array) {
		forkJoinPool.submit(new MergeSortTask(array, 0, array.length)).join();
	}

	void destroy() {
		forkJoinPool.shutdown();
	}

	private static class MergeSortTask extends RecursiveAction {

		static final int THRESHOLD = 286;

		final int[] array;
		final int low;
		final int high;

		MergeSortTask(int[] array, int low, int high) {
			this.array = array;
			this.low = low;
			this.high = high;
		}

		@Override
		protected void compute() {
			if (high - low < THRESHOLD) {
				Arrays.sort(array, low, high);
			} else {
				int middle = low + (high - low) / 2;
				invokeAll(new MergeSortTask(array, low, middle), new MergeSortTask(array, middle, high));
				merge(middle);
			}
		}

		void merge(int middle) {
			if (array[middle - 1] <= array[middle]) {
				return;
			}
			int[] copy = new int[high - low];
			System.arraycopy(array, low, copy, 0, copy.length);

			int hi = middle - low;
			for (int i = low, p = 0, q = hi; i < high; i++) {
				array[i] = p == hi || (q < copy.length && copy[p] > copy[q]) ? copy[q++] : copy[p++];
			}
		}
	}

	public static void main(String[] args) {
		MergeSort ms = new MergeSort(Runtime.getRuntime().availableProcessors());
		Random r = new Random();
		IntStream.range(0, 1000).forEach(i -> ms.sort(r.ints(10000).toArray()));

		int total = 0;
		int times = 1;
		while (times-- > 0) {
			int[] array = r.ints(100000000).toArray();
			long t = System.currentTimeMillis();
			ms.sort(array);
			total += System.currentTimeMillis() - t;

			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					throw new RuntimeException("Sort wrong!");
				}
			}
		}
		ms.destroy();

		System.out.println(total);
	}
}
