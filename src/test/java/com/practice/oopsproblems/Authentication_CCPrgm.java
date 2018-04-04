package com.practice.oopsproblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Account {
	String username;
	String password;
	int cvv;
	byte[] fingerPrint;

	public Account(String username, String password, int cvv, byte[] fingerPrint) {
		this.username = username;
		this.password = password;
		this.cvv = cvv;
		this.fingerPrint = fingerPrint;
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

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public byte[] getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(byte[] fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public Boolean authentication(String username, String password) {
		if (username.equalsIgnoreCase(getUsername()) && password.equalsIgnoreCase(getPassword()))
			return true;
		else
			return false;
	}

	public Boolean authentication(String username, int cvv) {
		if (username.equalsIgnoreCase(getUsername()) && cvv == getCvv())
			return true;
		else
			return false;
	}

	public Boolean authentication(byte[] fingerPrint) {
		if (Arrays.equals(fingerPrint, getFingerPrint()))
			return true;
		else
			return false;
	}

}

public class Authentication_CCPrgm {

	public static void main(String args[]) throws IOException {
		String username, password;
		int cvv;
		byte[] fingerPrint;
		boolean result = false;
		Account accountArray[] = new Account[5];
		accountArray[0] = new Account("vicky", "vicky123", 999, "0011".getBytes());
		accountArray[1] = new Account("mark", "mark007", 100, "1111".getBytes());
		accountArray[2] = new Account("priya", "priya332", 444, "0101".getBytes());
		accountArray[3] = new Account("max", "max232", 555, "0001".getBytes());
		accountArray[4] = new Account("martin", "martin345", 888, "0010".getBytes());
		System.out.println("Enter the login mode");
		System.out.println("1)Browser\n2)Wallet\n3)Mobile");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice = Integer.parseInt(br.readLine());
		switch (choice) {
		case 1:
			System.out.println("Enter the username");
			username = br.readLine();
			System.out.println("Enter the password");
			password = br.readLine();
			for (int i = 0; i < accountArray.length; i++) {
				if (username.equalsIgnoreCase(accountArray[i].getUsername())
						&& password.equalsIgnoreCase(accountArray[i].getPassword())) {
					result = accountArray[i].authentication(username, password);
				}
			}
			break;
		case 2:
			System.out.println("Enter the username");
			username = br.readLine();
			System.out.println("Enter the CVV");
			cvv = Integer.parseInt(br.readLine());
			for (int i = 0; i < accountArray.length; i++) {
				if (username.equalsIgnoreCase(accountArray[i].getUsername()) && cvv == accountArray[i].getCvv()) {
					result = accountArray[i].authentication(username, cvv);
				}
			}
			break;
		case 3:
			System.out.println("Enter the fingerprint");
			fingerPrint = br.readLine().getBytes();
			for (int i = 0; i < accountArray.length; i++) {
				if(Arrays.equals(fingerPrint, accountArray[i].getFingerPrint()))
				{
					result = accountArray[i].authentication(fingerPrint);	
				}				
			}
			break;
		}
		if (result)
			System.out.println("Authentication successful");
		else
			System.out.println("Authentication failed ");

	}

}
