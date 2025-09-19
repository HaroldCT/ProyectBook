package com.edu.upc.proyectBook.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.edu.uptc.proyectBook.enums.ETypeFileEnum;
import com.edu.uptc.proyectBook.model.Book;
import com.edu.uptc.proyectBook.persistence.ProyectPersistenceBook;

public class EventsAddWindow implements ActionListener {
	
	private AddBookWindow addBookWindow;
	
	public static final String GET_BACK = "GET_BACK";
	public static final String ADD_BOOK = "ADD_BOOK";
	
	private ProyectPersistenceBook proyectPersistenceBook;
	
	public EventsAddWindow(AddBookWindow addBookWindow) {
		this.addBookWindow = addBookWindow;
		this.proyectPersistenceBook = new ProyectPersistenceBook();
		this.proyectPersistenceBook.loadFile(ETypeFileEnum.FILE_PLAIN);
	}
	
	private void flushData() {
		
		this.proyectPersistenceBook.dumpFile(ETypeFileEnum.FILE_PLAIN);
		this.proyectPersistenceBook.dumpFile(ETypeFileEnum.CSV);
		this.proyectPersistenceBook.dumpFile(ETypeFileEnum.XML);
		this.proyectPersistenceBook.dumpFile(ETypeFileEnum.JSON);
		this.proyectPersistenceBook.dumpFile(ETypeFileEnum.SER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case GET_BACK: {
			this.addBookWindow.getPanelMiddleAddBookWindow().getInputName().setText("");
			this.addBookWindow.getPanelMiddleAddBookWindow().getInputAuthor().setText("");
			this.addBookWindow.getPanelMiddleAddBookWindow().getInputGenre().setText("");
			this.addBookWindow.getPanelMiddleAddBookWindow().getInputPublisher().setText("");
			this.addBookWindow.getPanelMiddleAddBookWindow().getInputNumberPages().setText("");
			this.addBookWindow.getPanelMiddleAddBookWindow().getInputIsbn().setText("");
			
			this.addBookWindow.setVisible(false);
			break;
		}
		case ADD_BOOK: {
			String name = this.addBookWindow.getPanelMiddleAddBookWindow().getInputName().getText();
			String author = this.addBookWindow.getPanelMiddleAddBookWindow().getInputAuthor().getText();
			String genre = this.addBookWindow.getPanelMiddleAddBookWindow().getInputGenre().getText();
			String publisher = this.addBookWindow.getPanelMiddleAddBookWindow().getInputPublisher().getText();
			int numberPages = Integer.parseInt(this.addBookWindow.getPanelMiddleAddBookWindow().getInputNumberPages().getText());
			int isbn = Integer.parseInt(this.addBookWindow.getPanelMiddleAddBookWindow().getInputIsbn().getText());
			
			Book book = new Book(name, author, genre, publisher, numberPages, isbn);
			this.proyectPersistenceBook.addBook(book);
			
			//se realizan volcados para actualizar los archivos de bases de datos
			this.flushData();
			
			this.addBookWindow.setVisible(false);
			
			JOptionPane.showMessageDialog(null, "Se creo el registro");
			
			
			break;
		}
		}
	}
}