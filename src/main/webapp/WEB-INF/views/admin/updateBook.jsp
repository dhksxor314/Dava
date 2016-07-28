<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../include/headerAdmin.jsp"%>

<script>
	$(document).ready(function() {

		var formObj = $("form[role='form']");

		console.log(formObj);

		//취소 버튼
		$(".btn-warning").on("click", function() {
			self.location = "/admin/listBook";
		});

		//수정 저장 버튼
		$(".btn-primary").on("click", function() {
			formObj.submit();
		});

	});
</script>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-9">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">등록 도서 수정</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post">
					<div class="box-body">
					
						<div class="form-group">
							<label for="exampleInputEmail1">도서번호</label> <input type="text"
								name='booknum' class="form-control" value="${bookVO.booknum}"
								readonly="readonly">
						</div>
						
						<div class="form-group">
							<label for="exampleInputPassword1">장 르</label> <input type="text"
								class="form-control" name="genre" value="${bookVO.genre}" />
						</div>
						
						<div class="form-group">
							<label for="exampleInputEmail1">도서제목</label> <input type="text"
								name='title' class="form-control" value="${bookVO.title}" />
						</div>
						
						<div class="form-group">
							<label for="exampleInputPassword1">작 가</label> <input type="text"
								class="form-control" name="author" value="${bookVO.author}" />
						</div>
						
						<div class="form-group">
							<label for="exampleInputEmail1">출 판 사</label> <input type="text"
								name="publisher" class="form-control"
								value="${bookVO.publisher}" />
						</div>
						
						<div class="form-group">
							<label for="exampleInputPassword1">출 판 일</label> <input
								type="date" class="form-control" name="pub_date" value="${bookVO.pub_date}" />
						</div>
						
						<div class="form-group">
							<label for="exampleInputPassword1">도서가격</label> <input
								type="text" class="form-control" name="price"
								value="${bookVO.price}" />
						</div>
						
						<div class="form-group">
							<label for="exampleInputPassword1">img</label> <input type="text"
								class="form-control" name="img" value="${bookVO.img}" />
						</div>
						
						<div class="form-group">
							<label for="exampleInputPassword1">summary</label>
							<textarea class="form-control" name="summary" rows="3">${bookVO.summary}</textarea>
						</div>
						
					</div>
					<!-- /.box-body -->
				</form>


				<div class="box-footer">
					<button type="submit" class="btn btn-primary">SAVE</button>
					<button type="submit" class="btn btn-warning">CANCEL</button>
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
