package com.interfaces.exs;

interface Interface2 {
	default void defaultMethod() {
		System.out.println("From Interface1 defaultMethod()");
	}
}

public class InterfaceExample2 implements Interface2 {

	public static void main(String[] args) {
		Interface2 obj = new InterfaceExample2();
		obj.defaultMethod();

	}

}
