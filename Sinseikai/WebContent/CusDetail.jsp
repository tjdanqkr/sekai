<%@page import="net.cus.db.cusbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	cusbean board = (cusbean)request.getAttribute("detailbean");
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>제목 : <%=board.getTitle() %></h3><br>
<h4>내용 : <%=board.getCon() %></h4>

</body>
</html>