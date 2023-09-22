<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String[] movieList = {"Harry Potter","Fast and Furious","Intern"};
	request.setAttribute("movieList", movieList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Example</title>
</head>
<body>
	Popular movies : 
	<ul>
		<c:forEach var="movie" items="${movieList}">
			<li>${movie}</li>
		</c:forEach>
	</ul>
</body>
</html>