
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<style>

</style>
<script>
	$(document).ready(function(){
		var formObj = $('#updateForm');
		$('#submit').click(function(){
			formObj.attr("method", "post");
			formObj.attr("action", "/board/doupdate");
			formObj.submit();
		})
		
	});
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<br/><br/>

<div class="container">
	<div class="row">
	<div class="col-md-2"></div>
		<div class="col-md-8"align="center">
			<form id="updateForm">
				<input type="hidden" id="bno" name="bno" value="${boardVO.bno }"/>
				<table class="table">
					<tr>
						<td>제목</td>
					</tr>
					<tr>
						<td><input type="text" id="title" name="title" style="width:100%" value="${boardVO.title }"></td>
					</tr>
					<tr>
						<td>내용</td>
					</tr>
					<tr>
						<td><textarea rows="5" style="width:100%" id="content" name="content" >${boardVO.content }</textarea></td>
					</tr>
				</table>
				
				<button class="btn" id="submit">완료</button>&nbsp;&nbsp;<a href="/board/read?bno=${boardVO.bno }" class="btn">취소</a>
			</form>
		</div>
	</div>
</div>

<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

