<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String email = request.getParameter("email");
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신세카이 백화점</title>

<script type="text/javascript" src="./js/product_into.js"></script>

</head>
<body onload="onLoad()" >
<div id="container">

<!--  headmenu.jsp의 open.jsp를 해결하라. -->

<div></div>

<h1>안녕! 마이페이지!</h1>

</div>

</body>
</html>