package com.practice.jdbc.exs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShipmentDAO {

	List<Shipment> getAllShipment() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			String QUERY = "SELECT s.id, s.name, s.arrival_port_name, s.departure_port_name, s.cost, ss.id, ss.name, ss.code FROM shipment s\r\n"
					+ "INNER JOIN shipment_status ss\r\n" + "ON s.shipment_status_id = ss.id;";
			ArrayList<Shipment> shipmentList = new ArrayList<Shipment>();
			connection = DbConnection.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QUERY);
			while (resultSet.next()) {
				shipmentList.add(new Shipment(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getDouble(5),
						new ShipmentStatus(resultSet.getInt(6), resultSet.getString(7), resultSet.getInt(8))));
			}
			return shipmentList;
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

	List<ShipmentStatus> getAllShipmentStatus() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			String QUERY = "SELECT id, name, code FROM shipment_status;";
			ArrayList<ShipmentStatus> shipmentStatusList = new ArrayList<ShipmentStatus>();
			connection = DbConnection.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QUERY);
			while (resultSet.next()) {
				shipmentStatusList
						.add(new ShipmentStatus(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
			}
			return shipmentStatusList;
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

	void updateShipment(int shipmentId, int shipmentStatusId) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DbConnection.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate("UPDATE shipment SET shipment_status_id = " + shipmentStatusId + " WHERE id = " + shipmentId);
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
