package com.alphagnfss.testproject.svglabelbutton;


import javafx.scene.control.Label;
import javafx.scene.shape.SVGPath;

import java.util.concurrent.atomic.AtomicBoolean;

public class SVGLabelButton {
	private final Label label;
	private final SVGPath svgPath;
	private final AtomicBoolean selected;

	public SVGLabelButton(Label label, SVGPath svgPath) {
		this.label = label;
		this.svgPath = svgPath;
		selected = new AtomicBoolean(false);

		label.setOnMouseClicked(event -> {
			if (!isSelected()) {
				select();
				setCSS();
			} else {
				deselect();
			}
			System.out.println(label.getStyle());
		});
	}

	public boolean isSelected() {
		return label.getStyleClass().contains("selected");
	}

	public void select() {
		label.getStyleClass().add("selected");
		selected.set(true);
	}

	public void deselect() {
		label.getStyleClass().remove("selected");
		selected.set(false);
	}

	public void setCSS() {
		
	}
}
