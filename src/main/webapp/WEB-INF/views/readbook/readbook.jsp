
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="/resources/turn/turn.js"></script>
<style>
body{
	background:#ccc;
}
#flipbook{
	width:1000px;
	height:800px;
}
#flipbook .turn-page{
	background-color:#ccc;
	
}
#flipbook{
  -webkit-transition:margin-left 1.0s ease-in-out;
  -moz-transition:margin-left 1.0s ease-in-out;
  -o-transition:margin-left 1.0s ease-in-out;
  -ms-transition:margin-left 1.0s ease-in-out;
  transition:margin-left 1.0s ease-in-out;
}
</style>
</head>
<body>

<%@ include file="/WEB-INF/views/include/header.jsp" %>

<!-- 커버 -->
<div class="container" style="margin-top:50px;">
	
	<div id="flipbook" style="margin-left:5%">
		<div class="hard"><img src="/resources/books/moon/cover.png" width="100%" height="100%" style="border-radius:20px"/></div>
		   <c:forEach items="${content }" var="c">
		   	 <div style="background-image: url('/resources/books/p2.jpg') ; background-repeat: no-repeat; background-size:100% 100%; border-radius:20px"><p style="margin:5% 5% 5% 5%">${c }</p> </div>
		   </c:forEach>
		<div class="hard" style="border-radius:20px"></div>
	</div>
	
	
	<br/><br/>
	<div align="center"><button id="prev" class="btn">이전</button>&nbsp;&nbsp;&nbsp;<button id="next" class="btn">다음</button>
	<button id="zoomInBtn">확대</button><button id="zoomOutBtn">축소</button></div><br/>
	<div id="controls">
		<label for="page-number">Page:</label> <input type="text" size="3" id="page-number"> of <span id="number-pages"></span>
	</div>
<script type="text/javascript">
	
	var numberOfPages = '${totalPage+2}';
	var startPage = 1;
	$(window).ready(function() {
		
		$('#flipbook').turn({
							page:startPage,
							display: 'double',
							acceleration: true,
							gradients: !$.isTouch,
							elevation:50,
							autoCenter: true,
							when: {
								turned: function(e, page) {
									$('#page-number').val(page);								}
							}
						});
		
		
		
		
		$('#number-pages').html(numberOfPages);
		
		$('#page-number').keydown(function(e){
			if (e.keyCode==13)
				$('#flipbook').turn('page', $('#page-number').val());
		});
		
		$("#prev").click(function(){
			$('#flipbook').turn('previous');
		});
		$("#next").click(function(){
			$('#flipbook').turn('next');
		});
		
	});

	$(window).bind('keydown', function(e){
		if (e.keyCode==37)
			$('#flipbook').turn('previous');
		else if (e.keyCode==39)
			$('#flipbook').turn('next');
	});
	
</script>
</div>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>

