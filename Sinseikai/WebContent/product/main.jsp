<%@page import="net.product.db.MenuBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
pageContext.setAttribute("majorbeans",request.getAttribute("menuBeans"));
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="./css/menubar.css" type ="text/css"/>
</head>

<body>
<div class="menubar">
<ul>

 <li><a href="#"><c:forEach items="${majorbeans}" var="list" varStatus="status">
 <c:out value = "${status.index }   " />
 </c:forEach>
 </a></li>
 <li><a href="#" id="current">Men</a>
	<ul> 
     <li><a href="#">정장,자켓,코트</a></li>
    </ul>
 </li>
 <li><a href="#" id="current">Woman</a>
	<ul>
	<li><a href="#">셔츠/블라우스</a></li>
     <li><a href="#">티셔츠</a></li>
     <li><a href="#">니트/스웨터</a></li>
     <li><a href="#">원피스</a></li>
     <li><a href="#">스커트</a></li>
     <li><a href="#">팬츠</a></li>
     <li><a href="#">아우터</a></li>
</ul>
</li>
</ul>
</div>
</body>
</html>