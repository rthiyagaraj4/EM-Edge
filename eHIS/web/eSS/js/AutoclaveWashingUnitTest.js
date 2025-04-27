/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create(){
	f_query_add_mod.location.href = "../../eSS/jsp/AutoclaveWashingUnitTestFrame.jsp?mode="+MODE_INSERT+"&menu_id="+menu_id+"&module_id="+module_id+"&function_id="+function_id ;
}

function query(){
	f_query_add_mod.location.href = "../../eSS/jsp/AutoclaveWashingUnitTestQueryFrame.jsp?function_id="+function_id ;
}

function onSuccess(){
	var mode = f_query_add_mod.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.mode.value;
	if( mode == MODE_INSERT ) {
		reset();
		if(!((flag==null)||(flag=="null")))
			setTimeout("messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+flag",1000);;
	}
	else if( (mode == MODE_DELETE)||(f_query_add_mod.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.finalized.value=="Y")) 
		f_query_add_mod.document.location.href="../../eCommon/html/blank.html";
	else {
		//f_query_add_mod.document.location.reload(); // commented for AAKH-CRF-0057 - IN052312 
		f_query_add_mod.location.href = "../../eSS/jsp/AutoclaveWashingUnitTestFrame.jsp?mode="+MODE_INSERT+"&menu_id="+menu_id+"&module_id="+module_id+"&function_id="+function_id ; // modified for AAKH-CRF-0057 - IN052312
	}
}

function reset() {
	if(f_query_add_mod.frameAutoclaveWashingUnitTestQueryCriteria!=null){
		f_query_add_mod.frameAutoclaveWashingUnitTestQueryCriteria.document.formAutoclaveWashingUnitTestQueryCriteria.reset();
		f_query_add_mod.frameAutoclaveWashingUnitTestQueryResult.document.location.href="../../eCommon/html/blank.html";
	}
	else if(f_query_add_mod.frameAutoclaveWashingUnitTestHeader!=null){
		f_query_add_mod.location.reload();
	}
}


async function deleterecord(){
	var formObj	=	f_query_add_mod.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader;
 		
	if(formObj.mode.value==MODE_MODIFY){
		var confirmation = await confirmDelete();

		if(confirmation=="Yes"){
 			formObj.mode.value=MODE_DELETE;
 			
			eval(formApply(formObj,SS_CONTROLLER));
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			if( result ) {
				onSuccess();
			}
			else{
				formObj.mode.value=MODE_MODIFY;
			}
		}
		else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPERATION_CANCELLED","SS");
		}
	}
	else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}
}

async function apply(){
totalCBox=parseInt(f_query_add_mod.frameAutoclaveWashingUnitTestList.document.formAutoclaveWashingUnitTestList.total_checkboxes.value)
	
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	var checkBoxObj=null;
	var noDetailExists=true;
	var forDeletion=""
	for(i=0;i<totalCBox;i++)
	{
		checkBoxObj=eval("f_query_add_mod.frameAutoclaveWashingUnitTestList.document.formAutoclaveWashingUnitTestList.checkbox"+i);
		if(checkBoxObj.checked)
			forDeletion+=("Y,");
		else
			forDeletion+=("N,");
		if(!eval("f_query_add_mod.frameAutoclaveWashingUnitTestList.document.formAutoclaveWashingUnitTestList.checkbox"+i.checked)){
			noDetailExists=false;
		}
	}
	
	forDeletion						=	forDeletion.substring(0,forDeletion.length-1);

	var formObj						=	f_query_add_mod.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader ;
	formObj.records_to_delete.value =	forDeletion;
	var blankObject					=	null;
	var fields						=	new Array();
	var fieldNames					=	new Array();
	var	index						=	0;
	var queryString					=	"";
	fields[index]					=	formObj.unit_type;
	fieldNames[index++]				=	getLabel("eSS.UnitType.label","SS");
	fields[index]					=	formObj.autoclave_wash_unit_code;
	fieldNames[index++]				=	getLabel("eSS.AutoclaveWashUnit.label","SS");
	var locale						=	formObj.locale.value;
	formObj.test_date.value			=	convertDate(formObj.test_date.value,'DMY',formObj.locale.value,"en"); 
	fields[index]					=	formObj.test_date;
	fieldNames[index++]				=	getLabel("eSS.TestDate.label","SS");


	
	blankObject						=	getBlankField( fields, fieldNames, messageFrame);
	
	if(blankObject==null) {
		if (noDetailExists){
		messageFrame.location.href = errorPage+"?err_num="+getMessage("MIN_ONE_DETAIL_REQUIRED","Common"); 		
		return;
	}
		//if (formObj.SS_AUTCL_WU_TEST_FINALIZE!=null)   Commented by Sakti  since we have finalize in function level AAKH_SCF_158
		//if(formObj.entry_completed_yn.checked && (formObj.SS_AUTCL_WU_TEST_FINALIZE.value=="Y")){
		if(formObj.entry_completed_yn.checked) {
			var confirmation = await confirmFinalize();//window.confirm("Current record will be deleted!!");
	
			//if(confirmation=="YES"){
			if(confirmation==YES){
				formObj.finalized.value="Y";
					
			}
			if(confirmation==NO){
			//if(confirmation=="NO"){
			
				formObj.finalized.value="N";
					
			}
			//else if(formObj.entry_completed_yn.disabled){
			else if (confirmation ==	CLOSED) {
				messageFrame.location.href = errorPage+"?err_num="+ getMessage("OPERATION_CANCELLED","SS");
				return;
			}
			
	
		
		}
				eval(formApply(formObj,SS_CONTROLLER));
				messageFrame.location.href = errorPage+"?err_num="+ message;
				if( result ) {
				onSuccess();
				}
	
	}
	else{
		blankObject.focus();
	}
}

function checkDoc_type_code(){
	if(document.formAutoclaveWashingUnitTestHeader.doc_type_code.value=="") return;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/AutoclaveWashingUnitTestValidate.jsp?validate=DOC_TYPE_CODE&doc_type_code=" + document.formAutoclaveWashingUnitTestHeader.doc_type_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

function quantityAlert(_total_quantity, _sterilized_quantity, _unsterilized_quantity){
	alert("WARNING! Available Quantity is "+_total_quantity+" (Sterilized = "+_sterilized_quantity+", Unsterilized = "+_unsterilized_quantity+")");
}

function clearList(){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/AutoclaveWashingUnitTestValidate.jsp?validate=CLEAR_LIST", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	refreshList();
}

function enableDocNo(bValue){
	if(!bValue){
		parent.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.doc_no.value="";	
	}
	parent.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.doc_no.disabled=!bValue;
}

function addToList(){
	var formObj					=	document.formAutoclaveWashingUnitTestDetail;
	var locale					=	formObj.locale.value;
	formObj.result_date.value	=	convertDate(formObj.result_date.value,'DMY',locale,"en"); 

	var fields = new Array ( formObj.test_code,  formObj.batch_id,formObj.result_date);
	var names  =  new Array (getLabel("eSS.TestCode.label","SS"),
		getLabel("eSS.BatchID.label","SS"),
		getLabel("eSS.ResultDate.label","SS"));
	var obj    =null;
	var messageFrame = parent.parent.messageFrame; 
	var errorPage	 = "../../eCommon/jsp/error.jsp"
	obj=getBlankField( fields, names, messageFrame);
	if(obj==null) {
		
		document.getElementById("test_code").disabled= false; //AAKH-CRF-0057 - IN052312 
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		if(formObj.unit_type.value=='W'){
		//xmlHttp.open("POST", "../../eSS/jsp/AutoclaveWashingUnitTestValidate.jsp?test_code=" + formObj.test_code.value + "&batch_id=" + formObj.batch_id.value +"&test_result=" + formObj.test_result.value +"&result_date=" + formObj.result_date.value +"&index="+formObj.index.value+ "&result_remarks="+formObj.result_remarks.value+ "&autoclave_wash_unit_code="+parent.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.autoclave_wash_unit_code.value+"&unit_type="+parent.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.unit_type.value+ "&validate=ADD_TO_LIST", false);// modified for AAKH-CRF-0057 - IN052312
			xmlHttp.open("POST", "../../eSS/jsp/AutoclaveWashingUnitTestValidate.jsp?test_code=" + formObj.test_code.value + "&batch_id=" + formObj.batch_id.value +"&test_result=" + formObj.test_result.value +"&result_date=" + formObj.result_date.value +"&index="+formObj.index.value+ "&result_remarks="+formObj.result_remarks.value+ "&autoclave_wash_unit_code="+parent.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.autoclave_wash_unit_code.value+"&unit_type="+parent.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.unit_type.value+ "&validate=ADD_TO_LIST" +"&room_temp=" + formObj.room_temp.value + "&relative_humidity=" + formObj.relative_humidity.value + "&biologic_indicator=X&bms_pass_fail=X", false); //added for AAKH-CRF-0057 - IN052312
		}else{
			xmlHttp.open("POST", "../../eSS/jsp/AutoclaveWashingUnitTestValidate.jsp?test_code=" + formObj.test_code.value + "&batch_id=" + formObj.batch_id.value +"&test_result=" + formObj.test_result.value +"&result_date=" + formObj.result_date.value +"&index="+formObj.index.value+ "&result_remarks="+formObj.result_remarks.value+ "&autoclave_wash_unit_code="+parent.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.autoclave_wash_unit_code.value+"&unit_type="+parent.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.unit_type.value+ "&validate=ADD_TO_LIST" +"&room_temp=" + formObj.room_temp.value + "&relative_humidity=" + formObj.relative_humidity.value + "&biologic_indicator=" + formObj.biologic_indicator.value + "&bms_pass_fail=" + formObj.bms_pass_fail.value, false); //added for AAKH-CRF-0057 - IN052312
		}
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if( result ) {
			refreshDetails();
			formObj.index.value="-1";
		
		}
		else{
			messageFrame.location.href = errorPage+"?err_num="+ getMessage(message,"SS");
		}
	}
	else
		obj.focus();
}

function searchGroupCode( objCode, objDesc ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "group_type";
	dataValueArray[0]= document.formAutoclaveWashingUnitTestDetail.group_type.value;
	dataTypeArray[0] = STRING;

	argumentArray[0] = document.formAutoclaveWashingUnitTestDetail.SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = "";
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	} 
}

function clearGroupDetail(){
	var formObj = top.content.f_query_add_mod.frameAutoclaveWashingUnitTestDetail.document.formAutoclaveWashingUnitTestDetail;
	formObj.group_code.value="";
}

function resetGroupDetail(){
	var formObj = top.content.f_query_add_mod.frameAutoclaveWashingUnitTestDetail.document.formAutoclaveWashingUnitTestDetail;

	formObj.test_code.value="";
	
	formObj.batch_id.value="";
	formObj.test_result[formObj.test_result.selectedIndex].text=getLabel("eSS.Pass.label","SS");
	formObj.test_result.disabled=true;
	formObj.batch_id.disabled=false;
	formObj.result_remarks.value="";
	// AAKH-CRF-0057 - IN052312 - Start	
	formObj.room_temp.value="";
	formObj.relative_humidity.value="";
	if(formObj.unit_type=="A"){
		formObj.biologic_indicator_id.value="";
		formObj.bms_pass_fail_id.value="";
		document.getElementById("bio_indicator_row_id").style.display = "none";
		document.getElementById("bms_passfail_row_id").style.display = "none"; 
	}
	// AAKH-CRF-0057 - IN052312 - End
	formObj.index.value="-1";
	formObj.apply.value=getLabel("Common.Add.label","Common");
}

function refreshDetails(){
	displayMessage(top.content.messageFrame,"");
	resetGroupDetail();
	refreshList();
}

function refreshList(){
	top.content.f_query_add_mod.frameAutoclaveWashingUnitTestList.document.location.reload();
}

function listModify(index,test_code,unit_type){
	parent.frameAutoclaveWashingUnitTestDetail.location.href="../../eSS/jsp/AutoclaveWashingUnitTestDetail.jsp?index="+index+"&unit_type="+unit_type+"&test_code="+test_code;
	
}

function Modify(obj){
	var unit_type=obj.cells[0].innerText;
	var autoclave_wash_unit_code=obj.cells[4].innerText;
	var test_date=obj.cells[2].innerText;
	var unit_status=obj.cells[5].innerText;
	
	
		top.content.f_query_add_mod.document.location.href="../../eSS/jsp/AutoclaveWashingUnitTestFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&menu_id="+parent.parent.menu_id+"&module_id="+parent.parent.module_id+"&unit_type="+unit_type+"&autoclave_wash_unit_code="+autoclave_wash_unit_code+"&unit_status="+unit_status+"&test_date="+test_date+"&met=modify";
}


function searchTrayNo(){
	var formObj = document.formAutoclaveWashingUnitTestDetail;
	var group_code	=	formObj.group_code.value;
	var group_desc	=	formObj.description.value;
	if(group_code=="")	return;

	var dialogHeight= "28" ;
    var dialogWidth = "43" ;
    var status = "no";
	
	var dialogUrl       = "../../eSS/jsp/AutoclaveWashingUnitTestTrayQueryFrame.jsp?function_id="+parent.function_id+"&tray_no="+formObj.tray_no.value+"&group_code="+group_code+"&group_desc="+group_desc+"&store_code="+parent.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.store_code.value;
	var dialogArguments = ""
	var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var returnVal = window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);

	if( returnVal == null )
		return;
	else{
		formObj.tray_no.value=returnVal;
		formObj.tray_no.focus();
	}
}

function searchTrayDetail( objCode, objDesc ) {
var formObj	= document.forms[0];
	if(formObj.tray_no.value==""){
		clearTrayDetails();
		return;
	}

	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/AutoclaveWashingUnitTestValidate.jsp?validate=TRAY_DETAIL&tray_no="+formObj.tray_no.value+"&group_code="+formObj.group_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
	if(!result){
		alert(getMessage(flag));
		formObj.tray_no.select();
		formObj.tray_no.focus();
	}
	} 

	function clearTrayDetails(){
	document.formAutoclaveWashingUnitTestDetail.tray_no.value="";
}

function setTrayDetail(tray_no, bin_location_code, expiry_date){
	var formObj = top.content.f_query_add_mod.frameAutoclaveWashingUnitTestDetail.document.formAutoclaveWashingUnitTestDetail;
	formObj.tray_no.value=tray_no;
}


function searchWriteOffReason(objCode, objDesc){
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formAutoclaveWashingUnitTestDetail.SS_WRITE_OFF_REASON_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = "";
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( getLabel("eSS.WriteOff.label","SS"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	} 
}
function returnTrayNo(obj){
	var tray_no=obj.cells[0].innerText;
    top.window.returnValue = tray_no;
    top.close();
}


function populate_code(unit_type)
{
		var reset_form_obj = top.content.f_query_add_mod.frameAutoclaveWashingUnitTestDetail.document.formAutoclaveWashingUnitTestDetail;
		var reset_form_obj_frame = top.content.f_query_add_mod.frameAutoclaveWashingUnitTestDetail;
		if( unit_type.value == "" ) 
			return;
	 
		 //AAKH-CRF-0057 - IN052312 - Start	- 04/12/2014
	//	if(unit_type.value === 'W') {
		//top.content.f_query_add_mod.frameAutoclaveWashingUnitTestDetail.document.formAutoclaveWashingUnitTestDetail.document.getElementById("bio_indicator_row_id").style.display = "none";
		//top.content.f_query_add_mod.frameAutoclaveWashingUnitTestDetail.document.formAutoclaveWashingUnitTestDetail.document.getElementById("bms_passfail_row_id").style.display = "none";
		top.content.f_query_add_mod.frameAutoclaveWashingUnitTestDetail.document.getElementById("bio_indicator_row_id").style.display = "none";
		top.content.f_query_add_mod.frameAutoclaveWashingUnitTestDetail.document.getElementById("bms_passfail_row_id").style.display = "none";
	//	}
		reset_form_obj.batch_id.value="";
		reset_form_obj_frame.document.getElementById("test_result").selectedIndex.text=getLabel("eSS.Pass.label","SS");
		reset_form_obj.test_result.disabled=true;
		reset_form_obj_frame.document.getElementById("test_code").disabled=false;
		reset_form_obj_frame.document.getElementById("batch_id").value="";
		reset_form_obj_frame.document.getElementById("batch_id").disabled=false;
		reset_form_obj_frame.document.getElementById("result_remarks").value="";
		reset_form_obj_frame.document.getElementById("room_temp").value="";
		reset_form_obj_frame.document.getElementById("relative_humidity").value="";
		// AAKH-CRF-0057 - IN052312 - End -  04/12/2014
		var bean_id = document.formAutoclaveWashingUnitTestHeader.bean_id.value;
		var bean_name = document.formAutoclaveWashingUnitTestHeader.bean_name.value;
		var xmlDom = "";//new ActiveXObject( "Microsoft.XMLDom" );
		var xmlHttp = new XMLHttpRequest();
		var arrayObject = new Array();
		arrayObject[0] = unit_type;
		xmlStr = getXMLString(arrayObject);
		xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		//xmlDom.loadXML(xmlStr);
		
		xmlHttp.open("POST", "AutoclaveWashUnitTestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&function_type=1"  , false);
		xmlHttp.send( xmlDom );
		responseText=xmlHttp.responseText;
		eval( responseText );

		

}

function populate_codeonCreate(varmode)
{
		if( varmode == MODE_INSERT ) {
			var unit_type="A";
			var bean_id = document.formAutoclaveWashingUnitTestHeader.bean_id.value;
			var bean_name = document.formAutoclaveWashingUnitTestHeader.bean_name.value;
			//var xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
			var xmlHttp = new XMLHttpRequest();
			var arrayObject = new Array();
			arrayObject[0] = unit_type;
			xmlStr = getXMLString(arrayObject);
			xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
			//xmlDom.loadXML(xmlStr);
	 	
			xmlHttp.open("POST", "AutoclaveWashUnitTestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&function_type=3"  , false);
			xmlHttp.send( xmlDom );
			responseText=xmlHttp.responseText;
			eval( responseText );
		
		}	
		

}

function populate_code1(unit_type)
{
		if( unit_type.value == "" ) 
			return;
		var bean_id = document.formAutoclaveWashingUnitTestQueryCriteria.bean_id.value;
		var bean_name = document.formAutoclaveWashingUnitTestQueryCriteria.bean_name.value;
		var xmlDom = "";//new ActiveXObject( "Microsoft.XMLDom" );
		var xmlHttp = new XMLHttpRequest();
		var arrayObject = new Array();
		arrayObject[0] = unit_type;
		xmlStr = getXMLString(arrayObject);
		xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		//xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "AutoclaveWashUnitTestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&unit_type=" + unit_type+ "&function_type=2", false);
		xmlHttp.send( xmlDom );
		responseText=xmlHttp.responseText;
		eval( responseText );
}	
//AAKH-CRF-0057 - IN052312 - Start	 
function loadWashTestCode(){
	var formObj = document.formAutoclaveWashingUnitTestDetail;
	var test_code = formObj.test_code.value;
	formObj.batch_id.value="";
	formObj.test_result[formObj.test_result.selectedIndex].text=getLabel("eSS.Pass.label","SS");
	formObj.test_result.disabled=true;
	formObj.batch_id.disabled=false;
	formObj.result_remarks.value="";
	formObj.room_temp.value="";
	formObj.relative_humidity.value="";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;	
	xmlStr += " validate=\"LOAD_BMS_BIO_CODE\"";
	xmlStr += " test_code=\""+test_code+ "\" ";
	xmlStr += "/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "AutoclaveWashingUnitTestValidate.jsp?test_code=" + test_code + "&validate=LOAD_BMS_BIO_CODE" , false );
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

function addBmsBiologicalCodes(bio_bms_codes){
	bio_bms_codes = bio_bms_codes.split("/"); 
	
	if(bio_bms_codes[0] === 'Y' || bio_bms_codes[0] === 'N') {
		document.getElementById("bio_indicator_row_id").style.display = "inline" ; 
	}
	else {
		document.getElementById("bio_indicator_row_id").style.display = "none"; 
		
	}
	if(bio_bms_codes[1] === 'Y' || bio_bms_codes[1] === 'N') {
		document.getElementById("bms_passfail_row_id").style.display = "inline";
	}
	else {
			document.getElementById("bms_passfail_row_id").style.display = "none"; 
	} 
	document.formAutoclaveWashingUnitTestDetail.biologic_indicator.value = bio_bms_codes[0];
	document.formAutoclaveWashingUnitTestDetail.biologic_indicator_id.value = bio_bms_codes[0];
	document.formAutoclaveWashingUnitTestDetail.bms_pass_fail.value = bio_bms_codes[1];
	document.formAutoclaveWashingUnitTestDetail.bms_pass_fail_id.value = bio_bms_codes[1];
}
function enaDisableBIOBMS(mode, unit_type){
	if(mode === '1' && unit_type === 'A') {
		document.getElementById("bio_indicator_row_id").style.display = "none";
		document.getElementById("bms_passfail_row_id").style.display = "none"; 
	}
}
function modifyBioIndicator() {
	if(document.formAutoclaveWashingUnitTestDetail.biologic_indicator_id.value === 'Y') {
		document.formAutoclaveWashingUnitTestDetail.biologic_indicator.value = document.formAutoclaveWashingUnitTestDetail.biologic_indicator_id.value; 
	} 
	if(document.formAutoclaveWashingUnitTestDetail.biologic_indicator_id.value === 'N') {
		document.formAutoclaveWashingUnitTestDetail.biologic_indicator.value = document.formAutoclaveWashingUnitTestDetail.biologic_indicator_id.value; 
	}
}
function modifyBmsPassFail() {
	if(document.formAutoclaveWashingUnitTestDetail.bms_pass_fail_id.value === 'Y') {
		document.formAutoclaveWashingUnitTestDetail.bms_pass_fail.value = document.formAutoclaveWashingUnitTestDetail.bms_pass_fail_id.value; 
	} 
	if(document.formAutoclaveWashingUnitTestDetail.bms_pass_fail_id.value === 'N') {
		document.formAutoclaveWashingUnitTestDetail.bms_pass_fail.value = document.formAutoclaveWashingUnitTestDetail.bms_pass_fail_id.value; 
	}
}
// AAKH-CRF-0057 - IN052312 - End
