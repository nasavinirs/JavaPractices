package com.practice.jdbc.exs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PrivilegeDAO {
	private static final String QUERY = "SELECT id, name FROM privilege";

	public List<Privilege> getAllPrivileges() throws SQLException, ClassNotFoundException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Privilege> privilegeList = new ArrayList<Privilege>();

		connection = DbConnection.getConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(QUERY);
		while (resultSet.next()) {
			privilegeList.add(new Privilege(resultSet.getInt(1), resultSet.getString(2)));
		}
		connection.close();

		return privilegeList;
	}

}