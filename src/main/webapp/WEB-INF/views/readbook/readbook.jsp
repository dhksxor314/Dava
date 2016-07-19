<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="/resources/turn.min.js"></script>

<style type="text/css">
body{
	background:#ccc;
}
#book{
	width:800px;
	height:500px;
}

#book .turn-page{
	background-color:white;
}

#book .cover{
	background:#333;
}

#book .cover h1{
	color:white;
	text-align:center;
	font-size:50px;
	line-height:500px;
	margin:0px;
}

#book .loader{
	background-image:url(/resources/loader.gif);
	width:24px;
	height:24px;
	display:block;
	position:absolute;
	top:238px;
	left:188px;
}

#book .data{
	text-align:center;
	font-size:40px;
	color:#999;
	line-height:500px;
}

#controls{
	width:800px;
	text-align:center;
	margin:20px 0px;
	font:30px arial;
}

#controls input, #controls label{
	font:30px arial;
}

#book .odd{
	background-image:-webkit-linear-gradient(left, #FFF 95%, #ddd 100%);
	background-image:-moz-linear-gradient(left, #FFF 95%, #ddd 100%);
	background-image:-o-linear-gradient(left, #FFF 95%, #ddd 100%);
	background-image:-ms-linear-gradient(left, #FFF 95%, #ddd 100%);
}

#book .even{
	background-image:-webkit-linear-gradient(right, #FFF 95%, #ddd 100%);
	background-image:-moz-linear-gradient(right, #FFF 95%, #ddd 100%);
	background-image:-o-linear-gradient(right, #FFF 95%, #ddd 100%);
	background-image:-ms-linear-gradient(right, #FFF 95%, #ddd 100%);
}
</style>
</head>
<body>

<%@ include file="/WEB-INF/views/include/header.jsp" %>

<!-- 커버 -->
<div class="container">
	<div id="book">
	<div class="cover"><img src="<%=cp %>/resources/cover.png"/></div>
</div>
<button id="prev">이전</button><button id="next">다음</button>
<div id="controls">
	<label for="page-number">Page:</label> <input type="text" size="3" id="page-number"> of <span id="number-pages"></span>
</div>

<script type="text/javascript">

	// Sample using dynamic pages with turn.js

	var numberOfPages = 1000; 


	// Adds the pages that the book will need
	function addPage(page, book) {
		// 	First check if the page is already in the book
		if (!book.turn('hasPage', page)) {
			// Create an element for this page
			var element = $('<div />', {'class': 'page '+((page%2==0) ? 'odd' : 'even'), 'id': 'page-'+page}).html('<i class="loader"></i>');
			// If not then add the page
			book.turn('addPage', element, page);
			// Let's assum that the data is comming from the server and the request takes 1s.
			setTimeout(function(){
					element.html('<div class="data">sdadsfdsfds</div>');
			}, 1000);
		}
	}

	$(window).ready(function(){
		$('#book').turn({acceleration: true,
							pages: numberOfPages,
							elevation: 50,
							gradients: !$.isTouch,
							when: {
								turning: function(e, page, view) {

									// Gets the range of pages that the book needs right now
									var range = $(this).turn('range', page);

									// Check if each page is within the book
									for (page = range[0]; page<=range[1]; page++) 
										addPage(page, $(this));

								},

								turned: function(e, page) {
									$('#page-number').val(page);
								}
							}
						});

		$('#number-pages').html(numberOfPages);

		$('#page-number').keydown(function(e){

			if (e.keyCode==13)
				$('#book').turn('page', $('#page-number').val());
				
		});
	});

	$(window).bind('keydown', function(e){

		if (e.target && e.target.tagName.toLowerCase()!='input')
			if (e.keyCode==37)
				$('#book').turn('previous');
			else if (e.keyCode==39)
				$('#book').turn('next');

	});
	
	$(document).ready(function(){
		$("#prev").click(function(){
			$('#book').turn('previous');
		});
		$("#next").click(function(){
			$('#book').turn('next');
		});
	});

</script>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>

</div>


</body>
</html>

