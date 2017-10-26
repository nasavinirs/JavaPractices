package com.practice.iosw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class User {
	Long id;
	String firstName;
	String lastName;
	String username;
	String password;
	String mobileNumber;
	Role role;

	public User(Long id, String firstName, String lastName, String username, String password, String mobileNumber,
			Role role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.role = role;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}

class Role {
	Long roleId;
	String name;

	public Role(Long roleId, String name) {
		super();
		this.roleId = roleId;
		this.name = name;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class UserBO {
	public void saveAllUser(List<User> userList, String fileName) {
		List<User> uList = userList;
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
			for (User user : uList) {
				String line = user.getId() + "," + user.getFirstName() + "," + user.getLastName() + ","
						+ user.getUsername() + "," + user.getPassword() + "," + user.getMobileNumber() + ","
						+ user.getRole().getRoleId() + "," + user.getRole().getName();
				bw.write(line);
				bw.write("\n");
			}

		} catch (IOException e) {

			e.printStackTrace();

		}
		System.out.println("User Information saved successfully");
	}
}

public class DisplayUserDetailsPrgm {
	private static final String FILENAME = "src/test/java/com/practice/iosw/userrole.txt";

	public static void main(String[] args) throws IOException {
		List<User> userList = new ArrayList<User>();
		UserBO userBO = new UserBO();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of users:");
		int n = Integer.parseInt(br.readLine());
		String input[] = new String[n];
		Long id, roleId = 0L;
		String fname, lname, uname, password, mobile, role;
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the User ID");
			id = Long.parseLong(br.readLine());
			System.out.println("Enter the first name");
			fname = br.readLine();
			System.out.println("Enter the last name");
			lname = br.readLine();
			System.out.println("Enter the username");
			uname = br.readLine();
			System.out.println("Enter the password");
			password = br.readLine();
			System.out.println("Enter the mobile number");
			mobile = br.readLine();
			System.out.println("Enter the role name");
			role = br.readLine();
			if (role.equalsIgnoreCase("Admin"))
				roleId = (long) 100;
			else if (role.equalsIgnoreCase("Shipping Manager"))
				roleId = (long) 101;
			else if (role.equalsIgnoreCase("Purchase Manager"))
				roleId = (long) 102;
			userList.add(new User(id, fname, lname, uname, password, mobile, new Role(roleId, role)));
		}
		userBO.saveAllUser(userList, FILENAME);
	}

}
