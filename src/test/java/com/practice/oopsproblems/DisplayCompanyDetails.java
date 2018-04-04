package com.practice.oopsproblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Company {
	private String identifier;
	private String iata;
	private String fmc;
	private Address address;

	// getters & setters
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

	// Constructor
	public Company(String identifier, String iata, String fmc, Address address) {
		this.identifier = identifier;
		this.iata = iata;
		this.fmc = fmc;
		this.address = address;
	}

	public Company() {
		this.identifier = "";
		this.iata = "";
		this.fmc = "";
		this.address = null;
	}

	public String toString() {
		return String.format("%-15s %-15s %-15s %s", identifier, iata, fmc, address);
	}
}

// Class address
class Address {
	private String state;
	private String country;

	// getters and setters
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

	// Constructors
	public Address(String state, String country) {
		this.state = state;
		this.country = country;
	}

	public Address() {
		this.state = "";
		this.country = "";
	}

	// Overriding toString() method
	public String toString() {
		return String.format("%-15s %s\n", state, country);
	}
}

class CompanyBO {
	public void displayCompanyDetails(Company[] companies) {
		int i;
		boolean blnHeaderDisplay = true;
		boolean blnCompanyInsideIndia = true;

		for (i = 0; i < companies.length; i++) {
			if (!companies[i].getAddress().getCountry().equalsIgnoreCase("India")) {
				if (blnHeaderDisplay) {
					System.out.println("Companies outside India :");
					System.out.format("%-15s %-15s %-15s %-15s %s\n", "Company ID", "IATA Code", "FMC Code", "State",
							"Country");
					blnHeaderDisplay = false;
					blnCompanyInsideIndia = false;
				}
				System.out.print(companies[i]);
			}
		}
		if (blnCompanyInsideIndia) {
			System.out.println("All companies are inside India");
		}
	}
}

public class DisplayCompanyDetails {

	public static void main(String[] args) throws IOException {
		int nCompanies, i;
		String strId, strIATA, strFMC, strState, strCountry;
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		System.out.println("Enter the number of companies :");
		nCompanies = Integer.parseInt(br.readLine());
		Company[] comp = new Company[nCompanies];
		Address[] addr = new Address[nCompanies];

		for (i = 0; i < nCompanies; i++) {
			System.out.println("Enter the company " + (i + 1) + " details :");

			System.out.println("Enter company id :");
			strId = br.readLine();

			System.out.println("Enter the company's IATA code :");
			strIATA = br.readLine();

			System.out.println("Enter the company's FMC code :");
			strFMC = br.readLine();

			System.out.println("Enter the company's state :");
			strState = br.readLine();

			System.out.println("Enter the company's country :");
			strCountry = br.readLine();

			addr[i] = new Address(strState, strCountry);
			comp[i] = new Company(strId, strIATA, strFMC, addr[i]);
		}

		CompanyBO objectCompanyBO = new CompanyBO();
		objectCompanyBO.displayCompanyDetails(comp);

		br.close();
		r.close();
	}

}
