/* package com.practice.oopsproblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class ShipmentEntity {

	protected String shipmentEntityName;
	protected String identificationNumber;

	public ShipmentEntity(String shipmentEntityName, String identificationNumber) {
		this.shipmentEntityName = shipmentEntityName;
		this.identificationNumber = identificationNumber;
	}

	public void setShipmentEntityName(String shipmentEntityName) {
		this.shipmentEntityName = shipmentEntityName;
	}

	public String getShipmentEntityName() {
		return shipmentEntityName;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void display() {
	}
}

class Agent extends ShipmentEntity {

	String name;
	String iata;
	String fmc;

	public Agent(String shipmentEntityName, String identificationNumber, String name, String iata, String fmc) {
		super(shipmentEntityName, identificationNumber);
		this.name = name;
		this.iata = iata;
		this.fmc = fmc;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public String getIata() {
		return iata;
	}

	public void setFmc(String fmc) {
		this.fmc = fmc;
	}

	public String getFmc() {
		return fmc;
	}

	@Override
	public void display() {
		System.out.format("%-15s %-25s %-15s %-15s %-15s\n", shipmentEntityName, identificationNumber, name, iata, fmc);
	}
}

class Customer extends ShipmentEntity {

	private Integer id;
	private String name;

	public Customer(String shipmentEntityName, String identificationNumber, Integer id, String name) {
		super(shipmentEntityName, identificationNumber);
		this.id = id;
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void display() {
		System.out.format("%-15s %-25s %-15s %-15s\n", shipmentEntityName, identificationNumber, id, name);
	}
}

class Company extends ShipmentEntity {

	private String identifier;
	private String iata;
	private String fmc;

	public Company(String name, String identificationNumber, String identifier, String iata, String fmc) {
		super(name, identificationNumber);
		this.identifier = identifier;
		this.iata = iata;
		this.fmc = fmc;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public String getIata() {
		return iata;
	}

	public void setFmc(String fmc) {
		this.fmc = fmc;
	}

	public String getFmc() {
		return fmc;
	}

	@Override
	public void display() {
		System.out.format("%-15s %-25s %-15s %-15s %-15s\n", shipmentEntityName, identificationNumber, identifier, iata,
				fmc);
	}

}

class Carrier extends ShipmentEntity {

	private String carrierCode;
	private String iata;

	public Carrier(String shipmentEntityName, String identificationNumber, String carrierCode, String iata) {
		super(shipmentEntityName, identificationNumber);
		this.carrierCode = carrierCode;
		this.iata = iata;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public String getIata() {
		return iata;
	}

	@Override
	public void display() {
		System.out.format("%-15s %-25s %-15s %-15s\n", shipmentEntityName, identificationNumber, carrierCode, iata);
	}

}

public class DisplayShipmentEntry {

	public static void main(String[] args) throws Exception {
		int option, n;
		String input[], shipmentType;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of shipment entity");
		n = Integer.parseInt(br.readLine());
		Agent[] agent = new Agent[n];
		Carrier[] carrier = new Carrier[n];
		Company[] company = new Company[n];
		Customer[] customer = new Customer[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the shipment entity " + (i + 1) + " details :");
			System.out.println("Select the shipment entity type");
			System.out.println("1)Customer\n2)Company\n3)Agent\n4)Carrier");
			option = Integer.parseInt(br.readLine());
			input = br.readLine().split(",");
			if (option == 1) {
				customer[i] = new Customer(input[0], input[1], Integer.parseInt(input[2]), input[3]);
			} else if (option == 2) {
				company[i] = new Company(input[0], input[1], input[2], input[3], input[4]);
			} else if (option == 3) {
				agent[i] = new Agent(input[0], input[1], input[2], input[3], input[4]);
			} else if (option == 4) {
				carrier[i] = new Carrier(input[0], input[1], input[2], input[3]);
			}
		}

		System.out.println("Shipment details are");
		System.out.println("Enter the shipment entity type to display");
		shipmentType = br.readLine();
		if (shipmentType.equals("Customer")) {
			System.out.format("%-15s %-25s %-15s %-15s\n", "Name", "Identification Number", "Customer Id",
					"Customer Name");
			for (int i = 0; i < n; i++) {
				if (customer[i] != null) {
					customer[i].display();
				}

			}
		} else if (shipmentType.equals("Company")) {
			System.out.format("%-15s %-25s %-15s %-15s %-15s\n", "Name", "Identification Number", "Company Name",
					"IATA", "FMC");
			for (int i = 0; i < n; i++) {
				if(company[i] != null) {
					company[i].display();
				}
			}
		} else if (shipmentType.equals("Agent")) {
			System.out.format("%-15s %-25s %-15s %-15s %-15s\n", "Name", "Identification Number ", "Agent Name", "IATA",
					"FMC");
			for (int i = 0; i < n; i++) {
				if(agent[i] != null) {
					agent[i].display();
				}
			}
		} else if (shipmentType.equals("Carrier")) {
			System.out.format("%-15s %-25s %-15s %-15s\n", "Name", "Identification Number", "Code Name", "IATA");
			for (int i = 0; i < n; i++) {
				if (carrier[i] != null) {
					carrier[i].display();
				}
			}
		}

		br.close();

	}

}
*/