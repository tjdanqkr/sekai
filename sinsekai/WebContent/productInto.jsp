<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head><!-- 여기는상품상세란 -->
<body>
<div><%@include file="headmenu.jsp" %></div><br>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
    <title>상품상세정보</title>
   <link rel ="stylesheet" href="menubar.css" type ="text/css"/>
    
</head>
<body>  
    <div id="main">
        <div id="content">
            
            <h3>상품 이미지</h3>
          <span> <%@include file="productIntoImg.jsp" %></span>
                <span style="float:left; margin:0 10px 10px 0;" ><br /></span>
               
               
               
               
        </div>
        <div id="sidebar">
            <h3>오일릴리</h3>
            
            <h1>라운드 투톤 호리젠탈 프메일 자켓</h1>
            <ul>
            <h2>    	        ${productBean }</h2>
            </ul>  
            <ul>카드할인 kb국민카드 5%청구할인</ul>
            <ul>색상선택 : </ul>
            <ul>사이즈선택</ul>
            
            
                          
            <ul>
            	상품번호 ${productBean}
            </ul>
            <ul>
            	모델번호
            </ul>
            <ul>
            	배송정보	
            </ul>
            
            
                           
        </div>
        <div id="comments">
            <h3>Comments</h3>
            <p>
                <span>상품상세설명</span>
                대충 설명하는 사진
            </p>
            <p>
                <span>상품 상세설명</span>
                대충 글
            </p>
            <p>
                <span>Visitor 3</span>
              대충 뭘로 결제하세요
            </p>
        </div>
    </div>
    <div id="footer">Copyright © JankoAtWarpSpeed 2009.</div>
</body>
</html>
</body>
</html>