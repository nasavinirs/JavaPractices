package com.practice.iosw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Shipment {
	Long id;
	String bookingNumber;
	Date departureDate;
	Date arrivalDate;
	Integer totalWeight;
	String status;

	public Shipment(Long id, String bookingNumber, Date departureDate, Date arrivalDate, Integer totalWeight,
			String status) {
		this.id = id;
		this.bookingNumber = bookingNumber;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.totalWeight = totalWeight;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

class ShipmentBO {

	String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Shipment> readShipmentDetails(String fileName) {
		List<Shipment> sList = new ArrayList<Shipment>();
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		Date arrivalDate, departureDate;
		String sCurrentLine, splitStr[];
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((sCurrentLine = br.readLine()) != null) {
				splitStr = sCurrentLine.split(",");				
				departureDate = df.parse(splitStr[2]);
				arrivalDate = df.parse(splitStr[3]);
				sList.add(new Shipment(Long.parseLong(splitStr[0]), splitStr[1], departureDate, arrivalDate,
						Integer.parseInt(splitStr[4]), splitStr[5]));
			}
		} catch (ParseException pe) {
			pe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sList;
	}

	public List<Shipment> filterByStatus(List<Shipment> shipmentList, String status) {
		List<Shipment> filteredList = new ArrayList<Shipment>();
		for (Shipment shipment : shipmentList) {
			if (shipment.getStatus().equalsIgnoreCase(status)) {
				filteredList
						.add(new Shipment(shipment.getId(), shipment.getBookingNumber(), shipment.getDepartureDate(),
								shipment.getArrivalDate(), shipment.getTotalWeight(), shipment.getStatus()));
			}
		}
		return filteredList;
	}

	public void saveShipments(List<Shipment> shipmentList, String outputfile) {
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		List<Shipment> sList = shipmentList;
		String line;
		int countStatus = 0, lineNo = 1;
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputfile))) {
			for (Shipment shipment : sList) {
				if (shipment.getStatus().equalsIgnoreCase(status)) {
					countStatus++;
					line = shipment.getId() + "," + shipment.getBookingNumber() + "," + df.format(shipment.getDepartureDate())
							+ "," + df.format(shipment.getArrivalDate()) + "," + shipment.getTotalWeight() + ","
							+ shipment.getStatus();
					bw.write(line);
					if(lineNo != sList.size())
						bw.newLine();
					lineNo++;
				}				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (countStatus < 1)
				System.out.println("There are none in " + status + " status");
			else if (countStatus == 1)
				System.out.println("There is " + countStatus + " in '" + status + "' status ");
			else if (countStatus > 1)
				System.out.println("There are " + countStatus + " in '" + status + "' status ");
		}
	}
}

public class ShipmentStatusPrgm {
	private static final String INPUTFILE = "src/test/java/com/practice/iosw/shin.txt";
	private static final String OUTPUTFILE = "src/test/java/com/practice/iosw/shout.txt";

	public static void main(String[] args) throws IOException {
		ShipmentBO shipmentBO = new ShipmentBO();
		List<Shipment> shipmentList = new ArrayList<Shipment>();
		List<Shipment> filteredShipmentList = new ArrayList<Shipment>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the status to be filtered");
		String statusFilter = br.readLine();
		shipmentBO.setStatus(statusFilter);
		shipmentList.addAll(shipmentBO.readShipmentDetails(INPUTFILE));
		filteredShipmentList.addAll(shipmentBO.filterByStatus(shipmentList, statusFilter));
		shipmentBO.saveShipments(filteredShipmentList, OUTPUTFILE);
	}

}
