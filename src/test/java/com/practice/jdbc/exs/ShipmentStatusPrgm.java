package com.practice.jdbc.exs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ShipmentStatusPrgm {

	public static void main(String ags[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ShipmentDAO shipmentDAO = new ShipmentDAO();
		List<Shipment> shipmentsList = new ArrayList<Shipment>();
		List<ShipmentStatus> shipmentStatusList = new ArrayList<ShipmentStatus>();
		shipmentsList = shipmentDAO.getAllShipment();
		shipmentStatusList = shipmentDAO.getAllShipmentStatus();
		System.out.println("List of the Shipment Details");
		System.out.format("%-5s %-20s %-20s %-20s %-10s %s\n", "Id", "Name", "Arrival PortName", "Departure PortName",
				"Cost", "Status");
		for (Shipment ship : shipmentsList) {
			System.out.format("%-5s %-20s %-20s %-20s %-10s %s\n", ship.getId(), ship.getName(),
					ship.getArrivalPortName(), ship.getDeparturePortName(), ship.getCost(),
					ship.getShipmentStatus().getName());
		}
		System.out.println("Select the shipment id to be updated");
		int num = Integer.parseInt(br.readLine());
		System.out.println("Select the id of new shipment status");
		for (ShipmentStatus status : shipmentStatusList) {
			System.out.println(status.getId() + "." + status.getName());
		}
		int new_id = Integer.parseInt(br.readLine());
		shipmentDAO.updateShipment(num, new_id);
		shipmentsList = shipmentDAO.getAllShipment();
		System.out.println("List of the updated Shipment Details");
		System.out.format("%-5s %-20s %-20s %-20s %-10s %s\n", "Id", "Name", "Arrival PortName", "Departure PortName",
				"Cost", "Status");
		for (Shipment ship : shipmentsList) {
			System.out.format("%-5s %-20s %-20s %-20s %-10s %s\n", ship.getId(), ship.getName(),
					ship.getArrivalPortName(), ship.getDeparturePortName(), ship.getCost(),
					ship.getShipmentStatus().getName());
		}
	}

}
