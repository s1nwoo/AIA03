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
    
            <form>

      
                <table width=100% border=0>
                    <tr><td width=50% class="alignRight">학과</td>
                        <td width=45% class="alignLeft">컴퓨터학과</td></tr>
                    <tr><td class="alignRight">교번</td>
                        <td class="alignLeft">20083320</td></tr>
                    <tr><td class="alignRight">직급</td>
                        <td class="alignLeft">주강사</td></tr>
                    <tr><td class="alignRight">이름</td>
                        <td class="alignLeft">박혜미</td></tr>
                    <tr><td class="alignRight">비밀번호</td>
                        <td class="alignLeft"><input type="password" id="pw1"></td></tr>
                    <tr><td class="alignRight">비밀번호 확인</td>
                        <td class="alignLeft"><input type="password" id="pw2"></td></tr>
                    <tr><td class="alignRight">핸드폰</td>
                        <td class="alignLeft"><input type="text" id="phone" value="010-1234-1234"></td></tr>
                    <tr><td class="alignRight">이메일</td>
                        <td class="alignLeft"><input type="text" id="email" value="1234@naver.com"></td></tr>
                    
                    <tr><td colspan="2">
                        
                        <button type="submit" id="modify" class="" onClick="doModify(this.form)">수정</button>
                        </td></tr>
                </table>
            </form>
        

        </div>        
        
    </div>

  

</body>

<script>
    function doModify(form) {     




        
        form.submit();
        

    }
    

  



</script>

</html>

    