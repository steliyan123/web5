package com.example.web5;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;

import elemental.json.JsonArray;

@StyleSheet({ "diagram.css" })
@SuppressWarnings("serial")
@JavaScript({ "d3.min.js", "diagram_connector.js", "jquery-1.11.3.min.js" })
public class Diagram extends AbstractJavaScriptComponent {

	public Diagram() {
		/*
		 * constructor inherits super registers Client2Server RPC calls
		 * initializes new rpc object and implements defined in the interface
		 * methods
		 */
		// Register an RPC interface implementation for this component
		registerRpc(new DiagramClientToServerRpc() {
			@Override
			public void onPlotClick() {
				// TODO
				// Notification.show("Clicked");
			}
		});

		/*
		 * addFunction(String functionName, JavaScriptFunction function)
		 * Exposing server side API to JavaScript Registers a JavaScriptFunction
		 * that can be called from the JavaScript using the provided name. A
		 * JavaScript function with the provided name will be added to the
		 * connector wrapper object (initially available as this). Calling that
		 * JavaScript function will cause the call method in the registered
		 * JavaScriptFunction to be invoked with the same arguments.
		 */

		addFunction("onPlotClick",
				// TODO
				// Defines a method that is called by the client-side JavaScript
				// function.
				// When the corresponding JavaScript function is called, the
				// call(JsonArray) method is invoked.
				new JavaScriptFunction() {
					@Override
					public void call(JsonArray arguments) {
						// int seriesIndex = (int) arguments.getNumber(0);
						// int dataIndex = (int) arguments.getNumber(1);
						// Notification.show("Clicked");
						// Notification.show("Clicked on [" + seriesIndex + ", "
						// + dataIndex + "]");
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

}