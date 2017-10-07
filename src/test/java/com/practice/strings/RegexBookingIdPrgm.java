package com.practice.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegexBookingIdPrgm {

	public static void main(String[] args) throws IOException {
		String regex = "\\d+";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the generated booking id");
		String input = br.readLine();
		if(input.matches(regex)) {
			System.out.println("Generated booking id is valid ");
		} else {
			System.out.println("Generated booking id is not valid");
		}

	}

}
