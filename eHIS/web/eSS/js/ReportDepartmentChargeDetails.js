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


}

function run()
{
   var formObj=parent.f_query_add_mod.document.formRep_DepartmentChargeDetails;
	var messageFrame	=	parent.messageFrame;
	if (isValidFromToField(formObj.p_fm_group_code, formObj.p_to_group_code, STRING, "Group", messageFrame)) 
		if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, "Store", messageFrame)) 
			if (isValidFromToField(formObj.p_fm_dept_code, formObj.p_to_dept_code, STRING, "Department", messageFrame))
    			if (isValidFromToField(formObj.p_fm_doc_date, formObj.p_to_doc_date, DATE, "Document Date", messageFrame)) 
						formObj.p_fm_doc_date.value=convertDate(formObj.p_fm_doc_date1.value,'DMY',formObj.locale.value,"en");
						formObj.p_to_doc_date.value=convertDate(formObj.p_to_doc_date1.value,'DMY',formObj.locale.value,"en");
		
	            	formObj.submit();
}

async function searchCodeStoreMaster(obj) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray  [0]="facility_id"
	dataValueArray [0]=document.formRep_DepartmentChargeDetails.p_facility_id.value;
	dataTypeArray  [0]=STRING


	argumentArray[0] = document.formRep_DepartmentChargeDetails.SQL_SS_STORE_LOOKUP.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.formRep_DepartmentChargeDetails.locale.value;
	dataTypeArray  [1]=STRING;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	

	returnedValues =await CommonLookup( getLabel("eSS.Store.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var result = returnedValues[0].split(",");
		obj.value = result[0];
	} 
}
async function searchCodeGroupMaster(obj) {

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formRep_DepartmentChargeDetails.SQL_SS_GROUP_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formRep_DepartmentChargeDetails.locale.value;
	dataTypeArray  [0]=STRING;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var result = returnedValues[0].split(",");
		obj.value = result[0];
	} 
}

async function searchCodeDeptMaster(obj) {

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray  [0]="facility_id"
	dataValueArray [0]=document.formRep_DepartmentChargeDetails.p_facility_id.value;
	dataTypeArray  [0]=STRING 

	argumentArray[0] = document.formRep_DepartmentChargeDetails.SQL_SS_DEPT_LOOKUP.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.formRep_DepartmentChargeDetails.locale.value;
	dataTypeArray  [1]=STRING;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup( getLabel("Common.department.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var result = returnedValues[0].split(",");
		obj.value = result[0];
	} 
}
