<%
/*
 * Admin : Overview page
*/
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	.overviewContainer{
		display: inline-block;
		width: 50%;
		height: 50%;
	}
	.overviewHeader{
		width: 100%;
		height: 15%;
		margin: 0px;
		background-color: hsl(200, 100%, 80%);
		color: white;
	}
	.overviewContent{
		width: 100%;
		height: 85%;
	}
</style>


<!--Load the JQuery-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    
<!--Load the AJAX API-->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>



<script>
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart);
	
	function drawChart(){
		var data = google.visualization.arrayToDataTable([
			['Task', 'asd'],
			<c:forEach var="brandNamePiece" items="${brandNameMap}" varStatus="status">
				['${brandNamePiece.key}',
				${brandNamePiece.value}]<c:if test="${!status.last}">,</c:if>
			</c:forEach>
		]);
		
		var options = {
			title: 'brand name'
		};
		
		var chart = new google.visualization.PieChart(document.getElementById('pieChart'));
		
		chart.draw(data, options);
	}
</script>

<h1>안녕 난 오버뷰야</h1>
<div class="overviewContainer">
	<h1 class="overviewHeader">오늘</h1>
	<div id="pieChart" class="overviewContent"></div>
</div>
