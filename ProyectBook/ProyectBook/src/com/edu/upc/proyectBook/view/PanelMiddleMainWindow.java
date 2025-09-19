package com.edu.upc.proyectBook.view;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class PanelMiddleMainWindow extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel dtm;
	private JTable table;
	private MainWindow mainWindow;
	
	public PanelMiddleMainWindow(MainWindow mainWindow) {
		setLayout(new GridLayout(1,1));
		setBorder(new EmptyBorder(40,10,10,10));
		this.buildComponents();
		this.addComponents();
		this.mainWindow = mainWindow;
		
	}
	public void buildComponents() {
		Object [] row = {"Nombre", "Autor", "Genero", "Editorial", "Numero paginas", " ISBN"};
		dtm = new DefaultTableModel(row,0);
		table = new JTable(dtm);
		
		//Solo deja seleccionar un row
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//Seleccion de Row o fila
		this.table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {	
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
					int fila = table.getSelectedRow();
					String nombre = table.getValueAt(fila, 0).toString();
					System.out.println("Se selecciono: " + nombre);
					mainWindow.getPanelRightMainWindow().setVisible(true);
				}
				
			}
		});
	}
	public void setDefaultTableModel(String[] titles) {
		dtm = new DefaultTableModel(titles,0);
		this.table.setModel(dtm);
	}
	public void addComponents() {
		this.add(new JScrollPane(table));
	}
	public void addRow(Object[] row) {
		dtm.addRow(row);
	}
	public DefaultTableModel getDtm() {
		return dtm;
	}
	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	

}
