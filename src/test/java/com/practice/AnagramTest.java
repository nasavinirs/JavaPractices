package com.practice;

import java.util.Arrays;

public class AnagramTest {

	public void anagramTest(String s1, String s2) {

		String s1Copy = s1.replaceAll("\\s", "").toLowerCase();
		String s2Copy = s2.replaceAll("\\s", "").toLowerCase();
		boolean status = true;
		
		if (s1Copy.length() != s2Copy.length()) {
			status = false;
		}
		else {
			char[] s1CharArray = s1Copy.toCharArray();
			char[] s2CharArray = s2Copy.toCharArray();
			Arrays.sort(s1CharArray);
			Arrays.sort(s2CharArray);
			
			status = Arrays.equals(s1CharArray, s2CharArray);
			
		}
		
		if (status) {
			System.out.println(s1 + " and " + s2 + " are both anagrams");
		} else {
			System.out.println(s1 + " and " + s2 + " are not anagrams");
		}

	}

	public static void main(String[] args) {

		AnagramTest aTest = new AnagramTest();
		aTest.anagramTest("SiLeNt CAT", "LisTen AcT");
		
	}

}
