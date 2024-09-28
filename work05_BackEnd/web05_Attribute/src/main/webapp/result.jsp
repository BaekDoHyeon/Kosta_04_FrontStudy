<%@ page import="web.servlet.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	/* 자바 코드만 입력한다... */
	Member member = (Member)request.getAttribute("mem");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2><%= member.getAddress() %>에 거주하는 멤버의 정보입니다.</h2>
<p></p>
이름 : <%= member.getName() %><br>
나이 : <%= member.getAge() %>
</body>
</html>