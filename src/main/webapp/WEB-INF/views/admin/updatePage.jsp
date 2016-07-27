<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">등록 도서 수정</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" action="updatePage" method="post">

					<input type='hidden' name='page' value="${cri.page}"> <input
						type='hidden' name='perPageNum' value="${cri.perPageNum}">

					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">도서번호</label> <input type="text"
								name='booknum' class="form-control" value="${bookVO.booknum}" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Title</label> <input type="text"
								name='title' class="form-control" value="${bookVO.title}">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">author</label>
							<textarea class="form-control" name="author" rows="3">${bookVO.author}</textarea>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">publisher</label> <input type="text"
								name="publisher" class="form-control" value="${bookVO.publisher}">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">pub_date</label>
							<textarea class="form-control" name="pub_date" rows="3">${bookVO.pub_date}</textarea>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">price</label>
							<textarea class="form-control" name="price" rows="3">${bookVO.price}</textarea>
						</div>
					</div>
					<!-- /.box-body -->
				</form>
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">SAVE</button>
					<button type="submit" class="btn btn-warning">CANCEL</button>
				</div>

				<script>
					$(document).ready(function() {
						var formObj = $("form[role='form']");
						console.log(formObj);

						$(".btn-warning").on("click", function() {
							self.location = "/admin/listPage?page=${cri.page}&perPageNum=${cri.perPageNum}";
						});

						$(".btn-primary").on("click", function() {
							formObj.submit();
						});
					});
				</script>
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
