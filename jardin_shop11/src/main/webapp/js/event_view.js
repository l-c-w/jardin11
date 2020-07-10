/**
 * 
 */

//
$(document).ready(function(){
	//댓글수정열기
	$("${e_com.ec_num }").click(function(){
		var index = $(".modi").index(this);
		$(this).parents('ul');
		$(this).parents('ul').hide();
		$("${e_com.ec_num }").eq(index).show(); // 0
//		$(".comment_modifyM").not(index).hide(); // 1, 2
//		$(".modi").not(index).parent().show();

	});
	$(".reset_re").click(function(){	
		var index2 = $(".reset_re").index(this);
		$(".comment_modifyM").eq(index2).hide();
		var test2 = $(".modi").eq(index2).parents('ul');
		$(".modi").eq(index2).parents('ul').show();
	});	

	// 수정 submit
	$('.s_modi').click(function() {
		var index = $(".s_modi").index(this);
		var form = $(this).parents('form');
		$(form).submit();
	});
	
	// 삭제 submit
	$('.delComm').click(function() {
		var result = confirm('댓글을 삭제 하시겠습니까?');
		if(result){
			var index = $(".delComm").index(this);
			var form = $(this).parents('form');
			$(form).submit();			
		}else{
			
		}	
	});
	
	// 로그인하지 않고 댓글을 작성하려고 할 때
	$('.emptySe').click(function(){
		var result = confirm('댓글을 작성하시려면 로그인 하셔야 합니다. 로그인 하시겠습니까?');
		if(result){
//			window.location.replace('/ex/member/login');
			location.href='../member/login?returnUrl=' + encodeURIComponent(location);
		}else{
			
		}				
	});
	
//	<a href="#none" onclick="location.href='/member/login.html?returnUrl=' + encodeURIComponent(location) ">로그인</a>	
	
	
	
});

