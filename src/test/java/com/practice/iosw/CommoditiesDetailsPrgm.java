package com.practice.iosw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Commodity {
	Long commodityId;
	Double weight;
	Integer quantity;
	Boolean hazardous;
	Long containerId;

	public Commodity(Long commodityId, Double weight, Integer quantity, Boolean hazardous, Long containerId) {
		super();
		this.commodityId = commodityId;
		this.weight = weight;
		this.quantity = quantity;
		this.hazardous = hazardous;
		this.containerId = containerId;
	}

	public Long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getHazardous() {
		return hazardous;
	}

	public void setHazardous(Boolean hazardous) {
		this.hazardous = hazardous;
	}

	public Long getContainerId() {
		return containerId;
	}

	public void setContainerId(Long containerId) {
		this.containerId = containerId;
	}

	@Override
	public String toString() {
		return "Commodity [commodityId=" + commodityId + ", weight=" + weight + ", quantity=" + quantity
				+ ", hazardous=" + hazardous + ", containerId=" + containerId + "]";
	}

	
}

class CommodityBO {
	public List<Commodity> readCommodity(String fileName) {
		List<Commodity> commodityList = new ArrayList<Commodity>();
		String sCurrentLine, splitStr[];
		boolean isHazardous = false; 
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((sCurrentLine = br.readLine()) != null) {
				splitStr = sCurrentLine.split(",");
				if (splitStr[3].equals("1"))
					isHazardous = true;
				else 
					isHazardous = false;
				commodityList.add(new Commodity(Long.parseLong(splitStr[0]), Double.parseDouble(splitStr[1]),
						Integer.parseInt(splitStr[2]), isHazardous, Long.parseLong(splitStr[4])));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return commodityList;
	}

	public void checkCommodity(List<Commodity> commodityList) {
		double weight = 0;
		int quantity = 0;
		boolean isHazardous = false;
		
		List<Commodity> cList = commodityList;
		
		for(Commodity commodity : commodityList) {
			weight += commodity.getWeight();
			quantity += commodity.getQuantity();
			if(commodity.getHazardous())
				isHazardous = true;
		}
		
		System.out.println("Total Weight: " + weight);
		System.out.println("Total Quantity: " + quantity);
		if(isHazardous)
			System.out.println("Hazardous Commodity Found!");

	}
}

public class CommoditiesDetailsPrgm {
	private static final String FILENAME = "src/test/java/com/practice/iosw/commodity.txt";

	public static void main(String[] args) {
		List<Commodity> commodityList = new ArrayList<Commodity>();
		CommodityBO shipmentBO = new CommodityBO();

		commodityList.addAll(shipmentBO.readCommodity(FILENAME));
		shipmentBO.checkCommodity(commodityList);
	}

}
