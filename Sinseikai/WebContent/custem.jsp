<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<% 
String contentPage=request.getParameter("contentPage");
    if(contentPage==null)
        contentPage="cusbottom.jsp";
    %>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div><jsp:include page="product/headmenu.jsp"></jsp:include></div>
<div><jsp:include page="left.jsp"></jsp:include></div>
<div><jsp:include page="custop.jsp"></jsp:include></div>
<div><jsp:include page="<%=contentPage %>"></jsp:include></div>

</body>
</html>