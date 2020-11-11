<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LMS</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
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

#idClass td {
	font-size: 14px;
	border-bottom: 1px solid rgb(228, 228, 228);
}

#insertArea {
	top: 100px;
	left: 50%;
	margin-left: -150px;
	background-color: white;
	width: 300px;
	position: absolute;
	/* z-index: 1; */
	border: 2px solid rgb(26, 188, 156);
	display: none;
	text-align: center;
	font-size: 12pt;
}

#insertAreaInner {
	margin: 10px 10px 10px 10px;
	background-color: white;
	text-align: center;
	font-size: 10pt;
}

#modifyArea {
	top: 100px;
	left: 50%;
	margin-left: -150px;
	background-color: white;
	width: 300px;
	position: absolute;
	/* z-index: 1; */
	border: 2px solid rgb(26, 188, 156);
	display: none;
	text-align: center;
	font-size: 12pt;
}

#modifyAreaInner {
	margin: 10px 10px 10px 10px;
	background-color: white;
	text-align: center;
	font-size: 10pt;
}

#delArea {
	top: 100px;
	left: 50%;
	margin-left: -150px;
	background-color: white;
	width: 300px;
	position: absolute;
	/* z-index: 1; */
	border: 2px solid rgb(26, 188, 156);
	display: none;
	text-align: center;
	font-size: 12pt;
}

#delAreaInner {
	margin: 10px 10px 10px 10px;
	background-color: white;
	text-align: center;
	font-size: 10pt;
}

.bgColorGray {
	background-color: rgb(228, 228, 228);
}

.bgColorHeader {
	background-color: rgb(26, 188, 156);
}

#deletefont{
	color: black;
	font-size: 1em	;
}
</style>
<script></script>
</head>

<body>

	<div id="container">

		<%@ include file="/WEB-INF/views/include/header.jsp"%>


		<div id="contentsAll">


			<table width=100% border=0>
				<tr>
					<td colspan="2" class="tdRight">강사명검색
						<button id="search" class="btnSearch">F</button>
						<input type="text" id="search">
					</td>
				</tr>
				<tr>
					<td class="alignLeft bold">강사 목록</td>
					<td class="tdRight">
						<button id="viewInsert" class="" onClick="viewInsert()">등록</button>
					</td>
				</tr>
			</table>

			<table id="idClass" width=100% border=0 cellspacing="0">
				<tr class="bgColorGray">
					<th>번호</th>
					<th>학번</th>
					<th>이름</th>
					<th>전공</th>
					<th>학년</th>
					<th>연락처</th>
					<th>이메일</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
 				<c:forEach items="${sListView.studentList}" var="student" varStatus="staus">
				<tr class="">
					<td>${staus.count }</td>
					<td>${student.sIdx}</td>
					<td>${student.name}</td>
					<td>${student.major}</td>
					<td>${student.grade}</td>
					<td>${student.tel}</td>
					<td>${student.email}</td>
					<td><button id="viewModify" class="" onClick="viewModify()">수정</button></td>
					<td><button id="doDel" class="" onClick="doDel(${student.sIdx})">삭제</button></td>
				</tr>
				</c:forEach> 
			</table>
		</div>
	</div>

	<div id="insertArea">
		<div id="insertAreaInner">

			<form action="sAdd.do" method="post">

				학생등록
				<table width=100% border=0>
					<tr>
						<td>학번</td>
						<td><input type="text" id="sIdx" name="sIdx"></td>
					</tr>
					<tr>
						<td>패스워드</td>
						<td><input type="text" id="pw" name="pw"></td>
					</tr>
					<tr>
						<td>학생명</td>
						<td><input type="text" id="name" name="name"></td>
					</tr>
					<tr>
						<td>전공</td>
						<td><input type="text" id="major" name="major"></td>
					</tr>
					<tr>
						<td>학년</td>
						<td><input type="text" id="grade" name="grade"></td>
					</tr>
					<tr>
						<td>연락처</td>
						<td><input type="text" id="tel" name="tel"></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" id="email" name="email"></td>
					</tr>
					<tr>
						<td colspan="2">
							<button class="" onClick="location.href = 'sList.do'">취소</button>
							<button type="submit" id="insert" class=""
								onClick="doInsert(this.form)">등록</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<div id="modifyArea">
		<div id="modifyAreaInner">
			<form action="sEditByAdmin.do" method="post">
				학생 수정
				<table width=100% border=0>
					<tr>
						<td>학번</td>
						<td><input type="text" id="sIdx" name="chgSidx"></td>
					</tr>
					<tr>
						<td>패스워드</td>
						<td><input type="text" id="pw" name="chgPw"></td>
					</tr>
					<tr>
						<td>학생명</td>
						<td><input type="text" id="name" name="chgName"></td>
					</tr>
					<tr>
						<td>전공</td>
						<td><input type="text" id="major" name="chgMajor"></td>
					</tr>
					<tr>
						<td>학년</td>
						<td><input type="text" id="grade" name="chgGrade"></td>
					</tr>
					<tr>
						<td>연락처</td>
						<td><input type="text" id="tel" name="chgTel"></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" id="email" name="chgEmail"></td>
					</tr>
					<tr>
						<td colspan="2">
							<button class="" onClick="location.href = 'sList.do'">취소</button>
							<td><button id="doDel" class="" onClick="doModify(${student.sIdx})">수정</button>
							</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<div id="delArea">
		<div id="delAreaInner">

			<form>

				학생삭제
				<table width=100% border=0>
					<tr>
						<td>교과목명</td>
						<td></td>
					</tr>
					<tr>
						<td>교수명</td>
						<td></td>
					</tr>
					<tr>
						<td>과목내용</td>
						<td></td>
					</tr>
					<tr>
						<td>대상학년</td>
						<td></td>
					</tr>
					<tr>
						<td>이수구분</td>
						<td></td>
					</tr>
					<tr>
						<td>학점</td>
						<td></td>
					</tr>
					<tr>
						<td>수업시간</td>
						<td></td>
					</tr>
					<tr>
						<td>정원</td>
						<td></td>
					</tr>
					<tr>
						<td>교재</td>
						<td></td>
					</tr>
					<tr>
						<td>강의실</td>
						<td></td>
					</tr>
					<tr>
						<td colspan="2">
							<button class="" onClick="closeInsert()">취소</button>
							<button type="submit" id="insert" class=""
								onClick="doInsert(this.form)">등록</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>


</body>

<script>

    function closeInsert() {
            document.getElementById('insertArea').style.display = 'none';
    }
    
    function viewInsert() {     
        document.getElementById('insertArea').style.display = 'block';

    }

    function doInsert(form) {     


    	if(confirm('입력한 학생 정보를 등록하시겠습니까?')){
			location.href = 'sList.do';
		}

    }
    

    function closeModify() {
            document.getElementById('modifyArea').style.display = 'none';

    }
    
    function viewModify() {     
        document.getElementById('modifyArea').style.display = 'block';

    }

    function doModify(sIdx) {     

    	if(confirm('입력하신 회원 정보로 수정하시겠습니까?')){
			location.href = 'sEditByAdmin.do?sIdx='+sIdx;
		}

    }

    function closeDel() {
            document.getElementById('delArea').style.display = 'none';

    }
    
    function viewDel() {     
        document.getElementById('delArea').style.display = 'block';

    }

    function doDel(sIdx) {     

		if(confirm('선택하신 회원 정보를 삭제하시겠습니까?')){
			location.href = 'sDelete.do?sIdx='+sIdx;
		}


/*         document.getElementById('delArea').style.display = 'none';
        form.submit(); */
        

    }


</script>

</html>

