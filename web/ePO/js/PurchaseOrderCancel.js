var xmlDom;
var xmlHttp;
var prevObj=null;
var prevColor=null;

function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
}

function Modify(obj){
	var po_no =obj.cells[1].innerText;
	var po_order_mode =obj.cells[5].innerText; 
	parent.document.location.href="../../ePO/jsp/PurchaseOrderCancelFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&po_order_mode="+po_order_mode+"&po_no="+po_no;
}

function onSuccess(){
	f_query_add_mod.document.location.reload();
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;
	return;
}

function reset() {
		f_query_add_mod.location.reload();
}

function query() {
		f_query_add_mod.location.href="../../ePO/jsp/PurchaseOrderCancelQueryFrame.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;
}

function apply() {
	if( f_query_add_mod.STPOCancelOrderQueryResultFrame==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObject = f_query_add_mod.STPOCancelOrderQueryResultFrame.document.formSTPOCancelOrderQueryResult;
	if (formObject == null) {
		messageFrame.location.href = errorPage+"?err_num=";
		return;
	}
	var total_items = formObject.total_check_boxes.value;
	var chkdValue = 0;
/*	for (count = 0;count<total_items;count++) {
		
		if(eval("formObject.doc_"+count+".checked")) {
			
			// Added
			if(eval("formObject.rem_"+count).value == ""){ 
			 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-000001 Remarks cannot be blank... ";
			return;
			}else if(eval("formObject.rem_"+count).value =='undefined'){
			 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-000001 Remarks cannot be blank... ";
			return;
			}
			
			// End
			chkdValue++;
			}
	}
*/
	assignBean(formObject);
	//xmlStr = getXMLString(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderCancelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=5", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
					
	if(result){
		chkdValue++;
	}else{
		for (count = 0;count<total_items;count++) {
			if(eval("formObject.doc_"+count+".checked")) {
				chkdValue++;
			}
		}	
	}	
				
	if (chkdValue<=0) {
		messageFrame.location.href = errorPage+"?err_num="+ getMessage('MIN_ONE_DETAIL_REQUIRED','Common');
		return;
	}
	var selectedIndices = "";
	var index = 0;
	var flag  = "true";
	var total_check_boxes = formObject.total_check_boxes.value;
	
	for (count = 0;count<total_check_boxes;count++) {
		if(eval("formObject.doc_"+count+".checked") ) {
			selectedIndices += (count+ ",");
		}
	}
	formObject.checkedIndices.value = selectedIndices;
	
	var poCancel = formObject.poCancel.value;
	var poClose = formObject.poClose.value;

	if(poCancel == "Y")
		CancelYN = confirmCancel(); 
	else if(poClose == "Y")
		CancelYN = confirmClose(); 
	
	if(CancelYN=="")
		{
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
		return false;
		}
	if(CancelYN == "Yes"  ) {
		var appResult  = formApply(formObject, PO_CONTROLLER);
		eval(appResult);
		
		if (message == "INVALID_REMARKS") {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-000001 Remarks cannot be blank... ";
		}
		else{
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage(message,'PO');
		}
		if(result) {
			onSuccess();
		}
	}else {
	   f_query_add_mod.document.location.reload();
	   messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage("OPER_CANCELLED","PO");
	}
}

function displayPending(trObj) {
	changeRowColor(trObj,8);
	var po_no =trObj.cells[1].innerText;
	var po_order_mode = trObj.cells[8].innerText;
	retVal=window.showModalDialog("../../ePO/jsp/PurchaseOrderCancelList.jsp?function_id="+parent.parent.function_id+"&po_order_mode="+po_order_mode+"&po_no="+po_no,'','dialogHeight:15; dialogWidth:60; center:0; status: no; scroll: no; dialogLeft :75; dialogTop :250;');
	
}

function showReason(trObj,index) {
	changeRowColor(trObj,8);
	var po_no =trObj.cells[1].innerText;
	var po_order_mode = trObj.cells[8].innerText;
	if (eval ("document.formSTPOCancelOrderQueryResult.doc_"+index+".checked")){
		retVal=window.showModalDialog("../../ePO/jsp/PurchaseOrderCancelRemarks.jsp?function_id="+parent.parent.function_id+"&po_order_mode="+po_order_mode+"&po_no="+po_no+"&po_close="+document.formSTPOCancelOrderQueryResult.poClose.value+"&po_cancel="+document.formSTPOCancelOrderQueryResult.poCancel.value,'','dialogHeight:10; dialogWidth:32; center:0; status: no; dialogLeft :75; dialogTop :250;');
		
		while(retVal == undefined){
			alert(getMessage("PLS_PRESS_CLOSE_BUTTON","PO"));
			//retVal=window.showModalDialog("../../ePO/jsp/PurchaseOrderCancelRemarks.jsp?function_id="+parent.parent.function_id+"&po_order_mode="+po_order_mode+"&po_no="+po_no,'','dialogHeight:10; dialogWidth:32; center:0; status: no; dialogLeft :75; dialogTop :250;');
			retVal=window.showModalDialog("../../ePO/jsp/PurchaseOrderCancelRemarks.jsp?function_id="+parent.parent.function_id+"&po_order_mode="+po_order_mode+"&po_no="+po_no+"&po_close="+document.formSTPOCancelOrderQueryResult.poClose.value+"&po_cancel="+document.formSTPOCancelOrderQueryResult.poCancel.value,'','dialogHeight:10; dialogWidth:32; center:0; status: no; dialogLeft :75; dialogTop :250;');
		}
		(eval("document.formSTPOCancelOrderQueryResult.rem_"+index)).value=retVal;
	}
}

function updateRemarks() { 
	formObject = document.formSTPOCancelOrderRemarks;
	/*if (!setTextAreaMaxLength(formObject.remarks,200)) {
		alert (getMessage('REMARKS_CHAR_EXCEEDS_LIMIT','ST'));
		return;
	}*/
	if (formObject.remarks.value == "") {
		checkField(formObject.remarks,getLabel("Common.remarks.label","Common"));
		return;
	}
	assignBean(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderCancelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	window.returnValue = formObject.remarks.value;
	window.close();
}

function SubmitLink(from, to) {
	var formObject = document.formSTPOCancelOrderQueryResult;
	var selectedIndices = "";
	var index = 0;
	var total_check_boxes = formObject.total_check_boxes.value;
	for (count = 0;count<total_check_boxes;count++) {
			if(eval("formObject.doc_"+count+".checked")) {
				selectedIndices += (count+ ",");
			}
	}
	
	formObject.checkedIndices.value = selectedIndices;
	
	assignBean(formObject);
//	xmlStr = getXMLString(formObject);
	xmlStr = getXMLStringForPOCancel(formObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderCancelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=2", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ;
}


function changeMyRowColor(index,n,chkObj,po_no) { 
	var formObject = document.formSTPOCancelOrderQueryResult;
	var trObj=eval("document.getElementById("tr_")"+index+"");
	if (chkObj.checked) 
		//OAGREEN,OAHOLIDAY,DATACHANGE,ORPANEL,ORHIGHER		
		classValue="DATACHANGE"
	else if (index%2==0) 
		classValue="OAQRYEVEN";
	else
		classValue="OAQRYODD";

	for( k=0;k<n;k++)
		trObj.cells(k).className=classValue;
	if (chkObj.checked){
		eval("document.getElementById("remarks_td_")"+index+"").disabled=false;
		eval("document.getElementById("manditHidden_")"+index+"").style.visibility="visible";
	}else{
		eval("document.getElementById("remarks_td_")"+index+"").disabled=true;
		eval("document.getElementById("manditHidden_")"+index+"").style.visibility="hidden";
	//	alert("chkObj.value = "+chkObj.value);
		
		assignBean(formObject);
	//	xmlStr = getXMLString(formObject);
		xmlStr = getEnhancedXMLString(formObject);
		xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderCancelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&key="+chkObj.value+"&function_type=4", false);
		xmlHttp.send(xmlDom);
		responseText=xmlHttp.responseText;
		eval(responseText);
	}
		//Added By Sakti to uncheck the check box if grn_qty != delv_qty inc#40671
	if (chkObj.checked){
//if(formObject.poClose.value == "Y") {
		assignBean(formObject);
		xmlStr = getEnhancedXMLString(formObject);
		xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderCancelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&po_no="+po_no+"&function_type=6", false);
		xmlHttp.send(xmlDom);
		responseText=xmlHttp.responseText;
		eval(responseText);
		
	if(result){
		if(formObject.poClose.value == "Y") {
		if(flag == "qty"){
		alert(getMessage("CANNOT_CLOSE_PO_SINGLE", "PO"));
		}
	}
		if(flag == "grn_unf_qty"){
			alert(getMessage("CANNOT_CLOSE_PO_GRN_UNF_QTY", "PO"));
		}else if(flag == "blocked"){
			alert(getMessage("CANNOT_CLOSE_PO_DO_UNF_QTY", "PO"));
		}
		if(formObject.poClose.value == "Y") {
			classValue="OAQRYODD";
			for( k=0;k<n;k++){
			trObj.cells(k).className=classValue;
		}	chkObj.checked = false;	
			eval("document.getElementById("remarks_td_")"+index+"").disabled=true;
			eval("document.getElementById("manditHidden_")"+index+"").style.visibility="hidden";
		}else{
			if(flag == "grn_unf_qty" || flag == "blocked"){
				classValue="OAQRYODD";
				for( k=0;k<n;k++){
					trObj.cells(k).className=classValue;
				}	chkObj.checked = false;	
					eval("document.getElementById("remarks_td_")"+index+"").disabled=true;
					eval("document.getElementById("manditHidden_")"+index+"").style.visibility="hidden";
				}
			}
		}
		//}//Added ends
  }//Added ends
}

function changeRowColor(obj,n) {
	if(prevObj!=null){
		for( k=0;k<n;k++)
			prevObj.cells(k).className=prevColor;
	}
	prevObj=obj;
	prevColor=obj.cells(0).className;
	for( k=0;k<n;k++)
		obj.cells(k).className="STLIGHTPINK";
}

function submitQueryCriteria(){

   var from_date     =  document.formSTPOCancelOrderQueryCriteria.from_doc_date.value ;
   var to_doc_date   =  document.formSTPOCancelOrderQueryCriteria.to_doc_date.value ;
   var locale        =  document.formSTPOCancelOrderQueryCriteria.p_language_id.value;
   if(locale != "en") {
		from_date = convertDate(from_date, "DMY", locale, "en");
		to_doc_date = convertDate(to_doc_date, "DMY", locale, "en");
	}

   if(from_date==""){
	   parent.frames[1].document.location.href = "../../eCommon/html/blank.html";
	   alert(getMessage("FROM_DATE_NOT_BLANK", "PO"));
	   document.formSTPOCancelOrderQueryCriteria.from_doc_date.focus();
	   return ;
   }
   else if(to_doc_date==""){
	   parent.frames[1].document.location.href = "../../eCommon/html/blank.html";
	   alert(getMessage("TO_DATE_NOT_BLANK", "PO"));
	   document.formSTPOCancelOrderQueryCriteria.to_doc_date.focus();
	   return ;
   }
   else if(!isBefore(from_date,to_doc_date,"DMY",'en'.value)) {
	   parent.frames[1].document.location.href = "../../eCommon/html/blank.html";
	   alert(getMessage("FM_DATE_GR_TO_DATE", "PO"));
	   document.formSTPOCancelOrderQueryCriteria.from_doc_date.focus();
	   return ;
   }


	if (isValidFromToField(document.formSTPOCancelOrderQueryCriteria.from_doc_date,document.formSTPOCancelOrderQueryCriteria.to_doc_date,DATE,"Doc Date",parent.parent.messageFrame,"../../eCommon/jsp/error.jsp")) {
		document.formSTPOCancelOrderQueryCriteria.submit();
	}
}
function toggleCheck(formObject){
	var formObject = document.formSTPOCancelOrderQueryResult;
	assignBean(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	xmlDom.loadXML(xmlStr);
	var key="";
	var cnt=0;
	var exist=false;
	var allElements	=	formObject.elements;
	var ischecked=formObject.cancelAll.checked;
	for (i=0; i<allElements.length; i++){
		if (allElements[i].type=="checkbox"){
			if (!allElements[i].disabled){ 
				allElements[i].checked=ischecked;
				if(ischecked){
					for (j=0; j<allElements.length; j++){
					if(eval("document.getElementById("remarks_td_")"+j+"")){
						eval("document.getElementById("remarks_td_")"+j+"").disabled=false;
						eval("document.getElementById("manditHidden_")"+j+"").style.visibility="visible";
					}
		//Added By Sakti to uncheck the check box if po_qty != delv_qty inc#40671
				//if(formObject.poClose.value == "Y"){
					if(eval("document.getElementById("doc_")"+j+"")){
						key = eval("document.getElementById("doc_")"+j+"").value;
						var key_split=key.split("-");
						xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderCancelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&po_no="+key_split[1]+"&function_type=6", false);
						xmlHttp.send(xmlDom);
						responseText=xmlHttp.responseText;
						eval(responseText);
						
						if(result){
							if(formObject.poClose.value == "Y"){
						formObject.cancelAll.checked = false;
						eval("document.getElementById("doc_")"+j+"").checked=false;
						eval("document.getElementById("remarks_td_")"+j+"").disabled=true;
						eval("document.getElementById("manditHidden_")"+j+"").style.visibility="hidden";
							}else{
								if(flag == "grn_unf_qty" || flag == "blocked"){
									formObject.cancelAll.checked = false;
									eval("document.getElementById("doc_")"+j+"").checked=false;
									eval("document.getElementById("remarks_td_")"+j+"").disabled=true;
									eval("document.getElementById("manditHidden_")"+j+"").style.visibility="hidden";
								}
							}
						}
					}
				//}//Added ends
			}
				for (j=0; j<allElements.length; j++){
					if(eval("document.getElementById("doc_")"+j+"")){
						cnt = cnt + 1;
					}
				}
			}else{
					for (j=0; j<allElements.length; j++){
					if(eval("document.getElementById("remarks_td_")"+j+"")){
						eval("document.getElementById("remarks_td_")"+j+"").disabled=true;
						eval("document.getElementById("manditHidden_")"+j+"").style.visibility="hidden";
						
					}

					if(eval("document.getElementById("doc_")"+j+"")){
						 key = eval("document.getElementById("doc_")"+j+"").value;
					
				//Added for clearing remarks value after uncheck the check box for all
					xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderCancelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&key="+key+"&function_type=4", false);
					xmlHttp.send(xmlDom);
					responseText=xmlHttp.responseText;
					eval(responseText);
					//Added ends
					} 
					
					
				/*	var formObject = document.formSTPOCancelOrderQueryResult;
					assignBean(formObject);
					xmlStr = getXMLString(formObject);
					xmlDom.loadXML(xmlStr);
					xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderCancelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&key="+chkObj.value+"&function_type=4", false);
					xmlHttp.send(xmlDom);
					responseText=xmlHttp.responseText;
					eval(responseText);
				*/	
					
					}
					
					
				}
			}
			
		}
		
	}
	//Added By Sakti to show the alert box if po_qty != delv_qty inc#40671
		/*if(formObject.poClose.value == "Y"){
			for (k=0; k<cnt; k++){
				if(eval("document.getElementById("doc_")"+k+"")){
				if(eval("document.getElementById("doc_")"+k+"").checked == false){
				alert(getMessage("CANNOT_CLOSE_PO_MULTIPLE", "PO"));
				break;
				}
			}
		}
	}*/
	//Added ends
	//if(formObject.poClose.value == "Y"){

			for (k=0; k<cnt; k++){
				if(eval("document.getElementById("doc_")"+k+"")){
					if(eval("document.getElementById("doc_")"+k+"").checked == false){
					key = eval("document.getElementById("doc_")"+k+"").value;
						var key_split=key.split("-");
						xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderCancelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&po_no="+key_split[1]+"&function_type=6", false);
						xmlHttp.send(xmlDom);
						responseText=xmlHttp.responseText;
						eval(responseText);
						if(result){
							if(formObject.poClose.value == "Y"){
								if(flag == "qty"){
								alert(getMessage("CANNOT_CLOSE_PO_MULTIPLE", "PO"));
								}
							 }
								if(flag == "grn_unf_qty"){
								alert(getMessage("CANNOT_CLOSE_PO_GRN_UNF_QTY_MULTIPLE", "PO"));
								}else if(flag == "blocked"){
								alert(getMessage("CANNOT_CLOSE_PO_DO_UNF_QTY_MULTIPLE", "PO"));
								}
							}
					break;
				}
			}
		}
	//}//Added ends
}
/*function populateStores(request_by_store) {
	if (request_by_store.value == "")	{
		return;
	}
	var arrayObject										=		 new Array();
	arrayObject[0]										=		request_by_store;
	assignBean(document.formSTPOCancelOrderQueryCriteria);
	xmlStr												=		getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../ePO/jsp/STPOCancelOrderValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=3", false);
	xmlHttp.send(xmlDom);
	responseText										=		xmlHttp.responseText;
	eval(responseText);
	
}
function searchRemarks(objCode,objDesc){
	
	var argumentArray		 =		 new Array();
	var dataNameArray		 =		 new Array();
	var dataValueArray		 =		 new Array();
	var dataTypeArray		 =		 new Array();

	dataNameArray[0]		 =		"language_id" ;
	dataValueArray[0]		 =		document.formSTPOCancelOrderRemarks.lang_id.value;
	dataTypeArray[0]		 =		STRING ;
	dataNameArray[1]		 =		"module_id" ;
	dataValueArray[1]		 =		"ST";
	dataTypeArray[1]		 =		STRING ; 
	dataNameArray[2]		 =		"trn_type" ;
	dataValueArray[2]		 =		document.formSTPOCancelOrderRemarks.rem_trans_type.value;
	dataTypeArray[2]		 =		STRING ;
	argumentArray[0]		 =		document.formSTPOCancelOrderRemarks.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[1]		 =		dataNameArray;
	argumentArray[2]		 =		dataValueArray;
	argumentArray[3]		 =		dataTypeArray;
	argumentArray[4]		 =		 "4,5";
	argumentArray[5]		 =		objDesc.value;
	argumentArray[6]		 =		CODE_LINK;
	argumentArray[7]		 =		CODE_DESC;
	returnedValues			 =		CommonLookup( getLabel("Common.remarks.label","Common"), argumentArray );	

	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value		 =		returnedValues[0];
		objDesc.value		 =		returnedValues[1];
	
	} 
	
}*/

function frmdate(){
   var from_date     =  document.formSTPOCancelOrderQueryCriteria.from_doc_date.value ;
   var to_doc_date   =  document.formSTPOCancelOrderQueryCriteria.to_doc_date.value ;
   var locale        =  document.formSTPOCancelOrderQueryCriteria.p_language_id.value;
   if(locale != "en") {
		from_date = convertDate(from_date, "DMY", locale, "en");
		to_doc_date = convertDate(to_doc_date, "DMY", locale, "en");
	}

   if(from_date==""){
	   alert(getMessage("FROM_DATE_NOT_BLANK", "PO"));
	   document.formSTPOCancelOrderQueryCriteria.from_doc_date.focus();
	   return ;
   }
   else if(to_doc_date==""){
	   alert(getMessage("TO_DATE_NOT_BLANK", "PO"));
	   document.formSTPOCancelOrderQueryCriteria.to_doc_date.focus();
	   return ;
   }
   else if(!isBefore(from_date,to_doc_date,"DMY",'en'.value)) {
	   alert(getMessage("FM_DATE_GR_TO_DATE", "PO"));
	   document.formSTPOCancelOrderQueryCriteria.from_doc_date.focus();
	   return ;
   }
   else{
	submitQueryCriteria();
   }
}

function poStatus(stat){
	var formObj = document.formSTPOCancelOrderQueryCriteria;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderCancelValidate.jsp?function_type=3"+"&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value +"&status="+ stat  , false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

function changeTran(obj_tran,stat){
	
	if(stat =='Cancel'){
		if(obj_tran == 'Y'){			
			document.formSTPOCancelOrderQueryCriteria.poCancel.checked = false;
			document.formSTPOCancelOrderQueryCriteria.poClose.checked = true;
			document.formSTPOCancelOrderQueryCriteria.po_order_status.disabled = false;
		}else{
			document.formSTPOCancelOrderQueryCriteria.poCancel.checked = true;
			document.formSTPOCancelOrderQueryCriteria.poClose.checked = false;
			document.formSTPOCancelOrderQueryCriteria.po_order_status.disabled = false;
		}
	}else if(stat == 'Close'){
		if(obj_tran == 'Y'){			
			document.formSTPOCancelOrderQueryCriteria.poClose.checked = false;
			document.formSTPOCancelOrderQueryCriteria.poCancel.checked = true;
			document.formSTPOCancelOrderQueryCriteria.po_order_status.disabled = true;
		}else{
			document.formSTPOCancelOrderQueryCriteria.poClose.checked = true;
			document.formSTPOCancelOrderQueryCriteria.poCancel.checked = false;
			document.formSTPOCancelOrderQueryCriteria.po_order_status.disabled = true;
		}
	}		
	submitQueryCriteria();
}


function searchRemarksHeader(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].lang_id_1.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	dataNameArray[2] = "trn_type";
	if (document.forms[0].bean_master_type.value == "") {
		dataValueArray[2] = "PORDER";
	} else {
		dataValueArray[2] = document.forms[0].bean_master_type.value;
	}
	dataTypeArray[2] = STRING;
  
	argumentArray[0] = document.forms[0].SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = "";
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	}
}


function checkMaxLengthPaste(obj,maxlength)
{


                var len; 
                var txt = clipboardData.getData("Text"); 
                txt = obj.value + txt 
                len = parseInt(txt.length); 
                if ( len >  maxlength ) 
                { 
                        event.returnValue=false; 
                        txt = txt.substring(0, maxlength);                
                        obj.value = txt;                           
                        
                } 
          
    
}

function getXMLStringForPOCancel(frmObj) {
	var arrObj = frmObj.elements;
	var frmObjs = new Array();
	if (frmObj.name == null) {
		frmObjs = frmObj;
	} else {
		frmObjs[0] = frmObj;
	}
	var xmlStr = "<root><SEARCH ";
	for (var frmCount = 0; frmCount < frmObjs.length; frmCount++) {
		frmObj = frmObjs[frmCount];
		var arrObj = frmObj.elements;
		for (var i = 0; i < arrObj.length; i++) {
			var val = "";
			if (arrObj[i].type == "checkbox") {
				//Comented by sakti sankar 
				/*if (arrObj[i].checked) {
				//	alert(arrObj[i].value);
					val = arrObj[i].value;
				} else {
					val = "";
				}*/
				if (arrObj[i].name != null && arrObj[i].name != "") {
					xmlStr += arrObj[i].name + "=\"" + checkSpl(arrObj[i].value) + "\" ";
				}
			} else {
				if (arrObj[i].type == "radio") {
					if (arrObj[i].checked) {
						val = arrObj[i].value;
						if (arrObj[i].name != null && arrObj[i].name != "") {
							xmlStr += arrObj[i].name + "=\"" + checkSpl(val) + "\" ";
						}
					}
				} else {
					if (arrObj[i].type == "select-multiple") {
						for (var j = 0; j < arrObj[i].options.length; j++) {
							if (arrObj[i].options[j].selected) {
								val += arrObj[i].options[j].value + "~";
							}
						}
						val = val.substring(0, val.lastIndexOf("~"));
						if (arrObj[i].name != null && arrObj[i].name != "") {
							xmlStr += arrObj[i].name + "=\"" + checkSpl(val) + "\" ";
						}
					} else {
						val = arrObj[i].value;
						if (arrObj[i].name != null && arrObj[i].name != "") {
							xmlStr += arrObj[i].name + "=\"" + checkSpl(val) + "\" ";
						}
					}
				}
			}
		}
	}
	xmlStr += " /></root>";
	return xmlStr;
}
