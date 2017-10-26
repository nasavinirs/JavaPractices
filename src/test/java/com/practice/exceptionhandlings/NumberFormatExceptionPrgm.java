package com.practice.exceptionhandlings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberFormatExceptionPrgm {

	public static void main(String[] args) {
		int total = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter the total number of items");
			int n = Integer.parseInt(br.readLine());
			int[] items = new int[n];
			for (int i = 0; i < n; i++) {
				try {
					System.out.println("Enter the shipping price of the item " + (i + 1) + " :");
					items[i] = Integer.parseInt(br.readLine());

				} catch (NumberFormatException nfe) {
					System.out.println("Exception : java.lang.NumberFormatException");
					System.out.println("Re-enter the item price :");
					items[i] = Integer.parseInt(br.readLine());
				}
				total += items[i];
			}

			System.out.println("Total cost of the container is " + total);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
