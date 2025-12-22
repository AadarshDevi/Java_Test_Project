package com.alphagnfss.testproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.SVGPath;

import java.util.concurrent.atomic.AtomicBoolean;

public class Controller {
	@FXML private Label label;
	@FXML private SVGPath svgPath;

	@FXML public void initialize() {
		AtomicBoolean selected = new AtomicBoolean(false);
		label.setOnMouseClicked(event -> {
			if(!selected.get()) {
				label.getStyleClass().add("selected");
				selected.set(true);
			} else {
				label.getStyleClass().remove("selected");
				selected.set(false);
			}
			System.out.println(label.getStyle());
		});
	}
}
