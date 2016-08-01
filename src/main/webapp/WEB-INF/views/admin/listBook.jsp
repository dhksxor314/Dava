<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@include file="../include/headerAdmin.jsp"%>

<script>
	var img = /(\.gif|\.png|\.jpg|\.jpeg)$/i;//이미지 파일 형식만 가능
	var hwp = /(\.hwp)$/i;
	$(document).ready(
			function() {

				//도서 삭제 버튼 동작
				$(".btn-danger").on("click", function() {
					var con = confirm("도서를 삭제하시겠습니까?");
					if (con == true) {
						$("#delBook").submit();
					}
				});

				//도서 등록
				$(".btn-primary").on("click", function() {
					//이미지 파일 형식 검사
					if (!img.test($("#img").val())) {
						alert("표지사진이 이미지 형식의 파일이 아닙니다.");
						return false;
					}
					//한글 파일 형식 검사
					if (!hwp.test($("#hwp").val())) {
						alert("도서파일이 hwp확장자 파일이 아닙니다.");
						return false;
					}
					$("#registBook").submit();
					alert("등록 완료");
					return "redirect:/admin/listBook";
				});

				//검색
				$("#searchBtn").on(
						
						"click",
						function(event) {
							self.location = "listBook"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keyword').val();
						});

				//최상단 체크박스 클릭 < 전체 checkBox >
				$("#checkall").click(function() {
					//클릭되었으면
					if ($("#checkall").prop("checked")) {
						//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
						$("input[name=chBook]").prop("checked", true);
						//클릭이 안되있으면
					} else {
						//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
						$("input[name=chBook]").prop("checked", false);
					}
				});
			});
</script>

<div class="container">

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<!-- left column -->
			<div class="col-md-2"></div>
			<div class="col-md-9">
				<!-- general form elements -->

				<div class="box">
					<div class="box-header with-border">
						<h3 align="center">도서 목록</h3>
					</div>


					<!-- main 출력 부분  -->
					<div class="box-body">

						<!-- 검색 -->
							<select name="searchType">
								<option value="n"
									<c:out value="${cri.searchType == null?'selected':''}"/>>
										-선택-</option>
									<option value="title"
									<c:out value="${cri.searchType eq 'title'?'selected':''}"/>>
										책제목</option>
									<option value="author"
										<c:out value="${cri.searchType eq 'author'?'selected':''}"/>>
										작 가</option>
									<option value="publisher"
										<c:out value="${cri.searchType eq 'publisher'?'selected':''}"/>>
										출판사</option>
							</select>
									<input type="text" id="keyword" name="keyword" value="${cri.keyword }" />
									<button id="searchBtn">검색</button>


						<form method="post" id="delBook" action="/admin/deleteBook">
							<table class="table table-bordered">
								<tr align="center" style="font-size: 20; font-weight: bold;">
									<td width="5%"><input type="checkbox" id="checkall" /></td>
									<td width="10%">번호</td>
									<td width="20%">제목</td>
									<td width="10%">작가</td>
									<td width="10%">가격</td>
									<td width="15%">SAL</td>
									<td width="15%">출판사</td>
									<td width="15%">출판일</td>
								</tr>

								<c:forEach items="${Blist}" var="bookVO">

									<tr>
										<td align="center"><input type="checkbox" name="chBook"
											value="${bookVO.booknum}" /></td>
										<td align="center">${bookVO.booknum}</td>
										<td align="center"><a
											href='/admin/readBook${pageMaker.makeSearch(pageMaker.cri.page)
											}&booknum=${bookVO.booknum}'>
												${bookVO.title}</a></td>
										<td align="center">${bookVO.author}</td>
										<td align="center">${bookVO.price}</td>
										<td align="center">${bookVO.sal}</td>
										<td align="center">${bookVO.publisher}</td>
										<td align="center">${bookVO.pub_date}</td>
									</tr>

								</c:forEach>
							</table>
						</form>
					</div>


					<!-- 페이징 부분 -->
					<!-- /.box-body -->
					<div style="background-color: #23b300" class="box-footer">
						<div class="text-center">
							<ul class="pagination">

								<c:if test="${pageMaker.prev}">
									<li><a
										href="listBook${pageMaker.makeSearch(pageMaker.startPage -1) }">&laquo;</a></li>
								</c:if>

								<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
									<li
										<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
										<a href="listBook${pageMaker.makeSearch(idx)}">${idx}</a>
									</li>
								</c:forEach>

								<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
									<li><a
										href="listBook${pageMaker.makeSearch(pageMaker.endPage + 1) }">&raquo;</a></li>
								</c:if>

							</ul>
						</div>
					</div>


					<!-- 도서등록 버튼 -->
					<div class="col-md-12">
						<span style="float: right">
							<button class="btn btn-danger">삭제</button>
							<button class="btn btn-default" data-target="#layerpop"
								data-toggle="modal">도서등록</button>
						</span>
					</div>
					<br />


					<!-- 도서 등록 modal -->
					<div class="modal fade" id="layerpop">
						<div class="modal-dialog">
							<div class="modal-content">
								<!-- header -->
								<div align="center" class="modal-header">
									<!-- 닫기(x) 버튼 -->
									<button type="button" class="close" data-dismiss="modal">×</button>
									<!-- header title -->
									<h4 class="modal-title">신규 도서 등록</h4>
								</div>
								<!-- body -->
								<div class="modal-body">

									<form method="post" id="registBook" name="registBook"
										action="/admin/registBook" enctype="multipart/form-data">
										<table style="width: 550px;">
											<!-- 도서정보 입력 필드 -->

											<tr>
												<td>제 목</td>
												<td align="left"><input type="text" id="title"
													name="title" maxlength="25" class="form-control" /></td>
											</tr>

											<tr>
												<td>장 르</td>
												<td align="left"><input type="text" name="genre"
													id="genre" maxlength="15" class="form-control" /></td>
											</tr>

											<tr>
												<td>작 가</td>
												<td align="left"><input type="text" name="author"
													id="author" maxlength="30" class="form-control" /></td>
											</tr>

											<!-- 출판사 입력 필드-->
											<tr>
												<td>출판사</td>
												<td align="left"><input type="text" name="publisher"
													id="publisher" maxlength="15" class="form-control" /></td>
											</tr>

											<!-- 출판일 -->
											<tr>
												<td>출판일</td>
												<td><input type="date" name="pub_date" id="pub_date"
													class="form-control" /></td>
											</tr>

											<!-- 가격 필드 -->
											<tr>
												<td>가 격</td>
												<td align="left"><input type="number" name="price"
													id="price" maxlength="15" class="form-control" /></td>
											</tr>
											<!-- hwp 필드 -->
											<tr>
												<td>도서 파일</td>
												<td><input type="file" id="hwp" name="hwp"
													class="form-control"></td>
											</tr>
											<!-- img 필드 -->
											<tr>
												<td>표지 사진</td>
												<td><input type="file" id="img" name="img"
													class="form-control"></td>
											</tr>

											<!-- summary 필드 -->
											<tr>
												<td>요약정보</td>
												<td align="left"><textarea name="summary" id="summary"
														maxlength="50" class="form-control"></textarea>
											</tr>

										</table>
									</form>
								</div>
								<!-- Footer -->
								<div class="modal-footer">
									<button class="btn btn-default" data-dismiss="modal">닫기</button>
									<button class="btn btn-primary">등록</button>
								</div>
							</div>
						</div>
					</div>
					<!-- 등록 modal 끝 -->


					<!-- /.box-footer-->
				</div>
			</div>
			<!--/.col (left) -->

		</div>
		<!-- /.row -->
	</section>
</div>
<!-- /.content -->
<!-- /.content-wrapper -->

<script>
	var result = '${msg}';

	if (result == 'SUCCESE') {
		alert("처리가 완료되었습니다.");
	}
</script>

<%@include file="../include/footer.jsp"%>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<div class="modal-footer"></div>