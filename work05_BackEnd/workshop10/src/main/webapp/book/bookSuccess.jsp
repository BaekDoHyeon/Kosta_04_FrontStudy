<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>결과 페이지</h2>
<p> <span style="color: red;">${param.bookTitle}</span> ${msg}</p>
<a href="${pageContext.request.contextPath}/book/Book.jsp">추가 등록</a>
<a href="${pageContext.request.contextPath}/bookList.do">도서목록</a>
</body>
</html>