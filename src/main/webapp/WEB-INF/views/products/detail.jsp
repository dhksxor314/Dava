
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ page session="true"%>


<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<html>
<head>
<title>Detail</title>
</head>
<body>

	<%@ include file="../include/header.jsp"%>


	<div class="container"
		style="margin-top: 5px; border: solid 0.5px silver;">

		<div class="row" style="margin-top: 20px">
			<div class="col-md-offset-1 col-md-3">
				<img src="<%=cp%>/resources/imgs/Chrysanthemum.jpg"
					style="width: 100%; height: 40%">
			</div>
			<div class="col-md-offset-1 col-md-6 col-md-offset-1">

				<div style="border: solid 1px;">
					<div class="row" style="height: 40%; ">
						<div class="col-md-offset-1"style="margin-top: 20px">
							<p>제 목 : </p>
							<p>저 자 :</p>
							<p>출 판 사 :</p>
							<p>판 매 일 :</p>
							<p>가 격 :</p>
							<p>줄 거 리 :</p>
						</div>
					</div>


				</div>

			</div>



		</div>

		<div class="row">
			<div class="col-md-offset-8 col-md-3" style="text-align: right;">
				<button>결제</button>
				<button>장바구니</button>
				<button>바로보기</button>
			</div>
		</div>

	</div>



	<script src="<%=cp%>/resources/bootstrap/js/bootstrap.min.js"></script>


	<%@ include file="../include/footer.jsp"%>
</body>
</html>
