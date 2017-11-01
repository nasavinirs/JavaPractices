package com.practice.jdbc.exs;

import java.util.*;
import java.sql.*;

public class CargoDAO {

	public List<Cargo> filterCargoByWeight(Float weight) throws Exception
    {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			String QUERY = "SELECT id, name, width, height, weight FROM cargodetail WHERE weight > " + weight;
			List<Cargo> cargoList = new ArrayList<Cargo>();
			connection = DbConnection.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QUERY);
			while (resultSet.next()) {
				cargoList.add(new Cargo(resultSet.getInt(1), resultSet.getString(2), resultSet.getFloat(3), resultSet.getFloat(4), resultSet.getFloat(5)));
			}
			return cargoList;
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
