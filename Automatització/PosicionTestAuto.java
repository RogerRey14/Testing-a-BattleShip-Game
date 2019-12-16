package com.battelship.main;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import com.battelship.mocks.ManagerIOMock;

public class PosicionTestAuto {

	@Test
	public void testGetOrientacionString() throws NumberFormatException, IOException {

		File f = new File ("C:\\Users\\roger\\Desktop\\testBarcoDentroDeRango.txt");
		if(f.exists())
		{
			FileReader fr = new FileReader("C:\\Users\\roger\\Desktop\\testBarcoDentroDeRango.txt");
			@SuppressWarnings("resource")
			BufferedReader bf = new BufferedReader(fr);
			String input;
			
			int num_variables=0;
			
			Posicion pos = new Posicion(0, 0);
			
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
						
						pos.setOrientacion(Integer.parseInt(num[0]));
						assertEquals(pos.getOrientacionString(), num[1]);
						assertEquals(pos.getOrientacion(), Integer.parseInt(num[0]));
						
					}
					countlinea++;
				}
				
				
				}
		}
	
	
		
		
		
	}


}
