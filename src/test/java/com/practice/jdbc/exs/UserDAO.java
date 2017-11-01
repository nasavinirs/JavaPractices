package com.practice.jdbc.exs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	private static final String QUERY = "SELECT u.id, u.name, r.id, r.name, c.id, c.street, c.city, c.state\r\n"
			+ "FROM user u\r\n" + "INNER JOIN contact c\r\n" + "ON u.contact_id = c.id\r\n" + "INNER JOIN role r\r\n"
			+ "ON u.role_id = r.id\r\n" + "ORDER BY u.name";

	/*
	 * public ArrayList<User> getAllUsers() { Connection connection = null;
	 * Statement statement = null; ResultSet resultSet = null; try { ArrayList<User>
	 * roleList = new ArrayList<User>(); connection = DbConnection.getConnection();
	 * statement = connection.createStatement(); resultSet =
	 * statement.executeQuery(QUERY); while (resultSet.next()) { roleList.add(new
	 * User(resultSet.getInt(1), resultSet.getString(2), new
	 * Role(resultSet.getInt(3), resultSet.getString(4)), new
	 * Contact(resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7),
	 * resultSet.getString(8)))); } return roleList; } catch (SQLException e) {
	 * e.printStackTrace(); } finally { try { connection.close(); } catch
	 * (SQLException e) { e.printStackTrace(); } } return null; }
	 */

	public void createUser(User user) throws Exception {
		Connection connection = null;
		Statement statement = null;

		connection = DbConnection.getConnection();
		statement = connection.createStatement();
		// Program:6
/*		statement.executeUpdate("INSERT INTO `user` (`name`, `username`, `password`, `mobile number`, `role`) VALUES \r\n" + 
							   "('" + user.getName() + "', '" + user.getUserName() + "' , '" + user.getPassword()+ "', '" + user.getMobileNumber()+ "', '" + user.getRole().getRoleName() + "')");
*/		
		connection.close();
	}

	public void displayDetails() throws Exception {
		String USERQUERY = "SELECT * FROM user";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<User> userList = new ArrayList<User>();
		System.out.println("User details:");
		System.out.format("%-15s %-15s %-15s %-15s %-15s %s\n", "User id", "Name", "User name", "Password",
				"Mobile number", "Role");
		try {
			connection = DbConnection.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(USERQUERY);
			while (resultSet.next()) {
				System.out.format("%-15s %-15s %-15s %-15s %-15s %s\n", resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
