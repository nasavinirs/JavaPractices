package com.practice.jdbc.exs;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PurchaseOrderBO {

	
	//TODO: Need to complete this method
	/*public Integer createPurchaseOrder(List<Item> items, Integer[] quantity, String customerName, String mobileNumber,
			Date orderDate) {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		OrderLine orderLine = new OrderLine();
		
	}*/

	public PurchaseOrder getPurchaseOrderById(Integer id) throws SQLException {

		PurchaseOrderDAO purchaseOrderDAO = new PurchaseOrderDAO();
		return purchaseOrderDAO.getPurchaseOrderById(id);
	}

	public List<PurchaseOrder> getAllPurchaseOrder() throws SQLException {
		PurchaseOrderDAO purchaseOrderDAO = new PurchaseOrderDAO();
		return purchaseOrderDAO.getAllPurchaseOrder();
		
	}

}
