/**
 * 
 */

function reward_sel(){
	
	var reward_sel = document.getElementById("reward_sel");
	var persent = document.getElementById("persent");
	var price = document.getElementById("price");
	var val;
	
	for(var i=0; i<reward_sel.options.length; i++) {
	    if(reward_sel.options[i].selected == true) {
	        val = reward_sel.options[i].value;
	        break;
	    }
	}
	console.log(val);
	if(val == "dis_per"){
		price.style.display ='none';
		
	}
	if(val == "dis_pri"){
		persent.style.display = 'none';
	}
	//document.getElementById("showHide").style.display ='none';
	
}

$(document).ready(function(){
	
	$('#price').hide();
	$('#cou_exp_div2').hide();

	$('#reward_sel').click(function(){
		if($("#reward_sel option:selected").val() == 'dis_pri'){
			$('#persent').hide();
			$('#price').show();
		}
		if($("#reward_sel option:selected").val() == 'dis_per'){
			$('#price').hide();
			$('#persent').show();
		}		
	});
	
	
	$('#cou_exp').click(function(){
		if($("#cou_exp option:selected").val() == 'period'){
			$('#cou_exp_div2').hide();
			$('#cou_exp_div').show();
		}
		if($("#cou_exp option:selected").val() == 'issued'){
			$('#cou_exp_div').hide();
			$('#cou_exp_div2').show();
		}
	});
	
});//ready

function test(){
	
}
//	if($("#reward_sel option:selected").val() == 'dis_per'){
//		$('#persent').hide();
//	}