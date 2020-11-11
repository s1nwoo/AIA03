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
        .btnTmyPage {
            width: 150px;
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

        #idClass td {
            font-size : 14px;
            border-bottom: 1px solid rgb(228, 228, 228);
        }

        #idSchedule {
            border-color: rgb(228, 228, 228);
        }
        #idSchedule td {
            font-size : 14px;
            border-bottom: 1px solid rgb(228, 228, 228);
        }

        #infoArea{
                
                top:100px;
                left:50%;
                margin-left :-150px;
                
                background-color:white;
                width:300px;
                
                position:absolute;
                /* z-index: 1; */            
                
                border: 2px solid  rgb(26, 188, 156);
                display:none;
                text-align:center;
                font-size :12pt;
                
            }
    
            #infoAreaInner{        
                margin : 10px 10px 10px 10px;
                background-color:white;       
                text-align:center;
                font-size :10pt;
                
            }


          


        #delArea{
            
            top:100px;
            left:50%;
            margin-left :-150px;
            
            background-color:white;
            width:300px;
            
            position:absolute;
            /* z-index: 1; */            
            
            border: 2px solid  rgb(26, 188, 156);
            display:none;
            text-align:center;
            font-size :12pt;
            
        }

        #delAreaInner{        
            margin : 10px 10px 10px 10px;
            background-color:white;       
            text-align:center;
            font-size :10pt;
            
        }

        #saveImgArea{
            
            top:100px;
            left:50%;
            margin-left :-150px;
            
            background-color:white;
            width:300px;
            
            position:absolute;
            /* z-index: 1; */            
            
            border: 2px solid  rgb(26, 188, 156);
            display:none;
            text-align:center;
            font-size :12pt;
            
        }

        #saveImgAreaInner{        
            margin : 10px 10px 10px 10px;
            background-color:white;       
            text-align:center;
            font-size :10pt;
            
        }

        #shareKaArea{
            
            top:100px;
            left:50%;
            margin-left :-150px;
            
            background-color:white;
            width:300px;
            
            position:absolute;
            /* z-index: 1; */            
            
            border: 2px solid  rgb(26, 188, 156);
            display:none;
            text-align:center;
            font-size :12pt;
            
        }

        #shareKaAreaInner{        
            margin : 10px 10px 10px 10px;
            background-color:white;       
            text-align:center;
            font-size :10pt;
            
        }

   

        .bgColorGray {
            background-color: rgb(228, 228, 228);
        }


        .bgColorHeader {
            background-color:rgb(41, 128, 185);
        }
        




    </style>
    <script></script>
</head>

<body>

<div id="container">

		<%@ include file="/WEB-INF/views/include/header.jsp"%>
		
        <!-- <div id="header" class="bgColorHeader">
            
            <table class="titleTable" width=100% border=0 cellspacing=0>
                <tr><td rowspan=2 class="alignRight" width=15% valign="bottom"><img class="userImg" width=50 src="./images/userImg.png"></td>
                    <td  class="alignLeft"> 2008123456114</td></tr>
                <tr><td class="alignLeft">  컴퓨터학과 주강사</td></tr>
            </table> 
            <table class="titleTable" width=100% border=0 cellspacing=0>
                <tr><td><a href="cAddForm.html">강의등록</a></td>
                    <td><a href="tMyPage.html">[나의 강의실]</a></td>
                    <td><a href="tInfo.html">내정보</a></td></tr>                
            </table> 
        </div> -->
	    
        <div id="contentsAll">

        
        <table width=100% border=0>            
            <tr><td class="alignLeft bold">수업 목록</td>
                <td class="tdRight"></td></tr>
        </table>
        
        <table id="idClass" width=100% border=0 cellspacing="0">
            <tr class="bgColorGray"><th>강의<br>번호</th><th>강의명</th><th>교수명</th>
                <th>학년</th><th>이수<br>구분</th><th>수업시간</th><th>정원</th><th>강의정보</th>
                <th>삭제</th></tr>
            <tr class="">
                <td class="">A01</td><td>컴퓨터기초</td><td>송가람</td>
                <td>1</td><td>교양</td><td>수(3,4)</td><td>20/25</td>
                <td><button id="viewInfo" class="" onClick="viewInfo()">강의정보</button></td>
                <td><button id="viewDel" class="" onClick="viewDel()">삭제</button></td></tr>
            <tr class="">
                <td class="">A01</td><td>컴퓨터기초</td><td>송가람</td>
                <td>1</td><td>교양</td><td>수(3,4)</td><td>20/25</td>
                <td><button id="viewInfo" class="" onClick="viewInfo()">강의정보</button></td>
                <td><button id="viewDel" class="" onClick="viewDel()">삭제</button></td></tr>
            <tr class="">
                <td class="">A01</td><td>컴퓨터기초</td><td>송가람</td>
                <td>1</td><td>교양</td><td>수(3,4)</td><td>20/25</td>
                <td><button id="viewInfo" class="" onClick="viewInfo()">강의정보</button></td>
                <td><button id="viewDel" class="" onClick="viewDel()">삭제</button></td></tr>
        </table>

        <br><br><br>

        <table width=100% border=0>            
            <tr><td class="alignLeft bold">일정표</td>
                <td class="tdRight">
                <button id="saveImg" class="btnTmyPage" onClick="viewSaveImg()">이미지저장</button>                
                <button id="shareKa" class="btnTmyPage" onClick="viewShareKa()">카카오톡공유</button>
                </td></tr>
        </table>

        <table id="idSchedule" width=100% border=1 cellspacing="0">
            
            
            <tr class="bgColorGray"><th width="100"></th><th>월</th><th>화</th><th>수</th><th>목</th>
                <th>금</th></tr>
            <tr class="">
                <td>0교시<br>08:00</td><td></td><td></td><td></td><td></td><td></td>
            <tr class="">
                <td>1교시<br>08:00</td><td></td><td></td><td></td><td></td><td></td>
            <tr class="">
                <td>2교시<br>08:00</td><td></td><td></td><td></td><td></td><td></td>
            <tr class="">
                <td>3교시<br>08:00</td><td></td><td></td><td></td><td></td><td></td>
            <tr class="">
                <td>4교시<br>08:00</td><td></td><td></td><td></td><td></td><td></td>
            <tr class="">
                <td>5교시<br>08:00</td><td></td><td></td><td></td><td></td><td></td>
            <tr class="">
                <td>6교시<br>08:00</td><td></td><td></td><td></td><td></td><td></td>
            <tr class="">
                <td>7교시<br>08:00</td><td></td><td></td><td></td><td></td><td></td>
            <tr class="">
                <td>8교시<br>08:00</td><td></td><td></td><td></td><td></td><td></td>
        </table>
        



        </div>        
             

        
    </div>

    <div id="infoArea">
        <div id="infoAreaInner">
        
        <form>

            강의정보
            <table width=100% border=0>
                <tr><td>교과목명</td>
                    <td></td></tr>
                <tr><td>교수명</td>
                    <td></td></tr>
                <tr><td>과목내용</td>
                    <td></td></tr>
                <tr><td>대상학년</td>
                    <td></td></tr>
                <tr><td>이수구분</td>
                    <td></td></tr>
                <tr><td>학점</td>
                    <td></td></tr>
                <tr><td>수업시간</td>
                    <td></td></tr>
                <tr><td>정원</td>
                    <td></td></tr>
                <tr><td>교재</td>
                    <td></td></tr>
                <tr><td>강의실</td>
                    <td></td></tr>
                <tr><td colspan="2">
                    <button class="" onClick="closeInfo()">닫기</button>                    
                </td></tr>
            </table>
        </form>
        </div>
    </div>


    <div id="delArea">
        <div id="delAreaInner">
        
        <form>

            강사삭제
            <table width=100% border=0>
                <tr><td>교과목명</td>
                    <td></td></tr>
                <tr><td>교수명</td>
                    <td></td></tr>
                <tr><td>과목내용</td>
                    <td></td></tr>
                <tr><td>대상학년</td>
                    <td></td></tr>
                <tr><td>이수구분</td>
                    <td></td></tr>
                <tr><td>학점</td>
                    <td></td></tr>
                <tr><td>수업시간</td>
                    <td></td></tr>
                <tr><td>정원</td>
                    <td></td></tr>
                <tr><td>교재</td>
                    <td></td></tr>
                <tr><td>강의실</td>
                    <td></td></tr>
                <tr><td colspan="2">
                    <button class="" onClick="closeInsert()">취소</button>
                    <button type="submit" id="insert" class="" onClick="doInsert(this.form)">삭제</button>
                    </td></tr>
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
        

            <button class="btnTmyPage" onClick="closeShareKa()">취소</button>
            <button class="btnTmyPage" onClick="doShareKa()">카카오톡공유</button>
       
        </div>
    </div>

</body>

<script>

    function closeInfo() {
            document.getElementById('infoArea').style.display = 'none';

    }
    
    function viewInfo() {     
        document.getElementById('infoArea').style.display = 'block';

    }
   

    function closeDel() {
        document.getElementById('delArea').style.display = 'none';

    }
    
    function viewDel() {     
        document.getElementById('delArea').style.display = 'block';

    }

    function doDel(form) {     




        document.getElementById('delArea').style.display = 'none';
        form.submit();
        

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
  

    

    function doShareKa() {     



    }





    

</script>

</html>

