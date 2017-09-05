package com.readers.exs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderExample1 {

	public static void main(String arg[]) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter an integer : ");
	        int a = Integer.parseInt(br.readLine());
	        System.out.print("\nEnter a String : ");
	        String b = br.readLine();
	        System.out.printf("You have entered:- " + a +
	                          " and name as " + b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
