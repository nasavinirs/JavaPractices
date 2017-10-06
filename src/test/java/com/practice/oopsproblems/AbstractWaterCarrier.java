package com.practice.oopsproblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

abstract class WaterCarrier {
	protected String carrierName;
	protected String carrierCode;
	protected String carrierType;
	protected String iataCode;
	protected String carrierAddress;

	public WaterCarrier() {

	}

	public WaterCarrier(String carrierName, String carrierCode, String iataCode, String carrierAddress,
			String carrierType) {
		super();
		this.carrierName = carrierName;
		this.carrierCode = carrierCode;
		this.iataCode = iataCode;
		this.carrierAddress = carrierAddress;
		this.carrierType = carrierType;
	}

	public String getCarrierType() {
		return carrierType;
	}

	public void setCarrierType(String carrierType) {
		this.carrierType = carrierType;
	}

	public String getCarrierAddress() {
		return carrierAddress;
	}

	public void setCarrierAddress(String carrierAddress) {
		this.carrierAddress = carrierAddress;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	static WaterCarrier createShip(String carrierName, String carrierCode, String iataCode, String carrierAddress,String carrierType,Integer capacity) {
		
		WaterCarrier carrier = null;

		if(carrierType.equals("BulkShip") || carrierType.equals("Cargo")) {
			carrier = new BulkShip(carrierName, carrierCode, iataCode, carrierAddress, carrierType, capacity);
		} else if(carrierType.equals("ContainerShip") || carrierType.equals("Container")) {
			carrier = new ContainerShip(carrierName, carrierCode, iataCode, carrierAddress, carrierType, capacity);
		} else if(carrierType.equals("Ferries") || carrierType.equals("Ferry")) {
			carrier = new Ferry(carrierName, carrierCode, iataCode, carrierAddress, carrierType, capacity);
		}
		
		return carrier;
	}
	
	static String returnOwner(WaterCarrier waterCarrier) {
		if (waterCarrier.carrierType.equals("BulkShip") || waterCarrier.carrierType.equals("ContainerShip"))
			return "Company";
		else
			return "Agent";
	}
	
	public abstract void displayShipDetails();
}

class BulkShip extends WaterCarrier {
	Integer noOfcargoes;

	public BulkShip() {

	}

	public BulkShip(String carrierName, String carrierCode, String iataCode, String carrierAddress, String carrierType,
			Integer noOfcargoes) {
		super(carrierName, carrierCode, iataCode, carrierAddress, carrierType);
		this.noOfcargoes = noOfcargoes;
	}

	public Integer getNoOfcargoes() {
		return noOfcargoes;
	}

	public void setNoOfcargoes(Integer noOfcargoes) {
		this.noOfcargoes = noOfcargoes;
	}

	@Override
	public void displayShipDetails() {
		
		System.out.format("%-20s%-15s%-15s%-15s%-15s%-25s%s\n", carrierType, carrierName, carrierCode, iataCode, carrierAddress, noOfcargoes + " cargoes", WaterCarrier.returnOwner(this));
	}
}

class Ferry extends WaterCarrier {
	Integer maxLoad;

	public Ferry() {

	}

	public Ferry(String carrierName, String carrierCode, String iataCode, String carrierAddress, String carrierType,
			Integer maxLoad) {
		super(carrierName, carrierCode, iataCode, carrierAddress, carrierType);
		this.maxLoad = maxLoad;
	}

	public Integer getMaxLoad() {
		return maxLoad;
	}

	public void setMaxLoad(Integer maxLoad) {
		this.maxLoad = maxLoad;
	}

	@Override
	public void displayShipDetails() {
		
		System.out.format("%-20s%-15s%-15s%-15s%-15s%-25s%s\n", carrierType, carrierName, carrierCode, iataCode, carrierAddress, maxLoad + " kilograms", WaterCarrier.returnOwner(this));
	}
}

class ContainerShip extends WaterCarrier {
	Integer noOfContainers;

	public ContainerShip() {

	}

	public ContainerShip(String carrierName, String carrierCode, String iataCode, String carrierAddress,
			String carrierType, Integer noOfContainers) {
		super(carrierName, carrierCode, iataCode, carrierAddress, carrierType);
		this.noOfContainers = noOfContainers;
	}

	public Integer getNoOfContainers() {
		return noOfContainers;
	}

	public void setNoOfContainers(Integer noOfContainers) {
		this.noOfContainers = noOfContainers;
	}

	@Override
	public void displayShipDetails() {
		
		System.out.format("%-20s%-15s%-15s%-15s%-15s%-25s%s\n", carrierType, carrierName, carrierCode, iataCode, carrierAddress, noOfContainers + " containers", WaterCarrier.returnOwner(this));
	}
}

public class AbstractWaterCarrier {

	public static void main(String args[])throws IOException {
		String input[];		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of carriers :");
		int n = Integer.parseInt(br.readLine());
		WaterCarrier[] carrier = new WaterCarrier[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the carrier " + (i+1) + " details :");
			input = br.readLine().split(",");
			carrier[i] = WaterCarrier.createShip(input[0], input[1], input[2], input[3], input[4], Integer.parseInt(input[5]));
		}
		System.out.println("Ship details are");
		System.out.format("%-20s%-15s%-15s%-15s%-15s%-25s%s\n","Carrier type","Name","Code","IATAcode","Location","Capacity","OwnedBy");
		for (int i = 0; i < carrier.length; i++) {
			carrier[i].displayShipDetails();
		}
		br.close();
	}

}
