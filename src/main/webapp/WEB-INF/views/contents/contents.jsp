
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ page session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>

<html>
<head>
<title>contents</title>
</head>

<script>
	$(document).ready(function() {
		var get='${get}'
		if(get != "get"){
			$("#more").focus();
		}
		
		$("#more").click(function() {

			$("#form").submit();

		});
	});
</script>

<body>
	<form id="form" e method="post" action="/contents/contents">
		<input type="hidden" name="contents" value="${choise}" /> <input
			type="hidden" name="limit" value="${limit}" />
	</form>
	<%@ include file="../include/header.jsp"%>
	<div class="container" style="border: solid 0.5px silver;">
		<div class="row" style="text-align: center;">
			<h2><c:if test="${contents eq ''}">
				전체보기
			</c:if>
			<c:if test="${contents != ''}">
				${contents}
			</c:if>
			</h2>
		</div>
		<div class="row" style="margin-top: 20px;" id="table">
			<c:set var="doneLoop" value="false" />
			<c:forEach items="${list}" var="bookVO" begin="1" varStatus="status">
				<c:if test="${not doneLoop}">
					<div class="col-xs-6 col-md-3">
						<a href="/products/detail?booknum=${bookVO.booknum}"
							class="thumbnail"> <img src="/resources/imgs/${bookVO.img}">
						</a>
					</div>
				</c:if>
				<c:if test="${status.count eq limit}">
					<c:set var="doneLoop" value="true"></c:set>
				</c:if>
			</c:forEach>


		</div>
		<div class="row">
			<input type="button" value="더보기" id="more" name="more"
				class="col-xs-12" style="background-color: white;" />
		</div>
	</div>



	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>


	<%@ include file="../include/footer.jsp"%>
</body>
</html>
