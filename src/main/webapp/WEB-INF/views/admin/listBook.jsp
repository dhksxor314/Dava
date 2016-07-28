<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@include file="../include/headerAdmin.jsp"%>

<script>
	$(document).ready(function() {

		//도서 삭제 버튼 동작
		$(".btn-danger").on("click", function() {
			var con = confirm("도서를 삭제하시겠습니까?");
			if (con == true) {
				$("#delBook").submit();
			}
		});

		//도서 등록
		$(".btn-primary").on("click", function() {
			$("#registBook").submit();
			alert("등록 완료");
			return "redirect:/admin/listBook";
		});
		
		//검색
		$("#search").on("click", function(){

			
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

				<div style="background-color: #23ff11" class="box">
					<div class="box-header with-border">
						<h3 align="center">도서 목록</h3>
						<div>
						<span style="float: right">
						
							<form name="serach" method="post">
							
								<select name="keyField">
									<option value="0">----선택----</option>
									<option value="booknum">책번호</option>
									<option value="title">제목</option>
									<option value="author">작가</option>
									<option value="price">가격</option>
									<option value="publisher">출판사</option>
									<option value="pub_date">출판일</option>
								</select>
								<input type="text" id="keyWord" name="keyWord" />
								<input type="button" value="검색" id="search" name="search"/>
							</form>
							
						</span>
								</div>
					</div>


					<!-- main 출력 부분  -->
					<div class="box-body">

						<form method="post" id="delBook" action="/admin/deleteBook">
							<table style="background-color: #bbffbb"
								class="table table-bordered">
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
											href='/admin/readBook?booknum=${bookVO.booknum}'>
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
					<div style="background-color: #ccccff" class="box-footer">번호목록
						및 페이지 이동</div>


					<!-- 도서등록 버튼 -->
					<div class="col-md-12">
						<span style="float: right">
							<button class="btn btn-danger">삭제</button>
							<button class="btn btn-default" data-target="#layerpop"
								data-toggle="modal">도서등록</button>
						</span>
					</div>
					<br/>
					<!-- 검색 -->
					<form action="/admin/search" id="searchForm" name="searchForm" method="post">
						<div id="searchDiv" class="col-md-12">
							<select id="keyfield" class="form-control" style="width: 100px;float:left">
								<option>제목</option>
								<option>작가</option>
								<option>출판사</option>
							</select>
							&nbsp;&nbsp;&nbsp;
							<input type="text" id="keyword" name="keyword" class="form-control" style="width: 300px;float:left"/>
							&nbsp;&nbsp;&nbsp;
							<input type="button" id="searchBtn" name="serachBtn" class="form-control" style="width:60px;float:left" value="검색"/>
						</div>
					</form>
					
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
													name="title" maxlength="25" class="form-control"/></td>
											</tr>
											
											<tr>
												<td>장 르</td>
												<td align="left"><input type="text" name="genre"
													id="genre" maxlength="15" class="form-control"/></td>
											</tr>

											<tr>
												<td>작 가</td>
												<td align="left"><input type="text" name="author"
													id="author" maxlength="30" class="form-control"/></td>
											</tr>
											
											<!-- 출판사 입력 필드-->
											<tr>
												<td>출판사</td>
												<td align="left"><input type="text" name="publisher"
													id="publisher" maxlength="15" class="form-control"/></td>
											</tr>

											<!-- 출판일 -->
											<tr>
												<td>출판일</td>
												<td><input type="date" name="pub_date" id="pub_date" class="form-control"/></td>
											</tr>

											<!-- 가격 필드 -->
											<tr>
												<td>가 격</td>
												<td align="left"><input type="number" name="price"
													id="price" maxlength="15" class="form-control"/></td>
											</tr>
											<!-- hwp 필드 -->
											<tr>
												<td>도서 파일</td>
												<td><input type="file" id="hwp" name="hwp" class="form-control"></td>
											</tr>
											<!-- img 필드 -->
											<tr>
												<td>표지 사진</td>
												<td><input type="file" id="img" name="img" class="form-control"></td>
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