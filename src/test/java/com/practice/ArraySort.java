package com.practice;

import java.util.*;

public class ArraySort {

	public static void main(String[] args) {
		int arr[] = {10, -1, 6, 8, 2, 0};
		
		System.out.print("Before Sorting : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\nAscending Order : ");
		Arrays.sort(arr); // Using java.util.Arrays class and sort() method
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.print("\nDescending Order : ");
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
			

	}
}