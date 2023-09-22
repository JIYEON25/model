<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="vo" class="jstl.MemberVO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL EXAMPLE</title>
</head>
<body>
	<c:set target="${vo}" property="name" value="홍길동" />
	<c:set target="${vo}" property="email">
		hong@gmail.com
	</c:set>
	<c:set var="age" value="30" />
	<c:set target="${vo }" property="age" value="${age}"/>
	<h3>회원정보</h3>
		<ul>
			<li>Name : ${vo.name}</li>
			<li>Email : ${vo.email}</li>
			<li>Age : ${vo.age}</li>
		</ul>
</body>
</html>