/**
 * 
 */
//배송비 테이블
$(document).ready(function() {
	$("#delfee_pay").hide();
	$("#min_delfee").hide();
	$("#delfee_detail").hide();
	
	$("#delevery_choice").click(function() {
		if($("#delevery_choice option:selected").val()=="del_case1"){
			$("#delfee_pay").hide();
			$("#min_delfee").hide();
			$("#delfee_detail").hide();
		}
		if($("#delevery_choice option:selected").val()=="del_case2"){
			$("#delfee_pay").hide();
			$("#min_delfee").hide();
			$("#delfee_detail").hide();
		}
		
		if($("#delevery_choice option:selected").val()=="del_case3"){
			$("#delfee_pay").show();
			$("#min_delfee").show();
			$("#delfee_detail").show();
			$("#delfee_detail span").hide();
		}
		
		if($("#delevery_choice option:selected").val()=="del_case4"){
			$("#delfee_pay").show();
			$("#min_delfee").show();
			$("#delfee_detail").hide();
		}
		
		if($("#delevery_choice option:selected").val()=="del_case5"){
			$("#delfee_pay").show();
			$("#min_delfee").show();
			$("#delfee_detail").show();
			$("#delfee_detail span").show();
		}
		
	});
	
	
	
});