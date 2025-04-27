function query() {
	query_criteria_frame.location.href = "../../eOP/jsp/ProcessReferralMain.jsp";
}

function reset() {
	frames[2].location.href = "../../eCommon/jsp/error.jsp";
	frames[1].frames[0].document.forms[0].reset();
	frames[1].frames[0].document.forms[0].search_button.disabled = false;

	frames[1].frames[1].location.href = "../../eCommon/html/blank.html";
}

function onSuccess() {
	var ctbFrame = commontoolbarFrame.location.href
	query_criteria_frame.result_frame.location.reload();
	commontoolbarFrame.location.href = ctbFrame;
}

function clearqry() {
	parent.frames[0].document.query_criteria_form.search_button.disabled = false;

	parent.frames[0].document.query_criteria_form.txtdtfrm.value = "";
	parent.frames[0].document.query_criteria_form.txtdtto.value = "";
	parent.frames[0].document.query_criteria_form.episode_no.value = "";
	parent.frames[1].location.href = "../../eCommon/html/blank.html";

}

function chkfld() {
	parent.query_frame.document.query_criteria_form.txtdtto.onblur();
	var dateFrm = parent.query_frame.document.query_criteria_form.txtdtfrm.value;
	var dateTo = parent.query_frame.document.query_criteria_form.txtdtto.value;

	
	if(dateFrm == "" && dateTo == ""){
		alert(getMessage('FRM_AND_TO_DT_CANNOT_BLANK','OP'));
		return false;
	}

	if (dateFrm != "" && dateTo != "") {
		if (isBefore(dateFrm, dateTo, 'DMY', localeName) == false) {
			alert(getMessage('TO_DT_GR_EQ_FM_DT', 'SM'))
			parent.query_frame.document.forms[0].txtdtto.select();
			return false;
		}
	}

	if (dateFrm != "")
		dateFrm = convertDate(dateFrm, "DMY", localeName, "en");
	if (dateTo != "")
		dateTo = convertDate(dateTo, "DMY", localeName, "en");

	//validate_date_from(dateFrm);
	//validate_date_to(dateTo, dateFrm);


	var episode_id = parent.query_frame.document.query_criteria_form.episode_no.value;

	if (episode_id != "") {
		var alphabet = false;
		for (i = 0; i < episode_id.length; i++) {
			if (!(episode_id.charCodeAt(i) >= 48 && episode_id.charCodeAt(i) <= 57)) {
				alphabet = true;
			}
		}

		if (alphabet) {
			alert(getMessage("OP_INVALID_EPISODE", 'OP'));
			parent.query_frame.document.query_criteria_form.episode_no.value="";
			parent.query_frame.document.query_criteria_form.episode_no.focus();
			return false;
		}
	}
	parent.frames[0].document.query_criteria_form.search_button.disabled = false;

	var qrystr = "blnk=N&dtfrm=" + dateFrm + "&episode_id=" + episode_id
			+ "&dtto=" + dateTo + "&srch=Y";

	if (dateFrm == "" && dateTo == "") {
		parent.result_frame.location.href = "../../eOP/jsp/ProcessReferralResult.jsp?"
				+ qrystr;
	} else if ((dateFrm != "" && dateTo == "")
			|| (dateFrm == "" && dateTo != "")) {
		alert(getMessage('FRM_TO_DT_CANNOT_BLANK', 'OP'));
	} else {
		parent.result_frame.location.href = "../../eOP/jsp/ProcessReferralResult.jsp?"
				+ qrystr;
	}
}

function validate_date_to(to, from) {
	if (to.value != "") {
		if (!validDateObj(to, "DMY", localeName)) {
			to.value = "";
			return;
		}
var sys = getCurrentDate('DMY', 'en');
		var obj1 = convertDate(to.value, "DMY", localeName, "en");
		if (isBefore(obj1, sys, 'DMY', 'en') == false) {
			alert(getMessage("TO_DATE_NOT_GREATER_SYSDATE", "SM"));
			to.value = "";
			to.select();
			parent.frames[0].document.query_criteria_form.search_button.disabled = false;
			return false;
		}

		if (from.value != "" && to.value != "") {
			if (isBefore(from.value, to.value, 'DMY', localeName) == false) {
				alert(getMessage("TO_DT_GR_EQ_FM_DT", "SM"));
				to.value = "";
				to.select();
				return false;
			} else {

				var dateAftTwWeek = plusDate(from.value, 'DMY', 'en', 14, 'd');
				if (isBetween(from.value, dateAftTwWeek, to.value, 'DMY', 'en') == false) {
					//alert("Date is out of Two weeks");
					alert(getMessage("GREATER_THAN_TWO_WEEKS", "SM"));
					to.value = "";
					parent.frames[0].document.query_criteria_form.search_button.disabled = false;
					to.select();
					parent.frames[1].location.href = "../../eCommon/html/blank.html";
					return false;
				}
				//console.log(dateAftTwWeek);
				//alert(dateAftTwWeek);
				return true;
			}
		}
	}
}

function validate_date_from(from) {
	var sys = getCurrentDate('DMY', 'en');
	// alert(sys);
	if (from.value != "") {
		if (!validDateObj(from, "DMY", localeName)) {
			from.value = "";
			return;
		}
		var obj1 = convertDate(from.value, "DMY", localeName, "en");
		if (isBefore(obj1, sys, 'DMY', 'en') == false) {
			alert(getMessage("FROM_DATE_LESS_SYSDATE", "SM"));
			from.value = "";
			from.select();
			return false;
		} else
			return true;
	}
}

function validateForCurrDate(obj) {
	var currDate = getCurrentDate('DMY', 'en');
	if (isBefore(currDate, obj.value, 'DMY', 'en')) {
		alert(getMessage("FROM_DT_NGE_CURR_DATE", "SM"));
		obj.value = '';
	} else {
		alert('From Date OK');
	}
}

function validateDateForTwWeeks(obj) {

	var fromdt = document.query_criteria_form.txtdtfrm.value;

	if (fromdt == '') {
		alert('Please Enter from date');
	} else {

		if (isBefore(fromdt, obj.value, 'DMY', 'en')) {
		//	alert(fromdt);
			var finaldate = plusDate(fromdt, 'DMYHM', 14, 'd')
		//	alert("Date after 14 days: " + finaldate);
		} else {
			alert("To date cannot be a Before date of FROM");
			obj.value = "";
		}

	}
}

async function authUser(patid, speciality_code, locn_type, locn_code, cntr,
		referredYN, episode_id, encounter_id, service_code, referral_id, visit_id, patient_class) {
	var privilege_yn = document.proc_ref_priv_form.privilege_yn.value;
	if(privilege_yn=='N'){
	var features	= "dialogHeight:30vh; dialogWidth:40vw";
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../eSM/jsp/AuthorizeMain.jsp?resp_id=OP&func_id=PROCESS_REF",arguments,features);

		if (retVal == true) {
			if (referredYN == 'N') {
				getReferralID(patid, speciality_code, locn_type, locn_code,
						cntr, episode_id, encounter_id, service_code, visit_id, patient_class);
			} else if (referredYN == 'Y') {
				processDelinkReferral(patid, speciality_code, speciality_code,
						locn_code, episode_id, encounter_id, service_code,
						referral_id, visit_id, patient_class)
			}
		} else {
			return false;
		}
	} else if (privilege_yn == 'Y') {
		if (referredYN == 'N') {
			getReferralID(patid, speciality_code, locn_type, locn_code, cntr,
					episode_id, encounter_id, service_code,  visit_id, patient_class);
		} else if (referredYN == 'Y') {
			processDelinkReferral(patid, speciality_code, speciality_code,
					locn_code, episode_id, encounter_id, service_code,
					referral_id,  visit_id, patient_class)
		}
	}
}

function processLinkReferral(patid, episode_id, referral_id, locn_code, encounter_id, service_code,visit_id, patient_class) {
	var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='linkReferralForm' id='linkReferralForm' method='post' action='../../servlet/eOP.ProcessReferralNonReferralServlet' target='messageFrame'><input type='hidden' name='referral_id' id='referral_id' value='"
			+ referral_id
			+ "'><input type='hidden' name='referred_yn' id='referred_yn' value='Y'><input type='hidden' name='episode_id' id='episode_id' value='"
			+ episode_id
			+ "'><input type='hidden' name='patient_id' id='patient_id' value='"
			+ patid
			+ "'><input type='hidden' name='ref_locn_code' id='ref_locn_code' value='"
			+ locn_code
			+ "'><input type='hidden' name='encounter_id' id='encounter_id' value='"
			+ encounter_id
			+ "'><input type='hidden' name='service_code' id='service_code' value='"
			+ service_code
			+ "'><input type='hidden' name='visit_id' id='visit_id' value='"
			+ visit_id
			+ "'><input type='hidden' name='patient_class' id='patient_class' value='"
			+ patient_class
			+ "'><input type='hidden' name='mode' id='mode' value='link'></form></BODY></HTML>";
	document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	document.linkReferralForm.submit();
}

function processDelinkReferral(patid, speciality_code, locn_type, locn_code,
		episode_id, encounter_id, service_code, referral_id, visit_id, patient_class) {
	var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='delinkReferralForm' id='delinkReferralForm' method='post' action='../../servlet/eOP.ProcessReferralNonReferralServlet' target='messageFrame'><input type='hidden' name='referral_id' id='referral_id' value='"
			+ referral_id
			+ "'><input type='hidden' name='referred_yn' id='referred_yn' value='N'><input type='hidden' name='episode_id' id='episode_id' value='"
			+ episode_id
			+ "'><input type='hidden' name='patient_id' id='patient_id' value="
			+ patid
			+ "><input type='hidden' name='ref_locn_code' id='ref_locn_code' value='"
			+ locn_code
			+ "'><input type='hidden' name='encounter_id' id='encounter_id' value='"
			+ encounter_id
			+ "'><input type='hidden' name='service_code' id='service_code' value='"
			+ service_code
			+ "'><input type='hidden' name='visit_id' id='visit_id' value='"
			+ visit_id
			+ "'><input type='hidden' name='patient_class' id='patient_class' value='"
			+ patient_class
			+ "'><input type='hidden' name='mode' id='mode' value='delink'></form></BODY></HTML>";

	document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	document.delinkReferralForm.submit();
}

async function getReferralID(patid, speciality_code, locn_type, locn_code, counter, episode_id, encounter_id, service_code,  visit_id, patient_class) {
	var funcid = "REFERAL_REQUIRED";

	var retVal;
	var dialogTop = "";
	var dialogHeight = "42vh";
	var dialogWidth = "70vw";
	var arguments = "";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:"
			+ dialogWidth + "; center: " + center + "; status: " + status
			+ "; dialogTop :" + dialogTop + "; scrolling :" + "NO";
	var arguments = "";

	oth_params = "&p_service_code=" + service_code + "&p_patient_id=" + patid
			+ "&p_to_locn_code=" + locn_code + "&p_speciality_code="
			+ speciality_code + "&p_to_locn_type=" + locn_type;

	var url = "../../eMP/jsp/ReferralSearchFrameset.jsp?p_calling_function=OP_REG_VISIT&p_select=YES&p_reg_patient=YES&ass_func_id="
			+ funcid + oth_params

	retVal = await window.showModalDialog(url, arguments, features);
	processLinkReferral(patid, episode_id, retVal, locn_code, encounter_id,
			service_code, visit_id, patient_class);

}


/*var patient_id= document.forms[0].patient_id.value;
var locn_type = document.forms[0].locn_type.value;
var assign_care_locn_code =document.forms[0].assign_care_locn_code.value;
var speciality_code = document.forms[0].locationSpeciality.value;
var visit_type_code = document.forms[0].visit_adm_type.value;
var service_code=document.forms[0].service_code.value;*/


	

