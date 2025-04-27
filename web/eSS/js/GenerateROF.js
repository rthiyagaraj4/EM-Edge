/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var xmlDom;
var xmlHttp;
var finalizeType;


function create(){
   	f_query_add_mod.location.href="../../eSS/jsp/GenerateROFFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
} 

function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	// xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlDom = "" ;
	// xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlHttp = new XMLHttpRequest();;
}

function reset() {
	f_query_add_mod.location.reload();
}

function apply() {
	
	var fields =	new Array();
	var fieldNames =new Array();
	var index = 0;
	var headerForm = f_query_add_mod.frameGenerateROFFrameHeader.document.formGenerateROFHeader;
	if(headerForm==undefined)
	{
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
return;
	}
	fields[index] = headerForm.doc_type_code;
	fieldNames[index++]	=	getLabel("Common.DocType.label","Common");
	
	fields[index] = headerForm.doc_date;
	fieldNames[index++]	=	getLabel("eSS.DocDate.label","SS");
	fields[index] = headerForm.store_code;
	fieldNames[index++]	=	getLabel("eSS.StoreCode.label","SS");
	fields[index] = headerForm.service_location;
	fieldNames[index++]	=	getLabel("eSS.ServiceLocation.label","SS");

	//ML-MMOH-CRF-1821-STARTS
	if(headerForm.group_type_mandatory_yn!=null && headerForm.group_type_mandatory_yn.value=="Y") // ML-MMOH-CRF-1821
	{
		fields[index] = headerForm.group_type;
		fieldNames[index++]	=	getLabel("eSS.GroupType.label","SS");		
	}
	//ML-MMOH-CRF-1821-ENDS
	
	obj = getBlankField(fields, fieldNames, messageFrame) 
	if(obj != null){
		obj.focus();
		return;
	}

	var listForm = f_query_add_mod.frameGenerateROFFrameList.document.formGenerateROFQueryResult;
	if(listForm==undefined)
	{
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
return;
	}
	var total_trays = listForm.total_trays.value;

	if (parseFloat(total_trays)<=0) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('MIN_ONE_DETAIL_REQUIRED',"SS");
		return;
	}
	var selectedIndices = "";
	var index = 0;
	var xmlString = "";
	assignBean(listForm);

	for (count = 0;count<parseFloat(total_trays);count++) {
			if(eval("f_query_add_mod.frameGenerateROFFrameList.document.formGenerateROFQueryResult.tray_"+count+".checked")) {
				checkedValue = eval("f_query_add_mod.frameGenerateROFFrameList.document.formGenerateROFQueryResult.tray_key_"+count+".value");
				checkedType = eval("f_query_add_mod.frameGenerateROFFrameList.document.formGenerateROFQueryResult.tray_"+count+".value");
				xmlString += " selected_tray_"+ index +"=\""+checkedValue+"\"";
				xmlString += " selected_type_"+ index +"=\""+checkedType+"\"";
				index+=1;
				
			}
			xmlString += " ";
	}
	
	xmlString ="<root><SEARCH "+xmlString+"/></root>";
//	xmlDom.loadXML(xmlString);
	xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/GenerateROFValidate.jsp?function_type=1", false);
	
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));	
	if(!result){
messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("ATLEAST_ONE_SELECTED","SS");
return;

	}
	eval(formApply(headerForm,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
	
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message+flag;
		
	if (result) {
		onSuccess();
	}
	

}

function onSuccess() {
	create();
}

function getSelectedTrays() {
	var selectedIndices = "";
	var total_trays = document.formReturnGroupSelectTrayResult.total_trays.value;
	var arrayObject = new Array();
	for (count = 0;count<total_trays;count++) {
			if(eval("document.formReturnGroupSelectTrayResult.tray_"+count+".checked")) {
				selectedIndices += (count+ ",");
			}
	}
	document.formReturnGroupSelectTrayResult.chkdIndices.value = selectedIndices;
	arrayObject[arrayObject.length] = document.formReturnGroupSelectTrayResult.chkdIndices;
	assignBean(document.formReturnGroupSelectTrayResult);
	xmlStr = getXMLString(arrayObject);
//	xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
	//window.close();
	let dialogBody = parent.document.getElementById('dialog-body');
	dialogBody.contentWindow.returnValue = formObject.remarks.value;
    const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}

function showSelectTray() {
	var headerForm = document.formGenerateROFHeader;

	var index = 0;
	var queryString = "";
	var fields = "";

	if(headerForm.group_type_mandatory_yn!=null && headerForm.group_type_mandatory_yn.value=="Y") // ML-MMOH-CRF-1821
		fields = new Array (headerForm.doc_type_code,headerForm.doc_date, headerForm.store_code,headerForm.service_location , headerForm.group_type);
	else 
		fields = new Array (headerForm.doc_type_code,headerForm.doc_date, headerForm.store_code,headerForm.service_location); //existing


	var fieldNames	= "";
	if(headerForm.group_type_mandatory_yn!=null && headerForm.group_type_mandatory_yn.value=="Y") // ML-MMOH-CRF-1821
		fieldNames		= new Array (getLabel("Common.DocType.label","Common"),getLabel("eSS.DocDate.label","SS"),	getLabel("eSS.StoreCode.label","SS"),getLabel("eSS.ServiceLocation.label","SS"), getLabel("eSS.GroupType.label","SS"));
	else 
		fieldNames		= new Array (getLabel("Common.DocType.label","Common"),getLabel("eSS.DocDate.label","SS"),	getLabel("eSS.StoreCode.label","SS"),getLabel("eSS.ServiceLocation.label","SS"));
	

	obj = getBlankField1(fields, fieldNames, parent.parent.messageFrame) 
	
	if(obj != null){
		obj.focus();
		return;
	}
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	headerForm.action ="../../eSS/jsp/GenerateROFSelectTrayResult.jsp";
	headerForm.target="frameGenerateROFFrameList";
	headerForm.submit();
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
           errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(legends[i])))+"<br>"
        }
    }
    if ( errors.length != 0 ) {
        messageFrame.location.href=errorPage+"?err_num="+errors;
    }
        return obj ;
}
function closeActionPerformed(frmObj) {
	var selectedIndices = "";
	var index = 0;
	var total_trays = document.formGenerateROFSelectTrayResult.total_trays.value;
	var arrayObject = new Array();
	for (count = 0;count<total_trays;count++) {
			if(eval("document.formGenerateROFSelectTrayResult.tray_"+count+".checked")) {
				arrayObject[index] = eval("document.formGenerateROFSelectTrayResult.table_index_"+count);
				arrayObject[index+1] = eval("document.formGenerateROFSelectTrayResult.group_code_"+count);
				arrayObject[index+2] = eval("document.formGenerateROFSelectTrayResult.tray_no_"+count);
				arrayObject[index+3] = eval("document.formGenerateROFSelectTrayResult.group_desc_"+count);
				arrayObject[index+4] = eval("document.formGenerateROFSelectTrayResult.bin_location_code_"+count);
				arrayObject[index+5] = eval("document.formGenerateROFSelectTrayResult.expiry_date_"+count);
				arrayObject[index+6] = eval("document.formGenerateROFSelectTrayResult.non_returnable_yn_"+count);
				selectedIndices += (count+ ",");
				index += 7
			}
	}
	document.formGenerateROFSelectTrayResult.chkdIndices.value = selectedIndices;
	arrayObject[arrayObject.length] = document.formGenerateROFSelectTrayResult.chkdIndices;
	assignBean(document.formGenerateROFSelectTrayResult);
	xmlStr = getXMLString(arrayObject);
//	xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "GenerateROFValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
	// window.close();
	parent.document.getElementById("dialog_tag").close(); 
}

// To be considered for maintaing the state of the check boxes
function SubmitLink(from, to) {
	var listForm = document.formGenerateROFQueryResult;
	var total_trays = listForm.total_trays.value;

	var selectedIndices = "";
	var index = 0;
	var xmlString = "";
	assignBean(listForm);

	for (count = 0;count<parseFloat(total_trays);count++) {
			if(eval("document.formGenerateROFQueryResult.tray_"+count+".checked")) {
				checkedValue = eval("document.formGenerateROFQueryResult.tray_key_"+count+".value");
				checkedType = eval("document.formGenerateROFQueryResult.tray_"+count+".value");
				checkedKey = eval("document.formGenerateROFQueryResult.total_key_"+count+".value");
				xmlString += " selected_tray_"+ index +"=\""+checkedValue+"\"";
				xmlString += " selected_type_"+ index +"=\""+checkedType+"\"";
				xmlString += " total_key_"+ index +"=\""+checkedKey	+"\"";
				index+=1;
			}
			xmlString += " ";
	}
	xmlString ="<root><SEARCH "+xmlString+"/></root>";

//	xmlDom.loadXML(xmlString);
	xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/GenerateROFValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;

	eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));

    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ;
}


function changeStatusCheckBox(obj)
{
	formObj=parent.frameGenerateROFFrameList.document.formGenerateROFQueryResult;	
	for(var i=0;i<formObj.elements.length;i++)
	{
	  if(formObj.elements[i].type=="checkbox")
	   {
		   if(obj.checked){
				formObj.elements[i].checked=true;
			}
			else{
				formObj.elements[i].checked=false;
			}
		}
	}
}

function assignValue(obj){

formObj=parent.frameGenerateROFFrameList.document.formGenerateROFQueryResult;	

}

