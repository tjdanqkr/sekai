<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="./css/manageCategory.css" />

<c:set var="majorBeans" value="${menuBeans}"></c:set>
<c:set var="categoryCodeBeans" value="${categoryCodeBeans}"></c:set>

<!-- 
Prevent the action that select all category if entered to modify mode.  
-->
<div id="blockScreen"></div>

<div id="categoryTop">
	<div id="formContainer">
		<button id="backButton">돌아가기</button>
		<form action="manage-category-insert.ad" method="post"
			onsubmit="return checkValues()">
			MajorName <input type="text" name="majorName" oninput="validate()" />
			MinorName <input type="text" name="minorName" oninput="validate()" />
			CategoryName <input type="text" name="categoryName"
				oninput="validate()" /> CategoryCode <input type="text"
				name="categoryCode" oninput="validate()" /> <input type="submit"
				value="" class="btn_submit" alt="등록" />

			<!-- Used for modify the category. -->
			<input type="text" name="previousCategoryCode" value="" />

		</form>
		<p id="noticeCategory"></p>
		<p id="noticeCode"></p>
		<h2 id="noticeConfirm"></h2>
	</div>
</div>
<div>
<div class="categoryContainers">
	<div class="categoryContainers">
		<div class="categoryContainer0">
			<ul id="majorCategory" class="categoryList">
				<c:forEach var="minorBeans" items="${menuBeans}" varStatus="status">
					<li class="categoryButton" value="${status.index}">${minorBeans.get(0).get(0).majorName}</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="categoryContainers">
		<div class="categoryContainer1">
			<ul id="minorCategory" class="categoryList">
			</ul>
		</div>
	</div>
	<div class="categoryContainers">
		<div class="categoryContainer2">
			<ul id="category" class="categoryList">
			</ul>
		</div>

	</div>
</div>
</div>
<script>
	$(document).ready(function() {
		$('#backButton').css('display', 'none');
		$('#blockScreen').css('display', 'none');

		$('#backButton').on('click', function() {
			backToView();
		});

		$('input[name=previousCategoryCode]').css('display', 'none');
	});

	var selected = {
		major : -1,
		minor : -1,
		category : -1
	};
	var majorList = [];
	var categoryCodeList = [];

	<c:forEach var="minorBeans" items="${majorBeans}">
	var minorList = [];
	<c:forEach var="categoryBeans" items="${minorBeans}">
	var categoryList = [];
	<c:forEach var="bean" items="${categoryBeans}">
	var category = {
		majorName : '${bean.majorName}',
		minorName : '${bean.minorName}',
		categoryName : '${bean.categoryName}',
		categoryCode : '${bean.categoryCode}'
	};

	categoryCodeList.push(category.categoryCode);
	categoryList.push(category);
	</c:forEach>
	minorList.push(categoryList);
	</c:forEach>
	majorList.push(minorList);
	</c:forEach>

	$('#majorCategory').children().on('click', function(event) {
		openMinorCategory(event.target.value);
	});

	// open minor category when clicked major category.
	function openMinorCategory(value) {
		selected.major = value;
		selected.minor = -1;
		selected.category = -1;
		var minorList = majorList[value];

		$('#minorCategory').empty();
		$('#category').empty();

		for (var i = 0; i < minorList.length; i++) {
			var li = $('<li></li>');
			li.attr('class', 'categoryButton');
			li.val(i);
			li.html(minorList[i][0].minorName);
			li.on('click', function(event) {
				openCategory(event.target.value);
			})
			$('#minorCategory').append(li);
		}

		changeInput();
		validate();
	}

	// open category when clicked minor category.
	function openCategory(value) {
		selected.minor = value;
		selected.category = -1;
		var categoryList = majorList[selected.major][value];

		$('#category').empty();

		for (var i = 0; i < categoryList.length; i++) {
			var li = $('<li></li>');
			var button = $('<button></button>');

			li.attr('class', 'categoryButton');
			li.val(i);
			li.html(categoryList[i].categoryName);
			li.on('click', function(event) {
				selected.category = event.target.value;

				// Modified.
				modifyCategoryIfWant(selected.major, selected.minor,
						event.target.value);
			})

			button.attr('class', 'deleteButton')
			button.val(i);
			button.html('');
			button.on('click', function(event) {
				// Delete category.
				deleteCategoryIfWant(selected.major, selected.minor,
						event.target.value);
			});

			li.append(button);
			$('#category').append(li);
		}

		changeInput();
		validate();
	}

	function changeInput() {
		$('input[name=majorName]').val(
				majorList[selected.major][0][0].majorName);
		if (selected.minor != -1) {
			$('input[name=minorName]').val(
					majorList[selected.major][selected.minor][0].minorName);
		} else {
			$('input[name=minorName]').val('');
		}
	}

	function checkOverlap(majorName, minorName, categoryName) {
		if ($('#formContainer').attr('class') == 'modify') {
			var categoryData = majorList[selected.major][selected.minor][selected.category];

			// When only change category code.
			if (categoryData.majorName == majorName
					&& categoryData.minorName == minorName
					&& categoryData.categoryName == categoryName) {
				return true;
			}
		}

		for (var i = 0; i < majorList.length; i++) {
			for (var j = 0; j < majorList[i].length; j++) {
				for (var k = 0; k < majorList[i][j].length; k++) {
					var category = majorList[i][j][k];
					if (($('input[name=majorName]').val() == category.majorName)
							&& ($('input[name=minorName]').val() == category.minorName)
							&& ($('input[name=categoryName]').val() == category.categoryName)) {
						$('#noticeCategory').html('동일한 카테고리가 있습니다');
						return false;
					}
				}
			}
		}
		$('#noticeCategory').html('');
		return true;
	}

	function checkOverlapCode(categoryCode) {
		if ($('#formContainer').attr('class') == 'modify') {
			var categoryData = majorList[selected.major][selected.minor][selected.category];

			// When change major, minor, category.
			if (categoryData.categoryCode == categoryCode) {
				return true;
			}
		}

		for (var i = 0; i < categoryCodeList.length; i++) {
			if ($('input[name=categoryCode]').val() == categoryCodeList[i]) {
				$('#noticeCode').html('동일한 카테고리 코드가 있습니다');
				return false;
			}
		}
		$('#noticeCode').html('');
		return true;
	}

	// Check values before submit.
	function checkValues() {
		if (!validate()) {
			alert('안됩니다');
			return false;
		}
		return true;
	}

	// Check values at changed input value.
	function validate() {
		$('#noticeConfirm').html('');

		var majorName = $('input[name=majorName]').val();
		var minorName = $('input[name=minorName]').val();
		var categoryName = $('input[name=categoryName]').val();
		var categoryCode = $('input[name=categoryCode]').val();

		if ((!checkOverlap(majorName, minorName, categoryName))
				|| (!checkOverlapCode(categoryCode))) {
			return false;
		}

		if ($('#formContainer').attr('class') == 'modify'
				&& isEqualAllCategoryData(majorName, minorName, categoryName,
						categoryCode)) {
			return false;
		}

		var reg = /^[\w\s가-힣]{1,}$/; // Check string.
		if (!reg.test(majorName)) {
			return false;
		}
		if (!reg.test(minorName)) {
			return false;
		}
		if (!reg.test(categoryName)) {
			return false;
		}

		reg = /^\d{1,}$/; // Check number.
		if (!reg.test(categoryCode)) {
			return false;
		}

		if ($('#formContainer').attr('class') == 'modify') {
			$('#noticeConfirm').html('변경 가능합니다!');
		} else {
			$('#noticeConfirm').html('추가 가능합니다!');
		}
		return true;
	}

	// Change to modify mode.
	function modifyCategoryIfWant(major, minor, category) {
		var categoryData = majorList[major][minor][category];
		var inputs = $('#formContainer > form').children();

		$('#formContainer').attr('class', 'modify');
		$('#formContainer > form').attr('action', 'manage-category-modify.ad');

		/*
		 * inputs[0],[1](major, minor) is already insert data.
		 */
		inputs[2].value = categoryData.categoryName;
		inputs[3].value = categoryData.categoryCode;
		inputs[4].value = '수정';

		$('#backButton').css('display', '');
		$('#blockScreen').css('display', '');

		$('input[name=previousCategoryCode]').val(categoryData.categoryCode);

		validate();
	}

	// Change to view mode.
	function backToView() {
		var inputs = $('#formContainer > form').children();

		$('#formContainer').attr('class', '');
		$('#formContainer > form').attr('action', 'manage-category-insert.ad');

		inputs[2].value = '';
		inputs[3].value = '';
		inputs[4].value = '등록';

		$('#backButton').css('display', 'none');
		$('#blockScreen').css('display', 'none');

		$('input[name=previousCategoryCode]').val('');

		validate();
	}

	// Prevent update if not change the data on modify mode.
	function isEqualAllCategoryData(majorName, minorName, categoryName,
			categoryCode) {
		var categoryData = majorList[selected.major][selected.minor][selected.category];

		if (categoryData.majorName == majorName
				&& categoryData.minorName == minorName
				&& categoryData.categoryName == categoryName
				&& categoryData.categoryCode == categoryCode) {
			return true;
		}

		return false;
	}

	// Question that are you sure delete the category?
	function deleteCategoryIfWant(major, minor, category) {
		var categoryData = majorList[major][minor][category];

		if (confirm('정말 삭제?\n' + categoryData.majorName + ' - '
				+ categoryData.minorName + ' - ' + categoryData.categoryName)) {
			// Request category delete to server.
			var form = $('<form></form>');
			var input = $('<input />')

			form.attr('action', 'manage-category-delete.ad');
			form.attr('method', 'post');
			form.css('display', 'none');

			input.attr('name', 'categoryCode');
			input.val(categoryData.categoryCode);

			form.append(input[0]);
			form.append(input[1]);
			form.append(input[2]);
			form.append(input[3]);

			$('body').append(form);

			form.submit();
		}
	}
</script>
