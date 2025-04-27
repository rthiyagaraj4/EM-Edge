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
	f_query_add_mod.location.href = "../../eSS/jsp/RequestGroupFrame.jsp?mode="+MODE_INSERT+"&menu_id="+menu_id+"&module_id="+module_id+"&function_id="+function_id ;
}

function query(){
	f_query_add_mod.location.href = "../../eSS/jsp/RequestGroupQueryFrame.jsp?function_id="+function_id ;
}

function onSuccess(){
	
	if(module_id=="" || module_id=="SS"){
		
	f_query_add_mod.frameRequestGroupHeader.document.location.href="../../eCommon/html/blank.html";
	//f_query_add_mod.frameRequestGroupDetail.document.location.href="../../eCommon/html/blank.html";//Commented by sakti against BRU-HIMS-CRF-373
	f_query_add_mod.frameRequestGroupList.document.location.href="../../eCommon/html/blank.html";
	create();
	}else if(module_id=="OT"){
		if(!f_query_add_mod.frameRequestGroupHeader.document.formRequestGroupHeader.doc_no.disabled){
			var doc_no = f_query_add_mod.frameRequestGroupHeader.document.formRequestGroupHeader.doc_no.value;
			alert(message+" Doc No: "+doc_no);				
			document.parentWindow.returnValue="Doc No: "+doc_no;
		}else{
			document.parentWindow.returnValue=flag;
		}
		document.parentWindow.close();
	}
}

function reset() {
	if(f_query_add_mod.frameRequestGroupQueryCriteria!=null){
		f_query_add_mod.frameRequestGroupQueryCriteria.document.formRequestGroupQueryCriteria.reset();
		f_query_add_mod.frameRequestGroupQueryResult.document.location.href="../../eCommon/html/blank.html";
	}
	else if(f_query_add_mod.frameRequestGroupHeader!=null){
		f_query_add_mod.location.reload();
	}
	
}
function reset_criteria() {
	document.GroupSearchCriteria_Form.surg_description.readOnly = false;
	
}


async function deleterecord(){
	if( f_query_add_mod.frameRequestGroupList==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var formObj	=	f_query_add_mod.frameRequestGroupHeader.document.formRequestGroupHeader;
	if(formObj.mode.value==MODE_MODIFY){
		var confirmation = await confirmDelete();
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

async function apply(){
	if( f_query_add_mod.frameRequestGroupList==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var formObject		=	f_query_add_mod.frameRequestGroupList.document.formRequestGroupList ;//Added by sakti against BRU-HIMS-CRF-373
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

	var formObj		=	f_query_add_mod.frameRequestGroupHeader.document.formRequestGroupHeader ;
	
	
	formObject.records_to_delete.value=forDeletion;
	
	
	var blankObject	=	null;
	var fields		=	new Array();
	var fieldNames	=	new Array();
	var	index		=	0;
	var queryString =	"";

	var fields = new Array (formObj.doc_type_code,formObj.doc_date, formObj.req_by_store_code,formObj.req_on_store_code);
	var fieldNames = new Array (getLabel("Common.DocType.label","Common"),getLabel("eSS.DocDate.label","SS"),	getLabel("Common.RequestedBy.label","Common"),getLabel("eSS.RequestedOn.label","SS"));
	if(!formObj.doc_no.disabled){
		var fields = new Array (formObj.doc_type_code,formObj.doc_no,formObj.doc_date, formObj.req_by_store_code,formObj.req_on_store_code);;
		var fieldNames = new Array (getLabel("Common.DocType.label","Common"),getLabel("eSS.DocNo.label","SS"),getLabel("eSS.DocDate.label","SS"),	getLabel("Common.RequestedBy.label","Common"),getLabel("eSS.RequestedOn.label","SS"));
		
	}
	
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	blankObject		=	getBlankField1( fields, fieldNames, messageFrame);

	if(blankObject==null) {
		
		if (noDetailExists){
		messageFrame.location.href = errorPage+"?err_num="+getMessage("MIN_ONE_DETAIL_REQUIRED","Common"); 		
		return;
	}
		//Added by sakti against BRU-HIMS-CRF-373
		bean_id = f_query_add_mod.frameRequestGroupList.document.formRequestGroupList.bean_id.value;
		bean_name =f_query_add_mod.frameRequestGroupList.document.formRequestGroupList.bean_name.value;
		var index = f_query_add_mod.frameRequestGroupList.document.formRequestGroupList.total_checkboxes.value;
//		xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
//		xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
		
		var xmlHttp = new XMLHttpRequest();
		xmlStr = getEnhancedXMLString (formObject);
	    var parser = new DOMParser();
	    var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
//		xmlDom.loadXML( xmlStr );
		xmlHttp.open("POST", "RequestGroupValidate.jsp?prev_index=" + index  +"&bean_id="+bean_id+"&bean_name="+bean_name+ "&validate=DTL_FINAL_DATA_STORE", false);
		//xmlHttp.send( xmlDom );
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
		responseText=xmlHttp.responseText;
		eval( responseText );
		
		
		formObject.mode.value 				= formObj.mode.value;
		formObject.function_id.value 		= formObj.function_id.value;
		formObject.req_by_store_code.value 	= formObj.req_by_store_code.value;
		formObject.req_on_store_code.value 	= formObj.req_on_store_code.value;
		formObject.doc_ref.value 			= formObj.doc_ref.value;
		formObject.doc_type_code.value 		= formObj.doc_type_code.value;
		formObject.doc_no.value 			= formObj.doc_no.value;
		formObject.doc_date.value 			= formObj.doc_date.value;
		formObject.request_type.value 		= formObj.request_type.value;
		formObject.module_id.value 			= formObj.module_id.value;
		
		//Added ends
		
		//if (formObj.SS_REQUEST_GROUP_AUTHORIZE!=null) { Commented by Ganga  since we have authorize in function level ML-BRU-SCF-0813 [IN:039420]
				//Added by Rabbani #INC no:32068 on 06/12/2012
			    if (formObj.entry_completed_yn.checked) {
			    	formObject.entry_completed_yn.value = "Y";
				var confirmation =await confirmAuthorize();//window.confirm("Current record will be deleted!!");
				if(confirmation!=CLOSED){
				if(confirmation=="Yes"){
					//formObj.authorized.value="Y";
					formObject.authorized.value="Y";
					eval(formApply(formObject,SS_CONTROLLER));
					callOnlinePrint(formObject, confirmation);//Added for AAKH-CRF-0057
						//if(module_id!="OT") Commented by Ganga for 36954
					if( result ) {
						flag = (flag.split("~"))[0];//Added for AAKH-CRF-0057
						if(flag=="null")//Added for AAKH-CRF-0057
							flag="";//Added for AAKH-CRF-0057
						messageFrame.location.href = errorPage+"?err_num="+ message+"<BR>"+flag;
					onSuccess();
					}
				}
				/*else if(formObj.entry_completed_yn.disabled){					
					formObj.authorized.value="N";
					messageFrame.location.href = errorPage+"?err_num="+ getMessage("OPERATION_CANCELLED");
					return;
				}*/
				else{					
					//formObj.authorized.value="N";
					formObject.authorized.value="N";
					eval(formApply(formObject,SS_CONTROLLER));
					callOnlinePrint(formObject, confirmation);//Added for AAKH-CRF-0057
					//if(module_id!="OT") Commented by Ganga for 36954
					flag = (flag.split("~"))[0];//Added for AAKH-CRF-0057
					if(flag=="null")//Added for AAKH-CRF-0057
						flag="";//Added for AAKH-CRF-0057
					messageFrame.location.href = errorPage+"?err_num="+ message+"<BR>"+flag;
					if( result ) {
					onSuccess();
					}
				}
			}
			else {
				
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPERATION_CANCELLED","SS");
		}
		} else{ //Added by Rabbani #INC no:32068 on 06/12/2012
					formObject.entry_completed_yn.value = "N";
		            //formObj.authorized.value="N";
					formObject.authorized.value="N";
					eval(formApply(formObject,SS_CONTROLLER));
					//if(module_id!="OT") Commented by Ganga for 36954
					flag = (flag.split("~"))[0];
					if(flag=="null")//Added for AAKH-CRF-0057
						flag="";//Added for AAKH-CRF-0057
						
					messageFrame.location.href = errorPage+"?err_num="+ message+"<BR>"+flag;
					if( result ) {
					onSuccess();
					}
		}
      //}	
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
	if(document.formRequestGroupHeader.doc_type_code.value=="") return;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlString = getXMLString(null);
	var parser = new DOMParser();
    xmlDoc = parser.parseFromString(xmlString, "application/xml");
    
	xmlHttp.open("POST", "../../eSS/jsp/RequestGroupValidate.jsp?validate=DOC_TYPE_CODE&doc_type_code=" + document.formRequestGroupHeader.doc_type_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

function quantityAlert(_total_quantity, _sterilized_quantity, _unsterilized_quantity){
	}

function clearList(){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/RequestGroupValidate.jsp?validate=CLEAR_LIST", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	refreshList();
}

function enableDocNo(bValue){
	if(!bValue){
		parent.frameRequestGroupHeader.document.formRequestGroupHeader.doc_no.value="";	
	}
	parent.frameRequestGroupHeader.document.formRequestGroupHeader.doc_no.disabled=!bValue;
}

function addToList(){
	var formObj=  document.formRequestGroupDetail;
	var errorPage	 = "../../eCommon/jsp/error.jsp";
	if((!formObj.description.readOnly)&&(!formObj.description.disabled)&&(formObj.description.value!="")){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/RequestGroupValidate.jsp?req_group_code=" + formObj.description.value + "&validate=GROUP_DESC", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(! result ) {
			parent.parent.messageFrame.location.href = errorPage+"?err_num="+ getMessage(flag);
			return;
		}
	}

	
	var fields = new Array ( formObj.description, formObj.auth_group_code, formObj.request_qty );
	var names  =  new Array ( getLabel("eSS.ReqGroup.label","SS"),getLabel("eSS.AuthGroup.label","SS") , getLabel("Common.Quantity.label","Common"));
	var obj    =null;
	var messageFrame = parent.parent.messageFrame; 
	obj=getBlankField( fields, names, messageFrame,errorPage);
	var auth_group_desc=formObj.auth_group_code.options[formObj.auth_group_code.options.selectedIndex].text;
	if(obj==null) {
		if(formObj.surg_description.value != "" && formObj.surgery_type.value == '') {
			parent.parent.messageFrame.location.href = errorPage+"?err_num="+"App 0001 Invalid Surgery Type";
			return;
		}
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		//xmlHttp.open("POST", "../../eSS/jsp/RequestGroupValidate.jsp?req_group_code=" + formObj.req_group_code.value +"&auth_group_code=" + formObj.auth_group_code.value + "&request_qty=" + formObj.request_qty.value +"&group_type=" + formObj.group_type.value +"&index="+formObj.index.value+ "&description="+formObj.description.value+ "&auth_group_desc="+auth_group_desc+ "&issue_store_code="+parent.frameRequestGroupHeader.document.formRequestGroupHeader.req_on_store_code.value+ "&validate=ADD_TO_LIST", false);
		xmlHttp.open("POST", "../../eSS/jsp/RequestGroupValidate.jsp?surg_name=" + encodeURIComponent(formObj.ot_surg_description.value,"UTF-8") +"&surg_description=" + encodeURIComponent(formObj.surg_description.value,"UTF-8") +"&req_group_code=" + formObj.req_group_code.value +"&auth_group_code=" + formObj.auth_group_code.value + "&request_qty=" + formObj.request_qty.value +"&group_type=" + formObj.group_type.value +"&index="+formObj.index.value+ "&description="+formObj.description.value+ "&auth_group_desc="+auth_group_desc+ "&issue_store_code="+parent.frameRequestGroupHeader.document.formRequestGroupHeader.req_on_store_code.value+ "&validate=ADD_TO_LIST", false);
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

/*function searchGroupCode( objCode, objDesc ) {
	
	var formObj		=	parent.frameRequestGroupHeader.document.formRequestGroupHeader ;
	
	var blankObject	=	null;
	var fields		=	new Array();
	var fieldNames	=	new Array();
	var index=0;
	
	fields[index]		=	formObj.req_by_store_code;
	fieldNames[index++]	=	getLabel("Common.RequestedBy.label","Common");
	fields[index]		=	formObj.req_on_store_code;
	fieldNames[index++]	=	getLabel("eSS.RequestedOn.label","SS");

	var errorPage	=	"../../eCommon/jsp/error.jsp";
	blankObject		=	getBlankField( fields, fieldNames, parent.parent.messageFrame);

	if(blankObject==null) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "group_type";
	dataValueArray[0]= document.formRequestGroupDetail.group_type.value;
	dataTypeArray[0] = STRING;
	
	dataNameArray[1] = "language_id";
	dataValueArray[1]= document.formRequestGroupDetail.locale.value;
	dataTypeArray[1] = STRING;

	dataNameArray[2] = "store_code";
	dataValueArray[2]= parent.frameRequestGroupHeader.document.formRequestGroupHeader.req_on_store_code.value;
	dataTypeArray[2] = STRING;
	
	
	argumentArray[0] = document.formRequestGroupDetail.SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_REQUEST.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	if (objDesc.readOnly) 
		argumentArray[5] = "";
	else
		argumentArray[5] = objDesc.value;
		
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	
	returnedValues = CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		var formObj=document.formRequestGroupDetail;
		//Added by Rabbani for validate Request_by_Store on 17/12/2012 Starts
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/RequestGroupValidate.jsp?req_group_code=" + formObj.req_group_code.value+ "&req_by_store="+parent.frameRequestGroupHeader.document.formRequestGroupHeader.req_by_store_code.value+ "&validate=CHECK_REQ_STORE", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(!result){
		alert(getMessage(flag,"SS"));
		formObj.description.value = ""; 
		formObj.auth_group_code.value = "";
		formObj.req_group_code.value="";
	    //formObj.description.readOnly=false;
		formObj.description.focus();
		return;
		}
		//end
		objDesc.readOnly=true;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/RequestGroupValidate.jsp?req_group_code=" + formObj.req_group_code.value + "&validate=POPULATE_AUTH_GROUP_CODE", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(formObj.mode.value==MODE_INSERT)
			formObj.auth_group_code.disabled=true;
		else
			formObj.auth_group_code.disabled=false;

	} 
	}
	else{
		blankObject.focus();
	}
}*/


/*function searchGroupCode( objCode, objDesc ) {
	
	var formObj		=	parent.frameRequestGroupHeader.document.formRequestGroupHeader ;
	
	var blankObject	=	null;
	var fields		=	new Array();
	var fieldNames	=	new Array();
	var index=0;
	
	fields[index]		=	formObj.req_by_store_code;
	fieldNames[index++]	=	getLabel("Common.RequestedBy.label","Common");
	fields[index]		=	formObj.req_on_store_code;
	fieldNames[index++]	=	getLabel("eSS.RequestedOn.label","SS");

	var errorPage	=	"../../eCommon/jsp/error.jsp";
	blankObject		=	getBlankField( fields, fieldNames, parent.parent.messageFrame);

	if(blankObject==null) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "group_type";
	dataValueArray[0]= document.formRequestGroupDetail.group_type.value;
	dataTypeArray[0] = STRING;
	
	dataNameArray[1] = "language_id";
	dataValueArray[1]= document.formRequestGroupDetail.locale.value;
	dataTypeArray[1] = STRING;

	dataNameArray[2] = "store_code";
	dataValueArray[2]= parent.frameRequestGroupHeader.document.formRequestGroupHeader.req_on_store_code.value;
	dataTypeArray[2] = STRING;
	//Added By Sakti against KDAH-CRF-0247
	dataNameArray[3] = "surgery_type";
	dataValueArray[3]= document.formRequestGroupDetail.surgery_type.value;
	dataTypeArray[3] = STRING;
//Added ends
	
	argumentArray[0] = document.formRequestGroupDetail.SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_REQUEST.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "5,6";
	if (objDesc.readOnly) 
		argumentArray[5] = "";
	else
		argumentArray[5] = objDesc.value;
		
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	
	returnedValues = CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		var formObj=document.formRequestGroupDetail;
		//Added by Rabbani for validate Request_by_Store on 17/12/2012 Starts
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/RequestGroupValidate.jsp?req_group_code=" + formObj.req_group_code.value+ "&req_by_store="+parent.frameRequestGroupHeader.document.formRequestGroupHeader.req_by_store_code.value+ "&validate=CHECK_REQ_STORE", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(!result){
		alert(getMessage(flag,"SS"));
		formObj.description.value = ""; 
		formObj.auth_group_code.value = "";
		formObj.req_group_code.value="";
	    //formObj.description.readOnly=false;
		formObj.description.focus();
		return;
		}
		//end
		objDesc.readOnly=true;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/RequestGroupValidate.jsp?req_group_code=" + formObj.req_group_code.value + "&validate=POPULATE_AUTH_GROUP_CODE", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(formObj.mode.value==MODE_INSERT)
			formObj.auth_group_code.disabled=true;
		else
			formObj.auth_group_code.disabled=false;

	} 
	}
	else{
		blankObject.focus();
	}
}*/


/*function searchGroupCode( objCode, objDesc ) {
	
	var formObj		=	parent.frameRequestGroupHeader.document.formRequestGroupHeader ;
	
	var blankObject	=	null;
	var fields		=	new Array();
	var fieldNames	=	new Array();
	var index=0;
	var surgery_type = document.formRequestGroupDetail.surgery_type.value;
	
	fields[index]		=	formObj.req_by_store_code;
	fieldNames[index++]	=	getLabel("Common.RequestedBy.label","Common");
	fields[index]		=	formObj.req_on_store_code;
	fieldNames[index++]	=	getLabel("eSS.RequestedOn.label","SS");

	var errorPage	=	"../../eCommon/jsp/error.jsp";
	blankObject		=	getBlankField( fields, fieldNames, parent.parent.messageFrame);

	if(blankObject==null) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "group_type";
	dataValueArray[0]= document.formRequestGroupDetail.group_type.value;
	dataTypeArray[0] = STRING;
	
	dataNameArray[1] = "language_id";
	dataValueArray[1]= document.formRequestGroupDetail.locale.value;
	dataTypeArray[1] = STRING;

	dataNameArray[2] = "store_code";
	dataValueArray[2]= parent.frameRequestGroupHeader.document.formRequestGroupHeader.req_on_store_code.value;
	dataTypeArray[2] = STRING;
	//Added By Sakti against KDAH-CRF-0247
	if(surgery_type != ""){
	dataNameArray[3] = "surgery_type";
	dataValueArray[3]= surgery_type;
	dataTypeArray[3] = STRING;
	}
//Added ends
		
	if(surgery_type == ""){
		argumentArray[0] = document.formRequestGroupDetail.SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_REQUEST.value;
	}else{
		argumentArray[0] = document.formRequestGroupDetail.SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_SURGERY_TYPE_FOR_REQUEST.value;
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
	
	returnedValues = CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		var formObj=document.formRequestGroupDetail;
		//Added by Rabbani for validate Request_by_Store on 17/12/2012 Starts
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/RequestGroupValidate.jsp?req_group_code=" + formObj.req_group_code.value+ "&req_by_store="+parent.frameRequestGroupHeader.document.formRequestGroupHeader.req_by_store_code.value+ "&validate=CHECK_REQ_STORE", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(!result){
		alert(getMessage(flag,"SS"));
		formObj.description.value = ""; 
		formObj.auth_group_code.value = "";
		formObj.req_group_code.value="";
	    //formObj.description.readOnly=false;
		formObj.description.focus();
		return;
		}
		//end
		objDesc.readOnly=true;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/RequestGroupValidate.jsp?req_group_code=" + formObj.req_group_code.value + "&validate=POPULATE_AUTH_GROUP_CODE", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(formObj.mode.value==MODE_INSERT)
			formObj.auth_group_code.disabled=true;
		else
			formObj.auth_group_code.disabled=false;

	} 
	}
	else{
		blankObject.focus();
	}
}*/

async function searchGroupCode( objCode, objDesc ) {
	
	var formObj		=	document.formRequestGroupHeader ;
	
	var blankObject	=	null;
	var fields		=	new Array();
	var fieldNames	=	new Array();
	var index=0;
	var surgery_type = document.formRequestGroupHeader.surgery_type.value;
	
	fields[index]		=	formObj.req_by_store_code;
	fieldNames[index++]	=	getLabel("Common.RequestedBy.label","Common");
	fields[index]		=	formObj.req_on_store_code;
	fieldNames[index++]	=	getLabel("eSS.RequestedOn.label","SS");

	var errorPage	=	"../../eCommon/jsp/error.jsp";
	blankObject		=	getBlankField( fields, fieldNames, parent.parent.messageFrame);

	if(blankObject==null) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "group_type";
	dataValueArray[0]= document.formRequestGroupHeader.group_type.value;
	dataTypeArray[0] = STRING;
	
	dataNameArray[1] = "language_id";
	dataValueArray[1]= document.formRequestGroupHeader.locale.value;
	dataTypeArray[1] = STRING;

	dataNameArray[2] = "store_code";
	dataValueArray[2]= document.formRequestGroupHeader.req_on_store_code.value;
	dataTypeArray[2] = STRING;
	//Added By Sakti against KDAH-CRF-0247
	if(surgery_type != ""){
	dataNameArray[3] = "surgery_type";
	dataValueArray[3]= surgery_type;
	dataTypeArray[3] = STRING;
	}
//Added ends
		
	if(surgery_type == ""){
		argumentArray[0] = document.formRequestGroupHeader.SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_REQUEST.value;
	}else{
		argumentArray[0] = document.formRequestGroupHeader.SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_SURGERY_TYPE_FOR_REQUEST.value;
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
	
	var returnedValues =await CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		var formObj=document.formRequestGroupHeader;
		//Added by Rabbani for validate Request_by_Store on 17/12/2012 Starts
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/RequestGroupValidate.jsp?req_group_code=" + formObj.req_group_code.value+ "&req_by_store="+document.formRequestGroupHeader.req_by_store_code.value+ "&validate=CHECK_REQ_STORE", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(!result){
		alert(getMessage(flag,"SS"));
		formObj.description.value = ""; 
		formObj.auth_group_code.value = "";
		formObj.req_group_code.value="";
	    //formObj.description.readOnly=false;
		formObj.description.focus();
		return;
		}
		//end
		objDesc.readOnly=true;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/RequestGroupValidate.jsp?req_group_code=" + formObj.req_group_code.value + "&validate=POPULATE_AUTH_GROUP_CODE", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(formObj.mode.value==MODE_INSERT)
			formObj.auth_group_code.disabled=true;
		else
			formObj.auth_group_code.disabled=false;

	} 
	}
	else{
		blankObject.focus();
	}
}

function clearGroupDetail(){
	var formObj = "";
	if(parent.frameRequestGroupHeader.document.formRequestGroupHeader.module_id != undefined && parent.frameRequestGroupHeader.document.formRequestGroupHeader.module_id.value == "OT")
		formObj = document.formRequestGroupDetail;
	else
		formObj = top.content.f_query_add_mod.frameRequestGroupDetail.document.formRequestGroupDetail;

	formObj.req_group_code.value="";
	formObj.description.readOnly=false;
	formObj.request_qty.value="";
	formObj.description.value="";
}

function resetGroupDetail(){
	var formObj = "";

	if(parent.frameRequestGroupHeader.document.formRequestGroupHeader.module_id != undefined && parent.frameRequestGroupHeader.document.formRequestGroupHeader.module_id.value == "OT")
		formObj = document.formRequestGroupDetail;
	else
		formObj = top.content.f_query_add_mod.frameRequestGroupDetail.document.formRequestGroupDetail;

	formObj.group_type.value="E";
	formObj.group_type.disabled=false;
	formObj.req_group_code.value="";
	formObj.request_qty.value="";
	formObj.description.value="";
	formObj.description.disabled=false;
	formObj.description.readOnly=false;
	formObj.group_search.disabled=false;
	//Added against KDAH_CRF_0247
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
	clearListItems("parent.frameRequestGroupDetail.document.formRequestGroupDetail.auth_group_code");
}

function refreshDetails(){
	if(parent.frameRequestGroupHeader.document.formRequestGroupHeader.module_id != undefined && parent.frameRequestGroupHeader.document.formRequestGroupHeader.module_id.value != "OT")
		displayMessage(top.content.messageFrame,"");

	resetGroupDetail();
	refreshList();
}

function refreshList(){
	if(parent.frameRequestGroupHeader.document.formRequestGroupHeader.module_id != undefined && parent.frameRequestGroupHeader.document.formRequestGroupHeader.module_id.value == "OT"){
		parent.frameRequestGroupList.location.href="../../eSS/jsp/RequestGroupList.jsp";
	}
	else	
		top.content.f_query_add_mod.frameRequestGroupList.document.location.reload();
}

function listModify(index){
	parent.frameRequestGroupDetail.location.href="../../eSS/jsp/RequestGroupDetail.jsp?index="+index;
}

function Modify(obj){
	var doc_type_code		=	obj.cells[5].innerText;
	var doc_no				=	obj.cells[1].innerText;
	var req_on_store_code	=	obj.cells[4].innerText;
	var req_by_store_code	=	obj.cells[3].innerText;
	req_by_store_code 		= 	encodeURIComponent(req_by_store_code,"UTF-8");
	
	//top.content.f_query_add_mod.document.location.href="../../eSS/jsp/RequestGroupFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&menu_id="+parent.parent.menu_id+"&module_id="+parent.parent.module_id+"&doc_no="+doc_no;
	top.content.f_query_add_mod.document.location.href="../../eSS/jsp/RequestGroupFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&menu_id="+parent.parent.menu_id+"&module_id="+parent.parent.module_id+"&doc_no="+doc_no+"&req_on_store_code="+req_on_store_code+"&req_by_store_desc="+req_by_store_code;
}

function setGroupDetails(_req_group_code, _description){
	var formObj=  document.formRequestGroupDetail;
	formObj.req_group_code.value	=	_req_group_code;
	formObj.description.value		=	_description;
	formObj.description.readOnly	=	true;
}



//Added by sakti against KDAH-CRF-0247


async function callSurgeryTypeSearchWindow(code,desc,surg_code,surg_name) {

	retVal =await window.showModalDialog("../../eSS/jsp/SurgeryTypeSearchFrame.jsp?&typed_text="+encodeURIComponent(desc.value,"UTF-8") ,"", "dialogHeight:80vh; dialogWidth:80vw; center:0; status: no; dialogLeft :200; dialogTop :100;");
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
	parent.frameSurgeryTypeSearchResult.document.location.href = "../../eSS/jsp/SurgeryTypeSearchResult.jsp?radioval=" + radioval+"&search_text="+search_text;
}

function storeVal(currad) {
    radioval=currad.value;
}

function ModifySearch(code1,desc1,code2,desc2){
    
	var retVal = code1 + "~" + desc1 + "~" + code2 + "~" + desc2 ;
	//alert(retVal);
	var returnedValue=retVal.split("~");
    /*top.window.returnValue = retVal.split("~"); ;
    top.close();*/
	
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = returnedValue;
    
    const dialogTag = parent.parent.document.getElementById('dialog_tag');    
    dialogTag.close();   
	
	
}

function Setsurgdesc(surg_description,surgery_type){
	document.formRequestGroupDetail.surg_description.value = decodeURIComponent(surg_description.value,"UTF-8");
	document.formRequestGroupDetail.surg_description.value = document.formRequestGroupDetail.surg_description.value.replace(/\+/g,' ');
	document.formRequestGroupDetail.ot_surg_description.value = decodeURIComponent(surgery_type.value,"UTF-8");
	document.formRequestGroupDetail.ot_surg_description.value = document.formRequestGroupDetail.ot_surg_description.value.replace(/\+/g,' ');
}


function isNumberKey(evt)
{

    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode == 8 || charCode == 13) 
    	return false;

  } 

//Added ends


//Added by Sakti against BRU-HIMS-CRF-373
async function callGroupSearch() {
	var formObject 								= parent.frameRequestGroupList.document.formRequestGroupList;
	parent.parent.messageFrame.location.href 	= "../../eCommon/jsp/error.jsp";
	var formObj 								= document.formRequestGroupHeader;
	var arrayObject 							= new Array(formObj.req_by_store_code,formObj.req_on_store_code);
	var names 									= new Array(getLabel("Common.RequestedBy.label","Common"),getLabel("eSS.RequestedOn.label","SS"));
	var blankObject 							= checkSSFields(arrayObject, names, parent.parent.messageFrame);
	if (blankObject == true) {
		var req_on_store_code 					= formObj.req_on_store_code.value;
		var req_by_store_code 					= formObj.req_by_store_code.value;
		var listbox 							= document.formRequestGroupHeader.req_by_store_code;
		var selIndex 							= listbox.selectedIndex;
		var selText 							= listbox.options[selIndex].text;//Store descreption
			selText								= encodeURIComponent(selText,"UTF-8");

			if(req_by_store_code == req_on_store_code ) {
				parent.parent.messageFrame.location.href 	= "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("REQUEST_BOTH_STORE_SAME","SS");
				return;

			}
						
		/*xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
		xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
		xmlStr = getEnhancedXMLString (formObject);
		xmlDom.loadXML( xmlStr );
		xmlHttp.open("POST", "RequestGroupValidate.jsp?bean_id="+formObject.bean_id.value+"&bean_name="+formObject.bean_name.value+ "&validate=DTL_DATA_STORE", false);
		xmlHttp.send( xmlDom );*/
		var xmlHttp = new XMLHttpRequest();
        var xmlStr = getEnhancedXMLString(formObject);
        var parser = new DOMParser();
        var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
        xmlHttp.open("POST", "RequestGroupValidate.jsp?bean_id=" + formObject.bean_id.value + "&bean_name=" + formObject.bean_name.value + "&validate=DTL_DATA_STORE", false);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
		responseText=xmlHttp.responseText;
		eval( responseText );
			
		retval = await top.window.showModalDialog("../../eSS/jsp/RequestGroupSearchFrame.jsp?req_on_store_code=" + req_on_store_code+"&mode="+formObj.mode.value+"&req_by_store_code="+req_by_store_code ,"", "dialogHeight:90vh; dialogWidth:90vw; center:0; status: no; dialogLeft :200; dialogTop :100;");
	
		//if (retval != null && retval!="" && retval!=undefined) {
		if (retval != null && retval!=undefined) {

			formObj.req_on_store_code.disabled = true;
			formObj.req_by_store_code.disabled = true;
			
			parent.frameRequestGroupList.location.href="../../eSS/jsp/RequestGroupList.jsp?mode="+formObj.mode.value+"&req_on_store_code="+formObj.req_on_store_code.value+"&req_by_store_code="+formObj.req_by_store_code.value+"&req_by_store_desc="+selText;
		}
		//else part added  for clearing checked values oncancel and clicking on cross or close
		else{
			

		/*	xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
			xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
			xmlStr = getXMLString (null);
			xmlDom.loadXML( xmlStr );*/
			
			var xmlHttp = new XMLHttpRequest();
	        var xmlStr = getEnhancedXMLString(formObject);
	        var parser = new DOMParser();
	        var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	        
			xmlHttp.open("POST", "RequestGroupValidate.jsp?bean_id="+formObject.bean_id.value+"&bean_name="+formObject.bean_name.value+"&validate=CLEAR_DATA", false);
			//xmlHttp.send( xmlDom );
			xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
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
	var req_on_store_code 	= document.GroupSearchCriteria_Form.req_on_store_code.value;
	var req_by_store_code 	= document.GroupSearchCriteria_Form.req_by_store_code.value;
	var isincludetargetstore= document.GroupSearchCriteria_Form.target_store.checked;
	var searchCriteria		= document.GroupSearchCriteria_Form.search_criteria.value;
	var search_text 		= document.GroupSearchCriteria_Form.search_text.value;
	var mode 				= document.GroupSearchCriteria_Form.mode.value;
	
	parent.frameRequestGroupSearchResult.document.location.href = "../../eSS/jsp/RequestGroupSearchResult.jsp?radioval=" + radioval+"&search_text="+encodeURIComponent(search_text,"UTF-8")+"&mode="+mode+"&group_type="+group_type+"&ot_surg_description="+ot_surg_description+"&req_on_store_code="+req_on_store_code+"&surg_description="+surg_description+"&surgery_type="+surgery_type+"&req_by_store_code="+req_by_store_code+"&isincludetargetstore="+isincludetargetstore+"&searchCriteria="+searchCriteria;
}

function closeActionPerformed(frmObj) {

	var index = 0;
	var returnvals = "";
	var new_index= "";
	var unchecked_index = "";
	var seach_type = "";
	var exist = false;
	var formObj = parent.frameRequestGroupSearchResult.document.GroupsearchForm;
	if(formObj == undefined){
		alert(getMessage("SELECT_GROUP_TO_PROCEED","SS"));
		return;
	}
	var total_trays = formObj.totalRecords.value;
	
	var arrayObject = new Array();
	window.returnValue=false;
	
	for (var count = 0;count<total_trays;count++) {
			if(eval("parent.frameRequestGroupSearchResult.document.GroupsearchForm.group_code"+count+".checked")) {
				exist = true;
				returnvals += formObj.elements["group" + count].value + "`" + formObj.elements["desc" + count].value +  "~";
				
				arrayObject[index] = eval("parent.frameRequestGroupSearchResult.document.GroupsearchForm.group"+count);
				arrayObject[index+1] = eval("parent.frameRequestGroupSearchResult.document.GroupsearchForm.desc"+count);
				
				arrayObject[index+2] = eval("parent.frameRequestGroupSearchResult.document.GroupsearchForm.group_type"+count);
				arrayObject[index+3] = eval("parent.frameRequestGroupSearchResult.document.GroupsearchForm.auth_group"+count);
				arrayObject[index+4] = eval("parent.frameRequestGroupSearchResult.document.GroupsearchForm.surgery_type"+count);
				arrayObject[index+5] = eval("parent.frameRequestGroupSearchResult.document.GroupsearchForm.surgery_name"+count);
				arrayObject[index+6] = eval("parent.frameRequestGroupSearchResult.document.GroupsearchForm.qty"+count);
				arrayObject[index+7] = eval("parent.frameRequestGroupSearchResult.document.GroupsearchForm.avlbl_ster_qty"+count);
				index += 8;
				
				new_index += count + "!";
			}else{
				arrayObject[index] = eval("parent.frameRequestGroupSearchResult.document.GroupsearchForm.group"+count);
				arrayObject[index+1] = eval("parent.frameRequestGroupSearchResult.document.GroupsearchForm.desc"+count);
				
				arrayObject[index+2] = eval("parent.frameRequestGroupSearchResult.document.GroupsearchForm.group_type"+count);
				arrayObject[index+3] = eval("parent.frameRequestGroupSearchResult.document.GroupsearchForm.auth_group"+count);
				arrayObject[index+4] = eval("parent.frameRequestGroupSearchResult.document.GroupsearchForm.surgery_type"+count);
				arrayObject[index+5] = eval("parent.frameRequestGroupSearchResult.document.GroupsearchForm.surgery_name"+count);
				arrayObject[index+6] = eval("parent.frameRequestGroupSearchResult.document.GroupsearchForm.qty"+count);
				arrayObject[index+7] = eval("parent.frameRequestGroupSearchResult.document.GroupsearchForm.avlbl_ster_qty"+count);
				
				index += 8;
				
				unchecked_index += count+"!";
			}
	}

		
	parent.frameRequestGroupSearchResult.document.GroupsearchForm.index.value = new_index;
	parent.frameRequestGroupSearchResult.document.GroupsearchForm.mode.value = document.GroupSearchCriteria_Form.mode.value;
	parent.frameRequestGroupSearchResult.document.GroupsearchForm.unchecked_index.value = unchecked_index;
	
	
	arrayObject[arrayObject.length] = parent.frameRequestGroupSearchResult.document.GroupsearchForm.unchecked_index;
	arrayObject[arrayObject.length] = parent.frameRequestGroupSearchResult.document.GroupsearchForm.index;
	arrayObject[arrayObject.length] = parent.frameRequestGroupSearchResult.document.GroupsearchForm.mode;
		
	
/*  var xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString (arrayObject);
	xmlDom.loadXML( xmlStr ); */
	
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString (arrayObject);
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	
	xmlHttp.open("POST", "RequestGroupValidate.jsp?validate=ADD_GROUPS_TO_LIST"+"&search_type=search", false);
	//xmlHttp.send( xmlDom );
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;
	eval( responseText );
	
	//This is added by Sakti against BRU-HIMS-CRF-373 if in group search window any one group is selected among all pages, need to add that group in list. If not, then below message shown
	if(!result) {
		alert(getMessage("SELECT_GROUP_TO_PROCEED","SS")); 
		return;
	}else{
		/*window.parent.parent.returnValue = returnvals;
		window.close();*/
		let dialogBody = parent.parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue = returnvals;
	    
	    const dialogTag = parent.parent.document.getElementById('dialog_tag');    
	    dialogTag.close();   
	}//Added ends
	
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
				arrayObject[index+3] = eval("document.GroupsearchForm.auth_group"+count);
				arrayObject[index+4] = eval("document.GroupsearchForm.surgery_type"+count);
				arrayObject[index+5] = eval("document.GroupsearchForm.surgery_name"+count);
				arrayObject[index+6] = eval("document.GroupsearchForm.qty"+count);
				arrayObject[index+7] = eval("document.GroupsearchForm.avlbl_ster_qty"+count);
				
				index += 8;
				
				new_index += count+"!";
		}else{
			arrayObject[index] = eval("document.GroupsearchForm.group"+count);
			arrayObject[index+1] = eval("document.GroupsearchForm.desc"+count);
			
			arrayObject[index+2] = eval("document.GroupsearchForm.group_type"+count);
			arrayObject[index+3] = eval("document.GroupsearchForm.auth_group"+count);
			arrayObject[index+4] = eval("document.GroupsearchForm.surgery_type"+count);
			arrayObject[index+5] = eval("document.GroupsearchForm.surgery_name"+count);
			arrayObject[index+6] = eval("document.GroupsearchForm.qty"+count);
			arrayObject[index+7] = eval("document.GroupsearchForm.avlbl_ster_qty"+count);
			
			index += 8;
			
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

	
	
	/*xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
	xmlStr = getXMLString (arrayObject);
	xmlDom.loadXML( xmlStr );
	*/
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString (arrayObject);
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
    
	xmlHttp.open("POST", "RequestGroupValidate.jsp?validate=ADD_GROUPS_TO_LIST"+"&search_type=next_prev", false);
	//xmlHttp.send( xmlDom );
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
	responseText=xmlHttp.responseText;
	eval( responseText );
	}
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ; 
    
}

function updateSelection() {
	var frmObject		= document.formRequestGroupList;
	var total_check_boxes = frmObject.total_checkboxes.value;
	var exist=true;
		for (var count = 0;count<total_check_boxes;count++) {
				if(!(eval("frmObject.checkbox"+count+".checked"))) {
					exist=false;
				}
			}
			if(exist){
			document.formRequestGroupList.selectAll.checked=true;
			}else{
			document.formRequestGroupList.selectAll.checked=false;
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

	var formObj = document.formRequestGroupList;
	
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

async function details(group_code,group_desc)
{
  
	if(group_code!="")
	{
	var dialogHeight = "70vh" ;
	var dialogWidth	= "70vw" ;

	var dialogTop = "265" ;
	var center = "1" ;

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=yes; status=no;" ;
	
	var arguments = "" ;
	var title="Request Detail";
	var params = "group_code="+group_code+"&group_desc="+group_desc;
	
	retVal =await window.showModalDialog("../../eSS/jsp/GroupItemDetails.jsp?"+params,arguments,features);
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

function checkstrqty(i,pgroup_code,req_by_store_code,req_on_store_code) {
	var frmObject		= document.formRequestGroupList;
	var language_id = frmObject.locale.value;
	var group_code		=	"";
	if(eval("frmObject.auth_group_"+i).value == ""){
		group_code = pgroup_code;
	}else{
		group_code = eval("frmObject.auth_group_"+i).value;
	}
	
	var xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString (null);
	xmlDom.loadXML( xmlStr );
	
	xmlHttp.open("POST", "RequestGroupValidate.jsp?group_code="+group_code+"&req_by_store_code="+req_by_store_code+"&index="+i+"&language_id="+language_id+"&req_on_store_code="+req_on_store_code+"&validate=CHECK_STER_QTY", false);
	xmlHttp.send( xmlDom );
	responseText=xmlHttp.responseText;
	eval( responseText );
}

function setSterQuantity(surg_desc, ot_surg_desc,ster_qty,index) {
	
		eval("document.getElementById('id_surg_desc_')"+index).innerHTML = surg_desc;
	if(document.formRequestGroupList.surg_nature_link_to_OT_yn.value == "Y") {
		eval("document.getElementById('id_ot_surg_desc_')"+index).innerHTML = ot_surg_desc;
	}
		eval("document.getElementById('id_av_st_qty_')"+index).innerHTML = ster_qty;
}//Added ends


 async function callOnlinePrint(formObject, confirmation){//Adding start for AAKH-CRF-0057
	flag1 = (flag.split("~"))[0];
	flag2 = (flag.split("~"))[1];
	flag1 = (flag1=="null"?"":flag1);
	bean_id = f_query_add_mod.frameRequestGroupList.document.formRequestGroupList.bean_id.value;
	bean_name =f_query_add_mod.frameRequestGroupList.document.formRequestGroupList.bean_name.value;
	var PConfirm = "No";
	if(flag2 == "PY")
		PConfirm = await confirmPrintingNew();
		if (PConfirm == "Yes" || (flag2 == "PS" && confirmation=="Yes")){
			var doc_type_code = f_query_add_mod.frameRequestGroupHeader.document.formRequestGroupHeader.doc_type_code.value;
			if(f_query_add_mod.frameRequestGroupHeader.document.formRequestGroupHeader.mode.value==MODE_MODIFY)
				var doc_no=f_query_add_mod.frameRequestGroupHeader.document.formRequestGroupHeader.doc_no.value
			else
				var doc_no =(flag1.split(":"))[1];
			var language_id = f_query_add_mod.frameRequestGroupHeader.document.formRequestGroupHeader.locale.value;
			//alert("doc_type_code==="+doc_type_code+"doc_no==="+doc_no+"language_id==="+language_id)
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			
		    var parser = new DOMParser();
		    var xmlDoc = parser.parseFromString(getXMLString(null), "application/xml");
			
			
//			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", 	"../../eSS/jsp/RequestGroupValidate.jsp?validate=printOnlineDoc&msg="+encodeURIComponent(message)+"&language_id="+language_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no, true);
			
			xmlHttp.setRequestHeader("Content-Type", "text/xml");
			xmlHttp.send(xmlDoc);
		
	}
	/*else if(flag2 == "PS" || confirmation=="Yes"){
		var doc_type_code = f_query_add_mod.frameRequestGroupHeader.document.formRequestGroupHeader.doc_type_code.value;
		if(f_query_add_mod.frameRequestGroupHeader.document.formRequestGroupHeader.mode.value==MODE_MODIFY)
			var doc_no=f_query_add_mod.frameRequestGroupHeader.document.formRequestGroupHeader.doc_no.value
		else
			var doc_no =(flag1.split(":"))[1];
		var language_id = f_query_add_mod.frameRequestGroupHeader.document.formRequestGroupHeader.locale.value;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", 	"../../eSS/jsp/RequestGroupValidate.jsp?validate=printOnlineDoc&msg="+encodeURIComponent(message)+"&language_id="+language_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no, true);
		xmlHttp.send(xmlDoc);
	}*/
 }//Adding end for AAKH-CRF-0057
 //Added by suresh.r on 06-04-2015 against Inc 54315 beg
 async function confirmPrintingNew() {
	
	var retVal = "";
	var dialogHeight = "8";
	var dialogWidth = "19";
	var dialogTop = "230";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../eSS/jsp/ConfirmOnlinePrint.jsp?confirmLable=PRINT_DOC";
	retVal = await window.showModalDialog(url, arguments, features);
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
}//Added by suresh.r on 06-04-2015 against Inc 54315 end

