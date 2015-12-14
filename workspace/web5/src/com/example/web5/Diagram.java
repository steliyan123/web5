package com.example.web5;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;

@StyleSheet({ "diagram.css" })
@SuppressWarnings("serial")
@JavaScript({ "d3.min.js", "diagram_connector.js", "jquery-1.11.3.min.js" })
public class Diagram extends AbstractJavaScriptComponent {

	@Override
	public DiagramState getState() {
		return (DiagramState) super.getState();
	}

	public void addTreeData(String data) {
		getState().treeData = data;
	}

}