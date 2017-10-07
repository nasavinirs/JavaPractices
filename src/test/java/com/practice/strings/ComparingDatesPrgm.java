package com.practice.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComparingDatesPrgm {

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of shipments:");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter the shipment details:");
		String input[] = new String[n];
		for (int i = 0; i < n; i++) {
			input[i] = br.readLine();
		}
		
		System.out.println("Shipments that are arrived on same day:");
		for (int i = 0; i < input.length; i++) {
			String split[] = input[i].split(",");
			if(split[1].compareTo(split[2]) == 0) {
				System.out.println(split[0]);
			}
		}
	}

}
