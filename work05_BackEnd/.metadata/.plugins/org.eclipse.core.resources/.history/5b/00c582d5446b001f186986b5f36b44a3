<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script><title>Insert title here</title>
<style type="text/css">
	#searchContainer {
		width: 100%;
		text-align: right;
		margin: 10px auto;
	}
	
	#detailView {
		display: none;
		width: 100%;
		height: 50px;
		pading: auto;
	}
</style>
<script type="text/javascript">
$(function() {  
	$('.title').on({
		mouseenter:function() {
			let title = $(this).text();
			$('#detailView').css('display', 'block');
			$.ajax({
				type:'post',
				url:'front.do?command=detailInfo',
				data:{'title' : title},
				
				success:function(result) {
					let str = result.split(',');
					$('#detailView').html('<font color=red>Book 상세정보 출력!! 제목:' + str[0] + ', 출판사:' + str[1] + ', 저자:' + str[2] + '</font>');
				}
			}); //ajax
		},
		mouseleave:function() {
			$('#detailView').css('display', 'none');
		}
		
	});//bind
});//ready
</script>
</head>
<body>
<h2 align="center">도서 목록 화면</h2>
<!-- 인증된 사용자가 보는 화면 -->
<c:if test="${not empty user}">
	<h4>${user.name}님 로그인 되셨습니다. <a href="front.do?command=logout">로그아웃</a></h4>
</c:if>
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
			<c:choose>
				<c:when test="${list.size() == 0}">
					<tr>
						<td colspan="4" style="text-align:center; color:gray;"><b>입력된 도서 정보가 없습니다.</b></td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list}" var="item">
						<tr>
							<td>${item.isbn}</td>
							<td><a href="#" class="title">${item.title}</a></td>
							<td>${item.catalogue}</td>
							<td>${item.author}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</div>
<p></p>
<div id="detailView" align="center"> 테스트입니다.</div>
<h3 align="center"><a href="book/Book.jsp">도서 등록</a></h3>
</body>
</html>