<%@page import="net.cus.db.cusbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	cusbean board = (cusbean) request.getAttribute("detailbean");
%>
<script>
	window.onfocus = function() {
	}
	window.onload = function() {
		window.focus(); // 현재 window 즉 익스플러러를 윈도우 최상단에 위치
		window.moveTo(0, 0); // 웹 페이지의 창 위치를 0,0 (왼쪽 최상단) 으로 고정
		window.resizeTo(1000, 800); // 웹페이지의 크기를 가로 1000 , 세로 800 으로 고정(확장 및 축소)
		window.scrollTo(0, 250); // 페이지 상단 광고를 바로 볼 수 있게 스크롤 위치를 조정
	}
</script>
<link rel="stylesheet" href="./css/cusdtail.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		제목 :
		<%=board.getTitle()%></h3>
	<h4>
		내용 :
		<%=board.getCon()%></h4>

</body>
</html>