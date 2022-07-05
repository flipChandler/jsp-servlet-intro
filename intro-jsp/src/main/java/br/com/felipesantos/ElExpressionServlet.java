package br.com.felipesantos;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipesantos.model.Student;

//<form action="el-expression"> do index.html
@WebServlet("/el-expression") 
public class ElExpressionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		Student student = new Student("Chris Cornell");
		student.setAge(52);
		student.setLocation("USA");
		
		Student student2 = new Student("Harry Maguire", 25, "England");
		
		List<Student> students = Arrays.asList(student, student2);
		
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		
		
		StringBuilder nomeCompleto = new StringBuilder(nome);
		nomeCompleto.append(" ")
		.append(sobrenome);	
		
		String[] countries = {"India", "Japan", "China", "Brazil", "USA" };
		
		request.setAttribute("nomeCompleto", nomeCompleto.toString());	// setAttribute nomeCompleto, to be available to use in output.jsp
		request.setAttribute("estudante", student);
		request.setAttribute("estudante2", student2);
		request.setAttribute("paises", countries);
		request.setAttribute("estudantes", students);
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("/output-el-expression.jsp");
		dispatcher.forward(request, response);		
	}
}
