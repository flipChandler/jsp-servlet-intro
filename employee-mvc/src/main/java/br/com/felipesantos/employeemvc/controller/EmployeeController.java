package br.com.felipesantos.employeemvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipesantos.employeemvc.dao.EmployeeDAO;
import br.com.felipesantos.employeemvc.dao.EmployeeDAOImpl;
import br.com.felipesantos.employeemvc.entity.Employee;

public class EmployeeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;

	// create a reference variable for employee dao
	EmployeeDAO employeeDAO = null;

	// create constructor and initialize employeeDAO w/ employeDAOImpl
	public EmployeeController() {
		this.employeeDAO = new EmployeeDAOImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			action = "LIST";
		}

		switch (action) {
			case "LIST":
				listEmployees(request, response);
				break;
			
			case "EDIT": 
				getEmployee(request, response);
				break;
				
			case "DELETE": 
				deleteEmployee(request, response);
				break;
			
			default:
				listEmployees(request, response);
				break;
		}
	}	

	public void listEmployees(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// call dao method to get list of employees
		List<Employee> employees = employeeDAO.findAll();

		// add the employees to request object
		request.setAttribute("employees", employees);

		// get the request dispatcher
		dispatcher = request.getRequestDispatcher("/views/employee-list.jsp");

		// forward the request and response objects
		dispatcher.forward(request, response);
	}

	public void getEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeDAO.getEmployee(id);
		
		request.setAttribute("employee", employee);
		
		// get the request dispatcher
		dispatcher = request.getRequestDispatcher("/views/employee-add.jsp");

		// forward the request and response objects
		dispatcher.forward(request, response);		
	}
	
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
	
		if (employeeDAO.deleteById(id)) {
			request.setAttribute("message", "Record has been deleted successfully!");
		}
		
		listEmployees(request, response); 
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstname");
		String dob = request.getParameter("dob");
		String department = request.getParameter("department");

		Employee employee = new Employee();
		
		employee.setName(firstName);
		employee.setDob(dob);
		employee.setDepartment(department);

		if (id.isEmpty() || id == null) {
			if (employeeDAO.save(employee)) {
				request.setAttribute("message", "Save successfully!");
			}
		} else {
			employee.setId(Integer.parseInt(id));
			if (employeeDAO.update(employee)) {
				request.setAttribute("message", "Update successfully!");
			}
		}		

		listEmployees(request, response);
	}	 
}

// quando não tinha a tela de login, só precisava deixar a linha abaixo em index.jsp
// <% response.sendRedirect("EmployeeController?action=LIST"); %>   