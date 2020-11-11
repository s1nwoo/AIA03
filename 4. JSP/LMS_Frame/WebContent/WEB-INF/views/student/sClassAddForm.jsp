<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LMS</title>
<link href="../css/lms.css" rel="stylesheet">
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

.btnTmyPage {
	width: 150px;
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
	color: black;
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

#myCourseList td {
	font-size: 14px;
	border-bottom: 1px solid rgb(228, 228, 228);
}

#idSchedule {
	border-color: rgb(228, 228, 228);
}

#idSchedule td {
	font-size: 14px;
	border-bottom: 1px solid rgb(228, 228, 228);
}

#infoArea {
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

#infoAreaInner {
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

#saveImgArea {
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

#saveImgAreaInner {
	margin: 10px 10px 10px 10px;
	background-color: white;
	text-align: center;
	font-size: 10pt;
}

#shareKaArea {
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

#shareKaAreaInner {
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
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>

<body>

	<div id="container">

		<%@ include file="/WEB-INF/views/include/header.jsp"%>
		<!-- <div id="header" class="bgColorHeader">
            
            <table class="titleTable" width=100% border=0 cellspacing=0>
                <tr><td rowspan=2 class="alignRight" width=15% valign="bottom"><img class="userImg" width=50 src="./images/userImg.png"></td>
                    <td  class="alignLeft"> 2008123456114</td></tr>
                <tr><td class="alignLeft"> 관리자</td></tr>
            </table> 
            <table class="titleTable" width=100% border=0 cellspacing=0>
                <tr><td><a href="cList.html">강의</a></td>
                    <td><a href="tList.html">강사</a></td>
                    <td><a href="sList.html">[학생]</a></td></tr>                
            </table> 
        </div>
	     -->


		<div id="contentsAll">

			[2020.1학기]
			<canvas id="canvas" width=500 height=500>
			<table width=100% border=0>
				<tr>
					<td class="alignLeft bold">개설강좌 조회</td>
					<td class="tdRight">교과목검색
						<button id="search" class="btnSearch">F</button> <input
						type="text" id="search">
					</td>
				</tr>
			</table>
		</canvas>
<a id="download" download="myImage.jpg" href=""
		onclick="download_img(this);" style="color=black">클릭하면 다운받아짐</a>


			<div id="courseList"></div>

			<br> <br> <br>

			<table width=100% border=0>
				<tr>
					<td class="alignLeft bold">수강신청 목록</td>
					<td class="tdRight">수강과목 : 4/5
						<button id="clearList" " class="btnTmyPage"
							onClick="doclearList()">목록 초기화</button>
					</td>
				</tr>
			</table>
			<div id="myCourseList"></div>
			<br> <br> <br>
			<table width=100% border=0>
				<tr>
					<td class="alignLeft bold">일정표</td>
					<td class="tdRight">
						<button id="saveImg" class="btnTmyPage" onClick="viewSaveImg()">이미지저장</button>
						<button id="shareKa" class="btnTmyPage" onClick="viewShareKa()">카카오톡공유</button>
					</td>
				</tr>
			</table>

			<div id="timeTable"></div>

		</div>
	</div>



	

	<div id="infoArea">
		<div id="infoAreaInner">
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
							<button class="" onClick="closeInfo()">닫기</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="delArea">
		<div id="delAreaInner">
			<form>
				삭제
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
							<button class="" onClick="closeDel()">취소</button>
							<button type="submit" id="del" class=""
								onClick="doDel(this.form)">삭제</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="saveImgArea">
		<div id="saveImgAreaInner">
			<button class="btnTmyPage" onClick="closeSaveImg()">취소</button>
			<button class="btnTmyPage" onClick="doSaveImg()">이미지저장</button>
		</div>
	</div>
	<div id="shareKaArea">
		<div id="shareKaAreaInner">
			<button class="btnTmyPage" onClick="doShareKa()">카카오톡공유</butto
		</div>
	</div>
</body>
<script>

var canvas = document.getElementById("canvas");
var ctx = canvas.getContext("2d");
var ox = canvas.width / 2;
var oy = canvas.height / 2;
ctx.font = "100px serif";
ctx.textAlign = "center";
ctx.textBaseline = "middle";
ctx.fillStyle = "#8000";
ctx.fillRect(ox/2,oy/2,ox,oy)

download_img = function(el) {
  var image = canvas.toDataURL("image/jpg");
  el.href = image;
};


	window.onload = function() {

		viewMyCourse();

	}
	//객체 생성
	function Course(cIdx, name, teacher, content, startTime, totalPer,
			applyPer, tIdx) {

		this.cIdx = cIdx;
		this.name = name;
		this.teacher = teacher;
		this.content = content;
		this.startTime = startTime; // 1~20
		this.totalPer = totalPer;
		this.applyPer = applyPer;
		this.tIdx = tIdx;

	}
	var CourseList = [];
	var SelectedCourseList = [];
	var countOfCourseArea = document.getElementById('countOfCourse');
	var courseListArea = document.getElementById('courseList');
	var SelectedCourseListArea = document.getElementById('myCourseList');
	var timeTableArea = document.getElementById('timeTable');

	makeCourseListTable();

	//var sIdx=${session.sIdx};
	//**
	function makeCourseListTable() {
		makeCourseListTableDATA();
		makeCourseListTableHTML();
	}

	//**강의목록 전체 - 수강신청페이지
	function makeCourseListTableDATA() {

		//alert("전체목록!");

		$.getJSON('sAddFormCourseList.do', function(data) {
			//alert("e들어옴");
			//data와 각각 어떻게 처리할지 함수 정의
			$.each(data, function(key, value) {

				console.log(value);
				//alert(value.cIdx);
				console.log("value.name : " + value.name);
				var cIdx = value.cIdx;
				var cName = value.name;
				var cTeacher = value.teacher;
				var content = value.content;
				var cDay = value.day;
				var cStartTime = value.startTime;
				var cTotalPer = value.totalPer;
				var cApplyPer = value.applyPer;
				var tIdx = value.tIdx;

				CourseList.push(new Course(cIdx, cName, cTeacher, content,
						cStartTime, cTotalPer, cApplyPer, tIdx));

			});

			makeCourseListTableHTML();

		});

	}

	function makeCourseListTableHTML() {
		var makeHtml = '';
		makeHtml += '<table id="idClass" width=100% border="0" cellspacing="0">';
		makeHtml += '<tr class="bgColorGray"><th>강의<br>번호</th><th>강의명</th><th>교수명</th>';
		makeHtml += '<th>수업<br>시간</th><th>정원</th>';
		makeHtml += '<th>강의<br>정보</th><th>신청</th></tr>';
		for (var i = 0; i < CourseList.length; i++) {
			makeHtml += '<tr><td>' + CourseList[i].cIdx + '</td>';
			makeHtml += '<td>' + CourseList[i].name + '</td>';
			makeHtml += '<td>' + CourseList[i].teacher + '</td>';
			makeHtml += '<td>' + CourseList[i].startTime + '</td>';
			makeHtml += '<td>' + CourseList[i].applyPer + ' / '
					+ CourseList[i].totalPer + '</td>';
			makeHtml += '<td><button id="viewInfo" class="" onClick="viewInfo('
					+ i + ')">강의정보</button></td>';
			makeHtml += '<td><button id="insert" class="" onClick="insert(' + i
					+ ')">신청</button></td>';
			makeHtml += '</tr>';
		}
		makeHtml += '</table>';
		courseListArea.innerHTML = makeHtml;
		document.getElementById("idClass").style.border.bottom = "1px solid rgb(228, 228, 228)";
	}

	function viewMyCourse() {
		var sIdx = $
		{
			info.sIdx
		}
		;

		// 내 강의목록 불러오기
		$.ajax({
			url : 'sAddFormMyCourseList.do',
			data : {
				sIdx : sIdx
			},
			method : 'get',
			success : function(data) {

				$.each(data, function(key, value) {
					var cIdx = value.cIdx;
					var cName = value.name;
					var cTeacher = value.teacher;
					var content = value.content;
					var cDay = value.day;
					var cStartTime = value.startTime;
					var cTotalPer = value.totalPer;
					var cApplyPer = value.applyPer;
					var tIdx = value.tIdx;

					SelectedCourseList.push(new Course(cIdx, cName, cTeacher,
							content, cStartTime, cTotalPer, cApplyPer, tIdx));

				});

				makeSelectedCourseListTable();
			}

		});
	}
	function addSelectedCourse() {

		var makeHtml = '';
	}
	function delSelectedCourse() {

	}

	function doSaveImg() {

	}

	function reload() {
		//$("#myCourseList").load(window.location.href+ "myCourseList");
		//location.href=window.location.href;
		viewMyCourse();
	}

	function doclearList() {
		alert('목록초기화 실행!!');
	}
	function closeInfo() {
		document.getElementById('infoArea').style.display = 'none';
	}

	function viewInfo(i) {
		document.getElementById('infoArea').style.display = 'block';
		var infoAreaInner = document.getElementById('infoAreaInner');
		var makeHtml = '';
		makeHtml += '<h1>[ 강의정보 ]</h1>';
		makeHtml += '<br>강의번호 : ' + CourseList[i].cIdx;
		makeHtml += '<br>강의명 : ' + CourseList[i].name;
		makeHtml += '<br>교수 : ' + CourseList[i].teacher;
		makeHtml += '<br>상세소개 : ' + CourseList[i].content;
		makeHtml += '<br>수업시간 : ' + CourseList[i].startTime;
		makeHtml += '<br>정원 : ' + CourseList[i].applyPer + ' / '
				+ CourseList[i].totalPer;
		makeHtml += '<br><br><button class="" onClick="closeInfo()">닫기</button>';
		infoAreaInner.innerHTML = makeHtml;
	}
	function viewSelectedInfo(i) {
		document.getElementById('infoArea').style.display = 'block';
		var infoAreaInner = document.getElementById('infoAreaInner');
		var makeHtml = '';
		makeHtml += '<h1>[ 강의정보 ]</h1>';
		makeHtml += '<br>강의번호 : ' + SelectedCourseList[i].cIdx;
		makeHtml += '<br>강의명 : ' + SelectedCourseList[i].name;
		makeHtml += '<br>교수 : ' + SelectedCourseList[i].teacher;
		makeHtml += '<br>상세소개 : ' + SelectedCourseList[i].content;
		makeHtml += '<br>수업시간 : ' + SelectedCourseList[i].startTime;
		makeHtml += '<br>정원 : ' + SelectedCourseList[i].applyPer + ' / '
				+ SelectedCourseList[i].totalPer;
		makeHtml += '<br><br><button class="" onClick="closeInfo()">닫기</button>';
		infoAreaInner.innerHTML = makeHtml;
	}

	function closeDel() {
		document.getElementById('delArea').style.display = 'none';
	}

	function closeSaveImg() {
		document.getElementById('saveImgArea').style.display = 'none';
	}
	function viewSaveImg() {
		document.getElementById('saveImgArea').style.display = 'block';
	}
	function closeShareKa() {
		document.getElementById('shareKaArea').style.display = 'none';
	}
	function viewShareKa() {
		document.getElementById('shareKaArea').style.display = 'block';
	}

	function makeSelectedCourseListTable() {
		makeSelectedCourseListTableHTML();
		makeSelectedCourseTimeTableHTML();
	}
	function makeSelectedCourseListTableHTML() {

		var makeHtml = '';
		makeHtml += '<table id="idClass" width=100% border="0" cellspacing="0">';
		makeHtml += '<tr class="bgColorGray"><th>강의<br>번호</th><th>강의명</th><th>교수명</th>';
		makeHtml += '<th>수업<br>시간</th><th>정원</th>';
		makeHtml += '<th>강의<br>정보</th><th>신청</th></tr>';
		for (var i = 0; i <= SelectedCourseList.length - 1; i++) {
			makeHtml += '<tr><td>' + SelectedCourseList[i].cIdx + '</td>';
			makeHtml += '<td>' + SelectedCourseList[i].name + '</td>';
			makeHtml += '<td>' + SelectedCourseList[i].teacher + '</td>';
			makeHtml += '<td>' + SelectedCourseList[i].startTime + '</td>';
			makeHtml += '<td>' + SelectedCourseList[i].applyPer + ' / '
					+ SelectedCourseList[i].totalPer + '</td>';
			makeHtml += '<td><button id="viewSelectedInfo" class="" onClick="viewSelectedInfo('
					+ i + ')">강의정보</button></td>';
			makeHtml += '<td><button id="viewDel" class="" onClick="viewDel('
					+ i + ')">삭제</button></td></tr>';
			makeHtml += '</tr>';
		}
		makeHtml += '</table>';
		SelectedCourseListArea.innerHTML = makeHtml;
		document.getElementById("myCourseList").style.border.bottom = "1px solid rgb(228, 228, 228)";

	}

	//내 강의 시간표 (일정표)
	function makeSelectedCourseTimeTableHTML() {
		var arrTimeTable = [];
		var makeHtml = '';
		for (var i = 0; i <= 21; i++) {
			arrTimeTable[i] = '';
		}
		for (var i = 0; i <= SelectedCourseList.length - 1; i++) {
			arrTimeTable[SelectedCourseList[i].startTime] = SelectedCourseList[i].name;

		}
		makeHtml += '<table id="idSchedule" width=100% border=1 cellspacing="0">';
		makeHtml += '<tr class="bgColorGray"><th width="100"></th><th width="100">월</th><th width="100">화</th><th width="100">수</th><th width="100">목</th><th width="100">금</th></tr>';

		makeHtml += '<tr>';
		makeHtml += '<td>1교시<br>09:00</td><td>' + arrTimeTable[1] + '</td><td>'
				+ arrTimeTable[5] + '</td><td>' + arrTimeTable[9] + '</td><td>'
				+ arrTimeTable[13] + '</td><td>' + arrTimeTable[17] + '</td>';
		makeHtml += '</tr><tr>';
		makeHtml += '<td>2교시<br>11:00</td><td>' + arrTimeTable[2] + '</td><td>'
				+ arrTimeTable[6] + '</td><td>' + arrTimeTable[10]
				+ '</td><td>' + arrTimeTable[14] + '</td><td>'
				+ arrTimeTable[18] + '</td>';
		makeHtml += '</tr><tr>';
		makeHtml += '<td>3교시<br>13:00</td><td>' + arrTimeTable[3] + '</td><td>'
				+ arrTimeTable[7] + '</td><td>' + arrTimeTable[11]
				+ '</td><td>' + arrTimeTable[15] + '</td><td>'
				+ arrTimeTable[19] + '</td>';
		makeHtml += '</tr><tr>';
		makeHtml += '<td>4교시<br>15:00</td><td>' + arrTimeTable[4] + '</td><td>'
				+ arrTimeTable[8] + '</td><td>' + arrTimeTable[12]
				+ '</td><td>' + arrTimeTable[16] + '</td><td>'
				+ arrTimeTable[20] + '</td>';
		makeHtml += '</table>';
		timeTableArea.innerHTML = makeHtml;

	}

	function viewDel(i) {
		document.getElementById('delArea').style.display = 'block';

		var delAreaInner = document.getElementById('delAreaInner');
		var makeHtml = '';
		makeHtml += '<h1>[ 강의정보 ]</h1>';
		makeHtml += '<br>강의번호 : ' + SelectedCourseList[i].cIdx;
		makeHtml += '<br>강의명 : ' + SelectedCourseList[i].name;
		makeHtml += '<br>교수 : ' + SelectedCourseList[i].teacher;
		makeHtml += '<br>상세소개 : ' + SelectedCourseList[i].content;
		makeHtml += '<br>수업시간 : ' + SelectedCourseList[i].startTime;
		makeHtml += '<br>정원 : ' + SelectedCourseList[i].applyPer + ' / '
				+ SelectedCourseList[i].totalPer;
		makeHtml += '<br><br><button onClick="closeDel()">취소</button>';
		makeHtml += '<button id="del" class="" onClick="doDel(' + i
				+ ')">삭제</button>';
		delAreaInner.innerHTML = makeHtml;
	}

	function doDel(i) {

		var cIdx = SelectedCourseList[i].cIdx;
		var sIdx = $
		{
			info.sIdx
		}
		;
		//저장하는 ajax - 완료됐으면 Y
		$.ajax({
			url : 'sAddFormCourseDelCheck.do',
			data : {
				sIdx : sIdx,
				cIdx : cIdx
			},
			method : 'get',
			success : function(data) {
				if (data == "Y") {
					alert("정상적으로 삭제가 되었습니다.");
				} else {
					alert("삭제 실패!");
				}
				//SelectedCourseList.push(CourseList[i]);
				// makeSelectedCourseListTable();
			}

		});

		document.getElementById('delArea').style.display = 'none';
		SelectedCourseList.splice(i, 1);
		makeSelectedCourseListTable();
		// form.submit();

	}

	function insert(i) {

		alert("insert!");
		var cIdx = CourseList[i].cIdx;
		var sIdx = $
		{
			info.sIdx
		}
		;
		alert(cIdx);
		alert(sIdx);
		//저장하는 ajax - 완료됐으면 Y
		$.ajax({
			url : 'sAddFormCourseCheck.do',
			data : {
				sIdx : sIdx,
				cIdx : cIdx
			},
			method : 'get',
			success : function(data) {
				if (data == "Y") {
					alert("정상적으로 수강이 신청되었습니다.");
				} else {
					alert("수강신청 실패!");
				}
				//SelectedCourseList.push(CourseList[i]);
				// makeSelectedCourseListTable();
			}

		});

		SelectedCourseList.push(CourseList[i]);

		makeSelectedCourseListTable();

		//SelectedCourseList = [];
		//viewMyCourse();
		// 내 강의목록 불러오기
		/*
		$.ajax({
			url : 'sAddFormMyCourseList.do',
			data : {
					sIdx:sIdx,
					cIdx:cIdx
					},
			method: 'get',
			success : 
				function(data){
				SelectedCourseList = [];
				$.each(data, function(key, value){
					
					console.log(value);
					//alert(value.cIdx);
					console.log("value.name : "+value.name);
					var cIdx = value.cIdx;
					var cName = value.name;
					var cTeacher = value.teacher;
					var content = value.content;
					var cDay = value.day;
					var cStartTime = value.startTime;
					var cTotalPer = value.totalPer;
					var cApplyPer = value.applyPer;
					var tIdx = value.tIdx;
				
					
				SelectedCourseList.push(new Course(cIdx, cName, cTeacher, content, cStartTime, cTotalPer, cApplyPer, tIdx));
					
				});
		        makeSelectedCourseListTable();
		        //makeCourseListTableHTML();
		        //makeCourseListTable();
		        
		        //reload();
				}
					
			});
		 */

	}

	function doShareKa() {
	}
</script>
</html>