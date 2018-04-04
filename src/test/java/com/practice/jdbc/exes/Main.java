package com.practice.jdbc.exes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.practice.jdbc.exes.Item;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		ItemDAO itemdao = new ItemDAO();
		List<Item> itemList = itemdao.getAllItems();
		Double price;

		System.out.format("%-15s %-15s %s\n","Item ID","Item Name","Price");
		for (Item itm : itemList) {
			System.out.format("%-15s %-15s %s\n", itm.getId(), itm.getName(), itm.getPrice());
		}
		
		System.out.println("Enter the item id to update :");
		Item item = new Item();
		item.setId(buff.readLine());
		
		
		System.out.println("Enter the new price :");
		price = Double.parseDouble(buff.readLine());
		
		itemdao.updateItemPrice(item, price);
		itemList = itemdao.getAllItems();
		System.out.println("Item details after update :");
		System.out.format("%-15s %-15s %s\n","Item ID","Item Name","Price");
		for (Item itm : itemList) {
			System.out.format("%-15s %-15s %s\n", itm.getId(), itm.getName(), itm.getPrice());
		}
		

	}
}