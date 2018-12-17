package pers.zyc.demo.java8.time;

import java.time.LocalDate;
import java.time.MonthDay;

/**
 * @author zhangyancheng
 */
public class LocalDateDemo {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		System.out.println(now);
		System.out.println(now.getYear() + "-" + now.getMonthValue() + "-" + now.getDayOfMonth());

		LocalDate date1 = LocalDate.of(1990, 10, 1);
		LocalDate date2 = LocalDate.parse("1990-10-01");
		System.out.println(date1.equals(date2));

		MonthDay birthDay = MonthDay.from(date1), monthDay = MonthDay.from(now);
		//MonthDay birthDay = MonthDay.of(date1.getMonth(), date1.getDayOfMonth()), monthDay = MonthDay.of(now.getMonth(), now.getDayOfMonth());
		System.out.println(birthDay.equals(monthDay));
	}
}
