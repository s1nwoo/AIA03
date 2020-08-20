<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<style>

#commentList {
	overflow: hidden;
}
/* 
div.card {
	
	width: 100%;
	height: 30%;
	float: left;
	border: 1px solid #DDD;
} */

div.card>ul>li {
	list-style: none;
	font-size: 12px;
}

#contentText {
	font-size: 32px;
}

#editForm{
	/* display: none; */
}

button.deleteImg {
  background : url("images/delete.png");
  position : right;
  border: none;
  width: 32px;
  height: 32px;
  cursor: pointer;
}

button.editImg {
  background : url("images/pencil.png");
  position : right;
  border: none;
  width: 32px;
  height: 32px;
  cursor: pointer;
}

input.form-control{
	width: 40%;
}

</style>

<body>

	<h3>댓글 리스트</h3>
	<div id="commentList"></div>

	<h3>댓글 작성</h3>
	<form id="commentForm" onsubmit="return false;">
		<input type="text" class="form-control" name="content" id="content" placeholder="댓글을 작성하세요" required>
		<button class="btn btn-primary" onclick="commentSubmit();">등록</button>
	</form>
	
	<h3>댓글 수정</h3>
	<form id="editForm" onsubmit="return false;">
		<input type="text" class="form-control" name="content" id="econtent" placeholder="댓글을 수정하세요" required>
		<button type="button" class="btn btn-primary" onclick="editSubmit();">수정</button>
	</form>

<script>


	var domain = 'http://ec2-13-209-17-96.ap-northeast-2.compute.amazonaws.com:8080/wifiComment/comment';
	//var domain = 'http://localhost:8080/comment/comment'
	
	$(document).ready(function(){
	
		commentList();
		
	})
	
	//prependTo()를 사용해서 더보기 
	//$('.more').on('click', function(){
	//$('<p>추가내용<p>').prependTo('.last_li');	//여기다 데이터를 저장해서 불러오기(json)
	//});
	
	function commentSubmit(){
		
		var commentFormData = new FormData();
		commentFormData.append('content', $('#content').val());
		
			$.ajax({
				url: domain,
				type: 'POST',
				data: commentFormData,
				processData: false, // File 전송시 필수
				contentType: false, // multipart/form-data
				success: function(data){
					commentList();
					document.getElementById('commentForm').reset();
				}
				
			});
	}
	

	
	function commentList(){
		
		
		$.ajax({
			url: domain ,	
			type: 'GET',
			success: function(data){
				
				var html = '';
				var len = data.length;
				
				for(var i=0; i<len; i++){
					html += '<div class="card">';
					html += '	<ul class="list-group-item">';	
					//html += '		<li>댓글번호 : '+data[i].cidx+'</li>';
					html += '		<li>작성자: '+data[i].midx+'</li>';
					html += '		<li>'+data[i].regdate+'</li>';
					html += '		<br>';
					html += '		<li id="contentText">'+data[i].content;
					//html += '		<li>댓글상태 : '+data[i].state+'</li>';
					html += '		<button class="deleteImg" onclick="deleteComment('+data[i].cidx+')"></button>'
					html += '		<button class="editImg" onclick="editForm('+data[i].cidx+')"></button></li>';
					html += '	</ul>';
					html += '</div>';
				}
			$('#commentList').html(html);
				
			}
		});
		
	}
	

	function editForm(cidx){
		
		$.ajax({
			url : domain+'/'+cidx,
			type : 'GET',
			success : function(data){
				
				$('#cidx').val(data.cidx);
				$('#econtent').val(data.content);
				$('#econtent').focus();
				
			}
			
		});
	}
	
	function editSubmit(){

		var commentFormData = new FormData();
		commentFormData.append('content', $('#econtent').val());
		
		$.ajax({
			url : domain+'/'+$('#cidx').val(),
			type : 'POST',
			processData: false, // File 전송시 필수
			contentType: false, // multipart/form-data
			data : commentFormData,
			success : function(data){
				commentList();
				document.getElementById('editForm').reset();
			}
		});
		
	}

	
	function deleteComment(cidx){
		
		if(confirm('정말 삭제하시겠습니까?')){
			
			$.ajax({
				url : domain+'/'+cidx,
				type : 'DELETE',
				success : function(data){
					commentList();
				}
			});
		}
	}
	
	
	


</script>

</body>
</html>