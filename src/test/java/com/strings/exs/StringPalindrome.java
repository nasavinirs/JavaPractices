package com.strings.exs;

import java.util.Scanner;

public class StringPalindrome {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter String to find whether its palindrome or not : ");
		String inputString = scan.nextLine();
		String reverseString = "";
		for(int i = inputString.length() - 1; i >=0 ; i--) {
			reverseString += inputString.charAt(i);
		}
		
		if(inputString.equals(reverseString))
			System.out.println(inputString + " is palindrome");
		else
			System.out.println(inputString + " is not palindrome");
	}

}
