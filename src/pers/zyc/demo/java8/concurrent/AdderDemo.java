package pers.zyc.demo.java8.concurrent;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author zhangyancheng
 */
public class AdderDemo {

	public static void main(String[] args) {
		LongAdder longAdder = new LongAdder();
		longAdder.increment();
		longAdder.increment();
		longAdder.increment();
		System.out.println(longAdder.sum());
		System.out.println(longAdder.sumThenReset());


		DoubleAdder doubleAdder = new DoubleAdder();
		doubleAdder.add(1);
		doubleAdder.add(1);
		doubleAdder.add(1);
		System.out.println(doubleAdder.sum());
		System.out.println(doubleAdder.sumThenReset());
	}
}
