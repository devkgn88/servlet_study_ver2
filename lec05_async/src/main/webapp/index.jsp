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
	
	

</body>
</html>