/* package com.practice.iosw;

import java.util.Date;
import java.util.List;

class Shipment {
	Long id;
	String bookingNumber;
	Date departureDate;
	Date arrivalDate;
	Integer totalWeight;

	public Shipment(Long id, String bookingNumber, Date departureDate, Date arrivalDate, Integer totalWeight) {
		super();
		this.id = id;
		this.bookingNumber = bookingNumber;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.totalWeight = totalWeight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Integer getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(Integer totalWeight) {
		this.totalWeight = totalWeight;
	}

}

class Carrier {
	Long carrierId;
	String name;
	String code;
	List<Shipment> shipmentList;

	public Carrier(Long carrierId, String name, String code, List<Shipment> shipmentList) {
		super();
		this.carrierId = carrierId;
		this.name = name;
		this.code = code;
		this.shipmentList = shipmentList;
	}

	public Long getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(Long carrierId) {
		this.carrierId = carrierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Shipment> getShipmentList() {
		return shipmentList;
	}

	public void setShipmentList(List<Shipment> shipmentList) {
		this.shipmentList = shipmentList;
	}

}

public class DisplayShipmentDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
*/