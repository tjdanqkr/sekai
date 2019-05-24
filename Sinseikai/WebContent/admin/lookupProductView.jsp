<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/admin/lookupProduct.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="./css/lookupProduct.css" />

<table >
<tr class="chistory1">
   <td>productNumber</td>
   <td>brandName</td>
   <td>modelNumber</td>
   <td>modelName</td>
   <td>price</td>
   <td>imgAddr1</td>
   <td>deliveryPeriod</td>
   <td>categorycode</td>
</tr>
<c:forEach var="productBean" items="${productBeans}">
<tr class="chistory2">
   <td>${productBean.productNumber}</td>
   <td>${productBean.brandName}</td>
   <td>${productBean.modelNumber}</td>
   <td>${productBean.modelName}</td>
   <td>${productBean.price}</td>
   <td>${productBean.imgAddr1}</td>
   <td>${productBean.deliveryPeriod}</td>
   <td>${productBean.categorycode}</td>
</tr>
<tr>
   <td colspan="8"><hr /></td>
</tr>
</c:forEach>
</table>