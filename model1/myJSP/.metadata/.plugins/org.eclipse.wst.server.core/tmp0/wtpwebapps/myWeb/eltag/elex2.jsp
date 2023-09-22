<%@page import="actiontag.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	ArrayList<String> singer = new ArrayList<String>();
	singer.add("Ed Sheeran");
	singer.add("Charlie Puth");
	request.setAttribute("singer", singer);
	
	Customer[] customer = new Customer[2];
	customer[0] = new Customer();
	customer[0].setName("Kim");
	customer[0].setEmail("kim@gmail.com");
	customer[0].setPhone("010-1111-0000");
	customer[1] = new Customer();
	customer[1].setName("Hong");
	customer[1].setEmail("hong@gmail.com");
	customer[1].setPhone("010-3333-2222");
	request.setAttribute("customer", customer);
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Example</title>
</head>
<body>
	<ul>
		<li>${singer[0]}, ${singer[1]}</li>
	</ul>
	<ul>
		<li>Name : ${customer[0].name}</li>
		<li>Email : ${customer[0].email}</li>
		<li>Phone : ${customer[0].phone}</li>
	</ul>
	<ul>
		<li>Name : ${customer[1].name}</li>
		<li>Email : ${customer[1].email}</li>
		<li>Phone : ${customer[1].phone}</li>
	</ul>
</body>
</html>