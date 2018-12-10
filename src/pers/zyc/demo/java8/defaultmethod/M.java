package pers.zyc.demo.java8.defaultmethod;

/**
 * @author zhangyancheng
 */
public class M {

	public static void main(String[] args) {
		Default d = Default.create(DefaultImpl::new);
		System.out.println(d.noNeedImplement());

		d = Default.create(OverrideImpl::new);
		System.out.println(d.noNeedImplement());
	}
}
