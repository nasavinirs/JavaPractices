package com.abstracts.exs;

abstract class BaseAbstract1 {
	
	public void prints() {
		System.out.println("From BastAbstract");
	}
}

public class AbstractExample1 {

	public static void main(String args[]) {
		//BaseAbstract1 obj = new BaseAbstract1(); // Cannot instantiate the type BaseAbstract
		
		
		// Creating object for an abstract class is possible indirectly by the following way.
		BaseAbstract1 obj = new BaseAbstract1() {
			
		};
		
		obj.prints();
		System.out.println(obj.getClass().toString());
	}
}
