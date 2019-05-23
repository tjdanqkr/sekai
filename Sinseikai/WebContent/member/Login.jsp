<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<!DOCTYPE html>
<html>
<head>

  <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>

<link rel="stylesheet" href="./css/login.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
<form class="box" action="loginAction.me" method="post" >

<h1>Login</h1>

<input type="text" name="email" placeholder="id">
<input type="password" name="pw" placeholder="password">
<input type="submit" value="Login" >
<button formaction="join.me">Join</button>
<!-- 네이버아이디로로그인 버튼 노출 영역 -->
<div id="naverIdLogin"></div>
<!-- //네이버아이디로로그인 버튼 노출 영역 -->

<!-- 네이버아디디로로그인 초기화 Script -->
<script type="text/javascript">
<<<<<<< HEAD
   var naverLogin = new naver.LoginWithNaverId(
      {
         clientId: "HICTyiQbY5EEz1krtPvC",
         callbackUrl: "http://localhost:8090/Sinseikai/member/callback.jsp",
         isPopup: false, /* 팝업을 통한 연동처리 여부 */
         loginButton: {color: "black", type: 3, height: 60} /* 로그인 버튼의 타입을 지정 */
      }
   );
   
   /* 설정정보를 초기화하고 연동을 준비 */
   naverLogin.init();
   
=======
	var naverLogin = new naver.LoginWithNaverId(
		{
			clientId: "HICTyiQbY5EEz1krtPvC",
			callbackUrl: "http://localhost:8090/Sinseikai/member/callback.jsp",
			isPopup: false, /* 팝업을 통한 연동처리 여부 */
			loginButton: {color: "black", type: 3, height: 60} /* 로그인 버튼의 타입을 지정 */
		}
	);
	
	/* 설정정보를 초기화하고 연동을 준비 */
	naverLogin.init();
	
>>>>>>> parent of 29805cb... Revert "d"
</script>

</form>
</body>
</html>