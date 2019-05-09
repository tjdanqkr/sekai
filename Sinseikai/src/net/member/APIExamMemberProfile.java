package net.member;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;

public class APIExamMemberProfile implements Action{

    public static void main(String[] args) {
        
    }

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String token = "YOUR_ACCESS_TOKEN";// 네이버 로그인 접근 토큰;
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
            	System.out.println("ss");
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
            	System.out.println("dd");
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer responsed = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                responsed.append(inputLine);
            }
            br.close();
            System.out.println(responsed.toString());
            System.out.println("qq");
        } catch (Exception e) {
            System.out.println(e);
        }
		return null;
	}
}