<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕하세요. JSP로 응답 페이지를 생성했습니다.</h1>
	
	<%
	
		Date now = new Date();	
		String message = "HELLO!!";
	
	%>
	
	<p>현재시간은 : <%= now %></p>
	<h3><%= message %></h3>
</body>
</html>