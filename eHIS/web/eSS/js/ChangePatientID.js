/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
1/7/2021  	TFS:19249        	Shazana                      			ML-MMOH-CRF-1661-US001

-------------------------------------------------------------------------------------------------------------------------------------------------------------
 */ 

/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function query(){
	f_query_add_mod.location.href = "../../eSS/jsp/ChangePatientIDQueryFrame.jsp?function_id="+function_id ;
}

function onSuccess(){
	f_query_add_mod.document.location.href="../../eCommon/html/blank.html";
}

function reset() {
	if(f_query_add_mod.frameChangePatientIDQueryCriteria!=null){
		f_query_add_mod.frameChangePatientIDQueryCriteria.document.formChangePatientIDQueryCriteria.reset();
		f_query_add_mod.frameChangePatientIDQueryResult.document.location.href="../../eCommon/html/blank.html";
	}
	else if(f_query_add_mod.document.formChangePatientID!=null){
		f_query_add_mod.document.formChangePatientID.reset();
	}
}

function apply(){
	//Added By Sakti due to Apply error in query result mode on 20th may 2013
	if(  f_query_add_mod.formChangePatientID ==undefined ){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	} 
	//Added ends
	var formObj=f_query_add_mod.document.formChangePatientID;
	var errorPage	=	"../../eCommon/jsp/error.jsp";

	var fields = new Array ( formObj.patient_id);
	var names = new Array (getLabel("Common.patientId.label","Common"));
	var blankObj	=	null;
	blankObject		=	getBlankField( fields, names, messageFrame,errorPage);
	if(blankObject==null) {
		eval(formApply(formObj,SS_CONTROLLER));
		messageFrame.location.href = errorPage+"?err_num="+ message;
		if( result ) {
			onSuccess();
		}
	}
}

function Modify(obj){
	var doc_type_code=obj.cells[8].innerText;
	var doc_no=obj.cells[1].innerText;
	var issue_group_code=obj.cells[9].innerText;
	var tray_no=obj.cells[6].innerText;
	top.content.f_query_add_mod.document.location.href="../../eSS/jsp/ChangePatientIDModify.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&issue_group_code="+issue_group_code+"&tray_no="+tray_no;
}

function showResults(){
	var frmObj = document.formChangePatientIDQueryCriteria;

	var store_code = frmObj.store_code.value;
	var doc_type_code = frmObj.doc_type_code.value;
	var doc_no = frmObj.doc_no.value; 
	var group_type = frmObj.group_type.value;
	var issue_group_code = frmObj.issue_group_code.value;
	var tray_no = frmObj.tray_no.value;
	var patient_id = frmObj.patient_id.value;
	var patient_order = frmObj.patient_order.value;
	if(group_type == "%"){
		group_type = "";
	}
		
	if(frmObj.store_code.value == null || frmObj.store_code.value == "" ) {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage("STORE_CANNOT_BLANK", "SS");
		parent.frameChangePatientIDQueryResult.location.href='../../eCommon/html/blank.html';
		frmObj.store_code.focus();
		return ;
	}

	parent.frameChangePatientIDQueryResult.location.href="../../eSS/jsp/ChangePatientIDQueryResult.jsp?doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&group_type="+group_type+"&issue_group_code="+issue_group_code+"&tray_no="+tray_no+"&patient_id="+patient_id+"&store_code="+store_code+"&patient_order="+patient_order;
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	
}


//Bru-HIMS-CRF-360
async function searchGroupCode( objCode, objDesc ) {
	
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	if(document.formChangePatientIDQueryCriteria.store_code.value == null || document.formChangePatientIDQueryCriteria.store_code.value == "") {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage("STORE_CANNOT_BLANK", "SS");
		document.formChangePatientIDQueryCriteria.store_code.focus();
		return;
	}
	dataNameArray[0] = "group_type";
	dataValueArray[0]= escape(document.formChangePatientIDQueryCriteria.group_type.value);
	dataTypeArray[0] = STRING;

	//argumentArray[0] = document.formChangePatientIDQueryCriteria.SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE.value;
	argumentArray[0] = document.formChangePatientIDQueryCriteria.SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_REQUEST.value;//Bru-HIMS-CRF-360
	dataNameArray  [1]="language_id"
	dataValueArray [1]=document.formChangePatientIDQueryCriteria.locale.value;
	dataTypeArray  [1]=STRING;

	dataNameArray[2] = "store_code";
	dataValueArray[2]= document.formChangePatientIDQueryCriteria.store_code.value;
	dataTypeArray[2] = STRING;

	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(  getLabel("Common.Group.label","Common"), argumentArray );
	var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	} 
	
}
//ADDED ENDS


async function searchGroupCodeForTray( objCode, objDesc ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "group_type";
	dataValueArray[0]=document.formChangePatientIDTrayQueryCriteria.group_type.value;//mmoh-crf-1661
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.formChangePatientIDTrayQueryCriteria.SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.formChangePatientIDTrayQueryCriteria.locale.value;
	dataTypeArray  [1]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup( "Group", argumentArray );
	var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = arr[0];
		objDesc.value = arr[1];
		objDesc.readOnly =true;
	} 
}


async function searchPatient() {
	var patient_id	=await PatientSearch();
	if(document.formChangePatientIDQueryCriteria!=null)
		var formObj = document.formChangePatientIDQueryCriteria;
	else
		var formObj = document.formChangePatientID;

	if (!((patient_id == null) || (patient_id =="")))	{
		formObj.patient_id.value = patient_id;
	}
	formObj.patient_id.focus();
}

async function searchTrayNo(){
	var formObj = document.formChangePatientIDQueryCriteria;

	var dialogHeight= "90vh" ;
    var dialogWidth = "60vw" ;
    var status = "no";
	var group_code	=	document.formChangePatientIDQueryCriteria.issue_group_code.value;
	var description	=	document.formChangePatientIDQueryCriteria.description.value;
	var group_type = document.formChangePatientIDQueryCriteria.group_type.value;//mmoh-crf-1661
	var dialogUrl       = "../../eSS/jsp/ChangePatientIDTrayQueryFrame.jsp?function_id="+parent.function_id+"&tray_no="+formObj.tray_no.value+"&group_code="+group_code+"&description="+description+"&group_type="+group_type;//mmoh-crf-1661 
	var dialogArguments = ""
	var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var returnVal =await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);

	if( returnVal == null )
		return;
	else{
		formObj.tray_no.value=returnVal;
		formObj.tray_no.focus();
	}
}
function returnTrayNo(obj){
	var tray_no=obj.cells[0].innerText;
    /*top.window.returnValue = tray_no;
    top.close();*/
	

    let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = tray_no;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();   
	
}
function populateBinLocation(obj){
	clearListItems("document.formChangePatientIDTrayQueryCriteria.bin_location_code")
	if(obj.value==""){
		return;
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/ChangePatientIDValidate.jsp?validate=POPULATE_BIN_LOCATION&owner_store_code=" + obj.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);

}

function searchPatientName(){
	var formObj	= document.formChangePatientID;
	if(formObj.patient_id.value==""){
		formObj.patient_name.value="";
		return;
	}

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/ChangePatientIDValidate.jsp?validate=PATIENT_NAME&patient_id="+formObj.patient_id.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
	
	if(!result){
		//alert(getMessage(flag));
		alert(getMessage(flag,"SS"));//Bru-HIMS-CRF-360
		formObj.patient_id.select();
		formObj.patient_id.focus();
	}
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}

function setPatientName(patient_name){
	var formObj = document.formChangePatientID;
	formObj.patient_name.value=patient_name;
}
 
