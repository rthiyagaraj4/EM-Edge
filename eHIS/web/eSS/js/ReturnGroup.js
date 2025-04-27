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
	f_query_add_mod.location.href="../../eSS/jsp/ReturnGroupFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id+"&menu_id="+menu_id+"&module_id="+module_id;
}

function query(){
	f_query_add_mod.location.href="../../eSS/jsp/ReturnGroupQueryMain.jsp?mode="+MODE_MODIFY+"&function_id="+function_id;
}

function onSuccess(){
	if(f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader.mode.value==MODE_DELETE) {
		f_query_add_mod.location.href = "../../eCommon/html/blank.html";
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;
	}
	else if(f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader.mode.value==MODE_MODIFY) {
		create();
		
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;
	}
	else if(f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader.mode.value==MODE_INSERT) {
		create();
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message+flag;
	}
	else 
	{
		var header = f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader;
		header.reset();
		header.return_from.disabled = header.return_to.disabled = false;
		f_query_add_mod.frameReturnGroupDetail.document.formReturnGroupDetail.reset();
		f_query_add_mod.frameReturnGroupList.document.location.reload();
	}
	return;
}

function enableStores() { 
	parent.frameReturnGroupHeader.document.formReturnGroupHeader.return_from.disabled=false;
	parent.frameReturnGroupHeader.document.formReturnGroupHeader.return_to.disabled=false;
}

function reset(){
	if (f_query_add_mod.frames[0].document.forms[0].mode.value==MODE_MODIFY){
		f_query_add_mod.frames[0].document.forms[0].reset();
		
	}
	else {
		f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader.reset();
		f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader.return_to.disabled = f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader.return_from.disabled = false;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var param = "reset=\"Y\"";
		var xmlStr ="<root><SEARCH "+param+"/></root>";
		assignBean(f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader);
		// xmlDom.loadXML(xmlStr);
		var parser = new DOMParser();
    	 xmlDoc = parser.parseFromString(xmlStr, "application/xml");
		
		xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=13", false);
		//xmlHttp.send(xmlDom);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
		responseText=xmlHttp.responseText;
		eval(responseText);
		f_query_add_mod.frameReturnGroupList.document.location.reload();
		f_query_add_mod.frameReturnGroupDetail.document.location.reload();
		f_query_add_mod.frameReturnGroupDetail.document.formReturnGroupDetail.group_desc.value ="";
		f_query_add_mod.frameReturnGroupDetail.document.formReturnGroupDetail.tray_no.value ="";
		f_query_add_mod.frameReturnGroupDetail.document.formReturnGroupDetail.used_yn.disabled=true;
		disableForm(f_query_add_mod.frameReturnGroupDetail.document.formReturnGroupDetail);
	}
}

function Modify(obj){
	var doc_type_code =obj.cells[5].innerText;
	var doc_no =obj.cells[1].innerText;
	parent.document.location.href="../../eSS/jsp/ReturnGroupFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&menu_id="+parent.parent.menu_id+"&module_id="+parent.parent.module_id;
}

async function deleterecord(){
	//Added by Sakti handled error in query mode
		if(  f_query_add_mod.frameReturnGroupHeader ==undefined ){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	} 
	//Added ends
	var form_mode = f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader.mode.value;
	if(form_mode==MODE_MODIFY){
		f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader.mode.value = MODE_DELETE;
		var result = await confirmDelete();
		if(result==YES){
			apply();
		}
		else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPERATION_CANCELLED","SS");
			f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader.mode.value = MODE_MODIFY;
		}
	}
	else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}
}

function editDiscrepancyDetail(arrayObject) {
	var formDiscrepancyDetail = parent.frameReturnGroupDiscrepancyDetail.document.formReturnGroupDiscrepancyDetail;
	formDiscrepancyDetail.write_off_reason_code.disabled =  true;
	formDiscrepancyDetail.item_code.value = arrayObject[0];
	formDiscrepancyDetail.write_off_reason_code.value = arrayObject[1];
	formDiscrepancyDetail.remarks.value =arrayObject[2]; 
	formDiscrepancyDetail.discrepancy_qty.value =arrayObject[3]; 
	formDiscrepancyDetail.patient_id.value = arrayObject[4];
	formDiscrepancyDetail.encounter_id.value =arrayObject[5]; 
	formDiscrepancyDetail.charge_option.value = arrayObject[6];
	formDiscrepancyDetail.charge_amt.value = arrayObject[7];
	formDiscrepancyDetail.rec_reference.value = arrayObject[8];
	if (arrayObject[9] == "Y") {
		formDiscrepancyDetail.item_returnable_yn.checked = true;
	}
	else {
		formDiscrepancyDetail.item_returnable_yn.checked = false;
	}

}

function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	/*xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");*/
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
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
async function showSelectTray(fromCode,toCode) {
	var fields =	new Array();
	var fieldNames =new Array();
	var index = 0;
	var headerForm = document.formReturnGroupHeader;

	fields[index] = headerForm.return_from;
	fieldNames[index++]	=	getLabel("eSS.ReturnFrom.label","SS");
	fields[index] = headerForm.return_to;
	fieldNames[index++]	=	getLabel("eSS.ReturnTo.label","SS");
	obj = getBlankField1(fields, fieldNames, parent.parent.messageFrame);

	if(obj != null){
	
		obj.focus();
		return;
	}
	else {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}
	if (fromCode.value==toCode.value)	{
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage('RETURN_BOTH_STORE_SAME',"SS");
		return;
	}
	parent.frameReturnGroupDetail.document.formReturnGroupDetail.reset();

	var formObject = parent.frameReturnGroupList.document.formReturnGroupList;
	
	//Added by sakti against inc#43893 to hold already added groupcode-trayno
	/*xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );*/
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var parser = new DOMParser();
	xmlStr = getEnhancedXMLString (formObject);
	//xmlDom.loadXML( xmlStr );
	xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+formObject.bean_id.value+"&bean_name="+formObject.bean_name.value+ "&function_type=20", false);
	//xmlHttp.send( xmlDom );
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;
	eval( responseText );
	//Added ends

	var arrayObject = new Array();
	arrayObject[0] = document.formReturnGroupHeader.return_from;
	arrayObject[1] = document.formReturnGroupHeader.return_to;
	assignBean(document.formReturnGroupHeader);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=4", false);
	//xmlHttp.send(xmlDom);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
	responseText=xmlHttp.responseText;
	eval(responseText);
	var dialogHeight = "50vh" ;
	var dialogWidth	= "50vw" ;
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;" ;
	var arguments = "" ;
	//var params = "fr_store_code="+fromCode.value+"&to_store_code="+toCode.value;
	var params = "fr_store_code="+fromCode.value+"&to_store_code="+toCode.value+"&patient_order="+headerForm.patient_order.value;//Added against BRU-HIMS-CRF-360
	retVal =await  top.window.showModalDialog("../../eSS/jsp/ReturnGroupSelectTrayQueryFrame.jsp?"+params,arguments,features);
	//if(retVal){
	if (retVal != null && retVal!=undefined) {
		arrayObject[0].disabled=true;
		arrayObject[1].disabled=true;
		parent.frameReturnGroupList.document.location.reload();
	
	}//else part added by Sakti for clearing checked values oncancel and clicking on cross to clear all the values
	else{
		if(!(document.formReturnGroupHeader.return_from.disabled && document.formReturnGroupHeader.return_to.disabled))	{
			// xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
			// xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			assignBean(document.formReturnGroupHeader);
			xmlStr = getXMLString (null);
			// xmlDom.loadXML( xmlStr );
			var parser = new DOMParser();
   			 xmlDoc = parser.parseFromString(xmlStr, "application/xml");
			
			xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=19", false);
			//xmlHttp.send( xmlDom );
			xmlHttp.setRequestHeader("Content-Type", "text/xml");
   			 xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
			responseText=xmlHttp.responseText;
			eval( responseText );
		}
	}//Added ends

	
}
//Added by sakti against BRU-HIMS-CRF_360
function validateRemarksDetail() {
	var formDetail				= document.formReturnGroupDetail;
	if (!setTextAreaMaxLength(formDetail.remarks, 201)) {
				alert(getMessage("REMARKS_NOT_EXCEED_200_CH", "SS"));
				formDetail.remarks.focus();
				return;
			}
}
//Added ends

function updateTrayDetail() {
	var formTrayDetail				= document.formReturnGroupDetail;
	formTrayDetail.updated.value	= "Y";
	//if (formTrayDetail.used_yn.checked && formTrayDetail.patient_id.value=="") {
		var fields					=	new Array();
		var fieldNames				=	new Array();
		var index					=	0;
		fields[index]				=	formTrayDetail.bin_location_code;
		fieldNames[index++]			=	getLabel("eSS.BinLocation.label","SS");
		obj							=	getBlankField(fields, fieldNames, parent.parent.messageFrame) 
		if(obj != null){
			obj.focus();
			return;
		//}
	}
	if (formTrayDetail.patient_id.value!="" && formTrayDetail.patient_name.value=="") {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('INVALID_PATIENT',"SS");
		formTrayDetail.patient_id.focus();
		return;
	}
	//Added by sakti against BRU-HIMS-CRF_360
				if(formTrayDetail.patient_id.value == "")
				{
					if(formTrayDetail.remarks.value==""){
					alert(getMessage('ENTER_REMARKS',"SS"));
					formTrayDetail.remarks.focus();
					parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
					return;
					}
				}else{
					if(formTrayDetail.remarks.value==""){
						formTrayDetail.remarks_code.value = "";
					}
				}
		if(formTrayDetail.remarks_code.value == "undefined"){
		formTrayDetail.remarks_code.value = "";
	}
	//Added ends
	var bin_desc		= formTrayDetail.bin_location_code.options[ formTrayDetail.bin_location_code.selectedIndex].text;
	var formTrayList	= parent.frameReturnGroupList.document.formReturnGroupList;chkBox = eval("formTrayList.tray_id_"+formTrayDetail.table_row_index.value)
	chkBox.disabled = chkBox.checked = false;
	assignBean(formTrayDetail);
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr = getEnhancedXMLString(formTrayDetail);
	//xmlDom.loadXML(xmlStr);
	var parser = new DOMParser();
	 xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	xmlHttp.open("POST", "ReturnGroupValidate.jsp?bin_desc="+bin_desc+"&bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=6", false);
	//xmlHttp.send(xmlDom);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;
	eval(responseText);
	disableAndResetForm(formTrayDetail);
	
	parent.frameReturnGroupList.document.location.reload();
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
}

function updateDiscrepancyTrayDetail() {
	var formDiscrepancyTrayList = parent.frameReturnGroupDiscrepancyList.document.formReturnGroupDiscrepancyList;
	var formDiscrepancyTrayDetail = document.formReturnGroupDiscrepancyDetail;
	formDiscrepancyTrayList.tblInstrumentList.rows[parseFloat(formDiscrepancyTrayDetail.table_row_index.value)].cells[4].innerText = formTrayDetail.patient_id.value;
	chkBox = eval("formDiscrepancyTrayList.item_id_"+formDiscrepancyTrayDetail.table_row_index.value)
	chkBox.disabled = false;
	chkBox.checked = true;
	assignBean(formDiscrepancyTrayDetail);
	xmlStr = getEnhancedXMLString(formDiscrepancyTrayList);
	//xmlDom.loadXML(xmlStr);
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var parser = new DOMParser();
	 xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=6", false);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;
	eval(responseText);
	disableAndResetForm(formDiscrepancyTrayDetail);
	
}

function closeActionPerformed(frmObj) {
	var selectedIndices = "";
	var unselectedIndices = "";
	var returnvals = "";
	var index = 0;
	var total_trays = document.formReturnGroupSelectTrayResult.total_trays.value;
	var arrayObject = new Array();
	//window.returnValue=false;
	for (count = 0;count<total_trays;count++) {
			if(eval("document.formReturnGroupSelectTrayResult.tray_"+count+".checked")) {
				//window.returnValue=true;
	returnvals += document.formReturnGroupSelectTrayResult.elements["group_code_" + count].value + "`" + document.formReturnGroupSelectTrayResult.elements["group_desc_" + count].value +  "~";

				arrayObject[index] = eval("document.formReturnGroupSelectTrayResult.table_index_"+count);
				arrayObject[index+1] = eval("document.formReturnGroupSelectTrayResult.group_code_"+count);
				arrayObject[index+2] = eval("document.formReturnGroupSelectTrayResult.tray_no_"+count);

				eval("document.formReturnGroupSelectTrayResult.group_desc_"+count).value = encodeURIComponent(eval("document.formReturnGroupSelectTrayResult.group_desc_"+count).value,"UTF-8");//Added By Sakti sankar on 08/05/2012 against Inc#32402

				arrayObject[index+3] = eval("document.formReturnGroupSelectTrayResult.group_desc_"+count);
				arrayObject[index+4] = eval("document.formReturnGroupSelectTrayResult.bin_location_code_"+count);
				arrayObject[index+5] = eval("document.formReturnGroupSelectTrayResult.expiry_date_"+count);
				arrayObject[index+6] = eval("document.formReturnGroupSelectTrayResult.non_returnable_yn_"+count);
				arrayObject[index+7] = eval("document.formReturnGroupSelectTrayResult.used_status_"+count);
				arrayObject[index+8] = eval("document.formReturnGroupSelectTrayResult.sterilize_yn_"+count);
				arrayObject[index+9] = eval("document.formReturnGroupSelectTrayResult.wash_yn_"+count);
				arrayObject[index+10] = eval("document.formReturnGroupSelectTrayResult.pack_yn_"+count);
				arrayObject[index+11] = eval("document.formReturnGroupSelectTrayResult.iss_doc_type_code_"+count);
				arrayObject[index+12] = eval("document.formReturnGroupSelectTrayResult.iss_doc_no_"+count);
				arrayObject[index+13] = eval("document.formReturnGroupSelectTrayResult.patient_id_"+count);
				arrayObject[index+14] = eval("document.formReturnGroupSelectTrayResult.bin_desc_"+count);
				selectedIndices += (count+ ",");
				index += 15;
				
			}else{//Added by sakti against inc#43893
				arrayObject[index] = eval("document.formReturnGroupSelectTrayResult.group_code_"+count);
				arrayObject[index+1] = eval("document.formReturnGroupSelectTrayResult.tray_no_"+count);
				unselectedIndices += (count+ ",");
				index += 2;
			} //Added ends
				
	}
	document.formReturnGroupSelectTrayResult.chkdIndices.value = selectedIndices;
	arrayObject[arrayObject.length] = document.formReturnGroupSelectTrayResult.chkdIndices;

	document.formReturnGroupSelectTrayResult.unchkdIndices.value = unselectedIndices;
	arrayObject[arrayObject.length] = document.formReturnGroupSelectTrayResult.unchkdIndices;

	assignBean(document.formReturnGroupSelectTrayResult);
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr = getXMLString(arrayObject);

	//xmlDom.loadXML(xmlStr);
	var parser = new DOMParser();
	 xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=1", false);
	//xmlHttp.send(xmlDom);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
	responseText=xmlHttp.responseText;
	eval(responseText);
	
	window.parent.parent.returnValue = returnvals;
	window.close();
}

function dispalyReturnGroupDtls(cellData,index) {
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var param = "group_code=\""+document.getElementById("tblTrayList").rows[index+1].cells[1].innerText+"\" tray_no=\""+document.getElementById("tblTrayList").rows[index+1].cells[3].innerText+"\" selected_index=\""+index+"\"";
	var xmlStr ="<root><SEARCH "+param+"/></root>";
	assignBean(document.formReturnGroupList);
	// xmlDom.loadXML(xmlStr);
	var parser = new DOMParser();
	xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=2", false);
	//xmlHttp.send(xmlDom);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;
	eval(responseText);
	var detailObject = parent.frameReturnGroupDetail.document.formReturnGroupDetail;
	detailObject.table_row_index.value = index;
	detailObject.group_code.value = document.getElementById("tblTrayList").rows[index+1].cells[1].innerText;
	detailObject.group_desc.value = document.getElementById("tblTrayList").rows[index + 1].cells[2].innerText;
	detailObject.tray_no.value = document.getElementById("tblTrayList").rows[index + 1].cells[3].innerText;
	detailObject.bin_location_code.value = eval("document.formReturnGroupList.bin_location_code_"+index+".value");
	// detailObject.all.details.disabled = false;
	// detailObject.all.details.style.cursor = "pointer";
	getPatientName(detailObject.patient_id,detailObject.patient_name,detailObject);
	enableDetails(parent.frameReturnGroupDetail.document.formReturnGroupDetail);
	
	if(eval("document.formReturnGroupList.used_status_"+index+".value")=="N"){
		detailObject.used_yn.value ="N";
		
	}


	if( (eval("document.formReturnGroupList.used_status_"+index+".value")=="Y")){
		if(eval("parent.frameReturnGroupList.document.formReturnGroupList.tray_id_"+index+".checked")){
		detailObject.used_yn.checked = true;
	
		if(eval("document.formReturnGroupList.charge_consumable_yn_"+index+".value")=="N"){
		detailObject.charge_consumable_yn.checked = false;
		
		}
		else{
		detailObject.charge_consumable_yn.checked = true;
		}
		}
		else
		{
			
			detailObject.used_yn.checked = true;
			
		}
	}

	else{
		
		detailObject.used_yn.checked = false;
		detailObject.used_yn.value = "N";
		detailObject.charge_consumable_yn.checked = false;
	}



	if (eval("document.formReturnGroupList.expiry_date_"+index+".value")=="Y") {
		detailObject.expired_yn.checked = true;
		detailObject.used_yn.checked = false;
		detailObject.used_yn.disabled = true;

		detailObject.sterilize_yn.disabled = true;
	}
	else {
		detailObject.expired_yn.checked = false;
		detailObject.sterilize_yn.disabled = true;
	}
	if (eval("document.formReturnGroupList.non_returnable_yn_"+index+".value")=="Y") {
		detailObject.used_yn.checked = false;
		detailObject.used_yn.disabled = true;
		detailObject.discrepancy.disabled = true;
		detailObject.sterilize_yn.disabled = true;
	}
	else {
		if (detailObject.mode.value==MODE_MODIFY) {
			detailObject.used_yn.disabled = true;
		}
		else {
			detailObject.used_yn.disabled = false;
		}
		
			if(eval("document.formReturnGroupList.used_status_"+index+".value")=="N"){
			detailObject.used_yn.checked = false;
			}
			else
			{
				detailObject.used_yn.checked = true;
			}
		
	
		detailObject.discrepancy.disabled = false;
	}
	if (detailObject.expired_yn.checked || detailObject.used_yn.checked)	{
		detailObject.sterilize_yn.disabled = true;
	}
	//detailObject.patient_id.disabled = detailObject.cmdPatientSearch.disabled = (!detailObject.used_yn.checked);
	//Added By Sakti Against BRU_HIMS_CRF_360
	if ( (parent.frameReturnGroupHeader.document.formReturnGroupHeader.mode.value == MODE_MODIFY)  && ( !parent.frameReturnGroupHeader.document.formReturnGroupHeader.entry_completed_yn.checked  ) )  {
		detailObject.patient_id.disabled = false;
	}
	//Added ends
	checkSterilized();
	detailObject.modify.disabled = false;
	detailObject.cancel.disabled = false;
	if (parent.frameReturnGroupHeader.document.formReturnGroupHeader.mode.value == MODE_MODIFY  && parent.frameReturnGroupHeader.document.formReturnGroupHeader.entry_completed_yn.checked)  {
		disableForm(parent.frameReturnGroupDetail.document.formReturnGroupDetail);
		
		detailObject.discrepancy.disabled = false;
		detailObject.discrepancy.disabled = false;
		var param = "group_code=\""+document.getElementById("tblTrayList").rows[index+1].cells[1].innerText+"\" tray_no=\""+document.getElementById("tblTrayList").rows[index+1].cells[3].innerText+"\" selected_index=\""+index+"\"";
		var xmlStr ="<root><SEARCH "+param+"/></root>";
		assignBean(document.formReturnGroupList);
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		//xmlDom.loadXML(xmlStr);
		var parser = new DOMParser();
	 	xmlDoc = parser.parseFromString(xmlStr, "application/xml");
		xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=18", false);
		//xmlHttp.send(xmlDom);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
   		xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
		responseText=xmlHttp.responseText;
		eval(responseText);
		detailObject.cancel.disabled = false;
		return;
	}
	if (parent.frameReturnGroupHeader.document.formReturnGroupHeader.mode.value == MODE_MODIFY)  {
		//parent.frameReturnGroupDetail.document.formReturnGroupDetail.patient_id.disabled=true;
		parent.frameReturnGroupDetail.document.formReturnGroupDetail.patient_name.disabled=true;
	
		detailObject.discrepancy.disabled = false;
		var param = "group_code=\""+document.getElementById("tblTrayList").rows[index+1].cells[1].innerText+"\" tray_no=\""+document.getElementById("tblTrayList").rows[index+1].cells[3].innerText+"\" selected_index=\""+index+"\"";
		var xmlStr ="<root><SEARCH "+param+"/></root>";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		assignBean(document.formReturnGroupList);
		//xmlDom.loadXML(xmlStr);
		var parser = new DOMParser();
	 	xmlDoc = parser.parseFromString(xmlStr, "application/xml");
		xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=18", false);
		//xmlHttp.send(xmlDom);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
		responseText=xmlHttp.responseText;
		eval(responseText);
		
	detailObject.cancel.disabled = false;
		return;
	}
	
	
	
}

function displayDiscrepancyDtls(cellData,index) {

	enableDiscrepancyDetails();
	var param = "selected_discrepancy=\""+eval("document.formReturnGroupDiscrepancyList.group_tray_item_"+index+".value")+"\"";
	var xmlStr ="<root><SEARCH "+param+"/></root>";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	assignBean(document.formReturnGroupDiscrepancyList);
	//xmlDom.loadXML(xmlStr);
	var parser = new DOMParser();
	 xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=11", false);
	//xmlHttp.send(xmlDom);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;
	
	eval(responseText);
	if (document.formReturnGroupDiscrepancyList.mode.value == MODE_MODIFY)  {

	
		disableForm(parent.frameReturnGroupDiscrepancyDetail.document.formReturnGroupDiscrepancyDetail);
		parent.frameReturnGroupDiscrepancyDetail.document.formReturnGroupDiscrepancyDetail.close.disabled = false;
	}
	parent.frameReturnGroupDiscrepancyDetail.document.formReturnGroupDiscrepancyDetail.modify.value =getLabel("Common.Modify.label","Common");
	return;
}

function enableDiscrepancyDetails() {
	formObject = parent.frameReturnGroupDiscrepancyDetail.document.formReturnGroupDiscrepancyDetail;
	formObject.write_off_reason_code.disabled = false;
	formObject.remarks.disabled = false;
	formObject.discrepancy_qty.disabled = false;
	formObject.encounter_id.disabled = false;
	formObject.charge_option.disabled = false;
	formObject.rec_reference.disabled = false;
	formObject.modify.disabled = false;
	formObject.cancel.disabled = false;
}

function checkSterilized() {

	var detailObject = parent.frameReturnGroupDetail.document.formReturnGroupDetail;
	if (detailObject.sterilize_yn.checked) {

		detailObject.wash_yn.disabled = detailObject.pack_yn.disabled  = detailObject.contaminated_yn.disabled  = detailObject.charge_consumable_yn.disabled  = (!detailObject.sterilize_yn.checked);
		detailObject.pack_yn.disabled =true;
		detailObject.wash_yn.disabled=true;
	}
	else {

		detailObject.wash_yn.disabled = detailObject.pack_yn.disabled = detailObject.contaminated_yn.disabled= detailObject.charge_consumable_yn.disabled = true;
	}
}

function canAllowEdit(group_code,tray_no) {
	if (document.formReturnGroupDiscrepancyDetail.mode.value==MODE_MODIFY) {
	
		disableForm(document.formReturnGroupDiscrepancyDetail);
		document.formReturnGroupDiscrepancyDetail.close.disabled = false;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		//xmlDoc.loadXML(getXMLString(null));
		var parser = new DOMParser();
	 	xmlDoc = parser.parseFromString(getXMLString(null), "application/xml");
		xmlHttp.open("POST", "../../eSS/jsp/ReturnGroupValidate.jsp?&function_type=17&tray_no="+tray_no+"&group_code="+group_code+"&bean_id="+"returnGroupBean"+"&bean_name="+"eSS.ReturnGroupBean", false);
		//xmlHttp.send(xmlDoc);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
		responseText=xmlHttp.responseText ;
		eval(responseText);
		

	}
}

async function callPatientSearch(patientID,patientName,formObject) {
	var pat_id=await PatientSearch();
	if ((pat_id == null) || (pat_id =="")) {
		patientID.value = "";
		return;
	}
	patientID.value = pat_id;
	getPatientName(patientID,patientName,formObject);
}

async function showHyperDiscrepancyDetails(patientID,groupCode,trayNo,mode) {
	

	var params = "?patient_id="+patientID.value
	+"&group_code="+groupCode.value
	+"&tray_no="+trayNo.value+"&mode="+mode;

	var param = "group_code=\""+groupCode.value+"\" tray_no=\""+trayNo.value+"\"";
	var xmlStr ="<root><SEARCH "+param+"/></root>";
	assignBean(document.forms[0]);
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	//xmlDom.loadXML(xmlStr);
	var parser = new DOMParser();
	xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=16", false);
	//xmlHttp.send(xmlDom);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;


	var dialogHeight	= "58vh";
	var dialogWidth	= "56vw" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;" ;
	var arguments	= "" ;
	
	retVal = await top.window.showModalDialog("../../eSS/jsp/ReturnGroupDiscrepancyFrame.jsp"+params,arguments,features);
}

async function showDiscrepancyDetails(patientID,groupCode,trayNo) {
	var formObject = document.formReturnGroupDetail;
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	var dialogHeight	= "58vh";
	var dialogWidth	= "56vw" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;" ;
	var arguments	= "" ;
	var params = "?"+patientID.name+"="+patientID.value
	+"&"+groupCode.name+"="+groupCode.value 
	+"&"+trayNo.name+"="+trayNo.value+"&mode="+formObject.mode.value;
	retVal = await top.window.showModalDialog("../../eSS/jsp/ReturnGroupDiscrepancyFrame.jsp"+params,arguments,features);
}

function getPatientName(patientID,patientName,formObject) {
	patientName.value = "";
	if (patientID.value == "")	{
		formObject.img_remarks.style.visibility = 'visible';
		return;
	}else{
		formObject.img_remarks.style.visibility = 'hidden';
	}
	var arrayObject = new Array();
	arrayObject[0] = patientID;
	assignBean(formObject);
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr = getXMLString(arrayObject);
	// xmlDom.loadXML(xmlStr);
	var parser = new DOMParser();
	 xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=5", false);
	//xmlHttp.send(xmlDom);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;
	eval(responseText);
}

function setEncounterID(encounter_id){
	document.forms[0].encounter_id.value=encounter_id;
}

function defaultEncounterID(patientID) {
	if (patientID.value == "")	{
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = patientID;
	xmlStr = getXMLString(null);
	//xmlDom.loadXML(xmlStr);
	var parser = new DOMParser();
	xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=15&patient_id="+patientID, false);
	//xmlHttp.send(xmlDom);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		alert(getMessage(message,"SS"));
	}
}

function setPatientName(patientName) {
	if (document.formReturnGroupDetail == null) {
		formObject = document.formReturnGroupDiscrepancyDetail;
	}
	else {
		formObject = document.formReturnGroupDetail;		
	}
	if (patientName == null) {
		formObject.patient_name.value = "";
	}
	else {
		//commented by Rabbani #Inc no:42059 (ML-BRU-SCF-0960) on 07-AUG-2013
		//formObject.patient_name.value = patientName;
		formObject.patient_name.value = decodeURIComponent(patientName,"UTF-8");
	}
}

function enableDetails(detailForm) {
	//detailForm.cmdPatientSearch.disabled = detailForm.bin_location_code.disabled = 	detailForm.used_yn.disabled = 	detailForm.patient_id.disabled = detailForm.sterilize_yn.disabled = 	detailForm.wash_yn.disabled = 	detailForm.pack_yn.disabled = detailForm.contaminated_yn.disabled = detailForm.charge_consumable_yn.disabled = detailForm.discrepancy.disabled = detailForm.modify.disabled = detailForm.cancel.disabled = false;
	detailForm.cmdPatientSearch.disabled = detailForm.bin_location_code.disabled = 	detailForm.used_yn.disabled = 	detailForm.patient_id.disabled = detailForm.sterilize_yn.disabled = 	detailForm.wash_yn.disabled = 	detailForm.pack_yn.disabled = detailForm.contaminated_yn.disabled = detailForm.charge_consumable_yn.disabled = detailForm.discrepancy.disabled = detailForm.modify.disabled = detailForm.cancel.disabled = detailForm.remarks.disabled = detailForm.remark.disabled = false;
	detailForm.sterilize_yn.disabled =true;
	detailForm.wash_yn.disabled =true;
	detailForm.pack_yn.disabled =true;
}

function validateDocAutoNo(doc_type_code) {
	if(document.formReturnGroupHeader.mode.value == MODE_INSERT){
		if(doc_type_code.value == "")  
			return;
		var arrayObject = new Array();
		arrayObject[0] = doc_type_code;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		assignBean(document.formReturnGroupHeader);
		xmlStr = getXMLString(arrayObject);
		//xmlDom.loadXML(xmlStr);
		var parser = new DOMParser();
   		xmlDoc = parser.parseFromString(xmlStr, "application/xml");
		xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=3", false);
		//xmlHttp.send(xmlDom);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
		responseText=xmlHttp.responseText;
		eval(responseText);
	}
}

function enableDocNo() {
	document.formReturnGroupHeader.doc_no.disabled = false;
	document.formReturnGroupHeader.doc_no.readonly = false;
	document.formReturnGroupHeader.doc_no.focus();
	document.formReturnGroupHeader.autono_yn.value = NO;
}

function disableDocNo() {
	document.formReturnGroupHeader.doc_no.disabled = true;
	document.formReturnGroupHeader.doc_no.readonly = true;
	document.formReturnGroupHeader.doc_no.value="";
	document.formReturnGroupHeader.autono_yn.value = YES;
}

async function apply(){
	//Added By Sakti due to Apply error in query result mode on 20th may 2013
	if(  f_query_add_mod.frameReturnGroupList ==undefined ){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	} 
	//Added ends
	var listForm = f_query_add_mod.frameReturnGroupList.document.formReturnGroupList;
		totalCBox	=	parseInt(listForm.total_checkboxes.value);
	var checkBoxObj=null;
	var noDetailExists	=	true;
	var errorPage	=	"../../eCommon/jsp/error.jsp";

	for(i=0;i<totalCBox;i++)
	{
		checkBoxObj=eval("listForm.tray_id_"+i);
		if(!checkBoxObj.checked){
			noDetailExists=false;
		}
	}
	if (noDetailExists){
		messageFrame.location.href = errorPage+"?err_num="+getMessage("MIN_ONE_DETAIL_REQUIRED","Common"); 		
		return;
	}

	var headerForm = f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader;
	if (headerForm.mode.value==MODE_DELETE)  {
		eval(formApply(f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader,SS_CONTROLLER));
		onSuccess();
		return;
	}
	
	//Added By Sakti Sankar against Inc#35525	
	var totalCheckBoxes = listForm.total_checkboxes.value;
	
	var hasRecordsToProcess = false;
			var checkedValues = "";
			var deleteTrays = "";
			var updateTrays = "";
		if (headerForm.mode.value==MODE_MODIFY)	{
			
		for (idx = 0 ;idx < parseFloat(totalCheckBoxes);idx++ ) {
			hasRecordsToProcess = true;
			if (eval("f_query_add_mod.frameReturnGroupList.document.formReturnGroupList.tray_id_"+idx+".checked")) {
				deleteTrays += (idx + ",")
			}
			else {
				updateTrays += (idx + ",")
			}
		}
		headerForm.delete_trays.value = deleteTrays;
		headerForm.update_trays.value = updateTrays;
		
	
	}
	else if (headerForm.mode.value==MODE_INSERT)	{
		for (idx = 0 ;idx < parseFloat(totalCheckBoxes);idx++ ) {
			if ((!(eval("f_query_add_mod.frameReturnGroupList.document.formReturnGroupList.tray_id_"+idx+".disabled"))) && (! (eval("f_query_add_mod.frameReturnGroupList.document.formReturnGroupList.tray_id_"+idx+".checked")))) {
				hasRecordsToProcess = true;
				checkedValues += (idx + ",")
			}
		}
		headerForm.records_for_submission.value = checkedValues;
	}	//Added ends
	if (headerForm.mode.value==MODE_MODIFY )  {
	//if (headerForm.SS_RETURN_GROUP_FINALIZE!=null){
	//if(headerForm.entry_completed_yn.checked && (headerForm.SS_RETURN_GROUP_FINALIZE.value=="Y")){
		if(headerForm.entry_completed_yn.checked){
			finalizeType = await confirmFinalize();
			if (finalizeType !=	CLOSED) {
				if (finalizeType == YES) {
					headerForm.finalize_yn.value = YES;
					eval(formApply(headerForm,SS_CONTROLLER));
					if(result) {
						callOnlinePrint(headerForm, finalizeType); //Added for AAKH-CRF-0057
						onSuccess();
					}
					f_query_add_mod.frameReturnGroupHeader.FocusFirstElement();
					return;
				}
				else {
					headerForm.finalize_yn.value = NO;
					eval(formApply(headerForm,SS_CONTROLLER));
					if(result) {
						callOnlinePrint(headerForm, finalizeType); //Added for AAKH-CRF-0057	
						onSuccess();
					}
					f_query_add_mod.frameReturnGroupHeader.FocusFirstElement();
					return;
				}
			}
			else{
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPERATION_CANCELLED","SS");
			}
		}
	 //if((headerForm.entry_completed_yn.checked==false) && (headerForm.SS_RETURN_GROUP_FINALIZE.value=="Y")){
		  if(headerForm.entry_completed_yn.checked==false){
				eval(formApply(headerForm,SS_CONTROLLER));
				if(result) {
				onSuccess();
			}
			f_query_add_mod.frameReturnGroupHeader.FocusFirstElement();
		
				return;
		
		}
		
	//}
	}

	//var hasRecordsToProcess = false;

	/*var totalCheckBoxes = listForm.total_checkboxes.value;
	var headerForm = f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader;

	var checkedValues = "";
	var deleteTrays = "";
	var updateTrays = "";

	if (headerForm.mode.value==MODE_MODIFY)	{
		for (idx = 0 ;idx < parseFloat(totalCheckBoxes);idx++ ) {
			hasRecordsToProcess = true;
			if (eval("f_query_add_mod.frameReturnGroupList.document.formReturnGroupList.tray_id_"+idx+".checked")) {
				deleteTrays += (idx + ",")
			}
			else {
				updateTrays += (idx + ",")
			}
		}
		headerForm.delete_trays.value = deleteTrays;
		headerForm.update_trays.value = updateTrays;
	
	}
	else if (headerForm.mode.value==MODE_INSERT)	{
		for (idx = 0 ;idx < parseFloat(totalCheckBoxes);idx++ ) {
			if ((!(eval("f_query_add_mod.frameReturnGroupList.document.formReturnGroupList.tray_id_"+idx+".disabled"))) && (! (eval("f_query_add_mod.frameReturnGroupList.document.formReturnGroupList.tray_id_"+idx+".checked")))) {
				hasRecordsToProcess = true;
				checkedValues += (idx + ",")
			}
		}
		
		headerForm.records_for_submission.value = checkedValues;
		
	}*/

	var fields =	new Array();
	var fieldNames =new Array();
	var index = 0;
	var queryString = "";

	fields[index] = headerForm.doc_type_code;
	fieldNames[index++]	=	getLabel("Common.DocType.label","Common");
	if(!headerForm.doc_no.disabled){
		fields[index] = headerForm.doc_no;
		fieldNames[index++]	=	getLabel("eSS.DocNo.label","SS");
	}
	fields[index] = headerForm.doc_date;
	fieldNames[index++]	=	getLabel("eSS.DocDate.label","SS");
	fields[index] = headerForm.return_from;
	fieldNames[index++]	=	getLabel("eSS.ReturnFrom.label","SS");
	fields[index] = headerForm.return_to;
	fieldNames[index++]	=	getLabel("eSS.ReturnTo.label","SS");
	obj = getBlankField(fields, fieldNames, messageFrame) 
	if(obj != null){
		obj.focus();
	}
	else	if (!hasRecordsToProcess) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('MIN_ONE_DETAIL_REQUIRED',"SS");
		return;
	}
	else if ((headerForm.mode.value==MODE_INSERT) && (checkedValues != null) && (checkedValues == ""))	{
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
		return;
	}
	else {
	
		validateDocDate(headerForm.doc_date);
		if (!result) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;
			return;
		}

		if  ((headerForm.mode.value==MODE_INSERT) &&(headerForm.entry_completed_yn.checked)) {

			finalizeType =await confirmFinalize();
			if (finalizeType !=	CLOSED) {
			if (finalizeType == YES) {
				headerForm.finalize_yn.value = YES;
				eval(formApply(headerForm,SS_CONTROLLER));
				callOnlinePrint(headerForm, finalizeType); //Added for AAKH-CRF-0057
				flag = (flag.split("~"))[0];//Added for AAKH-CRF-0057
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message+"<BR>"+ flag;
				if(result) {
				onSuccess();
				}
				f_query_add_mod.frameReturnGroupHeader.FocusFirstElement();
		
				return;
			}
			else {
					headerForm.finalize_yn.value = NO;
					eval(formApply(headerForm,SS_CONTROLLER));
					callOnlinePrint(headerForm, finalizeType); //Added for AAKH-CRF-0057
					flag = (flag.split("~"))[0];//Added for AAKH-CRF-0057
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message+"<BR>"+ flag;
				if(result) {
				onSuccess();
			}
			f_query_add_mod.frameReturnGroupHeader.FocusFirstElement();
		
				return;
			}
			}
			
				else {
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPERATION_CANCELLED","SS");
		}
		}
		else
		{
					
					eval(formApply(headerForm,SS_CONTROLLER));
					
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message+"<BR>"+ flag;
					if(result) {

					onSuccess();
				
					f_query_add_mod.frameReturnGroupHeader.FocusFirstElement();
				
					return;
			}
		}
		
		
	}
}

function validateDocDate(doc_date) {
	var headerForm = f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader;
	var locale			=	headerForm.locale.value;
	
	doc_date.value			=	convertDate(headerForm.doc_date.value,'DMY',headerForm.locale.value,"en"); 

	var arrayObjects = new Array();
	arrayObjects[0] = doc_date;
	if(!(headerForm.mode.value==MODE_DELETE)) {
		bean_id = headerForm.bean_id.value;
		bean_name = headerForm.bean_name.value;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr = getXMLString (arrayObjects);
		//xmlDom.loadXML( xmlStr );
		var parser = new DOMParser();
	 	xmlDoc = parser.parseFromString(xmlStr, "application/xml");
		xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=7", false);
		//xmlHttp.send( xmlDom );
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
		responseText=xmlHttp.responseText;
		eval( responseText );
	}
}

function requestDocDateFocus() {
	f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader.doc_date.focus();
}
function convertDate(date,format,from,to){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=convertDate&format="+format+"&date="+date+"&fromLocale="+from+"&toLocale="+to;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText =  trimString(xhr.responseText);

	return(xmlText);
}
function getXHR(){
	var request = false;
	try {
		request = new XMLHttpRequest();
	}catch (trymicrosoft) {
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		}catch (othermicrosoft) {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (failed) {
				request = false;
			}
		}
    }
	if (!request){
		alert("System Error initializing XMLHttpRequest!");
		return;
	}else return request;
}
function getCurrentDate(format, locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=getCurrentDate&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}
function closeMe() {
	//function to update the selected discrepancy items
	var listForm = parent.frameReturnGroupDiscrepancyList.document.formReturnGroupDiscrepancyList;
	if (listForm.mode.value==MODE_MODIFY) {
		window.close();
		return;
	}
	var totalCheckBoxes = listForm.total_inst_checkboxes.value;
	var checkedValues = "";	
	var xmlString = "";
	var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		
	assignBean(listForm);
	for (idx = 0 ;idx < parseFloat(totalCheckBoxes);idx++ ) {
		if ((!(eval("parent.frameReturnGroupDiscrepancyList.document.formReturnGroupDiscrepancyList.item_id_"+idx+".disabled"))) && (! (eval("parent.frameReturnGroupDiscrepancyList.document.formReturnGroupDiscrepancyList.item_id_"+idx+".checked")))) {
			checkedValues = (eval("parent.frameReturnGroupDiscrepancyList.document.formReturnGroupDiscrepancyList.group_tray_item_"+idx+".value"));
			xmlString += " selected_code_"+idx+"=\""+checkedValues+"\"";
		}
	}
	xmlString += " discrepancy_key=\""+document.formReturnGroupDiscrepancyDetail.discrepancy_key.value + "\" ";
	xmlString ="<root><SEARCH "+xmlString+"/></root>";
	//xmlDom.loadXML(xmlString);
	var parser = new DOMParser();
	 	xmlDoc = parser.parseFromString(xmlString, "application/xml");
	xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=10", false);
	//xmlHttp.send(xmlDom);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;
	eval(responseText);
	window.close();
}

function checkMaxQty(discrepancy_qty){
	if (discrepancy_qty.value == "") {
		return;
	}
	var formObject = document.formReturnGroupDiscrepancyDetail;
	var objects = new Array(formObject.item_code,formObject.discrepancy_qty);
	assignBean(formObject);
	var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
	xmlString = getXMLString(objects);
	//xmlDom.loadXML(xmlString);
	var parser = new DOMParser();
	 	xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=14", false);
	//xmlHttp.send(xmlDom);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;
	eval(responseText);
}

function validateEncounterID() {
		if(document.formReturnGroupDiscrepancyDetail.patient_id.value == "" ||
		document.formReturnGroupDiscrepancyDetail.encounter_id.value == "" )   
			return;
		var arrayObject = new Array();
		arrayObject[0] = document.formReturnGroupDiscrepancyDetail.encounter_id;
		assignBean(document.formReturnGroupDiscrepancyDetail);
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr = getXMLString(arrayObject);
		var parser = new DOMParser();
	 	xmlDoc = parser.parseFromString(xmlStr, "application/xml");
		xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=8", false);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
		responseText=xmlHttp.responseText;
		eval(responseText);
}

function requestEncounterIDFocus() {
	document.formReturnGroupDiscrepancyDetail.encounter_id.focus();   
}

function disableAndResetForm(formObject) {
	const details = formObject.querySelectorAll('#details');
	const img_remarks = formObject.querySelectorAll('#img_remarks');
	
	var formElements = formObject.elements;
	for (i=0;i<formElements.length ;i++){
		formElements[i].disabled = true;
	}
	formObject.reset();
details.disabled=true;
//details.style.cursor='default';
//img_remarks.style.visibility = 'hidden';
}

function disableForm(formObject) {
	var formElements = formObject.elements;
	for (i=0;i<formElements.length ;i++){
		formElements[i].disabled = true;
	}
}

function setBinlocation(binLocation) {
	parent.frameReturnGroupDetail.document.formReturnGroupDetail.bin_location_code.value = binLocation;
}
function setExpired(expired) {
	parent.frameReturnGroupDetail.document.formReturnGroupDetail.expired_yn.checked = expired;
}
function setUsed(used) {
	parent.frameReturnGroupDetail.document.formReturnGroupDetail.used_yn.checked = used;
}
function setPatientID(patinetId) {
	parent.frameReturnGroupDetail.document.formReturnGroupDetail.patient_id.value= patinetId;
}
function setPatientName(patientName) {
	//commented by Rabbani #Inc no:42059 (ML-BRU-SCF-0960) on 07-AUG-2013
	//parent.frameReturnGroupDetail.document.formReturnGroupDetail.patient_name.value= patientName;
	parent.frameReturnGroupDetail.document.formReturnGroupDetail.patient_name.value= decodeURIComponent(patientName,"UTF-8");
}
function setSterilization(sterilize) {
	parent.frameReturnGroupDetail.document.formReturnGroupDetail.sterilize_yn.checked = sterilize;
}
function setWashing(wash) {
	parent.frameReturnGroupDetail.document.formReturnGroupDetail.wash_yn.checked = wash;
}
function setPacking(pack) {
	parent.frameReturnGroupDetail.document.formReturnGroupDetail.pack_yn.checked = pack;
}
function setContaminated(contaminated) {
	parent.frameReturnGroupDetail.document.formReturnGroupDetail.contaminated_yn.checked = contaminated;
}
function setChargeConsumable(charge_consum) {
	
	parent.frameReturnGroupDetail.document.formReturnGroupDetail.charge_consumable_yn.checked = charge_consum;
}

//Bru-HIMS-CRF-360
function setRemarks(remarks,remarks_code) {
	parent.frameReturnGroupDetail.document.formReturnGroupDetail.remarks.value= decodeURIComponent(remarks,"UTF-8");
	parent.frameReturnGroupDetail.document.formReturnGroupDetail.remarks_code.value= remarks_code;
}
//ENDS

function isUpdationAllowed(isEntryCompleted) {
	if ((document.formReturnGroupHeader.entry_completed_yn.checked) && (document.formReturnGroupHeader.mode.value == MODE_MODIFY)) {
	
		disableForm(document.formReturnGroupHeader);
		disableForm(parent.frameReturnGroupDetail.document.formReturnGroupDetail);
		disableForm(parent.frameReturnGroupList.document.formReturnGroupList);
	}
}

function canDisableDiscrepancy(checkUsed) {
	if (checkUsed.checked) {
		document.formReturnGroupDetail.discrepancy.disabled =  false;
	}
	else {
	
		document.formReturnGroupDetail.discrepancy.disabled =  true;
	}
	document.formReturnGroupDetail.patient_id.disabled = document.formReturnGroupDetail.cmdPatientSearch.disabled = (!checkUsed.checked);
}

function addToList() {
	var formObj = document.formReturnGroupDiscrepancyDetail;
	var valueIndex = formObj.write_off_reason_code.selectedIndex;
	var itemValueIndex = formObj.item_code.selectedIndex;
	formObj.write_off_reason_desc.value = formObj.write_off_reason_code.options[parseFloat(valueIndex)].text;
	formObj.item_desc.value = formObj.item_code.options[parseFloat(itemValueIndex)].text;
	var fields = new Array ( formObj.item_code,formObj.write_off_reason_code, formObj.discrepancy_qty);/*,formObj.encounter_id*/
	var names =  new Array ( getLabel("eSS.Instrument.label","SS"),getLabel("eSS.DiscrepancyReason.label","SS"),getLabel("eSS.DiscrepancyQuantity.label","SS")  );/*,"Encounter ID"*/
	var obj=null;
	var errors ="";
	validateEncounterID();
	if ((formObj.discrepancy_qty.value != "") && (parseFloat(formObj.discrepancy_qty.value)<=0))	{
		alert (getMessage('INVALID_DISCREPANCY_QUANTITY',"SS"));
		formObj.discrepancy_qty.focus();
		return;
	}
	for( var i=0;i<fields.length; i++ ) 
	{
		if(trimCheck(fields[i].value)) 
			fields[i].value = trimString(fields[i].value);
		else
		{
			if(obj==null)
				obj=fields[i];
			errors = errors + "APP-000001 " + names[i] + " cannot be blank...";
			alert (errors);
			obj.focus();
			return;
		}
	}
	assignBean(formObj);
	var xmlString = getEnhancedXMLString(formObj);
	//xmlDom.loadXML(xmlString);	
	var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
	var parser = new DOMParser();
	 	xmlDoc = parser.parseFromString(xmlString, "application/xml");
	xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+ bean_name +"&function_type=9", false);
	//xmlHttp.send(xmlDom);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;
	eval(responseText);
	if (!result) {
			alert (getMessage(message,"SS"));
			return;
	}
	refreshDetails();
	enableDiscreancySelect();
	formObj.modify.value =getLabel("Common.Add.label","Common");
	return;
}

function refreshDetails(){
	document.formReturnGroupDiscrepancyDetail.reset();
	refreshList();
}

function resetFormObject(frmObj) {
    var arrObj = frmObj.elements;
    var frmObjs = new Array()
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else 
		frmObjs[0] = frmObj ;

    for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
        frmObj = frmObjs[frmCount];
        var arrObj = frmObj.elements;
        for(var i=0;i<arrObj.length;i++) {
            var val = "" ;
            if((arrObj[i].type == "checkbox") || (arrObj[i].type == "radio")) {
                arrObj[i].checked = false;
            }
            else if(arrObj[i].type == "select-multiple" ) {
                for(var j=0; j<arrObj[i].options.length; j++) {
                    arrObj[i].options[j].selected = false;
                }
            }
            else if(arrObj[i].type != "button") {
                arrObj[i].value = "";
			}
		}
	}
}

function refreshList() {
	parent.frameReturnGroupDiscrepancyList.document.forms[0].submit();
}

function enableDiscreancySelect() {
	var formObj = document.formReturnGroupDiscrepancyDetail;
	if (formObj.item_code.disabled) {
		formObj.item_code.disabled = false;
		var arrayObject = new Array();
		arrayObject[0] = formObj.item_code;
		assignBean(formObj);
		var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
		var xmlStr = getXMLString(arrayObject);
		//xmlDom.loadXML(xmlStr);
		var parser = new DOMParser();
	 xmlDoc = parser.parseFromString(xmlStr, "application/xml");
		xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=12", false);
		//xmlHttp.send(xmlDom);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	

		responseText=xmlHttp.responseText;
		eval(responseText);
	} 
	if (formObj.write_off_reason_code.disabled)	{
		formObj.write_off_reason_code.disabled=  false;
	} 
	formObj.modify.value =getLabel("Common.Add.label","Common");
	formObj.reset();
}

//Comented due to problem in query result next==> previous
//Un-Commented by Sakti against ML-BRU-SCF-1050 [IN:043893]
function SubmitLink(from, to) {
	var selectedIndices = "";
	var unselectedIndices = "";
	var index = 0;
	if(document.formReturnGroupSelectTrayResult) {//Added Condition only by Sakti specific to next-previous
	var total_trays = document.formReturnGroupSelectTrayResult.total_trays.value;
	var arrayObject = new Array();
	//window.returnValue=false;
	for (count = 0;count<total_trays;count++) {
			if(eval("document.formReturnGroupSelectTrayResult.tray_"+count+".checked")) {
				//window.returnValue=true;
				arrayObject[index] = eval("document.formReturnGroupSelectTrayResult.table_index_"+count);
				arrayObject[index+1] = eval("document.formReturnGroupSelectTrayResult.group_code_"+count);
				arrayObject[index+2] = eval("document.formReturnGroupSelectTrayResult.tray_no_"+count);
				arrayObject[index+3] = eval("document.formReturnGroupSelectTrayResult.group_desc_"+count);
				arrayObject[index+4] = eval("document.formReturnGroupSelectTrayResult.bin_location_code_"+count);
				arrayObject[index+5] = eval("document.formReturnGroupSelectTrayResult.expiry_date_"+count);
				arrayObject[index+6] = eval("document.formReturnGroupSelectTrayResult.non_returnable_yn_"+count);
				arrayObject[index+7] = eval("document.formReturnGroupSelectTrayResult.used_status_"+count);
				arrayObject[index+8] = eval("document.formReturnGroupSelectTrayResult.sterilize_yn_"+count);
				arrayObject[index+9] = eval("document.formReturnGroupSelectTrayResult.wash_yn_"+count);
				arrayObject[index+10] = eval("document.formReturnGroupSelectTrayResult.pack_yn_"+count);
				arrayObject[index+11] = eval("document.formReturnGroupSelectTrayResult.iss_doc_type_code_"+count);//Added against INC#43893
				arrayObject[index+12] = eval("document.formReturnGroupSelectTrayResult.iss_doc_no_"+count);//Added against INC#43893
				arrayObject[index+13] = eval("document.formReturnGroupSelectTrayResult.patient_id_"+count);//Added against INC#43893
				arrayObject[index+14] = eval("document.formReturnGroupSelectTrayResult.bin_desc_"+count);//Added against INC#43893
				selectedIndices += (count+ ",");  
				index += 15;
			}else{
				arrayObject[index] = eval("document.formReturnGroupSelectTrayResult.group_code_"+count);
				arrayObject[index+1] = eval("document.formReturnGroupSelectTrayResult.tray_no_"+count);
				unselectedIndices += (count+ ",");
				index += 2;
			}
	}
	document.formReturnGroupSelectTrayResult.chkdIndices.value = selectedIndices;
	arrayObject[arrayObject.length] = document.formReturnGroupSelectTrayResult.chkdIndices;

	document.formReturnGroupSelectTrayResult.unchkdIndices.value = unselectedIndices;
	arrayObject[arrayObject.length] = document.formReturnGroupSelectTrayResult.unchkdIndices;

	assignBean(document.formReturnGroupSelectTrayResult);
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	var parser = new DOMParser();
	 xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	xmlHttp.open("POST", "ReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=1", false);
	//xmlHttp.send(xmlDom);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;
	eval(responseText);
	}//Added Condition only ends
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ;
}
async function details()
{
    var group_code		=	document.formReturnGroupDetail.group_code.value;
	var group_desc		=	document.formReturnGroupDetail.group_desc.value;
      if(group_code!="")
	{
	var dialogHeight = "60vh" ;
	//var dialogWidth	= "24" ;
	var dialogWidth	= "50vw" ;

	var dialogTop = "265" ;
	var center = "1" ;

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=yes; status=no;" ;
	var arguments = "" ;
	var title="Request Detail";
	var params = "group_code="+group_code+"&group_desc="+group_desc;
	
	retVal =await window.showModalDialog("../../eSS/jsp/GroupItemDetails.jsp?"+params,arguments,features);
	}
}

async function searchRemarks(objCode,objDesc) {

	objCode_value			=		"";
	objDesc_value			=		"";
	var argumentArray		=		new Array();
	var dataNameArray		=		new Array();
	var dataValueArray		=		new Array();
	var dataTypeArray		=		new Array();

	dataNameArray[0]		=		"language_id" ;
	dataValueArray[0]		=		document.formReturnGroupDetail.language_id.value;
	dataTypeArray[0]		=		STRING ;

	dataNameArray[1]		=		"module_id" ;
	dataValueArray[1]		=		"ST";
	dataTypeArray[1]		=		STRING ; 
	

	dataNameArray[2]		=		"trn_type" ;
	dataValueArray[2]		=		"RTG";
	dataTypeArray[2]		=		STRING ;	

	argumentArray[0]		=		document.formReturnGroupDetail.SQL_SS_TRN_REMARKS_LOOKUP_SELECT.value;	
	
	argumentArray[1]		=		dataNameArray;
	argumentArray[2]		=		dataValueArray;
	argumentArray[3]		=		dataTypeArray;
	argumentArray[4]		=		"4,5";
	argumentArray[5]		=		objDesc_value;
	argumentArray[6]		=		CODE_LINK;
	argumentArray[7]		=		CODE_DESC;
	
	var remarks				=		getLabel("eSS.Reason.label","SS");
	returnedValues			=		await CommonLookup( remarks, argumentArray );
	var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value		=		arr[0];
		objDesc.value		=		arr[1];
		
document.formReturnGroupDetail.remarks_code.value = objCode.value;

		
	} 
}

async function reason(i) {
	if( eval("document.formReturnGroupList.remarks_"+i).value != "") {
	var rem = "";
	rem =await window.showModalDialog("../../eSS/jsp/ReturnGroupRemarks.jsp?remarks=" + encodeURIComponent(eval("document.formReturnGroupList.remarks_"+i).value,"UTF-8"), "", "dialogHeight:41vh; dialogWidth:32vw; center:1; status: no; dialogLeft :520; dialogTop :330;");
		
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

async function callOnlinePrint(formObject, finalizeType){//Adding start for AAKH-CRF-0057
	flag1 = (flag.split("~"))[0];
	flag2 = (flag.split("~"))[1];
	flag1 = (flag1=="null"?"":flag1);
	bean_id = f_query_add_mod.frameReturnGroupList.document.formReturnGroupList.bean_id.value;
	bean_name =f_query_add_mod.frameReturnGroupList.document.formReturnGroupList.bean_name.value;
	var PConfirm = "No";
	if(flag2 == "PY")
		PConfirm = await confirmPrintingNew();
	
	if (PConfirm =='Yes'|| (flag2 == "PS" && finalizeType == YES) ){
		var doc_type_code = f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader.doc_type_code.value;
		if(f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader.mode.value==MODE_MODIFY)
			var doc_no=f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader.doc_no.value
		else
			var doc_no =(flag1.split(":"))[1];
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		var parser = new DOMParser();
	 	xmlDoc = parser.parseFromString(getXMLString(null), "application/xml");
		xmlHttp.open("POST", "../../eSS/jsp/ReturnGroupValidate.jsp?&function_type=21&bean_id="+"returnGroupBean"+"&bean_name="+"eSS.ReturnGroupBean"+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no, true);
		xmlHttp.send(xmlDoc);
	}
/*	}
	else if(flag2 == "PS" && finalizeType == YES ){
		//var language_id = f_query_add_mod.frameReturnGroupList.document.formReturnGroupList.locale.value;
		var doc_type_code = f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader.doc_type_code.value;
		if(f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader.mode.value==MODE_MODIFY)
				var doc_no=f_query_add_mod.frameReturnGroupHeader.document.formReturnGroupHeader.doc_no.value
			else
				var doc_no =(flag1.split(":"))[1];
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/ReturnGroupValidate.jsp?&function_type=21&bean_id="+"returnGroupBean"+"&bean_name="+"eSS.ReturnGroupBean"+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no, true);
		xmlHttp.send(xmlDoc);
	}*/
 }//Adding end  for AAKH-CRF-0057
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

