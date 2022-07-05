package br.com.felipesantos.employeemvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.felipesantos.employeemvc.entity.Employee;
import br.com.felipesantos.employeemvc.util.DbConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;

	@Override
	public List<Employee> findAll() {

		// create references variables
		List<Employee> employees = null;
		Employee employee = null;

		try {
			employees = new ArrayList<>();

			// create sql query
			String sql = "SELECT * FROM tbl_employee";

			// get the database connection
			connection = DbConnectionUtil.openConnection();

			// create a statement
			statement = connection.createStatement();

			// execute the sql query
			resultSet = statement.executeQuery(sql);

			// process the resultset
			while (resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setDob(resultSet.getString("dob"));

				employees.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public boolean save(Employee employee) {
		boolean flag = false;

		String sql = "INSERT INTO tbl_employee (name, dob, department) " + "VALUES (?, ?, ?)";

		try {
			connection = DbConnectionUtil.openConnection();

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getDob());
			preparedStatement.setString(3, employee.getDepartment());

			preparedStatement.executeUpdate();

			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public Employee getEmployee(int id) {
		Employee employee = null;
		String sql = "SELECT * FROM tbl_employee WHERE id = " + id;

		try {
			employee = new Employee();
			connection = DbConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setDob(resultSet.getString("dob"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}

	@Override
	public boolean update(Employee employee) {
		boolean flag = false;
		String sql = "UPDATE tbl_employee SET name = ?, dob = ?, department = ? WHERE id = ?";

		try {
			connection = DbConnectionUtil.openConnection();

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getDob());
			preparedStatement.setString(3, employee.getDepartment());
			preparedStatement.setInt(4, employee.getId());

			preparedStatement.executeUpdate();

			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteById(int id) {
		boolean flag = false;
		String sql = "DELETE FROM tbl_employee WHERE id = ?";

		try {
			connection = DbConnectionUtil.openConnection();

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);			

			preparedStatement.executeUpdate();

			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
