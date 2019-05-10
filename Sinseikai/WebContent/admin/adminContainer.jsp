<%
/*
 * This page is include the left, center. 
*/
%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	String id = session.getAttribute("id") + "";
	if(!id.equals("admin")){
	//	response.sendRedirect("./");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Admin Page</title>
<style>
	body{
		display: flex;
		margin: 0px;
	}
	#leftContainer{
		height: 100vh;
		background:gray;
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