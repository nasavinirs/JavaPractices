package com.practice.jdbc.exs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderDAO {

	public Integer createPurchaseOrder(PurchaseOrder po) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Integer id = null;
		connection = DbConnection.getConnection();
		statement = connection.createStatement();

		statement.executeUpdate(
				"INSERT INTO purchase_order (order_date, created_date, number_of_items, status, total_amount, customer_name, mobile_number) VALUES \r\n"
						+ "('" + po.getOrderDate() + "' , '" + po.getCreatedDate() + "', '"
						+ po.getNumberOfItems() + "', '" + po.getStatus() + "', '" + po.getTotalAmount() + "', '"
						+ po.getCustomerName() + "', '" + po.getMobileNumber() + "')");

		connection.close();

		String QUERY = "SELECT id FROM purchase_order WHERE id = " + po.getId();
		resultSet = statement.executeQuery(QUERY);

		while (resultSet.next()) {
			id = resultSet.getInt(1);
		}
		return id;
	}

	public PurchaseOrder getPurchaseOrderById(Integer id) throws SQLException {
		String QUERY = "SELECT * FROM purchase_order WHERE id = " + id;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PurchaseOrder purchaseOrder = null;
		connection = DbConnection.getConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(QUERY);

		while (resultSet.next()) {
			purchaseOrder = new PurchaseOrder();
			purchaseOrder.setId(resultSet.getLong(1));
			purchaseOrder.setOrderDate(resultSet.getDate(2));
			purchaseOrder.setCreatedDate(resultSet.getDate(3));
			purchaseOrder.setNumberOfItems(resultSet.getInt(4));
			purchaseOrder.setStatus(resultSet.getString(5));
			purchaseOrder.setTotalAmount(resultSet.getDouble(6));
			purchaseOrder.setCustomerName(resultSet.getString(7));
			purchaseOrder.setMobileNumber(resultSet.getString(8));

		}

		connection.close();

		return purchaseOrder;
	}
	
	public List<PurchaseOrder> getAllPurchaseOrder() throws SQLException {
		String QUERY = "SELECT * FROM purchase_order";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PurchaseOrder purchaseOrder = null;
		List<PurchaseOrder> purchaseOrderList = new ArrayList<PurchaseOrder>();
		connection = DbConnection.getConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(QUERY);

		while (resultSet.next()) {
			purchaseOrder = new PurchaseOrder();
			purchaseOrder.setId(resultSet.getLong(1));
			purchaseOrder.setOrderDate(resultSet.getDate(2));
			purchaseOrder.setCreatedDate(resultSet.getDate(3));
			purchaseOrder.setNumberOfItems(resultSet.getInt(4));
			purchaseOrder.setStatus(resultSet.getString(5));
			purchaseOrder.setTotalAmount(resultSet.getDouble(6));
			purchaseOrder.setCustomerName(resultSet.getString(7));
			purchaseOrder.setMobileNumber(resultSet.getString(8));

			purchaseOrderList.add(purchaseOrder);
		}

		connection.close();

		return purchaseOrderList;
   }

}
