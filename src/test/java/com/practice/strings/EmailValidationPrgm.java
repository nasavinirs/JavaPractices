package com.practice.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmailValidationPrgm {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the email id");
		String input = br.readLine();
		String valid = input.substring(input.indexOf('.') + 1, input.length());
		if (valid.equals("com") || valid.equals("net") || valid.equals("bix") || valid.equals("org")) {
			System.out.println("Valid domain");
		} else {
			System.out.println("Not a valid domain");
		}
	}

}
