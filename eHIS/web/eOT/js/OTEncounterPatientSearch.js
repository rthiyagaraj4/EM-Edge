/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/

/*function populatePatientDetails(){
	var formObj = document.EncounterPatientSearchForm;
	parent.f_query_add_mod.location.href="../../eOT/jsp/OTEncounterPatientSearchResults.jsp?patient_class="+formObj.patient_class.value+"&patient_id="+formObj.patient_id.value ;
}*/

function returnPatientDetails(rownum,encounter_id,patient_class,episode_id,episode_type,visit_id){
	var formObj = document.responsibility_form;	
	patient_name = eval("formObj.patient_class_"+rownum).value;
	var returnValue = encounter_id+"##"+patient_class+"##"+episode_id+"##"+visit_id+"##"+episode_type;
	window.returnValue = returnValue;
	window.close();
}

function lockKey(){
    if(event.keyCode == 93)
        alert(getMessage("APP-OT0084","OT"));
}