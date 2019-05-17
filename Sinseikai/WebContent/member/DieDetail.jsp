<%@page import="net.cus.db.DieBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="./css/DieDetail.css">
<head>
<%
	DieBean board = (DieBean)request.getAttribute("detailbean");
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="detai">
<tr class="tp">
<td>Title <%=board.getTitle() %></td>
<td>Product <%=board.getProduct()%></td>
</tr><br>
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
<td colspan="2" class="rp">
<%if(board.getReple()==null){ %>
아직 답변을 못했어요
<%}else{ %>
관리자   <%=board.getReple() %>
<%} %></td>
</tr>
</table>
</body>
</html>