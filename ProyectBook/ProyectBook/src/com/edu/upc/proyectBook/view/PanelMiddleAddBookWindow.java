package com.edu.upc.proyectBook.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMiddleAddBookWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblName;
	private JLabel lblAuthor;
	private JLabel lblGenre;
	private JLabel lblPublisher;
	private JLabel lblNumberPages; 
	private JLabel lblIsbn;
	
	private StyledTextField inputName;
	private StyledTextField inputAuthor;
	private StyledTextField inputGenre;
	private StyledTextField inputPublisher;
	private StyledTextField inputNumberPages;
	private StyledTextField inputIsbn;
	
	public PanelMiddleAddBookWindow() {
		setLayout(new GridLayout(12,1));
		this.setBackground(Color.WHITE);
		this.lblName = new JLabel("Nombre");
		this.lblAuthor = new JLabel("Autor");
		this.lblGenre = new JLabel("Genero");
		this.lblPublisher = new JLabel("Publisher");
		this.lblNumberPages = new JLabel("Numero de paginas");
		this.lblIsbn = new JLabel("ISBN");
		
		this.inputName = new StyledTextField(Boolean.FALSE);
		this.inputAuthor = new StyledTextField(Boolean.FALSE);
		this.inputGenre = new StyledTextField(Boolean.FALSE);
		this.inputPublisher =  new StyledTextField(Boolean.FALSE);
		this.inputNumberPages =  new StyledTextField(Boolean.FALSE);
		this.inputIsbn =  new StyledTextField(Boolean.FALSE);
		
		this.add(this.lblName);
		this.add(this.inputName);
		this.add(this.lblAuthor);
		this.add(this.inputAuthor);
		this.add(this.lblGenre);
		this.add(this.inputGenre);
		this.add(this.lblPublisher);
		this.add(this.inputPublisher);
		this.add(this.lblNumberPages);
		this.add(this.inputNumberPages);
		this.add(this.lblIsbn);
		this.add(this.inputIsbn);
			
	}

	public JLabel getLblName() {
		return lblName;
	}

	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}

	public JLabel getLblAuthor() {
		return lblAuthor;
	}

	public void setLblAuthor(JLabel lblAuthor) {
		this.lblAuthor = lblAuthor;
	}

	public JLabel getLblGenre() {
		return lblGenre;
	}

	public void setLblGenre(JLabel lblGenre) {
		this.lblGenre = lblGenre;
	}

	public JLabel getLblPublisher() {
		return lblPublisher;
	}

	public void setLblPublisher(JLabel lblPublisher) {
		this.lblPublisher = lblPublisher;
	}

	public JLabel getLblNumberPages() {
		return lblNumberPages;
	}

	public void setLblNumberPages(JLabel lblNumberPages) {
		this.lblNumberPages = lblNumberPages;
	}

	public JLabel getLblIsbn() {
		return lblIsbn;
	}

	public void setLblIsbn(JLabel lblIsbn) {
		this.lblIsbn = lblIsbn;
	}

	public StyledTextField getInputName() {
		return inputName;
	}

	public void setInputName(StyledTextField inputName) {
		this.inputName = inputName;
	}

	public StyledTextField getInputAuthor() {
		return inputAuthor;
	}

	public void setInputAuthor(StyledTextField inputAuthor) {
		this.inputAuthor = inputAuthor;
	}

	public StyledTextField getInputGenre() {
		return inputGenre;
	}

	public void setInputGenre(StyledTextField inputGenre) {
		this.inputGenre = inputGenre;
	}

	public StyledTextField getInputPublisher() {
		return inputPublisher;
	}

	public void setInputPublisher(StyledTextField inputPublisher) {
		this.inputPublisher = inputPublisher;
	}

	public StyledTextField getInputNumberPages() {
		return inputNumberPages;
	}

	public void setInputNumberPages(StyledTextField inputNumberPages) {
		this.inputNumberPages = inputNumberPages;
	}

	public StyledTextField getInputIsbn() {
		return inputIsbn;
	}

	public void setInputIsbn(StyledTextField inputIsbn) {
		this.inputIsbn = inputIsbn;
	}
	
	

}
