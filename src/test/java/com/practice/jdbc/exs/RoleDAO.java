package com.practice.jdbc.exs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RoleDAO {

	public ArrayList<Role> getAllRoles() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			String QUERY = "SELECT * from role order by name;";
			ArrayList<Role> roleList = new ArrayList<Role>();
			connection = DbConnection.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QUERY);
			while (resultSet.next()) {
				roleList.add(new Role(resultSet.getInt(1), resultSet.getString(2)));
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
