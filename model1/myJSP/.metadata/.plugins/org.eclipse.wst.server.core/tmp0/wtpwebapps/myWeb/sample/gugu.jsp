<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>구구단</title>
</head>
<body>
	<h2>구구단</h2>
	<%
		int dan = 0;
		int num = 0;
		out.println("<table border='1' width='100'>");
		for(num=1; num<10; num++) {
			out.println("<tr>");
			for(dan=1; dan<10; dan++) {
				out.println("<td>");
				out.print(dan + "X" + num + "=" + dan*num);
				out.println("</td>");
			}
			out.println("</tr>");
		}
		out.println("</table>");
	%>
</body>
</html>