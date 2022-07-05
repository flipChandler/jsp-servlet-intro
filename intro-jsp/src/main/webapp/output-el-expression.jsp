<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>		
	<p>
		I am writting EL expression ${6 ge 10 ? "Welcome" : "Good bye"}  <!-- ge : greater than or equal to -->
	</p>
	
	<p>
		I am writting EL expression ${3 > 2}  
	</p>
	
	<p>
		I am writting EL expression ${100 * 2}  
	</p>
	
	<!-- 
		ge : >= 
		le : <=
		lt : < 
		gt : > 
		ne : != 
		eq : == 
	
	 -->
	 
	 <h1>My name is ${nomeCompleto}</h1>
	 
	 <h1>My name is ${nomeCompleto eq "Felipe Santos"}</h1> <!--  true -->
	 
	 <h2>
	 	My favorite student is ${estudante.name}
	 </h2>
	 
	 <h2>
	 	His names is ${estudante2.name}, he is ${estudante2.age} years old
	  	and he is from ${estudante2.location} 
	  </h2>
	  
	  <c:out value = "Kim Thayil"></c:out> <!--  Kim Thayil  -->
	  
	  <c:set var = "valor" value = "${10 * 2}"></c:set>
	  
	  <c:out value = "${valor}"></c:out>
	  
	  <p>
	  	Before: <c:out value = "${valor}"></c:out>
	  </p>
	  
	  <c:remove var = "valor" />
	  
	  <p>
	  	After: <c:out value = "${valor}"></c:out>
	  </p>
	  
	  <a href = "<c:url value = "/index.html"></c:url>">
	  	Click here!
	  </a>
	  
	  <c:forEach items = "${paises}" var = "pais">
	  	<p>
	  		Country = ${pais}
	  	</p>
	  </c:forEach>
	  
	  <c:forEach items = "${estudantes}" var = "estudante">
	  	<p>
	  		Student name = ${estudante.name}
	  	</p>
	  	<p>
	  		Student age = ${estudante.age}
	  	</p>
	  	<p>
	  		Student location = ${estudante.location}	  		
	  	</p>
	  	<hr/>
	  </c:forEach>
	  
	  
	  <table border = "1">
	  	<tr>
	  		<th>Name</th>
	  		<th>Age</th>
	  		<th>Location</th>
	  	</tr>
	  	<c:forEach items = "${estudantes}" var = "estudante">
	  		<tr>
	  			<td>${estudante.name}</td>
	  			<td>${estudante.age}</td>
	  			<td>${estudante.location}</td>	  		
	  		</tr>
	  	</c:forEach>
	  </table>
	  
	  <c:if test="${2000 > 1000 }">
	  	<p>This is a true block </p>
	  </c:if>
	  
	  <c:set var = "score" value = "75"></c:set>
	  <c:choose>
	  	<c:when test="${score > 100 }">
	  		<p>${score} is greater than 100</p>
	  	</c:when>
	  	
	  	<c:otherwise>
	  		<p>${score} is less than 100</p>
	  	</c:otherwise>
	  </c:choose>
	  
	  <c:out value="${fn:toLowerCase('SOUNDGARDEN')}"></c:out>
	  
	  <c:out value="${fn:toUpperCase('audioslave')}"></c:out>
	  
	  <c:out value="${fn:length('audioslave')}"></c:out>
	  
	  <c:out value="${fn:contains('Thats what blind dogs believe', 'dogs')}"></c:out>
	  
	  <c:out value="${fn:indexOf('Thats what blind dogs believe', 'dogs')}"></c:out>
</body>
</html>