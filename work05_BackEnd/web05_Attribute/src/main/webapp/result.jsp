<%@ page import="web.servlet.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	/* �ڹ� �ڵ常 �Է��Ѵ�... */
	Member member = (Member)request.getAttribute("mem");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2><%= member.getAddress() %>�� �����ϴ� ����� �����Դϴ�.</h2>
<p></p>
�̸� : <%= member.getName() %><br>
���� : <%= member.getAge() %>
</body>
</html>