
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
		$("#complete").on("click", function(){
			if(confirm("수정하시겠습니까?")){
				$("#form").submit();
			}
		});
		
		$("#reset").click(function(){
			self.location="/board/read?bno="+${boardVO.bno}
		})
	});
</script>
<style>
	
</style>
</head>
<body>

<div class="container">
	<div class="row">
		<form id="form" action="/board/doupdate" method="post">
			<input type="hidden" id="bno" name="bno" value="${boardVO.bno }"/>
		
			<table class="table">
				<tr>
					<td>작성자</td>
				</tr>
				<tr><td><input type="text" id="writer" name="writer" value="${boardVO.writer }" readonly="readonly" ></td></tr>
				<tr>
					<td>글제목</td>
				</tr>
				<tr><td><input type="text" id="title" name="title" value="${boardVO.title }" ></td></tr>
				<tr>
					<td colspan="2">내용</td>
				</tr>
				<tr>					
					<td colspan="2"><textarea rows="10" id="content" name="content" >${boardVO.content }</textarea></td>
				</tr>
			</table>
		</form>
			<div align="right">
				<button id="complete">완료</button>&nbsp;&nbsp;<button id="reset">취소</button>
			</div>
		
	</div>
</div>

<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

