package com.practice.iosw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Item {
	Long id;
	String internalNumber;
	int deleted;
	Long currencyId;
	Double price;

	public Item(Long id, String internalNumber, int deleted, Long currencyId, Double price) {
		super();
		this.id = id;
		this.internalNumber = internalNumber;
		this.deleted = deleted;
		this.currencyId = currencyId;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInternalNumber() {
		return internalNumber;
	}

	public void setInternalNumber(String internalNumber) {
		this.internalNumber = internalNumber;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public Long getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}

public class ItemSummary_CCPrgm {

	public static void main(String[] args) throws IOException {
		String FILENAME = "src/test/java/com/practice/iosw/itemstatus_input.txt";
		String sCurrentLine, splitStr[];
		int active = 0, deleted = 0;
		List<Item> itemList = new ArrayList<Item>();

		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			while ((sCurrentLine = br.readLine()) != null) {
				splitStr = sCurrentLine.split(" ");
				itemList.add(new Item(Long.parseLong(splitStr[0]), splitStr[1], Integer.parseInt(splitStr[2]),
						Long.parseLong(splitStr[3]), Double.parseDouble(splitStr[4])));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Item item : itemList) {
			if (item.getDeleted() == 1) {
				deleted += 1;
			} else if (item.getDeleted() == 0) {
				active += 1;
			}
		}

		System.out.println("Number of active items : " + active);
		System.out.println("Number of deleted items : " + deleted);
	}

}
