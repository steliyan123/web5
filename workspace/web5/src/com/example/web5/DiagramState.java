package com.example.web5;

import com.vaadin.shared.ui.JavaScriptComponentState;
import java.util.List;

@SuppressWarnings("serial")
public class DiagramState extends JavaScriptComponentState {
	 
    private List<Integer> coords;
 
    public List<Integer> getCoords() {
        return coords;
    }
 
    public void setCoords(final List<Integer> coords) {
        this.coords = coords;
    }
}