package com.alphagnfss.testproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
		BorderPane  root = fxmlLoader.load();
		Scene scene = new Scene(root);

		scene.setFill(Color.TRANSPARENT);
		stage.setTitle("Hello!");
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(scene);
		stage.show();
	}
}
