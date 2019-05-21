<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>상품 검색</h1>
<form action="lookupProductSearch.pr">
	검색 <input type="text" name="keyword" />
	<input type="submit" value="검색" />
</form>

<hr />

<table border="1">
<tr>
	<td>modelName</td>
	<td>price</td>
	<td>categorycode</td>
</tr>
<c:forEach var="productBean" items="${productBeans}">
<tr>
	<td>${productBean.modelName}</td>
	<td>${productBean.price}</td>
	<td>${productBean.categorycode}</td>
</tr>
<tr>
	<td colspan="3"><hr /></td>
</tr>
</c:forEach>
</table>
