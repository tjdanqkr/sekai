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
%>
<style type="text/css">
table {
	padding-top: 50px;

	font-size: 15px;
}
div{
 color: red;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="memberlist">
		<table width=70% border="0" cellpadding="0" cellspacing="0">
			<tr align="center" valign="middle" bordercolor="#333333" class="list" >
				<td width="10%">
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
				<td width="30%">
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
			</div>

</body>
</html>