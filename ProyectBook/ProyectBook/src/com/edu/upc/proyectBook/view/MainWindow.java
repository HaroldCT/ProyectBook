package com.edu.upc.proyectBook.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private OptionBar optionBar;
	private PanelNorthMainWindow panelNorthMainWindow;
	private PanelMiddleMainWindow panelMiddleMainWindow;
	private PanelButtonMainWindow panelButtonMainWindow;
	private PanelRightMainWindow panelRightMainWindow;
	private AddBookWindow addBookWindow;
	private FindBookWindow findBookWindow;
	
	public MainWindow() {
		setSize(1041,800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.optionBar = new OptionBar(this);
		this.panelNorthMainWindow = new PanelNorthMainWindow(this);
		this.panelMiddleMainWindow = new PanelMiddleMainWindow(this);
		this.panelButtonMainWindow = new PanelButtonMainWindow();
		this.panelRightMainWindow = new PanelRightMainWindow();
		this.findBookWindow = new FindBookWindow(this);
		this.setJMenuBar(optionBar);
		this.add(panelNorthMainWindow, BorderLayout.NORTH);
		this.add(panelMiddleMainWindow, BorderLayout.CENTER);
		this.add(panelButtonMainWindow, BorderLayout.SOUTH);
		this.add(panelRightMainWindow, BorderLayout.EAST);
		this.panelRightMainWindow.setVisible(false);
		this.addBookWindow = new AddBookWindow();	
	}
	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
	}

	public OptionBar getOptionBar() {
		return optionBar;
	}

	public void setOptionBar(OptionBar optionBar) {
		this.optionBar = optionBar;
	}

	public PanelNorthMainWindow getPanelNorthMainWindow() {
		return panelNorthMainWindow;
	}

	public void setPanelNorthMainWindow(PanelNorthMainWindow panelNorthMainWindow) {
		this.panelNorthMainWindow = panelNorthMainWindow;
	}

	public PanelMiddleMainWindow getPanelMiddleMainWindow() {
		return panelMiddleMainWindow;
	}

	public void setPanelMiddleMainWindow(PanelMiddleMainWindow panelMiddleMainWindow) {
		this.panelMiddleMainWindow = panelMiddleMainWindow;
	}

	public PanelButtonMainWindow getPanelButtonMainWindow() {
		return panelButtonMainWindow;
	}

	public void setPanelButtonMainWindow(PanelButtonMainWindow panelButtonMainWindow) {
		this.panelButtonMainWindow = panelButtonMainWindow;
	}

	public PanelRightMainWindow getPanelRightMainWindow() {
		return panelRightMainWindow;
	}

	public void setPanelRightMainWindow(PanelRightMainWindow panelRightMainWindow) {
		this.panelRightMainWindow = panelRightMainWindow;
	}

	public AddBookWindow getAddBookWindow() {
		return addBookWindow;
	}

	public void setAddBookWindow(AddBookWindow addBookWindow) {
		this.addBookWindow = addBookWindow;
	}

	public FindBookWindow getFindBookWindow() {
		return findBookWindow;
	}

	public void setFindBookWindow(FindBookWindow findBookWindow) {
		this.findBookWindow = findBookWindow;
	}

	

	
}
