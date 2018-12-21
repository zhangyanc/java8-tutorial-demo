package pers.zyc.demo.java8.time;

import java.time.Clock;
import java.time.Instant;

/**
 * @author zhangyancheng
 */
public class InstantDemo {

	public static void main(String[] args) {
		Instant timestamp = Instant.now();
		System.out.println(timestamp + " " + timestamp.toEpochMilli());

		Instant dzi = Clock.systemDefaultZone().instant();
		System.out.println(dzi + " " + timestamp.toEpochMilli());
		System.out.println(System.currentTimeMillis());
	}
}
