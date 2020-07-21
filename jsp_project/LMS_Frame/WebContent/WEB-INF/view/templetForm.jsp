<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<div>
		<h1 class="subtitle">테스트 템플릿</h1>
		
		<hr>
		
		<form action="templet.do" method="post" enctype="multipart/form-data">			
			<table>
				<tr>
					<td> A 테스트 입력 </td>
					<td><input type="text" name="a" id="a" value="a"></td>
				</tr>
				<tr>
					<td> B 테스트 입력 </td>
					<td><input type="text" name="b" id="b" value="b"></td>
				</tr>
				<tr>
					<td> <input type="submit" name="submit" value="데이터 보내기"> </td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>