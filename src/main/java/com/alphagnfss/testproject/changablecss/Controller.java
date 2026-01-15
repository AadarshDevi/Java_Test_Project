package com.alphagnfss.testproject.changablecss;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.SVGPath;

public class Controller {
	@FXML
	public Button css_button_1;
	@FXML
	public Button css_button_2;
	@FXML
	public Button css_button_3;
	@FXML
	public Button css_button_3_2;
	@FXML
	public Button css_button_4;
	@FXML
	public Button css_button_5;
	@FXML
	public Button css_button_6;
	@FXML
	Button test_button;
	@FXML
	Label test_label;
	@FXML
	TextField test_textfield;
	@FXML
	Label test_label_button_label;
	@FXML
	SVGPath test_label_button_svgpath;

	@FXML
	BorderPane root;
	private Scene scene;

	@FXML
	public void initialize() {

		css_button_1.setOnMouseClicked(event -> {
			System.out.println("css_button_1");
			scene.getStylesheets().removeAll(scene.getStylesheets());
			scene.getStylesheets().add(getClass().getResource("/com/alphagnfss/testproject/changablecss/test_1.css").toExternalForm());
			for (String string : scene.getStylesheets()) {
				System.out.println(string);
			}
		});

		css_button_2.setOnMouseClicked(event -> {
			System.out.println("css_button_2");
			scene.getStylesheets().removeAll(scene.getStylesheets());
			scene.getStylesheets().add(getClass().getResource("/com/alphagnfss/testproject/changablecss/test_2.css").toExternalForm());
			for (String string : scene.getStylesheets()) {
				System.out.println(string);
			}
		});

		css_button_3.setOnMouseClicked(event -> {
			System.out.println("css_button_3");
			scene.getStylesheets().removeAll(scene.getStylesheets());
			scene.getStylesheets().add(getClass().getResource("/com/alphagnfss/testproject/changablecss/test_3.css").toExternalForm());
			for (String string : scene.getStylesheets()) {
				System.out.println(string);
			}
		});

		css_button_3_2.setOnMouseClicked(event -> {
			System.out.println("css_button_3_2");
			scene.getStylesheets().removeAll(scene.getStylesheets());
			scene.getStylesheets().add(getClass().getResource("/com/alphagnfss/testproject/changablecss/test_3_2.css").toExternalForm());
			for (String string : scene.getStylesheets()) {
				System.out.println(string);
			}
		});

		css_button_4.setOnMouseClicked(event -> {
			System.out.println("css_button_4");
			scene.getStylesheets().removeAll(scene.getStylesheets());
			scene.getStylesheets().add(getClass().getResource("/com/alphagnfss/testproject/changablecss/test_4.css").toExternalForm());
			for (String string : scene.getStylesheets()) {
				System.out.println(string);
			}
		});

		css_button_5.setOnMouseClicked(event -> {
			System.out.println("css_button_5");
			scene.getStylesheets().removeAll(scene.getStylesheets());
			scene.getStylesheets().add(getClass().getResource("/com/alphagnfss/testproject/changablecss/test_5.css").toExternalForm());
			for (String string : scene.getStylesheets()) {
				System.out.println(string);
			}
		});

		css_button_6.setOnMouseClicked(event -> {
			System.out.println("css_button_6");
			scene.getStylesheets().removeAll(scene.getStylesheets());
			scene.getStylesheets().add(getClass().getResource("/com/alphagnfss/testproject/changablecss/test_6.css").toExternalForm());
			for (String string : scene.getStylesheets()) {
				System.out.println(string);
			}
		});
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
}
