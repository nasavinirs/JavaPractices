package com.abstracts.exs;

abstract class BaseAbstract5 {
	
	static String value = "VALUE";
	static void method() {
		System.out.println("From BaseAbstract5 class static method()");
	}
}

public class AbstractExample5 {

	public static void main(String[] args) {
		BaseAbstract5.method();
		System.out.println(BaseAbstract5.value);
	}

}
