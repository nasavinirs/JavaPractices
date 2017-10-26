package com.practice.jdbc.exs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO {
	private static final String QUERY = "SELECT u.id, u.name, r.id, r.name, c.id, c.street, c.city, c.state\r\n"
			+ "FROM user u\r\n" + "INNER JOIN contact c\r\n" + "ON u.contact_id = c.id\r\n" + "INNER JOIN role r\r\n"
			+ "ON u.role_id = r.id\r\n" + "ORDER BY u.name";

	public ArrayList<User> getAllUsers() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			ArrayList<User> roleList = new ArrayList<User>();
			connection = DbConnection.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QUERY);
			while (resultSet.next()) {
				roleList.add(new User(resultSet.getInt(1), resultSet.getString(2),
						new Role(resultSet.getInt(3), resultSet.getString(4)), new Contact(resultSet.getInt(5),
								resultSet.getString(6), resultSet.getString(7), resultSet.getString(8))));
			}
			return roleList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
