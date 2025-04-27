function fnEnableTextBox(obj){
	if(obj.value=="N"){
		document.downTimePatientListForm.p_patient_count.disabled=false;
		document.downTimePatientListForm.man_gif.style.visibility='visible';
		document.downTimePatientListForm.p_patient_count.focus();
	}else{
		document.downTimePatientListForm.p_patient_count.value='';
		document.downTimePatientListForm.p_patient_count.disabled=true;
		document.downTimePatientListForm.man_gif.style.visibility='hidden';
	}
}

function geDownTimePatientListCount(patientSeriesId) {

	if(patientSeriesId!="" && patientSeriesId==document.downTimePatientListForm.p_pat_ser_grp_code.value){
		 var xmlHttp
		if(navigator.appName.indexOf("Internet") ==-1)
			xmlHttp = new XMLHttpRequest();
		else
			//xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", "../../eAE/jsp/getDownTimePatientsListCount.jsp?patientSeriesId="+patientSeriesId+"", false);
		xmlHttp.setRequestHeader("Content-Type","text/html;charset=UTF-8")
		xmlHttp.send("");
		var xmlText = xmlHttp.responseText
		var result	= TrimStr(xmlText);
		if(result!=""){
			var count	= result.split("||");
			//document.downTimePatientListForm.p_used_patients.value=count[0];
			document.downTimePatientListForm.p_used_patients.value =count[0].split(/(?<=html>)/)[1]; // <!DOCTYPE html>0 is the string in count[0] so i needed to split and get the zero only
			document.downTimePatientListForm.p_unused_patients.value=count[1];
			document.downTimePatientListForm.p_total_patients.value=count[2];
		}
	}else{
		document.downTimePatientListForm.p_total_patients.value='';
		document.downTimePatientListForm.p_unused_patients.value='';
		document.downTimePatientListForm.p_used_patients.value='';

	}
		 
}

function run(){

	var p_total_patients	= parseInt(f_query_add_mod.document.downTimePatientListForm.p_total_patients.value);
	var p_used_patients		= parseInt(f_query_add_mod.document.downTimePatientListForm.p_used_patients.value);
	var p_unused_patients	= parseInt(f_query_add_mod.document.downTimePatientListForm.p_unused_patients.value);
	
	if(f_query_add_mod.document.downTimePatientListForm.p_pat_ser_grp_code.value==""){
			error = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace("$",getLabel('eMP.PatientSeries.label','MP'));
			alert(error);
			commontoolbarFrame.document.location.reload();
			return false;
	}

	if(!f_query_add_mod.document.downTimePatientListForm.p_patient_count.disabled){
		var p_count	= parseInt(f_query_add_mod.document.downTimePatientListForm.p_patient_count.value);
		
		if(f_query_add_mod.document.downTimePatientListForm.p_patient_count.value==""){
			error = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace("$",getLabel('eAE.NoOfPatientIDsToBePrinted.label','AE'));
			alert(error);
			f_query_add_mod.document.downTimePatientListForm.p_patient_count.focus();
			commontoolbarFrame.document.location.reload();
			return false;
		}else if(p_count == 0){
			error = getMessage("VALUE_SHOULD_BE_GR_ZERO","Common");
			alert(error);
			f_query_add_mod.document.downTimePatientListForm.p_patient_count.focus();
			commontoolbarFrame.document.location.reload();
			return false;
		}

		if(p_count > p_total_patients && f_query_add_mod.document.downTimePatientListForm.p_list_value.value=="ALL"){
			error = getMessage("REMARKS_SHOULD_LS_EQUAL","Common");
			error = error.replace("$",getLabel('eAE.NoOfPatientIDsToBePrinted.label','AE'));
			error = error.replace(" #",getLabel("Common.total.label","Common")+" "+getLabel("Common.Patients.label","Common"));
			alert(error);
			f_query_add_mod.document.downTimePatientListForm.p_patient_count.focus();
			f_query_add_mod.document.downTimePatientListForm.p_patient_count.value="";
			commontoolbarFrame.document.location.reload();
			return false;
		}
		if(p_count > p_used_patients && f_query_add_mod.document.downTimePatientListForm.p_list_value.value=="U"){
			error = getMessage("REMARKS_SHOULD_LS_EQUAL","Common");
			error = error.replace("$",getLabel('eAE.NoOfPatientIDsToBePrinted.label','AE'));
			error = error.replace(" #",getLabel("Common.used.label","Common")+" "+getLabel("Common.Patients.label","Common"));
			alert(error);
			f_query_add_mod.document.downTimePatientListForm.p_patient_count.focus();
			f_query_add_mod.document.downTimePatientListForm.p_patient_count.value="";
			commontoolbarFrame.document.location.reload();
			return false;
		}
		if(p_count > p_unused_patients && f_query_add_mod.document.downTimePatientListForm.p_list_value.value=="UN"){
			error = getMessage("REMARKS_SHOULD_LS_EQUAL","Common");
			error = error.replace("$",getLabel('eAE.NoOfPatientIDsToBePrinted.label','AE'));
			error = error.replace(" #",getLabel("Common.unused.label","Common")+" "+getLabel("Common.Patients.label","Common"));
			alert(error);
			f_query_add_mod.document.downTimePatientListForm.p_patient_count.focus();
			f_query_add_mod.document.downTimePatientListForm.p_patient_count.value="";
			commontoolbarFrame.document.location.reload();
			return false;
		}
	}
	f_query_add_mod.document.downTimePatientListForm.submit() ;
}
function reset(){
	f_query_add_mod.document.downTimePatientListForm.reset() ;
}

function fnChkAlphaNumericForAltIds(Object) {
    var objectfield = Object ;
	var fieldVal = 	objectfield.value;
	
	var strCheck = '0123456789';
	var msg = getMessage("NAT_ID_SPL_NOT_ALLOWED",'MP');
	msg = msg.replace("in National ID"," ");
	msg = msg.replace("Special Characters"," Alphabets and Special Characters");

	var n = fieldVal.length;
	for (var i=0;i<n ;++i )
	{
		if (strCheck.indexOf(fieldVal.charAt(i)) == -1)
		{
			objectfield.value = "";
			alert(msg);
			objectfield.focus();
			return false;  
		}
	}

}