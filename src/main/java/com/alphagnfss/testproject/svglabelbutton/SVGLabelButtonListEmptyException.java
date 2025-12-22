package com.alphagnfss.testproject.svglabelbutton;

public class SVGLabelButtonListEmptyException extends RuntimeException {
	public SVGLabelButtonListEmptyException() {
		super("SVGLabelButton.Manager does not have any SVGLabelButtons.");
	}
}
