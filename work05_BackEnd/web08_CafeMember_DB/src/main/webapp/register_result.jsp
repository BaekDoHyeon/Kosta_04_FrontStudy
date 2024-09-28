<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member vo = (Member)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2><%= vo.getName() %>님 회원가입 성공!!!</h2>
<b>회원 아이디</b> <%= vo.getId() %> <br>
<b>회원명</b> <%= vo.getName() %> <br>
<b>회원 주소</b> <%= vo.getAddress() %>
</body>
</html>