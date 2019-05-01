
	function idcheck(){
		 var id = document.getElementById("email").value;
		 if(id.length<1 || id==null){
		  alert("중복체크할 아이디를 입력하십시오");
		  return false;
		 }
		 var url = "/Sinseikai/idch.me?id=" + id;
		 window.open(url, "get");
		}


function validate() {

	var re = /^[a-zA-Z0-9]{4,12}$/ // 아이디와 패스워드가 적합한지 검사할 정규식

	var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

	// 이메일이 적합한지 검사할 정규식

	var email = document.getElementById("email");

	var pw = document.getElementById("pw");

	var num1 = document.getElementById("num1");

	var num2 = document.getElementById("num2");

	var arrNum1 = new Array(); // 주민번호 앞자리숫자 6개를 담을 배열

	var arrNum2 = new Array(); // 주민번호 뒷자리숫자 7개를 담을 배열

	// ------------ 이메일 까지 -----------

	if (email.value == "") {

		alert("아이디를 입력해 주세요");

		email.focus();

		return false;

	}

	if (!check(re2, email, "적합하지 않은 아이디 형식입니다.")) {

		return false;

	}

	if (!check(re, pw, "패스워드는 4~12자의 영문 대소문자와 숫자로만 입력")) {

		return false;

	}

	if (join.email.value == join.pw.value) {

		alert("아이디와 비밀번호가 동일합니다. 다시 입력해주세요.");

		join.email.value = "";

		join.pw.focus();

		return false;

	}

	if (join.pw.value != join.checkpw.value) {

		alert("비밀번호가 다릅니다. 다시 확인해 주세요.");

		join.checkpw.value = "";

		join.checkpw.focus();

		return false;

	}

	if (join.name.value == "") {

		alert("이름을 입력해 주세요");

		join.name.focus();

		return false;

	}

	// -------------- 주민번호 -------------

	for (var i = 0; i < num1.value.length; i++) {

		arrNum1[i] = num1.value.charAt(i);

	} // 주민번호 앞자리를 배열에 순서대로 담는다.

	for (var i = 0; i < num2.value.length; i++) {

		arrNum2[i] = num2.value.charAt(i);

	} // 주민번호 뒷자리를 배열에 순서대로 담는다.

	var tempSum = 0;

	for (var i = 0; i < num1.value.length; i++) {
		0

		tempSum += arrNum1[i] * (2 + i);

	} // 주민번호 검사방법을 적용하여 앞 번호를 모두 계산하여 더함
	s
	for (var i = 0; i < num2.value.length - 1; i++) {

		if (i >= 2) {

			tempSum += arrNum2[i] * i;

		}

		else {

			tempSum += arrNum2[i] * (8 + i);

		}

	} // 같은방식으로 앞 번호 계산한것의 합에 뒷번호 계산한것을 모두 더함

	if ((11 - (tempSum % 11)) % 10 != arrNum2[6]) {

		alert("올바른 주민번호가 아닙니다.");

		num1.value = "";

		num2.value = "";

		num1.focus();

		return false;

	}if(confirm("회원가입을 하시겠습니까?")){
	        if(idck==0){
	            alert('아이디 중복체크를 해주세요');
	            return false;
	        }else{
	        alert("회원가입을 축하합니다");
	        $("#frm").submit();
	        }
	    }

	alert("회원가입이 완료되었습니다.");

}

function check(re, what, message) {

	if (re.test(what.value)) {

		return true;

	}

	alert(message);

	what.value = "";

	what.focus();

	//return false;

}

//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
function sample4_execDaumPostcode() {
	new daum.Postcode(
			{
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

					// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
					alert(fullRoadAddr);
					var extraRoadAddr = ''; // 도로명 조합형 주소 변수

					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraRoadAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraRoadAddr += (extraRoadAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraRoadAddr !== '') {
						extraRoadAddr = ' (' + extraRoadAddr + ')';
					}
					// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
					if (fullRoadAddr !== '') {
						fullRoadAddr += extraRoadAddr;
					}

					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
					document.getElementById('sample4_roadAddress').value = fullRoadAddr;
					document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

					// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
					if (data.autoRoadAddress) {
						//예상되는 도로명 주소에 조합형 주소를 추가한다.
						var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
						document.getElementById('guide').innerHTML = '(예상 도로명 주소 : '
								+ expRoadAddr + ')';

					} else if (data.autoJibunAddress) {
						var expJibunAddr = data.autoJibunAddress;
						document.getElementById('guide').innerHTML = '(예상 지번 주소 : '
								+ expJibunAddr + ')';

					} else {
						document.getElementById('guide').innerHTML = '';
					}
				}
			}).open();
}

new daum.Postcode({
	oncomplete : function(data) {
		// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		// 예제를 참고하여 다양한 활용법을 확인해 보세요.
	}
}).open();