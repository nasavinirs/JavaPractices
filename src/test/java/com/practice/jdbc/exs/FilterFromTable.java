package com.practice.jdbc.exs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FilterFromTable {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Cargo> cargoList = new ArrayList<>();
		CargoDAO cargoDAO = new CargoDAO();
		System.out.println("Enter the weight to filter:");
		Float weight = Float.parseFloat(br.readLine());

		cargoList = cargoDAO.filterCargoByWeight(weight);

		if (cargoList.size() == 0)
			System.out.println("No cargo found");
		else {
			System.out.format("%-15s %-25s %-15s %-15s %s\n", "Cargo id", "Cargo name", "Width", "Height",
					"Cargo weight");
			for (Cargo cargo : cargoList) {
				System.out.format("%-15s %-25s %-15.2f %-15.2f %.2f\n", cargo.getId(), cargo.getName(), cargo.getWidth(),
						cargo.getHeight(), cargo.getWeight());
			}
		}
	}

}
