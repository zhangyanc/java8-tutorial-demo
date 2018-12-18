package pers.zyc.demo.java8.time;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.stream.Stream;

/**
 * @author zhangyancheng
 */
public class LocalDateDemo {

	public static void main(String[] args) {
		// 今天的日期
		LocalDate now = LocalDate.now();
		System.out.println(now);
		System.out.println(now.getYear() + "-" + now.getMonthValue() + "-" + now.getDayOfMonth());

		// 创建目标日期
		LocalDate date1 = LocalDate.of(1990, 10, 1);
		LocalDate date2 = LocalDate.parse("1990-10-01");
		System.out.println(date1.equals(date2));

		// 某年某月有多少天, 是否闰年
		Stream.of(YearMonth.from(now), YearMonth.of(2010, Month.FEBRUARY), YearMonth.of(2012, Month.FEBRUARY))
				.forEach(ym -> System.out.printf("%s: %d, leap: %b%n", ym, ym.lengthOfMonth(), ym.isLeapYear()));

		// 从日期获取月日(忽略年, 节日比较)
		MonthDay birthDay = MonthDay.from(date1), monthDay = MonthDay.from(now);
		//MonthDay birthDay = MonthDay.of(date1.getMonth(), date1.getDayOfMonth()), monthDay = MonthDay.of(now.getMonth(), now.getDayOfMonth());
		System.out.println(birthDay.equals(monthDay));
		System.out.println(MonthDay.of(Month.FEBRUARY, 29).isValidYear(2012));

		// 加减day,week,month,year可进行日期变换
		Stream.of(now.plusDays(1),  now.plusWeeks(1),  now.plusMonths(1),  now.plusYears(1),
				  now.minusDays(1), now.minusWeeks(1), now.minusMonths(1), now.minusYears(1))
				.forEach(System.out::println);

		// 给日期设置时间, 明天下午18点30
		System.out.println(now.plusDays(1).atTime(18, 30));

		// 日期前后比较
		assert now.isBefore(now.plusDays(1));
		assert now.isAfter(now.minusDays(1));

		// 某个出生日期后的第一个父亲节
		System.out.println(getFirstFathersDay(LocalDate.of(2017, Month.OCTOBER, 25)));


	}

	private static LocalDate getFirstFathersDay(LocalDate childBirthday) {
		LocalDate currentYearFD = childBirthday
				.withMonth(Month.JUNE.getValue())
				.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY))//6月的第一个周日
				.plusDays(14);
		if (childBirthday.isAfter(currentYearFD)) {
			return currentYearFD.plusYears(1).with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY))//6月的第一个周日
					.plusDays(14);
		}
		return currentYearFD;
	}
}
