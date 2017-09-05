package com.practice;

public class ReverseAString {

	public static void main(String[] args) {
		String str = "Hello World!";
		String specialStr = "HeLLo WoRlD";
		char[] revStr = str.toCharArray();
		System.out.println("String is : " + str);
		System.out.print("Reverse String is : ");
		for (int i = revStr.length - 1; i >= 0; i--) {
			System.out.print(revStr[i]);
		}

		System.out.print("\nString is Case Changed: ");
		for (int i = 0; i < str.length(); i++) {
			char aChar = str.charAt(i);
			if (65 <= aChar && aChar <= 90) {
				aChar = (char) (aChar + 32);
			} else if (97 <= aChar && aChar <= 122) { 
				aChar = (char) (aChar - 32);
			}
			System.out.print(aChar);
		}

		System.out.print("\nSpecial String is : " + specialStr);
		System.out.print("\nSpecial String is Case Changed: ");
		for (int i = 0; i < specialStr.length(); i++) {
			char aChar = specialStr.charAt(i);
			if (65 <= aChar && aChar <= 90) {
				aChar = (char) (aChar + 32);
			} else if (97 <= aChar && aChar <= 122) { 
				aChar = (char) (aChar - 32);
			}
			System.out.print(aChar);
		}

		
		System.out.print("\nString Reverse without space and special chars position change: ");
		for (int i = revStr.length - 1; i >= 0; i--) {
			System.out.print(revStr[i]);
		}
	}
}
