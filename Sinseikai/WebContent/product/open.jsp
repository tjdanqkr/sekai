<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="./css/open.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<%
 String cp = request.getContextPath();
 request.setCharacterEncoding("UTF-8");
 Cookie [] ck= request.getCookies();
 
%>
<script>
function defaultSet() {
	
	var recently = document.getElementsByClassName("recently");
	recently[0].addEventListener("click", changeMenu());
	document.getElementsByClassName("sky_cont")[0].addEventListener("click",changeMenu());

}
function changeMenu(){
	var container = document.getElementsByClassName("skyscraper")[0];
	var container1 = document.getElementsByClassName("skyscraper open")[0];
	if(container.getAttribute("class") == "skyscraper") {
		
		container.setAttribute("class", "skyscraper open");
		
	}else if(container1.getAttribute("class") == "skyscraper open") {
		container1.setAttribute("class", "skyscraper");
	}
	return 0;
}
function count(){
	
	var container = document.getElementById("count")[0].innerHTML = Count();
}
</script>
</head>
<body>
	<div class="skyscraper">
		<div class="sky_bnr">
			<ul>

				<li class="recently"><a href="javascript:void(0);" onclick="defaultSet()">
						<span>최근 본 쇼핑</span>
						<p class="recent_shopping_infomation_count" id="count"></p>
				</a></li>

				<li class="gotop"><a href="#top">TOP</a></li>
			</ul>
		</div>
		<div class="sky_cont">
			<div class="sky_wrap recently_wrap">
				<h2>
					최근 본 쇼핑정보 <span class="counter recent_shopping_infomation_count">0</span>
				</h2>
				<p class="close">
					<button type="button">
						<span class="ico_closer"><span class="a11y_sr-only">닫기</span></span>
					</button>
				</p>
				
				<div class="list nodata" style="display: none;"

					id="recent_shopping_infomation_none">최근 본 쇼핑정보가 없습니다.</div>
				
				<ul>
				
				<li></li>
				
				</ul>
				

				<div class="list">
					<p class="clear_items">
						<button type="button" id="remove-recent_shopping_infomation">전체
							삭제</button>
					</p>
					<template id="recent_shopping_infomation_goods_tmpl">
					<li class="item">
						<div class="figure">
							<p class="photo">
								<a href="#"><img src="" alt="" /></a>
							</p>
						</div> <a href="#" class="info">
							<p class="seller"></p>
							<p class="title"></p>
							<p class="price"></p>
					</a>
						<div class="favorite">
							<button type="button" role="checkbox" aria-checked="false"
								class="manual_fn">
								<span class="ico_favorite"><span class="a11y_sr-only">찜하기</span></span>
							</button>
						</div>
					</li>
					</template>
					<template id="recent_shopping_infomation_category_tmpl">
					<li class="item">
						<div class="figure">
							<p class="category">
								<a href="javascript:void(0);">카테고리</a>
							</p>
						</div> <a href="#" class="info"></a>
					</li>
					</template>
					<template id="recent_shopping_infomation_search_tmpl">
					<li class="item">
						<div class="figure">
							<p class="search">
								<a href="javascript:void(0);">검색</a>
							</p>
						</div> <a href="#" class="info"></a>
					</li>
					</template>
					<ul id="area_recent_shopping_infomation">
					</ul>
				</div>
			</div>
		</div>
	</div>
	 <script>

	//

	// recent item    

	 var Cpage;   // 현재 페이지 

	var pagingSize = 4;   // 원하는 페이지 사이즈로 조정하세용 

	function chkRecent(a){

	var itemID = getCookie("itemID");

	$("#right_zzim ul").html('');    // 일단 Ul 내용 지우기... 

	if(itemID){

		var totcount = itemID.split('&').length-1;   //

		var totpage = Math.ceil(totcount / pagingSize) *1;

		

		Cpage = (totpage >= a )? a:1;

		Cpage = (Cpage <1)? totpage:Cpage;

		

		var start = (Cpage-1) * pagingSize;    

	

		for (i = start ; i <= start+(pagingSize-1) ;i++){

		var  thisItem = itemID.split('&')[i];

			if(thisItem){

				var itemId = thisItem.split(':')[0];

				var itemImg = thisItem.split(':')[1];
				var itemPrice = thisItem.split(':')[2];
				

			$("#right_zzim ul").append('<li><a href="/_detail.php?id='+itemId+'" target="_top"><img src="http://www.xxx.com/images/s'+itemImg+'"  width="75" border=1></a><div class="detail"><a href="javascript:removeRecentItem(\''+thisItem+'\')" class="btn_delete">삭제</a></div></li>')

			}

		}

		

		$("#paging").show();

	}else{

		$("#right_zzim ul").append('<p class="noData">최근 본 상품이<br> 없습니다.</p>');

		$("#paging").hide();$("#recentCnt").text('');

	}

	

	

	updateRecentPage(totcount, Cpage);

	

}

chkRecent(1);



	function removeRecentItem(itemname){

		var itemID = getCookie("itemID");

		itemID = itemID.replace(itemname+"&","");			

		setCookie("itemID",itemID,1);

		chkRecent(Cpage);

	}





	function updateRecentPage(totcount,Cpage){  //  

	

		$("#recentCnt").text(totcount);  //

		

		$("#totalPageCount").text("/"+Math.ceil((totcount / pagingSize) *1)); 

		if(Math.ceil((totcount / pagingSize) *1) < Cpage){

		$("#currentPage").text(Math.ceil((totcount / pagingSize) *1));

		}else{

		$("#currentPage").text(Cpage);  //

		}

	}



	$(".btn_next").on('click',function(){

	chkRecent(Cpage + 1);

	 

	});

	

	$(".btn_prev").on('click',function(){

	chkRecent(Cpage - 1);

	});
	 </script>	
</body>
</html>