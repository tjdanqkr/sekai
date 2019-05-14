<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
String recent;
%>
<link rel="stylesheet" href="css/recentshop.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="skyscraper">
      <div class="sky_bnr">
         <ul>

            <li class="recently"><a href="?recent=./product/open.jsp"
               onClick="gaEventCommon('PC_공통_액션바', '최근 본 쇼핑', '최근 본 쇼핑', '', '');">
                  <span>최근 본 쇼핑</span>
                  <p class="recent_shopping_infomation_count">0</p>
            </a></li>

            <li class="gotop"><a href="#top">TOP</a></li>
         </ul>
      </div>
      <!-- 
         <div class="sky_cont">
            <div class="sky_wrap recently_wrap">
               <h2>최근 본 쇼핑정보 <span class="counter recent_shopping_infomation_count">0</span></h2>
               <p class="close"><button type="button"><span class="ico_closer"><span class="a11y_sr-only">닫기</span></span></button></p>
               <div class="list nodata" style="display: none;" id="recent_shopping_infomation_none">최근 본 쇼핑정보가 없습니다.</div>
               <div class="list">
                  <p class="clear_items"><button type="button" id="remove-recent_shopping_infomation">전체 삭제</button></p>
                  <template id="recent_shopping_infomation_goods_tmpl">
                     <li class="item">
                        <div class="figure">
                           <p class="photo"><a href="#"><img src="" alt=""/></a></p>
                        </div>
                        <a href="#" class="info">
                           <p class="seller"></p>
                           <p class="title"></p>
                           <p class="price"></p>
                        </a>
                        <div class="favorite">
                           <button type="button" role="checkbox" aria-checked="false" class="manual_fn"><span class="ico_favorite"><span class="a11y_sr-only">찜하기</span></span></button>
                        </div>
                     </li>
                  </template>
                  <template id="recent_shopping_infomation_category_tmpl">
                     <li class="item">
                        <div class="figure">
                           <p class="category"><a href="javascript:void(0);">카테고리</a></p>
                        </div>
                        <a href="#" class="info"></a>
                     </li>
                  </template>
                  <template id="recent_shopping_infomation_search_tmpl">
                     <li class="item">
                        <div class="figure">
                           <p class="search"><a href="javascript:void(0);">검색</a></p>
                        </div>
                        <a href="#" class="info"></a>
                     </li>
                  </template>
                  <ul id="area_recent_shopping_infomation">
                  </ul>
               </div>
            </div>
         </div> -->
   </div>
</body>
</html>