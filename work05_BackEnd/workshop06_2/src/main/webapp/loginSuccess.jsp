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
</head>
<body>
<h2><%=user.getName() %>님이 로그인 되었습니다!!!</h2><br><br>
<a href="Book.html">도서 등록</a><br><br>
<a href="login.html" onclick="logout()">로그아웃</a><br><br>
<script type="text/javascript">
function logout() {
	<%session.invalidate();%>
	alert("로그아웃 하셨습니다.");
}

</script>
</body>
</html>