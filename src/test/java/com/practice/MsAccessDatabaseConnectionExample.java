package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MsAccessDatabaseConnectionExample {

	public static void main(String[] args) {

		// variables
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\309934\\Documents\\Employee.accdb");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Employee");
			System.out.println("==\t================\t============\t\t========");
			System.out.println("ID\tName\t\t\tDesignation\t\tSalary");
			System.out.println("==\t================\t============\t\t========");

			// processing returned data and printing into console
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t\t\t"
						+ resultSet.getString(3) + "\t\t\t" + resultSet.getString(4));
			}
			System.out.println("==\t================\t============\t\t========");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
