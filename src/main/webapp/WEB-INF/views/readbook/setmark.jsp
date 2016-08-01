


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!doctype html>
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

</head>
		<script>
		$(window).ready(function() {

			     var $form = $('<form></form>');
			     $form.attr('action', '/readbook/read');
			     $form.attr('method', 'post');
			     $form.appendTo('body');
			     
			     var mybooknum = $('<input type="hidden" value="'+${mybooknum}+'" name="mybooknum">');
			 
			     $form.append(mybooknum);
			     $form.submit();
			
		});
		</script>
	</div>
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</html>

