package com.edu.upc.proyectBook.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelRightMainWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnSeeMore;
	private JButton btnUpdate;
	private JButton btnDelete;
	
	public PanelRightMainWindow() {
		setBorder(new EmptyBorder(200,15,0,15));
		setLayout(new GridLayout(14,1));
		this.btnSeeMore = new JButton("Ver mas");
		this.btnUpdate= new JButton("Actualizar");
		this.btnDelete = new JButton("Eliminar");
		this.add(btnSeeMore);
		this.add(btnUpdate);
		this.add(btnDelete);
	}

	public JButton getBtnSeeMore() {
		return btnSeeMore;
	}

	public void setBtnSeeMore(JButton btnSeeMore) {
		this.btnSeeMore = btnSeeMore;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}
	
	
}
