<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="./product/kaisu.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
pageContext.setAttribute("option1Beans",request.getAttribute("option1Beans"));
%>
<script language="javascript">
function showBig(val) {
 var obj = document.getElementById("big");
  obj.src = "./img/" + val;
} 
function kessai(){
	
	
}


</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세물품정보</title>
</head>
<!-- 여기는상품상세란 -->
<body>
	<div><%@include file="/product/headmenu.jsp"%></div>
	<br>
<head>
<title></title>
<link href="css/productInto.css" rel="stylesheet">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script>
			// var sel = $("#selectbox option:selected").text(); //전체, 제목, 작성자
			$( document ).ready( function() {
				var jb;
				var jb1;
				function myFunction() {
					  document.getElementById("myP").style.visibility = "visible";
					}
				$( 'button#jbButton' ).click( function() {		
					  jb = $("select[name='option1'] option:selected").text();			
					document.getElementById("demo").innerHTML = jb;
					 jb1 = $("select[name='option2'] option:selected").text();	
					 jb1= jb1.substring(3);
					 document.getElementById("demo1").innerHTML = jb1;
				} );				
				
			} );
	
			</script>
</head>
<body>
	<div id="main">
		<div id="content">
			<h3>상품 이미지</h3>

			<img src="img/a1.jpg" width="100%" height="100%" id="big" /> <br />
			<br /> <img src="img/a1.jpg" width="15%" height="15%"
				onmouseover="showBig('a1.jpg');" /> <img src="img/a2.jpg"
				width="15%" height="15%" onmouseover="showBig('a2.jpg');" /> <img
				src="img/a3.jpg" width="15%" height="15%"
				onmouseover="showBig('a3.jpg');" /> <img src="img/a4.jpg"
				width="15%" height="15%" onmouseover="showBig('a4.jpg');" /> <img
				src="img/a5.jpg" width="15%" height="15%"
				onmouseover="showBig('a5.jpg');" /> <span
				style="float: left; margin: 0 10px 10px 0;"><br /></span>

		</div>

		<div align="right" id="sidebar">

			<h3 align="left">${productBean.brandName}</h3>

			<h2 align="left">${productBean.modelName}</h2>
			<ul>
				<fmt:parseNumber var="test"
					value="${Math.floor(100*productBean.discountRate)}%"
					integerOnly="true" />
				${test}%off


				<hr>
				<span style="font-size: 0.7em;"> *카드할인삼성카드 5%청구할인 할인 혜택 내역</span>
				<hr>
				<gg>${productBean.price}원</gg>
				<h2>
					<c:set var="no"
						value="${Math.round(productBean.price*(1-productBean.discountRate))}" />${no}원</h2>
			</ul>
		</div>

			<div id="sidebar">


			<label for="select">옵션선택</label>
			
			${optionHTML}<!-- 얘가 텍스트박스 생성 -->
			<button id="jbButton" onclick="gasu()">Click</button>
			
  			주문한 색상: 	<p id="demo"></p>
  			주문한 사이즈:	<p align="left" id="demo1"></p>
  <p  style="visibility:hidden;"id="myP" >	주문 개수:	<input  type ="text" id="su" style="width:30px;" value="1">			</p>	<br>
			  	 
    			<div>
			 <br>
			<br>
			<br>
			
			<hr>
			<span> 상품 번호 : ${productBean.modelNumber} <br>
				포인트 적립률 :${productBean.rating}% <br> 배송소요기간
				:${productBean.deliveryPeriod}일
			</span>
			</div>
			</div>
			</div>
		
	<div id="comments">
		<h3>Comments</h3>
		<p>
			<span>Visitor 1</span> <img src="img/b1.png" width="100%"
				height="100%" />
		</p>
		<p>
			<span>Visitor 2</span> 평점
		</p>
		<p>
			<span>Visitor 3</span> 추가할거있으면 추가

		</p>
	</div>
</div>
	<div id="footer">Copyright © JankoAtWarpSpeed 2009.</div>
	
	
	
	<script>
   
    ${optionJS}
    
    </script>





</body>
</html>

