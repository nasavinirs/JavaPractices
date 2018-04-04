package com.practice.jdbc.exs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

	public List<Item> getAllItems() throws SQLException {
		String QUERY = "SELECT * FROM item";
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
			item.setId(resultSet.getLong(1));
			item.setName(resultSet.getString(2));
			item.setAvailableQuantity(resultSet.getInt(3));
			item.setPrice(resultSet.getDouble(4));			
			itemList.add(item);
		}

		connection.close();
		
		return itemList;
		
	}
}
