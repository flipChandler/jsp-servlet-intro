package br.com.felipesantos.employeemvc.dao;

import java.util.List;

import br.com.felipesantos.employeemvc.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	
	boolean save(Employee employee);
	
	Employee getEmployee(int id);
	
	boolean update(Employee employee);
	
	boolean deleteById(int id);
}
