<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript" src="/resources/bookflipjs/bookflip.js"></script>
<style>
#bookflip {
	color: #ffffff;
}
</style>
</head>
<body>


	<div id="pages" style="width: 1px; height: 1px; overflow: hidden;">
		<div style="text-align: center; color: #ffffff">
			<p style="font-size: 2em;">
				asdfaasdfdsafasdfsf
			</p>

			<script type="text/javascript">
			<!--
				google_ad_client = "ca-pub-4857789398432351";
				/* Bookflip1 */
				google_ad_slot = "7843921630";
				google_ad_width = 336;
				google_ad_height = 280;
			//-->
			</script>
			<script type="text/javascript"
				src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
				
			</script>
		</div>


		<div>Pg0</div>
		<div>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</div>
		<div>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb</div>
		<div>cccccccccccccccccccccccccccc</div>
		<div>dddddddddddddddddddddddddddddddddd</div>
		<div>eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee</div>
		<div>fffffffffffffffffffffffffffffffffffffff asd dasf dsaf asdf
			asdf saf asdf asf sa fsa fsf</div>


	</div>
	<div align=center>
		<div>
			<input type=button class="buttons" value=prev onclick="clipmeR();">
			<input type=button class="buttons" value=next onclick="clipmeL();">
			<!-- Speed: <input id=speedButton style="width:30px;" value="15" onchange="pSpeed=parseInt(this.value);"> -->
			<select id="flipSelect" style="display: none;"></select> <br>
			<br>
		</div>
		<div id="bookflip"></div>
	</div>

	<script type="text/javascript">
		/****************************************************************************
		 //** Software License Agreement (BSD License)
		 //** Book Flip slideshow script- Copyright 2011, Will Jones (coastworx.com)
		 //** This Script is wholly developed and owned by CoastWorx.com
		 //** Copywrite: http://www.coastworx.com/
		 //** You are free to use this script so long as this coptwrite notices
		 //** and link back to http://www.coastworx.com stays intact in its entirety.
		 //** If you want to remove the link back to http://www.coastworx.com then purchase a licence.
		 //** You are NOT Permitted to claim this script as your own or
		 //** use this script for commercial purposes without the express
		 //** permission of CoastWorx Technologies!
		 //***************************************************************************/

		pWidth = 400; //width of each page
		pHeight = 482; //height of each page

		numPixels = 20; //size of block in pixels to move each pass
		pSpeed = 15; //speed of animation, more is slower

		startingPage = "0";//select page to start from, for last page use "e", eg. startingPage="e"
		allowAutoflipFromUrl = true; //true allows querystring in url eg bookflip.html?autoflip=5

		pageBackgroundColor = "#CCCCCC";
		pageFontColor = "#ffffff";

		pageBorderWidth = "1";
		pageBorderColor = "#3D4D5D";
		pageBorderStyle = "solid"; //dotted, dashed, solid, double, groove, ridge, inset, outset, dotted solid double dashed, dotted solid

		pageShadowLeftImgUrl = "black_gradient.png";
		pageShadowWidth = 80;
		pageShadowOpacity = 60;
		pageShadow = 1 //0=shadow off, 1= shadow on left page

		allowPageClick = true; //allow page turn by clicking the page directly
		allowNavigation = true; //this builds a drop down list of pages for auto navigation.
		pageNumberPrefix = "page "; //displays in the drop down list of pages if enabled

		ini();
	</script>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>