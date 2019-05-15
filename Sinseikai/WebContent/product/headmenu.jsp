<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String recent=request.getParameter("recent");
if (recent==null){
	recent = "recentshop.jsp";
}%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head><!-- 상단 헤더관련은 여기에 붙이세요 -->
<body>
<div><%@include file="headerside.jsp" %></div><br>
<div><jsp:include page="<%=recent%>"></jsp:include></div><br>
<a href="./start.jsp"><img alt="" src="./img/elLotte.png" ></a><br>
<div><%@include file="main.jsp" %></div><!-- 상단 메뉴바 -->
</body>
</html>