package pers.zyc.demo.java8.defaultmethod;

/**
 * @author zhangyancheng
 */
public class OverrideImpl implements Default {

	@Override
	public String noNeedImplement() {
		return "Overridden implementation";
	}
}
