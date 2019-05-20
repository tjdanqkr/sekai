<%@page import="net.cus.db.DieBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="./css/DieDetail.css">
<head>
<!-- 웹 페이지 크기 및 위치 자동 고정하기 -->
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
<%
	DieBean board = (DieBean) session.getAttribute("detailbean");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="detai">
		<tr class="tp">
			<td>Title <%=board.getTitle()%></td>
			<td>Product <%=board.getProduct()%></td>
		</tr>
		<br>
		<tr class="ep">
			<td>Email <%=board.getEmail()%></td>
			<td>Phone <%=board.getPhone()%></td>
		</tr>
		<tr class="ct">
			<td colspan="2">Content</td>
		</tr>
		<tr class="ct">
			<td colspan="2"><%=board.getSubject()%></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="2" class="rp">
				<%
					if (board.getReple() == null) {
				%> 아직 답변을 못했어요 <%
					} else {
				%> 관리자 <%=board.getReple() %>
				<%} %>
			</td>
		</tr>
	</table>
</body>
</html>