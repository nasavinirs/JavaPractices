package com.practice;

public class PrintNumbers {

	public static void main(String[] args) {
		System.out.println("1st way to print 1 to 100 without loops"); 
		usingSysOut(); 
		
		System.out.println("2nd way to print 1 to 100 without using loops"); 
		usingSysPrint(); 
		
		System.out.println("3rd way to print 1 to 100 without loops"); 
		usingRecursion(10);

	}
	
	public static void usingSysOut() { 
		System.out.println(1); 
		System.out.println(2); 
		System.out.println(3); 
		System.out.println(4); 
		System.out.println(5); 
		System.out.println(6); 
		System.out.println(7); 
		System.out.println(8); 
		System.out.println(9); 
		System.out.println(10); 
	}
	
	public static void usingSysPrint() { 
		System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n" + "%s%n%s%n%s%n%s%n", 
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10); 
	}

	public static void usingRecursion(int number) { 
		if(number > 1) { 
			usingRecursion(number-1); 
		} 
		System.out.println(number); 
	}

}
