/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function reset() {
	f_query_add_mod.formRequestSummaryReport.reset();
}

function run(){
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	var formObj=f_query_add_mod.formRequestSummaryReport; 

	if (isValidFromToField(formObj.p_from_doc_type, formObj.p_to_doc_type, STRING, "Doc Type", messageFrame)) 
		if (isValidFromToField(formObj.p_from_doc_no, formObj.p_to_doc_no, LONG, "Doc No", messageFrame)) 
			if (isValidFromToField(formObj.p_from_doc_date1, formObj.p_to_doc_date1, DATE, "Doc Date", messageFrame)) 
				if (isValidFromToField(formObj.p_from_by_code, formObj.p_to_by_code, STRING, "Requested By", messageFrame)) 
					if (isValidFromToField(formObj.p_from_on_code, formObj.p_to_on_code, STRING, "Requested On", messageFrame)) {
							formObj.p_from_doc_date.value=convertDate(formObj.p_from_doc_date1.value,'DMY',formObj.locale.value,"en");
							formObj.p_to_doc_date.value=convertDate(formObj.p_to_doc_date1.value,'DMY',formObj.locale.value,"en");
		
							formObj.submit();
					}
}

async function searchStoreCode( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray [0]="facility_id"
	dataValueArray[0]= document.formRequestSummaryReport.p_facility_id.value;
	dataTypeArray [0]= STRING

	argumentArray[0] = document.formRequestSummaryReport.SQL_SS_STORE_LOOKUP.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.formRequestSummaryReport.locale.value;
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
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
		
		obj.value = arr[0];
	} 
}

async function searchDocType( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray [0]= "facility_id";
	dataValueArray[0]= document.formRequestSummaryReport.p_facility_id.value;
	dataTypeArray [0]= STRING

	dataNameArray [1]= "trn_type"
	dataValueArray[1]= "REQ";
	dataTypeArray [1]= STRING

	argumentArray[0] = document.formRequestSummaryReport.SQL_SS_TRN_DOC_TYPE_LOOKUP_FOR_REPORT.value;
	dataNameArray  [2]="LANGUAGE_ID"
	dataValueArray [2]=document.formRequestSummaryReport.locale.value;
	dataTypeArray  [2]=STRING;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.documenttype.label","Common"), argumentArray );
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
