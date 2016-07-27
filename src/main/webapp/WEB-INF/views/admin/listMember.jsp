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

			<div style="background-color: #23ff11" class="box">
				<div class="box-header with-border">
					<h3 align="center" >회원 목록</h3>
					<span style="float: right">
					
					
						<!-- 검색 구현안됨 -->
							<div class="dropdown">
								<button id="dLabel" type="button" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false">
									검색옵션 <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
									<li>회원번호</li>
									<li>ID</li>
									<li>별명</li>
								</ul>
							</div> <input type="text" id="search" /> <input type="button"
							value="검색" />
						</span>
				</div>
				<div class="box-body">


			<!-- 메인 회원 출력 -->
				<form method="POST" id="delMem" action="/admin/deleteMember">
					<table style="background-color: #bbffbb" class="table table-bordered">
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
				<div style="background-color: #ccccff" class="box-footer">번호 목록 및 페이지 이동</div>
				<span style="float: right">
					<button class="btn btn-danger">회원삭제</button>
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