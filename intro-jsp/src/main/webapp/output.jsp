<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is an output file! JSP Expression</h1>	
	
	<p>
		Hello, this is 
		<strong>
			<%= request.getAttribute("nomeCompleto") %>		<!-- jsp expression ... one line --> 
		</strong>
	</p>
	
	
	<h1>This is an output file! JSP Scriplets</h1> 				
	<h2>Hello, my name is 
		<em>
			<%												 					
				String nomeCompleto = request.getAttribute("nomeCompleto").toString(); // <!-- jsp scriplet ... more than one line -->
				out.println(nomeCompleto);
			%>
		</em>
	</h2>
	
	<p>
		The value of 2 x 2 = <%= 2 * 2 %>
	</p>
	
	<p>
		6 is greater than 8 = <%= 6 > 8 %>
	</p>
	
	<%
		for (int i = 0; i < 11; i++) {
			out.print("<p>The value of i = " + i + "</p>");
		}
	%>
	
	<%!
		int stringLength(String word) {
			return word.length();
		}
	%>
	
	<p>
		The length of the string BUSHAN is <%= stringLength("BUSHAN") %> 
	</p>
	
</body>
</html>