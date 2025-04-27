/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
??
10/08/2022				Chandrashekar Raju A							MO-CRF-20177
---------------------------------------------------------------------------------------------------------
*/  
var xmlDom;
var xmlHttp;
var prevObj=null;
var prevColor=null;

function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlDom = "";
	xmlHttp = new XMLHttpRequest();
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
		f_query_add_mod.location.href="../../eST/jsp/CancelAuthorizationQueryFrame.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;
}

async function apply() {

	var errorPage = "../../eCommon/jsp/error.jsp";
	if( f_query_add_mod.CancelAuthQueryResultFrame==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var formObject = f_query_add_mod.CancelAuthQueryResultFrame.document.formCancelAuthQueryResult;
	if (formObject == null) {
		messageFrame.location.href = errorPage+"?err_num=";
		return;
	}
	var total_items = formObject.total_check_boxes.value;
	var chkdValue = 0;
	var chkditemvalue = 0; 
	  for (count = 0;count<total_items;count++) {
			if(eval("formObject.doc_"+count+".checked")) {
			
				chkdValue++;
			}
			var total_dtl_items  =   eval("formObject.item_size_"+count).value;
			for (j = 0;j<total_dtl_items;j++) {
			if(eval("formObject.item_cancel_"+count+"_"+j) != null){
			if(eval("formObject.item_cancel_"+count+"_"+j+".checked")){
			var item_name = decodeURIComponent(eval("formObject.item_desc_"+count+"_"+j).value,"UTF-8");
					chkditemvalue++;
				}
			  }
			} 
	   }
	if (chkdValue<=0 && chkditemvalue<=0) {  
	messageFrame.location.href = errorPage+"?err_num="+ "APP-ST0211 Select atleast one Issue Request or Stock Item for cancellation"; 
		
		return;
	}
	var selectedIndices = "";
	var selecteditemIndices = ""; 
	var index = 0;
	var total_check_boxes = formObject.total_check_boxes.value;

	for (count = 0;count<total_check_boxes;count++) {
	        var total_dtl_items  =   eval("formObject.item_size_"+count).value; 
			var item_dtl_length  =   eval("formObject.item_dtl_length_"+count).value;
			var flag_chk         =   true;
				if(eval("formObject.doc_"+count+".checked") && (total_dtl_items == item_dtl_length)) {
				 
				    flag_chk = false;
					selectedIndices += (count+ ",");
					
				 }
			for (j = 0;j<total_dtl_items;j++) {
				
			if(eval("formObject.item_cancel_"+count+"_"+j) != "null" && eval("formObject.item_cancel_"+count+"_"+j) != undefined){
			if(eval("formObject.item_cancel_"+count+"_"+j+".checked")){
				
			       if(flag_chk)
					selecteditemIndices += (count+"_"+j+ ",");
				 }
			  }
			}
	  }
	formObject.checkedIndices.value = selectedIndices;
	formObject.checked_item_indices.value = selecteditemIndices;
	
	CancelYN = await confirmCancel(); 
	if(CancelYN==""){
	messageFrame.location.href = errorPage+"?err_num=";
		return false;
	}

	if(CancelYN == "Yes"  ) 
	{
		var appResult  = formApply(formObject, ST_CONTROLLER);

		eval(appResult);
		flag1 = (flag.split("~"))[0];
	    flag2 = (flag.split("~"))[1];
	   flag1 = (flag1 == "null" ? "" : flag1);
	
		if(result) {
		var bean_id = "CancelAuthorizationBean";
	    var bean_name = "eST.CancelAuthorizationBean";
		
			onSuccess();
		}
	}
	else {
	   f_query_add_mod.document.location.reload();
	   messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage("OPER_CANCELLED","ST");
	}
}

async function displayPending(trObj) {
	changeRowColor(trObj,9);
	var doc_no =trObj.cells[2].innerText;
	var doc_type_code = trObj.cells[9].innerText
	retVal=await window.showModalDialog("../../eST/jsp/CancelRequestList.jsp?function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no,'','dialogHeight:15vh; dialogWidth:40vw; center:0; status: no; dialogLeft :75; dialogTop :250;');
	
}


function SubmitLink(from, to) {
	var formObject = document.formCancelAuthQueryResult;
	var selectedIndices = "";
	var selectedItemIndices = ""; 
	var index = 0;
	var total_check_boxes = formObject.total_check_boxes.value;
	
	for (count = 0;count<total_check_boxes;count++) {
	var total_dtl_items  =   eval("formObject.item_size_"+count).value;
	var item_dtl_length  =   eval("formObject.item_dtl_length_"+count).value;
	var flag_chk         =   true;
			    if(eval("formObject.doc_"+count+".checked")) {
				 if(total_dtl_items == item_dtl_length){
				    flag_chk = false;
					selectedIndices += (count+ ",");
					}
		        }
			  for (j = 0;j<total_dtl_items;j++){ 
			  if(eval("formObject.item_cancel_"+count+"_"+j+".checked")){
			  
				  if(flag_chk)
					selectedItemIndices += (count+"_"+j+ ",");
				 }
			   }
	     }
	formObject.checkedIndices.value = selectedIndices;
	formObject.checked_item_indices.value = selectedItemIndices; 
	assignBean(formObject);
	xmlStr = getXMLString(formObject); 
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/CancelAuthorizationValidation.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=5", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ;
}



function changeMyRowColor(index,n,chkObj) { 
	var trObj=eval(document.getElementById("tr_"+index));
	
	var formObject         =   document.formCancelAuthQueryResult;
     var allElements	   =	formObject.elements;
     var dtl_length        =   eval("formObject.item_size_"+index).value;  
	 var total_check_boxes =   formObject.total_check_boxes.value;
	 var ischecked =chkObj.checked;
	 eval("document.formCancelAuthQueryResult.hed_remarks_code_"+index).disabled =false;
	 for (j=0; j<dtl_length; j++) 
	{
		if (allElements[j].type=="checkbox")
			if (!allElements[j].disabled) 
				ischecked =chkObj.checked;
				if(eval("formObject.item_cancel_"+index+"_"+j) !=undefined){
				   eval("formObject.item_cancel_"+index+"_"+j).checked=ischecked;
				   eval("document.formCancelAuthQueryResult.dtl_remarks_code_"+index+"_"+j).disabled =false;
				   if(!ischecked){
					   eval("document.formCancelAuthQueryResult.hed_remarks_code_"+index).disabled =true;
					   eval("document.formCancelAuthQueryResult.dtl_remarks_code_"+index+"_"+j).disabled =true;
				   }
				}
	
	    if (chkObj.checked) {
	
		classValue="DATACHANGE"
	   
	   }
	   else if (index%2==0) {
		classValue="OAQRYEVEN";
		 
		}
	 else{
		classValue="OAQRYODD";
		 
		}

	for( k=0;k<n;k++){
		trObj.cells[k].className=classValue;
}
     var check_all = true;
	 for(i=0; i<total_check_boxes;i++){
	 if(eval("formObject.doc_"+i).checked == false)
	   check_all = false;
	 }
} 
	 if(check_all)
	 formObject.cancelAll.checked = true;
	 else
	 formObject.cancelAll.checked = false;
}


var prevObj=null;
var prevColor=null;

function changeRowColor(obj,n) {
	if(prevObj!=null){
		for( k=0;k<n;k++)
			prevObj.cells[k].className=prevColor;
	}
	prevObj=obj;
	prevColor=obj.cells[0].className;
	for( k=0;k<n;k++)
		obj.cells[k].className="STLIGHTPINK";
}

function submitQueryCriteria(){
	if (isValidFromToField(document.formCancelAuthQueryCriteria.from_doc_date,document.formCancelAuthQueryCriteria.to_doc_date,DATE,getLabel("Common.DocDate.label", "Common"),parent.parent.messageFrame,"../../eCommon/jsp/error.jsp")) 
	{
		if(document.formCancelAuthQueryCriteria.item_desc.value != "")
		{
			alert("When searching for Issue Requests using Item, no other Stock Items contained in the Issue Request ID are displayed");
		}
		document.formCancelAuthQueryCriteria.action="../../eST/jsp/CancelAuthorizationQueryResult.jsp";
		document.formCancelAuthQueryCriteria.target="CancelAuthQueryResultFrame";
		document.formCancelAuthQueryCriteria.submit();
	}
}


function toggleCheck(formObject){
	var allElements	=	formObject.elements;
	var ischecked=formObject.cancelAll.checked;
	for (i=0; i<allElements.length; i++) 
	{
		    if (allElements[i].type=="checkbox")
			if (!allElements[i].disabled){ 
				allElements[i].checked=ischecked;	
			}
	    if(ischecked){
           if(eval("document.formCancelAuthQueryResult.hed_remarks_code_"+i) !=undefined){
			    if(eval("document.formCancelAuthQueryResult.doc_"+i).disabled)
				    eval("document.formCancelAuthQueryResult.hed_remarks_code_"+i).disabled =true;
				else
					eval("document.formCancelAuthQueryResult.hed_remarks_code_"+i).disabled =false;
		      }
			}else if(eval("document.formCancelAuthQueryResult.hed_remarks_code_"+i) !=undefined){
				    eval("document.formCancelAuthQueryResult.hed_remarks_code_"+i).disabled =true;
				}


		
	    if(eval("formObject.item_size_"+i) != null)
		    var dtl_length=     eval("formObject.item_size_"+i).value;

		    for(j=0; j<dtl_length;j++){
			if(ischecked){
               if(eval("document.formCancelAuthQueryResult.dtl_remarks_code_"+i+"_"+j) !=undefined){
				   if(eval("document.formCancelAuthQueryResult.item_cancel_"+i+"_"+j).disabled)
			    	    eval("document.formCancelAuthQueryResult.dtl_remarks_code_"+i+"_"+j).disabled =true;
				   else
				        eval("document.formCancelAuthQueryResult.dtl_remarks_code_"+i+"_"+j).disabled =false;
			    }
			  }else if(eval("document.formCancelAuthQueryResult.dtl_remarks_code_"+i+"_"+j) !=undefined){
				        eval("document.formCancelAuthQueryResult.dtl_remarks_code_"+i+"_"+j).disabled =true;
				}
		   
		}
	}
 }

function populateStores(request_on_store) {
	
	if (request_on_store.value == "")	{
		clearListItems('document.forms[0].request_by_store');
		return;
	}
	
	var arrayObject										=		 new Array();
	arrayObject[0]										=		request_on_store;
	assignBean(document.formCancelAuthQueryCriteria);
	xmlStr												=		getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/CancelAuthorizationValidation.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText										=		xmlHttp.responseText;
	eval(responseText);
	
}
function populateItemClasses(request_on_store,request_by_store) {
	if (request_by_store.value == "" || request_on_store == "")	{
		
		clearListItems('document.forms[0].item_class_code');
		return;
	}
	var arrayObject			=		 new Array();
	arrayObject[0]			=		request_by_store;
	arrayObject[1]			=		request_on_store;
	assignBean(document.formCancelAuthQueryCriteria);
	xmlStr					=		 getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/CancelAuthorizationValidation.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=2", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

function populateReqOnStore(request_type)
{
	parent.CancelAuthQueryResultFrame.location.href=src="../../eCommon/html/blank.html";
	var arrayObject										=		 new Array();
	arrayObject[0]										=		request_type;
	assignBean(document.formCancelAuthQueryCriteria);
	xmlStr												=		getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/CancelAuthorizationValidation.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=3", false);
	xmlHttp.send(xmlDom);
	responseText										=		xmlHttp.responseText;
	eval(responseText);

}

async function callItemSearch() {
	var search_string = "";
	if (!document.formCancelAuthQueryCriteria.item_desc.readOnly) {
		search_string = document.formCancelAuthQueryCriteria.item_desc.value;
	}
	var store_code = "";
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	var store_disable = "Y";
	var retVal = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment, "", "", store_disable);
	if (retVal != null) {
		document.formCancelAuthQueryCriteria.item_code.value = retVal[0];;
		document.formCancelAuthQueryCriteria.item_desc.value = retVal[1];
		document.formCancelAuthQueryCriteria.item_desc.readOnly=true;
	}
}

function expanddetails(obj, trObj,index){
    var doc_no        =  trObj.cells[2].innerText;
	var doc_type_code =  trObj.cells[9].innerText;
	var frmObj        =   document.forms[0];	
	
	       if(eval(document.getElementById("item_dtls_"+doc_no))){	 
			var dispstatus = obj.innerText;
			if(dispstatus == '+'){
				document.getElementById('tblItemList_'+index).style.display ='inline';
				obj.innerText="-";
				obj.style.cursor='hand';
				obj.innerHTML="<a id='view"+index+" href='' width='2%'><font color='blue'><b>"+obj.innerText+"</b></font></a>";
			 }
			 else
			 if(dispstatus == '-'){
				document.getElementById('tblItemList_'+index).style.display ='none';
				obj.innerText="+";
				obj.style.cursor='hand';
				obj.innerHTML="<a id='view"+index+" href='' width='2%'><font color='blue'><b>"+obj.innerText+"</b></font></a>";
				
			}
		}	
}
function ItemCancel(index,n,chkObj)
{
var formObject = document.formCancelAuthQueryResult;
var total_check_boxes = formObject.total_check_boxes.value;
var disable_items ="";
var check_all = true;
  if(chkObj.checked) {	
	   eval("document.formCancelAuthQueryResult.dtl_remarks_code_"+index+"_"+n).disabled =false;
	 }else{
	 key = "";
	 eval("document.formCancelAuthQueryResult.dtl_remarks_code_"+index+"_"+n).disabled =true;
	  
	 }
	 var dtl_length =     eval("formObject.item_size_"+index).value;
	 var count = 0;	
	 for (j=0; j<dtl_length; j++) 
	{
	if(eval("formObject.item_cancel_"+index+"_"+j+".checked"))
	     count++; 
	}
	if(dtl_length == count){
	  eval("formObject.doc_"+index).checked = true;
	}else{
	key = "";
	eval("formObject.doc_"+index).checked = false;
	key = eval("formObject.doc_"+index).value;	 
	}
	 for(i=0; i<total_check_boxes;i++){
	 if(eval("formObject.doc_"+i).checked == false)
	   check_all = false;
	 }
	 
	 if(check_all)
	 formObject.cancelAll.checked = true;
	 else
	 formObject.cancelAll.checked = false;
}


function validateRemarks(){
 var formObject = document.forms[0];
	if (!setTextAreaMaxLength(formObject.remarks,201)) {  
		alert (getMessage('REMARKS_CHAR_EXCEEDS_LIMIT','ST'));
		return;
	}
}
function defaultRemarksDesc(reason_code,i,called_from,j,doc_type,doc_no,facility_id,item_code){

    var frmObj      = document.formCancelAuthQueryResult;
	var total_rec   = frmObj.total_check_boxes.value;
	var key ="1";
	if(reason_code.value != "O" ){
		
	    var bean_id		=	frmObj.bean_id.value;
		var bean_name	=	frmObj.bean_name.value;
		
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "reason_code  =\"" + reason_code.value + "\" " ;
		xmlStr+= "row_num  =\"" + i + "\" " ;
		xmlStr+= "col_num  =\"" + j + "\" " ;
		xmlStr+= "bean_id =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;
		xmlStr+= "called_from=\"" + called_from + "\" " ;
		xmlStr+= "doc_type=\"" + doc_type + "\" " ;
		xmlStr+= "doc_no=\"" + doc_no + "\" " ;
		xmlStr+= "facility_id=\"" + facility_id + "\" " ;
		xmlStr+= "item_code=\"" + item_code + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="../../eST/jsp/CancelAuthorizationValidation.jsp?function_type=4&bean_id="+bean_id+"&bean_name="+bean_name+"&reason_code="+reason_code.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		
		responseText=xmlHttp.responseText ;
		
		eval(responseText);
	}else if(called_from=="HDR"){
		eval("document.formCancelAuthQueryResult.hed_remarks_textarea_"+i).value ="";
		eval("document.formCancelAuthQueryResult.hed_remarks_textarea_"+i).readOnly = false;
	}else if(called_from=="DTL"){
		eval("document.formCancelAuthQueryResult.dtl_remarks_textarea_"+i+"_"+j).value ="";
	    eval("document.formCancelAuthQueryResult.dtl_remarks_textarea_"+i+"_"+j).readOnly = false;
	}

}

function assignRemarksDesc(remarks_desc,i,j,called_from){
	
	if(called_from=="HDR"){
		eval("document.formCancelAuthQueryResult.hed_remarks_textarea_"+i).value =remarks_desc;
		eval("document.formCancelAuthQueryResult.hed_remarks_textarea_"+i).readOnly = true;
	}else if(called_from=="DTL"){
		eval("document.formCancelAuthQueryResult.dtl_remarks_textarea_"+i+"_"+j).value =remarks_desc;
	    eval("document.formCancelAuthQueryResult.dtl_remarks_textarea_"+i+"_"+j).readOnly = true;
	}
}

function disableHDR(i,j,hdr_disable,line_disabled){
	if(eval("document.formCancelAuthQueryResult.doc_"+i) != undefined){
           eval("document.formCancelAuthQueryResult.doc_"+i).disabled =hdr_disable;
		   eval("document.formCancelAuthQueryResult.item_cancel_"+i+"_"+j).disabled =line_disabled;
		  
	}
}

function checkLength(obj,i,called_from,j) {
	var formObj = document.formCancelAuthQueryResult;
	var remarks = getLabel("Common.remarks.label", "Common");
	if( called_from =="HDR"){
	if (!SPCheckMaxLen(remarks, eval("document.formCancelAuthQueryResult.hed_remarks_textarea_"+i), 200)) {
		return false;
	  }
	}else if(called_from =="DTL"){
		if (!SPCheckMaxLen(remarks,  eval("document.formCancelAuthQueryResult.dtl_remarks_textarea_"+i+"_"+j), 200)) {
		return false;
	  }
	}
	return true;
}
