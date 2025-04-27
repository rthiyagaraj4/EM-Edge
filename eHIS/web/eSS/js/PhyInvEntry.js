/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;

function create() {
	f_query_add_mod.location.href="../../eSS/jsp/PhyInvEntryFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
}

function reset() { 
	if (f_query_add_mod.framePhyInvEntryQueryCriteria != null) {
		var headerForm = f_query_add_mod.framePhyInvEntryQueryCriteria.document.formPhyInvEntryHeader;
		headerForm.reset();
		return;
	}
	f_query_add_mod.location.reload();
}

function query(){
	f_query_add_mod.location.href="../../eSS/jsp/PhyInvEntryQueryFrame.jsp?function_id="+function_id;
}

async function deleterecord(){
	var formHeader = f_query_add_mod.PhyInvEntryHeaderFrame.document.formPhyInvEntryHeader;
	var formList = f_query_add_mod.PhyInvEntryListFrame.document.formPhyInvEntryList;
	if(formHeader.mode.value==MODE_MODIFY){
		formHeader.mode.value = MODE_DELETE;
		formList.mode.value = MODE_DELETE;
		var result = await confirmDelete();
		if(result==YES){
			apply();
		}
		else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPERATION_CANCELLED","SS");
			formHeader.mode.value = MODE_MODIFY;
		}
	}
	else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}
}

function onSuccess(){
	var formHeader = f_query_add_mod.PhyInvEntryHeaderFrame.document.formPhyInvEntryHeader;
	if (formHeader.mode.value == MODE_DELETE) {
		query();
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+message;
	}
	else {
		   f_query_add_mod.location.href=src="../../eCommon/html/blank.html" ;
	}
	return;
}

function apply(){
	var headerForm = f_query_add_mod.PhyInvEntryHeaderFrame.document.formPhyInvEntryHeader;
	if (headerForm.mode.value == MODE_DELETE)	{
		eval(formApply(f_query_add_mod.PhyInvEntryListFrame.document.formPhyInvEntryList,SS_CONTROLLER));
		onSuccess();
		return;
	}

	var fields =	new Array();
	var fieldNames =new Array();
	var index = 0;
	var queryString = "";
	
	fields[index] = headerForm.phy_inv_id;
	fieldNames[index++]	=	getLabel("eSS.PhysicalInvId.label","SS");
	fields[index] = headerForm.owner_store_code;
	fieldNames[index++]	=	getLabel("eSS.Owner.label","SS");
	fields[index] = headerForm.current_store_code;
	fieldNames[index++]	=	getLabel("eSS.CurrentStore.label","SS");
	obj = getBlankField(fields, fieldNames, messageFrame) 
	if(obj != null){
		obj.focus();
		return;
	}
	var listForm = f_query_add_mod.PhyInvEntryListFrame.document.formPhyInvEntryList;
	var total_trays = listForm.total_trays.value;
	var index = 0;
	var xmlString = "";
	if (parseFloat(total_trays)<=0) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage("MIN_ONE_DETAIL_REQUIRED","Common");
		return;
	}
	for (count = 0;count<parseFloat(total_trays);count++) {
			if(!eval("f_query_add_mod.PhyInvEntryListFrame.document.formPhyInvEntryList.tray_id_"+count+".checked")) {
				checkedValue = eval("f_query_add_mod.PhyInvEntryListFrame.document.formPhyInvEntryList.selected_tray_"+count+".value");
				xmlString += " selected_tray_"+ index +"=\""+checkedValue+"\"";
				index+=1;
			}
			xmlString += " ";
	}
	xmlString ="<root><SEARCH "+xmlString+"/></root>";
	assignBean(headerForm);	
	xmlDom.loadXML(xmlString);
	xmlHttp.open("POST", "../../eSS/jsp/PhyInvEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=6", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);

	var canProcess = false;
	var formObject = f_query_add_mod.PhyInvEntryListFrame.document.formPhyInvEntryList;
	var total_checkboxes = formObject.total_trays.value;
		for (i=0;i<total_checkboxes;i++ ){
			if (!eval ("formObject.tray_id_"+i+".checked")) {
				canProcess = true;
			}
		}
		if (!canProcess) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage("MIN_ONE_DETAIL_REQUIRED","Common");	 
			return;
		}

	eval(formApply(f_query_add_mod.PhyInvEntryListFrame.document.formPhyInvEntryList,SS_CONTROLLER));
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;	 
	onSuccess();
	return;
}

function Modify(obj,index){
	var phy_inv_id =obj.cells[0].innerText;
	var owner_store_code = eval("document.forms[0].owner_store_code_"+index+".value");
	var current_store_code = eval("document.forms[0].current_store_code_"+index+".value");
	parent.document.location.href="../../eSS/jsp/PhyInvEntryFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&phy_inv_id="+phy_inv_id	+"&owner_store_code="+owner_store_code+"&current_store_code="+current_store_code;
}

function setTrayNo(cellData,index) {
	var tray_no = parent.PhyInvEntryListFrame.document.getElementById("tblTrayList").rows[parseFloat(index)].cells[3].innerText;
	var editing_key = eval("document.formPhyInvEntryList.selected_tray_"+index+".value");
	var bin_location_code = parent.PhyInvEntryListFrame.document.getElementById("tblTrayList").rows[parseFloat(index)].cells[2].innerText;
	var group_code = parent.PhyInvEntryListFrame.document.getElementById("tblTrayList").rows[parseFloat(index)].cells[5].innerText;
	parent.PhyInvEntryDetailFrame.document.location.href="../../eSS/jsp/PhyInvEntryDetail.jsp?tray_no="+tray_no+"&editing_key="+editing_key+"&group_code="+group_code+"&bin_location_code="+bin_location_code;
	return;
}

function assignBean(formObject) {
	bean_id = formObject.bean_id.value;
	bean_name = formObject.bean_name.value;
	xmlDom ="";
	xmlHttp = new XMLHttpRequest();
}

function addToTable() {
	var headerForm = parent.PhyInvEntryHeaderFrame.document.formPhyInvEntryHeader;
	var formTrayDetail = document.formPhyInvEntryDetail;
	var arrayObjects = new Array();
	arrayObjects[0] = formTrayDetail.bin_location_code;
	arrayObjects[1] = formTrayDetail.tray_no;
	arrayObjects[2] = formTrayDetail.group_code;

	var itemValueIndex = formTrayDetail.bin_location_code.selectedIndex;
	formTrayDetail.bin_location_desc.value = formTrayDetail.bin_location_code.options[parseFloat(itemValueIndex)].text;
	var groupValueIndex = formTrayDetail.group_code.selectedIndex;
	formTrayDetail.group_desc.value = formTrayDetail.group_code.options[parseFloat(groupValueIndex)].text;
	var fieldNames = new Array(getLabel("eSS.BinLocation.label","SS"),getLabel("eSS.TrayNo.label","SS"),getLabel("eSS.GroupCode.label","SS"));
	var obj = getBlankField(arrayObjects, fieldNames, parent.parent.messageFrame); 
	if (obj != null) {
		obj.focus();
		return;
	}
	validateTrayNo();
	if (!result) {
		return;
	}
	arrayObjects[2] = formTrayDetail.editing_key;
	arrayObjects[3] = formTrayDetail.bin_location_desc;
	arrayObjects[4] = formTrayDetail.group_code;
	arrayObjects[5] = formTrayDetail.group_desc;
	bean_id = headerForm.bean_id.value;
	bean_name = headerForm.bean_name.value;
	xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
	xmlStr = getXMLString (arrayObjects);
	xmlDom.loadXML( xmlStr );
	xmlHttp.open("POST", "../../eSS/jsp/PhyInvEntryValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=4", false);
	xmlHttp.send( xmlDom );
	responseText=xmlHttp.responseText;
	eval( responseText );
	if (!result) {
		formTrayDetail.bin_location_code.value = "";
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage(message,"SS");
		return;
	}
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	parent.PhyInvEntryListFrame.document.location.reload();
	formTrayDetail.bin_location_code.value = "";
	formTrayDetail.group_code.value="";
	formTrayDetail.tray_no.value="";
	formTrayDetail.editing_key.value="";
	formTrayDetail.modify.value = getLabel("Common.Add.label","Common");
	formTrayDetail.group_code.disabled = false;
	formTrayDetail.tray_no.disabled = false;
}

function disableAll() {
	var formTrayDetail = parent.PhyInvEntryDetailFrame.document.formPhyInvEntryDetail;
	formTrayDetail.group_code.value=formTrayDetail.tray_no.value=formTrayDetail.bin_location_code.value="";
	formTrayDetail.modify.disabled=formTrayDetail.group_code.disabled=formTrayDetail.tray_no.disabled=false;
	formTrayDetail.modify.value = getLabel("Common.Add.label","Common");
	formTrayDetail.editing_key.value ="";
	return;
}

function searchCode( objCode, objDesc ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	argumentArray[0] = document.formPhyInvEntryHeader.SQL_SS_GROUP_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	if(objDesc.readOnly)
		argumentArray[5] = "";
	else
		argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup( "Physical Inventory Entry", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objDesc.readOnly=true;
	} 
}

function addBinLocations(owner_store_code) {
		if( owner_store_code.value == "" ) 
			return;
		assignBean(document.formPhyInvEntryHeader);
		var arrayObject = new Array();
		arrayObject[0] = owner_store_code;
		xmlStr = getXMLString(arrayObject);
		xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "../../eSS/jsp/PhyInvEntryValidate.jsp?bean_id="+ bean_id +"&bean_name="+bean_name+"&function_type=1", false);
		xmlHttp.send( xmlDom );
		responseText=xmlHttp.responseText;
		eval( responseText );
}



function validatePhyInvId(phyInvId) {
	if (phyInvId.value =="") 
		return;
	assignBean(document.formPhyInvEntryHeader);
	var arrayObject = new Array();
	arrayObject[0] = phyInvId;
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eSS/jsp/PhyInvEntryValidate.jsp?bean_id="+ bean_id +"&bean_name="+bean_name+"&function_type=2", false);
	xmlHttp.send( xmlDom );
	responseText=xmlHttp.responseText;
	eval( responseText );
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";	 
	if (!result) {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('INVALID_PHY_IND_ID',"SS");
		document.formPhyInvEntryHeader.count_sheet_date.value = "";
		phyInvId.focus();
	}
	return;
}

function setCountSheetDate(count_date) {
	document.formPhyInvEntryHeader.count_sheet_date.value = count_date;
}

function setBinLocation(binLocation) {
	document.formPhyInvEntryDetail.bin_location_code.value = binLocation;
}

function validatePhyInvRecord() {
	var formObject = document.formPhyInvEntryHeader;
	if (formObject.current_store_code.value =="")	{
		return;
	}
	assignBean(formObject);
	var arrayObject = new Array();
	arrayObject[0] = formObject.phy_inv_id;
	arrayObject[1] = formObject.owner_store_code;
	arrayObject[2] = formObject.group_code;
	arrayObject[3] = formObject.current_store_code;
	var arrayMessage = new Array("Physical Inventory ID","Owner Store","Group","Current Store");
	obj = getBlankField(arrayObject, arrayMessage, parent.parent.messageFrame) 
	if(obj != null){
		obj.focus();
		return;
	}
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eSS/jsp/PhyInvEntryValidate.jsp?bean_id="+ bean_id +"&bean_name="+bean_name+"&function_type=3", false);
	xmlHttp.send( xmlDom );
	responseText=xmlHttp.responseText;
	eval( responseText );
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";	 
	if (!result) {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('INVALID_PHY_IND_RECORD',"SS");	
		formObject.current_store_code.focus();
	}
	return;
}

function searchTrayNo(){
	
	
	var headerForm = parent.PhyInvEntryHeaderFrame.document.formPhyInvEntryHeader;
	
	var formDetail = parent.PhyInvEntryDetailFrame.document.formPhyInvEntryDetail;
	
	var phy_inv_id	=	headerForm.phy_inv_id.value;
	var group_code	=	headerForm.group_code.value;
	var group_desc	=	headerForm.group_desc.value;
	var store_code	=	headerForm.owner_store_code.value;
	var current_store_code =	headerForm.current_store_code.value;
	
	if((group_code=="")||(store_code==""))
		return;
	var dialogHeight= "28" ;
    var dialogWidth = "43" ;
    var status = "no";
	
	var dialogUrl = "../../eSS/jsp/PhyInvEntryTrayQueryFrame.jsp?function_id="+function_id+"&tray_no="+formDetail.tray_no.value+"&group_code="+group_code+"&group_desc="+group_desc+"&store_code="+store_code+"&current_store_code="+current_store_code+"&phy_inv_id="+phy_inv_id;
	
	var dialogArguments = ""
	var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var returnVal = window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
	if( returnVal == null )
		return;
	else{
		formDetail.tray_no.value=returnVal;
		formDetail.tray_no.focus();
	}
}

function validateTrayNo() {
	var headerForm = parent.PhyInvEntryHeaderFrame.document.formPhyInvEntryHeader;
	var formDetail = document.formPhyInvEntryDetail;
	if (formDetail.tray_no.value != "" && !checkIntegerFormat(formDetail.tray_no)) {
		formDetail.tray_no.focus();
		return;
	}
	if (formDetail.tray_no.value != "") {
		var arrayObjects = new Array (headerForm.phy_inv_id, headerForm.owner_store_code,formDetail.group_code,headerForm.current_store_code);
		var names  =  new Array(getLabel("eSS.PhysicalInvId.label","SS"),getLabel("eSS.Owner.label","SS"), getLabel("Common.Group.label","Common"),getLabel("eSS.CurrentStore.label","SS"));
		var obj =null;
		var messageFrame = parent.parent.messageFrame; 
		var errorPage	 = "../../eCommon/jsp/error.jsp";
		var xmlString ="";
		
		arrayObjects = new Array (headerForm.phy_inv_id, headerForm.owner_store_code,formDetail.group_desc,headerForm.current_store_code,formDetail.group_code,formDetail.tray_no);
		for (index=0;index<arrayObjects.length;index++)	{
				xmlString += arrayObjects[index].name+"=\""+ checkSpl(arrayObjects[index].value) +"\" ";
		}
		xmlString ="<root><SEARCH "+xmlString+"/></root>";
		bean_id = headerForm.bean_id.value;
		bean_name = headerForm.bean_name.value;
		xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
		xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
		xmlDom.loadXML(xmlString);
		xmlHttp.open("POST", "../../eSS/jsp/PhyInvEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=5", false);
		xmlHttp.send(xmlDom);
		responseText=xmlHttp.responseText;
		eval(responseText);
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
		if (!result) {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('INVALID_TRAY_NO',"SS");
			formDetail.tray_no.focus();
			return;
		}
	 }
}

function returnTrayNo(obj){
	var tray_no=obj.cells[0].innerText;
    top.window.returnValue = tray_no;
    top.close();
}

function submitCriteria() {
	var headerForm = document.formPhyInvEntryHeader;
	headerForm.submit();
}
