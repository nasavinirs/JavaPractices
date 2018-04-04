package com.practice.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class ItemCount extends Thread {
	String itemName;
	List<String> itemList;
	Integer count;

	public ItemCount(String itemName, List<String> itemList) {
		this.itemName = itemName;
		this.count = 0;
		this.itemList = itemList;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public List<String> getItemList() {
		return itemList;
	}

	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void run() {
		String[] str;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).equals(itemName)) {
				count += 1;
			}
		}

	}

}

public class PurchaseFrequency_CCPrgm {

	public static void main(String[] args) throws IOException, InterruptedException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of purchases");
		Integer n = Integer.parseInt(br.readLine());
		List<String> itemList = new ArrayList<String>();
		String item, searchItem;
		System.out.println("Enter the items purchased");
		for (int i = 0; i < n; i++) {
			item = br.readLine();
			itemList.add(item);
		}
		System.out.println("Number of items to search");
		n = Integer.parseInt(br.readLine());
		List<ItemCount> threadList = new ArrayList<ItemCount>();
		for (int i = 0; i < n; i++) {
			searchItem = br.readLine();
			threadList.add(new ItemCount(searchItem, itemList));
		}

		// fill in your code here
		for (ItemCount i : threadList) {
			ItemCount temp = new ItemCount(i.itemName, itemList);
			temp.start();

		}

		System.out.format("%-15s %-15s\n", "Item Name", "Count");
		for (ItemCount i : threadList) {
			System.out.format("%-15s %-15s\n", i.itemName, i.count);
		}

	}

}
