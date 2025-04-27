/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function reset() {
	f_query_add_mod.formReturnGroupSummaryReport.reset();
}

function run(){
	var formObj=f_query_add_mod.formReturnGroupSummaryReport; 
	if (isValidFromToField(formObj.p_from_doc_type, formObj.p_to_doc_type, STRING, "Doc Type", messageFrame)) 
		if (isValidFromToField(formObj.p_from_doc_no, formObj.p_to_doc_no, LONG, "Doc No", messageFrame)) 
			if (isValidFromToField(formObj.p_from_doc_date, formObj.p_to_doc_date, DATE, "Doc Date", messageFrame)) 
				if (isValidFromToField(formObj.p_from_fr_store_code, formObj.p_to_fr_store_code, STRING, "From Store", messageFrame)) 
					if (isValidFromToField(formObj.p_from_to_store_code, formObj.p_to_to_store_code, STRING, "To Store", messageFrame)) 
							formObj.p_from_doc_date.value=convertDate1(formObj.p_from_doc_date1.value,'DMY',formObj.locale.value,"en");
							formObj.p_to_doc_date.value=convertDate1(formObj.p_to_doc_date1.value,'DMY',formObj.locale.value,"en");
							f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
							f_query_add_mod.document.forms[0].target="messageFrame";
							formObj.submit();
}
function convertDate1(date,format,from,to){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=convertDate&format="+format+"&date="+date+"&fromLocale="+from+"&toLocale="+to;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText =  trimString(xhr.responseText)
	return(xmlText);
}

async function searchStoreCode( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray [0]="facility_id"
	dataValueArray[0]= document.formReturnGroupSummaryReport.p_facility_id.value;
	dataTypeArray [0]= STRING

	argumentArray[0] = document.formReturnGroupSummaryReport.SQL_SS_STORE_LOOKUP.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.formReturnGroupSummaryReport.locale.value;
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
		if(returnedValues.length === 1){
			returnedValues = returnedValues[0].split(',');
		}
		obj.value = returnedValues[0];
	} 
}

async function searchDocType( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray [0]= "facility_id";
	dataValueArray[0]= document.formReturnGroupSummaryReport.p_facility_id.value;
	dataTypeArray [0]= STRING

	dataNameArray [1]= "trn_type"
	dataValueArray[1]= "RTG";
	dataTypeArray [1]= STRING

	argumentArray[0] = document.formReturnGroupSummaryReport.SQL_SS_TRN_DOC_TYPE_LOOKUP_FOR_REPORT.value;
	dataNameArray  [2]="LANGUAGE_ID"
	dataValueArray [2]=document.formReturnGroupSummaryReport.locale.value;
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
		obj.value = arr [0];
	} 
}
