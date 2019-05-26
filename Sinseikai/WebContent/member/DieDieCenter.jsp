<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="./js/Diebutton.js"></script>
<link rel="stylesheet" href="./css/DieDieCenter.css">
<link rel="stylesheet" href="./css/DieDieTop.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="sub_cont">
	<header>
		<h3 class="page_title">1:1 문의하기</h3>
		<ul class="bull_list-dash">
			<li>- 문의하신 내용에 대한 답변은 이메일 또는 마이롯데 &gt; 1:1답변확인에서 확인하실 수 있습니다.</li>
			<li>- 답변 완료 시 회원정보에 등록된 휴대폰번호로 알림을 받으실 수 있습니다.</li>
		</ul>
	</header>
</div>
	<div class="information_table">
		<form method="post" id="frmCnslRegist" action="diedieinsert.cus">
			<table>
				<caption></caption>
				<colgroup>
					<col style="width: 180px"></col>
					<col></col>
					<col style="width: 140px"></col>
				</colgroup>
				<tbody>
					<tr>
						<th scope="row">문의 상품</th>
						<td colspan="2">
							<button type="button" class="btn_normal-medium"
								aria-haspopup="dialog" aria-controls="popup_orderSearch"
								id="opener_orderSearch" aria-pressed="false">주문 상품선택</button> 
								<input
							type="checkbox" id="custCnsl_cbxNotProductInqry"
							name="cbxNotProductInqry" value="Y"></input> <label
							for="custCnsl_cbxNotProductInqry">상품 외 문의</label>
							<div id="div_sltdOrdGoodsList" class="select_order-item"></div>
						</td>
					</tr>
					<tr>
						<th scope="row"><label for="custCnsl_inqTitl">문의 제목</label></th>
						<td colspan="2"><input type="text" id="custCnsl_inqTitl"
							name="inqTitl" class="input_field-full" maxlength="50"></input></td>
					</tr>
					<tr>
						<th scope="row"><label for="custCnsl_inqCnts">문의 내용</label></th>
						<td colspan="2"><textarea id="custCnsl_inqCnts"
								name="inqCnts"
								placeholder="반품 및 교환 접수 상태 문의는 택배사 및 송장번호를 입력해 주시기 바랍니다."
								maxlength="2000"></textarea></td>
					</tr>
					<tr>
						<th scope="row">답변 알림</th>
						<td><input type="checkbox" id="custCnsl_ansSmsRecvYn"
							name="ansSmsRecvYn" value="Y"></input> <label
							for="custCnsl_ansSmsRecvYn"><%=session.getAttribute("phone") %></label> <input
							type="hidden" name="ansCellNo" value="<%=session.getAttribute("phone") %>"></input></td>
						<td>
							<button id="btn_doEditMbrInfoOfNonLPOINT" type="button"
								class="btn_normal-medium" onclick="update()">회원정보수정</button>


						</td>
					</tr>
					<tr>
						<th scope="row">이메일 수신</th>
						<td colspan="2"><input type="checkbox"
							id="custCnsl_ansEmailRecvYn" name="ansEmailRecvYn" value="Y"></input>
							<label for="custCnsl_ansEmailRecvYn"><%=session.getAttribute("email1") %></label> <input
							type="hidden" name="ansEmailAddr" value="<%=session.getAttribute("email1") %>"></input>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="btn_area-center">
				<a id="btn_cancelCnslRegist" href="javascript:void(0);"
					class="btn_normal">취소</a> <input id="btn_doCnslRegist"
					type="submit" value="등록" class="btn_default"></input>
			</div>
		</form>
	</div>
</body>
</html>