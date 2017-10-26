package com.practice;

import java.util.Scanner;

class Address {
	String state;
	String country;

	public Address(String state, String country) {
		this.state = state;
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return String.format("%-15s %s\n", state, country);
	}

}

class Company {
	String identifier;
	String iata;
	String fmc;
	Address address;

	public Company(String identifier, String iata, String fmc, Address address) {
		super();
		this.identifier = identifier;
		this.iata = iata;
		this.fmc = fmc;
		this.address = address;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public String getFmc() {
		return fmc;
	}

	public void setFmc(String fmc) {
		this.fmc = fmc;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return String.format("%-15s %-15s %-15s %s", identifier, iata, fmc, address);
	}

}

class CompanyBO {
	public void displayCompanyDetails(Company[] companies) {
		int indiaCounter = 0;
		
		for (int i = 0; i < companies.length; i++) {
			if(companies[i].getAddress().getCountry().equalsIgnoreCase("India")) {
				indiaCounter++;
			}
		}
		
		if(indiaCounter == 0) {
			System.out.format("%-15s %-15s %-15s %s","Company ID","IATA Code","FMC Code","State","Country");
			
		}
		else
			System.out.println("All companies are inside India");
			
	}
}

public class DisplayCompanyDetails {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	}

}
