<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String name= request.getParameter("name"); %>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신세카이 백화점</title>
</head>
<body>

<div><%@include file="headmenu.jsp" %></div><br>
<div><%@include file="slide.html" %></div><!-- 이벤트 슬라이드 -->
<div align="center" ><h2>5월 선물 BEST</h2></div>	
<div><%@include file="index.jsp"  %></div><!--이미지슬라이드 타일형  -->
<div><%@include file="indexslide.html" %></div><!--이미지 슬라이드 창형  -->
<a href="categoryProduct.pr">ㄱㄱ</a>
<div></div>

	<%=name %>



</body>
</html>