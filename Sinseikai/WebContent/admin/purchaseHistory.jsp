<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="./css/purchaseHistory.css" />
<span>


<table >
<tr>
<td colspan="8">
<h1>판매 현황</h1>
</td>
</tr>

<tr class="chistory1">
   <td>productNumber</td>
   <td>brandName</td>
   <td>modelNumber</td>
   <td>modelName</td>
   <td>fullPrice</td>
   <td>deliveryPeriod</td>
   <td>categoryCode</td>
   <td>purchaseDate</td>
</tr>

<c:forEach var="purchaseHistoryBean" items="${purchaseHistoryBeans}">
<tr class="chistory2">
   <td>${purchaseHistoryBean.productNumber}</td>
   <td>${purchaseHistoryBean.brandName}</td>
   <td>${purchaseHistoryBean.modelNumber}</td>
   <td>${purchaseHistoryBean.modelName}</td>
   <td>${purchaseHistoryBean.fullPrice}</td>
   <td>${purchaseHistoryBean.deliveryPeriod}</td>
   <td>${purchaseHistoryBean.categoryCode}</td>
   <td>
      <fmt:formatDate value="${purchaseHistoryBean.purchaseDate}" 
      pattern="yyyy년 MM월 dd일 || HH : mm : ss"/>
   </td>
</tr>
<tr>
   <td colspan="8"></td>
</tr>
</c:forEach>
</table>
</span>