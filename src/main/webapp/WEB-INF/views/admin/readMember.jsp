<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="../include/headerAdmin.jsp"%>


<!-- 결제 목록에서 사용 -->

<script>
	$(document).ready(function() {

		var formObj = $("form[role='form']");

		console.log(formObj);

		//목록으로 돌아가기
		$(".btn-primary").on("click", function() {
			//self.location = "/admin/listBuy";
			formObj.attr("method", "get");
			formObj.attr("action", "/admin/listBuy");
			formObj.submit();
		});

	});
</script>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-4"></div>
		<div class="col-md-3">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">등록 회원 정보</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post">

					<input type='hidden' name='memnum' value="${memberVO.memnum}">
					<input type='hidden' name='page' value="${cri.page}">
					<input type='hidden' name='perPageNum' value="${cri.perPageNum}">

				</form>

				<div class="box-body">
				
					<div class="form-group">
						<label for="exampleInputEmail1">회원번호</label> <input type="text"
							name='memnum' class="form-control" value="${memberVO.memnum}"
							readonly="readonly">
					</div>
					
					<div class="form-group">
						<label for="exampleInputPassword1">아 이 디</label> <input type="text"
							class="form-control" name="id" readonly="readonly"
							value="${memberVO.id}" />
					</div>
					
					<div class="form-group">
						<label for="exampleInputEmail1">닉 네 임</label> <input type="text"
							name='nickname' class="form-control" value="${memberVO.nickname}"
							readonly="readonly" />
					</div>
					
					<div class="form-group">
						<label for="exampleInputPassword1">POINT</label> <input
							type="text" class="form-control" name="point" readonly="readonly"
							value="${memberVO.point}" />
					</div>
					
				</div>
				<!-- /.box-body -->

				<div class="box-footer">
					<button type="submit" class="btn btn-primary">확인</button>
				</div>

			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>
