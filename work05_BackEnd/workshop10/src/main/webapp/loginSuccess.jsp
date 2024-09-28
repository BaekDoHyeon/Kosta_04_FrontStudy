<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2> ${user.name} 님이 로그인 되었습니다.</h2>	
<br/><br/>
<div><a href="${pageContext.request.contextPath}/book/Book.jsp">도서 등록</a></div>
<div><a href="logout.do">로그아웃</a></div>
<a href="${pageContext.request.contextPath}/bookList.do">도서목록</a>
</body>
</html>