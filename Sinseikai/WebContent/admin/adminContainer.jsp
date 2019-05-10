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
<style>
	body{
		display: flex;
		margin: 0px;
	}
	#leftContainer{
		flex-grow: 1;
		height: 100vh;
		background:gray;
	}
	#centerContainer{
		flex-grow: 6;
	}
</style>
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