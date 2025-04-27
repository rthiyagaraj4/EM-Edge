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
	f_query_add_mod.location.href="../../eSS/jsp/LoanReturnGroupFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id+"&menu_id="+menu_id+"&module_id="+module_id;
}

function query(){
	f_query_add_mod.location.href="../../eSS/jsp/LoanReturnGroupQueryMain.jsp?mode="+MODE_MODIFY+"&function_id="+function_id;
}

function onSuccess(){
	if(f_query_add_mod.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader.mode.value==MODE_DELETE) {
		f_query_add_mod.location.href = "../../eCommon/html/blank.html";
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;
	}
	else if(f_query_add_mod.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader.mode.value==MODE_MODIFY) {
		create();
		
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;
	}
	else if(f_query_add_mod.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader.mode.value==MODE_INSERT) {
		create();
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message+flag;
	}
	else 
	{
		var header = f_query_add_mod.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader;
		header.reset();
		header.return_from.disabled = header.return_to.disabled = false;
		f_query_add_mod.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.reset();
		f_query_add_mod.frameLoanReturnGroupList.document.location.reload();
	}
	return;
}

function enableStores() { 
	parent.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader.return_from.disabled=false;
	parent.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader.return_to.disabled=false;
}

function reset(){
	if (f_query_add_mod.frames[0].document.forms[0].mode.value==MODE_MODIFY){
		f_query_add_mod.frames[0].document.forms[0].reset();
		
	}
	else {
		f_query_add_mod.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader.reset();
		f_query_add_mod.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader.return_to.disabled = f_query_add_mod.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader.return_from.disabled = false;
		var param = "reset=\"Y\"";
		var xmlStr ="<root><SEARCH "+param+"/></root>";
		assignBean(f_query_add_mod.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader);
		xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=13", false);
		xmlHttp.send(xmlDom);
		responseText=xmlHttp.responseText;
		eval(responseText);
		f_query_add_mod.frameLoanReturnGroupList.document.location.reload();
		f_query_add_mod.frameLoanReturnGroupDetail.document.location.reload();
		f_query_add_mod.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.group_desc.value ="";
		f_query_add_mod.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.tray_no.value ="";
		f_query_add_mod.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.used_yn.disabled=true;
		disableForm(f_query_add_mod.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail);
	}
}

function Modify(obj){
	var doc_type_code =obj.cells[5].innerText;
	var doc_no =obj.cells[1].innerText;
	parent.document.location.href="../../eSS/jsp/LoanReturnGroupFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&menu_id="+parent.parent.menu_id+"&module_id="+parent.parent.module_id;
}

async function deleterecord(){
	//Added by Sakti handled error in query mode
		if(  f_query_add_mod.frameLoanReturnGroupHeader ==undefined ){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	} 
	//Added ends
	var form_mode = f_query_add_mod.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader.mode.value;
	if(form_mode==MODE_MODIFY){
		f_query_add_mod.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader.mode.value = MODE_DELETE;
		var result = await confirmDelete();
		if(result==YES){
			apply();
		}
		else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPERATION_CANCELLED","SS");
			f_query_add_mod.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader.mode.value = MODE_MODIFY;
		}
	}
	else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}
}

function editDiscrepancyDetail(arrayObject) {
	var formDiscrepancyDetail = parent.frameLoanReturnGroupDiscrepancyDetail.document.formLoanReturnGroupDiscrepancyDetail;
	formDiscrepancyDetail.write_off_reason_code.disabled =  true;
	formDiscrepancyDetail.item_code.value = arrayObject[0];
	formDiscrepancyDetail.write_off_reason_code.value = arrayObject[1];
	formDiscrepancyDetail.remarks.value =new Array(decodeURIComponent(arrayObject[2])); //Added encode by Sakti to handle Special Character if any in remarks against inc#45463
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
	xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
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
function showSelectTray(fromCode,toCode) {
	var fields =	new Array();
	var fieldNames =new Array();
	var index = 0;
	var headerForm = document.formLoanReturnGroupHeader;

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
	//parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.reset();

	var formObject = parent.frameLoanReturnGroupList.document.formLoanReturnGroupList;
	
	//Added by sakti against  to hold already added groupcode-trayno
	xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" ); 
	xmlStr = getEnhancedXMLString (formObject);
	xmlDom.loadXML( xmlStr );
	xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+formObject.bean_id.value+"&bean_name="+formObject.bean_name.value+ "&function_type=20", false);
	xmlHttp.send( xmlDom );
	responseText=xmlHttp.responseText;
	eval( responseText );
	//Added ends

	var arrayObject = new Array();
	arrayObject[0] = document.formLoanReturnGroupHeader.return_from;
	arrayObject[1] = document.formLoanReturnGroupHeader.return_to;
	
	/*assignBean(document.formLoanReturnGroupHeader);
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=4", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	*/
	
	var dialogHeight = "28" ;
	var dialogWidth	= "50" ;
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;" ;
	var arguments = "" ;
	var params = "fr_store_code="+fromCode.value+"&to_store_code="+toCode.value+"&patient_order="+headerForm.patient_order.value;//Added against BRU-HIMS-CRF-360
	retVal = window.showModalDialog("../../eSS/jsp/LoanReturnGroupSelectTrayQueryFrame.jsp?"+params,arguments,features);
	//if(retVal){
	if (retVal != null && retVal!=undefined) {
		arrayObject[0].disabled=true;
		arrayObject[1].disabled=true;
		parent.frameLoanReturnGroupList.document.location.reload();
	
	}//else part added by Sakti for clearing checked values oncancel and clicking on cross to clear all the values
	else{
		if(!(document.formLoanReturnGroupHeader.return_from.disabled && document.formLoanReturnGroupHeader.return_to.disabled))	{
			xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
			xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
			assignBean(document.formLoanReturnGroupHeader);
			xmlStr = getXMLString (null);
			xmlDom.loadXML( xmlStr );
			
			xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=19", false);
			xmlHttp.send( xmlDom );
			responseText=xmlHttp.responseText;
			eval( responseText );
		}
	}//Added ends

	
}
//Added by sakti against BRU-HIMS-CRF_360
function validateRemarksDetail() {
	var formDetail				= document.formLoanReturnGroupRemarks;
	if (!setTextAreaMaxLength(formDetail.remarks, 201)) {
				alert(getMessage("REMARKS_NOT_EXCEED_200_CH", "SS"));
				formDetail.remarks.focus();
				return;
			}
}
//Added ends

function updateTrayDetail() {
	var formTrayDetail				= document.formLoanReturnGroupDetail;
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
	var formTrayList	= parent.frameLoanReturnGroupList.document.formLoanReturnGroupList;chkBox = eval("formTrayList.tray_id_"+formTrayDetail.table_row_index.value)
	chkBox.disabled = chkBox.checked = false;
	assignBean(formTrayDetail);
	xmlStr = getEnhancedXMLString(formTrayDetail);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bin_desc="+bin_desc+"&bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=6", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	disableAndResetForm(formTrayDetail);
	
	parent.frameLoanReturnGroupList.document.location.reload();
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
}

function updateDiscrepancyTrayDetail() {
	var formDiscrepancyTrayList = parent.frameLoanReturnGroupDiscrepancyList.document.formLoanReturnGroupDiscrepancyList;
	var formDiscrepancyTrayDetail = document.formLoanReturnGroupDiscrepancyDetail;
	formDiscrepancyTrayList.all.tblInstrumentList.rows[parseFloat(formDiscrepancyTrayDetail.table_row_index.value)].cells[4].innerText = formTrayDetail.patient_id.value;
	chkBox = eval("formDiscrepancyTrayList.item_id_"+formDiscrepancyTrayDetail.table_row_index.value)
	chkBox.disabled = false;
	chkBox.checked = true;
	assignBean(formDiscrepancyTrayDetail);
	xmlStr = getEnhancedXMLString(formDiscrepancyTrayList);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=6", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	disableAndResetForm(formDiscrepancyTrayDetail);
	
}

function closeActionPerformed(frmObj) {
	var selectedIndices = "";
	var unselectedIndices = "";
	var returnvals = "";
	var index = 0;
	var total_trays = document.formLoanReturnGroupSelectTrayResult.total_trays.value;
	var arrayObject = new Array();
	//window.returnValue=false;
	for (count = 0;count<total_trays;count++) {
			if(eval("document.formLoanReturnGroupSelectTrayResult.tray_"+count+".checked")) {
				//window.returnValue=true;
	returnvals += document.formLoanReturnGroupSelectTrayResult.elements("group_code_" + count).value + "`" + document.formLoanReturnGroupSelectTrayResult.elements("group_desc_" + count).value +  "~";

				arrayObject[index] = eval("document.formLoanReturnGroupSelectTrayResult.table_index_"+count);
				arrayObject[index+1] = eval("document.formLoanReturnGroupSelectTrayResult.group_code_"+count);
				arrayObject[index+2] = eval("document.formLoanReturnGroupSelectTrayResult.tray_no_"+count);

				eval("document.formLoanReturnGroupSelectTrayResult.group_desc_"+count).value = encodeURIComponent(eval("document.formLoanReturnGroupSelectTrayResult.group_desc_"+count).value,"UTF-8");//Added By Sakti sankar on 08/05/2012 against Inc#32402

				arrayObject[index+3] = eval("document.formLoanReturnGroupSelectTrayResult.group_desc_"+count);
				arrayObject[index+4] = eval("document.formLoanReturnGroupSelectTrayResult.bin_location_code_"+count);
				arrayObject[index+5] = eval("document.formLoanReturnGroupSelectTrayResult.expiry_date_"+count);
				arrayObject[index+6] = eval("document.formLoanReturnGroupSelectTrayResult.non_returnable_yn_"+count);
				arrayObject[index+7] = eval("document.formLoanReturnGroupSelectTrayResult.used_status_"+count);
				arrayObject[index+8] = eval("document.formLoanReturnGroupSelectTrayResult.sterilize_yn_"+count);
				arrayObject[index+9] = eval("document.formLoanReturnGroupSelectTrayResult.wash_yn_"+count);
				arrayObject[index+10] = eval("document.formLoanReturnGroupSelectTrayResult.pack_yn_"+count);
				arrayObject[index+11] = eval("document.formLoanReturnGroupSelectTrayResult.iss_doc_type_code_"+count);
				arrayObject[index+12] = eval("document.formLoanReturnGroupSelectTrayResult.iss_doc_no_"+count);
				arrayObject[index+13] = eval("document.formLoanReturnGroupSelectTrayResult.patient_id_"+count);
				arrayObject[index+14] = eval("document.formLoanReturnGroupSelectTrayResult.bin_desc_"+count);
				selectedIndices += (count+ ",");
				index += 15;
				
			}else{//Added by sakti against inc#43893
				arrayObject[index] = eval("document.formLoanReturnGroupSelectTrayResult.group_code_"+count);
				arrayObject[index+1] = eval("document.formLoanReturnGroupSelectTrayResult.tray_no_"+count);
				unselectedIndices += (count+ ",");
				index += 2;
			} //Added ends
				
	}
	document.formLoanReturnGroupSelectTrayResult.chkdIndices.value = selectedIndices;
	arrayObject[arrayObject.length] = document.formLoanReturnGroupSelectTrayResult.chkdIndices;

	document.formLoanReturnGroupSelectTrayResult.unchkdIndices.value = unselectedIndices;
	arrayObject[arrayObject.length] = document.formLoanReturnGroupSelectTrayResult.unchkdIndices;

	assignBean(document.formLoanReturnGroupSelectTrayResult);
	xmlStr = getXMLString(arrayObject);

	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	
	window.parent.parent.returnValue = returnvals;
	window.close();
}

function dispalyLoanReturnGroupDtls(cellData,index) {
	
	var param = "group_code=\""+document.getElementById("tblTrayList").rows[index+1].cells[1].innerText+"\" tray_no=\""+document.getElementById("tblTrayList").rows[index+1].cells[3].innerText+"\" selected_index=\""+index+"\"";
	var xmlStr ="<root><SEARCH "+param+"/></root>";
	assignBean(document.formLoanReturnGroupList);
	xmlDom.loadXML(xmlStr);
	
	xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=2", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	var detailObject = parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail;
	detailObject.table_row_index.value = index;
	detailObject.group_code.value = document.getElementById("tblTrayList").rows[index+1].cells[1].innerText;
	detailObject.group_desc.value = document.getElementById("tblTrayList").rows[index + 1].cells[2].innerText;
	detailObject.tray_no.value = document.getElementById("tblTrayList").rows[index + 1].cells[3].innerText;
	detailObject.bin_location_code.value = eval("document.formLoanReturnGroupList.bin_location_code_"+index+".value");
	detailObject.all.details.disabled = false;
	detailObject.all.details.style.cursor = "hand";
	getPatientName(detailObject.patient_id,detailObject.patient_name,detailObject);
	enableDetails(parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail);
	
	if(eval("document.formLoanReturnGroupList.used_status_"+index+".value")=="N"){
		detailObject.used_yn.value ="N";
		
	}


	if( (eval("document.formLoanReturnGroupList.used_status_"+index+".value")=="Y")){
		if(eval("parent.frameLoanReturnGroupList.document.formLoanReturnGroupList.tray_id_"+index+".checked")){
		detailObject.used_yn.checked = true;
	
		if(eval("document.formLoanReturnGroupList.charge_consumable_yn_"+index+".value")=="N"){
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



	if (eval("document.formLoanReturnGroupList.expiry_date_"+index+".value")=="Y") {
		detailObject.expired_yn.checked = true;
		detailObject.used_yn.checked = false;
		detailObject.used_yn.disabled = true;

		detailObject.sterilize_yn.disabled = true;
	}
	else {
		detailObject.expired_yn.checked = false;
		detailObject.sterilize_yn.disabled = true;
	}
	if (eval("document.formLoanReturnGroupList.non_returnable_yn_"+index+".value")=="Y") {
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
		
			if(eval("document.formLoanReturnGroupList.used_status_"+index+".value")=="N"){
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
	if ( (parent.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader.mode.value == MODE_MODIFY)  && ( !parent.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader.entry_completed_yn.checked  ) )  {
		detailObject.patient_id.disabled = false;
	}
	//Added ends
	checkSterilized();
	detailObject.modify.disabled = false;
	detailObject.cancel.disabled = false;
	if (parent.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader.mode.value == MODE_MODIFY  && parent.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader.entry_completed_yn.checked)  {
		disableForm(parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail);
		
		detailObject.discrepancy.disabled = false;
		detailObject.discrepancy.disabled = false;
		var param = "group_code=\""+document.getElementById("tblTrayList").rows[index+1].cells[1].innerText+"\" tray_no=\""+document.getElementById("tblTrayList").rows[index+1].cells[3].innerText+"\" selected_index=\""+index+"\"";
		var xmlStr ="<root><SEARCH "+param+"/></root>";
		assignBean(document.formLoanReturnGroupList);
		xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=18", false);
		xmlHttp.send(xmlDom);
		responseText=xmlHttp.responseText;
		eval(responseText);
		detailObject.cancel.disabled = false;
		return;
	}
	if (parent.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader.mode.value == MODE_MODIFY)  {
		//parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.patient_id.disabled=true;
		parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.patient_name.disabled=true;
	
		detailObject.discrepancy.disabled = false;
		var param = "group_code=\""+document.getElementById("tblTrayList").rows[index+1].cells[1].innerText+"\" tray_no=\""+document.getElementById("tblTrayList").rows[index+1].cells[3].innerText+"\" selected_index=\""+index+"\"";
		var xmlStr ="<root><SEARCH "+param+"/></root>";
		assignBean(document.formLoanReturnGroupList);
		xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=18", false);
		xmlHttp.send(xmlDom);
		responseText=xmlHttp.responseText;
		eval(responseText);
		
	detailObject.cancel.disabled = false;
		return;
	}
	
	
	
}

function displayDiscrepancyDtls(cellData,index) {

	enableDiscrepancyDetails();
	var param = "selected_discrepancy=\""+eval("document.formLoanReturnGroupDiscrepancyList.group_tray_item_"+index+".value")+"\"";
	var xmlStr ="<root><SEARCH "+param+"/></root>";
	
	assignBean(document.formLoanReturnGroupDiscrepancyList);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=11", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	
	eval(responseText);
	if (document.formLoanReturnGroupDiscrepancyList.mode.value == MODE_MODIFY)  {

	
		disableForm(parent.frameLoanReturnGroupDiscrepancyDetail.document.formLoanReturnGroupDiscrepancyDetail);
		parent.frameLoanReturnGroupDiscrepancyDetail.document.formLoanReturnGroupDiscrepancyDetail.close.disabled = false;
	}
	parent.frameLoanReturnGroupDiscrepancyDetail.document.formLoanReturnGroupDiscrepancyDetail.modify.value =getLabel("Common.Modify.label","Common");
	return;
}

function enableDiscrepancyDetails() {
	formObject = parent.frameLoanReturnGroupDiscrepancyDetail.document.formLoanReturnGroupDiscrepancyDetail;
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

	var detailObject = parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail;
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
	if (document.formLoanReturnGroupDiscrepancyDetail.mode.value==MODE_MODIFY) {
	
		disableForm(document.formLoanReturnGroupDiscrepancyDetail);
		document.formLoanReturnGroupDiscrepancyDetail.close.disabled = false;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/LoanReturnGroupValidate.jsp?&function_type=17&tray_no="+tray_no+"&group_code="+group_code+"&bean_id="+"LoanReturnGroupBean"+"&bean_name="+"eSS.LoanReturnGroupBean", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
		

	}
}

function callPatientSearch(patientID,patientName,formObject,ind) {
	var pat_id= PatientSearch();
	if ((pat_id == null) || (pat_id =="")) {
		patientID.value = "";
		return;
	}
	patientID.value = pat_id;
	getPatientName(patientID,patientName,formObject,ind);
}

function showHyperDiscrepancyDetails(patientID,groupCode,trayNo,mode) {

	var params = "?patient_id="+patientID
	+"&group_code="+groupCode.value
	+"&tray_no="+trayNo.value+"&mode="+mode;

	var param = "group_code=\""+groupCode.value+"\" tray_no=\""+trayNo.value+"\"";
	var xmlStr ="<root><SEARCH "+param+"/></root>";
	assignBean(document.forms[0]);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=16", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;


	var dialogHeight	= "25";
	var dialogWidth	= "50" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;" ;
	var arguments	= "" ;
	
	retVal = window.showModalDialog("../../eSS/jsp/LoanReturnGroupDiscrepancyFrame.jsp"+params,arguments,features);
}

function showDiscrepancyDetails(patientID,groupCode,trayNo) {
	var formObject = document.formLoanReturnGroupDetail;
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	var dialogHeight	= "25";
	var dialogWidth	= "50" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;" ;
	var arguments	= "" ;
	var params = "?"+patientID.name+"="+patientID.value
	+"&"+groupCode.name+"="+groupCode.value 
	+"&"+trayNo.name+"="+trayNo.value+"&mode="+formObject.mode.value;
	retVal = window.showModalDialog("../../eSS/jsp/LoanReturnGroupDiscrepancyFrame.jsp"+params,arguments,features);
}

function getPatientName(patientID,patientName,formObject,index) {
	if (patientID.value == "" )	{
		eval("formObject.img_remarks_"+index).style.visibility = 'visible';
	}else{
		eval("formObject.img_remarks_"+index).style.visibility = 'hidden';
	}

	
	assignBean(formObject);
	xmlStr = getXMLString(null);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&index="+index+"&patient_id="+patientID.value+"&function_type=5", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	
	if (patientID.value!="" && patientName.value=="") {
		//parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('INVALID_PATIENT',"SS");
		alert(getMessage('INVALID_PATIENT',"SS"));
		eval("formObject.patient_id_"+index).focus();
		eval("formObject.patient_id_"+index).select();
		eval("formObject.img_remarks_"+index).style.visibility = 'visible';
		return;
	}
	if (patientName.value=="")	{
		eval("formObject.img_remarks_"+index).style.visibility = 'visible';
	}else{
		eval("formObject.img_remarks_"+index).style.visibility = 'hidden';
	}
	
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
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=15&patient_id="+patientID, false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		alert(getMessage(message,"SS"));
	}
}

function setPatientName(patientName,index) {
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	formObject = document.formLoanReturnGroupList;		
	if (patientName == null) {
		eval("formObject.patient_name_"+index).value = "";
	}
	else {		
		eval("formObject.patient_name_"+index).value = decodeURIComponent(patientName,"UTF-8");
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
	if(document.formLoanReturnGroupHeader.mode.value == MODE_INSERT){
		if(doc_type_code.value == "")  
			return;
		var arrayObject = new Array();
		arrayObject[0] = doc_type_code;
		assignBean(document.formLoanReturnGroupHeader);
		xmlStr = getXMLString(arrayObject);
		xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=3", false);
		xmlHttp.send(xmlDom);
		responseText=xmlHttp.responseText;
		eval(responseText);
	}
}

function enableDocNo() {
	document.formLoanReturnGroupHeader.doc_no.disabled = false;
	document.formLoanReturnGroupHeader.doc_no.readonly = false;
	document.formLoanReturnGroupHeader.doc_no.focus();
	document.formLoanReturnGroupHeader.autono_yn.value = NO;
}

function disableDocNo() {
	document.formLoanReturnGroupHeader.doc_no.disabled = true;
	document.formLoanReturnGroupHeader.doc_no.readonly = true;
	document.formLoanReturnGroupHeader.doc_no.value="";
	document.formLoanReturnGroupHeader.autono_yn.value = YES;
}

async function apply(){
	//Added By Sakti due to Apply error in query result mode on 20th may 2013
	if(  f_query_add_mod.frameLoanReturnGroupList ==undefined ){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	} 
	//Added ends
	var listForm = f_query_add_mod.frameLoanReturnGroupList.document.formLoanReturnGroupList;
		totalCBox	=	parseInt(listForm.total_checkboxes.value);
	var checkBoxObj=null;
	var noDetailExists	=	true;
	var errorPage	=	"../../eCommon/jsp/error.jsp";

	for(i=0;i<totalCBox;i++)
	{
		checkBoxObj=eval("listForm.tray_id_"+i);
		if(!checkBoxObj.checked){
			noDetailExists=false;

			if(eval("listForm.patient_id_"+i).value == "") {
				if(eval("listForm.remarks_"+i).value==""){
				//alert(getMessage('ENTER_REMARKS',"SS"));
				messageFrame.location.href= errorPage + "?err_num="+getMessage('ENTER_REMARKS',"SS");
				return;
				}
			}
			if(eval("listForm.bin_location_code_"+i).value == ""){
				messageFrame.location.href= errorPage + "?err_num="+getMessage('BIN_CANNOT_BLANK',"SS");
				return;
				}
			}
			
	}
	if (noDetailExists){
		messageFrame.location.href = errorPage+"?err_num="+getMessage("MIN_ONE_DETAIL_REQUIRED","Common"); 		
		return;
	}

	assignBean(listForm);
	xmlStr = getEnhancedXMLString(listForm);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+listForm.bean_id.value+"&bean_name="+listForm.bean_name.value+"&function_type=6", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	

	var headerForm = f_query_add_mod.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader;
	if (headerForm.mode.value==MODE_DELETE)  {
		eval(formApply(f_query_add_mod.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader,SS_CONTROLLER));
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
			if (eval("f_query_add_mod.frameLoanReturnGroupList.document.formLoanReturnGroupList.tray_id_"+idx+".checked")) {
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
			if ((!(eval("f_query_add_mod.frameLoanReturnGroupList.document.formLoanReturnGroupList.tray_id_"+idx+".disabled"))) && (! (eval("f_query_add_mod.frameLoanReturnGroupList.document.formLoanReturnGroupList.tray_id_"+idx+".checked")))) {
				hasRecordsToProcess = true;
				checkedValues += (idx + ",")
			}
		}
		
		
		headerForm.records_for_submission.value = checkedValues;
		
	}
	//Added ends
	
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
	

			onSuccess();
			}
			
			f_query_add_mod.frameLoanReturnGroupHeader.FocusFirstElement();
			
		
				return;
			
		}
		else {
			headerForm.finalize_yn.value = NO;
		
			eval(formApply(headerForm,SS_CONTROLLER));
				if(result) {
					
			onSuccess();
			}
			f_query_add_mod.frameLoanReturnGroupHeader.FocusFirstElement();
			
		
				return;
		}
		}
		else 
		{
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPERATION_CANCELLED","SS");
		}
		
	}
	
	 //if((headerForm.entry_completed_yn.checked==false) && (headerForm.SS_RETURN_GROUP_FINALIZE.value=="Y")){
		  if(headerForm.entry_completed_yn.checked==false){
				eval(formApply(headerForm,SS_CONTROLLER));
				if(result) {
				onSuccess();
				
			}
			f_query_add_mod.frameLoanReturnGroupHeader.FocusFirstElement();
		
				return;
		
		}
		
	//}
	}

	//var hasRecordsToProcess = false;

	/*var totalCheckBoxes = listForm.total_checkboxes.value;
	var headerForm = f_query_add_mod.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader;

	var checkedValues = "";
	var deleteTrays = "";
	var updateTrays = "";

	if (headerForm.mode.value==MODE_MODIFY)	{
		for (idx = 0 ;idx < parseFloat(totalCheckBoxes);idx++ ) {
			hasRecordsToProcess = true;
			if (eval("f_query_add_mod.frameLoanReturnGroupList.document.formLoanReturnGroupList.tray_id_"+idx+".checked")) {
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
			if ((!(eval("f_query_add_mod.frameLoanReturnGroupList.document.formLoanReturnGroupList.tray_id_"+idx+".disabled"))) && (! (eval("f_query_add_mod.frameLoanReturnGroupList.document.formLoanReturnGroupList.tray_id_"+idx+".checked")))) {
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

			finalizeType = await confirmFinalize();
			if (finalizeType !=	CLOSED) {
			if (finalizeType == YES) {
				headerForm.finalize_yn.value = YES;
				eval(formApply(headerForm,SS_CONTROLLER));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message+"<BR>"+ flag;
				if(result) {
				onSuccess();
				}
				f_query_add_mod.frameLoanReturnGroupHeader.FocusFirstElement();
		
				return;
			}
			else {
					headerForm.finalize_yn.value = NO;
					eval(formApply(headerForm,SS_CONTROLLER));
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message+"<BR>"+ flag;
				if(result) {
				onSuccess();
			}
			f_query_add_mod.frameLoanReturnGroupHeader.FocusFirstElement();
		
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
				
					f_query_add_mod.frameLoanReturnGroupHeader.FocusFirstElement();
				
					return;
			}
		}
		
		
	}
}

function validateDocDate(doc_date) {
	var headerForm = f_query_add_mod.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader;
	var locale			=	headerForm.locale.value;
	
	doc_date.value			=	convertDate(headerForm.doc_date.value,'DMY',headerForm.locale.value,"en"); 

	var arrayObjects = new Array();
	arrayObjects[0] = doc_date;
	if(!(headerForm.mode.value==MODE_DELETE)) {
		bean_id = headerForm.bean_id.value;
		bean_name = headerForm.bean_name.value;
		xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
		xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
		xmlStr = getXMLString (arrayObjects);
		xmlDom.loadXML( xmlStr );
		xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=7", false);
		xmlHttp.send( xmlDom );
		responseText=xmlHttp.responseText;
		eval( responseText );
	}
}

function requestDocDateFocus() {
	f_query_add_mod.frameLoanReturnGroupHeader.document.formLoanReturnGroupHeader.doc_date.focus();
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
	var listForm = parent.frameLoanReturnGroupDiscrepancyList.document.formLoanReturnGroupDiscrepancyList;
	if (listForm.mode.value==MODE_MODIFY) {
		window.close();
		return;
	}
	var totalCheckBoxes = listForm.total_inst_checkboxes.value;
	var checkedValues = "";	
	var xmlString = "";
	assignBean(listForm);
	for (idx = 0 ;idx < parseFloat(totalCheckBoxes);idx++ ) {
		if ((!(eval("parent.frameLoanReturnGroupDiscrepancyList.document.formLoanReturnGroupDiscrepancyList.item_id_"+idx+".disabled"))) && (! (eval("parent.frameLoanReturnGroupDiscrepancyList.document.formLoanReturnGroupDiscrepancyList.item_id_"+idx+".checked")))) {
			checkedValues = (eval("parent.frameLoanReturnGroupDiscrepancyList.document.formLoanReturnGroupDiscrepancyList.group_tray_item_"+idx+".value"));
			xmlString += " selected_code_"+idx+"=\""+checkedValues+"\"";
		}
	}
	xmlString += " discrepancy_key=\""+document.formLoanReturnGroupDiscrepancyDetail.discrepancy_key.value + "\" ";
	xmlString ="<root><SEARCH "+xmlString+"/></root>";
	xmlDom.loadXML(xmlString);
	xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=10", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	window.close();
}

function checkMaxQty(discrepancy_qty){
	if (discrepancy_qty.value == "") {
		return;
	}
	var formObject = document.formLoanReturnGroupDiscrepancyDetail;
	var objects = new Array(formObject.item_code,formObject.discrepancy_qty);
	assignBean(formObject);
	xmlString = getXMLString(objects);
	xmlDom.loadXML(xmlString);
	xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=14", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

function validateEncounterID() {
		if(document.formLoanReturnGroupDiscrepancyDetail.patient_id.value == "" ||
		document.formLoanReturnGroupDiscrepancyDetail.encounter_id.value == "" )   
			return;
		var arrayObject = new Array();
		arrayObject[0] = document.formLoanReturnGroupDiscrepancyDetail.encounter_id;
		assignBean(document.formLoanReturnGroupDiscrepancyDetail);
		xmlStr = getXMLString(arrayObject);
		xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=8", false);
		xmlHttp.send(xmlDom);
		responseText=xmlHttp.responseText;
		eval(responseText);
}

function requestEncounterIDFocus() {
	document.formLoanReturnGroupDiscrepancyDetail.encounter_id.focus();   
}

function disableAndResetForm(formObject) {
	
	var formElements = formObject.elements;
	for (i=0;i<formElements.length ;i++){
		formElements(i).disabled = true;
	}
	formObject.reset();
formObject.all.details.disabled=true;
formObject.all.details.style.cursor='default';
formObject.img_remarks.style.visibility = 'hidden';
}

function disableForm(formObject) {
	var formElements = formObject.elements;
	for (i=0;i<formElements.length ;i++){
		formElements(i).disabled = true;
	}
}

function setBinlocation(binLocation) {
	parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.bin_location_code.value = binLocation;
}
function setExpired(expired) {
	parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.expired_yn.checked = expired;
}
function setUsed(used) {
	parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.used_yn.checked = used;
}
function setPatientID(patinetId) {
	parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.patient_id.value= patinetId;
}
function setSterilization(sterilize) {
	parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.sterilize_yn.checked = sterilize;
}
function setWashing(wash) {
	parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.wash_yn.checked = wash;
}
function setPacking(pack) {
	parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.pack_yn.checked = pack;
}
function setContaminated(contaminated) {
	parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.contaminated_yn.checked = contaminated;
}
function setChargeConsumable(charge_consum) {
	
	parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.charge_consumable_yn.checked = charge_consum;
}

//Bru-HIMS-CRF-360
function setRemarks(remarks,remarks_code) {
	parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.remarks.value= decodeURIComponent(remarks,"UTF-8");
	parent.frameLoanReturnGroupDetail.document.formLoanReturnGroupDetail.remarks_code.value= remarks_code;
}
//ENDS

function isUpdationAllowed(isEntryCompleted) {
	if ((document.formLoanReturnGroupHeader.entry_completed_yn.checked) && (document.formLoanReturnGroupHeader.mode.value == MODE_MODIFY)) {	
		disableForm(document.formLoanReturnGroupHeader);		
		//disableForm(parent.frameLoanReturnGroupList.document.formLoanReturnGroupList);
		//Added by Sakti against inc#45808
		parent.frameLoanReturnGroupList.location.href="../../eSS/jsp/LoanReturnGroupList.jsp?entry_completed_yn="+document.formLoanReturnGroupHeader.entry_completed_yn.value+"&mode="+document.formLoanReturnGroupHeader.mode.value;
	}
}

function canDisableDiscrepancy(checkUsed,ind) {
	if (checkUsed.checked) {	
		document.getElementById('discrepancy_'+ind).disabled=false;
		document.getElementById('discrepancy_'+ind).setAttribute('href');    
	}
	else {				
		document.getElementById('discrepancy_'+ind).disabled=true;
		document.getElementById('discrepancy_'+ind).removeAttribute('href');    
		document.getElementById('discrepancy_'+ind).style.textDecoration = 'none';
		document.getElementById('discrepancy_'+ind).cursor = 'normal';
	}
	
	//eval("document.formLoanReturnGroupList.patient_id_"+ind).disabled = eval("document.formLoanReturnGroupList.cmdPatientSearch_"+ind).disabled = (!checkUsed.checked);
}

function addToList() {
	var formObj = document.formLoanReturnGroupDiscrepancyDetail;
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
	xmlDom.loadXML(xmlString);	
	xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+ bean_name +"&function_type=9", false);
	xmlHttp.send(xmlDom);
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
	document.formLoanReturnGroupDiscrepancyDetail.reset();
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
	parent.frameLoanReturnGroupDiscrepancyList.document.forms[0].submit();
}

function enableDiscreancySelect() {
	var formObj = document.formLoanReturnGroupDiscrepancyDetail;
	if (formObj.item_code.disabled) {
		formObj.item_code.disabled = false;
		var arrayObject = new Array();
		arrayObject[0] = formObj.item_code;
		assignBean(formObj);
		var xmlStr = getXMLString(arrayObject);
		xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=12", false);
		xmlHttp.send(xmlDom);
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
	if(document.formLoanReturnGroupSelectTrayResult) {//Added Condition only by Sakti specific to next-previous
	var total_trays = document.formLoanReturnGroupSelectTrayResult.total_trays.value;
	var arrayObject = new Array();
	//window.returnValue=false;
	for (count = 0;count<total_trays;count++) {
			if(eval("document.formLoanReturnGroupSelectTrayResult.tray_"+count+".checked")) {
				//window.returnValue=true;
				arrayObject[index] = eval("document.formLoanReturnGroupSelectTrayResult.table_index_"+count);
				arrayObject[index+1] = eval("document.formLoanReturnGroupSelectTrayResult.group_code_"+count);
				arrayObject[index+2] = eval("document.formLoanReturnGroupSelectTrayResult.tray_no_"+count);
				arrayObject[index+3] = eval("document.formLoanReturnGroupSelectTrayResult.group_desc_"+count);
				arrayObject[index+4] = eval("document.formLoanReturnGroupSelectTrayResult.bin_location_code_"+count);
				arrayObject[index+5] = eval("document.formLoanReturnGroupSelectTrayResult.expiry_date_"+count);
				arrayObject[index+6] = eval("document.formLoanReturnGroupSelectTrayResult.non_returnable_yn_"+count);
				arrayObject[index+7] = eval("document.formLoanReturnGroupSelectTrayResult.used_status_"+count);
				arrayObject[index+8] = eval("document.formLoanReturnGroupSelectTrayResult.sterilize_yn_"+count);
				arrayObject[index+9] = eval("document.formLoanReturnGroupSelectTrayResult.wash_yn_"+count);
				arrayObject[index+10] = eval("document.formLoanReturnGroupSelectTrayResult.pack_yn_"+count);
				arrayObject[index+11] = eval("document.formLoanReturnGroupSelectTrayResult.iss_doc_type_code_"+count);//Added against INC#43893
				arrayObject[index+12] = eval("document.formLoanReturnGroupSelectTrayResult.iss_doc_no_"+count);//Added against INC#43893
				arrayObject[index+13] = eval("document.formLoanReturnGroupSelectTrayResult.patient_id_"+count);//Added against INC#43893
				arrayObject[index+14] = eval("document.formLoanReturnGroupSelectTrayResult.bin_desc_"+count);//Added against INC#43893
				selectedIndices += (count+ ",");  
				index += 15;
			}else{
				arrayObject[index] = eval("document.formLoanReturnGroupSelectTrayResult.group_code_"+count);
				arrayObject[index+1] = eval("document.formLoanReturnGroupSelectTrayResult.tray_no_"+count);
				unselectedIndices += (count+ ",");
				index += 2;
			}
	}
	document.formLoanReturnGroupSelectTrayResult.chkdIndices.value = selectedIndices;
	arrayObject[arrayObject.length] = document.formLoanReturnGroupSelectTrayResult.chkdIndices;

	document.formLoanReturnGroupSelectTrayResult.unchkdIndices.value = unselectedIndices;
	arrayObject[arrayObject.length] = document.formLoanReturnGroupSelectTrayResult.unchkdIndices;

	assignBean(document.formLoanReturnGroupSelectTrayResult);
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "LoanReturnGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	}//Added Condition only ends
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ;
}
function details(ind)
{
    var group_code		=	eval("document.formLoanReturnGroupList.group_code_"+ind).value;
	var group_desc		=	eval("document.formLoanReturnGroupList.group_desc_"+ind).value;
    
	if(group_code!=""){
		
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
function searchRemarks(objCode,objDesc) {

	var argumentArray		=		new Array();
	var dataNameArray		=		new Array();
	var dataValueArray		=		new Array();
	var dataTypeArray		=		new Array();

	dataNameArray[0]		=		"language_id" ;
	dataValueArray[0]		=		document.formLoanReturnGroupRemarks.language_id.value;
	dataTypeArray[0]		=		STRING ;

	dataNameArray[1]		=		"module_id" ;
	dataValueArray[1]		=		"ST";
	dataTypeArray[1]		=		STRING ; 
	

	dataNameArray[2]		=		"trn_type" ;
	dataValueArray[2]		=		"RTL";
	dataTypeArray[2]		=		STRING ;	

	argumentArray[0]		=		document.formLoanReturnGroupRemarks.SQL_SS_TRN_REMARKS_LOOKUP_SELECT.value;		
	argumentArray[1]		=		dataNameArray;
	argumentArray[2]		=		dataValueArray;
	argumentArray[3]		=		dataTypeArray;
	argumentArray[4]		=		"4,5";
	argumentArray[5]		=		objDesc.value;
	argumentArray[6]		=		CODE_LINK;
	argumentArray[7]		=		CODE_DESC;
	
	var remarks				=		getLabel("eSS.Reason.label","SS");
	
	returnedValues			=		CommonLookup( remarks, argumentArray );
	
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value		=		returnedValues[0];
		objDesc.value		=		returnedValues[1];		
		document.formLoanReturnGroupRemarks.remarks_code.value = objCode.value;		
	} 
}

function reason(i) {
	if( eval("document.formLoanReturnGroupList.remarks_"+i).value != "") {
	var rem = "";
	rem = window.showModalDialog("../../eSS/jsp/LoanReturnGroupRemarks.jsp?remarks=" + encodeURIComponent(eval("document.formLoanReturnGroupList.remarks_"+i).value,"UTF-8"), "", "dialogHeight:10; dialogWidth:28; center:1; status: no; dialogLeft :520; dialogTop :330;");
		
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

function showRemarks(ind){
    var patient_id		=	eval("document.formLoanReturnGroupList.patient_id_"+ind).value;
	var patient_name	=	eval("document.formLoanReturnGroupList.patient_name_"+ind).value;
	var remarks			=	eval("document.formLoanReturnGroupList.remarks_"+ind).value;
	var remarks_gif		=   "";
	
    
	if(patient_id!="" && patient_name!=""){
		remarks_gif = "visibility:hidden";
	}else{
		remarks_gif = "visibility:visible";
	}
	
	var dialogHeight = "10" ;
	var dialogWidth	= "30" ;
	var dialogTop = "300" ;
	var center = "1" ;
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=yes; status=no;" ;
	var arguments = "" ;
	//var params = "remarks="+encodeURIComponent(remarks,"UTF-8")+"&remarks_gif="+remarks_gif;
	var params = "remarks="+encodeURIComponent(remarks,"UTF-8")+"&remarks_gif="+remarks_gif+"&entry_completed_yn="+document.formLoanReturnGroupList.entry_completed_yn.value;
	
	var retVal = window.showModalDialog("../../eSS/jsp/LoanReturnGroupRemarks.jsp?"+params,arguments,features);
	if(retVal!=undefined)
		eval("document.formLoanReturnGroupList.remarks_"+ind).value = retVal;
}

function updateRemarks(visibility){
	var remarks			=	document.formLoanReturnGroupRemarks.remarks.value;
	if(visibility=="visibility:visible"){
		if(remarks=="" || remarks==null){		
			alert(getMessage('ENTER_REMARKS',"SS"));
			return false;
		}
	}	
	if (!setTextAreaMaxLength(document.formLoanReturnGroupRemarks.remarks, 201)) {
		alert(getMessage("REMARKS_NOT_EXCEED_200_CH", "SS"));
		//formDetail.remarks.focus(); //Commented against inc#45644 
		return false;
	}
	
		window.returnValue  =   remarks;
		window.close();

}


