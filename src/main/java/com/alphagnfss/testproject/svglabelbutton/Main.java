package com.alphagnfss.testproject.svglabelbutton;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

	public Scene scene;

	@Override
	public void start(Stage stage) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/alphagnfss/testproject/hello-view.fxml"));
		BorderPane root = fxmlLoader.load();
//		Controller controller = fxmlLoader.getController();
		Scene scene = new Scene(root);
//		this.scene = scene;


		// replaceable css files.
//		scene.getStylesheets().removeAll();
//		String cssUri = getClass().getResource("/com/alphagnfss/testproject/test2.css").toExternalForm();
//		scene.getStylesheets().add(cssUri);
//		this.scene = scene;
		System.out.println("Stylesheets:");
		for (String string : scene.getStylesheets()) {
			System.out.println(string);
		}

		scene.setFill(Color.TRANSPARENT);
		stage.setTitle("Hello!");
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(scene);
		stage.show();

//		controller.setCSS();
	}
}
