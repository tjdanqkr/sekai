<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
          <span> <%@include file="/product/productIntoImg.jsp" %></span>
                <span style="float:left; margin:0 10px 10px 0;" ><br /></span>
         
        </div>
        
        <div id="sidebar">

            <h3></h3>
           
            <h4>Sub header</h4>
            <ul>
            
            <li><h2>${productBean.price}원</h2></li> 
      	 	<li><h2></h2></li> 
            </ul>                               
        </div>
        <div id="comments">
            <h3>Comments</h3>
            <p>
                <span>Visitor 1</span>
                Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, 
                there live the blind texts. Separated they live in Bookmarksgrove right at the coast of 
                the Semantics, a large language ocean.
            </p>
            <p>
                <span>Visitor 2</span>
                Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, 
                there live the blind texts. Separated they live in Bookmarksgrove right at the coast of 
                the Semantics, a large language ocean.
            </p>
            <p>
                <span>Visitor 3</span>
                Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, 
                there live the blind texts. Separated they live in Bookmarksgrove right at the coast of 
                the Semantics, a large language ocean.
            </p>
        </div>
    </div>
    <div id="footer">Copyright © JankoAtWarpSpeed 2009.</div>
</body>
</html>

