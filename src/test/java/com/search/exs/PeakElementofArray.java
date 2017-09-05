package com.search.exs;

/**
 * A peak element of an array is that element which is not smaller than its neighbors.
 * The time complexity of the following program is O (n).
 * @author 309934
 *
 */
public class PeakElementofArray {

	public static void main(String[] args) {
		int input[] = { 1, 3, 2, 4, 6, 23, 25, 24, 26, 1};

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();
		for (int i = 1; i <= input.length; i++) {
			if (i == input.length - 1) {
				break;
			} else {
				if ((input[i - 1] <= input[i]) && (input[i] >= input[i + 1])) {
					System.out.println(input[i] + " at position " + i);
				}
			}
		}
	}
}
