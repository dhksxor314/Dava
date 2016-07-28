<%@ page contentType="text/html; charset=UTF-8"%>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>

<html>
<head>
<title>Mypage</title>
</head>

<script>
	$(document).ready(function() {
		$("#buybook").click(function(){
			location.href="mypage_Buybook";
		});
		$("#shop_bag").click(function() {

			location.href="/products/shop_bag";			

		});
		$("#personal_info").click(function() {

			var wsize = 350;
			var hsize = 280;
			window.open('mypage_personal_info','personal_info','width ='
					+ wsize+ ',height='+ hsize+ ',top='+ (screen.height - hsize)/ 2+ ', left='+ (screen.width - wsize)/ 2);		

		});
	});
</script>

<body>
	<%@ include file="../include/header.jsp"%>
	<div class="container">
		<div class="row" style="margin-top: 10px">
			<div class="col-xs-offset-8 col-xs-4">보유한 포인트 : ${meminfo.point }</div>
		</div>


		<div class="row" style="margin-top: 10px">
			<div class="col-xs-offset-2 col-xs-8 col-xs-offset-2">
				
				<img class="col-xs-6 btn" id="buybook" style="margin-top: 10px" id="paybook" src="/resources/imgs/my_book.png"  >
				<img class="col-xs-6 btn" id="shop_bag" style="margin-top: 10px" id="paybook" src="/resources/imgs/cart.png">
				<img class="col-xs-6 btn" id="personal_info" style="margin-top: 10px" id="paybook" src="/resources/imgs/password.png" >		
			</div>

		</div>

	</div>





	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>


	<%@ include file="../include/footer.jsp"%>

</body>
</html>
