<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/headerAdmin.jsp"%>

<script>
	$(document).ready(function(){
		
		//회원 삭제 버튼
		$(".btn-danger").on("click", function(){
			var con = confirm("회원을 삭제하시겠습니까?");
			if(con == true){
				$("#delMem").submit();
			}
		});
		
		//최상단 체크박스 클릭
	    $("#checkall").click(function(){
	        //클릭되었으면
	        if($("#checkall").prop("checked")){
	            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
	            $("input[name=chMember]").prop("checked",true);
	            //클릭이 안되있으면
	        }else{
	            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
	            $("input[name=chMember]").prop("checked",false);
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
					<h3 align="center" >회원 목록</h3>
								
						<!-- 검색 구현안됨 -->
							<form name="serachMember" method="post">
							
								<select name="keyField">
									<option value="0">----선택----</option>
									<option value="memnum">회원번호</option>
									<option value="id">회원ID</option>
									<option value="nickname">닉네임</option>
								</select>
								<input type="text" id="keyWordMember" name="keyWordMember" />
								<input type="button" value="검색" id="searchMember" name="searchMember"/>
							</form>
				</div>
				<div class="box-body">


			<!-- 메인 회원 출력 -->
				<form method="POST" id="delMem" action="/admin/deleteMember">
					<table class="table table-bordered">
						<tr align="center" style="font-size: 20;font-weight: bold;">
									<td width="5%"><input type="checkbox" id="checkall"/></td>
									<td width="10%">번호</td>
									<td width="30%">E-mail ID</td>
									<td width="15%">별명</td>
									<td width="50%">비밀번호</td>
						</tr>

						<c:forEach items="${Mlist}" var="memberVO">

							<tr>
								<td align="center"><input name="chMember" type="checkbox" value="${memberVO.memnum }"/></td>
								<td align="center">${memberVO.memnum}</td>
								<td align="center">${memberVO.id}</td>
								<td align="center">${memberVO.nickname}</td>
								<td align="center">${memberVO.password}</td>
							</tr>

						</c:forEach>

					</table>
				</form>
				
				
			<!-- 페이징  -->
				</div>
				<!-- /.box-body -->
				<div class="box-footer" style="background-color: silver">
					<div class="text-center">
						<ul class="pagination">

							<c:if test="${pageMaker.prev}">
								<li><a href="listMember${pageMaker.makeQuery(pageMaker.startPage - 1) }">&laquo;</a></li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }" var="idx">
								<li
									<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
									<a href="listMember${pageMaker.makeQuery(idx)}">${idx}</a>
								</li>
							</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a href="listMember${pageMaker.makeQuery(pageMaker.endPage + 1) }">&raquo;</a></li>
							</c:if>

						</ul>
					</div>
				</div>
		<!--/.col (left) -->
</div>
</div>
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
