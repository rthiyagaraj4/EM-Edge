/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
26/10/2017		IN061892	Prakash C	31/10/2017		Ramesh G		ML-MMOH-CRF-0544
------------------------------------------------------------------------------------------------------------------------------
*/
function clearValues()
{
	document.specimen_order_search_not_register.reset();	
	parent.resultframe.location.href="../../eCommon/html/blank.html";
}

function populateSelection()
{
	var time_alert=""
	var patientId ="";
	var order_id ="";
	var priority="";
	var specimen="";
	var practitioner_type="";
	var status="";
	var practitioner_id="";
	
	time_alert =parent.viewframe.document.forms[0].time_alert_frame.value;
	patientId = parent.viewframe.document.forms[0].patientId.value;
	order_id = parent.viewframe.document.forms[0].order_id.value;
	priority=parent.viewframe.document.forms[0].priority_value.value;
	specimen=parent.viewframe.document.forms[0].specimen_no.value;
	status=parent.viewframe.document.forms[0].status.value;
	practitioner_type=parent.viewframe.document.forms[0].practitioner_type.value;	
	practitioner_id=parent.viewframe.document.forms[0].practitioner_id.value;
	
	var params = '?time_alert='+time_alert+'&patientId='+patientId+'&order_id='+order_id+'&priority='+priority+'&specimen_no='+specimen+'&status='+status+'&practitioner_type='+practitioner_type+'&practitioner_id='+practitioner_id; 
	parent.resultframe.location.href = '../../eOR/jsp/SpecimenNotRegisteredSearchResult.jsp'+params;
}
function callPatientSearch()
{
	var pat_id =  PatientSearch();
	if(pat_id != null)
		document.getElementById("patientId").value = pat_id;
}
function emptyValidate(obj)
{
	var obj_value = obj.value;
	if(obj_value==""){	
		alert(getMessage('TIME_FRAME_EMPTY_ALERT','OR'));
		document.getElementById('time_alert').focus();
	}
	else if(obj_value == 0){
		alert(getMessage('VAL_NOT_ZERO','OR'));		
		document.getElementById('time_alert').select();
	}
}	
