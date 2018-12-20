package pers.zyc.demo.java8.defaultmethod;

/**
 * 默认方法的继承规则:
 *
 * 1. 类优先规则, 如果一个Class实现了接口的默认方法, 则其子类优先继承其实现的方法
 * 			     如果一个Class将接口默认方法设置为抽象的(abstract), 则其子类必须实现此方法
 *
 * 2. 子接口优先规则, 如果一个接口继承另外一个接口, 并且都提供了某方法的默认实现, 则子接口优先
 *
 * @author zhangyancheng
 */
public class Inheritance {

	private interface Swimable {

		default String swim() {
			return "I can swim.";
		}
	}

	private static abstract class Fish implements Swimable {

		@Override
		public String swim() {
			return getClass().getSimpleName() + " swims under water.";
		}
	}

	// 按照类优先规则, Tuna将继承父类Fish的swim方法
	private static class Tuna extends Fish implements Swimable {
	}

	private interface Diveable extends Swimable {

		@Override
		default String swim() {
			return "I can swim on the surface of the water.";
		}

		default String dive() {
			return "I can dive.";
		}
	}

	// 子接口优先规则, Duck将继承Diveable接口的swim方法
	private static class Duck implements Diveable, Swimable {
	}

	public static void main(String[] args) {
		System.out.println(new Tuna().swim());
		System.out.println(new Duck().swim());
	}
}
