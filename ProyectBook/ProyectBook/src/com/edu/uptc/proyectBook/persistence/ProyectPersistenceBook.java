package com.edu.uptc.proyectBook.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import com.google.gson.*;
import com.google.gson.GsonBuilder;
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
	public Boolean updateBook(Book newBook) {
		Book actualBook = new Book();
		int index=-1;
		for(int i =0; i<this.listBook.size(); i++) {
			if(this.listBook.get(i).getIsbn() == newBook.getIsbn()) {
				actualBook = this.listBook.get(i);
				index = i;
			}
		}
		if (index == -1) {
			return false;
		}
		actualBook.setName(newBook.getName());
		actualBook.setAuthor(newBook.getAuthor());
		actualBook.setGenre(newBook.getGenre());
		actualBook.setPublisher(newBook.getPublisher());
		actualBook.setNumberPages(newBook.getNumberPages());
		actualBook.setIsbn(newBook.getIsbn());
		this.listBook.set(index, actualBook);
		return true;
		
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
		if(ETypeFileEnum.JSON.equals(eTypeFileEnum)) {
			loadFileJSON();
		}
		if (ETypeFileEnum.XML.equals(eTypeFileEnum)) {
			loadFileXML();
		}
		if(ETypeFileEnum.SER.equals(eTypeFileEnum)) {
			loadFileSerializate();
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
		if(ETypeFileEnum.XML.equals(eTypeFileEnum)) {
			dumpFileXML();
		}
		if(ETypeFileEnum.SER.equals(eTypeFileEnum)) {
			dumpFileSerializate();
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
	
	/*private void dumpFileJSON() {
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
	
	*/
	/*private void loadFileJSON() {
		List<String> contentInLine = this.reader(
				config.getPathFile().concat(config.getNameFileJson()))
				.stream().filter(line -> !line.equals("[") && !line.equals("]") &&
						!line.equals(CommonConstants.BREAK_LINE) &&
						!line.trim().isEmpty() && !line.trim().isBlank())
				.collect(Collectors.toList());
		for(String line: contentInLine) {
			line = line.replace("{", "").replace("},", "").replace("}", "");
			StringTokenizer tokens = new StringTokenizer(line, ",");
			while(tokens.hasMoreElements()){
				String name = this.escapeValue(tokens.nextToken().split(":")[1]);
				String author = this.escapeValue(tokens.nextToken().split(":")[1]);
				String genre= this.escapeValue(tokens.nextToken().split(":")[1]);
				String publisher = this.escapeValue(tokens.nextToken().split(":")[1]);
				String numberPages = this.escapeValue(tokens.nextToken().split(":")[1]);
				String isbn = this.escapeValue(tokens.nextToken().split(":")[1]);
				this.listBook.add(new Book(name, author, genre, publisher, Integer.parseInt(numberPages), Integer.parseInt(isbn)));
			}
		}
	}
	
	private String escapeValue(String value) {
		return value.replace("\"", "");
	}
	*/
	private void dumpFileJSON() {
	    String rutaArchivo = config.getPathFile()
	            .concat(config.getNameFileJson());

	    try (FileWriter writer = new FileWriter(rutaArchivo)) {
	        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // formato bonito
	        gson.toJson(this.listBook, writer);  // Serializa toda la lista
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
	private void loadFileJSON(){
	    String rutaArchivo = config.getPathFile()
	            .concat(config.getNameFileJson());

	    try (FileReader reader = new FileReader(rutaArchivo)){
	    	Gson gson = new Gson();
	    	Book[] bookArray = gson.fromJson(reader, Book[].class);
	    	this.listBook = new ArrayList<> (Arrays.asList(bookArray));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadFileXML() {
		try {
			File file  = new File(config.getPathFile().concat(config.getNameFileXML()));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);
			NodeList list = document.getElementsByTagName(CommonConstants.NAME_TAG_BOOK);
			for(int i=0; i<list.getLength();i++) {
				String name = document.getElementsByTagName("name").item(i).getTextContent();
				String author = document.getElementsByTagName("author").item(i).getTextContent();
				String genre = document.getElementsByTagName("genre").item(i).getTextContent();
				String publisher = document.getElementsByTagName("publisher").item(i).getTextContent();
				int numberPages = Integer.parseInt(document.getElementsByTagName("numberPages").item(i).getTextContent());
				int isbn = Integer.parseInt(document.getElementsByTagName("isbn").item(i).getTextContent());
				this.listBook.add(new Book(name, author, genre, publisher, numberPages, isbn));
			}
					
		} catch (Exception e) {
			System.out.println("Se presento un erro en el cargue del archivo XML");
		}
	}
	
	private void dumpFileXML() {
		String rutaArchivo = config.getPathFile().concat(config.getNameFileXML());
		List<String> records = new ArrayList<String>();
		records.add("<XML version=\"1.0\" encoding=\"UTF-8\">");
		for (Book book : this.listBook) {
			records.add("<book>\n");
			records.add("\t<name>"+ book.getName()+"</name>");
			records.add("\t<author>"+book.getAuthor()+"</author>");
			records.add("\t<genre>"+book.getGenre()+"</genre>");
			records.add("\t<publisher>"+book.getPublisher()+"</publisher>");
			records.add("\t<numberPages>"+book.getNumberPages()+"</numberPages>");
			records.add("\t<isbn>"+book.getIsbn()+"</isbn>");
			records.add("</book>");
			
			
		}
		records.add("</XML>");
		this.writer(rutaArchivo, records);
	}
	
	private void dumpFileSerializate() {
		try (FileOutputStream fileOut = new FileOutputStream(this.config.getPathFile().concat(this.config.getNameFileSer()));
			ObjectOutputStream out = new ObjectOutputStream(fileOut)){
			out.writeObject(this.listBook);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void loadFileSerializate() {
		try (FileInputStream fileIn = new FileInputStream(this.config.getPathFile().concat(this.config.getNameFileSer()));
				ObjectInputStream in = new ObjectInputStream(fileIn)){
			this.listBook = (List<Book>) in.readObject();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	public List<Book> getListBook() {
		return listBook;
	}

	public void setListBook(List<Book> listBook) {
		this.listBook = listBook;
	}
	
	
	
}
