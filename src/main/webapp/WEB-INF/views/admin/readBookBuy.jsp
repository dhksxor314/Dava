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
		<div class="col-md-5">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">등록 도서 정보</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post">

					<input type='hidden' name='buynum' value="${buylistVO.buynum}">
					<input type='hidden' name='page' value="${cri.page}">
					<input type='hidden' name='perPageNum' value="${cri.perPageNum}">

				</form>

				<div class="box-body">
				
					<div class="form-group">
						<label for="exampleInputEmail1">도서번호</label> <input type="text"
							name='booknum' class="form-control" value="${bookVO.booknum}"
							readonly="readonly">
					</div>
					
					<div class="form-group">
						<label for="exampleInputPassword1">-장르-</label> <input type="text"
							class="form-control" name="genre" readonly="readonly"
							value="${bookVO.genre}" />
					</div>
					
					<div class="form-group">
						<label for="exampleInputEmail1">도서제목</label> <input type="text"
							name='title' class="form-control" value="${bookVO.title}"
							readonly="readonly" />
					</div>
					
					<div class="form-group">
						<label for="exampleInputPassword1">-작가-</label> <input type="text"
							class="form-control" name="author" readonly="readonly"
							value="${bookVO.author}" />
					</div>
					
					<div class="form-group">
						<label for="exampleInputEmail1">출 판 사</label> <input type="text"
							name="publisher" class="form-control" value="${bookVO.publisher}"
							readonly="readonly">
					</div>
					
					<div class="form-group">
						<label for="exampleInputPassword1">출 판 일</label> <input
							type="text" class="form-control" name="pub_date"
							readonly="readonly" value="${bookVO.pub_date}" />
					</div>
					
					<div class="form-group">
						<label for="exampleInputPassword1">도서가격</label> <input type="text"
							class="form-control" name="price" readonly="readonly"
							value="${bookVO.price}" />
					</div>
					
					<div class="form-group">
						<label for="exampleInputPassword1">img</label> <input type="text"
							class="form-control" name="img" readonly="readonly"
							value="${bookVO.img}" />
					</div>
					
					<div class="form-group">
						<label for="exampleInputPassword1">summary</label>
						<textarea class="form-control" name="summary" rows="3"
							readonly="readonly">${bookVO.summary}</textarea>
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
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>
