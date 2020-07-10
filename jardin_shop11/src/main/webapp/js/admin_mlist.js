
//제이쿼리//



jQuery(document).ready(function() {

	if (document.getElementById("DivLoadEmail")) {
		document.getElementById("DivLoadEmail").style.visibility = "hidden";
	}

});




// <!-[CDATA [


$(function() {
	$("#KeyDate1").datepicker({
		showOn : "both",
		buttonImage : "../image/icon_calen.gif",
		buttonImageOnly : true
	});
	$("#KeyDate1").datepicker("option", "dateFormat", "yy-mm-dd");
	$("#KeyDate1").val('');

	$("#KeyDate2").datepicker({
		showOn : "both",
		buttonImage : "../image/icon_calen.gif",
		buttonImageOnly : true
	});
	$("#KeyDate2").datepicker("option", "dateFormat", "yy-mm-dd");
	$("#KeyDate2").val('');
});
// ]]>




function common_sch_detail_Chk(PageName) {

	var IE = /* @cc_on!@ */false;
	var f = document.getElementById("" + PageName);
	if (f.schDetailYN.value == "N") {

		if (IE) { // block
			document.getElementById("common_sch_detailID1").style.display = "inline";

		} else {
			document.getElementById("common_sch_detailID1").style.display = "table-row";
		}
		
		f.schDetailYN.value = "Y";
		document.getElementById("common_sch_detailTXT").innerHTML = "상세검색 [닫기] <span class='fontredN'>▲</span>";

	} else if (f.schDetailYN.value == "Y") {

		document.getElementById("common_sch_detailID1").style.display = "none";
		f.schDetailYN.value = "N";
		document.getElementById("common_sch_detailTXT").innerHTML = "상세검색 [열기] <span class='fontredN'>▼</span>";
	}

}
function sch_Go() {

	var f = document.getElementById("student_list");
	var schGenderLen = f.schGender.length;
	for (var i = 0; i < schGenderLen; i++) {
		if (f.schGender[i].checked == true) {
			schGender = f.schGender[i].value
		}
	}
	var schRouteLen = f.schRoute.length;
	for (var i = 0; i < schRouteLen; i++) {
		if (f.schRoute[i].checked == true) {
			schRoute = f.schRoute[i].value
		}
	}
	var schClassHistoryLen = f.schClassHistory.length;
	for (var i = 0; i < schClassHistoryLen; i++) {
		if (f.schClassHistory[i].checked == true) {
			schClassHistory = f.schClassHistory[i].value
		}
	}
	location.href = 'student_list.asp?schIcon=' + student_list.schIcon.value
			+ '&schPageTemp=' + student_list.schPageTemp.value
			+ '&schDetailYN=' + student_list.schDetailYN.value + '&schOrderBy='
			+ student_list.schOrderBy.value + '&schGubun='
			+ student_list.schGubun.value + '&schText='
			+ student_list.schText.value + '&schCDay='
			+ student_list.schCDay.value + '&schDate='
			+ student_list.schDate.value + '&schMemGrade='
			+ student_list.schMemGrade.value + '&schPaymentPoint='
			+ student_list.schPaymentPoint.value + '&schPaymentAmountS='
			+ student_list.schPaymentAmountS.value + '&schPaymentAmountE='
			+ student_list.schPaymentAmountE.value + '&Date1='
			+ student_list.Date1.value + '&Date2=' + student_list.Date2.value
			+ '&schGender=' + escape(schGender) + '&schRoute='
			+ escape(schRoute) + '&schClassHistory=' + escape(schClassHistory);

}

function student_list_Chk(PageAction, s_MemSKU) {

	var PageAction = PageAction;
	var s_MemSKU = s_MemSKU;

	if (PageAction == "Modify") {

		location.href = "student_reg.asp?s_MemSKU=" + escape(s_MemSKU)

	} else if (PageAction == "Del") {

		var Location_URL = location.href;
		var PageAction = PageAction;
		var s_MemSKU = s_MemSKU;
		if (confirm("- 삭제할려는 학생이 기존에 사용 이력이 있으면\n  해당 이력에 오류가 발생 할 수도 있습니다.\n- 해당 이력 : 신청관련, 수업관련, 포인트, 쿠폰 등등\n\n정말로 삭제 하시겠습니까?")) {
			self.location.href = "student_reg_sql.asp?Sel=" + escape(s_MemSKU)
					+ "&PageAction=" + escape(PageAction) + "&Location_URL="
					+ escape(Location_URL);
		} else {
		}

	}

}

function AccPointOne_Chk(p_Seq) {

	if (confirm("[포인트] 적립하시겠습니까?")) {
		var Sel0 = p_Seq
		var PageAction = "AccPoint100to200";
		var Location_URL = location.href;
		location.href = '../promotion/point_sql.asp?Sel=' + escape(Sel0)
				+ '&PageAction=' + escape(PageAction) + '&Location_URL='
				+ escape(Location_URL);
	} else {

	}

}

function TrBottom_Chk(FormID, Num) {

	var FormID = FormID;
	var Num = Num;
	var f = document.getElementById("student_list"); // 엑셀파일명때문에 PageNaem로 설정

	if (f.SelectType.value == "S") {

		if (confirm("검색한 리스트를 엑셀 변환하시겠습니까?")) {
		} else {
		}

	} else if (f.SelectType.value == "C") {

		var Sel0 = CallCheck_ListAll(FormID, 0)
		var Sel1 = CallCheck_ListAll(FormID, 1)
		var Sel2 = CallCheck_ListAll(FormID, 2)
		var Sel3 = CallCheck_ListAll(FormID, 3)
		var Sel4 = CallCheck_ListAll(FormID, 4)

		if (Sel0 == "") {
			alert("하나 이상 선택해주세요.");
			return;
		} else {

			if (Num == "SMS") {

				parent
						.open_box(
								'../promotion/sms_send_multi_pop.asp?SMSMemSKU='
										+ Sel1, 850, 700);

				// **********************************************************
				// 검색관련
				// **************************************************************************************************************

				function CDay_Chk(PageName, n, m) {

					var PageName = PageName;
					var n = n
					var m = m
					var f = document.getElementById("" + PageName);

					f.schCDay.value = n;

					f.KeyDate1.value = "";
					f.KeyDate2.value = "";

					document.getElementById("T").className = "btn_CDay";
					document.getElementById("7").className = "btn_CDay";
					document.getElementById("15").className = "btn_CDay";
					document.getElementById("1M").className = "btn_CDay";
					document.getElementById("3M").className = "btn_CDay";
					document.getElementById("6M").className = "btn_CDay";
					document.getElementById("1Y").className = "btn_CDay";
					document.getElementById("W").className = "btn_CDay";
					document.getElementById("M").className = "btn_CDay";
					document.getElementById("Y").className = "btn_CDay";
					document.getElementById("A").className = "btn_CDay";
					if (n == "A") {
						f.KeyDate1.value = "";
						f.KeyDate2.value = "";
					} else if (n == "T") {
						f.KeyDate1.value = "2020-03-31";
						f.KeyDate2.value = "2020-03-31";
					} else if (n == "W") {
						f.KeyDate1.value = "2020-03-29";
						f.KeyDate2.value = "2020-04-04";
					} else if (n == "M") {
						f.KeyDate1.value = "2020-03-01";
						f.KeyDate2.value = "2020-03-31";
					} else if (n == "Y") {
						f.KeyDate1.value = "2020-01-01";
						f.KeyDate2.value = "2020-12-31";
					} else if (n == "1M") {
						f.KeyDate1.value = "2020-02-29";
						f.KeyDate2.value = "2020-03-31";
					} else if (n == "3M") {
						f.KeyDate1.value = "2019-12-31";
						f.KeyDate2.value = "2020-03-31";
					} else if (n == "6M") {
						f.KeyDate1.value = "2019-09-30";
						f.KeyDate2.value = "2020-03-31";
					} else if (n == "1Y") {
						f.KeyDate1.value = "2019-03-31";
						f.KeyDate2.value = "2020-03-31";
					} else {

						var date = new Date();
						var start = new Date(Date.parse(date) - n * 1000 * 60
								* 60 * 24);
						var yyyy = start.getFullYear();
						var mm = start.getMonth() + 1;
						var dd = start.getDate();

						if (mm < 10) {
							mm = "0" + mm;
						}
						if (dd < 10) {
							dd = "0" + dd;
						}
						f.KeyDate1.value = yyyy + "-" + mm + "-" + dd;
						f.KeyDate2.value = "2020-03-31";

					}

					document.getElementById("" + n).className = "btn_CDay_on";

				}

				// **********************************************************
				// 회원관련
				// **************************************************************************************************************

			} else if ((Num == "StudnetWithdrawal")
					|| (Num == "StudnetRestore") || (Num == "StudnetDel")) {

				if (Num == "StudnetWithdrawal") {
					Msg = "탈퇴 처리 하시겠습니까?"
				} else if (Num == "StudnetRestore") {
					Msg = "복원 처리 하시겠습니까?"
				} else if (Num == "StudnetDel") {
					Msg = "- 삭제할려는 학생이 기존에 사용 이력이 있으면\n  해당 이력에 오류가 발생 할 수도 있습니다.\n- 해당 이력 : 신청관련, 수업관련, 포인트, 쿠폰 등등\n\n정말로 삭제 하시겠습니까?"
				}

				if (confirm("" + Msg)) {
					var Location_URL = location.href;
					location.href = 'student_reg_sql.asp?Sel=' + escape(Sel0)
							+ '&PageAction=' + escape(Num) + '&Location_URL='
							+ escape(Location_URL);
				} else {
				}

			} else if ((Num == "TeacherStop") || (Num == "TeacherUse")
					|| (Num == "TeacherDel")) {

				if (Num == "TeacherStop") {
					Msg = "[사용중지]으로 변경하시겠습니까?"
				} else if (Num == "TeacherUse") {
					Msg = "[사용]으로 변경하시겠습니까?"
				} else if (Num == "TeacherDel") {
					Msg = "- 강사를 삭제하면 \n  강사의 해당 수업 및 통계등에서 오류가 발생할 수 있습니다.\n- 삭제보다는 [사용중지]을 권장합니다.\n\n정말로 삭제 하시겠습니까?"
				}

				if (confirm("" + Msg)) {
					var Location_URL = location.href;
					location.href = 'teacher_sql.asp?Sel=' + escape(Sel0)
							+ '&PageAction=' + escape(Num) + '&Location_URL='
							+ escape(Location_URL);
				} else {
				}

			} else if (Num == "ManagerDel") {

				if (confirm("정말로 삭제 하시겠습니까?")) {
					var Location_URL = location.href;
					location.href = 'manager_reg_sql.asp?Sel=' + escape(Sel0)
							+ '&PageAction=' + escape(Num) + '&Location_URL='
							+ escape(Location_URL);
				} else {
				}

			} else if ((Num == "TeacherHomepageDisplay")
					|| (Num == "TeacherHomepageHidden")) {

				if (Num == "TeacherHomepageDisplay") {
					var Msg = "[표시]으로 변경하시겠습니까?"
				} else if (Num == "TeacherHomepageHidden") {
					var Msg = "[숨김]으로 변경하시겠습니까?"
				}

				if (confirm("" + Msg)) {
					var Location_URL = location.href;
					location.href = 'teacher_profile_sql.asp?Sel='
							+ escape(Sel0) + '&PageAction=' + escape(Num)
							+ '&Location_URL=' + escape(Location_URL);
				} else {
				}

				// ********************************************************** 회원
				// 상담 관련
				// **************************************************************************************************************

			} else if (Num == "CounselingDel") { // 파일삭제

				if (confirm("정말로 삭제 하시겠습니까?")) {
					var Location_URL = location.href;
					var PageAction = "Del"
					location.href = 'student_counseling_sql.asp?Sel='
							+ escape(Sel0) + '&PageAction='
							+ escape(PageAction) + '&Location_URL='
							+ escape(Location_URL);
				} else {
				}

				// **********************************************************
				// 회원등급관련
				// **************************************************************************************************************
			} else if ((Num == "StudentGradeUse") || (Num == "StudentGradeNo")) {

				if (Num == "StudentGradeUse") {
					var Msg = "[사용]으로 변경하시겠습니까?"
				} else if (Num == "StudentGradeNo") {
					var Msg = "[사용안함]으로 변경하시겠습니까?"
				}

				if (confirm("" + Msg)) {
					var Location_URL = location.href;
					location.href = 'student_grade_sql.asp?Sel=' + escape(Sel0)
							+ '&PageAction=' + escape(Num) + '&Location_URL='
							+ escape(Location_URL);
				} else {
				}

				// **********************************************************
				// 수업관련
				// **************************************************************************************************************

			} else if (Num == "ClassDel") { // 수업 삭제

				if (confirm("- 수업을 삭제하면 수업과 관련된 모든 파일이 삭제됩니다.\n- 삭제대상 : 수업정보, 출석정보, 수업파일, 월별평가서, 수업히스토리등 수업관련된 모든 파일\n\n정말로 삭제 하시겠습니까?")) {
					var Location_URL = location.href;
					location.href = 'class_reg_sql.asp?Sel=' + escape(Sel0)
							+ '&PageAction=' + escape(Num) + '&Location_URL='
							+ escape(Location_URL);
				} else {
				}

			} else if (Num == "ClassFileDel") { // 파일삭제

				if (confirm("정말로 삭제 하시겠습니까?")) {
					var Location_URL = location.href;
					var PageAction = "ClassFileDel"
					location.href = 'class_file_list_del_sql.asp?Sel='
							+ escape(Sel0) + '&PageAction=' + escape(Num)
							+ '&Location_URL=' + escape(Location_URL);
				} else {
				}

			} else if ((Num == "ApprovalDaily")
					|| (Num == "ApprovalCancelDaily")) { // Daily Rerport일괄
				// 승인/승인취소

				if (Num == "ApprovalDaily") {

					if ((Sel3.indexOf("100") > -1)
							|| (Sel3.indexOf("300") > -1)) {
						alert("[Daily Report]\n\n[승인 전] 리스트만 선택해주세요.")
						return false;
					}
					var Batch_Step = "300"
					var Msg = "승인 하시겠습니까?"

				} else if (Num == "ApprovalCancelDaily") {

					if ((Sel3.indexOf("100") > -1)
							|| (Sel3.indexOf("200") > -1)) {
						alert("[Daily Report]\n\n[승인 된] 리스트만 선택해주세요.")
						return false;
					}
					var Batch_Step = "200"
					var Msg = "승인취소 하시겠습니까?"

				}

				var PageAction = "ApprovalDailyMuti";
				var Location_URL = location.href;

				if (confirm("[Daily Report]\n\n" + Msg)) {
					self.location.href = '../class/daily_report_sql.asp?PageAction='
							+ PageAction
							+ '&Sel='
							+ Sel0
							+ '&Batch_Step='
							+ Batch_Step
							+ '&ClassSKU='
							+ Sel4
							+ '&Location_URL=' + escape(Location_URL);
				} else {
				}

			} else if (Num == "RegDailyMulti") { // 출/결 일괄 처리

				if ((Sel2.indexOf("#HOLD#") > -1)
						|| (Sel2.indexOf("#HOLDW#") > -1)
						|| (Sel2.indexOf("#HOLDW#") > -1)) {
					alert("[Daily Report]\n\n[출석/결석/취소] 리스트만 선택해주세요.")
				} else {
					if (confirm("[Daily Report]\n\n[확인사항]\n1.이미 작성된 내용은 신규로 작성한 내용으로 모두 변경됩니다.\n2.기존 수업파일도 모두 변경됩니다.")) {
						parent.open_box('daily_report_reg_pop_batch.asp?Sel='
								+ Sel0, 850, 750);
					} else {
					}
				}

			} else if (Num == "DelDailyMulti") { // 출/결 일괄 처리

				var PageAction = Num;
				var Location_URL = location.href;

				if (confirm("[Daily Report] 삭제하시겠습니까?")) {
					self.location.href = '../class/daily_report_sql.asp?PageAction='
							+ PageAction
							+ '&Sel='
							+ Sel0
							+ '&Location_URL='
							+ escape(Location_URL);
				} else {
				}

			} else if ((Num == "ApprovalMonthly")
					|| (Num == "ApprovaCancelMonthly")) { // Monthly Rerport일괄
				// 승인/승인취소

				if (Num == "ApprovalMonthly") {

					if (Sel2.indexOf("300") > -1) {
						alert("[Monthly Report]\n\n[승인 전] 리스트만 선택해주세요.")
						return false;
					}
					var Batch_Step = "300"
					var Msg = "승인 하시겠습니까?"

				} else if (Num == "ApprovaCancelMonthly") {

					if (Sel2.indexOf("200") > -1) {
						alert("[Monthly Report]\n\n[승인 전] 리스트만 선택해주세요.")
						return false;
					}
					var Batch_Step = "200"
					var Msg = "승인취소 하시겠습니까?"

				}

				var PageAction = "ApprovalMonthlyMuti";
				var Location_URL = location.href;

				if (confirm("" + Msg)) {
					self.location.href = '../class/monthly_report_sql.asp?PageAction='
							+ PageAction
							+ '&Sel='
							+ Sel0
							+ '&Batch_Step='
							+ Batch_Step
							+ '&ClassSKU='
							+ Sel3
							+ '&Location_URL=' + escape(Location_URL);
				} else {
				}

			} else if (Num == "DelMonthlyMulti") { // 출/결 일괄 처리

				var PageAction = Num;
				var Location_URL = location.href;

				if (confirm("[Monthly Report] 삭제하시겠습니까?")) {
					self.location.href = '../class/monthly_report_sql.asp?PageAction='
							+ PageAction
							+ '&Sel='
							+ Sel0
							+ '&Location_URL='
							+ escape(Location_URL);
				} else {
				}

			} else if ((Num == "ApprovalHold") || (Num == "ApprovalCancelHold")
					|| (Num == "DelHold")) { // HOLD 일괄 승인/승인취소

				if (Num == "ApprovalHold") {

					if (Sel2.indexOf("#HOLD#") > -1) {
						alert("[승인 전] 리스트만 선택해주세요.");
						return;
					}

				} else if (Num == "ApprovalCancelHold") {

					if (Sel2.indexOf("#HOLD#") > -1) {
						alert("[승인 전] 리스트만 선택해주세요.");
						return;
					}

				} else if (Num == "DelHold") {

					if ((Sel2.indexOf("#HOLDW#") > -1)
							|| (Sel3.indexOf("#PRESENT#") > -1)) {
						alert("[승인된 홀드, 수업전 홀드]만 선택해주세요.")
						return;
					}

				}

				var PageAction = Num;
				var Location_URL = location.href;
				parent.open_box('hold_status_pop_batch.asp?PageAction='
						+ PageAction + '&Sel=' + Sel0, 700, 300);

			} else if (Num == "HoldMulti") { // HOLD 일괄 처리

				if ((Sel2.indexOf("#PRESENT#") > -1)
						|| (Sel2.indexOf("#ABSENT#") > -1)
						|| (Sel2.indexOf("#CANCEL#") > -1)
						|| (Sel2.indexOf("#HOLD#") > -1)
						|| (Sel2.indexOf("#HOLDW#") > -1)
						|| (Sel2.indexOf("#HOLDWBA#") > -1)) {
					alert("[홀드]\n\n[수업 전] 리스트만 선택해주세요.")
				} else {
					parent.open_box('hold_reg_pop_batch.asp?Sel=' + Sel0, 850,
							600);
				}

				// **********************************************************
				// POINT관련
				// **************************************************************************************************************

			} else if (Num == "DelPoint") { // 삭제

				if (confirm("정말로 삭제 하시겠습니까?")) {
					var Location_URL = location.href;
					var PageAction = Num;
					location.href = 'point_sql.asp?Sel=' + escape(Sel0)
							+ '&PageAction=' + escape(PageAction)
							+ '&Location_URL=' + escape(Location_URL);
				} else {

				}

			} else if (Num == "AccPointMulti") { // 등록

				if (confirm("[포인트] 적립하시겠습니까?")) {
					var Location_URL = location.href;
					var PageAction = Num;
					location.href = 'point_sql.asp?Sel=' + escape(Sel0)
							+ '&PageAction=' + escape(PageAction)
							+ '&Location_URL=' + escape(Location_URL);
				} else {

				}

				// **********************************************************
				// COUPON관련
				// **************************************************************************************************************

			} else if (Num == "CouponDel") {

				if (Sel2.indexOf("N") > -1) {
					alert("이미 회원에게 발행된 쿠폰이 있어 수정 및 삭제할 수 없습니다.")
					return;
				} else {

					if (confirm("정말로 삭제 하시겠습니까?")) {
						var Location_URL = location.href;
						location.href = 'coupon_sql.asp?Sel=' + escape(Sel0)
								+ '&PageAction=' + escape(Num)
								+ '&Location_URL=' + escape(Location_URL);
					} else {
					}

				}

			} else if (Num == "IssueCouponDel") {

				if (Sel2.indexOf("Y") > -1) {
					alert("이미 적립금으로 전환된 쿠폰이 있어 수정 및 삭제할 수 없습니다.")
					return;
				} else {

					if (confirm("정말로 삭제 하시겠습니까?")) {
						var Location_URL = location.href;
						location.href = 'coupon_sql.asp?Sel=' + escape(Sel0)
								+ '&PageAction=' + escape(Num)
								+ '&Location_URL=' + escape(Location_URL);
					} else {
					}

				}

				// **********************************************************
				// SMS관련
				// **************************************************************************************************************

			} else if (Num == "DelSMSGroup") {

				if (confirm("정말로 삭제 하시겠습니까?")) {
					var Location_URL = location.href;
					location.href = 'sms_group_sql.asp?Sel=' + escape(Sel0)
							+ '&PageAction=' + escape(Num) + '&Location_URL='
							+ escape(Location_URL);
				} else {
				}

			} else if (Num == "DelSMSSendList") {

				if (confirm("정말로 삭제 하시겠습니까?")) {
					var Location_URL = location.href;
					location.href = 'sms_sql.asp?Sel=' + escape(Sel0)
							+ '&PageAction=' + escape(Num) + '&Location_URL='
							+ escape(Location_URL);
				} else {
				}

			} else if (Num == "CancelSMSReservation") {

				if (confirm("SMS 발송 예약을 취소 하시겠습니까?")) {
					var Location_URL = location.href;
					location.href = 'sms_reservation_cancel_sql.asp?Sel='
							+ escape(Sel0) + '&PageAction=' + escape(Num)
							+ '&Location_URL=' + escape(Location_URL);
				} else {
				}

				// **********************************************************
				// 교재관련
				// **************************************************************************************************************
			} else if ((Num == "TextBookHomepageDisplay")
					|| (Num == "TextBookHomepageHidden")) {

				if (Num == "TextBookHomepageDisplay") {
					var Msg = "[표시]으로 변경하시겠습니까?"
				} else if (Num == "TextBookHomepageHidden") {
					var Msg = "[숨김]으로 변경하시겠습니까?"
				}

				if (confirm("" + Msg)) {
					var Location_URL = location.href;
					location.href = 'textbook_sql.asp?Sel=' + escape(Sel0)
							+ '&PageAction=' + escape(Num) + '&Location_URL='
							+ escape(Location_URL);
				} else {
				}

				// **********************************************************
				// 수강료입금현황
				// **************************************************************************************************************

			} else if (Num == "DepositMutilDel") { // 파일삭제

				if (confirm("정말로 삭제 하시겠습니까?")) {
					var Location_URL = location.href;
					location.href = 'deposit_sql.asp?Sel=' + escape(Sel0)
							+ '&PageAction=' + escape(Num) + '&Location_URL='
							+ escape(Location_URL);
				} else {
				}

				// **********************************************************
				// 결제리스트
				// **************************************************************************************************************

			} else if (Num == "DelPaymentMulti") { // 파일삭제

				if (confirm("정말로 삭제 하시겠습니까?")) {
					var Location_URL = location.href;
					location.href = 'class_payment_sql.asp?Sel=' + escape(Sel0)
							+ '&PageAction=' + escape(Num) + '&Location_URL='
							+ escape(Location_URL);
				} else {
				}

				// **********************************************************
				// 강사료 지불 관리
				// **************************************************************************************************************

			} else if (Num == "TeacherFeesMutilDel") { // 파일삭제

				if (confirm("정말로 삭제 하시겠습니까?")) {
					var Location_URL = location.href;
					location.href = 'teacher_accounting_sql.asp?Sel='
							+ escape(Sel0) + '&PageAction=' + escape(Num)
							+ '&Location_URL=' + escape(Location_URL);
				} else {
				}

				// **********************************************************
				// 레벨테스트
				// **************************************************************************************************************

			} else if ((Num == "ApprovalLevelTest")
					|| (Num == "ApprovaCancelLevelTest")) { // LevelTest
				// Rerport일괄 승인/승인취소

				if (Num == "ApprovalLevelTest") {
					if ((Sel3.indexOf("100") > -1)
							|| (Sel3.indexOf("200") > -1)
							|| (Sel3.indexOf("400") > -1)) {
						alert("[승인 전] 리스트만 선택해주세요.");
						return;
					}
					var Batch_Step = "400"
				} else if (Num == "ApprovaCancelLevelTest") {

					if ((Sel3.indexOf("100") > -1)
							|| (Sel3.indexOf("200") > -1)
							|| (Sel3.indexOf("300") > -1)) {
						alert("[승인 된] 리스트만 선택해주세요.");
						return;
					}
					var Batch_Step = "300"
				}

				var PageAction = "ApprovalMuti";
				var Location_URL = location.href;

				self.location.href = '../application/leveltest_result_sql.asp?PageAction='
						+ PageAction
						+ '&Sel='
						+ Sel0
						+ '&Batch_Step='
						+ Batch_Step + '&Location_URL=' + escape(Location_URL);

			}

		}

	}

}
