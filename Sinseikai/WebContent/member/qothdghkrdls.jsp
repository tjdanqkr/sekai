<%@page import="net.cus.db.cusbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="net.cus.db.*" %>

<!DOCTYPE html>
<html>
<%
List<cusbean> boardList=(List<cusbean>)request.getAttribute("boardlist");
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
			<tr align="center" valign="middle" bordercolor="#333333">
				<td style="font-family: Tahoma; font-size: 20pt;" width="30%"
					height="26">
					<div align="center">번호</div>
				</td>
				<td style="font-family: Tahoma; font-size: 20pt;" width="50%">
					<div align="center">제목</div>
				</td>

			</tr>
			<%for(int i=0; i<boardList.size();i++){
				cusbean bl=(cusbean)boardList.get(i);%>
			<tr align="center" valign="middle" bordercolor="#333333">
				<td >
					<div align="center"><%=i+1 %></div>
				</td>
				<td >
					<div align="center" class="iii"><a target="_blank" href="http://localhost:8090/Sinseikai/detail.cus?title=<%=bl.getTitle()%>"><%=bl.getTitle()%></a></div>
				</td>

			</tr>
			<%}%>
			
		</table>
	</div>
</body>
</html>