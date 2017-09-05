package com.practice;

public class BlankFinalExample {

	final int a;
	
	public BlankFinalExample()
	{
		a = 10;
	}
	
	public BlankFinalExample(int v)
	{
		a = v;
	}
	
	public void printA()
	{
		System.out.println("Value is : " + a);
	}
	
	public static void main(String args[]) {
		BlankFinalExample f1 = new BlankFinalExample();
		BlankFinalExample f2 = new BlankFinalExample(100);
		
		f1.printA();
		f2.printA();
	}
}
