package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.utilities.ConnectionFactory;

public class EmployeeDAO {

	public List<Employee> getEmployees() throws SQLException {
		try(Connection conn = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			
			String sql = "select * from employees;";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<Employee> employeeList = new ArrayList<>();
			
			while(rs.next()) {
				Employee e = new Employee(
						rs.getInt("employee_id"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getInt("role_id")				
						);
				employeeList.add(e);
			}
			return employeeList;
		}
		catch (SQLException e) {
			System.out.println("Something went wrong while getting employees");
			e.printStackTrace();
			return null;
		}
	}

	public void insertEmployee(Employee newEmployee) throws SQLException {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "insert into employees (f_name, l_name, role_id) " + "values (?, ?, ?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, newEmployee.getF_name());
			ps.setString(2, newEmployee.getL_name());
			ps.setInt(3, newEmployee.getRole_id());
			
			ps.executeUpdate();
			
			System.out.println("Employee " + newEmployee.getF_name() + " was created. Welcome to the team!");
		}
		catch(SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
	}

	public List<Employee> getEmployeeById(int id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			
			String sql = "select * from employees where employee_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			List<Employee> employeeList = new ArrayList<>();
			
			while(rs.next()) {
				Employee e = new Employee(
						rs.getInt("employee_id"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getInt("role_id")				
						);
				employeeList.add(e);
			}
			return employeeList;			
		}
		catch(SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
			return null;
		}		
		
	}

	public List<Employee> getEmployeesByRoleTitle(String roleTitle) {
		try(Connection conn = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			
			String sql = "select * from employees inner join roles " + "on employees.role_id = roles.role_id where roles.role_title = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, roleTitle);
			
			rs = ps.executeQuery();
			
			List<Employee> employeeList = new ArrayList<>();
			
			while(rs.next()) {
				Employee e = new Employee(
						rs.getInt("employee_id"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getInt("role_id")				
						);
				employeeList.add(e);
			}
			return employeeList;				
		}
		catch(SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
			return null;
		}
	}

}
