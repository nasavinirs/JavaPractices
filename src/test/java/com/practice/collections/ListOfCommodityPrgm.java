package com.practice.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Commodity {
	String commodityName;
	String quantity;
	String totalvalue;
	String totalWeight;
	String hazardous;

	public Commodity() {

	}

	public Commodity(String commodityName, String quantity, String totalvalue, String totalWeight, String hazardous) {
		this.commodityName = commodityName;
		this.quantity = quantity;
		this.totalvalue = totalvalue;
		this.totalWeight = totalWeight;
		this.hazardous = hazardous;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTotalvalue() {
		return totalvalue;
	}

	public void setTotalvalue(String totalvalue) {
		this.totalvalue = totalvalue;
	}

	public String getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(String totalWeight) {
		this.totalWeight = totalWeight;
	}

	public String getHazardous() {
		return hazardous;
	}

	public void setHazardous(String hazardous) {
		this.hazardous = hazardous;
	}

	@Override
	public String toString() {
		return String.format("%-15s%-15s%-15s%-15s%s", commodityName, quantity, totalvalue, totalWeight, hazardous);
	}

}

public class ListOfCommodityPrgm {

	public static void main(String[] args) throws IOException {
		String[] split;
		List<Commodity> list = new ArrayList<Commodity>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of commodities:");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter the commodity details");
		String input[] = new String[n];
		for (int i = 0; i < n; i++) {
			input[i] = br.readLine();
			split = input[i].split(",");
			if(split[4].equalsIgnoreCase("True"))
				split[4] = "Yes";
			else
				split[4] = "No";
			list.add(new Commodity(split[0], split[1], split[2], split[3], split[4]));
		}
		System.out.println("Commodity details are:");
		System.out.println(String.format("%-15s%-15s%-15s%-15s%s", "Commodity Name", "Quantity", "Total Value",
				"TotalWeight", "Hazardous"));
		for (Commodity commodity : list) {
			System.out.println(commodity);
		}
	}

}
