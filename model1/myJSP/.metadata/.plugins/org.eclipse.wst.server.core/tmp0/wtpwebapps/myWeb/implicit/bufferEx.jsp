<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page buffer="8kb" autoFlush="false" %> --%>
<%
	int bufferSize = out.getBufferSize();
	int remainSize = out.getRemaining();
	int usedSize = bufferSize - remainSize;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BUFFER</title>
</head>
<body>
버퍼 전체 크기 : <%=bufferSize%><br></br>
사용한 버퍼크기 : <%=usedSize%><br></br>
남은 버퍼 : <% out.println(remainSize); %> byte<br></br>
</body>
</html>