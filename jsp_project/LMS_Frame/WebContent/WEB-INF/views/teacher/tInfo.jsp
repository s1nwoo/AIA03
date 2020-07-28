<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LMS</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
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
            height : 20px;
            width : 150px;
            border-color: rgb(188, 188, 188);

        }

        button {
            
            
            width: 80px;
            height: 30px;
            text-align: center;
            font-size :14px;


        }


        .btnSearch {

            margin-left: 5px;
            margin-right: -2px;
            width: 50px;
            height: 26px;
            text-align: center;
            font-size :14px;

        }

        .tdRight {
            text-align : right;
        }

        .alignLeft {
		    text-align : left;
        }


        .alignRight {
            text-align : right;
        }

        .bold {       
            font-size : 25px;
            font-weight : 900;
        }

        a {
            text-decoration : none;
            color : white;
            font-size : 20px;
            font-weight : 500;
            margin: 3px 3px 3px 3px; 
        }
        .titleTable {       
            color : white;
            font-size : 20px;
            font-weight : 500;
            margin: 3px 3px 3px 3px;            
            
        
        }
        
        .alignCenter {
            text-align : center;
        }

        .btnStyle {            
            border-radius: 10px;
            font-size:14px;
            color: white;
            font-weight : 900;
            /* background-color: rgba(0, 0, 255, 0.7);
            border-color:  rgba(0, 0, 255, 1);             */
        }

        .btnStyle:hover {
            color: black;
            background-color: white;
            border-color:  gray; 
        }

        .userImg {
            border-radius: 10px;
            border: 7px solid white;
            

        }




        .bgColorGray {
            background-color: rgb(228, 228, 228);
        }


        .bgColorHeader {
            background-color: rgb(41, 128, 185);
        }
        




    </style>
    <script></script>
</head>

<body>

<div id="container">
<%@ include file="/WEB-INF/views/include/header.jsp"%>
 <!--        <div id="header" class="bgColorHeader">
            
            <table class="titleTable" width=100% border=0 cellspacing=0>
                <tr><td rowspan=2 class="alignRight" width=15% valign="bottom"><img class="userImg" width=50 src="./images/userImg.png"></td>
                    <td  class="alignLeft"> 2008123456114</td></tr>
                <tr><td class="alignLeft"> 컴퓨터학과 주강사</td></tr>
            </table> 
            <table class="titleTable" width=100% border=0 cellspacing=0>
                <tr><td><a href="cAddForm.html">강의등록</a></td>
                    <td><a href="tMyPage.html">나의 강의실</a></td>
                    <td><a href="tInfo.html">[내정보]</a></td></tr>                
            </table> 
        </div>
	    
        <div id="contentsAll"> -->
    
		<div id="contentsAll">
				<table width=100% border=0>
					<tr>
						<td width=50% class="alignRight">학과</td>
						<td width=45% class="alignLeft">${info.major}</td>
					</tr>
					<tr>
						<td class="alignRight">교번</td>
						<td class="alignLeft">${info.tIdx}</td>
					</tr>
					<tr>
						<td class="alignRight">직급</td>
						<td class="alignLeft">${info.job}</td>
					</tr>
					<tr>
						<td class="alignRight">이름</td>
						<td class="alignLeft">${info.name}</td>
					</tr>
				</table>
				
				<!-- 비밀번호 체크 Form -->
				<form id="checkPwtForm" action="checkPw.do" method="post">
				<table width=100% border=0>
					<tr>
						<td class="alignLeft" width=50%><input type="hidden" id="pw1" name="pw1" value="${info.pw}"></td>
					</tr>
					<tr>
						<td class="alignRight" width=50%>비밀번호 확인</td>
						<td class="alignLeft" width=45%><input type="password" id="pw2" name="pw2"></td>
						
					</tr>	
					<tr>
						<td class="alignRight" width=50%> </td>
						<td class="alignLeft" width=45%><input type="submit" id="chkPw" value="확인"></td>
					</tr>
				</table>
				</form>

				<!-- result값이 존재하지 않거나 0일 경우 -->
				<!-- 처음 로그인 시 저장되어있는 session 로그인정보 출력 --> 
				<c:if test="${empty result or result == 0}">
				<table width=100% border=0>	
					<tr>
						<td width=50% class="alignRight">핸드폰</td>
						<td width=45% class="alignLeft">${info.tel}</td>
					</tr>
					<tr>
						<td width=50% class="alignRight">이메일</td>
						<td width=45% class="alignLeft">${info.email}</td>
					</tr>
				</table>	
			 	</c:if>
				 
				 <!-- 비밀번호 체크 결과 chkResult 가 1일 경우 -->
				 <!-- 수정할 수 있는 Form 테이블이 생성됨 -->
				 <c:if test="${chkResult eq 1}">
				 <form id="infoEditForm" action="infoEdit.do" method="post">
				 <table width=100% border=0>
					<tr>
						<td width=50% class="alignRight">수정할 전화번호</td>
						<td width=45% class="alignLeft"><input type="text" id="tel" name="tel"></td>
					</tr>
					<tr>
						<td width=50% class="alignRight">수정할 이메일</td>
						<td width=45% class="alignLeft"><input type="text" id="email" name="email"></td>
					</tr>
					<tr>
						<td width=50% class="alignRight"> </td>
						<td width=45% class="alignLeft"><input type="submit" id="modify" class="" value="수정"></td>
					</tr>
				</table>
				</form>
				</c:if>
				
				<!-- result 결과가 1일 경우 -->
				<!-- dao를 통해 update 된 새로운 session 정보 출력 -->
				<c:if test="${not empty result && result eq 1}">
				<table width=100% border=0>
				 	<tr>
						<td width=50% class="alignRight">핸드폰</td>
						<td width=45% class="alignLeft">${chgTel}</td>
					</tr>
					<tr>
						<td width=50% class="alignRight">이메일</td>
						<td width=45% class="alignLeft">${chgEmail}</td>
					</tr>	
				</table>
				</c:if>
		</div>

	</div>
  

</body>

<script>

</script>

</html>

    