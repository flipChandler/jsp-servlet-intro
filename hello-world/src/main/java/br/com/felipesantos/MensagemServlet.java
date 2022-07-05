package br.com.felipesantos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mensagem")
public class MensagemServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		if (nome == null) {
			nome = "camarada";
		}
		
		response.getWriter().print("<html><h1>oi, " + nome + "</h1></html>");
	}
}

// localhost:8080/hello-world/mensagem?nome=Felipe