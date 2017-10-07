package com.practice.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MyOwnInteger implements Comparable<MyOwnInteger> {
	Integer number;

	public MyOwnInteger(Integer number) {
		this.number = number;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public int compareTo(MyOwnInteger o) {
		return this.number > o.number ? 1 : this.number < o.number ? -1 : 0;
	}

	@Override
	public String toString() {
		return number.toString();
	}

}

public class IntegerListsSortPrgm {

	public static void main(String[] args) throws IOException {
		List<MyOwnInteger> list = new ArrayList<MyOwnInteger>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter n");
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			list.add(new MyOwnInteger(Integer.parseInt(br.readLine())));
		}
		Collections.sort(list);
		System.out.println(list);
	}

}
