
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
<style>

</style>
<script>
	$(document).ready(function(){
		$("#write").click(function(){
			location.href="/board/write";
		});
	});
</script>
</head>
<body>
<div class="container">
	<div class="row">
		<table class="table">
			<tr>
				<td>글번호</td><td>글제목</td><td>작성자</td><td>작성일</td><td>조회수</td>
			</tr>
			
			<c:forEach items="${list }" var="boardVO">
				<tr>
					<td>${boardVO.bno }</td>
					<td><a href="/board/read${pageMaker.makeQuery(pageMaker.cri.page) }&bno=${boardVO.bno }">${boardVO.title }</a></td>
					<td>${boardVO.writer }</td>
					<td><fmt:formatDate pattern="yyyy-mm-dd hh:mm" value="${boardVO.regdate }"/></td>
					<td>${boardVO.viewcnt }</td>
				</tr>
			</c:forEach>
			
		</table>
		
		<div align="center">
			<ul class="pagination">
				<c:if test="${pageMaker.prev}">
					<li><a href="/board/list${pageMaker.makeQuery(pageMaker.startPage-1) }">&laquo;</a></li>
				</c:if>
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
					<li <c:out value="${pageMaker.cri.page==idx? 'class = active':''}"/>>
						<a href="/board/list?page=${idx }">${idx }</a>
					</li>
				</c:forEach>
				<c:if test="${pageMaker.next && pageMaker.endPage>0 }">
					<li><a href="/board/list${pageMaker.makeQuery(pageMaker.endPage+1) }">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
		<div align="right">
			<button id="write">글쓰기</button>
		</div>
	</div>
</div>

<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

