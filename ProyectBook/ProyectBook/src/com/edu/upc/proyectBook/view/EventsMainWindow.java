package com.edu.upc.proyectBook.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.edu.uptc.proyectBook.enums.ETypeFileEnum;
import com.edu.uptc.proyectBook.model.Book;
import com.edu.uptc.proyectBook.persistence.ProyectPersistenceBook;

public class EventsMainWindow implements ActionListener {
	public static final String LOAD_BOOK_PLAIN = "LOAD_BOOK_PLAIN";
	public static final String LOAD_BOOK_XML = "LOAD_BOOK_XML";
	public static final String LOAD_BOOK_CSV = "LOAD_BOOK_CSV";
	public static final String LOAD_BOOK_JSON = "LOAD_BOOK_JSON";
	public static final String LOAD_BOOK_SERIALIZATE = "LOAD_BOOK_SERIALIZATE";
	public static final String ADD_BOOK = "ADD_BOOK";
	public static final String SEE_MORE_BOOK = "SEE_MORE_BOOK";
	public static final String FIND_BOOK_BY = "FIND_BOOK_BY";
	public static final String SHOW_FIND_BOOK = "SHOW_FIND_BOOK";
	public static final String BACK = "BACK";
	public static final String UPDATE_BOOK = "UPDATE_BOOK";

	private MainWindow mainWindow;
	private ProyectPersistenceBook proyectPersistenceBook;
	
	public EventsMainWindow(MainWindow mainWindow) {
		this.proyectPersistenceBook = new ProyectPersistenceBook();
		this.mainWindow = mainWindow;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(LOAD_BOOK_PLAIN)) {
			this.loadInfoTable(ETypeFileEnum.FILE_PLAIN);
		}
		if (e.getActionCommand().equals(LOAD_BOOK_XML)) {
			this.loadInfoTable(ETypeFileEnum.XML);
		}
		if (e.getActionCommand().equals(LOAD_BOOK_JSON)) {
			this.loadInfoTable(ETypeFileEnum.JSON);
		}
		if (e.getActionCommand().equals(LOAD_BOOK_SERIALIZATE)) {
			this.loadInfoTable(ETypeFileEnum.SER);
		}
		if (e.getActionCommand().equals(LOAD_BOOK_CSV)) {
			this.loadInfoTable(ETypeFileEnum.CSV);
		}
		if (e.getActionCommand().equals(ADD_BOOK)) {
			this.mainWindow.getAddBookWindow().setVisible(true);
		}
		if (e.getActionCommand().equals(SEE_MORE_BOOK)) {
			
		}if (e.getActionCommand().equals(SHOW_FIND_BOOK)) {
			this.mainWindow.getFindBookWindow().setVisible(true);
		}
		if (e.getActionCommand().equals(BACK)) {
			this.mainWindow.getFindBookWindow().setVisible(false);
		}
		if (e.getActionCommand().equals(FIND_BOOK_BY)) {
			int index = mainWindow.getFindBookWindow().getComboAtributes().getSelectedIndex();
			String value = mainWindow.getFindBookWindow().getTxtfind().getText();
			Book book = proyectPersistenceBook.findBookByIsbn(Integer.parseInt(value));
			this.clearTable();
			Object[] row = new Object[] {book.getName(), book.getAuthor(), book.getGenre(), book.getPublisher(), book.getNumberPages(), book.getIsbn()};
			this.mainWindow.getPanelMiddleMainWindow().addRow(row);
		}
		if (e.getActionCommand().equals(UPDATE_BOOK)) {
			Book book = new Book();
			this.proyectPersistenceBook.updateBook(null);
		}
		
	}
	
	public void loadInfoTable (ETypeFileEnum eTypeFileEnum) {
		proyectPersistenceBook.setListBook(new ArrayList<>());
		proyectPersistenceBook.loadFile(eTypeFileEnum);
		this.clearTable();
		proyectPersistenceBook.getListBook().forEach(book -> {
			Object [] row = {book.getName(), book.getAuthor(), book.getGenre(), book.getPublisher(), book.getNumberPages(), book.getIsbn()};
			this.mainWindow.getPanelMiddleMainWindow().addRow(row);
		});
	}
	public void clearTable() {
		for (int i= (this.mainWindow.getPanelMiddleMainWindow().getDtm().getRowCount() -1); i >= 0; i--) {
			this.mainWindow.getPanelMiddleMainWindow().getDtm().removeRow(i);
		}
	}

}
