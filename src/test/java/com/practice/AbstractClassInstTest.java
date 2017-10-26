package com.practice;

abstract class AbstractClass {
	public void print() {
		System.out.println("From Abstract class print method");
	}
}
public class AbstractClassInstTest {
	public static void main(String args[]) {
		AbstractClass abst = new AbstractClass() { };
		abst.print();
	}
}
