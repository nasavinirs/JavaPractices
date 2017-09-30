package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Port {
	int id;
	String name;
	String country;

	public Port(int id, String name) {
		this.id = id;
		this.name = name;
		this.country = "India";
	}

	public Port(int id, String name, String country) {
		this.id = id;
		this.name = name;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return String.format("%-15s %-15s %-15s", id, name, country);
	}

}

public class DisplayPortDetails {

	public static void main(String[] args) throws Exception {
		int id = 0;
		String name = null;
		String country = "India";
		String option;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of ports");
		int no = Integer.parseInt(br.readLine());
		Port port[] = new Port[no];
		for (int i = 0; i < no; i++) {
			System.out.println("Enter the port" + (i + 1) + " details");
			id = Integer.parseInt(br.readLine());
			name = br.readLine();
			System.out.println("Is the port from same country[Y/N]");
			option = br.readLine();
			if (option.equals("N")) {
				System.out.println("Enter the country");
				port[i] = new Port(id, name, br.readLine());
				continue;
			}
			port[i] = new Port(id, name);
		}
		System.out.println("The port details are");
		System.out.println("Id              Name            Country        ");
		for (int i = 0; i < port.length; i++) {
			System.out.println(port[i]);
		}
		br.close();
	}

}
