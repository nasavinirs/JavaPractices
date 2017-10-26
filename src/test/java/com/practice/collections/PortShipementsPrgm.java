package com.practice.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PortShipementsPrgm {

	public static void main(String[] args) throws IOException {
		Map<Integer,Integer> mymap = new HashMap<Integer,Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of shipments");
		int n = Integer.parseInt(br.readLine());
		String input[];
		System.out.println("Enter shipment details");
		
		
		System.out.format("%-15s%-15s%", "Port Id", "Number of Shipments");
	}

}
