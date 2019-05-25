<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><%@include file="headmenu.jsp" %></div><br>

<h2>${name}님의 판매등록 페이지입니다.</h2><hr>
브랜드 선택하기 :

<select name = "brando">
<c:forEach var="brando" items="${productlist}"><option value="${brando.brandName}">${brando.brandName}</option></c:forEach>
</select>
 





<div id=footer><%@include file="footer.jsp" %>  </div>
</body>
</html>