<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Date time = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 정보</title>
</head>
<body>
	Session ID : <%= session.getId() %><br>
<%
	time.setTime(session.getCreationTime());
%>
	Session Creation Time : <%=formatter.format(time) %><br>
<%
	time.setTime(session.getLastAccessedTime());
%>
	Last Accessed Time : <%= formatter.format(time) %>
</body>
</html>