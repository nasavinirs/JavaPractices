package com.practice.jdbc.exs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TestConnection {

	public static void main(String[] args) {
		System.out.println("Driver loading success!");
		ResourceBundle rb = ResourceBundle.getBundle("mysql");
		String url = rb.getString("db.url");
		//String username = rb.getString("db.username");
		String password = rb.getString("db.password");
		//String url = "jdbc:mysql://192.168.56.101:3306/userrole";
		String username = "root";
		//String password = "root";
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connected.");
			String QUERY = "SELECT * from role order by name;";
			ArrayList<Role> roleList = new ArrayList<Role>();
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY);
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " : " + resultSet.getString(2));
			}
			con.close();
			System.out.println("Disconnected.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
