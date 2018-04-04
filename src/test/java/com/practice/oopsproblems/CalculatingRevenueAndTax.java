package com.practice.oopsproblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

interface ICarrier {
	public void listPorts();

	public void noOfPort();
}

interface TaxPayer {
	public Double calculateRevenue();

	public Double calculateTax();
}

interface MenuDrivenEntity {
	public void displayMenu();

	public void choiceAction(int choice);
}

class Agent implements MenuDrivenEntity, TaxPayer {
	private String id;
	private Double expense;
	private Double commision;

	public Agent() {
	}

	public Agent(String values) {
		String input[] = values.split(",");
		id = input[0];
		expense = Double.parseDouble(input[1]);
		commision = Double.parseDouble(input[2]);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getExpense() {
		return expense;
	}

	public void setExpense(Double expense) {
		this.expense = expense;
	}

	public Double getCommision() {
		return commision;
	}

	public void setCommision(Double commision) {
		this.commision = commision;
	}

	@Override
	public Double calculateRevenue() {
		return expense + commision;
	}

	@Override
	public Double calculateTax() {
		double tax = commision * 0.05;
		return tax;
	}

	@Override
	public void displayMenu() {
		System.out.println("Agent menu");
		System.out.println("1.Calculate agent revenue");
		System.out.println("2.Calculate agent tax");
	}

	@Override
	public void choiceAction(int choice) {
		if (choice == 1) {
			double revenue = calculateRevenue();
			System.out.println("Revenue for " + getId() + " is " + revenue);
		} else if (choice == 2) {
			double tax = calculateTax();
			System.out.println("Tax for " + getId() + " is " + tax);
		}
	}
}

class Company1 implements MenuDrivenEntity, TaxPayer {
	private String id;
	private Double expense;
	private Double profit;

	public Company1() {
	}

	public Company1(String values) {
		String input[] = values.split(",");
		id = input[0];
		expense = Double.parseDouble(input[1]);
		profit = Double.parseDouble(input[2]);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getExpense() {
		return expense;
	}

	public void setExpense(Double expense) {
		this.expense = expense;
	}

	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}

	@Override
	public Double calculateRevenue() {
		return expense + profit;
	}

	@Override
	public Double calculateTax() {
		double tax = profit * 0.08;
		return tax;
	}

	@Override
	public void displayMenu() {
		System.out.println("Company menu");
		System.out.println("1.Calculate company revenue");
		System.out.println("2.Calculate company tax");
	}

	@Override
	public void choiceAction(int choice) {
		if (choice == 1) {
			double revenue = calculateRevenue();
			System.out.println("Revenue for " + getId() + " is " + revenue);
		} else if (choice == 2) {
			double tax = calculateTax();
			System.out.println("Tax for " + getId() + " is " + tax);
		}
	}
}

class Carrier1 implements ICarrier, MenuDrivenEntity {
	private String id;
	private Double expense;
	private String modeOfTransport;
	private String[] listOfPorts;

	public Carrier1() {
	}

	public Carrier1(String values) {
		String input[] = values.split(",");
		if(input.length > 3) {
			id = input[0];
			expense = Double.parseDouble(input[1]);
			modeOfTransport = input[2];
			listOfPorts = new String[input.length-3];
			int c = 0;
			for(int i = 3 ;i < input.length; i++) {
				listOfPorts[c] = input[i];
				if (c < input.length)
					c++;			
			}
		} else {
			id = input[0];
			expense = Double.parseDouble(input[1]);
			modeOfTransport = input[2];
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getExpense() {
		return expense;
	}

	public void setExpense(Double expense) {
		this.expense = expense;
	}

	public String getModeOfTransport() {
		return modeOfTransport;
	}

	public void setModeOfTransport(String modeOfTransport) {
		this.modeOfTransport = modeOfTransport;
	}

	@Override
	public void listPorts() {
		for (int i = 0; i < listOfPorts.length; i++) {
			System.out.println(listOfPorts[i]);
		}
	}

	@Override
	public void noOfPort() {
		System.out.println("Number of ports :" + listOfPorts.length);
	}

	@Override
	public void displayMenu() {
		System.out.println("Carrier menu");
		System.out.println("1.List the ports");
		System.out.println("2.Calculate number of ports");
	}

	@Override
	public void choiceAction(int choice) {
		if (choice == 1) {
			System.out.println("List of ports :");
			listPorts();
		} else if (choice == 2) {
			noOfPort();
		}
	}
}

public class CalculatingRevenueAndTax {

	public static void main(String[] args) throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of shipment entity :");
		int n = Integer.parseInt(buff.readLine());
		String[] values = new String[n];
		Object[] object = new Object[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the entity " + (i + 1) + " details :");
			values[i] = buff.readLine();
			if (values[i].substring(0, 2).equalsIgnoreCase("CO")) {
				object[i] = new Company1(values[i]);
			} else if (values[i].substring(0, 2).equalsIgnoreCase("AG")) {
				object[i] = new Agent(values[i]);
			} else if (values[i].substring(0, 2).equalsIgnoreCase("CA")) {
				object[i] = new Carrier1(values[i]);
			}
		}
		System.out.println("Enter the entity id :");
		String id = buff.readLine();
		for (int i = 0; i < n; i++) {
			String[] val = values[i].split(",");
			if (val[0].equalsIgnoreCase(id)) {
				if (id.substring(0, 2).equalsIgnoreCase("CO")) {
					Company1 c = (Company1) object[i];
					c.displayMenu();
					c.choiceAction(Integer.parseInt(buff.readLine()));
				} else if (id.substring(0, 2).equalsIgnoreCase("AG")) {
					Agent a = (Agent) object[i];
					a.displayMenu();
					a.choiceAction(Integer.parseInt(buff.readLine()));
				} else if (id.substring(0, 2).equalsIgnoreCase("CA")) {
					Carrier1 c = (Carrier1) object[i];
					c.displayMenu();
					c.choiceAction(Integer.parseInt(buff.readLine()));
				}
			}
		}
	}

}
