package com.practice.oopsproblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Cargo {
	protected Float length;
	protected Float width;
	protected Float height;
	protected Double weight;

	Cargo() {
	}

	public Cargo(Float length, Float width, Float height, Double weight) {
		this.length = length;
		this.height = height;
		this.width = width;
		this.weight = weight;
	}

	public Float getLength() {
		return length;
	}

	public void setLength(Float length) {
		this.length = length;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
}

class Container extends Cargo {
	private String containerNumber;

	Container() {
	}

	public Container(String containerNumber) {
		this.containerNumber = containerNumber;
	}

	public String getContainerNumber() {
		return containerNumber;
	}

	public void setContainerNumber(String containerNumber) {
		this.containerNumber = containerNumber;
	}

	public void displayContainerDetails() {
		System.out.format("%-20s %-15s %-15s %-15s %s\n", containerNumber, length, width, height, weight);
	}
}

public class DisplayContainterDetails {

	public static void main(String[] args) throws Exception {
		String input[];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of containers :");
		int nos = Integer.parseInt(br.readLine());
		Container[] containers = new Container[nos];
		for (int i = 0; i < nos; i++) {
			System.out.println("Enter the container " + (i + 1) + " details :");
			input = br.readLine().split(",");
			containers[i] = new Container();
			containers[i].setContainerNumber(input[0]);
			containers[i].setLength(Float.parseFloat(input[1]));
			containers[i].setWidth(Float.parseFloat(input[2]));
			containers[i].setHeight(Float.parseFloat(input[3]));
			containers[i].setWeight(Double.parseDouble(input[4]));

		}
		System.out.println("Container details are");
		System.out.format("%-20s %-15s %-15s %-15s %s\n", "Container Number", "Length", "Width", "Height", "Weight");
		for (int i = 0; i < nos; i++) {
			containers[i].displayContainerDetails();
		}
	}

}
