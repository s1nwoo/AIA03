<%@page import="lms.model.Admin"%>
<%@page import="lms.model.Teacher"%>
<%@page import="lms.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="header" class="bgColorHeader">
	<table class="titleTable" width=100% border=0 cellspacing=0>
		<tr>
			<td rowspan=2 class="alignRight" width=15% valign="bottom"><img
				class="userImg" width=50 src="./images/userImg.png"></td>
			<!-- 로그인번호가 관리자이면, -->
			<c:if test="${loginType eq 'aLogin'}">
				<td class="alignLeft">${info.id}</td>
			</c:if>
			<!-- 로그인번호가 학생. 교수이면, -->
			<c:if test="${loginType eq 'tLogin'}">
				<td class="alignLeft">${info.tIdx} ${info.name}</td>
			</c:if>
			<!-- 로그인번호가 학생이면, -->
			<c:if test="${loginType eq 'sLogin'}">
				<td class="alignLeft"> ${info.sIdx} ${info.name}</td>
			</c:if>
		</tr>
		<tr>
			<!-- 로그인번호가 관리자이면, -->
			<c:if test="${loginType eq 'aLogin'}">
				<td class="alignLeft">관리자</td>
			</c:if>
			<!-- 로그인번호가 교수이면, -->
			<c:if test="${loginType eq 'tLogin'}">
				<td class="alignLeft">${info.major}${info.job}</td>
			</c:if>
			<!-- 로그인번호가 학생이면, -->
			<c:if test="${loginType eq 'sLogin'}">
				<td class="alignLeft">${info.major}${info.grade}</td>
			</c:if>
		</tr>
	</table>


	<table class="titleTable" width=100% border=0 cellspacing=0>
		<tr>
			<!-- 로그인번호가 관리자이면, -->
			<c:if test="${loginType eq 'aLogin'}">
				<td><a href="cList.do" class="cListTab">강의</a></td>
				<td><a href="tList.do" class="tListTab">강사</a></td>
				<td><a href="sList.do" class="sListTab">학생</a></td>
			</c:if>
			<!-- 로그인번호가 교수이면, -->
			<c:if test="${loginType eq 'tLogin'}">
				<td><a href="cAddForm.do" class="cAddFormTab">강의등록</a></td>
				<td><a href="myPage.do" class="myPageTab">나의 강의실</a></td>
				<td><a href="info.do" class="infoTab">내정보</a></td>
			</c:if>
			<!-- 로그인번호가 학생이면, -->
			<c:if test="${loginType eq 'sLogin'}">
				<td><a href="sClassAddForm.do" class="cAddFormTab">수강신청</a></td>
				<td><a href="myPage.do" class="myPageTab">나의 강의실</a></td>
				<td><a href="info.do" class="infoTab">내정보</a></td>
			</c:if>
		</tr>
	</table>
</div>  <!-- header end -->