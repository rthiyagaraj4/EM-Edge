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
	f_query_add_mod.document.formSterilelabel.reset();
}

function onSuccess(){
	f_query_add_mod.location.reload();
}




function run()
{
	formObj= parent.f_query_add_mod.document.formSterilelabel;
	var messageFrame	=	parent.messageFrame;
		if( isValidFromToField(formObj.p_fm_rof_document_type,formObj.p_to_rof_document_type, STRING,"Ster Req Doc Type" ,  messageFrame )  )
		if( isValidFromToField(formObj.p_fm_rof_document_no,formObj.p_to_rof_document_no, LONG,"Ster Req Doc No" ,  messageFrame )  )
		if( isValidFromToField(formObj.p_fm_autoclave_unit,formObj.p_to_autoclave_unit, STRING,"Autoclave Unit" ,  messageFrame )  )
		if( isValidFromToField(formObj.p_fm_load_no,formObj.p_to_load_no,  LONG ,"Load No" ,messageFrame )  )
		if( isValidFromToField(formObj.p_fm_group_code,formObj.p_to_group_code,  STRING,"Group" , messageFrame )  )
		if( isValidFromToField(formObj.p_fm_curr_tray_no,formObj.p_to_curr_tray_no, LONG,"Tray No" ,  messageFrame )  )

		formObj.submit();
}
async function searchCode( objCode ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	if(objCode.name=="p_fm_rof_document_type"  || objCode.name=="p_to_rof_document_type"){
		argumentArray[0] = document.formSterilelabel.SQL_STERILE_LABEL_ROF_DOC_TYPE_LIST.value;
		dataNameArray[0]	= "facility_id";
		dataValueArray[0]	= document.formSterilelabel.P_facility_id.value;
		dataTypeArray[0]	= STRING;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.formSterilelabel.locale.value;
	dataTypeArray  [1]=STRING;
		argumentArray[4] = "3,4";
	}
	if(objCode.name=="p_fm_autoclave_unit" || objCode.name=="p_to_autoclave_unit" ){
	argumentArray[0] =document.formSterilelabel.SQL_STERILE_LABEL_AUTOCLAVE_UNIT.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formSterilelabel.locale.value;
	dataTypeArray  [0]=STRING;
		argumentArray[4] = "2,3";
	}
	if(objCode.name=="p_fm_group_code" || objCode.name=="p_to_group_code" ){
		argumentArray[0] =document.formSterilelabel.SQL_SS_GROUP_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formSterilelabel.locale.value;
	dataTypeArray  [0]=STRING;
		argumentArray[4] = "2,4";
	}
	
	
		
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	if(objCode.name=="p_fm_rof_document_type"  || objCode.name=="p_to_rof_document_type")
		returnedValues = await CommonLookup(getLabel("Common.Document.label","Common") , argumentArray );
	if(objCode.name=="p_fm_autoclave_unit" || objCode.name=="p_to_autoclave_unit" )
		returnedValues = await CommonLookup( getLabel("eSS.AutoclaveUnit.label","ss"), argumentArray );
	if(objCode.name=="p_fm_group_code" || objCode.name=="p_to_group_code" )
		returnedValues = await CommonLookup(getLabel("Common.Group.label","Common"), argumentArray );
	
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
