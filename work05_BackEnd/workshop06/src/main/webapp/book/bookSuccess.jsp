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
<p><%= request.getParameter("bookTitle") %> 정상적으로 저장되었습니다.</p>
<a href="Book.html">추가 등록</a>
<a href="#">도서목록</a>
</body>
</html>