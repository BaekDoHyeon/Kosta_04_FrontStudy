<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		alert("Logout~~!!");
	}
</script>
</head>
<body onload="return logout()">
<b>로그아웃 되셨습니다</b><br>
<a href="index.jsp">INDEX로 가기</a>
</body>
</html>