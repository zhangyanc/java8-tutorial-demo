package pers.zyc.demo.java8.fx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.awt.*;

/**
 * @author zhangyancheng
 */
public class WebViewSample extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		final WebView webView = new WebView();
		final WebEngine webEngine = webView.getEngine();

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();

		stage.setTitle("Web View");
		Scene scene = new Scene(new Region() {
			{
				getStyleClass().add("browser");
				webEngine.load("http://www.zhihu.com");
				getChildren().add(webView);
			}

			@Override
			protected void layoutChildren() {
				layoutInArea(webView, 0 , 0 , getWidth(), getHeight(), 0, HPos.CENTER, VPos.CENTER);
			}

			@Override
			protected double computePrefWidth(double height) {
				return screenSize.width * 0.625;
			}

			@Override
			protected double computePrefHeight(double width) {
				return screenSize.height * 0.75;
			}
		}, screenSize.width * 0.625, screenSize.height * 0.75);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
