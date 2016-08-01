<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>


<html>
<head>
<title>Mypage</title>
</head>

<script>
	$(document).ready(function() {
		
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
<body>
	<%@ include file="../include/header.jsp"%>

<div class="container" style="">
		<div class="row"
			style="text-align: center; border: solid 0.5px silver;">
			<h2>구매한 책</h2>
		</div>

		<div class="row" style="margin-top: 20px; border: solid 0.5px silver;">
			<div class="row">
					<div class="col-md-offset-2 col-md-4"  style="padding-top: 5%">
						구분
					</div>
					<div class="col-md-2 " style="padding-top: 5%">
						구입날짜
					</div>
					<div class="col-md-2 " style="padding-top: 5%">
						결제방법
					</div>
					<div class="col-md-2 " style="padding-top: 5%">
							  최종지불금액
					</div>
				</div>

			<c:forEach items="${buylist}" var="buylistVO" varStatus="status">

				<hr />
				<div class="row">
					<div class="col-md-offset-1 col-md-5">
						<img src="/resources/covers/${buylistVO.img}" class="imgs_size" />
						(${buylistVO.genre})${buylistVO.title}
					</div>
					<div class="col-md-2 " style="padding-top: 5%">
						<fmt:formatDate value="${buylistVO.buy_date}" pattern="YY.MM.dd"/>
					</div>
					<div class="col-md-2 " style="padding-top: 5%">
						   ${buylistVO.p_way}
					</div>
					<div class="col-md-2 " style="padding-top: 5%">
							${buylistVO.final_pay} 원
					</div>
				</div>

			</c:forEach>

			<hr>

		</div>

	</div>
	
	
	
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	<%@ include file="../include/footer.jsp"%>

</body>
</html>
