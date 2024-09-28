<%@page import="web.servlet.model.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">회원 전체 명단 보기</h2>
<table border="2" width="400px" bgcolor="DodgerBlue" align="center">
	<c:forEach items="${list}" var="item">
		<tr>
			<td>${item.id}</td>
			<td>${item.name}</td>
			<td>${item.address}</td>
		</tr>
	</c:forEach>
</table>
<p></p>
<h3 align="center"><a href="index.jsp">INDEX...</a></h3>
</body>
</html>






