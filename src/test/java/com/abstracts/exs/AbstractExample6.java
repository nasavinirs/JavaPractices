package com.abstracts.exs;

abstract class BaseAbstract6 {
	
	abstract void print();
}

public class AbstractExample6 extends BaseAbstract6 {
	
	public static void main(String[] args) {
	
		BaseAbstract6 obj = new BaseAbstract6() {

			void print() {
				System.out.println("From inner class implemented print() method");	
			}
			
		};
		
		obj.print();
	}

	void print() {
		System.out.println("From AbstractExample6 class implemented method");
		
	}


}
