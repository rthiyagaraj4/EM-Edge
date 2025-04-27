/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function reset() {
	f_query_add_mod.formAgeingAnalysis.reset();
}

function run(){
	var formObj=parent.f_query_add_mod.formAgeingAnalysis; 
	var messageFrame	=	parent.messageFrame;
	if (isValidFromToField(formObj.p_fr_group_code, formObj.p_to_group_code, STRING, "Group", messageFrame)) 
		if (isValidFromToField(formObj.p_fr_store_code, formObj.p_to_store_code, STRING, "Store", messageFrame)) 
			if (isValidFromToField(formObj.p_fr_surgery_type, formObj.p_to_surgery_type, STRING, "Surgery Type", messageFrame)) 
						formObj.submit();
}

async function searchStoreCode( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray [0]="facility_id"
	dataValueArray[0]= document.formAgeingAnalysis.p_facility_id.value;
	dataTypeArray [0]= STRING

	argumentArray[0] = document.formAgeingAnalysis.SQL_SS_STORE_LOOKUP.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.formAgeingAnalysis.locale.value;
	dataTypeArray  [1]=STRING;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("eSS.Store.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var result = returnedValues[0].split(",");
		obj.value = result[0];
	} 
}

async function searchSurgeryType( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formAgeingAnalysis.SQL_SS_SURGERY_TYPE_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formAgeingAnalysis.locale.value;
	dataTypeArray  [0]=STRING;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup( getLabel("eSS.SurgeryType.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var result = returnedValues[0].split(",");
		obj.value = result[0];
	} 
}
async function searchGroupCode( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formAgeingAnalysis.SQL_SS_GROUP_LOOKUP_FOR_REPORT.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formAgeingAnalysis.locale.value;
	dataTypeArray  [0]=STRING;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var result = returnedValues[0].split(",");
		obj.value = result[0];
	} 
}
