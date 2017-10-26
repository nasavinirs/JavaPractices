package com.practice.oopsproblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


abstract class ShipmentEntity {
	protected String name;
	protected Double weight;
	protected Integer quantity;
	protected Double transferCost;
	protected Double maxShipmentCapacity;
	
	
	public ShipmentEntity(String name, Double weight, Integer quantity, Double transferCost,
			Double maxShipmentCapacity) {
		this.name = name;
		this.weight = weight;
		this.quantity = quantity;
		this.transferCost = transferCost;
		this.maxShipmentCapacity = maxShipmentCapacity;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getWeight() {
		return weight;
	}
	
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Double getTransferCost() {
		return transferCost;
	}
	
	public void setTransferCost(Double transferCost) {
		this.transferCost = transferCost;
	}
	
	public Double getMaxShipmentCapacity() {
		return maxShipmentCapacity;
	}
	
	public void setMaxShipmentCapacity(Double maxShipmentCapacity) {
		this.maxShipmentCapacity = maxShipmentCapacity;
	}
	
	abstract void calculateCost();
	abstract void operatingCapacity();

}


class CustomerShipment extends ShipmentEntity {
	private Double referalFee;

	
	public CustomerShipment(String name, Double weight, Integer quantity, Double transferCost,
			Double maxShipmentCapacity, Double referalFee) {
		super(name, weight, quantity, transferCost, maxShipmentCapacity);
		this.referalFee = referalFee;
	}

	public Double getReferalFee() {
		return referalFee;
	}

	public void setReferalFee(Double referalFee) {
		this.referalFee = referalFee;
	}

	public void calculateCost(){
		double amount = weight * quantity * transferCost;
		double totalAmount = amount + referalFee;
		System.out.println("Cost for the shipment is " + totalAmount);
	}
	
	public void operatingCapacity(){
		double capacity = weight * quantity;
		if (capacity > maxShipmentCapacity) {
			System.out.println("The shipment is not within the shipping capacity of the agent");
		} else {
			System.out.println("The shipment is within the shipping capacity of the agent");
		}
	}
}


class CompanyShipment extends ShipmentEntity {
	private Integer tax;

	public CompanyShipment(String name, Double weight, Integer quantity, Double transferCost, Double maxShipmentCapacity,
			Integer tax) {
		super(name, weight, quantity, transferCost, maxShipmentCapacity);
		this.tax = tax;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}
	
	public void calculateCost(){
		double amount = weight * quantity * transferCost;
		double taxApplied = (tax / 100.0);
		double totalTax = amount * taxApplied;
		double totalAmount = amount + totalTax;
		System.out.println("Cost for the shipment is " + totalAmount);
	}
	
	public void operatingCapacity(){
		double capacity = weight * quantity;
		if (capacity > maxShipmentCapacity) {
			System.out.println("The shipment is not within the shipping capacity of the company");
		} else {
			System.out.println("The shipment is within the shipping capacity of the company");
		}
	}
}


public class AbstractShipmentEntity {

	public static void main(String[] args) throws NumberFormatException, IOException {
		ShipmentEntity shipmentEntity = null;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1. Customer Shipment\n2. Company Shipment\nEnter your choice :");
		Integer choice = Integer.parseInt(buf.readLine());
		if(choice <= 2){
			System.out.println("Enter the name :");
			String name = buf.readLine();
			System.out.println("Enter the weight :");
			Double weight = Double.parseDouble(buf.readLine());
			System.out.println("Enter the quantity :");
			Integer quantity = Integer.parseInt(buf.readLine());
			System.out.println("Enter the shipment transfer cost :");
			Double transferCost = Double.parseDouble(buf.readLine());
			System.out.println("Enter the maximum shipment capacity :");
			Double maxShipmentCapacity = Double.parseDouble(buf.readLine());
			switch(choice) {
				case 1:
						System.out.println("Enter the referal fee :");
						Double referalFee = Double.parseDouble(buf.readLine());
						shipmentEntity = new CustomerShipment(name, weight, quantity, transferCost, maxShipmentCapacity, referalFee);
						break;
				case 2:
						System.out.println("Enter the tax percentage:");
						Integer tax = Integer.parseInt(buf.readLine());
						shipmentEntity = new CompanyShipment(name, weight, quantity, transferCost, maxShipmentCapacity, tax);
						break;
			}
			   shipmentEntity.calculateCost();
			   shipmentEntity.operatingCapacity();
		}
		else{
			System.out.println("Invalid Input");
		}
	}
}
