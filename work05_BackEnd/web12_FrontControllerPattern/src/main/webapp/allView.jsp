<%@page import="web.servlet.model.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Member> list = (ArrayList) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">회원 전체 명단 보기</h2>
<table border="2" width="400px" bgcolor="DodgerBlue" align="center">
	<%
		for(Member vo : list) {
	%>
		<tr>
			<td><%= vo.getId()%> </td>
			<td><%= vo.getName()%> </td>
			<td><%= vo.getAddress()%> </td>
		</tr>
	<%
		}
	%>
</table>
<p></p>
<h3 align="center"><a href="index.html">INDEX...</a></h3>
</body>
</html>






