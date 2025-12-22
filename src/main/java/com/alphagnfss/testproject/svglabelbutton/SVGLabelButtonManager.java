package com.alphagnfss.testproject.svglabelbutton;

import java.util.HashMap;

public class SVGLabelButtonManager {
	private final HashMap<String, SVGLabelButton> svgLabelButtons;
	private String activeButtonName;

	public SVGLabelButtonManager() {
		svgLabelButtons = new HashMap<>();
		activeButtonName = null;
	}

	public void setActive(String name) throws SVGLabelButtonListEmptyException, SVGLabelButtonNotFoundException {
		isEmpty();
		hasButton(name);
		for (String key : svgLabelButtons.keySet()) {
			if(key.equals(name)) {
				svgLabelButtons.get(name).select();
				activeButtonName = name;
			} else {
				svgLabelButtons.get(key).deselect();
			}
		}
	}

	public void addSVGLabelButton(String name, SVGLabelButton svgLabelButton) {
		svgLabelButtons.put(name, svgLabelButton);
	}

	public SVGLabelButton getActive() throws SVGLabelButtonListEmptyException, SVGLabelButtonNotFoundException {
		isEmpty();
		hasButton(activeButtonName);
		return svgLabelButtons.get(activeButtonName);
	}

	public void deselectAll() {
		try {
			isEmpty();
		} catch (SVGLabelButtonListEmptyException _) {
			return;
		}
		for (String key : svgLabelButtons.keySet()) {
			svgLabelButtons.get(key).deselect();
		}
	}

	public void removeSVGLabelButton(String name) {
		isEmpty();
		hasButton(activeButtonName);
		svgLabelButtons.remove(name);
	}

	private void isEmpty() throws SVGLabelButtonListEmptyException {
		if (svgLabelButtons.isEmpty()) {
			throw new SVGLabelButtonListEmptyException();
		}
	}

	private void hasButton(String name) throws SVGLabelButtonNotFoundException {
		if (!svgLabelButtons.containsKey(name)) {
			throw new SVGLabelButtonNotFoundException(name);
		}
	}
}
