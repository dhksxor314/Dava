
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/resources/turn/turn.js"></script>
<style>
body {
	background: #ccc;
}

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

	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<!-- 커버 -->
	<div class="container" style="margin-top: 50px;">

		<div id="flipbook" style="margin-left: 5%">
			<div class="hard" style="border-radius: 20px">
				<img src="/resources/books/moon/cover.png" width="100%"
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
				<button type="button" class="btn btn-default" id="mark" data-target="#myModal1" data-toggle="modal">책갈피
					등록</button>
				<button type="button" class="btn btn-default" id="move" data-target="#myModal2" data-toggle="modal">책갈피
					이동</button>
			</div>
		</div>

		<br />
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<label for="page-number">현재 페이지:</label> <input type="text" size="3"
					id="page-number"> of <span id="number-pages"></span>
			</div>
		</div>

		<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">책갈피 등록</h4>
		      </div>
		      <div class="modal-body">
		      	현재 페이지(<span id="nowPage">1</span>페이지)를 책갈피로 등록하시겠습니까?
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
		        <button type="button" class="btn btn-primary">등록</button>
		      </div> 
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
		      </div>
		      <div class="modal-body">
		      
		      	책갈피로 저장된 페이지(${markedPage}페이지)로 이동하시겠습니까?

		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
		        <button type="button" class="btn btn-primary">이동</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<script type="text/javascript">
			var numberOfPages = '${totalPage+2}';
			var startPage = 1;
			
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
						}
					}
				});

				$('#number-pages').html(numberOfPages);

				$('#page-number').keydown(function(e) {
					if (e.keyCode == 13)
						$('#flipbook').turn('page', $('#page-number').val());
						$('#nowPage').text($('#flipbook').turn("page"));
				});

				$("#prev").click(function() {
					$('#flipbook').turn('previous');
					$('#nowPage').text($('#flipbook').turn("page"));
				});
				$("#next").click(function() {
					$('#flipbook').turn('next');
					$('#nowPage').text($('#flipbook').turn("page"));
				});

			});

			$(window).bind('keydown', function(e) {
				if (e.keyCode == 37){
					$('#flipbook').turn('previous');
					$('#nowPage').text($('#flipbook').turn("page"));
				}
				else if (e.keyCode == 39){
					$('#flipbook').turn('next');
					$('#nowPage').text($('#flipbook').turn("page"));
				}
			});

			
		</script>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>

