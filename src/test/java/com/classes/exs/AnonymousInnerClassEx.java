package com.classes.exs;

class Class1 {
	int i;

	public void print() {
		System.out.println("From Class1 print() method");	
	}
}

interface Interface1 {
	void print();
}

public class AnonymousInnerClassEx {
	public static void main(String args[]) {
		Class1 classObj1 = new Class1(); // Class - Normal Class
		classObj1.print();
		Class1 classObj2 = new Class1() // Class - Anonymous Inner Class 
		{ 
			int i = 20;
	
			public void print() {
				System.out.println("I = " + i);
			}
		};
		classObj2.print();
		
		Interface1 interfaceObj1 = new Interface1() // Interface - Anonymous Inner Class  
		{
			int j = 10;
			
			public void print() {
				System.out.println("J = " + j);				
			}
		};
		
		interfaceObj1.print();
	}
}
