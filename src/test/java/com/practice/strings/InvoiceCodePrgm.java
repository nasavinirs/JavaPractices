package com.practice.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InvoiceCodePrgm {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the invoice code");
		String input = br.readLine();
		String words = input.replaceAll("\\d", "");
		String digits = input.replaceAll("\\D", "");
		if (words.equalsIgnoreCase("CU")) {
			sb.append("CUT");
		} else if (words.equalsIgnoreCase("AT")) {
			sb.append("AGT");
		} else if (words.equalsIgnoreCase("CY")) {
			sb.append("CMY");
		}
		if (digits.length() == 1) {
			sb.append("0000" + digits);
		} else if (digits.length() == 2) {
			sb.append("000" + digits);
		} else if (digits.length() == 3) {
			sb.append("00" + digits);
		} else if (digits.length() == 4) {
			sb.append("0" + digits);
		} else if (digits.length() == 5) {
			sb.append(digits);
		}

		System.out.println("Formated Code :");
		System.out.println(sb.toString());
	}

}
