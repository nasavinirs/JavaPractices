package com.practice;

@FunctionalInterface
interface Calculator {
	int add(int a, int b);
	
	default void print() {
		System.out.println("From Calculator print() method");
	}
	
	static void show()
	{
		System.out.println("From Calculator show() method");
	}
}

public class FunctionalInterfaceEx1 {

	public static void main(String[] args) {
		int a = 10, b = 20;
		Calculator s = (x,y) -> x+y; // Lambda Expression
		
		System.out.println(s.add(a,b));
		s.print(); // Calling default() method
		Calculator.show(); // Calling show() method
		
	}

}
