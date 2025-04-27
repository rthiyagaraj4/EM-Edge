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
	f_query_add_mod.document.formPackingCheckReport.reset();
}



function run()
{
	var formObj	=	parent.f_query_add_mod.document.formPackingCheckReport;
	var messageFrame	=	parent.messageFrame;
		
			if( isValidFromToField(formObj.p_from_doc_type,formObj.p_to_doc_type, STRING,"Doc Type",messageFrame )  )
			{
				if( isValidFromToField(formObj.P_from_doc_no,formObj.P_to_doc_no, LONG,"Doc No",messageFrame )  )
						if( isValidFromToField(formObj.P_from_tray_no,formObj.P_to_tray_no, LONG,"Tray No",messageFrame )  )
							if(isValidFromToField(formObj.p_from_packing_date1,formObj.p_to_packing_date1,DATE,"Packing Date",messageFrame))
								if ( isValidFromToField(formObj.p_from_group_code,formObj.p_to_group_code,STRING,"Group" , messageFrame )  ) {
									formObj.p_from_packing_date.value=convertDate(formObj.p_from_packing_date1.value,'DMY',formObj.lang_id.value,"en");
									formObj.p_to_packing_date.value=convertDate(formObj.p_to_packing_date1.value,'DMY',formObj.lang_id.value,"en");
								
										formObj.submit();
								}
			}
		
		
		
}

async function searchCodeDocumentType(obj) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray  [0]="facility_id"
	dataValueArray [0]=document.formPackingCheckReport.p_facility_id.value;
	dataTypeArray  [0]=STRING

	argumentArray[0] = document.formPackingCheckReport.SQL_SS_DOC_TYPE_ROF_LIST_LOOKUP.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.formPackingCheckReport.locale.value;
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
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
		
		obj.value = arr[0];
	}
}


async function searchGroup( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formPackingCheckReport.SQL_SS_GROUP_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formPackingCheckReport.locale.value;
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
