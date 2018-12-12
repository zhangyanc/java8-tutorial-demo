package pers.zyc.demo.java8.optional;

import java.util.Optional;

/**
 * @author zhangyancheng
 */
public class Optionals {

	public static void main(String[] args) {
		String tag1 = "tag1", tag2 = "tag2";

		Optional<String> empty = Optional.empty();
		System.out.println(empty.isPresent());// false
		System.out.println(empty.orElse(tag1));// tag1
		System.out.println(empty.orElseGet(() -> tag1));// tag1
		System.out.println(empty.filter(v -> true).isPresent());// false
		System.out.println(empty.map(s -> tag1).isPresent());// false
		System.out.println(empty.flatMap(s -> Optional.of(tag1)).isPresent());// false
		empty.ifPresent(s -> {throw new Error("Empty optional can't pass the ifPresent check");});

		Optional<String> optional = Optional.of(tag1);
		System.out.println(optional.isPresent());// true
		System.out.println(optional.orElse(tag2));// tag1
		System.out.println(optional.orElseGet(() -> tag2));// tag1
		System.out.println(optional.filter(v -> true).isPresent());// true
		System.out.println(optional.filter(v -> false).isPresent());// false
		System.out.println(optional.map(s -> null).isPresent());// false
		System.out.println(optional.map(s -> tag2).orElseThrow(() -> new Error("Non empty optional return it's value")));// tag2
		System.out.println(optional.flatMap(s -> Optional.of(tag2)).orElse(tag1));// tag2
	}
}
