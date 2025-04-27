/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function populatePatientDetails(){
	var formObj = document.PatientSearchForm;
	//alert("../../eOT/jsp/OTPatientSearchResults.jsp?patient_class="+formObj.patient_class.value+"&patient_id="+formObj.patient_id.value+"&episode_id="+formObj.episode_id.value+"&encounter_id="+formObj.encounter_id.value+"&patient_name="+formObj.patient_name.value);	
	parent.f_query_add_mod.location.href="../../eOT/jsp/OTPatientSearchResults.jsp?patient_class="+formObj.patient_class.value+"&patient_id="+formObj.patient_id.value+"&encounter_id="+formObj.encounter_id.value+"&patient_name="+formObj.patient_name.value+"&view_by="+formObj.view_by.value;
}
function returnPatientDetails(rownum,patient_id,episode_type,encounter_id,episode_id,	date_of_birth,sex,visit_id){
	var formObj = document.responsibility_form;
	patient_name = eval("formObj.patient_name_"+rownum).value;
	var returnValue = patient_id+"##"+patient_name+"##"+episode_type+"##"+encounter_id+"##"+episode_id+"##"+date_of_birth+"##"+sex+"##"+visit_id;
	//alert(returnValue);
	window.returnValue = returnValue;
	window.close();
}
function lockKey(){
    if(event.keyCode == 93)
        alert(getMessage("APP-OT0084","OT"));
}
