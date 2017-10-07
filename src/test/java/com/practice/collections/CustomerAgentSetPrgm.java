package com.practice.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Shipment {
	String shipmentName;
	String agentName;
	String customerName;

	public Shipment() {

	}

	public Shipment(String shipmentName, String customerName, String agentName) {
		this.shipmentName = shipmentName;
		this.agentName = agentName;
		this.customerName = customerName;
	}

	public String getShipmentName() {
		return shipmentName;
	}

	public void setShipmentName(String shipmentName) {
		this.shipmentName = shipmentName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return String.format("%-15s%-15s%-15s", shipmentName, customerName, agentName);
	}

}

public class CustomerAgentSetPrgm {

	public static void main(String[] args) throws IOException {
		List<Shipment> shipmentList = new ArrayList<Shipment>();
		Set<String> customer = new TreeSet<String>();
		Set<String> agent = new TreeSet<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of shipment:");
		int n = Integer.parseInt(br.readLine());
		String input[];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter shipment " + (i + 1) + " details:");
			input = br.readLine().split(",");
			shipmentList.add(new Shipment(input[0], input[1], input[2]));
			customer.add(input[1]);
			agent.add(input[2]);
		}
		System.out.println("Shipment details:");
		System.out.format("%-15s%-15s%-15s\n", "Shipment name", "Customer name", "Agent name");
		for (Shipment ship : shipmentList) {
			System.out.println(ship);
		}

		System.out.println("Unique customer name:");
		Iterator<String> itr1 = customer.iterator();
		while (itr1.hasNext()) {
			System.out.println(itr1.next());
		}
		System.out.println("Unique agent name:");
		Iterator<String> itr2 = agent.iterator();
		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}
	}

}
