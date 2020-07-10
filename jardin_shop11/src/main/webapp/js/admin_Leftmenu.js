// 좌측메뉴 닫기 열기
function Submenu_OC(num) {

	var leftmenuDepth01 = document.getElementById("LeftMenuID" + num);
	var leftmenuDepth01_icon = document.getElementById("icon-plus-minus" + num);

	if (leftmenuDepth01.style.display == "none") {
		leftmenuDepth01.style.display = "block";
		leftmenuDepth01_icon.className = "icon-list-minus";
	} else {
		leftmenuDepth01.style.display = "none";
		leftmenuDepth01_icon.className = "icon-list-plus";
	}

}
function LeftMenu_OCAll() {

	if (document.getElementById("leftmemu_oc").className == "leftmemu_close_off") {
		document.getElementById("contentArea").style.marginLeft = "50px";
		document.getElementById("LeftArea").style.display = "none";
		document.getElementById("leftmemu_oc").className = "leftmemu_close_on";
		document.getElementById("submemu_oc").style.display = "none";
	} else if (document.getElementById("leftmemu_oc").className == "leftmemu_close_on") {
		document.getElementById("contentArea").style.marginLeft = "250px";
		document.getElementById("LeftArea").style.display = "block";
		document.getElementById("leftmemu_oc").className = "leftmemu_close_off";
		document.getElementById("submemu_oc").style.display = "block";
	}

}

function Submenu_OCAll(num) {

	if (document.getElementById("submemu_oc").className == "submemu_close_off") {

		for (var i = 1; i <= num; i++) {
			document.getElementById("LeftMenuID" + i).style.display = "none";
			document.getElementById("icon-plus-minus" + i).className = "icon-list-plus";
		}
		document.getElementById("submemu_oc").className = "submemu_close_on";

	} else if (document.getElementById("submemu_oc").className == "submemu_close_on") {

		for (var i = 1; i <= num; i++) {
			document.getElementById("LeftMenuID" + i).style.display = "block";
			document.getElementById("icon-plus-minus" + num).className = "icon-list-minus";
		}
		document.getElementById("submemu_oc").className = "submemu_close_off";
	}
}
// 좌측메뉴 닫기 열기
