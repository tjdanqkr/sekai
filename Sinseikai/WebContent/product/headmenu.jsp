<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>




<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head><!-- 상단 헤더관련은 여기에 붙이세요 -->
<body onload="onLoad()">


<div><%@include file="/product/headerside.jsp" %></div><br>
<div><jsp:include page="/product/open.jsp"></jsp:include></div>
<a href="./start.jsp"><img alt="" src="./img/elLotte.png" ></a><br>
<div><%@include file="/product/main.jsp" %></div><!-- 상단 메뉴바 -->
</body>
</html>