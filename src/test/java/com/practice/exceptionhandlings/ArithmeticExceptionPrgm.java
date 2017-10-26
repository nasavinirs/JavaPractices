package com.practice.exceptionhandlings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArithmeticExceptionPrgm {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter the container price :");
			int price = Integer.parseInt(br.readLine());
			System.out.println("Enter the number of items in the container :");
			int items = Integer.parseInt(br.readLine());
			int averagePrice = price / items;
			System.out.println("The average price of the item is Rs." + averagePrice);
		} catch (ArithmeticException aex) {
			System.out.println("Exception : java.lang.ArithmeticException");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
