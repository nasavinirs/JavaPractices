package com.practice.jdbc.exs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {

    public static Connection getConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
        ResourceBundle rb = ResourceBundle.getBundle("mysql");
        String url = rb.getString("db.url");
        String username = rb.getString("db.username");
        String password = rb.getString("db.password");
		Connection connection = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, "root", "root");
			return connection;
		}  catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
		return null;
    }

    
}
