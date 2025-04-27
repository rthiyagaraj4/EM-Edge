/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function reset() {
	f_query_add_mod.formMonthlyServiceStatisticsByGroupsReport.reset();
}

function run(){
	
	var formObj=parent.f_query_add_mod.formMonthlyServiceStatisticsByGroupsReport; 
	var messageFrame	=	parent.messageFrame;	
	if (isValidFromToField(formObj.p_fm_doc_date1, formObj.p_to_doc_date1, DATE, "Doc Date", messageFrame)) 
		if (isValidFromToField(formObj.P_fm_group_code, formObj.P_to_group_code, STRING, "Group", messageFrame)) 
			if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, "Store", messageFrame)) {
					formObj.p_fm_doc_date.value=convertDate(formObj.p_fm_doc_date1.value,'DMY',formObj.locale.value,"en");
					formObj.p_to_doc_date.value=convertDate(formObj.p_to_doc_date1.value,'DMY',formObj.locale.value,"en");
					formObj.submit();
			}
}


async function searchCodeRequestBy(obj) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formMonthlyServiceStatisticsByGroupsReport.SQL_SS_STORE_REQ_SELECT_LIST_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formMonthlyServiceStatisticsByGroupsReport.locale.value;
	dataTypeArray  [0]=STRING;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("eSS.Requestor.label","ss") , argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
		
		obj.value = arr[0];
	}  
}

async function searchCodeGroupMaster(obj) {

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formMonthlyServiceStatisticsByGroupsReport.SQL_SS_GROUP_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formMonthlyServiceStatisticsByGroupsReport.locale.value;
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
		var ret1=unescape(returnedValues);
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
		
		obj.value = arr[0];
	}  
}
