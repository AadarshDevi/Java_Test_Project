package com.alphagnfss.testproject.theming;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class ThemeController {
	@FXML
	public Button testButton;
	@FXML
	public ListView<BorderPane> listView;
	private Scene scene;

	@FXML
	public void initialize() {
		testButton.setOnAction(e -> restartTheme());
		for (int i = 0; i < 10; i++) {
			BorderPane borderPane = new BorderPane();
			borderPane.getStyleClass().add("border-pane");
			Label main = new Label("A Very Long Funny Show Name");
			Label extra = new Label("26 Eps");
			borderPane.setCenter(main);
			borderPane.setRight(extra);
			listView.getItems().add(borderPane);
		}
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	@FXML
	public void restartTheme() {
		System.out.println("Restarting theme");
		scene.getStylesheets().removeAll(scene.getStylesheets());
		scene.getStylesheets().add(getClass().getResource("/com/alphagnfss/testproject/themeing/test.entertainmenttracker.theme.css").toExternalForm());
		scene.getStylesheets().forEach(System.out::println);
	}
}
