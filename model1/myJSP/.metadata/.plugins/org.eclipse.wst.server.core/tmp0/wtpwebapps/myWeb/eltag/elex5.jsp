<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Example</title>
</head>
<body>
	<h3>파라미터 값 처리</h3><br><br>
	<form action="elex5.jsp" method="post">
		Name : <input type="text" name="name" value="${param['name']}">
			   <input type="submit" value="submit">
	</form>
	<p>
		Name is ${param.name} .
	</p>
</body>
</html>