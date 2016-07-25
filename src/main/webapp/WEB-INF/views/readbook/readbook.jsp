


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<!doctype html>
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/resources/turn/turn.js"></script>
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<style>

#flipbook {
	width: 1000px;
	height: 700px;
}

#flipbook .turn-page {
	background-color: #ccc;
}

#flipbook {
	-webkit-transition: margin-left 1.0s ease-in-out;
	-moz-transition: margin-left 1.0s ease-in-out;
	-o-transition: margin-left 1.0s ease-in-out;
	-ms-transition: margin-left 1.0s ease-in-out;
	transition: margin-left 1.0s ease-in-out;
}
</style>
</head>
<body>

	<!-- 커버 -->
	<div class="container" style="margin-top: 50px;">

		<div id="flipbook" style="margin-left: 5%">
			<div class="hard" style="border-radius: 20px">
				<img src="/resources/imgs/${img }" width="100%"
					height="100%" />
			</div>
			<c:forEach items="${content }" var="c">
				<div
					style="background-image: url('/resources/books/p2.jpg'); background-repeat: no-repeat; background-size: 100% 100%; border-radius: 20px">
					<p style="margin: 5% 5% 5% 5%">${c }</p>
				</div>
			</c:forEach>
			<div class="hard" style="border-radius: 20px"></div>
			<c:if test="${totalPage%2!=0 }">
				<div class="hard" style="border-radius: 20px"></div>
			</c:if>
		</div>

		<br />
		<div class="row">
			<div class="col-md-3"></div>
			<div class="btn-group col-md-3" role="group" aria-label="...">
				<button type="button" class="btn btn-default" id="prev">이전
					페이지</button>
				<button type="button" class="btn btn-default" id="next">다음
					페이지</button>
			</div>
			<div class="btn-group col-md-3" role="group" aria-label="...">
				<button type="button" class="btn btn-default" 
					data-target="#myModal1" data-toggle="modal">책갈피 등록</button>
				<button type="button" class="btn btn-default" 
					data-target="#myModal2" data-toggle="modal">책갈피 이동</button>
			</div>
		</div>

		<br />
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-3">
					<label for="page-number">현재 페이지:</label> <input type="text"
						size="3" id="page-number" name="page-number"> of <span id="number-pages"></span>
				<form action="/readbook/setmark" id="markForm" method="post">
					<input type="hidden"
						size="3" id="page_number" name="page_number">
					<input type="hidden"
						size="3" id="mybooknum" name="mybooknum" value="${param.mybooknum }">
				</form>
			</div>
		</div>

		<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">책갈피 등록</h4>
					</div>
					<div class="modal-body">
						현재 페이지(<span id="nowPage">${startPage }</span>페이지)를 책갈피로 등록하시겠습니까?
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
						<button type="button" class="btn btn-primary" id="mark">등록</button>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Modal title</h4>
					</div>
					<div class="modal-body">책갈피로 저장된 페이지(${markedPage}페이지)로
						이동하시겠습니까?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
						<button type="button" class="btn btn-primary" id="move">이동</button>
					</div>
				</div>
			</div>
		</div>

		<script type="text/javascript">
			var numberOfPages = '${totalPage+2}';
			if (numberOfPages % 2 != 0) {//페이지가 짝수가 아닐경우 커버페이지를 하나 더 추가했으므로 페이지 수 추가
				numberOfPages++;
			}
			var startPage = '${startPage}';

			$(window).ready(function() {

				$('#flipbook').turn({
					page : startPage,
					display : 'double',
					acceleration : true,
					gradients : !$.isTouch,
					elevation : 50,
					autoCenter : true,
					when : {
						turned : function(e, page) {
							$('#page-number').val(page);
							$('#nowPage').text($('#flipbook').turn("page"));
							$('#bookmark').val($('#flipbook').turn("page"));
							$('#page_number').val($('#flipbook').turn("page"));
						}
					}
				});

				$('#number-pages').html(numberOfPages);

				$('#page-number').keydown(function(e) {
					if (e.keyCode == 13)
						$('#flipbook').turn('page', $('#page-number').val());
					$('#nowPage').text($('#flipbook').turn("page"));
					$('#bookmark').val($('#flipbook').turn("page"));
					$('#page_number').val($('#flipbook').turn("page"));
				});

				$("#prev").click(function() {
					$('#flipbook').turn('previous');
					$('#nowPage').text($('#flipbook').turn("page"));
					$('#bookmark').val($('#flipbook').turn("page"));
					$('#page_number').val($('#flipbook').turn("page"));
				});
				$("#next").click(function() {
					$('#flipbook').turn('next');
					$('#nowPage').text($('#flipbook').turn("page"));
					$('#bookmark').val($('#flipbook').turn("page"));
					$('#page_number').val($('#flipbook').turn("page"));
				});

				$("#mark").click(function(){
					$('#markForm').submit();
				});
				
			});

			$(window).bind('keydown', function(e) {
				if (e.keyCode == 37) {
					$('#flipbook').turn('previous');
					$('#nowPage').text($('#flipbook').turn("page"));
					$('#bookmark').val($('#flipbook').turn("page"));
					$('#page_number').val($('#flipbook').turn("page"));
				} else if (e.keyCode == 39) {
					$('#flipbook').turn('next');
					$('#nowPage').text($('#flipbook').turn("page"));
					$('#bookmark').val($('#flipbook').turn("page"));
					$('#page_number').val($('#flipbook').turn("page"));
				}
			});
		</script>
	</div>
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>

