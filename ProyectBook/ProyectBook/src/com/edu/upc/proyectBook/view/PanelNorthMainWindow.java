package com.edu.upc.proyectBook.view;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelNorthMainWindow  extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel lblTitleMainWindow;
	private JButton buttonFindBy;
	
	public PanelNorthMainWindow(MainWindow mainWindow) {
		this.lblTitleMainWindow = new JLabel("ADMINISTRADOR DE LIBROS");
		Font  actualFont = new  Font("Arial", 0, 40);
		Font fontTitle = new Font(actualFont.getName(), Font.BOLD, 24);
		
		this.buttonFindBy = new JButton("Buscar por:");
		this.buttonFindBy.setIcon(new ImageIcon("resources/img/icons/find.png"));
		this.buttonFindBy.setActionCommand(EventsMainWindow.SHOW_FIND_BOOK);
		this.buttonFindBy.addActionListener(new EventsMainWindow(mainWindow));
		
		this.lblTitleMainWindow.setBorder(new EmptyBorder(0,0,0,80));
		this.lblTitleMainWindow.setFont(fontTitle);
		this.setLayout(new FlowLayout());
		this.add(this.lblTitleMainWindow);
		this.add(buttonFindBy);
	}
}
