package pers.zyc.demo.java8.time;

import java.time.Clock;

/**
 * @author zhangyancheng
 */
public class ClockDemo {

	public static void main(String[] args) {
		Clock utcClock = Clock.systemUTC();
		System.out.println(utcClock.instant() + "-" + utcClock.millis() + "-" + utcClock);
		Clock localClock = Clock.systemDefaultZone();
		System.out.println(localClock.instant() + "-" + localClock.millis() + "-" + localClock);
		//ZonedDateTime zonedDateTime = ZonedDateTime.
	}
}
