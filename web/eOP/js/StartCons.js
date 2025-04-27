function closewin()
		{	
			//window.parent.close();
			parent.parent.document.getElementById("dialog_tag").close();
		}	
function PopulateThis() {		
	/*Added by Thamizh selvi on 17th Oct 2017 for ML-MMOH-CRF-0623 Start*/
	var moduleId = parent.frames[1].document.forms[0].moduleId.value;
	var allowBackdateConsYn = parent.frames[1].document.forms[0].allowBackdateConsYn.value;
	var chkBackDatedCons = "N";

	if (allowBackdateConsYn == "Y" && moduleId == "AE") {
		chkBackDatedCons = parent.frames[1].document.forms[0].chkBackDatedCons.value;
	}
	
	if (moduleId == "AE" && allowBackdateConsYn == "Y" && chkBackDatedCons == "Y") {
		var aeParamAllowedDate = parent.frames[1].document.forms[0].aeParamAllowedDate.value;
		var startConsDateTime = parent.frames[1].document.forms[0].start_cons_date_time.value;
		var assignTrmtAreaDateTime = parent.frames[1].document.forms[0].assignTrmtAreaDateTime.value;

		if (startConsDateTime === "") {
			var error = getMessage('CAN_NOT_BE_BLANK', 'Common');
			error = error.replace("$", getLabel("eOP.StartofConsultation.label", "OP"));
			alert(error);
			parent.frames[1].document.forms[0].start_cons_date_time.focus();
			return false;  
		} else {
			var sysDateTime = getSysDateTime();

			if (!isAfter(startConsDateTime, aeParamAllowedDate, "DMYHM", localeName)) {
				var error = getMessage('AE_PARAM_CONS_DATE_TIME', 'AE');
				var paramValue = parent.frames[1].document.forms[0].allowBackdateConsHrs.value;
				paramValue += (paramValue == 1) ? " " + getLabel("Common.hours.label", "Common").substring(0, 4).toLowerCase() : " " + getLabel("Common.hours.label", "Common").toLowerCase();
				error = error.replace("$", paramValue);
				alert(error);
				parent.frames[1].document.forms[0].start_cons_date_time.select();
				parent.frames[1].document.forms[0].start_cons_date_time.focus();				
				return false;
			} else if (!isAfter(startConsDateTime, assignTrmtAreaDateTime, "DMYHM", localeName)) {
				alert(getMessage("ASSIGN_TRMT_AREA_CONS_DATE_TIME", "AE"));
				parent.frames[1].document.forms[0].start_cons_date_time.select();
				parent.frames[1].document.forms[0].start_cons_date_time.focus();					
				return false;
			} else if (isAfter(startConsDateTime, sysDateTime, "DMYHM", localeName)) {
				alert(getMessage("BACK_DATE_CONS", "AE"));
				parent.frames[1].document.forms[0].start_cons_date_time.select();
				parent.frames[1].document.forms[0].start_cons_date_time.focus();					
				return false;
			} else {
				parent.frames[1].document.forms[0].insertBackDatedConsY.value = "Y";

				// Wrap submission in a setTimeout to ensure the form submission happens before closing the dialog
				parent.frames[1].document.forms[0].submit();
				/*setTimeout(function() {;
					parent.parent.document.getElementById("dialog_tag").close();
				}, 100); */// Delay to ensure submission is processed
			}
		}
	} else {
		if (parent.frames[1].document.forms[0].start_cons_date_time)
			parent.frames[1].document.forms[0].start_cons_date_time.disabled = false;
		parent.frames[1].document.forms[0].submit();
		/*setTimeout(function() {
			parent.parent.document.getElementById("dialog_tag").close();
		}, 100); */// Delay to ensure submission is processed
	}
	/*End*/
}


/*Added by Thamizh selvi on 17th Oct 2017 for ML-MMOH-CRF-0623 Start*/
function chkWithSysDt(obj)
{
	if(obj.value!='')
	{
		if(isBeforeNow(obj.value,"DMYHM",localeName))
			return true;
		else{
			alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
			obj.select();
			obj.focus();				
			return false ;
		}
	}		
}
function enableDisableConsDate(obj)
{
	if(obj.checked){
		obj.value="Y";				
		document.forms[0].start_cons_date_time.disabled = false;
	}else{
		var sysDateTime = getSysDateTime();
		obj.value="N";
		document.forms[0].start_cons_date_time.disabled = true;
		document.forms[0].start_cons_date_time.value = sysDateTime;
	}
}
function getSysDateTime()
{
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH action='getSystemDateTime'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOP/jsp/OPIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText = xmlHttp.responseText
	var sysDateTime = trimString(responseText);
	return sysDateTime;
}
/*End*/
