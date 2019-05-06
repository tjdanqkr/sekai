<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<!DOCTYPE html>
<html>
<head>
 <%
    String clientId = "HICTyiQbY5EEz1krtPvC";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http://localhost:8090/Sinseikai/product_into.jsp", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 %>
<link rel="stylesheet" href="css/login.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
<form class="box" action="loginAction.me" method="post" >

<h1>Login</h1>

<input type="text" name="email" placeholder="id">
<input type="password" name="pw" placeholder="password">
<input type="submit" value="Login" >
<a href="<%=apiURL%>"><img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a><br>
<button formaction="join.me">Join</button>
</form>
</body>
</html>