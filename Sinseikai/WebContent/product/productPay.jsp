<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String name= request.getParameter("name"); 
pageContext.setAttribute("option1Beans",session.getAttribute("option1Beans"));
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/product_into.js"></script>
<style type="text/css">
.my-hr1 {
    border: 0;
    height: 2px;
    background: #111;
    }
.my-hr2{border: 0;
    height: 1px;
    background: #E6E6E6;}    
#sang{
height:10%;
}
#imgdiv{
margin:auto;
width:30%;
height:10%;
float:left;
}  
#setumei{
margin:auto;
width:60%;
height:10%;
float:left;
}  
  </style>
</head>
<body onload="onLoad()">
<div id="sang">
<div><%@include file="headmenu.jsp" %></div><br>

<h1>주문결제</h1>
<hr class="my-hr1">
<h2>주문상품</h2>
<hr class="my-hr2">
<div align="left" class="imgdiv"><img src="./img/test1.png" width="200px" height="200px"><!--이미지 -->
<div class="setumei">
<span>${productBean.brandName}</span>
<span>${productBean.modelNumber }</span>
<span> ${productBean.rating}%</span>
<span>${productBean.modelName}</span>
</div>
</div><!-- 컨테이너꺼 -->
<hr class= "my-hr1">
<h2>주문고객</h2>
<hr class= "my-hr2">
이름 : <input type="text" value="<%=name%>">
<br><br>
<hr class= "my-hr1">

<h2>배송정보</h2>
<hr class= "my-hr2">
배송지 : <input type="text" value="<%=name%>">
<br><br>
<hr class= "my-hr1">

<div></div>


</div>
</body>
</html>