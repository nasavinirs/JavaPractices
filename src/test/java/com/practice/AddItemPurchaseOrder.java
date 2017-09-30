package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class PurchaseOrder {

	int id;
	String customerName;
	OrderLine[] orderLineArray;

	public PurchaseOrder(int id, String customerName) {
		this.id = id;
		this.customerName = customerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public OrderLine[] getOrderLineArray() {
		return orderLineArray;
	}

	public void setOrderLineArray(OrderLine[] orderLineArray) {
		this.orderLineArray = orderLineArray;
	}

	public void displayItemDetails(PurchaseOrder purchaseOrderObj) {
		OrderLine[] order = purchaseOrderObj.getOrderLineArray();
		Item[] item = new Item[order.length];
		for (int i = 0; i < order.length; i++) {
			item[i] = purchaseOrderObj.getOrderLineArray()[i].getItem();
			System.out.format("%-15s%-15s%-15s%s\n", item[i].getId(), item[i].getName(), item[i].getPrice(),
					order[i].getQuantity());
		}

	}
}

class OrderLine {
	PurchaseOrder purchaseOrder;
	Item item;
	int quantity;

	public OrderLine(PurchaseOrder purchaseOrder, Item item, int quantity) {
		this.purchaseOrder = purchaseOrder;
		this.item = item;
		this.quantity = quantity;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

class Item {
	int id;
	String name;
	int price;

	public Item(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}

class PurchaseBO {
	public PurchaseOrder addNewItem(PurchaseOrder purchaseOrder, Item item, int quantity) {
		List<OrderLine> orderLineList = new ArrayList<OrderLine>();
		orderLineList.addAll(Arrays.asList(purchaseOrder.getOrderLineArray()));
		//List<OrderLine> orderLineList = Arrays.asList(purchaseOrder.getOrderLineArray());
		orderLineList.add(new OrderLine(purchaseOrder, item, quantity));
		OrderLine orderLine[] = orderLineList.toArray(new OrderLine[orderLineList.size()]);
		purchaseOrder.setOrderLineArray(orderLine);
		return purchaseOrder;

	}

	public void updateItem(OrderLine orderLineObj, int quantity) {
		orderLineObj.setQuantity(quantity);
	}
}

public class AddItemPurchaseOrder {

	public static void main(String[] args) throws Exception {
		List<Item> itemList = new ArrayList<Item>();
		List<OrderLine> orderLineList = new ArrayList<OrderLine>();
		PurchaseBO purchaseBO = new PurchaseBO();
		int quantity, no_items, item_id;
		String item_details, item_split[];
		PurchaseOrder purchaseOrder = new PurchaseOrder(1, "Mathews");
		itemList.add(new Item(1, "Samsung Mobile", 10599));
		itemList.add(new Item(2, "Dell Laptop", 32999));
		itemList.add(new Item(3, "Lenovo Laptop", 35000));
		itemList.add(new Item(4, "Mac Book", 89499));
		itemList.add(new Item(5, "Sony Headset", 2499));
		orderLineList.add(new OrderLine(purchaseOrder, itemList.get(0), 25));
		orderLineList.add(new OrderLine(purchaseOrder, itemList.get(1), 15));
		orderLineList.add(new OrderLine(purchaseOrder, itemList.get(2), 45));
		orderLineList.add(new OrderLine(purchaseOrder, itemList.get(3), 24));
		orderLineList.add(new OrderLine(purchaseOrder, itemList.get(4), 20));
		OrderLine orderLine[] = orderLineList.toArray(new OrderLine[orderLineList.size()]);
		purchaseOrder.setOrderLineArray(orderLine);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("1. Add new item");
			System.out.println("2. Update order line");
			System.out.println("3. Display");
			System.out.println("4. Exit");
			System.out.println("Enter your choice :");
			int ch = Integer.parseInt(br.readLine());

			if (ch == 1) {
				System.out.println("Enter number of items :");
				no_items = Integer.parseInt(br.readLine());
				Item[] item = new Item[no_items];
				for (int i = 0; i < no_items; i++) {
					System.out.println("Enter item " + (i + 1) + " details :");
					item_details = br.readLine();
					item_split = item_details.split(",");
					item[i] = new Item(Integer.parseInt(item_split[0]), item_split[1], Integer.parseInt(item_split[2]));
					System.out.println("Enter quantity :");
					quantity = Integer.parseInt(br.readLine());
					purchaseOrder = purchaseBO.addNewItem(purchaseOrder, item[i], quantity);
				}
				System.out.println("Item has been added");
			} else if (ch == 2) {
				System.out.println("Enter the item id you want to update :");
				item_id = Integer.parseInt(br.readLine());
				// orderLine = new OrderLine(purchaseOrder, item, quantity);
				System.out.println("Enter the quantity :");
				quantity = Integer.parseInt(br.readLine());
				// purchaseBO.updateItem(orderLine, quantity);
			} else if (ch == 3) {
				System.out.println("Order list of :" + purchaseOrder.getCustomerName());
				System.out.format("%-15s%-15s%-15s%s\n", "Item Id", "Name", "Price", "Quantity");
				purchaseOrder.displayItemDetails(purchaseOrder);
			} else if (ch == 4) {
				System.exit(0);
			}
		}

	}

}
