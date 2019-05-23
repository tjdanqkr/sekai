<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ pageContext.setAttribute("memberBean",session.getAttribute("memberBean")); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="./css/categoryProduct.css" type ="text/css"/>
</head>
<body>
<div><%@include file="headmenu.jsp" %></div><br>

<div class="cat">
<h1><%= request.getParameter("categoryName") %></h1>
추천순 | 판매순 | 낮은가격순 |
</div>
<hr>
<c:forEach items="${productBeans}" var="bean">

<div class="kann">
<table>
<tr>
<td rowspan="5"><a href="productinto.pr?productNumber=${bean.productNumber}&email=${memberBean.id}"><img width="250rem" src="img/${bean.imgAddr1}" alt="기달려임마" ></a></td>
</tr>
<tr>
<td>
${memberBean.id}
${memberBean.email}
 브랜드명 : <b>${bean.brandName}</b><br>
 상품명  : ${bean.modelName}<br>
 상품번호 :  ${bean.modelNumber}<br>
 가격 : ${bean.price}<br>
 별점 :  ${bean.rating}
</td>
</tr>
</table>
</div>
</c:forEach>






</body>
</html>