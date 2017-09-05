package com.abstracts.exs;

abstract class BaseAbstract2 {
	
	abstract public void method();
	
	public void prints() {
		System.out.println("From BastAbstract2");
	}
}

public class AbstractExample2 extends BaseAbstract2 {

	public static void main(String[] args) {

		AbstractExample2 obj = new AbstractExample2();
		obj.prints();
		obj.method();
		obj.method2();
		
	}

	public void method() {
		System.out.println("Form implemented abstract method");
		
	}

	public void method2() {
		System.out.println("Form method2");
		
	}
}
