<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h1>게시글 등록</h1>
	<form id="createBoardFrm">
		<input type="hidden" name="boardWriter" value="${loginMember.memberNo }">
	    <label>제목:</label><br>
	    <input type="text" name="boardTitle" required><br><br>
	    
	    <label>내용:</label><br>
	    <textarea name="boardContent" rows="5" cols="40" required></textarea><br><br>
	    
	    <label>파일첨부:</label><br>
	    <input type="file" id="board_file" name="board_file" multiple><br><br>
	    
	    <input type="submit" value="등록">
	</form>
	<script>
		$(function(){
		    $("#createBoardFrm").submit(function(e){
		        e.preventDefault();
		        
		        const form = document.getElementById("createBoardFrm");
		        const formData = new FormData(form);
		        
		        $.ajax({
		            url : "/boardCreate",
		            type : "post",
		            data : formData,
		            enctype : "multipart/form-data",
		            contentType : false,
		            processData : false,
		            cache : false,
		            dataType : "json",
		            success : function(res){
		                alert(res.res_msg);
		                if(res.res_code == 200){
		                    location.href = "<c:url value='/boardList'/>";
		                }
		            }
		        });
		    });
		});
	</script>

</body>
</html>