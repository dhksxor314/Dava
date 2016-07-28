<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/headerAdmin.jsp"%>
<
<script type="text/javascript">
	$(document).ready(function() {
		//환불처리 버튼
		$(".btn-danger").on("click", function() {
			var con = confirm("환불처리 하시겠습니까?");
			if (con == true) {
				$("#delBuy").submit();
			}
		});
		
		//최상단 체크박스 클릭
	    $("#checkall").click(function(){
	        //클릭되었으면
	        if($("#checkall").prop("checked")){
	            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
	            $("input[name=chBuy]").prop("checked",true);
	            //클릭이 안되있으면
	        }else{
	            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
	            $("input[name=chBuy]").prop("checked",false);
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
						<h3 align="center">결제 내역</h3>
						<div>
						<span style="float: right">
						
						<!-- 검색  -->
							<form name="serachBuy" method="post">
							
								<select name="keyField">
									<option value="0">----선택----</option>
									<option value="buynum">결제번호</option>
									<option value="memnum">회원번호</option>
									<option value="title">제 목</option>
									<option value="booknum">도서번호</option>
									<option value="buydate">결제날짜</option>
								</select>
								<input type="text" id="keyWordBuy" name="keyWordBuy" />
								<input type="button" value="검색" id="searchBuy" name="searchBuy"/>
							</form>
						</span>
					</div>
				</div>
					
					
				<!-- 메인 결제 목록 출력 -->
					<div class="box-body">

						<form method="POST" id="delBuy" action="/admin/deleteBuy">
							<table class="table table-bordered">
								<tr align="center" style="font-size: 20; font-weight: bold;">
									<td width="5%"><input type="checkbox" id="checkall"/></td>
									<td width="10%">구매 번호</td>
									<td width="15%">회원 번호</td>
									<td width="20%">도서 번호</td>
									<td width="20%">구매일</td>
								</tr>

								<c:forEach items="${Buylist}" var="BuyVO">
								

									<tr>
										<td align="center"><input name="chBuy" type="checkbox"
											value="${BuyVO.buynum }" /></td>
										<td align="center">${BuyVO.buynum}</td>
										<td align="center"><a
											href='/admin/readMember?memnum=${BuyVO.memnum}'>
												${BuyVO.memnum}</a></td>
										<td align="center"><a
											href='/admin/readBookBuy?booknum=${BuyVO.booknum}'>
												${BuyVO.booknum}</a></td>
										<td align="center">${BuyVO.buydate}</td>
									</tr>

								</c:forEach>

							</table>
						</form>

					</div>
					<!-- /.box-body -->
					
				<!-- paging 처리 -->
					<div style="background-color: #ccccff" class="box-footer">번호
						목록 및 페이지 이동</div>
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
