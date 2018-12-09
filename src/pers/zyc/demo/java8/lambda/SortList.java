package pers.zyc.demo.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author zhangyancheng
 */
public class SortList {

	private int compareAbs(int x, int y) {
		return Math.abs(x) - Math.abs(y);
	}

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(2, 1, 5, 3, 4);
		//静态方法引用，接口方法参数列表与静态方法参数列表一致
		integers.sort(Integer::compare);
		System.out.println(integers);

		integers = Arrays.asList(2, 1, 5, 3, 4);
		//成员方法引用，接口方法第一个参数与引用类型一致，且其余参数与引用方法列表一致
		integers.sort(Integer::compareTo);
		System.out.println(integers);

		integers = Arrays.asList(-2, 1, 5, 3, 4);
		//构造方法引用，接口方法参数列表与构造方法参数列表一致
		Supplier<SortList> comparator = SortList::new;
		//实例方法引用，接口方法参数列表与实例方法参数列表一致
		integers.sort(comparator.get()::compareAbs);
		System.out.println(integers);

		integers = Arrays.asList(2, 1, 5, 3, 4);
		integers.sort(Comparator.comparingInt(i -> i));
		System.out.println(integers);

		integers = Arrays.asList(2, 1, 5, 3, 4);
		integers.sort((x, y) -> y - x);//DESC
		System.out.println(integers);
	}
}