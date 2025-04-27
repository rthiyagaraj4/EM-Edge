/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var message1="";
function reset(){
	var formObj = parent.document.frames.recovery_frame.document.CheckInToRecoveryRoomForm;
	var params = "";
	if(formObj!=null)
		params = formObj.params.value;
		recovery_frame.document.location.href="../../eOT/jsp/ChkInRecoveryRoom.jsp?"+params;
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}

function CheckMandatoryFields(){
	var formObj = parent.document.frames.recovery_frame.document.CheckInToRecoveryRoomForm;
	var messageFrame= parent.document.frames.messageFrame;
	var fields= new Array(formObj.start_date, formObj.start_time,formObj.recovery_room_desc);
	var RecoveryStartDate= getLabel("eOT.RecoveryStartDate.Label","OT");
	var	RecoveryStartTime= getLabel("eOT.RecoveryStartTime.Label","OT");
	var	RecoveryRoom= getLabel("eOT.RecoveryRoom.Label","OT");
	var names=new Array(RecoveryStartDate,RecoveryStartTime,RecoveryRoom);
	
	if(checkFields(fields,names,messageFrame)==false){
		return false;
	}else 
		return true;
}

function checkForSpecCharsforIDTime(event){
    var strCheck = '0123456789:';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function CheckMandatoryFlds(){
	var formObj = parent.document.frames.recovery_frame.document.CheckInToRecoveryRoomForm;
	var messageFrame= parent.document.frames.messageFrame;
	var transfer_to = formObj.transfer.value;
	var RecoveryEndDate =getLabel("eOT.RecoveryEndDate.Label","OT");
	var RecoveryEndTime =getLabel("eOT.RecoveryEndTime.Label","OT");
	var TransferDate =getLabel("Common.transferdate.label","Common");
	var	TransferTime = getLabel("eOT.TransferTime.Label","OT");
	var RecoveryEndTransferDate =getLabel("eOT.RecoveryEndTransferDate.Label","OT");
		
	if(transfer_to=="W" && formObj.check_out.checked==true){
		var fields= new Array(formObj.end_date, formObj.end_time,formObj.transfer_date,formObj.transfer_time,formObj.ward_code);
		var Ward =getLabel("Common.nursingUnit.label","Common");
		var names=new Array(RecoveryEndDate,RecoveryEndTime,TransferDate,TransferTime,Ward);
	}else{
		var fields= new Array(formObj.end_date, formObj.end_time,formObj.transfer_date,formObj.transfer_time);
		var names=new Array(RecoveryEndDate,RecoveryEndTransferDate,TransferTime,TransferTime);
	}

	if(checkFields(fields,names,messageFrame)==false){
		return false;
	}else 
		return true;
}

function validateTransferTime(){
	var flag=true;
	var formObj = parent.document.frames.recovery_frame.document.CheckInToRecoveryRoomForm;
	var locale=formObj.locale.value;
	var messageFrame= parent.document.frames.messageFrame;
	var rec_end_date_time = formObj.end_date.value+" "+formObj.end_time.value;
	var transfer_date_time = formObj.transfer_date.value+" "+formObj.transfer_time.value;
	if(rec_end_date_time!="" && transfer_date_time!=""){
		var returnVal =  compareDates(rec_end_date_time,transfer_date_time,locale,"DMYHM");
		if(returnVal==false){
			var msg = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
			var msgArray = msg.split("#");
			var transfertime = getLabel("eOT.TransferTime.Label","OT");
			var recoveryendtime = getLabel("eOT.RecoveryEndTime.Label","OT");
			msg=msgArray[0]+recoveryendtime+msgArray[1]+transfertime+msgArray[2];
			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			flag = false;
		}
	}
	return flag;
}

function loadRecTime1(){
	var delay = function() { loadRecTime(); };
	setTimeout(delay,1200);
}

function loadRecTime(){
	var frmObj = parent.document.frames.recovery_frame.document.CheckInToRecoveryRoomForm;
	var formObjHdr = parent.document.frames.common_patient_hdr_frame.document.CommonOperDtlsHdrForm;
	var formObj = document.forms[0];
	var locale=formObj.locale.value;
	var rec_room_code = formObjHdr.recovery_room_code.value;
	var rec_start_time = formObjHdr.rec_start_time.value;
	var rec_end_time =formObjHdr.rec_end_time.value;
	var transfer_to = formObjHdr.transfer_to.value;
	var transfer_ward_code = formObjHdr.transfer_ward_code.value;
	var transfer_status =formObjHdr.transfer_status.value;
	var oper_num =formObjHdr.oper_num.value;
	var recy_room_finalization_stage=frmObj.recy_room_finalization_stage.value;
	var bl_interface_flag=frmObj.bl_interface_flag.value;
	var charge_recovery_room_yn=frmObj.charge_recovery_room_yn.value;
	hideChargeBillDtls(rec_room_code,charge_recovery_room_yn)
	document.forms[0].accession_num_chrg_unit.value=oper_num+"RR"+rec_room_code;
	document.forms[0].accession_num.value=oper_num+"RR"+rec_room_code;
	formObj.rec_room_code.value=rec_room_code;
	var facility_id=formObj.facility_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "func_mode=getRecoveryRoomDesc&facility_id="+facility_id+'&recovery_room_code='+rec_room_code;
	xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	formObj.recovery_room_desc.value=retVal;
	formObj.rec_room_desc.value=retVal;
	if(rec_start_time.length>0){
		var arr1 = rec_start_time.split(" ");
		formObj.start_date.value=convertDate(arr1[0],"DMY","en",locale);
		formObj.start_time.value=arr1[1];
	}
	var rec_room_chrge_yn=frmObj.rec_room_chrge_yn.value;
	if(rec_end_time.length>0){
		var arr2 = rec_end_time.split(" ");
		formObj.end_date.value=convertDate(arr2[0],"DMY","en",locale);
		formObj.end_time.value=arr2[1];
		if(bl_interface_flag=="Y" && charge_recovery_room_yn=="Y" && rec_room_chrge_yn=="Y"){
		callChargeableUnits();
		}
	}
	if(formObj.check_out.checked==true){
		if(transfer_to.length>0){
			document.forms[0].transfer.value=formObjHdr.transfer_to.value;
			flag="SECOND"
		}else{
			document.forms[0].transfer.value="W"
			flag = "FIRST"
		}
		if(transfer_to=="W" && flag!="FIRST" ){
			document.forms[0].ward_code.value = transfer_ward_code;
			document.forms[0].ward_desc.value = getTransferDesc(transfer_ward_code); 
			document.forms[0].status.value = formObjHdr.transfer_status.value;
			disableWardAndStatus();
		}
		
		else if(transfer_to=="C" && flag!="FIRST")
		{		
			document.forms[0].ward_code.value=transfer_ward_code;
			document.forms[0].ward_desc.value=getclinicTransferDesc(transfer_ward_code);
			document.forms[0].status.value = formObjHdr.transfer_status.value;
			disableWardAndStatus();
		}
		else{
			document.forms[0].ward_code.value = "";
			document.forms[0].ward_desc.value = "";
			document.forms[0].status.value = "";
			disableWardAndStatus();
		}
	}else{
		disableWardAndStatus();
	}
	validateDtTime(document.forms[0].end_time);
}

function loadChkInRecTime(){
	var formObjHdr = parent.document.frames.common_patient_hdr_frame.document.CommonOperDtlsHdrForm;
	var rec_room_code = formObjHdr.recovery_room_code.value;
	var oper_room_code = formObjHdr.theatre_code.value;
	var formObj = document.forms[0];
	var locale=formObj.locale.value;
	var rec_start_time = formObjHdr.rec_start_time.value;
	var rec_end_time = formObjHdr.rec_end_time.value;
	
	formObj.rec_room_code.value=rec_room_code;
	var facility_id=formObj.facility_id.value;
	if(rec_room_code!='')
	{
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "func_mode=getRecoveryRoomDesc&facility_id="+facility_id+'&recovery_room_code='+rec_room_code;
		xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		formObj.recovery_room_desc.value=retVal;
		formObj.rec_room_desc.value=retVal;
		if(retVal!='')
		{
			formObj.recovery_room_desc.disabled=true;
			formObj.recoveryLookUp.disabled=true;
		}
    } else
	{
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "func_mode=getDfltRecCodeAndDesc&facility_id="+facility_id+'&oper_room_code='+oper_room_code;
		xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
    
		retVal=retVal.split("##");
		formObj.rec_room_code.value=retVal[0];
		formObj.recovery_room_desc.value=retVal[1];
		formObj.rec_room_desc.value=retVal[1];
	}

	if(rec_start_time.length>0 ){
		var arr1 = rec_start_time.split(" ");
		formObj.start_date.value=convertDate(arr1[0],"DMY","en",locale);
		formObj.start_time.value=arr1[1];
		if(rec_end_time.length>0){
			var arr2 = rec_end_time.split(" ");
			formObj.end_date.value=convertDate(arr2[0],"DMY","en",locale);
			formObj.end_time.value=arr2[1];			
		}
	}else{
		formObj.start_date.value=getSysDate();
		formObj.start_time.value=getSysTime();
		formObj.end_date.value="";
		formObj.end_time.value="";
	}
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

function assignResult( _result, _message, _flag ){
	result = _result ;
	message1  = _message ;
	flag = _flag ;
}

function apply(){	
	var frmObj = parent.document.frames.recovery_frame.document.CheckInToRecoveryRoomForm;
	var formObj = parent.document.frames.recovery_frame.document.CheckInToRecoveryRoomForm;
	var formObj = parent.frames[4].document.forms[0];	
	var params = formObj.params.value;
	parent.document.frames.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?"+params;
	var called_from = formObj.called_from.value;
	var recovery_in_out_flag = formObj.recovery_in_out_flag.value;
	if(recovery_in_out_flag=="CHECK_IN_RECO"){		
		if(CheckMandatoryFields()==true && validateCheckedOutTime()==true ){
			 retVal = formApply(formObj,OT_CONTROLLER);			
			 eval(retVal);
			 if(result){
				 if(called_from=="OT_SLATE"){				 
					window.returnValue=getMessage("RECORD_INSERTED","SM");
					alert(window.returnValue);
					window.close();
				 }else{				 
					parent.document.frames.recovery_frame.document.location.href="../../eOT/jsp/ChkInRecoveryRoom.jsp?"+params;
					parent.document.frames.result_frame.document.location.href="../../eCommon/html/blank.html";
					parent.document.frames.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
				 }				
			 }else{
				var msg = getMessage("APP-OT0082","OT");
				alert(msg);
				window.returnValue=msg;
				window.close();
			 }
		}
	}else if(recovery_in_out_flag=="CHECK_OUT_RECO"){		
//Start of checking for VeriCheckList Function 
		var check_for_check_list_compl = formObj.check_for_check_list_compl.value;
		var checklist_flag = "true";
		if(check_for_check_list_compl=="Y"){
			 if(formObj.checklist_completed_yn.value=="N"){
				checklist_flag = "false";
				var msg = getMessage("INCOMPLETE_CHECKLIST","OT");
				parent.document.frames.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
			 }
		}
//End of checking for VeriCheckList Function 
		if(checklist_flag == "true"){
			var apply_flag = "true";
			  if(formObj.check_out.checked==true && formObj.transfer.value!="M"){
				 if( CheckMandatoryFlds() && validateCheckedOutTime() && validateTransferTime() ){							
				 }else 
					apply_flag="false";
			}else{ //else part added by rajesh on 21/11/2007
				if( CheckMandatoryFlds() && validateCheckedOutTime() && validateTransferTime() ){
					apply_flag="true";
				}
				else 
				apply_flag="false";
			}
			 // if checkbox is not checked, we need not apply the transaction.
			//mandatory fields check added by bala on 13/06/2005
			//end of mandatory fields check added by bala on 13/06/2005
			 if(apply_flag=="true"){
				 submitSpecimenDetails();
				 //formObj.check_out_time.disabled = "";
				 retVal = formApply(formObj,OT_CONTROLLER);
			     retVal=trimString(retVal);
				 eval(retVal);
				 if(called_from=="OT_SLATE"){
					 if(message1=="RECORD_INSERTED")
					 {window.returnValue=getMessage("RECORD_INSERTED","SM");
					 alert(window.returnValue);
					 }
					 else{
						 alert(message1)
					 }					
					window.close();
				 }else{ // this code is used when it is called from OT_MENU...temporarily not used
					parent.document.frames.recovery_frame.document.location.href="../../eOT/jsp/ChkInRecoveryRoom.jsp?"+params;
					parent.document.frames.result_frame.document.location.href="../../eCommon/html/blank.html";
					parent.document.frames.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
				 }//else				
			 }//apply flaf (if)
		 }//checklist_flag
	}//recovery_in_out_flag
}

function beforePost(str){
}

function submitSpecimenDetails(){
	frmObj = parent.document.frames.ObjectCollect;
	rows = parent.document.frames.ObjectCollect.specimen_rows;
	var formObj = parent.document.frames.recovery_frame.document.CheckInToRecoveryRoomForm;
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

function checkDtlRecords(){
		/*var formObj = parent.document.frames.recovery_frame.document.CheckInToRecoveryRoomForm; 
		var disposal_size=formObj.size.value;
		var untoward_size=formObj.size1.value;
		if(disposal_size > 0 || untoward_size > 0)
	     return 1;
		 return 0;*/
}

function validateCheckedOutTime(){
	var flag=true;
	var formObj = parent.document.frames.recovery_frame.document.CheckInToRecoveryRoomForm; 
	var locale = formObj.locale.value;
	var recovery_in_out_flag = formObj.recovery_in_out_flag.value;
	var cur_date = getSysDate();
	var rec_start_time = formObj.start_date.value+" "+formObj.start_time.value;
	var rec_end_time = formObj.end_date.value+" "+formObj.end_time.value;
	var check_into_or_time= formObj.check_into_or_time.value;

	var returnVal =  compareDates(rec_start_time,rec_end_time,locale,"DMYHM");
	if(returnVal==false){
		var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
		var msgArray = msg.split("#");
		var recoverystarttime = getLabel("eOT.RecoveryStartTime.Label","OT");
		var recoveryendtime = getLabel("eOT.RecoveryEndTime.Label","OT");
		msg=msgArray[0]+recoveryendtime+msgArray[1]+recoverystarttime+msgArray[2];
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		flag = false;
		formObj.end_time.focus();
		formObj.end_time.select();
	}
	return flag;
}

function checkTimeValidity(obj){
	if(obj.value!=null && obj.value!=""){
		var retVal = chkTime(obj.value);
		if(retVal==true){
			var chk_out_time=obj.value;
			if(chk_out_time.length!="5"){
				alert(getMessage("VALID_TIME_SLOTS","OT"));		
				obj.value="";
				obj.focus();
			}
		}
		if(retVal==false ){
			alert(getMessage("VALID_TIME_SLOTS","OT"));		
			obj.value="";
			obj.focus();
			
		}
	}
}

function checkTimeValidation(){
	var formObj = parent.document.frames.recovery_frame.document.CheckInToRecoveryRoomForm;
	var chk_out_date=formObj.transfer_date.value;
	var chk_out_time=formObj.transfer_time.value;
	var cur_date=formObj.cur_date.value;
	var cur_time=formObj.cur_time.value;
	var check_in_date=formObj.cur_date.value;
	var check_in_time=formObj.cur_time.value;
	var chk_in_dt_time=check_in_date+" "+check_in_time;
	var chk_out_dt_time=chk_out_date+" "+chk_out_time;
	var locale=formObj.locale.value;
	if(chk_out_time!=""){
		if(!isBeforeNow(chk_out_dt_time,"DMYHM",locale)){
			var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
			var msgArr = msg_1.split("#");
			var checkin_time = getLabel("eOT.TransferTime.Label","OT");
			var chk_out_dt_time =getLabel("Common.SystemDateTime.label","OT");
			alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);										
			formObj.transfer_time.value="";
			return false;
		}		
	}
}

function trimString(sInString){
   return sInString.replace(/^\s+|\s+$/g,"");
}

function checkTimeFormat(obj){	
	var check_in_recovery_time=document.CheckInToRecoveryRoomForm.check_in_recovery_time.value;
	var recovery_in_out_flag = document.CheckInToRecoveryRoomForm.recovery_in_out_flag.value;
	var locale = document.CheckInToRecoveryRoomForm.locale.value;
	//61689 starts
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
    	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=check_for_speciality",false);
	xmlHttp.send(xmlDoc);
	var customerId = trimString(xmlHttp.responseText);
	//61689 ends	
	
	var chk_out_recovry_end_time = document.CheckInToRecoveryRoomForm.end_date.value+" "+document.CheckInToRecoveryRoomForm.end_time.value;
	var check_in_recovery_start_date = document.CheckInToRecoveryRoomForm.start_date.value;
	
	var cur_date = dateUtils(getSysDate(),locale,'DMY');
	var date_time;
	//Added against 61689-starts
	if(customerId=="KDAH"){
		date_time= check_in_recovery_start_date+" "+obj.value;
	}else{
		//date_time= cur_date+" "+obj.value; //commented Against ARYU-SCF-0099
		date_time= check_in_recovery_start_date+" "+obj.value; //Modified Against ARYU-SCF-0099
	}
	//Added against 61689-ends
	var database_system_date_time = dateUtils(getSysDateTime(),locale,'DMYHM');
	check_in_recovery_time = dateUtils(check_in_recovery_time,locale,'DMYHM');
	if(obj.value!=null && obj.value!=""){
		var retVal = chkTime(obj.value);
		if(retVal==false){
			alert(getMessage("VALID_TIME_SLOTS","OT"));		
			obj.focus();
			obj.select();
		}
	}	
	
	var retVal = compareDates(date_time,database_system_date_time,locale,"DMYHM");	
	if(retVal==false || retVal=="false"){
		var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
		var msgArr = msg_1.split("#");
		if(recovery_in_out_flag=="CHECK_IN_RECO"){
			var checkout_time = getLabel("eOT.RecoveryStartTime.Label","OT");
		}else{
			var checkout_time = getLabel("eOT.CheckOutTime.Label","OT");
		}
		var systemdatetime =getLabel("Common.SystemDateTime.label","Common");
		alert(msgArr[0]+ checkout_time +msgArr[1]+ systemdatetime +msgArr[2]);
		obj.focus();
		obj.select();
		return;
	}else{
		if(recovery_in_out_flag=="CHECK_OUT_RECO"){
				var flag = compareDates(chk_out_recovry_end_time,date_time,locale,"DMYHM"); // small, greater	
				if(flag==false || flag=="false"){
				var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
				var msgArr = msg_1.split("#");
				var checkout_time = getLabel("eOT.CheckOutTime.Label","OT");
				var recovery_checkin_time = getLabel("eOT.RecoveryCheckInTime.Label","OT");			
				alert(msgArr[0]+ checkout_time + msgArr[1]+recovery_checkin_time+msgArr[2]);
				obj.focus();
				obj.select();
				return;
			}
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

function validateCheckBox(){
	formObj = document.CheckInToRecoveryRoomForm;
	var check_out = formObj.check_out;
	//Added by Sharon Crasta on 6/11/2009 for IN011349
	var ward = formObj.transfer.value;
	//
	if(check_out.checked){
		formObj.check_out_flag.value="Y";
		
		if(ward == "W" || ward == "C"){
			formObj.WardLookUp.disabled=false;
			formObj.ward_desc.disabled=false;
		}else{
			formObj.WardLookUp.disabled=true;
			formObj.ward_desc.disabled=true;	
		}
	}else{
		formObj.check_out_flag.value="N";
		formObj.WardLookUp.disabled=true;
		formObj.ward_desc.disabled=true;
	}
}

async function searchAnatomicalSite(obj,target){
	var locale = document.forms[0].locale.value;
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
		tit=getLabel("Common.AnatomicalSite.label","Common");
		var sql="SELECT SHORT_DESC description, ANATOMICAL_SITE_CODE code FROM AM_ANATOMICAL_SITE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E') = 'E'  and upper(SHORT_DESC) like upper(?) and upper(ANATOMICAL_SITE_CODE) like upper(?) order by 2";
	}
	tit=encodeURIComponent(tit);
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
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
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
	var locale = document.forms[0].locale.value;
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
		var tit=getLabel("eOT.Disposal.Label","OT");
		tit=encodeURIComponent(tit);

		var sql="SELECT DISPOSAL_DESC DESCRIPTION, DISPOSAL_CODE CODE FROM OT_ORGAN_DISPOSAL_LANG_VW WHERE NVL(STATUS,'E') = 'E'  and upper(DISPOSAL_DESC) like upper(?) and upper(DISPOSAL_CODE) like upper(?) AND LANGUAGE_ID ='"+locale+"' order by 2";
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
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
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
	var formObj = document.UntowardEvtRecordForm;
	var locale = formObj.locale.value;
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var tit=getLabel("eOT.UnusualOccurrence.Label","OT");
	tit=(tit);

	var sql="SELECT SHORT_DESC description, UNUSUAL_OCCUR_CODE code FROM OT_UNUSUAL_OCCUR_CODE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'E') = 'E'  and upper(SHORT_DESC) like upper(?) and upper(UNUSUAL_OCCUR_CODE) like upper(?) order by 2";
	
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
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value='';
		obj.value='';
	}
}

function checkLimit(field, limit){
 if (field.value.length > limit)
  {
	var msg = getMessage("MAX_LENGTH_DATA","OT");
	var msgArray = msg.split("#");
	alert(msgArray[0]+""+msgArray[1]+limit+msgArray[2]);
	var revertField = field.value.slice(0, limit-1);
	field.value = revertField;
	field.focus();
  }
}

function isRecordVitalEnable(){
	var formObj =  parent.common_patient_hdr_frame.document.all; //muthu
	var discr_msr_id  = formObj.discr_msr_id.value;   
	//Modified by Muthukumar against SRR20056-SCF-7683 on 21-06-2011 	  
	if( discr_msr_id==null ||  discr_msr_id =='' || discr_msr_id=='null' ){	
		formObj.record_vitals1.style.visibility = 'visible'; 
	}
}
	//Modified by Muthukumar against SRR20056-SCF-7683 on 21-06-2011

async function callRecordVitals(){	
	var formObj =  parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var formObjDtl=parent.recovery_frame.CheckInToRecoveryRoomForm;
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

	var url='../../eCA/jsp/ChartRecording.jsp?patient_id='+patient_id+'&function_from=CP&p_start_date_time='+date_time+'&Chart_Id='+discr_msr_id+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
	var retVal;
	var dialogHeight = window.screen.availHeight ;
	var dialogWidth  = window.screen.availWidth ;
	var dialogTop    = "0";
	var dialogLeft   = "0";
	var features = "dialogHeight:" + dialogHeight + ";dialogWidth:" + dialogWidth+ "; left:"+dialogLeft+";top:"+dialogLeft+";status:no;resizable:no";
	var arguments    = "" ;
	retVal  = await window.showModalDialog(url, arguments, features);
 }

async function funsubmitCheckInDtls(checklists){
	var formObj = document.CheckInToRecoveryRoomForm;	
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
				access="NNNNY";
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
	var viewchecklist_legend = encodeURIComponent(getLabel("eOT.ViewCheckList.Label","OT"));	
	var db_param_1="module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access="+access+"&home_required_yn=N";
	var function_string = "&function_id=OT_CHECK_LIST&function_name="+viewchecklist_legend;
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
		var tit=getLabel("Common.nursingUnit.label","Common");
		tit=encodeURIComponent(tit);
		var sql="SELECT SHORT_DESC DESCRIPTION, WARD_CODE CODE FROM IP_WARD WHERE FACILITY_ID ='"+facility_id+"' AND STATUS IS NULL AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(WARD_CODE) LIKE UPPER(?) ORDER BY 1";
	}
	else if(ward=="C")
	{
		var tit =getLabel("Common.clinic.label","OT");
		tit=encodeURIComponent(tit);
		var sql="SELECT LONG_DESC DESCRIPTION, CLINIC_CODE CODE FROM   OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID ='"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(CLINIC_CODE) LIKE UPPER(?) ORDER BY 1";
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
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value=tdesc;
		obj.value=tcode;
	}
}
async function searchWardclinic(obj){
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var code_name = obj.name;
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var ward = document.forms[0].transfer.value;
	if(ward=="W")
	{
	var tit= getLabel("Common.nursingUnit.label","common");

	var sql="SELECT IP_GET_DESC.IP_NURSING_UNIT('"+facility_id+"',NURSING_UNIT_CODE,'"+locale+"',2) DESCRIPTION,NURSING_UNIT_CODE CODE FROM IP_NURSING_UNIT WHERE FACILITY_ID ='"+facility_id+"' AND EFF_STATUS ='E' AND UPPER(IP_GET_DESC.IP_NURSING_UNIT('"+facility_id+"',NURSING_UNIT_CODE,'"+locale+"',2)) LIKE UPPER(?) AND UPPER(NURSING_UNIT_CODE) LIKE UPPER(?) ORDER BY 1";
	}
	else if(ward=="C")
	{
		var tit=getLabel("Common.clinic.label","common");
		var sql="SELECT LONG_DESC DESCRIPTION, CLINIC_CODE CODE FROM   OP_CLINIC_LANG_VW WHERE FACILITY_ID ='"+facility_id+"' AND LANGUAGE_ID='"+locale+"'AND NVL(EFF_STATUS,'D') = 'E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(CLINIC_CODE) LIKE UPPER(?) ORDER BY 1";
	}
	
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
	 	var arr=ret1.split(",");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		document.forms[0].ward_desc.value=arr[1];
		document.forms[0].ward_code.value=arr[0];
	}else{
		document.forms[0].ward_desc.value="";
		document.forms[0].ward_code.value="";		
	}
}

function disableWardAndStatus(){
	var formObj = document.forms[0];
	var ward = formObj.transfer.value;

	if(ward=="W" || ward=="C"){
		 if(formObj.check_out.checked){
		 formObj.WardLookUp.disabled=false;
		 formObj.ward_desc.disabled=false;
		}
		formObj.status.disabled=false;
		formObj.ward_code.value="";
		formObj.ward_desc.value="";
	}else {
		formObj.WardLookUp.disabled=true;
		formObj.ward_desc.disabled=true;
		formObj.ward_code.value="";
		formObj.ward_desc.value="";
		formObj.status.value="";
		formObj.status.disabled=true;
	}
}

function funRecoveryNotes(){
	var formObj =  parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var title=getLabel("eOT.RecoveryNotes.Label","OT");
	title=encodeURIComponent(title);
	var slate_user_id=document.forms[0].slate_user_id.value;
	var facility_id = formObj.facility_id.value;//1
	var patient_id = formObj.patient_id.value;//2
	var episode_id = formObj.episode_id.value;//3
	var patient_class = formObj.patient_class.value;//4
	var encounter_id = formObj.encounter_id.value;//5
	var called_from =getLabel("eOT.RecoveryNotes.Label","OT")
	var accession_num=formObj.oper_num.value;//7
	var speciality_code=formObj.oper_speciality_code.value;//8
	var locn_type = "40";//from Recovery Notes Locn type=40;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=Surgeon_notes_dispaly&accession_num="+accession_num+"&facility_id="+facility_id+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&called_from="+called_from+"&speciality_code="+speciality_code+"&locn_type="+locn_type+"&slate_user_id="+slate_user_id,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);

	var arr_spec=retVal.split("~");
	var arr2_spec="";
	var note_type_value="";
	for (var m=0;m<arr_spec.length-1;m++ )
	{
		note_type_value=arr_spec[m];
		arr2_spec=note_type_value.split(",");
		opt = parent.frames[2].document.createElement('OPTION');
		opt.text =arr2_spec[1];
		opt.value=arr2_spec[0];

		parent.frames[2].document.forms[0].contr_mod_accession_num.value=arr2_spec[2];
		parent.frames[2].document.forms[0].update_mode.value=arr2_spec[3];
		parent.frames[2].document.forms[0].accession_num.value=arr2_spec[4];
		parent.frames[2].document.forms[0].note_type_val.add(opt);		
	}
}
async function onselectnotetype(obj){		
	var formObj =  parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	//var title="Recovery Notes";
	var title=getLabel("eOT.RecoveryNotes.Label","OT");
	title=encodeURIComponent(title);
	var slate_user_id=document.forms[0].slate_user_id.value;
	var facility_id = formObj.facility_id.value;//1
	var patient_id = formObj.patient_id.value;//2
	var episode_id = formObj.episode_id.value;//3
	var patient_class = formObj.patient_class.value;//4
	var encounter_id = formObj.encounter_id.value;//5
	//var called_from = "RECOVERY_NOTES";//6
	var called_from =getLabel("eOT.RecoveryNotes.Label","OT")
	var accession_num= formObj.accession_num.value;
	var speciality_code=formObj.oper_speciality_code.value;//8
	var locn_type = "40";//from Recovery Notes Locn type=40;
	var function_id="SPCL_NOTE";
	var event_class="$PHY$";
	var window_close="Y";
	var hide_header="N";
	var tab_yn="N";
		var oper_num = formObj.oper_num.value;

	var update_mode=formObj.update_mode.value;
	if(obj.value !="")
	{			
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=chk_note_exists&accession_num="+oper_num+"&facility_id="+facility_id+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&called_from=HOLD_NOTES&speciality_code="+speciality_code+"&locn_type="+locn_type+"&slate_user_id="+slate_user_id,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
	if(retVal =="")
	{
		var action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=OT_NOTES&title="+title+"&note_type="+obj.value+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+parent.frames[2].document.forms[0].accession_num.value+"&window_close="+window_close+"&ot_speciality_code="+speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+parent.frames[2].document.forms[0].contr_mod_accession_num.value+"&performed_by_ql="+formObj.strUser.value;//ML-MMOH-SCF-1105

		var title1="";
		var dialogHeight= "100";
		var dialogWidth	= "100";
		var status = "no";
		var arguments	= "";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		secondwindow  = await window.showModalDialog(action_url, title1, features);

		parent.frames[2].document.forms[0].note_type_val.selectedIndex=0;
		}else
		{
		var arr_spec=retVal.split("*");
		var arr2_spec="";
		var note_type_value="";
		var accession_num="";
		for (var m=0;m<arr_spec.length-1;m++ )
		{

			note_type_value=arr_spec[m];
			arr2_spec=note_type_value.split(",");
			opt = parent.frames[0].document.createElement('OPTION');
			opt.text =arr2_spec[1];
			opt.value=arr2_spec[0];
			parent.frames[2].document.forms[0].contr_mod_accession_num.value=arr2_spec[2];
			parent.frames[2].document.forms[0].update_mode.value=arr2_spec[3];
			parent.frames[2].document.forms[0].accession_num.value=arr2_spec[4];
		}
		if(arr2_spec[0]==obj.value)
		{
			var action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=OT_NOTES&title="+title+"&note_type="+obj.value+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+parent.frames[2].document.forms[0].accession_num.value+"&window_close="+window_close+"&ot_speciality_code="+speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+parent.frames[2].document.forms[0].contr_mod_accession_num.value+"&performed_by_ql="+formObj.strUser.value;//ML-MMOH-SCF-1105
			var title1="";
			var dialogHeight= "100";
			var dialogWidth	= "100";
			var status = "no";
			var arguments	= "";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			secondwindow  = await window.showModalDialog(action_url, title1, features);
			parent.frames[2].document.forms[0].note_type_val.selectedIndex=0;
			}else
			{
				alert(getMessage("APP-OT0190","OT"));
			}
		}
	}
}

async function searchRecoveryRoomforCheckIn(obj,target){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var oper_num= document.forms[0].oper_num.value;
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var tit=getLabel("eOT.RecoveryRoom.Label","OT");
   	
	//var sql="SELECT RECOVERY_ROOM_DESC DESCRIPTION,RECOVERY_ROOM_CODE CODE FROM OT_RECOVERY_ROOM_LANG_VW WHERE OPERATING_FACILITY_ID='"+facility_id+"'   and upper(RECOVERY_ROOM_DESC) like upper(?) and upper(RECOVERY_ROOM_CODE) like upper(?) AND LANGUAGE_ID='"+locale+"' AND STATUS ='E'";
	
	var sql = "OTINTERNALREP_6::otsql::"+facility_id+"::"+locale+"::";   // Modified Against MOHE-SCF-0245
	
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
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
		target.value=arr[1];
		document.forms[0].rec_room_code.value=arr[0];
		document.forms[0].rec_room_desc.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
}

async function searchRecoveryRoomforCheckIn_blur(obj,target){
	if(target.value !="")
	{
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var oper_num= document.forms[0].oper_num.value;
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var tit=getLabel("eOT.RecoveryRoom.Label","OT");
	
   	var sql="SELECT RECOVERY_ROOM_DESC DESCRIPTION,RECOVERY_ROOM_CODE CODE FROM OT_RECOVERY_ROOM_LANG_VW WHERE OPERATING_FACILITY_ID='"+facility_id+"'   and upper(RECOVERY_ROOM_DESC) like upper(?) and upper(RECOVERY_ROOM_CODE) like upper(?) AND LANGUAGE_ID='"+locale+"' AND STATUS ='E'";
	
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
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
		target.value=arr[1];
	
		document.forms[0].rec_room_code.value=arr[0];
		document.forms[0].rec_room_desc.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
	}
}

function paintBillDetails(Total,Payable,Paid,include_exclude,Appr_reqd_val){
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

function getServPanelDtls(obj,serv_code){
	var formObj=document.forms[0];
	var disabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/disabled.gif'></img>";
	var enabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/enabled.gif'></img>";
	if(obj.value>0)
	{
		var locale = formObj.locale.value;
		var units_modified=formObj.charge_units.value;
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
		var params = "units="+units_modified+"&serv_code="+serv_code+"&locale="+locale+"&facility_id="+facility_id+"&oper_num="+oper_num+"&module_id="+module_id+"&patient_id="+patient_id+"&booking_num="+booking_num+"&order_id="+order_id+"&speciality_code="+speciality_code+"&oper_code="+oper_code+"&surgeon_code="+surgeon_code;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","ChkInOutRecoveryChargeUnits.jsp?func_mode=callServPanel&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var arrVal=retVal.split("$$");
		var Total=arrVal[2];
		var Payable=arrVal[3];
		var Paid = arrVal[6];
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
		document.getElementById("charge_details_1").style.display='Inline';
		formObj.include_exclude.value=include_exclude;
		formObj.appr_reqd_val.value=Appr_reqd_val
		paintBillDetails(Total,Payable,Paid,include_exclude,Appr_reqd_val);
		formObj.modified_charge_units.value=units_modified;
	}
	else
	{
		var msg = getMessage("APP-OT0068","OT");
		var msgArray = msg.split("#");
		var chargableunits = getLabel("eOT.ChargableUnits.Label","OT");
		
		msg=msgArray[0]+chargableunits+msgArray[1];
		alert(msg)
		obj.select();
	}
}

function callBillingWindow(){
	var formObj=document.forms[0];
	var oper_num=formObj.oper_num.value;
	var bay_code="";
	var service_code="";
	var charge_units="";
	var key="";
	var key_line="";
	bay_code=formObj.recovery_room_code.value;
	service_code=formObj.service_code.value;
	charge_units=formObj.charge_units.value;
	key=formObj.accession_num.value;
	key_line = "1";
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
}

function callBillingWindow1(){
	var formObj=document.forms[0];
	var oper_num=formObj.oper_num.value;
	var bay_code="";
	var service_code="";
	var charge_units="";
	var key="";
	var key_line="";
	bay_code=formObj.recovery_room_code.value;
	service_code=formObj.service_code.value;
	charge_units=formObj.charge_units.value;
	key=formObj.accession_num.value;
	key_line = "1";
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
	var param = "key="+key+"&key_line="+key_line+"&oper_num="+oper_num+"&bay_code="+bay_code+"&service_code="+service_code+"&charge_units="+charge_units+"&called_from=PassBillDetails&room_id=RR";
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
	var order_id=arr[0]; 
	var order_line_no=arr[1];									//--- to be check
	var bean_id=""; 
	var total_qty =formObj.charge_units.value;				//---to be check
	var appr_reqd_value =formObj.appr_reqd_val.value;				//---to be check
	var revised_qty = formObj.charge_units.value;
	var original_qty = formObj.calc_chrge_units.value; //calc_chrge_units,charge_units 
	var bl_panel_str = arr[13];	//Panel Str returing from units
	var index_val="";
	var dialogTop = "100";
	var dialogHeight = "30" ;
	var dialogWidth = "70" ;
	var inc_exe=""; // dummy var created for painting the bill details in front end
	var apprvl_reqd_yn="";  // dummy var created for painting the bill details in front end
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
			paintBillDetails(retArray[1],retArray[2],retArray[3],inc_exe,apprvl_reqd_yn);
			PaintPanelStringval();
		}
}

function PaintPanelStringval(){
	var formObj=document.forms[0];
	var oper_num=formObj.oper_num.value;
	var bay_code="";
	var service_code="";
	var charge_units="";
	var key="";
	var key_line="";
	bay_code=formObj.recovery_room_code.value;
	service_code=formObj.service_code.value;
	charge_units=formObj.charge_units.value;
	key=formObj.accession_num.value;
	key_line = "1";
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

function callChargeableUnits(){
	var formObj=document.forms[0];
	var facility_id=formObj.facility_id.value;
	//var chk_in_date=formObj.start_date.value;
	//Added Against SKR-SCF-1287 Starts
	var formObjHdr = parent.document.frames.common_patient_hdr_frame.document.CommonOperDtlsHdrForm;
	var rec_start_time = formObjHdr.rec_start_time.value;
	var rec_end_time =formObjHdr.rec_end_time.value;
	if(rec_start_time.length>0){
	var arr1 = rec_start_time.split(" ");
	var chk_in_date=arr1[0];
	}
	var change_out_date=formObj.current_date.value;
	var change_out_date_time=formObj.current_time.value;
	//Added Against SKR-SCF-1287 Ends
	var chk_in_time=formObj.start_time.value;
	//var change_out_date=formObj.end_date.value;
	//var change_out_date_time=formObj.end_time.value;
	var recovery_room_desc=formObj.recovery_room_desc.value;

	if(change_out_date_time!=""){
		var arr=chk_in_date.split("/");
		var chk_in_cnvrt_date=arr[1]+"/"+arr[0]+"/"+arr[2];
		var ar=change_out_date.split("/");
		var chk_out_cnvrt_date=ar[1]+"/"+ar[0]+"/"+ar[2];
		var chk_in_dt_time=chk_in_cnvrt_date+" "+chk_in_time;
		var chk_out_dt_time=chk_out_cnvrt_date+" "+change_out_date_time;
		var recovery_room_code=formObj.rec_room_code.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "chk_in_dt_time="+chk_in_dt_time+"&chk_out_dt_time="+chk_out_dt_time+"&recovery_room_code="+recovery_room_code+"&facility_id="+facility_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","ChkInOutRecoveryChargeUnits.jsp?func_mode=callChargeUnits&"+params,false);
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
			formObj.charge_units.value=arrVal[0];
			formObj.service_code.value=arrVal[1];
			formObj.calc_chrge_units.value=arrVal[0];
			formObj.modified_charge_units.value=arrVal[0];
			units=arrVal[0];
			serv_code=arrVal[1];
			callGetServPanelDtls(units,serv_code);		
		}
	}else{
			var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.RecoveryEndDate.Label","OT"));
			alert(msg1);
			return;
	}
}

function callGetServPanelDtls(units, serv_code){
	var disabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/disabled.gif'></img>";
	var enabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/enabled.gif'></img>";
	var formObj=document.CheckInToRecoveryRoomForm;
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
	var params = "units="+units+"&serv_code="+serv_code+"&locale="+locale+"&facility_id="+facility_id+"&oper_num="+oper_num+"&module_id="+module_id+"&patient_id="+patient_id+"&booking_num="+booking_num+"&order_id="+order_id+"&speciality_code="+speciality_code+"&oper_code="+oper_code+"&surgeon_code="+surgeon_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ChkInOutRecoveryChargeUnits.jsp?func_mode=callServPanel&"+params,false);
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
	document.getElementById("charge_details_1").style.display='Inline';
	formObj.include_exclude.value=include_exclude;
	formObj.appr_reqd_val.value=Appr_reqd_val
	paintBillDetails(Total,Payable,Paid,include_exclude,Appr_reqd_val);
}

function getRecRoomFinalizationCheck(){
	var formObj=document.forms[0];
	var facility_id=formObj.facility_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "func_mode=getRecoveryRoomCheck&facility_id="+facility_id;
	xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	formObj.rec_room_chrging_stg.value=retVal;
}

function getChargeRecoveryRoomyn(){
	var formObj=document.forms[0];
	var facility_id=formObj.facility_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "func_mode=getChargeRecoveryRoomyn&facility_id="+facility_id;
	xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	return retVal;
}

function hideChargeBillDtls(obj,charge_recovery_room_yn){
	var facility_id = document.forms[0].facility_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=chkRecRoomChrgeYn&facility_id="+facility_id+"&recovery_room_code="+obj;
	xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	

	if(charge_recovery_room_yn=="N" || retVal=="N" ){
		document.getElementById("chrg_unit_show_yn").style.visibility = 'hidden';
		document.getElementById("pyble_unit_show_yn").style.visibility = 'hidden';
	}else if(charge_recovery_room_yn=="Y" && retVal=="Y"){
		document.getElementById("chrg_unit_show_yn").style.visibility = 'visible';
		document.getElementById("pyble_unit_show_yn").style.visibility = 'visible';
	}	
	document.forms[0].rec_room_chrge_yn.value=retVal;
}

function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}

function showCalendar_local(val){
	var formObj=document.forms[0];
	var recovery_room_desc=formObj.recovery_room_desc.value;	
	if(recovery_room_desc==""){
		var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.RecoveryRoom.Label","OT"));
		alert(msg1);
		return false;	
	}else{
		return showCalendar(val);
	}
}

function getchkinrecoverytime(){
	var facility_id = document.forms[0].facility_id.value;
	var oper_num = document.forms[0].oper_num.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=getchkinrecoverytime&facility_id="+facility_id+"&oper_num="+oper_num;
	xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
    return retVal;
}


function validateDate(){
	var formObj=document.forms[0];
	var locale=formObj.locale.value;
	var end_date=formObj.end_date.value;
	var chk_in_rec_end_dt_time=getchkinrecoverytime();
	var chk_in_rec_end_dt_time1=chk_in_rec_end_dt_time.split(" ");
	var chk_in_rec_end_dt=chk_in_rec_end_dt_time1[0];
    if(chk_in_rec_end_dt=='null') chk_in_rec_end_dt="";
	
	if(end_date!=""){
	if(chk_in_rec_end_dt!="" && !isAfter(end_date,chk_in_rec_end_dt,"DMY",locale)){
		alert("Check Out Recovery Date Should Not Be Lesser Than Check In Recovery Date");
		formObj.end_date.value="";
		formObj.end_time.disabled=true;
		return false;
	}else {
		formObj.end_time.disabled=false;
		return true;			
	}	
	}else{
		return false;
	}
}

function validateDtTime(obj){
	var formObj=document.forms[0];
	var rec_room_chrge_yn=formObj.rec_room_chrge_yn.value;
	var locale=formObj.locale.value;
	var end_date=formObj.end_date.value;
	var end_time=formObj.end_time.value;
	var chk_in_rec_end_dt_time=getchkinrecoverytime();	
	var chk_out_rec_dt_time=end_date+" "+end_time;	
	if(chk_in_rec_end_dt_time=='null')chk_in_rec_end_dt_time="";
	
	var dateDiff = compareDates(chk_in_rec_end_dt_time,chk_out_rec_dt_time,locale,"DMYHM"); //Added Against ML-MMOH-SCF-1726
	
	var duration=obj.value;
	var bl_interface_flag=formObj.bl_interface_flag.value;
	var charge_recovery_room_yn=formObj.charge_recovery_room_yn.value;
	if(duration!=''){
	if(duration.length!="5" ){
		alert(getMessage("APP-OT0130","OT"));
		obj.value="";
		obj.focus()
		return;
	}
}
	var RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;
	if(obj.value!="" && !RE_EXP.test(obj.value) ){
		var err_text="";
	    var time = obj.value;
	    var arr_time =  time.split(":")
        if(arr_time.length!=2){
			cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}
		else if(arr_time[1]=='' || arr_time[0]==''){
		cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}
		else
			 if(arr_time[0]<0 || arr_time[0]>23 ){
			err_text+=getMessage("APP-OT0040","OT");
		}
		else  if(arr_time[1]<0 || arr_time[1]>59 ){
			err_text+=getMessage("APP-OT0041","OT");
		}
		else if(err_text.length>0)	
			cal_error(err_text,obj);
		}
		 //else if(end_time!="" && chk_in_rec_end_dt_time!="" &&		!isAfter(chk_out_rec_dt_time,chk_in_rec_end_dt_time,"DMYHM",locale)){
			
		 //else if(end_time!="" && chk_in_rec_end_dt_time!="" &&	(chk_out_rec_dt_time<chk_in_rec_end_dt_time)){ //Modified Against SKR-SCF-1287
		 else if(end_time!="" && chk_in_rec_end_dt_time!="" &&	dateDiff==false){ //Modified Against ML-MMOH-SCF-1726
			 alert("Check Out Recovery Time Should Not Be Lesser Than Check In Recovery Time");
			 formObj.end_time.select();
			 return false;
		} 
		else if(end_time=="" )
	    {
			var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.RecoveryEndTime.Label","OT"));
			alert(msg1);
			formObj.end_time.select();
			return false;
	    }else {
		if(bl_interface_flag=="Y" && charge_recovery_room_yn=="Y" && rec_room_chrge_yn=="Y")
			callChargeableUnits();
			return true;
		}	
	return true;
}

function cal_error (str_message,obj) {
	alert (str_message);
	obj.value="";
	obj.focus();
	return null;
}
/* 
function isValidDate(obj){
	if(obj.value!=""){
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);//flag=false;
		if(arr_date[0]!=null)
		{
		if (arr_date[0].length !=2 ) flag=false;
		}
		if(arr_date[1]!=null)
		{
		if (arr_date[1].length !=2 ) flag=false;
		}
		if(arr_date[2]!=null)
		{
		if (arr_date[2].length !=4 ) flag=false;
		}
		if (!arr_date[0]) flag=false;
		if (!RE_NUM.exec(arr_date[0])) flag=false;
		if (!arr_date[1]) flag=false;
		if (!RE_NUM.exec(arr_date[1])) flag=false;
		if (!arr_date[2]) flag=false;
		if (arr_date[2].length!=4) flag=false;
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;
		if (flag==false){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
	}
	return true;
} */


//Added Against SKR-SCF-1287 Starts
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
//Added Against SKR-SCF-1287 Ends
