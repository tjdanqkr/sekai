<%@page import="net.member.db.NaverBean"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="net.member.db.MemberBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
List<MemberBean> memberlist =(List)request.getAttribute("memberlist");
List<NaverBean> naverlist =(List)request.getAttribute("naverlist");
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
.naver .list{
	background: #98fb98;
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
					<div align="left">Email</div>
				</td>
				<td >
					<div align="left">Pw</div>
				</td>
				<td >
					<div align="left">Name</div>
				</td>
				<td >
					<div align="left">Num1</div>
				</td>
				<td >
					<div align="left">Age</div>
				</td>
				<td >
					<div align="left">Phone</div>
				</td>
				<td >
					<div align="left">Address</div>
				</td>

			</tr>
			<%for(int i=0; i<memberlist.size();i++){
				MemberBean ml=(MemberBean)memberlist.get(i);%>
			<tr align="center" valign="middle" bordercolor="#333333" class="bol">
				<td >
					<div class="o" align="left" ><%=i+1 %></div>
				</td>
				<td >
					<div align="left" class="iii"><%=ml.getEmail()%></div>
				</td>
				<td >
					<div align="left" class="iii"><%=ml.getPw()%></div>
				</td>
				<td >
					<div align="left" class="iii"><%=ml.getName()%></div>
				</td>
				<td >
					<div align="left" class="iii"><%=ml.getNum1()%></div>
				</td>
				<td >
					<div align="left" class="iii"><%=ml.getAge()%></div>
				</td>
				<td >
					<div align="left" class="iii"><%=ml.getPhone()%></div>
				</td>
				<td >
					<div align="left" class="iii"><%=ml.getAddress()%></div>
				</td>
			</tr>
			<%}%>
			</table>
			
			
			<table  border="0" cellpadding="0" cellspacing="0" class="naver">
			<tr>
				<td colspan="8" align="center" background="black" class="soga">네이버 친구들</td>
			</tr>
			<tr align="center" valign="middle"  class="list" >
				<td >
					<div align="left">Number</div>
				</td>
				<td >
					<div align="left">Email</div>
				</td>
				<td >
					<div align="left">Name</div>
				</td>
				<td >
					<div align="left">Age</div>
				</td>
				<td >
					<div align="left">Phone</div>
				</td>

			</tr>
			<%for(int i=0; i<naverlist.size();i++){
				NaverBean nl=(NaverBean)naverlist.get(i);%>
			<tr align="center" valign="middle" bordercolor="#333333" class="bol">
				<td >
					<div class="o" align="left" ><%=i+1 %></div>
				</td>
				<td >
					<div align="left" class="iii"><%=nl.getEmail()%></div>
				</td>
				
				<td >
					<div align="left" class="iii"><%=nl.getName()%></div>
				</td>
				<td >
					<div align="left" class="iii"><%=nl.getPhone()%></div>
				</td>
				<td >
					<div align="left" class="iii"><%=nl.getAge()%></div>
				</td>
				
				
			</tr>
			<%}%>
			</table>
			
			
			</div>

</body>
</html>