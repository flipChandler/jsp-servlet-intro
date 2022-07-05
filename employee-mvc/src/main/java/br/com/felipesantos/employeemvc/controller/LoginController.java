package br.com.felipesantos.employeemvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.felipesantos.employeemvc.dao.LoginDAO;
import br.com.felipesantos.employeemvc.dao.LoginDAOImpl;
import br.com.felipesantos.employeemvc.entity.Login;

public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	LoginDAO loginDAO = null;
	
	

	public LoginController() {
		this.loginDAO = new LoginDAOImpl();
	}



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Login login = new Login();
		login.setEmail(request.getParameter("email"));
		login.setPassword(request.getParameter("password"));
		
		String status = loginDAO.authenticate(login);
		
		switch(status) {
			case "true":
				session.setAttribute("email", login.getEmail());
				response.sendRedirect("EmployeeController?action=LIST");
				break;
				
			case "false":
				response.sendRedirect("index.jsp?status=false");
				break;
				
			case "error":
				response.sendRedirect("index.jsp?status=error");
				break;
		}
	}
}
