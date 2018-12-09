package pers.zyc.demo.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyancheng
 */
public class RemoveIf {

	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<>(Arrays.asList(1, 3, 4, 6, 7));
		integers.removeIf(i -> (i & 1) == 0);
		System.out.println(integers);
	}
}