package com.methodover.exs;

class StaticClass {
	public static void print() {
		System.out.println("Printed from StaticClass class print() method.");
	}
}

public class StaticMethodOverride extends StaticClass {
	
	public static void print() {
		System.out.println("Printed from StaticMethodOverride class print() method.");
	}
	
	public static void main(String args[]) {
		StaticClass obj =  new StaticMethodOverride();
		
		obj.print();
	}
}
