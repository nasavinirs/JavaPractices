package com.practice.jdbc.exes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.practice.jdbc.exes.DbConnection;
import com.practice.jdbc.exes.Item;

public class ItemDAO {
	
	public List<Item> getAllItems() throws ClassNotFoundException, SQLException {

		String QUERY = "SELECT * FROM item order by id";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Item> itemList = new ArrayList<Item>();
		Item item = null;
		connection = DbConnection.getConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(QUERY);

		while (resultSet.next()) {
			item = new Item();
			item.setId(resultSet.getString(1));
			item.setName(resultSet.getString(2));
			item.setPrice(resultSet.getDouble(3));			
			itemList.add(item);
		}

		connection.close();
		
		return itemList;
		
	}

	
	public void updateItemPrice(Item item, Double price) throws ClassNotFoundException, SQLException {

		Connection connection = null;
		Statement statement = null;
		connection = DbConnection.getConnection();
		statement = connection.createStatement();
		statement.executeUpdate("UPDATE item SET price='" + price + "' WHERE id='" +  item.getId() + "'");		
		connection.close();	

	}
	
}