<%@ page contentType="text/html; charset=UTF-8"%>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>

<html>
<head>
<title>Mypage</title>
</head>

<script>
	$(document).ready(function() {
		$("#view").click(function(){
			var title = $(this).title();
			$("#form"+title).submit();
			
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
<body>
	<%@ include file="../include/header.jsp"%>


	<div class="container" style="">
		<div class="row"
			style="text-align: center; border: solid 0.5px silver;">
			<h2>구매한 책</h2>
		</div>

		<div class="row" style="margin-top: 20px; border: solid 0.5px silver;">


			<c:forEach items="${list}" var="bookVO" varStatus="status">

				<hr />
				<div class="row">
					<div class="col-md-offset-1 col-md-5">
						<img src="/resources/covers/${bookVO.img}" class="imgs_size" />
						${bookVO.title}
					</div>
					<div class="col-md-offset-3 col-md-3 " style="padding-top: 5%">
						<form method="post" action="/readbook/read" id="form${mybooknum.get(status.count-1)}">
							<div class="col-xs-4">
								<input type="hidden" id="mybooknum"
									value="${mybooknum.get(status.count-1)}" /> 
									<a name="view" id="view" title="${mybooknum.get(status.count-1)}" >바로보기</a>
							</div>
						</form>
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
