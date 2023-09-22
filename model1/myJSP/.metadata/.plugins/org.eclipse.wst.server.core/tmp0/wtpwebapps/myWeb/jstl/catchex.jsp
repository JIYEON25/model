<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>catch 태그</title>
</head>
<body>
	<c:catch var="ex">
		name parameter value = <%= request.getParameter("name") %><br><br>
		<%
			if(request.getParameter("name").equals("test")) {
		%>
			${param.name} is test.
		<%
			}
		%>
	</c:catch><br><br>
	<c:if test="${ex != null}">
		Exception occurred : <br><br>
		${ex}
	</c:if>
</body>
</html>