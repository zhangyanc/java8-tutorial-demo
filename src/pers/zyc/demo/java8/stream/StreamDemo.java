package pers.zyc.demo.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhangyancheng
 */
public class StreamDemo {

	static class Score {
		String name;
		int age;
		double score;
		String subject;

		Score(String name, int age, double score, String subject) {
			this.name = name;
			this.age = age;
			this.score = score;
			this.subject = subject;
		}
	}

	/**
	 * 打印所有成绩单姓名
	 */
	static void demo0() {
		Score s1 = new Score("stu1", 15, 30, "A");
		Score s2 = new Score("stu1", 15, 20, "B");
		Score s3 = new Score("stu2", 15, 20, "A");

		// 通过数组创建Stream
		Arrays.stream(new Score[] {s1, s2, s3}).map(score -> score.name).forEach(System.out::println);
		// 通过集合获取Stream
		new ArrayList<Score>() {
			{
				add(s1);
				add(s2);
				add(s3);
			}
		}.stream().map(score -> score.name).forEach(System.out::println);
		// 直接通过元素创建Stream
		Stream.of(s1, s2, s3).map(score -> score.name).forEach(System.out::println);
	}

	static void demo1() {
		List<Score> scores = Arrays.asList(
				new Score("lucy", 13, 20, "A"),
				new Score("mark", 14, 20, "A"),
				new Score("tong", 14, 30, "B"),
				new Score("jack", 15, 15, "A"),
				new Score("mary", 16, 15, "B")
		);
		// 打印所有成绩单的姓名
		scores.stream().map(score -> score.name).forEach(System.out::println);
		// 打印最高分的姓名
		System.out.println(scores.stream().max(Comparator.comparingDouble(s -> s.score)).orElseThrow(Error::new).name);
		// 所有年龄大于14分数和
		System.out.println(scores.stream().filter(score -> score.age > 14).mapToDouble(score -> score.score).sum());
		// 所有科目A中年龄最小的
		System.out.println(scores.stream().filter(score -> score.subject.equals("A")).min(Comparator.comparingInt(score -> score.age)).orElseThrow(Error::new).age);
	}

	static void demo2() {
		List<Score> scores = Arrays.asList(
				new Score("lucy", 13, 20, "A"),
				new Score("mark", 14, 20, "A"),
				new Score("tong", 14, 30, "B")
		);
		System.out.println(scores.stream().parallel().mapToDouble(score -> score.score).reduce(Double::sum).orElseThrow(Error::new));
	}

	static void demo3() {
		List<Score> scores = Arrays.asList(
				new Score("lucy", 13, 10, "A"),
				new Score("mark", 14, 20, "A"),
				new Score("tong", 15, 30, "B")
		);
		//打印姓名
		System.out.println(scores.stream().map(score -> score.name).collect(Collectors.joining(",")));
		//打印科目
		System.out.println(scores.stream().map(score -> score.subject).collect(Collectors.toList()));
		//打印平均年龄
		System.out.println(scores.stream().collect(Collectors.averagingInt(s -> s.age)));

		DoubleSummaryStatistics scoreStatistics = scores.stream().collect(Collectors.summarizingDouble(s -> s.score));
		System.out.println(String.format("Count: %d, Average: %f, Min: %f, Max: %f, Sum: %f",
				scoreStatistics.getCount(), scoreStatistics.getAverage(), scoreStatistics.getMin(),
				scoreStatistics.getMax(), scoreStatistics.getSum()));

		System.out.println(scores.stream().collect(
				HashMap<String, Double>::new,
				(HashMap<String, Double> m, Score s) -> {
					Double score = m.get(s.subject);
					m.put(s.subject, score == null ? s.score : score + s.score);
				},
				HashMap<String, Double>::putAll));
	}

	static void demo4() {
		List<Score> scores = Arrays.asList(
				new Score("lucy", 13, 10, "A"),
				new Score("mark", 14, 20, "A"),
				new Score("tong", 15, 30, "B")
		);
		System.out.println(scores.stream().collect(Collectors.groupingBy((score -> score.subject))));
	}

	public static void main(String[] args) {
		//demo1();
		//demo2();
		//demo3();
		demo4();
	}
}
