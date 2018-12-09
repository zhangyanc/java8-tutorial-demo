package pers.zyc.demo.java8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyancheng
 */
public class ReplaceList {

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4);
		integers.replaceAll(i -> i + 1);
		System.out.println(integers);

		integers = Arrays.asList(1, 2, 3, 4);
		integers.replaceAll(i -> i * i);
		System.out.println(integers);
	}
}