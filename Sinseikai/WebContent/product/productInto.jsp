<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
pageContext.setAttribute("option1Bans",request.getAttribute("option1Beans"));
%>
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

<head>
    <title></title>
     <link href="css/productInto.css" rel="stylesheet">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
    <script type="text/javascript">
    function selectmenu() {
        var x = document.getElementById("option1").value;
        var y = document.getElementById("option2").value;      
        document.getElementById("demo").innerHTML = "You selected: " + x + y;     
    }
    function checkmenu() {
    	var x = document.getElementById("option1").value;
        var y = document.getElementById("option2").value;
        var z = false;
        if(x!="색상" && y!="사이즈"){  
        	z=true;  }else{
        		z=false;
        	};
        if(z==true){  alert("rnt");            };
        	
    }
    	
    
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
	
                <span style="float:left; margin:0 10px 10px 0;" ><br /></span>
         
        </div>
        
        <div align="right" id="sidebar">

            <h3 align="left">${productBean.brandName}</h3>
           
            <h2 align="left" >${productBean.modelName}</h2>
            <ul>
            <fmt:parseNumber var="test" value="${Math.floor(100*productBean.discountRate)}%" integerOnly="true" /> ${test}%off
             
            
            <hr>
      	 	<span style="font-size:0.7em;"> *카드할인삼성카드 5%청구할인  할인 혜택 내역</span>
           	<hr>
           	<gg>${productBean.price}원</gg><h2><c:set var="no" value="${Math.round(productBean.price*(1-productBean.discountRate))}"/>${no}원</h2>
            </ul>                               
        </div>
        
        <div  id="sidebar">
        <ul>
    <div class="selectbox"  >
    <label for="select">옵션선택</label> 
        <c:forEach var="minorBeans" items="${option1Beans}">	
        <select id="option${minorBeans.get(0).majorNumber}"  onchange="selectmenu()">		       
	 		<option>${minorBeans.get(0).majorName}</option> 	
	 			<c:forEach var="bean" items="${minorBeans}">
	 				<option>${bean.minorName} </option>
	 			</c:forEach>		
	 	</select>
 		</c:forEach>
	</div>
	<br><br><br>
	<p id="demo"></p>
	<p id="demo1"></p>
	<input  type="button" value="추가하기" id="menulist" onclick="checkmenu()" >
	<hr><span align="right">
       상품 번호 : ${productBean.modelNumber} <br>
       포인트 적립률 :${productBean.rating}% <br>	
      배송소요기간 :${productBean.deliveryPeriod}일 
        </ul>
        </span>
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

