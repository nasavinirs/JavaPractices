package com.practice.oopsproblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class PurchaseOrder {
	private int id;
	private String customerName;
	private OrderLine[] orderLineArray;

	public PurchaseOrder(int id, String customerName) {
		this.id = id;
		this.customerName = customerName;
	}

	public OrderLine[] getOrderLineArray() {
		return orderLineArray;
	}

	public void setOrderLineArray(OrderLine[] orderLineArray) {
		this.orderLineArray = orderLineArray;
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

	public void setCustomerName(String userName) {
		this.customerName = userName;
	}

	void displayItemDetails(PurchaseOrder purchaseOrderObj) {
		int i;
		System.out.println("Order list of " + purchaseOrderObj.getCustomerName() + " :");

		System.out.format("%-15s%-15s%-15s%s\n", "Item Id", "Name", "Price", "Quantity");
		int size = 0;
		for (i = 0; i < purchaseOrderObj.orderLineArray.length; i++)
			if (purchaseOrderObj.orderLineArray[i] != null)
				size++;

		for (i = 0; i < size; i++) {
			System.out.format("%-15s%-15s%-15d%d\n", purchaseOrderObj.getOrderLineArray()[i].getItem().getId(),
					purchaseOrderObj.getOrderLineArray()[i].getItem().getName(),
					purchaseOrderObj.getOrderLineArray()[i].getItem().getPrice(),
					purchaseOrderObj.getOrderLineArray()[i].getQuantity());
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

	public void addNewItem(PurchaseOrder purchaseOrder, Item item, int quantity) {
		// fill code here.
		OrderLine[] orderLineArray = purchaseOrder.getOrderLineArray();

		for (int i = 0; i < orderLineArray.length; i++) {
			OrderLine orderLine = orderLineArray[i];
			if(orderLine == null) {
				orderLineArray[i] = new OrderLine(purchaseOrder,item, quantity);
				break;
			}			
		}
				
		purchaseOrder.setOrderLineArray(orderLineArray);
	}

	public void updateItem(OrderLine orderLineObj, int quantity) {
		// fill code here.
		orderLineObj.setQuantity(quantity);

	}

}

public class AddItemToPurchaseOrderCC {

	public static void main(String[] args) throws Exception {

		int i, itemNumber;
		int j, choice;
		int id;
		int quantity;

		PurchaseOrder purchaseOrderObj = new PurchaseOrder(125, "Mathews");
		PurchaseBO purchaseBOObj = new PurchaseBO();

		Item itemArray[] = new Item[5];

		itemArray[0] = new Item(1, "Samsung Mobile", 10599);
		itemArray[1] = new Item(2, "Dell Laptop", 32999);
		itemArray[2] = new Item(3, "Lenovo Laptop", 35000);
		itemArray[3] = new Item(4, "Mac Book", 89499);
		itemArray[4] = new Item(5, "Sony Headset", 2499);

		OrderLine[] orderLineArray = new OrderLine[30];

		orderLineArray[0] = new OrderLine(purchaseOrderObj, itemArray[0], 25);
		orderLineArray[1] = new OrderLine(purchaseOrderObj, itemArray[1], 15);
		orderLineArray[2] = new OrderLine(purchaseOrderObj, itemArray[2], 45);
		orderLineArray[3] = new OrderLine(purchaseOrderObj, itemArray[3], 24);
		orderLineArray[4] = new OrderLine(purchaseOrderObj, itemArray[4], 20);

		purchaseOrderObj.setOrderLineArray(orderLineArray);

		String itemDetails;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println("1. Add new item\n2. Update order line\n3. Display\n4. Exit\nEnter your choice :");
			choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1:
				System.out.println("Enter number of items :");
				itemNumber = Integer.parseInt(br.readLine());
				for (j = 0; j < itemNumber; j++) {
					System.out.println("Enter item " + (j + 1) + " details :");
					itemDetails = br.readLine();
					System.out.println("Enter quantity :");
					quantity = Integer.parseInt(br.readLine());
					String splited[] = itemDetails.split(",");

					// fill code here.
					purchaseBOObj.addNewItem(purchaseOrderObj,
							new Item(Integer.parseInt(splited[0]), splited[1], Integer.parseInt(splited[2])), quantity);
				}
				System.out.println("Item has been added");
				break;
			case 2:

				System.out.println("Enter the item id you want to update :");
				id = Integer.parseInt(br.readLine());
				System.out.println("Enter the quantity :");
				quantity = Integer.parseInt(br.readLine());

				// fill code here.
				for (int k = 0; k < orderLineArray.length; k++) {
					Item item = orderLineArray[k].getItem();
					if (item.getId() == id) {
						purchaseBOObj.updateItem(orderLineArray[k], quantity);
						break;
					}
				}				
				System.out.println("Item has been updated");
				break;
			case 3:

				// fill code here.
				purchaseOrderObj.displayItemDetails(purchaseOrderObj);
				break;
			case 4:
				System.exit(0);
			default:
				break;
			}
		} while (choice != 4);
	}

}
