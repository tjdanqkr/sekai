<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신세카이 백화점 - 마이페이지</title>

<style>
	td{
		text-align: center;
	}
	.header{
		background-color: skyblue;
	}
	.regist{
		
	}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

<script>
	if('${id}' == ''){
		location.href = 'login.me';
	}
</script>
</head>

<body>

<div><%@include file="/product/headmenu.jsp" %></div><br>

<h1>안녕! 마이페이지!</h1>
<h2>${name}님</h2><br />

<!-- Buyer order list -->
<h3>구매 목록</h3>
<table>
	<tr class="header">
		<td>상품 번호</td>
		<td>상품 명</td>
		<td>옵션</td>
		<td>갯수</td>
		<td>판매자</td>
		<td>상태</td>
	</tr>
<c:forEach var="buyerOrderListBean" items="${buyerOrderListBeans}" varStatus="status">
	<tr>
		<td>${buyerOrderListBean.productNumber}</td>
		<td><a href="productinto.pr?productNumber=${buyerOrderListBean.productNumber}&email=${id}">${buyerProductBeans.get(status.index).modelName}</a></td>
		<td>
			<c:forEach var="buyerOptionBean" items="${buyerOption1Beans.get(status.index)}">
				${buyerOptionBean.minorName}<br />
			</c:forEach>
		</td>
		<td>${buyerOrderListBean.amount}</td>
		<td>${buyerOrderListBean.seller}</td>
		<td>${buyerOrderListBean.status}</td>
	</tr>
	<tr>
		<td colspan="6"><hr /></td>
	</tr>
</c:forEach>
</table>
<br />

<%-- 
	status of order list
--%>
<c:set var="statusContents">결제대기,결제완료,배송준비,배송출발,배송중,배송완료</c:set>

<!-- Seller order list -->
<h3>판매 목록</h3>
<table>
	<tr class="header">
		<td>상품 번호</td>
		<td>상품 명</td>
		<td>옵션</td>
		<td>갯수</td>
		<td>구매자</td>
		<td>상태</td>
	</tr>
<c:forEach var="sellerOrderListBean" items="${sellerOrderListBeans}" varStatus="status">
	<tr>
		<td>${sellerOrderListBean.productNumber}</td>
		<td><a href="productinto.pr?productNumber=${sellerOrderListBean.productNumber}&email=${id}">${sellerProductBeans.get(status.index).modelName}</a></td>
		<td>
			<c:forEach var="sellerOptionBean" items="${sellerOption1Beans.get(status.index)}">
				${sellerOptionBean.minorName}<br />
			</c:forEach>
		</td>
		<td>${sellerOrderListBean.amount}</td>
		<td>${sellerOrderListBean.buyer}</td>
		
		<td>
			<form action="modify-order-list.pr" method="post">
				<input type="hidden" name="seller" value="${sellerOrderListBean.seller}" />
				<input type="hidden" name="orderId" value="${sellerOrderListBean.orderId}" />
				<select name="status" onchange="submit();">
					<c:forEach var="statusContent" items="${statusContents}">
						<c:choose>
							<c:when test="${statusContent == sellerOrderListBean.status}">
								<%-- Equal with DB data. --%>
								<option value="${statusContent}" selected>${statusContent}</option>
							</c:when>
							<c:otherwise>
								<%-- Not equal with DB data. --%>
								<option value="${statusContent}">${statusContent}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</form>
		</td>
	</tr>
	<tr>
		<td colspan="6"><hr /></td>
	</tr>
</c:forEach>
</table>

<h3>판매등록</h3>
<form action="product-input.pr" id="regist" method="post">
<input type="submit" value="상품 등록하러 가기" > 
</form>
<div id=footer><%@include file="/product/footer.jsp" %></div>

</body>
</html>