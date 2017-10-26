package com.practice.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TagLengthPrgm {

	public static void main(String[] args) throws IOException {
		List<String> strList = new ArrayList<String>();
		List<Integer> lenList = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the xml input");
		String input = br.readLine();
		char startChar = input.charAt(0);
		char endChar = input.charAt(9);
		System.out.format("%-15s %-15s\n","Tag Name","Length");
		System.out.println(startChar);
		System.out.println(endChar);
	}

}
