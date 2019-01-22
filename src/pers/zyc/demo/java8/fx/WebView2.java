package pers.zyc.demo.java8.fx;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @author zhangyancheng
 */
public class WebView2 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		WebView webView = new WebView();
		WebEngine webEngine = webView.getEngine();
		webEngine.getLoadWorker().stateProperty()
				.addListener((obs, oldValue, newValue) -> {
					if (newValue == Worker.State.SUCCEEDED) {
						System.out.println("finished loading");
					}
				});
		webEngine.load("http://www.baidu.com");

		Scene scene = new Scene(webView, 600, 400);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
