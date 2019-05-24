<%@page import="java.net.URLDecoder"%>
<%@page import="net.product.db.ProductBean"%>
<%@page import="net.cus.db.OpenBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
&nbsp;
<% Cookie[] cook= request.getCookies();
	if(cook!=null){
		out.println("첫 이프");
		for(int i=0;i<cook.length;i++){
			out.println("폴");
			String name= cook[i].getName();
			
			
			if(name.indexOf("pro")!=-1){
				
				out.println("막이프");
				String value = cook[i].getValue();
				String item = URLDecoder.decode(value,"UTF-8");
				out.println(name+"="+item+"<br>");
			}out.println("폴"+i);
		}
	}else{
		out.println("쿠키가 없네요");
	}
%>
쿠기 받기 
</body>
</html>