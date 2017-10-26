package com.practice.exceptionhandlings;

import java.text.*;
import java.io.*;

class ContainerOverloadedException extends Exception {

	private static final long serialVersionUID = 1L;

	public ContainerOverloadedException(String message) {
		super(message);
	}
}

class Commodity {
	String commodityId;
	Float totalWeight;
	Integer quantity;

	public Commodity(String commodityId, Float totalWeight, Integer quantity) {
		super();
		this.commodityId = commodityId;
		this.totalWeight = totalWeight;
		this.quantity = quantity;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public Float getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(Float totalWeight) {
		this.totalWeight = totalWeight;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}

class Container {
	String number;
	Float containerWeight;
	Commodity[] commodities;

	public Container(String number, Float containerWeight, Commodity[] commodities) {
		super();
		this.number = number;
		this.containerWeight = containerWeight;
		this.commodities = commodities;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Float getContainerWeight() {
		return containerWeight;
	}

	public void setContainerWeight(Float containerWeight) {
		this.containerWeight = containerWeight;
	}

	public Commodity[] getCommodities() {
		return commodities;
	}

	public void setCommodities(Commodity[] commodities) {
		this.commodities = commodities;
	}

	public void displayDetails() {
		DecimalFormat df = new DecimalFormat("0");
		Commodity[] commodities = getCommodities();

		for (int i = 0; i < getCommodities().length; i++) {
			System.out.format("%-15s%-15s%s\n", commodities[i].getCommodityId(),
					df.format(commodities[i].getTotalWeight()), commodities[i].getQuantity());
		}

	}
}

class ShipmentBO1 {
	public void validate(Container container, Commodity[] commodity) throws ContainerOverloadedException {
		Float weight = (float) 0;
		for (int i = 0; i < commodity.length; i++) {
			weight += commodity[i].totalWeight;
		}
		if (weight > container.containerWeight) {
			throw new ContainerOverloadedException("Container is overloaded");
		} 
	}
}

public class ContainerOverloadedExceptionPrgm {

	public static void main(String[] args) {
		try {
			ShipmentBO1 shipmentBO = new ShipmentBO1();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the container number :");
			String containerNo = br.readLine();
			System.out.println("Enter the capacity of container :");
			Float capacity = Float.parseFloat(br.readLine());
			System.out.println("Enter the number of commodities :");
			int num = Integer.parseInt(br.readLine());
			System.out.println("Enter the commodities :");
			Commodity[] commodities = new Commodity[num];
			String[] input;
			for (int i = 0; i < num; i++) {
				input = br.readLine().split(",");
				commodities[i] = new Commodity(input[0], Float.parseFloat(input[1]), Integer.parseInt(input[2]));
			}
			Container container = new Container(containerNo, capacity, commodities);
			shipmentBO.validate(container, commodities);
			System.out.println("Commodity details are");
			System.out.format("%-15s%-15s%s\n", "Id", "Weight", "Quantity");
			container.displayDetails();
		} catch (ContainerOverloadedException coe) {
			System.out.println("ContainerOverloadedException: Container is overloaded");
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

	}

}
