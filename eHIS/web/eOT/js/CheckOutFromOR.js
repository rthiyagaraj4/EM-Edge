/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var units="";
var serv_code="";
var message2 = "";
function reset(){
	var formObj = parent.document.frames.recovery_frame.document.CheckOutFromORForm;
	var params = "";
	if(formObj!=null)
	params = formObj.params.value;
	recovery_frame.document.location.href="../../eOT/jsp/CheckOutFromOR.jsp?"+params;
	window.frames[7].frames[1].document.location.reload();
	messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}

function CheckMandatoryFields(){
	var formObj = parent.document.frames.recovery_frame.document.CheckOutFromORForm;
	var messageFrame= parent.document.frames.messageFrame;	
}

function CheckMandatoryFlds(){
	var formObj = parent.document.frames.recovery_frame.document.CheckOutFromORForm;
	var messageFrame= parent.document.frames.messageFrame;
	var transfer_to = formObj.transfer.value;
	var TransferDate =getLabel("Common.transferdate.label","Common");
	var	TransferTime = getLabel("eOT.CheckOutFromORDateTime.Label","OT");
	var ward="";
	if(transfer_to=="W"){
		ward=getLabel("Common.Ward.label","Common");
	}else{
		ward=getLabel("eOT.RecoveryRoom.Label","OT");
	}
	
	if(transfer_to=="W" || transfer_to=="R"){
		var fields= new Array(formObj.check_out_date,formObj.check_out_time_or,formObj.ward_code);
		//var names=new Array("Transfer Date","Transfer Time","Ward");
		var names=new Array(TransferDate,TransferTime,ward);
	}else{
		var fields= new Array(formObj.check_out_date,formObj.check_out_time_or);
		var names=new Array(TransferDate,TransferTime);
	}

	if(checkFields(fields,names,messageFrame)==false){
		return false;
	}else 
		return true;
}

function validateTransferTime(){
	var flag=true;
	var formObj = parent.document.frames.recovery_frame.document.CheckOutFromORForm;
	var messageFrame= parent.document.frames.messageFrame;
	return flag;
}

function loadRecTime(){
//	var formObjHdr = parent.document.frames.common_patient_hdr_frame.document.CommonOperDtlsHdrForm;
//	var formObj = document.forms[0];
//
//	var transfer_to = formObjHdr.transfer_to.value;
//	var transfer_ward_code = formObjHdr.transfer_ward_code.value;
//	var transfer_status =formObjHdr.transfer_status.value;
//
//	
//	if(transfer_to.length>0){
//		document.forms[0].transfer.value=formObjHdr.transfer_to.value;
//		flag="SECOND"
//	}else{
//		document.forms[0].transfer.value="W"
//		flag = "FIRST"
//	}
//	if(transfer_to=="W" && flag!="FIRST" ){
//		document.forms[0].ward_code.value = transfer_ward_code;
//		document.forms[0].ward_desc.value = getTransferDesc(transfer_ward_code); 
//
//		if(transfer_status == "")
//			document.forms[0].status.value == "";
//		}
//		else{
//			document.forms[0].status.value = formObjHdr.transfer_status.value;
//		}
//		disableWardAndStatus();
//	}
//	
//	else{
//		document.forms[0].ward_code.value = "";
//		document.forms[0].ward_desc.value = "";
//		document.forms[0].status.value = "";
//		disableWardAndStatus();
//	}
}

function getTransferDesc(code){
	var xmlStr ="<root></root>";
	var temp_jsp="ChkInOutRecoveryValidation.jsp?func_mode=transfer_desc&transfer_ward_code="+code;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return responseText;
}

function getclinicTransferDesc(code){
	var xmlStr ="<root></root>";
	var temp_jsp="ChkInOutRecoveryValidation.jsp?func_mode=transferclinic_desc&transfer_ward_code="+code;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return responseText;
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message2  = _message ;
	flag = _flag ;
}

function apply(){
	var formObj = parent.document.frames.recovery_frame.document.CheckOutFromORForm;	
	var params = formObj.params.value;
	parent.document.frames.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?"+params;
	var called_from = formObj.called_from.value;
	var check_for_check_list_compl = formObj.check_for_check_list_compl.value;
	var checklist_flag = "true";
	var oper_room_code=formObj.oper_room.value;
	var oper_num=formObj.oper_num.value;
	var facility_id=formObj.facility_id.value;
	
	formObj.or_bill_accession_num.value=oper_num+"OR"+oper_room_code;
	if(formObj.transfer.value !="R")
	{
		if(check_for_check_list_compl=="Y"){
			 if(formObj.checklist_completed_yn.value=="N"){
				checklist_flag = "false";
				var msg = getMessage("INCOMPLETE_CHECKLIST","OT");
				parent.document.frames.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
			 }
	}
}
	var chk_out_or_date=formObj.check_out_date.value;
	var check_out_time_or=formObj.check_out_time_or.value;
	//Added Against PMG2016-KDAH-CRF-0001	starts
	var chk_out_from_or_date_time=chk_out_or_date+" "+check_out_time_or;
	var multi_check_in_yn=formObj.multi_check_in_yn.value;
	if(multi_check_in_yn=="N"){
	var isOTFree=isOTAvailable(chk_out_from_or_date_time,oper_room_code,facility_id,oper_num,'Check_Out_From_OR');
	
	if(isOTFree!=""){
		var msg=getMessage("APP-OT0237","OT");
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
		return false;
	}
	}
	//Added Against PMG2016-KDAH-CRF-0001 ends	
	if(chk_out_or_date!="" && check_out_time_or==""){
		var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.CheckOutFromORDateTime.Label","OT"));
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg1;	
		return false;
	}
	//End of checking for VeriCheckList Function 
	if(checklist_flag == "true"){
		var apply_flag = "true";
		 if(formObj.check_out.checked==true && formObj.transfer.value!="M"){
			 if( CheckMandatoryFlds() && validateCheckedOutTime() && validateTransferTime() ){
				if(formObj.check_out_time.value==""){
					apply_flag="false";
					var message = "Check Out Time cannot be empty";
					parent.document.frames.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
				}			
			 }else 
				apply_flag="false";
		}
		 // if checkbox is not checked, we need not apply the transaction.
		//mandatory fields check added by bala on 13/06/2005
		//end of mandatory fields check added by bala on 13/06/2005
		
		 if(apply_flag=="true"){
			 submitSpecimenDetails();
			 formObj.check_out_time.disabled = "";
			// retVal = formApply(formObj,OT_CONTROLLER);
			 retVal = formApply(formObj,OT_CONTROLLER);
			 eval(retVal);
		
			 if(called_from=="OT_SLATE"){				
				window.returnValue=getMessage("RECORD_INSERTED","SM");				
				//window.returnValue="RECORD_INSERTED SUCCESSFULLY....,";
				if(message2 == "RECORD_INSERTED") 
					alert(window.returnValue);
				else
					alert(message2);
				window.close();
			 }else{ // this code is used when it is called from OT_MENU...temporarily not used
				parent.document.frames.recovery_frame.document.location.href="../../eOT/jsp/ChkOutFromOR.jsp?"+params;				
        parent.document.frames.result_frame.document.location.href="../../eCommon/html/blank.html";
				parent.document.frames.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
			 }				
		 }
	 }
}

function beforePost(str){
}

function submitSpecimenDetails(){
	frmObj = parent.document.frames.ObjectCollect;
	rows = parent.document.frames.ObjectCollect.specimen_rows;
	var formObj = parent.document.frames.recovery_frame.document.CheckOutFromORForm;
	if(formObj!=null)
		var params = formObj.params.value;
	if( isModified(rows) ){
		var action="../../servlet/eOT.RecordNursingServlet?"+params;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root>";
		xmlStr+=frmObj.createXMLForSpecimenDtls();
		xmlStr+="</root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",action,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
  }
}

//added by subramanian 09/08/2005
function isModified(rows){
	var modified_flag=false;
	if(rows.length>0){
		for(var i=0;i<rows.length;i++){
			if(rows[i]!=null){
				if(rows[i].db_mode!='L'){
					modified_flag=true;
					break;
				}
			} 
			continue;
		}
	}
	return modified_flag;
}

function validateCheckedOutTime(){
	var formObj = parent.document.frames.recovery_frame.document.CheckOutFromORForm; 
	var locale=formObj.locale.value;
	var transfer_date=formObj.check_out_date.value;
	var transfer_time=formObj.check_out_time_or.value;
	var flag=true;
	var cur_date = getSysDate();
	var systime = trimString(getSysDateTime());
	var check_out_time = transfer_date+" "+transfer_time;
	var error = "";
	var retVal2 =  compareDates(check_out_time,systime,"en","DMYHM");
	if(retVal2==false){
		var msg = " Check-Out Date and Time should be Lesser Than System Date and Time"+"<br>";
		error = msg;
		flag = false;
	}
	if(retVal2==true){
		var chk_out_date=formObj.check_out_date.value;
		var chk_out_time=formObj.check_out_time_or.value;
		var chk_out_dt_time=chk_out_date+" "+chk_out_time;
		var check_in_dt_time=formObj.check_in_dt_time.value;
		var bl_interface_flag=formObj.bl_interface_flag.value;
		var charge_operating_room_yn=formObj.charge_operating_room_yn.value;
		if(!isAfter(chk_out_dt_time,check_in_dt_time,"DMYHM",locale)){
			var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
			var msgArr = msg_1.split("#");
			var checkin_time = getLabel("eOT.CheckinToORDateTime.Label","OT");
			var chk_out_dt_time =getLabel("eOT.CheckOutFromORDateTime.Label","OT");
			var err_msg=msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2];
			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+err_msg;
			formObj.check_out_time_or.value="";
			if(bl_interface_flag=="Y" && charge_operating_room_yn=="Y"){
				formObj.charge_units.value="";
				//formObj.all.cashcounter_desc.innerText="";
				//document.getElementById("charge_details_1").style.visibility='hidden';
				document.getElementById("charge_details_1").style.display='none';
			}
			return false;
		}
	}
	if(error.length>0)		
    parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+error;
  return flag;
}

function checkTimeValidity(obj){
	if(obj.value!=null && obj.value!=""){
		var retVal = chkTime(obj.value);
		if(retVal==false){
			alert(getMessage("VALID_TIME_SLOTS","OT"));		
			//obj.focus();
			obj.select();
		}
	}
}

function validateDate(obj){
	var formObj=document.forms[0];
	var locale = document.forms[0].locale.value;
	if(obj.value!=""){
		if(!validDate(obj.value,'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.select();
			return false;
		}else{
			return true;
		}
			
	}
}

function assingTime(obj){
	if(obj.value=="")
	obj.value = trimString(getSysTime());
}

function getSysDateTime(){
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="ChkInOutRecoveryValidation.jsp?func_mode=getSysDateTime";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return trimString(responseText);
}

function getSysDate(){
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="ChkInOutRecoveryValidation.jsp?func_mode=getSysDate";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return trimString(responseText);
}

function getSysTime(){
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="ChkInOutRecoveryValidation.jsp?func_mode=getSysTime";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	return trimString(responseText);
}

/* Added start against for MO-GN-5505 [IN058517] */
function getCustomer(){
	formObj = document.CheckOutFromORForm;
	var facility_id = formObj.facility_id.value; 
	var oper_num =  formObj.oper_num.value; 
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="CommonValidation.jsp?func_mode=getCustomerId&facility_id="+facility_id+"&oper_num="+oper_num;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	return trimString(responseText);
	}
	/* Added end against for MO-GN-5505 [IN058517] */
	
function validateCheckBox(){
	formObj = document.CheckOutFromORForm;
	var check_out = formObj.check_out;
	/* Added start against for MO-GN-5505 [IN058517] */
 	var customer_id =  formObj.customer_id.value; 
	if(customer_id == "MODOM" || customer_id == "MOD")
	{
		var status = getCustomer();
		if(status == "false" ){
		alert("Please Enter the Personnel details in the Record Surgeon Notes");
		check_out.checked = false;
		}
	}
	/* Added end against for MO-GN-5505 [IN058517] */	
	if(check_out.checked){
		formObj.check_out_time.disabled=false;
		formObj.check_out_time.value =trimString(getSysTime());
		formObj.check_out_flag.value="Y";
		formObj.img1.src="../../eCommon/images/mandatory.gif";			
		formObj.img2.src="../../eCommon/images/mandatory.gif";			
		formObj.img3.src="../../eCommon/images/mandatory.gif";			
	}else{
		formObj.check_out_time.value='';
		formObj.check_out_flag.value="N";
		formObj.check_out_time.disabled=true;
		formObj.img1.src="../../eCommon/images/Blank1.gif";	
		formObj.img2.src="../../eCommon/images/Blank1.gif";	
		formObj.img3.src="../../eCommon/images/Blank1.gif";	
	}	
}

async function searchAnatomicalSite(obj,target){
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	obj.value='';
	target.value='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var tit="";				
	if(target.name == desc_name){
		tit="Anatomical Site Search";
		var sql="SELECT SHORT_DESC description, ANATOMICAL_SITE_CODE code FROM AM_ANATOMICAL_SITE WHERE NVL(EFF_STATUS,'E') = 'E'  and upper(SHORT_DESC) like upper(?) and upper(ANATOMICAL_SITE_CODE) like upper(?) order by 2";
	}
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == desc_name){
			obj.value = arr[0];
			document.forms[0].target.disabled=true;
		}
	}else{
		target.value=tdesc;
		obj.value=tcode;
	}
}

async function searchDisposal(obj,target){
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	obj.value='';
	target.value='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var tit="";				
	if(target.name == desc_name){
		tit="Disposal Search";
		var sql="SELECT DISPOSAL_DESC DESCRIPTION, DISPOSAL_CODE CODE FROM OT_ORGAN_DISPOSAL WHERE NVL(STATUS,'E') = 'E'  and upper(DISPOSAL_DESC) like upper(?) and upper(DISPOSAL_CODE) like upper(?) order by 2";
	}
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == desc_name){
			obj.value = arr[0];
			document.forms[0].target.disabled=true;
		}
	}else{
		target.value=tdesc;
		obj.value=tcode;
	}
}

async function searchUnusalOccurance(obj,target){
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var tit="Unusal Occur Search";
	var sql="SELECT SHORT_DESC description, UNUSUAL_OCCUR_CODE code FROM OT_UNUSUAL_OCCUR_CODE WHERE NVL(STATUS,'E') = 'E'  and upper(SHORT_DESC) like upper(?) and upper(UNUSUAL_OCCUR_CODE) like upper(?) order by 2";
	
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value=tdesc;
		obj.value=tcode;
	}
}

function checkLimit(field, limit)
{
 if (field.value.length > limit)
  {
   alert(limit+' characters only allowed');
    var revertField = field.value.slice(0, limit-1);
   field.value = revertField;
   field.focus();
  }

}

function isRecordVitalEnable(){
 var formObj = parent.tab_frame.CheckInRecoveryTabForm;
 var discr_msr_id  = formObj.discr_msr_id.value;
 if(discr_msr_id==null ||  discr_msr_id ==""){
	  formObj.record_vitals.disabled=true;
 }
}

function callRecordVitals(){
	var formObj =  parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var formObjDtl=parent.recovery_frame.CheckOutFromORForm;
	var speciality_code = formObj.speciality_code.value;
	var discr_msr_id  = formObj.discr_msr_id.value;
	var facility_id = formObjDtl.facility_id.value;
	var patient_id = formObj.patient_id.value;
	var episode_id = formObj.episode_id.value;
	var sex = formObj.sex.value;
	var dob = formObj.date_of_birth.value;
	var encounter_id = formObj.encounter_id.value;
	var patient_class = formObj.patient_class.value;
	var episode_type = formObj.episode_type.value;
	var window_name = patient_id+encounter_id;
	var date_time = trimString(getSysDateTime());
	 var url='../../eCA/jsp/ChartRecording.jsp?patient_id='+patient_id+'&function_from=CP&p_start_date_time='+date_time+'&Chart_Id='+discr_msr_id+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id+"&module_id=OT";
	var retVal;
	var dialogHeight = window.screen.availHeight-28 ;
	var dialogWidth  = window.screen.availWidth-10 ;
	var dialogTop    = "0";
	var dialogLeft   = "0";
	var features = "Height=" + dialogHeight + ",Width=" + dialogWidth+ ", left="+dialogLeft+",top="+dialogLeft+",status=no,resizable=no";
	var arguments    = "" ;
	//retVal  = window.showModalDialog(url, arguments, features);
	retVal  = window.open(url, arguments, features);
 }

async function funsubmitCheckInDtls(checklists){
	var formObj = document.CheckOutFromORForm;	
	var chk_params = formObj.params.value;
	var no_of_verifications = formObj.no_of_verifications.value;

	var checklist_stage = "";
	var post_oper_user1_completed_yn = formObj.post_oper_user1_completed_yn.value;
	var post_oper_user2_completed_yn = formObj.post_oper_user2_completed_yn.value;
	var post_oper_user3_completed_yn = formObj.post_oper_user3_completed_yn.value;
	var post_oper_user4_completed_yn = formObj.post_oper_user4_completed_yn.value;

	if(no_of_verifications > 0 && post_oper_user1_completed_yn=="N")
		checklist_stage="C50";		
	else if(no_of_verifications > 1 && post_oper_user2_completed_yn=="N")
		checklist_stage="C60";		
	else if(no_of_verifications > 2 && post_oper_user3_completed_yn=="N")
		checklist_stage="C70";		
	else if(no_of_verifications > 3 && post_oper_user4_completed_yn=="N")
		checklist_stage="C80";		

	var order_id = formObj.order_id.value;
	var checklist_arr = checklists.split("##");
	var verify_checklist_codes = "&verify_checklist_code_1="+checklist_arr[0];
	var count=1;
	for(i=1;i<checklist_arr.length;i++){
		count++;		
		//verify_checklist_codes+=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i];
		verify_checklist_codes=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i]; //Modified Against AAKH-SCF-0478
	}
	var booking_or_oper_flag = "B";
	if(order_id!=null && order_id!="null" && order_id!="")
			booking_or_oper_flag = "ORD";

	var old_post_oper_user1_id = (formObj.old_post_oper_user1_id.value).toUpperCase();
	var old_post_oper_user2_id = (formObj.old_post_oper_user2_id.value).toUpperCase();
	var old_post_oper_user3_id = (formObj.old_post_oper_user3_id.value).toUpperCase();
	var old_post_oper_user4_id = (formObj.old_post_oper_user4_id.value).toUpperCase();

	var slate_user_id = (formObj.slate_user_id.value).toUpperCase();
	var disable_checklist_fields = "N";
	var access="NYNNY";
	if(checklist_stage=="C50"){
		if(old_post_oper_user1_id!=null && old_post_oper_user1_id!="" && old_post_oper_user1_id!="null" && old_post_oper_user1_id!="NULL"){
			if(slate_user_id.toUpperCase()!=old_post_oper_user1_id.toUpperCase()){
				disable_checklist_fields = "disabled"
				access="NNNN";
			}
		}
	}else if(checklist_stage=="C60"){
		if(old_post_oper_user2_id!=null && old_post_oper_user2_id!="" && old_post_oper_user2_id!="null" && old_post_oper_user2_id!="NULL"){
			if(slate_user_id.toUpperCase()!=old_post_oper_user2_id.toUpperCase()){
				disable_checklist_fields = "disabled"
				access="NNNNN";
			}
		}
	}
	if(checklist_stage=="C70"){
		if(old_post_oper_user3_id!=null && old_post_oper_user3_id!="" && old_post_oper_user3_id!="null" && old_post_oper_user3_id!="NULL"){
			if(slate_user_id.toUpperCase()!=old_post_oper_user3_id.toUpperCase()){
				disable_checklist_fields = "disabled"
				access="NNNNN";
			}
		}
	}
	if(checklist_stage=="C80"){
		if(old_post_oper_user4_id!=null && old_post_oper_user4_id!="" && old_post_oper_user4_id!="null" && old_post_oper_user4_id!="null"){
			if(slate_user_id.toUpperCase()!=old_post_oper_user4_id.toUpperCase()){
				disable_checklist_fields = "disabled"
				access="NNNNN";
			}
		}
	}

	var checklist_completed_yn = formObj.checklist_completed_yn.value;
	if(checklist_completed_yn=="Y"){
		disable_checklist_fields = "disabled"
		access="NNNNN";
	}
	var db_param_1="module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access="+access+"&home_required_yn=N";
	var function_string = "&function_id=OT_CHECK_LIST&function_name=Verify Checklist";
	var db_param = db_param_1 + function_string;
	var url_desc = "VerifyCheckListMain.jsp";
	var url = url_desc+"?"+db_param+"&called_from=OT_SLATE&patient_id="+formObj.patient_id.value+"&slate_user_id="+slate_user_id+verify_checklist_codes+"&checklist_codes_count="+count+"&checklist_stage="+checklist_stage+"&pre_or_post=O&booking_or_oper_flag="+booking_or_oper_flag+"&no_of_verifications="+no_of_verifications+"&user_id="+slate_user_id+"&role_id_1="+formObj.role_id_1.value+"&role_id_2="+formObj.role_id_2.value+"&role_id_3="+formObj.role_id_3.value+"&role_id_4="+formObj.role_id_4.value+"&order_id="+order_id+"&booking_num="+formObj.booking_num.value+"&oper_num="+"&disable_checklist_fields="+disable_checklist_fields;
	var retVal;
	var dialogHeight = "94" ;
	var dialogWidth  = "445" ;
	var dialogTop    = "790";
	var dialogLeft   = "100";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;

	var arguments    = "" ;
	alaert(url)
	retVal 	   = await window.showModalDialog(url, arguments, features);
	if(retVal==null){
	}else if(retVal=="undefined" || retVal=='undefined'){
	}else if(retVal!="null" && retVal!="" && retVal!="Y"){
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+retVal;
	}else if(retVal!="null" && retVal!="" && retVal=="Y"){
		if(no_of_verifications > 0 && checklist_stage=="C50" ){
			formObj.post_oper_user1_completed_yn.value="Y";
			formObj.old_post_oper_user1_id.value = slate_user_id;
		}else if(no_of_verifications > 1 && checklist_stage=="C60" ){
			formObj.post_oper_user2_completed_yn.value="Y";
			formObj.old_post_oper_user2_id.value = slate_user_id;
		}else if(no_of_verifications > 2 && checklist_stage=="C70" ){
			formObj.post_oper_user3_completed_yn.value="Y";
			formObj.old_post_oper_user3_id.value = slate_user_id;
		}else if(no_of_verifications > 3 && checklist_stage=="C80" ){
			formObj.post_oper_user4_completed_yn.value="Y";		
			formObj.old_post_oper_user4_id.value = slate_user_id;
		}

		if(no_of_verifications==1 && checklist_stage=="C50")
			formObj.checklist_completed_yn.value = "Y";
		else if(no_of_verifications==2 && checklist_stage=="C60")
			formObj.checklist_completed_yn.value = "Y";
		else if(no_of_verifications==3 && checklist_stage=="C70")
			formObj.checklist_completed_yn.value = "Y";
		else if(no_of_verifications==4 && checklist_stage=="C80")
			formObj.checklist_completed_yn.value = "Y";
	}else
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}

async function searchWard(obj,target){
	var facility_id = document.forms[0].facility_id.value;
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var ward = document.forms[0].transfer.value;
	if(ward=="W")
	{
		var tit="Ward search";
		var sql="SELECT SHORT_DESC DESCRIPTION, WARD_CODE CODE FROM IP_WARD WHERE FACILITY_ID ='"+facility_id+"' AND STATUS IS NULL AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(WARD_CODE) LIKE UPPER(?) ORDER BY 1";
	}

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value=tdesc;
		obj.value=tcode;
	}
}

function disableWardAndStatus(){
	var formObj = document.forms[0];
	var ward = formObj.transfer.value;
	if(ward=="W" || ward=="R" ){
		formObj.CommonLookUp1.disabled=false;
		formObj.status.disabled=false;
		formObj.ward_code.value="";
		formObj.ward_desc.value="";
		formObj.ward_desc.disabled=false;
	}else {
		formObj.CommonLookUp1.disabled=true;
		formObj.ward_code.value="";
		formObj.ward_desc.value="";
		formObj.ward_desc.disabled=true;
		formObj.status.value="";
		formObj.status.disabled=true;
	}
}

function funRecoveryNotes(){
	var formObj =  parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var title="Recovery Notes";
	var slate_user_id=document.forms[0].slate_user_id.value;
	var facility_id = formObj.facility_id.value;//1
	var patient_id = formObj.patient_id.value;//2
	var episode_id = formObj.episode_id.value;//3
	var patient_class = formObj.patient_class.value;//4
	var encounter_id = formObj.encounter_id.value;//5
	var called_from = "RECOVERY_NOTES";//6
	var accession_num=formObj.oper_num.value;//7
	var speciality_code=formObj.oper_speciality_code.value;//8
	var locn_type = "40";//from Recovery Notes Locn type=40;
	var url = "../../eOT/jsp/SelectNoteTypeFrames.jsp?"+ "facility_id="+facility_id+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&called_from="+called_from+"&accession_num="+accession_num+"&speciality_code="+speciality_code+"&locn_type="+locn_type+"&slate_user_id="+slate_user_id;
	var retVal;
		var arguments    = "" ;
		retVal 	   = window.open(url, arguments, 'height=35,width=300,top=250,left=250,resizable=no');
}

function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

async function srchCommonCode(obj,target,tit,sql){
	var facility_id=document.forms[0].facility_id.value;
	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	returnedValues = await CommonLookup( tit, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		target.value=returnedValues[1];
		obj.value=returnedValues[0];
	}else{
		target.value='';
		obj.value='';
	}	
}

function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789/';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

/*function isValidDate(obj){
	var locale=document.forms[0].locale.value;
	if(obj.value!=""){	
		if(!validDate(obj.value,'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.select();
			return false;
		}else{
			return true;
		}
	}
}*/

function displayCurrTime(){
	var formObj=document.forms[0];
	var curr_time=formObj.current_time.value;
	formObj.check_out_time_or.value=curr_time;
}

function checkORChargeYNValidate(){
	var formObj=document.forms[0];
	var facility_id=formObj.facility_id.value;
	var locale=formObj.locale.value;
	var oper_room=formObj.oper_room.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "facility_id="+facility_id+"&oper_room_code="+oper_room+"&locale="+locale;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OperRoomChargeUnits.jsp?func_mode=checkORChargeYN&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	return retVal;
}

function checkORChargeYN(){
	var formObj=document.forms[0];
	var facility_id=formObj.facility_id.value;
	var locale=formObj.locale.value;
	var oper_room=formObj.oper_room.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "facility_id="+facility_id+"&oper_room_code="+oper_room+"&locale="+locale;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OperRoomChargeUnits.jsp?func_mode=checkORChargeYN&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	formObj.chk_oper_room_yn.value=retVal;
		if(retVal=="N"){
		document.getElementById("pyble_unit_show_yn").style.visibility = 'hidden';
		document.getElementById("pyble_unit_show_yn").style.visibility = 'hidden';
	
	}else if(retVal=="Y"){
		document.getElementById("pyble_unit_show_yn").style.visibility = 'visible';
		document.getElementById("pyble_unit_show_yn").style.visibility = 'visible'
	
	}
return retVal;
}

function checkORParameter(){
	var ret_oper_chrg_yn=checkORChargeYN();
	var formObj=document.forms[0];
	var facility_id=formObj.facility_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "facility_id="+facility_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OperRoomChargeUnits.jsp?func_mode=checkORParameter&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
		if(retVal=="N"){
		document.getElementById("pyble_unit_show_yn").style.visibility = 'hidden';
		document.getElementById("pyble_unit_show_yn_td").style.visibility = 'hidden';
	
	}else if(retVal=="Y" && ret_oper_chrg_yn=="Y"){
		document.getElementById("pyble_unit_show_yn").style.visibility = 'visible';
		document.getElementById("pyble_unit_show_yn_td").style.visibility = 'visible';	
	}
}

function validateDuration(obj){
	var retVal="";
	var formObj = document.forms[0];
	var from_time=obj.value;
	var bl_interface_flag=formObj.bl_interface_flag.value;
	var charge_operating_room_yn=formObj.charge_operating_room_yn.value;
	var chk_oper_rm_chrg_yn=checkORChargeYNValidate();
	var splt_from_dur=from_time.split(":");
	if(from_time!=''){
		if(from_time.length!="5"){
		alert(getMessage("APP-OT0130","OT"));
		formObj.check_out_time_or.value="";
		formObj.check_out_time_or.select();
		if(bl_interface_flag=="Y" && charge_operating_room_yn=="Y" && chk_oper_rm_chrg_yn=="Y"){
			formObj.charge_units.value="";
			//document.getElementById("cashcounter_desc").innerText="";
			//document.getElementById("charge_details_1").style.visibility='hidden';
			document.getElementById("charge_details_1").style.display='none';
		}
		return;
	}
	if(splt_from_dur[0].length!=2 ||splt_from_dur[1].length!=2 ){
		alert(getMessage("APP-OT0130","OT"));
		formObj.check_out_time_or.value="";
		formObj.check_out_time_or.select();
		if(bl_interface_flag=="Y" && charge_operating_room_yn=="Y" && chk_oper_rm_chrg_yn=="Y"){
			formObj.charge_units.value="";
			//document.getElementById("cashcounter_desc").innerText="";		
			//document.getElementById("charge_details_1").style.visibility='hidden';
			document.getElementById("charge_details_1").style.display='none';
		}
		return;
	}
}
	var RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;
	if(obj.value!="" && !RE_EXP.test(obj.value) ){
		var err_text="";
	    var time = obj.value;
	    var arr_time =  time.split(":")
        if(arr_time.length!=2 || arr_time[1]=='' || arr_time[0]==''){
			cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}
		if(arr_time[0]<0 || arr_time[0]>23 || arr_time[1]<0 || arr_time[1]>59 ){
			err_text+=getMessage("APP-OT0040","OT");
		}

		if(err_text.length>0){	
			retVal="Error";
			cal_error(err_text,obj);
		}
	}
	return retVal;
}

function cal_error (str_message,obj) {
	alert (str_message);
	var formObj = document.forms[0];
	var bl_interface_flag=formObj.bl_interface_flag.value;
	var charge_operating_room_yn=formObj.charge_operating_room_yn.value;
	var chk_oper_rm_chrg_yn=checkORChargeYNValidate();
	obj.value="";
	obj.select();
	if(bl_interface_flag=="Y" && charge_operating_room_yn=="Y"&&chk_oper_rm_chrg_yn=="Y"){
		document.forms[0].charge_units.value="";
		//document.getElementById("cashcounter_desc").innerText="";
		//document.getElementById("charge_details_1").style.visibility='hidden';
		document.getElementById("charge_details_1").style.display='none';
	}
	return null;
}

function validateDateTime(){
	var formObj=document.forms[0];
	var locale=formObj.locale.value;
	var check_out=formObj.check_out.checked;
	var chk_out_date=formObj.check_out_date.value;
	var current_date_time=formObj.current_date_time.value;
	var chk_out_time=formObj.check_out_time_or.value;
	var check_in_dt_time=formObj.check_in_dt_time.value;
	var bl_interface_flag=formObj.bl_interface_flag.value;
	var charge_operating_room_yn=formObj.charge_operating_room_yn.value;
	var current_time=formObj.current_time.value;
	var chk_oper_rm_chrg_yn=checkORChargeYNValidate();
	var chk_out_dt_time=chk_out_date+" "+chk_out_time;
	var chk_in_date=check_in_dt_time.split(" ");
	if(chk_out_date!="" && chk_out_time!=""){
		var ret_val_frm_time_validtion=validateDuration(formObj.check_out_time_or);
		if(ret_val_frm_time_validtion==""){
				if(!isAfter(chk_out_dt_time,check_in_dt_time,"DMYHM",locale)){
					var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
					var msgArr = msg_1.split("#");
					var checkin_time = getLabel("eOT.CheckinToORDateTime.Label","OT");
					var chk_out_dt_time =getLabel("eOT.CheckOutFromORDateTime.Label","OT");
					alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);										//DATE1_NOT_LESSER_THAN_DATE2
					formObj.check_out_time_or.value="";
					if(bl_interface_flag=="Y" && charge_operating_room_yn=="Y" && chk_oper_rm_chrg_yn=="Y"){
						formObj.charge_units.value="";
						//document.getElementById("cashcounter_desc").innerText="";
						//document.getElementById("charge_details_1").style.visibility='hidden';
						document.getElementById("charge_details_1").style.display='none';
					}
					return false;
	//			}else if(isBeforeNow(chk_out_dt_time,'DMYHM',locale)){
				}else if(!isBeforeNow(chk_out_dt_time,"DMYHM",locale)){
					var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
					var msgArr = msg_1.split("#");
					var systemdatetime =getLabel("Common.SystemDateTime.label","Common");
					var chk_out_dt_time =getLabel("eOT.CheckOutFromORDateTime.Label","OT");
					alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ systemdatetime+msgArr[2]);	
					formObj.check_out_time_or.value="";
					if(bl_interface_flag=="Y" && chk_oper_rm_chrg_yn=="Y"){
						formObj.charge_units.value="";
						//document.getElementById("cashcounter_desc").innerText="";
						document.getElementById("charge_details_1").style.display="none";
					}
					return false;
				}else{
					if(bl_interface_flag=="Y" && charge_operating_room_yn=="Y" && chk_oper_rm_chrg_yn=="Y" && chk_out_time!=""){
						callChargableUnits();
						return true;
					}
				}
			}
		}else{
		if(check_out==true){
			alert("Check Out Date/Time Cannot Be Blank...,") 
			if(bl_interface_flag=="Y" && charge_operating_room_yn=="Y" && chk_oper_rm_chrg_yn=="Y"){
				formObj.charge_units.value="";
				//document.getElementById("cashcounter_desc").innerText="";
				//document.getElementById("charge_details_1").style.visibility='hidden';
				document.getElementById("charge_details_1").style.display='none';
			}
			return;
		}else{
			if(bl_interface_flag=="Y" && charge_operating_room_yn=="Y" && check_out==true && chk_oper_rm_chrg_yn=="Y"){
				formObj.charge_units.value="";
			//document.getElementById("cashcounter_desc").innerText="";
			//document.getElementById("charge_details_1").style.visibility='hidden';
			document.getElementById("charge_details_1").style.display='none';
			}
		}
	}
}

function assignLegend(){
		//check for oper_room chargable or not in setup parameter level...
		checkORParameter();
		var formObj=document.forms[0];
		var facility_id = formObj.facility_id.value;

		var locale = formObj.locale.value;
		var type= formObj.transfer.value;
		var check_out= formObj.check_out.value;
		var ward_title=getLabel("Common.Ward.label","Common");
		var recovery_room_title=getLabel("eOT.RecoveryRoom.Label","OT");
		// Added by Muthukumar on 06-02-12 
		if(type=='H'){
				formObj.hidedesc.style.visibility='hidden';
				formObj.hidelookup.style.visibility='hidden';
				formObj.img1.style.visibility='hidden';
				formObj.img2.style.visibility='hidden';
			}
		// Added by Muthukumar on 06-02-12 

		else if(type=='M'){
			formObj.hidedesc.style.visibility='hidden';
			formObj.hidelookup.style.visibility='hidden';
			formObj.img1.style.visibility='hidden';
			formObj.img2.style.visibility='hidden';
		}else{
			formObj.hidedesc.style.visibility='visible';
			formObj.hidelookup.style.visibility='visible';
			formObj.img1.style.visibility='visible';
			formObj.img2.style.visibility='visible';
		}
		 if(type=="W"){
			formObj.ward_desc.value="";
			formObj.ward_code.value="";
			test.innerHTML=ward_title;
			//formObj.qry_sql.value="SELECT SHORT_DESC DESCRIPTION, WARD_CODE CODE FROM IP_WARD WHERE FACILITY_ID ='"+facility_id+"' AND STATUS IS NULL AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(WARD_CODE) LIKE UPPER(?) ORDER BY 1";
			//SELECT IP_GET_DESC.IP_NURSING_UNIT('"+facility_id+"',NURSING_UNIT_CODE,'"+locale+"',2),NURSING_UNIT_CODE CODE FROM IP_NURSING_UNIT WHERE FACILITY_ID ='"+facility_id+"' AND EFF_STATUS IS NULL ORDER BY 1
			formObj.qry_sql.value="SELECT IP_GET_DESC.IP_NURSING_UNIT('"+facility_id+"',NURSING_UNIT_CODE,'"+locale+"',2) DESCRIPTION,NURSING_UNIT_CODE CODE FROM IP_NURSING_UNIT WHERE FACILITY_ID ='"+facility_id+"' AND EFF_STATUS ='E' AND UPPER(IP_GET_DESC.IP_NURSING_UNIT('"+facility_id+"',NURSING_UNIT_CODE,'"+locale+"',2)) LIKE UPPER(?) AND UPPER(NURSING_UNIT_CODE) LIKE UPPER(?) ORDER BY 1";
		}else if(type=="R"){
			formObj.ward_desc.value="";
			formObj.ward_code.value="";
			test.innerHTML=recovery_room_title;
			formObj.qry_sql.value="SELECT RECOVERY_ROOM_CODE CODE,RECOVERY_ROOM_DESC DESCRIPTION FROM OT_RECOVERY_ROOM WHERE OPERATING_FACILITY_ID='"+facility_id+"' AND STATUS='E' AND UPPER(RECOVERY_ROOM_DESC) LIKE UPPER(?) AND UPPER(RECOVERY_ROOM_CODE) LIKE UPPER(?) ORDER BY 1"; 
		}else if(type=="M"){
			formObj.ward_desc.value="";
			formObj.ward_code.value="";
			test.innerHTML=recovery_room_title;
			//test.innerHTML="Theatre ";
			test.innerHTML="";
			formObj.qry_sql.value="";
		}
		//Added by Muthukumar on 06-02-12 		
		else if(type=="H"){
			formObj.ward_desc.value="";
			formObj.ward_code.value="";
			test.innerHTML=recovery_room_title;
			//test.innerHTML="Theatre ";
			test.innerHTML="";
			formObj.qry_sql.value="";
		}
		//Added by Muthukumar on 06-02-12 
		else{
			formObj.ward_desc.value="";
			formObj.ward_code.value="";
			test.innerHTML=ward_title;
			formObj.qry_sql.value="SELECT SHORT_DESC DESCRIPTION, WARD_CODE CODE FROM IP_WARD WHERE FACILITY_ID ='"+facility_id+"' AND STATUS IS NULL AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(WARD_CODE) LIKE UPPER(?) ORDER BY 1";
		}
		if(type=="R"){
			assignDefaultRecRoom();
		}
}

function assignDefaultRecRoom(){
	var formObj=document.forms[0];
	var oper_room_code=formObj.oper_room.value;
	var locale=formObj.locale.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "oper_room_code="+oper_room_code+"&locale="+locale;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=assignDfltRecRoom&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var arr=retVal.split("&&")
	formObj.ward_code.value=arr[0];
	formObj.ward_desc.value=arr[1];
}

function callChargableUnits(){
	var formObj=document.forms[0];
	var facility_id=formObj.facility_id.value;
	var locale=formObj.locale.value;
	var oper_rm_chk_yn=formObj.oper_rm_chk_yn.value; 
	var charge_operating_room_yn=formObj.charge_operating_room_yn.value;
	var bl_interface_flag=formObj.bl_interface_flag.value;
	if(chk_out_time!=""){
		var chk_out_date=formObj.check_out_date.value; // Modified Against SKR-SCF-1553
		//var chk_out_date=formObj.current_date_time_db.value;	//Modified Against SKR-SCF-1288
		var chk_out_time=formObj.check_out_time_or.value;
		//var chk_in_dt_time=formObj.check_in_dt_time.value; 
		var chk_in_dt_time=formObj.chk_into_or_beforeConvert.value;	//Modified Against SKR-SCF-1288
		var chk_out_dt_time=chk_out_date+" "+chk_out_time;
		var oper_room_code=formObj.oper_room.value;
		var oper_num=formObj.oper_num.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "chk_in_dt_time="+chk_in_dt_time+"&chk_out_dt_time="+chk_out_dt_time+"&oper_room_code="+oper_room_code+"&facility_id="+facility_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OperRoomChargeUnits.jsp?func_mode=callChargeUnits&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var arrVal=retVal.split("##")
		if(arrVal[2]==null)arrVal[2]="";
        if(arrVal[3]==null)arrVal[3]="";
        if(arrVal[4]==null)arrVal[4]="";
		if(arrVal[2]!="" || arrVal[3]!="" || arrVal[4]!=""){
			if(arrVal[4]=="")
			{
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "func_mode=getErrmsg&msg_id="+arrVal[3];
			xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			alert(retVal)
			window.close();
			}else
			{
				alert(arrVal[4])
				window.close();
			}
			return;
		}else{
			units=arrVal[0];
			serv_code=arrVal[1];
			if(oper_rm_chk_yn=="Y" && charge_operating_room_yn=="Y" && bl_interface_flag=="Y"){
				formObj.charge_units.value=arrVal[0];
				formObj.bill_service_code.value=arrVal[1];
				formObj.calc_charge_units.value=arrVal[0];
				getRecoveryRoomCheck();
				callGetServPanelDtls(units, serv_code);
			}
		}
	}else{
			var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.CheckOutFromORDateTime.Label","OT"));
			alert(msg1);
			return;
	}
}

function paintBillDetails(Total,Payable,Paid,include_exclude,Appr_reqd_val){
	if(document.getElementById("charge_details_1").style.display=="none"){
		document.getElementById("charge_details_1").style.display='Inline';
	}
	var lbl_total=getLabel("Common.total.label","common_labels")+" "+getLabel("eOT.Payable.Label","ot_labels");
	var lbl_payable=getLabel("Common.PatientPayable.label","common_labels");
	var lbl_paid=getLabel("Common.PatientPaid.label","common_labels");
	var included=getLabel("eOT.Included.Label","ot_labels");
	var app_reqd=getLabel("eOT.ApprovalRequired.Label","ot_labels");
	var disabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/disabled.gif'></img>";
	var enabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/enabled.gif'></img>";
	var formObj=document.forms[0];
	var inc_exc=formObj.include_exclude.value;
	var appr_reqd_val=formObj.appr_reqd_val.value;
	if(Appr_reqd_val==""){
		Appr_reqd_val=appr_reqd_val;
	}
	if(include_exclude==""){
		include_exclude=inc_exc;
	}
	var str = "<B><font color='Indigo' >"+lbl_total+":&nbsp;"+Total+"</font>&nbsp;&nbsp;";
	str+="<font color='crimson' >"+lbl_payable+":&nbsp;"+Payable+"</font>&nbsp;&nbsp;";
	str+="<font color='green'>"+lbl_paid+":&nbsp;"+Paid+"</font>&nbsp;&nbsp;";
	str+="<font color='Indigo'>"+included+":&nbsp;"+include_exclude+"</font>&nbsp;&nbsp;";
	str+="<font color='Indigo'>"+app_reqd+":&nbsp;"+Appr_reqd_val+"</font>&nbsp;&nbsp;</B>";
	str+="<a class='gridLink' href=\"javascript:callBillingWindow1();\"><img src='../../eOT/images/dollar.png'></img></a>";
	eval("document.getElementById('charge_details_1')").innerHTML = str;
}

function callGetServPanelDtls(units, serv_code){
	var disabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/disabled.gif'></img>";
	var enabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/enabled.gif'></img>";
	var formObj=document.forms[0];
	var locale = formObj.locale.value;
	var facility_id=formObj.facility_id.value;
	var oper_num=formObj.oper_num.value;
	var module_id=formObj.module_id.value;
	var patient_id=formObj.patient_id.value;
	var booking_num=formObj.booking_num.value;
	var order_id=formObj.order_id.value;
	var speciality_code=formObj.speciality_code.value;
	var oper_code=formObj.oper_code.value;
	var surgeon_code=formObj.surgeon_code.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	if(units==""){
		var msg1 = getMessage("CANNOT_BE_BLANK","OT").replace("&",getLabel("eOT.ChargableUnits.Label","OT"));
		alert(msg1);
		formObj.charge_units.select();
		return;
	}else if(units=="0" || units=="00" || units=="000"){
		var msg1 = getMessage("APP-OT0068","OT").replace("#",getLabel("eOT.ChargableUnits.Label","OT"));
		alert(msg1);
		formObj.charge_units.select();
		return;
		}
	var params = "units="+units+"&serv_code="+serv_code+"&locale="+locale+"&facility_id="+facility_id+"&oper_num="+oper_num+"&module_id="+module_id+"&patient_id="+patient_id+"&booking_num="+booking_num+"&order_id="+order_id+"&speciality_code="+speciality_code+"&oper_code="+oper_code+"&surgeon_code="+surgeon_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","HoldingAreaChargeUnits.jsp?func_mode=callServPanel&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var arrVal=retVal.split("$$");
	var Total=arrVal[2];
	var Payable=arrVal[3];
	var Paid ="";
	if(arrVal[6]==""){
		Paid ="0.0"
	}else{
		Paid = arrVal[6];
	}
	var include_exclude="";
	var Appr_reqd_val="";
	formObj.include_exclude.value=arrVal[4];
	formObj.appr_reqd_val.value=arrVal[5];
	if(arrVal[4]=="I"){
		include_exclude=enabled;	
	}else{
		include_exclude=disabled;	
	}
	if(arrVal[5]=="Y"){
		Appr_reqd_val=enabled;	
	}else{
		Appr_reqd_val=disabled;	
	}
	callBillingWindow();
	document.getElementById("charge_details_1").style.display="inline"
	paintBillDetails(Total,Payable,Paid,include_exclude,Appr_reqd_val);

}

function callBillingWindow(){
	var formObj=document.forms[0];
	var oper_num=formObj.oper_num.value;
	var bay_code="";
	var service_code="";
	var charge_units="";
	var key="";
	var key_line="";
		bay_code=formObj.oper_room.value;
		service_code=formObj.bill_service_code.value;
		charge_units=formObj.charge_units.value;
		key=formObj.or_bill_accession_num.value;
		key_line = "1";
	//	var key_line = "";
	pushAllValuestoOR(key,key_line,oper_num,bay_code,service_code,charge_units);
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";
	var xmlStr ="<root></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	//showBillingWindow(responseText,"1");
}

function callBillingWindow1(){
	var formObj=document.forms[0];
	var oper_num=formObj.oper_num.value;
	var bay_code="";
	var service_code="";
	var charge_units="";
	var key="";
	var key_line="";
		bay_code=formObj.oper_room.value;
		service_code=formObj.bill_service_code.value;
		charge_units=formObj.charge_units.value;
		key=formObj.or_bill_accession_num.value;
		key_line = "1";
	//var key_line = "";
	//pushAllValuestoOR(key,key_line,oper_num,bay_code,service_code,charge_units);
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";
	var xmlStr ="<root></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	showBillingWindow(responseText,"1");
}

function pushAllValuestoOR(key,key_line,oper_num,bay_code,service_code,charge_units){
	var formObj=document.forms[0];
	var param = "key="+key+"&key_line="+key_line+"&oper_num="+oper_num+"&bay_code="+bay_code+"&service_code="+service_code+"&charge_units="+charge_units+"&called_from=PassBillDetails&room_id=OR";
	var xmlStr ="<root></root>";
	var temp_jsp="OTInterRoomCharges.jsp?"+param;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);

}

async function showBillingWindow(str,key){
	var formObj=document.forms[0];
	var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
	var arr = str.split("::");
	var column_sizes = "";
	var column_descriptions ="";       
	var episode_type = arr[4];
	var patient_id=arr[3];
	var visit_id=arr[6];
	var episode_id=arr[5];         
	var service_panel_code=arr[12];     //---service code returining from billing proc
	var service_panel_ind=arr[11];;						  //---to be check
	var service_date=arr[8];							  //---to be chedk
	var order_catalog_code=arr[2];      
	var module_id = "OT";
	var encounter_id=arr[7]; 
	var key=arr[0]; 
	var key_line_no=arr[1];//--- to be check
	//var order_id=formObj.order_id.value; 
	var order_id=arr[0]; 
	var order_line_no=arr[1];									//--- to be check
	var bean_id=""; 
	var total_qty =formObj.charge_units.value;				//---to be check
	var revised_qty = formObj.charge_units.value;
	//var original_qty = formObj.calc_charge_units.value;//commented against SKR-SCF-1233_Muthu-190619
	var original_qty = 1;//Added against SKR-SCF-1233_Muthu-190619
	//calc_chrge_units,charge_units
	var appr_reqd_value =formObj.appr_reqd_val.value;
	var bl_panel_str = arr[13];				//Panel Str returing from units
	var index_val="";
	var dialogTop = "100";
	var dialogHeight = "30" ;
	var dialogWidth = "70" ;
	var inc_exe=""; // dummy var created for painting the bill details in front end
	var apprvl_reqd_yn=formObj.appr_reqd_val.value;  // dummy var created for painting the bill details in front end
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments = "" ;
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episode_type="+episode_type+"&"+"patient_id="+patient_id+"&"+"visit_id="+visit_id+"&"+"episode_id="+episode_id+"&"+"service_panel_code="+service_panel_code+"&"+"service_panel_ind="+service_panel_ind+"&"+"service_date="+service_date+"&"+"order_catalog_code="+order_catalog_code+"&"+"module_id="+module_id+"&encounter_id="+encounter_id+"&key="+key+"&key_line_no="+key_line_no+"&order_id="+order_id+"&order_line_no="+order_line_no+"&bean_id="+bean_id+"&total_qty="+total_qty+"&revise_qty="+revised_qty+"&original_qty="+original_qty+"&quantity="+revised_qty+"&qty="+revised_qty+"&p_serv_qty="+revised_qty+"&revised_qty="+revised_qty+"&serv_panel_qty="+revised_qty+"&modify_qty_yn=Y&p_str="+bl_panel_str; 
	var retVal = await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);		
	if(retVal!=null){
		var retArray  = retVal;
		if(retArray[8]=="I"){
			inc_exe="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/enabled.gif'></img>";
		}else if(retArray[8]=="E"){
			inc_exe="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/disabled.gif'></img>";
		}
		if(retArray[6]!="" && retArray[7]!=""){
			formObj.inc_exe_blng_wdw.value=retArray[6];
			formObj.reason_inc_exe.value=retArray[7];
		}else{
			formObj.inc_exe_blng_wdw.value="";
			formObj.reason_inc_exe.value="";
		}
		if(apprvl_reqd_yn==""){
			apprvl_reqd_yn=appr_reqd_value;
		}
		if(appr_reqd_value=="Y"){
			apprvl_reqd_yn="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/enabled.gif'></img>";
		}else if(appr_reqd_value=="N"){
			apprvl_reqd_yn="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/disabled.gif'></img>";
		}
		if(typeof retArray[10]=='undefined')retArray[10]="";
		if(retArray[10]!="")
		{
		/* NOTE: Done by sathish on 10-03-2010.For urgency.
		Here surgeon_code is changed which is return by billing window. 
		this is for inserting in billing table as now surgeon_code is not used for inserting 
		in any other place. If it is required to insert in other place also like OT tables.please take another  
		hidden variable and change the logic */
        formObj.surgeon_code.value=retArray[10];
		var params=formObj.params.value
		params="&surgeon_code="+retArray[10]+"&"+params;
		formObj.params.value=params;
		}
	paintBillDetails(retArray[1],retArray[2],retArray[3],inc_exe,apprvl_reqd_yn);
	Paintpanelstring();
	}
}

function Paintpanelstring()
{
	var formObj=document.forms[0];
	var oper_num=formObj.oper_num.value;
	var bay_code="";
	var service_code="";
	var charge_units="";
	var key="";
	var key_line="";
	bay_code=formObj.oper_room.value;
	service_code=formObj.bill_service_code.value;
	charge_units=formObj.charge_units.value;
	key=formObj.or_bill_accession_num.value;
	key_line = "1";
	//var key_line = "";
	//pushAllValuestoOR(key,key_line,oper_num,bay_code,service_code,charge_units);
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";
	var xmlStr ="<root></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	var arr = responseText.split("::");
	var bl_panel_str = arr[13];	
	document.forms[0].bl_panel_str.value=bl_panel_str;
}

function onBlurGetServPanelDtls(obj, serv_code){
	var disabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/disabled.gif'></img>";
	var enabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/enabled.gif'></img>";
	var formObj=document.forms[0];
	var locale = formObj.locale.value;
	var facility_id=formObj.facility_id.value;
	var oper_num=formObj.oper_num.value;
	var check_out=formObj.check_out.checked;
	var module_id=formObj.module_id.value;
	var patient_id=formObj.patient_id.value;
	var booking_num=formObj.booking_num.value;
	var order_id=formObj.order_id.value;
	var speciality_code=formObj.speciality_code.value;
	var check_out_time_or=formObj.check_out_time_or.value;
	var charge_units=formObj.charge_units.value;
	var oper_code=formObj.oper_code.value;
	var surgeon_code=formObj.surgeon_code.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	if(check_out_time_or!="" && check_out==true){

	if(obj.value==""){
		var msg1 = getMessage("CANNOT_BE_BLANK","OT").replace("&",getLabel("eOT.ChargableUnits.Label","OT"));
		alert(msg1);
		formObj.charge_units.select();
		return;
	}else if(obj.value=="0" || obj.value=="00" || obj.value=="000"){
		var msg1 = getMessage("APP-OT0068","OT").replace("#",getLabel("eOT.ChargableUnits.Label","OT"));
		alert(msg1);
		formObj.charge_units.select();
		return;
		}
	}
	var params = "units="+obj.value+"&serv_code="+serv_code+"&locale="+locale+"&facility_id="+facility_id+"&oper_num="+oper_num+"&module_id="+module_id+"&patient_id="+patient_id+"&booking_num="+booking_num+"&order_id="+order_id+"&speciality_code="+speciality_code+"&oper_code="+oper_code+"&surgeon_code="+surgeon_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","HoldingAreaChargeUnits.jsp?func_mode=callServPanel&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var arrVal=retVal.split("$$");
	var Total=arrVal[2];
	var Payable=arrVal[3];
	var Paid = arrVal[6];
	var include_exclude="";
	var Appr_reqd_val="";
	if(arrVal[4]=="I"){
		include_exclude=enabled;	
	}else{
		include_exclude=disabled;	
	}
	if(arrVal[5]=="Y"){
		Appr_reqd_val=enabled;	
	}else{
		Appr_reqd_val=disabled;	
	}
	callBillingWindow();
	formObj.include_exclude.value=include_exclude;
	formObj.appr_reqd_val.value=Appr_reqd_val
	paintBillDetails(Total,Payable,Paid,include_exclude,Appr_reqd_val);
	//document.getElementById("cashcounter_desc").innerText=arrVal[2];
}

function getRecoveryRoomCheck(){
	var formObj=document.forms[0];
	var facility_id=formObj.facility_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "func_mode=getOperRoomCheck&facility_id="+facility_id;
	xmlHttp.open("GET","../../eOT/jsp/OperRoomChargeUnits.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	formObj.oper_room_chrging_stg.value=retVal;
}

function checkForSpecCharsforID(event)
{
	var strCheck = '0123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function checkSpecCharsforID(event)
{
    var strCheck = '0123456789:';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function localTrimString(sInString) {
	  sInString = sInString.replace( /^\s+/g, "" );// strip leading space	  
	  return sInString.replace(/^\s+|\s+$/g,"");
}
//Added Against PMG2016-KDAH-CRF-0001 ends

//Added Against SKR-SCF-1288 Starts
function isValidDate(obj){
	if(obj.value!=""){
		//var RE_NUM = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(20)[0-9]{2}$/;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length!=3) return cal_error ("Invalid date format: '" + str_date + "'.\nFormat accepted is DD/MM/YYYY.",obj);
		if (!arr_date[0]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo day of month value can be found.",obj);
		if (!RE_NUM.exec(arr_date[0])) return cal_error ("Invalid day of month value: '" + arr_date[0] + "'.\nAllowed values are unsigned integers.",obj);
		if (!arr_date[1]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo month value can be found.",obj);
		if (!RE_NUM.exec(arr_date[1])) return cal_error ("Invalid month value: '" + arr_date[1] + "'.\nAllowed values are unsigned integers.",obj);
		if (!arr_date[2]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo year value can be found.",obj);
		if (arr_date[2].length!=4) return cal_error ("Invalid year value: '" + arr_date[2] + "'.\nAllowed format YYYY.",obj);
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) return cal_error ("Invalid month value: '" + arr_date[1] + "'.\nAllowed range is 01-12.",obj);
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) return cal_error ("Invalid day of month value: '" + arr_date[0] + "'.\nAllowed range is 01-"+dt_numdays.getDate()+".",obj);
		//if(arr_date[2].length==4 && arr_date[2]>=dt_date.getFullYear() ) return cal_error ("Not a valid Year value: '" + arr_date[2] + "'.\nCurrent Year "+dt_date.getFullYear()+" Only Allowed .",obj);	
	}
	return true;
}
//Added Against SKR-SCF-1288 Ends
