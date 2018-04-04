package com.practice.jdbc.exs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrder_CCPrgm {

	public static void main(String[] args) throws IOException, ParseException, SQLException {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		OrderLine orderLine = new OrderLine();
		PurchaseOrderBO purchaseOrderBO = new PurchaseOrderBO();
		ItemDAO itemDAO = new ItemDAO();
		List<Item> itemList = itemDAO.getAllItems();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.format("%-15s %-25s %-25s %-15s\n", "Item ID", "Name", "Available Quantity", "Price");
		for (Item itm : itemList) {
			System.out.format("%-15s %-25s %-25s %-15s\n", itm.getId(), itm.getName(), itm.getAvailableQuantity(), itm.getPrice());
		}
		System.out.println("Creating new purchase order...");
		System.out.println("Enter Customer Name:");
		String customerName = br.readLine();
		System.out.println("Enter Contact Number:");
		String mobileNumber = br.readLine();
		System.out.println("Enter Order Date(dd/mm/yyyy):");
		String orderDate = br.readLine();
		System.out.println("Enter all the Item ID you want to purchase:");
		String itemIds[] = br.readLine().split(",");
		List<Item> items = new ArrayList<Item>();
		System.out.println("Enter number of quantities:");
		String quantities[] = br.readLine().split(",");
		
		for (int i = 0; i < itemIds.length; i++) {
			Item item = new Item();
			item.setId(Long.parseLong(itemIds[i]));
			items.add(item);
			//purchaseOrderBO.createPurchaseOrder(items, quantities, customerName, mobileNumber, orderDate);
		}
		
	}
}
