/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function apply(){
	var formObjHdr = document.frames.f_header.ExamCheckListHeaderForm;
	var checklist_completed_yn = formObjHdr.checklist_completed_yn.value;
	if(checklist_completed_yn==null) checklist_completed_yn="N";
	if(checklist_completed_yn=="null") checklist_completed_yn="N";
	if(checklist_completed_yn=="") checklist_completed_yn="N";
	var formObj=document.frames.f_details.f_query_add_mod.document.ExamsCheckListResultsForm;
	var checklist_already_completed_yn = formObj.checklist_completed_yn.value;
	if(checklist_already_completed_yn=="N" && checklist_completed_yn=="N")
		formObj.completed_by_id.value="";
	if(checklist_already_completed_yn=="Y"){
		var msg = "This CheckList is already Confirmed.";
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
		return false;
	}else{
		formObj.submit();
	}
}
function searchOrders(){
	var locale = document.forms[0].locale.value;
	var formObj = document.ExamCheckListHeaderForm;
	var dialogTop  = "40";
	var dialogHeight = "10";
	var dialogWidth  = "40";
	var arguments = "";
	var column_sizes = escape("50%,40%,10%");               

	// var column_descriptions = escape("Order Id,Ordered Date Time,Order Type Code");  
	
	var column_descriptions = getLabel('Common.OrderID.label','Common')+','+getLabel('Common.OrderDateTime.label','Common')+','+getLabel('Common.OrderType.label');
	
	column_descriptions = encodeURIComponent(column_descriptions);
	
	var sql=escape("SELECT ORDER_ID ORDER_ID1, TO_CHAR(ORD_DATE_TIME,'DD/MM/YYYY HH24:MI') ORD_DATE_TIME1, ORDER_TYPE_CODE ORDER_TYPE_CODE1 FROM OR_ORDER WHERE ORDER_CATEGORY = 'RD' AND ORDER_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ORDER_STATUS_TYPE='10')");
	var title='Search Orders';
	var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	if(retVal!=null){
		var arr = retVal.split('::');
		formObj.order_id.value=arr[0];
		formObj.ordered_date.value=arr[1];
		formObj.order_type_code.value=arr[2];
		assignPatientDetails(formObj);
	}else{
		clearFields(formObj);
	}
}
function assignPatientDetails(formObj){
	var retValue = getPatientDetails(formObj.facility_id.value,formObj.order_id.value);
	var pat_dtls_arr  = retValue.split("::");	
	//alert(pat_dtls_arr);
	formObj.patient_id.value = pat_dtls_arr[1];
	formObj.encounter_id.value = pat_dtls_arr[2];
	formObj.patient_name.value = pat_dtls_arr[3];
	formObj.sex.value = pat_dtls_arr[4];
	formObj.dob.value = pat_dtls_arr[5];
	formObj.episode_type.value = pat_dtls_arr[6];
	formObj.patient_class.value = pat_dtls_arr[7];
	formObj.patient_class_desc.value = pat_dtls_arr[8];
	formObj.data_exists.value = pat_dtls_arr[9];
	var checklist_completed_yn = pat_dtls_arr[10];
	formObj.checklist_completed_yn.value = checklist_completed_yn;
	if(checklist_completed_yn=="Y"){
		formObj.checklist_completed_yn.checked=true;
		formObj.checklist_completed_yn.disabled=true;
	}else{
		formObj.checklist_completed_yn.value="N";
		formObj.checklist_completed_yn.checked=false;
		formObj.checklist_completed_yn.disabled=false;
	}
	formObj.order_type_code.value = pat_dtls_arr[11];
	formObj.ordered_date.value = pat_dtls_arr[12];
}
function clearSearchCriteria(formObj){
	clearFields(formObj);
	parent.f_details.location.href="../../eCommon/html/blank.html";
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	formObj.Search.disabled=false;
}
function clearFields(formObj){
	formObj.order_id.value="";
	formObj.ordered_date.value="";
	formObj.order_type_code.value="";
	formObj.patient_id.value="";
	formObj.patient_name.value="";
	formObj.sex.value="";
	formObj.dob.value="";
	formObj.patient_class.value="";
	formObj.patient_class_desc.value="";
	formObj.encounter_id.value="";
}

function getPatientDetails(facility_id,order_id){
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var url="ExamsCheckListValidation.jsp?facility_id="+facility_id+"&order_id="+order_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",url,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	return responseText;
}
function searchCheckList(){
	var formObj = document.ExamCheckListHeaderForm;
	var params			=	formObj.params.value;
	var order_id		=	formObj.order_id.value;
	var patient_id		=	formObj.patient_id.value;
	var order_type_code	=	formObj.order_type_code.value;
	var encounter_id	=	formObj.encounter_id.value;
	var data_exists		=	formObj.data_exists.value;
	var checklist_completed_yn	= formObj.checklist_completed_yn.value;
	if(order_id==null || order_id==""){
		//alert("Order Id to be selected");
		//alert(getMessage("APP-OT0048"));
		var msg_1 = getOTMessage("CANNOT_BE_BLANK");
		var msgArr = msg_1.split("#");
		alert(msgArr[0]+" Order ID "+msgArr[1]);
		formObj.Search.disabled=false;
	}else{
		formObj.Search.disabled=true;
		parent.f_details.location.href="../../eOT/jsp/ExamsCheckListResultFrames.jsp?"+params+"&order_id="+order_id+"&patient_id="+patient_id+"&order_type_code="+order_type_code+"&encounter_id="+encounter_id+"&data_exists="+data_exists+"&checklist_completed_yn="+checklist_completed_yn;
	}
}
async function openCheckListRemarksWindow(rownum){
	var formObj = document.ExamsCheckListResultsForm;
	var checklist_completed_yn = formObj.checklist_completed_yn.value;
	var remarks_title = "Remarks for "+eval("formObj.description_"+rownum).value;
	var order_id = formObj.order_id.value;
	var old_remarks = eval("formObj.old_remarks_"+rownum).value;
	var new_remarks = eval("formObj.new_remarks_"+rownum).value;
	var dialogHeight	= "27";
	var dialogWidth		= "38";
	var dialogTop		= "110";
	var dialogLeft		= "350";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	var retVal = await window.showModalDialog("../../eOT/jsp/ExamsCheckListRemarks.jsp?order_id="+order_id+"&remarks_title="+remarks_title+"&old_remarks="+old_remarks+"&new_remarks="+new_remarks+"&checklist_completed_yn="+checklist_completed_yn,arguments, features);
	if(retVal!=null && retVal!="undefined" && retVal!="null")
		eval("formObj.new_remarks_"+rownum).value = retVal;
}
function assignNewRemarks(){
	var formObj = document.ExamsCheckListRemarksForm;
	window.returnValue = formObj.new_remarks.value;
	window.close();
}
function assignCheckBoxValue(row_num){
	var formObj = document.ExamsCheckListResultsForm;
	var checkboxObj = eval("formObj.checkbox_"+row_num);
	if(checkboxObj.checked==true)
		checkboxObj.value="Y";
	else
		checkboxObj.value="N";
}
async function assignConfirm(obj,user_id){
	if(obj.checked==true){
		var dialogHeight= "3" ;
		var dialogWidth	= "19" ;
		var dialogTop = "210" ;
		var dialogLeft = "220" ;
		var center = "1" ;
		var status="no";
		var scroll="no";
		var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var retVal = await window.showModalDialog("../../eOT/jsp/VerifyCheckListPIN.jsp?user_id="+user_id,arguments,features);
		var formObjHdr = parent.parent.frames.f_header.ExamCheckListHeaderForm;
		var checklist_formObj = document.ExamsCheckListConfirmForm;		
		if(retVal=="false" || retVal=="undefined"){
			formObjHdr.checklist_completed_yn.value="N";
			checklist_formObj.confirm_yn.value="N";
			obj.checked=false;
			obj.value="N";
		}else if(retVal=="true"){
			formObjHdr.checklist_completed_yn.value="Y";
			checklist_formObj.confirm_yn.value="Y";
			obj.value="Y";
		}
	}
}
