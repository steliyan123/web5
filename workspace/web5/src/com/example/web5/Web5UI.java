package com.example.web5;

import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import javax.servlet.annotation.WebServlet;

import org.json.simple.JSONObject;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("web5theme")
public class Web5UI extends UI {

	final VerticalLayout layout = new VerticalLayout();
	String s = "{\"name\": \"flare\",\"size\": 3812}";

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Web5UI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {

		LinkedHashMap childrenObj = new LinkedHashMap();
		childrenObj.put("name", "The Hamburget Postulate");
		childrenObj.put("type", "document");
		childrenObj.put("nodeId", new Integer(3534));

		LinkedHashMap childrenObj1 = new LinkedHashMap();
		childrenObj1.put("name", "Mendeleev");
		childrenObj1.put("type", "author");
		childrenObj1.put("nodeId", new Integer(7734));

		LinkedList listChildNodes = new LinkedList();
		listChildNodes.add(childrenObj);
		listChildNodes.add(childrenObj1);
		JSONObject obj = new JSONObject();
		obj.put("name", "Science");
		obj.put("type", "topic");
		childrenObj.put("nodeId", new Integer(534));
		obj.put("children", listChildNodes);
		obj.put("children", listChildNodes);
		StringWriter out = new StringWriter();
		try {
			obj.writeJSONString(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonText = out.toString();

		Diagram diagram = new Diagram();
		diagram.addTreeData(jsonText);
		diagram.setHeight(Page.getCurrent().getBrowserWindowHeight() + "px");
		diagram.setWidth(Page.getCurrent().getBrowserWindowWidth() + "px");
		layout.setSpacing(true);
		layout.addComponent(diagram);
		layout.setSizeFull();
		setContent(layout);
	}

}