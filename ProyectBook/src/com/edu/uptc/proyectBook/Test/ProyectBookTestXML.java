package com.edu.uptc.proyectBook.Test;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import com.edu.uptc.proyectBook.enums.ETypeFileEnum;
import com.edu.uptc.proyectBook.model.Book;
import com.edu.uptc.proyectBook.persistence.ProyectPersistenceBook;



class ProyectBookTestXML {
	private ProyectPersistenceBook proyectPersistenceBook = new ProyectPersistenceBook();

	@Test
	void test() {
		this.scenarieOne();
		this.proyectPersistenceBook.dumpFile(ETypeFileEnum.XML);
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
	
	@Test
	void test2() {
		this.proyectPersistenceBook.setListBook(new ArrayList<>());//Prueba de q cerro el programa
		Assert.assertEquals(0, this.proyectPersistenceBook.getListBook().size());
		
		this.proyectPersistenceBook.loadFile(ETypeFileEnum.XML);//Simulacion de volvio a ejecutar el programa
		Assert.assertEquals("El principito", this.proyectPersistenceBook.getListBook().get(0).getName());
		Assert.assertEquals("Tragico", this.proyectPersistenceBook.getListBook().get(1).getGenre());
	}
}
