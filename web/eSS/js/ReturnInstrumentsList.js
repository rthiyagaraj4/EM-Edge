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
	f_query_add_mod.document.formReportRetInstList.reset();
}



function run()
{
	/*var formObj	=	f_query_add_mod.document.formTrayDiscrepancyReport;
	if (isValidFromToField(formObj.from_group_code, formObj.to_group_code, STRING, "Group", messageFrame)) 
		if (isValidFromToField(formObj.from_store_code, formObj.to_store_code, STRING, "Store", messageFrame)) 
			if (isValidFromToField(formObj.from_tray_no, formObj.to_tray_no, LONG, "Tray No", messageFrame)) 
				formObj.submit();
		*/
		var formObj	=	f_query_add_mod.document.formReportRetInstList;
	
			if( isValidFromToField(formObj.p_from_doc_type, formObj.p_to_doc_type,STRING, "Doc Type" ,messageFrame )  )
			{
				if( isValidFromToField( formObj.P_from_doc_no,formObj.P_to_doc_no,LONG, "Doc No" ,messageFrame )  )
						if(isValidFromToField(formObj.p_from_doc_date,formObj.p_to_doc_date ,DATE,"Doc Date" ,messageFrame)){
							if ( isValidFromToField(formObj.p_from_req_store,formObj.p_to_req_store, STRING, "Store" , messageFrame )  )
								formObj.p_from_doc_date.value=convertDate(formObj.p_from_doc_date1.value,'DMY',formObj.locale.value,"en");
								formObj.p_to_doc_date.value=convertDate(formObj.p_to_doc_date1.value,'DMY',formObj.locale.value,"en");
								f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
								f_query_add_mod.document.forms[0].target="messageFrame";
								f_query_add_mod.document.formReportRetInstList.submit();
						}
			}
		
		
		
}

async function searchCodeDocumentType(obj) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray  [0]="facility_id"
	dataValueArray [0]=document.formReportRetInstList.p_facility_id.value;
	dataTypeArray  [0]=STRING

	argumentArray[0] = document.formReportRetInstList.SQL_SS_DOC_TYPE_RTI_LIST_LOOKUP.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.formReportRetInstList.locale.value;
	dataTypeArray  [1]=STRING;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("Common.documenttype.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	} 
}

async function searchCodeRequestBy(obj) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formReportRetInstList.SQL_SS_STORE_REQ_SELECT_LIST_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formReportRetInstList.locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup(getLabel("eSS.Requestor.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	} 
}

function doDateCheckFrom(from,today) { //args objects 1st is this object & second is the date object
 if(from.value != "")
	 {
			alert();
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today.value ;

				if(fromdate.length > 0 && todate.length > 0 ) {
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) > Date.parse(fromdt)) {
							var msg = getMessage('FROM_DATE_GREATER_TO_DATE',"SS");
							messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
							messageFrame.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
						}
			return true;
	 }
	return true;
}
