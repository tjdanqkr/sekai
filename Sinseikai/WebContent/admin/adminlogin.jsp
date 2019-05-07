<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/login.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
<form class="box" action="loginAction.ad" method="post" >
<h1>Login</h1>
<input type="text" name="id" placeholder="id">
<input type="password" name="pw" placeholder="password">
<input type="submit" value="Login" >

</form>
</body>
</html>