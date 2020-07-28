<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>LMS</title>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>


	#innerContainner {
		border: 20px solid lightblue;

		position : absolute;
		top: 50%;
		left: 50%;
		width: 300px;
		height : 450px;
		margin-left: -150px;
		margin-top : -280px;

		/* padding: 10px; */
		
		/* top: 100%; */
		/* left: 50%; */
		/* width : 300px; */
		
		/* margin-left: 15%; */
		/* margin-top : 170px; */


		/* width: 360px;
  
  
		text-align: center;
		position: relative; */
		/* transform:translateY(15%); */


	}
	

	.alignCenter {
		text-align : center;
	}


	.input {

		border: 1px solid;
		height : 25px;
		width : 190px;
		border-color: rgb(188, 188, 188);

		outline-style : none;
		margin-top: 2.6px;
		margin-left : -3px;

	}




	.btnLogin {

		margin-left: 5px;
		margin-right: -2px;
		width: 200px;
		height: 40px;
		text-align: center;
		font-size :14px;
		color : white;
		background-color: rgb(26, 188, 156);
		/* border-color:  rgb(26, 188, 156); */
		border-color: white;
		border-radius: 5px;

	}

	.btnLogin:hover {
            color: black;
            background-color: white;
            border-color:  rgb(26, 188, 156);
	}
	

	.slider {

		outline-style : none;
		-webkit-appearance: none;
		cursor: pointer; 
		
		background: rgb(4, 212, 4); 
		border-radius: 10px;
		height: 15px;
		width : 40px;	
		margin-top: 5px;	
	}

	.slider::-webkit-slider-thumb {
    /* border: 1px solid rgb(1, 122, 1);  */
    height: 12px;
    width: 20px;
    background: #ffffff;
	cursor: pointer;
	border-radius: 10px;
    -webkit-appearance: none;
    /* margin-top: -5px; chrome의 경우 margin-top값을 부여해야합니다. */
	}

	.alignLeft {
		text-align : left;
	}


	.alignRight {
		text-align : right;
	}


	.loginImg{

		margin-top: 6px;



	}

	.fontInnerTable {
		font-size: 14px;
	}



</style>
<link rel="stylesheet" href="./css/lms.css">
</head>

<body>
	<div id="container11">
        <div id="header11">
			<br>
        </div>

        <div id="contentsAll11" class="alignCenter">

			<div id ="innerContainner">
				

				<form id="loginForm" action="login.do" method="post">
					<table width=100% border=0 class="loginTable" cellspacing="0">
						<tr><td class="alignLeft" colspan="2"><img width=70 src="./images/logo.png"></td></tr>
						<tr><td colspan="2"><h1 class="subtitle">로그아웃</h1></td></tr>
						
						<tr>
							<td class="alignRight" width=25%><img class="loginImg" height="35px" src="./images/loginId.png"></td>
							<!-- 로그인번호가 관리자이면, -->
							<c:if test="${loginType eq 'aLogin'}">
								<td class="alignLeft">${info.id}</td>
							</c:if>
							<!-- 로그인번호가 학생이나 강사이면, -->
							<c:if test="${loginType eq 'tLogin' || loginType eq 'sLogin'}">
								<td class="alignLeft">${info.tIdx} ${info.name}</td>
							</c:if>
						</tr>
						<tr>
							<td colspan="2"><input class="btnLogout" type="submit" value="로그아웃"></td>
							<td colspan="2"><input class="btnMyPage" type="submit" value="나의 강의실로"></td>
						</tr>
					</table>
					
				</form>
			</div>
        </div>

	</div>
</body>

<script>
	
	$('.btnLogout').onclick(function(){
		
		location.href = "/LMS_Frame/logout.do";	
	});
	
	
	$('.btnMyPage').onclick(function(){
		
		location.href = "/LMS_Frame/myPage.do";	
		
	});
	
	
	
	
</script> 



</html>






