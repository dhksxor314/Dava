<!--
	설명 : 이 페이지는 사용자가 구매한 책을 보는 페이지입니다. 
	작성자 : 전현영
 -->


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

</style>
</head>
<body>
<div class="container">
	<div class="row">
		<table class="table">
			<tr>
				<td>글번호</td><td>글제목</td><td>작성자</td><td>작성일</td><td>조회수</td>
			</tr>
			<!-- 
			<c:forEach items=${list } var="boardVO">
				<td>${boardVO.bno }</td>
				<td>${boardVO.title }</td>
				<td>${boardVO.WRITER }</td>
				<td>${boardVO.regdate }</td>
				<td>${boardVO.viewcnt }</td>
			</c:forEach>
			 -->
		</table>
	</div>
</div>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

