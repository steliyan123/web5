package com.example.web5;

//import com.google.gson.JsonArray;
import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;
@StyleSheet({ "diagram.css" })
@SuppressWarnings("serial")
@JavaScript({ "d3.min.js", "diagram_connector.js", "jquery-1.11.3.min.js","bla.js" })
public class Diagram extends AbstractJavaScriptComponent {
	 public Diagram() {
	        addFunction("onPlotClick", new JavaScriptFunction() {
				@Override
				public void call(elemental.json.JsonArray arguments) {
					@SuppressWarnings("unused")
					String nodeName = arguments.getString(0);
					displayMsg(nodeName);
					
				}
	        });
	 }
	@Override
	public DiagramState getState() {
		return (DiagramState) super.getState();
	}

	public void addTreeData(String data) {
		getState().treeData = data;
	}
	
	public void displayMsg(String nodeName){
		String xtraNodeName = nodeName + "Server";
		callFunction("displayMsg",xtraNodeName);
	}

}