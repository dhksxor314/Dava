
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
<script type="text/javascript">

	$(document).ready(function(){
		$('#login').on('click', function(){
			var formObj = $('#loginForm');
			formObj.attr("action", "/login");
			formObj.attr("method", "post");
			formObj.submit();
		});
	});
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<br/><br/>

<div class="container">
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8" align="center">
			<div class="pull-left">
				<form action="/board/list" method="get" >
					<select id="keyword" name="keyword">
						<option <c:out value="${search.keyword=='t'? 'selected' : '' }"/> value="t">제목</option>
						<option <c:out value="${search.keyword=='c'? 'selected' : '' }"/> value="c">내용</option>
						<option <c:out value="${search.keyword=='w'? 'selected' : '' }"/> value="w">작성자</option>
						<option <c:out value="${search.keyword=='tc'? 'selected' : '' }"/> value="tc">제목+내용</option>
					</select>
					
					<input type="text" id="keyfield" name="keyfield" value="${search.keyfield }"/>
					<input type="submit" value="검색"/>
				</form>
			</div>
			<br/><br/>
			<table class="table">
				<tr>
					<td>글번호</td><td>제목</td><td>작성자</td><td>등록일</td><td>조회수</td>
				</tr>
				
				<c:forEach items="${list }" var="boardVO">
					<tr>
						<td>${boardVO.bno }</td>
						<td><a href="/board/read?bno=${boardVO.bno }">${boardVO.title }</a></td>
						<td>${boardVO.writer }</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"  value="${boardVO.regdate }"/></td>
						<td>${boardVO.viewcnt }</td>
					</tr>	
				</c:forEach>
			</table>
			<div>
				<ul class="pagination">
					<c:if test="${paging.nowBlock>0 }">
						<li><a href="/board/list?nowPage=${paging.start-1 }&nowBlock=${paging.nowBlock-1}&keyword=${search.keyword}&keyfield=${search.keyfield}">이전</a></li>
					</c:if>
					<c:forEach begin="${paging.start }" end="${paging.end }" var="idx">
						<li <c:out value="${paging.nowPage==idx? 'class = active':''}"/>>
							<a href="/board/list?nowPage=${idx }&nowBlock=${paging.nowBlock}&keyword=${search.keyword}&keyfield=${search.keyfield}">${idx }</a>
						</li>
					</c:forEach>
					<c:if test="${paging.nowBlock<paging.totalBlock }">
						<li><a href="/board/list?nowPage=${paging.end+1 }&nowBlock=${paging.nowBlock+1}&keyword=${search.keyword}&keyfield=${search.keyfield}">다음</a></li>
					</c:if>
				</ul>
			</div>
			<c:if test="${nickname != null }">
				<a href="/board/write" class="btn">글쓰기</a>
			</c:if>
		</div>
	</div>
</div>

<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>

</body>
</html>

