package com.practice.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Port {
	String country;
	String portId;
	String name;

	public Port() {

	}

	public Port(String country, String portId, String name) {
		this.country = country;
		this.portId = portId;
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPortId() {
		return portId;
	}

	public void setPortId(String portId) {
		this.portId = portId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class PortUploadCSVPrgm {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of ports:");
		int n = Integer.parseInt(br.readLine());
		String input[] = new String[n];
		String split[];
		Port[] port = new Port[n];
		System.out.println("Enter the port details:");
		for (int i = 0; i < n; i++) {
			input[i] = br.readLine();
			split = input[i].split(",");
			port[i] = new Port(split[0], split[1], split[2]);
		}
		System.out.println("Port details are");
		System.out.println(String.format("%-15s%-15s%s", "Country", "Port Id", "Port Name"));
		for (int i = 0; i < port.length; i++) {
			System.out.println(String.format("%-15s%-15s%s", port[i].getCountry(), port[i].getPortId(), port[i].getName()));
		}
	}

}
