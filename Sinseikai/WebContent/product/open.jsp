<%@page import="java.net.URLDecoder"%>
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

				<li class="recently"><a href="javascript:void(0);"
					onclick="defaultSet()"> <span>최근 본 쇼핑</span>
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
					
					<ul id="area_recent_shopping_infomation">
						<% Cookie[] cook= request.getCookies();
	if(cook!=null){
		
		for(int i=0;i<cook.length;i++){
			
			String url= "";
			String name= cook[i].getName();
			if(name.indexOf("productid_url_")!=-1){
				
				String value = cook[i].getValue();
				String item = URLDecoder.decode(value,"UTF-8");
				url=item;
				
			}
			if(name.indexOf("productid_img_")!=-1){
				out.println("<li class='item'>"+i);
				out.println("<div class='figure'>");
				out.println("<p class='photo'>");
				String value = cook[i].getValue();
				String item = URLDecoder.decode(value,"UTF-8");
				out.println("<a href='"+url+"'><img src='"+item+"'></a></p></div>");
			}
			
			if(name.indexOf("productid_name_")!=-1){
				out.println("<a href='"+url+"' class='info'>");
				String value = cook[i].getValue();
				String item = URLDecoder.decode(value,"UTF-8");
				out.println("<p class='title'>"+item+"</p>");
			}if(name.indexOf("productid_price_")!=-1){
				
				String value = cook[i].getValue();
				String item = URLDecoder.decode(value,"UTF-8");
				out.println("<p class='price'>"+item+"</p></a></li>");
			}
		}
	}else{
		out.println("<li class='item'>쿠키가 없네요</li>");
	}
%>
					</ul>
				</div>
			</div>
		</div>
	</div>

</body>
</html>