<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<% 

String kkk = request.getParameter("kkk");
String contentPage=request.getAttribute("contentPage")+"";

    if(contentPage.equals("null")){
        contentPage="cusbottom.jsp";}
    
    request.setAttribute("kkk", request.getParameter("kkk"));
   
    %>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div><jsp:include page="../product/headmenu.jsp"></jsp:include></div>
<div><jsp:include page="left.jsp"></jsp:include></div>

<div><jsp:include page="custop.jsp"></jsp:include></div>
<div><jsp:include page="../product/open.jsp"></jsp:include></div>

<% if(contentPage.equals("DieDieCenter.jsp")){%>

<div><jsp:include page="<%=contentPage %>"></jsp:include></div>
<%}else{ %>
<div><jsp:include page="custop.jsp"></jsp:include></div>
<div><jsp:include page="<%=contentPage %>"></jsp:include></div>
<%} %>
</body>
</html>