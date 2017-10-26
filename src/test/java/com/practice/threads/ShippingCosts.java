package com.practice.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Cargo {
	Long id;
	Integer length;
	Integer width;
	Integer weight;
	String cargoType;
	String storageType;
	static String DRY_STORAGE;
	static String COLD_STORAGE;

	public Cargo(String s) {
		String[] splitStr = s.split(",");
		id = Long.parseLong(splitStr[0]);
		length = Integer.parseInt(splitStr[1]);
		width = Integer.parseInt(splitStr[2]);
		weight = Integer.parseInt(splitStr[3]);
		cargoType = splitStr[4];
		storageType = splitStr[5];
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getCargoType() {
		return cargoType;
	}

	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public static String getDRY_STORAGE() {
		return DRY_STORAGE;
	}

	public static void setDRY_STORAGE(String dRY_STORAGE) {
		DRY_STORAGE = dRY_STORAGE;
	}

	public static String getCOLD_STORAGE() {
		return COLD_STORAGE;
	}

	public static void setCOLD_STORAGE(String cOLD_STORAGE) {
		COLD_STORAGE = cOLD_STORAGE;
	}

}

class ShippingCostThread extends Thread {
	List<Cargo> cargoList;
	List<Double> priceList;

	public List<Cargo> getCargoList() {
		return cargoList;
	}

	public void setCargoList(List<Cargo> cargoList) {
		this.cargoList = cargoList;
	}

	public List<Double> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<Double> priceList) {
		this.priceList = priceList;
	}

	public void run() {

	}
}

public class ShippingCosts {

	public static void main(String[] args) {
		try {
			List<Cargo> cargoList = new ArrayList<Cargo>();
			List<Double> priceList = new ArrayList<Double>();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the number of Cargo:");
			int n = Integer.parseInt(br.readLine());
			Cargo[] cargo = new Cargo[n];
			System.out.println("Enter cargo details (id,length,width,weight,cargo type,storage type):");
			String input[] = new String[n];
			for (int i = 0; i < n; i++) {
				input[i] = br.readLine();
				cargo[i] = new Cargo(input[i]);
			}

			Thread t1 = new ShippingCostThread();
			Thread t2 = new ShippingCostThread();
			
			t1.start();
			t2.start();
			t1.join();
			t2.join();
			
			System.out.println("Price List:");
		} catch (InterruptedException ie) {

		} catch (IOException ioe) {

		}

	}

}
