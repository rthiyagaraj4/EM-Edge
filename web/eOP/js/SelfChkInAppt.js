function fnShowNoRecords(){
	alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
	parent.frames[1].location.reload();
	parent.frames[2].location.href = '../../eCommon/html/blank.html';
	parent.frames[3].location.href = '../../eCommon/jsp/error.jsp';
}

function callSearch(){

	var patientId				= document.forms[0].patientId.value;
	if(patientId==""){
		var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
		error = error.replace('$',getLabel('Common.patientId.label','Common'));
		alert(error);
	}else{
		parent.frames[2].location.href = '../../eOP/jsp/SelfChkInAppResults.jsp?patientId='+patientId;
	}
}

function barCodeScanFunc(evnt,obj){
	var keyVal	= parseInt(evnt.keyCode);
	if(obj.value!="" && keyVal==17){
		validatePatientId(obj);
	}
}


function reset(){
	frames[1].location.reload();
	frames[2].location.href = '../../eCommon/html/blank.html';
	frames[3].location.href = '../../eCommon/jsp/error.jsp'
}

function validatePatientId(obj) {
	var patId = obj.value;
	if(parent.content !=null) {
		f = parent.content.frames[1];
	}else {
		f = parent.frames[1];
	}

	if(patId!=""){ 
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patId+"\" action='validatePatIdStatus' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		 var pat_status	= TrimStr(responseText);
		 var ErrorMessage	= ""; 
		/* if (pat_status=="SUSPENDED"){  
				 ErrorMessage= getMessage('PAT_SUSPENDED_NOT_ALLOWED','MP'); 
			  }else if (pat_status=="DECEASED"){
				 ErrorMessage= getMessage('PAT_DECEASED_NOT_ALLOWED','MP'); 
			  }else if (pat_status=="SECURED"){
				 ErrorMessage= getMessage('SECURED_NOT_ALLOWED','COMMON'); 
			  }else if (pat_status=="INACTIVE"){
				 ErrorMessage= getMessage('PAT_INACTIVE_NOT_ALLOWED','MP'); 
			  }else if (pat_status=="BLACKLISTED_PATIENT"){
				 ErrorMessage= getMessage('BLACKLISTED_PATIENT','MP'); 
			  }else*/ if ( pat_status=="INVALID_PATIENT"){
				 ErrorMessage	= getMessage('INVALID_PATIENT','MP');
			  }

		 if(ErrorMessage!=''){
			alert(ErrorMessage);
			obj.focus();
			obj.value='';
			parent.frames[2].location = "../../eCommon/html/blank.html";
		}else{
			callSearch();
		}
	}
}

function onSuccess(){
}

function submitForm(appt_ref_no,appt_date,clinic_code,pract_id,from_time,to_time, resource_class,clinic_type,service_code,clinic_desc,appt_time,visit_adm_type,order_id,order_line_num,order_type_code, order_catlog_code, order_catalog_desc,ordering_facility_id,no_of_fu_visits_allowed,dur_for_fu_vsts_in_days,op_episode_id,episode_close_days_wo_fu,old_episode_no,episode_close_days_fu,last_visit_date,new_op_episode_yn,op_episode_visit_num){
	
	document.forms[0].appt_ref_no_2.value	= appt_ref_no;
	document.forms[0].appt_ref_no.value	= appt_ref_no;
	document.forms[0].assign_care_locn_code.value	= clinic_code;
	document.forms[0].assign_care_locn_desc.value	= clinic_desc;
	document.forms[0].attend_practitioner_id.value	= pract_id;
	document.forms[0].appt_practitioner_id.value	= pract_id;
	document.forms[0].service_code.value	= service_code;
	document.forms[0].q_appt_time.value	= appt_time;
	document.forms[0].visit_adm_type.value	= visit_adm_type;

	document.forms[0].order_id.value	= order_id;
	document.forms[0].order_line_num.value	= order_line_num;
	document.forms[0].order_type_code.value	= order_type_code;
	document.forms[0].order_catalog_desc.value	= order_catalog_desc;
	document.forms[0].ordering_facility_id.value	= ordering_facility_id;
	document.forms[0].order_cat_code.value	= order_catlog_code;
	document.forms[0].order_catalog_code.value	= order_catlog_code;
	document.forms[0].no_of_fu_visits_allowed.value	= no_of_fu_visits_allowed;
	document.forms[0].dur_for_fu_vsts_in_days.value	= dur_for_fu_vsts_in_days;
	document.forms[0].op_episode_id.value	= op_episode_id;
	document.forms[0].episode_close_days_wo_fu.value	= episode_close_days_wo_fu;
	document.forms[0].old_episode_no.value	= old_episode_no;
	document.forms[0].episode_close_days_fu.value	= episode_close_days_fu;
	document.forms[0].last_visit_date.value	= last_visit_date;
	document.forms[0].new_op_episode_yn.value	= new_op_episode_yn;
	document.forms[0].op_episode_visit_num.value	= op_episode_visit_num;

	if(old_episode_no!=""){
		document.forms[0].episodeReqd.value	= "S";
	}
	document.forms[0].submit();

}
