/**
  * @Author Mahesh, Created on 4/22/2008
  */
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
05/02/2021      TFS id:6938        B Haribabu   05/02/2021 1   Manickam           MMS-DM-CRF-0174.3
---------------------------------------------------------------------------------------------------------
*/
function create(){
	//f_query_add_mod.location.href="../../eST/jsp/AcknowledgmentFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
//Modified by Sakti against BRU-HIMS-CRF-073.1 passed store_code and trn_heading
	f_query_add_mod.location.href="../../eST/jsp/AcknowledgmentFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id+"&trn_name="+trn_name+"&store_code="+store_code; 
}  
function reset() {
	f_query_add_mod.location.reload();
}
function apply(){
	if(f_query_add_mod.frameAcknowledgeHeader==null){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var formObj = f_query_add_mod.frameAcknowledgeHeader.document.formAcknowledgeHeader; 
	
	var formObj1 = f_query_add_mod.frameAcknowledgeDetail.document.formAcknowledgeDetail;
	var record_selected = "N";
	var arrayObject = new Array(formObj.trn_type, formObj.store_code,formObj.doc_type_code);
	var names = new Array(getLabel("Common.TRNType.label", "Common"), getLabel("Common.Store.label", "Common"),getLabel("Common.documenttype.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, messageFrame);
	if(formObj.action_type.value=="C"){
		formObj.mode.value = MODE_MODIFY;
		for(var i=0;i<eval(formObj1.total_records.value);i++){
			if((eval("formObj1.confirm_"+i).value)=="Y"){
				record_selected = "Y";
				break;
			}
		}
	}
	if(blankObject){
		if(formObj.mode.value == MODE_MODIFY){
			if(record_selected =="N"){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MIN_ONE_RECORD_AVB","ST");
				return;
			}
		}else if(formObj.record_saved.value=="N"){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MIN_ONE_RECORD_AVB","ST");
				return;
		}
		responseText = formApply(formObj, ST_CONTROLLER);
		//alert(responseText);
		eval(responseText);
		if(result){
			f_query_add_mod.location.reload();
			//Added by sakti against CRF - PH - Bru-HIMS-CRF-073.1/03 inc#51319 to refresh Menu frame after complete transaction to show current count
			if(top.content.menuFrame != undefined) {
				top.content.menuFrame.location.reload();
			}//Added ends
		}
		if(message == ""){
		doYouWantTo();
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		return;
		}
		else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
		}
	}
}
function searchVals(){
	var formObj = document.formAcknowledgeHeader;
	var arrayObject = new Array(formObj.trn_type,formObj.doc_type_code, formObj.store_code);
	var names = new Array(getLabel("Common.TRNType.label", "Common"), getLabel("Common.documenttype.label", "Common"),getLabel("Common.Store.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame);
	if(blankObject==true){
		formObj.trn_type.disabled		=	true;
		formObj.store_code.disabled		=	true;
		formObj.action_type.disabled	=	true;
		formObj.doc_type_code.disabled	=	true;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
	//	xmlDoc.loadXML(getXMLString(null));
	    var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/AcknowledgmentValidate.jsp?validate=LOAD_DETAIL&trn_type="+formObj.trn_type.value+"&doc_no="+formObj.doc_no.value+"&fm_doc_date="+formObj.from_doc_date.value+"&to_doc_date="+formObj.to_doc_date.value+"&action_type="+formObj.action_type.value+"&store_code="+formObj.store_code.value+"&doc_type_code="+formObj.doc_type_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		//alert(responseText);
		parent.frameAcknowledgeDetail.document.location.href = "../../eST/jsp/AcknowledgmentDetail.jsp";
		parent.frameAcknowledgeList.document.location.href = "../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
}
function loadExpDetail(index){
//alert(parent.frameAcknowledgeHeader.document.formAcknowledgeHeader.record_saved.value);
	var trObject = eval(document.getElementById("tr_" + index));
	if(parent.frameAcknowledgeHeader.document.formAcknowledgeHeader.action_type.value=="C")
		changeRowColor(trObject,5);
	else
		changeRowColor(trObject,4);
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AcknowledgmentValidate.jsp?validate=LOAD_EXP_DETAIL&doc_no="+eval("document.formAcknowledgeDetail.doc_no_"+index).value+"&seq_no="+eval("document.formAcknowledgeDetail.seq_no_"+index).value+"&fm_store_code="+eval("document.formAcknowledgeDetail.fm_store_code_"+index).value+"&to_store_code="+eval("document.formAcknowledgeDetail.to_store_code_"+index).value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	//alert(responseText);
	if(result){
		parent.frameAcknowledgeList.document.location.href = "../../eST/jsp/AcknowledgmentList.jsp?&doc_no="+eval("document.formAcknowledgeDetail.doc_no_"+index).value+"&index="+index+"&fm_store_code="+eval("document.formAcknowledgeDetail.fm_store_code_"+index).value+"&to_store_code="+eval("document.formAcknowledgeDetail.to_store_code_"+index).value+"&seq_no="+eval("document.formAcknowledgeDetail.seq_no_"+index).value;
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}else{
		alert(getMessage("PHY_INV_PROCESS_INITIATED", "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + flag);
	}
}
function populateRejQuantity(i,no_of_decimals){
	var formObj = document.formAcknowledgeList;
	/**
	* @Name - Mahesh
	* @Date - 21/01/2010
	* @Inc# - IN015496
	* @Desc - Code is moved to intermediate JSP as caluculations we not happening properly in js for decimal values..
	*/
	/*if(eval(eval("formObj.received_qty_"+i).value) > eval(eval("formObj.pending_qty_temp_"+i).value)-eval(eval("formObj.rejected_qty_"+i).value==""?"0":eval("formObj.rejected_qty_"+i).value)) {
		alert(getMessage("RCVD_QTY_NOT_GREATER_ISSUED_QTY","ST"));
		eval("formObj.received_qty_"+i).value = "";
		eval("formObj.received_qty_"+i).focus();
		return;
	}else if(eval(eval("formObj.rejected_qty_"+i).value==""?"0":eval("formObj.rejected_qty_"+i).value) > eval(eval("formObj.pending_qty_temp_"+i).value)-eval(eval("formObj.received_qty_"+i).value==""?"0":eval("formObj.received_qty_"+i).value)) {
		alert(getMessage("RJCTD_QTY_NOT_GREATER_ISSUED_QTY","ST"));
		eval("formObj.rejected_qty_"+i).value="";
		eval("formObj.rejected_qty_"+i).focus();
		return;
	}
	if(eval("formObj.received_qty_"+i).value!=""){
		eval("formObj.pending_qty_"+i).value = eval(eval("formObj.pending_qty_temp_"+i).value) - eval(eval("formObj.received_qty_"+i).value) - eval(eval("formObj.rejected_qty_"+i).value==""?"0":eval("formObj.rejected_qty_"+i).value);
	}else if(eval("formObj.rejected_qty_"+i).value!=""){
		eval("formObj.pending_qty_"+i).value = eval(eval("formObj.pending_qty_temp_"+i).value) - eval(eval("formObj.rejected_qty_"+i).value) - eval(eval("formObj.received_qty_"+i).value==""?"0":eval("formObj.received_qty_"+i).value);
	}*/
	if(eval("formObj.received_qty_"+i).value=="" && eval("formObj.rejected_qty_"+i).value==""){
		eval("formObj.pending_qty_"+i).value = eval("formObj.pending_qty_temp_"+i).value;
		eval("formObj.entry_completed_"+formObj.doc_no.value).checked = false;
		eval("formObj.entry_completed_"+formObj.doc_no.value).value   = "N";
	}
	var pending_temp_qty= eval("formObj.pending_qty_temp_"+i).value;
	var pending_qty		= eval("formObj.pending_qty_"+i).value;
	var rejected_qty	= eval("formObj.rejected_qty_"+i).value==""?"0":eval("formObj.rejected_qty_"+i).value;
	var received_qty	= eval("formObj.received_qty_"+i).value==""?"0":eval("formObj.received_qty_"+i).value;

	var bean_id = document.formAcknowledgeList.bean_id.value;
	var bean_name = document.formAcknowledgeList.bean_name.value;
	xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
	frmObj = document.formAcknowledgeList;
//	xmlDom.loadXML(getEnhancedXMLString(frmObj));
    xmlDom = new DOMParser().parseFromString(getEnhancedXMLString(frmObj), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AcknowledgmentValidate.jsp?validate=VALIDATE_QTY&bean_name=" + bean_name + "&bean_id=" + bean_id+"&index="+i+"&pending_temp_qty="+pending_temp_qty+"&pending_qty="+pending_qty+"&rejected_qty="+rejected_qty+"&received_qty="+received_qty+"&no_of_decimals="+no_of_decimals, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);
	if(!result){
		eval("formObj.entry_completed_"+formObj.doc_no.value).checked = false;
		eval("formObj.entry_completed_"+formObj.doc_no.value).value   = "N";
		alert(getMessage(message,"ST"));
		if(message=="RCVD_QTY_NOT_GREATER_ISSUED_QTY"){
			eval("formObj.received_qty_"+i).value = "";
			eval("formObj.received_qty_"+i).focus();
			return;
		}else if(message=="RJCTD_QTY_NOT_GREATER_ISSUED_QTY"){
			eval("formObj.rejected_qty_"+i).value="";
			eval("formObj.rejected_qty_"+i).focus();
			return;
		}
		return;
	}else{
		eval("formObj.pending_qty_"+i).value = flag;
	}
}
function showRemarksImg(obj,i){
	var formObj = document.formAcknowledgeList;
	if(eval(eval("formObj.rejected_qty_"+i).value==""?"0":eval("formObj.rejected_qty_"+i).value) > 0){
		obj.style.visibility="visible";
	}else{
		obj.style.visibility="hidden";
	}
}
function copyVals(){
var formObj = document.formAcknowledgeList;
var count = eval(formObj.total_records.value); 
var barcode_appl_for_ack_yn = formObj.barcode_appl_for_ack_yn.value; //Added for TFS id:6938
	for(var i=0;i<count;i++){
	if(eval("parent.frameAcknowledgeDetail.document.formAcknowledgeDetail.new_saved_"+eval(document.formAcknowledgeList.hdr_index.value)).value=="Y" )
	eval("formObj.received_qty_"+i).value = eval("formObj.received_qty_"+i).value; 
	//Modified for TFS id:6938 start
	else{
		if(parent.frameAcknowledgeHeader.document.formAcknowledgeHeader.action_type.value=="A" && barcode_appl_for_ack_yn=="Y")
			eval("formObj.received_qty_"+i).value = 0;
		else
			eval("formObj.received_qty_"+i).value = eval("formObj.pending_qty_temp_"+i).value;
	}
	//Modified for TFS id:6938 END
	if(eval("parent.frameAcknowledgeDetail.document.formAcknowledgeDetail.new_saved_"+eval(document.formAcknowledgeList.hdr_index.value)).value=="Y" )
	{
	eval("formObj.rejected_qty_"+i).value = eval("formObj.rejected_qty_"+i).value;
	}else{
	if(parent.frameAcknowledgeHeader.document.formAcknowledgeHeader.action_type.value=="A"){
	 eval("formObj.rejected_qty_"+i).value = 0;
	 }
	 }
	if(eval("parent.frameAcknowledgeDetail.document.formAcknowledgeDetail.new_saved_"+eval(document.formAcknowledgeList.hdr_index.value)).value=="Y" ){
	eval("formObj.pending_qty_"+i).value = eval("formObj.pending_qty_"+i).value;
	}else{
	if(parent.frameAcknowledgeHeader.document.formAcknowledgeHeader.action_type.value=="A"){
	//Modified for TFS id:6938 START
		if(barcode_appl_for_ack_yn=="Y")
			eval("formObj.pending_qty_"+i).value = eval("formObj.pending_qty_temp_"+i).value;
		else
			eval("formObj.pending_qty_"+i).value = 0;
//Modified for TFS id:6938 END
	}
	}
if(parent.frameAcknowledgeHeader.document.formAcknowledgeHeader.action_type.value=="C"){
	eval("formObj.rejected_qty_"+i).value =eval("formObj.rejected_qty_"+i).value==""?"0":    eval("formObj.rejected_qty_"+i).value;
	}
	if(parent.frameAcknowledgeHeader.document.formAcknowledgeHeader.action_type.value=="C"){
	eval("formObj.pending_qty_"+i).value =eval("formObj.pending_qty_"+i).value==""?"0":eval("formObj.pending_qty_1_"+i).value;
}	
	}
	}

function saveVals(){
	if(parent.frameAcknowledgeHeader.document.formAcknowledgeHeader.action_type.value=="A"){
		if(!checkAllValues1())
			return;
	}
	var bean_id = document.formAcknowledgeList.bean_id.value;
	var bean_name = document.formAcknowledgeList.bean_name.value;
	xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
	var frmObj = document.formAcknowledgeList;
	var count = eval(frmObj.total_records.value);	
	//alert(eval("parent.frameAcknowledgeDetail.document.formAcknowledgeDetail.new_saved_"+eval(document.formAcknowledgeList.hdr_index.value)).value);

	for(var i=0;i<count;i++){
		if(eval("frmObj.rejected_qty_"+i).value >0 && eval("frmObj.remarks_"+i).value==""){
			alert(getMessage("ADJ_REMARKS_NOT_BLANK","ST"));
			return;
		}
	}
	
	//Added by Ganga RUT-CRF-0079
	if(frmObj.validatebarcode.value=="true" && parent.frameAcknowledgeHeader.document.formAcknowledgeHeader.action_type.value=="A"){
		var confirmScannedBarcode = "Yes";
		
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
        var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");		
		xmlHttp.open("POST", "../../eST/jsp/AcknowledgmentValidate.jsp?doc_no="+document.formAcknowledgeList.doc_no.value+"&seq_no="+document.formAcknowledgeList.seq_no.value+"&validate=BARCODE_FULLY_VERIFIED", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if(!result){
			//confirmScannedBarcode = confirm(getMessage("BARCODE_SCANNING_NOT_COMPLETE","ST"));
			confirmScannedBarcode = confirmYesNo(getMessage("BARCODE_SCANNING_NOT_COMPLETE","ST"));
		}
		
		if(confirmScannedBarcode=="No" || confirmScannedBarcode==""){
			return;
		}
	}//ended
	
	
	//Added By Rabbani,  #inc no:29537 on 11/11/11
//Starts Here		
	for(var i=0;i<count;i++){
	if(parent.frameAcknowledgeHeader.document.formAcknowledgeHeader.action_type.value=="A"){
	 if((eval("frmObj.stBatch_status_"+i).value == "S") && (frmObj.process_suspended_yn_.value == "N")){
	alert(getMessage("SUSPENDED_BATCH_YN","ST"));
	parent.parent.f_query_add_mod.location.reload();	 	
	return;
    }	
	}
	} 
	//Ends Here
	//xmlDom.loadXML(getEnhancedXMLString(frmObj));
	xmlDom = new DOMParser().parseFromString(getEnhancedXMLString(frmObj), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AcknowledgmentValidate.jsp?validate=UPDATE_EXP_DETAIL&bean_name=" + bean_name + "&bean_id=" + bean_id+"&doc_no="+document.formAcknowledgeList.doc_no.value+"&seq_no="+document.formAcknowledgeList.seq_no.value, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);
	if(result){
		if(parent.frameAcknowledgeHeader.document.formAcknowledgeHeader.action_type.value == "C"){
			eval("parent.frameAcknowledgeDetail.document.formAcknowledgeDetail.confirm_"+eval(document.formAcknowledgeList.hdr_index.value)).value = "Y";
			eval("parent.frameAcknowledgeDetail.document.formAcknowledgeDetail.confirm_"+eval(document.formAcknowledgeList.hdr_index.value)).checked = true;
			confirmRecord(document.formAcknowledgeList.hdr_index.value);
		}else{
		
		eval("parent.frameAcknowledgeDetail.document.formAcknowledgeDetail.new_saved_"+eval(document.formAcknowledgeList.hdr_index.value)).value = "Y";
	parent.frameAcknowledgeHeader.document.formAcknowledgeHeader.record_saved.value = "Y";
	}
		parent.frameAcknowledgeList.document.location.href = "../../eCommon/html/blank.html";	
	}
}
function checkAllValues(obj){
	var formObj = document.formAcknowledgeList;

	if(!(obj.checked==true))
		return;
	var count = eval(formObj.total_records.value);
	//alert(count);
	var item_code = "";
	var item_desc = "";
	for(var i=0;i<count;i++){
		if(eval("formObj.received_qty_"+i).value==""){
			alert(getMessage("RCVD_QTY_NOT_BLANK","ST"));
			obj.checked = false;
			obj.value = "N";
			eval("formObj.received_qty_"+i).focus();
			return;
		}
	}
	for(var i=0;i<count;){
		var item_qty = 0;
		if(eval("formObj.received_qty_"+i).value==""){
			alert(getMessage("RCVD_QTY_NOT_BLANK","ST"));
			obj.checked = false;
			obj.value = "N";
			eval("formObj.received_qty_"+i).focus();
			return;
		}
		if(!((eval("formObj.item_code_"+i).value) == item_code)){
		item_code = eval("formObj.item_code_"+i).value;
		item_desc = eval("formObj.item_desc_"+i).value;
		item_qty = item_qty + eval(eval("formObj.received_qty_"+i).value==""?"0":eval("formObj.received_qty_"+i).value);
		i++;
		}
		while(i<count && ((eval("formObj.item_code_"+i).value) == item_code)){
			item_qty = item_qty + eval(eval("formObj.received_qty_"+i).value==""?"0":eval("formObj.received_qty_"+i).value);
			item_code = eval("formObj.item_code_"+i).value;
			item_desc = eval("formObj.item_desc_"+i).value;
			i++;
		}
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/AcknowledgmentValidate.jsp?validate=QUANTITY&item_qty="+eval(item_qty)+"&item_code="+item_code+"&fm_store_code="+formObj.to_store_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		//alert(responseText);
		if(!result){
			var msg = "Sum Of Received Quantity Should Be In Multiples Of <B>"+flag+"</B> For The Item:: <B>"+item_desc
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
			obj.checked = false;
			obj.value = "N";
			return;
		}else{
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}
		//item_code = eval("formObj.item_code_"+i).value;
		//item_desc = eval("formObj.item_desc_"+i).value;
		/*if(eval("formObj.received_qty_"+i).value==""){
			alert("Received Quantity Cannot Be Blank");
			obj.checked = false;
			obj.value = "N";
			eval("formObj.received_qty_"+i).focus();
			return;
		}*/
	}
	for(var i=0;i<count;){
		var item_qty = 0;
		if(eval("formObj.received_qty_"+i).value==""){
			alert(getMessage("RCVD_QTY_NOT_BLANK","ST"));
			obj.checked = false;
			obj.value = "N";
			eval("formObj.received_qty_"+i).focus();
			return;
		}
		if(!((eval("formObj.item_code_"+i).value) == item_code)){
		item_code = eval("formObj.item_code_"+i).value;
		item_desc = eval("formObj.item_desc_"+i).value;
		item_qty = item_qty +  eval(eval("formObj.rejected_qty_"+i).value==""?"0":eval("formObj.rejected_qty_"+i).value);
		i++;
		}
		while(i<count && ((eval("formObj.item_code_"+i).value) == item_code)){
			item_qty = item_qty +  eval(eval("formObj.rejected_qty_"+i).value==""?"0":eval("formObj.rejected_qty_"+i).value);
			item_code = eval("formObj.item_code_"+i).value;
			item_desc = eval("formObj.item_desc_"+i).value;
			i++;
		}
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/AcknowledgmentValidate.jsp?validate=QUANTITY&item_qty="+eval(item_qty)+"&item_code="+item_code+"&fm_store_code="+formObj.fm_store_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		//alert(responseText);
		if(!result){
			var msg = "Sum Of Rejected Quantity Should Be In Multiples Of <B>"+flag+"</B> For The Item:: <B>"+item_desc
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
			obj.checked = false;
			obj.value = "N";
			return;
		}else{
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}
	}
	/*if(eval(item_qty)>=0){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/AcknowledgmentValidate.jsp?validate=QUANTITY&item_qty="+eval(item_qty)+"&item_code="+item_code+"&fm_store_code="+formObj.fm_store_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		//alert(responseText);
		if(!result){
			var msg = "Sum Of Batch Quantity Should Be In Multiples Of <B>"+flag+"</B> For The Item:: <B>"+item_desc
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
			obj.checked = false;
			obj.value = "N";
			return;
		}
	}*/
}
function checkAllValues1(){
	var formObj = document.formAcknowledgeList;
	var obj = eval("formObj.entry_completed_"+formObj.doc_no.value);
	if(!(obj.checked==true))
		return true;
	var count = eval(formObj.total_records.value);
	var item_code = eval("formObj.item_code_"+0).value;
	var item_desc = eval("formObj.item_desc_"+0).value;
	var proceed = false;
	for(var i=0;i<count;i++){
		if(eval("formObj.received_qty_"+i).value!=""){
			proceed = true;
			break;
		}
	}
	if(!proceed){
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("RCVD_QTY_NOT_BLANK","ST");
		return;
	}
	for(var i=0;i<count;i++){
		if(eval("formObj.stock_item_yn_"+i).value=="Y"){
			if(eval("formObj.bin_location_"+i).value==""){
				eval("formObj.bin_location_"+i).focus();
				proceed = false;
				break;
			}
		}
	}
	if(!proceed){
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("BIN_LOCN_NOT_BLANK","ST");
		return;
	}
	for(var i=0;i<count;i++){
		if(eval("formObj.received_qty_"+i).value==""){
			alert(getMessage("RCVD_QTY_NOT_BLANK","ST"));
			obj.checked = false;
			obj.value = "N";
			eval("formObj.received_qty_"+i).focus();
			return;
		}
	}
	for(var i=0;i<count;){
		var item_qty = 0;
		if(!((eval("formObj.item_code_"+i).value) == item_code)){
		item_code = eval("formObj.item_code_"+i).value;
		item_desc = eval("formObj.item_desc_"+i).value;
		item_qty = item_qty + eval(eval("formObj.received_qty_"+i).value==""?"0":eval("formObj.received_qty_"+i).value);
		i++;
		}
		while(i<count && ((eval("formObj.item_code_"+i).value) == item_code)){
			item_qty = item_qty + eval(eval("formObj.received_qty_"+i).value==""?"0":eval("formObj.received_qty_"+i).value);
			item_code = eval("formObj.item_code_"+i).value;
			item_desc = eval("formObj.item_desc_"+i).value;
			i++;
		}
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/AcknowledgmentValidate.jsp?validate=QUANTITY&item_qty="+eval(item_qty)+"&item_code="+item_code+"&fm_store_code="+formObj.to_store_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		//alert(responseText);
		if(!result){
			var msg = "Sum Of Received Quantity Should Be In Multiples Of <B>"+flag+"</B> For The Item:: <B>"+item_desc
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
			obj.checked = false;
			obj.value = "N";
			return false;
		}else{
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}
		//item_code = eval("formObj.item_code_"+i).value;
		//item_desc = eval("formObj.item_desc_"+i).value;
		/*if(eval("formObj.received_qty_"+i).value==""){
			alert("Received Quantity Cannot Be Blank");
			obj.checked = false;
			obj.value = "N";
			eval("formObj.received_qty_"+i).focus();
			return;
		}*/
	}
	for(var i=0;i<count;){
		var item_qty = 0;
		if(!((eval("formObj.item_code_"+i).value) == item_code)){
		item_code = eval("formObj.item_code_"+i).value;
		item_desc = eval("formObj.item_desc_"+i).value;
		item_qty = item_qty +  eval(eval("formObj.rejected_qty_"+i).value==""?"0":eval("formObj.rejected_qty_"+i).value);
		i++;
		}
		while(i<count && ((eval("formObj.item_code_"+i).value) == item_code)){
			item_qty = item_qty +  eval(eval("formObj.rejected_qty_"+i).value==""?"0":eval("formObj.rejected_qty_"+i).value);
			item_code = eval("formObj.item_code_"+i).value;
			item_desc = eval("formObj.item_desc_"+i).value;
			i++;
		}
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/AcknowledgmentValidate.jsp?validate=QUANTITY&item_qty="+eval(item_qty)+"&item_code="+item_code+"&fm_store_code="+formObj.fm_store_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		//alert(responseText);
		if(!result){
			var msg = "Sum Of Rejected Quantity Should Be In Multiples Of <B>"+flag+"</B> For The Item:: <B>"+item_desc
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
			obj.checked = false;
			obj.value = "N";
			return false;
		}else{
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}
	}
	/*if(eval(item_qty)>=0){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/AcknowledgmentValidate.jsp?validate=QUANTITY&item_qty="+item_qty+"&item_code="+item_code+"&fm_store_code="+formObj.fm_store_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		//alert(responseText);
		if(!result){
			var msg = "Sum Of Batch Quantity Should Be In Multiples Of <B>"+flag+"</B> For The Item:: <B>"+item_desc
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
			obj.checked = false;
			obj.value = "N";
			return false;
		}
	}*/
		return true;
}
var prevObj = null;
var prevColor = null;
function changeRowColor(obj, n) {
	if (prevObj != null) {
		for (k = 0; k < n; k++) {
			prevObj.cells[k].className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells[0].className;
	for (k = 0; k < n; k++) {
		obj.cells[k].className = "STLIGHTPINK";
	}
}
async function showRemarks(i) {
	var doc_no				= document.formAcknowledgeList.doc_no.value;
	var seq_no				= document.formAcknowledgeList.seq_no.value;
	var item_code			= eval("document.formAcknowledgeList.item_code_"+i).value;
	var batch_id			= eval("document.formAcknowledgeList.batch_id_"+i).value;
	var expiry_date			= eval("document.formAcknowledgeList.expiry_date_"+i).value;
	var bin_location_code	= eval("document.formAcknowledgeList.bin_location_code_"+i).value;
	var doc_type_code		= eval("document.formAcknowledgeList.doc_type_code_"+i).value;
	
	var rem = "";
	rem = await window.showModalDialog("../../eST/jsp/AcknowledgeRemarks.jsp?remarks=" + eval("document.formAcknowledgeList.remarks_"+i).value+"&doc_no="+doc_no+"&seq_no="+seq_no+"&item_code="+item_code+"&batch_id="+batch_id+"&expiry_date="+expiry_date+"&bin_location_code="+bin_location_code+"&doc_type_code="+doc_type_code, "", "dialogHeight:30vh; dialogWidth:30vw; center:0; status: no; dialogLeft :520; dialogTop :330;");
	if (rem != null) {
		eval("document.formAcknowledgeList.remarks_"+i).value = rem;
	}
}
function updateRemarks() {
	formObject = document.formAcknowledgeRemarks;
	if (!setTextAreaMaxLength(formObject.remarks, 201)) {		
		//alert(getMessage("REMARKS_NOT_EXCEED_200_CH", "Common"));
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$","Remarks");
		msg = msg.replace("#",200);		
		alert(msg);
		return;
	}
	window.returnValue = formObject.remarks.value;
	//window.close();
	const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}
function confirmRecord(index){
	if(eval("parent.frameAcknowledgeDetail.document.formAcknowledgeDetail.confirm_"+index).checked)
		eval("parent.frameAcknowledgeDetail.document.formAcknowledgeDetail.confirm_"+index).value= "Y";
	else
		eval("parent.frameAcknowledgeDetail.document.formAcknowledgeDetail.confirm_"+index).value = "N";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AcknowledgmentValidate.jsp?validate=CONFIRM&confirm_yn="+eval("parent.frameAcknowledgeDetail.document.formAcknowledgeDetail.confirm_"+index).value+"&index="+index+"&doc_no="+eval("parent.frameAcknowledgeDetail.document.formAcknowledgeDetail.doc_no_"+index).value+"&seq_no="+eval("parent.frameAcknowledgeDetail.document.formAcknowledgeDetail.seq_no_"+index).value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	//alert(responseText);
}
function setTrnType(obj){
	if(obj==null)
		obj = document.formAcknowledgeHeader.trn_type;
	var xmlHttp = new XMLHttpRequest();
	/*var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null)); */
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AcknowledgmentValidate.jsp?validate=TRNTYPE&trn_type="+obj.value, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
	//alert(responseText);
}
function setActionType(obj){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AcknowledgmentValidate.jsp?validate=ACTIONTYPE&action_type="+obj.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	//alert(responseText);
}
	/**
	* @Name - Mahesh
	* @Date - 21/01/2010
	* @Inc# - IN015496
	* @Desc - Method duplicated to pass allow_yn value.
	*/

function isValidNumber(fld, e, maxInt, deci,allow_yn) {
	/**
	* @Name - Mahesh
	* @Date - 21/01/2010
	* @Inc# - IN015496
	* @Desc - Code added to accept decimal values dynamically.
	*/

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

//Added by Rabbani #Inc no:30909 on 12/03/12 
//Starts
function checkDocDate(formObj) {
	if (isValidFromToField(formObj.from_doc_date, formObj.to_doc_date, DATE, getLabel("Common.DocDate.label", "Common"))) {
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
//ends
function doYouWantTo(){
  var doIt= confirm('Transaction Will Be Refreshed?');
  if(doIt){
   	f_query_add_mod.location.reload();
	}
  else{
   	return false;
  }
}
//This Function is added for RUT-CRF-0079 By Ganga on 1st AUG 2013 
var previous_indexes	=	"";
function CallBarcodeVerifyItems(e,obj,doc_no,seq_no){	
	var barcode = obj.value;
	
	var previous_index = "";

	if(previous_indexes!= "" || previous_indexes != null){
		for (var i=0;i<previous_indexes.length;i++){
		previous_index	= previous_indexes[i];
			for (var k = 0; k < 12; k++) {
					if(eval(document.getElementById("tr_"+previous_index)).cells[k] != undefined)
						eval(document.getElementById("tr_"+previous_index)).cells[k].className = "FOREDITOR";
			}
		}
	}

	if((e.keyCode==13 || e.keyCode== 9) && barcode != "") {
		var xmlHttp = new XMLHttpRequest();
        var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/AcknowledgmentValidate.jsp?barcode="+barcode+"&doc_no="+doc_no+"&seq_no="+seq_no+"&validate=BARCODE_ITEM_EXISTS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);		
		obj.value="";//This is done for 42985
	}
	

	var selected_indexes	= message.split("-");
	var	current_index		= "";
	
	if(selected_indexes!=""){
		var i;
		for ( i=0;i<selected_indexes.length;i++){
			current_index	= selected_indexes[i];
			for (var k = 0; k < 12; k++) {
						if(eval(document.getElementById("tr_"+current_index)).cells[k]!= undefined)
							eval(document.getElementById("tr_"+current_index)).cells[k].className = "STLIGHTPINK";
			}
		}
		eval(document.getElementById("tr_"+current_index)).scrollIntoView();
		previous_indexes	=	selected_indexes;
	}
}
//Added by Sakti against BRU-HIMS-CRF-073.1
function setStore(store_code) {
	if(store_code != "null" && store_code != "") {
		document.formAcknowledgeHeader.store_code.value = store_code;
	}
}
//Added ends
//Added for TFS id:6938 START
var pre_indexes="";
function CallBarcodeVerifyItemBatches(e,obj,doc_no,seq_no,no_of_decimals){	
	var barcode = obj.value;
	
	var previous_index = "";

	if(pre_indexes!= "" || pre_indexes != null){
		for (var i=0;i<pre_indexes.length;i++){
		previous_index	= pre_indexes[i];
			for (var k = 0; k < 12; k++) {
					if(eval(document.getElementById("tr_"+previous_index)).cells[k] != undefined)
						eval(document.getElementById("tr_"+previous_index)).cells[k].className = "WHITE";
			}
		}
	}

	if((e.keyCode==13 || e.keyCode== 9) && barcode != "") {
		var xmlHttp = new XMLHttpRequest();
        var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/AcknowledgmentValidate.jsp?barcode="+barcode+"&doc_no="+doc_no+"&seq_no="+seq_no+"&validate=BARCODE_ITEM_EXISTS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);		
		obj.value="";//This is done for 42985
	}
	

	var selected_indexes	= message.split("-");
	var	current_index		= "";
	
	if(selected_indexes!=""){
		var i;
		for ( i=0;i<selected_indexes.length;i++){
			current_index	= selected_indexes[i];
			for (var k = 0; k < 12; k++) {
						if(eval(document.getElementById("tr_"+current_index)).cells[k]!= undefined)
							eval(document.getElementById("tr_"+current_index)).cells[k].className = "STLIGHTPINK";
			}
			var temp_qty=0;

			if(eval("document.formAcknowledgeList.received_qty_"+current_index).value !=""){
				 temp_qty=parseInt(eval("document.formAcknowledgeList.received_qty_"+current_index).value);
			}
			//var temp_qty=parseInt(eval("document.formAcknowledgeList.received_qty_"+current_index).value);
			eval("document.formAcknowledgeList.received_qty_"+current_index).value=temp_qty+1;
			populateRejQuantity(current_index,no_of_decimals);
			
		}
		eval(document.getElementById("tr_"+current_index)).scrollIntoView();
		pre_indexes	=	selected_indexes;
	}
}
//Added for TFS id:6938 end

