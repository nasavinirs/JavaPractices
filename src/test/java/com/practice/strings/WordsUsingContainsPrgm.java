package com.practice.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordsUsingContainsPrgm {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the file content:");
		String input = br.readLine();
		System.out.println("Enter the virus keyword:");
		String findStr = br.readLine().trim();
		if(input.contains(findStr)) {
			System.out.println("Virus " + findStr + " is present");
		} else {
			System.out.println("Virus " + findStr + " is not present");
		}
	}

}
