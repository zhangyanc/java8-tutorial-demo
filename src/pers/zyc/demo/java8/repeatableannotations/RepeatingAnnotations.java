package pers.zyc.demo.java8.repeatableannotations;

import java.lang.annotation.*;
import java.util.Arrays;

/**
 * @author zhangyancheng
 */
public class RepeatingAnnotations {

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Filters {
		Filter[] value();
	}

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Repeatable(Filters.class)
	public @interface Filter {
		String value() default "";
	}

	@Filter
	@Filter("filter1")
	@Filter("filter2")
	public interface Filterable {
	}

	public static void main(String[] args) {
		Arrays.asList(Filterable.class.getAnnotationsByType(Filter.class)).forEach(filter -> System.out.println(filter.value()));
	}
}
