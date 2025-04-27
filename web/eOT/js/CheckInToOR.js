/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function checkTimeFormat(obj){
	if(obj.value!=null && obj.value!=""){
		var retVal = chkTime(obj.value);
		if(retVal==false){
			alert(getMessage("VALID_TIME_SLOTS","OT"));		
			obj.focus();
			obj.select();
			return;
		}
		var formObj = document.CheckInToORForm;
		var locale = formObj.locale.value;
		var obj_date_time = dateUtils(formObj.checked_in_date.value,locale)+" "+obj.value;
		var database_system_date_time = dateUtils(getSysDateTime(),locale,'DMYHM');
		var retVal = compareDates(obj_date_time,database_system_date_time,"en","DMYHM"); // small, greater
		if(retVal==false){
			//alert("Checkin time should be < system date and time");		
			//alert(getMessage("APP-OT0044"));
			var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
			var msgArr = msg_1.split("#");
			var checkin_time=getLabel("eOT.CheckInTime.Label","OT");
			var systemdatetime =getLabel("Common.SystemDateTime.label","Common");
			alert(msgArr[0]+ checkin_time +msgArr[1]+ systemdatetime +msgArr[2]);
			obj.focus();
			obj.select();
			return;
		}
	}	
}


function ValidateCheckInDate(){
	var formObj=document.frames.CheckInORFrame.document.CheckInToORForm;
	var locale = formObj.locale.value;
	//commented below line on 12/16/2010 for 25523 by Anitha
	//var check_out_holding_area_time = dateUtils(formObj.check_out_holding_area_time.value,locale);
	//var obj_date_time = formObj.cur_date.value+" "+obj.value;
	var check_out_holding_area_time = (formObj.check_out_holding_area_time.value);
	var obj_date_time = dateUtils(formObj.checked_in_date.value)+" "+formObj.checked_in_time.value;
	obj_date_time = convertDate(obj_date_time,'DMYHM',locale,"en")

	if(check_out_holding_area_time!=""){ 
	  var retVal = compareDates(check_out_holding_area_time,obj_date_time,"en","DMYHM"); // small, greater	
	  if(retVal==false){
			return false;
	   }else 
			return true
	}else
		return true;
}
function ValidateCheckInDate1(){
	var formObj=document.frames.CheckInORFrame.document.CheckInToORForm;
	var locale = formObj.locale.value;
	var check_in_time = formObj.check_in_time.value;
	
	//var obj_date_time = formObj.cur_date.value+" "+obj.value;
	var obj_date_time = formObj.checked_in_date.value+" "+formObj.checked_in_time.value;
	obj_date_time = convertDate(obj_date_time,'DMYHM', locale, "en");
	
	if(check_in_time!="")
	{
	  return compareDates(check_in_time,obj_date_time,"en","DMYHM"); // small, greater	
	}
	else
		return true;
}


function  reset(){
	var formObj=document.frames.CheckInORFrame.document.CheckInToORForm;
	formObj.reset();
	document.frames.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}

function getSysDateTime(){
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var temp_jsp="HoldingAreaValidation.jsp?func_mode=getSysDateTime";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		return trimString(responseText);
}

function apply(){
	formObj = document.frames.CheckInORFrame.document.CheckInToORForm;
	var formObjHdr=document.frames.common_patient_hdr_frame.document.CommonOperDtlsHdrForm;//PMG2016-KDAH-CRF-0001
	
	var locale = formObj.locale.value;
	var no_of_verifications = parseInt(formObj.no_of_verifications.value);
	var check_for_check_list_compl = formObj.check_for_check_list_compl.value;
	var checklist_flag = "true";
	if(check_for_check_list_compl=="Y"){
		if(formObj.checklist_completed_yn.value=="N" && no_of_verifications>2){
			checklist_flag = "false";
			var msg1 = getMessage("INCOMPLETE_CHECKLIST","OT");
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg1;
		}
	}
	//Added Newly By MuthuN on 3/8/2013 against 38347
	var chkdInDate = formObj.checked_in_date.value;	
	var enConvertDate = convertDate(chkdInDate,"DMY",locale,"en");
	var dateArr = enConvertDate.split("/");
	var date1 = new Date(dateArr[2],dateArr[1]-1,dateArr[0]);
	var today = new Date();	
	if(date1>today){
						msg1 = getMessage("DATE_NOT_GREATER_SYSDATE","Common");
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg1;
						return false;
					}
	//Added Newly By MuthuN on 3/8/2013 against 38347
	
	//PMG2016-KDAH-CRF-0001 starts
	var multi_check_in_yn=formObj.multi_check_in_yn.value;

	if(multi_check_in_yn=="N"){
	var checked_in_time=formObj.checked_in_time.value;
	var check_in_date_time=enConvertDate+" "+checked_in_time;
	var oper_room_code=formObjHdr.theatre_code.value;
	var facility_id=formObj.facility_id.value;
	var oper_num=formObj.oper_num.value;	
	var isOTVaccant=isOTAvailable(check_in_date_time,oper_room_code,facility_id,oper_num,'Check_In_OR');
	
	if(isOTVaccant!=""){
		var msg=getMessage("APP-OT0238","OT");
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
		return false;
	}
	}
	//PMG2016-KDAH-CRF-0001 ends
	
	if(checklist_flag == "true"){
		if(CheckMandatoryFields()){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var cur_date = dateUtils(formObj.checked_in_date.value,locale);
			var xmlStr ="<root><SEARCH ";
			xmlStr += "oper_num=\""+ formObj.oper_num.value +  "\" ";
			xmlStr += "change_date_time=\""+cur_date+" "+formObj.checked_in_time.value  + "\" ";
			xmlStr += "slate_user_id=\""+ formObj.slate_user_id.value  + "\" ";
			xmlStr +=" /></root>";
			//alert(xmlStr);
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","HoldingAreaValidation.jsp?func_mode=updateAndCommitCheckinToORDtls",false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			//if(retVal!=null && retVal!=""){//Commented Against AAKH-SCF-0465
			if(retVal!=null && retVal!="" && retVal!="null"){  //Modified Against AAKH-SCF-0465
				if(retVal == "RECORD_INSERTED"){
					 alert(getMessage("RECORD_INSERTED","SM"));
					window.returnValue="RECORD_INSERTED";   
					window.close();
				}else
					alert(retVal);
			}
			else{	//Added Against AAKH-SCF-0465
				window.close();
			}
		}
	}
}

function CheckMandatoryFields(){
	var submitflag = 'false';
	var messageFrame = parent.parent.messageFrame;
	var formObj =  document.frames.CheckInORFrame.document.CheckInToORForm;
	var fields= new Array(formObj.checked_in_time);
	var names=new Array("Checked In Date Time");
	var locale = formObj.locale.value;
	parent.parent.frames[0].location.href="../../eCommon/jsp/commonToolbar.jsp?module_id=OT&function_type=F&menu_id=26&access=NYNNY&home_required_yn=N&function_id=OT_CHECKIN_TO_OR&function_name=Check-In%20to%20OR&called_from=OT_SLATE";

	if(checkFields(fields,names,messageFrame)){
		submitflag=true;
	}else{
		submitflag=false;
	}
	if(submitflag==true){
		if(ValidateCheckInDate()==false){
			var msg = getMessage("APP-OT0158","OT")
			//msg=msg+" "+formObj.check_out_holding_area_time.value;
			//Added convertDate below for 25523 by Anitha on 12/16/2010
			msg=msg+" "+convertDate(formObj.check_out_holding_area_time.value,'DMYHM','en',locale);
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
			submitflag=false;
		}else
		{
			if(ValidateCheckInDate1()==false)
			{
			var msg = getMessage("APP-OT0159","OT")
			var checkInLocale = convertDate(formObj.check_in_time.value,'DMYHM', "en", locale);
			msg=msg+" "+ checkInLocale;
			
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
			submitflag=false;
			}else
			{
			submitflag=true;
			}
		}
		}
	return submitflag;
}

/*function funsubmitCheckInDtls(checklists){
	var formObj = document.CheckInToORForm;	
	var order_id = formObj.order_id.value;

	var checklist_arr = checklists.split("##");
	var verify_checklist_codes = "&verify_checklist_code_1="+checklist_arr[0];
	var count=1;
	for(i=1;i<checklist_arr.length;i++){
		count++;		verify_checklist_codes+=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i];
	}
	var booking_or_oper_flag = "B";
	if(order_id!=null && order_id!="null" && order_id!="")
			booking_or_oper_flag = "ORD";
	var checklist_completed_yn = formObj.checklist_completed_yn.value;
	var old_checklist_user_id = (formObj.old_checklist_user_id.value).toUpperCase();
	var slate_user_id = (formObj.slate_user_id.value).toUpperCase();
	var disable_checklist_fields = "N";
	var access="NYNNY";
	if(old_checklist_user_id!="" && old_checklist_user_id!="null" && old_checklist_user_id!="NULL"){
		if(slate_user_id.toUpperCase()!=old_checklist_user_id.toUpperCase()){
			disable_checklist_fields = "disabled"
			access="NNNNN";
		}
	}
	if(checklist_completed_yn=="Y"){
		disable_checklist_fields = "disabled"
		access="NNNNN";
	}
	var viewchecklist_legend = encodeURIComponent(getLabel("eOT.ViewCheckList.Label","OT"));	

	var db_param_1="module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access="+access+"&home_required_yn=N";
	var function_string = "&function_id=OT_CHECK_LIST&function_name="+viewchecklist_legend;
	var db_param = db_param_1 + function_string;
	var url_desc = "VerifyCheckListMain.jsp";
	var url = url_desc+"?"+db_param+"&called_from=OT_CHECKIN_TO_OR&patient_id="+formObj.patient_id.value+"&slate_user_id="+slate_user_id+verify_checklist_codes+"&checklist_codes_count="+count+"&checklist_stage=C30&pre_or_post=P&booking_or_oper_flag="+booking_or_oper_flag+"&no_of_verifications="+formObj.no_of_verifications.value+"&user_id="+slate_user_id+"&role_id_1="+formObj.role_id_1.value+"&role_id_2="+formObj.role_id_2.value+"&role_id_3="+formObj.role_id_3.value+"&role_id_4="+formObj.role_id_4.value+"&order_id="+order_id+"&booking_num="+formObj.booking_num.value+"&oper_num="+formObj.oper_num.value+"&disable_checklist_fields="+disable_checklist_fields+"&invoked_from=CHECKINTOOR";
	alert(url);
	var retVal;
	var dialogHeight = "40" ;
	var dialogWidth  = "52" ;
	var dialogTop    = "200";
	var dialogLeft   = "100";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;

	var arguments    = "" ;

	retVal 	   = window.showModalDialog(url, arguments, features);
	if(retVal==null){
	}else if(retVal=="undefined" || retVal=='undefined'){
	}else if(retVal!="null" && retVal!="" && retVal!="Y"){
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+retVal;
	}else if(retVal!="null" && retVal!="" && retVal=="Y"){
		formObj.checklist_completed_yn.value = "Y";
	}else
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}*/

//added by subramanian on 10/07/2005
function validatePatientConsent(){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var order_id = formObj.order_id.value;
	if(order_id!="" && order_id!= null  ){
		var xmlStr ="<root></root>";
		var temp_jsp="TempConsentValidation.jsp?patient_id="+patient_id+"&order_id="+order_id;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=trimString(xmlHttp.responseText);
		//alert(responseText);
		if( responseText!="ORDER_ID_NULL" && responseText!="CONSENT_NOT_REQUIRED" && responseText!="CONSENT_TAKEN" ){
			alert(responseText);
			window.close();
		}
	}
}
