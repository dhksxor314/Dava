<%@ page contentType="text/html; charset=UTF-8"%>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>

<html>
<head>
<title>Mypage</title>
</head>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<link href="/resources/bootstrap/css/bootstrap.min.css"
   rel="stylesheet">
<script>
	$(document).ready(function() {
		   var get='${get}'
		 if(get != "get"){
			var msg='${msg}'
			
			var editpassword='${editpassword}' 
			var nowpassword='${nowpassword}' 
			if(editpassword==""){
				 $("#editpassword").attr("style","border-color: red");
				 $("#editpassword_check").attr("style","border-color: red");
				 
			}
			if(nowpassword==""){
				 $("#nowpassword").attr("style","border-color: red");
			}
			if(msg!=""){
				alert(msg)
			}
			if(editpassword != "" && nowpassword !="" ){
				window.close()
			}
			
				
		 }
		 
		$("input[group='edit']").click(function(){
	         $(this).attr("style","border-color: silver");
	      });
		$("#edit").click(function(){
	     
			$("#formeditpassword").submit();

			
	      });
		
	});
</script>
<style>
.margin {
   margin-top: 5px;
   margin-bottom: 5px;
}
</style>
<body>


	<form method="post" id="formeditpassword">
   <div class="container">
      <div class="row"> <h1>비밀번호 수정</h1></div>
      <div class="row margin">   
         <input type="password"  class="form-control" placeholder="현재 비밀번호" name="nowpassword" id="nowpassword" group="edit" value="${nowpassword }">
      </div>
      <div class="row margin">   
         <input type="password"  class="form-control" placeholder="변경 비밀번호" name="editpassword" id="editpassword" group="edit">
      </div>
      <div class="row margin">   
         <input type="password"  class="form-control" placeholder="변경 비밀번호 확인" name="editpassword_check" id="editpassword_check" group="edit">
      </div>
      <div class="row margin">
            <input type="submit" id="edit" class="col-xs-offset-3 col-xs-6 col-xs-offset-3 btn btn-success" value="변경" style="height: 53px">
      </div>
      
   </div>
</form>





	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
