package com.example.web5;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;
import java.util.List;

@SuppressWarnings("serial")
@JavaScript({"d3.min.js","diagram_connector.js"})
public class Diagram extends AbstractJavaScriptComponent {

	public void setCoords(final List<Integer> coords) {
		getState().setCoords(coords);
	}

	@Override
	public DiagramState getState() {
	    return (DiagramState) super.getState();
	}
}

