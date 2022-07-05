package br.com.felipesantos.employeemvc.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String username = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/employee_db";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			PrintWriter writer = response.getWriter();
			writer.println("Connecting to database " + url);
			
			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(url, username, password);
			writer.println("Connection successful");
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
