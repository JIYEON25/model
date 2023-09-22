<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core Example - set, out, remove</title>
</head>
<body>
	browser variable setting
	<c:set var="browser" value="${header['User-Agent']}"/><br>
	<c:out value="${browser}"/><p>
	browser variable removed
	<c:remove var="browser"/>
	<c:out value="${browser}"/>
</body>
</html>