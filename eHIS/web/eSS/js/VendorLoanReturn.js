/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/ 
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
31/08/2015	IN056823		Ramesh G										The Owner Store users access the newly introduced  'Return Vendor Loan' functionality
--------------------------------------------------------------------------------------------------------------------
*/
function create(){
	f_query_add_mod.location.href = "../../eSS/jsp/VendorLoanReturnFrame.jsp?mode="+MODE_INSERT+"&menu_id="+menu_id+"&module_id="+module_id+"&function_id="+function_id ;
}

function query(){
	f_query_add_mod.location.href = "../../eSS/jsp/VendorLoanReturnQueryFrame.jsp?function_id="+function_id ;
}
function reset() {
	if(f_query_add_mod.frameVendorLoanReturnQueryCriteria!=null){
		f_query_add_mod.frameVendorLoanReturnQueryCriteria.document.formVendorLoanReturnQueryCriteria.reset();
		f_query_add_mod.frameVendorLoanReturnQueryResult.document.location.href="../../eCommon/html/blank.html";
	}
	else if(f_query_add_mod.frameVendorLoanReturnHeader!=null){
		f_query_add_mod.location.reload();
	}
	
}

function Modify(obj){
	var doc_type_code		=	obj.cells[8].innerText;
	var doc_no				=	obj.cells[0].innerText;
	top.content.f_query_add_mod.document.location.href="../../eSS/jsp/VendorLoanReturnFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&menu_id="+parent.parent.menu_id+"&module_id="+parent.parent.module_id+"&doc_no="+doc_no;
}
async function apply(){
	messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
	if( f_query_add_mod.frameVendorLoanReturnList==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var formObject		=	f_query_add_mod.frameVendorLoanReturnList.document.formVendorLoanReturnList ;
	var totalCBox=parseInt(formObject.total_checkboxes.value);
	
	var checkBoxObj=null;
	var selectedDocNO = "";
	for(var i=0;i<totalCBox;i++){
		checkBoxObj=eval("formObject.checkbox"+i);
		if(checkBoxObj.checked)
		{
			if(selectedDocNO!="")
				selectedDocNO=selectedDocNO+","+eval("formObject.DOC_NO"+i+".value");
			else
				selectedDocNO=eval("formObject.DOC_NO"+i+".value");;
		}
	}
	
	if(selectedDocNO==""){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("ATLEAST_ONE_SELECTED","Common"); 		
		return;
	}else{
		var formObjhdr = f_query_add_mod.frameVendorLoanReturnHeader.document.formVendorLoanReturnHeader;
		formObject.selectedLoanReturnDocNos.value = selectedDocNO;		
		
			
		var arrayObject = new Array(formObjhdr.doc_type_code,formObjhdr.return_from_store_code,formObjhdr.return_to_vendor_code);
		var names = new Array(getLabel("Common.DocType.label", "Common"),getLabel("eSS.FromStore.label", "SS"),getLabel("eSS.ToVendor.label", "SS"));
		var blankObject = checkSSFields(arrayObject, names, messageFrame);
		if(blankObject){
		    if (formObjhdr.entry_completed_yn.checked) {
		    	formObjhdr.entry_completed_yn.value = "Y";
				var confirmation =await confirmAuthorize();
				if(confirmation!=CLOSED){
					if(confirmation=="Yes"){
						formObject.authorized.value="Y";
						eval(formApply(formObject,SS_CONTROLLER));
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message+"<BR>"+flag;						
						if( result ) {						
						onSuccess();
						}
					}
					else{					
						formObject.authorized.value="N";
						eval(formApply(formObject,SS_CONTROLLER));
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message+"<BR>"+flag;						
						if( result ) {
						onSuccess();
						}
					}
				}else {			
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPERATION_CANCELLED","SS");
				}
			} else{ 
				formObject.entry_completed_yn.value = "N";
				formObject.authorized.value="N";
						eval(formApply(formObject,SS_CONTROLLER));
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message+"<BR>"+flag;
						if( result ) {
						onSuccess();
						}
			}
		}
	}
	
}

function deleterecord(){
	if( f_query_add_mod.frameVendorLoanReturnList==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var formObj	=	f_query_add_mod.frameVendorLoanReturnHeader.document.formVendorLoanReturnHeader;
	if(formObj.mode.value==MODE_MODIFY){
		var confirmation = confirmDelete();
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

function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
//	xmlDom = new ActiveXObject("Microsoft.XMLDom");
//	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	var xmlHttp = new XMLHttpRequest();
    var xmlDoc = "";
}
function onSuccess(){
	
	if(module_id=="" || module_id=="SS"){
		
	f_query_add_mod.frameVendorLoanReturnHeader.document.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.frameVendorLoanReturnList.document.location.href="../../eCommon/html/blank.html";
	create();
	}
}
function validateDocAutoNo(doc_type_code) {
	if(document.formVendorLoanReturnHeader.mode.value == MODE_INSERT){
		if(doc_type_code.value == "")  
			return;
		var arrayObject = new Array();
		arrayObject[0] = doc_type_code;
		assignBean(document.formVendorLoanReturnHeader);
//		xmlStr = getXMLString(arrayObject);
//		xmlDom.loadXML(xmlStr);
		var xmlHttp = new XMLHttpRequest();
		var xmlStr = getXMLString (arrayObject);
	    var parser = new DOMParser();
	    var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
		xmlHttp.open("POST", "VendorLoanReturnValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=1", false);
//		xmlHttp.send(xmlDom);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
		responseText=xmlHttp.responseText;
		eval(responseText);
	}
}

function enableDocNo() {
	document.formVendorLoanReturnHeader.doc_no.disabled = false;
	document.formVendorLoanReturnHeader.doc_no.readonly = false;
	document.formVendorLoanReturnHeader.doc_no.focus();
	document.formVendorLoanReturnHeader.autono_yn.value = NO;
}

function disableDocNo() {
	document.formVendorLoanReturnHeader.doc_no.disabled = true;
	document.formVendorLoanReturnHeader.doc_no.readonly = true;
	document.formVendorLoanReturnHeader.doc_no.value="";
	document.formVendorLoanReturnHeader.autono_yn.value = YES;
}

function callVendorLoanSearch(){
	
	parent.parent.messageFrame.location.href 	= "../../eCommon/jsp/error.jsp";
	var formObj 								= document.formVendorLoanReturnHeader;
	var arrayObject 							= new Array(formObj.doc_type_code,formObj.return_from_store_code,formObj.return_to_vendor_code);
	var names 									= new Array(getLabel("Common.DocType.label","Common"),getLabel("eSS.FromStore.label","SS"),getLabel("eSS.ToVendor.label","SS"));
	var blankObject 							= checkSSFields(arrayObject, names, parent.parent.messageFrame);
	if (blankObject == true) {
		document.formVendorLoanReturnHeader.selectedLoanReturnDocNos.value = "";
		parent.frameVendorLoanReturnList.location.href="../../eSS/jsp/VendorLoanReturnLists.jsp?mode="+formObj.mode.value+"&doc_no="+formObj.doc_no.value+"&doc_type_code="+formObj.doc_type_code.value+"&return_from_store_code="+formObj.return_from_store_code.value+"&return_to_vendor_code="+formObj.return_to_vendor_code.value+"&request_type="+formObj.request_type.value+"&from_date="+formObj.from_date.value+"&to_date="+formObj.to_date.value+"&entry_completed_yn="+formObj.entry_completed_yn.value+"&added_by_id="+formObj.added_by_id.value;
	}
}

async function details(doc_no,doc_type_code,doc_type,doc_date){	
	
	if(doc_no!="" && doc_type_code!="")
	{
	var dialogHeight = "70vh" ;
	var dialogWidth	= "70vw" ;

	var dialogTop = "265" ;
	var center = "1" ;

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=yes; status=no;" ;
	
	var arguments = "" ;
	var title="Request Detail";
	parent.frameVendorLoanReturnHeader.document.formVendorLoanReturnHeader.return_from_store_code
	
	var storelistbox 							= parent.frameVendorLoanReturnHeader.document.formVendorLoanReturnHeader.return_from_store_code;
	var storeSelIndex 							= storelistbox.selectedIndex;
	var storeSelText 							= storelistbox.options[storeSelIndex].text;
	storeSelText								= encodeURIComponent(storeSelText,"UTF-8");
	
	var vendorlistbox 							= parent.frameVendorLoanReturnHeader.document.formVendorLoanReturnHeader.return_to_vendor_code;
	var vendorSelIndex 							= vendorlistbox.selectedIndex;
	var vendorSelText 							= vendorlistbox.options[vendorSelIndex].text;
	vendorSelText								= encodeURIComponent(vendorSelText,"UTF-8");
	
	var params = "storeSelText="+storeSelText+"&vendorSelText="+vendorSelText+"&doc_type_code="+doc_type_code+"&doc_type="+doc_type+"&doc_date="+doc_date+"&doc_no="+doc_no;
	
	retVal =await window.showModalDialog("../../eSS/jsp/VenderReturnGroupItemFrame.jsp?"+params,arguments,features);
	}
}
async function groupDetails(group_code,group_desc)
{
  
	if(group_code!="")
	{
	var dialogHeight = "70vh" ;
	var dialogWidth	= "60vw" ;

	var dialogTop = "265" ;
	var center = "1" ;

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=yes; status=no;" ;
	
	var arguments = "" ;
	var title="Request Detail";
	var params = "group_code="+group_code+"&group_desc="+group_desc;
	
	retVal =await window.showModalDialog("../../eSS/jsp/GroupItemDetails.jsp?"+params,arguments,features);
	}
}

function updateSelection(obj){	
	var frmObject		= document.formVendorLoanReturnList;
	var selDocNo = eval("frmObject.DOC_NO"+obj+".value");
	var selDocGroupDtl=eval("frmObject.GROUP_DTLS"+selDocNo+".value");	
	assignBean(document.formVendorLoanReturnList);
	xmlStr					= "<root><SEARCH " ;
	xmlStr					+= "selDocNo=\""+selDocNo+"\" ";
	xmlStr					+= "selDocGroupDtl=\""+encodeURIComponent(selDocGroupDtl,"UTF-8")+"\" ";
	xmlStr 			+=" /></root>" ;		
//	xmlDom.loadXML(xmlStr);
	var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	var function_type="2";
	if(!eval("frmObject.checkbox"+obj+".checked"))
		function_type="3";
		
	xmlHttp.open("POST", "VendorLoanReturnValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type="+function_type, false);
//	xmlHttp.send(xmlDom);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
	responseText=xmlHttp.responseText;
	responseText=responseText.replace(/^\s+|\s+$/gm,'');	
	var responseArr = responseText.split("|");
	if(responseArr[0]=="N"){
		alert("Inadequate Quantity of Below Groups. \n"+responseArr[1]);
		eval("frmObject.checkbox"+obj+".checked=false;");			
	}else{
		var total_check_boxes = frmObject.total_checkboxes.value;
		var exist=true;
		for (var count = 0;count<total_check_boxes;count++) {
			if(!(eval("frmObject.checkbox"+count+".checked"))) {
				exist=false;
			}
		}
		if(exist){
			document.formVendorLoanReturnList.selectAll.checked=true;
		}else{
			document.formVendorLoanReturnList.selectAll.checked=false;
		}
	}
}
function clickSelectAll(selAllObj){
	
	var frmObject		= document.formVendorLoanReturnList;
	var total_check_boxes = frmObject.total_checkboxes.value;
	var totalDocNo = frmObject.totalDocNo.value;
	if(selAllObj.checked == true){
		var exist="";
		var totalDocDtls = "";
		for (var count = 0;count<total_check_boxes;count++) {			
			var selDocNo = eval("frmObject.DOC_NO"+count+".value");
			var selDocGroupDtl=eval("frmObject.GROUP_DTLS"+selDocNo+".value");
			if(totalDocDtls=="")
				totalDocDtls = selDocNo+"~"+selDocGroupDtl;
			else
				totalDocDtls = totalDocDtls+"^"+selDocNo+"~"+selDocGroupDtl;			
		}
		assignBean(document.formVendorLoanReturnList);
		xmlStr					= "<root><SEARCH " ;
		xmlStr					+= "totalDocDtls=\""+encodeURIComponent(totalDocDtls,"UTF-8")+"\" ";	
		xmlStr					+= "totalDocNo=\""+encodeURIComponent(totalDocNo,"UTF-8")+"\" ";
		xmlStr 			+=" /></root>" ;		
//		xmlDom.loadXML(xmlStr);
		var xmlHttp = new XMLHttpRequest();
	    var parser = new DOMParser();
	    var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
		var function_type="4";			
		xmlHttp.open("POST", "VendorLoanReturnValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type="+function_type, false);
//		xmlHttp.send(xmlDom);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
		responseText=xmlHttp.responseText;
		responseText=responseText.replace(/^\s+|\s+$/gm,'');	
		var responseArr = responseText.split("|");
			
		if("N"==responseArr[0]){
			alert("Inadequate Quantity of Below Doc No's. \n"+responseArr[1]);
			selAllObj.checked = false ;
			for (var count = 0;count<total_check_boxes;count++) {
				eval("frmObject.checkbox"+count+".checked=false");				
			}
		}else if("Y"==responseArr[0]){
			for (var count = 0;count<total_check_boxes;count++) {
				eval("frmObject.checkbox"+count+".checked=true");				
			}
		}
	}else{
		assignBean(document.formVendorLoanReturnList);
		xmlStr					= "<root><SEARCH " ;	
		xmlStr					+= "totalDocNo=\""+encodeURIComponent(totalDocNo,"UTF-8")+"\" ";		
		xmlStr 			+=" /></root>" ;		
//		xmlDom.loadXML(xmlStr);
		var parser = new DOMParser();
	    var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
		var function_type="5";			
		xmlHttp.open("POST", "VendorLoanReturnValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type="+function_type, false);
//		xmlHttp.send(xmlDom);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
		responseText=xmlHttp.responseText;
		responseText=responseText.replace(/^\s+|\s+$/gm,'');	
		var responseArr = responseText.split("|");
		if("Y"==responseArr[0]){
			for (var count = 0;count<total_check_boxes;count++) {
				eval("frmObject.checkbox"+count+".checked=false");				
			}
		}
	}
	
}
