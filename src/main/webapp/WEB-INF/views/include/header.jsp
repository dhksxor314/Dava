<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script> -->
<script>
	$(document).ready(function() {

		$("li[role='presentation']").click(function(event) {
			$("li[role='presentation']").removeClass("active");
			$(this).attr('class', 'active col-md-2');
		});

	});
</script>



<%
	String cp = request.getContextPath();
%>

<link href="<%=cp%>/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">


<div class="container" style="margin-top: 50px">
	<div class="col-md-3 " style="background-color: black;">로고</div>

	<div class="col-md-6 col-md-offset-3">
		<div class="row">


			<form class="form-inline">
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<icon class="glyphicon glyphicon-user" />
						</div>
						<input type="email" class="form-control" id="exampleInputEmail3"
							placeholder="Enter email">
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<icon class="glyphicon glyphicon-sunglasses" />
						</div>
						<input type="password" class="form-control"
							id="exampleInputPassword3" placeholder="Password">
					</div>
				</div>
				<button type="submit" class="btn btn-default">Sign in</button>
			</form>
		</div>
		<div class="row" style="text-align: right;">


			<a href="#">회원가입</a><a href="#" class="col-md-offset-1"
				style="margin-right: 30px;">아이디 / 비밀번호 찾기</a>
		</div>
	</div>

</div>

<div class="container" style="background-color: lime; ">
		<ul class="nav nav-pills col-md-9" style="text-align: center; margin-top: 4px;margin-bottom: -10px "> 
			<li role="presentation"  class="col-md-2"><a href="#">무협</a></li>
			<li role="presentation"  class="col-md-2"><a href="#">판타지</a></li>
			<li role="presentation"  class="col-md-2"><a href="#">소설</a></li>
			<li role="presentation"  class="col-md-2"><a href="#">기타</a></li>
		</ul>


		<div class="form-group col-md-3" style="text-align: right;" >
			<div class="input-group" style="margin-top: 8px;margin-bottom: -10px">
				<input type="text" class="form-control">
				<div class="input-group-addon">
					<icon class="glyphicon glyphicon-search" />
				</div>
			</div>
		</div>

</div>



<script src="http://code.jquery.com/jquery-2.1.1.min.js"
	type="text/javascript"></script>
<script src="<%=cp%>/resources/bootstrap/js/bootstrap.min.js"></script>