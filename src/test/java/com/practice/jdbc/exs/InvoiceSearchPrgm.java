package com.practice.jdbc.exs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

import com.sun.jna.platform.win32.LMAccess.GROUP_USERS_INFO_0;

public class InvoiceSearchPrgm {

	public static void main(String ags[]) throws Exception {
		String option = "no";
		int ch = 0;
		int amount = 1000;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		InvoiceDAO invoiceDAO = new InvoiceDAO();
		List<Invoice> balanceBelowAmountList = invoiceDAO.findInvoiceByAmount(amount);
		List<Invoice> pendingList = invoiceDAO.findPendingInvoice();
		List<Invoice> noPaymentList = invoiceDAO.findNoPaymentInvoice();
		List<List> groupByCustomerList = invoiceDAO.invoiceGroupByCustomer();

		do {
			System.out.println("Select your choice");
			System.out.println("1.Invoices greater than $1000");
			System.out.println("2.Invoices which are pending for payment");
			System.out.println("3.Invoices which did not receive any payment");
			System.out.println("4.Group invoice based on the customer and print summary");
			ch = Integer.parseInt(br.readLine());

			switch (ch) {
			case 1:
				System.out.println("List of the Invoices more than $1000");
				System.out.println(String.format("%-5s %-15s %-17s %-15s %-10s %s", "Id", "Customer Name",
						"Payment Attempts", "Total Amount", "Balance", "Status"));
				for (Invoice invoice : balanceBelowAmountList) {
					System.out.println(String.format("%-5s %-15s %-17s %-15s %-10s %s", invoice.getId(),
							invoice.getCustomerName(), invoice.getPaymentAttempts(), invoice.getTotalAmount(),
							invoice.getBalance(), invoice.getStatus()));
				}
				break;
			case 2:
				System.out.println("List of the Invoices which are pending for payment");
				System.out.println(String.format("%-5s %-15s %-17s %-15s %-10s %s", "Id", "Customer Name",
						"Payment Attempts", "Total Amount", "Balance", "Status"));

				for (Invoice invoice : pendingList) {
					System.out.println(String.format("%-5s %-15s %-17s %-15s %-10s %s", invoice.getId(),
							invoice.getCustomerName(), invoice.getPaymentAttempts(), invoice.getTotalAmount(),
							invoice.getBalance(), invoice.getStatus()));
				}
				break;

			case 3:
				System.out.println("List of the Invoices which did not receive any payment");
				System.out.println(String.format("%-5s %-15s %-17s %-15s %-10s %s", "Id", "Customer Name",
						"Payment Attempts", "Total Amount", "Balance", "Status"));

				for (Invoice invoice : noPaymentList) {
					System.out.println(String.format("%-5s %-15s %-17s %-15s %-10s %s", invoice.getId(),
							invoice.getCustomerName(), invoice.getPaymentAttempts(), invoice.getTotalAmount(),
							invoice.getBalance(), invoice.getStatus()));
				}
				break;

			case 4:
				System.out.println("Invoice Summary");
				System.out.println(String.format("%-17s %-15s %s", "Customer Name", "Total Amount", "Total Balance"));
				for(List<List> list : groupByCustomerList) {
					for(int i = 0; i < list.size(); i++) {
						String[] str = String.join(",", list.get(i)).split(",");
						//System.out.println(list.get(i));
						System.out.println(String.format("%-17s %-15s %s", str[0], str[1], str[2]));
					}					
				}
				break;
			}

			System.out.println("Do you want to continue");
			option = br.readLine();
		} while (option.equalsIgnoreCase("yes"));

	}

}

