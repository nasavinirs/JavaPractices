package com.constructor.exs;

class PrivateContructor {

	static PrivateContructor obj;
	private PrivateContructor() {
		
	}
	
	public static PrivateContructor newInstance()
	{
		if (obj == null)
			return new PrivateContructor();
		else
			return null;
	}
	
	public void print() {
		System.out.println(" From PrivateContructor class print() method");
	}
}

public class PrivateContructorExample1 {

	
	public static void main(String[] args) {
		PrivateContructor obj = PrivateContructor.newInstance();
		obj.print();
		
	}

}
