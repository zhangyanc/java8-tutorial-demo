package pers.zyc.demo.java8.time;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author zhangyancheng
 */
public class LocalTimeDemo {

	public static void main(String[] args) {
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		System.out.println(IntStream.of(localTime.getHour(), localTime.getMinute(),
				localTime.getSecond(), localTime.getNano()).mapToObj(i -> i + "").collect(Collectors.joining(", ")));

		List<ChronoUnit> units = Arrays.asList(ChronoUnit.HOURS, ChronoUnit.MINUTES, ChronoUnit.SECONDS);
		// 1小时, 1分钟, 1秒后的时间
		units.stream().map(u -> localTime.plus(1, u)).forEach(System.out::println);
		// 1小时, 1分钟, 1秒前的时间
		units.stream().map(u -> localTime.minus(1, u)).forEach(System.out::println);

		// 明天的这个时候
		System.out.println(localTime.atDate(LocalDate.now().plus(1, ChronoUnit.DAYS)));

		System.out.println(LocalDateTime.now());
		System.out.println(LocalDateTime.of(1994, Month.APRIL, 15, 11, 30));
		System.out.println(LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));
	}
}
