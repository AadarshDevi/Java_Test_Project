package com.alphagnfss.testproject.dragdropdata;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/alphagnfss/testproject/dragdropdata/drapdropmainframe.fxml"));
		BorderPane root = fxmlLoader.load();
		DragDropController ddc = fxmlLoader.getController();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("DragDropData Test Package");
		stage.setResizable(false);
		stage.show();
	}
}