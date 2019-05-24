<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
pageContext.setAttribute("option1Beans",session.getAttribute("option1Beans"));
pageContext.setAttribute("memberBean",session.getAttribute("memberBean"));
%>
<c:set var="no" value="${Math.round(productBean.price*(1-productBean.discountRate))}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/product_into.js"></script>

<link rel="stylesheet" href="./css/Pay.css">
</head>
<body onload="onLoad()">
<div><%@include file="headmenu.jsp" %></div><br>
<div class="sang">
<h1>주문결제 </h1>
<div>
</div>
<hr class="my-hr1">
<h2>주문상품</h2>
<hr class="my-hr2">
<div align="left" class="imgspan"><img width="350rem" src="./img/${productBean.imgAddr1}" id="gurim"><!--이미지 -->
<br><br><span class="setumei">
<h2><b>${productBean.brandName}</b></h2><br><br>
상품명 : ${productBean.modelName}<br><br>
모델번호 : ${productBean.modelNumber}<br><br>
주문갯수 : ${param.su} 개<br><br>
가격 : ${param.su*no}원<br><br>
포인트 적립률 : ${productBean.rating}%<br><br>
</span><br><br><br><br><br>

</div><!-- 컨테이너꺼 -->
<hr class= "my-hr1">
<h2>주문고객</h2>
<hr class= "my-hr2">
이름 : <input type="text" value="${memberBean.name}">
<br><br>
<hr class= "my-hr1">

<h2>배송정보</h2>
<hr class= "my-hr2">
배송지 : <input type="text" size="80" name="juso" value="${memberBean.address}"><br>
<br><br>
<hr class= "my-hr1">
<h2>할인/포인트</h2>
<hr class= "my-hr2">
적용가능한 할인 포인트가 없습니다.
<hr class= "my-hr1">
<h2>결제수단</h2>
<hr class= "my-hr2">
무통장입금<br>

은행선택  <select name="bank" id="bank" onchange="myFunction()">
 		 <option value='신한은행 예금주 : 김기찬    110-371-563730'>신한은행</option>
 		 <option value='국민은행 예금주 : 김기찬    110-371-563730' >국민은행</option>
  		<option value='농협은행 예금주 : 김기찬    110-371-563730'>농협은행</option>
 		 <option value='우리은행 예금주 : 김기찬    110-371-563730'>우리은헹</option>
 		 <option value='카카오뱅크 예금주 : 김기찬    110-371-563730'>카카오뱅크</option>
</select><br> 
<p id ="bbank"></p>
<script>
function myFunction() {
	var a =document.getElementById("bank").value;
	  document.getElementById("bbank").innerHTML = a;
	}
</script>

입급자명 <input type="text" name="donzul" value="${memberBean.name }"><br><br>

예금주 : 김기찬<br><br>

입금기한 (예정) : 3일(최종 주문일 기준, 다음날까지 미 입금 시 자동취소 됩니다)<br><br>

<div align="center">
<form id="getsu" method="post" action="./product-pay.pr?productNumber=${productBean.productNumber}&email=${memberBean.email}">
		<input type="hidden" name = "price"  value="${param.su*no}">
<input type ="button" value = "주문확정" onclick ="alert('주문이 완료되었습니다'); document.getElementById('getsu').submit()"  />
</form>	
</div>
<hr class= "my-hr2">

<h5><b>무통장입금 이용안내</b><br><br>
<b>무통장입금 이용시 주의사항</b><br><br></h5>
<div style="color: grey">
<h6>
-문자(SMS)/e-mail로 전달될 계좌번호와 입금하실 총 금액을 꼭 확인하시어 정확한 입금을 해주시기 바랍니다. 안내계좌번호와 입금예정금액이 주문내역과 일치하지 않을경우 입금확인이 지연되며, 주문일 기준으로 다음날까지 입금확인되지 않은 경우 주문이 취소됩니다.(토,일,공휴일 제외/취소전 안내 메일 발송)
입금확인 여부는 마이페이지에서 확인하실 수 있으며, 입금확인시 휴대폰 문자(SMS) 및 확인메일을 보내드립니다.<br><br>
입금시 은행에서 발생되는 송금 수수료는 고객님 부담이며, 해외은행에서는 환율등의 문제로 인터넷뱅킹/무통장 입금을 사용하실수 없습니다.<br><br><br>
소비자피해보상보험 안내<br><br>
현금 등으로 결제 시 결제금액 전액에 대해 SGI서울보증의 소비자피해보상보험서비스를 이용하실 수 있습니다.
</h6>
</div>


<div></div>
<div id=footer><%@include file="footer.jsp" %>  </div>
</div>
</body>
</html>