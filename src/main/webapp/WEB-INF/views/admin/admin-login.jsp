<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<!-- 
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
-->
	<%@include file="../include/header.jsp"%>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<!-- left column -->
			<div class="col-md-12">
				<!-- general form elements -->

				<div class="box">
					<div class="box-header with-border">
						<h3 class="box-title">
							<h1>관리자 페이지</h1>
						</h3>
					</div>
				</div>
			</div>
			<!--/.col (left) -->
		</div>
		<!-- /.row -->
	</section>
	<!-- /.content -->


	<%@include file="../include/footer.jsp"%>
</body>
</html>
