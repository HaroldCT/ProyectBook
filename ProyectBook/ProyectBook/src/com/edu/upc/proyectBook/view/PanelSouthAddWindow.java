package com.edu.upc.proyectBook.view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelSouthAddWindow extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton btnBack;
	private JButton btnAccept;
	private EventsAddWindow eventsAddWindow;
	
	public PanelSouthAddWindow(AddBookWindow addBookWindow) {
		setLayout(new FlowLayout());
		//Le asigno margenes
		this.setBorder(new EmptyBorder(0,0,50,0));
		this.setBackground(Color.WHITE);
		this.btnBack = new JButton("Volver");
		this.btnBack.setIcon(new ImageIcon("resources/img/icons/back.png"));
		this.btnBack.setActionCommand(EventsAddWindow.GET_BACK);
		eventsAddWindow = new EventsAddWindow(addBookWindow);
		this.btnBack.addActionListener(eventsAddWindow);
		
		this.btnAccept = new JButton("Aceptar");
		this.btnAccept.setIcon(new ImageIcon("resources/img/icons/ok.png"));
		this.btnAccept.setActionCommand(eventsAddWindow.ADD_BOOK);
		this.btnAccept.addActionListener(eventsAddWindow);
		
		this.add(btnBack);
		this.add(btnAccept);
	}

}
