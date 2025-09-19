package com.edu.upc.proyectBook.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FindBookWindow extends JFrame{
	private static final long serialVersionUID =1L;
	private JLabel lblTitle;
	private JLabel lblAtribute;
	private JComboBox<String> comboAtributes;
	private JLabel lblfind;
	private JTextField txtfind;
	private JButton btnBack;
	private JButton btnFind;	
	private JPanel southPanel;
	private JPanel northPanel;
	private JPanel middlePanel;
	private JLabel lblspace1;
	private JLabel lblspace3;
	private JLabel lblspace5;
	
	public FindBookWindow(MainWindow mainWindow) {
		setSize(600,500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.southPanel = new JPanel();
		this.northPanel = new JPanel();
		this.middlePanel = new JPanel();
		this.lblTitle = new JLabel("Busqueda");
		this.lblTitle.setFont(new Font("Arial", Font.BOLD,30));
		this.lblAtribute = new JLabel("Atributo");
		this.lblAtribute.setFont(new Font("Arial", 16, 16));
		String[] atributos = {"Nombre", "Autor", "Genero", "Editorial", "Numero de paginas", "Isbn"};
		this.comboAtributes = new JComboBox<String>(atributos);
		this.lblfind = new JLabel("Buscar por: ");
		this.lblfind.setFont(new Font("Arial", 16,16));
		this.txtfind = new JTextField();
		this.btnBack = new JButton("Volver");
		this.btnBack.setIcon(new ImageIcon("resources/img/icons/back.png"));
		this.btnBack.setActionCommand(EventsMainWindow.BACK);
		this.btnBack.addActionListener(new EventsMainWindow(mainWindow));
		this.btnFind = new JButton("Buscar");
		this.btnFind.setIcon(new ImageIcon("resources/img/icons/find.png"));
		this.btnFind.setActionCommand(EventsMainWindow.FIND_BOOK_BY);
		this.btnFind.addActionListener(new EventsMainWindow(mainWindow));
		this.lblspace1 = new JLabel();
		this.lblspace3 = new JLabel();
		this.lblspace5 = new JLabel();
		
		this.northPanel.add(lblTitle);
		this.southPanel.setLayout(new FlowLayout());
		this.southPanel.add(btnBack);
		this.southPanel.add(btnFind);
		this.middlePanel.setLayout(new GridLayout(7,1));
		this.middlePanel.setBorder(new EmptyBorder(0, 80, 0, 80));
		
		this.middlePanel.add(lblspace3);
		this.middlePanel.add(lblAtribute);
		this.middlePanel.add(comboAtributes);
		this.middlePanel.add(lblspace1);
		this.middlePanel.add(lblfind);
		this.middlePanel.add(txtfind);
		this.middlePanel.add(lblspace5);
		
		
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(middlePanel, BorderLayout.CENTER);
	}

	public JLabel getLblTitle() {
		return lblTitle;
	}

	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

	public JLabel getLblAtribute() {
		return lblAtribute;
	}

	public void setLblAtribute(JLabel lblAtribute) {
		this.lblAtribute = lblAtribute;
	}

	public JComboBox<String> getComboAtributes() {
		return comboAtributes;
	}

	public void setComboAtributes(JComboBox<String> comboAtributes) {
		this.comboAtributes = comboAtributes;
	}

	public JLabel getLblfind() {
		return lblfind;
	}

	public void setLblfind(JLabel lblfind) {
		this.lblfind = lblfind;
	}

	public JTextField getTxtfind() {
		return txtfind;
	}

	public void setTxtfind(JTextField txtfind) {
		this.txtfind = txtfind;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	public JButton getBtnFind() {
		return btnFind;
	}

	public void setBtnFind(JButton btnFind) {
		this.btnFind = btnFind;
	}

	public JPanel getSouthPanel() {
		return southPanel;
	}

	public void setSouthPanel(JPanel southPanel) {
		this.southPanel = southPanel;
	}

	public JPanel getNorthPanel() {
		return northPanel;
	}

	public void setNorthPanel(JPanel northPanel) {
		this.northPanel = northPanel;
	}

	public JPanel getMiddlePanel() {
		return middlePanel;
	}

	public void setMiddlePanel(JPanel middlePanel) {
		this.middlePanel = middlePanel;
	}

	public JLabel getLblspace1() {
		return lblspace1;
	}

	public void setLblspace1(JLabel lblspace1) {
		this.lblspace1 = lblspace1;
	}

	public JLabel getLblspace3() {
		return lblspace3;
	}

	public void setLblspace3(JLabel lblspace3) {
		this.lblspace3 = lblspace3;
	}

	public JLabel getLblspace5() {
		return lblspace5;
	}

	public void setLblspace5(JLabel lblspace5) {
		this.lblspace5 = lblspace5;
	}
	
}
