<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 가입</h2>
<form action="front.do" method="post">
<input type="hidden" name="command" value="register">
	<b>ID</b> <input type="text" name="id" required><br>
	<b>PASSWODR</b> <input type="password" name="pwd" required><br>
	<b>NAME</b> <input type="text" name="name"><br>
	<b>ADDRESS</b> <input type="text" name="addr"><br>
	<button type="submit">회원가입</button>
</form> 
</body>
</html>