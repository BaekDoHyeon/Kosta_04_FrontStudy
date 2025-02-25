<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style type="text/css">
	body {
		margin: 0;
	}

	.nav {
		width: 100%;
		height: 70px;
		background-color: orange;
		display: flex;
		flex-direction: row;
		justify-content: flex-end;
		align-items: center;
	}
	
	.nav * {
		width: 8%;
	}
	
	.detailContainer {
		display: flex;
		justify-content: center;
		margin: 10px;
	}
	
	.detailContainer>*{
		width: 30%;
		height: 500px;
	}
	
	#detailFruitImg {
		background-image: url(${item.url});
		background-repeat: no-repeat;
		background-size: contain;
		background-position: center;		
	}
	
	#detailFruitDesc {
		display: flex;
		flex-direction: column;
		justify-content: flex-start;
	}
</style>
<script type="text/javascript">
	$(() => {
		$('.shoppingBasket').hover(function() {
			$(this).css("color","blue");
			$(this).css("cursor", "pointer");
		}, function() {
			$(this).css("color","black");
		});
	}); //ready
</script>
</head>
<body>
<h2 align="center">${item.name}의 정보</h2>
<div class="nav">
	<p>조회수: ${item.count}</p>
	<p class="shoppingBasket">장바구니 담기</p>
	<p class="shoppingBasket">장바구니 확인</p>
</div>
<div class="detailContainer">
	<div id="detailFruitImg"></div>
	<div id="detailFruitDesc">
		<p><b>종류</b>: ${item.name}</p>
		<p><b>가격</b>: ${item.price}</p>
		<p><b>설명</b>: ${item.description}</p>
	</div>
</div>
</body>
</html>