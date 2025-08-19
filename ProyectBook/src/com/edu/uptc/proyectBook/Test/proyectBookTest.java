package com.edu.uptc.proyectBook.Test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.edu.uptc.proyectBook.enums.ETypeFileEnum;
import com.edu.uptc.proyectBook.model.Book;
import com.edu.uptc.proyectBook.persistence.ProyectPersistenceBook;

import junit.framework.Assert;

class proyectBookTest {

	private ProyectPersistenceBook proyectPersistenceBook = new ProyectPersistenceBook();
	@Test
	void test() {
		this.scenarieOne();
		this.proyectPersistenceBook.dumpFile(ETypeFileEnum.FILE_PLAIN);
	}
	void tes2() {
		this.scenarieTwo();
		
		Assert.assertEquals(5, this.proyectPersistenceBook.getListBook().size());
	}
	private void scenarieOne() {
		Book book1 = new Book("El principito", "Del Toro", "Caricaturesco", "Columbia", 100, 1001);
		Book book2 = new Book("Rayuela", "Camilo", "Tragico", "Columbia", 110, 1002);
		Book book3 = new Book ("El bosque susurrante", "Emily Carter", "Fantasia", "Monlight Press", 412, 1003);
		Book book4 = new Book ("Bajo las olas", "James Holloway", "Aventura", "Oceanic House", 421, 1004);
		Book book5 = new Book ("Satanas", "Mario Mendoza", "Realismo magico" , "Panamericana", 368, 1005);
	
		this.proyectPersistenceBook.addBook(book1);
		this.proyectPersistenceBook.addBook(book2);
		this.proyectPersistenceBook.addBook(book3);
		this.proyectPersistenceBook.addBook(book4);
		this.proyectPersistenceBook.addBook(book5);
	}
	
	private void scenarieTwo() {
		
		// Simulacion de que la persona cerro el programa
		this.proyectPersistenceBook.setListBook(new ArrayList<>());
		Assert.assertTrue(this.proyectPersistenceBook.getListBook().isEmpty());
		
		// Simulacion de que la persona volvio a abrir el programa
		this.proyectPersistenceBook.loadFile(ETypeFileEnum.FILE_PLAIN);
		Assert.assertEquals(5, this.proyectPersistenceBook.getListBook().size());
		
	}

}
