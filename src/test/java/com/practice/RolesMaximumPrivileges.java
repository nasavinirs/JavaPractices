package com.practice;

class Privilege {
	String name;

	public Privilege(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Role {
	String name;
	String description;
	Privilege[] privilege;

	public Role(String name, String description, Privilege[] privilege) {
		this.name = name;
		this.description = description;
		this.privilege = privilege;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Privilege[] getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege[] privilege) {
		this.privilege = privilege;
	}

}

class RoleBO {
	public void display(Role[] role) {

	}
}

public class RolesMaximumPrivileges {

}
