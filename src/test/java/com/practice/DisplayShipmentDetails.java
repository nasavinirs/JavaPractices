package com.practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Shipment {
	private int id;
	private String shipperName;
	private String modeOfTransportation;
	private float totalWeight;
	private String arrivalPort;
	private String departurePort;
	private static int nextShipmentId = 1000;

	public Shipment(int id, String shipperName, String modeOfTransportation, float totalWeight, String arrivalPort,
			String departurePort) {
		nextShipmentId++;
		this.id = nextShipmentId;
		this.shipperName = shipperName;
		this.modeOfTransportation = modeOfTransportation;
		this.totalWeight = totalWeight;
		this.arrivalPort = arrivalPort;
		this.departurePort = departurePort;
	}

	public static Shipment createNewShipment(String shipperName, String modeOfTransportation, float totalWeight,
			String arrivalPort, String departurePort) {

		Shipment ship = new Shipment(nextShipmentId, shipperName, modeOfTransportation, totalWeight, arrivalPort,
				departurePort);
		return ship;
	}

	@Override
	public String toString() {
		return String.format("%-15d%-15s%-25s%-15s%-20s%s", this.id, this.shipperName, this.modeOfTransportation,
				String.valueOf(this.totalWeight) + "Kg", this.arrivalPort, this.departurePort);
	}

}

public class DisplayShipmentDetails {
	static Shipment createNewShipment = null;
	static List<Shipment> listOfShipment = new ArrayList<Shipment>();

	public static void main(String args[]) throws IOException {
		String shipperName = null;
		String modeOfTransportation = null;
		float totalWeight = 0;
		String arrivalPort = null;
		String departurePort = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of shipments :");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the shipment " + (i + 1) + " details");
			sc.nextLine();
			System.out.println("Enter the shipper name :");
			shipperName = sc.nextLine();
			System.out.println("Enter the mode of transportation :");
			modeOfTransportation = sc.nextLine();
			System.out.println("Enter the total weight :");
			totalWeight = sc.nextFloat();
			System.out.println("Enter the arrival port :");
			arrivalPort = sc.next();
			System.out.println("Enter the departure port :");
			departurePort = sc.next();
			createNewShipment = Shipment.createNewShipment(shipperName, modeOfTransportation, totalWeight, arrivalPort,
					departurePort);
			listOfShipment.add(createNewShipment);
		}
		System.out.println("Shipment details are");

		System.out.println(String.format("%-15s%-15s%-25s%-15s%-20s%s", "Id", "ShipperName", "ModeOfTransportation",
				"TotalWeight", "ArrivalPort", "DeparturePort"));
		if (null != listOfShipment && !listOfShipment.isEmpty())
			for (int i = 0; i < listOfShipment.size(); i++) {
				System.out.println(listOfShipment.get(i).toString());
			}
	}
}
