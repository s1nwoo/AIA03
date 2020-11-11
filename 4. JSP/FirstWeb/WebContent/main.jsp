<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include TEST</title>

<style>
header {
	text-align: center;
}

#news {
	width: 45%;
	float: left;
}

#shopping {
	width: 45%;
	float: right;
}

#wrap {
	hidden
	width: 50%;
	
	position:relative;
	margin: 0 auto;
}
</style>

</head>
<body>

</body>


	<%@ include file="include/header.jsp"%>
	<div id="wrap">
	<%@ include file="include/news.jsp"%>
	<%@ include file="include/shopping.jsp"%>
	</div>
	
	<jsp:include page="include/footer.jsp">
	<jsp:param value="xxxx@xxxx.com" name="email"/>
	<jsp:param value="010-xxxx-xxxx" name="tel"/>
	</jsp:include>


</html>

