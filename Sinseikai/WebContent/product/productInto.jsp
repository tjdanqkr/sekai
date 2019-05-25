<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.cus.db.OpenBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="no" value="${Math.round(productBean.price*(1-productBean.discountRate))}" />

<%@ page session = "true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>




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
				 $('input[name=seller]').val('${productBean.sellerEmail}');
				var jb;
				var jb1;
				var jb2;
				var jb3;
				var temp;
				function input(){
					var input = document.getElementById("quantity").value;
					return input;
					}					
				$( 'button#jbButton' ).click( function() {
					 jb = $("select[name='option1'] option:selected").text();	
					  jb1 = $("select[name='option2'] option:selected").text();
					  jbv= $("select[name='option1'] option:selected").val();	
					  jbv1=$("select[name='option2'] option:selected");					
					  for(var i=0;i<jbv1.length;i++){
						  var vv = jbv1[i].value;						 
						  if(vv!=0){     
							jbv1=vv;
							break;
						  }
					  }
					  document.getElementById("demo").innerHTML = jb;
					  document.getElementById("demo1").innerHTML = jb1;																			
						 jb2=input();
						 jb3=input()*${no};	 
						 document.getElementById("demo").innerHTML = jb;		 
						 document.getElementById("demo1").innerHTML = jb1;			
						 document.getElementById("demo2").innerHTML = jb2;
						 sessionStorage.setItem( 'color', 'jb' );
						 sessionStorage.setItem( 'size', 'jb1' );
						 document.getElementById("nedan").innerHTML = jb3;
					
						 $('input[name=no]').val(${no});
						 $('input[name=su]').val(input());
						 $('input[name=option1]').val(jbv);
						 $('input[name=option2]').val(jbv1);
						 

						
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
			<script type="text/javascript">
			
window.onload=function(){
	var setCookie = function(name, value, exp) {
	
		  var date = new Date();
		  date.setTime(date.getTime() + exp*60*1000);
		  document.cookie = name + '=' + value + ';expires=' + date.toUTCString() + ';path=/';
		};

		setCookie("productid_url_${productBean.modelNumber}", location.href, 1);
setCookie("productid_img_${productBean.modelNumber}", "img/${productBean.imgAddr1}", 1);
setCookie("productid_name_${productBean.modelNumber}", "${productBean.modelName}", 1);
setCookie("productid_price_${productBean.modelNumber}", "${productBean.price}원", 1);

//2개 변수는 해당 화면에서 조회되는 값 - 각자에 맞게 변경

}
//productid_${productInfo.id}"  -  productid name 구분

//${productInfo.id} - 해당 제품의 ID값

//별거 없이 java에서 id값 추출하기 위한 부분이다....................

//포인트는 해당 제품의 id값~

		</script>
</head>
<body>
	<div id="main">
		<div id="content">
			<h3>상품 이미지</h3>
			  <img src="img/${productBean.imgAddr1}" width="100%" height="100%" id="big" /> <br /><br />
			  <img src="img/${productBean.imgAddr1}" width="15%" height="15%" onmouseover="showBig('${productBean.imgAddr1}');" /> 
			  <img src="img/${productBean.imgAddr2}" width="15%" height="15%" onmouseover="showBig('${productBean.imgAddr2}');" /> 
			  <img src="img/${productBean.imgAddr3}" width="15%" height="15%" onmouseover="showBig('${productBean.imgAddr3}');" /> 
			  <img src="img/${productBean.imgAddr4}" width="15%" height="15%" onmouseover="showBig('${productBean.imgAddr4}');" />
			 
			  <span style="float: left; margin: 0 10px 10px 0;"><br /></span>
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
				<h2>${no}원</h2>
			</ul>
		</div>

			<div id="sidebar">


			<label for="select">색상,사이즈 선택</label>		
			
			${optionHTML}<!-- 얘가 텍스트박스 생성 -->
			<!--<button id="jbButton" >Click</button>
			<div>
  			 주문한 색상: 	<p id="demo"></p>
  			주문한 사이즈:	<p align="left" id="demo1"></p>
  			주문 개수: -->
  			<div>
    <input name="quantity" id="quantity" style="vertical-align:middle; text-align:right" size="5" maxlength="4" value="1"/>
    	<img style="vertical-align:middle;" alt="수량 증가 감소" src="btn_cnt.gif" usemap="#map_name_quantity"/>
   	 <map id="map_name_quantity" name="map_name_quantity">
        <area href="javascript:modifyProductQuantity('quantity',1);" shape="rect" alt="수량 증가" coords="0,0,9,10"/>
        <area href="javascript:modifyProductQuantity('quantity',-1);" shape="rect" alt="수량 감소" coords="0,10,9,20"/>
    </map><button id="jbButton" >선택</button>	<span id="jaego"> </span>
			<br>
			</div>
    			<div>
			<div class="blue-box">
	<span class="tl"></span><span class="tr"></span>
	<div class="box-content">
		<h2>주문내용</h2>
		물품:<span id ="demo"></span>
		<span id ="demo1"></span><br>
		개수:<span id ="demo2"></span><br>
		가격:<span id = "nedan"> </span>
	</div>
	<span class="bl"></span><span class="br"></span>

</div>
			
			<hr>
			 

		<form id="getsu" method="post" action="./product-pay.pr?productNumber=${productBean.productNumber}&email=${memberBean.email}">		
			<input type="hidden" name = "su" >
			<input type="hidden" name = "option1">
			<input type="hidden" name = "option2">
			<input type="hidden" name = "no">
			<input type="hidden" name = "seller">
			<input type="submit"  value ="주문하기">
		</form>	
			<span> 상품 번호 : ${productBean.modelNumber} <br>
				포인트 적립률 :${productBean.rating}% <br> 배송소요기간
				:${productBean.deliveryPeriod}일
			</span>
			</div>
			</div>
			
	<div id="comments">
		<h3>Comments</h3>
		<p>
			<span>Visitor 1</span><img src="img/${productBean.imgAddr5}" width="100%" height="100%" />
		</p>
		<p>
			<span>Visitor 2</span> 상품 상제 이미지
				 <img src="img/${productBean.imgAddr5}" width="100%" height="100%" />
		</p>
		<p>
		
			<span>Visitor 3</span> 사이즈표 

		</p>
	</div>
			
	
	
	
	
	<script>
    ${optionJS}
    $('#jaego').html("남은 재고 : ");
    </script>


</div>
<a href="./cookie.jsp">쿠키보기</a>
<div id=footer> <%@include file="footer.jsp" %>  </div>
<% String su =request.getParameter("quantity") ;
request.getParameter("quantity");
session.setAttribute("quantity",su );

%>
</body>
</html>
