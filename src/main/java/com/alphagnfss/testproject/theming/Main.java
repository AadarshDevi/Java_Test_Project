package com.alphagnfss.testproject.theming;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/alphagnfss/testproject/themeing/themeing.fxml"));
		BorderPane root = fxmlLoader.load();
		ThemeController controller = fxmlLoader.getController();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/com/alphagnfss/testproject/themeing/test.entertainmenttracker.theme.css").toExternalForm());
		controller.setScene(scene);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Create Custom Theme");
		stage.show();
	}
}

