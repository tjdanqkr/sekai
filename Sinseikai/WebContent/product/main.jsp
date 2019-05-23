<%@page import="net.product.db.MenuBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="./css/menubar.css" type ="text/css"/>
</head>

<body>
<div class="menubar">
<ul>

 <c:forEach var="minorBeans" items="${menuBeans}">
 	<li>
	 	<a href="#" id="current">${minorBeans.get(0).get(0).majorName}</a>
	 	<ul><li>
	 		<c:forEach var="categoryBeans" items="${minorBeans}">
				<li><b>${categoryBeans.get(0).minorName}</b><li>
					<c:forEach var="bean" items="${categoryBeans}">
						<li><a href="category-product.pr?categoryCode=${bean.categoryCode}&categoryName=${bean.categoryName}">${bean.categoryName}</a></li>
					</c:forEach>
	 		</c:forEach>
	 	</li></ul>
 	</li>
 </c:forEach>
</ul>
</div>
</body>
</html>