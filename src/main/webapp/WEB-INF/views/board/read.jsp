
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
		
		var formObj = $("#form"); 
		
		$("#update").click(function(){
			formObj.attr("action", "/board/update");
			formObj.attr("method", "get");
			formObj.submit();
		});
		
		$("#delete").click(function(){
			formObj.attr("action", "/board/delete");
			formObj.attr("method", "post");
			formObj.submit();
		});
		
		$("#list").click(function(){
			formObj.attr("method", "get");
			formObj.attr("action", "/board/list");
			formObj.submit();
		});
			
	});
		


</script>
<style>
	
</style>
</head>
<body>


<div class="container">
	<div class="row">
	<form id="form">
		<input type="hidden" id="bno" name="bno" value="${boardVO.bno }"/>
		<input type="hidden" id="page" name="page" value="${cri.page }"/>
		<input type="hidden" id="pagePerNum" name="pagePerNum" value="${cri.pagePerNum }"/>
	</form>
		<table class="table">
			<tr>
				<td>작성자</td>
			</tr>
			<tr><td><input type="text" id="writer" name="writer" value="${boardVO.writer }" readonly="readonly"></td></tr>
			<tr>
				<td>글제목</td>
			</tr>
			<tr><td><input type="text" id="title" name="title" value="${boardVO.title }" readonly="readonly"></td></tr>
			<tr>
				<td colspan="2">내용</td>
			</tr>
			<tr>
				
				<td colspan="2"><textarea rows="10" id="content" name="content" readonly="readonly">${boardVO.content }</textarea></td>
			
			</tr>
		</table>
	
		<div align="right">
			<button id="update">수정</button>&nbsp;&nbsp;<button id="delete">삭제</button>&nbsp;&nbsp;<button id="list">목록</button>
		</div>
	</div>
</div>

<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

