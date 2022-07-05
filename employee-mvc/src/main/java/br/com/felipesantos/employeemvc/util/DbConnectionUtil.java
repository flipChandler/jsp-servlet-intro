package br.com.felipesantos.employeemvc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectionUtil {
	
	private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static Connection connection = null;
	
	public static Connection openConnection() {
		// check the connection
		if (connection != null) {
			return connection;
		}
		
		try {
			// load the driver
			Class.forName(DRIVER);
			
			// get the connection
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// return connection
		return connection;
	}
}
