package pers.zyc.demo.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyancheng
 */
public class ForEach {

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 3, 4);

		List<Integer> integers2 = new ArrayList<>(integers.size());
		integers.forEach(i -> integers2.add(i * i));
		integers2.forEach(System.out::println);
	}
}