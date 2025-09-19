package com.edu.upc.proyectBook.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.edu.uptc.proyectBook.persistence.ProyectPersistenceBook;

public class AddBookWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private PanelSouthAddWindow panelSouthAddWindow;
	private JLabel lblTitle;
	private PanelMiddleAddBookWindow panelMiddleAddBookWindow;
	private ProyectPersistenceBook proyectPersistenceBook;
	
	public AddBookWindow() {
		//tamano
		setSize(600, 750);
		//centrar
		setLocationRelativeTo(null);
		//comportamineto por defecto
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//que no fuera modificable
		setResizable(false);
		//layout
		setLayout(new BorderLayout());
		//Color blanco al fondo
		this.setBackground(Color.WHITE);
		
		this.panelMiddleAddBookWindow = new PanelMiddleAddBookWindow();
		this.panelSouthAddWindow = new PanelSouthAddWindow(this);
		
		JPanel panelNorth = new JPanel();
		
		this.lblTitle = new JLabel("Agregar libro");
		Font fontAux = lblTitle.getFont();
		Font fontTitle = new Font(fontAux.getName(), Font.BOLD, 24);
		this.lblTitle.setFont(fontTitle);
		this.lblTitle.setBorder(new EmptyBorder(15,0,15,0));
		
		panelNorth.add(this.lblTitle);
		panelNorth.setBackground(Color.WHITE);
		
		this.add(panelSouthAddWindow, BorderLayout.SOUTH);
		this.add(panelMiddleAddBookWindow, BorderLayout.CENTER);
		this.add(panelNorth, BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		AddBookWindow addBookWindow = new AddBookWindow();
		addBookWindow.setVisible(true);
	}

	public PanelSouthAddWindow getPanelSouthAddWindow() {
		return panelSouthAddWindow;
	}

	public void setPanelSouthAddWindow(PanelSouthAddWindow panelSouthAddWindow) {
		this.panelSouthAddWindow = panelSouthAddWindow;
	}

	public JLabel getLblTitle() {
		return lblTitle;
	}

	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

	public PanelMiddleAddBookWindow getPanelMiddleAddBookWindow() {
		return panelMiddleAddBookWindow;
	}

	public void setPanelMiddleAddBookWindow(PanelMiddleAddBookWindow panelMiddleAddBookWindow) {
		this.panelMiddleAddBookWindow = panelMiddleAddBookWindow;
	}
	
	
}
