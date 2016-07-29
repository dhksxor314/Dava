
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ page session="true"%>
<%@ include file="include/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<html>
<head>
<title>DAVA</title>
<link rel="shortcut icon" type="image/x-icon"
	href="/resources/imgs/favicon.ico" />
</head>
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
<body>



	<div class="container" style="border: solid 0.5px silver;">
		<div class="row" style="text-align: center;">
			<h2>인기 도서</h2>
		</div>
		<div class="row" style="margin-top: 20px;">

			<c:forEach items="${list}" var="bookVO">

				<div class="col-xs-6 col-md-3 ">
					<a href="products/detail?booknum=${bookVO.booknum}"
						class="thumbnail"> <img src="/resources/covers/${bookVO.img}">
					</a>
				</div>

			</c:forEach>


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

					<c:forEach items="${newstlist}" var="BookVO" varStatus="status"
						begin="0" end="${newstlist.size()}">

						<c:if test="${status.count eq 1  || status.count % 3 eq 1}">
							<c:if test="${status.count eq 1}">
								<div class="item active">
							</c:if>
							<c:if test="${status.count != 1}">
								<div class="item">
							</c:if>
							<div class="row" style="margin-top: 15px; margin-bottom: 15px;">
						</c:if>
						<a href="products/detail?booknum=${BookVO.booknum}"> <img
							src="/resources/covers/${BookVO.img}" class="imgs_size">
						</a>


						<c:if
							test="${status.count % 3 eq 0 || status.count eq newstlist.size() }">
				</div>
			</div>
			</c:if>



			</c:forEach>



		</div>

		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>

	</div>
	</div>








	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>


	<%@ include file="include/footer.jsp"%>
</body>
</html>