<%@page import="java.util.ArrayList"%>
<%@page import="member.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/css/default.css" />">
<style>
td>img{
	width: 50px;
	height: 50px;
}
</style>

</head>
<body>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<br>
	<h3>회원 리스트</h3>
	<hr>
	<table border="1">
		<tr>
			<th>인덱스</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>첨부파일</th>
		</tr>
		<tr>
		</tr>

		<c:if test="${not empty listView.memberList }">
			<c:forEach items="${listView.memberList }" var="member">
				<tr>
					<td>${member.idx }</td>
					<td>${member.uid }</td>
					<td>${member.upw }</td>
					<td>${member.uname }</td>
					<td><img alt="제목없음" src="<c:url value="${member.uphoto}"/>">  </td>
				</tr>
			</c:forEach>
		</c:if>
	</table>


	


	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</body>
</html>