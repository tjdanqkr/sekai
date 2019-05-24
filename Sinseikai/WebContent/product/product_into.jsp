<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
	String name = request.getParameter("name");
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신세카이 백화점</title>

<script type="text/javascript" src="./js/product_into.js"></script>

</head>
<body onload="onLoad()" >
<div id="container">

<div><%@include file="headmenu.jsp" %></div><br>
<div><%@include file="slide.html" %></div><!-- 이벤트 슬라이드 -->
<div align="center"  ><h1 >5월 선물 BEST</h1></div>	
<div><%@include file="index.jsp"  %></div><!--이미지슬라이드 타일형  -->
<div><%@include file="indexslide.html" %></div><!--이미지 슬라이드 창형  -->
<a href="categoryProduct.pr">ㄱㄱ</a>
<div id=footer><%@include file="footer.jsp" %>  </div>
<div></div>

	<%=name %>


</div>

</body>
</html>