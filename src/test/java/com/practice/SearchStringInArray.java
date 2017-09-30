package com.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchStringInArray {

	public static void main(String[] args) {
		ArrayList<String> name = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		int countOfCustomers = Integer.parseInt(sc.nextLine());
		boolean isFound = false;

		for (int i = 0; i < countOfCustomers; i++) {
			name.add(sc.nextLine());
		}
		System.out.println("Enter the name you want to search");
		String nameToSearch = sc.nextLine();

		for (int i = 0; i < countOfCustomers; i++) {
			if (name.get(i).equalsIgnoreCase(nameToSearch)) {
				isFound = true;
				break;
			}

		}
		if (isFound)
			System.out.println(nameToSearch + " found!");
		else
			System.out.println(nameToSearch + " not found");

	}

}
