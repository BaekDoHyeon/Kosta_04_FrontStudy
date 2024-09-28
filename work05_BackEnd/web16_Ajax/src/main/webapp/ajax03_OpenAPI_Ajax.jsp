<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#serverSend').one('click', () => {
			$.ajax({
				type: 'get',
				url: "http://localhost:8888/weather.xml",
				dataType: 'xml', //option...서버에서 응답하는 데이터 타입을 미리 알려주는 속성이다.
				
				success:function(result) {
					//alert(result);
					let str = '';
					$(result).find('list').each(function(index, item) {
						let region = $(this).find('region').text();
						let wind = $(this).find('wind').text();
						let rain = $(this).find('rain').text();
						let temp = $(this).find('temp').text();
						
						str += '<tr>';
						str += '<td>' + region + "</td>";
						str += '<td>' + wind + "</td>";
						str += '<td>' + rain + "</td>";
						str += '<td>' + temp + "</td>";
						str += '</tr>';
					}); //each
					//$('tbody>tr*').remove(); // one() 을 사용하지 않는다면, 이 부분을 지정하고 사용가능하다.
					$('tbody').append(str);
				} 
			});//ajax
		});//on
	});
</script>
</head>
<body>
<div class="container">
<div class="jumbotron text-center">
	<h2 align="center">==== OPEN API Weather 데이터 가져오기 ====</h2>
</div>
<p><a href="#" id="serverSend">XML 데이터 서버로 요청하기</a></p>
<table class="table table-dark table-striped">
	<thead>
		<tr>
			<th>REGION</th>
			<th>WIND</th>
			<th>RAIN</th>
			<th>TEMP</th>
		</tr>
	</thead>
	<tbody>
		<!-- 이 부분에 공공데이터 XML 의 태그안의 내용이 출력 $.each -->
	</tbody>
</table>
</div>
</body>
</html>