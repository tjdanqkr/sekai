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
<link rel ="stylesheet" href="./css/adminMenu.css" type ="text/css"/>
<div>
<h1><a href="admin-overview.ad">Overview</a></h1><!-- Overview -->

<c:set var="adminMenuBeans" value="${adminMenuBeans}"></c:set>
<c:forEach var="beans" items="${adminMenuBeans}">
	<h3>${beans.get(0).majorName}</h3>
	<c:forEach var="bean" items="${beans}">
		<p><a href="${bean.url}">${bean.name}</a></p>
	</c:forEach>
</c:forEach>

<script>
	var adminMenuBeans = '${adminMenuBeans}';
	if(adminMenuBeans == ''){
		alert('잘못된 경로로 접근됨');
		location.href = 'admin.ad';
	}
</script>
</div>