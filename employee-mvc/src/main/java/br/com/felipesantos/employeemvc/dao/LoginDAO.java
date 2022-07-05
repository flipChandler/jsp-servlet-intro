package br.com.felipesantos.employeemvc.dao;

import br.com.felipesantos.employeemvc.entity.Login;

public interface LoginDAO {
	
	String authenticate(Login login);
}
