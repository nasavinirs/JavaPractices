package com.abstracts.exs;

interface Interface1 {
	void method1();
	void method2();
}

abstract class BaseAbstract4 implements Interface1 {
	
	public void method1() {		
		System.out.println("From implemented interface method method1() from BaseAbstract4 class");
	}
}

public class AbstractExample4 extends BaseAbstract4 {

	public void method2() {
		System.out.println("From implemented interface method method2() from AbstractExample4 class");
	}
	
	public static void main(String args[]) {
		AbstractExample4 obj = new AbstractExample4();
		obj.method1();
		obj.method2();
	}
}
