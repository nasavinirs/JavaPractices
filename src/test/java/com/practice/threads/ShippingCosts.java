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
	List<Double> priceList = new ArrayList<>();

	public void run() {

		for (int i = 0; i < cargoList.size(); i++) {
			if (cargoList.get(i).getStorageType().equalsIgnoreCase(Cargo.COLD_STORAGE)) {

				priceList.add((double) (cargoList.get(i).getWeight() * 1.85));
			}
			if (cargoList.get(i).getStorageType().equalsIgnoreCase(Cargo.DRY_STORAGE)) {

				priceList.add((double) (cargoList.get(i).getWeight() * 0.90));
			}
		}
		ShippingCosts.displayPrice(priceList);
	}

	public ShippingCostThread(List<Cargo> cargoList) {
		this.cargoList = cargoList;
	}

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

}

public class ShippingCosts {

	public static void main(String args[]) throws IOException, InterruptedException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of Cargo:");
		int numberOfCargo = Integer.parseInt(reader.readLine());

		System.out.println("Enter cargo details (id,length,width,weight,cargo type,storage type):");
		List<Cargo> cargoList = new ArrayList<Cargo>();
		for (int i = 0; i < numberOfCargo; i++) {
			cargoList.add(new Cargo(reader.readLine()));
		}
		System.out.println("Price List:");
		Thread temp = new ShippingCostThread(cargoList.subList(0, (int) Math.floor(cargoList.size() / 2)));
		
		Thread temp1 = new ShippingCostThread(
				cargoList.subList((int) Math.floor(cargoList.size() / 2), cargoList.size()));
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		temp.start();
		temp.join();
		temp1.start();
		temp1.join();
		
	}

	public static void displayPrice(List<Double> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
