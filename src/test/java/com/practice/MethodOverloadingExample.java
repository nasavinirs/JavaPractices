package com.practice;

public class MethodOverloadingExample {

	public int add(int a, int b) {
		System.out.println("int");
		return a + b;
	}
	
	public double add(double a, double b) {
		System.out.println("double");
		return (a + b);
	}
	
	public static void main(String[] args) {

		MethodOverloadingExample obj = new MethodOverloadingExample();
		System.out.println(obj.add(1, 2));
	}

}
