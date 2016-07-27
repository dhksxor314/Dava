
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ page session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>

<html>
<head>
<title>Detail</title>
</head>

<script>
	$(document).ready(function() {

		$("#payment").click(function(event) {
			var wsize = 770;
			var hsize = 550;
			window.open('payment?booknum=${bookVO.booknum}&memnum=${memnum}','payment','width ='
					+ wsize+ ',height='+ hsize+ ',top='+ (screen.height - hsize)/ 2+ ', left='+ (screen.width - wsize)/ 2);
			});
		$("#shop_bag").click(function() {
				
			
			
				
				var check = '${check}';
				
				if(check == "true"){
					var con = confirm('${bookVO.title}'+"을(를) 장바구니에 담겠습니까??");
					if (con == true) {
						$("#form2").submit();
						window.close();
						
					}else{
						return false;
					}
				}
				
			});
		});
</script>

<body>
	<%@ include file="../include/header.jsp"%>
	
	<form method="post" id="form2">
		<div class="container" style="border: solid 0.5px silver;">

			<div class="row" style="margin-top: 20px">
				<div class="col-md-offset-1 col-md-3">
					<img src="/resources/imgs/Chrysanthemum.jpg"
						style="width: 100%; height: 40%">
				</div>
				<div class="col-md-offset-1 col-md-6 col-md-offset-1">

					<div style="border: solid 1px;">
						<div class="row" style="height: 40%;">
							<div class="col-md-offset-1" style="margin-top: 20px">
								<input type="hidden" name="memnum" value="${memnum}">
								<input type="hidden" name="booknum" value="${bookVO.booknum}">
								<p>제 목 : ${bookVO.title}</p>
								<p>저 자 :${bookVO.author }</p>
								<p>장 르 : ${bookVO.genre}</p>
								<p>출 판 사 : ${bookVO.publisher}</p>
								<p>
									판 매 일 :
									<fmt:formatDate pattern="yyyy-MM-dd" value="${bookVO.pub_date}" />
								</p>
								<p>가 격 : ${bookVO.price }</p>
								<p>줄 거 리 : ${bookVO.summary }</p>
							</div>
						</div>


					</div>

				</div>



			</div>

			<div class="row">
				<div class="col-md-offset-8 col-md-3" style="text-align: right;">
					<input type="button" id="payment" value="결제"/>  
					<input type="button" id="shop_bag" value="장바구니"/>
					<input type="button" value="바로보기"/>
					
				</div>
			</div>

		</div>
	</form>


	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>


	<%@ include file="../include/footer.jsp"%>
</body>
</html>
