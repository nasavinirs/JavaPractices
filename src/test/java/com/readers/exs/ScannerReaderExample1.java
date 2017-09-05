package com.readers.exs;

import java.util.Scanner;

public class ScannerReaderExample1 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
        System.out.print("Enter an integer : ");
        int a = scn.nextInt();
        System.out.print("Enter a String : ");
        String b = scn.nextLine();
        System.out.printf("You have entered:- "
                + a + " " + "and name as " + b);
		
	}

}
