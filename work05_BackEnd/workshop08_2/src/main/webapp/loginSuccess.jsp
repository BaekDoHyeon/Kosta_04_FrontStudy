<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
<h2> ${user.name} 님이 로그인 되었습니다.</h2>	
<br/><br/>
<div><a href="${pageContext.request.contextPath}/book/Book.jsp">도서 등록</a></div>
<div><a href="login.html" onclick="logout()">로그아웃</a></div>
<a href="${pageContext.request.contextPath}/front.do?command=showBooks">도서목록</a>
</body>
</html>