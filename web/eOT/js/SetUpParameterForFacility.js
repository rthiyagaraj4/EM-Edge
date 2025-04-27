/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var flag="";
var result="";
var message="";
 
function apply()
{
	var formObj = parent.content.f_query_add_mod.document.forms[0];
	var tab_id = formObj.tab_id.value;
	var flag=true;
		
	if(tab_id=="MainPage")
	{
		if(formObj.ot_sec1_notice_fm_time.value !="" && formObj.ot_sec1_notice_to_time.value =="")
		{
				err_txt=getMessage("APPT_TO_TIME_BLANK","OT");
				alert(err_txt);
				formObj.ot_sec1_notice_to_time.focus();
				flag=false;
		}
		else if(formObj.ot_sec1_notice_fm_time.value == "" && formObj.ot_sec1_notice_to_time.value != "")
		{
				err_txt=getMessage("APPT_FROM_TIME_BLANK","OT");
				alert(err_txt);
				formObj.ot_sec1_notice_fm_time.focus();
				flag=false;
		}

		if(flag==true)
	{
		if(formObj.ot_sec2_notice_fm_time.value !="" && formObj.ot_sec2_notice_to_time.value =="")
		{
				err_txt=getMessage("APPT_TO_TIME_BLANK","OT");
				alert(err_txt);
				formObj.ot_sec2_notice_to_time.focus();
				flag=false;
		}
		else if(formObj.ot_sec2_notice_fm_time.value =="" && formObj.ot_sec2_notice_to_time.value !="")
		{
				err_txt=getMessage("APPT_FROM_TIME_BLANK","OT");
				alert(err_txt);
				formObj.ot_sec2_notice_fm_time.focus();
				flag=false;
		}
	}
	if(flag==true)
	{
		if(formObj.ot_sec3_notice_fm_time.value !="" && formObj.ot_sec3_notice_to_time.value =="")
		{
				err_txt=getMessage("APPT_TO_TIME_BLANK","OT");
				alert(err_txt);
				formObj.ot_sec3_notice_to_time.focus();
				flag=false;
		}
		else if(formObj.ot_sec3_notice_fm_time.value =="" && formObj.ot_sec3_notice_to_time.value !="")
		{
				err_txt=getMessage("APPT_FROM_TIME_BLANK","OT");
				alert(err_txt);
				formObj.ot_sec3_notice_fm_time.focus();
				flag=false;
		}
	}
	}
	if(tab_id=="AdditionalDetails")
	{
		var isTimeDtlsSurNurAppl=formObj.isTimeDtlsSurNurAppl.value;
	
	if(isTimeDtlsSurNurAppl=="true"){
	if(formObj.AnesProcedureStartEndTimeYN.checked == true || formObj.AnesStartEndTimeYN.checked == true || formObj.SurgeryStartEndTimeYN.checked == true || formObj.PreparationStartEndTimeYN.checked == true){
		if(formObj.RecordSurgeonNotesYN.checked == false && formObj.RecordNursingNotesYN.checked == false){
			err_txt=getMessage("APP_TIME_DTLS_BLANK","OT");
			alert(err_txt);
			flag=false;
		}	
	}
	}
	}
if(flag ==true)
	{
	var commit_flag = false;
	commit_flag = (tab_id=="MainPage")?checkMandatory():true;
	commit_flag = (tab_id=="BillingSetup")?chkMandatoryBillingSetupPage():true;
	commit_flag = (tab_id=="OtherDetails") ? chkMandatoryOtherDetails() : true;
	if(commit_flag)
	{
		var retVal = formApply(formObj,OT_TAB_MANAGER);
		retVal = trimString(retVal);
		eval(retVal);
		var mesg = (result==true)?getMessage(message,"SM"):message;
		parent.content.tabsFrame.location.reload();
		parent.content.f_query_add_mod.location.reload();
		parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
	}
	}
	else
	{
		parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}

function checkMandatory()
{
	var formObj = parent.content.f_query_add_mod.document.forms[0];
	var unit_ot_time_title = getLabel("eOT.UnitTimeforBooking.Label","OT");
	var ot_sec1_notice_fm_time_title =getLabel("eOT.Section1NoticeFromTime.Label","OT");
	var ot_sec1_notice_to_time_title =getLabel("eOT.Section1NoticeToTime.Label","OT");
	var ot_sec2_notice_fm_time_title =getLabel("eOT.Section2NoticeFromTime.Label","OT");
	var ot_sec2_notice_to_tim_title =getLabel("eOT.Section2NoticeToTime.Label","OT");
	var ot_sec3_notice_fm_time_title =getLabel("eOT.Section3NoticeFromTime.Label","OT");
	var ot_sec3_notice_to_time_title =getLabel("eOT.Section3NoticeToTime.Label","OT");
	var next_booking_num_title =getLabel("eOT.BookingNextNumber.Label","OT");
	var max_booking_num_title =getLabel("eOT.BookingMaxNumber.Label","OT");
	var next_waitlist_num_title =getLabel("eOT.WaitListNextNumber.Label","OT");
	var max_waitlist_num_title =getLabel("eOT.WaitListMaxNumber.Label","OT");
	var next_oper_num_ip_title =getLabel("eOT.IPOperNextNumber.Label","OT");
	var max_oper_num_ip_title =getLabel("eOT.IPOperMaxNumber.Label","OT");
	var next_oper_num_op_title =getLabel("eOT.OPOperNextNumber.Label","OT");
	var max_oper_num_op_title =getLabel("eOT.OPOperMaxNumber.Label","OT");
	//var allwdSwabCnts = getLabel("eOT.NoOfSwabsRequired.Label","OT"); //IN054191 //Commented Against Main Page Issue
	//var fields = new Array (formObj.unit_ot_time,formObj.ot_sec1_notice_fm_time,formObj.ot_sec1_notice_to_time,formObj.ot_sec2_notice_fm_time,formObj.ot_sec2_notice_to_time,formObj.ot_sec3_notice_fm_time,formObj.ot_sec3_notice_to_time,formObj.next_booking_num,formObj.max_booking_num,formObj.next_waitlist_num,formObj.max_waitlist_num,formObj.next_oper_num_ip,formObj.max_oper_num_ip,formObj.next_oper_num_op,formObj.max_oper_num_op, formObj.allwdSwabCnts); //Commented Against Main Page
	var fields = new Array (formObj.unit_ot_time,formObj.ot_sec1_notice_fm_time,formObj.ot_sec1_notice_to_time,formObj.ot_sec2_notice_fm_time,formObj.ot_sec2_notice_to_time,formObj.ot_sec3_notice_fm_time,formObj.ot_sec3_notice_to_time,formObj.next_booking_num,formObj.max_booking_num,formObj.next_waitlist_num,formObj.max_waitlist_num,formObj.next_oper_num_ip,formObj.max_oper_num_ip,formObj.next_oper_num_op,formObj.max_oper_num_op);
	//var names = new Array ( 	"UnitOtTime","OTSec1NoticeFromTime","OTSec1NoticeToTime","OTSec2NoticeFromTime","OTSec2NoticeToTime","OTSec3NoticeFromTime","OTSec3NoticeToTime","NextBookingNum","MaxBookingNum","NextWaitlistNum","MaxWaitlistNum","NextOperNumIp","MaxOperNumIp","NextOperNumOp","MaxOperNumOp");
	//var names = new Array (unit_ot_time_title,ot_sec1_notice_fm_time_title,ot_sec1_notice_to_time_title,ot_sec2_notice_fm_time_title,ot_sec2_notice_to_tim_title,ot_sec3_notice_fm_time_title,ot_sec3_notice_to_time_title,next_booking_num_title,max_booking_num_title,next_waitlist_num_title,max_waitlist_num_title,next_oper_num_ip_title,max_oper_num_ip_title,next_oper_num_op_title,max_oper_num_op_title, allwdSwabCnts); //Commented Against Main Page Issue
	var names = new Array (unit_ot_time_title,ot_sec1_notice_fm_time_title,ot_sec1_notice_to_time_title,ot_sec2_notice_fm_time_title,ot_sec2_notice_to_tim_title,ot_sec3_notice_fm_time_title,ot_sec3_notice_to_time_title,next_booking_num_title,max_booking_num_title,next_waitlist_num_title,max_waitlist_num_title,next_oper_num_ip_title,max_oper_num_ip_title,next_oper_num_op_title,max_oper_num_op_title);
	return checkFieldsofMst( fields, names, messageFrame);
}

function onSuccess(){
		//parent.content.f_query_add_mod.location.reload();
}

function assignResult(res,msg,flg){
	result=res;
	flag=flg;
	message=msg;
}

function reset() {

	 if(f_query_add_mod.document.location.href.indexOf("SetUpParameterForFacility.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}

function setCheckBoxBillService(obj){
	var formObj = document.forms[0];
	var tab=formObj.tab_id.value;
	if(obj.checked)
		obj.value="Y";
	else{
		obj.value="N";
	}
	return true;
}


function setChkBoxValue(obj){
	var formObj = document.forms[0];
	var tab=formObj.tab_id.value;
	if(obj.checked)
		obj.value="Y";
	else
		obj.value="N";

	if(tab=="OtherDetails"){
		//check_ena_dis();
	//	chk_ena_dis();

	if(obj.name =="oh_interface_flag")
	{
		if(obj.checked==true)
		{
			if(document.forms[0].oh_task_catalog_desc)
			{
		document.forms[0].oh_task_catalog_desc.disabled=false;
		document.forms[0].oh_dental_chart_lookup.disabled=false;
			}
		}else
		{
			if(document.forms[0].oh_task_catalog_desc)
			{
		document.forms[0].oh_task_catalog_desc.disabled=true;
		document.forms[0].oh_dental_chart_lookup.disabled=true;
		document.forms[0].oh_task_catalog_desc.value="";
		document.forms[0].oh_task_catalog.value="";
			}
		}

	}else if(obj.name =="st_interface_flag")
	{


			if(obj.checked==true)
		{
		document.forms[0].st_doc_type_sli_desc.disabled=false;
		document.forms[0].st_doc_sale_btn.disabled=false;
		document.forms[0].st_doc_type_rti_desc.disabled=false;
		document.forms[0].st_doc_req_btn.disabled=false;
		}else
		{
		document.forms[0].st_doc_type_sli_desc.disabled=true;
		document.forms[0].st_doc_sale_btn.disabled=true;
		document.forms[0].st_doc_type_rti_desc.disabled=true;
		document.forms[0].st_doc_req_btn.disabled=true;
		document.forms[0].st_doc_type_sli_desc.value="";
		document.forms[0].st_doc_type_rti_desc.value="";
		document.forms[0].st_doc_type_rti.value="";
		document.forms[0].st_doc_type_sli.value="";
		}

	}
	//MMS-QH-CRF-186
	else if(obj.name == "chkAmmendBookings"){
	
		if(obj.checked==false){
			formObj.chkAmmendBookingsDays.disabled=true;
		}else{
			formObj.chkAmmendBookingsDays.disabled=false;
		}
	}
	//PMG2016-KDAH-CRF-0001 STARTS
	else if(obj.name == "multicheckinallowed_yn"){
		if(obj.checked==false){
			var msg=getMessage("APP-OT0236","OT");
			if(!window.confirm(getMessage("APP-OT0236","OT"))){
				formObj.multicheckinallowed_yn.checked=true;
			}
			//alert(msg);
		}		
	}
	//PMG2016-KDAH-CRF-0001 ENDS
	}
	return true;
}

function setListBoxValues(str)
{
	var formObj = document.forms[0];
	var arr = str.split("@@");
	if(arr[0] !="")
	{
	formObj.bkg_fin_alert_for_op.value=arr[0];
	}else
	{
		formObj.bkg_fin_alert_for_op.value="A";
	}
	if(arr[1] !="")
	{
	formObj.bkg_fin_alert_for_em.value=arr[1];
	}else
	{
		formObj.bkg_fin_alert_for_em.value="A";
	}
	formObj.no_of_swab_count_reqd.value=arr[2];
	formObj.diary_sched_for_surg_reqd_yn.value=arr[3];
	formObj.allwdSwabCnts.value=arr[4]; //IN054191

}

function setChkBoxValues(str)
{
	var formObj = document.forms[0];
	var st_module_instaled_yn=formObj.st_module_installed_yn.value;
	var arr = str.split("::");
	if(arr[0]=="Y")
	{
		formObj.warn_unscheduled_cases_only.checked=true;
		formObj.warn_unscheduled_cases_only.value = "Y";
	}
	else
	{
		formObj.warn_unscheduled_cases_only.checked=false;
		formObj.warn_unscheduled_cases_only.value = "N";
	}

	if(arr[1]=="Y")
	{
		formObj.ipbooking_with_theatre_yn.checked=true;
		formObj.ipbooking_with_theatre_yn.value = "Y";
	}
	else
	{
		formObj.ipbooking_with_theatre_yn.checked=false;
		formObj.ipbooking_with_theatre_yn.value = "N";
	}

	if(arr[2]=="Y")
	{
		formObj.chk_surgeon_doc_cmpl_for_sts.checked=true;
		formObj.chk_surgeon_doc_cmpl_for_sts.value = "Y";
	}
	else
	{
		formObj.chk_surgeon_doc_cmpl_for_sts.checked=false;
		formObj.chk_surgeon_doc_cmpl_for_sts.value = "N";
	}

	if(arr[3]=="Y")
	{
		formObj.chk_nursing_doc_cmpl_for_sts.checked=true;
		formObj.chk_nursing_doc_cmpl_for_sts.value = "Y";
	}
	else
	{
		formObj.chk_nursing_doc_cmpl_for_sts.checked=false;
		formObj.chk_nursing_doc_cmpl_for_sts.value = "N";
	}

	if(arr[4]=="Y")
	{
		formObj.chk_intra_doc_cmpl_for_sts.checked=true;
		formObj.chk_intra_doc_cmpl_for_sts.value = "Y";
	}
	else
	{
		formObj.chk_intra_doc_cmpl_for_sts.checked=false;
		formObj.chk_intra_doc_cmpl_for_sts.value = "N";
	}

	if(arr[5]=="Y")
	{
		formObj.disp_last_antib_preop_yn.checked=true;
		formObj.value = "Y";
	}
	else
	{
		formObj.disp_last_antib_preop_yn.checked=false;
		formObj.disp_last_antib_preop_yn.value = "N";
	}

	if(arr[6]=="Y")
	{
		formObj.bl_interface_flag.checked=true;
		formObj.bl_interface_flag.value = "Y";
	}
	else
	{
		formObj.bl_interface_flag.checked=false;
		formObj.bl_interface_flag.value = "N";
	}

	if("Y"==st_module_instaled_yn)
	{
		if(arr[7]=="Y")
		{
		formObj.st_interface_flag.checked=true;
		formObj.st_interface_flag.value = "Y";
		}
		else
		{
		formObj.st_interface_flag.checked=false;
		formObj.st_interface_flag.value = "N";
	}
}

	if(arr[8]=="Y")
	{
		formObj.slate_login_reqd_yn.checked=true;
		formObj.value = "Y";
	}
	else
	{
		formObj.slate_login_reqd_yn.checked=false;
		formObj.slate_login_reqd_yn.value = "N";
	}

	if(arr[9]=="Y")
	{
		formObj.reason_for_rearrange_seqence.checked=true;
		formObj.reason_for_rearrange_seqence.value = "Y";
	}
	else
	{
		formObj.reason_for_rearrange_seqence.checked=false;
		formObj.reason_for_rearrange_seqence.value = "N";
	}

	if(arr[10]=="Y")
	{
		if(formObj.oh_task_catalog_desc)
		{
		formObj.oh_task_catalog_desc.disabled=false;
		formObj.oh_dental_chart_lookup.disabled = false;
		formObj.oh_interface_flag.checked = true;
		formObj.oh_interface_flag.value = "Y";
		}
	}
	else
	{
		if(formObj.oh_task_catalog_desc)
		{
		formObj.oh_task_catalog_desc.disabled=true;
		formObj.oh_dental_chart_lookup.disabled = true;
		formObj.oh_interface_flag.checked = false;
		formObj.oh_interface_flag.value = "N";
		}
	}

     /* Below line was added by venkatesh.S on 27-Aug-2013 against RUT-CRF-0083.4[IN041509] */
	if(arr[12]=="Y")
	{
		formObj.external_link.checked=true;
		formObj.external_link.value = "Y";
	}
	else
	{
		formObj.external_link.checked=false;
		formObj.external_link.value = "N";
	   }
/* end RUT-CRF-0083.4[IN041509] */
 /* Added by MuthuN against CHL-CRF-0020.1 on 11/6/2013 */
	if(arr[13]=="Y")
	{
		formObj.display_hospital.checked=true;
		formObj.display_hospital.value = "Y";
	}
	else
	{
		formObj.display_hospital.checked=false;
		formObj.display_hospital.value = "N";
	   }
/* Added by MuthuN against CHL-CRF-0020.1 on 11/6/2013 */
//PMG-CRF-003
	if(arr[14]=="Y")
	{
		formObj.default_user_role.checked=true;
		formObj.default_user_role.value = "Y";
	}
	else
	{
		formObj.default_user_role.checked=false;
		formObj.default_user_role.value = "N";
	}
	// Added start for KDAH-CRF-0283 [IN:050553]  
	if(arr[15] == "Y")
	{
		formObj.booking_priority_orders_yn.checked=true;
		formObj.booking_priority_orders_yn.value = "Y";
	}
	else
	{
		formObj.booking_priority_orders_yn.checked=false;
		formObj.booking_priority_orders_yn.value = "N";
	}
	//PMG-MOD-0005 Start
	if(arr[16] == "Y")
	{
		formObj.Link_Operation_And_Notes_in_Record_Surgeon_Notes.checked=true;
		formObj.Link_Operation_And_Notes_in_Record_Surgeon_Notes.value = "Y";
	}
	else
	{
		formObj.Link_Operation_And_Notes_in_Record_Surgeon_Notes.checked=false;
		formObj.Link_Operation_And_Notes_in_Record_Surgeon_Notes.value = "N";
	}

	if(arr[17] == "Y")
	{
		formObj.chkAmmendBookings.checked = true;
		formObj.chkAmmendBookings.value = "Y";
	}
	else
	{
		formObj.chkAmmendBookings.checked = false;
		formObj.chkAmmendBookings.value = "N";
		//formObj.chkAmmendBookings.value = "N";
		formObj.chkAmmendBookingsDays.disabled=true;//MMS-QH-CRF-186
	}
//ML-MMOH-CRF-0337
	if(arr[18] == "Y")
	{
		formObj.IncludeBlockedSlot.checked = true;
		formObj.IncludeBlockedSlot.value = "Y";
	}
	else
	{
		formObj.IncludeBlockedSlot.checked = false;		
		formObj.IncludeBlockedSlot.value = "N";		
	}
	//ML-MMOH-CRF-0337
	//Added Against PMG2016-KDAH-CRF-0001 Starts
	if(arr[19] == "Y")
	{
		formObj.multicheckinallowed_yn.checked = true;
		formObj.multicheckinallowed_yn.value = "Y";
	}
	else
	{
		formObj.multicheckinallowed_yn.checked = false;		
		formObj.multicheckinallowed_yn.value = "N";		
	}

	//Added for ML-MMOH-CRF-1791-US001
	if(arr[20]=="Y")
	{
		formObj.auto_schdl_to_nxtday_yn.checked=true;
		formObj.auto_schdl_to_nxtday_yn.value = "Y";
	}
	else
	{
		formObj.auto_schdl_to_nxtday_yn.checked=false;
		formObj.auto_schdl_to_nxtday_yn.value = "N";
	}//End ML-MMOH-CRF-1791-US001

	//Added for PMG2023-MMS-CRF-0002
	if(arr[21]=="Y")
	{
		formObj.allow_to_update.checked=true;
		formObj.allow_to_update.value = "Y";
	}
	else
	{
		formObj.allow_to_update.checked=false;
		formObj.allow_to_update.value = "N";
	}//End PMG2023-MMS-CRF-0002
	
	//Added Against PMG2016-KDAH-CRF-0001 Ends
	//PMG-MOD-0005 End
	// Added end for KDAH-CRF-0283 [IN:050553]
	if("Y"==st_module_instaled_yn)
		checkInterfaceFlagEnaDis()
}

function checkInterfaceFlagEnaDis(){
	var formObj=document.forms[0];
		if (formObj.st_interface_flag.checked==true)
		{
			formObj.st_doc_type_sli_desc.disabled=false;
			formObj.st_doc_sale_btn.disabled=false;
			formObj.st_doc_type_rti_desc.disabled=false;
			formObj.st_doc_req_btn.disabled=false;

		}else{
			formObj.st_doc_type_sli_desc.disabled=true;
			formObj.st_doc_sale_btn.disabled=true;
			formObj.st_doc_type_rti_desc.disabled=true;
			formObj.st_doc_req_btn.disabled=true;
		}

}

function isValidTime(obj){
	var formObj = document.forms[0];
	var retVal=true;
	var from_time=obj.value
	var splt_from_dur=from_time.split(":");

if(from_time!=''){
	if(from_time.length!="5"){
		//alert(getMessage("APP-OT0040","OT"));
		alert(getMessage("APP-OT0130","OT"));
		obj.value="";
		obj.select();
		obj.focus()
		return;
	}
	if(splt_from_dur[0].length!=2 ||splt_from_dur[1].length!=2 ){
		alert(getMessage("APP-OT0130","OT"));
		obj.value="";
		obj.select();
		obj.focus()
		return;
	}
}

	var RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;
	if(obj.value!="" && !RE_EXP.test(obj.value) ){
		var err_text="";
	    var time = obj.value;
	    var arr_time =  time.split(":")
        if(arr_time.length!=2 || arr_time[1]=='' || arr_time[0]==''){
			//cal_error("Invalid Time format! Allowed Format is HH24:MI",obj);
			cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}

		if(arr_time[0]<0 || arr_time[0]>23 || arr_time[1]<0 || arr_time[1]>59 ){
			//err_text+= "Invalid Hours! Allowed Hours 00 - 23\n";
			err_text+=getMessage("APP-OT0040","OT");
		}

		if(err_text.length>0)
			retVal=false;
			cal_error(err_text,obj);
			obj.value="";
			obj.select();
			obj.focus()
		}

	return retVal;


}
function wrapTime(str){
	var now  = new Date();
	var arr = str.split(":");
	var date = new Date(now.getFullYear() , now.getMonth(),now.getDate(), arr[0], arr[1], "00");
	return date
}

function enabletime()
{
	var formObj = document.forms[0];

if(formObj.ot_sec1_notice_fm_time.value !="")
{
	formObj.ot_sec1_notice_to_time.disabled=false;
}else
	{
	formObj.ot_sec1_notice_to_time.disabled=true;
}

if(formObj.ot_sec2_notice_fm_time.value !="")
{
	formObj.ot_sec2_notice_to_time.disabled=false;
}else
	{
	formObj.ot_sec2_notice_to_time.disabled=true;
}

if(formObj.ot_sec3_notice_fm_time.value !="")
{
	formObj.ot_sec3_notice_to_time.disabled=false;
}else
	{
	formObj.ot_sec3_notice_to_time.disabled=true;
}

}
function chkTimeSec1(){
	var formObj = document.forms[0];
	var frmStartTime=wrapTime(formObj.ot_sec1_notice_fm_time.value);
	var frmEndTime=wrapTime(formObj.ot_sec1_notice_to_time.value);
	var err_txt="";
		var flag=true;


if(formObj.ot_sec1_notice_fm_time.value !="" && formObj.ot_sec1_notice_to_time.value =="")
{
		err_txt=getMessage("APPT_TO_TIME_BLANK","OT");
		alert(err_txt);
formObj.ot_sec1_notice_to_time.focus();
	flag=false;
}

if(flag==true &&  formObj.ot_sec1_notice_to_time.value !="")
	{
	if(frmStartTime>=frmEndTime){
		//err_txt="Start Time Cannot Be Greater than End time..........";
		err_txt=getMessage("ST_TIME_GREATER_ED_TIME","OA");
		alert(err_txt);
        formObj.ot_sec1_notice_to_time.value="";
		formObj.ot_sec1_notice_to_time.select();
		return false;
	}else
		return true;
	}
}
function chkTimeSec11(){
	var formObj = document.forms[0];
	var frmStartTime=wrapTime(formObj.ot_sec1_notice_fm_time.value);
	var frmEndTime=wrapTime(formObj.ot_sec1_notice_to_time.value);
	var err_txt="";

if(formObj.ot_sec1_notice_fm_time.value !="")
{
	formObj.ot_sec1_notice_to_time.disabled=false;
formObj.ot_sec1_notice_to_time.focus();
}
	if(frmStartTime>=frmEndTime){
		//err_txt="Start Time Cannot Be Greater than End time..........";
		err_txt=getMessage("ST_TIME_GREATER_ED_TIME","OA");
		alert(err_txt);
        formObj.ot_sec1_notice_fm_time.value="";
		formObj.ot_sec1_notice_fm_time.select();
		return false;
	}else
		return true;
}
function chkfrmtime4()
{
	var formObj = document.forms[0];


if(formObj.ot_sec2_notice_fm_time.value !="")
{
	formObj.ot_sec2_notice_to_time.disabled=false;
formObj.ot_sec2_notice_to_time.focus();
}
}

function chkfrmtime5()
{
	var formObj = document.forms[0];


if(formObj.ot_sec3_notice_fm_time.value !="")
{
	formObj.ot_sec3_notice_to_time.disabled=false;
formObj.ot_sec3_notice_to_time.focus();
}
}
function chktotimesec2()
{
	var formObj = document.forms[0];
	var frmStartTime=wrapTime(formObj.ot_sec2_notice_fm_time.value);
	var frmEndTime=wrapTime(formObj.ot_sec2_notice_to_time.value);
	var err_txt="";



}
function chkTimeSec2(){
	var formObj = document.forms[0];
	var frmStartTime=wrapTime(formObj.ot_sec2_notice_fm_time.value);
	var frmEndTime=wrapTime(formObj.ot_sec2_notice_to_time.value);
	var err_txt="";

	if(frmStartTime>=frmEndTime){
		//err_txt="Start Time Cannot Be Greater than End time..........";
		err_txt=getMessage("ST_TIME_GREATER_ED_TIME","OA");
		alert(err_txt);
        formObj.ot_sec2_notice_to_time.value="";
		formObj.ot_sec2_notice_to_time.select();
		return false;
	}else
		return true;
}
function chkTimeSec3(){
	var formObj = document.forms[0];
	var frmStartTime=wrapTime(formObj.ot_sec3_notice_fm_time.value);
	var frmEndTime=wrapTime(formObj.ot_sec3_notice_to_time.value);
	var err_txt="";


	if(frmStartTime>=frmEndTime){
		//err_txt="Start Time Cannot Be Greater than End time..........";
		err_txt=getMessage("ST_TIME_GREATER_ED_TIME","OA");
		alert(err_txt);
        formObj.ot_sec3_notice_to_time.value="";
		formObj.ot_sec3_notice_to_time.select();
		return false;
	}else
		return true;
}
function fromTOTimeCheck(obj){
	var formObj=document.forms[0];
	var from_time=formObj.ot_sec2_notice_fm_time.value;
	var to_time=formObj.ot_sec2_notice_to_time.value;
	var err_text="Entered time should between 00:01 to 23:59";
	if(from_time=="00:00"){
		var RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;
			if(obj.value!="" && !RE_EXP.test(obj.value) ){
				var err_text="";
				var time = obj.value;
				var arr_time =  time.split(":")
				if(arr_time.length!=2){
					//cal_error("Invalid Time format! Allowed Format is HH24:MI",obj);
					cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
				}

				if(  isNaN(arr_time[0]) || isNaN(arr_time[1]) ){
					cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
				}

				if(arr_time[0]<0 || arr_time[0]>23 ){
					//err_text+= "Invalid Hours! Allowed Hours 00 - 23\n";
					err_text+=getMessage("APP-OT0040","OT");
				}
				if(arr_time[1]<0 || arr_time[1]>59 ){
					//err_text+= "Invalid Minutes! Allowed Mins 00 - 59";
					err_text+=getMessage("APP-OT0041","OT");
				}
				if(err_text.length>0)
					cal_error(err_text,obj);
			}
		}else{
			if(to_time=="00:00"){
				cal_error(err_text,obj);
				return false;
			}
		}

	return true
}


function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}


async function callSearchLookUp(obj,target,id){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";
	var sql = "";
	switch(id){
		case '1':
		tit=getLabel("eOT.PACReviewOrderable.Label","OT");
		var sql="SELECT LONG_DESC DESCRIPTION,ORDER_CATALOG_CODE CODE  FROM OR_ORDER_CATALOG WHERE ORDER_CATEGORY = 'MI' AND  CONTR_MOD_ID IS NULL AND CONTR_MSR_PANEL_ID IS NULL AND NVL(EFF_STATUS, 'D') = 'E'  AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(ORDER_CATALOG_CODE) LIKE UPPER(?) ORDER BY 1 ";
		break;
		case '2':
		tit=getLabel("eOT.RequestDocType.Label","OT");

	var sql="SELECT SY.SHORT_DESC DESCRIPTION,ST.DOC_TYPE_CODE CODE  FROM ST_TRN_DOC_TYPE ST,SY_DOC_TYPE_MASTER_LANG_VW SY WHERE SY.LANGUAGE_ID = '"+locale+"' AND ST.TRN_TYPE= 'ISS' AND ST.DOC_TYPE_CODE = SY.DOC_TYPE_CODE AND ST.FACILITY_ID = '"+facility_id+"' AND UPPER(SY.SHORT_DESC) LIKE UPPER(?) AND UPPER(ST.DOC_TYPE_CODE) LIKE UPPER(?) ORDER BY 1";
	//	var sql="SELECT ST.DOC_TYPE_CODE CODE ,SY.SHORT_DESC DESCRIPTION FROM ST_TRN_DOC_TYPE ST,SY_DOC_TYPE_MASTER_LANG_VW SY WHERE SY.LANGUAGE_ID = '"+locale+"' AND ST.TRN_TYPE= 'ISS' AND ST.DOC_TYPE_CODE = SY.DOC_TYPE_CODE AND ST.FACILITY_ID = '"+facility_id+"' AND UPPER(SY.SHORT_DESC) LIKE UPPER(?) AND UPPER(ST.DOC_TYPE_CODE) LIKE UPPER(?) ORDER BY UPPER(SY.SHORT_DESC)"
		break;

		case '3':
		tit=getLabel("eOT.InventoryDocumentType.Label","OT");
		var sql="SELECT B.SHORT_DESC DESCRIPTION,A.DOC_TYPE_CODE CODE FROM SS_TRN_DOC_TYPE A, SY_DOC_TYPE_MASTER B WHERE A.FACILITY_ID = '"+facility_id+"' AND  A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND  NVL(B.STATUS,'E') ='E'  AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.DOC_TYPE_CODE) LIKE UPPER(?) ORDER BY 1 ";
		break;

		case '4':
		tit=getLabel("eOT.SaleDoctype.Label","OT");
		var sql="SELECT SY.SHORT_DESC DESCRIPTION , ST.DOC_TYPE_CODE CODE  FROM ST_TRN_DOC_TYPE ST,SY_DOC_TYPE_MASTER_LANG_VW SY WHERE SY.LANGUAGE_ID = '"+locale+"' AND ST.TRN_TYPE= 'SAL' AND ST.DOC_TYPE_CODE = SY.DOC_TYPE_CODE AND ST.FACILITY_ID = '"+facility_id+"' AND UPPER(SY.SHORT_DESC) LIKE UPPER(?) AND UPPER(ST.DOC_TYPE_CODE) LIKE UPPER(?) ORDER BY UPPER(SY.SHORT_DESC)"
		break;

		case '5':
		tit=getLabel("eOT.OralHealthOTprocedure.Label","OT");
		var sql="SELECT LONG_DESC DESCRIPTION,ORDER_CATALOG_CODE CODE  FROM OR_ORDER_CATALOG WHERE ORDER_CATEGORY = 'OT' AND  CONTR_MOD_ID IS NOT NULL AND CONTR_MSR_PANEL_ID IS NOT NULL AND NVL(EFF_STATUS, 'D') = 'E'  AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(ORDER_CATALOG_CODE) LIKE UPPER(?) ORDER BY 1 ";


	}

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
 }

 function CheckForPositiveNumber(obj){
	var RegExpr=/^[1-9]|[0-9]{1,9}$/
	if(obj.value!=""){
		if(!RegExpr.test(obj.value)){
			alert(getMessage("POSITIVE_NUMBER_ALLOWED","CA"));
			obj.select();
			obj.focus();
		}
	}
}
function changeDairyScheduleBy(){
	//var obj=document.forms[0];
	var obj = document.SetUpParameterForFacilityForm.diary_sched_for_surg_reqd_yn;
    if(obj.value="S")
        document.SetUpParameterForFacilityForm.diary_sched_for_surg_reqd_yn.value="Y";
	else if((obj.value="T"))
        document.SetUpParameterForFacilityForm.diary_sched_for_surg_reqd_yn.value="N";
	//var diary_sched_for_surg_reqd_yn1 = document.SetUpParameterForFacilityForm.diary_sched_for_surg_reqd_yn1.value;
}


function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789:';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function checkForSpecChars(event)
{
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function checkEnaDisHoldingArea(){
	var formObj = document.forms[0];
	var hold_area_bill=formObj.holding_area_bill_yn;
	setChkBoxValue(hold_area_bill);
	if(formObj.holding_area_bill_yn.checked==true){
		formObj.holding_area.disabled=false;
		formObj.holding_area.disabled=false;
	}else{
		formObj.holding_area.disabled=true;
		formObj.holding_area.disabled=true;
	}
checkEnaOperRoom();
}

function checkEnaOperRoom(){
	var formObj = document.forms[0];
	var oper_room_bill=formObj.operating_room_bill_yn;
	setChkBoxValue(oper_room_bill);
	if(formObj.operating_room_bill_yn.checked==true){
		formObj.operating_room.disabled=false;
		formObj.operating_room.disabled=false;
	}else{
		formObj.operating_room.disabled=true;
		formObj.operating_room.disabled=true;
	}
checkEnaRecoveryRoom();
}

function checkEnaRecoveryRoom(){
	var formObj = document.forms[0];
	var rec_room_bill=formObj.recovery_room_bill_yn;
	setChkBoxValue(rec_room_bill);
	if(formObj.recovery_room_bill_yn.checked==true){
		formObj.recovry_room.disabled=false;
		formObj.recovry_room.disabled=false;
	}else{
		formObj.recovry_room.disabled=true;
		formObj.recovry_room.disabled=true;
	}

}

function removeHoldingArea(){
	var formObj = document.forms[0];
	var hold_area_sel=formObj.holding_area.value;
	var elOptNew = document.createElement('option');
	elOptNew.text = 'Before Check-out/Documentation Completition';
	elOptNew.value = 'A';
	var elSel = document.getElementById('holding_area');
	if(formObj.admin_func_charging_un.checked==false){
	  if (elSel.length >1)
	  {
		elSel.remove(elSel.length - 1);
	  }

	}else{
		if(elSel.length=="1"){
		try {
			elSel.add(elOptNew, null); // standards compliant; doesn't work in IE
		}catch(ex) {
			elSel.add(elOptNew); // IE only
		}//catch
		}
	  }//else 544
//	}
	removeOperRoom();
}//function

function removeOperRoom(){
	var formObj = document.forms[0];
	var operating_room=formObj.operating_room.value;
//	if(operating_room!="O"){
		var elOptNew = document.createElement('option');
		elOptNew.text = 'Before Check-out/Documentation Completition';
		//elOptNew.value = 'O';
		elOptNew.value = 'A';
		var elSel = document.getElementById('operating_room');
		if(formObj.admin_func_charging_un.checked==false){
		  if (elSel.length > 1)
		  {
			elSel.remove(elSel.length - 1);
		  }

		}else{
			if(elSel.length=="1"){
			try {
				elSel.add(elOptNew, null); // standards compliant; doesn't work in IE
			}catch(ex) {
				elSel.add(elOptNew); // IE only
			}//catch
			}
		}//else 544
//	}
	removeRecoveryRoom();
}//function

function removeRecoveryRoom(){
	var formObj = document.forms[0];
	var recovry_room=formObj.recovry_room.value;
//	if(recovry_room!="R"){
		var elOptNew = document.createElement('option');
		elOptNew.text = 'Before Check-out/Documentation Completition';
		//elOptNew.value = 'R';
		elOptNew.value = 'A';
		var elSel = document.getElementById('recovry_room');
		if(formObj.admin_func_charging_un.checked==false){
		  if (elSel.length > 1)
		  {
			elSel.remove(elSel.length - 1);
		  }

		}else{
			if(elSel.length=="1"){
			try {
				elSel.add(elOptNew, null); // standards compliant; doesn't work in IE
			}catch(ex) {
				elSel.add(elOptNew); // IE only
			}//catch
			}
		}//else 544
//	}
	removeProsImpAdminFunction();
}//function

//these functions will be called only when Admin CheckBox is checked/Unchecked Starts here
function onCheckRemoveBillHoldAreaUsage(){
	var formObj = document.forms[0];
	var hold_area_sel=formObj.holding_area.value;
	if(hold_area_sel=="A" || hold_area_sel=="H"){
	  var elSel = document.getElementById('holding_area');
	  if (elSel.length >1)
	  {
		elSel.remove(elSel.length - 1);
	  }
	}
}


function onCheckRemoveBillOperRoomUsage(){
	var formObj = document.forms[0];
	var operating_room=formObj.operating_room.value;
	if(operating_room=="A" || operating_room=="O"){
	  var elSel = document.getElementById('operating_room');
	  if (elSel.length >1)
	  {
		elSel.remove(elSel.length - 1);
	  }
	}
}


function onCheckRemoveBillRecoveryRoomUsage(){
	var formObj = document.forms[0];
	var recovry_room=formObj.recovry_room.value;
	if(recovry_room=="A" || recovry_room=="R"){
	  var elSel = document.getElementById('recovry_room');
	  if (elSel.length >1)
	  {
		elSel.remove(elSel.length - 1);
	  }
	}
}


function onCheckRemoveAdminProsImp(){
var formObj = document.forms[0];
var pros_imp_val=formObj.pros_imp_val.value;
if(pros_imp_val=="AF"){
		var elSel = document.getElementById('pros_imp_val');
		if(formObj.admin_func_charging_un.checked==false){
		  if (elSel.length > 2) {
			elSel.remove(elSel.length-1 );
		  }

		}
	}
}

function onCheckRemoveAdminEquip(){
var formObj = document.forms[0];
	var equip_val=formObj.equip_val.value;
	if(equip_val=="AF"){
		var elSel = document.getElementById('equip_val');
		if(formObj.admin_func_charging_un.checked==false){
		  if (elSel.length > 1) {
			elSel.remove(elSel.length-1 );
		  }

		}
	}
}

function onCheckemoveAdminInsCSSD(){
	var formObj = document.forms[0];
	var instr_cssd_val=formObj.instr_cssd_val.value;
	if(instr_cssd_val=="AF"){
		var elSel = document.getElementById('instr_cssd_val');
		if(formObj.admin_func_charging_un.checked==false){
		  if (elSel.length > 1) {
			elSel.remove(elSel.length-1 );
		  }

		}
	}
}

function onCheckemoveAdminConsPacks(){
	var formObj = document.forms[0];
	var consumable_pack_val=formObj.consumable_pack_val.value;
	if(consumable_pack_val=="AF"){
		var elSel = document.getElementById('consumable_pack_val');
		if(formObj.admin_func_charging_un.checked==false){
		  if (elSel.length > 1) {
			elSel.remove(elSel.length-1 );
		  }

		}
	}
}

//these functions will be called only when Admin CheckBox is checked/Unchecked Ends here

function assignChkValues(){
	var formObj = document.forms[0];
	if(formObj.admin_func_charging_un.checked==false){
		formObj.pros_admin_yn.disabled=true;
		formObj.equip_admin_yn.disabled=true;
		formObj.cssd_admin_yn.disabled=true;
		formObj.cons_admin_yn.disabled=true;

		formObj.pros_admin_yn.checked=false;
		formObj.equip_admin_yn.checked=false;
		formObj.cssd_admin_yn.checked=false;
		formObj.cons_admin_yn.checked=false;
		onCheckRemoveAdminProsImp();
		onCheckRemoveAdminEquip();
		onCheckemoveAdminInsCSSD();
		onCheckemoveAdminConsPacks();
		onCheckRemoveBillHoldAreaUsage();
		onCheckRemoveBillOperRoomUsage();
		onCheckRemoveBillRecoveryRoomUsage();


	}else{
		formObj.pros_admin_yn.disabled=false;
		formObj.equip_admin_yn.disabled=false;
		formObj.cssd_admin_yn.disabled=false;
		formObj.cons_admin_yn.disabled=false;

	}
}

function removeProsImpAdminFunction(){
	var formObj = document.forms[0];
	var pros_imp_val=formObj.pros_imp_val.value;
		var elOptNew = document.createElement('option');
		elOptNew.text = 'Admin Function';
		elOptNew.value = 'AF';
		var elSel = document.getElementById('pros_imp_val');
		if(formObj.admin_func_charging_un.checked==false){
			formObj.pros_admin_yn.checked=false;
			formObj.pros_admin_yn.disabled=true;
		  if (elSel.length > 3) {
			elSel.remove(elSel.length-1 );
		  }

		} else {
			formObj.pros_admin_yn.disabled=false;
			if(elSel.length=="3"){
			try {
				elSel.add(elOptNew, null); // standards compliant; doesn't work in IE
			}catch(ex) {
				elSel.add(elOptNew); // IE only
			}//catch
			}
		}//else 544
	//}
	removeEquipAdminFunction();
}//function

function removeEquipAdminFunction(){
	var formObj = document.forms[0];
	var equip_val=formObj.equip_val.value;
	//if(equip_val!="AF"){
		var elOptNew = document.createElement('option');
		elOptNew.text = 'Admin Function';
		elOptNew.value = 'AF';
		var elSel = document.getElementById('equip_val');
		if(formObj.admin_func_charging_un.checked==false){
			formObj.equip_admin_yn.checked=false;
			formObj.equip_admin_yn.disabled=true;
		  if (elSel.length > 2)
		  {
			elSel.remove(elSel.length-1);
		  }

		}else{
			formObj.equip_admin_yn.disabled=false;
			if(elSel.length=="2"){
			try {
				elSel.add(elOptNew, null); // standards compliant; doesn't work in IE
			}catch(ex) {
				elSel.add(elOptNew); // IE only
			}//catch
			}
		}//else 544
	//}
	removeInstrCssdAdminFunction();
}//function

function removeInstrCssdAdminFunction(){
	var formObj = document.forms[0];
	var instr_cssd_val=formObj.instr_cssd_val.value;
	//if(instr_cssd_val!="AF"){
		var elOptNew = document.createElement('option');
		elOptNew.text = 'Admin Function';
		elOptNew.value = 'AF';
		var elSel = document.getElementById('instr_cssd_val');
		if(formObj.admin_func_charging_un.checked==false){
			formObj.cssd_admin_yn.checked=false;
			formObj.cssd_admin_yn.disabled=true;
		  if (elSel.length > 2)
		  {
			elSel.remove(elSel.length-1);
		  }

		}else{
			formObj.cssd_admin_yn.disabled=false;
			if(elSel.length=="2"){
			try {
				elSel.add(elOptNew, null); // standards compliant; doesn't work in IE
			}catch(ex) {
				elSel.add(elOptNew); // IE only
			}//catch
			}
		}//else 544
	//}
	removeConsPackAdminFunction();
}//function

function removeConsPackAdminFunction(){
	var formObj = document.forms[0];
	var consumable_pack_val=formObj.consumable_pack_val.value;consumable_pack_val
	//if(consumable_pack_val!="AF"){
		var elOptNew = document.createElement('option');
		elOptNew.text = 'Admin Function';
		elOptNew.value = 'AF';
		var elSel = document.getElementById('consumable_pack_val');
		if(formObj.admin_func_charging_un.checked==false){
			formObj.cons_admin_yn.checked=false;
			formObj.cons_admin_yn.disabled=true;
		  if (elSel.length > 2)
		  {
			elSel.remove(elSel.length-1);
		  }

		}else{
			formObj.cons_admin_yn.disabled=false;
			if(elSel.length=="2"){
			try {
				elSel.add(elOptNew, null); // standards compliant; doesn't work in IE
			}catch(ex) {
				elSel.add(elOptNew); // IE only
			}//catch
			}
		}//else 544
	//}
	checkEnaDisHoldingArea();
}//function

function disableSurgAcces(){
	var formObj = document.forms[0];
	formObj.equip_srgn_notes_yn.disabled=true;
	formObj.cssd_srgn_notes_yn.disabled=true;
	formObj.cons_srgn_notes_yn.disabled=true;
}

function checkAdminChkBox(){
	var formObj = document.forms[0];
	if(formObj.pros_admin_yn.checked==false){
	alert("Pls Check Admin CheckBox...");
	return
	}
}

function setBillChkBoxValues(str)
{
	var formObj = document.forms[0];
	var isIncludeFpp = formObj.isIncludeFpp.value;
	var arr = str.split("::");
	if(arr[0]=="Y"){
		formObj.billing_sub_services.checked=true;
		formObj.billing_sub_services.value = "Y";
	}else{
		formObj.billing_sub_services.checked=false;
		formObj.billing_sub_services.value = "N";
	}

	if(arr[1]=="Y"){
		formObj.admin_func_charging_un.checked=true;
		formObj.admin_func_charging_un.value = "Y";
	}else{
		formObj.admin_func_charging_un.checked=false;
		formObj.admin_func_charging_un.value = "N";
	}

	if(arr[2]=="Y"){
		formObj.holding_area_bill_yn.checked=true;
		formObj.holding_area_bill_yn.value = "Y";
	}else{
		formObj.holding_area_bill_yn.checked=false;
		formObj.holding_area_bill_yn.value = "N";
	}

	if(arr[3]=="Y"){
		formObj.operating_room_bill_yn.checked=true;
		formObj.operating_room_bill_yn.value = "Y";
	}else{
		formObj.operating_room_bill_yn.checked=false;
		formObj.operating_room_bill_yn.value = "N";
	}

	if(arr[4]=="Y"){
		formObj.recovery_room_bill_yn.checked=true;
		formObj.recovery_room_bill_yn.value = "Y";
	}else{
		formObj.recovery_room_bill_yn.checked=false;
		formObj.recovery_room_bill_yn.value = "N";
	}

	if(arr[5]=="Y"){
		formObj.pros_srgn_notes_yn.checked=true;
		formObj.pros_srgn_notes_yn.value = "Y";
	}else{
		formObj.pros_srgn_notes_yn.checked=false;
		formObj.pros_srgn_notes_yn.value = "N";
	}

	if(arr[6]=="Y"){
		formObj.pros_nursing_notes_yn.checked=true;
		formObj.pros_nursing_notes_yn.value = "Y";
	}else{
		formObj.pros_nursing_notes_yn.checked=false;
		formObj.pros_nursing_notes_yn.value = "N";
	}

	if(arr[7]=="Y"){
		formObj.pros_admin_yn.checked=true;
		formObj.pros_admin_yn.value = "Y";
	}else{
		formObj.pros_admin_yn.checked=false;
		formObj.pros_admin_yn.value = "N";
	}

	if(arr[8]=="Y"){
		formObj.equip_nursing_notes_yn.checked=true;
		formObj.equip_nursing_notes_yn.value = "Y";
	}else{
		formObj.equip_nursing_notes_yn.checked=false;
		formObj.equip_nursing_notes_yn.value = "N";
	}

	if(arr[9]=="Y"){
		formObj.equip_admin_yn.checked=true;
		formObj.equip_admin_yn.value = "Y";
	}else{
		formObj.equip_admin_yn.checked=false;
		formObj.equip_admin_yn.value = "N";
	}

	if(arr[10]=="Y"){
		formObj.cssd_nursing_notes_yn.checked=true;
		formObj.cssd_nursing_notes_yn.value = "Y";
	}else{
		formObj.cssd_nursing_notes_yn.checked=false;
		formObj.cssd_nursing_notes_yn.value = "N";
	}
	if(arr[11]=="Y"){
		formObj.cssd_admin_yn.checked=true;
		formObj.cssd_admin_yn.value = "Y";
	}else{
		formObj.cssd_admin_yn.checked=false;
		formObj.cssd_admin_yn.value = "N";
	}
	if(arr[12]=="Y"){
		formObj.cons_nursing_notes_yn.checked=true;
		formObj.cons_nursing_notes_yn.value = "Y";
	}else{
		formObj.cons_nursing_notes_yn.checked=false;
		formObj.cons_nursing_notes_yn.value = "N";
	}
	if(arr[13]=="Y"){
		formObj.cons_admin_yn.checked=true;
		formObj.cons_admin_yn.value = "Y";
	}else{
		formObj.cons_admin_yn.checked=false;
		formObj.cons_admin_yn.value = "N";
	}
//047105 start
	if(arr[14]=="Y")
	{
		formObj.charges_appl_checkin_yn.checked=true;
		formObj.charges_appl_checkin_yn.value = "Y";
	}
	else
	{
		formObj.charges_appl_checkin_yn.checked=false;
		formObj.charges_appl_checkin_yn.value = "N";
	}
//047105 end
    //Added against ML-MMOH-CRF-1939-US1...starts
	if(isIncludeFpp === 'true'){
    if(arr[15]=="Y")
	{
		formObj.Include_fpp.checked=true;
		formObj.Include_fpp.value = "Y";
	}
	else
	{
		formObj.Include_fpp.checked=false;
		formObj.Include_fpp.value = "N";
	}
	}
	//Added against ML-MMOH-CRF-1939-US1...starts
}
function setBillingListBoxValues(str){
	var formObj = document.forms[0];
	var arr = str.split("@@");
	formObj.holding_area.value=arr[0];
	formObj.operating_room.value=arr[1];
	formObj.recovry_room.value=arr[2];
	formObj.pros_imp_val.value=arr[3];
	formObj.equip_val.value=arr[4];
	formObj.instr_cssd_val.value=arr[5];
	formObj.consumable_pack_val.value=arr[6];
	formObj.oper_proc_fin_stg.value=arr[7];

}

function checkEnaDisBillSetupTab(){
	var formObj=document.forms[0];
	if(formObj.bl_interface_flag.checked==true){
		window.parent.frames[1].document.getElementById("BillingSetup").disabled=false;
	}else{
		window.parent.frames[1].document.getElementById("BillingSetup").disabled=true;
	}
}

function onLoadCheckEnaDisBillSetupTab(){
/*	var formObj=document.forms[0];
	if(formObj.bl_interface_flag..value=="Y"){
		window.parent.frames[2].document.getElementById("BillingSetup").disabled=false;
	}else{
		window.parent.frames[2].document.getElementById("BillingSetup").disabled=true;
	}*/
}

//Finalisation Stages Validation for Prosthesis/Implants
function checkProsSurgeonFinStage(){
	var formObj=document.forms[0];
	var pros_imp_val=formObj.pros_imp_val.value;
	formObj.pros_imp_val.selectedIndex = 0;
}

function checkProsNursingFinStage(){
	var formObj=document.forms[0];
	var pros_imp_val=formObj.pros_imp_val.value;
	formObj.pros_imp_val.selectedIndex = 0;
}

function checkProsAdminFinStage(){
	var formObj=document.forms[0];
	var pros_imp_val=formObj.pros_imp_val.value;
	formObj.pros_imp_val.selectedIndex = 0;
}

function checkProsImpChkBox(){
var formObj=document.forms[0];
	var pros_imp_val=formObj.pros_imp_val.value;
	if(pros_imp_val=="RS"){
		if(formObj.pros_srgn_notes_yn.checked==false){
			alert(getMessage("APP-OT0149","OT"));//APP-OT0149
			formObj.pros_imp_val.selectedIndex = 0;
		}
	}else if(pros_imp_val=="RN"){
		if(formObj.pros_nursing_notes_yn.checked==false){
			alert(getMessage("APP-OT0150","OT"))//APP-OT0150
			formObj.pros_imp_val.selectedIndex = 0;
		}
	}else if(pros_imp_val=="AF"){
		if(formObj.pros_admin_yn.checked==false){
			alert(getMessage("APP-OT0151","OT"));//APP-OT0151
			formObj.pros_imp_val.selectedIndex = 0;
		}
	}

}
//Finalisation Stages Validation for Prosthesis/Implants Ends

//Finalisation Stages Validation for Equipments
function checkEquipNursingFinStage(){
	var formObj=document.forms[0];
	var equip_val=formObj.equip_val.value;
	formObj.equip_val.selectedIndex = 0;
}

function checkEquipAdminFinStage(){
	var formObj=document.forms[0];
	var equip_val=formObj.equip_val.value;
	formObj.equip_val.selectedIndex = 0;
}

function checkEquipChkBox(){
var formObj=document.forms[0];
	var equip_val=formObj.equip_val.value;
	if(equip_val=="RN"){
		if(formObj.equip_nursing_notes_yn.checked==false){
			alert(getMessage("APP-OT0150","OT"))//APP-OT0150
			formObj.equip_val.selectedIndex = 0;
		}
	}else if(equip_val=="AF"){
		if(formObj.equip_admin_yn.checked==false){
			alert(getMessage("APP-OT0151","OT"))//APP-OT0151
			formObj.equip_val.selectedIndex = 0;
		}
	}
}

//Finalisation Stages Validation for Equipments Ends

//Finalisation Stages Validation for Instruments/CSSD

function checkInstrNursingFinStage(){
	var formObj=document.forms[0];
	var instr_cssd_val=formObj.instr_cssd_val.value;
	formObj.instr_cssd_val.selectedIndex = 0;
}

function checkInstrAdminFinStage(){
	var formObj=document.forms[0];
	var instr_cssd_val=formObj.instr_cssd_val.value;
	formObj.instr_cssd_val.selectedIndex = 0;
}

function checkInstrChkBox(){
var formObj=document.forms[0];
	var instr_cssd_val=formObj.instr_cssd_val.value;
	if(instr_cssd_val=="RN"){
		if(formObj.cssd_nursing_notes_yn.checked==false){
			alert(getMessage("APP-OT0150","OT"))//APP-OT0150
			formObj.instr_cssd_val.selectedIndex = 0;
		}
	}else if(instr_cssd_val=="AF"){
		if(formObj.cssd_admin_yn.checked==false){
			alert(getMessage("APP-OT0151","OT"))//APP-OT0151
			formObj.instr_cssd_val.selectedIndex = 0;
		}
	}

}
//Finalisation Stages Validation for Instruments/CSSD Ends
//Finalisation Stages Validation for Consumables

function checkConsNursingFinStage(){
	var formObj=document.forms[0];
	var consumable_pack_val=formObj.consumable_pack_val.value;
	formObj.consumable_pack_val.selectedIndex = 0;
}

function checkConsAdminFinStage(){
	var formObj=document.forms[0];
	var consumable_pack_val=formObj.consumable_pack_val.value;
	formObj.consumable_pack_val.selectedIndex = 0;
}

function checkConsChkBox(){
var formObj=document.forms[0];
	var consumable_pack_val=formObj.consumable_pack_val.value;
	if(consumable_pack_val=="RN"){
		if(formObj.cons_nursing_notes_yn.checked==false){
			alert(getMessage("APP-OT0150","OT"))//APP-OT0150
			formObj.consumable_pack_val.selectedIndex = 0;
		}
	}else if(consumable_pack_val=="AF"){
		if(formObj.cons_admin_yn.checked==false){
			alert(getMessage("APP-OT0151","OT"))//APP-OT0151
			formObj.consumable_pack_val.selectedIndex = 0;
		}
	}

}
//Finalisation Stages Validation for Consumables

function chkMandatoryBillingSetupPage(){
	var commit_flag=true;
	var formObj = parent.content.f_query_add_mod.document.forms[0];
	//Pros chk
	var pros_imp_val=formObj.pros_imp_val.value;
	var pros_srgn_chk=formObj.pros_srgn_notes_yn.checked;
	var pros_nursing_notes_yn=formObj.pros_nursing_notes_yn.checked;
	var pros_admin_yn=formObj.pros_admin_yn.checked;
	//Equip chk
	var equip_val=formObj.equip_val.value;
	var equip_nursing_chk=formObj.equip_nursing_notes_yn.checked;
	var equip_admin_chk=formObj.equip_admin_yn.checked;
	//Instr CSSD
	var instr_cssd_val=formObj.instr_cssd_val.value;
	var cssd_nursing_chk=formObj.cssd_nursing_notes_yn.checked;
	var cssd_admin_chk=formObj.cssd_admin_yn.checked;
	//Consumables
	var consumable_pack_val=formObj.consumable_pack_val.value;
	var cons_nursing_chk=formObj.cons_nursing_notes_yn.checked;
	var cons_admin_chk=formObj.cons_admin_yn.checked;

	if((pros_srgn_chk==true || pros_nursing_notes_yn==true || pros_admin_yn==true) && pros_imp_val==""){
		var mesg=getMessage("APP-OT0152","OT")//APP-OT0150;//APP-OT0152
		parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg
		commit_flag=false;
	}else
	if((equip_nursing_chk==true || equip_admin_chk==true) && equip_val==""){
		var mesg=getMessage("APP-OT0153","OT");//APP-OT0153
		parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg
		commit_flag=false;
	}else
	if((cssd_nursing_chk==true || cssd_admin_chk==true) && instr_cssd_val==""){
		var mesg=getMessage("APP-OT0154","OT");//APP-OT0154
		parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg
		commit_flag=false;
	}else
	if((cons_nursing_chk==true || cons_admin_chk==true) && consumable_pack_val==""){
		var mesg=getMessage("APP-OT0155","OT");//APP-OT0155
		parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg
		commit_flag=false;
	}
	return commit_flag;
}

//IN054191 start
function chkMandatoryOtherDetails()
{
	var formObj = parent.content.f_query_add_mod.document.forms[0];
	var chkAmmendBookingsDaysVal = formObj.chkAmmendBookingsDays.value;
	var chkAmmendBookings=formObj.chkAmmendBookings.value;//MMS-QH-CRF-186
	
	if(chkAmmendBookingsDaysVal > 0 && chkAmmendBookingsDaysVal <= 365){
	
	return true;
	}
	//MMS-QH-CRF-186
	else if(chkAmmendBookings=="N"){
	return true;
	}
	else{
	
		//var mesg = "Timelimit for existing booking selection(in days) should be minimum 1 and maximum 365";
		//getLabel("eOT.UnitTimeforBooking.Label","OT");
		var mesg = getLabel("eOT.TimelimitForExistingBookingShouldBeminimumAndMaximum.Label","OT");
		formObj.chkAmmendBookingsDays.focus();
		parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg
		return false;
	}
}
//IN054191 end

function checkBillSetupFlag(){
	var formObj=document.forms[0];
	var facility_id=formObj.facilityid.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "facility_id="+facility_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=checkBLInterfaceaFlag&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal=="Y"){
			window.parent.frames[1].document.getElementById("BillingSetup").disabled=false;
	}else{
			window.parent.frames[1].document.getElementById("BillingSetup").disabled=true;
	}

}

//Added by rajesh for IN017012 issue on 71/01/2010

function checkPanelService(){
	var formObj=document.forms[0];
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var param="func_mode=chkpanelservice";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	if(retVal>0){
		alert(getMessage("APP-OT0182","OT"))
		formObj.billing_sub_services.checked=false;
		return false;
	}
}

function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}

//Rajesh V
async function getLookup(obj,text){
	var frmObj = document.forms[0];
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var user_id = document.forms[0].user_id.value;
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	var sql= "";
	if(text=='request_doc'){
		sql = "SELECT a.doc_type_code code,b.short_desc description FROM ss_trn_doc_type a, sy_doc_type_master_lang_vw b WHERE a.facility_id = '"+facility_id+"' AND a.doc_type_code = b.doc_type_code AND a.trn_type = 'REQ' AND b.status IS NULL AND language_id = '"+locale+"' AND upper(b.short_desc) like upper(?) and upper(a.doc_type_code) like upper(?) ORDER BY 2";
	}
	else if(text=='return_doc'){
		sql = "SELECT a.doc_type_code code,b.short_desc description FROM ss_trn_doc_type a, sy_doc_type_master_lang_vw b WHERE a.facility_id = '"+facility_id+"' AND a.doc_type_code = b.doc_type_code AND a.trn_type = 'RTG' AND b.status IS NULL AND language_id = '"+locale+"' AND upper(b.short_desc) like upper(?) and upper(a.doc_type_code) like upper(?) ORDER BY 2";
	}
	else if(text=='request_store'){
		sql = "SELECT ss.store_code code,mm.short_desc description FROM ss_user_access_for_store ss, mm_store mm WHERE ss.store_code = mm.store_code AND ss.req_allowed_yn = 'Y' AND mm.eff_status = 'E' AND mm.facility_id = '"+facility_id+"' AND user_id = '"+user_id+"' AND upper(mm.short_desc) like upper(?) and upper(ss.store_code) like upper(?) ORDER BY 2";
	}
	else if(text=='issue_store'){
		sql = "SELECT ss.store_code code,mm.short_desc description FROM ss_store ss, mm_store mm WHERE ss.store_code = mm.store_code AND ss.iss_allowed_yn = 'Y' AND mm.facility_id = '"+facility_id+"' AND mm.eff_status = 'E' AND upper(mm.short_desc) like upper(?) and upper(ss.store_code) like upper(?) ORDER BY 2"
	}
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues =await CommonLookup(getLabel("Common.speciality.label","Common"), argumentArray );
	var ret1=unescape(returnedValues);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if((returnedValues != null) && (returnedValues != "") )  {
		if(text=='request_doc'){
			frmObj.request_doc.value = arr[1];
			frmObj.request_doc_hdn.value = arr[0];
		}
		else if(text=='return_doc'){
			frmObj.return_doc.value = arr[1];
			frmObj.return_doc_hdn.value = arr[0];
		}
		else if(text=='request_store'){
			frmObj.request_store.value = arr[1];
			frmObj.request_store_hdn.value = arr[0];
		}
		else if(text=='issue_store'){
			frmObj.issue_store.value = arr[1];
			frmObj.issue_store_hdn.value = arr[0];
		}
	}
	else{
		if(text=='request_doc'){
			frmObj.request_doc.value ='';
			frmObj.request_doc_hdn.value = '';
		}
		else if(text=='return_doc'){
			frmObj.return_doc.value = '';
			frmObj.return_doc_hdn.value = '';
		}
		else if(text=='request_store'){
			frmObj.request_store.value = '';
			frmObj.request_store_hdn.value = '';
		}
		else if(text=='issue_store'){
			frmObj.issue_store.value = '';
			frmObj.issue_store_hdn.value = '';
		}

	}

}

function fieldEnableDisable(text){
	var frmObj = document.forms[0];
	if(text=='cssdInterface'){
		if(frmObj.cssdInterface.checked == true){
			frmObj.request_doc.disabled = false;
			frmObj.btn_request_doc.disabled = false;
			frmObj.return_doc.disabled = false;
			frmObj.btn_return_doc.disabled = false;
			frmObj.request_store.disabled = false;
			frmObj.btn_req_str.disabled = false;
			frmObj.issue_store.disabled = false;
			frmObj.btn_issue_store.disabled = false;
		}
		else{
			frmObj.request_doc.disabled = true;
			frmObj.btn_request_doc.disabled = true;
			frmObj.return_doc.disabled = true;
			frmObj.btn_return_doc.disabled = true;
			frmObj.request_store.disabled = true;
			frmObj.btn_req_str.disabled = true;
			frmObj.issue_store.disabled = true;
			frmObj.btn_issue_store.disabled = true;

			/*frmObj.request_doc.value = '';
			frmObj.return_doc.value = '';
			frmObj.request_store.value = '';
			frmObj.issue_store.value = '';*/
		}
	}
	else if(text=='turnAround'){
		if(frmObj.turnAround.checked == true){
			frmObj.fromStatus.disabled = false;
			frmObj.toStatus.disabled = false;
		}
		else{
			frmObj.fromStatus.disabled = true;
			frmObj.toStatus.disabled = true;

			/*frmObj.fromStatus.value = '';
			frmObj.toStatus.value = '';*/
		}
	}
}


function populateToStatus(obj){
	var tobox = document.forms[0].toStatus;
	if(obj.value.length>1){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=populateToStatus&from_value="+obj.value;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var toStatus = localTrimString(xmlHttp.responseText);
		tobox.options.length = 0;
		if(toStatus.length>1){
			var toStatusArr = toStatus.split("###");
			for(var i=0;i<toStatusArr.length;i++){
				var toValArr = toStatusArr[i].split(":::");
				var opt = document.createElement("option");
				opt.value = toValArr[0];
				opt.text = toValArr[1];
				tobox.add(opt);
			}
		}
		else{
			var opt = document.createElement("option");
			opt.value = "";
			opt.text = "Select a lesser from Status";
			tobox.add(opt);
		}
	}
	else{
		tobox.options.length = 0;
		var opt = document.createElement("option");
		opt.value = "";
		opt.text = "Please select From Status";
		tobox.add(opt);
	}


}

function checkVal(){
	var fromstatus = document.forms[0].fromStatus;
	var tostatus = document.forms[0].toStatus;
	if((tostatus.value<=fromstatus.value)||(fromstatus.value == 65)||(tostatus.value == 35)){
		alert(getMessage("APP-OT0205","OT"));
		fromstatus.selectedIndex = 0;
		tostatus.selectedIndex = tostatus.options.length-1;
		fromstatus.focus();
	}

}
//Rajesh V

//Added by Arthi for ML-MMOH-CRF-1936
function RecSurNurEnDisYN(){
	
	var formObj = document.forms[0];
	if(formObj.AnesProcedureStartEndTimeYN.checked == true){
			formObj.RecordSurgeonNotesYN.disabled = false;
			formObj.RecordNursingNotesYN.disabled = false;
	}

	else if(formObj.AnesStartEndTimeYN.checked == true){
			formObj.RecordSurgeonNotesYN.disabled = false;
			formObj.RecordNursingNotesYN.disabled = false;
	}

	else if(formObj.SurgeryStartEndTimeYN.checked == true){
			formObj.RecordSurgeonNotesYN.disabled = false;
			formObj.RecordNursingNotesYN.disabled = false;
	}

	else if(formObj.PreparationStartEndTimeYN.checked == true){
			formObj.RecordSurgeonNotesYN.disabled = false;
			formObj.RecordNursingNotesYN.disabled = false;
	}

	else if(formObj.AnesProcedureStartEndTimeYN.checked == false && formObj.AnesStartEndTimeYN.checked == false && formObj.SurgeryStartEndTimeYN.checked == false && formObj.PreparationStartEndTimeYN.checked == false){
			formObj.RecordSurgeonNotesYN.disabled = true;
			formObj.RecordNursingNotesYN.disabled = true;
			formObj.RecordSurgeonNotesYN.checked = false;
			formObj.RecordNursingNotesYN.checked = false;
	}
}

function enDisRecSurYN(){
 
	//var formObj = document.forms[0];

	if(document.forms[0].AnesProcedureStartEndTimeYN.checked == true && document.forms[0].AnesStartEndTimeYN.checked == true && document.forms[0].SurgeryStartEndTimeYN.checked == true && document.forms[0].PreparationStartEndTimeYN.checked == true){
			document.forms[0].RecordSurgeonNotesYN.disabled = false;
			document.forms[0].RecordNursingNotesYN.disabled = false;
	}
	else if(document.forms[0].AnesProcedureStartEndTimeYN.checked == true || document.forms[0].AnesStartEndTimeYN.checked == true || document.forms[0].SurgeryStartEndTimeYN.checked == true || document.forms[0].PreparationStartEndTimeYN.checked == true){
			document.forms[0].RecordSurgeonNotesYN.disabled = false;
			document.forms[0].RecordNursingNotesYN.disabled = false;
	}else{
			document.forms[0].RecordSurgeonNotesYN.disabled = true;
			document.forms[0].RecordNursingNotesYN.disabled = true;
	}
}
//End ML-MMOH-CRF-1936
