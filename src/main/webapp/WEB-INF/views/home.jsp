<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ page session="true"%>
<html>
<head>
<title>DAVA</title>
</head>
<body>
	<%
		String cp = request.getContextPath();
	%>
	<jsp:include page="include/header.jsp"></jsp:include>

<style>
.t_center{
	text-align: center;
}

.imgs_size{
	width: 110px;
	height: 160px;
}


</style>


	<div class="container"
		style="margin-top: 5px; background-color: silver;">

		<div class="row" style="margin-top: 20px;">
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img
					src="<%=cp%>/resources/imgs/Chrysanthemum.jpg"  >
				</a>
			</div>
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img
					src="<%=cp%>/resources/imgs/Chrysanthemum.jpg"  >
				</a>
			</div>
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img
					src="<%=cp%>/resources/imgs/Chrysanthemum.jpg"  >
				</a>
			</div>
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img
					src="<%=cp%>/resources/imgs/Chrysanthemum.jpg"  >
				</a>
			</div>
		</div>


		<div class="col-md-2"></div>
		<div class="row col-md-8">

			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- Indicators -->


				<!-- Wrapper for slides -->
				<div class="carousel-inner t_center" role="listbox">
					<div class="item active">
						<div class="row">
							<img src="<%=cp%>/resources/imgs/Chrysanthemum.jpg" class="imgs_size">
							&nbsp;&nbsp;&nbsp;&nbsp;
							<img src="<%=cp%>/resources/imgs/Chrysanthemum.jpg" class="imgs_size">&nbsp;&nbsp;&nbsp;&nbsp;
							<img src="<%=cp%>/resources/imgs/Chrysanthemum.jpg" class="imgs_size">
						</div>

					</div>
					<div class="item">
						<div class="row">
							<img src="<%=cp%>/resources/imgs/Chrysanthemum.jpg"  class="imgs_size">&nbsp;&nbsp;&nbsp;&nbsp;
							<img src="<%=cp%>/resources/imgs/Chrysanthemum.jpg" class="imgs_size" >&nbsp;&nbsp;&nbsp;&nbsp;
							<img src="<%=cp%>/resources/imgs/Chrysanthemum.jpg"  class="imgs_size">

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










	<jsp:include page="include/footer.jsp" flush="false"></jsp:include>

</body>
</html>
