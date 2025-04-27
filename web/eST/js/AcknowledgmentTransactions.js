/*
--------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------------------
15/7/2021  	TFS:21516        Shazana                      					MOHE-CRF-0084.1-US014
--------------------------------------------------------------------------------------------------------------------------------
 */ 

function reset(){
	f_query_add_mod.location.reload();
}
async function searchItemCode(obj) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formAcknowledgmentTransactionsCriteria.locale.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = "SELECT ST.ITEM_CODE CODE, MM.SHORT_DESC DESCRIPTION FROM MM_ITEM_LANG_VW  MM, ST_ITEM ST WHERE ST.ITEM_CODE = MM.ITEM_CODE AND MM.LANGUAGE_ID LIKE  ? AND ST .ITEM_CODE LIKE UPPER(?) AND UPPER(MM.SHORT_DESC) LIKE UPPER(?) ORDER BY 2";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value.toUpperCase();
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		obj.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	} */
}

async function searchStoreCode(obj) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formAcknowledgmentTransactionsCriteria.locale.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = "SELECT ST.STORE_CODE CODE, MM.SHORT_DESC DESCRIPTION FROM MM_STORE_LANG_VW  MM, ST_STORE ST WHERE ST.STORE_CODE = MM.STORE_CODE AND MM.LANGUAGE_ID LIKE  ? AND ST .STORE_CODE LIKE UPPER(?) AND UPPER(MM.SHORT_DESC) LIKE UPPER(?) ORDER BY 2";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value.toUpperCase();
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		obj.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	} */
	
}
//MOHE-CRF-0084.1
function searchStoreCode1(obj) {
	
	var user_name =  document.formAcknowledgmentTransactionsCriteria.p_user_name.value;  
	var strFacilityParam = document.formAcknowledgmentTransactionsCriteria.p_strFacilityParam.value;  //MOHE-CRF-0084.1 
	var argumentArray = new Array(); 
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formAcknowledgmentTransactionsCriteria.locale.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "facility_id";//MOHE-CRF-0084.1
	dataValueArray[1] = document.formAcknowledgmentTransactionsCriteria.p_facility_id.value;
	dataTypeArray[1] = STRING;
	if(strFacilityParam == "Y"){//MOHE-CRF-0084.1 START
		argumentArray[0] = "SELECT ST.STORE_CODE CODE, MM.SHORT_DESC DESCRIPTION FROM MM_STORE_LANG_VW  MM, ST_STORE ST, st_acc_entity_param WHERE ST.STORE_CODE = MM.STORE_CODE AND MM.LANGUAGE_ID LIKE  ? AND  mm.facility_id LIKE decode(TRN_ACROSS_FACILITY_YN, 'Y',mm.facility_id,? ) AND ST .STORE_CODE LIKE UPPER(?) AND UPPER(MM.SHORT_DESC) LIKE UPPER(?) AND st.store_code IN (SELECT STORE_CODE FROM st_user_access_for_store where user_id = '" +user_name+"' "+ ") ORDER BY 2";
	}else if (strFacilityParam == "N"){
		argumentArray[0] = "SELECT ST.STORE_CODE CODE, MM.SHORT_DESC DESCRIPTION FROM MM_STORE_LANG_VW  MM, ST_STORE ST, st_acc_entity_param WHERE ST.STORE_CODE = MM.STORE_CODE AND MM.LANGUAGE_ID LIKE  ? AND  mm.facility_id LIKE decode(TRN_ACROSS_FACILITY_YN, 'Y',mm.facility_id,? ) AND ST .STORE_CODE LIKE UPPER(?) AND UPPER(MM.SHORT_DESC) LIKE UPPER(?) ORDER BY 2";
	}//END
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";////MOHE-CRF-0084.1
	argumentArray[5] = obj.value.toUpperCase();
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}

function showResultPage(){
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		
	var formObj =  document.formAcknowledgmentTransactionsCriteria;
	
	//Edge clearing happening on date...so have to reset again below 2 lines
	formObj.action="../../eST/jsp/AcknowledgmentTransactionsResult.jsp"; 
	formObj.target="frameAcknowledgementTransactionsResult"; 
		
	if(formObj.issue_store_code.value!="" || formObj.receiving_store_code.value!="" ){
		if (isValidFromToField(formObj.item_code_from, formObj.item_code_to, STRING, getLabel("Common.ItemCode.label", "Common"), parent.parent.messageFrame)) {
			if (isValidFromToField(formObj.ack_from_date, formObj.ack_to_date, DATE, getLabel("Common.date.label", "Common"), parent.parent.messageFrame)) {
				if(((formObj.issue_store_code.value).toUpperCase()==""&& (formObj.receiving_store_code.value).toUpperCase()=="")||!((formObj.issue_store_code.value).toUpperCase() == (formObj.receiving_store_code.value).toUpperCase())){
					formObj.submit();
				}else{
					parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("ISS_STR_CANNOT_SAME_REC_STR","ST");
					parent.frames[1].location.href = "../../eCommon/html/blank.html";
					return;
				}
			}
		}
	}else{
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("ISS_STR_CANNOT_BLANK_REC_STR","ST");
	}
}

async function showRemarks(doc_no,doc_type_code,pending_qty,item_code,ack_date){
	rem = await window.showModalDialog("../../eST/jsp/AcknowledgmentTransactionsDetails.jsp?doc_no=" + doc_no+"&doc_type_code="+doc_type_code+"&pending_qty="+pending_qty+"&item_code="+item_code+"&ack_date="+ack_date, "", "dialogHeight:30vh; dialogWidth:60vw; center:0; status: no; dialogLeft :130; dialogTop :20; scroll:auto;");

}
