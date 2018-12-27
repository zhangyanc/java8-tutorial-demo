package pers.zyc.demo.java8.lambda;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangyancheng
 */
public class ThreadLocalCreate {

	public static void main(String[] args) {
		ThreadLocal<AtomicInteger> threadLocal = ThreadLocal.withInitial(AtomicInteger::new);
		System.out.println(threadLocal.get());
	}
}
