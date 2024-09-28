<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script><title>Insert title here</title>
<style type="text/css">
	#searchContainer {
		width: 100%;
		text-align: right;
		margin: 10px auto;
	}
</style>
</head>
<body>
<h2 align="center">도서 목록 화면</h2>
<div class="container" id="searchContainer">
	<form action="${pageContext.request.contextPath}/front.do">
	<input type="hidden" name="command" value="conditionSearch">
	    <select name="condition" id="search">
		    <option value="전체">전체</option>
		    <option value="도서명">도서명</option>
		    <option value="도서분류">도서분류</option>
	    </select>
	    <input type="text" name="search">
	    <input type="submit" value="검색"/>
	</form>
</div>
<div class="container">
	<table class="table table-striped" border="2" width="400px" align="center">
		<thead>
			<tr bgcolor="lightgray">
				<th>도서번호</th>
				<th>도서명</th>	
				<th>도서분류</th>
				<th>저자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.isbn}</td>
					<td>${item.title}</td>
					<td>${item.catalogue}</td>
					<td>${item.author}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<p></p>
<h3 align="center"><a href="book/Book.jsp">도서 등록</a></h3>
</body>
</html>