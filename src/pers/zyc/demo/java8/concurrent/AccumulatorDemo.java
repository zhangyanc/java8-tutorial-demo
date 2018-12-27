package pers.zyc.demo.java8.concurrent;

import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.LongAccumulator;

/**
 * @author zhangyancheng
 */
public class AccumulatorDemo {

	public static void main(String[] args) {
		LongAccumulator longAccumulator = new LongAccumulator((l, r) -> l * r, 1);

		longAccumulator.accumulate(2);
		longAccumulator.accumulate(3);
		longAccumulator.accumulate(5);
		System.out.println(longAccumulator.get());
		System.out.println(longAccumulator.getThenReset());

		DoubleAccumulator doubleAccumulator = new DoubleAccumulator((l, r) -> l / r, 30);
		doubleAccumulator.accumulate(5);
		doubleAccumulator.accumulate(3);
		doubleAccumulator.accumulate(2);
		System.out.println(doubleAccumulator.get());
		System.out.println(doubleAccumulator.getThenReset());
	}
}
