package com.example.web5;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/*Testting ES*/
/*import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;


import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortOrder;
*/
import elemental.json.JsonArray;

@StyleSheet({ "diagram.css" })
@SuppressWarnings("serial")
@JavaScript({ "d3.min.js", "diagram_connector.js", "jquery-1.11.3.min.js" })
public class Diagram extends AbstractJavaScriptComponent {

	public Diagram() {
		// callback that will be called from the client-side
		addFunction("onPlotClick",

				new JavaScriptFunction() {
					@Override
					public void call(JsonArray arguments) {
						String nodeName = (String) returnNodeName(arguments.getString(0));
						String nodeType = (String) returnNodeName(arguments.getString(1));
						// String nodeId = (String)
						// returnNodeName(arguments.getString(2));
						displayPopUp(nodeName, nodeType);
					}
				});
	}

	public void displayPopUp(String name, String type) {

		Window subWindow = new Window("Node Name:" + name);
		VerticalLayout subContent = new VerticalLayout();
		subContent.setMargin(true);
		subWindow.setWidth(500, UNITS_PIXELS);
		subWindow.setContent(subContent);

		// Put some components in it
		subContent.addComponent(new Label("Name: " + name));
		subContent.addComponent(new Label("Type: " + type));
		// subContent.addComponent(new Label("Id: " + id));
		// subContent.addComponent(new Button("Awlright"));

		// Center it in the browser window
		subWindow.center();

		// Open it in the UI
		UI.getCurrent().addWindow(subWindow);

	}

	public String returnNodeName(String name) {

		return name;
	}

	public void displayMsg(String newName) {
		callFunction("displayMsg", newName);
	}

	@Override
	public DiagramState getState() {
		return (DiagramState) super.getState();
	}

	public void addTreeData(String data) {
		getState().treeData = data;
	}

}