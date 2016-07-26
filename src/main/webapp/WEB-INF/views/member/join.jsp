<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>

<html>
<head>

<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<link href="/resources/bootstrap/css/bootstrap.min.css"
   rel="stylesheet">
<title>Join</title>


<script>
   $(document).ready(function() {
      var close ='${close}'
      
      var get ='${get}'
      
      if(get != "get"){
         var msg ='${msg}'
         var id='${id}';
         var nickname='${nickname}';
         var password='${password}';
         
         alert(msg);
         if('${id}' == ""){
            $("#id").attr("style","border-color: red");
         }
         if(nickname == ""){
            $("#nickname").attr("style","border-color: red");
         }
         if(password == ""){
            $("#password").attr("style","border-color: red");
            $("#password_check").attr("style","border-color: red");
         }
         if(close =="close"){
            window.close();
         }
      }
      
      
      $("input[group='join']").click(function(){
         $(this).attr("style","border-color: silver");
      });
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
<form action="join" method="post" id="joinform">
   <div class="container">
      <div class="row"> <h1>가입하기</h1></div>
      <div class="row margin">   
         <input type="email" class="form-control" placeholder="Enter email" name="id" id="id" value="${id}" group="join">
      </div>
      <div class="row margin">   
         <input type="text"  class="form-control" placeholder="Nick name" name="nickname" id="nickname" value="${nickname}" group="join">
      </div>
      <div class="row margin">   
         <input type="password"  class="form-control" placeholder="Password" name="password" id="password" value="${password}" group="join">
      </div>
      <div class="row margin">   
         <input type="password"  class="form-control" placeholder="Password check" name="password_check" id="password_check" group="join">
      </div>
      <div class="row margin">
            <input type="submit" id="join" class="col-xs-offset-3 col-xs-6 col-xs-offset-3 btn btn-success" value="가입하기" style="height: 53px">
      </div>
      
   </div>
</form>
   

</body>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</html>