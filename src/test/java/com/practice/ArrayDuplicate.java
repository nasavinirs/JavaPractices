package com.practice;

import java.util.ArrayList;

public class ArrayDuplicate {

	public static void main(String[] args) {
		String[] array = {"abc", "def", "ghi", "abc", "jkl", "def", "nmo"};
		ArrayList<String> duplicate = new ArrayList<String>();
		
		System.out.println("All elements in array");		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i+1; j < array.length; j++) {
				if ((array[i].equalsIgnoreCase(array[j])) && (i != j)) {
					duplicate.add(array[i]);
				}
			}
		}

		System.out.println("\nDuplicate elements in array");
		for (String value : duplicate) {
			System.out.print(value + " ");
		}
		
	}
}
