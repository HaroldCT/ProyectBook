package com.edu.upc.proyectBook.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class LoginWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private PanelLeftLoginWindow panelLeftLoginWindow;
	private PanelRightLoginWindow panelRightLoginWindow;
	
	public LoginWindow() {
		this.initComponents();
		this.addComponents();
	}
	
	public void initComponents() {
		setUpScreen();
		initializationComponent();
	}
	
	public void setUpScreen() {
		
		setSize(800,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		setResizable(false);
	}
	public void initializationComponent() {
		this.panelLeftLoginWindow = new PanelLeftLoginWindow();
		this.panelRightLoginWindow = new PanelRightLoginWindow();
	}
	
	public void addComponents() {
		this.add(panelLeftLoginWindow, BorderLayout.WEST);
		this.add(panelRightLoginWindow, BorderLayout.EAST);
	}
	
	public PanelLeftLoginWindow getPanelLeftLoginWindow() {
		return panelLeftLoginWindow;
	}
	public void setPanelLeftLoginWindow(PanelLeftLoginWindow panelLeftLoginWindow) {
		this.panelLeftLoginWindow = panelLeftLoginWindow;
	}
	public PanelRightLoginWindow getPanelRightLoginWindow() {
		return panelRightLoginWindow;
	}
	public void setPanelRightLoginWindow(PanelRightLoginWindow panelRightLoginWindow) {
		this.panelRightLoginWindow = panelRightLoginWindow;
	}
	
	public static void main(String[] args) {
		LoginWindow loginWindow = new LoginWindow();
		loginWindow.setVisible(true);
	}
}
