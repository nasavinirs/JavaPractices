package com.practice.jdbc.exs;

public class UserContactRolePrgm {

	public static void main(String[] args) {
		System.out.format("%-10s %-20s %-25s %-10s %-10s \n", "User", "Role", "Street", "City", "State");
		UserDAO userDAO = new UserDAO();
		for (User user : userDAO.getAllUsers()) {
			System.out.format("%-10s %-20s %-25s %-10s %-10s \n", user.getName(), user.getRole().getName(),
					user.getContact().getStreet(), user.getContact().getCity(), user.getContact().getState());
		}
	}

}
