package com.practice.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class EliminateDuplicateInvoiceIdPrgm {

	public static void main(String[] args) throws IOException {
		TreeSet<Integer> tset = new TreeSet<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of invoice id :");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter the invoice id :");
		for (int i = 0; i < n; i++) {
			tset.add(Integer.parseInt(br.readLine()));
		}
		System.out.println("Invoice id without duplicate values :");
		Iterator<Integer> itr = tset.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
