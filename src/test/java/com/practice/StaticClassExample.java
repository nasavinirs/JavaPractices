package com.practice;

import com.practice.ParentClass.ChildClass;

class ParentClass {
	static int a = 10;
	int b = 20;
	
	public ParentClass() {
		System.out.println("From ParentClass");
	}
	
	public static void printA() {
		System.out.println("A = " + a);
	}
	
	public void printB() {
		System.out.println("B = " + b);
	}
	
	static class ChildClass {
		public ChildClass() {
			System.out.println("From ChildClass");
		}
		
		public void printC() {
			printA();
		}
	}
}

public class StaticClassExample {

	public static void main(String[] args) {
		ParentClass.ChildClass obj = new ParentClass.ChildClass();
		obj.printC();
		
		ParentClass pObj = new ParentClass();
		ParentClass.printA();
		pObj.printB();
	}

}
