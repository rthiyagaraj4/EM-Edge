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
	f_query_add_mod.document.formReportWriteOffSummary.reset();
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
	var formObj=f_query_add_mod.document.formReportWriteOffSummary;
	if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, "Store", messageFrame)) 
		if (isValidFromToField(formObj.p_fm_group_code, formObj.p_to_group_code, STRING, "Group", messageFrame)) 
          if (isValidFromToField(formObj.p_fm_doc_type_code, formObj.p_to_doc_type_code, STRING, "Doc Type", messageFrame))
			if (isValidFromToField(formObj.p_fm_doc_no, formObj.p_to_doc_no, LONG, "Doc No", messageFrame)) 
				if (isValidFromToField(formObj.p_fm_doc_date, formObj.p_to_doc_date, DATE, "Doc Date", messageFrame)){ 
					f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
					f_query_add_mod.document.forms[0].target="messageFrame";
				   formObj.submit();	
				}
}




async function searchCodeStoreBy(obj) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray  [0]="facility_id"
	dataValueArray [0]=document.formReportWriteOffSummary.p_facility_id.value;
	dataTypeArray  [0]=STRING
	argumentArray[0] = document.formReportWriteOffSummary.SQL_SS_STORE_WRITE_OFF_SELECT_LIST_LOOKUP.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.formReportWriteOffSummary.locale.value;
	dataTypeArray  [1]=STRING;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("eSS.Store.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	} 
}

async function searchCodeGroupMaster(obj) {

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formReportWriteOffSummary.SQL_SS_GROUP_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formReportWriteOffSummary.locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	} 
}

async function searchCodeDocumentType(obj) {

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray  [0]="facility_id"
	dataValueArray [0]=document.formReportWriteOffSummary.p_facility_id.value;
	dataTypeArray  [0]=STRING
	argumentArray[0] = document.formReportWriteOffSummary.SQL_SS_DOC_TYPE_ADJ_LIST_LOOKUP.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.formReportWriteOffSummary.locale.value;
	dataTypeArray  [1]=STRING;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.documenttype.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	} 
}


