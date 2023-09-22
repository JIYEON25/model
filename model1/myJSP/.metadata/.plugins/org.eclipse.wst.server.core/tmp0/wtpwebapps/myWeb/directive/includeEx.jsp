<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 파일을 만드는데 반복되는 내용만 .jspf 라는 확장자를 주고 -->
<!-- 코드를 넣어서 include해서 다른 파일에서 사용할 수 있게 함. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>include 지시어를 활용한 예제</h2>
<%
	String name = "Jiyeon Jun";
%>
<%@ include file="top.jsp"%>
포함하는 페이지 지시어(include) 예제의 내용입니다. <%@ include file="bottom.jsp"%>
</body>
</html>