package com.practice.oopsproblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class User {
	String userName;
	String firstName;
	String lastName;
	String contact;

	public User() {

	}

	public User(String userName, String firstName, String lastName, String contact) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public User findUser(User userArray[], String userName) {
		for (int i = 0; i < userArray.length; i++) {
			User user = userArray[i];
			if (user.getUserName().equals(userName)) {
				return user;
			}
		}
		return null;
	}

	public User findUser(User userArray[], String firstName, String lastName) {
		for (int i = 0; i < userArray.length; i++) {
			User user = userArray[i];
			if (user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) {
				return user;
			}
		}
		return null;
	}
}

public class DisplayUserDetails {

	public static void main(String[] args) throws Exception {

		List<User> userList = new ArrayList<User>();
		String input[], userName, firstName, lastName;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the total number of users");
		int nos = Integer.parseInt(br.readLine());
		User user = new User();
		User[] userArray = new User[nos];
		System.out.println("Enter user details");
		for (int i = 0; i < nos; i++) {
			input = br.readLine().split(",");
			userArray[i] = new User(input[0], input[1], input[2], input[3]);
		}
		System.out.println("1)Search user by user name");
		System.out.println("2)Search user by first name and last name");
		System.out.println("Enter your option");
		int ch = Integer.parseInt(br.readLine());
		if (ch == 1) {
			System.out.println("Enter the user name to search");
			userName = br.readLine();
			user = user.findUser(userArray, userName);
		} else if (ch == 2) {
			System.out.println("Enter the first name to search");
			firstName = br.readLine();
            System.out.println("Enter the last name to search");            
			lastName = br.readLine();
			user = user.findUser(userArray, firstName, lastName);
		}

		if (user != null) {
			System.out.println("User details :");
			System.out.println("Username :" + user.getUserName());
			System.out.println("FirstName :" + user.getFirstName());
			System.out.println("LastName :" + user.getLastName());
			System.out.println("Contact :" + user.getContact());
		} else {
			System.out.println("User not found");
		}
	}

}

/*
 package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class User {
	String userName;
	String firstName;
	String lastName;
	String contact;

	public User() {

	}

	public User(String userName, String firstName, String lastName, String contact) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public User findUser(User userArray[], String userName) {
		List<User> userList = new ArrayList<User>(Arrays.asList(userArray));
		Iterator<User> iterator = userList.iterator(); 
		while (iterator.hasNext()) {
			User user = (User) iterator.next();
			if(user.getUserName().equals(userName)) {
				return user;
			}
		}
		return null;
	}

	public User findUser(User userArray[], String firstName, String lastName) {
		List<User> userList = new ArrayList<User>(Arrays.asList(userArray));
		Iterator<User> iterator = userList.iterator(); 
		while (iterator.hasNext()) {
			User user = (User) iterator.next();
			if(user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) {
				return user;
			}
		}
		return null;
	}
}

public class DisplayUserDetails {

	public static void main(String[] args) throws Exception {
		User user = new User();
		List<User> userList = new ArrayList<User>();
		String input[], userName, firstName, lastName;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the total number of users");
		int nos = Integer.parseInt(br.readLine());
		System.out.println("Enter user details");
		for (int i = 0; i < nos; i++) {
			input = br.readLine().split(",");
			userList.add(new User(input[0], input[1], input[2], input[3]));
		}
		User userArray[] = userList.toArray(new User[userList.size()]);
		System.out.println("1)Search user by user name");
		System.out.println("2)Search user by first name and last name");
		System.out.println("Enter your option");
		int ch = Integer.parseInt(br.readLine());
		if(ch == 1) {
			System.out.println("Enter the user name to search");
			userName = br.readLine();
			user = user.findUser(userArray, userName);
		} else if(ch == 2) {
			System.out.println("Enter the first name and last name to search");
			firstName = br.readLine();
			lastName = br.readLine();
			user = user.findUser(userArray, firstName, lastName);
		}
		
		if(user != null) {
			System.out.println("User details :");
			System.out.println("Username :" + user.getUserName());
			System.out.println("FirstName :" + user.getFirstName());
			System.out.println("LastName :" + user.getLastName());
			System.out.println("Contact :" + user.getContact());
		} else {
			System.out.println("User not found");
		}
	}

}

 * */
