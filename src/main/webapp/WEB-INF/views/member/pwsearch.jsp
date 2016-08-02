<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>

<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<link href="/resources/bootstrap/css/bootstrap.min.css"
   rel="stylesheet">
<title>Join</title>


<script>
	$(document).ready(function(){
		
	});
</script>
<style>
.margin {
   margin-top: 5px;
   margin-bottom: 5px;
}
</style>
</head>

<body>
	<form method="post" id="findform">
	   <div class="container">
	      <div class="row"> <h1>비밀번호찾기</h1></div>
	      <div class="row margin">   
	         <input type="email" class="form-control" placeholder="Enter email" name="id" id="id" value=${id }><br/>	         
	      </div>
	         <div class="row">
	      		<div>${msg}</div>
	      	</div>
	      <div class="row margin">
	            <input type="submit" id="find" class="col-xs-offset-3 col-xs-6 col-xs-offset-3 btn btn-success" value="찾기" style="height: 53px">
	      </div>
	   </div>
	</form>
</body>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</html>