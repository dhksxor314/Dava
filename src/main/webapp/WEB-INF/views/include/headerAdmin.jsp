<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
		<div class="row">


			<form class="form-inline pull-right" action="/admin/logout" method="post" id="logoutForm" name="logoutForm">
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<icon class="glyphicon glyphicon-star">Administrator</icon>
							
						</div>
						<input type="submit" value="로그아웃"/>
					</div>
				</div>
				
			</form>
		</div>
	</div>

</div>

<div class="container" style="background-color: #23b300;">
	<ul class="nav nav-pills col-md-9"
		style="text-align: center; margin-top: 4px; margin-bottom: -10px">
		<li role="presentation" class="col-md-2"><a href="/admin/listBook" style="color: #dfef00;">도서관리</a></li>
		<li role="presentation" class="col-md-2"><a href="/admin/listMember" style="color: #dfef00;">회원관리</a></li>
		<li role="presentation" class="col-md-2"><a href="/admin/listBuy" style="color: #dfef00;">결제관리</a></li>
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



