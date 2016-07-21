<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String cp = request.getContextPath();
%>

<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>

<!-- <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script> -->




<script>
	$(document).ready(function() {

		$("li[role='presentation']").click(function(event) {
			$("li[role='presentation']").removeClass("active");
			$(this).attr('class', 'active col-md-2');
		});

		$("#login").click(function() {
			
			alert("로그인처리");
			$("#loginForm").submit();

		});

		$("#logout").click(function() {

			alert("로그아웃")

			alert("세션지우기 들어갈곳");

		});

		$("#mypage").click(function() {

			alert("마이페이지")
			alert("페이지 이동 들어갈곳")

		});

	});
</script>



<link href="<%=cp%>/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">


<div class="container" style="margin-top: 50px">
	<div class="col-md-3 ">
		<a href="/"><img src="<%=cp%>/resources/imgs/logo.png" width="80%"></a>
	</div>
	<!-- 로그인-->
	<c:if test="${param.id eq null}">
		<!-- param.id 대신 세션 -->
		<div class="col-md-6 col-md-offset-3">
			<div class="row">

				<form class="form-inline" id="loginForm" name="loginForm" action="/">
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<icon class="glyphicon glyphicon-user" />
							</div>
							<input type="email" class="form-control" name="id"
								placeholder="Enter email">
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<icon class="glyphicon glyphicon-sunglasses" />
							</div>
							<input type="password" class="form-control" name="password"
								placeholder="Password">
						</div>
					</div>
					<button type="submit" class="btn btn-default" id="login">Sign
						in</button>
				</form>
			</div>
			<div class="row" style="text-align: right;">

				<a href="#">회원가입</a><a href="#" class="col-md-offset-1"
					style="margin-right: 30px;">아이디 / 비밀번호 찾기</a>
			</div>
		</div>
	</c:if>
	<!-- 로그아웃-->
	<c:if test="${param.id != null}">
		<!-- param.id 대신 세션 -->
		<div class="col-md-6 col-md-offset-3">
			<div class="row" style="text-align: right;">

				<div class="col-xs-offset-6 col-xs-2" >
					<img src="<%=cp%>/resources/imgs/login.png" class="img-circle"
						style="width: 50px; height: 50px">
				</div>
				<div class="col-xs-4" style="text-align:left;">
					<div class="row" style="margin-top: 5px">${param.id}</div>
					<div class="row" style="margin-top: 5px">
						<a href="" id="mypage">me</a> | <a id="logout" href="">로그아웃</a>
					</div>
				</div>

			</div>

		</div>
	</c:if>







</div>

<div class="container" style="background-color: #23b300;">
	<ul class="nav nav-pills col-md-9"
		style="text-align: center; margin-top: 4px; margin-bottom: -10px">
		<li role="presentation" class="col-md-2"><a href="#"
			style="color: #dfef00;">무협</a></li>
		<li role="presentation" class="col-md-2"><a href="#"
			style="color: #dfef00;">판타지</a></li>
		<li role="presentation" class="col-md-2"><a href="#"
			style="color: #dfef00;">소설</a></li>
		<li role="presentation" class="col-md-2"><a href="#"
			style="color: #dfef00;">기타</a></li>
	</ul>

	<div class="form-group col-md-3" style="text-align: right;">
		<div class="input-group" style="margin-top: 8px; margin-bottom: -10px">
			<input type="text" class="form-control">
			<div class="input-group-addon">
				<icon class="glyphicon glyphicon-search" />
			</div>
		</div>
	</div>

</div>



