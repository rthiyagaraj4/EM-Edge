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
	f_query_add_mod.document.formReportTrayDetails.reset();
}


function run()
{
	var formObj	=	parent.f_query_add_mod.document.formReportTrayDetails;
	var messageFrame	=	parent.messageFrame;
		
			if( isValidFromToField( formObj.P_fm_owner_store_code,formObj.P_to_owner_store_code,STRING, "Store" ,messageFrame )  )
				if( isValidFromToField( formObj.P_fm_curr_store_code,formObj.P_to_curr_store_code,STRING,"Current Store" , messageFrame )  )
					if( isValidFromToField(formObj.P_fm_group_code,formObj.P_to_group_code,STRING,"Group Code" ,  messageFrame )  )
						if( isValidFromToField( formObj.P_fm_tray_no,formObj.P_to_tray_no,LONG, "Tray No" ,messageFrame )  )
							parent.f_query_add_mod.document.formReportTrayDetails.submit();
		
}




async function searchCodeStoreMaster(obj) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray  [0]="facility_id"
	dataValueArray [0]=document.formReportTrayDetails.p_facility_id.value;
	dataTypeArray  [0]=STRING


	argumentArray[0] = document.formReportTrayDetails.SQL_SS_STORE_LOOKUP.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.formReportTrayDetails.locale.value;
	dataTypeArray  [1]=STRING;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	

	returnedValues =await  CommonLookup( getLabel("eSS.Store.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var result = returnedValues[0].split(",");
		obj.value = result[0];
	} 
}
async function searchCodeGroupMaster(obj) {

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formReportTrayDetails.SQL_SS_GROUP_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formReportTrayDetails.locale.value;
	dataTypeArray  [0]=STRING;
		argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var result = returnedValues[0].split(",");
		obj.value = result[0];
	} 
}
