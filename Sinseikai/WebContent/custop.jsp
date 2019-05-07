<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/custop.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="sub_cont">
      
      <header>
         <h3 class="page_title">자주 찾는 질문</h3>
         <p class="title_button">
            <a href="https://order.ellotte.com/order-fo/claim/orderDelivery?bypass" class="btn_normal">주문배송조회</a>
            <a href="https://order.ellotte.com/order-fo/claim/claims?claimType=cancel&amp;bypass" class="btn_normal">취소/교환/반품 조회</a>
         </p>
      </header>
      <div class="search_faq-form">
         <form id="faqSearchForm" action="/cca-fo/faq/search" method="get">
            <fieldset>
               <legend>자주 찾는 질문 검색</legend>
               <label for="search_faq" class="a11y_sr-only">검색어 입력</label>
               <input type="text" id="search_faq" name="searchValue" placeholder="자주 묻는 질문을 검색해보세요." ></input>
               <input type="submit" value="검색" ></input>
            </fieldset>
         </form>
         
            <ul class="rank">
               <li><a  href="/cca-fo/faq/viewFAQ/P00001/P00009">배송확인</a></li>
               <li><a  href="/cca-fo/faq/viewFAQ/P00003/P00023">주문내역확인</a></li>
               <li><a  href="/cca-fo/faq/viewFAQ/P00006/P00049">L.POINT</a></li>
               <li><a  href="/cca-fo/faq/viewFAQ/P00002/P00017">반품접수</a></li>
               <li><a  href="/cca-fo/faq/viewFAQ/P00002/P00016">교환접수</a></li>
            </ul>
         
      </div>
      </div>
</body>
</html>