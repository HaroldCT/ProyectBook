package com.edu.upc.proyectBook.view;

import java.awt.Dimension;

import javax.swing.JPanel;

public class PanelLeftLoginWindow extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public PanelLeftLoginWindow() {
		/*Asignacion de tamaño */
		setPreferredSize(new Dimension(300, getHeight()));
		/*Asignacion de color*/ 
		setBackground(GUIUtils.getPrincipalColor());
	}
	
	
}
