package com.practice.jdbc.exs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssignRolePrivilegesPrgm {

	public static void main(String[] args)
			throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		String[] rolesPrivilege;
		RoleDAO roleDAO = new RoleDAO();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrivilegeDAO privilegeDAO = new PrivilegeDAO();
		List<Privilege> privileges = privilegeDAO.getAllPrivileges();
		ArrayList<Privilege> privilegeList = new ArrayList<Privilege>();
		System.out.println("List of privileges :");
		System.out.format("%-15s %s\n", "Privilege ID", "Privilege Name");
		for (int i = 0; i < privileges.size(); i++) {
			System.out.format("%-15s %s\n", privileges.get(i).getId(), privileges.get(i).getName());
		}

		System.out.println("Enter number of new Roles to be created :");
		Integer n = Integer.parseInt(br.readLine());

		System.out.println("Enter the role and privileges :");

		for (int i = 0; i < n; i++) {
			rolesPrivilege = br.readLine().split(",");
			for (int j = 1; j < rolesPrivilege.length; j++) {
				privilegeList.add(new Privilege(rolesPrivilege[j]));
			}
			roleDAO.createRole(new Role(0, rolesPrivilege[0]), privilegeList);
		}

		System.out.println("Enter the Role :");
		String rol = br.readLine();
		System.out.println("Privileges for " + rol + " :");

		List<Privilege> privilegeByRole = roleDAO.getPrivilegeByRole(rol);

	} 

}
