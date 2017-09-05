package com.strings.exs;

public class StringReverse {

	public static void main(String[] args) {
		
		String input = "Welcome";
		String output = "";
					
		System.out.println("Before Reverse : " + input);
		
		System.out.println("String reverse using StringBuffer : " + new StringBuffer(input).reverse());
		System.out.println("String reverse using StringBuilder : " + new StringBuilder(input).reverse());
		
		for (int i = input.length() - 1; i >= 0 ; i--) {
			output = output + input.charAt(i);
		}
		System.out.println("After Reverse : " + output);
	}

}
