package pers.zyc.demo.java8.defaultmethod;

/**
 * 菱形继承说明:
 * 		当无法通过{@link Inheritance}中的两条规则选择一个默认实现时, 子类必须显示实现默认方法.
 * 		不过子类现在可以通过Interface.super.xxx();引用某个父接口的默认实现.
 *
 * @author zhangyancheng
 */
public class DiamondInheritance {

	interface Animal {
		String go();
	}

	interface Horse extends Animal {
		@Override
		default String go() {
			return getClass().getSimpleName() + " walks on four legs";
		}

		default String run() {
			return "i can run";
		}
	}

	interface Bird extends Animal {

		@Override
		default String go() {
			return getClass().getSimpleName() + " walks on four legs";
		}

		default String fly() {
			return "i can fly";
		}
	}

	// Pegasus必须显示实现(重写)go方法
	static class Pegasus implements Horse, Bird {

		@Override
		public String go() {
			//使用Horse接口的实现
			return Horse.super.go();
		}
	}

	public static void main(String[] args) {
		System.out.println(new Pegasus().go());
	}
}
