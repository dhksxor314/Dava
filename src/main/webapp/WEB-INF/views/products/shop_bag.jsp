<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ page session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<%@ include file="../include/header.jsp"%>

<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>

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
	<div class="row" style="margin-top: 5px; border: solid 0.5px silver;">
		<div class="row" style="margin-top: 10px;">
			<div class="col-md-offset-1 col-md-11">
				<input type="checkbox">
				<button>선택상품 삭제</button>
			</div>

			
		</div>
		<div class="row">
			<div class="col-md-offset-1 col-md-5">
				<input type="checkbox"><img>이미지 이름
			</div>
			<div class="col-md-offset-3 col-md-3">
				<div class="col-xs-offset-4 col-xs-4">가격</div>
				<div class="col-xs-4">
					<a>X</a>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row" style="margin-top: 5px; border: solid 0.5px silver;">
		<div class="col-md-offset-10 col-md-2">
			<div class="row"> 총 결제 금액(x건)  :   xx원</div>
		</div>
	</div>
</div>







<script src="/resources/bootstrap/js/bootstrap.min.js"></script>

<%@ include file="../include/footer.jsp"%>