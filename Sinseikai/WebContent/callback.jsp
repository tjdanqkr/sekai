<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
  <script type="text/javascript">
  <script type="text/javascript">
  var naverLogin = new naver.LoginWithNaverId(
  		{
  			clientId: "HICTyiQbY5EEz1krtPvC",
  			callbackUrl: "http://localhost:8090/Sinseikai/product_into.jsp",
  			isPopup: false,
  			callbackHandle: false
  		}
  	);

  	naverLogin.init();
  	
  	naverLogin.getLoginStatus(function (status) {
  		if (status) {
  			var email = naverLogin.user.getEmail();
  			var name = naverLogin.user.getNickName();
  			var profileImage = naverLogin.user.getProfileImage();
  			var birthday = naverLogin.user.getBirthday();			
  			var uniqId = naverLogin.user.getId();
  			var age = naverLogin.user.getAge();
  		} else {
  			console.log("AccessToken이 올바르지 않습니다.");
  		}
  	});</script>

  </script>
    <title>네이버로그인</title>
  </head>
  <body>
  <%
    String clientId = "HICTyiQbY5EEz1krtPvC";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "tOt4k7jYW_";//애플리케이션 클라이언트 시크릿값";
    String code = request.getParameter("code");
    String state = request.getParameter("state");
    String redirectURI = URLEncoder.encode("http://localhost:8090/Sinseikai/product_into.jsp", "UTF-8");
    String apiURL;
    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
    apiURL += "client_id=" + clientId;
    apiURL += "&client_secret=" + clientSecret;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&code=" + code;
    apiURL += "&state=" + state;
    String access_token = "";
    String refresh_token = "";
    System.out.println("apiURL="+apiURL);
    try {
      URL url = new URL(apiURL);
      HttpURLConnection con = (HttpURLConnection)url.openConnection();
      con.setRequestMethod("GET");
      int responseCode = con.getResponseCode();
      BufferedReader br;
      System.out.print("responseCode="+responseCode);
      if(responseCode==200) { // 정상 호출
        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
      } else {  // 에러 발생
        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
      }
      String inputLine;
      StringBuffer res = new StringBuffer();
      while ((inputLine = br.readLine()) != null) {
        res.append(inputLine);
      }
      br.close();
      if(responseCode==200) {
        out.println(res.toString());
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    
  %>
  
  </body>
</html>