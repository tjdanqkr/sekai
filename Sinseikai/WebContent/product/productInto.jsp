
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.cus.db.OpenBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String cp= request.getContextPath();
	request.setCharacterEncoding("UTF-8");
	Cookie c= new Cookie("productname",URLEncoder.encode(request.getParameter("productBean.brandName")+" "+ request.getParameter("productBean.modelName") ,"utf-8"));
	Cookie c2= new Cookie("img",URLEncoder.encode("img/a1.jpg" ,"utf-8"));
%>
<%@ page session = "true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

function checkCookie() {
    var itemID = getCookie("itemID");
	var thisItem='img/a1.jpg:${productBean.brandName}+${productBean.modelName}:${productBean.price}원';   // 제품 아이디와 이미지 이름을 저장  2차원 배열처럼 쓸려고 짱구를 굴림...  json 형태로 저장도 가능할텐데.... 그건 취향대로 
	if (thisItem){
		if (itemID != "" && itemID != null) {
			if (itemID.indexOf(thisItem) ==-1 ){ //값이 없으면 
					setCookie("itemID",thisItem+"&"+itemID,1);
			 }
		} else {
			if (itemID == "" || itemID == null) {
				setCookie("itemID",thisItem+"&",1);
			}
		}
	}
}
checkCookie();
</script>

<script language="javascript">
function showBig(val) {
 var obj = document.getElementById("big");
  obj.src = "./img/" + val;
} 


</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세물품정보</title>
</head>
<!-- 여기는상품상세란 -->

	<div><%@include file="/product/headmenu.jsp"%></div>
	<br>


<link href="css/productInto.css" rel="stylesheet">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script>
			// var sel = $("#selectbox option:selected").text(); //전체, 제목, 작성자
			$( document ).ready( function() {
				var jb;
				var jb1;
				var jb2;
				var temp;
				function input(){
					var input = document.getElementById("quantity").value;
					return input;
					}
					
				$( 'button#jbButton' ).click( function() {		
					  jb = $("select[name='option1'] option:selected").text();			
					document.getElementById("demo").innerHTML = jb;
					 jb1 = $("select[name='option2'] option:selected").text();	
					 jb1= jb1.substring(3);
					 document.getElementById("demo1").innerHTML = jb1;
								
				$( 'button#jbButton2' ).click( function() {		
						
						 jb2=input();
						 document.getElementById("demo4").innerHTML = jb;		 
						 document.getElementById("demo5").innerHTML = jb1;
						 document.getElementById("demo").innerHTML = " ";		 
						 document.getElementById("demo1").innerHTML = " ";
						 document.getElementById("demo6").innerHTML = jb2;
						 
						 sessionStorage.setItem( 'color', 'jb' );
						 sessionStorage.setItem( 'size', 'jb1' );

				} );			
				} );
				
			} );
			 function modifyProductQuantity(id, quantity){
			        
		         if(isNaN($("#"+id).val())){
		              alert( '숫자만 입력가능 합니다.' );
		              $("#"+id).focus();
		              $("#"+id).val(0);
		              return;
		         }			        
		         //var v = parseFloat($("#"+id).val())+parseFloat(quantity);    
		         //$("#"+id).val(Math.round(v*10)/10);			         
		         var q = parseInt($("#"+id).val())+parseInt(quantity);    
		         $("#"+id).val(q);
		    };
		   

		   
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


			<label for="select">색상,사이즈 선택</label>			
			${optionHTML}<!-- 얘가 텍스트박스 생성 -->
			<button id="jbButton" >Click</button>
			<div>
  			주문한 색상: 	<p id="demo"></p>
  			주문한 사이즈:	<p align="left" id="demo1"></p>
  			주문 개수:
    <input name="quantity" id="quantity" style="vertical-align:middle; text-align:right" size="5" maxlength="4" value="1"/>
    <img style="vertical-align:middle;" alt="수량 증가 감소" src="btn_cnt.gif" usemap="#map_name_quantity"/>
    <map id="map_name_quantity" name="map_name_quantity">
        <area href="javascript:modifyProductQuantity('quantity',1);" shape="rect" alt="수량 증가" coords="0,0,9,10"/>
        <area href="javascript:modifyProductQuantity('quantity',-1);" shape="rect" alt="수량 감소" coords="0,10,9,20"/>
    </map>
			<br>
			</div>
    			<div>
			<button id="jbButton2" >추가하기</button>
	
			<div class="blue-box">
	<span class="tl"></span><span class="tr"></span>
	<div class="box-content">
		<h2>제목</h2>
		<p id ="demo4"></p>
		<p id ="demo5"></p>
		<p id ="demo6"></p>
	</div>
	<span class="bl"></span><span class="br"></span>

</div>
	
			
	
			<hr>
			<a href="./productPay.pr">주문하기</a>
			<span> 상품 번호 : ${productBean.modelNumber} <br>
				포인트 적립률 :${productBean.rating}% <br> 배송소요기간
				:${productBean.deliveryPeriod}일
			</span>
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

	
	
	
	
	<script>
   
    ${optionJS}
    
    </script>


</div>
<div id=footer> <%@include file="footer.jsp" %>  </div>

</body>
</html>

