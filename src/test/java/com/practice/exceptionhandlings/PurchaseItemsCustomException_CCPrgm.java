package com.practice.exceptionhandlings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ItemInsufficientQuantity extends Exception {
	private static final long serialVersionUID = 1L;

	public ItemInsufficientQuantity() {
		super();
	}

	public ItemInsufficientQuantity(String message) {
		super(message);
	}
}

class Invoice {
	int id;
	String createdBy;
	String customerName;
	InvoiceLine[] invoiceLine;

	public Invoice(int id, String createdBy, String customerName) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public InvoiceLine[] getInvoiceLine() {
		return invoiceLine;
	}

	public void setInvoiceLine(InvoiceLine[] invoiceLine) {
		this.invoiceLine = invoiceLine;
	}

}

class InvoiceLine {
	Item item;
	Invoice invoice;
	int quantity;

	public InvoiceLine(Item item, Invoice invoice, int quantity) {
		super();
		this.item = item;
		this.invoice = invoice;
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
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
	int quantity;

	public Item(int id, String name, int price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public String toString() {
		return String.format("%-15s %-25s %-15s", this.getId(), this.getName(), this.getQuantity());
	}

}

class InvoiceBO {
	public Item getItemById(Item[] itemArray, int id) {
		Item item;
		for (int i = 0; i < itemArray.length; i++) {
			item = itemArray[i];
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}

	public void processInvoice(Invoice invoice) throws ItemInsufficientQuantity {
		InvoiceLine[] invoiceLines = invoice.getInvoiceLine();

		for (int i = 0; i < invoiceLines.length; i++) {
			int invoiceQuantity = invoiceLines[i].getQuantity();
			int itemQuantity = invoiceLines[i].getItem().getQuantity();
			if (invoiceQuantity <= itemQuantity) {
				int quantity = itemQuantity - invoiceQuantity;
				invoiceLines[i].getItem().setQuantity(quantity);
			} else {
				throw new ItemInsufficientQuantity("Item Insufficient");
			}
		}
	}
}

public class PurchaseItemsCustomException_CCPrgm {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* Invoice details */
		Invoice invoice = new Invoice(1, "Raj", "Stella");
		InvoiceBO invoiceBO = new InvoiceBO();
		/* Item details */
		Item[] itemArray = new Item[10];
		itemArray[0] = new Item(1, "Laptop", 40000, 4);
		itemArray[1] = new Item(2, "Computer", 35000, 10);
		itemArray[2] = new Item(3, "Mouse", 250, 250);
		itemArray[3] = new Item(4, "Key Board", 2000, 50);
		itemArray[4] = new Item(5, "CPU", 15000, 10);
		itemArray[5] = new Item(6, "Speaker", 15000, 2);
		itemArray[6] = new Item(7, "FM Radio", 1500, 5);
		itemArray[7] = new Item(8, "Cell Phone", 6999, 10);
		itemArray[8] = new Item(9, "Dell Laptop Charger", 3500, 20);
		itemArray[9] = new Item(10, "Camera", 50000, 10);

		/* Printing the item details available in ware house */
		System.out.println("The available item details before purchase");
		int i;
		System.out.format("%-15s %-25s %-15s\n", "Id", "Name", "Available Quantity");
		for (i = 0; i < itemArray.length; i++) {
			System.out.format("%-15s %-25s %-15s\n", itemArray[i].getId(), itemArray[i].getName(),
					itemArray[i].getQuantity());
		}

		System.out.println("Enter the number of items you want to purchase :");
		int no = Integer.parseInt(br.readLine());
		Item[] item = new Item[no];
		InvoiceLine[] invoiceLine = new InvoiceLine[no];
		System.out.println("Enter the item details [itemId,quantity]");
		for (int j = 0; j < no; j++) {
			System.out.println("Enter the item details " + (j + 1) + " :");
			String input[] = br.readLine().split(",");
			item[j] = invoiceBO.getItemById(itemArray, Integer.parseInt(input[0]));
			invoiceLine[j] = new InvoiceLine(item[j], invoice, Integer.parseInt(input[1]));
		}
		invoice.setInvoiceLine(invoiceLine);
		try {
			invoiceBO.processInvoice(invoice);

			/* Printing the item details available in ware house */
			System.out.println("The available item details after purchase");
			System.out.format("%-15s %-25s %-15s\n", "Id", "Name", "Available Quantity");
			for (i = 0; i < itemArray.length; i++) {
				System.out.format("%-15s %-25s %-15s\n", itemArray[i].getId(), itemArray[i].getName(),
						itemArray[i].getQuantity());
			}
		} catch (ItemInsufficientQuantity e) {
			System.out.println("Exception occurred: ItemInsufficientQuantity: Item Insufficient");
		}

	}

}
