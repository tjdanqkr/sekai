<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- (1) LoginWithNaverId Javscript SDK -->
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"
	charset="UTF-8"></script>


<!-- (2) LoginWithNaverId Javscript 설정 정보 및 초기화 -->
<script type="text/javascript">
	alert("ㅅ");
		var naverLogin = new naver.LoginWithNaverId(
			{
				clientId: "HICTyiQbY5EEz1krtPvC",
				callbackUrl: "http://localhost:8090/Sinseikai/cus.cus",
				isPopup: false,
				callbackHandle: true
				
				/* callback 페이지가 분리되었을 경우에 callback 페이지에서는 callback처리를 해줄수 있도록 설정합니다. */
			}
		);

		/* (3) 네아로 로그인 정보를 초기화하기 위하여 init을 호출 */
		naverLogin.init();
		alert("ㅅㅂ1");

		/* (4) Callback의 처리. 정상적으로 Callback 처리가 완료될 경우 main page로 redirect(또는 Popup close) */
		window.addEventListener('load', function () {
			naverLogin.getLoginStatus(function (status) {
				alert("ㅅㅂ2");
				if (status) {
					alert("ㅅㅂ3");
					/* (5) 필수적으로 받아야하는 프로필 정보가 있다면 callback처리 시점에 체크 */
					var email = naverLogin.user.getEmail();
					var name = naverLogin.user.getNickName();
					var profileImage = naverLogin.user.getProfileImage();
					var birthday = naverLogin.user.getBirthday();			
					var uniqId = naverLogin.user.getId();
					var age = naverLogin.user.getAge();
					
					if( email == undefined || email == null) {
						alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
						/* (5-1) 사용자 정보 재동의를 위하여 다시 네아로 동의페이지로 이동함 */
						naverLogin.reprompt();
						return;
					}
					alert(name+age);
					alert("ㅅㅂ3");
					window.location.replace("http://localhost:8090/Sinseikai/cus.cus");
				} else {
					console.log("callback 처리에 실패하였습니다.");
				}
			});
		});
		
	</script>
<title>네이버로그인</title>
</head>
<body>callback 처리중입니다. 이 페이지에서는 callback을 처리하고 바로 main으로
	redirect하기때문에 이 메시지가 보이면 안됩니다.


</body>
</html>