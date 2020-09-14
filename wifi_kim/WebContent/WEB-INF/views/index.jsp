<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="js/swiper-bundle.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/swiper-bundle.css">
<link rel="stylesheet" href="css/autoplay.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<title>Insert title here</title>
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

<!-- Login Modal-->
  <div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">
  
      <div class="w3-center"><br>
        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-transparent w3-display-topright" title="Close Modal">×</span>
        <h1>W1F1 Login</h1>
        <img src="img/img_avatar4.png" alt="Avatar" style="width:30%" class="w3-circle w3-margin-top">
      </div>

      <form class="w3-container" method="POST">
        <div class="w3-section">
        <c:if test="${empty loginInfo}">
			<div class="login-page">
				<div class="form">
					<br>
						<a href="${kakao_url}"> <img id="button" style= "display:block; margin: 0px auto;" src=<c:url value="img/kakao_login_medium_narrow.png" />>
						</a>
					<br>
				</div>
			</div>
		</c:if>
        </div>
      </form>
      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('id01').style.display='none'" style="display:block; margin: 0px auto;" type="button" class="w3-button w3-red">Cancel</button>
      </div>
    </div>
  </div>
  
  <!-- MyInfo Modal-->
  <div id="id02" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">
      <div class="w3-center"><br>
        <span onclick="document.getElementById('id02').style.display='none'" class="w3-button w3-xlarge w3-transparent w3-display-topright" title="Close Modal">×</span>
        <h1>W1F1 MyInfo</h1>
        <img src="img/img_avatar4.png" alt="Avatar" style="width:30%" class="w3-circle w3-margin-top">
      </div>
      <div class="w3-section">
		<c:if test="${!empty loginInfo}">
			<table class="table">
			  <tbody>
			    <tr>
			      <th scope="row">Num</th>
			      <td>${loginInfo.midx}</td>
			    </tr>
			    <tr>
			      <th scope="row">ID</th>
			      <td>${loginInfo.id}</td>
			    </tr>
			    <tr>
			      <th scope="row">Name</th>
			      <td>${loginInfo.name}</td>
			    </tr>
			    <tr>
			      <th scope="row">Phone</th>
			      <td>${loginInfo.phone}</td>
			    </tr>
			        <tr>
			      <th scope="row">Addr</th>
			      <td>${loginInfo.addr}</td>
			    </tr>
			  </tbody>
			</table>
		</c:if>
		<br>
        </div>
      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('id02').style.display='none'" style="display:block; margin: 0px auto;" type="button" class="w3-button w3-red">Cancel</button>
      </div>
    </div>
  </div>
  
	<!-- Sidebar (hidden by default) -->
	<nav
		class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left"
		style="display: none; z-index: 3; width: 20%; min-width: 300px"
		id="mySidebar">
		<a href="javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button">Close Menu</a> 
		<a href="#power" onclick="w3_close()" class="w3-bar-item w3-button">파워 리스트</a>
		<a href="#nomal" onclick="w3_close()" class="w3-bar-item w3-button">일반 리스트</a>
		<div class="w3-bar">
		<hr style="margin-bottom: 0">
		<button class="w3-bar-item w3-button tablink w3-red" onclick="openCity(event,'London')" style="display: inline-block; width: 45%;">판매 현황</button>
		<button class="w3-bar-item w3-button tablink" onclick="openCity(event,'Paris')" style="display: inline-block; width: 45%;">구매 현황</button>
		<hr style="margin-top: 0">
		</div>
		<div id="London" class="w3-container city">
   			<h2>판매 내용</h2>
 		</div>
		<div id="Paris" class="w3-container city" style="display:none">
			<h2>구매 내용</h2>
		</div>
	</nav>
	<div class="w3-top" style="height: 200px;">
		<div class="w3-white w3-xlarge" style="background-color: #5c196b">
			<div class="w3-button w3-padding-16 w3-left" onclick="w3_open()">☰</div>
			<c:if test="${empty loginInfo}">
			<div class="w3-button w3-padding-16 w3-right" onclick="document.getElementById('id01').style.display='block'">Login</div>
			</c:if>
			<c:if test="${!empty loginInfo}">
			<div id="kakao_id_logout" class="w3-button w3-padding-16 w3-right">
				<a href="${logout_url}" style="text-decoration: none; color: black;">Logout</a>
			</div>
			<c:if test="${!empty loginInfo}">
			<div class="w3-button w3-padding-16 w3-right" onclick="document.getElementById('id02').style.display='block'">MyInfo</div>
			</c:if>
		</c:if>
			<div class="w3-center w3-padding-16">W1F1</div>
			<hr style="margin-top: 0">
		</div>
	</div>

	<!-- !PAGE CONTENT! -->
		<!-- Swiper -->

		<div class="swiper-container" style="z-index: 0" id="power">
			<h1 style="text-align: center; margin-top: 100px">W1F1 파워 리스트</h1>
			<hr class="hr-1">
			<div class="swiper-wrapper">
				<div class="swiper-slide"><img src="img/slide0.jpg" style="width: 100%" height="100%"></div>
				<div class="swiper-slide"><img src="img/slide2.jpg" style="width: 100%" height="100%"></div>
				<div class="swiper-slide"><img src="img/slide3.jpg" style="width: 100%" height="100%"></div>
				<div class="swiper-slide"><img src="img/slide4.jpg" style="width: 100%" height="100%"></div>
				<div class="swiper-slide"><img src="img/slide0.jpg" style="width: 100%" height="100%"></div>
				<div class="swiper-slide"><img src="img/slide2.jpg" style="width: 100%" height="100%"></div>
				<div class="swiper-slide"><img src="img/slide3.jpg" style="width: 100%" height="100%"></div>
				<div class="swiper-slide"><img src="img/slide4.jpg" style="width: 100%" height="100%"></div>
				<div class="swiper-slide"><img src="img/slide0.jpg" style="width: 100%" height="100%"></div>
				<div class="swiper-slide"><img src="img/slide2.jpg" style="width: 100%" height="100%"></div>
			</div>
		<!-- Add Pagination -->
		<div class="swiper-pagination"></div>
	</div>

	<a href="<c:if test="${!empty loginInfo}"><c:url value="board/itemList"/></c:if>">게시판으로</a>
	
	<%@include file="board/nomalList.jsp" %>

	<div class="w3-main w3-content w3-padding" style="margin-top: 50px" id="nomal">
	

		<hr id="about">
		<!-- About Section -->
		<div class="w3-container w3-padding-32 w3-center">
			<h3>About Me, The Food Man</h3>
			<br> <img src="/w3images/chef.jpg" alt="Me" class="w3-image"
				style="display: block; margin: auto" width="800" height="533">
			<div class="w3-padding-32">
				<h4>
					<b>I am Who I Am!</b>
				</h4>
				<h6>
					<i>With Passion For Real, Good Food</i>
				</h6>
				<p>Just me, myself and I, exploring the universe of unknownment.
					I have a heart of love and an interest of lorem ipsum and mauris
					neque quam blog. I want to share my world with you. Praesent
					tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta
					lectus vitae, ultricies congue gravida diam non fringilla. Praesent
					tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta
					lectus vitae, ultricies congue gravida diam non fringilla.</p>
			</div>
		</div>
		<hr>

		<!-- Footer -->
		<footer class="w3-row-padding w3-padding-32">
			<div class="w3-third">
				<h3>FOOTER</h3>
				<p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo
					condimentum, porta lectus vitae, ultricies congue gravida diam non
					fringilla.</p>
				<p>
					Powered by <a href="https://www.w3schools.com/w3css/default.asp"
						target="_blank">w3.css</a>
				</p>
			</div>

			<div class="w3-third">
				<h3>BLOG POSTS</h3>
				<ul class="w3-ul w3-hoverable">
					<li class="w3-padding-16"><img src="/w3images/workshop.jpg"
						class="w3-left w3-margin-right" style="width: 50px"> <span
						class="w3-large">Lorem</span><br> <span>Sed mattis
							nunc</span></li>
					<li class="w3-padding-16"><img src="/w3images/gondol.jpg"
						class="w3-left w3-margin-right" style="width: 50px"> <span
						class="w3-large">Ipsum</span><br> <span>Praes tinci
							sed</span></li>
				</ul>
			</div>

			<div class="w3-third w3-serif">
				<h3>POPULAR TAGS</h3>
				<p>
					<span class="w3-tag w3-black w3-margin-bottom">Travel</span> <span
						class="w3-tag w3-dark-grey w3-small w3-margin-bottom">New
						York</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Dinner</span>
					<span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Salmon</span>
					<span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">France</span>
					<span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Drinks</span>
					<span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Ideas</span>
					<span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Flavors</span>
					<span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Cuisine</span>
					<span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Chicken</span>
					<span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Dressing</span>
					<span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Fried</span>
					<span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Fish</span>
					<span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Duck</span>
				</p>
			</div>
		</footer>

		<!-- End page content -->
	</div>
	<script>
function openCity(evt, cityName) {
  var i, x, tablinks;
  x = document.getElementsByClassName("city");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < x.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" w3-red", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " w3-red";
}
</script>
	
	<script>
    var swiper = new Swiper('.swiper-container', {
      slidesPerView: 3,
      autoplay: {
      	delay: 2500,
      	disableOnInteraction: false,
      },
      grabCursor: true,
      spaceBetween: 30,
      pagination: {
        el: '.swiper-pagination',
        clickable: true,
        renderBullet: function (index, className) {
            return '<span class="' + className + '">' + (index + 1) + '</span>';
          },
      },
      navigation: {
          nextEl: '.swiper-button-next',
          prevEl: '.swiper-button-prev',
        },
    });
  </script>
	
	<script>
		// Script to open and close sidebar
		function w3_open() {
			document.getElementById("mySidebar").style.display = "block";
		}

		function w3_close() {
			document.getElementById("mySidebar").style.display = "none";
		}
	</script>
</body>
</html>