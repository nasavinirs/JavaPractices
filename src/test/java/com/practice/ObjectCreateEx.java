package com.practice;

public class ObjectCreateEx {

	public void printValue()
	{
		System.out.println("Printing from ObjectCreateEx -> printValue() method");
	}

	public static void main(String[] args) throws Exception {
		// Method 1
		//ObjectCreateEx ex = new ObjectCreateEx();
		//ex.printValue();
		
		// Method 2
		//Class c = Class.forName("com.practice.ObjectCreateEx");
		//ObjectCreateEx ex = (ObjectCreateEx) c.newInstance();
		//ex.printValue();
		
		// Method 3 - Not working
		//ObjectCreateEx ex1 = new ObjectCreateEx();
		//ObjectCreateEx ex2 = ex1.clone();
		//ex2.printValue();
		
		
	}
}
