<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div><%@include file="headerside.jsp" %></div><br>
<img alt="" src="./elLotte.png"><br>
<div><%@include file="main.jsp" %></div>
<div><%@include file="slide.html" %></div>
<div align="center" ><h2>5월 선물 BEST</h2></div>

<ul class="tag_filter" id="menuListWrap">
		<li>
			<input type="radio" name="tagFilter" id="tag_14" tagseq="14" onclick="showGoodsListAjax('14');gaEvent('이런상품 어때요_태그', '어머니 선물_품격', '', '');">
			<label for="tag_14">#어머니 선물_품격</label> 
		</li>
		
<div><%@include file="indexslide.html" %></div>
</body>
</html>