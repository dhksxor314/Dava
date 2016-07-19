
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>


<html>
<head>
<title>DAVA</title>
</head>
<body>

	<%@ include file="include/header.jsp" %>

	<style>
.t_center {
	text-align: center;
}

.imgs_size {

	margin-left: 10px;
	margin-right: 10px;
	padding-left: 5px;
	padding-right: 5px;
	width: 110px;
	height: 140px;
}
</style>


	<div class="container"
		style="margin-top: 5px; border: solid 0.5px silver;">
		<div class="row" style="text-align: center;">
			<h2>인기 도서</h2>
		</div>
		<div class="row" style="margin-top: 20px;">
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img
					src="<%=cp%>/resources/imgs/Chrysanthemum.jpg">
				</a>
			</div>
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img
					src="<%=cp%>/resources/imgs/Chrysanthemum.jpg">
				</a>
			</div>
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img
					src="<%=cp%>/resources/imgs/Chrysanthemum.jpg">
				</a>
			</div>
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img
					src="<%=cp%>/resources/imgs/Chrysanthemum.jpg">
				</a>
			</div>
		</div>
		<div class="row" style="margin-top: 20px;">
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img
					src="<%=cp%>/resources/imgs/Chrysanthemum.jpg">
				</a>
			</div>
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img
					src="<%=cp%>/resources/imgs/Chrysanthemum.jpg">
				</a>
			</div>
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img
					src="<%=cp%>/resources/imgs/Chrysanthemum.jpg">
				</a>
			</div>
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img
					src="<%=cp%>/resources/imgs/Chrysanthemum.jpg">
				</a>
			</div>
		</div>
	</div>
	<div class="container"
		style="margin-top: 5px; border: solid 0.5px silver; padding-bottom: 30px;">
				<div class="row" style="text-align: center;">
				<h2>최신 도서</h2>
			</div>
		<div class="col-md-2"></div>
		<div class="row col-md-8">
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- Indicators -->


				<!-- Wrapper for slides -->
				<div class="carousel-inner t_center" role="listbox">
					<div class="item active">
						<div class="row" style="margin-top: 15px;margin-bottom: 15px;">
							<img src="<%=cp%>/resources/imgs/Chrysanthemum.jpg"
								class="imgs_size"> <img
								src="<%=cp%>/resources/imgs/Chrysanthemum.jpg" class="imgs_size">
							<img src="<%=cp%>/resources/imgs/Chrysanthemum.jpg"
								class="imgs_size">
						</div>

					</div>
					<div class="item">
						<div class="row">
							<img src="<%=cp%>/resources/imgs/Chrysanthemum.jpg"
								class="imgs_size"> <img
								src="<%=cp%>/resources/imgs/Chrysanthemum.jpg" class="imgs_size">
							<img src="<%=cp%>/resources/imgs/Chrysanthemum.jpg"
								class="imgs_size">

						</div>
					</div>

				</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>

		</div>
	</div>








<script src="<%=cp%>/resources/bootstrap/js/bootstrap.min.js"></script>


	<%@ include file="include/footer.jsp" %>
</body>
</html>
