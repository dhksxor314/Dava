
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="/resources/turn/turn.js"></script>
<script type="text/javascript" src="/resources/turn/zoom.js"></script>


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
  -webkit-transition:margin-left 0.2s ease-in-out;
  -moz-transition:margin-left 0.2s ease-in-out;
  -o-transition:margin-left 0.2s ease-in-out;
  -ms-transition:margin-left 0.2s ease-in-out;
  transition:margin-left 0.2s ease-in-out;
}
</style>
</head>
<body>

<%@ include file="/WEB-INF/views/include/header.jsp" %>

<!-- 커버 -->
<div class="container" style="margin-top:50px">
	<div class=".magazine-viewport">
	<div id="flipbook">
		<div class="hard"><img src="/resources/books/moon/cover.png" width="100%" height="100%"/></div>
		   <c:forEach items="${content }" var="c">
		   	 <div><p style="margin:5% 5% 5% 5%">${c }</p> </div>
		   </c:forEach>
		   
		<div class="hard"></div>
		
	</div>
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
	
	// Zoom.js
	/*
	$('.magazine-viewport').zoom({
		flipbook: $('#flipbook'),

		max: function() { 
			
			return largeMagazineWidth()/$('#flipbook').width();

		}, 

		when: {

			swipeLeft: function() {

				$(this).zoom('flipbook').turn('next');

			},

			swipeRight: function() {
				
				$(this).zoom('flipbook').turn('previous');

			},

			resize: function(event, scale, page, pageElement) {

				if (scale==1)
					loadSmallPage(page, pageElement);
				else
					loadLargePage(page, pageElement);

			},

			zoomIn: function () {

				//$('.thumbnails').hide();
				$('.made').hide();
				$('#flipbook').removeClass('animated').addClass('zoom-in');
				$('.zoom-icon').removeClass('zoom-icon-in').addClass('zoom-icon-out');
				
				if (!window.escTip && !$.isTouch) {
					escTip = true;

					$('<div />', {'class': 'exit-message'}).
						html('<div>Press ESC to exit</div>').
							appendTo($('body')).
							delay(2000).
							animate({opacity:0}, 500, function() {
								$(this).remove();
							});
				}
			},

			zoomOut: function () {

				$('.exit-message').hide();
				//$('.thumbnails').fadeIn();
				$('.made').fadeIn();
				$('.zoom-icon').removeClass('zoom-icon-out').addClass('zoom-icon-in');

				setTimeout(function(){
					$('#flipbook').addClass('animated').removeClass('zoom-in');
					resizeViewport();
				}, 0);

			}
		}
	});
	*/

</script>

<%@ include file="/WEB-INF/views/include/footer.jsp" %>
<script src="<%=cp%>/resources/bootstrap/js/bootstrap.min.js"></script>
</div>


</body>
</html>

