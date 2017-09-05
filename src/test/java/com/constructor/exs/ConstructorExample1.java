package com.constructor.exs;

public class ConstructorExample1 {

	public ConstructorExample1(int a) {
		
	}
	
	public static void main(String[] args) {
		
		// ConstructorExample1 obj = new ConstructorExample1(); // This is create compile time error
		ConstructorExample1 obj = new ConstructorExample1(1); // This will work

	}

}
