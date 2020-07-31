<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>@RequestParam을 이용한 파일 업로드</h1>
	<hr>

	<form action="upload1" method="post" enctype="multpart/form-data">
		<table>
			<tr>
				<td>학번</td>
				<td><input type="text" name="sno"></td>
			</tr>
			<tr>
				<td>과제파일</td>
				<td><input type="file" name="report"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="제출"></td>
			</tr>
		</table>
	</form>

	<h1>@MultipartHttpServletRequest를 이용한 파일 업로드</h1>
	<hr>

	<form action="upload2" method="post" enctype="multpart/form-data">
		<table>
			<tr>
				<td>학번</td>
				<td><input type="text" name="sno"></td>
			</tr>
			<tr>
				<td>과제파일</td>
				<td><input type="file" name="report"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="제출"></td>
			</tr>
		</table>
	</form>

	<h1>@커맨드 객체를 이용한 파일 업로드</h1>
	<hr>

	<form action="upload3" method="post" enctype="multpart/form-data">
		<table>
			<tr>
				<td>학번</td>
				<td><input type="text" name="sno"></td>
			</tr>
			<tr>
				<td>과제파일</td>
				<td><input type="file" name="report"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="제출"></td>
			</tr>
		</table>
	</form>

</body>
</html>