<%@page import="java.util.ArrayList"%>
<%@page import="jstl.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	MemberVO vo1 = new MemberVO("Kim", "kim@naver.com", 10);
	MemberVO vo2 = new MemberVO("Lee", "lee@naver.com", 10);
	MemberVO vo3 = new MemberVO("Jung", "jung@naver.com", 10);
	
	ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
	memberList.add(vo1);
	memberList.add(vo2);
	memberList.add(vo3);
	request.setAttribute("memberList", memberList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Example</title>
</head>
<body>
	<h3>Member Info</h3>
	<table border="1" width="450">
		<tr>
			<th width="50">No.</th>
			<th width="100">Name</th>
			<th width="200">Email</th>
			<th width="100">Age</th>
		</tr>
	<c:forEach var="member" items="${memberList}" varStatus="num">
		<tr>
			<td align="center">${num.count}</td>
			<td align="center">${member.name}</td>
			<td align="center">${member.email}</td>
			<td align="center">${member.age}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>