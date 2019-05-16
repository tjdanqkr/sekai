<%@page import="java.net.URLEncoder"%>
<%@page import="net.cus.db.DieBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
List<DieBean> boardList=(List)request.getAttribute("boardlist");
%>
<link rel="stylesheet" href="./css/qothdghkrdls.css">
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
				DieBean bl=(DieBean)boardList.get(i);%>
			<tr align="center" valign="middle" bordercolor="#333333" class="bol">
				<td width="30%">
					<div align="left" ><%=i+1 %></div>
				</td>
				<td >
					<div align="left" class="iii"><a target="_blank" href="./detaildie.cus?title=<%=URLEncoder.encode(bl.getTitle(), "UTF-8")%>"><%=bl.getTitle()%></a></div>
				</td>

			</tr>
			<%}%>
			</table>
			</div>

</body>
</html>