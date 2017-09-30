package com.practice;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to find as prime :");
		int num = sc.nextInt();
		int sum = 0, temp;
		System.out.println("Actual Number is : " + num);
		while (num > 0) {
			temp = num % 10;
			sum += temp;
			num = num / 10;
		}
		System.out.println("Sum of the digits is : " + sum);
		for (int i = 2; i < sum; i++) {
			if (sum % i == 0) {
				flag = false;
			}
		}

		if (flag) {
			System.out.println("Number is prime");
		} else {
			System.out.println("Number is not prime");
		}

	}

}
