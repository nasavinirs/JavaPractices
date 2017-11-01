package com.practice.jdbc.exs;

public class Shipment {

	private int id;
	private String name;
	private String arrivalPortName;
	private String departurePortName;
	private double cost;
	private ShipmentStatus shipmentStatus;

	public Shipment(int id, String name, String arrivalPortName, String departurePortName, double cost,
			ShipmentStatus shipmentStatus) {
		this.id = id;
		this.name = name;
		this.arrivalPortName = arrivalPortName;
		this.departurePortName = departurePortName;
		this.cost = cost;
		this.shipmentStatus = shipmentStatus;
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

	public String getArrivalPortName() {
		return arrivalPortName;
	}

	public void setArrivalPortName(String arrivalPortName) {
		this.arrivalPortName = arrivalPortName;
	}

	public String getDeparturePortName() {
		return departurePortName;
	}

	public void setDeparturePortName(String departurePortName) {
		this.departurePortName = departurePortName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public ShipmentStatus getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(ShipmentStatus shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

}
