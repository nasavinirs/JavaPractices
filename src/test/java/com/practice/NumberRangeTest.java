package com.practice;

import java.util.Scanner;

public class NumberRangeTest {

	public static void main(String[] args) throws Exception {
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int values[] = new int[n];
		int c025 = 0, c2550 = 0, c50100 = 0, c100500 = 0, c5001k = 0;
		for (int i = 0; i < n; i++) {
			values[i] = sc.nextInt();
			if(values[i] > 0 && values[i] <=25)
				c025++;
			else if(values[i] > 25 && values[i] <=50)
				c2550++;
			else if(values[i] > 50 && values[i] <=100)
				c50100++;
			else if(values[i] > 100 && values[i] <=500)
				c100500++;
			else if(values[i] > 500 && values[i] <=1000)
				c5001k++;
			else {
				System.out.println("Invalid Input");
				flag = false;
				break;
			}
				
		}
		if(flag) {
			System.out.println("The number of items between 0 to 25 :" + c025);
			System.out.println("The number of items between 25 to 50 :" + c2550);
			System.out.println("The number of items between 50 to 100 :" + c50100);
			System.out.println("The number of items between 100 to 500 :" + c100500);
			System.out.println("The number of items between 500 to 1000 :" + c5001k);	
		}
	}

}
