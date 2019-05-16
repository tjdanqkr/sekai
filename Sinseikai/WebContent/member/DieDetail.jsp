<%@page import="net.cus.db.DieBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	DieBean board = (DieBean)request.getAttribute("detailbean");
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>제목 : <%=board.getTitle() %></h3>
<h4>물품 : <%=board.getProduct()%></h4>
<h4>내용 : <%=board.getSubject()%></h4>
<h4>이메일 : <%=board.getEmail()%></h4>
<h4>폰 : <%=board.getPhone()%></h4>
<%if(board.getReple()==null){ %>
<h4>관리자 말 : 아직 답변을 못했어요</h4>
<%}else{ %>
<h4>관리자 말 : <%=board.getReple() %></h4>
<%} %>
</body>
</html>