package com.battelship.main;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.battelship.mocks.ManagerIOMock;

class TableroTestAuto {

	@Test
	void testInsertPosition() throws IOException {
		File f = new File ("C:\\Users\\roger\\Desktop\\testInsertPosition.txt");
		if(f.exists())
		{
			FileReader fr = new FileReader("C:\\Users\\roger\\Desktop\\testInsertPosition.txt");
			@SuppressWarnings("resource")
			BufferedReader bf = new BufferedReader(fr);
			String input;
			
			int num_variables=0;
			
			int countlinea=1;
			while ((input = bf.readLine()) != null)
				{
				//System.out.println(input);
				String[] num=input.split(" ");
				
				if(countlinea==1)
				{
					num_variables = Integer.parseInt(num[0]);
					countlinea++;
				} else if(countlinea!=3)
				{
					for(int i=0;i<num_variables;i++)
					{
						int [] x =new int[] {Integer.parseInt(num[0]),Integer.parseInt(num[1])};
						Tablero testTablero = new Tablero(new ManagerIOMock(x));
						testTablero.insertPosicion(Integer.parseInt(num[2]));
						assertEquals(testTablero.getTablero()[Integer.parseInt(num[0])-1][Integer.parseInt(num[1])-1], 1);
						
					}
					countlinea++;
				}
				
				
				}
		}
	}
	
	@Test
	void testInsertVaixell() throws IOException {
		File f = new File ("C:\\Users\\roger\\Desktop\\testInsertVaixell.txt");
		if(f.exists())
		{
			FileReader fr = new FileReader("C:\\Users\\roger\\Desktop\\testInsertVaixell.txt");
			@SuppressWarnings("resource")
			BufferedReader bf = new BufferedReader(fr);
			String input;
			
			int num_variables=0;
			
			int countlinea=1;
			while ((input = bf.readLine()) != null)
				{
				//System.out.println(input);
				String[] num=input.split(" ");
				
				if(countlinea==1)
				{
					num_variables = Integer.parseInt(num[0]);
					countlinea++;
				} else if(countlinea!=3)
				{
					for(int i=0;i<num_variables;i++)
					{
						int [] x =new int[] {Integer.parseInt(num[0]),Integer.parseInt(num[1])};
						Tablero testTablero = new Tablero(new ManagerIOMock(x));
						
						Posicion pos = new Posicion(Integer.parseInt(num[0]), Integer.parseInt(num[1]));
						pos.setTamaño(Integer.parseInt(num[2]));
						pos.setOrientacion(Integer.parseInt(num[3]));
						testTablero.insertarBarco(pos);
						
						for(int j=0;j<Integer.parseInt(num[2]);j++)
						{
							
							if(Integer.parseInt(num[3])==0)//orientacio dreta
							{
								assertEquals(testTablero.getTablero()[Integer.parseInt(num[0])][Integer.parseInt(num[1])+j], 1);
							}
							if(Integer.parseInt(num[3])==1)//orientacio abaix
							{
								assertEquals(testTablero.getTablero()[Integer.parseInt(num[0])+j][Integer.parseInt(num[1])], 1);
							}
							if(Integer.parseInt(num[3])==2)//orientacio adalt
							{
								assertEquals(testTablero.getTablero()[Integer.parseInt(num[0])-j][Integer.parseInt(num[1])], 1);
							}
							if(Integer.parseInt(num[3])==3)//orientacio esquerra
							{
								assertEquals(testTablero.getTablero()[Integer.parseInt(num[0])][Integer.parseInt(num[1])-j], 1);
							}
							
						}

						
					}
					countlinea++;
				}
				
				
				}
		}
	}
	
	
	
	@Test
	void testLeerOrientacion() throws IOException {
		File f = new File ("C:\\Users\\roger\\Desktop\\testLeerOrientacion.txt");
		if(f.exists())
		{
			FileReader fr = new FileReader("C:\\Users\\roger\\Desktop\\testLeerOrientacion.txt");
			@SuppressWarnings("resource")
			BufferedReader bf = new BufferedReader(fr);
			String input;
			
			int num_variables=0;
			
			int countlinea=1;
			while ((input = bf.readLine()) != null)
				{
				//System.out.println(input);
				String[] num=input.split(" ");
				
				if(countlinea==1)
				{
					num_variables = Integer.parseInt(num[0]);
					countlinea++;
				} else if(countlinea!=3)
				{
					for(int i=0;i<num_variables;i++)
					{
						int [] x =new int[] {Integer.parseInt(num[0]),Integer.parseInt(num[1]),Integer.parseInt(num[2])};
						Tablero testTablero = new Tablero(new ManagerIOMock(x));
						assertEquals(testTablero.leerOrientacion(), Integer.parseInt(num[2]));
						
					}
					countlinea++;
				}
				
				
				}
		}
	}
	
	@Test
	void testBarcoFueraDeRango() throws IOException {
		File f = new File ("C:\\Users\\roger\\Desktop\\testBarcoFueraDeRango.txt");
		if(f.exists())
		{
			FileReader fr = new FileReader("C:\\Users\\roger\\Desktop\\testBarcoFueraDeRango.txt");
			@SuppressWarnings("resource")
			BufferedReader bf = new BufferedReader(fr);
			String input;
			
			int num_variables=0;
			
			int countlinea=1;
			while ((input = bf.readLine()) != null)
				{
				//System.out.println(input);
				String[] num=input.split(" ");
				
				if(countlinea==1)
				{
					num_variables = Integer.parseInt(num[0]);
					countlinea++;
				} else if(countlinea!=3)
				{
					for(int i=0;i<num_variables;i++)
					{
						int [] x =new int[] {Integer.parseInt(num[0]),Integer.parseInt(num[1])};
						Tablero testTablero = new Tablero(new ManagerIOMock(x));
						
						Posicion pos = new Posicion(Integer.parseInt(num[2]), Integer.parseInt(num[3]));
						pos.setTamaño(Integer.parseInt(num[4]));
						pos.setOrientacion(Integer.parseInt(num[5]));
						assertFalse(testTablero.sePuedeInsertarOrientacion(pos));
						
					}
					countlinea++;
				}
				
				
				}
		}
	}
	
	
	

	@Test
	void testBarcoDentroDeRango() throws IOException {
		File f = new File ("C:\\Users\\roger\\Desktop\\testBarcoDentroDeRango.txt");
		if(f.exists())
		{
			FileReader fr = new FileReader("C:\\Users\\roger\\Desktop\\testBarcoDentroDeRango.txt");
			@SuppressWarnings("resource")
			BufferedReader bf = new BufferedReader(fr);
			String input;
			
			int num_variables=0;
			
			int countlinea=1;
			while ((input = bf.readLine()) != null)
				{
				//System.out.println(input);
				String[] num=input.split(" ");
				
				if(countlinea==1)
				{
					num_variables = Integer.parseInt(num[0]);
					countlinea++;
				} else if(countlinea!=3)
				{
					for(int i=0;i<num_variables;i++)
					{
						int [] x =new int[] {Integer.parseInt(num[0]),Integer.parseInt(num[1])};
						Tablero testTablero = new Tablero(new ManagerIOMock(x));
						
						Posicion pos = new Posicion(Integer.parseInt(num[2]), Integer.parseInt(num[3]));
						pos.setTamaño(Integer.parseInt(num[4]));
						pos.setOrientacion(Integer.parseInt(num[5]));
						assertTrue(testTablero.sePuedeInsertarOrientacion(pos));
						
					}
					countlinea++;
				}
				
				
				}
		}
	}
	
	
}
	


