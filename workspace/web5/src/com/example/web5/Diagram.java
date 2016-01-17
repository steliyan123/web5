package com.example.web5;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;
import com.vaadin.ui.Notification;

import elemental.json.JsonArray;

@StyleSheet({ "diagram.css" })
@SuppressWarnings("serial")
@JavaScript({ "d3.min.js", "diagram_connector.js", "jquery-1.11.3.min.js" })
public class Diagram extends AbstractJavaScriptComponent {

	/*
	 * public void setValue(String data) { getState().treeData = data; }
	 * 
	 * public String getValue() { return getState().treeData; }
	 */
	public Diagram() {
		// callback that will be called from the client-side
		addFunction("onPlotClick",

				new JavaScriptFunction() {
					@Override
					public void call(JsonArray arguments) {
						String nodeName = (String) returnNodeName(arguments.getString(0));
						// highlight(nodeName);
						// Notification.show("Clicked");
					}
				});

	}

	public String returnNodeName(String name) {
		Notification.show("The Name of the Node you Just clicked on is: " + name);
		return "The Name of the Node you Just clicked on is: " + name;
	}

	public void highlight(String newName) {
		callFunction("highlight", newName);
	}

	@Override
	public DiagramState getState() {
		return (DiagramState) super.getState();
	}

	public void addTreeData(String data) {
		getState().treeData = data;
	}

}