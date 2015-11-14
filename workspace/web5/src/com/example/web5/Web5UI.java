package com.example.web5;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("valo")
public class Web5UI extends UI {

	final VerticalLayout layout = new VerticalLayout();
	final TextField xCoordField = new TextField("X");
	final TextField yCoordField = new TextField("Y");
	final Button button = new Button("Move Circle");
	final Diagram diagram = new Diagram();
	final List<Integer> coords = new ArrayList<>();

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Web5UI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {

		// configureIntegerField(xCoordField); // not interesting, just adding
		// converter/validator to the
		// textFields
		// configureIntegerField(yCoordField);

		button.addClickListener(new Button.ClickListener() { // ATTENTION! Here
																// we get the
																// coordinates
																// from the
																// textfields
																// and apply
																// them to our
																// Diagram via
																// calling
																// diagram.setCoords()
			@Override
			public void buttonClick(Button.ClickEvent event) {
				if (xCoordField.isValid() && yCoordField.isValid()) {
					coords.clear();
					coords.add(Integer.parseInt(xCoordField.getValue()));
					coords.add(Integer.parseInt(yCoordField.getValue()));
					diagram.setCoords(coords);
				}
			}
		});
		// now we build the layout.
		layout.setSpacing(true);
		layout.addComponent((Component) diagram);
		layout.addComponent(xCoordField);
		layout.addComponent(yCoordField);
		layout.addComponent(button);
		// add the diagram like any
		// other vaadin component,
		// cool!
		// cool!
		setContent(layout);
	}

	private void configureIntegerField(final TextField integerField) {
		integerField.setConverter(Integer.class);
		integerField.addValidator(new IntegerRangeValidator("only integer, 0-500", 0, 500));
		integerField.setRequired(true);
		integerField.setImmediate(true);
	}

}