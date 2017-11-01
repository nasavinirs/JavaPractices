package com.practice.jdbc.exs;

import java.util.ArrayList;

/* Program-1 : User Role

public class Role {

	private Integer id;
	private String name;

	public Role(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
} */



// Program-3: 

public class Role {

    private Integer id;
    private String name;
    private ArrayList<Privilege> privilegeList;

    public Role(){}
    
    public Role(String name) {
        this.name = name;
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role(Integer id, String name, ArrayList<Privilege> privilegeList) {
        this.id = id;
        this.name = name;
        this.privilegeList = privilegeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Privilege> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(ArrayList<Privilege> privilegeList) {
        this.privilegeList = privilegeList;
    }
} 


// Program-4:

/* public class Role {
    private Integer id;
    private String roleName;
    private String description;

    public Role(Integer id, String roleName, String description) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

} */

