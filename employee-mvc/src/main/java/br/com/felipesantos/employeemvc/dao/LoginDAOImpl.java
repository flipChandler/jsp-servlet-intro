package br.com.felipesantos.employeemvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.felipesantos.employeemvc.entity.Login;
import br.com.felipesantos.employeemvc.util.DbConnectionUtil;

public class LoginDAOImpl implements LoginDAO {
	
	@Override
	public String authenticate(Login login) {
		String sql = "SELECT * FROM tbl_login WHERE email = ? AND password = ?";
		
		try {
			Connection connection = DbConnectionUtil.openConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login.getEmail());
			preparedStatement.setString(2, login.getPassword());

			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				return "true";
			} else {
				return "false";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}
}
