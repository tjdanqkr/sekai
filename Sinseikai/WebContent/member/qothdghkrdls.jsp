<%@page import="java.net.URLEncoder"%>
<%@page import="net.cus.db.cusbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="net.cus.db.*" %>

<!DOCTYPE html>
<html>
<%
List<cusbean> boardList=(List)request.getAttribute("boardlist");
String title;
%>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>

<script type="text/javascript" src="./js/ajax.js"></script>
<link rel="stylesheet" href="./css/qothdghkrdls.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="information_tableanswer_areacol_type">
		<table width=50% border="0" cellpadding="0" cellspacing="0">
			<tr align="center" valign="middle" bordercolor="#333333" class="uppo" >
				<td width="30%">
					<div align="left">번호</div>
				</td>
				<td >
					<div align="center">제목</div>
				</td>

			</tr>
			<%for(int i=0; i<boardList.size();i++){
				cusbean bl=(cusbean)boardList.get(i);%>
			<tr align="center" valign="middle" bordercolor="#333333" class="bol">
				<td width="30%">
					<div align="left" ><%=i+1 %></div>
				</td>
				<td >
					<div align="left" class="iii"><a target="_blank" href="./detail.cus?title=<%=URLEncoder.encode(bl.getTitle(), "UTF-8")%>"><%=bl.getTitle()%></a></div>
				</td>

			</tr>
			<%}%>
			
		</table>
	</div>
</body>
</html>