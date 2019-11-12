package com.battelship.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.BeforeClass;
import org.junit.Test;

import com.battelship.Posicion;

/*
 * Esta clase de test se encarga de las pruebas unitarias de la clase Posicion
 */
public class PosicionTest {

	private static PrintStream systemOutOriginal;
	public static ByteArrayOutputStream resultado;

	/*
	 * Funci�n que se ejecuta antes de cada @Test inicializa y setea un outputstream
	 * para recoger los datos printados en consola
	 */
	@BeforeClass
	public static void beforeClass() {
		systemOutOriginal = System.out;
		resultado = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultado));
	}

	/*
	 * Test de caja negra para asegurar que el constructor setea correctamente los
	 * parametros
	 */
	@Test
	public void testConstructor() {
		Posicion posicion = new Posicion(0, 0);
		assertEquals(posicion.getX(), 0);
		assertEquals(posicion.getY(), 0);
	}

	/*
	 * Test de caja negra del metodo getOrientacionString particiones equivalentes
	 * (-inf, 0), [0, 3], [4, inf) frontera 0, 3 limites: -1, 1, 3, 4
	 */
	@Test
	public void testOrientacion() {
		Posicion posicion = new Posicion(0, 0);
		posicion.setOrientacion(0);
		assertEquals(posicion.getOrientacionString(), "Derecha");
		posicion.setOrientacion(1);
		assertEquals(posicion.getOrientacionString(), "Abajo");
		posicion.setOrientacion(2);
		assertEquals(posicion.getOrientacionString(), "Arriba");
		posicion.setOrientacion(3);
		assertEquals(posicion.getOrientacionString(), "Izquierda");
		posicion.setOrientacion(-1);
		assertEquals(posicion.getOrientacionString(), "No tiene orientacion");
		posicion.setOrientacion(4);
		assertEquals(posicion.getOrientacionString(), "No tiene orientacion");
	}

	/*
	 * Test de caja negra del metodo Posicion.toString() que muestra por el terminal
	 * los valores de Posicion. Particiones equivalentes: (-inf, 0), [0, 3], [4,
	 * inf) frontera 0, 3 limites: -1, 1, 3, 4
	 */
	@Test
	public void testPrintPosicion() {

		Posicion posicion = new Posicion(0, 0);
		posicion.setOrientacion(0);
		assertEquals(posicion.toString(), "Posicion [x=1, y=1, orientacion=Derecha]");
		restoreSystemOutStream();

		posicion.setOrientacion(1);
		assertEquals(posicion.toString(), "Posicion [x=1, y=1, orientacion=Abajo]");
		restoreSystemOutStream();
		posicion.setOrientacion(2);

		assertEquals(posicion.toString(), "Posicion [x=1, y=1, orientacion=Arriba]");
		restoreSystemOutStream();
		posicion.setOrientacion(3);

		assertEquals(posicion.toString(), "Posicion [x=1, y=1, orientacion=Izquierda]");
		restoreSystemOutStream();
		posicion.setOrientacion(-1);

		assertEquals(posicion.toString(), "Posicion [x=1, y=1, orientacion=No tiene orientacion]");
		restoreSystemOutStream();
		posicion.setOrientacion(4);
		assertEquals(posicion.toString(), "Posicion [x=1, y=1, orientacion=No tiene orientacion]");
	}

	/*
	 * Funci�n que devuelve la salida del sistema a su estado original despues de
	 * cada
	 */
	private void restoreSystemOutStream() {
		System.setOut(systemOutOriginal);
	}

}
