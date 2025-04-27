/*
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
24-JAN-2018      100           	Aravindh.H          Created
---------------------------------------------------------------------------------------------------------------
 */

function reset() {
	splAgencyDeposit.document.location.reload();
}

function getPatID(obj) {
	pat_id = PatientSearch();

	if (pat_id != null) {
		obj.value = pat_id;
	}
}

function run() {

	messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	
	var parentForm = parent.content.splAgencyDeposit.document.forms[0];
	
	var facility_id = parentForm.facility_id.value;
	var report_id = parentForm.report_id.value;
	var locale = parentForm.locale.value;
	var fromPatientId = parentForm.fromPatID.value;
	var toPatientId = parentForm.toPatID.value;
	var loggedUserId = parentForm.userid.value;

	if (fromPatientId == "") {
		var str = getLabel("eBL.Patient_Id_From.label", "Common");

		var error = getMessage("CAN_NOT_BE_BLANK", "COMMON");
		error = error.replace("$", str);
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="
				+ error;

		parentForm.fromPatID.focus();

		chkConditoin = false;

		return false;
	}

	if (toPatientId == "") {
		parent.content.splAgencyDeposit.document.getElementById("toPatID").value = fromPatientId;
		toPatientId = fromPatientId;
	}

	if (fromPatientId != "" && toPatientId != "") {

		var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=comparePatientId&fromPatId="
				+ fromPatientId + "&toPatId=" + toPatientId;
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send();
		var responseText = trimString(xmlHttp.responseText);
		if (responseText == "false") {
			var str1 = getLabel("eBL.Patient_Id_From.label", "Common");
			var str2 = getLabel("eBL.Patient_Id_To.label", "Common");

			var error = getMessage("REMARKS_SHOULD_GR_EQUAL", "COMMON");
			error = error.replace("$", str2);
			error = error.replace("#", str1);

			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="
				+ error;

			parentForm.toPatID.focus();
			return false;
		}
	}

	$
			.ajax({
				type : "GET",
				url : "../jsp/BLCommonReportValidation.jsp?p_report_id="
						+ report_id + "&param1=" + fromPatientId + "&param2="
						+ toPatientId + "&param3=" + loggedUserId,
				data : "",
				async : false,
				dataType : "text",
				success : function(data) {

					var session_id = '';
					var pgm_date = '';

					var retVal = trimString(data).split(":::");

					if (retVal.length == 2) {
						session_id = retVal[0];
						pgm_date = retVal[1];
					}

					var dummyDoc = dummy_frame.document;
					var htmlVal = "<html><body>";
					htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
					htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"
							+ facility_id + "'>";
					htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"
							+ locale + "'>";
					htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"
							+ report_id + "'>";
					htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"
							+ session_id + "'>";
					htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"
							+ pgm_date + "'>";
					htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"
							+ "BL" + "'>";
					htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"
							+ report_id + "'>";

					htmlVal += "</form></body></html>";

					dummyDoc.body.insertAdjacentHTML("afterbegin", HTMLVal);
					dummyDoc.dummy_frm.submit();

				},
				error : function(xhr, ajaxOptions, thrownError) {
					alert(xhr);
					alert(ajaxOptions);
				}
			});
}

function trimString(sInString) {
	return sInString.replace(/^\s+|\s+$/g, "");
}

function callPatValidation(obj) {
	var patient_id = obj.value;
	if (patient_id != "") {
		var function_id = "PAT_CHK";
		var xmlStr = "<root><SEARCH ";
		xmlStr += "patient_id=\"" + patient_id + "\" ";
		xmlStr += " /></root>";
		var temp_jsp = "PkgSubscriptionValidation.jsp?func_mode=CHK_PAT_ID&function_id="
				+ function_id;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		var responseText = trimString(xmlHttp.responseText);
		if (responseText == "N") {
			alert(getMessage("INVALID_PATIENT", "MP"));
			obj.select();
		}
	}
}

function downloadExcel() {
	
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	
	var fromPatientId = document.forms[0].fromPatID.value;
	var toPatientId = document.forms[0].toPatID.value;
	
	if (fromPatientId == "") {
		var str = getLabel("eBL.Patient_Id_From.label", "Common");

		var error = getMessage("CAN_NOT_BE_BLANK", "COMMON");
		error = error.replace("$", str);
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="
				+ error;

		document.forms[0].fromPatID.focus();

		chkConditoin = false;

		return false;
	}

	if (toPatientId == "") {
		document.getElementById("toPatID").value = fromPatientId;
		toPatientId = fromPatientId;
	}

	if (fromPatientId != "" && toPatientId != "") {

		var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=comparePatientId&fromPatId="
				+ fromPatientId + "&toPatId=" + toPatientId;
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send();
		var responseText = trimString(xmlHttp.responseText);
		if (responseText == "false") {
			var str1 = getLabel("eBL.Patient_Id_From.label", "Common");
			var str2 = getLabel("eBL.Patient_Id_To.label", "Common");

			var error = getMessage("REMARKS_SHOULD_GR_EQUAL", "COMMON");
			error = error.replace("$", str2);
			error = error.replace("#", str1);

			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="
				+ error;

			document.forms[0].toPatID.focus();
			return false;
		}
	}
	
	var urlPath = "../../eBL/jsp/BLPatientWiseSplAgencyDepositTransExcelDwld.jsp?fromPatId="
			+ fromPatientId + "&toPatId=" + toPatientId;

	//window.open(urlPath);
	
	parent.frames[1].document.forms[0].method	= "POST";
	parent.frames[1].document.forms[0].action	= urlPath;
	
	parent.frames[1].document.forms[0].submit();
}

