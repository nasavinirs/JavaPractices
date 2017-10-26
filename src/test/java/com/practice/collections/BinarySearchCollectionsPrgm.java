package com.practice.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ShipmentEntity implements Comparable<ShipmentEntity> {

	Integer id;
	String name;
	Integer bookingNumber;

	public ShipmentEntity(Integer id, String name, Integer bookingNumber) {
		this.id = id;
		this.name = name;
		this.bookingNumber = bookingNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(Integer bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	@Override
	public int compareTo(ShipmentEntity o) {
		return this.id - o.id;
	}

	@Override
	public String toString() {
		return String.format("%-16s%-16s%-15s", id, name, bookingNumber);
	}

	public static Comparator<ShipmentEntity> ShipmentEntityComparator = new Comparator<ShipmentEntity>() {

		@Override
		public int compare(ShipmentEntity s1, ShipmentEntity s2) {
			return s1.getBookingNumber() - s2.getBookingNumber();
		}
	};

}

public class BinarySearchCollectionsPrgm {

	public static void main(String[] args) throws IOException {
		String val, input[];
		List<ShipmentEntity> list = new ArrayList<ShipmentEntity>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the shipment entity details");
		do {
			input = br.readLine().split(",");
			list.add(new ShipmentEntity(Integer.parseInt(input[0]), input[1], Integer.parseInt(input[2])));
			System.out.println("Do you want to continue[Yes/No]");
			val = br.readLine();
		} while (val.equalsIgnoreCase("yes"));

		Collections.sort(list);
		System.out.println("After sorting the shipment entity details");
		System.out.format("%-16s%-16s%-15s\n", "Port Id", "Name", "Number");
		for (ShipmentEntity entry : list) {
			System.out.println(entry);
		}
		System.out.println("Enter the shipment entity details to be searched");
		input = br.readLine().split(",");
		ShipmentEntity entry = new ShipmentEntity(Integer.parseInt(input[0]), input[1], Integer.parseInt(input[2]));
		int index = Collections.binarySearch(list, entry, ShipmentEntity.ShipmentEntityComparator);
		System.out.println("Shipment entity found in index : " + index);
	}

}
