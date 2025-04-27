/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;

function create() {

}

function reset() {
	f_query_add_mod.document.formDispatch.reset();
}

function onSuccess(){
	f_query_add_mod.location.reload();
}

function run()
{
	formObj= parent.f_query_add_mod.document.formDispatch;
		var messageFrame	=	parent.messageFrame;

		if( isValidFromToField(formObj.p_fm_document_type,formObj.p_to_document_type,STRING,"Document Type" ,  messageFrame )  )
		if( isValidFromToField(formObj.p_fm_store_code,formObj.p_to_store_code,STRING,"Store" ,  messageFrame )  )
		if( isValidFromToField( formObj.p_fm_document_no,formObj.p_to_document_no,LONG,"Document No" , messageFrame )  )
		if( isValidFromToField(formObj.p_fm_doc_date1,formObj.p_to_doc_date1,DATE,"Doc Date" , messageFrame )  ){
			formObj.p_fm_doc_date.value=convertDate(formObj.p_fm_doc_date1.value,'DMY',formObj.locale.value,"en");
			formObj.p_to_doc_date.value=convertDate(formObj.p_to_doc_date1.value,'DMY',formObj.locale.value,"en");
			

			formObj.submit();
		}
}

async function searchCode( objCode,label ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	if(objCode.name=="p_fm_document_type"  || objCode.name=="p_to_document_type")
		argumentArray[0] = document.formDispatch.SQL_WRITE_RSN_DOC_TYPE_LIST.value;
	
	if(objCode.name=="p_fm_store_code" || objCode.name=="p_to_store_code" )
		argumentArray[0] =document.formDispatch.SQL_SS_STORE_LOOKUP.value;

	if(objCode.name=="p_fm_sl_code" || objCode.name=="p_to_sl_code" ){
		argumentArray[0] =document.formDispatch.SQL_SS_SERVICE_LOCATION_LOOKUP.value;

		argumentArray[4] = "1,2";
	}
	
	if(objCode.name=="p_fm_document_type"  || objCode.name=="p_to_document_type" || objCode.name=="p_fm_store_code" || objCode.name=="p_to_store_code" ){
		dataNameArray[0]	= "facility_id";
		dataValueArray[0]	= document.formDispatch.P_facility_id.value;
		dataTypeArray[0]	= STRING;

		dataNameArray  [1]="LANGUAGE_ID"
		dataValueArray [1]=document.formDispatch.locale.value;
		dataTypeArray  [1]=STRING;
		argumentArray[4] = "3,4";
	}

	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(label, argumentArray );
	
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
		
		objCode.value = arr[0];
	}
}
