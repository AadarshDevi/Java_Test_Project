package com.alphagnfss.testproject.svglabelbutton;

public class SVGLabelButtonNotFoundException extends RuntimeException {
	public SVGLabelButtonNotFoundException(String name) {
		super("SVGLabelButton.Manager does not have SVGLabelButton: " + name + ".");
	}
}