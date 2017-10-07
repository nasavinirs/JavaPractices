package com.practice.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCasePrgm {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the username");
		String input = br.readLine();
		System.out.println("Formatted username");
		System.out.println(input.toLowerCase());
	}

}
