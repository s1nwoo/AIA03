<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.4.js">
</script>
<style></style>
</head>
<body>

	<h1>request Form Test</h1>
	<hr>

	<form action="requestResult.jsp" method="post">

		<label>이름</label> <input type="text" name="username" required>
		<br> <label>직업</label> <select name="job">
			<option value="시스템엔지니어">시스템엔지니어</option>
			<option value="프로그래머">프로그래머</option>
			<option value="디자이너">디자이너</option>
		</select> <br> <label>관심사항</label> 
		JAVA <input type="checkbox" name="like"value="JAVA"> 
		JSP <input type="checkbox" name="like"value="JSP"> 
		HTML5 <input type="checkbox" name="like"value="HTML5"> 
		CSS3 <input type="checkbox" name="like"value="CSS3"> 
		<br> 
		<input type="submit" value="보내기">
		<input type="reset">

	</form>

</body>
</html>