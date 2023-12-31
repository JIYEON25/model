<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//pageContext Scope에 속성 저장하기
pageContext.setAttribute("pageAttribute", "주황버섯");
//pageContext.setAttribute("pageAttribute", "이승재", PageContext.PAGE_SCOPE);
//둘이 같은건데 pageContext는 길고 해당 페이지에서만 유효하고, 코드가 길어짐.

//request Scope에 속성 저장하기
request.setAttribute("requestAttribute", "010-1234-5678");
//pageContext.setAttribute("pageAttribute", "010-9531-0114", PageContext.REQUEST_SCOPE);

//session Scope에 속성 저장하기
session.setAttribute("sessionAttribute", "orange@gmail.com");
//pageContext.setAttribute("sessionAttribute", "stdio@hanmail.net", PageContext.SESSION_SCOPE);

//application Scope에 속성 저장하기
application.setAttribute("applicationAttribute", "KGITBANK");
//pageContext.setAttribute("applicaionAttribute", "KH Information", PageContext.APPLICATION_SCOPE);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scope Example</title>
</head>
<body>
<ul>
	<li>이름 : <%=pageContext.getAttribute("pageAttribute") %></li>
	<li>전화 : <%=request.getAttribute("requestAttribute") %></li>
	<% String email = (String)session.getAttribute("sessionAttribute"); %>
	<li>메일 : <%= email %></li>
<%-- 	<li>메일 : <%=session.getAttribute("sessionAttribute") %></li> --%>
	<li>회사 : <%=application.getAttribute("applicationAttribute") %></li>
</ul>
</body>
</html>