package com.practice.jdbc.exs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {

	List<Invoice> findInvoiceByAmount(int amount) throws SQLException {
		String QUERY = "SELECT * FROM invoice WHERE total_amount > " + amount + " ORDER BY id";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		connection = DbConnection.getConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(QUERY);

		while (resultSet.next()) {
			invoiceList.add(new Invoice(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
					resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getString(6)));
		}

		connection.close();
		
		return invoiceList;
	}

	List<Invoice> findPendingInvoice() throws SQLException {
		String QUERY = "SELECT * FROM invoice WHERE status = 'pending' AND payment_attempts > 0 ORDER BY id";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		connection = DbConnection.getConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(QUERY);

		while (resultSet.next()) {
			invoiceList.add(new Invoice(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
					resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getString(6)));
		}

		connection.close();
		
		return invoiceList;

	}

	List<Invoice> findNoPaymentInvoice() throws SQLException {
		String QUERY = "SELECT * FROM invoice WHERE payment_attempts = 0 ORDER BY id";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		connection = DbConnection.getConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(QUERY);

		while (resultSet.next()) {
			invoiceList.add(new Invoice(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
					resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getString(6)));
		}

		connection.close();
		
		return invoiceList;
	}

	List<List> invoiceGroupByCustomer() throws SQLException {
		List<List> obj=new ArrayList<List>();
		String QUERY = "SELECT customer_name, total_amount, SUM(balance) \"Total Balance\"\r\n" + 
					   "FROM invoice\r\n" + 
					   "GROUP BY customer_name\r\n" + 
					   "ORDER BY customer_name";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<List> list = new ArrayList<List>();
		List<String> sList = new ArrayList<String>();
		List<String> cnList = new ArrayList<String>();
		List<String> taList = new ArrayList<String>();
		List<String> baList = new ArrayList<String>();
		connection = DbConnection.getConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(QUERY);

		while (resultSet.next()) {
			cnList.add(resultSet.getString(1));
			taList.add(resultSet.getString(2));
			baList.add(resultSet.getString(3));
			sList.add(String.format("%-17s %-15s %s", resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
		}
		list.add(sList);	
		connection.close();
		
		return list;

	}
}
