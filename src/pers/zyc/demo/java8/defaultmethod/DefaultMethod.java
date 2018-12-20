package pers.zyc.demo.java8.defaultmethod;

import java.util.function.Supplier;

/**
 * @author zhangyancheng
 */
public class DefaultMethod {

	private interface Default {

		default String noNeedImplement() {
			return "Default implementation";
		}

		static Default create(Supplier<Default> supplier) {
			return supplier.get();
		}
	}


	private static class DefaultImpl implements Default {
	}

	private static class OverrideImpl implements Default {

		@Override
		public String noNeedImplement() {
			return "Overridden implementation";
		}
	}

	public static void main(String[] args) {
		Default d = Default.create(DefaultImpl::new);
		System.out.println(d.noNeedImplement());

		d = Default.create(OverrideImpl::new);
		System.out.println(d.noNeedImplement());
	}
}
