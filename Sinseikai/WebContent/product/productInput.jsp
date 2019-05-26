<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"  src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript">

function plus() {
			$("div").prepend("<input type='text' name='d'>");
		}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><%@include file="headmenu.jsp" %></div><br>

<h2>${name}님의 판매등록 페이지입니다.</h2><hr>

<form action="product-regist.pr" method="post" name="productset"   enctype="Multipart/form-data" >
브랜드 선택하기 :<select name = "brandName">
<c:forEach var="brando" items="${brandolist}">
	<option id = "brandselect" value="${brando.brandName}">     ${brando.brandName}    </option>
</c:forEach>
</select>


 <p id="demo" ></p><br>

상품명 등록 <input type="text" name = "proname" size = "25px"><br><br>

 
쿠폰사용가능 여부 : <select name ="coupon"><!--  쿠폰 -->
<option value ="0">미적용</option>
<option value ="1">사용가능</option>
</select><br><br>

배송기간 선택 : <select name = "delibery">
<option value ="0">당일배송</option>
<option value ="1">1일</option>
<option value ="2">2일</option>
<option value ="3">3일</option>
<option value ="4">4일</option>
</select><br><br>

가격 설정 : <input type ="text" size="10px" name="setPrice">원 <br><br>

카테고리 설정 : <select name = "category">
<c:forEach var="cate" items="${categorycodelist}">
	<option id = "brandselect" value="${cate.categoryCode}">${cate.majorName} ${cate.minorName}  ${cate.categoryName}</option>
</c:forEach>
</select><br><br>

이미지 업로드 -------<br>
파일명1 : <input type="file" name="ImgAddr1" /><br/>
파일명2 : <input type="file" name="ImgAddr2" /><br/>
파일명3 : <input type="file" name="ImgAddr3" /><br/>
파일명4 : <input type="file" name="ImgAddr4" /><br/>
파일명5 : <input type="file" name="ImgAddr5" /><br/><br>
<!-- <div id="colortable">
 <input type="text" name="color">
 </div><button onclick="plus()">dd</button>
옵션 추가하기--------------------------<br>
<select>
<option value = " "><p id = "option1"></p></option>
<option value = " "><p id = "option2"></p></option>
<option value = " "><p id = "option3"></p></option>
</select>
-----------------------------------------<br> -->
<input type="hidden" name="seller" value ="${id}">
<input type="submit" value="등 록 하 기 고 고 "> 
</form>
<div id=footer><%@include file="footer.jsp" %>  </div>
</body>
</html>
