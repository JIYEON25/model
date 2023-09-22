<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String fileName1 = request.getParameter("fileName1");
	String fileName2 = request.getParameter("fileName2");
	String origFileName1 = request.getParameter("origFileName1");
	String origFileName2 = request.getParameter("origFileName2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FILE UPLOAD CHECK AND DOWNLOAD</title>
</head>
<body>
	UPLOADED PERSON : <%=name %><br>
	TITLE : <%=subject %><br>
	FILE 1 : <a href="/myWeb/upload/<%=fileName1 %>"><%=origFileName1 %></a><br>
	FILE 2 : <a href="/myWeb/upload/<%=fileName2 %>"><%=origFileName2 %></a><br>
</body>
</html>