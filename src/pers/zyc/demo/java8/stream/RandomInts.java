package pers.zyc.demo.java8.stream;

import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author zhangyancheng
 */
public class RandomInts {
	public static void main(String[] args) {
		Random random = new Random();

		System.out.println(random.ints().limit(5).boxed().collect(Collectors.toList()));
		System.out.println(random.ints(5).boxed().collect(Collectors.toList()));
		System.out.println(random.ints(5, 1, 10).boxed().collect(Collectors.toList()));
	}
}