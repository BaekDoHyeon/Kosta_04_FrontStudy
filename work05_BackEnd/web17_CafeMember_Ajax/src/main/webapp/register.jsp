<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#idCheck').on('click', () => {
			let id = $('#id').val();
			alert(id);
			$.ajax({
				//front.do?command=idCheck
				type:'post',
				url:'front.do?command=idCheck',
				data:{'id':id},
						
				success:function(result) {
					if(result === "true") 
						$('#resultView').html('<h3><font color=red>사용중인 ID!!</font></h3>');
					else 
						$('#resultView').html('<h3><font color=blue>사용가능 ID!!</font></h3>');
				}
			}); //ajax
		}); //on
	}); //ready
</script>
</head>
<body>
<h2>회원 가입</h2>
<form action="front.do" method="post">
<input type="hidden" name="command" value="register">
	<b>ID</b> <input type="text" name="id" id="id" required>
	<input type="button" value="중복확인" id="idCheck">
	<span id="resultView"></span>
	<br>
	<b>PASSWODR</b> <input type="password" name="pwd" required><br>
	<b>NAME</b> <input type="text" name="name"><br>
	<b>ADDRESS</b> <input type="text" name="addr"><br>
	<button type="submit">회원가입</button>
</form> 
</body>
</html>