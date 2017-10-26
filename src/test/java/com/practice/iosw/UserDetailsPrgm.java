/* package com.practice.iosw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class User {
	Long id;
	String firstName;
	String lastName;
	String username;
	String password;
	String mobileNumber;

	public User() {

	}

	public User(Long id, String firstName, String lastName, String username, String password, String mobileNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return String.format("%-10s %-15s %-15s %-15s %-15s %s", id, firstName, lastName, username, password,
				mobileNumber);
	}

}

public class UserDetailsPrgm {
	private static final String FILENAME = "src/test/java/com/practice/iosw/test.txt";

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			List<User> userList = new ArrayList<User>();
			String sCurrentLine, splitStr[];
			while ((sCurrentLine = br.readLine()) != null) {
				splitStr = sCurrentLine.split(" ");
				for (int i = 0; i < splitStr.length; i++) {
					String id= splitStr[i].replaceAll("[^0-9]", "");
					String firstName= splitStr[i].replaceAll("[^a-zA-Z]", "");
					System.out.println(id + " " + firstName);
				}
				//String id= splitStr[0].replaceAll("[^0-9]", "");
				//String firstName= splitStr[0].replaceAll("[^a-zA-Z]", "");
				//System.out.format("%-10s %-15s %-15s %-15s %-15s %s\n", id, firstName, splitStr[0], splitStr[2], splitStr[3], splitStr[4]);
				//userList.add(new User(Long.parseLong(id), firstName, splitStr[2], splitStr[3], splitStr[4], splitStr[5]));
			}
			System.out.format("%-10s %-15s %-15s %-15s %-15s %s\n", "Id", "First Name", "Last Name", "Username",
					"Password", "Mobile Number");
			//for (User user : userList) {
			//	System.out.println(user);
			//}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
*/