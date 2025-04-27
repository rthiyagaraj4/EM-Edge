/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create(){
	f_query_add_mod.location.href="../../eSS/jsp/VendorLoanAckFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}
function reset() {
	f_query_add_mod.location.reload();
}

function onSuccess(){
	var formObj = f_query_add_mod.AcknowledgeHeaderframe.document.formAcknowledgeHeader;
		alert(getMessage("TRANSACTION_PROCESSED","SS"));
		formObj.fm_vendor_code.disabled	=	true;
		formObj.doc_type_code.disabled	=	true;
		var xmlHttp = new XMLHttpRequest();
		//	var xmlDoc="";
		//	xmlDoc.loadXML(getXMLString(null));
		var xmlString = getXMLString(null);  // Your XML string function
		var parser = new DOMParser();
		var xmlDoc = parser.parseFromString(xmlString, "application/xml");
		xmlHttp.open("POST", "../../eSS/jsp/VendorLoanAckValidate.jsp?validate=LOAD_DETAIL&doc_no="+formObj.doc_no.value+"&req_from_date="+formObj.req_from_date.value+"&req_to_date="+formObj.req_to_date.value+"&fm_vendor_code="+formObj.fm_vendor_code.value+"&to_store_code="+formObj.to_store_code.value+"&doc_type_code="+formObj.doc_type_code.value+"&group_code="+formObj.group_code.value+"&doc_ref="+formObj.doc_ref.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		f_query_add_mod.AcknowledgeDetailframe.document.location.href = "../../eSS/jsp/VendorLoanAckDetail.jsp?mode="+formObj.mode.value;
		f_query_add_mod.AcknowledgeListframe.document.location.href = "../../eCommon/html/blank.html";
}

function apply(){
	if(f_query_add_mod.AcknowledgeHeaderframe==null){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var formObjhdr = f_query_add_mod.AcknowledgeHeaderframe.document.formAcknowledgeHeader;
	var formObjdtl = f_query_add_mod.AcknowledgeDetailframe.document.formAcknowledgeDetail;
	var frmObjlist = f_query_add_mod.AcknowledgeListframe.document.formAcknowledgeList;
		

	if(formObjdtl==null ){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MIN_ONE_RECORD_AVB","SS");
		return;
	}
	var checkedIndices = "";
	var canProcess = false;
	var total_checkboxes = formObjdtl.total_records.value;
	for (var i=0;i<total_checkboxes;i++ ){
		if (eval ("formObjdtl.checkbox"+i+".checked")) {
			canProcess = true;
			checkedIndices += (i+ ",");
		}
	}
	//IN056488 Start.
	if(canProcess && frmObjlist!=null){
		canProcess = false;
		var total_checkboxes1 = frmObjlist.total_records.value;
		for (var i=0;i<total_checkboxes1;i++ ){
			if (eval ("frmObjlist.checkbox"+i+".checked")) {
				canProcess = true;
			}
			
		}
	}
	//IN056488 End.
	if (!canProcess) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("SELECT_ONE_DOCUMENT","SS");
		return;
	}
	
	formObjdtl.checkedIndices.value = checkedIndices;
	formObjhdr.checkedIndices.value = checkedIndices;
	formObjhdr.total_records.value  = total_checkboxes;
	var fields =	new Array();
	var fieldNames =new Array();
	var obj = getBlankField(fields, fieldNames, messageFrame); 
	if(obj != null){

		obj.focus();
	}
	else{
		var total_check_boxes = formObjdtl.total_records.value;
		for (var count = 0;count<total_check_boxes;count++) {
			
			if(eval("formObjdtl.checkbox"+count).checked){
				
				if(eval("formObjdtl.bin_location_code_"+count).value == "") {
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("BIN_CANNOT_BLANK","SS");
					eval("formObjdtl.bin_location_code_"+count).focus();
					return;
				}
			}
	}}
if(frmObjlist){
	var bean_id = frmObjlist.bean_id.value;
	var bean_name = frmObjlist.bean_name.value;
	
	var count = eval(frmObjlist.total_records.value);
	var exist =false;
	var ack_qty="";
	
	xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlDom.loadXML(getEnhancedXMLString(frmObjlist));
	xmlHttp.open("POST", "../../eSS/jsp/VendorLoanAckValidate.jsp?validate=UPDATE_EXP_DETAIL&bean_name=" + bean_name + "&bean_id=" + bean_id+"&doc_no="+frmObjlist.doc_no.value, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);

	
	var arrayObject = new Array(formObjhdr.doc_type_code,formObjhdr.fm_vendor_code);
	var names = new Array(getLabel("Common.documenttype.label", "Common"),getLabel("eSS.FromVendor.label", "SS"));
	var blankObject = checkSSFields(arrayObject, names, messageFrame);

	if(blankObject){
		responseText = formApply(formObjdtl, SS_CONTROLLER);
		eval(responseText);
		if(result){
			onSuccess(); 
		}
	}
}else {
	
	var arrayObject = new Array(formObjhdr.doc_type_code,formObjhdr.fm_vendor_code);
	var names = new Array(getLabel("Common.documenttype.label", "Common"),getLabel("eSS.FromVendor.label", "SS"));
	var blankObject = checkSSFields(arrayObject, names, messageFrame);
	if(blankObject){
		responseText = formApply(formObjdtl, SS_CONTROLLER);
		eval(responseText);
		if(result){
			onSuccess(); 
		}
	}
	
}
messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
}



function searchVals(){
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	var formObj = parent.AcknowledgeHeaderframe.document.formAcknowledgeHeader;
	var arrayObject = new Array(formObj.doc_type_code,formObj.fm_vendor_code);
	var names = new Array(getLabel("Common.documenttype.label", "Common"), getLabel("eSS.FromVendor.label", "ST"));
	var blankObject = checkSSFields(arrayObject, names, parent.parent.messageFrame);
	if(blankObject==true){
		formObj.fm_vendor_code.disabled	=	true;
		formObj.to_store_code.disabled	=	true;
		formObj.doc_type_code.disabled	=	true;
		var xmlHttp = new XMLHttpRequest();
		//	var xmlDoc="";
		//	xmlDoc.loadXML(getXMLString(null));
		var xmlString = getXMLString(null);  // Your XML string function
		var parser = new DOMParser();
		var xmlDoc = parser.parseFromString(xmlString, "application/xml");
		xmlHttp.open("POST", "../../eSS/jsp/VendorLoanAckValidate.jsp?validate=LOAD_DETAIL&doc_no="+formObj.doc_no.value+"&req_from_date="+formObj.req_from_date.value+"&req_to_date="+formObj.req_to_date.value+"&fm_vendor_code="+formObj.fm_vendor_code.value+"&to_store_code="+formObj.to_store_code.value+"&doc_type_code="+formObj.doc_type_code.value+"&group_code="+formObj.group_code.value+"&doc_ref="+formObj.doc_ref.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		parent.AcknowledgeDetailframe.document.location.href = "../../eSS/jsp/VendorLoanAckDetail.jsp?mode="+formObj.mode.value;
		parent.AcknowledgeListframe.document.location.href = "../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
}

function loadExpDetail(index){
	
	if(parent.AcknowledgeListframe.document.formAcknowledgeList) {
		xmlDom = new ActiveXObject("Microsoft.XMLDom");
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		xmlDom.loadXML(getEnhancedXMLString(parent.AcknowledgeListframe.document.formAcknowledgeList));
		xmlHttp.open("POST", "../../eSS/jsp/VendorLoanAckValidate.jsp?validate=UPDATE_EXP_DETAIL&bean_name=" + parent.AcknowledgeListframe.document.formAcknowledgeList.bean_name.value + "&bean_id=" + parent.AcknowledgeListframe.document.formAcknowledgeList.bean_id.value+"&doc_no="+parent.AcknowledgeListframe.document.formAcknowledgeList.doc_no.value, false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}

	var trObject = eval("document.getElementById('tr_"+ index + "')");
	changeRowColor(trObject,9); //changed from changeRowColor(trObject,8); against IN056488

	var xmlHttp = new XMLHttpRequest();
	//	var xmlDoc="";
	//	xmlDoc.loadXML(getXMLString(null));
	var xmlString = getXMLString(null);  // Your XML string function
	var parser = new DOMParser();
	var xmlDoc = parser.parseFromString(xmlString, "application/xml");
	xmlHttp.open("POST", "../../eSS/jsp/VendorLoanAckValidate.jsp?validate=LOAD_EXP_DETAIL&doc_no="+eval("document.formAcknowledgeDetail.doc_no_"+index).value+"&fm_vendor_code="+eval("document.formAcknowledgeDetail.fm_vendor_code_"+index).value+"&to_store_code="+eval("document.formAcknowledgeDetail.to_store_code_"+index).value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
    var checked_yn = eval("document.formAcknowledgeDetail.checkbox"+index).checked;
	if(result){
		parent.AcknowledgeListframe.document.location.href = "../../eSS/jsp/VendorLoanAckList.jsp?&doc_no="+eval("document.formAcknowledgeDetail.doc_no_"+index).value+"&index="+index+"&fm_vendor_code="+eval("document.formAcknowledgeDetail.fm_vendor_code_"+index).value+"&to_store_code="+eval("document.formAcknowledgeDetail.to_store_code_"+index).value+"&doc_type_code="+eval("document.formAcknowledgeDetail.doc_type_code_"+index).value+"&checked_yn="+checked_yn;
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
	else{
		return false;
	}
}

var prevObj = null;
var prevColor = null;
function changeRowColor(obj, n) {
	if (prevObj != null) {
		for (k = 0; k < n; k++) {
			prevObj.cells(k).className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells(0).className;
	for (k = 0; k < n; k++) {
		obj.cells(k).className = "STLIGHTPINK";
	}
}

function showRemarks(i,obj) {
	var formObj;
	if(obj=="Detail"){
		formObj = document.formAcknowledgeDetail;
	}
	else{
		formObj = document.formAcknowledgeList;
	}
	var remarks             = eval("formObj.remarks_"+i).value;  
	var rem = "";
	rem = window.showModalDialog("../../eSS/jsp/VendorLoanAckRemarks.jsp?remarks="+encodeURIComponent(remarks,"UTF-8"), "", "dialogHeight:10; dialogWidth:30; center:0; status: no; dialogLeft :520; dialogTop :330;");
	if (rem != null) {
		eval("formObj.remarks_"+i).value = rem;
	}
}

function updateRemarks() {
	formObject = document.formAcknowledgeRemarks;
	 if (!setTextAreaMaxLength(formObject.remarks, 401)) { 
		alert(getMessage("REMARKS_NOT_EXCEED_400_CH", "SS"));
		return;
	}
	window.returnValue = formObject.remarks.value;
	window.close();
}

function checkDocDate(formObj) {
	if (isValidFromToField(formObj.req_from_date, formObj.req_to_date, DATE, getLabel("Common.DocDate.label", "Common"))) {
		searchVals();
	}
	else {
		return;
	}
}

function isValidFromToField(fromObj, toObj, dataType, stLegend) {
	var bReturn = true;
	var stFromValue = fromObj.value;
	var stToValue = toObj.value;
	if ((!trimCheck(stFromValue)) || (!trimCheck(stToValue))) {
		return bReturn;
	}
	if (dataType == null) {
		dataType = STRING;
	}
	switch (dataType) {
	  case INT:
	  case LONG:
	  case FLOAT:
	  case DOUBLE:
		if (parseFloat(stFromValue) > parseFloat(stToValue)) {
			bReturn = false;
		}
		break;
	  case DATE:
		var arFromDate = stFromValue.split("/");
		var arToDate = stToValue.split("/");
		if (Date.parse("" + arFromDate[1] + "/" + arFromDate[0] + "/" + arFromDate[2] + "/") > Date.parse("" + arToDate[1] + "/" + arToDate[0] + "/" + arToDate[2] + "/")) {
			bReturn = false;
		}
		break;
	  default:
		if (stFromValue > stToValue) {
			bReturn = false;
		}
	}
	if ((!bReturn)) {
		var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
		stMessage = stMessage.replace(/@/g, stLegend);
		alert(stMessage);
		toObj.focus();
		
	}
	return bReturn;
}

async function searchGroupCode( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formAcknowledgeHeader.SQL_SS_GROUP_LOOKUP_FOR_REPORT.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formAcknowledgeHeader.locale.value;
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
	}
		obj.value = arr[0];
}

function toggleCheck(formObject){
	var xmlHttp = new XMLHttpRequest();
		//	var xmlDoc="";
	//	xmlDoc.loadXML(getXMLString(null));
	var xmlString = getXMLString(null);  // Your XML string function
	var parser = new DOMParser();
	var xmlDoc = parser.parseFromString(xmlString, "application/xml");
	xmlHttp.open("POST", "../../eSS/jsp/VendorLoanAckValidate.jsp?validate=CLEAR_GRP_SEL", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	var total_records	=	formObject.total_records.value;
	var ischecked=formObject.selectAll.checked;
	for (var i=0; i<parseInt(total_records); i++){
		eval("formObject.checkbox"+i).checked=ischecked;
		saveDtlVals(i);
	}
	var frmObjlist = parent.AcknowledgeListframe.document.formAcknowledgeList;
	if(frmObjlist!=null){
		var total_records_list	=	frmObjlist.total_records.value;
		for (var i=0; i<parseInt(total_records); i++){
			for (var j=0; j<parseInt(total_records_list); j++){
				eval("frmObjlist.checkbox"+j).checked=ischecked;
			}
			saveDtlVals(i);
		}
	}
}

function updateSelection(index) {
	var formObject		= parent.AcknowledgeDetailframe.document.formAcknowledgeDetail;
	var total_check_boxes = formObject.total_records.value;
	var exist=true;
	for (var count = 0;count<total_check_boxes;count++) {
		if(!(eval("formObject.checkbox"+count+".checked"))) {
			exist=false;
		}
	}
	if(exist){
		formObject.selectAll.checked=true;
	}
	else{
		formObject.selectAll.checked=false;
	}
	saveDtlVals(index);
}

function details(group_code,group_desc){  
	if(group_code!=""){
		var dialogHeight = "30" ;
		var dialogWidth	= "40" ;
		var dialogTop = "265" ;
		var center = "1" ;
		var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=yes; status=no;" ;
		
		var arguments = "" ;
		var title="Request Detail";
		var params = "group_code="+group_code+"&group_desc="+group_desc;
		
		retVal = window.showModalDialog("../../eSS/jsp/GroupItemDetails.jsp?"+params,arguments,features);
	}
}

function saveVals(index){
	var formObj= document.formAcknowledgeList;
	var xmlHttp = new XMLHttpRequest();
	//	var xmlDoc="";
	//	xmlDoc.loadXML(getXMLString(null));
	var xmlString = getEnhancedXMLString(formObj);  // Your XML string function
	var parser = new DOMParser();
	var xmlDoc = parser.parseFromString(xmlString, "application/xml");
	xmlHttp.open("POST", "../../eSS/jsp/VendorLoanAckValidate.jsp?validate=ADD_TO_LIST&doc_no="+formObj.doc_no.value+"&doc_type_code="+formObj.doc_type_code.value , false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

function saveDtlVals(index){
	var formObj= document.formAcknowledgeDetail;
	var doc_no= eval("formObj.doc_no_"+index+".value");
	var doc_type_code= eval("formObj.doc_type_code_"+index+".value");
	var groupCodes= eval("formObj.groupCodes_"+index+".value");
	var xmlHttp = new XMLHttpRequest();
	//	var xmlDoc="";
	//	xmlDoc.loadXML(getXMLString(null));
	var xmlString = getEnhancedXMLString(formObj);  // Your XML string function
	var parser = new DOMParser();
	xmlHttp.open("POST", "../../eSS/jsp/VendorLoanAckValidate.jsp?validate=ADD_TO_LIST_DTL&doc_no="+doc_no+"&doc_type_code="+doc_type_code+"&groupCodes="+groupCodes+"&index="+index, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

function isNumberKey(evt){
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode == 8 || charCode == 46) 
    	return false;
}
