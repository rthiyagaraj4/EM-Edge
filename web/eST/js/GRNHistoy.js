/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

23/04/2022	23925			Ramesh Goli		23/04/2022		RAMESH G    	MO-CRF-20171
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
function CloseWindow() {
	parent.window.close();
}
function reset() {
	f_query_add_mod.location.reload();
}
async function callItemMasterWindow(search_string) {
	retVal = await window.showModalDialog("../../eMM/jsp/ItemMaster.jsp?search_string=" + encodeURIComponent(search_string), "", "dialogHeight:90vh; dialogWidth:80vw; center:0; status: no; dialogLeft :90; dialogTop :125;");
	
	//&category="+objform.category.value+"&searchby="+radioval+"&sole_source="+objform.sole_source.value+"&item_code="+item_code+"&short_desc="+short_desc+"&item_class="+objform.item_class.value+"&alpha_code="+alpha_code+"&item_remarks="+item_remarks+"&trade_id="+trade_id+"&trade_name="+trade_name+"&trade_name="+trade_name+"&search="+search+"&ps_item="+objform.ps_item.value+"&eff_status="+objform.enabled_Yn.value+"&spl_item="+objform.spl_item.value+"&item_analysis_1="+objform.item_analysis_1.value+"&manufacturer="+objform.manufacturer.value+"&item_analysis_2="+objform.item_analysis_2.value+"&search_criteria="+objform.search_criteria.value+"&item_analysis_3="+objform.item_analysis_3.value+"&search_string="+objform.search_string.value
	
	//retVal=window.open("../jsp/ItemSearch.jsp?search_string="+search_string+"&store_code="+store_code+"&category="+category+"&sole_source="+sole_source+"&ps_item="+ps_item+"&mfg_item="+mfg_item+"&expiry="+expiry+"&item_class="+item_class,'','dialogHeight:30; dialogWidth:50; center:0; status: no; dialogLeft :200; dialogTop :100;');
	return retVal;
}
async function callItemSearchScreen() {
	//alert("GNT");
	var search_string = "";
	if (!parent.frameGRNHistorySearchQueryCriteria.formGRNHistoryQueryCriteria.item_desc.readOnly) {
		search_string = parent.frameGRNHistorySearchQueryCriteria.formGRNHistoryQueryCriteria.item_desc.value;
	//	alert(search_string);
	}
	var item_code = "";
	var short_desc = "";
	/*	var ps_item ="A";
	var mfg_item ="A";
	var expiry ="A";
	var consignment ="A";
	var item_class ="";
	var search_criteria  = "S";*/
	var retVal = await callItemMasterWindow(search_string);		
	
	if (retVal != null) {
		
		var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var retVal=ret1.split("@");
		item_code = retVal[0];
		short_desc = retVal[1];

	//		parent.parent.frameSalesHeader.document.formSalesHeader.store_code_disabled.value="disabled";
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
		document.formGRNHistoryQueryCriteria.item_code.value =  item_code;
		document.formGRNHistoryQueryCriteria.item_desc.value =  short_desc;
		
		


		//document.formGRNHistoryQueryCriteria.store_cod.value = store_code;
	}
}
function searchVals() {
	objform = parent.frameGRNHistorySearchQueryCriteria.formGRNHistoryQueryCriteria;
	var from_date    =  objform.FM_DATE.value ;
	var to_doc_date =  objform.TO_DATE.value ;
   //alert(from_date);
   //alert(to_doc_date);
   if(from_date==""){
   alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
   objform.FM_DATE.focus();
   return ;
   }  

	 //alert(objform.doc_no.value);
	// alert(objform.ref_no.value);
	 //28/10/11
	var temp_jsp = "../jsp/GRNHistoryValidate.jsp?function_type=1&item_code=" + objform.item_code.value + "&doc_no=" + objform.doc_no.value + "&ext_doc_no=" + objform.ref_no.value +"&supp_code=" + objform.supplier.value + "&finalized_yn=" + objform.finalized_yn.value + "&fm_doc_date=" + objform.FM_DATE.value + "&to_doc_date=" + objform.TO_DATE.value + "&store_code=" + objform.store.value + "&replace_on_expiry_yn=" + objform.repl_grn.value + "&po_no=" + objform.po_no.value;
	var xmlStr = "<root><SEARCH /></root>";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	parent.frameGRNHistoryQueryResult.document.location.href = "../../eST/jsp/GRNHistoryQueryResult.jsp";
}
function activeLink() {
	if (parent.frameGRNHistoryQueryResult.GRNResultForm != null) {
		formObjCriteria = parent.frameGRNHistorySearchQueryCriteria.formGRNHistoryQueryCriteria;
		formObjResult = parent.frameGRNHistoryQueryResult.GRNResultForm;
		if (formObjResult.start.value != 0) {
			parent.frameGRNHistorySearchQueryCriteria.formGRNHistoryQueryCriteria.previous.disabled = false;
		} else {
			parent.frameGRNHistorySearchQueryCriteria.formGRNHistoryQueryCriteria.previous.disabled = true;
		}
		if (!((parseInt(formObjResult.start.value) + parseInt(formObjResult.displaySize.value)) >= formObjResult.totalRecords.value)) {
			parent.frameGRNHistorySearchQueryCriteria.formGRNHistoryQueryCriteria.next.disabled = false;
		} else {
			parent.frameGRNHistorySearchQueryCriteria.formGRNHistoryQueryCriteria.next.disabled = true;
		}
	}
}
function goNext() {
	formObj = parent.frameGRNHistoryQueryResult.GRNResultForm;
	start = parseInt(formObj.start.value) + parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) + parseInt(formObj.displaySize.value);
	parent.frameGRNHistoryQueryResult.location.href = "../../eST/jsp/GRNHistoryQueryResult.jsp?from=" + start + "&to=" + end;
}
function goPrev() {
	formObj = parent.frameGRNHistoryQueryResult.GRNResultForm;
	start = parseInt(formObj.start.value) - parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) - parseInt(formObj.displaySize.value);
	parent.frameGRNHistoryQueryResult.location.href = "../../eST/jsp/GRNHistoryQueryResult.jsp?from=" + start + "&to=" + end;
}
async function displayPending(item_code, doc_type_code, doc_no) {
	
	for (var i = 1; i < document.getElementById('tb1').rows.length; i++) {
		var className = "";
		/*	if(i%2){
			className = "QRYEVEN";
		}else{
			className = "QRYODD";
		}
		/*if(i==count){
			eval("document.getElementById("period_")"+count).className="STLIGHTPINK";
			eval("document.getElementById("qty_")"+count).className="STLIGHTPINK";
			eval("document.getElementById("cost_")"+count).className="STLIGHTPINK";
		}else{
		if(eval("document.getElementById("period_")"+i)!=null){
			
//			eval("document.getElementById("period_")"+i).style.background="";
			eval("document.getElementById("period_")"+i).className=className;
		}

		if(eval("document.getElementById("qty_")"+i)!=null){
//			eval("document.getElementById("qty_")"+i).style.background="";
			eval("document.getElementById("qty_")"+i).className=className;	
		}
		if(eval("document.getElementById("cost_")"+i)!=null){
//			eval("document.getElementById("qty_")"+i).style.background="";
			eval("document.getElementById("cost_")"+i).className=className;	
		}
		}
	*/
	}
	var dialogFeatures = "dialogHeight:72vh; dialogWidth:46vw;dialogLeft :100; dialogTop :200; scrolling :no; status:no";
	var retVal = await window.showModalDialog("../../eST/jsp/GRNHistoryFrameList.jsp?item_code=" + item_code + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no, "", dialogFeatures);
}
async function displayRtvReplPending(item_code, doc_type_code, doc_no) {
	var dialogFeatures = "dialogHeight:20vh; dialogWidth:35vw;dialogLeft :100; dialogTop :200; scrolling :yes; status:no";
	var retVal =await window.showModalDialog("../../eST/jsp/GRNHistoryReplFrameList.jsp?item_code=" + item_code + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no, "", dialogFeatures);
}

function chkvaliddate(){
	formObj = f_query_add_mod.document.VMISalesOrConsumptionCriteria;
 if (isValidFromToField(formObj.FM_DATE.value, formObj.TO_DATE.value, DATE, getLabel("Common.date.label", "Common"))) {
		formObj.submit();
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
//23925 Start
function getFile(imageRef){
	window.open("../../eST/jsp/ViewGRNBatchUploadFile.jsp?imageRef="+imageRef,'Document',"height="+screen.height+",width="+screen.width+",top=0,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes,addressbar=no");
}
//23925 End.
