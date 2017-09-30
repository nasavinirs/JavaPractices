package com.practice;

import java.util.Scanner;

public class MultiPortExample {

	public static void main(String[] args) {
		int intNumber;
		int intCount;
		Boolean blnOneMode = false;
		Boolean blnOneDisplay = true;
		Boolean blnMoreDisplay = true;
		Boolean blnMoreMode = false;
		String[] strCurrentString;
		String strId;
		String strName;
		String strRail;
		String strRoad;
		String strAir;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of ports :");
		intNumber = scanner.nextInt();
		scanner.nextLine();
		String[] strInput = new String[intNumber];
		System.out.println("Enter port details :");
		for (int i = 0; i < intNumber; i++) {

			strInput[i] = scanner.nextLine();
		}
		// scanner.nextLine();
		System.out.println("One mode of transportation :");
		for (int j = 0; j < intNumber; j++) {
			intCount = 0;
			strCurrentString = strInput[j].split("\\|");
			strId = strCurrentString[0];
			strName = strCurrentString[1];
			strRail = strCurrentString[2];
			strRoad = strCurrentString[3];
			strAir = strCurrentString[4];

			if (strRail.equalsIgnoreCase("1")) {
				intCount = intCount + 1;
			}
			if (strRoad.equalsIgnoreCase("1")) {
				intCount = intCount + 1;
			}
			if (strAir.equalsIgnoreCase("1")) {
				intCount = intCount + 1;
			}
			if (intCount == 1) {
				if (blnOneDisplay) {
					System.out.format("%-5s%s\n", "Id", "Name");
					blnOneDisplay = false;
				}
				System.out.format("%-5s%s\n", strId, strName);
				blnOneMode = true;
			}
		}
		if (!blnOneMode) {
			System.out.println("No such transportation available");
		}
		System.out.println("More than one mode of transportation :");
		for (int j = 0; j < intNumber; j++) {
			intCount = 0;
			strCurrentString = strInput[j].split("\\|");
			strId = strCurrentString[0];
			strName = strCurrentString[1];
			strRail = strCurrentString[2];
			strRoad = strCurrentString[3];
			strAir = strCurrentString[4];
			if (strRail.equalsIgnoreCase("1")) {
				intCount = intCount + 1;
			}
			if (strRoad.equalsIgnoreCase("1")) {
				intCount = intCount + 1;
			}
			if (strAir.equalsIgnoreCase("1")) {
				intCount = intCount + 1;
			}
			if (intCount > 1) {
				if (blnMoreDisplay) {
					System.out.format("%-5s%s\n", "Id", "Name");
					blnMoreDisplay = false;
				}
				System.out.format("%-5s%s\n", strId, strName);
				blnMoreMode = true;
			}
		}

		if (!blnMoreMode) {
			System.out.println("No such transportation available");
		}
		scanner.close();
	}

}
