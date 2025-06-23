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
	<hr>
	<h1>성적 계산기</h1>

	<label for="kor">국어 : </label>
	<input type="number" id="kor"><br>
	
	<label for="eng">영어 : </label>
	<input type="number" id="eng"><br>
	
	<label for="math">수학 : </label>
	<input type="number" id="math"><br>
	
	<button id="btnPost">계산</button>
	
	<div id="resultArea"></div>
		
	<script>
 	 $(function(){
	    $("#btnPost").click(function(){
	      const kor = $("#kor").val();
	      const eng = $("#eng").val();
	      const math = $("#math").val();

	      $.ajax({
	        url: "/scoreAjax",
	        type: "post",
	        data: {
	          kor: kor,
	          eng: eng,
	          math: math
	        },
	        success: function(result){
	          $("#resultArea").html("<p>" + result + "</p>");
	        },
	        error: function(){
	          alert("서버 요청 실패");
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
						// dataType에 json이라고 적어두면 별도로 json 데이터 파싱할 필요 없음
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
	<h1>카테고리별 상품 조회</h1>

	<label>카테고리 선택: </label>
	<select id="categorySelect">
	    <option value="1">전자제품</option>
	    <option value="2">생활용품</option>
	    <option value="3">패션</option>
	</select>
	
	<button id="searchBtn">조회</button>
	
	<div id="productListArea"></div>
	
	<script>
	$(function(){
	    $("#searchBtn").click(function(){
	        const categoryCode = $("#categorySelect").val(); // 숫자 형태로 전송
	
	        $.ajax({
	            url: "/searchProduct",
	            type: "post",
	            data: { categoryCode: categoryCode },
	            dataType: "json",
	            success: function(data){
	                $("#productListArea").empty();
	
	                if(data.products.length === 0){
	                    $("#productListArea").append("<p>해당 카테고리의 상품이 없습니다.</p>");
	                } else {
	                    for(let i = 0; i < data.products.length; i++){
	                        const p = data.products[i];
	                        $("#productListArea").append("<p>상품명: " + p.name + ", 가격: " + p.price + "원</p>");
	                    }
	                }
	            }
	        });
	    });
	});
	</script>
	
</body>
</html>