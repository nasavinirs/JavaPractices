package com.classes.exs;

import com.classes.exs.OuterClass2.InnerClass2;

class OuterClass2 {
	int i;
	static class InnerClass2 {
		int j;
		
		public void print() {
			System.out.println("J = " + j);
		}
	}
}

public class StaticInnerClassEx {
	public static void main(String args[]) {
		OuterClass2 outer = new OuterClass2(); // Outer Class
		outer.i = 10;
		System.out.println("I = " + outer.i);		
		InnerClass2 inner = new InnerClass2(); // Static Inner Class
		inner.j = 20;		
		inner.print();		
	}
}
