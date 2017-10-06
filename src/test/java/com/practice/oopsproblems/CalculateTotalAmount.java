/* package com.practice.oopsproblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

class Shipment {
	protected String name;
	protected String source;
	protected String destination;
	protected double price;

	public Shipment(String name, String source, String destination, double price) {
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	double calculateShipmentAmount() {
		return Double.NaN;
	}

}

class CompanyShipment extends Shipment {

	private Double luxuryTax;
	private Double corporateTax;

	public CompanyShipment(String name, String source, String destination, double price, double luxuryTax,
			double corporateTax) {
		super(name, source, destination, price);
		this.luxuryTax = luxuryTax;
		this.corporateTax = corporateTax;
	}

	public double getLuxuryTax() {
		return luxuryTax;
	}

	public void setLuxuryTax(double luxuryTax) {
		this.luxuryTax = luxuryTax;
	}

	public Double getCorporateTax() {
		return corporateTax;
	}

	public void setCorporateTax(double corporateTax) {
		this.corporateTax = corporateTax;
	}

	@Override
	double calculateShipmentAmount() {
		double lTax = (price * luxuryTax) / 100;
		double cTax = (price * corporateTax) / 100;
		return price + lTax + cTax;
	}

}

class AgentShipment extends Shipment {
	private double referalFee;

	public AgentShipment(String name, String source, String destination, double price, double referalFee) {
		super(name, source, destination, price);
		this.referalFee = referalFee;
	}

	public double getReferalFee() {
		return referalFee;
	}

	public void setReferalFee(double referalFee) {
		this.referalFee = referalFee;
	}

	@Override
	double calculateShipmentAmount() {
		return price + referalFee;
	}

}

public class CalculateTotalAmount {

	public static void main(String[] args) throws Exception {
		String name, source, destination;
		double price;
		int choice;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the shipment name :");
		name = br.readLine();
		System.out.println("Enter the source :");
		source = br.readLine();
		System.out.println("Enter the destination :");
		destination = br.readLine();
		System.out.println("Enter the price :");
		price = Double.parseDouble(br.readLine());
		System.out.println("1. Agent\n2. Company\nEnter your choice :");
		choice = Integer.parseInt(br.readLine());
		Shipment shipment;
		DecimalFormat df2 = new DecimalFormat("#.00");
		
		if (choice == 1) {
			double referalFee;
			System.out.println("Enter the referal fee :");
			referalFee = Double.parseDouble(br.readLine());
			System.out.println("Agent details :");
			AgentShipment agentShipment = new AgentShipment(name, source, destination, price, referalFee);
			double total = agentShipment.calculateShipmentAmount();
			System.out.format("%-15s %-15s %-15s %s\n", "Name", "Source", "Destination", "Total Amount");
			System.out.format("%-15s %-15s %-15s %s\n", agentShipment.name, agentShipment.source,
					agentShipment.destination, df2.format(total));
		} else if (choice == 2) {
			double luxuryTax, corporateTax;
			System.out.println("Enter the luxury tax and corporate tax:");
			luxuryTax = Double.parseDouble(br.readLine());
			corporateTax = Double.parseDouble(br.readLine());
			System.out.println("Company details :");
			CompanyShipment companyShipment = new CompanyShipment(name, source, destination, price, luxuryTax,
					corporateTax);
			double total = companyShipment.calculateShipmentAmount();
			System.out.format("%-15s %-15s %-15s %s\n", "Name", "Source", "Destination", "Total Amount");
			System.out.format("%-15s %-15s %-15s %s\n", companyShipment.name, companyShipment.source,
					companyShipment.destination, df2.format(total));
		}
	}
}
*/