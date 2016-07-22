<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<!DOCTYPE html>

<%
	String cp = request.getContextPath();
%>

<html>
<head>

<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<link href="/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<title>Insert title here</title>


<script>
	$(document).ready(function() {
		if ('${bookVO.title}' == "") {
			window.close();
		}
		$("#cancel").click(function(event) {

			var con = confirm("취소하시면 입력한 모든 정보가 취소됩니다.\n결제를 취소하시겠습니까?");
			if (con == true) {
				window.close();
			}
		});

		$("#payment").click(function(event) {

			var p_way = $(':radio[name="p_way"]:checked').val();
			var agree = $(':checkbox[name="agree"]:checked').val();

			if (p_way == null) {
				alert("결제 수단을 선택해주세요");
				return false;
			} else if (agree == null) {
				alert("결제진행에 동의해 주세요");
				return false;
			}

			var con = confirm("정말로 결제 하시겠습니까?");
			if (con == true) {
				$("#form1").submit();
			} else {
				return false;
			}
		});

		$("#point").change(function(event) {
			var point = '${memberVO.point}' * 1;
			var price = '${bookVO.price}' * 1;
			if ($(this).val() > point) {
				alert('보유 포인트를 초과하였습니다.');
				$(this).val("");
				$("#use_point").text("0");
				$("#final_pay").val(price);
			} else if ($(this).val() > price) {
				alert('결제 금액을 초과 하였습니다..');
				$(this).val("");
				$("#use_point").text("0");
				$("#final_pay").val(price);
			} else {
				$("#use_point").text($(this).val());
				$("#final_pay").val(price - $("#use_point").text());
			}

		});

	});
</script>
</head>

<style>
.radio-inline {
	margin-top: 10px;
}
</style>
<body>
	<form method="POST" id="form1" name="form1">
		<div class="container">
			<div class="row" style="background-color: #23b300;">
				<div class=" col-xs-2">
					<img src="/resources/imgs/pay_logo.png" width="100%">
				</div>
				<div class="col-xs-2">
					<h3 style="color: white;">결제</h3>
				</div>
			</div>
			<div class="row" style="border: solid silver 1px; margin-top: 5px">

				<div class="row">
					<div class="col-xs-offset-1 col-xs-6" style="text-align: left;">
						<h4>[${bookVO.genre}] ${bookVO.title}</h4>
					</div>
					<div class="col-xs-offset-1 col-xs-3 col-xs-offset-1"
						style="text-align: right;">
						<h4>${bookVO.price }원</h4>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-xs-offset-1 col-xs-6" style="text-align: left;">
						<div class="row">포인트 사용</div>
						<div class="row" style="margin-top: 10px">
							<div class="col-xs-7">사용할 포인트(${memberVO.point} 원 보유)</div>
							<div class="col-xs-5">
								<input type="text"
									style="border: none; border-right: 0px; border-top: 0px; boder-left: 0px; boder-bottom: 0px; text-align: right; width: 50%"
									placeholder="0" id="point"> 원
							</div>

						</div>
					</div>
					<div class="col-xs-4" style="background-color: #ffffc2">
						<div class="col-xs-offset-1" style="margin-top: 10px">총 결제
							금액</div>
						<div class="col-xs-offset-1">
							<input type="text" id="final_pay"
								style="border: none; border-right: 0px; background-color: #ffffc2; border-top: 0px; boder-left: 0px; boder-bottom: 0px; width: 50%; font: bold; font-size: x-large;"
								name="final_pay" value="${bookVO.price}" readonly="readonly" />
							원
						</div>
						<hr>
						<div class="col-xs-7">상품 금액</div>
						<div class="col-xs-offset-1 col-xs-4">${bookVO.price}원</div>
						<div class="col-xs-7">포인트 사용금액</div>
						<div class="col-xs-offset-1 col-xs-4">
							<label id="use_point">0</label>원
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-offset-1 col-xs-6">
						<div class="row">
							<div class="col-xs-6" style="text-align: left;">결제 정보</div>
							<br />

							<div class="row" style="margin-top: 15px">
								<div role="tabpanel">
									<!-- Nav tabs -->
									<ul class="nav nav-tabs" role="tablist">
										<li role="presentation" class="active"><a href="#account"
											aria-controls="account" role="tab" data-toggle="tab">계좌
												결제</a></li>
										<li role="presentation"><a href="#nomal"
											aria-controls="nomal" role="tab" data-toggle="tab">일반 결제</a></li>
									</ul>
									<!-- Tab panes -->
									<div class="tab-content">
										<div role="tabpanel" class="tab-pane active" id="account">


											<div class="col-xs-4">
												<label class="radio-inline"><input type="radio"
													name="p_way" id="inlineRadio1" value="농협" /> 농협</label>
											</div>
											<div class="col-xs-4">
												<label class="radio-inline"><input type="radio"
													name="p_way" id="inlineRadio2" value="국민" /> 국민</label>
											</div>
											<div class="col-xs-4">
												<label class="radio-inline"><input type="radio"
													name="p_way" id="inlineRadio3" value="신한" /> 신한</label>
											</div>

											<div class="col-xs-4">
												<label class="radio-inline"><input type="radio"
													name="p_way" id="inlineRadio4" value="우리" /> 우리</label>
											</div>
											<div class="col-xs-4">
												<label class="radio-inline"><input type="radio"
													name="p_way" id="inlineRadio5" value="기업" /> 기업</label>
											</div>
											<div class="col-xs-4">
												<label class="radio-inline"><input type="radio"
													name="p_way" id="inlineRadio6" value="SC제일" /> SC제일</label>
											</div>


										</div>
										<div role="tabpanel" class="tab-pane" id="nomal"">
											<div class="col-xs-4">
												<label class="radio-inline"><input type="radio"
													name="p_way" id="inlineRadio1" value="신용카드" /> 신용카드</label>
											</div>
											<div class="col-xs-4">
												<label class="radio-inline"><input type="radio"
													name="p_way" id="inlineRadio2" value="계좌이체" /> 계좌이체</label>
											</div>
											<div class="col-xs-4">
												<label class="radio-inline"><input type="radio"
													name="p_way" id="inlineRadio3" value="휴대폰" /> 휴대폰</label>
											</div>

											<div class="col-xs-4">
												<label class="radio-inline"><input type="radio"
													name="p_way" id="inlineRadio4" value="상품권" /> 상품권</label>
											</div>

										</div>

									</div>

								</div>

							</div>


						</div>
						<hr />
						<div class="row checkbox">
							<label> <input type="checkbox" checked="checked"
								name="agree" /> 위 상품의 구매조건 확인 및 결제진행 동의</<label>
						</div>

					</div>
					<div class="col-xs-5">
						<div class="col-xs-12" style="margin-top: 30px">
							<h5 style="font: bold;">결제 혜택</h5>
							<h6>사용한 금액의 10%가 포인트로 적립됩니다.</h6>

						</div>
					</div>
				</div>


			</div>
			<div class="row" style="border: solid silver 1px;">
				<div class="col-xs-offset-3 col-xs-3" style="text-align: right;">
					<button id="payment" class="col-xs-10 btn btn-success">
						<h4>결제</h4>
					</button>
				</div>
				<div class="col-xs-3">
					<button id="cancel" class="col-xs-10 btn btn-default">
						<h4>취소</h4>
					</button>
				</div>

			</div>

		</div>
	</form>


</body>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</html>