package com.practice.oopsproblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface IExportData {
	void convertToJSON(Shipment[] shipmentObj);

	void convertToCSV(Shipment[] shipmentObj);
}

class Shipment {
	int id;
	String name;
	String arrivalPort;
	String departurePort;
	ShipmentStatus status;

	public Shipment() {

	}

	public Shipment(int id, String name, String arrivalPort, String departurePort, ShipmentStatus status) {
		this.id = id;
		this.name = name;
		this.arrivalPort = arrivalPort;
		this.departurePort = departurePort;
		this.status = status;
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

	public String getArrivalPort() {
		return arrivalPort;
	}

	public void setArrivalPort(String arrivalPort) {
		this.arrivalPort = arrivalPort;
	}

	public String getDeparturePort() {
		return departurePort;
	}

	public void setDeparturePort(String departurePort) {
		this.departurePort = departurePort;
	}

	public ShipmentStatus getStatus() {
		return status;
	}

	public void setStatus(ShipmentStatus status) {
		this.status = status;
	}

}

class ShipmentStatus {
	String code;
	String name;

	public ShipmentStatus() {

	}

	public ShipmentStatus(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class ShipmentBO implements IExportData {

	@Override
	public void convertToJSON(Shipment[] shipmentObj) {
		System.out.println("[");
		for (int i = 0; i < shipmentObj.length; i++) {
			System.out.println("{");
			System.out.println("\"id\":" + shipmentObj[i].getId());
			System.out.println("\"name\":\"" + shipmentObj[i].getName() + "\"");
			System.out.println("\"arrivalName\":\"" + shipmentObj[i].getArrivalPort() + "\"");
			System.out.println("\"departureName\":\"" + shipmentObj[i].getDeparturePort() + "\"");
			System.out.println("\"shipmentCode\":\"" + shipmentObj[i].getStatus().getCode() + "\"");
			System.out.println("\"shipmentName\":\"" + shipmentObj[i].getStatus().getName() + "\"");
			System.out.println("}");
		}
		System.out.println("]");
	}

	@Override
	public void convertToCSV(Shipment[] shipmentObj) {
		for (int i = 0; i < shipmentObj.length; i++) {
			System.out.println(shipmentObj[i].getId() + "," + shipmentObj[i].getName() + ","
					+ shipmentObj[i].getArrivalPort() + "," + shipmentObj[i].getDeparturePort() + ","
					+ shipmentObj[i].getStatus().getCode() + "," + shipmentObj[i].getStatus().getName());
		}
	}

}

public class DisplayShipmentDetails {

	public static void main(String[] args) throws IOException {
		ShipmentBO shipmentBO = new ShipmentBO();
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of shipment");
		int n = Integer.parseInt(buf.readLine());
		Shipment[] shipment = new Shipment[n];
		ShipmentStatus[] status = new ShipmentStatus[n];
		String[] input;
		for (int i = 0; i < n; i++) {
			System.out.println("Enter Shipment " + (i + 1) + " details");
			input = buf.readLine().split(",");
			status[i] = new ShipmentStatus(input[4], input[5]);
			shipment[i] = new Shipment(Integer.parseInt(input[0]), input[1], input[2], input[3], status[i]);
		}

		System.out.println("Enter the type to display the data (JSON/CSV)");
		String opt = buf.readLine();
		if (opt.equalsIgnoreCase("json")) {
			System.out.println("JSON Data:");
			shipmentBO.convertToJSON(shipment);
		} else if (opt.equalsIgnoreCase("csv")) {
			System.out.println("CSV Data:");
			shipmentBO.convertToCSV(shipment);
		}
	
	}

}
