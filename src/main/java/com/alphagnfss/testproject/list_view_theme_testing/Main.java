package com.alphagnfss.testproject.list_view_theme_testing;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/alphagnfss/testproject/list_view_theme_testing/list-view-theme-testing.fxml"));
		BorderPane root = fxmlLoader.load();

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/com/alphagnfss/testproject/list_view_theme_testing/test.entertainmenttracker.theme.css").toExternalForm());

		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Create Custom Theme");
		stage.show();
	}
}
