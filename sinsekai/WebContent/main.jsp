<%@page import="net.product.db.MenuBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String result = "";

	List<MenuBean> beans = (List<MenuBean>)request.getAttribute("menuBeans");
	System.out.println("be : " +  beans.size());
	for(int i = 0; i < beans.size(); i++){
		for(int j=0;j<beans.size();j++){
			
		}
		result += "<h1>" + beans.get(i).getMajorName() + "</h1><h2>" + beans.get(i).getMinorName() + "</h2><h3>" + 
				
				beans.get(i).getCategoryName() + "</h3>";
	}
	
	pageContext.setAttribute("result", result);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="menubar.css" type ="text/css"/>
</head>

<body>
<div class="menubar">
<ul>

 <li><a href="">Home</a></li>
 <li><a href="" id="current">${result}</a>
	<ul> 
     <li><a href="">정장,자켓,코트</a></li>
    </ul>
 </li>
 <li><a href="#" id="current">Woman</a>
	<ul>
	<li><a href="#">셔츠/블라우스</a></li>
   
</ul>
</li>
</ul>
</div>
</body>
</html>