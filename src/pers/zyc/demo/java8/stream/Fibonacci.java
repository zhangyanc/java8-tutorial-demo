package pers.zyc.demo.java8.stream;

import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zhangyancheng
 */
public class Fibonacci {

	private int n_2 = 0, n_1 = 0;

	private int next() {
		if (n_2 == 0) {
			return n_2 = 1;
		} else if (n_1 == 0) {
			return n_1 = 2;
		} else {
			int n = n_2 + n_1;
			n_2 = n_1;
			n_1 = n;
			return n;
		}
	}

	public static void main(String[] args) {
		System.out.println(Stream.generate(new Fibonacci()::next).limit(10).collect(Collectors.toList()));

		System.out.println(IntStream.iterate(1, new IntUnaryOperator() {

			int prev = 1;

			@Override
			public int applyAsInt(int operand) {
				int fib = operand + prev;
				prev = operand;
				return fib;
			}
		}).limit(10).boxed().collect(Collectors.toList()));
	}
}
