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

		<h1 class="subtitle"></h1>
		
		<c:if test="${result eq Y}">
			<div>
				데이터 입력 완료
			</div>
			${templet}	 
		</c:if>
		
		<c:if test="${not(result eq Y)}">
			데이터 입력 실패
			<!-- core 태그를 이용해서 contextPath 경로 읽어오기 -->
		</c:if>
		

</body>
</html>