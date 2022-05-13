package com.revature.services;

import java.sql.SQLException;

import com.revature.repositories.RoleDAO;

public class RoleService {

	RoleDAO rDAO = new RoleDAO();

	public void updateSalary(String roleTitle, int newSalary) throws SQLException {
		
		rDAO.updateSalary(roleTitle, newSalary);
		
	}
}
