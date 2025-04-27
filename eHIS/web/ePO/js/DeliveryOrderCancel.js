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
	var po_no =obj.cells[0].innerText;
	var po_order_mode =obj.cells[6].innerText;
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
	if( f_query_add_mod.DeliveryCancelOrderQueryResultFrame==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObject = f_query_add_mod.DeliveryCancelOrderQueryResultFrame.document.formDeliveryCancelOrderQueryResult;
	if (formObject == null) {
		messageFrame.location.href = errorPage+"?err_num=";
		return;
	}
	var total_items = formObject.total_check_boxes.value;
	var chkdValue = 0;
	for (count = 0;count<total_items;count++) {
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
	if (chkdValue<=0) {
	
		assignBean(formObject);
		xmlStr = getXMLString(formObject);
		xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderCancelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=4", false);
		xmlHttp.send(xmlDom);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(result){
				CancelYN = confirmCancel(); 
		}else{
			messageFrame.location.href = errorPage+"?err_num="+ getMessage('MIN_ONE_DETAIL_REQUIRED','Common');
			return;
		}	
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

	if(formObject.do_cancel_yn.value=="N"){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("NO_DELETE_ACCESS_FOR_USER", "ST");;
		return false;
	}
	
	if (chkdValue > 0) {
		var title = "Confirm";
		var header = "Items that are pending for Receipt will be marked as Cancelled. Do you wish to continue?";
		var doStatus = confirmWindow(title,header);
		
		if(doStatus == "Yes"){
			CancelYN = confirmCancel(); 
		}else{
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
			return false;
		}
	
	}
	
	
	//	CancelYN = confirmCancel(); 
		
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
	
	changeRowColor(trObj,6);
	var do_no =trObj.cells[0].innerText;
	
	retVal=window.showModalDialog("../../ePO/jsp/DeliveryOrderCancelList.jsp?function_id="+parent.parent.function_id+"&do_no="+do_no,'','dialogHeight:20; dialogWidth:70; center:0; status: no; scroll: no; dialogLeft :75; dialogTop :250;');
	 
	 if(retVal){
		frmObj = document.formDeliveryCancelOrderQueryResult;
		var total_items = frmObj.total_check_boxes.value;
		for (count = 0;count<total_items;count++) {
			eval("frmObj.doc_"+count+"").disabled = true ;
		}
		frmObj.cancelAll.disabled = true;
	 }
//	parent.DeliveryCancelOrderQueryListFrame.document.location.href = "../../ePO/jsp/DeliveryOrderCancelList.jsp?function_id="+parent.parent.function_id+"&do_no="+do_no ; 
	
}

function showReason(trObj,index) {
	changeRowColor(trObj,6);
	var do_no =trObj.cells[0].innerText;
	var do_date = trObj.cells[1].innerText;
	
	if (eval ("document.formDeliveryCancelOrderQueryResult.doc_"+index+".checked")){
		retVal=window.showModalDialog("../../ePO/jsp/DeliveryOrderCancelRemarks.jsp?function_id="+parent.parent.function_id+"&do_date="+do_date+"&do_no="+do_no,'','dialogHeight:10; dialogWidth:32; center:0; status: no; dialogLeft :75; dialogTop :250;');
		
		while(retVal == undefined){
			alert('Please Press Close Button');
			retVal=window.showModalDialog("../../ePO/jsp/DeliveryOrderCancelRemarks.jsp?function_id="+parent.parent.function_id+"&do_date="+do_date+"&do_no="+do_no,'','dialogHeight:10; dialogWidth:32; center:0; status: no; dialogLeft :75; dialogTop :250;');
		}	
		(eval("document.formDeliveryCancelOrderQueryResult.rem_"+index)).value=retVal;
	}
}

function updateRemarks() {
	formObject = document.formDeliveryCancelOrderRemarks;
	/*if (!setTextAreaMaxLength(formObject.remarks,200)) {
		alert (getMessage('REMARKS_CHAR_EXCEEDS_LIMIT','ST'));
		return;
	}*/
	if (formObject.remarks.value == "") {
		checkField(formObject.remarks,getLabel("Common.remarks.label","Common"));
		return;
	}
	assignBean(formObject);
	xmlStr = getXMLString(formObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderCancelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	window.returnValue = formObject.remarks.value;
	window.close();
}

function SubmitLink(from, to) {
	var formObject = document.formDeliveryCancelOrderQueryResult;
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
	xmlStr = getXMLString(formObject);
	xmlDom.loadXML(xmlStr);

	xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderCancelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=2", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ;
}


function changeMyRowColor(index,n,chkObj) { 
	var trObj=eval("document.getElementById("tr_")"+index+"");
	var total_check_boxes = document.formDeliveryCancelOrderQueryResult.total_check_boxes.value;
	
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
		for( k=0;k<total_check_boxes;k++){
			eval("document.getElementById("do_td_")"+k+"").disabled=true;
		}
	}else{
		eval("document.getElementById("remarks_td_")"+index+"").disabled=true;
		eval("document.getElementById("manditHidden_")"+index+"").style.visibility="hidden";
		for( k=0;k<total_check_boxes;k++){
			eval("document.getElementById("do_td_")"+k+"").disabled=false;
		}
	}
}

function changeMyRowColor1(index,n,chkObj) { 
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
		
	}
}
function showReason1(trObj,index) {
	changeRowColor(trObj,5);
//	var do_no =trObj.cells[0].innerText;
//	var do_date = trObj.cells[1].innerText;

	var do_no = eval("document.formDeliveryCancelOrderList.do_no_"+index).value ;
	var do_date = eval("document.formDeliveryCancelOrderList.item_code_"+index).value ;
	
	if (eval ("document.formDeliveryCancelOrderList.doc_"+index+".checked")){
		retVal=window.showModalDialog("../../ePO/jsp/DeliveryOrderCancelRemarks.jsp?function_id="+parent.parent.function_id+"&do_date="+do_date+"&do_no="+do_no,'','dialogHeight:10; dialogWidth:32; center:0; status: no; dialogLeft :75; dialogTop :250;');
		
		while(retVal == undefined){
			alert('Please Press Close Button');
			retVal=window.showModalDialog("../../ePO/jsp/DeliveryOrderCancelRemarks.jsp?function_id="+parent.parent.function_id+"&do_date="+do_date+"&do_no="+do_no,'','dialogHeight:10; dialogWidth:32; center:0; status: no; dialogLeft :75; dialogTop :250;');
		}
			
		(eval("document.formDeliveryCancelOrderList.rem_"+index)).value=retVal;
	}
}


function changeRowColor(obj,n) {

	if(prevObj!=null){
		for( k=0;k<n;k++)
			prevObj.cells(k).className=prevColor;
	}
	prevObj=obj;
	prevColor=obj.cells(1).className;
	for( k=0;k<n;k++)
		obj.cells(k).className="STLIGHTPINK";
}

function submitQueryCriteria(){
	if (isValidFromToField(document.formDeliveryCancelOrderQueryCriteria.from_doc_date,document.formDeliveryCancelOrderQueryCriteria.to_doc_date,DATE,"Doc Date",parent.parent.messageFrame,"../../eCommon/jsp/error.jsp")) {
		document.formDeliveryCancelOrderQueryCriteria.submit();
	}
}
function toggleCheck(formObject){
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
						eval("document.getElementById("do_td_")"+j+"").disabled=true;
					}
					
					}
				}else{
					for (j=0; j<allElements.length; j++){
					if(eval("document.getElementById("remarks_td_")"+j+"")){
						eval("document.getElementById("remarks_td_")"+j+"").disabled=true;
						eval("document.getElementById("manditHidden_")"+j+"").style.visibility="hidden";
						eval("document.getElementById("do_td_")"+j+"").disabled=false;
					}
					
					}
				}
			}			
		}
	}
}

function frmdate(){
   var from_date     =  document.formDeliveryCancelOrderQueryCriteria.from_doc_date.value ;
   var to_doc_date   =  document.formDeliveryCancelOrderQueryCriteria.to_doc_date.value ;
   var locale        =  document.formDeliveryCancelOrderQueryCriteria.p_language_id.value;
   if(locale != "en") {
		from_date = convertDate(from_date, "DMY", locale, "en");
		to_doc_date = convertDate(to_doc_date, "DMY", locale, "en");
	}

   if(from_date==""){
   alert(getMessage("FROM_DATE_NOT_BLANK", "PO"));
   document.formDeliveryCancelOrderQueryCriteria.from_doc_date.focus();
   return ;
   }
   else if(to_doc_date==""){
   alert(getMessage("TO_DATE_NOT_BLANK", "PO"));
   document.formDeliveryCancelOrderQueryCriteria.to_doc_date.focus();
   return ;
   }
   else if(!isBefore(from_date,to_doc_date,"DMY",'en'.value)) {
   alert(getMessage("FM_DATE_GR_TO_DATE", "PO"));
   document.formDeliveryCancelOrderQueryCriteria.from_doc_date.focus();
   return ;
   }
   else
	{
	submitQueryCriteria();
    }
}

function saveVals(){
	
	var bean_id = document.formDeliveryCancelOrderList.bean_id.value;
	var bean_name = document.formDeliveryCancelOrderList.bean_name.value;
	xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	frmObj = document.formDeliveryCancelOrderList;
	
		
	var total_items = eval(frmObj.total_records.value);
	var chkdValue = 0;
	for (count = 0;count<total_items;count++) {
			if(eval("frmObj.doc_"+count+".checked")) {
			
			// Added
			if(eval("frmObj.rem_"+count).value == ""){ 
			// parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-000001 Remarks cannot be blank... ";
			alert("APP-000001 Remarks cannot be blank... ");
			return;
			}else if(eval("frmObj.rem_"+count).value =='undefined'){
			// parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-000001 Remarks cannot be blank... ";
			alert("APP-000001 Remarks cannot be blank... ");
			return;
			}
			// End
				chkdValue++;
			
			
			
		xmlDom.loadXML(getEnhancedXMLString(frmObj));
		xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderCancelValidate.jsp?function_type=3&bean_name=" + bean_name + "&bean_id=" + bean_id+"&do_no="+eval("frmObj.do_no_"+count).value+"&do_srl_no="+eval("frmObj.do_srl_no_"+count).value+"&item_code="+eval("frmObj.item_code_"+count).value +"&rem_value=" + eval("frmObj.rem_"+count).value, false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		//alert(responseText);
		eval(responseText);
		
		window.returnValue = result;
		window.close();
	}
	
	}
	
	
	
}
