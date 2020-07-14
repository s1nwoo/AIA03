<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">

<style>
	
</style>
</head>
<body>

	<link rel = "stylesheet" type="type/css" href="${pageContext.request.contextPath}/css/default.css"/>

	<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<div>
		<h1>인덱스</h1>
	</div>
	
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	
</body>
</html>