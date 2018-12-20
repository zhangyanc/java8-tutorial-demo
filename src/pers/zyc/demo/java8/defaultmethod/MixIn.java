package pers.zyc.demo.java8.defaultmethod;

import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * @author zhangyancheng
 */
public class MixIn {

	private interface Printable {

		default String toPrint() {
			StringBuilder sb = new StringBuilder();
			sb.append("State of the: ").append(getClass().getSimpleName()).append("\n");
			for (Class<?> cls = getClass(); cls != null && !cls.isInterface(); cls = cls.getSuperclass()) {
				for (Field field : cls.getDeclaredFields()) {
					try {
						field.setAccessible(true);
						sb.append(field.getName()).append(": ").append(field.get(this)).append("\n");
					} catch (IllegalAccessException ignore) {
					}
				}
			}
			return sb.toString();
		}
	}

	private enum BuildType implements Printable {
		BUILD(0, "-build"),
		PLAN(0, "-plan"),
		EXCLUDE(1, "-exclude"),
		TOTAL(2, "-total");

		private final int compareOrder;
		private final String pathSuffix;

		BuildType(int compareOrder, String pathSuffix) {
			this.compareOrder = compareOrder;
			this.pathSuffix = pathSuffix;
		}
	}

	public static void main(String[] args) {
		Stream.of(BuildType.values()).map(Printable::toPrint).forEach(System.out::println);
	}
}
