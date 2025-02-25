<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<script>
window.onload = function() {
    // 모든 로컬 스토리지 키를 가져옵니다.
    var keys = Object.keys(localStorage);
    
    // 'cartItems'로 시작하는 키를 필터링합니다.
    var cartItemsKeys = keys.filter(function(key) {
        return key.startsWith('fruits_');
    });
    
    // 장바구니 아이템을 저장할 배열을 만듭니다.
    var allCartItems = [];
    
    // 각 'cartItems' 키에 대해 값을 읽어서 배열에 추가합니다.
    cartItemsKeys.forEach(function(key) {
        var cartItems = localStorage.getItem(key);
        if (cartItems) {
            // JSON 형식의 데이터를 배열로 변환하여 추가합니다.
            allCartItems = allCartItems.concat(JSON.parse(cartItems));
        }
    });
    
    // 장바구니 아이템을 표시할 HTML 요소를 선택합니다.
    var cartList = document.getElementById('cart-list');
    
    // 장바구니 아이템이 없으면 메시지를 표시합니다.
    if (allCartItems.length === 0) {
        cartList.innerHTML = '<p>장바구니가 비어 있습니다.</p>';
    } else {
        // 장바구니 아이템을 리스트 형태로 HTML에 추가합니다.
        var listHtml = '<ul>';
        allCartItems.forEach(function(item) {
            listHtml += '<li>' + item.name + "," + item.price'</li>'; 
        });
        listHtml += '</ul>';
        cartList.innerHTML = listHtml;
    }
};
</script>
</head>
<body>
<h2>장바구니~~</h2>
<div id="cart-list">
    <!-- 로컬 스토리지에서 가져온 장바구니 아이템이 여기에 표시됩니다. -->
</div>
</body>
</html>
