package pers.zyc.demo.java8.lambda;

/**
 * @author zhangyancheng
 */
public class CreateThread {

	public static void main(String[] args) {
		new Thread(() -> {
			//如果lambda只有一行代码，可去掉大括号
			System.out.println("Lambda constructed thread.");
		}).start();

		new Thread(() -> System.out.println("Lambda constructed thread.")).start();
	}
}