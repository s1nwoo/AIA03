<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

#insertCourseArea {
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

#insertCourseAreaInner {
	margin: 10px 10px 10px 10px;
	background-color: white;
	text-align: center;
	font-size: 10pt;
}

#infoCourseArea {
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

#infoCourseAreaInner {
	margin: 10px 10px 10px 10px;
	background-color: white;
	text-align: center;
	font-size: 10pt;
}

#modifyCourseArea {
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

#modifyCourseAreaInner {
	margin: 10px 10px 10px 10px;
	background-color: white;
	text-align: center;
	font-size: 10pt;
}

#delCourseArea {
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

#delCourseAreaInner {
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
</style>
<script></script>
</head>

<body>

	<div id="container">

		<%@ include file="/WEB-INF/views/include/header.jsp"%>


		<div id="contentsAll">


			<table width=100% border=0>
				<tr>
					<td colspan="2" class="tdRight">교과목검색
						<button id="search" class="btnSearch">F</button> <input
						type="text" id="search">
					</td>
				</tr>
				<tr>
					<td class="alignLeft bold">강의 목록</td>
					<td class="tdRight">
						<button id="viewInsertCourse" class=""
							onClick="viewInsertCourse()">등록</button>
					</td>
				</tr>
			</table>

			<table id="idClass" width=100% border=0 cellspacing="0">
				<tr class="bgColorGray">
					<th>번호</th>
					<th>코드</th>
					<th>교과목명</th>
					<th>교수명</th>
					<th>내용</th>
					<th>요일</th>
					<th>시작</th>
					<th>정원</th>
					<th>신청</th>
				</tr>
				<tr class="">
					<c:forEach items="${cListView.courseList}" var="course"
						varStatus="staus">
						<tr class="">
							<td>${staus.count}</td>
							<td>${course.cIdx}</td>
							<td>${course.name}</td>
							<td>${course.teacher}</td>
							<td>${course.content}</td>
							<td>${course.day}</td>
							<td>${course.startTime}</td>
							<td>${course.totalPer}</td>
							<td>${course.applyPer}</td>
						</tr>
					</c:forEach>
				<tr class="">
					<td>A01</td>
					<td>컴퓨터역사</td>
					<td>정신우</td>
					<td>1</td>
					<td>교양</td>
					<td>수(3,4)</td>
					<td>25</td>
					<td><button id="viewInfoCourse" class=""
							onClick="viewInfoCourse()">강의정보</button></td>
					<td><button id="viewModifyCourse" class=""
							onClick="viewModifyCourse()">수정</button></td>
					<td><button id="viewDelCourse" class=""
							onClick="viewDelCourse()">삭제</button></td>
				<tr class="">
					<td>A01</td>
					<td>컴퓨터역사</td>
					<td>정신우</td>
					<td>1</td>
					<td>교양</td>
					<td>수(3,4)</td>
					<td>25</td>
					<td><button id="viewInfoCourse" class=""
							onClick="viewInfoCourse()">강의정보</button></td>
					<td><button id="viewModifyCourse" class=""
							onClick="viewModifyCourse()">수정</button></td>
					<td><button id="viewDelCourse" class=""
							onClick="viewDelCourse()">삭제</button></td>
				<tr class="">
					<td>A01</td>
					<td>컴퓨터역사</td>
					<td>정신우</td>
					<td>1</td>
					<td>교양</td>
					<td>수(3,4)</td>
					<td>25</td>
					<td><button id="viewInfoCourse" class=""
							onClick="viewInfoCourse()">강의정보</button></td>
					<td><button id="viewModifyCourse" class=""
							onClick="viewModifyCourse()">수정</button></td>
					<td><button id="viewDelCourse" class=""
							onClick="viewDelCourse()">삭제</button></td>
			</table>




		</div>



	</div>

	<div id="insertCourseArea">
		<div id="insertCourseAreaInner">

			<!-- <form id=>
            강의등록
            <table width=100% border=0>
                <tr><td>교과목명</td>
                    <td><input type="text" id="search"></td></tr>
                <tr><td>교수명</td>
                    <td><input type="text" id="search"></td></tr>                
                <tr><td>과목내용</td>
                    <td><input type="text" id="search"></td></tr>
                <tr><td>대상학년</td>
                    <td><input type="text" id="search"></td></tr>
                <tr><td>이수구분</td>
                    <td><input type="text" id="search"></td></tr>
                <tr><td>학점</td>
                    <td><input type="text" id="search"></td></tr>
                <tr><td>수업시간</td>
                    <td><input type="text" id="search"></td></tr>
                <tr><td>정원</td>
                    <td><input type="text" id="search"></td></tr>
                <tr><td>교재</td>
                    <td><input type="text" id="search"></td></tr>
                <tr><td>강의실</td>
                    <td><input type="text" id="search"></td></tr>
                <tr><td colspan="2">
                    <button class="" onClick="closeInsertCourse()">취소</button>
                    <button type="submit" id="insertCourse" class="" onClick="doInsertCourse(this.form)">등록</button>
                    </td></tr>
            </table>
        </form> -->
		</div>
	</div>

	<div id="infoCourseArea">
		<div id="infoCourseAreaInner">

			<form>

				강의정보
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
							<button class="" onClick="closeInfoCourse()">닫기</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<div id="modifyCourseArea">
		<div id="modifyCourseAreaInner">

			<form>

				강의수정
				<table width=100% border=0>
					<tr>
						<td>교과목명</td>
						<td><input type="text" id="search"></td>
					</tr>
					<tr>
						<td>교수명</td>
						<td><input type="text" id="search"></td>
					</tr>
					<tr>
						<td>과목내용</td>
						<td><input type="text" id="search"></td>
					</tr>
					<tr>
						<td>대상학년</td>
						<td><input type="text" id="search"></td>
					</tr>
					<tr>
						<td>이수구분</td>
						<td><input type="text" id="search"></td>
					</tr>
					<tr>
						<td>학점</td>
						<td><input type="text" id="search"></td>
					</tr>
					<tr>
						<td>수업시간</td>
						<td><input type="text" id="search"></td>
					</tr>
					<tr>
						<td>정원</td>
						<td><input type="text" id="search"></td>
					</tr>
					<tr>
						<td>교재</td>
						<td><input type="text" id="search"></td>
					</tr>
					<tr>
						<td>강의실</td>
						<td><input type="text" id="search"></td>
					</tr>
					<tr>
						<td colspan="2">
							<button class="" onClick="closeInsertCourse()">취소</button>
							<button type="submit" id="modifyCourse" class=""
								onClick="doModifyCourse(this.form)">수정</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<div id="delCourseArea">
		<div id="delCourseAreaInner">

			<form>

				강의삭제
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
							<button class="" onClick="closeInsertCourse()">취소</button>
							<button type="submit" id="insertCourse" class=""
								onClick="doInsertCourse(this.form)">등록</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>


</body>

<script>
	// 강의 등록 
	function closeInsertCourse() {
		document.getElementById('insertCourseArea').style.display = 'none';

	}

	function viewInsertCourse() {
		document.getElementById('insertCourseArea').style.display = 'block';

	}

	$(document).ready(function() {

		$('#insertCourse').onclick(function() {

		});

		// 참고중인 코드
		$('#uid').focusout(function() {
			$.ajax({
				url : 'idCheck.jsp',
				type : 'GET', //POST, PUT, DELETE
				data : {
					uid : $(this).val()
				},
				success : function(data) {

					if (data == 'Y') {
						$('#checkmsg').html('사용 가능한 아이디입니다.');
					} else {
						$('#checkmsg').html('사용 불가능한 아이디입니다.');
					}

				}
			});
		});

	}); //ready end

	function doInsertCourse(form) {

		document.getElementById('insertCourseArea').style.display = 'none';
		form.submit();

	}

	function closeInfoCourse() {
		document.getElementById('infoCourseArea').style.display = 'none';

	}

	function viewInfoCourse() {
		document.getElementById('infoCourseArea').style.display = 'block';

	}

	function closeModifyCourse() {
		document.getElementById('modifyCourseArea').style.display = 'none';

	}

	function viewModifyCourse() {
		document.getElementById('modifyCourseArea').style.display = 'block';

	}

	function doModifyCourse(form) {

		document.getElementById('modifyCourseArea').style.display = 'none';
		form.submit();

	}

	function closeDelCourse() {
		document.getElementById('delCourseArea').style.display = 'none';

	}

	function viewDelCourse() {
		document.getElementById('delCourseArea').style.display = 'block';

	}

	function doDelCourse(form) {

		document.getElementById('delCourseArea').style.display = 'none';
		form.submit();

	}
</script>

</html>