package com.practice.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Port1 implements Comparable<Port1> {

	Integer id;
	String name;
	String country;

	Port1() {
	}

	public Port1(Integer id, String name, String country) {
		this.id = id;
		this.name = name;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return String.format("%-15s%-15s%-15s", id, name, country);
	}

	@Override
	public int compareTo(Port1 o) {
		return this.id - o.id;
	}

	public static Comparator<Port1> PortComparator = new Comparator<Port1>() {

		@Override
		public int compare(Port1 p1, Port1 p2) {
			return p1.getCountry().compareTo(p2.getCountry());
		}
	};

}

class PortByCountry implements Comparator<Port1> {

	@Override
	public int compare(Port1 o1, Port1 o2) {
		return o1.country.compareTo(o2.country);
	}

}

public class ComparePortDetailsPrgm {

	public static void main(String[] args) throws IOException {
		String val, input[];
		List<Port1> list = new ArrayList<Port1>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the port details");
		do {
			input = br.readLine().split(",");
			list.add(new Port1(Integer.parseInt(input[0]), input[1], input[2]));
			System.out.println("Do you want to continue[Yes/No]");
			val = br.readLine();
		} while (val.equalsIgnoreCase("yes"));

		Collections.sort(list, Port1.PortComparator);
		System.out.println("Port details in sorted order");
		System.out.format("%-15s%-15s%-15s\n", "Port Id", "Name", "Country");
		for (Port1 port : list) {
			System.out.println(port);
		}
	}

}
