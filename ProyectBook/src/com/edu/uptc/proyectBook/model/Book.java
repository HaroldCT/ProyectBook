package com.edu.uptc.proyectBook.model;

import java.io.Serializable;

public class Book implements Serializable{

	private String name;
	private String author;
	private String genre;
	private String publisher;
	private int numberPages;
	private int isbn;
	
	public Book() {
		
	}

	public Book(String name, String author, String genre, String publisher, int numberPages, int isbn) {
		super();
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		this.numberPages = numberPages;
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getNumberPages() {
		return numberPages;
	}

	public void setNumberPages(int numberPages) {
		this.numberPages = numberPages;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
}
