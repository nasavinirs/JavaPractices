package com.practice.jdbc.exs;



public class RoleDetailsPrgm {

	public static void main(String[] args) {
		RoleDAO roleDAO = new RoleDAO();
		for (Role role : roleDAO.getAllRoles()) {
			System.out.println(role.getName());
		}
	}

}
