package com.classes.exs;

import com.classes.exs.OuterClass1.InnerClass1;

class OuterClass1 {
	int i;
	class InnerClass1 {
		int j;
		
		public void print() {
			System.out.println("I = " + i);
			System.out.println("J = " + j);
		}
	}
}

public class InstanceInnerClassEx {
	public static void main(String args[]) {
		OuterClass1 outer = new OuterClass1(); // Outer class
		outer.i = 10;
		InnerClass1 inner = outer.new InnerClass1(); // Instance Inner class
		inner.j = 20;
		inner.print();
	}
}
