<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#recommend_itemList {
	
		overflow: hidden;
	
	}
	
	#itemList {
		overflow: hidden;
	}
	div.recommend_card {
		width: 18%;
		height:280px;
		float: left;
		margin: 10px;
		border: 3px solid red;
		
		
	}
	div.card {
		width: 33%;
		float: left;
		
		border : 1px solid blue;
		
	}
	div.search_card {
		width: 33%;
		float: left;
		
		border : 1px solid yellow;
		
	}
	
	div.card>ul>li {
		list-style: none;
		font-size: 12px;
	}
	
	div.keywordBox {
		display: none;
	}
	
	div.categoryBox {
		display: none;
	}
	
	#regForm {
		display: none;
	} 
	
	#aside {
		display: block;
	}
	
	
	#itemDetails {
		display: none;
	}
	#emphasis {
		color: red;
		font-weight: bold;
	}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.27.0/moment.min.js"></script>
</head>
<body>


	<h1>공구게시판</h1>
	
	<div id="regArea"><input type="button" value="글쓰기" onclick="itemReg();">
		<div class="regForm">
			<form id="regForm" onsubmit="return false;">


			공구글제목 : <input type="text" name="title" id="title" required><br>
			가격 : <input type="number" name="price" id="price" required><br>
			공구인원 : <input type="number" name="count_m" id="count_m" min="0" required><br>
			수령날짜 : <input type="datetime-local" id="receive" name="receive" required><br>
			판매처주소 : <input type="text" name="addr" id="addr" required><br>
			판매처위치 : <input type="text" name="location" id="location"><br>
			내용 : <input type="text" name="content" id="content"><br>
			사진 : <input type="file" name="photo" id="photo"><br>
			공구상태 : <input type="checkbox" name="state" id="state" value="1">추천공구로 등록하기<input type="checkbox" name="state" id="state" value="0">일반공구로 등록하기<br> 
			분류 : <select id="category">
						<option value="0">과일</option>
						<option value="1">육류</option>
						<option value="2">해산물</option>
						<option value="3">채소</option>
						<option value="4">생필품</option>
						<option value="5">음료</option>
						<option value="6">기타</option>
				</select><br>
			게시자idx : <input type="number" name="midx" id="midx"><br>
			<input type="submit" value="공구등록" onclick="regSubmit(); ">
			<input type="reset">
		
		
			</form>
		</div>
	</div>
	
	<div class="searchBox">
		<form onsubmit="return false;">
			<select name="searchType" id="searchType">
				<option value="total">전체보기</option>
				<option value="title">제목</option>
				<option value="category">카테고리</option>
			</select>
			
			
			<div class="keywordBox">
				<input type="text" name="keyword" id="keywordBox">
				<input type="submit" value="검색" onclick="searchItem(); cleanSearchList();">
			</div>
			
			
			<div class="categoryBox">
				<select name="keyword" id="categoryBox">
					<option value="0">과일</option>
					<option value="1">육류</option>
					<option value="2">해산물</option>
					<option value="3">채소</option>
					<option value="4">생필품</option>
					<option value="5">음료</option>
					<option value="6">기타</option>
					<option value="">전체보기</option>
				</select>
				<input type="submit" value="검색" onclick="searchItem(); cleanSearchList();">
			</div>
			
			 
			
		</form>
	</div>
	<button onclick="getMySellList();">aside-판매현황</button>
	<div id="aside"></div>
	<br>
	
	<div id="recommend_itemList"></div>
	<br>
	
	<div id="searchList"></div>
	<br>
	
	<div id="itemList"></div>
	<br>
	
	<div id="itemDetails"></div>
	
	<br><br>
	<div id="itemListView"></div>
	
	<br><br>
	<div id="pageNumber"></div>

	



<script>
	//item 객체 생성
	 function Item(iidx, title, price, count_m, count_w, regdate, receive, addr,
				location, content, photo, state, view_count,category, midx) {
				this.iidx = iidx;
				this.title = title;
				this.price = price;
				this.count_m = count_m;
				this.count_w = count_w;
				this.regdate = regdate;
				this.receive = receive;
				this.addr = addr;
				this.location = location;
				this.content = content;
				this.photo = photo;
				this.state = state;
				this.view_count = view_count;
				this.category = category;
				this.midx = midx;
	    }
	
	//MyItem 객체 생성
	 function MyItem(midx, iidx, oidx, pidx, title, price, count_m, count_w,
			 regdate, receive, addr, location, content, photo,
				view_count, category, istate, ostate, pstate) {
				
				this.midx=midx;
				this.iidx=iidx;
				this.oidx=oidx;
				this.pidx=pidx;
				this.title=title;
				this.price=price;
				this.count_m=count_m;
				this.count_w=count_w;
				this.regdate=regdate;
				this.receive=receive;
				this.addr=addr;
				this.location=location;
				this.content=content;
				this.photo=photo;
				this.view_count=view_count;
				this.category=category;
				this.istate=istate;
				this.ostate=ostate;
	        
	    }
	// ItemListView 객체 생성
	function ItemListView(itemTotalCount, currentPageNumber, itemList, pageTotalCount, itemCountPerPage, startRow){
		this.itemTotalCount = itemTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.itemList = itemList;
		this.pageTotalCount = itemTotalCount/itemCountPerPage;
		this.itemCountPerPage = itemCountPerPage;
		this.startRow = startRow;
	}
	
	function ItemListView_recommend(itemTotalCount, currentPageNumber, itemList, pageTotalCount, itemCountPerPage, startRow){
		this.itemTotalCount = itemTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.itemList = itemList;
		this.pageTotalCount = itemTotalCount/itemCountPerPage;
		this.itemCountPerPage = itemCountPerPage;
		this.startRow = startRow;
	}
	
	function MySell(midx, o_midx, iidx, oidx, pidx, title, category, istate, ostate, pstate, ireceive){
		this.midx=midx;
		this.o_midx=o_midx;
		this.iidx=iidx;
		this.oidx=oidx;
		this.pidx=pidx;
		this.title=title;
		this.category=category;
		this.istate=istate;
		this.ostate=ostate;
		this.pstate=pstate;
		this.ireceive=ireceive;
		
	}
	
	function SellListView(itemTotalCount, currentPageNumber, sellList, pageTotalCount, itemCountPerPage, startRow){
		this.itemTotalCount = itemTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.sellList = sellList;
		this.pageTotalCount = itemTotalCount/itemCountPerPage;
		this.itemCountPerPage = itemCountPerPage;
		this.startRow = startRow;
	}
	
	//var mainUrl ='http://ec2-13-209-70-0.ap-northeast-2.compute.amazonaws.com:8080/wifiTESTserver/items';
	var mainUrl ='http://localhost:8080/order/items';
	//var mainUrl ='http://ec2-54-180-98-41.ap-northeast-2.compute.amazonaws.com:8080/order_v2/items';
	var sellUrl = 'http://localhost:8080/order/sell';
	//var sellUrl = 'http://ec2-54-180-98-41.ap-northeast-2.compute.amazonaws.com:8080/order_v2/sell';
	
   	var ItemViewList = [];//메인에서 일반공구
   	var ItemTotalList = [];//메인에서 일반공구
   	var MySellTotalList = [];// 판매현황에서 내 공구
   	var MySellListView = [];// 판매현황에서 내 공구
   	var ItemViewList_recommend = [];//메인에서 추천공구
   	var MyItemTotalList_recommend = [];//메인에서 추천공구
   	var MyItemTotalList = [];//메인에서 일반공구
	var pageNum=1;
	var recommendPageNum=1;
	var searchPageNum=1;
	var searchCheckNum=0;
	
	
	// 가람 요청 0821
	function getMidxByIidx(iidx){
		
		$.ajax({
			
			url: sellUrl+'/'+iidx,
			type: 'GET',
			success : function(data){
				alert('넘어온 midx 데이터 : '+data);
			},
			error : function(){
				alert('실패!!');
			}
			
		});
		
	}
	
	
	function getItemListView_recommend(){
		
		var rhtml='';
		var html='';
		
    	$.ajax({
    		
    		url: mainUrl,
    		type: 'GET',
    		data : {
    			'searchType' : $('#searchType').val(),
   	        	 'page':recommendPageNum,
   	        	 'count':10,
   	        	 'istate':1,
   	        	 'keyword': $('#keywordBox').val()
    		},
    		success: function(data){
    			alert('추천리스트뷰 불러오기 성공!!');
    			console.log(pageNum+'추천 page load');
    			console.log(data+'추천 data');
    			var itemTotalCount = data.itemTotalCount;
    			var currentPageNumber = data.currentPageNumber;
    			console.log(' data.itemList.length : '+data.itemList.length);
    			
				for(var i=0; i<data.itemList.length; i++){
					
					var midx = data.itemList[i].midx;
					var iidx = data.itemList[i].iidx;
					var oidx = data.itemList[i].oidx;
					var pidx = data.itemList[i].pidx;
					var title = data.itemList[i].title;
	 				var price = data.itemList[i].price;
	 				var count_m = data.itemList[i].count_m;
	 				var count_w = data.itemList[i].count_w;
	 				var regdate = moment(data.itemList[i].regdate).format('YYYY-MM-DD');
	 				var receive = moment(data.itemList[i].receive).format('YYYY-MM-DD HH:mm');
	 				var addr = data.itemList[i].addr;
	 				var location = data.itemList[i].location;
	 				var content = data.itemList[i].content;
	 				var photo = data.itemList[i].photo;
	 				var view_count = data.itemList[i].view_count;
	 				var category = data.itemList[i].category;
	 				var istate = data.itemList[i].istate;
	 				var ostate = data.itemList[i].ostate;
	 				var pstate = data.itemList[i].pstate;
					
	 				console.log('istate_recommend :'+ istate);
	 				
	 				MyItemTotalList_recommend.push(new MyItem(midx, iidx, oidx, pidx, title, price, count_m, count_w,
	 						regdate, receive, addr, location, content, photo,
	 						view_count, category, istate, ostate, pstate));
	    			
	    			
	    				
		    			rhtml+='<div class="recommend_card" style="cursor:pointer;">';
		    			rhtml+='<button style="background-color:white; border:0; cursor:pointer;">';
		    			rhtml+='	<ul style="list-style:none;">';
		    			rhtml+='		<li><img src="http://localhost:8080/order/upload/'+photo+'" width="80%" height="80%"></li>';
		    			rhtml+='		<li>공구idx : '+iidx+'</li>';
		    			rhtml+='		<li>제목 : '+title+'</li>';
		    			rhtml+='		<li>가격 : '+price+'</li>';
		    			rhtml+='		<li>모집인원 : '+count_m+'</li>';
		    			rhtml+='		<li>등록일시 : '+regdate+'</li>';
		    			rhtml+='		<li>판매처주소 : '+addr+'</li>';
		    			rhtml+='		<li><input type="button" value="상세보기" onclick="showDetails('+iidx+');">';
		    			rhtml+='		<input type="button" value="삭제하기" onclick="deleteItem('+iidx+');"></li>';
		    			rhtml+='	</ul>';
		    			rhtml+='</button>';
		    			rhtml+='</div>';
		    			
		    			
	    			
	    			}
		    			console.log(rhtml);
	    		
	    		var pageTotalCount = data.itemTotalCount/data.itemCountPerPage;
				var itemCountPerPage = data.itemCountPerPage;
				var startRow = data.startRow;
	    		
    	
				ItemViewList_recommend.push(new ItemListView_recommend(itemTotalCount, currentPageNumber, itemList, pageTotalCount, itemCountPerPage, startRow));
	    	$('#recommend_itemList').append(rhtml);
	    	
	    	}, 
	    	error: function(data){
	    			alert(data);
	    			alert('추천리스트뷰 불러오기 실패');
	    	},
	    	complete : function(){
	    		
	    	}
	    	
	    	});
    	
    }
	
    	
    function getItemListView(){
    			
		var html='';
		
    	$.ajax({
    		
    		url: mainUrl,
    		type: 'GET',
    		data : {
    			 'searchType' : $('#searchType').val(),
    	         'page':pageNum,
    	         'count':5,
    	         'istate':0,
    	         'keyword': $('#keywordBox').val()
    		},
    		success: function(data){
    			console.log(pageNum+'일반 page load');
    			alert('리스트뷰 불러오기 성공!!');
    			
    			if(pageNum>data.pageTotalCount) {
    				$(window).off();
    	         } 
    			var itemTotalCount = data.itemTotalCount;
    			var currentPageNumber = data.currentPageNumber;
    			console.log('▶ 일반 data.itemList.length : '+data.itemList.length);
				for(var i=0; i<data.itemList.length; i++){
					
					var midx = data.itemList[i].midx;
					var iidx = data.itemList[i].iidx;
					var oidx = data.itemList[i].oidx;
					var pidx = data.itemList[i].pidx;
					var title = data.itemList[i].title;
	 				var price = data.itemList[i].price;
	 				var count_m = data.itemList[i].count_m;
	 				var count_w = data.itemList[i].count_w;
	 				var regdate = moment(data.itemList[i].regdate).format('YYYY-MM-DD');
	 				var receive = moment(data.itemList[i].receive).format('YYYY-MM-DD HH:mm');
	 				var addr = data.itemList[i].addr;
	 				var location = data.itemList[i].location;
	 				var content = data.itemList[i].content;
	 				var photo = data.itemList[i].photo;
	 				var view_count = data.itemList[i].view_count;
	 				var category = data.itemList[i].category;
	 				var istate = data.itemList[i].istate;
	 				var ostate = data.itemList[i].ostate;
	 				var pstate = data.itemList[i].pstate;
					
	 				console.log(istate+': istate');
	 				
	 				MyItemTotalList.push(new MyItem(midx, iidx, oidx, pidx, title, price, count_m, count_w,
	 						regdate, receive, addr, location, content, photo,
	 						view_count, category, istate, ostate, pstate));
		    			
		    			html+='<div class="card">';
		    			html+='<button>';
						html+='	<ul>';
						html+='		<li>공구idx : '+iidx+'</li>';
						html+='		<li>제목 : '+title+'</li>';
						html+='		<li>가격 : '+price+'</li>';
						html+='		<li>모집인원 : '+count_m+'</li>';
						html+='		<li>등록일시 : '+regdate+'</li>';
						html+='		<li>판매처주소 : '+addr+'</li>';
						html+='		<li>사진 : '+photo+'</li>';
						html+='		<li><input type="button" value="상세보기" onclick="showDetails('+iidx+');">';
						html+='		<input type="button" value="삭제하기" onclick="deleteItem('+iidx+');"></li>';
						html+='	</ul>';
		    			html+='</button>';
						html+='</div>';
	    			
	    			}
				
	    		var pageTotalCount = data.itemTotalCount/data.itemCountPerPage;
				var itemCountPerPage = data.itemCountPerPage;
				var startRow = data.startRow;
    	
				ItemViewList.push(new ItemListView(itemTotalCount, currentPageNumber, itemList, pageTotalCount, itemCountPerPage, startRow));
			
			cleanSearchList();
   		
	    	
	    	}, 
	    	error: function(data){
	    			alert(data);
	    			alert('리스트뷰 실패');
	    	},
	    	complete : function(){
	    		$('#itemList').append(html);
	   			pageNum++;
	    		loading=false;
	    	}
	    	
    	});
    	
    	// 활성화시 
		$(window).scroll(function() {
	      if($(window).scrollTop()+200>=$(document).height() - $(window).height()) {
	    	  if(!loading) {
	            loading=true;
	            getItemListView();
	         } 
	       } 
	    });
    	
    }
    
	
    function cleanItemList(){
    	 var html ='';
    	 $('#itemList').html(html);
    }
    function cleanSearchList(){
	   	 var html ='';
	   	 $('#searchList').html(html);
	   	searchPageNum=1;
   }
    function cleanSellList(){
	   	 var html ='';
		 $('#aside').html(html);
	}
    
	// ok
	function showDetails(iIdx){
		var html = '';
		
		$.ajax({
			
			url : mainUrl+'/'+iIdx,
			type : 'GET',
			success : function(data){
				alert('상세보기의 결과 데이터 : '+data);
				 html += '<br><h2> [ 공구 상세 ] </h2>';
				 html += '<br>공구글번호 : '+data.iidx;
				 html += '<br>글제목 : '+data.title;
				 html += '<br>가격 : '+data.price;
				 html += '<br>모집인원 : '+data.count_m;
				 html += '<br>대기가능인원 : '+data.count_w;
				 html += '<br>등록일시 : '+moment(data.regdate).format('YYYY-MM-DD');
				 html += '<br>수령일시 : '+moment(data.receive).format('YYYY-MM-DD HH:mm')+'까지';
				 html += '<br>판매처주소 : '+data.addr;
				 html += '<br>판매처위치 : '+data.location;
				 html += '<br>내용 : '+data.content;
				 html += '<br>사진 : '+data.photo;
				 html += '<br>공구상태값 : '+data.state;
				 html += '<br>조회수 : '+data.view_count;
				 html += '<br>상품분류 : '+data.category;
				 html += '<br>게시자idx : '+data.midx;
				 html += '<br><br><button class="" onclick="itemRequest('+data.iidx+','+data.count_w +');">신청</button>';
				 html += '<button class="" onclick="closeInfo();">닫기</button>';
				 // 기간 만료 체크용
				 if(new Date(data.receive) < new Date()){
					 console.log('new Date(data.receive) : '+new Date(data.receive));
				 }
				 
				 html += '';
				 document.getElementById('itemDetails').style.display='block';
				 $('#itemDetails').html(html);
				 
				 console.log('data.receive는 '+data.receive);
			},
			error : function(data){
				alert(data);
				alert('상세보기실패');
			}
		});
			
	}
	
	 function closeInfo(){
		 	document.getElementById('itemDetails').style.display='none';
		 }
	 
	 function closeRegForm(){
		 document.getElementById('regForm').style.display='none';
	 }
	 function closeMySell(){
		 document.getElementById('aside').style.display='none';
	 }
	
	function itemReg(){
		//location.href='itemRegForm';
		document.getElementById('regForm').style.display='block';
		
	}
	
	function regSubmit(){
		var regFormData = new FormData();
		regFormData.append('title', $('#title').val());
		regFormData.append('price', $('#price').val());
		regFormData.append('count_m', $('#count_m').val());
		regFormData.append('count_w', $('#count_m').val()*2);
		regFormData.append('receive', moment($('#receive').val()).format('YYYY-MM-DD HH:mm:ss'));
		regFormData.append('addr', $('#addr').val());
		regFormData.append('location', $('#location').val());
		regFormData.append('content', $('#content').val());
		// 파일 첨부
		if($('#photo')[0].files[0] != null){
		regFormData.append('photo', $('#photo')[0].files[0]);
		}
		regFormData.append('state', $('#state').val());
		regFormData.append('view_count', 0);
		regFormData.append('category', $('#category').val());
		regFormData.append('midx', $('#midx').val());
		
		$.ajax({
			
			url : mainUrl,
			type : 'POST',
			processData : false,
			contentType : false,
			data : regFormData,
			success : function(data){
				alert('공구등록완료');
				closeRegForm();
				getItemListView();
				
			},
			error : function(data){
				console.log(data);
				alert('실패');
			}
		});
	}
	
	// ok
	function deleteItem(iidx){
		
			//cleanItemList();
		
				$.ajax({
				url : mainUrl+'/'+iidx,
				type : 'delete',
				success : function(data){
					alert('성공시 : '+data);
					
				},
				complete : function(){
					
					getItemListView();
				}
			});
		
	}
	
	
	var SearchTotalList=[];
	var SearchListView=[];
	 
	// ok
	function searchItem(){
		
		//searchPageNum=1;
		var html='';
		var searchType=$('#searchType').val();
		var keyword='';
		searching=true;
		loading=true;
		
		if (searchType=='total'){
			pageNum=1;
			loading=true;
			getItemListView();
			return false;
		}
		if (searchType=='title'){
			keyword=$('#keywordBox').val();
		}
		if (searchType=='category'){
			keyword=$('#categoryBox').val();
		}
		
		alert(searchType);
		alert('"'+keyword+'"(으)로 검색합니다...');
		
		$.ajax({
			
			url : mainUrl,
			type : 'GET',
			data : {
				'searchType':searchType,
	   	         'spage':searchPageNum,
	   	     	 'count':2,
	   	         'keyword':keyword,
	   	         'istate':0
			},
			success : function(data){
				console.log('▶ 서칭 data.itemList.length : '+data.itemList.length);
				console.log(searchPageNum+'▶ searchPage load');
    			alert(searchPageNum+' 페이지 : 검색된 리스트뷰 불러오기 성공!!');
    			
    			console.log('현재  searchCheckNum: '+searchCheckNum+' 번째 검색');
    			console.log('현재  searchPageNum: '+searchPageNum);
    			console.log('현재 pageTotalCount : '+data.pageTotalCount);
    			
    			 if(searchPageNum>=data.pageTotalCount) {
    				$(window).off();
    				searchPageNum=0;
    	         } 
    			 
    			/*  if(searchCheckNum>0){
    				 searchPageNum=0;
    			 } */
    			
    			var itemTotalCount = data.itemTotalCount;
    			var currentPageNumber = data.currentPageNumber;
    			
				for(var i=0; i<data.itemList.length; i++){
					var midx = data.itemList[i].midx;
					var iidx = data.itemList[i].iidx;
					var oidx = data.itemList[i].oidx;
					var pidx = data.itemList[i].pidx;
					var title = data.itemList[i].title;
	 				var price = data.itemList[i].price;
	 				var count_m = data.itemList[i].count_m;
	 				var count_w = data.itemList[i].count_w;
	 				var regdate = moment(data.itemList[i].regdate).format('YYYY-MM-DD');
	 				var receive = moment(data.itemList[i].receive).format('YYYY-MM-DD HH:mm');
	 				var addr = data.itemList[i].addr;
	 				var location = data.itemList[i].location;
	 				var content = data.itemList[i].content;
	 				var photo = data.itemList[i].photo;
	 				var view_count = data.itemList[i].view_count;
	 				var category = data.itemList[i].category;
	 				var istate = data.itemList[i].istate;
	 				var ostate = data.itemList[i].ostate;
	 				var pstate = data.itemList[i].pstate;
					
	 				SearchTotalList.push(new MyItem(midx, iidx, oidx, pidx, title, price, count_m, count_w,
	 						regdate, receive, addr, location, content, photo,
	 						view_count, category, istate, ostate, pstate));
	    			
	    			
	    			html+='<div class="search_card">';
	    			html+='<button>';
					html+='	<ul>';
					html+='		<li>공구idx : '+iidx+'</li>';
					html+='		<li>제목 : '+title+'</li>';
					html+='		<li>가격 : '+price+'</li>';
					html+='		<li>모집인원 : '+count_m+'</li>';
					html+='		<li>등록일시 : '+regdate+'</li>';
					html+='		<li>판매처주소 : '+addr+'</li>';
					html+='		<li>사진 : '+photo+'</li>';
					html+='		<li><input type="button" value="상세보기" onclick="showDetails('+iidx+');">';
					if(state!=10){
						html+='		<input type="button" value="삭제하기" onclick="deleteItem('+iidx+');"></li>';
					}else {
						html+='		<span id="emphasis">삭제된 공구입니다.</span></li>';
					}
					html+='	</ul>';
	    			html+='</button>';
					html+='</div>';
	    			
	    		}
	    		
	    		var pageTotalCount = data.itemTotalCount/data.itemCountPerPage;
				var itemCountPerPage = data.itemCountPerPage;
				var startRow = data.startRow;
    	
				SearchListView.push(new ItemListView(itemTotalCount, currentPageNumber, itemList, pageTotalCount, itemCountPerPage, startRow));
		    	
		    	console.log('검색 결과 html :'+html);
	    			
		    	cleanItemList();
		    	
				},
				error : function(data){
					console.log(data);
					alert('검색 실패');
					
				},
		    	complete : function(){
		    		//$('#itemList').append(html);
		    		
		    		$('#searchList').append(html);
		    		searchPageNum++;
		    		searching=false;
			    	
			    	//$('#keywordBox').val('');
		    	}
			
		});
		
		
		 $(window).scroll(function() {
		      if($(window).scrollTop()+200>=$(document).height() - $(window).height()) {
		         if(!searching) {
		        	 searching=true;
		            searchItem();
	        	} 
	        } 
	    });  
		
		searchCheckNum++;
	}
	
	function itemRequest(iidx, count_w){
		
		$.ajax({
			
			url : 'order 주소',
			type : 'GET',
			data : {
				'iidx': iidx,
				'count_w': count_w
			},
			success: function(data){
				alert('성공시 : '+data);
				
			},
			error: function(data){
				alert('참여 신청 실패');
			},
			complete : function(){
				alert('참여신청 목록을 확인해주세요.');
			}
			
		});
		
	}
	
	
	// 내가 올린 공구  : ing...
	function getMySellList(){
		
		var html='';
		
		$.ajax({
			
			url: sellUrl,
			type:'GET',
			data : {
				'midx':1,
				'count':10
			},
			success : function(data){
				alert('나의 공구 불러오기 성공');
				console.log(data);
				//console.log(data);
    			
    			/* if(pageNum>data.pageTotalCount) {
    	            return;
    	         } */
    	         
    			var itemTotalCount = data.itemTotalCount;
    			var currentPageNumber = data.currentPageNumber;
    			
				for(var i=0; i<data.sellList.length; i++){
					var midx = data.sellList[i].midx;
	 				var iidx = data.sellList[i].iidx;
	 				var oidx = data.sellList[i].oidx;
	 				var pidx = data.sellList[i].pidx;
	 				var title = data.sellList[i].title;
	 				var category = data.sellList[i].category;
	 				var istate = data.sellList[i].istate;
	 				var ostate = data.sellList[i].ostate;
	 				var pstate = data.sellList[i].pstate;
	 				var ireceive = moment(data.sellList[i].ireceive).format('YYYY-MM-DD HH:mm');
					
	 				MySellTotalList.push(new MySell(midx, iidx, oidx, pidx, title, category, istate, ostate, pstate, ireceive));
	    			
	    			html+='<div class="mysell">';
	    			html+='	<button onclick="showDetails('+iidx+')" style="border:0; outline:0; background-color:white; cursor:pointer;">';
					html+='		<span>내idx : '+midx+'</span> |';
					html+='		<span>공구번호 : '+iidx+'</span> |';
					html+='		<span>제목 : '+title+'</span> |';
					html+='		<span>'+ireceive+'까지</span> |';
					if(istate==1){
						html+='		<span style="background-color:violet; color:white; font-weight:bold;">추천공구 등록중</span>';
					} else {
						html+='		<span style="background-color:black; color:white; font-weight:bold;">일반공구</span>';
						
					}
					//html+='		<span>ostate : '+ostate+'</span>';
					//html+='		<span>pstate : '+pstate+'</span>';
					// 0823추가
					// 오늘이전 + ostate-null + pstate-null (null을 3으로 치환) → 판매실패
					if((new Date(ireceive) < new Date()) && ostate==3 && pstate==3){
						html+='		<span style="background-color:red; color:white; font-weight:bold">판매실패</span>';
					 }
					// 오늘이전 또는 이후 + ostate-0 + pstate-1 → 판매완료
					if(ostate==0 && pstate==1){
						html+='		<span style="background-color:green; color:white; font-weight:bold">판매완료</span>';
					 }
					// 오늘이후 + ostate-null + pstate-null → 모집중
					if((new Date(ireceive) > new Date()) && ostate==3 && pstate==3){
						html+='		<span style="background-color:yellow; font-weight:bold">모집중</span>';
					 }
					// 오늘이후 + ostate-0 + pstate-0 → 모집완료 (오늘 이전도 체크필요!!) 
					if((new Date(ireceive) < new Date()) && ostate==0 && pstate==0){
						html+='		<span style="background-color:blue; color:white; font-weight:bold">모집완료</span>';
					 }
					html+='		<span><input type="button" value="요청보기" onclick="showRequestList('+midx+');">';
	    			html+='	</button>';
					html+='</div>';
	    		}
					html+='		<input type="button" value="닫기" onclick="closeMySell();"></span>';
				
				console.log('판매현황  sellList : '+data.sellList);
	    		
	    		var pageTotalCount = data.itemTotalCount/data.itemCountPerPage;
				var itemCountPerPage = data.itemCountPerPage;
				var startRow = data.startRow;
    	
				MySellListView.push(new SellListView(itemTotalCount, currentPageNumber, data.sellList, pageTotalCount, itemCountPerPage, startRow));
	    	pageNum++;
	    	loading=false;
	    	console.log('판매현황 : '+html);
	    	cleanSellList();
	    	document.getElementById('aside').style.display='block';
	    	$('#aside').append(html);
	    	
	    	
			},
			error: function(){
				alert('나의 공구 불러오기 성공');
			}
			
		});
		
		
	}
	
	function showRequestList(midx){
		
		$.ajax({
			
			url: sellUrl,
			data: {
				"midx": midx,
			},
			success : function(data){
				var midx = data.sellList[i].midx;
				var o_midx = data.sellList[i].o_midx;
 				var iidx = data.sellList[i].iidx;
 				var oidx = data.sellList[i].oidx;
 				var pidx = data.sellList[i].pidx;
 				var title = data.sellList[i].title;
 				var category = data.sellList[i].category;
 				var istate = data.sellList[i].istate;
 				var ostate = data.sellList[i].ostate;
 				var pstate = data.sellList[i].pstate;
 				var ireceive = moment(data.sellList[i].ireceive).format('YYYY-MM-DD HH:mm');
				
 				MySellTotalList.push(new MySell(midx, o_midx, iidx, oidx, pidx, title, category, istate, ostate, pstate, ireceive));
    			
    			html+='<div class="mysell">';
    			html+='	<button onclick="showDetails('+iidx+')" style="border:0; outline:0; background-color:white; cursor:pointer;">';
				html+='		<span>내idx : '+midx+'</span> |';
				html+='		<span>공구번호 : '+iidx+'</span> |';
				html+='		<span>제목 : '+title+'</span> |';
				html+='		<span>'+ireceive+'까지</span> |';
				if(istate==1){
					html+='		<span style="background-color:violet; color:white; font-weight:bold;">추천공구 등록중</span>';
				} else {
					html+='		<span style="background-color:black; color:white; font-weight:bold;">일반공구</span>';
					
				}
				//html+='		<span>ostate : '+ostate+'</span>';
				//html+='		<span>pstate : '+pstate+'</span>';
				// 0823추가
				// 오늘이전 + ostate-null + pstate-null (null을 3으로 치환) → 판매실패
				if((new Date(ireceive) < new Date()) && ostate==3 && pstate==3){
					html+='		<span style="background-color:red; color:white; font-weight:bold">판매실패</span>';
				 }
				// 오늘이전 또는 이후 + ostate-0 + pstate-1 → 판매완료
				if(ostate==0 && pstate==1){
					html+='		<span style="background-color:green; color:white; font-weight:bold">판매완료</span>';
				 }
				// 오늘이후 + ostate-null + pstate-null → 모집중
				if((new Date(ireceive) > new Date()) && ostate==3 && pstate==3){
					html+='		<span style="background-color:yellow; font-weight:bold">모집중</span>';
				 }
				// 오늘이후 + ostate-0 + pstate-0 → 모집완료 (오늘 이전도 체크필요!!) 
				if((new Date(ireceive) < new Date()) && ostate==0 && pstate==0){
					html+='		<span style="background-color:blue; color:white; font-weight:bold">모집완료</span>';
				 }
				html+='		<span><input type="button" value="요청보기" onclick="showRequestList('+midx+');">';
    			html+='	</button>';
				html+='</div>';
				html+='		<input type="button" value="닫기" onclick="closeMySell();"></span>';
			
			console.log('판매현황  sellList : '+data.sellList);
    		
    		var pageTotalCount = data.itemTotalCount/data.itemCountPerPage;
			var itemCountPerPage = data.itemCountPerPage;
			var startRow = data.startRow;
	
			MySellListView.push(new SellListView(itemTotalCount, currentPageNumber, data.sellList, pageTotalCount, itemCountPerPage, startRow));
    	pageNum++;
    	loading=false;
    	console.log('판매현황 : '+html);
    	cleanSellList();
    	document.getElementById('aside').style.display='block';
    	$('#aside').append(html);
			}
		});
		
	}
	
	
	
	$(document).ready(function(){
		
		var loading=false;	
		var searching=false;	
		//cleanSearchList();	
		getMidxByIidx(16);
		alert('appStart!\n공구게시판입니다.');
		getItemListView_recommend();
		getItemListView();
	   	$('#searchType').click(function(){
	   		$('#keywordBox').val('');
		});
	   	
	   	$('#searchType').mouseleave(function(){
	   		
	   		if($('#searchType').val()=='category'){
				$('div.keywordBox').css('display', 'none');
				$('div.categoryBox').css('display', 'block');
	   		} else if ($('#searchType').val()=='title') {
				$('div.categoryBox').css('display', 'none');
				$('div.keywordBox').css('display', 'block');
	   		} 
		});
	   	
	   	$('#searchType').focusout(function(){
	   		
	   		if($('#searchType').val()=='total') {
	   			pageNum=1;
				loading=true;
				getItemListView();
				$('div.categoryBox').css('display', 'none');
				$('div.keywordBox').css('display', 'none');
	   		}
	   	});
	   	
	   	
		});
	
	
</script>


</body>
</html>