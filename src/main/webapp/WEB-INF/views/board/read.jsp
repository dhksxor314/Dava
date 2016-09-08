
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
	getAllList();
	
	function getAllList(){
		var str="";
		var bno='${boardVO.bno }';
		$.getJSON("/replies/all/"+bno, function(data){
			$(data).each(function(){
				str+="<div style='border: 1px solid black'>"
					+"<p>작성자 : "+this.replyer+"</p><br/>"
					+"<textarea style='width:100%' readonly='readonly'>"+this.replytext+"</textarea>"
					+"</div>";
			});

			$('#replies').html(str);
		})
	}
	
	$(document).ready(function(){
		var form = $('#form');
		$('#delete').click(function(){
			form.attr("action", "/board/delete");
			form.submit();
		});
		
		$('#update').click(function(){
			form.submit();
		});
		
		$('#insertReply').click(function(){
			var replyer = '${nickname}';
			var replytext = $('#replytext').val();
			var bno = '${boardVO.bno }';
			
			$.ajax({
				type:'post',
				url:'/replies',
				headers:{"Content-Type":"application/json","X-HTTP-Method-Override":"POST"},
				dataType:'text',
				data:JSON.stringify({bno:bno, replyer:replyer, replytext:replytext}),
				success:function(result){
					if(result=='SUCCESS'){
						alert("등록되었습니다.");
						getAllList();
						$('#replytext').val('');
					}
				}
			});
		});
		
		
	});
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<br/><br/>
<form action="/board/update" method="post" id="form">
	<input type="hidden" name="bno" id="bno" value="${boardVO.bno }"/>
</form>
<div class="container">
	<div class="row">
	<div class="col-md-2"></div>
		<div class="col-md-8"align="center">

				<table class="table">
					<tr>
						<td>제목</td>
					</tr>
					<tr>
						<td><input type="text" id="title" name="title" style="width:100%" value="${boardVO.title }" readonly="readonly"></td>
					</tr>
					<tr>
						<td>내용</td>
					</tr>
					<tr>
						<td><textarea rows="5" style="width:100%" id="content" name="content" readonly="readonly">${boardVO.content }</textarea></td>
					</tr>
				</table>
				
				<a href="/board/list" class="btn">목록</a>
				<c:if test="${nickname eq boardVO.writer }">
					&nbsp;&nbsp;<button id="update" class="btn">수정</button>&nbsp;&nbsp;<button id="delete" class="btn">삭제</button>
				</c:if>
				<br/><br/>
				<div id="addReplyDiv">
					<p>댓글 입력</p><br/>
					<textarea id="replytext" name="replytext" rows="1" style="width:100%" ></textarea>
					<button id="insertReply">댓글등록</button>
				</div>
				<br/><br/>
				<div id="replies">
					
				</div>

		</div>
	</div>
</div>

<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

