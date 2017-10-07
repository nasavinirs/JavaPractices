package com.practice.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringEqualsPrgm {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the document 1 content:");
		String input1 = br.readLine();
		System.out.println("Enter the document 2 content:");
		String input2 = br.readLine();	
		if(input1.equals(input2)) {
			System.out.println("Green");
		} else if (input1.equalsIgnoreCase(input2)) {
			System.out.println("Blue");
		} else if (input1.replaceAll(" ", "").equals(input2) || input1.equals(input2.replaceAll(" ", ""))) {
			System.out.println("Orange");
		} else if (!input1.equals(input2) || !input1.equalsIgnoreCase(input2)) {
			System.out.println("Red");
		}
	}

}
