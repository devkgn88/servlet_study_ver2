<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기 연습하기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1>텍스트 + Ajax</h1>
	<input type="text" id="userId" name="user_id">
	<button id="ajax_get_btn">Get방식</button>
	<button id="ajax_post_btn">Post방식</button>
	<div id="ajax_get_div"></div>
	<script>
		$(document).ready(function(){
			
			$("#ajax_post_btn").click(function(){
				const userId = $("#userId").val();
				
				$.ajax({
					url: "/postTextAjax",
					type: 'post',
					data : {userId : userId},
					success: function(data){
						// $("#ajax_get_div").html(data);
						const p = $('<p>').text(data);
						$('#ajax_get_div').html(p); 
					},
					error : function(){
						alert("요청 실패!");
					}
				});
			});
			
			$("#ajax_get_btn").click(function(){
				const userId = $("#userId").val();
				$.ajax({
					url: "/getTextAjax?userId=" +userId,
					type: "get",
					success: function(data){
						// $("#ajax_get_div").html(data);
						const p = $('<p>').text(data);
						$('#ajax_get_div').html(p);
					},
					error: function(){
						alert("요청 실패!");
					}
				});
			});
		});
	</script>
	
	<h1>JSON + Ajax</h1>
	<label>이름 검색: </label>
	<input type="text" id="searchName">
	<button id="json_get_btn">조회</button>
	<div id="json_get_div"></div>
	<script>
		$(document).ready(function(){
			$("#json_get_btn").click(function(){
				const keyword = $("#searchName").val();
				$.ajax({
					url:"/searchAccount?name="+keyword,
					type:"get",
					dataType:"json",
					success: function(data){
						$("#json_get_div").empty();
						if(data.arr.length === 0){
							alert("검색 결과가 없습니다.");
						} else{
							for(let i = 0 ; i < data.arr.length ; i++){
								const user = data.arr[i];
								$("#json_get_div").append('<p>'+user.name+'</p>');
							}
						}
						
					}
				})
			});
		});
	</script>
</body>
</html>