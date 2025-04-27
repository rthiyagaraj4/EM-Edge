
function callCalender(obj,date_obj){
	return showCalendar(date_obj,'dd/mm/yyyy','hh24:mi');
}

function setSendoutDefaultValues(){
	var formObj = document.forms[0];
	/*
	if(formObj.sendout_parct.DB_VALUE == "" ){
			formObj.sendout_parct.value = "";
	}
	else{
		formObj.sendout_parct.value = formObj.sendout_parct.DB_VALUE;
	}*/

	if(formObj.sendout_perm_loc.DB_VALUE == "" ){
			formObj.sendout_perm_loc.value = "";
	}
	else{
		formObj.sendout_perm_loc.value = formObj.sendout_perm_loc.DB_VALUE;
	}

	
	/*
	if(formObj.sendout_facility.DB_VALUE == "" ){
			formObj.sendout_facility.value = "";
	}
	else{
		formObj.sendout_facility.value = formObj.sendout_facility.DB_VALUE;
	}

	if(formObj.sendout_location.DB_VALUE == "" ){
			formObj.sendout_location.value = "";
	}
	else{
		formObj.sendout_location.value = formObj.sendout_location.DB_VALUE;
	}
	

	formObj.sendout_facility.disabled = true;
	formObj.sendout_location.disabled = true;
	*/
}

function setAckDefaultValues(){
	var formObj = document.forms[0];
	var cur_date = formObj.cur_date.value;
//	var locale = formObj.locale.value;
	//var cur_date =  convertDate(formObj.cur_date.value,'DMYHM',"en",locale);
//formObj.ack_recvd_date.value = cur_date;
	//formObj.ack_expected_date.value = cur_date;
}

function setRcvDefaultValues(){

	var formObj = document.forms[0];
	var cur_date = formObj.cur_date.value;
	//formObj.recv_recvd_date.value = cur_date;
}

function setSendoutAckValue(action){
	if(action == "SendOut"){
		if(document.forms[0].sendout_completed.checked==false)
			document.forms[0].sendout_completed.value="N";
		else{
			document.forms[0].sendout_completed.value="Y";
		}
	}
	else if(action == "Acknowledge"){
		if(document.forms[0].ack_completed.checked==false)
			document.forms[0].ack_completed.value="N";
		else{
			document.forms[0].ack_completed.value="Y";
		}
	}
	else if(action == "Recieve"){
		if(document.forms[0].recv_completed.checked==false)
			document.forms[0].recv_completed.value="N";
		else{
			document.forms[0].recv_completed.value="Y";
		}
	}
}

function sendOutAction(){
	var formObj = document.forms[0];
	var sendout_completed = formObj.sendout_completed.value;
	var note_event_status = formObj.note_event_status.value;

	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var trmt_code = formObj.trmt_code.value;
	var task_code = formObj.task_code.value;
	var task_seq_no = formObj.task_seq_no.value;
	var seq_no = formObj.seq_no.value;
	var messageFrame = parent.parent.parent.parent.parent.messageFrame;
	var contr_mod_accession_num = patient_id+"$"+chart_num+"$"+chart_line_num+"$"+seq_no;//Added for CRF-702(IN012606) by Sridevi Joshi on 081009
	//BL09032439$1$1$1
	
	if(formObj != null){
		var facility_id_title=getLabel("Common.facility.label","Common");
		var location_title = getLabel("Common.Location.label","Common");
		if(sendout_completed == "Y"){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "contr_mod_accession_num="+contr_mod_accession_num;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","OHTrmtSendOutAckValidation.jsp?func_mode=checkNotesCompletedYN&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal= trimString(xmlHttp.responseText);
			retVal = localtrimString(retVal);
			var retVal_arr = retVal.split("##");
			var event_status = retVal_arr[0];
			accession_num = retVal_arr[1];
			//event_status = "4";

			//formObj.note_event_status.value = event_status;
			if(event_status != "4" && event_status != ""){
				alert(getMessage("APP-OH000133","OH")); //APP-OH000133
				return;
			}
			else{
				if(event_status == ""){
					var proceed_yn = confirm(getMessage("APP-OH000134","OH")); //Confirmation message added for IN015685 by Sridevi Joshi on 26/20/09
					if(proceed_yn){
						if(checkDateTimeValidations(formObj.sendout_date,'sendout')){
							formObj.submit();
							formObj.sendout_parct.disabled = true;
							formObj.sendout_perm_loc.disabled = true;
							formObj.sendout_completed.disabled = true;
							formObj.sendout_personnel.disabled = true;
							formObj.sendout_date.disabled = true;
							document.getElementById("sendout_cal").disabled = true;
							formObj.save.disabled = true;
							formObj.reset.disabled = true;

							parent.frames[0].document.getElementById("TrmtAcknowledge").disabled = false;
							if(event_status != ""){
								var view_notes_label = getLabel("eOH.ViewLabDetails.Label","OH");
								document.getElementById("viewRecordNotes").innerHTML=view_notes_label;
							}
							else{
								var view_notes_label = "";
								document.getElementById("viewRecordNotes").innerHTML=view_notes_label;
							}
						}
					}else{
						formObj.sendout_completed.checked = false;
						formObj.sendout_completed.value = "N";
						return;
					}
				}else{
					if(checkDateTimeValidations(formObj.sendout_date,'sendout')){
						formObj.submit();
						formObj.sendout_parct.disabled = true;
						formObj.sendout_perm_loc.disabled = true;
						formObj.sendout_completed.disabled = true;
						formObj.sendout_personnel.disabled = true;
						formObj.sendout_date.disabled = true;
						document.getElementById("sendout_cal").disabled = true;
						formObj.save.disabled = true;
						formObj.reset.disabled = true;

						parent.frames[0].document.getElementById("TrmtAcknowledge").disabled = false;
						if(event_status != ""){
							var view_notes_label = getLabel("eOH.ViewLabDetails.Label","OH");
							document.getElementById("viewRecordNotes").innerHTML=view_notes_label;
						}
						else{
							var view_notes_label = "";
							document.getElementById("viewRecordNotes").innerHTML=view_notes_label;
						}
					}
				}
			}
		}
		else{
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&task_seq_no="+task_seq_no+"&called_from=sentout";

			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","OHTrmtSendOutAckValidation.jsp?func_mode=getAckDetailsFromDB&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal= trimString(xmlHttp.responseText);
			retVal = localTrimString(retVal);

			var retVal_arr = retVal.split("##");
			var sendout_parct_db = retVal_arr[0];
			var sendout_perm_loc_db = retVal_arr[1];
			var sendout_date_db = retVal_arr[2];
			var sendout_personnel_db = retVal_arr[3];
			var sendout_completed_db = retVal_arr[4];
			if(formObj.sendout_parct.value != sendout_parct_db || formObj.sendout_perm_loc.value != sendout_perm_loc_db || formObj.sendout_completed.value != sendout_completed_db || formObj.sendout_personnel.value != sendout_personnel_db || formObj.sendout_date.value != sendout_date_db){
				if(checkDateTimeValidations(formObj.sendout_date,'sendout')){
					formObj.submit();
				}
			}else{
				var messageFrame = parent.parent.parent.parent.parent.messageFrame;
				var msg = getMessage("NO_CHANGE_TO_SAVE","Common");
				//var msg = "NO_CHANGE_TO_SAVE";
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg ;
				return;
			}
		}
	}
}

function ackAction(){
	var formObj = document.forms[0];
	var ack_completed = formObj.ack_completed.value;
	//var params = formObj.params.value;
	/*
	var acknowledge_date_hid = formObj.acknowledge_date_hid.value;
	var ack_receipt_no_hid = formObj.ack_receipt_no_hid.value;
	var acknowledged_by_hid = formObj.acknowledged_by_hid.value;
	var expected_delivery_date_hid = formObj.expected_delivery_date_hid.value;
	var acknowledged_yn_hid = formObj.acknowledged_yn_hid.value;
	*/
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var trmt_code = formObj.trmt_code.value;
	var task_code = formObj.task_code.value;
	var task_seq_no = formObj.task_seq_no.value;

	var messageFrame = parent.parent.parent.parent.parent.messageFrame;
	if(formObj != null){
		
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&task_seq_no="+task_seq_no+"&called_from=ack";

		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OHTrmtSendOutAckValidation.jsp?func_mode=getAckDetailsFromDB&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal= trimString(xmlHttp.responseText);
		retVal = localTrimString(retVal);
		var retVal_arr = retVal.split("##");
		var acknowledge_date_hid = retVal_arr[0];
		var ack_receipt_no_hid = retVal_arr[1];
		var acknowledged_by_hid = retVal_arr[2];
		var expected_delivery_date_hid = retVal_arr[3];
		var acknowledged_yn_hid = retVal_arr[4];

		if(formObj.ack_recvd_date.value != acknowledge_date_hid || formObj.ack_recpt_no.value != ack_receipt_no_hid || formObj.ack_personnel.value != acknowledged_by_hid || formObj.ack_expected_date.value != expected_delivery_date_hid || formObj.ack_completed.value != acknowledged_yn_hid){

			if(checkDateTimeValidations(formObj.ack_recvd_date,'ack')){
				formObj.submit();

				if(formObj.ack_completed.checked == true){
					formObj.ack_recvd_date.disabled = true;
					document.getElementById("ack_recvd_cal").disabled = true;
					formObj.ack_recpt_no.disabled = true;
					formObj.ack_personnel.disabled = true;
					formObj.ack_expected_date.disabled = true;
					document.getElementById("ack_expected_cal").disabled = true;
					formObj.ack_completed.disabled = true;
					formObj.save.disabled = true;
					formObj.reset.disabled = true;
				}

				if(ack_completed == "Y"){
					parent.frames[0].document.getElementById("TrmtRecieve").disabled = false;
				}
			}
		}else{
			var messageFrame = parent.parent.parent.parent.parent.messageFrame;
			var msg = getMessage("NO_CHANGE_TO_SAVE","Common");
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg ;
			return;
		}
	}
}

function rcvAction(){
	var formObj = document.forms[0];
	var recv_completed = formObj.recv_completed.value;
	var messageFrame = parent.parent.parent.parent.parent.messageFrame;

	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var trmt_code = formObj.trmt_code.value;
	var task_code = formObj.task_code.value;
	var task_seq_no = formObj.task_seq_no.value;

	if(formObj != null){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&task_seq_no="+task_seq_no+"&called_from=rcv";

		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OHTrmtSendOutAckValidation.jsp?func_mode=getAckDetailsFromDB&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal= trimString(xmlHttp.responseText);
		retVal = localTrimString(retVal);

		var retVal_arr = retVal.split("OH2SEP21");
		var received_date_db = retVal_arr[0];
		var received_by_db = retVal_arr[1];
		var received_yn_db = retVal_arr[2];
		var remarks_db = retVal_arr[3];
		var lab_price_db = retVal_arr[4];
		var rcv_receipt_no_db = retVal_arr[5];

		if(formObj.recv_recvd_date.value != received_date_db || formObj.recv_personnel.value != received_by_db || formObj.recv_remarks.value != remarks_db || formObj.recv_completed.value != received_yn_db || formObj.recv_lab_price.value != lab_price_db || formObj.recv_recpt_no.value != rcv_receipt_no_db){

			if(checkDateTimeValidations(formObj.recv_recvd_date,'recv')){
				formObj.submit();

				if(formObj.recv_completed.checked == true){
					formObj.recv_recvd_date.disabled = true;
					document.getElementById("recv_recvd_cal").disabled = true;
					formObj.recv_personnel.disabled = true;
					formObj.recv_remarks.disabled = true;
					formObj.recv_completed.disabled = true;
					formObj.recv_recpt_no.disabled = true;

					formObj.lab_price_db.disabled = true;
					formObj.save.disabled = true;
					formObj.reset.disabled = true;
				}

				if(recv_completed == "Y"){
					parent.frames[0].document.getElementById("TrmtResultEntry").disabled = false;
				}
			}
		}
		else{
			var messageFrame = parent.parent.parent.parent.parent.messageFrame;
			var msg = getMessage("NO_CHANGE_TO_SAVE","Common");
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg ;
			return;
		}
	}
}

function sendOutReset(){
	var formObj = document.forms[0];
	var params = formObj.params.value;
	/*
	var cur_date = formObj.cur_date.value;
	formObj.sendout_perm_loc.value = "";
	formObj.sendout_completed.value = "";
	formObj.sendout_completed.checked = false;
	formObj.sendout_personnel.value = "";
	formObj.sendout_date.value = cur_date;*/

	//setSendoutDefaultValues();

	parent.frames[1].location.href='../../eOH/jsp/OHTrmtSendOut.jsp?'+params;
}

function ackReset(){
	var formObj = document.forms[0];
	var params = formObj.params.value;
	/*
	var cur_date = formObj.cur_date.value;
	formObj.ack_recpt_no.value = "";
	formObj.ack_personnel.value = "";
	formObj.ack_completed.checked = false;
	formObj.ack_recvd_date.value = cur_date;
	formObj.ack_expected_date.value = cur_date;*/

	//setAckDefaultValues();

	parent.frames[1].location.href='../../eOH/jsp/OHTrmtAcknowledge.jsp?'+params;
}

function rcvReset(){
	var formObj = document.forms[0];
	var params = formObj.params.value;
	/*
	var cur_date = formObj.cur_date.value;
	formObj.recv_personnel.value = "";
	formObj.recv_completed.checked = false;
	formObj.recv_remarks.value = "";
	formObj.recv_recvd_date.value = cur_date;*/

	//setRcvDefaultValues();

	parent.frames[1].location.href='../../eOH/jsp/OHTrmtRecieveDetails.jsp?'+params;
}

async function openClinicalNotes(){
	var formObj = document.forms[0];
	var params = formObj.params.value;
	var facility_id = formObj.facility_id.value;
	var patient_id = formObj.patient_id.value;
	var visit_id = "";//formObj.visit_id.value;
	var episode_id = formObj.episode_id.value;
	var episode_type = formObj.episode_type.value;
	var patient_class = formObj.patient_class.value;
	var encounter_id = formObj.encounter_id.value;
	var accession_num = formObj.chart_num.value;
	var speciality_code = formObj.speciality_code.value;
	var location_code = formObj.location_code.value;
	var location_type = formObj.location_type.value;
	var task_code = formObj.task_code.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var trmt_code = formObj.trmt_code.value;
	var task_seq_no = formObj.task_seq_no.value;
	var seq_no = formObj.seq_no.value;
	var called_from = formObj.called_from.value;
	var contr_mod_accession_num = patient_id+"$"+chart_num+"$"+chart_line_num+"$"+seq_no;//Added for CRF-702(IN012606) by Sridevi Joshi on 081009

	//Added for CRF-702(IN012606) by Sridevi Joshi on 081009 to get the note_type
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "task_code="+task_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OHTrmtSendOutAckValidation.jsp?func_mode=getNoteType&"+params,false);
	xmlHttp.send(xmlDoc);
	var note_type= trimString(xmlHttp.responseText);
	note_type = localtrimString(note_type);

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "contr_mod_accession_num="+contr_mod_accession_num;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OHTrmtSendOutAckValidation.jsp?func_mode=checkNotesCompletedYN&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal= trimString(xmlHttp.responseText);
	retVal = localtrimString(retVal);
	var retVal_arr = retVal.split("##");
	//var event_status = retVal_arr[0];
	accession_num = retVal_arr[1];
		
	var function_id="SPCL_NOTE"; //Added for CRF-702(IN012606) by Sridevi Joshi on 081009
	var event_class="$PHY$";
	var window_close="Y";
	var hide_header="Y";
	var tab_yn="N";
	var query_flag_yn = "N";
	var title = getLabel("Common.ClinicalNotes.label","Common");
	var url="";
	if(query_flag_yn=="N"){
		 url = "../../eCA/jsp/RecClinicalNotesModal.jsp?title="+title+"&appl_task_id=OH&note_type="+note_type+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+accession_num+"&window_close="+window_close+"&speciality_code="+speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+contr_mod_accession_num+"&location_code="+location_code;

	}else if(query_flag_yn=="Y"){
		url = "../../eCA/jsp/PhysicanNotesDetails.jsp?title="+title+"&appl_task_id=OH&note_type="+note_type+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+accession_num+"&window_close="+window_close+"&speciality_code="+speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+contr_mod_accession_num+"&location_code="+location_code;
	}

	//Added by Sridevi Joshi for IN016003 on 04/11/09
	var dialogHeight = "80vh" ;
	var dialogWidth  = "80vw" ;
	var dialogTop    = "10";
	var dialogLeft   = "50";

	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no;channelmode=yes" ;

	//var features = "channelmode=yes";
	//window.open(url,"CAWindow",features);
	await top.window.showModalDialog(url,"CAWindow",features);
}

//Date Validation Check
function checkDateValidity(obj){
	var formObj = document.forms[0];
	var locale = formObj.locale.value;
	if(obj.value!=null && obj.value!=""){
		var retVal = CheckDate(obj.value,obj);
	 //   var retVal = CheckDate(convertDate(obj.value,'DMY',locale,"en"),obj);
		if(retVal==false){
			obj.focus();
			obj.select();
			//return false;
			return false;
		}
	}
	return true;
}

//Time Validation check
function checkTimeValidity(obj,time){
	if(time!=null && time!=""){
		var retVal = chkTime(time);
		if(retVal==false){
			alert(getMessage("INVALID_DATE_FMT", "SM"));		
			obj.focus();
			obj.select();
			return false;
		}
	}
	return true;
}

//Function to validate the Date in yyyy/MM/DD

 function CheckDate(Object2,obj) {
	var datefield = Object2;
	var focus_obj = obj;
	if (Object2.value != undefined)
    {
		Object2 = Object2.value;
    }
	else
	{
		Object2 = Object2;
	}

	hasChanged= true;
    if (ChkDate(Object2) == false) {
		if(hasChanged){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			if (datefield.value != undefined && focusflag == null)
			{
				datefield.select();
				datefield.focus();
			}
			hasChanged = false;
			return false;
		}
	}
    else{
		var strDate;
		var strDateTimeArray = new Array();
		var datefield = Object2;
		strDate = datefield;
		if (strDate.length == 0) return true;
		if(Object2.indexOf('.') > 0) return false;
		strDateTimeArray = strDate.split(" ");
		if(checkTimeValidity(focus_obj,strDateTimeArray[1])){
			return true;
		}
		else{
			return false;
		}
    }
}

function ChkDate(Object3) {
	if (Object3.value != undefined)
    {
		Object3 = Object3.value;
    }
	else
	{
		Object3 = Object3;
	}
    var strDate;
    var strDay;
    var strMonth;
    var strYear;
    var datefield = Object3;
    var strDateArray = new Array();
    var strDateTimeArray = new Array();

    strDate = datefield;
    if (strDate.length == 0) return true;

if(Object3.indexOf('.') > 0) return false;
	
    strDateTimeArray = strDate.split(" ");
    strDateArray = strDateTimeArray[0].split("/");
    if (strDateArray.length != 3) {
        return false;
    }
    else {
        strDay = trimString(strDateArray[0]);
        strMonth = trimString(strDateArray[1]);
        strYear = trimString(strDateArray[2]);
    }


    if (strYear.length < 4 || strYear.length > 4) return false;

    if (isNaN(strDay)==true) return false;
    if (isNaN(strMonth)==true) return false;
    if (isNaN(strYear)==true) return false;

    if (strYear < 1800) return false;

        if (strMonth>12 || strMonth<1)  return false;

    if ((strMonth == 1 || strMonth == 3 || strMonth == 5 || strMonth == 7 || strMonth == 8 || strMonth == 10 || strMonth == 12) && (strDay > 31 || strDay < 1)) return false;

    if ((strMonth == 4 || strMonth == 6 || strMonth == 9 || strMonth == 11) && (strDay > 30 || strDay < 1)) return false;

    if (strMonth == 2) {
        if (strDay < 1) return false;

        if (LeapYear(strYear) == true) {
            if (strDay > 29) return false;
        }
        else {
            if (strDay > 28) return false;
        }
    }
    return true;
}

//Function to check for LeapYear
function LeapYear(strYear) {
    if (strYear % 100 == 0) {
        if (strYear % 400 == 0)  return true;
    }
    else {
        if ((strYear % 4) == 0)  return true;
    }
    return false;
}

function validateSendOutDate(obj){
	var entered_date = obj.value;
	var sys_date = new Date();
	var month = sys_date.getMonth();
	var year = sys_date.getFullYear();
	var date = sys_date.getDate();
	if(entered_date != ""){
		if(entered_date.indexOf("/") != -1){
			var enteredDateArray = entered_date.split("/");
			if(enteredDateArray[0].length == 2 && enteredDateArray[1].length == 2 && enteredDateArray[2].length == 4){
				var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
				var sysDateObject = new Date(year,month,date);
				if(Date.parse(sysDateObject) > Date.parse(enteredDateObject)){
					return true;
				}
				else if(Date.parse(sysDateObject) < Date.parse(enteredDateObject)) {
					alert(getMessage("DATE_NOT_GREATER_SYSDATE",'Common'));
					obj.focus();
					obj.select();
					return false;
				}
			}
			else{
				alert(getMessage("INVALID_DATE_FMT",'SM'));
				obj.focus();
				obj.select();
				return false;
			}
		}
		else{
			alert(getMessage("INVALID_DATE_FMT",'SM'));
			obj.focus();
			obj.select();
			return false;
		}
	}
	return true;
}

// To allow only 0-9 and : while entering time.
 function NumberTimeCheck(obj){ 
	if ((event.keyCode < 47) || (event.keyCode > 58))
	{
		event.keyCode=0;
	}
}

// To allow only 0-9 and . while entering Lab Price.
 function LabPriceNumberCheck(obj){ 
	if ((event.keyCode < 48 && event.keyCode != 46) || (event.keyCode > 57))
	{
		event.keyCode=0;
	}
}

// To restrict only 2 numbers after decimal while entering Lab Price.
 function checkForDecimal(obj){ //check if only decimal is entered for labprice on monday.
	 var lab_price_decimal = obj.value;
	 var count = 0;
	 if(lab_price_decimal != ""){
		var re =/^\d{1,6}(\.\d{1,2})?$/; 
		var ret = re.test(lab_price_decimal); 
		if(ret == false){
			alert(getMessage("APP-OH000135","OH"));
			obj.focus();
			obj.select();
			return false;
		}
	 }
	 return true;
}

function checkDateGreaterThanRegDate(obj,called_from){
	var formObj = document.forms[0];
	var validate_date = obj.value;
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var trmt_code = formObj.trmt_code.value;
	var task_code = formObj.task_code.value;
	var task_seq_no = formObj.task_seq_no.value;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&task_seq_no="+task_seq_no+"&called_from="+called_from;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OHTrmtSendOutAckValidation.jsp?func_mode=getRegDateTime&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal = localtrimString(retVal);
	var retVal_arr = retVal.split("##");
	var regn_date_time = retVal_arr[0];
	var sendout_date_time = retVal_arr[1];
	var ack_date_time = retVal_arr[2];
	var rcv_date_time = retVal_arr[3];
	var sentout_ack_rcv_msg = getMessage("APP-OH000139","OH");
	var sentout_ack_rcv_msg_arr = sentout_ack_rcv_msg.split("##");

	var sentout_ack_rcv_msg1 = getMessage("APP-OH000140","OH");
	var sentout_ack_rcv_msg1_arr = sentout_ack_rcv_msg1.split("##");

	var ack_label = getLabel("eOH.RecievedAcknowledged.Label","OH");
	var sentout_label = getLabel("eOH.SendOutDate.Label","OH");
	var rcv_label = getLabel("Common.ReceivedDate.label","Common");
	var locale = formObj.locale.value;
	//Added by Sharon Crasta on 3/17/2010 for IN019604 - thai conversion
	ack_date_time =  convertDate(ack_date_time,'DMYHM','en',locale) ;
	rcv_date_time =  convertDate(rcv_date_time,'DMYHM','en',locale) ;
	sendout_date_time =  convertDate(sendout_date_time,'DMYHM','en',locale) ;
	rcv_date_time =  convertDate(rcv_date_time,'DMYHM','en',locale) ;
	//End
	
	if(called_from == "sendout" && validate_date != ""){
		
		if(ack_date_time != ""){
			var grater_yn = ValidateDateTime (validate_date,ack_date_time);
			if(!grater_yn){
				alert(sentout_ack_rcv_msg1_arr[0]+" "+sentout_label+sentout_ack_rcv_msg1_arr[1]+" "+ack_label+sentout_ack_rcv_msg1_arr[2]+" "+ack_date_time);
				obj.focus();
				obj.select();
				return false;
			}
		}
	
		

		if(rcv_date_time != ""){
			var grater_yn = ValidateDateTime (validate_date,rcv_date_time);
			if(!grater_yn){
				alert(sentout_ack_rcv_msg1_arr[0]+" "+sentout_label+sentout_ack_rcv_msg1_arr[1]+" "+rcv_label+sentout_ack_rcv_msg1_arr[2]+" "+rcv_date_time);
				obj.focus();
				obj.select();
				return false;
			}
		}
	}

	if(called_from == "ack" && validate_date != ""){
		
		if(sendout_date_time != ""){
			var grater_yn = ValidateDateTime (sendout_date_time,validate_date);
			if(!grater_yn){
				alert(sentout_ack_rcv_msg_arr[0]+" "+ack_label+sentout_ack_rcv_msg_arr[1]+" "+sentout_label+sentout_ack_rcv_msg_arr[2]+" "+sendout_date_time);
				obj.focus();
				obj.select();
				return false;
			}
		}

		if(rcv_date_time != ""){
			
			var grater_yn = ValidateDateTime (validate_date,rcv_date_time);
			if(!grater_yn){
				alert(sentout_ack_rcv_msg1_arr[0]+" "+ack_label+sentout_ack_rcv_msg1_arr[1]+" "+rcv_label+sentout_ack_rcv_msg1_arr[2]+" "+rcv_date_time);
				obj.focus();
				obj.select();
				return false;
			}
		}
	}

	if(called_from == "recv" && validate_date != ""){
		
		if(sendout_date_time != ""){
			var grater_yn = ValidateDateTime(sendout_date_time,validate_date);
			if(!grater_yn){
				alert(sentout_ack_rcv_msg_arr[0]+" "+rcv_label+sentout_ack_rcv_msg_arr[1]+" "+sentout_label+sentout_ack_rcv_msg_arr[2]+" "+sendout_date_time);
				obj.focus();
				obj.select();
				return false;
			}
		}

		if(ack_date_time != ""){
			var grater_yn = ValidateDateTime (ack_date_time,validate_date);
			if(!grater_yn){
				alert(sentout_ack_rcv_msg_arr[0]+" "+rcv_label+sentout_ack_rcv_msg_arr[1]+" "+ack_label+sentout_ack_rcv_msg_arr[2]+" "+ack_date_time);
				obj.focus();
				obj.select();
				return false;
			}
		}
	}
	
	if(regn_date_time.length>1){
		if(validate_date.length > 0 && regn_date_time.length > 0 ) {
			DateTimeArray = validate_date.split(" ");
			fromDateArray = DateTimeArray[0].split("/");
			fromTimeArray	= DateTimeArray[1].split(":");
		 
			regnarray1 = regn_date_time.split(" "); 
			regnSplitDate = regnarray1[0];
			regnSplitTime = regnarray1[1];

			splitdate1 =regnSplitDate.split("/")
			splittime1= regnSplitTime.split(":")

			var from_date  =new Date(eval(fromDateArray[2]), eval(fromDateArray[1])-1, eval(fromDateArray[0]), eval(fromTimeArray[0]), eval(fromTimeArray[1]));
			var regn_date = new Date(eval(splitdate1[2]),eval(splitdate1[1]-1),eval(splitdate1[0]),eval(splittime1[0]),eval(splittime1[1]));
			
			if((Date.parse(regn_date) > Date.parse(from_date)) && called_from == "sendout") {
				alert(getMessage("APP-OH000127","OH") + " " + regn_date_time);
		   		formObj.sendout_date.focus();
				formObj.sendout_date.select();
				return false;
		    }else if((Date.parse(regn_date) > Date.parse(from_date)) && called_from == "ack") {
				alert(getMessage("APP-OH000137","OH") + " " + regn_date_time);
		   		formObj.ack_recvd_date.focus();
				formObj.ack_recvd_date.select();
				return false;
		    }
			else if((Date.parse(regn_date) > Date.parse(from_date)) && called_from == "recv") {
				alert(getMessage("APP-OH000138","OH") + " " + regn_date_time);
		   		formObj.recv_recvd_date.focus();
				formObj.recv_recvd_date.select();
				return false;
		    }
			else if(Date.parse(regn_date) <= Date.parse(from_date)) return true;
		}
	}
	return true;
}

function checkDateGreaterThanSysdate(obj){
	var formObj = document.forms[0];
	var sendout_date = obj.value;
	var sys_date = new Date();
	var month = sys_date.getMonth();
	var year = sys_date.getFullYear();
	var date = sys_date.getDate();

	if(sendout_date.length > 0) {
		DateTimeArray = sendout_date.split(" ");
		fromDateArray = DateTimeArray[0].split("/");
		fromTimeArray	= DateTimeArray[1].split(":");

		splitdate1 =regnSplitDate.split("/")
		splittime1= regnSplitTime.split(":")

		var from_date  =new Date(eval(fromDateArray[2]), eval(fromDateArray[1])-1, eval(fromDateArray[0]), eval(fromTimeArray[0]), eval(fromTimeArray[1]));
		var regn_date = new Date(eval(splitdate1[2]),eval(splitdate1[1]-1),eval(splitdate1[0]),eval(splittime1[0]),eval(splittime1[1]));
		
		if(Date.parse(regn_date) > Date.parse(from_date)) {
			alert(getMessage("APP-OH000127","OH") + " " + regn_date_time);
			formObj.sendout_date.focus();
			formObj.strtDate.select();
			return false;
		}
		else if(Date.parse(regn_date) <= Date.parse(from_date)) return true;
	}
	return true;
}

function localtrimString(sInvar) {
  sInvar = sInvar.replace( /^\s+/g, "" );// strip leading
  return sInvar.replace( /\s+$/g, "" );// strip trailing
}

function checkDateTimeValidations(obj,from){
	var valid_date = checkDateValidity(obj);
	if(valid_date){
		if(OHValidateDateTime(obj,from)){
			if(checkDateGreaterThanRegDate(obj,from)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	else{
		return false;
	}
	return true;
}

function OHValidateDateTime(obj,from){
	var formObj = document.forms[0];
	var locale=formObj.locale.value;
		var currDate = new Date();
		var date = currDate.getDate();
		var mon = currDate.getMonth();
		var hrNow = currDate.getHours();
		var mnNow = currDate.getMinutes();
		scNow = currDate.getSeconds();
		mon = mon+1;
		var year = currDate.getYear();
		if(date <10)
			date = "0"+date;
		if(mon <10)
			mon = "0"+mon;
			
		if(hrNow<10)
				hrNow="0"+hrNow;
		if(mnNow<10)
				mnNow="0"+mnNow;
		var convert1= date + "/" + mon + "/" + year;
		var  CurrentDateTime=convert1+" "+hrNow+":"+mnNow;
	var from_date = obj.value;
	if(from_date != ""){
		/*var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "";
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OHTrmtSendOutAckValidation.jsp?func_mode=getCurDateTime&"+params,false);
		xmlHttp.send(xmlDoc);
		var sys_date = trimString(xmlHttp.responseText);
		sys_date = localtrimString(sys_date);  */
		if(from_date.indexOf(" ") != -1 && from_date.indexOf(":") != -1){
			var grater_yn = ValidateDateTime (from_date,convertDate(CurrentDateTime,'DMYHM',"en",locale));
			if(!grater_yn){
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
				obj.focus();
				obj.select();
				return false;
			}
		}else{
			alert(getMessage("APP-OH000143","OH"));
			obj.focus();
			obj.select();
			return false;
		}
	}
	return true;
}

function ExpDelieveryDateVal(obj){
	var valid_date = checkDateValidity(obj);
	if(valid_date){
		checkExpValidateDateTime(obj);
	}
}

function checkExpValidateDateTime(obj){
	var from_date = obj.value;
	if(from_date != ""){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "";
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OHTrmtSendOutAckValidation.jsp?func_mode=getCurDateTime&"+params,false);
		xmlHttp.send(xmlDoc);
		var sys_date = trimString(xmlHttp.responseText);
		sys_date = localtrimString(sys_date);
		if(from_date.indexOf(" ") != -1 && from_date.indexOf(":") != -1){
			
			var grater_yn = ValidateDateTime (sys_date,from_date);
			if(!grater_yn){
				alert(getMessage("APP-OH000136","OH"));
				obj.focus();
				obj.select();
				return;
			}
		}else{
			alert(getMessage("APP-OH000143","OH"));
			obj.focus();
			obj.select();
			return false;
		}
	}
}
function CurrTime(){
		var formObj = document.forms[0];
		var locale=formObj.locale.value;
		var currDate = new Date();
		var date = currDate.getDate();
		var mon = currDate.getMonth();
		var hrNow = currDate.getHours();
		var mnNow = currDate.getMinutes();
		scNow = currDate.getSeconds();
		mon = mon+1;
		var year = currDate.getYear();
		if(date <10)
			date = "0"+date;
		if(mon <10)
			mon = "0"+mon;
			
		if(hrNow<10)
				hrNow="0"+hrNow;
		if(mnNow<10)
				mnNow="0"+mnNow;
		var convert1= date + "/" + mon + "/" + year;
		
		var  DateTime=convert1+" "+hrNow+":"+mnNow;
		//DateTime=convertDate(DateTime,'DMYHM',locale,"en");
		if(formObj.name=='OHTrmtSendOut'){
			
				if(document.getElementById("sendout_date").value == ""){
				//document.getElementById("sendout_date").value = DateTime;
				document.getElementById("sendout_date").value = convertDate(DateTime,'DMYHM',"en",locale);

				}
			}
		else if(formObj.name=='OHTrmtRecvDetails'){

				if(document.getElementById("recv_recvd_date").value == ""){
				document.getElementById("recv_recvd_date").value = convertDate(DateTime,'DMYHM',"en",locale);
				}
		   }
		else if(formObj.name=='OHTrmtAcknowledge'){
		 
			if(document.getElementById("ack_recvd_date").value == ""){
				document.getElementById("ack_recvd_date").value =  convertDate(DateTime,'DMYHM',"en",locale);
			   }
		}
		
	}
