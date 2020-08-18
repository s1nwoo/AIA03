<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<style>
#commentList {
	overflow: hidden;
}

div.card {
	width: 100%;
	height: 50%;
	float: left;
	border: 1px solid #DDD;
}

div.card>ul>li {
	list-style: none;
	font-size: 12px;
}

#contentText {
	font-size: 20px;
}

</style>

<body>

	<h2>댓글 리스트</h2>
	<hr>
	<div id="commentList"></div>
	<hr>

	<h2>댓글 작성</h2>
	<form id="commentForm" onsubmit="return false;">
		<input type="text" name="content" id="content" placeholder="댓글을 작성하세요"><br> 
		<input type="submit" value="댓글등록" onclick="commentSubmit();">
	</form>
	
	<h2>댓글 수정</h2>
	<form id="editForm" onsubmit="return false;">
		<input type="text" name="cidx" id="cidx" readonly><br>
		<input type="text" name="content" id="econtent" placeholder="댓글을 작성하세요"><br>
		<input type="submit" value="댓글수정" onclick="editSubmit(); "><br>
	</form>


	<script>

	$(document).ready(function(){
	
		commentList();
	
	});
	
	
	function commentSubmit(){
		
		var commentFormData = new FormData();
		commentFormData.append('content', $('#content').val());
		
			$.ajax({
				url: 'http://localhost:8080/cm/comment',
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
			url: 'http://localhost:8080/cm/comment' ,	
			type: 'GET',
			success: function(data){
				
				var html = '';
				
				for(var i=0; i<data.length; i++){
					html += '<div class="card">';
					html += '	<ul>';	
					//html += '		<li>댓글번호 : '+data[i].cidx+'</li>';
					html += '		<li id="contentText">'+data[i].content+'</li>';
					html += '		<li>'+data[i].toDate+'</li>';
					html += '		<li>작성자: </li>';
					//html += '		<li>댓글상태 : '+data[i].state+'</li>';
					html += '		<li><input type="button" value="수정" onclick="editForm('+data[i].cidx+')"> ';
					html += '		<input type="button" value="삭제" onclick="deleteComment('+data[i].cidx+')"></li>';
					html += '	</ul>';
					html += '</div>';
					
				}
			$('#commentList').html(html);
				
			}
		});
		
	}
	
	function editForm(cidx){
		$.ajax({
			url : 'http://localhost:8080/cm/comment/'+cidx,
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
			url : 'http://localhost:8080/cm/comment/'+$('#cidx').val(),
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
				url : 'http://localhost:8080/cm/comment/'+ cidx,
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