package com.example.web5;

import java.util.List;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;

@StyleSheet({ "diagram.css" })
@SuppressWarnings("serial")
@JavaScript({ "d3.min.js", "diagram_connector.js", "jquery-1.11.3.min.js" })
public class Diagram extends AbstractJavaScriptComponent {

	public void setCoords(final List<Integer> coords) {
		getState().setCoords(coords);
	}

	@Override
	public DiagramState getState() {
		return (DiagramState) super.getState();
	}
}
