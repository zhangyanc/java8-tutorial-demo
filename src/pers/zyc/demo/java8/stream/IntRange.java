package pers.zyc.demo.java8.stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author zhangyancheng
 */
public class IntRange {

	public static void main(String[] args) throws InterruptedException {
		IntStream.Builder builder = IntStream.builder();
		builder.add(1).add(7);
		IntStream.range(60, 100).filter(i -> (i % 7) == 0).forEach(builder::add);
		System.out.println(builder.build().mapToObj(i -> i + "").collect(Collectors.joining(", ")));
	}
}