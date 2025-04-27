/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function reset() {
	f_query_add_mod.formAutoclaveWashUnitTestDtlReport.reset();
}

function run(){
	var formObj=parent.f_query_add_mod.formAutoclaveWashUnitTestDtlReport; 
	var messageFrame	=	parent.messageFrame;
	if (isValidFromToField(formObj.p_fr_wu_code, formObj.p_to_wu_code, STRING, "Autoclave/Washing Unit", messageFrame)) 
		if (isValidFromToField(formObj.p_fr_test_date1, formObj.p_to_test_date1, DATE, "Test Date", messageFrame)) {
		formObj.p_fr_test_date.value=convertDate(formObj.p_fr_test_date1.value,'DMY',formObj.locale.value,"en");
		formObj.p_to_test_date.value=convertDate(formObj.p_to_test_date1.value,'DMY',formObj.locale.value,"en");
			
			formObj.submit();
		}
}

async function searchTestCode( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray [0]="unit_type"
	dataValueArray[0]= escape((document.formAutoclaveWashUnitTestDtlReport.p_unit_type.value=="B")?"%":document.formAutoclaveWashUnitTestDtlReport.p_unit_type.value);
	dataTypeArray [0]= STRING
	argumentArray[0] = document.formAutoclaveWashUnitTestDtlReport.SQL_SS_AUTOCLAVE_WASH_TEST_LOOKUP_FOR_REPORT.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.formAutoclaveWashUnitTestDtlReport.locale.value;
	dataTypeArray  [1]=STRING;
	dataNameArray  [2]="facility_id" //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
	dataValueArray [2]=document.formAutoclaveWashUnitTestDtlReport.p_facility_id.value;
	dataTypeArray  [2]=STRING;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("eSS.AutoclaveWashingUnit.label","ss"), argumentArray );
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
	dataValueArray[0]= document.formAutoclaveWashUnitTestDtlReport.p_facility_id.value;
	dataTypeArray [0]= STRING

	dataNameArray [1]= "trn_type"
	dataValueArray[1]= "RTG";
	dataTypeArray [1]= STRING

	argumentArray[0] = document.formAutoclaveWashUnitTestDtlReport.SQL_SS_TRN_DOC_TYPE_LOOKUP_FOR_REPORT.value;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
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
