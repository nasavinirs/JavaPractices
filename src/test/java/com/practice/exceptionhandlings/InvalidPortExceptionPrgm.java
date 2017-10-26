package com.practice.exceptionhandlings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InvalidPortException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidPortException() {
		super();
	}

	public InvalidPortException(String message) {
		super(message);
	}

}

class Port {

	private int id;
	private String country;
	private String name;

	public Port() {

	}

	public Port(int id, String country, String name) {
		this.id = id;
		this.country = country;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Shipment {
	private int id;
	private String name;
	private Port arrivalport;
	private Port departureport;

	Shipment() {

	}

	public Shipment(int id, String name, Port arrivalport, Port departureport) {
		this.id = id;
		this.name = name;
		this.arrivalport = arrivalport;
		this.departureport = departureport;
	}

	public int getId() {
		return this.id;

	}

	public void setId(int id) {
		this.id = id;

	}

	public String getName() {
		return this.name;

	}

	public void setName(String name) {
		this.name = name;

	}

	public Port getArrivalport() {
		return this.arrivalport;

	}

	public void setArrivalport(Port arrivalport) {
		this.arrivalport = arrivalport;

	}

	public Port getDepartureport() {
		return this.departureport;

	}

	public void setDepartureport(Port departureport) {
		this.departureport = departureport;

	}
}

class ShipmentBO {
	public boolean validateShipment(String s1, String s2, Port[] p) throws InvalidPortException {
		if (s1.equalsIgnoreCase(s2)) {
			try {
				throw new InvalidPortException("InvalidPortException: The port name is invalid");
			} catch (InvalidPortException e) {
				System.out.println(e.getMessage());
			}
		} else {
			for (int i = 0; i < p.length; i++) {
				if (p[i].getName().equalsIgnoreCase(s1) || p[i].getName().equalsIgnoreCase(s2)) {
					return true;
				}
			}
		}
		return false;
	}

	public void displayShipmentDetails(Shipment shipmentObj, Port[] ports, String p1, String p2) {
		for (int i = 0; i < ports.length; i++) {
			if (ports[i].getName().equalsIgnoreCase(p1))
				p1 = ports[i].getName() + "/" + ports[i].getCountry();
			if (ports[i].getName().equalsIgnoreCase(p2))
				p2 = ports[i].getName() + "/" + ports[i].getCountry();
		}
		System.out.format("%-15s%-15s%-15s%-15s\n", shipmentObj.getId(), shipmentObj.getName(), p1, p2);
	}

}

public class InvalidPortExceptionPrgm {

	public static void main(String args[]) {
		try
		{
			ShipmentBO shipmentBO = new ShipmentBO();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Port[] port = new Port[4];
			port[0] = new Port(1, "India", "Chennai");
			port[1] = new Port(2, "America", "California");
			port[2] = new Port(3, "England", "London");
			port[3] = new Port(4, "Australia", "Melbourne");
			Shipment shipment = new Shipment();

			System.out.println("Enter the Shipment Id ");
			shipment.setId(Integer.parseInt(br.readLine()));
			System.out.println("Enter the Shipment Name ");
			shipment.setName(br.readLine());
			System.out.println("Available ports are");
			System.out.format("%-15s %-15s %s", "ID", "Country", "PortName");
			for (int i = 0; i < port.length; i++) {
				System.out.format("\n%-15s %-15s %s", port[i].getId(), port[i].getCountry(), port[i].getName());
			}

			System.out.println("\nEnter the arrival port name");
			String arrivalPort = br.readLine();
			System.out.println("Enter the departure port name");
			String departurePort = br.readLine();

			boolean valid = shipmentBO.validateShipment(arrivalPort, departurePort, port);
			if (valid) {
				System.out.println("Shipment Details :");
				System.out.format("%-16s%-16s%-16s%-15s\n", "Shipment id", "Shipment name", "Arrival place",
						"Departure place");
				shipmentBO.displayShipmentDetails(shipment, port, arrivalPort, departurePort);
			}
		} catch (InvalidPortException coe) {
			System.out.println("InvalidPortException: The port name is invalid");
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
}
