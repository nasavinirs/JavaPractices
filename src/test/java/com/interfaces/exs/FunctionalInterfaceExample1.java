package com.interfaces.exs;

interface FuncInterface1 {
	default void log() {
		System.out.println("From FuncInterface1 default method");
	}
}

interface FuncInterface2 {
	default void log() {
		System.out.println("From FuncInterface2 default method");
	}
}

public class FunctionalInterfaceExample1 implements FuncInterface1, FuncInterface2 {

	public static void main(String[] args) {
		FunctionalInterfaceExample1 obj = new FunctionalInterfaceExample1();
		obj.log();
		
	}

	@Override
	public void log() {
		FuncInterface1.super.log();
	}

}
