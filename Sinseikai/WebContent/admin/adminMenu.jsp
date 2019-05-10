<%
/*
 * Admin menu (vertical view).
*/
%>

<%@page import="net.admin.db.AdminMenuBean"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="adminMenuBeans" value="${adminMenuBeans}"></c:set>
<c:forEach var="beans" items="${adminMenuBeans}">
	<h3>${beans.get(0).majorName}</h3>
	<c:forEach var="bean" items="${beans}">
		<a href="${bean.url}">${bean.name}</a><br />
	</c:forEach>
</c:forEach>
</body>
</html>