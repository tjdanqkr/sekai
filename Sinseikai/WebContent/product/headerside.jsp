<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel ="stylesheet" href="./css/side.css" type ="text/css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul class="util_list">
<% if(session.getAttribute("name")!=null){ %>
							<li class="login"><a href="logout.me"><%=session.getAttribute("name") %>님 로그아웃</a></li>
							<li class="login"><a href="mypage.me">마이페이지</a></li>
						<%}else {%>
							<li class="login"><a href="login.me">로그인</a></li><li class="join"><a href="join.me">회원가입</a></li>
						<%} %>
						
						
						
						
						<li class="customer"><a href="cus.cus">고객센터</a></li>
						
						<li class="customer"><a href="https://campaign.ellotte.com/campaign-fo/event/main" onClick="gaEventCommon('PC_공통_Header', '이벤트', '이벤트', '', '');">이벤트</a></li>
						
						<li class="customer"><a href="https://campaign.ellotte.com/campaign-fo/event/attendanceEvent" onClick="gaEventCommon('PC_공통_Header', '출석체크', '출석체크', '', '');">출석체크</a></li>
					</ul>
</body>
</html>