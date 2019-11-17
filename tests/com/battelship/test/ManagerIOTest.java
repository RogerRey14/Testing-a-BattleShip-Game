package com.battelship.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.battelship.main.ManagerIO;

public class ManagerIOTest {
	private PrintStream systemOutOriginal;
	public ByteArrayOutputStream resultado;

	/*
	 * Función que se ejecuta antes de cada @Test inicializa y setea un outputstream
	 * para recoger los datos printados en consola
	 */
	@Before
	public void beforeAll() {
		systemOutOriginal = System.out;
		resultado = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultado));
	}

	/*
	 * Función que devuelve la salida del sistema a su estado original despues de
	 * cada @Test
	 */
	@After
	public void restoreSystemOutStream() {
		System.setOut(systemOutOriginal);
	}

	/*
	 * Test Funcion que printa un Integer en el buffer de salida
	 */
	@Test
	public void testManagerIOOutInteger() {
		ManagerIO manager = new ManagerIO();
		manager.out(1);
		assertEquals(Integer.valueOf(resultado.toString()),Integer.valueOf(1));
	}
	
	/*
	 * Test Funcion que printa un String en el buffer de salida
	 */
	@Test
	public void testManagerIOOutString() {
		ManagerIO manager = new ManagerIO();
		manager.out("hola");
		assertEquals(resultado.toString(),"hola");
	}
	
	/*
	 * Test Funcion que genera numero aleatorio entre 0-10
	 */
	@Test
	public void testManagerIOGetRandomInt() {
		ManagerIO manager = new ManagerIO();
		
	
		for(int i=0;i<100;i++) {
			int random = manager.getRandomInt();
			assertTrue(random>=0 && random<=10);
		}
		
	}
	
	/*
	 * Test Funcion que genera orientacion aleatoria entre 0-4
	 */
	@Test
	public void testManagerIOGetRandomOrientacion() {
		ManagerIO manager = new ManagerIO();
		
	
		for(int i=0;i<100;i++) {
			int random = manager.getRandomOrientacion();
			assertTrue(random>=0 && random<=4);
		}
		
	}
	
	/*
	 * Test Funcion lee la entrada por teclado de un valor Integer
	 */
	@Test
	public void testManagerIOinInt() {
		
		ManagerIO manager = new ManagerIO();
		String value = "1";
		ByteArrayInputStream in = new ByteArrayInputStream(value.getBytes());
		manager.setScanner(new Scanner(in));
		assertEquals(manager.inInt(),1);
	
		
		
		
	}
	

}