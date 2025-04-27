/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var toolBarString = "";
var show=0;
var menu="";
var group_code		= "";
var group_desc		= "";
var tray_no		= "";
var trn_type = "";

function create(){
	f_query_add_mod.location.href="../../eSS/jsp/LoanAcknowledgmentFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}
function reset() {
	f_query_add_mod.location.reload();
}

function onSuccess(){
	var formObj = f_query_add_mod.AcknowledgeHeaderframe.document.formAcknowledgeHeader;
	//var formObject = f_query_add_mod.AcknowledgeDetailframe.document.formAcknowledgeDetail;
		alert(getMessage("TRANSACTION_PROCESSED","SS"));
		formObj.trn_type.disabled		=	true;
		formObj.fm_store_code.disabled	=	true;
		formObj.to_store_code.disabled	=	true;
		formObj.action_type.disabled	=	true;
		formObj.doc_type_code.disabled	=	true;
		var xmlHttp = new XMLHttpRequest();
//	var xmlDoc="";
//	xmlDoc.loadXML(getXMLString(null));
	var xmlString = getXMLString(null);  // Your XML string function
	var parser = new DOMParser();
	var xmlDoc = parser.parseFromString(xmlString, "application/xml");
		xmlHttp.open("POST", "../../eSS/jsp/LoanAcknowledgmentValidate.jsp?validate=LOAD_DETAIL&trn_type="+formObj.trn_type.value+"&doc_no="+formObj.doc_no.value+"&fm_doc_date="+formObj.fm_doc_date.value+"&to_doc_date="+formObj.to_doc_date.value+"&action_type="+formObj.action_type.value+"&fm_store_code="+formObj.fm_store_code.value+"&to_store_code="+formObj.to_store_code.value+"&doc_type_code="+formObj.doc_type_code.value+"&group_code="+formObj.group_code.value+"&doc_ref="+formObj.doc_ref.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		//alert(responseText);
		f_query_add_mod.AcknowledgeDetailframe.document.location.href = "../../eSS/jsp/LoanAcknowledgmentDetail.jsp?trn_type="+formObj.trn_type.value+"&action_type="+formObj.action_type.value+"&mode="+formObj.mode.value;
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
	/*if(frmObjlist==null ){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MIN_ONE_RECORD_AVB","SS");
		return;
	}*/
	
	if(formObjhdr.action_type.value=="A") {
	var checkedIndices = "";
	var canProcess = false;
	var total_checkboxes = formObjdtl.total_records.value;
		for (var i=0;i<total_checkboxes;i++ ){
			if (eval ("formObjdtl.checkbox"+i+".checked")) {
				canProcess = true;
				checkedIndices += (i+ ",");
			}
			
		}
		
		if (!canProcess) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("SELECT_ONE_DOCUMENT","SS");
			return;
		}
		
		formObjdtl.checkedIndices.value = checkedIndices;
		
		formObjhdr.checkedIndices.value = checkedIndices;
		formObjhdr.total_records.value  = total_checkboxes;
		
		
		
	}else if(formObjhdr.action_type.value=="C") {
		if(frmObjlist==null ){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MIN_ONE_RECORD_AVB","SS");
		return;
	}
}
		

if(frmObjlist){
	var bean_id = frmObjlist.bean_id.value;
	var bean_name = frmObjlist.bean_name.value;
	
	var count = eval(frmObjlist.total_records.value);
	var exist =false;
	var ack_qty="";
	
	
	for(var i=0;i<count;i++){

		if(eval("frmObjlist.acknowledge_atatus_"+i).value == "R"  && eval("frmObjlist.remarks_"+i).value==""){
			alert(getMessage("REMARKS_NOT_BLANK","SS"));
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			return;
		}
		if(eval("frmObjlist.acknowledge_atatus_"+i).value != "P"){
			exist=true;
		}
	}
	if(!exist){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("ATLEASE_ONE_TRAY_ACK_OR_REJ","SS");
		return;
	}
	
	
	xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlDom.loadXML(getEnhancedXMLString(frmObjlist));
	xmlHttp.open("POST", "../../eSS/jsp/LoanAcknowledgmentValidate.jsp?validate=UPDATE_EXP_DETAIL&bean_name=" + bean_name + "&bean_id=" + bean_id+"&doc_no="+frmObjlist.doc_no.value+"&seq_no="+frmObjlist.seq_no.value+"&req_doc_no="+frmObjlist.req_doc_no.value, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);

	
	var arrayObject = new Array(formObjhdr.trn_type, formObjhdr.doc_type_code,formObjhdr.fm_doc_date,formObjhdr.to_doc_date);
	var names = new Array(getLabel("Common.TRNType.label", "Common"), getLabel("Common.documenttype.label", "Common"),getLabel("eST.FromDocDate.label", "SS"),getLabel("eST.ToDocDate.label", "SS"));
	var blankObject = checkSSFields(arrayObject, names, messageFrame);

	if(blankObject){
		var total_records = eval(frmObjlist.total_records.value);
			if(formObjhdr.action_type.value=="A") {
			exist =false;
			for(var i=0;i<total_records;i++){
				if(eval("frmObjlist.acknowledge_atatus_"+i).value == "R"){
				exist=true;
				}
			}
			
			if(exist){
					var doIt= confirm(getMessage("REJECTED_TRAY_WISH_TO_CONTINUE","SS"));
					if(doIt) {
					responseText = formApply(formObjdtl, SS_CONTROLLER);
					eval(responseText);
						if(result){
						//f_query_add_mod.location.reload();
							onSuccess();
						}
					}else {
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
						return;
					}
				}else{
					responseText = formApply(formObjdtl, SS_CONTROLLER);
					eval(responseText);
					if(result){
						onSuccess(); 
					//f_query_add_mod.location.reload();
					}
				}
			}else if(formObjhdr.action_type.value=="C" && formObjhdr.trn_type.value=="ISL" ) {
							
										/* THIS BLOCK IS NOW COMMENTED AND KEPT AS IT IS FOR FUTURE USE IF RE_LOAN_ISSUE COMES

										var doIt= confirm(getMessage("WISH_TO_RE_ISSUE_REJECTED_TRAY","SS"));
										if(doIt) {
											responseText = formApply(formObjhdr, SS_CONTROLLER);
											//alert(responseText);
											eval(responseText);
											if(result){
											messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
									
											var dialogHeight= "80" ;
											var dialogWidth	= "80" ;
											var dialogTop = "60" ;
											var center = "1" ;
											var status="no";
											var function_id="SS_ACKNOWLEDGEMENT_TRANS";
											var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
											var arguments	= "" ;
											var Re_Issue	= "Confirm" ;

											var retVal = window.showModalDialog("../../eSS/jsp/LoanIssueGroup.jsp?mode="+MODE_MODIFY+"&req_doc_type_code="+frmObjlist.req_doc_type_code.value+"&req_doc_no="+frmObjlist.req_doc_no.value+"&function_id="+function_id+"&doc_no="+frmObjlist.doc_no.value+"&doc_type_code="+frmObjlist.doc_type_code.value+"&Re_Issue="+Re_Issue,arguments,features);

												if(restoreToolbar()){
												//create();
													onSuccess(); 
												messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
												}
											}	
								}else {*/
										responseText = formApply(formObjhdr, SS_CONTROLLER);
										eval(responseText);
										if(result){
										//f_query_add_mod.location.reload();
											onSuccess(); 
									}
								//}
							
			} else{
				
				responseText = formApply(formObjdtl, SS_CONTROLLER);
				//alert(responseText);
				eval(responseText);
				if(result){
				//f_query_add_mod.location.reload();
					onSuccess(); 
				}
			}
				
	}
}else {
	
	var arrayObject = new Array(formObjhdr.trn_type, formObjhdr.doc_type_code,formObjhdr.fm_doc_date,formObjhdr.to_doc_date);
	var names = new Array(getLabel("Common.TRNType.label", "Common"), getLabel("Common.documenttype.label", "Common"),getLabel("eST.FromDocDate.label", "SS"),getLabel("eST.ToDocDate.label", "SS"));
	var blankObject = checkSSFields(arrayObject, names, messageFrame);

	if(blankObject){
		
		
		responseText = formApply(formObjdtl, SS_CONTROLLER);
		//alert(responseText);
		eval(responseText);
		if(result){
		//f_query_add_mod.location.reload();
			onSuccess(); 
		}
	}
	
}
messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
}



function searchVals(){
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	var formObj = parent.AcknowledgeHeaderframe.document.formAcknowledgeHeader;
	var store_code = "";
	var store_code_legend=""
	if(formObj.action_type.value=="A"){
		store_code = formObj.to_store_code;
		store_code_legend = getLabel("eSS.ToStore.label", "SS");
	}else{
		store_code = formObj.fm_store_code;
		store_code_legend = getLabel("eSS.FromStore.label", "SS");
	}
	var arrayObject = new Array(formObj.trn_type,formObj.doc_type_code,formObj.fm_doc_date,formObj.to_doc_date,store_code);
	var names = new Array(getLabel("Common.TRNType.label", "Common"), getLabel("Common.documenttype.label", "Common"), getLabel("eST.FromDocDate.label", "ST"), getLabel("eST.ToDocDate.label", "ST"), store_code_legend);
	var blankObject = checkSSFields(arrayObject, names, parent.parent.messageFrame);
	if(blankObject==true){
		
		if(formObj.fm_store_code.value == formObj.to_store_code.value) {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("BOTH_STORE_CANNOT_SAME","SS");
			return;
		}
		
		formObj.trn_type.disabled		=	true;
		formObj.fm_store_code.disabled	=	true;
		formObj.to_store_code.disabled	=	true;
		formObj.action_type.disabled	=	true;
		formObj.doc_type_code.disabled	=	true;
		var xmlHttp = new XMLHttpRequest();
//	var xmlDoc="";
//	xmlDoc.loadXML(getXMLString(null));
	var xmlString = getXMLString(null);  // Your XML string function
	var parser = new DOMParser();
	var xmlDoc = parser.parseFromString(xmlString, "application/xml");
		xmlHttp.open("POST", "../../eSS/jsp/LoanAcknowledgmentValidate.jsp?validate=LOAD_DETAIL&trn_type="+formObj.trn_type.value+"&doc_no="+formObj.doc_no.value+"&fm_doc_date="+formObj.fm_doc_date.value+"&to_doc_date="+formObj.to_doc_date.value+"&action_type="+formObj.action_type.value+"&fm_store_code="+formObj.fm_store_code.value+"&to_store_code="+formObj.to_store_code.value+"&doc_type_code="+formObj.doc_type_code.value+"&group_code="+formObj.group_code.value+"&doc_ref="+formObj.doc_ref.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		//alert(responseText);
		parent.AcknowledgeDetailframe.document.location.href = "../../eSS/jsp/LoanAcknowledgmentDetail.jsp?trn_type="+formObj.trn_type.value+"&action_type="+formObj.action_type.value+"&mode="+formObj.mode.value;
		parent.AcknowledgeListframe.document.location.href = "../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	
	}
}
function loadExpDetail(index){
	
	if(document.formAcknowledgeDetail.action_type.value == "A") {
		if(parent.AcknowledgeListframe.document.formAcknowledgeList) {
				var count = eval(parent.AcknowledgeListframe.document.formAcknowledgeList.total_records.value);
				var exist = false;
					for(var i=0;i<count;i++){

						if(eval("parent.AcknowledgeListframe.document.formAcknowledgeList.acknowledge_atatus_"+i).value == "R"  && eval("parent.AcknowledgeListframe.document.formAcknowledgeList.remarks_"+i).value==""){
						alert(getMessage("REMARKS_NOT_BLANK","SS"));
						parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
						return;
					}
						if(eval("parent.AcknowledgeListframe.document.formAcknowledgeList.acknowledge_atatus_"+i).value != "P"){
						exist=true;
						}
				}
						if(!exist){
							parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("ATLEASE_ONE_TRAY_ACK_OR_REJ","SS");
							return;
						}

						xmlDom = new ActiveXObject("Microsoft.XMLDom");
						xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
						xmlDom.loadXML(getEnhancedXMLString(parent.AcknowledgeListframe.document.formAcknowledgeList));
						xmlHttp.open("POST", "../../eSS/jsp/LoanAcknowledgmentValidate.jsp?validate=UPDATE_EXP_DETAIL&bean_name=" + parent.AcknowledgeListframe.document.formAcknowledgeList.bean_name.value + "&bean_id=" + parent.AcknowledgeListframe.document.formAcknowledgeList.bean_id.value+"&doc_no="+parent.AcknowledgeListframe.document.formAcknowledgeList.doc_no.value+"&seq_no="+parent.AcknowledgeListframe.document.formAcknowledgeList.seq_no.value+"&req_doc_no="+parent.AcknowledgeListframe.document.formAcknowledgeList.req_doc_no.value, false);
						xmlHttp.send(xmlDom);
						responseText = xmlHttp.responseText;
						//alert(responseText);
						eval(responseText);
		}
	}

	var trObject = eval("document.getElementById('tr_" + index + "')");
	changeRowColor(trObject,7);

	var xmlHttp = new XMLHttpRequest();
//	var xmlDoc="";
//	xmlDoc.loadXML(getXMLString(null));
	var xmlString = getXMLString(null);  // Your XML string function
	var parser = new DOMParser();
	var xmlDoc = parser.parseFromString(xmlString, "application/xml");
	xmlHttp.open("POST", "../../eSS/jsp/LoanAcknowledgmentValidate.jsp?validate=LOAD_EXP_DETAIL&doc_no="+eval("document.formAcknowledgeDetail.doc_no_"+index).value+"&seq_no="+eval("document.formAcknowledgeDetail.seq_no_"+index).value+"&fm_store_code="+eval("document.formAcknowledgeDetail.fm_store_code_"+index).value+"&to_store_code="+eval("document.formAcknowledgeDetail.to_store_code_"+index).value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	//alert(responseText);
	if(result){
		parent.AcknowledgeListframe.document.location.href = "../../eSS/jsp/LoanAcknowledgmentList.jsp?&doc_no="+eval("document.formAcknowledgeDetail.doc_no_"+index).value+"&index="+index+"&fm_store_code="+eval("document.formAcknowledgeDetail.fm_store_code_"+index).value+"&to_store_code="+eval("document.formAcknowledgeDetail.to_store_code_"+index).value+"&seq_no="+eval("document.formAcknowledgeDetail.seq_no_"+index).value+"&confirm_yn="+eval("document.formAcknowledgeDetail.confirm_yn_"+index).value+"&confirm_reqd_yn="+eval("document.formAcknowledgeDetail.confirm_reqd_yn_"+index).value+"&req_doc_no="+eval("document.formAcknowledgeDetail.req_doc_no_"+index).value+"&req_doc_type_code="+eval("document.formAcknowledgeDetail.req_doc_type_code_"+index).value+"&action_type="+document.formAcknowledgeDetail.action_type.value+"&doc_type_code="+eval("document.formAcknowledgeDetail.doc_type_code_"+index).value+"&trn_type="+document.formAcknowledgeDetail.trn_type.value;
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}else{
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

function showRemarksImg(obj,i){
	var formObj = document.formAcknowledgeList;
	//alert(eval("formObj.acknowledge_atatus_"+i).value );
	if(eval("formObj.acknowledge_atatus_"+i).value =="R") {
		obj.style.visibility="visible";
	}else{
		obj.style.visibility="hidden";
	}
	
	
}


function showRemarks(i) {
	var doc_no				= document.formAcknowledgeList.doc_no.value;
	var seq_no				= document.formAcknowledgeList.seq_no.value;
	var group_code			= eval("document.formAcknowledgeList.group_code_"+i).value;
	var tray_no				= eval("document.formAcknowledgeList.tray_no_"+i).value;
	var expiry_date			= eval("document.formAcknowledgeList.expiry_date_"+i).value;
	var bin_location_code	= eval("document.formAcknowledgeList.bin_location_code_"+i).value;
	var doc_type_code		= eval("document.formAcknowledgeList.doc_type_code_"+i).value;
	var remarks             = eval("document.formAcknowledgeList.remarks_"+i).value;  
	
	var rem = "";
	rem = window.showModalDialog("../../eSS/jsp/LoanAcknowledgeRemarks.jsp?remarks="+encodeURIComponent(remarks,"UTF-8")+"&doc_no="+doc_no+"&seq_no="+seq_no+"&group_code="+group_code+"&tray_no="+tray_no+"&expiry_date="+expiry_date+"&bin_location_code="+bin_location_code+"&doc_type_code="+doc_type_code, "", "dialogHeight:10; dialogWidth:30; center:0; status: no; dialogLeft :520; dialogTop :330;");
	
	if (rem != null) {
		eval("document.formAcknowledgeList.remarks_"+i).value = rem;
		
		
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

function setTrnType(obj){
	if(obj==null)
		obj = document.formAcknowledgeHeader.trn_type;
	var xmlHttp = new XMLHttpRequest();
//	var xmlDoc="";
//	xmlDoc.loadXML(getXMLString(null));
	var xmlString = getXMLString(null);  // Your XML string function
	var parser = new DOMParser();
	var xmlDoc = parser.parseFromString(xmlString, "application/xml");
	xmlHttp.open("POST", "../../eSS/jsp/LoanAcknowledgmentValidate.jsp?validate=TRNTYPE&trn_type="+obj.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	//alert(responseText);
	var action_type = document.formAcknowledgeHeader.action_type;
	setActionType(action_type);
}
function setActionType(obj){
	var xmlHttp = new XMLHttpRequest();
//	var xmlDoc="";
//	xmlDoc.loadXML(getXMLString(null));
	var xmlString = getXMLString(null);  // Your XML string function
	var parser = new DOMParser();
	var xmlDoc = parser.parseFromString(xmlString, "application/xml");
	xmlHttp.open("POST", "../../eSS/jsp/LoanAcknowledgmentValidate.jsp?validate=ACTIONTYPE&action_type="+obj.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	//alert(responseText);
}


function isValidNumber(fld, e, maxInt, deci,allow_yn) {

	var disp_allowed_yn = "Y";
	if(document.forms[0].dec_allowed_yn!=undefined){
		disp_allowed_yn = document.forms[0].dec_allowed_yn.value;
	}
	if(allow_yn=="N" ){
		deci = 0;
	}
	var count = fld.value.length;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (count >= maxInt) {
		if (count == maxInt) {
			var dotOccurance = fld.value.indexOf(".");
			if (((dotOccurance >= maxInt) || (dotOccurance == -1)) && (count == maxInt)) {
				if (whichCode != 46) {
					if (deci > 1) {
						fld.value = fld.value + ".";
					}
				}
			}
		} else {
			if (count > maxInt) {
				var objectValue = fld.value;
				var dotOccurance = objectValue.indexOf(".");
				if ((objectValue.charAt(maxInt)) != ".") {
					if (dotOccurance == -1) {
						if (deci != 0) {
							fld.value = objectValue.substring(0, maxInt) + ".";
						} else {
							fld.value = objectValue.substring(0, maxInt);
						}
						return false;
					}
				}
			}
		}
	}
	var strCheck = ".0123456789";
	if (deci == 0) {
		strCheck = "0123456789";
	}
	var fldvalue = fld.value;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) {
		return true;  // Enter
	}
	var pointCount = 0;
	for (var i = 0; i < fldvalue.length; i++) {
		if (fldvalue.charAt(i) == ".") {
			pointCount++;
		}
	}
	if (pointCount > 0 && whichCode == 46) {
		return false;
	}
	var fldValue = fld.value;
	var dotIndex = fldValue.indexOf(".");
	var fldLength = fldValue.length;
	if (dotIndex != -1) {
		if (fldLength > (dotIndex + deci)) {
			return false;
		}
	}
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;  // Not a valid key
	}
	return true;
}


//Starts
function checkDocDate(formObj) {
	if (isValidFromToField(formObj.fm_doc_date, formObj.to_doc_date, DATE, getLabel("Common.DocDate.label", "Common"))) {
		//formObj.submit();
		searchVals();
	} else {
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



function checkSysdate(receiptdate,sysdate){

var flag=true;

	
if(ChkDate(receiptdate) && flag )
   {
	
		if(!checkdateWithSysDate(receiptdate,sysdate))
		{
		alert(getMessage("NOT_GRT_THAN_SYSDATE","SS"));
		receiptdate.select();
		receiptdate.focus();
		return false;
		}
		else
		{

		}
   }
	else
	{
		if(!(flag))
		{

			alert(getMessage("INVALID_DATE_FMT","SS"));
			receiptdate.select();
			receiptdate.focus();
			return false;

		}
		else
		{
		alert(getMessage("INVALID_DATE_FMT","SS"));
		receiptdate.select();
		receiptdate.focus();
		return false;
		}
	}

	
}


function checkdateWithSysDate(entered_date,sys_date) 
{
	var enteredDateArray; var sysDateArray;
	var enteredDate = entered_date.value ;
	var sysDate = sys_date.value;
	
	if(enteredDate.length > 0 && sysDate.length > 0 ) 
	{
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2],(sysDateArray[1]-1),sysDateArray[0]);	
		if(Date.parse(sysDateObject) < Date.parse(enteredDateObject)) 
		{
			/**
			  * If the sys_date is less than the entered_date date,
			  * i.e., The Entered date is greater than the Current System Date
			  * Then return false to indicate it is wrong..
			  */
			return false;
		}
		else if(Date.parse(sysDateObject) >= Date.parse(enteredDateObject)) return true;
	}	
	return true;
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
		
		obj.value = arr[0];
	}
}

function restoreToolbar(){
	bean_id		=	parent.frames[2].frames[1].frames[0].document.formAcknowledgeHeader.bean_id.value;
	bean_name	=	parent.frames[2].frames[1].frames[0].document.formAcknowledgeHeader.bean_name.value;
	//alert(bean_id);
	//alert(bean_name);
	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();

    var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
    xmlStr +=" /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","LoanAcknowledgmentValidate.jsp?validate=toolBar&"+toolBarString,false);
    xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText)
	return true
}

function StoreMendateImageChk(){
	if(document.formAcknowledgeHeader.action_type.value=="A"){
		document.getElementById('fm_store_img').style.visibility = "hidden";
		document.getElementById('to_store_img').style.visibility = "visible";
		}else{
		document.getElementById('fm_store_img').style.visibility = "visible";
		document.getElementById('to_store_img').style.visibility = "hidden";
	}
}

function showReturnRemarks(return_remarks) {
	
	if( return_remarks != "") {
	var rem = "";
	rem = window.showModalDialog("../../eSS/jsp/LoanReturnGroupRemarks.jsp?remarks=" + return_remarks+"&function_id=" + "LOAN_ACKNOWLEDGE", "", "dialogHeight:10; dialogWidth:28; center:1; status: no; dialogLeft :520; dialogTop :330;");
		
	}
	
}


function showDiscrepancyRemarks(i) {
	var trn_type				= document.formAcknowledgeList.trn_type.value;
	var group_code		= "";
	if(trn_type == "ISL") {
	 group_code			= eval("document.formAcknowledgeList.group_code_"+i).value;
	}else{
		group_code			= eval("document.formAcknowledgeList.ret_group_code_"+i).value;
	}
	
	var tray_no				= eval("document.formAcknowledgeList.tray_no_"+i).value;
	var group_desc			= eval("document.formAcknowledgeList.group_desc_"+i).value;
	
	
	var rem = "";
	rem = window.showModalDialog("../../eSS/jsp/TrayDiscrepancyRemarks.jsp?group_desc="+encodeURIComponent(group_desc,"UTF-8")+"&group_code="+group_code+"&tray_no="+tray_no, "", "dialogHeight:30; dialogWidth:70; center:1; status: no;  dialogTop :265;");
}


function toggleCheck(formObject){
	var allElements	=	formObject.elements;
	var ischecked=formObject.selectAll.checked;
	for (var i=0; i<allElements.length; i++){
		if (allElements[i].type=="checkbox"){
			
				allElements[i].checked=ischecked;

						
		}
	}
}

function updateSelection() {
	var frmObject		= document.formAcknowledgeDetail;

	var total_check_boxes = frmObject.total_records.value;
	
	var exist=true;
		for (var count = 0;count<total_check_boxes;count++) {
				if(!(eval("frmObject.checkbox"+count+".checked"))) {
					exist=false;
				}
			}
			if(exist){
			document.formAcknowledgeDetail.selectAll.checked=true;
			}else{
			document.formAcknowledgeDetail.selectAll.checked=false;
			}
}
 //Added ends

//Tray discrepancy and Return Discrepancy Remarks popup display and hide logic Started
function showPopup(i,count_tray_disc,count_ret_disc){
	
	 show=1;
	 menu=document.getElementById("manage_menu");
	 menu.style.visibility="visible";
	
	 if(count_tray_disc>0){
		 document.getElementById("tray_disc").style.fontWeight='bold';
	 }else{
		 document.getElementById("tray_disc").style.fontWeight='normal';
	 }
	 if(count_ret_disc>0){
		 document.getElementById("ret_disc").style.fontWeight='bold';
	 }else{
		 document.getElementById("ret_disc").style.fontWeight='normal';
	 }
	 
	  	trn_type				= document.formAcknowledgeList.trn_type.value;
		
		if(trn_type == "ISL") {
		 group_code			= eval("document.formAcknowledgeList.group_code_"+i).value;
		}else{
			group_code			= eval("document.formAcknowledgeList.ret_group_code_"+i).value;
		}
		 group_desc			 = eval("document.formAcknowledgeList.group_desc_"+i).value;
		 tray_no				 = eval("document.formAcknowledgeList.tray_no_"+i).value;
		 

		 		var rightedge=document.body.clientWidth-(event.clientX+15);
				var bottomedge=document.body.clientHeight-(event.clientY +15);

				if (rightedge<menu.offsetWidth)
					menu.style.left=document.body.scrollLeft+event.clientX-menu.offsetWidth;
				else
					menu.style.left=document.body.scrollLeft+event.clientX;

				if (bottomedge<menu.offsetHeight)
					menu.style.top=document.body.scrollTop+event.clientY-menu.offsetHeight-15;
				else
					menu.style.top=document.body.scrollTop+event.clientY+15;
				
				 
}

/***************************************************************/
function over(){
	menu=document.getElementById("manage_menu");
	menu.style.backgroundColor="#83AAB4";
	event.target.style.backgroundColor="white";
	event.target.style.color="#83AAB4";
}
/***************************************************************/
/***************************************************************/
function out(){
	menu=document.getElementById("manage_menu");
	menu.style.backgroundColor="#83AAB4";
	event.target.style.backgroundColor="#83AAB4";//#B44664
	event.target.style.color="white";
}
/***************************************************************/
/***************************************************************/
function hidePopup(){
	if(show==0){
		menu=document.getElementById("manage_menu");
		menu.style.visibility="hidden";
		
	}
	show=0;
}
/***************************************************************/

function showWindow(doc_no, doc_type_code, facility_id,count_tray_disc,count_ret_disc){
	
	show = 1;
		
	if(count_tray_disc == 0 || count_ret_disc == 0) {
		document.getElementById("manage_menu").style.visibility="visible";
	} 
	
	if (event.target.style.fontWeight=="bold"){
		document.getElementById("manage_menu").style.visibility="hidden";
		var opt = event.target.value;
		var url = "";

		var dialogHeight ='30' ;
		var dialogWidth = '70' ;
		var dialogTop	= '265';
		var dialogLeft = '124' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		var arguments = "";
		
		switch(opt){
			
			case 'T':
				url="../../eSS/jsp/TrayDiscrepancyRemarks.jsp?group_desc="+encodeURIComponent(group_desc,"UTF-8")+"&group_code="+group_code+"&tray_no="+tray_no;
				break;

			case  'R':
				url="../../eSS/jsp/LoanReturnDiscrepancyRemarks.jsp?group_desc="+encodeURIComponent(group_desc,"UTF-8")+"&group_code="+group_code+"&tray_no="+tray_no+"&doc_no="+doc_no+"&doc_type_code="+doc_type_code+"&facility_id="+facility_id;
				break;
				
		}
		retVal = window.showModalDialog(url,arguments,features);
	}
}
//Tray discrepancy and Return Discrepancy Remarks popup display and hide logic ended
