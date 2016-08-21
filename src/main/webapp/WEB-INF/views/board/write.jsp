
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/include/header.jsp" %>

<!doctype html>
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/resources/turn/turn.js"></script>
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script>
	$(document).ready(function(){
		$("#insert").click(function(){
			if(confirm("등록을 완료하시겠습니까?")){
				$("#form").submit();
			}	
		})
		
		$("#list").click(function(){
			self.location="/board/list";
		})
			
	});
		


</script>
<style>
	
</style>
</head>
<body>


<div class="container">
	<div class="row">
	<form id="form" action="/board/dowrite" method="post">
		<table class="table">
			<tr>
				<td>작성자</td>
			</tr>
			<tr><td><input type="text" id="writer" name="writer"></td></tr>
			<tr>
				<td>글제목</td>
			</tr>
			<tr><td><input type="text" id="title" name="title"></td></tr>
			<tr>
				<td colspan="2">내용</td>
			</tr>
			<tr>
				
				<td colspan="2"><textarea rows="10" id="content" name="content"></textarea></td>
			
			</tr>
		</table>
	</form>
		<div align="right">
			<button id="insert">등록</button>&nbsp;&nbsp;<button id="list">목록</button>
		</div>
	</div>
</div>

<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

