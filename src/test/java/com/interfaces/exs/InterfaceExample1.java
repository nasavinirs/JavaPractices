package com.interfaces.exs;

interface Interface1 {
	// Constant
	int constant = 10;
	
	// Default method
	default void defaultMethod() {
		System.out.println("From Interface1 defaultMethod()");
	}
	
	// Static method
	static void staticMethod() {
		System.out.println("From Interface1 staticMethod()");				
	}
	
	// Method signature without any implementation
	void normalMethod();
}

public class InterfaceExample1 implements Interface1 {

	public static void main(String[] args) {
		InterfaceExample1 obj = new InterfaceExample1();
		System.out.println(Interface1.constant);
		Interface1.staticMethod();
		obj.defaultMethod();
		obj.normalMethod();
	}

	public void normalMethod() {
		System.out.println("From Interface1 implemented class InterfactExample1 implemented method defaultMethod()");
	}


}
