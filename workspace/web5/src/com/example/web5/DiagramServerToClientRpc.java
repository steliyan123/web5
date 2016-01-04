package com.example.web5;

import com.vaadin.shared.communication.ClientRpc;

public interface DiagramServerToClientRpc extends ClientRpc {

	public void addDiagramNode();

	public void removeDiagramNode();

}
