<%@page import="web.servlet.vo.User"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%	
	User user = (User)request.getAttribute("user");
 %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2> <%= user.getName() %> ���� �α��� �Ǿ����ϴ�.</h2>	
<br/><br/>
<div><a href="#">���� ���</a></div>
<div><a href="login.html">�α׾ƿ�</a></div>
</body>
</html>