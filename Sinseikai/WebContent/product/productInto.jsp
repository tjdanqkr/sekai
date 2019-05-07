<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language = "javascript">
function showBig(val) {
 var obj = document.getElementById("big");
  obj.src = "./img/" + val;
} 
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세물품정보</title>
</head><!-- 여기는상품상세란 -->
<body>
<div><%@include file="/product/headmenu.jsp" %></div><br>
<%request.getAttribute("productBean"); %>
<%request.getAttribute("option1Beans"); %>
<%request.getAttribute("codexBrandBean"); %>
<head>
    <title></title>
     <link href="css/productInto.css" rel="stylesheet">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#wideView").click(function() {
                $("#content").toggleClass("wide");
                $(this).toggleClass("wide");
            });
        });
    </script>
    
</head>
<body>  
    <div id="main">
        <div id="content">
            <h3>상품 이미지</h3>
          
          <img src="img/a1.jpg" width="100%" height="100%" id="big" />
	<br /><br />
	<img src="img/a1.jpg" width="15%" height="15%" onmouseover="showBig('a1.jpg');" />
	<img src="img/a2.jpg" width="15%" height="15%" onmouseover="showBig('a2.jpg');" />
	<img src="img/a3.jpg" width="15%" height="15%" onmouseover="showBig('a3.jpg');" />
	<img src="img/a4.jpg" width="15%" height="15%" onmouseover="showBig('a4.jpg');" />
	<img src="img/a5.jpg" width="15%" height="15%" onmouseover="showBig('a5.jpg');" />
	<img src="" width="15%" height="15%" onmouseover="showBig('.jpg');" />
                <span style="float:left; margin:0 10px 10px 0;" ><br /></span>
         
        </div>
        
        <div id="sidebar">

            <h3>${productBean.brandName}</h3>
           
            <span><h2 align="center">${productBean.modelName}</h2></span>
            <ul>
            
            <li><h2>${productBean.price}원</h2></li> 
      	 	<li><h2><fmt:parseNumber var="test" value="${Math.floor(100*productBean.discountRate)}%" integerOnly="true" /> ${test}%</h2></li> 
            </ul>                               
        </div>
        <div>
        <ul>
        <li>상품 번호${productBean.modelNumber} </li>
        <li>상품 명${productBean.modelName}</li>
        <li>${productBean.rating} </li>
        <li>배송기간 ${productBean.deliveryPeriod} </li>
        </ul>
        </div>
        <div id="comments">
            <h3>Comments</h3>
            <p>
                <span>Visitor 1</span>
               	<img src="img/b1.png" width="100%" height="100%" />
            </p>
            <p>
                <span>Visitor 2</span>
                	나는설명2단
            </p>
            <p>
                <span>Visitor 3</span>
                	나는 설명3단
                
            </p>
        </div>
    </div>
    <div id="footer">Copyright © JankoAtWarpSpeed 2009.</div>
</body>
</html>

