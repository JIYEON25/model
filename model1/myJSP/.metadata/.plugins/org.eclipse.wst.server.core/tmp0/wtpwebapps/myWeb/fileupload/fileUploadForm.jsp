<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FileUpload Form</title>
</head>
<body>
	<div style="text-align: center;">
		<form action="fileUpload.jsp" method="post" enctype="multipart/form-data">
			<table border="1">
				<tr>
					<td colspan="2" align="center"><h3>FILE UPLOAD FORM</h3></td>
				</tr>
				<tr>
					<td>UPLOADER :</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>TITLE :</td>
					<td><input type="text" name="subject"></td>
				</tr>
				<tr>
					<td>FILE 1 :</td>
					<td><input type="file" name="fileName1"></td>
				</tr>
				<tr>
					<td>FILE 2 :</td>
					<td><input type="file" name="fileName2"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="SUBMIT"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>