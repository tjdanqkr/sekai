<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 

       String token = "AAAANVAQwKavfATb8EPPCcTBJqJKklO6d5aIztTicVtfkcxPdsQdMNTVkTpjXmuetOJYZ_K9jMqGz0sBb8GNGXp8LKg";// 네이버 로그인 접근 토큰; 여기에 복사한 토큰값을 넣어줍니다.
        String header = "Bearer " + token; // Bearer 다음에 공백 추가
       try {
            String apiURL = "https://openapi.naver.com/v1/nid/me";
          URL url = new URL(apiURL);
          HttpURLConnection con = (HttpURLConnection)url.openConnection();
           con.setRequestMethod("GET");
          con.setRequestProperty("Authorization", header);
            int responseCode = con.getResponseCode();
            BufferedReader br;
           if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
               br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }

%>
</body>
</html>