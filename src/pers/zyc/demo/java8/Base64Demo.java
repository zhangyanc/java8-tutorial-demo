package pers.zyc.demo.java8;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author zhangyancheng
 */
public class Base64Demo {


	public static void main(String[] args) {
		String text = "Hello World!";

		String encoded = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
		System.out.println(encoded);
		System.out.println(new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8));

		String url = "https://www.baidu.com/s?wd=grep&rsv_spt=1&issp=1";
		String encodedUrl = Base64.getUrlEncoder().encodeToString(url.getBytes(StandardCharsets.UTF_8));
		System.out.println(encodedUrl);
		System.out.println(new String(Base64.getUrlDecoder().decode(encoded), StandardCharsets.UTF_8));
	}
}
