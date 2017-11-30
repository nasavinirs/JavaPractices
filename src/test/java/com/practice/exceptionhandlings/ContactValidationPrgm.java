package com.practice.exceptionhandlings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class InvalidContactException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidContactException(String message) {
		super(message);
	}
}

class Contact {
	String name;
	String streetName;
	String address;
	String city;
	String state;
	String phoneNumber;
	String email;

	public Contact(String name, String streetName, String address, String city, String state, String phoneNumber,
			String email) {
		this.name = name;
		this.streetName = streetName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

class ContactBO {
	private Pattern regexPattern;
	private Matcher regMatcher;

	public boolean validateContactDetails(Contact co) throws InvalidContactException {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		regexPattern = Pattern.compile(EMAIL_PATTERN);
		regMatcher = regexPattern.matcher(co.getEmail());
		if ((co.getStreetName().equals("") || co.getAddress().equals("") || co.getCity().equals("")
				|| co.getState().equals(""))) {
			throw new InvalidContactException("InvalidContactException: Make sure you entered all the fields");
		} else if(co.getPhoneNumber().length() != 10) {
			throw new InvalidContactException("InvalidContactException: Invalid Phone Number");
		} else if(!regMatcher.matches()) {
			throw new InvalidContactException("InvalidContactException: Invalid Email Address");
		}  
		else {
			return true;
		}
	}
}

public class ContactValidationPrgm {

	public static void main(String[] args) {
		try {
			ContactBO contactBO = new ContactBO();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("CONTACT DETAILS");
			System.out.println("Enter the name:");
			String name = br.readLine();
			System.out.println("Enter the street name:");
			String streetName = br.readLine();
			System.out.println("Enter the address:");
			String address = br.readLine();
			System.out.println("Enter the city:");
			String city = br.readLine();
			System.out.println("Enter the state:");
			String state = br.readLine();
			System.out.println("Enter the phone number:");
			String phoneNumber = br.readLine();
			System.out.println("Enter the email id:");
			String email = br.readLine();
			Contact contact = new Contact(name, streetName, address, city, state, phoneNumber, email);
			boolean validate = contactBO.validateContactDetails(contact);
			if (validate) {
				System.out.println("Contact is valid");
			}
		} catch (InvalidContactException ice) {
			System.out.println(ice.getMessage());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

	}

}
