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
<style type="text/css">
table {
	width:90%;
	position:relative;
	top: 40px;
	background:white;
	font-size: 15px;
	padding: 30px;
	
}
.memberlist div{
	color: black;
}
.memberlist .soga{
	background: black;
	color: white;
}
.member .list{
	background: #ffa500;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="memberlist">
		<table  border="0" cellpadding="0" cellspacing="0" class="member">
			<tr>
				<td colspan="8" align="center" background="black" class="soga">친구들</td>
			</tr>
			<tr align="center" valign="middle"  class="list" >
				<td >
					<div align="left">Number</div>
				</td>
				<td >
					<div align="left">title</div>
				</td>
				<td >
					<div align="left">id</div>
				</td>
				<td >
					<div align="left">email</div>
				</td>
				<td >
					<div align="left">phone</div>
				</td>
				<td >
					<div align="left">subject</div>
				</td>
				<td >
					<div align="left">product</div>
				</td>
				<td >
					<div align="left">reple</div>
				</td>

			</tr>
			<%for(int i=0; i<boardList.size();i++){
				DieBean dl=(DieBean)boardList.get(i);%>
			<tr align="center" valign="middle" bordercolor="#333333" class="bol">
				<td >
					<div class="o" align="left" ><%=i+1 %></div>
				</td>
				<td >
					<div align="left" class="iii"><%=dl.getTitle()%></div>
				</td>
				<td >
					<div align="left" class="iii"><%=dl.getId()%></div>
				</td>
				<td >
					<div align="left" class="iii"><%=dl.getEmail()%></div>
				</td>
				<td >
					<div align="left" class="iii"><%=dl.getPhone()%></div>
				</td>
				<td >
					<div align="left" class="iii"><%=dl.getSubject()%></div>
				</td>
				<td >
					<div align="left" class="iii"><%=dl.getProduct()%></div>
				</td>
				<td >
					<a target="_blank" href="./member-qan-reple.ad?title=<%=URLEncoder.encode(dl.getTitle(), "UTF-8")%>&email=<%=dl.getEmail() %>&id=<%=dl.getId() %>" align="left" class="iii"><%=dl.getReple()%></a>
				</td>
			</tr>
			<%}%>
			</table>
</body>
</html>