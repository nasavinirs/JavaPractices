package com.search.exs;

/***
 * Linear Search algorithm The worst case complexity of linear search is O(n).
 * 
 * @author 309934
 *
 */
public class LinearSearchEx {

	public static void main(String[] args) {
		int comp = 0, index = -1, find = 8;
		int input[] = { 1, 4, 6, 3, 8, 9, 12 };

		for (int i = 0; i < input.length; i++) {
			comp++;
			if (find == input[i]) {
				index = i;
				break;
			}
		}

		System.out.println("Item to find : " + find);
		System.out.println("Total comparisons made : " + comp);
		System.out.println("Element found at location : " + index);
	}
}
