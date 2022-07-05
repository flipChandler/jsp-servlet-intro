package br.com.felipesantos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//<form action="somar"> do index.html
@WebServlet("/somar") 
public class SomaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int parcela1 = Integer.parseInt(request.getParameter("parcela1"));
		int parcela2 = Integer.parseInt(request.getParameter("parcela2"));
		int total = parcela1 + parcela2;
		
		response.setContentType("text/html;charset=UTF-8");
		
		// http://localhost:8080/somar-parcelas/somar?parcela1=10&parcela2=50&soma=calcular
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Resultado da Soma</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>O resultado foi: " + total + "</h1>");
			out.println("</body>");
			out.println("<html/>");
		}
	}
}
