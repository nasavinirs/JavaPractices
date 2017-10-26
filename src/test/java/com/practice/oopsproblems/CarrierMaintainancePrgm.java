package com.practice.oopsproblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface IMaintainCarrier {
	public Carrier createCarrier(String carrierValues);

	public Carrier retrieveCarrier(String carrierCode, Carrier[] carrierArray);

	public Boolean deleteCarrier(String carrierCode, Carrier[] carrierArray);

	public Boolean updateCarrier(String carrierCode, Carrier[] carrierArray, String carrierValues);
}

class Carrier implements IMaintainCarrier {
	private String iataCode;
	private String user;
	private String address;
	private String carrierCode;

	public Carrier() {
	}

	public Carrier(String iataCode, String user, String address, String carrierCode) {
		this.iataCode = iataCode;
		this.user = user;
		this.address = address;
		this.carrierCode = carrierCode;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public void display(Carrier[] carriers) {
		for (Carrier carrier : carriers) {
			if (carrier != null) {
				System.out.format("%-15s %-15s %-15s %s\n", carrier.getIataCode(), carrier.getUser(),
						carrier.getAddress(), carrier.getCarrierCode());
			}
		}
	}

	@Override
	public Carrier createCarrier(String carrierValues) {
		String[] input = carrierValues.split(",");
		Carrier carrier = new Carrier(input[0], input[1], input[2], input[3]);
		return carrier;
	}

	@Override
	public Carrier retrieveCarrier(String carrierCode, Carrier[] carrierArray) {
		for (int i = 0; i < carrierArray.length; i++) {
			if (carrierArray[i] !=null) {
				if (carrierArray[i].carrierCode.equals(carrierCode)) {
					return carrierArray[i];
				}
			}
		}
		return null;
	}

	@Override
	public Boolean deleteCarrier(String carrierCode, Carrier[] carrierArray) {
		for (int i = 0; i < carrierArray.length; i++) {
			if (carrierArray[i] !=null) {
				if (carrierArray[i].carrierCode.equals(carrierCode)) {
					carrierArray[i] = null;
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public Boolean updateCarrier(String carrierCode, Carrier[] carrierArray, String carrierValues) {
		String[] values = carrierValues.split(",");
		
		for (int i = 0; i < carrierArray.length; i++) {
			if (carrierArray[i] !=null) {
				if (carrierArray[i].carrierCode.equals(carrierCode)) {
					carrierArray[i].iataCode = values[0];
					carrierArray[i].user = values[1];
					carrierArray[i].address = values[2];
					return true;
				}
			}
		}
		
		return false;
	}

}

public class CarrierMaintainancePrgm {
	static Carrier[] carriers = new Carrier[100];

	public static void main(String[] args) throws IOException {
		Carrier carrier = new Carrier();
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		String val;
		int length = 0;
		do {
			System.out.println("Carrier Maintainance\n1.Create carrier\n2.Retrieve carrier");
			System.out.println("3.Delete carrier\n4.Update carrier\n5.Display\nEnter your choice :");
			int ch = Integer.parseInt(buff.readLine());
			switch (ch) {
			case 1:
				System.out.println("Enter the carrier values :");
				carriers[length++] = carrier.createCarrier(buff.readLine());
				System.out.println("Carrier successfully created.");
				break;
			case 2:
				System.out.println("Enter the carrier code to retrieve :");
				Carrier c = carrier.retrieveCarrier(buff.readLine(), carriers);
				if (c == null) {
					System.out.println("Carrier code not found.");
				} else {
					System.out.println("Carrier details :\nIATA code : " + c.getIataCode());
					System.out.println("User : " + c.getUser());
					System.out.println("Address : " + c.getAddress());
					System.out.println("Carrier code :" + c.getCarrierCode());
				}
				break;
			case 3:
				System.out.println("Enter the carrier code to delete :");
				if (carrier.deleteCarrier(buff.readLine(), carriers)) {
					System.out.println("Carrier successfully deleted.");
				} else {
					System.out.println("Carrier code not found.");
				}
				break;
			case 4:
				System.out.println("Enter the carrier code to update :");
				String code = buff.readLine();
				System.out.println("Enter the carrier values :");
				String value = buff.readLine();
				if (carrier.updateCarrier(code, carriers, value)) {
					System.out.println("Carrier successfully updated.");
				} else {
					System.out.println("Carrier code not found.");
				}
				break;
			case 5:
				System.out.format("%-15s %-15s %-15s %s\n", "IATA Code", "User Name", "Address", "Carrier code");
				carrier.display(carriers);
				break;
			}
			System.out.println("Do you want to continue(yes/no) :");
			val = buff.readLine();
		} while (val.equalsIgnoreCase("yes"));
	}
}
