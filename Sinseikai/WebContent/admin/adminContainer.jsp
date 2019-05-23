<%
/*
 * This page is include the left, center. 
*/
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id = session.getAttribute("id") + "";
	if(!id.equals("admin")){
	//	response.sendRedirect("./");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
<link rel ="stylesheet" href="./css/adminMenu.css" type ="text/css"/>
</head>
<body>
	<div id="leftContainer">
		<jsp:include page="/admin/adminMenu.jsp"></jsp:include>
	</div>
	<div id="centerContainer">
		<jsp:include page="${centerUri}"></jsp:include>
	</div>
</body>
</html>