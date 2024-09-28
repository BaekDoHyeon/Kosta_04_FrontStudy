<%@page import="web.servlet.model.User"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%	
	User user = (User)session.getAttribute("user");
 %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		alert("Logout~~!!");
	}
</script>
</head>
<body>
<h2> <%= user.getName() %> 님이 로그인 되었습니다.</h2>	
<br/><br/>
<div><a href="./book/Book.html">도서 등록</a></div>
<div><a href="login.html" onclick="logout()">로그아웃</a></div>
</body>
</html>