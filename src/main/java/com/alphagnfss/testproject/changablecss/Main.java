package com.alphagnfss.testproject.changablecss;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
//	public Scene scene;

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/alphagnfss/testproject/changablecss/changable-css.fxml"));

		BorderPane root = fxmlLoader.load();
		System.out.println(root);

		Controller controller = fxmlLoader.getController();
		System.out.println(controller);

		Scene scene = new Scene(root);
		System.out.println(scene);

//		this.scene = scene;
		System.out.println(scene);
		controller.setScene(scene);

		stage.setScene(scene);
		stage.show();
	}

//	public Scene getScene() {
//		System.out.println("getScene:" + this.scene);
//		if (scene == null) System.err.println("Scene: null");
//		return scene;
//	}
}
