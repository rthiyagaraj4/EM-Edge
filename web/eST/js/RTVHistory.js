 
function CloseWindow() {
	//parent.window.close();
	parent.document.getElementById("dialog_tag").close();
}
function reset() {
	f_query_add_mod.location.reload();
}
async function callItemMasterWindow(search_string) {
	retVal = await window.showModalDialog("../../eMM/jsp/ItemMaster.jsp?search_string=" + encodeURIComponent(search_string), "", "dialogHeight:90vh; dialogWidth:80vw; center:0; status: no; dialogLeft :90; dialogTop :125;");
	return retVal;
}
  async function callItemSearchScreen() {
	//alert("a11");
	var search_string = "";
	if (!parent.frameRTVHistorySearchQueryCriteria.formRTVHistoryQueryCriteria.item_desc.readOnly) {
		search_string = parent.frameRTVHistorySearchQueryCriteria.formRTVHistoryQueryCriteria.item_desc.value;
	}
	var item_code = "";
	var short_desc = "";
	var retVal =   await callItemMasterWindow(search_string);	
	
	if (retVal != null) {
		
		var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var retVal=ret1.split("@");
		 	
		
		item_code = retVal[0];
		//alert("item_code"+item_code);
		short_desc = retVal[1];
		//alert("short_desc"+short_desc);
		/*	var temp_jsp="../../eMM/jsp/ItemMasterValidate.jsp?item_code="+ item_code +"&short_desc="+ short_desc;

	var xmlStr ="<root><SEARCH /></root>";
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	alert(responseText);
		eval(responseText);*/
		document.formRTVHistoryQueryCriteria.item_code.value = item_code;
		document.formRTVHistoryQueryCriteria.item_desc.value = short_desc;
	}
}
function searchVals() {
	objform = parent.frameRTVHistorySearchQueryCriteria.formRTVHistoryQueryCriteria;
	var temp_jsp = "../jsp/RTVHistoryValidate.jsp?function_type=1&item_code=" + objform.item_code.value + "&supp_code=" + objform.supplier.value + "&finalized_yn=" + objform.finalized_yn.value + "&fm_doc_date=" + objform.FM_DATE.value + "&to_doc_date=" + objform.TO_DATE.value + "&store_code=" + objform.store.value + "&replace_on_expiry_yn=" + objform.repl_rtv.value;
	var xmlStr = "<root><SEARCH /></root>";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	parent.frameRTVHistoryQueryResult.document.location.href = "../../eST/jsp/RTVHistoryQueryResult.jsp";
}
function activeLink() {
	formObjCriteria = parent.frameRTVHistorySearchQueryCriteria.formRTVHistoryQueryCriteria;
	formObjResult = parent.frameRTVHistoryQueryResult.RTVResultForm;
	if (parent.frameRTVHistoryQueryResult.RTVResultForm.start.value != 0) {
		parent.frameRTVHistorySearchQueryCriteria.formRTVHistoryQueryCriteria.previous.disabled = false;
	} else {
		parent.frameRTVHistorySearchQueryCriteria.formRTVHistoryQueryCriteria.previous.disabled = true;
	}
	if (!((parseInt(formObjResult.start.value) + parseInt(formObjResult.displaySize.value)) >= formObjResult.totalRecords.value)) {
		parent.frameRTVHistorySearchQueryCriteria.formRTVHistoryQueryCriteria.next.disabled = false;
	} else {
		parent.frameRTVHistorySearchQueryCriteria.formRTVHistoryQueryCriteria.next.disabled = true;
	}
}
function goNext() {
	formObj = parent.frameRTVHistoryQueryResult.RTVResultForm;
	start = parseInt(formObj.start.value) + parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) + parseInt(formObj.displaySize.value);
	parent.frameRTVHistoryQueryResult.location.href = "../../eST/jsp/RTVHistoryQueryResult.jsp?from=" + start + "&to=" + end;
}
function goPrev() {
	formObj = parent.frameRTVHistoryQueryResult.RTVResultForm;
	start = parseInt(formObj.start.value) - parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) - parseInt(formObj.displaySize.value);
	parent.frameRTVHistoryQueryResult.location.href = "../../eST/jsp/RTVHistoryQueryResult.jsp?from=" + start + "&to=" + end;
}
async function displayPending(doc_type_code, doc_no, grn_doc_no, grn_doc_type_code, item_code, count) {
	for (var i = 1; i < document.getElementById("tb1").rows.length; i++) {
		var className = "";
		/*if(i%2){
			className = "QRYEVEN";
		}else{
			className = "QRYODD";
		}

		if(i==count){
			eval("document.getElementById("doc_type_no_")"+count).className="STLIGHTPINK";
			eval("document.getElementById("doc_date_")"+count).className="STLIGHTPINK";
			eval("document.getElementById("supp_code_")"+count).className="STLIGHTPINK";
			eval("document.getElementById("rtv_val_")"+count).className="STLIGHTPINK";
			eval("document.getElementById("item_qty_normal_")"+count).className="STLIGHTPINK";
			eval("document.getElementById("item_qty_bonus_")"+count).className="STLIGHTPINK";
			eval("document.getElementById("rtv_unit_cost_in_pur_uom_")"+count).className="STLIGHTPINK";
			eval("document.getElementById("store_code_")"+count).className="STLIGHTPINK";
			eval("document.getElementById("expiry_date_or_receipt_date_")"+count).className="STLIGHTPINK";
			eval("document.getElementById("batch_id_")"+count).className="STLIGHTPINK";
		}
		else{
		if(eval("document.getElementById("doc_type_no_")"+i)!=null){
		eval("document.getElementById("doc_type_no_")"+i).className=className;
		}

		if(eval("document.getElementById("doc_date_")"+i)!=null){
			eval("document.getElementById("doc_date_")"+i).className=className;	
		}
		if(eval("document.getElementById("supp_code_")"+i)!=null){
			eval("document.getElementById("supp_code_")"+i).className=className;	
		}
		if(eval("document.getElementById("rtv_val_")"+i)!=null){
			eval("document.getElementById("rtv_val_")"+i).className=className;	
		}
		if(eval("document.getElementById("item_qty_normal_")"+i)!=null){
			eval("document.getElementById("item_qty_normal_")"+i).className=className;	
		}
		if(eval("document.getElementById("item_qty_bonus_")"+i)!=null){
			eval("document.getElementById("item_qty_bonus_")"+i).className=className;	
		}
		if(eval("document.getElementById("rtv_unit_cost_in_pur_uom_")"+i)!=null){
		eval("document.getElementById("rtv_unit_cost_in_pur_uom_")"+i).className=className;	
		}
		if(eval("document.getElementById("store_code_")"+i)!=null){
			eval("document.getElementById("store_code_")"+i).className=className;	
		}
		if(eval("document.getElementById("expiry_date_or_receipt_date_")"+i)!=null){
		eval("document.getElementById("expiry_date_or_receipt_date_")"+i).className=className;	
		}
		if(eval("document.getElementById("batch_id_")"+i)!=null){
			eval("document.getElementById("batch_id_")"+i).className=className;	
		}
	}*/
	}
	var dialogFeatures = "dialogHeight:40vh; dialogWidth:65vw;dialogLeft :50; dialogTop :200; scrolling :yes; status:no";
	var retVal = await window.showModalDialog("../../eST/jsp/RTVHistoryFrameList.jsp?grn_doc_no=" + grn_doc_no + "&grn_doc_type_code=" + grn_doc_type_code + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&item_code=" + item_code, "", dialogFeatures);
}
async function displayRTV_GRN(doc_type_code, doc_no, item_code) {
	var dialogFeatures = "dialogHeight:20vh; dialogWidth:30vw;dialogLeft :100; dialogTop :200; scrolling :no; status:no";
	var retVal =await window.showModalDialog("../../eST/jsp/RTVHistoryGRNFrameList.jsp?doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&item_code=" + item_code, "", dialogFeatures);
}

