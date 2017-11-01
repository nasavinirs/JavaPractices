package com.practice.jdbc.exs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {

	/*
	 * Program-3 : public ArrayList<Role> getAllRoles() { Connection connection =
	 * null; Statement statement = null; ResultSet resultSet = null; try { String
	 * QUERY = "SELECT * from role order by name;"; ArrayList<Role> roleList = new
	 * ArrayList<Role>(); connection = DbConnection.getConnection(); statement =
	 * connection.createStatement(); resultSet = statement.executeQuery(QUERY);
	 * while (resultSet.next()) { roleList.add(new Role(resultSet.getInt(1),
	 * resultSet.getString(2))); } return roleList; } catch (SQLException e) {
	 * e.printStackTrace(); } finally { try { connection.close(); } catch
	 * (SQLException e) { e.printStackTrace(); } } return null; }
	 */

	public void createRole(Role roleIns, ArrayList<Privilege> privilegeList)
			throws SQLException, ClassNotFoundException {
		String ROLEQUERY, PRIVILEGEQUERY;
		List<Privilege> pList = privilegeList;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Role> rList  = new ArrayList<Role>(); 
		connection = DbConnection.getConnection();
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO role(name) VALUES('" + roleIns.getName() + "');");

		ROLEQUERY = "SELECT id FROM role WHERE name = '" + roleIns.getName() + "'";
		

		resultSet = statement.executeQuery(ROLEQUERY);

		while (resultSet.next()) {
			privilegeList.add(new Privilege());
			PRIVILEGEQUERY = "SELECT id FROM privilege WHERE name = '" + resultSet.getString(1) + "'";
		}

		connection.close();

	}

	public List<Privilege> getPrivilegeByRole(String role) throws ClassNotFoundException, SQLException {
		String QUERY = "SELECt p.name FROM privilege p\r\n" + 
					   "INNER JOIN role_privilege rp\r\n" + 
					   "ON p.id = rp.privilege_id\r\n" + 
					   "INNER JOIN role r\r\n" + "ON r.id = rp.role_id\r\n" + 
					   "WHERE r.name = '" + role + "'";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Privilege> privilegeList = new ArrayList<Privilege>();

		connection = DbConnection.getConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(QUERY);
		while (resultSet.next()) {
			privilegeList.add(new Privilege(resultSet.getString(1)));
		}

		return privilegeList;
	}

	// Program-4:
	/*
	 * public List<Role> getAllRoles() throws Exception { Connection connection =
	 * null; Statement statement = null; ResultSet resultSet = null; try { String
	 * QUERY = "SELECT * FROM role ORDER BY name;"; ArrayList<Role> roleList = new
	 * ArrayList<Role>(); connection = DbConnection.getConnection(); statement =
	 * connection.createStatement(); resultSet = statement.executeQuery(QUERY);
	 * while (resultSet.next()) { roleList.add(new Role(resultSet.getInt(1),
	 * resultSet.getString(2), resultSet.getString(3))); } return roleList; } catch
	 * (SQLException e) { e.printStackTrace(); } finally { try { connection.close();
	 * } catch (SQLException e) { e.printStackTrace(); } } return null;
	 * 
	 * }
	 */

}
