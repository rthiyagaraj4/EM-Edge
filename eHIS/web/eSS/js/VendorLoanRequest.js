/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var radioval = "D";

function create(){
	f_query_add_mod.location.href = "../../eSS/jsp/VendorLoanRequestFrame.jsp?mode="+MODE_INSERT+"&menu_id="+menu_id+"&module_id="+module_id+"&function_id="+function_id ;
}

function query(){
	f_query_add_mod.location.href = "../../eSS/jsp/VendorLoanRequestQueryFrame.jsp?function_id="+function_id ;
}

function onSuccess(){
	
	if(module_id=="" || module_id=="SS"){
		
	f_query_add_mod.frameVendorLoanRequestHeader.document.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.frameVendorLoanRequestList.document.location.href="../../eCommon/html/blank.html";
	create();
	}
}

function reset() {
	if(f_query_add_mod.frameVendorLoanRequestQueryCriteria!=null){
		f_query_add_mod.frameVendorLoanRequestQueryCriteria.document.formVendorLoanRequestQueryCriteria.reset();
		f_query_add_mod.frameVendorLoanRequestQueryResult.document.location.href="../../eCommon/html/blank.html";
	}
	else if(f_query_add_mod.frameVendorLoanRequestHeader!=null){
		f_query_add_mod.location.reload();
	}
	
}


function deleterecord(){
	if( f_query_add_mod.frameVendorLoanRequestList==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var formObj	=	f_query_add_mod.frameVendorLoanRequestHeader.document.formVendorLoanRequestHeader;
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

function apply(){
	messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
	if( f_query_add_mod.frameVendorLoanRequestList==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var formObject		=	f_query_add_mod.frameVendorLoanRequestList.document.formVendorLoanRequestList ;
	totalCBox=parseInt(formObject.total_checkboxes.value);
	
	var checkBoxObj=null;
	var forDeletion="";
	var noDetailExists	=	true;
	for(i=0;i<totalCBox;i++)
	{	checkBoxObj=eval("formObject.checkbox"+i);
	
		if(checkBoxObj.checked)
		{
				forDeletion+=("Y,");
				
		}
		else
		{
			forDeletion=forDeletion +("N,");
			
			if(eval("formObject.req_qty_"+i).value == "") {
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("QUANTITY_CANNOT_BLANK","SS");
				eval("formObject.req_qty_"+i).focus();
				return;
			}

		}
		if(!checkBoxObj.checked){
			noDetailExists=false;
		}
	}
	
	forDeletion=forDeletion.substring(0,forDeletion.length-1);

	var formObj		=	f_query_add_mod.frameVendorLoanRequestHeader.document.formVendorLoanRequestHeader ;
	
	
	formObject.records_to_delete.value=forDeletion;
	
	
	var blankObject	=	null;
	var fields		=	new Array();
	var fieldNames	=	new Array();
	var	index		=	0;
	var queryString =	"";

	var fields = new Array (formObj.doc_type_code,formObj.doc_date, formObj.req_by_store_code,formObj.req_on_vendor_code);
	var fieldNames = new Array (getLabel("Common.DocType.label","Common"),getLabel("eSS.DocDate.label","SS"),	getLabel("eSS.RequestedbyStore.label","Common"),getLabel("eSS.RequestedonVendor.label","SS"));
	if(!formObj.doc_no.disabled){
		var fields = new Array (formObj.doc_type_code,formObj.doc_no,formObj.doc_date, formObj.req_by_store_code,formObj.req_on_vendor_code);;
		var fieldNames = new Array (getLabel("Common.DocType.label","Common"),getLabel("eSS.DocNo.label","SS"),getLabel("eSS.DocDate.label","SS"),	getLabel("eSS.RequestedbyStore.label","Common"),getLabel("eSS.RequestedonVendor.label","SS"));
		
	}
	
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	blankObject		=	getBlankField1( fields, fieldNames, messageFrame);

	if(blankObject==null) {
		
		if (noDetailExists){
		messageFrame.location.href = errorPage+"?err_num="+getMessage("MIN_ONE_DETAIL_REQUIRED","Common"); 		
		return;
	}
		bean_id = f_query_add_mod.frameVendorLoanRequestList.document.formVendorLoanRequestList.bean_id.value;
		bean_name =f_query_add_mod.frameVendorLoanRequestList.document.formVendorLoanRequestList.bean_name.value;
		var index = f_query_add_mod.frameVendorLoanRequestList.document.formVendorLoanRequestList.total_checkboxes.value;
//		xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
//		xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
//		xmlStr = getEnhancedXMLString (formObject);
//		xmlDom.loadXML( xmlStr );
		var xmlHttp = new XMLHttpRequest();
		var xmlStr = getXMLString (formObject);
	    var parser = new DOMParser();
	    var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
		xmlHttp.open("POST", "VendorLoanRequestValidate.jsp?prev_index=" + index  +"&bean_id="+bean_id+"&bean_name="+bean_name+"&doc_date="+formObj.doc_date.value+ "&validate=DTL_FINAL_DATA_STORE", false);
//		xmlHttp.send( xmlDom );
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
		responseText=xmlHttp.responseText;
		eval( responseText );
		if(! result ) {
			messageFrame.location.href = errorPage+"?err_num="+ getMessage(flag,"SS");
			return;
		}
		
		
		formObject.mode.value 				= formObj.mode.value;
		formObject.function_id.value 		= formObj.function_id.value;
		formObject.req_by_store_code.value 	= formObj.req_by_store_code.value;
		formObject.req_on_vendor_code.value 	= formObj.req_on_vendor_code.value;
		formObject.doc_ref.value 			= formObj.doc_ref.value;
		formObject.doc_type_code.value 		= formObj.doc_type_code.value;
		formObject.doc_no.value 			= formObj.doc_no.value;
		formObject.doc_date.value 			= formObj.doc_date.value;
		formObject.request_type.value 		= formObj.request_type.value;
		formObject.module_id.value 			= formObj.module_id.value;
		formObject.trn_type.value 			= formObj.trn_type.value;
		
			    if (formObj.entry_completed_yn.checked) {
			    	formObject.entry_completed_yn.value = "Y";
				var confirmation = confirmAuthorize();
				if(confirmation!=CLOSED){
				if(confirmation=="Yes"){
					formObject.authorized.value="Y";
					eval(formApply(formObject,SS_CONTROLLER));
						messageFrame.location.href = errorPage+"?err_num="+ message+"<BR>"+flag;
					if( result ) {						
					onSuccess();
					}
				}
				else{					
					formObject.authorized.value="N";
					eval(formApply(formObject,SS_CONTROLLER));
					messageFrame.location.href = errorPage+"?err_num="+ message+"<BR>"+flag;
					if( result ) {
					onSuccess();
					}
				}
			}
			else {
				
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPERATION_CANCELLED","SS");
		}
		} else{ 
					formObject.entry_completed_yn.value = "N";
					formObject.authorized.value="N";
					eval(formApply(formObject,SS_CONTROLLER));
					messageFrame.location.href = errorPage+"?err_num="+ message+"<BR>"+flag;
					if( result ) {
					onSuccess();
					}
		}
	}
	else{
		blankObject.focus();
	}
}
function getBlankField1( fields, legends, messageFrame, errorPage) {

    var obj=null;
    var errors = "" ;
    if (errorPage==null) {
        errorPage = "../../eCommon/jsp/error.jsp"
    }
    for( var i=0;i<fields.length; i++ )
    {
		
        if(trimCheck(fields[i].value))
            fields[i].value = trimString(fields[i].value);
        else
        {
            if(obj==null)
                obj=fields[i];
			
           errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(legends[i])))+"<br>";
		
        }
    }
    if ( errors.length != 0 ) {
        messageFrame.location.href=errorPage+"?err_num="+errors;
    }
        return obj ;
}
function checkDoc_type_code(){
	if(document.formVendorLoanRequestHeader.doc_type_code.value=="") return;	
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString (null);
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	//xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/VendorLoanRequestValidate.jsp?validate=DOC_TYPE_CODE&doc_type_code=" + document.formVendorLoanRequestHeader.doc_type_code.value, false);
	//xmlHttp.send(xmlDoc);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;
	eval(responseText);
}

function quantityAlert(_total_quantity, _sterilized_quantity, _unsterilized_quantity){
	}

function clearList(){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/VendorLoanRequestValidate.jsp?validate=CLEAR_LIST", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	refreshList();
}

function enableDocNo(bValue){
	if(!bValue){
		parent.frameVendorLoanRequestHeader.document.formVendorLoanRequestHeader.doc_no.value="";	
	}
	parent.frameVendorLoanRequestHeader.document.formVendorLoanRequestHeader.doc_no.disabled=!bValue;
}

function addToList(){
	var formObj=  document.formVendorLoanRequestDetail;
	var errorPage	 = "../../eCommon/jsp/error.jsp";
	if((!formObj.description.readOnly)&&(!formObj.description.disabled)&&(formObj.description.value!="")){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/VendorLoanRequestValidate.jsp?req_group_code=" + formObj.description.value + "&validate=GROUP_DESC", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(! result ) {
			parent.parent.messageFrame.location.href = errorPage+"?err_num="+ getMessage(flag);
			return;
		}
	}

	
	var fields = new Array ( formObj.description,  formObj.request_qty );
	var names  =  new Array ( getLabel("eSS.ReqGroup.label","SS"),getLabel("eSS.AuthGroup.label","SS") , getLabel("Common.Quantity.label","Common"));
	var obj    =null;
	var messageFrame = parent.parent.messageFrame; 
	obj=getBlankField( fields, names, messageFrame,errorPage);
	if(obj==null) {
		if(formObj.surg_description.value != "" && formObj.surgery_type.value == '') {
			parent.parent.messageFrame.location.href = errorPage+"?err_num="+"App 0001 Invalid Surgery Type";
			return;
		}
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/VendorLoanRequestValidate.jsp?surg_name=" + encodeURIComponent(formObj.ot_surg_description.value,"UTF-8") +"&surg_description=" + encodeURIComponent(formObj.surg_description.value,"UTF-8") +"&req_group_code=" + formObj.req_group_code.value + "&request_qty=" + formObj.request_qty.value +"&group_type=" + formObj.group_type.value +"&index="+formObj.index.value+ "&description="+formObj.description.value+ "&issue_store_code="+parent.frameVendorLoanRequestHeader.document.formVendorLoanRequestHeader.req_on_vendor_code.value+ "&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if( result ) {
			refreshDetails();
		}
		else{
			parent.parent.messageFrame.location.href = errorPage+"?err_num="+ getMessage(message,"SS");
		}
	}
	else
		obj.focus();
}


function searchGroupCode( objCode, objDesc ) {
	
	var formObj		=	document.formVendorLoanRequestHeader ;
	
	var blankObject	=	null;
	var fields		=	new Array();
	var fieldNames	=	new Array();
	var index=0;
	var surgery_type = document.formVendorLoanRequestHeader.surgery_type.value;
	
	fields[index]		=	formObj.req_by_store_code;
	fieldNames[index++]	=	getLabel("eSS.RequestedbyStore.label","Common");
	fields[index]		=	formObj.req_on_vendor_code;
	fieldNames[index++]	=	getLabel("eSS.RequestedonVendor.label","SS");

	var errorPage	=	"../../eCommon/jsp/error.jsp";
	blankObject		=	getBlankField( fields, fieldNames, parent.parent.messageFrame);

	if(blankObject==null) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "group_type";
	dataValueArray[0]= document.formVendorLoanRequestHeader.group_type.value;
	dataTypeArray[0] = STRING;
	
	dataNameArray[1] = "language_id";
	dataValueArray[1]= document.formVendorLoanRequestHeader.locale.value;
	dataTypeArray[1] = STRING;

	dataNameArray[2] = "store_code";
	dataValueArray[2]= document.formVendorLoanRequestHeader.req_on_vendor_code.value;
	dataTypeArray[2] = STRING;
	if(surgery_type != ""){
	dataNameArray[3] = "surgery_type";
	dataValueArray[3]= surgery_type;
	dataTypeArray[3] = STRING;
	}
		
	if(surgery_type == ""){
		argumentArray[0] = document.formVendorLoanRequestHeader.SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_REQUEST.value;
	}else{
		argumentArray[0] = document.formVendorLoanRequestHeader.SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_SURGERY_TYPE_FOR_REQUEST.value;
	}
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if(surgery_type == ""){
	argumentArray[4] = "4,5";
	}else{
		argumentArray[4] = "5,6";
	}
	if (objDesc.readOnly) 
		argumentArray[5] = "";
	else
		argumentArray[5] = objDesc.value;
		
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	
	var returnedValues = CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		var formObj=document.formVendorLoanRequestHeader;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/VendorLoanRequestValidate.jsp?req_group_code=" + formObj.req_group_code.value+ "&req_by_store="+document.formVendorLoanRequestHeader.req_by_store_code.value+ "&validate=CHECK_REQ_STORE", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(!result){
		alert(getMessage(flag,"SS"));
		formObj.description.value = ""; 
		formObj.req_group_code.value="";
		formObj.description.focus();
		return;
		}
		objDesc.readOnly=true;
	} 
	}
	else{
		blankObject.focus();
	}
}

function clearGroupDetail(){
	var formObj = "";
	if(parent.frameVendorLoanRequestHeader.document.formVendorLoanRequestHeader.module_id != undefined && parent.frameVendorLoanRequestHeader.document.formVendorLoanRequestHeader.module_id.value == "OT")
		formObj = document.formVendorLoanRequestDetail;
	else
		formObj = top.content.f_query_add_mod.frameVendorLoanRequestDetail.document.formVendorLoanRequestDetail;

	formObj.req_group_code.value="";
	formObj.description.readOnly=false;
	formObj.request_qty.value="";
	formObj.description.value="";
}

function resetGroupDetail(){
	var formObj = "";

	if(parent.frameVendorLoanRequestHeader.document.formVendorLoanRequestHeader.module_id != undefined && parent.frameVendorLoanRequestHeader.document.formVendorLoanRequestHeader.module_id.value == "OT")
		formObj = document.formVendorLoanRequestDetail;
	else
		formObj = top.content.f_query_add_mod.frameVendorLoanRequestDetail.document.formVendorLoanRequestDetail;

	formObj.group_type.value="E";
	formObj.group_type.disabled=false;
	formObj.req_group_code.value="";
	formObj.request_qty.value="";
	formObj.description.value="";
	formObj.description.disabled=false;
	formObj.description.readOnly=false;
	formObj.group_search.disabled=false;
	formObj.surg_description.value="";
	formObj.surg_description.disabled=false;
	formObj.surg_description.readOnly=false;
	formObj.surgery_type_search.disabled=false;
	formObj.surgery_type.value = "";
	if(formObj.surg_nature_link_to_OT_yn.value == "Y"){ 
	formObj.ot_surg_description.value="";
	formObj.surg_code.value="";
}
	formObj.index.value="-1";
	formObj.apply.value=getLabel("Common.Add.label","Common");
}

function refreshDetails(){
	if(parent.frameVendorLoanRequestHeader.document.formVendorLoanRequestHeader.module_id != undefined && parent.frameVendorLoanRequestHeader.document.formVendorLoanRequestHeader.module_id.value != "OT")
		displayMessage(top.content.messageFrame,"");

	resetGroupDetail();
	refreshList();
}

function refreshList(){
	if(parent.frameVendorLoanRequestHeader.document.formVendorLoanRequestHeader.module_id != undefined && parent.frameVendorLoanRequestHeader.document.formVendorLoanRequestHeader.module_id.value == "OT"){
		parent.frameVendorLoanRequestList.location.href="../../eSS/jsp/VendorLoanRequestList.jsp";
	}
	else	
		top.content.f_query_add_mod.frameVendorLoanRequestList.document.location.reload();
}

function listModify(index){
	parent.frameVendorLoanRequestDetail.location.href="../../eSS/jsp/VendorLoanRequestDetail.jsp?index="+index;
}

function Modify(obj){
	var doc_type_code		=	obj.cells[5].innerText;
	var doc_no				=	obj.cells[0].innerText;
	top.content.f_query_add_mod.document.location.href="../../eSS/jsp/VendorLoanRequestFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&menu_id="+parent.parent.menu_id+"&module_id="+parent.parent.module_id+"&doc_no="+doc_no;
}

function setGroupDetails(_req_group_code, _description){
	var formObj=  document.formVendorLoanRequestDetail;
	formObj.req_group_code.value	=	_req_group_code;
	formObj.description.value		=	_description;
	formObj.description.readOnly	=	true;
}

function callSurgeryTypeSearchWindow(code,desc,surg_code,surg_name) {

	retVal = window.showModalDialog("../../eSS/jsp/SurgeryTypeSearchFrame.jsp?&typed_text="+encodeURIComponent(desc.value,"UTF-8") ,"", "dialogHeight:30; dialogWidth:55; center:0; status: no; dialogLeft :200; dialogTop :100;");
	if (retVal !=undefined) {
		
		code.value = retVal[0];
		desc.value = retVal[1];
		desc.value = decodeURIComponent(desc.value,"UTF-8");
		desc.value = desc.value.replace(/\+/g,' ');
		if(document.GroupSearchCriteria_Form.surg_nature_link_to_OT_yn.value == "Y"){
		surg_code.value = retVal[2];
		surg_name.value = retVal[3];
		surg_name.value = decodeURIComponent(surg_name.value,"UTF-8");
		surg_name.value = surg_name.value.replace(/\+/g,' ');
		}
		
		desc.readOnly= true;
	}
	
}


function searchVals() {
	
	var search_text = document.SurgeryTypeSearchCriteria_Form.search_text.value;
	var searchCriteria		=	document.SurgeryTypeSearchCriteria_Form.search_criteria.value;
	parent.frameSurgeryTypeSearchResult.document.location.href = "../../eSS/jsp/SurgeryTypeSearchResult.jsp?radioval=" + radioval+"&search_text="+search_text+"&searchCriteria="+searchCriteria;
}

function storeVal(currad) {
    radioval=currad.value;
}

function ModifySearch(code1,desc1,code2,desc2){
    
	var retVal = code1 + "~" + desc1 + "~" + code2 + "~" + desc2 ;
    top.window.returnValue = retVal.split("~"); ;
    top.close();
}

function Setsurgdesc(surg_description,surgery_type){
	document.formVendorLoanRequestDetail.surg_description.value = decodeURIComponent(surg_description.value,"UTF-8");
	document.formVendorLoanRequestDetail.surg_description.value = document.formVendorLoanRequestDetail.surg_description.value.replace(/\+/g,' ');
	document.formVendorLoanRequestDetail.ot_surg_description.value = decodeURIComponent(surgery_type.value,"UTF-8");
	document.formVendorLoanRequestDetail.ot_surg_description.value = document.formVendorLoanRequestDetail.ot_surg_description.value.replace(/\+/g,' ');
}


function isNumberKey(evt)
{

    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode == 8 || charCode == 13) 
    	return false;

  } 

function callGroupSearch() {
	var formObject 								= parent.frameVendorLoanRequestList.document.formVendorLoanRequestList;
	parent.parent.messageFrame.location.href 	= "../../eCommon/jsp/error.jsp";
	var formObj 								= document.formVendorLoanRequestHeader;
	var arrayObject 							= new Array(formObj.doc_type_code,formObj.req_by_store_code,formObj.req_on_vendor_code);
	var names 									= new Array(getLabel("Common.DocType.label","Common"),getLabel("eSS.RequestedbyStore.label","Common"),getLabel("eSS.RequestedonVendor.label","SS"));
	var blankObject 							= checkSSFields(arrayObject, names, parent.parent.messageFrame);
	if (blankObject == true) {
		var req_by_store_code 					= formObj.req_by_store_code.value;
		var listbox 							= document.formVendorLoanRequestHeader.req_by_store_code;
		var selIndex 							= listbox.selectedIndex;
		var selText 							= listbox.options[selIndex].text;//Store descreption
			selText								= encodeURIComponent(selText,"UTF-8")
						
		xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
		xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
		xmlStr = getEnhancedXMLString (formObject);
		xmlDom.loadXML( xmlStr );
		xmlHttp.open("POST", "VendorLoanRequestValidate.jsp?bean_id="+formObject.bean_id.value+"&bean_name="+formObject.bean_name.value+ "&validate=DTL_DATA_STORE", false);
		xmlHttp.send( xmlDom );
		responseText=xmlHttp.responseText;
		eval( responseText );
			
		retval = window.showModalDialog("../../eSS/jsp/VendorLoanRequestSearchFrame.jsp?mode="+formObj.mode.value+"&req_by_store_code="+req_by_store_code ,"", "dialogHeight:33; dialogWidth:55; center:0; status: no; dialogLeft :200; dialogTop :100;");
	
		if (retval != null && retval!=undefined) {

			formObj.req_on_vendor_code.disabled = true;
			formObj.req_by_store_code.disabled = true;
			
			parent.frameVendorLoanRequestList.location.href="../../eSS/jsp/VendorLoanRequestLists.jsp?mode="+formObj.mode.value+"&req_by_store_code="+formObj.req_by_store_code.value+"&req_by_store_desc="+selText;
		}
		else{
			

			xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
			xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
			xmlStr = getXMLString (null);
			xmlDom.loadXML( xmlStr );
			
			xmlHttp.open("POST", "VendorLoanRequestValidate.jsp?bean_id="+formObject.bean_id.value+"&bean_name="+formObject.bean_name.value+"&validate=CLEAR_DATA", false);
			xmlHttp.send( xmlDom );
			responseText=xmlHttp.responseText;
			eval( responseText );
			
		}
	}
}


function searchValues() {
	

	var group_type 			= document.GroupSearchCriteria_Form.group_type.value;
	var surgery_type 		= document.GroupSearchCriteria_Form.surgery_type.value;
	var surg_description 	= document.GroupSearchCriteria_Form.surg_description.value;
	var ot_surg_description = document.GroupSearchCriteria_Form.ot_surg_description.value;
	var req_by_store_code 	= document.GroupSearchCriteria_Form.req_by_store_code.value;
	var searchCriteria		= document.GroupSearchCriteria_Form.search_criteria.value;
	var search_text 		= document.GroupSearchCriteria_Form.search_text.value;
	var mode 				= document.GroupSearchCriteria_Form.mode.value;
	
	parent.frameVendorLoanRequestSearchResult.document.location.href = "../../eSS/jsp/VendorLoanRequestSearchResult.jsp?radioval=" + radioval+"&search_text="+encodeURIComponent(search_text,"UTF-8")+"&mode="+mode+"&group_type="+group_type+"&ot_surg_description="+ot_surg_description+"&surg_description="+surg_description+"&surgery_type="+surgery_type+"&req_by_store_code="+req_by_store_code+"&searchCriteria="+searchCriteria;
}

function closeActionPerformed(frmObj) {

	var index = 0;
	var returnvals = "";
	var new_index= "";
	var unchecked_index = "";
	var seach_type = "";
	var exist = false;
	var formObj = parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm;
	if(formObj == undefined){
		alert(getMessage("SELECT_GROUP_TO_PROCEED","SS"));
		return;
	}
	var total_trays = formObj.totalRecords.value;
	
	var arrayObject = new Array();
	window.returnValue=false;
	
	for (var count = 0;count<total_trays;count++) {
			if(eval("parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.group_code"+count+".checked")) {
				exist = true;
				returnvals += formObj.elements("group" + count).value + "`" + formObj.elements("desc" + count).value +  "~";
				
				arrayObject[index] = eval("parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.group"+count);
				arrayObject[index+1] = eval("parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.desc"+count);
				arrayObject[index+2] = eval("parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.group_type"+count);
				arrayObject[index+3] = eval("parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.surgery_type"+count);
				arrayObject[index+4] = eval("parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.surgery_name"+count);
				arrayObject[index+5] = eval("parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.qty"+count);
				arrayObject[index+6] = eval("parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.total_qty"+count);
				index += 7;
				
				new_index += count + "!";
			}else{
				arrayObject[index] = eval("parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.group"+count);
				arrayObject[index+1] = eval("parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.desc"+count);
				arrayObject[index+2] = eval("parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.group_type"+count);
				arrayObject[index+3] = eval("parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.surgery_type"+count);
				arrayObject[index+4] = eval("parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.surgery_name"+count);
				arrayObject[index+5] = eval("parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.qty"+count);
				arrayObject[index+6] = eval("parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.total_qty"+count);
				
				index += 7;
				
				unchecked_index += count+"!";
			}
	}

		
	parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.index.value = new_index;
	parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.mode.value = document.GroupSearchCriteria_Form.mode.value;
	parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.unchecked_index.value = unchecked_index;
	
	
	arrayObject[arrayObject.length] = parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.unchecked_index;
	arrayObject[arrayObject.length] = parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.index;
	arrayObject[arrayObject.length] = parent.frameVendorLoanRequestSearchResult.document.GroupsearchForm.mode;
		
	
	var xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString (arrayObject);
	xmlDom.loadXML( xmlStr );
	
	xmlHttp.open("POST", "VendorLoanRequestValidate.jsp?validate=ADD_GROUPS_TO_LIST"+"&search_type=search", false);
	xmlHttp.send( xmlDom );
	responseText=xmlHttp.responseText;
	eval( responseText );
	
	if(!result) {
		alert(getMessage("SELECT_GROUP_TO_PROCEED","SS")); 
		return;
	}else{
		window.parent.parent.returnValue = returnvals;
		window.close();
	}
	
}



function SubmitLink(from, to) {

	var index = 0;
	var new_index= "";
	var unchecked_index= "";
	var formObj = document.GroupsearchForm;

	if(document.GroupsearchForm){
	var total_trays = formObj.totalRecords.value;
	
	var arrayObject = new Array();
		for (var count = 0;count<total_trays;count++) {
		
			if(eval("document.GroupsearchForm.group_code"+count+".checked")) {
				
				arrayObject[index] = eval("document.GroupsearchForm.group"+count);
				arrayObject[index+1] = eval("document.GroupsearchForm.desc"+count);
				arrayObject[index+2] = eval("document.GroupsearchForm.group_type"+count);
				arrayObject[index+3] = eval("document.GroupsearchForm.surgery_type"+count);
				arrayObject[index+4] = eval("document.GroupsearchForm.surgery_name"+count);
				arrayObject[index+5] = eval("document.GroupsearchForm.qty"+count);
				arrayObject[index+6] = eval("document.GroupsearchForm.total_qty"+count);
				
				index += 7;
				
				new_index += count+"!";
		}else{
			arrayObject[index] = eval("document.GroupsearchForm.group"+count);
			arrayObject[index+1] = eval("document.GroupsearchForm.desc"+count);
			arrayObject[index+2] = eval("document.GroupsearchForm.group_type"+count);
			arrayObject[index+3] = eval("document.GroupsearchForm.surgery_type"+count);
			arrayObject[index+4] = eval("document.GroupsearchForm.surgery_name"+count);
			arrayObject[index+5] = eval("document.GroupsearchForm.qty"+count);
			arrayObject[index+6] = eval("document.GroupsearchForm.total_qty"+count);
			
			index += 7;
			
			unchecked_index += count+"!";
		}
	}
		

	
	document.GroupsearchForm.index.value = new_index;
	arrayObject[arrayObject.length] = document.GroupsearchForm.index;
	
	document.GroupsearchForm.search_type.value = "next_prev";
	
	document.GroupsearchForm.unchecked_index.value = unchecked_index;
	arrayObject[arrayObject.length] = document.GroupsearchForm.unchecked_index;
	arrayObject[arrayObject.length] = document.GroupsearchForm.mode;
	arrayObject[arrayObject.length] = document.GroupsearchForm.search_type;

	
	
	xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
	xmlStr = getXMLString (arrayObject);
	xmlDom.loadXML( xmlStr );
	xmlHttp.open("POST", "VendorLoanRequestValidate.jsp?validate=ADD_GROUPS_TO_LIST"+"&search_type=next_prev", false);
	xmlHttp.send( xmlDom );
	responseText=xmlHttp.responseText;
	eval( responseText );
	}
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ; 
    
}

function updateSelection() {
	var frmObject		= document.formVendorLoanRequestList;
	var total_check_boxes = frmObject.total_checkboxes.value;
	var exist=true;
		for (var count = 0;count<total_check_boxes;count++) {
				if(!(eval("frmObject.checkbox"+count+".checked"))) {
					exist=false;
				}
			}
			if(exist){
			document.formVendorLoanRequestList.selectAll.checked=true;
			}else{
			document.formVendorLoanRequestList.selectAll.checked=false;
			}
}

function updateSelectionGroupSearch() {
	var frmObject		= document.GroupsearchForm;
	var total_check_boxes = frmObject.totalRecords.value;
	var exist=true;
		for (var count = 0;count<total_check_boxes;count++) {

				if(!(eval("frmObject.group_code"+count+".checked"))) {
					exist=false;
				}
		}
			if(exist){
			document.GroupsearchForm.selectAll.checked=true;
			}else{
			document.GroupsearchForm.selectAll.checked=false;
			}
}

function toggleCheck(selAllObj){

	var formObj = document.GroupsearchForm;
	
	for(var i=0; i<formObj.totalRecords.value; i++){
	if(eval('formObj.group_code'+i).disabled == false) {	
		if(selAllObj.checked == true){
			if(eval('formObj.group_code'+i) != undefined) {
				eval('formObj.group_code'+i).checked = true;
			}
		}
		else{
			if(eval('formObj.group_code'+i) != undefined) {
				eval('formObj.group_code'+i).checked = false;
			}
		}
	}
 }

}

function toggleCheckforDetail(selAllObj){

	var formObj = document.formVendorLoanRequestList;
	
	for(var i=0; i<formObj.total_checkboxes.value; i++){

		if(selAllObj.checked == true){
			if(eval('formObj.checkbox'+i) != undefined) {
				eval('formObj.checkbox'+i).checked = true;
			}
		}
		else{
			if(eval('formObj.checkbox'+i) != undefined) {
				eval('formObj.checkbox'+i).checked = false;
			}
		}

 }

}

function details(group_code,group_desc)
{
  
	if(group_code!="")
	{
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
function getXMLString(arrayObject) {
	
	xmlStr ="<root><SEARCH ";
	if (arrayObject!=null)
		for (index=0;index<arrayObject.length;index++)	{
			xmlStr += arrayObject[index].name+"=\""+ checkSpl(arrayObject[index].value) +"\" ";
		}
	xmlStr +=" /></root>";
	return xmlStr;
}

function checkstrqty(i,pgroup_code,req_by_store_code,req_on_vendor_code) {
	var frmObject		= document.formVendorLoanRequestList;
	var language_id = frmObject.locale.value;
	var group_code		=	"";
	
	
	var xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString (null);
	xmlDom.loadXML( xmlStr );
	
	xmlHttp.open("POST", "VendorLoanRequestValidate.jsp?group_code="+group_code+"&req_by_store_code="+req_by_store_code+"&index="+i+"&language_id="+language_id+"&req_on_vendor_code="+req_on_vendor_code+"&validate=CHECK_STER_QTY", false);
	xmlHttp.send( xmlDom );
	responseText=xmlHttp.responseText;
	eval( responseText );
}

function setSterQuantity(surg_desc, ot_surg_desc,ster_qty,index) {
	
	eval(document.getElementById("id_surg_desc_"+index)).innerHTML = surg_desc;
	eval(document.getElementById("id_ot_surg_desc_"+index)).innerHTML = ot_surg_desc;
	eval(document.getElementById("id_av_st_qty_"+index)).innerHTML = ster_qty;
}

function isNotExist(isNotExist){
	 if(isNotExist){
	 alert(getMessage("SELECT_GROUP_TO_PROCEED","SS")); 
	 return false;
	 }
	}

