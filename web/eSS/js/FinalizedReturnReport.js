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
	f_query_add_mod.document.formFinalizedReturnReport.reset();
}


function run()
{
	var formObj	=	f_query_add_mod.document.formFinalizedReturnReport;
	if (isValidFromToField(formObj.Fr_store_code, formObj.To_store_code, STRING, "Return From", messageFrame)) 
		if (isValidFromToField(formObj.Fr1_store_code, formObj.To1_store_code, STRING, "Return To", messageFrame)) 
			if (isValidFromToField(formObj.p_frm_doc_type_code, formObj.p_to_doc_type_code, STRING, "Doc Type", messageFrame)) 
				if (isValidFromToField(formObj.p_frm_doc_no, formObj.p_to_doc_no, LONG, "Doc No", messageFrame)) 
					if (isValidFromToField(formObj.p_frm_doc_date, formObj.p_to_doc_date, DATE, "Doc Date", messageFrame)){ 
						f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
	                    f_query_add_mod.document.forms[0].target="messageFrame";
						formObj.submit();
					}


/*

		if(f_query_add_mod.document.formFinalizedReturnReport)
		{
			if( CheckString("Return From" , f_query_add_mod.document.formFinalizedReturnReport.Fr_store_code,f_query_add_mod.document.formFinalizedReturnReport.To_store_code, messageFrame )  )
				if( CheckString("Return To" , f_query_add_mod.document.formFinalizedReturnReport.Fr1_store_code,f_query_add_mod.document.formFinalizedReturnReport.To1_store_code, messageFrame )  )
					if( CheckString("Document Type" , f_query_add_mod.document.formFinalizedReturnReport.p_frm_doc_type_code,f_query_add_mod.document.formFinalizedReturnReport.p_to_doc_type_code, messageFrame )  )
						if( CheckString("Document No" , f_query_add_mod.document.formFinalizedReturnReport.p_frm_doc_no,f_query_add_mod.document.formFinalizedReturnReport.p_to_doc_no, messageFrame )  )
						if( CheckString("Document Date" , f_query_add_mod.document.formFinalizedReturnReport.p_frm_doc_date,f_query_add_mod.document.formFinalizedReturnReport.p_to_doc_date, messageFrame )  )
							f_query_add_mod.document.formFinalizedReturnReport.submit();
		}
*/
}




async function searchCodeStoreMaster(objCode) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray  [0]="facility_id"
	dataValueArray [0]=document.formFinalizedReturnReport.p_facility_id.value;
	dataTypeArray  [0]=STRING


	argumentArray[0] = document.formFinalizedReturnReport.SQL_SS_STORE_LOOKUP.value;
	
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.formFinalizedReturnReport.locale.value;
	dataTypeArray  [1]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	

	returnedValues = await CommonLookup( getLabel("eSS.Store.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
//		objDesc.value = returnedValues[0];
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		objCode.value = arr[0];

	} 
}

async function searchCodeDocumentType(obj)
{
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray  [0]="facility_id"
	dataValueArray [0]=document.formFinalizedReturnReport.p_facility_id.value;
	dataTypeArray  [0]=STRING

	argumentArray[0] = document.formFinalizedReturnReport.SQL_SS_DOC_TYPE_RTG_LIST_LOOKUP.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.formFinalizedReturnReport.locale.value;
	dataTypeArray  [1]=STRING;

	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup( getLabel("Common.documenttype.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
       } 
}
