<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
pageContext.setAttribute("option1Beans",session.getAttribute("option1Beans"));
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/product_into.js"></script>

</head>
<body onload="onLoad()">
<div id="container">
<div><%@include file="headmenu.jsp" %></div><br>

<h2>주문결제</h2>
<hr>
주문상품
<hr>
<div align="left"><img src="./img/test1.png" width="200px" height="200px"><!--이미지 -->
<span>${productBean.brandName}</span>
<span>${productBean.modelNumber }</span>
<span> ${productBean.rating}%</span>
<span>${productBean.modelName}</span>
</div>
<hr>
<h2>주문고객</h2>
이름 : <input type="text" value="${productBean.modelName}">


<div></div>


</div>
</body>
</html>