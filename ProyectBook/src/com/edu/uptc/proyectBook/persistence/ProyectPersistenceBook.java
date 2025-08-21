package com.edu.uptc.proyectBook.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

import com.edu.uptc.proyectBook.constants.CommonConstants;
import com.edu.uptc.proyectBook.enums.ETypeFileEnum;
import com.edu.uptc.proyectBook.interfaces.IActionsFile;
import com.edu.uptc.proyectBook.model.Book;

public class ProyectPersistenceBook extends FilePlain implements IActionsFile {

	private List<Book> listBook;
	
	public ProyectPersistenceBook() {
		listBook = new ArrayList<>();
	}
	
	public Boolean addBook(Book book) {
		if(Objects.isNull(this.findBookByIsbn(book.getIsbn()))) {
			this.listBook.add(book);
			return Boolean.TRUE;
		}
		return 	Boolean.FALSE;
	}
		
	public Book findBookByIsbn(int isbn) {
		for(Book book: this.listBook) {
			if(book.getIsbn() == isbn) {
				return book;
			}
		}
		return null;
	}
	
	@Override
	public void loadFile(ETypeFileEnum eTypeFileEnum) {
		if(ETypeFileEnum.FILE_PLAIN.equals(eTypeFileEnum)) {
			String nameFile = config.getNameFile();
			loadFilePlain(nameFile);
		}
		if(ETypeFileEnum.CSV.equals(eTypeFileEnum)) {
			String nameFileCsv = config.getNameFileCSV() ;
			loadFilePlain(nameFileCsv);
		}
		
	}

	@Override
	public void dumpFile(ETypeFileEnum eTypeFileEnum) {
		if(ETypeFileEnum.FILE_PLAIN.equals(eTypeFileEnum)) {
			String nameFile = config.getNameFile();
			this.dumbFilePlain(nameFile);
		}
		if(ETypeFileEnum.CSV.equals(eTypeFileEnum)) {
			String nameFileCsv = config.getNameFileCSV() ;
			this.dumbFilePlain(nameFileCsv);
		}
		if(ETypeFileEnum.JSON.equals(eTypeFileEnum)) {
			dumpFileJSON();
		}
		
	}
	
	private void loadFilePlain(String nameFile) {
		List <String> contentInLine = this.reader(config.getPathFile().concat(nameFile));
		contentInLine.forEach(row -> {
			StringTokenizer tokens = new StringTokenizer(row, CommonConstants.SEMICOLON);
			while(tokens.hasMoreElements()) {
				String name = tokens.nextToken();
				String author = tokens.nextToken();
				String genre = tokens.nextToken();
				String publisher = tokens.nextToken();
				int numberPages = Integer.parseInt(tokens.nextToken());
				int isbn = Integer.parseInt(tokens.nextToken());
				this.listBook.add(new Book(name, author, genre, publisher, numberPages, isbn));
				
			}
		});
	}
	
	private void dumbFilePlain(String nameFile) {
		StringBuilder rutaArchivo = new StringBuilder();
		rutaArchivo .append(config.getPathFile());
		rutaArchivo.append(nameFile);
		List<String> records = new ArrayList<>();
		for(Book book : this.listBook) {
			StringBuilder contentBook = new StringBuilder();
			contentBook.append(book.getName()).append(CommonConstants.SEMICOLON);
			contentBook.append(book.getAuthor()).append(CommonConstants.SEMICOLON);
			contentBook.append(book.getGenre()).append(CommonConstants.SEMICOLON);
			contentBook.append(book.getPublisher()).append(CommonConstants.SEMICOLON);
			contentBook.append(book.getNumberPages()).append(CommonConstants.SEMICOLON);
			contentBook.append(book.getIsbn());
			records.add(contentBook.toString());
		}
		this.writer(rutaArchivo.toString(), records);
	}
	private void dumpFileJSON() {
		String rutaArchivo = config.getPathFile()
				.concat(config.getNameFileJson());
	    StringBuilder json = null;
	    List<String> content = new ArrayList<String>();
	    content.add(CommonConstants.OPENING_BRACKET);
	    int contador = 0;
	    int total = listBook.size();
	    for (Book c : this.listBook) {
	    	json = new StringBuilder();
	        json.append("{");
	        json.append("  \"name\":\"").append(escape(c.getName())).append("\",");
	        json.append("  \"author\":\"").append(escape(c.getAuthor())).append("\",");
	        json.append("  \"genre\":\"").append(escape(c.getGenre())).append("\",");
	        json.append("  \"publisher\":\"").append(escape(c.getPublisher())).append("\",");
	        json.append("  \"numberPages\":\"").append(escape(String.valueOf(c.getNumberPages()))).append("\",");
	        json.append("  \"isbn\":\"").append(escape(String.valueOf(c.getIsbn()))).append("\"");
	        json.append("}");

	        contador++;
	        if (contador < total) {
	            json.append(",");
	        }
	        content.add(json.toString());
	    }
	    content.add("]");
	    this.writer(rutaArchivo, content);
	}
	
	private String escape(String value) {
	    if (value == null) return "";
	    return value.replace("\\", "\\\\").replace("\"", "\\\"");
	}
	
	
	

	public List<Book> getListBook() {
		return listBook;
	}

	public void setListBook(List<Book> listBook) {
		this.listBook = listBook;
	}
	
	
	
}
