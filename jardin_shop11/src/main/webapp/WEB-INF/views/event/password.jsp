<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title> JARDIN SHOP </title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="JARDIN" />
<meta name="keywords" content="JARDIN" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scaleable=no" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/content.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
<div id="layerWrap">

	<div class="inputWrap">
			
		<div class="inputBody">
			<div class="title">비밀번호 확인</div>
			<p class="close"><a onclick="parent.$.fancybox.close();" href="javascript:;"><img src="images/btn/btn_input_close.gif" alt="닫기" /></a></p>

			<p class="popalert">비밀번호를 입력해주세요.</p>

			<div class="inputBox">			
			<form action="r_del" method="post" name="r_del">		
				<ul>
					<input type="hidden" value="${r_number }" name="r_number" id="r_number">
					<li><label for="">비밀번호</label><input type="password" class="w348" name="r_pw" id="r_pw"/></li>
					</form>
				</ul>
			</div>

			<div class="centerbrn" onclick="del()" style="cursor: pointer;">
				<a >확인</a>
			</div>
		</div>

	</div>


</div>

<script>

	function del() {
		var r_number = $("#r_number").val();
		var r_pw = $("#r_pw").val();
		var r_data = JSON.stringify({"r_number":r_number,"r_pw":r_pw});
		$.ajax({
			type:"post",
			url:"r_del",
			data:r_data,
			contentType:"application/json",
			dataType:"json",
			success: function (data) {
				if(data==1){
					alert("댓글이 삭제되었습니다.");
					window.close();
					opener.document.location.reload(true);
					}else if(data==-1){
						alert("비밀번호가 다릅니다.");
					}else{
						alert("오류가 발생하였습니다.")
					}
				},
				error: function () {
					alert("실패");
				}
				});
	}




</script>
</body>
</html>