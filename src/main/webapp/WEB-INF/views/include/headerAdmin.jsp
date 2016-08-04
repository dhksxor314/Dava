<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String cp = request.getContextPath();
%>

<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>

<script>
	$(document).ready(function() {
		$("li[role='presentation']").click(function(event) {
			$("li[role='presentation']").removeClass("active");
			$(this).attr('class', 'active col-md-2');
		});

	});
</script>



<link href="<%=cp%>/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">


<div class="container" style="margin-top: 50px">
	<div class="col-md-3 ">
		<a href="/"><img src="/resources/imgs/logo.png" width="80%"></a>
	</div>

				<div class="col-md-6 col-md-offset-3">

				<div class="col-xs-offset-6 col-xs-2">
					<img src="/resources/imgs/login.png" class="img-circle"
						style="width: 50px; height: 50px">
				</div>
				<div class="col-xs-4" style="text-align: left;">
					<div class="row" style="margin-top: 5px">관리자</div>
					<div class="row" style="margin-top: 5px">
							<a href="/admin/listBook">관리자페이지</a> | <a id="logout" href="/logout">로그아웃</a><br/>
							
					</div>
				</div>


		</div>
		</div>

<div class="container" style="background-color: #23b300;">
	<ul class="nav nav-pills col-md-9"
		style="text-align: center; margin-top: 4px; margin-bottom: -10px">
		<li role="presentation" class="col-md-2"><a href="/admin/listBook" style="color: #dfef00;">도서관리</a></li>
		<li role="presentation" class="col-md-2"><a href="/admin/listMember" style="color: #dfef00;">회원관리</a></li>
		<li role="presentation" class="col-md-2"><a href="/admin/listBuy" style="color: #dfef00;">결제내역</a></li>
	</ul>

</div>



