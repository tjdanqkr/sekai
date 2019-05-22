<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<script src="./js/join.js"></script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link href="http://fonts.googleapis.com/earlyaccess/nanumpenscript.css"
   rel="stylesheet">
   <link href="./css/join.css" rel="stylesheet">
<style>
.np {
   font-family: 'Nanum Pen Script', cursive;
}
</style>

</head>

<body>

   <form name="join" onsubmit="return validate();" class="jo" action="MemberAddAction.me" method="post">

      <table class="table"> 
          <tr><td colspan="5"><h1>회원가입정보</h1></td></tr>
         

         <tr>

            <td><b>이름</b></td>

            <td ><input type="text" id="name" name="name" maxlength="12" /></td>
            <td colspan="3"></td>
              
         </tr>
        <tr>

            <td><b>아이디</b></td>

            <td ><input type="text" id="email"
               name="email" /> </td>
         <td><input type="button" value="중복 검사" onclick="idcheck()"></td>
         <td colspan="2">※메일 형식으로 입력해주세요</td>
          
         </tr>
         <tr>

            <td><b>비밀번호</b></td>
            <td><input type="password" id="pw" name="pw" maxlength="12" /></td>
            <td colspan="2">※4-12자의 영문 대소문자와 숫자로만 입력해주세요</td>
            <td></td>
         </tr>
         <tr>

            <td><b>비밀번호확인</b></td>

            <td colspan="4"><input type="password"  id="checkpw"
               maxlength="12" /></td>

         </tr>
         <tr>

            <td><b>주민등록번호</b></td>

            <td><input type="text" name="num1" id="num1"  maxlength="6"></input></td>
           <td>
           <input type="password" name="num2" id="num2" maxlength="7"></input></td>
            <td>※ 123456-1234567</td>
            

         </tr>
         <tr>

            <td><b>나이</b></td>

            <td ><input type="text" name="age" id="age" maxlength="3"></td>
            <td  > ※ 만 나이를 입력해주세요</input></td>
            <td colspan="2"></td>

         </tr>
         <tr>

            <td><b>휴대폰 번호</b></td>

            <td><input type="text" name="phone" id="phone" maxlength="11"> </input></td>
            <td colspan="3">※ -를 제외하고 입력해주세요</td>

         </tr>
         <tr>

            <td><b>주소</b></td>
            <td><input type="button" class="btn-primarybox"
               onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br></td>
            <td><input type="text" name="post" class="box"
               id="sample4_postcode" placeholder="우편번호" required></td>
            <td><input type="text" name="roadAddress" class="box"
               id="sample4_roadAddress" placeholder="도로명주소" required></td>
            <td><input type="text" name="jibunAddress" class="box"
               id="sample4_jibunAddress" placeholder="지번주소" required></td>
               


         </tr>


<tr>
         <td><br /> <input type="submit" value="회원가입" style="border-radius: 5px;" /></td>

         <td><br /><input type="reset" value="다시입력" style="border-radius: 5px;" /></td>
         <td><br /><input type="button" value="돌아가기" style="border-radius: 5px;"
                    onclick="location.href='product-into.pr'  " /></td>
            </tr>
      
 </table>
   </form>

</body>


</html>