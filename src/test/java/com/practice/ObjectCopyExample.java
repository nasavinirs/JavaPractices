package com.practice;

class Test
{
	int a;
	String b;
	
	public Test() {
	
	}
	
	public Test(int a, String b) {
		this.a = a;
		this.b = b;
	}
	
	public Test(Test t) {
		this.a = t.a;
		this.b = t.b;
	}
	
	public void printTest()
	{
		System.out.println("A = " + a + " & B = " + b);
	}
}

public class ObjectCopyExample {

	public static void main(String[] args) {
		// Input objects
		Test t1 = new Test();
		Test t2 = new Test(1, "String");
		
		// Through Copy Constructor concept
		Test t3 = new Test(t2);
		
		// Copy object values by assigning the objects values to another object
		Test t4 = new Test();
		t4.a = t3.a;
		t4.b = t3.b;
			
		t1.printTest();
		t2.printTest();
		t3.printTest();
		t4.printTest();
	}

}
