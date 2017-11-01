package com.practice.jdbc.exs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class AssignRoleToUserPrgm {

	/* public static void main(String[] args) throws Exception {
		int choice, roleId, c = 0;
		String userDetails[];
		Role role = null;
		List<Role> roleList = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		User user;
		RoleDAO roleDAO = new RoleDAO();
		UserDAO userDAO = new UserDAO();
		while (true) {
			System.out.println("1. Create User\n2. Display Details\n3. Exit\nEnter the choice :");
			choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1:
				System.out.println("Enter the user details:");
				userDetails = br.readLine().split(",");

				System.out.println("Role details:");
				System.out.format("%-15s %-25s %s\n", "Role id", "Role name", "Role description");
				roleList = roleDAO.getAllRoles();
				for (Role rol : roleList) {
					System.out.format("%-15s %-25s %s\n", rol.getId(), rol.getRoleName(), rol.getDescription());
				}
				System.out.println("Enter the role id:");
				roleId = Integer.parseInt(br.readLine());
				for(Role rol : roleList) {
					if(rol.getId() == roleId) {
						role = new Role(rol.getId(), rol.getRoleName(), rol.getDescription());
					}
				}
				user = new User(userDetails[0], userDetails[1], userDetails[2], userDetails[3], role);
				userDAO.createUser(user);
				break;
			case 2:
				userDAO.displayDetails();
				break;
			case 3:
				System.exit(0);
			}
		} 
	} */

}
