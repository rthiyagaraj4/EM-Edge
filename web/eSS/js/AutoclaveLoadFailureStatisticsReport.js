/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function reset() {
	f_query_add_mod.formAutoclaveLoadFailureStat.reset();
}

function run(){
	var formObj=parent.f_query_add_mod.formAutoclaveLoadFailureStat; 
	var messageFrame	=	parent.messageFrame;	

	if (isValidFromToField(formObj.p_fr_cutoff_date1, formObj.p_to_cutoff_date1, DATE, "Cutoff Date", messageFrame)) 
		if (isValidFromToField(formObj.p_fr_autoclave_unit, formObj.p_to_autoclave_unit, STRING, "Autoclave Unit", messageFrame)) 
			if (isValidFromToField(formObj.p_fr_sterile_type, formObj.p_to_sterile_type, STRING, "Sterilization Type", messageFrame)) 
				if (isValidFromToField(formObj.p_fr_load_no, formObj.p_to_load_no, LONG, "Load No", messageFrame)) {
					formObj.p_fr_cutoff_date.value=convertDate(formObj.p_fr_cutoff_date1.value,'DMY',formObj.locale.value,"en");
					formObj.p_to_cutoff_date.value=convertDate(formObj.p_to_cutoff_date1.value,'DMY',formObj.locale.value,"en");
					formObj.submit();
				}
}

async function searchAutoclaveUnit( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formAutoclaveLoadFailureStat.SQL_SS_AUTOCLAVE_WASH_UNIT_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formAutoclaveLoadFailureStat.locale.value;
	dataTypeArray  [0]=STRING;
	 dataNameArray  [1]="facility_id"  //Added by Rabbani #Bru-HIMS-CRF-390(42494)  on 17-Apr-2014
	dataValueArray [1]=document.formAutoclaveLoadFailureStat.p_facility_id.value;
	dataTypeArray  [1]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("eSS.AutoclaveUnit.label","ss"), argumentArray );
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

async function searchSterileType( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formAutoclaveLoadFailureStat.SQL_SS_STERILIZATION_TYPE_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formAutoclaveLoadFailureStat.locale.value;
	dataTypeArray  [0]=STRING;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("eSS.SterilizationType.label","ss"), argumentArray );
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
