package pers.zyc.demo.java8.defaultmethod;

import java.util.function.Supplier;

/**
 * @author zhangyancheng
 */
public interface Default {

	default String noNeedImplement() {
		return "Default implementation";
	}

	static Default create(Supplier<Default> supplier) {
		return supplier.get();
	}
}
