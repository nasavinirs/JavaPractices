package com.practice;

import java.lang.reflect.Method;

class RefEx {
	
	public void method1()
	{
		System.out.println("From method1()");
	}
	
	public void method2()
	{
		System.out.println("From method2()");
	}
	
	public void method3()
	{
		System.out.println("From method3()");
	}
}

public class ReflectionExample {

	public static void main(String[] args) {

		Method[] methods = RefEx.class.getMethods();

		for(Method method : methods){
		    System.out.println("method = " + method.getName());
		}

	}

}
