package com.alphagnfss.testproject.svglabelbutton;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.SVGPath;

public class Controller {
	@FXML
	private Label label;
	@FXML
	private SVGPath svgPath;

	@FXML
	public void initialize() {
		SVGLabelButton home = new SVGLabelButton(label, svgPath);
		SVGLabelButtonManager svgLabelButtonManager = new SVGLabelButtonManager();
		svgLabelButtonManager.addSVGLabelButton("home-view", home);
	}
}