<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
	public String getParam(HttpServletRequest request, String paramName) {
		if(request.getParameter(paramName) != null) {
			return request.getParameter(paramName);
		} else {
			return "";
		}
	}
%>
<%
	request.setCharacterEncoding("UTF-8");
	int filecounter = 0;
	if(request.getParameter("addcnt") != null) {
		filecounter = Integer.parseInt(request.getParameter("addcnt"));
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>File Select Page</title>
	<link href="style.css" type="text/css" rel="stylesheet">
	<script type="text/javascript">
		function inputValue(form1, param, form2, idx) {
			var paramValue = form1.elements[idx].value;
			form2.elements[idx].value = paramValue;
			return;
		}
		function addFile(formName) {
			if(formNAme.addcnt.value == "") {
				alert("Put the number of files you'll upload and press the submit button.");
				formName.addcnt.focus();
				return;
			}
			formName.submit();
		}
		function elementCheck(formName) {
			paramIndex = 1;
			for(idx=0; idx<formName.elements.length; idx++) {
				if(formName.elements[idx].type == "file") {
					if(formNAme.elements[idx].value == "") {
						var message = paramIndex + "번째 파일 정보가 누락되었습니다.\n업로드할 파일을 선택해주세요.";
						alert(message);
						formName.elements[idx].focus();
						return;
					}
					paramIndex++;
				}
			}
			formName.action = "fileView.jsp";
			formName.submit();
		}
	</script>
</head>
<body topmargin="100">
	<div align="center">
		<font color="#0000ff" size="2">
			복수개의 파일의 업로드를 위하여 파일 갯수를 입력한 후<br>
			확인 버튼을 눌러주세요!!<br>
			입력이 완료되면 DONE 버튼을 눌러주세요
		</font>
	</div><br>
	<form name="formName1" method="post">
		<table width="75%" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#660000" bgcolor="#FFFF99">
			<tr bgcolor="#FFCC00">
				<td width="10%">
					<div align="right">user</div>
				</td>
				<td><input type="text" name="user" 
					 onkeyup="inputValue(this.form,user,formName2,0)" value="<%=getParam(request,"user") %>"></td>
				<td width="10%">
					<div align="right">title</div>
				</td>
				<td><input type="text" name="title" 
					 onkeyup="inputValue(this.form,title,formName2,1)" value="<%=getParam(request,"title") %>">
				</td>
			</tr>
			<tr bgcolor="#FFCC00">
				<td width="15%">
					<div align="right">Abstract</div>
				</td>
				<td width="50%" colspan="3">
					<textarea name="abstract" cols="40" onkeyup="inputValue(this.form,abstract,formName2,2)"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<div align="center">
						<font size="-2">추가할 파일 수 입력</font>
							<input type="text" name="addcnt">
							<input type="button" value="확인" onClick="addFile(this.form)">
					</div>
				</td>
			</tr>
		</table>
	</form>
	<form name="formName2" method="post" enctype="multipart/form-data">
		<table width="75%" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#660000" bgcolor="#FFFF99">
			<tr bgcolor="FFCC00">
				<td width="40%">
					<input type="hidden" name="txtUser" value="<%=getParam(request,"user") %>">
					<input type="hidden" name="txtTitle" value="<%=getParam(request,"title") %>">
					<input type="hidden" name="txtAbstract" value="<%=getParam(request,"abstract") %>">
				<%
					for(int i=0; i<filecounter; i++) {
				%>
					<input type="file" size="50" name="selectFile<%=i %>"><br>
				<%
					}
				%>
				</td>
				<td>
					<input type="button" value="DONE" onClick="elementCheck(this.form)">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>