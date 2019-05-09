<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

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
 <div id="naver_id_login"></div>
 <script type="text/javascript">
  	var naver_id_login = new naver_id_login("HICTyiQbY5EEz1krtPvC", "http://localhost:8090/Sinseikai/callback.jsp");
  	var state = naver_id_login.getUniqState();
  	naver_id_login.setButton("white", 2,40);
  	naver_id_login.setDomain("http://localhost:8090/Sinseikai/callback.jsp");
  	naver_id_login.setState(state);
  	naver_id_login.setPopup();
  	naver_id_login.init_naver_id_login();
  </script>
<button formaction="join.me" >Join</button>
</form>
</body>
</html>