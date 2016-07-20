<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<!DOCTYPE html>

<%
	String cp = request.getContextPath();
%>

<html>
<head>

<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<link href="<%=cp%>/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<title>Insert title here</title>


<script>
	$(document).ready(function() {

		$("#cancel").click(function(event) {

			var con =confirm("취소하시면 입력한 모든 정보가 취소됩니다.\n결제를 취소하시겠습니까?");
			if (con == true) {
				window.close();
			} 
		});
		
		$("#payment").click(function(event) {

			var con =confirm("정말로 결제 하시겠습니까?");
			if (con == true) {
				
				alert("디비내용");
				window.close();	
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

	<div class="container">
		<div class="row" style="background-color: lime;">
			<div class=" col-xs-2" style="background-color: black;">로고</div>
			<div class="col-xs-2">
				<h3>결제</h3>
			</div>
		</div>

		<div class="row" style="border: solid silver 1px; margin-top: 5px">

			<div class="row">
				<div class="col-xs-offset-1 col-xs-6" style="text-align: left;">
					<h4>[${bookVO.genre}] ${bookVO.title }</h4>
				</div>
				<div class="col-xs-offset-1 col-xs-3 col-xs-offset-1"
					style="text-align: right;">
					<h4>${bookVO.price }원</h4>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-xs-offset-1 col-xs-6" style="text-align: left;">
					<div>포인트 사용</div>
					<div>사용할 포인트(xx원 보유)</div>
				</div>
				<div class="col-xs-4" style="background-color: #ffffc2">
					<div class="col-xs-offset-1">총 결제 금액</div>
					<div class="col-xs-offset-1">xxx원</div>
					<hr>
					<div class="col-xs-6">상품 금액</div>
					<div class="col-xs-offset-1 col-xs-5">${vookVO.price }원</div>
					<div class="col-xs-6">포인트 사용금액</div>
					<div class="col-xs-offset-1 col-xs-5">xxxx원</div>
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
										aria-controls="account" role="tab" data-toggle="tab">계좌 결제</a></li>
									<li role="presentation"><a href="#nomal"
										aria-controls="nomal" role="tab" data-toggle="tab">일반 결제</a></li>
								</ul>
								<!-- Tab panes -->
								<div class="tab-content">
									<div role="tabpanel" class="tab-pane active" id="account">


										<div class="col-xs-4">
											<label class="radio-inline"><input type="radio"
												name="accountOptions" id="inlineRadio1" value="option1" />
												농협</label>
										</div>
										<div class="col-xs-4">
											<label class="radio-inline"><input type="radio"
												name="accountOptions" id="inlineRadio2" value="option2" />
												국민</label>
										</div>
										<div class="col-xs-4">
											<label class="radio-inline"><input type="radio"
												name="accountOptions" id="inlineRadio3" value="option3" />
												신한</label>
										</div>

										<div class="col-xs-4">
											<label class="radio-inline"><input type="radio"
												name="accountOptions" id="inlineRadio4" value="option4" />
												우리</label>
										</div>
										<div class="col-xs-4">
											<label class="radio-inline"><input type="radio"
												name="accountOptions" id="inlineRadio5" value="option5" />
												기업</label>
										</div>
										<div class="col-xs-4">
											<label class="radio-inline"><input type="radio"
												name="accountOptions" id="inlineRadio6" value="option6" />
												SC제일</label>
										</div>


									</div>
									<div role="tabpanel" class="tab-pane" id="nomal"">
										<div class="col-xs-4">
											<label class="radio-inline"><input type="radio"
												name="nomalOptions" id="inlineRadio1" value="option1" />
												신용카드</label>
										</div>
										<div class="col-xs-4">
											<label class="radio-inline"><input type="radio"
												name="nomalOptions" id="inlineRadio2" value="option2" />
												계좌이체</label>
										</div>
										<div class="col-xs-4">
											<label class="radio-inline"><input type="radio"
												name="nomalOptions" id="inlineRadio3" value="option3" />
												휴대폰</label>
										</div>

										<div class="col-xs-4">
											<label class="radio-inline"><input type="radio"
												name="nomalOptions" id="inlineRadio4" value="option4" />
												상품권</label>
										</div>

									</div>

								</div>

							</div>

						</div>


					</div>
					<hr />
					<div class="row checkbox">
						<label> <input type="checkbox" /> 위 상품의 구매조건 확인 및 결제진행
							동의</<label>
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


</body>
<script src="<%=cp%>/resources/bootstrap/js/bootstrap.min.js"></script>
</html>