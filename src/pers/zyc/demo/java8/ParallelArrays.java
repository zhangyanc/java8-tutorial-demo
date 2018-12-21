package pers.zyc.demo.java8;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * @author zhangyancheng
 */
public class ParallelArrays {

	public static void main(String[] args) {
		int[] array = new int[20000];
		Arrays.parallelSetAll(array, i -> ThreadLocalRandom.current().nextInt(10, 100000));
		System.out.print("UnSorted left 10: ");
		IntStream.of(array).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();

		Arrays.parallelSort(array);
		System.out.print("  Sorted left 10: ");
		IntStream.of(array).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();

		//Arrays.parallelPrefix();
	}
}
