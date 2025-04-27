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
	                f_query_add_mod.formAutoclavingLoadDtlReportList.reset(); 
}

function run(){
	
	var formObj=parent.f_query_add_mod.formAutoclavingLoadDtlReportList;
	var messageFrame	=	parent.messageFrame;

	if (isValidFromToField(formObj.p_fm_wash_unit_code, formObj.p_to_wash_unit_code, STRING, "Autoclaving Unit", messageFrame)) 
		if (isValidFromToField(formObj.p_fm_steril_type, formObj.p_to_steril_type, STRING, "Sterilization Type", messageFrame)) 
			if (isValidFromToField(formObj.p_fm_load_no, formObj.p_to_load_no, LONG, "Load Number", messageFrame)) 
		       if (isValidFromToField(formObj.p_fm_auto_date1, formObj.p_to_auto_date1, STRING , "Autoclave Date", messageFrame)) {
		          if (isValidFromToField(formObj.p_fm_store, formObj.p_to_store, STRING, "Store", messageFrame)) 
					formObj.p_fm_auto_date.value=convertDate(formObj.p_fm_auto_date1.value,'DMY',formObj.locale.value,"en");
					formObj.p_to_auto_date.value=convertDate(formObj.p_to_auto_date1.value,'DMY',formObj.locale.value,"en");
			
		             formObj.submit();
			   }
}

			      
async function searchAutoclavingUnit(obj)
{
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();



	argumentArray[0] = document.formAutoclavingLoadDtlReportList.SQL_SS_AUTOCLAVE_WASH_UNIT_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formAutoclavingLoadDtlReportList.locale.value;
	dataTypeArray  [0]=STRING
	dataNameArray  [1]="facility_id"  //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
	dataValueArray [1]=document.formAutoclavingLoadDtlReportList.p_facility_id.value;
	dataTypeArray  [1]=STRING;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	//argumentArray[4] = "2,3";
	argumentArray[4] = "3,4";//Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("eSS.AutoclavingUnit.label","ss") , argumentArray );
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

async function searchSterilizationType(obj)
{
	 
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	
	argumentArray[0] = document.formAutoclavingLoadDtlReportList.SQL_SS_STERILIZATION_TYPE_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formAutoclavingLoadDtlReportList.locale.value;
	dataTypeArray  [0]=STRING
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("eSS.SterilizationType.label","ss"), argumentArray );
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

async function searchLoadNumber(obj) {
	alert();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray  [0]="facility_id"
	dataValueArray [0]=document.formAutoclavingLoadDtlReportList.p_facility_id.value;
	dataTypeArray  [0]=STRING
	argumentArray[0] = document.formAutoclavingLoadDtlReportList.SQL_SS_STORE_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	

	returnedValues = await CommonLookup(getLabel("eSS.LoadNumber.label","ss") , argumentArray );
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

async function searchAutoclaveDate(obj) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray  [0]="facility_id"
	dataValueArray [0]=document.formAutoclavingLoadDtlReportList.p_facility_id.value;
	dataTypeArray  [0]=STRING


	argumentArray[0] = document.formAutoclavingLoadDtlReportList.SQL_SS_STORE_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	

	returnedValues = await CommonLookup(getLabel("eSS.AutoclaveDate.label","ss") , argumentArray );
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

async function searchStore(obj) {
		 
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray  [0]="facility_id"
	dataValueArray [0]=document.formAutoclavingLoadDtlReportList.p_facility_id.value;
	dataTypeArray  [0]=STRING


	argumentArray[0] = document.formAutoclavingLoadDtlReportList.SQL_SS_STORE_LOOKUP.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.formAutoclavingLoadDtlReportList.locale.value;
	dataTypeArray  [1]=STRING
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	

	returnedValues = await CommonLookup( getLabel("eSS.Store.label","ss"), argumentArray );
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

