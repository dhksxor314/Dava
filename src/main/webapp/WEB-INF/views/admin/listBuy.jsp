<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/headerAdmin.jsp"%>

<script type="text/javascript">
	$(document).ready(
			function() {
				//환불처리 버튼
				$(".btn-danger").on("click", function() {
					var con = confirm("환불처리 하시겠습니까?");
					if (con == true) {
						$("#delBuy").submit();
					}
				});

				//검색
				$("#searchBtn").on(

						"click",
						function(event) {
							self.location = "listBuy"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keyword').val();
						});

				//최상단 체크박스 클릭
				$("#checkall").click(function() {
					//클릭되었으면
					if ($("#checkall").prop("checked")) {
						//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
						$("input[name=chBuy]").prop("checked", true);
						//클릭이 안되있으면
					} else {
						//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
						$("input[name=chBuy]").prop("checked", false);
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
						<h1 align="center">결제 내역</h1>
					</div>


					<!-- 메인 결제 목록 출력 -->
					<div class="box-body">

						<!-- 검색 -->
						<select name="searchType">
							<option value="n"
								<c:out value="${cri.searchType == null?'selected':''}"/>>
								전체보기</option>
							<option value="buynum"
								<c:out value="${cri.searchType eq 'buynum'?'selected':''}"/>>
								결제번호</option>
							<option value="memnum"
								<c:out value="${cri.searchType eq 'memnum'?'selected':''}"/>>
								회원번호</option>
							<option value="title"
								<c:out value="${cri.searchType eq 'title'?'selected':''}"/>>
								도서제목</option>
						</select> <input type="text" id="keyword" name="keyword"
							value="${cri.keyword }" />
						<button id="searchBtn">검색</button>

						<form method="POST" id="delBuy" action="/admin/deleteBuy">
							<table class="table table-bordered">
								<tr align="center" style="font-size: 20; font-weight: bold;">
									<td width="5%"><input type="checkbox" id="checkall" /></td>
									<td width="20%">결제번호</td>
									<td width="20%">회원번호</td>
									<td width="35%">도서제목</td>
									<td width="20%">구 매 일</td>
								</tr>

								<c:forEach items="${Buylist}" var="BuylistVO">
									<tr>
										<td align="center"><input name="chBuy" type="checkbox"
											value="${BuylistVO.buynum }" /></td>
										<td align="center">${BuylistVO.buynum}</td>
										<td align="center"><a
											href='/admin/readMember${pageMaker.makeSearch(pageMaker.cri.page)
											}&memnum=${BuylistVO.memnum}'>
												${BuylistVO.memnum}</a></td>
										<td align="center"><a
											href='/admin/readBookBuy${pageMaker.makeSearch(pageMaker.cri.page)
											}&title=${BuylistVO.title}'>
												${BuylistVO.title}</a></td>
										<td align="center"><fmt:formatDate pattern="yyyy-MM-dd"
												value="${BuylistVO.buy_date}" /></td>
									</tr>
								</c:forEach>

							</table>
						</form>

					</div>
					<!-- 페이징 부분 -->
					<!-- /.box-body -->
					<div class="box-footer">
						<div class="text-center">
							<ul class="pagination">

								<c:if test="${pageMaker.prev}">
									<li><a
										href="listBuy${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
								</c:if>

								<c:forEach begin="${pageMaker.startPage }"
									end="${pageMaker.endPage }" var="idx">
									<li
										<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
										<a href="listBuy${pageMaker.makeSearch(idx)}">${idx}</a>
									</li>
								</c:forEach>

								<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
									<li><a
										href="listBuy${pageMaker.makeSearch(pageMaker.endPage + 1) }">&raquo;</a></li>
								</c:if>

							</ul>
						</div>
					</div>

					<span style="float: right">
						<button class="btn btn-danger">환불처리</button>
					</span>
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
