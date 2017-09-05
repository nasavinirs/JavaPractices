package com.abstracts.exs;

abstract class BaseAbstract3 extends BaseAbstract1 {
	
	public void prints() {
		System.out.println("From BastAbstract3");
	}
}

public class AbstractExample3 extends BaseAbstract3 {

	public static void main(String[] args) {
		AbstractExample3 obj = new AbstractExample3();
		
		obj.prints();
	}

}
