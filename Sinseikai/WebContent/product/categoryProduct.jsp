<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><%@include file="headmenu.jsp" %></div><br>


<h1><%= request.getParameter("categoryName") %></h1>
추천순|판매순|낮은가격순|
<hr>
<c:forEach items="${productBeans}" var="bean">
<div class="kann">
<img src="img/${bean.imgAddr1}" alt="기달려임마">
<span>브랜드명${bean.brandName}</span>
<span>상품명${bean.modelName}</span>
<span>상품번호${bean.modelNumber}</span>
<span>${bean.price}<!-- 이거는 취소선 해주세요 --></span>
<span>가격:${bean.price}*${bean.discountRate}</span>
<span>별점:${bean.rating}</span></div>
</c:forEach>






</body>
</html>