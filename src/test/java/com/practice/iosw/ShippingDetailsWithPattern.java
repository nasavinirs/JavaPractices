package com.practice.iosw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShippingDetailsWithPattern {
	private static final String INPUTFILE = "src/test/java/com/practice/iosw/shpin.txt";
	private static final String PATTERN = ".*55.*55.*";

	public static void main(String[] args) {
		Pattern regexPattern;
		Matcher regMatcher;
		String sCurrentLine, splitStr[];
		regexPattern = Pattern.compile(PATTERN);
		try (BufferedReader br = new BufferedReader(new FileReader(INPUTFILE))) {
			while ((sCurrentLine = br.readLine()) != null) {
				splitStr = sCurrentLine.split(",");
				regMatcher = regexPattern.matcher(splitStr[1]);
				if (regMatcher.matches()) {
					System.out.println(splitStr[0]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
