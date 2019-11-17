//package com.battelship.main.TDD;
//import java.util.Random;
//import java.util.Scanner;
//
//import com.battelship.main.intefaces.IManagerIO;
//
//
//
//public class ManagerIO implements IManagerIO {
//	private Scanner scanner;
//	Random rn ;
//	public ManagerIO() {
//	
//	}	
//
//	public int inInt() {
//		scanner = new Scanner(System.in);
//		return scanner.nextInt();
//	}
//	
//	public void out(String data) {
//		System.out.print(data);
//	}
//	
//	public void out(int data) {
//		System.out.print(data);
//	}
//
//	
//	public int getRandomInt() {
//		rn = new Random();
//		return rn.nextInt(10) + 1;
//	}
//
//
//	public int getRandomOrientacion() {
//		rn = new Random();
//		return rn.nextInt(4) + 0;
//	}
//
//
//
//
//
//	
//	
//}