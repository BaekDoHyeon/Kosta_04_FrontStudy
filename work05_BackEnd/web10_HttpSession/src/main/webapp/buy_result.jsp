<%@page import="servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member vo = (Member)session.getAttribute("vo");	
	String product = (String)session.getAttribute("pname");
	if(vo==null) { //로그인 한 상태가 아니라면...
%>
	<h3>로그인부터 하세요...</h3>
	<a href="login.html">LOGIN 하러가기</a>
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Result Page...</h2>
Id <b><%= vo.getId() %></b><br>
Name <b><%= vo.getName() %></b><br>
Address <b><%= vo.getAddress() %></b><br>
ProductName <b><%= product %></b><br>
</body>
</html>