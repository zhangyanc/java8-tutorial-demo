package pers.zyc.demo.java8.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author zhangyancheng
 */
public class BufferedReaderLines {

	public static void main(String[] args) throws IOException {
		String str = "pers.zyc.demo\n" +
				"demo.java8.stream\n" +
				"pers.zyc.demo.java8.stream";
		// BufferedReader#lines返回字符行流
		try (BufferedReader bufferedReader = new BufferedReader(new StringReader(str))) {
			bufferedReader.lines().forEach(System.out::println);
		}
		try (BufferedReader bufferedReader = new BufferedReader(new StringReader(str))) {
			System.out.println(bufferedReader.lines().filter(s -> s.contains("java")).count());
		}
	}
}