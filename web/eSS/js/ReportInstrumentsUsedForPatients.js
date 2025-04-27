/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;

function reset() {
	parent.MasterCodeListFrame.document.MasterCodeListFrame.reset();
}

function loadPage()
{
//	alert(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value);
/*	if(parent.MasterCodeListFrame.document.formReportExpiryList.master_code.value=="SS_STERILIZATION_TYPE")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportExpiryList.jsp'
	}
*/

}

function run()
{
   var formObj=parent.f_query_add_mod.document.formReportInstrumentsUsedForPatients;
	var messageFrame	=	parent.messageFrame;
	if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, "Instrument", messageFrame)) 
		if (isValidFromToField(formObj.p_fm_patient_id, formObj.p_to_patient_id, STRING, "Patient ID", messageFrame)) 
			if (isValidFromToField(formObj.p_fm_issue_date, formObj.p_to_issue_date, DATE, "Issue Date", messageFrame)) 
						formObj.p_fm_issue_date.value=convertDate(formObj.p_fm_issue_date1.value,'DMY',formObj.locale.value,"en");
						formObj.p_to_issue_date.value=convertDate(formObj.p_to_issue_date1.value,'DMY',formObj.locale.value,"en");
		
	         	formObj.submit();
}

async function searchCodeInstrument(obj) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formReportInstrumentsUsedForPatients.SQL_SS_ITEM_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formReportInstrumentsUsedForPatients.locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup( getLabel("eSS.Instrument.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var result = returnedValues[0].split(",");
		obj.value = result[0];
	} 
}

async function searchCodePatientID(obj)
{
	var patient_id	= await PatientSearch();
	if (!((patient_id == null) || (patient_id =="")))	{
		obj.value = patient_id;
	}
}
