<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ page session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<%@ include file="../include/header.jsp"%>

<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>

<script>
	$(document).ready(function() {
		$("#total_payment").click(function(){
			
			var wsize = 770;
			var hsize = 550;
			window.open('total_payment','total_payment','width ='
					+ wsize+ ',height='+ hsize+ ',top='+ (screen.height - hsize)/ 2+ ', left='+ (screen.width - wsize)/ 2);

		});
		
	});
	

</script>

<style>
.imgs_size {
	margin-left: 10px;
	margin-right: 10px;
	padding-left: 5px;
	padding-right: 5px;
	height: 140px;
}
</style>




<div class="container" style="margin-top: 25px">
	<div class="row">
		나의 장바구니
		<아이디>님의 장바구니에 담긴 상품입니다. 
	</div>
	<div class="row">
		<div class="col-md-4" style="border: solid 0.5px silver;">
			<div class="col-xs-4">
				<h4>1.장바구니</h4>
			</div>
			<div class="col-xs-8">
				<h6>구입하실상품이 담겨있습니다.</h6>
			</div>
		</div>
		<div class="col-md-4" style="border: solid 0.5px silver;">
			<div class="col-xs-5">
				<h4>2.주문 및 결제</h4>
			</div>
			<div class="col-xs-7">
				<h6>구입하실 상품을 결제 해주세요</h6>
			</div>
		</div>
		<div class="col-md-4" style="border: solid 0.5px silver;">
			<div class="col-xs-5">
				<h4>3.결제 완료</h4>
			</div>
			<div class="col-xs-7">
				<h6>상품 결제가 완료되었습니다.</h6>
			</div>
		</div>
	</div>
	<div class="row" style="margin-top: 5px;  border: solid 0.5px silver;  padding-bottom: 15px">

		<c:set var="total_price" value="0" />
		<c:forEach items="${list}" var="bookVO">

			<hr />
			<input type="hidden" id="booknum_${total}" value="${bookVO.booknum}">
			<div class="row" >
				<div class="col-md-offset-1 col-md-5">
				<img src="/resources/covers/${bookVO.img}" class="imgs_size"> ${bookVO.title}
				</div>
				<div class="col-md-offset-3 col-md-3 " style="padding-top: 5%" >
					<div class="col-xs-offset-4 col-xs-4"><span style="color: green">${bookVO.price}</span> 원 </div>
					<div class="col-xs-4">
						<a href="shop_drop?booknum=${bookVO.booknum}&memnum=${memnum}">X</a>
					</div>
				</div>
			</div>
			<c:set var="total_price" value="${total_price + bookVO.price}" />
		</c:forEach>
	</div>



	<div class="row" style="margin-top: 5px; border: solid 0.5px silver;">
		<div class="col-md-offset-10 col-md-2" style="margin-top: 10px; margin-bottom: 10px;">
			<div class="row" >
				총 결제 금액( <label id="total">${total}</label>건) : <label
					id="total_price" style="color: green">${total_price}</label> 원
			</div>
			<div class="row"> <input type="button" id="total_payment" value="구매하기" class="col-xs-10 btn btn-success"/></div>
		</div>
	</div>
</div>




<script src="/resources/bootstrap/js/bootstrap.min.js"></script>

<%@ include file="../include/footer.jsp"%>