<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- taglib 선언문  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>c:choose 문법 사용하기 :: 양자택일...또 다른 조건을 부여할때...</h2>
<c:choose>
	<c:when test="${param.NUM=='100'}">
		<b>자동차세 100만원이 입금되었습니다.</b>
	</c:when>
	<c:when test="${param.NUM=='200'}">
		<b>보증금 200만원이 입금되었습니다.</b>
	</c:when>
	<c:otherwise>
		<b>고객님, 입금액을 다시한번 확인해주세요.</b>
	</c:otherwise>
</c:choose>
</body>
</html>