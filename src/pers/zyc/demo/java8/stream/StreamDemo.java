package pers.zyc.demo.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
				new Score("lucy", 13, 20, "A"),
				new Score("mark", 14, 20, "A"),
				new Score("tong", 14, 30, "B")
		);
		//System.out.println(scores.stream());
	}

	public static void main(String[] args) {
		demo2();
	}
}
