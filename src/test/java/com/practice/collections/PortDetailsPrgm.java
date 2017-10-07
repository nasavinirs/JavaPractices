package com.practice.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Port {
	Integer id;
	String name;
	String city;

	public Port() {

	}

	public Port(Integer id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return String.format("%-15s%-15s%-15s", id, name, city);
	}

}

public class PortDetailsPrgm {

	public static void main(String[] args) throws IOException {
		String[] split;
		List<Port> list = new ArrayList<Port>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of port details");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter the port details");
		String input[] = new String[n];
		for (int i = 0; i < n; i++) {
			input[i] = br.readLine();
			split = input[i].split(",");
			list.add(new Port(Integer.parseInt(split[0]), split[1], split[2]));
		}
		System.out.format("%-15s%-15s%-15s\n", "Port Id", "Name", "Location");
		for (Port port : list) {
			System.out.println(port);
		}
		System.out.println("Enter the position");
		n = Integer.parseInt(br.readLine());
		System.out.println("Enter port detail to be inserted");
		String newInput = br.readLine();
		split = newInput.split(",");
		list.add(n-1, new Port(Integer.parseInt(split[0]), split[1], split[2]));
		System.out.println("After the insertion of port details");
		System.out.format("%-15s%-15s%-15s\n", "Port Id", "Name", "Location");
		for (Port port : list) {
			System.out.println(port);
		}
	}

}
