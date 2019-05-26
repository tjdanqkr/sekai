
<%
   /*
    * Admin : Overview page
   */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!--Load the JQuery-->
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

<!--Load the AJAX API-->
<script type="text/javascript"
   src="https://www.gstatic.com/charts/loader.js"></script>
<link rel="stylesheet" type="text/css" href="./css/overview.css" />


<script>
   google.charts.load('current', {'packages':['corechart']});
   google.charts.setOnLoadCallback(drawChart);
   
   function drawChart(){
      <c:forEach var="brandNameMap" items="${brandNameMaps}">
      var data_${brandNameMap.key} = google.visualization.arrayToDataTable([
         ['Period', '${brandNameMap.key}'],
         <c:forEach var="brandNamePiece" items="${brandNameMap.value}" varStatus="status">
            ['${brandNamePiece.key}',
            ${brandNamePiece.value}]<c:if test="${!status.last}">,</c:if>
         </c:forEach>
      ]);
      
      var options_${brandNameMap.key} = {
         chartArea: { 
            width: '100%',
            height: '90%'
         },
         <c:choose>
            <c:when test="${brandNameMap.key == 'dailyMap'}">
               /*
                * Daily is big.
               */
               width: 500,
               height: 500
            </c:when>
            <c:otherwise>
               /*
                * other is small.
               */
               width: 300,
               height: 300
            </c:otherwise>
         </c:choose>
      };
      
      var chart = new google.visualization.PieChart(document.getElementById('pieChartBrandName_${brandNameMap.key}'));
      
      chart.draw(data_${brandNameMap.key}, options_${brandNameMap.key});
      </c:forEach>
   }
</script>
<table>
   <tr>
      <td class="overviewcontent">오늘</td>
      <td class="overviewcontent">주간</td>
   </tr>
   <tr>
      <td id="pieChartBrandName_dailyMap"></td>
      <td id="pieChartBrandName_weeklyMap"></td>
   </tr>
</table>


