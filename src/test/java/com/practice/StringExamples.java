package com.practice;

class Base {
	public void foo(Object o) {
		System.out.println("Object");
	}

	public void foo(Exception e) {
		System.out.println("Exception");
	}

	public void foo(NullPointerException ne) {
		System.out.println("NullPointerException");
	}
/*
	public void foo(String ne) {
		System.out.println("String");	
	}*/
}

public class StringExamples  {
	public static void main(String args[]) {
	/*	String s1 = "abc";
		String s2 = new String("abc");
		s2 = s2.intern(); // true
		// s1.intern(); // false
		System.out.println(s1 == s2);*/
		
		//Base b = new Base();
		//b.foo(null);	
		//new Base().foo(null);
		
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		
		System.out.println("S1 = " + s1.hashCode());
		System.out.println("S2 = " + s2.hashCode());
		System.out.println("S3 = " + s3.hashCode());
		System.out.println("S4 = " + s4.hashCode());

	}
}

