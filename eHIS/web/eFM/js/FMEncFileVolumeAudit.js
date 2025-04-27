function reset(){
	criteria_frame.document.location.reload();
	patient_line_frame.document.location.href="../../eCommon/html/blank.html";
	result_frame.document.location.href="../../eCommon/html/blank.html";
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
}

function clearPage() {
	parent.patient_line_frame.document.location.href	= "../../eCommon/html/blank.html";
	parent.result_frame.document.location.href			= "../../eCommon/html/blank.html";
	parent.messageFrame.document.location.href			= "../../eCommon/jsp/error.jsp";
}

function fnShowNoRecords(){
	alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
	parent.result_frame.document.location.href			= "../../eCommon/html/blank.html";
	parent.messageFrame.document.location.href			= "../../eCommon/jsp/error.jsp";;
}

function getResults() {
		var patient_id		= document.forms[0].patient_id.value;
		var file_type_appl_yn = document.forms[0].file_type_appl_yn.value;
		var file_no	= "";
		var file_type = "";

		if(file_type_appl_yn == "N") {
			file_no		= document.forms[0].file_no.value;
		}
		
		if(file_type_appl_yn == "Y") {
			file_type	= document.forms[0].patient_file_type.value;
		}

		
		if(patient_id == "") {
			var errormsg=getMessage("CAN_NOT_BE_BLANK","common");
			errormsg=errormsg.replace('$',getLabel("Common.patientId.label","common"));
			alert(errormsg);
			document.forms[0].patient_id.focus();
			return;
		}
		parent.result_frame.document.location.href="../../eFM/jsp/FMEncFileVolumeAuditResult.jsp?patient_id="+patient_id+"&file_no="+file_no+"&file_type="+file_type+"&file_type_appl_yn="+file_type_appl_yn;
}


