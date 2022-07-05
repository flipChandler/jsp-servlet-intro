package br.com.felipesantos;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//<form action="nome-completo"> do index.html
@WebServlet("/nome-completo") 
public class NomeSobrenomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		
		StringBuilder nomeCompleto = new StringBuilder(nome);
		nomeCompleto.append(" ")
		.append(sobrenome);		
		
		request.setAttribute("nomeCompleto", nomeCompleto.toString());	// setAttribute nomeCompleto, to be available to use in output.jsp 
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("/output.jsp");
		dispatcher.forward(request, response);		
	}
	
	public NomeSobrenomeServlet() {
		super();
		System.out.println("Inside the no-arg constructor()::::::");
	}
	
	@Override
	public void init() throws ServletException {
		
		super.init();
		System.out.println("Inside the init():::::::::::::::::");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.service(req, resp);
		System.out.println("Inside the service()::::::::::::::");
	}
	
	@Override
	public void destroy() {
		
		super.destroy();
		System.out.println("Inside the destroy()::::::::::::::");
	}
}
