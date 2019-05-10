<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

<style>
	ul{
		margin: 2.5vh 20px;
		padding: 0px;
	}
	li{
		list-style-type: none;
	}
	#categoryTop{
		height: 20vh;
		background-color: skyblue;
	}
	#addButton{
		position: absolute;
		width: 10vw;
		height: 10vh;
		top: 5vh;
		right: 5vw;
		border: none;
		border-radius: 5px;
		transition: all .2s;
	}
	#addButton:hover{
		border-top: 5px solid;
		padding-top: 5px;
	}
	#categoryContainer{
		display: flex;
		margin: 0px;
	}
	#noticeCategory, #noticeCode{
		color: red;
	}
	#noticeConfirm{
		color: green;
	}
	.categoryList{
		flex-grow: 1;
		height: 75vh;
	}
	#minorCategory{
		background:tomato;
	}
	.categoryButton{
		height: 10rem;
		border-bottom: hsl(39, 100%, 40%) solid 3px;
		background-color: hsl(39, 100%, 50%);
		transition: background-color .2s;
	}
	.categoryButton:hover{
		background-color: hsl(39, 100%, 70%);
	}
</style>

<c:set var="majorBeans" value="${menuBeans}"></c:set>
<c:set var="categoryCodeBeans" value="${categoryCodeBeans}"></c:set>

<div id="categoryTop">
	<form action="manageCategoryInsert.pr" method="post" onsubmit="return checkValues()">
		MajorName <input type="text" name="majorName" oninput="validate()" />
		MinorName <input type="text" name="minorName" oninput="validate()" />
		CategoryName <input type="text" name="categoryName" oninput="validate()" />
		CategoryCode <input type="text" name="categorycode" oninput="validate()"/>
		<input type="submit" value="등록" />
	</form>
	<p id="noticeCategory"></p>
	<p id="noticeCode"></p>
	<h2 id="noticeConfirm"></h2>
</div>
<div id="categoryContainer">
	<ul id="majorCategory" class="categoryList">
		<c:forEach var="minorBeans" items="${menuBeans}" varStatus="status">
			<li class="categoryButton" value="${status.index}">${minorBeans.get(0).get(0).majorName}</li>
		</c:forEach>
	</ul>
	
	<ul id="minorCategory" class="categoryList">
	</ul>
	
	<ul id="category" class="categoryList">
	</ul>
</div>

<script>
	var selected = {
		major: -1,
		minor: -1,
		category: -1
	};
	var majorList = [];
	var codexCategoryList = [];

	<c:forEach var="minorBeans" items="${majorBeans}">
		var minorList = [];
		<c:forEach var="categoryBeans" items="${minorBeans}">
			var categoryList = [];
			<c:forEach var="bean" items="${categoryBeans}">
				var category = {
					majorName : '${bean.majorName}',
					minorName : '${bean.minorName}',
					categoryName : '${bean.categoryName}'
				};
				categoryList.push(category);
			</c:forEach>
			minorList.push(categoryList);
		</c:forEach>
		majorList.push(minorList);
	</c:forEach>
	
	
	<c:forEach var="bean" items="${categoryCodeBeans}">
		codexCategoryList.push('${bean.categorycode}');
	</c:forEach>	
	
	
	$('#majorCategory').children().on('click', function(event){
		openMinorCategory(event.target.value);
	});
	
	
	// open minor category when clicked major category.
	function openMinorCategory(value){
		selected.major = value;
		selected.minor = -1;
		var minorList = majorList[value];
		
		$('#minorCategory').empty();
		$('#category').empty();

		for(var i = 0; i < minorList.length; i++){
			var li = $('<li></li>');
			li.attr('class', 'categoryButton');
			li.val(i);
			li.html(minorList[i][0].minorName);
			li.on('click', function(event){
				openCategory(event.target.value);
			})
			$('#minorCategory').append(li);
		}
		
		changeInput();
		validate();
	}
	
	// open category when clicked minor category.
	function openCategory(value){
		selected.minor = value;
		selected.category = -1;
		var categoryList = majorList[selected.major][value];
		
		$('#category').empty();
		
		for(var i = 0; i < categoryList.length; i++){
			var li = $('<li></li>');
			li.attr('class', 'categoryButton');
			li.val(i);
			li.html(categoryList[i].categoryName);
			li.on('click', function(event){
				
			})
			$('#category').append(li);
		}

		changeInput();
		validate();
	}
	
	function changeInput(){
		$('input[name=majorName]').val(majorList[selected.major][0][0].majorName);
		if(selected.minor != -1){
			$('input[name=minorName]').val(majorList[selected.major][selected.minor][0].minorName);
		}else{
			$('input[name=minorName]').val('');
		}
	}
	
	function checkOverlap(){
		for(var i = 0; i < majorList.length; i++){
			for(var j = 0; j < majorList[i].length; j++){
				for(var k = 0; k < majorList[i][j].length; k++){
					var category = majorList[i][j][k];
					if(($('input[name=majorName]').val() == category.majorName) && 
						($('input[name=minorName]').val() == category.minorName) && 
						($('input[name=categoryName]').val() == category.categoryName)
					){
						$('#noticeCategory').html('동일한 카테고리가 있습니다');
						return false;
					}
				}
			}
		}
		$('#noticeCategory').html('');
		return true;
	}
	
	function checkOverlapCode(){
		for(var i = 0; i < codexCategoryList.length; i++){
			if($('input[name=categorycode]').val() == codexCategoryList[i]){
				$('#noticeCode').html('동일한 카테고리 코드가 있습니다');
				return false;
			}
		}
		$('#noticeCode').html('');
		return true;
	}
	
	// Check values before submit.
	function checkValues(){
		if(!validate()){
			alert('안됩니다');
			return false;
		}
		return true;
	}
	
	// Check values at changed input value.
	function validate(){
		$('#noticeConfirm').html('');
		
		var majorName = $('input[name=majorName]').val();
		var minorName = $('input[name=minorName]').val();
		var categoryName = $('input[name=categoryName]').val();
		var categorycode = $('input[name=categorycode]').val();
		
		if((!checkOverlap()) || (!checkOverlapCode())){
			return false;
		}
		
		var reg = /^[\w\s가-힣]{1,}$/; // Check string.
		if(!reg.test(majorName)){
			return false;
		}
		if(!reg.test(minorName)){
			return false;
		}
		if(!reg.test(categoryName)){
			return false;
		}
		
		reg = /^\d{1,}$/; // Check number.
		if(!reg.test(categorycode)){
			return false;
		}

		$('#noticeConfirm').html('추가 가능합니다!');
		return true;
	}
</script>
	