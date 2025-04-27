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
	f_query_add_mod.document.forms['formPrintCountSheet'].reset();
}

function onSuccess(){
	f_query_add_mod.location.reload();
}


async function searchCode( objCode, objDesc ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	

	if(objCode.name=="p_fm_group_code"  || objCode.name=="p_to_group_code"){
		argumentArray[0] = document.formPrintCountSheet.SQL_SS_GROUP_LOOKUP.value;
		dataNameArray  [0]="LANGUAGE_ID"
		dataValueArray [0]=document.formPrintCountSheet.locale.value;
		dataTypeArray  [0]=STRING
		argumentArray[4] = "2,3";
	}

	if(objCode.name=="p_fm_store_code" || objCode.name=="p_to_store_code" ){
		argumentArray[0] =document.formPrintCountSheet.SQL_SS_STORE_PRINT_COUNT_OWNER_SELECT_LIST.value;
		dataNameArray  [0]="facility_id"
		dataValueArray [0]=document.formPrintCountSheet.P_facility_id.value;
		dataTypeArray  [0]=STRING
		dataNameArray  [1]="LANGUAGE_ID"
		dataValueArray [1]=document.formPrintCountSheet.locale.value;
		dataTypeArray  [1]=STRING
		argumentArray[4] = "3,4";
	}
	if(objCode.name=="p_fm_curr_store_code" || objCode.name=="p_to_curr_store_code" ){

		argumentArray[0] =document.formPrintCountSheet.SQL_SS_STORE_PRINT_COUNT_ALL_SELECT_LIST.value;
		dataNameArray  [0]="facility_id"
		dataValueArray [0]=document.formPrintCountSheet.P_facility_id.value;
		dataTypeArray  [0]=STRING
		dataNameArray  [1]="LANGUAGE_ID"
		dataValueArray [1]=document.formPrintCountSheet.locale.value;
		dataTypeArray  [1]=STRING
		argumentArray[4] = "3,4";
	}
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( objDesc, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
		objCode.value = arr[0];
		objDesc.value = arr[1];
	} 
}

function run()
{
	var checkStringRange=false;

   formObj= f_query_add_mod.document.formPrintCountSheet;
   
	if(formObj!=null){
		if( !isValidFromToField(formObj.p_fm_store_code,formObj.p_to_store_code,STRING,"Owner" ,  messageFrame )  )
			checkStringRange=true;
		if( !isValidFromToField(formObj.p_fm_curr_store_code,formObj.p_to_curr_store_code,STRING,"Current" ,  messageFrame )  )
			checkStringRange=true;
		if( !isValidFromToField( formObj.p_fm_group_code,formObj.p_to_group_code,STRING,"Group" , messageFrame )  )
			checkStringRange=true;

			if(!checkStringRange)
			{
				eval(formApply(formObj,SS_CONTROLLER));
				formObj.submit();
			}
	}
}
