<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<h1>안녕 난 판매 현황이야</h1>

<table border="1">
<tr>
	<td>productNumber</td>
	<td>brandName</td>
	<td>modelNumber</td>
	<td>modelName</td>
	<td>fullPrice</td>
	<td>deliveryPeriod</td>
	<td>categoryCode</td>
</tr>
<c:forEach var="purchaseHistoryBean" items="${purchaseHistoryBeans}">
<tr>
	<td>${purchaseHistoryBean.productNumber}</td>
	<td>${purchaseHistoryBean.brandName}</td>
	<td>${purchaseHistoryBean.modelNumber}</td>
	<td>${purchaseHistoryBean.modelName}</td>
	<td>${purchaseHistoryBean.fullPrice}</td>
	<td>${purchaseHistoryBean.deliveryPeriod}</td>
	<td>${purchaseHistoryBean.categoryCode}</td>
</tr>
<tr>
	<td colspan="7"><hr /></td>
</tr>
</c:forEach>
</table>