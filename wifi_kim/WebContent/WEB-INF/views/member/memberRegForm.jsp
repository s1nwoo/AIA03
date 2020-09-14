<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 추가입력</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
<link rel="stylesheet" href="../css/w3.css">
<!-- <link rel="stylesheet" href="../css/bootstrap.css"> -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<style>
body, h2, h3, h4, h5, h6 {
	font-family: "Nanum Gothic", sans-serif;
	background-color: white;
}

h1{
	font-family: "Nanum Gothic", sans-serif;
	font-weight: 800;
}

.w3-bar-block .w3-bar-item {
	padding: 20px
}

.w3-quarter {
	width: 25%;
}

.swiper-container{
	height: 80%;
}

.hr-1 {
	border: solid 2px #9055A2;
	width: 100px;
	margin-left: auto;
	margin-right: auto;
}
</style>

<body>

	<div class="w3-top" style="height: 200px;">
		<div class="w3-white w3-xlarge" style="background-color: #5c196b">
			<div class="w3-button w3-padding-16 w3-left" onclick="w3_open()">☰</div>
			<div class="w3-button w3-padding-16 w3-right" onclick="document.getElementById('id01').style.display='block'">Login</div>
			<div class="w3-center w3-padding-16">W1F1</div>
			<hr style="margin-top: 0">
		</div>
	</div>
	

	
<div style="margin-top: 300px; width: 50%;" >
	<form id="regForm" method="POST" class="w3-container w3-card-4 w3-light-grey w3-text-black w3-margin">
		<h2 class="w3-center" style="background-color: #ffffff">Sign Up</h2>

		<div class="w3-row w3-section">
			<div class="w3-col" style="width: 50px">
				<i class="w3-xxlarge fa fa-user"></i>
			</div>
			<div class="w3-rest">
				<input class="w3-input w3-border" id="id" name="id" type="email" value="${email}" style="background: gray;" readonly >
			</div>
		</div>

		<div class="w3-row w3-section">
			<div class="w3-col" style="width: 40px">
				<i class="w3-xxlarge fa fa-user"></i>
			</div>
			<div class="w3-rest">
				<input class="w3-input w3-border" id="name" name="name" type="text" placeholder="NickName" required>
				<span  class="w3-text-purple" id="checkmsg"></span>
				<input type="checkbox" name="namechk" id="namechk">ID중복체크
			</div>
		</div>

		<div class="w3-row w3-section">
			<div class="w3-col" style="width: 40px">
				<i class="w3-xxlarge fa fa-envelope-o"></i>
			</div>
			<div class="w3-rest">
				<input class="w3-input w3-border" id="phone" name="phone" type="text" placeholder="PhoneNumber" required>
			</div>
		</div>

		<div class="w3-row w3-section">
			<div class="w3-col" style="width: 40px">
				<i class="w3-xxlarge fa fa-phone"></i>
			</div>
			<div class="w3-rest">
				<input class="w3-input w3-border" id="addr" name="addr" type="text" placeholder="Address" style="width: 80%;">
				<input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
				<div id="map" style="width:300px; height:300px; margin-top:10px; display:none"></div>
			</div>
		</div>
		<div>
			<button class="w3-button w3-section w3-ripple w3-text-white" style="background-color: #9055A2" type="submit">회원가입</button>
			<input class="w3-button w3-section w3-ripple w3-text-white w3-red" type="button" value="가입취소" onclick="location.href='http://localhost:8080/wifi/index'">
		</div>
	</form>
</div>


</body>
</html>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=64673c1abc8cfe0b9803764ec5691a78&libraries=services"></script>

<script>
	$(document).ready(function(){
		
		$('#regForm').submit(function(){
			
			if(!$('#namechk').prop('checked')){
				alert('닉네임 중복 체크는 필수 항목 입니다');
				$('#name').focus();
				return false;
			}
			
			
			
		}); // regForm submit end
	
		$('#name').focusin(function(){
			
			$(this).val('');
			$('#namechk').prop('checked', false);
			
			$('#checkmsg').text('');
			
			$('#checkmsg').removeClass('check_not');
			$('#checkmsg').removeClass('check_ok');
			
		}); // name focusin end
		
		$('#name').focusout(function(){
			
			
			
			if($(this).val().length < 1) {
				
				$('#checkmsg').text("닉네임 항목은 필수 항목입니다.");
				$('#checkmsg').addClass('check_not');
				return false;
			} // name focusout if end
			
			$.ajax({
				url:'nameCheck',
				data: {name: $('#name').val()},
				success: function(data){
					if(data == 'Y') {
						$('#checkmsg').text("사용 가능한 닉네임입니다.");
						$('#checkmsg').addClass('check_ok');
						$('#namechk').prop('checked', true);
					} else {
						$('#checkmsg').text("이미 사용중인 닉네임입니다.");
						$('#checkmsg').addClass('check_not');
						$('#namechk').prop('checked', false);
					
					} // success if end
					
				} // success function end
				
				
			}); // ajax check name end
			
			
		}); // name focusout function end
		
		
	}); // jquery end
	
	
	
   var mapContainer = document.getElementById('map'), // 지도를 표시할 div
       mapOption = {
           center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
           level: 5 // 지도의 확대 레벨
       };

   //지도를 미리 생성
   var map = new daum.maps.Map(mapContainer, mapOption);
   //주소-좌표 변환 객체를 생성
   var geocoder = new daum.maps.services.Geocoder();
   //마커를 미리 생성
   var marker = new daum.maps.Marker({
       position: new daum.maps.LatLng(37.537187, 127.005476),
       map: map
   });


   function sample5_execDaumPostcode() {
       new daum.Postcode({
           oncomplete: function(data) {
               var addr = data.address; // 최종 주소 변수

               // 주소 정보를 해당 필드에 넣는다.
               document.getElementById("addr").value = addr;
               // 주소로 상세 정보를 검색
               geocoder.addressSearch(data.address, function(results, status) {
                   // 정상적으로 검색이 완료됐으면
                   if (status === daum.maps.services.Status.OK) {

                       var result = results[0]; //첫번째 결과의 값을 활용

                       // 해당 주소에 대한 좌표를 받아서
                       var coords = new daum.maps.LatLng(result.y, result.x);
                       // 지도를 보여준다.
                       mapContainer.style.display = "block";
                       map.relayout();
                       // 지도 중심을 변경한다.
                       map.setCenter(coords);
                       // 마커를 결과값으로 받은 위치로 옮긴다.
                       marker.setPosition(coords)
                   }
               });
           }
       }).open();
   }
</script>