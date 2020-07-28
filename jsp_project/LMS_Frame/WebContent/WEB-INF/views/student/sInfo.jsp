<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LMS</title>
<link href="./css/lms.css" rel="stylesheet">
<style>
th {
	text-align: center;
	/* font-weight : 900; */
}

td {
	text-align: center;
}

input {
	border: 2px solid;
	height: 20px;
	width: 150px;
	border-color: rgb(188, 188, 188);
}

button {
	width: 80px;
	height: 30px;
	text-align: center;
	font-size: 14px;
}

.btnSearch {
	margin-left: 5px;
	margin-right: -2px;
	width: 50px;
	height: 26px;
	text-align: center;
	font-size: 14px;
}

.tdRight {
	text-align: right;
}

.alignLeft {
	text-align: left;
}

.alignRight {
	text-align: right;
}

.bold {
	font-size: 25px;
	font-weight: 900;
}

a {
	text-decoration: none;
	color: white;
	font-size: 20px;
	font-weight: 500;
	margin: 3px 3px 3px 3px;
}

.titleTable {
	color: white;
	font-size: 20px;
	font-weight: 500;
	margin: 3px 3px 3px 3px;
}

.alignCenter {
	text-align: center;
}

.btnStyle {
	border-radius: 10px;
	font-size: 14px;
	color: white;
	font-weight: 900;
	/* background-color: rgba(0, 0, 255, 0.7);
            border-color:  rgba(0, 0, 255, 1);             */
}

.btnStyle:hover {
	color: black;
	background-color: white;
	border-color: gray;
}

.userImg {
	border-radius: 10px;
	border: 7px solid white;
}

.bgColorGray {
	background-color: rgb(228, 228, 228);
}

.bgColorHeader {
	background-color: rgb(26, 188, 156);
}
</style>
<script></script>
</head>

<body>

	<div id="container">
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
		<!-- <div id="header" class="bgColorHeader">
		
			<table class="titleTable" width=100% border=0 cellspacing=0>
				<tr>
					<td rowspan=2 class="alignRight" width=15% valign="bottom"><img
						class="userImg" width=50 src="./images/userImg.png"></td>
					<td class="alignLeft">2008123456114</td>
				</tr>
				<tr>
					<td class="alignLeft">컴퓨터공학과 2학년</td>
				</tr>
			</table>
			<table class="titleTable" width=100% border=0 cellspacing=0>
				<tr>
					<td><a href="sClassAddForm.html">수강신청</a></td>
					<td><a href="sMyPage.html">나의 강의실</a></td>
					<td><a href="sInfo.html">[내정보]</a></td>
				</tr>
			</table>
		</div> -->

		<div id="contentsAll">
			<form id="infoEditForm" action="infoEdit.do" method="post">
				<table width=100% border=0>
					<tr>
						<td width=50% class="alignRight">학과</td>
						<td width=45% class="alignLeft">${info.major}</td>
					</tr>
					<tr>
						<td class="alignRight">학번</td>
						<td class="alignLeft">${info.sIdx}</td>
					</tr>
					<tr>
						<td class="alignRight">학년</td>
						<td class="alignLeft">${info.grade}</td>
					</tr>
					<tr>
						<td class="alignRight">이름</td>
						<td class="alignLeft">${info.name}</td>
					</tr>
					<tr>
						<td class="alignLeft"><input type="hidden" id="pw1" name="pw1" value="${info.pw}"></td>
					</tr>
					<tr>
						<td class="alignRight">비밀번호 확인</td>
						<td class="alignLeft"><input type="password" id="pw2" name="pw2"><button id="chkPw" name="pw2" onClick="checkPw()">확인</button></td>
					</tr>
				 <c:if test="${empty result or result == 0}">
					<tr>
						<td class="alignRight">핸드폰</td>
						<td class="alignLeft">${info.tel}</td>
					</tr>
					<tr>
						<td class="alignRight">이메일</td>
						<td class="alignLeft">${info.email}</td>
					</tr>
				 </c:if>
				 <c:if test="${not empty result && result eq 1}">
				 	<tr>
						<td class="alignRight">핸드폰</td>
						<td class="alignLeft">${chgTel}</td>
					</tr>
					<tr>
						<td class="alignRight">이메일</td>
						<td class="alignLeft">${chgEmail}</td>
					</tr>	
				 </c:if>
					<tr>
						<td class="alignRight">수정할 전화번호</td>
						<td class="alignLeft"><input type="text" id="tel" name="tel"></td>
					</tr>
					<tr>
						<td class="alignRight">수정할 이메일</td>
						<td class="alignLeft"><input type="text" id="email" name="email"></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="submit" id="modify" class="" value="수정"></td>
					</tr>
			</table>
		</form>
			


		</div>

	</div>



</body>

<script>
	
	
</script>

</html>

