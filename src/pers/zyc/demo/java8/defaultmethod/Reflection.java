package pers.zyc.demo.java8.defaultmethod;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

/**
 * @author zhangyancheng
 */
public class Reflection {

	private interface Animal {
		default String eat() {
			return getClass().getSimpleName() + " eats like an ordinary animal.";
		}

		default String sleep() {
			return getClass().getSimpleName() + " sleep like an ordinary animal.";
		}

		String go();
	}

	private static class Dog implements Animal {

		@Override
		public String sleep() {
			return "Dog sleep.";
		}

		@Override
		public String go() {
			return "Dog walks on four legs.";
		}
	}

	public static void main(String[] args) throws NoSuchMethodException {
		Dog dog = new Dog();
		Stream.of(Dog.class.getMethod("eat"),
				Dog.class.getMethod("sleep"),
				Dog.class.getMethod("go"))
				.forEach(m -> {
					System.out.println("Method name: " + m.getName());
					System.out.println("  isDefault: " + m.isDefault());
					try {
						System.out.println("     invoke: " + m.invoke(dog));
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ignore) {
					}
				});
	}
}
