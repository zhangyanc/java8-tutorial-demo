package pers.zyc.demo.java8.stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author zhangyancheng
 */
public class FilesWalk {

	public static void main(String[] args) throws IOException {
		Files.walk(new File(System.getProperty("user.home")).toPath(), 2).forEach(System.out::println);
	}
}