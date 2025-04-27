<!DOCTYPE html>
<%--
	FileName	: addOperatorStationDetails.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
%>


      <head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eAM/js/OperatorStation.js'></script>

      	<script>





function callfocusfun()
{
     
	 if(parent.frames[0].document.forms[0].operstntype.value=='O')
	 document.forms[0].book_appt_yn.focus()
}

function disencfrm()
 {

	if(document.forms[0].eff_status.value == 'E')
	{
		
		
	 if( document.forms[0].create_booking_yn.checked == true)
	 {

		 document.getElementById("CREATE_BOOKING_WITH_CONF_YN").disabled = true;
		 document.getElementById("CREATE_BOOKING_WITH_CONF_YN").checked = false;
		 document.getElementById("CREATE_BOOKING_WITH_CONF_YN").value = "N";
		
	 }
	 else 
	 {
		
		document.getElementById("CREATE_BOOKING_WITH_CONF_YN").disabled = false;
		  
		  
	 }
	}
 }

 function disencr()
{
	if(document.forms[0].eff_status.value == 'E')
	{
	 if( document.forms[0].CREATE_BOOKING_WITH_CONF_YN.checked)
	 {
		 document.forms[0].create_booking_yn.disabled = true;
		 document.getElementById('create_booking_yn').checked = false;
		 document.getElementById('create_booking_yn').value = "N";
	 }
	 else
	 {
		 document.forms[0].create_booking_yn.disabled = false;
		
	 }
	}
 }

 function chk_others(obj){
  if(obj.name=='book_appt_yn'){
	 if(obj.checked==true){
	
	 document.forms[0].book_appt_wo_pid_yn.disabled=false;
	 document.forms[0].obook_appt_yn.disabled=false;

	// document.forms[0].book_appt_across_catg_yn.disabled=false; 
	
	 document.getElementById('FORCED_BOOK_APPT_YN').disabled=false;

	 document.getElementById('GLOBAL_BOOK_APPT_YN').disabled=false; 
	// document.getElementById('BOOK_APPT_ACROSS_CATG_YN').disabled=false;

	 }
	 else{
		
	 document.forms[0].book_appt_wo_pid_yn.checked=false;
	 document.forms[0].book_appt_wo_pid_yn.disabled=true;
	 document.forms[0].obook_appt_yn.checked=false;
	 document.forms[0].obook_appt_yn.disabled=true;
	// document.forms[0].book_appt_across_catg_yn.checked=false;
	// document.forms[0].book_appt_across_catg_yn.disabled=true; 
	  
	  document.getElementById('FORCED_BOOK_APPT_YN').checked=false; 
	  
	  document.getElementById('FORCED_BOOK_APPT_YN').disabled=true;
  	 document.getElementById('GLOBAL_BOOK_APPT_YN').checked=false; 
	 document.getElementById('GLOBAL_BOOK_APPT_YN').disabled=true; 
	// document.getElementById('BOOK_APPT_ACROSS_CATG_YN').checked=false;
	// document.getElementById('BOOK_APPT_ACROSS_CATG_YN').disabled=true;
	 
	 }
 
 }
/* else if(obj.name=='tfr_appt_yn'){
	if(obj.checked==true){
	  document.forms[0].tfr_appt_across_catg_yn.disabled=false;
	 }
	 else{
	 	 document.forms[0].tfr_appt_across_catg_yn.checked=false;
		 document.forms[0].tfr_appt_across_catg_yn.disabled=true;
	 }
 } */
 else if(obj.name=='register_visit_yn'){
	if(obj.checked==true){
	 document.forms[0].register_pat_yn.disabled=false;
	 document.forms[0].register_visit_walkin_yn.disabled=false;
	 document.forms[0].register_visit_referral_yn.disabled=false;
	 }
	 else{
	 	 document.forms[0].register_pat_yn.checked=false;
		 document.forms[0].register_pat_yn.disabled=true;
		 document.forms[0].register_visit_walkin_yn.checked=false;
	 	document.forms[0].register_visit_walkin_yn.disabled=true;
	 	document.forms[0].register_visit_referral_yn.checked=false;
	 	document.forms[0].register_visit_referral_yn.disabled=true;
	 }
 }
 else if(obj.name=='register_visit_walkin_yn'){
	 if(obj.checked==true){
		document.forms[0].OVERRIDE_WALKIN_YN.disabled=false;	 
	 }
	 else{
	 	document.forms[0].OVERRIDE_WALKIN_YN.checked=false;
		document.forms[0].OVERRIDE_WALKIN_YN.disabled=true;		
	 }
 }

 
 
 }
 function setVal(Obj)
 {

	if(Obj.checked == true)      		
		Obj.value = 'Y';     		
	else if(Obj.checked == false)
		Obj.value = 'N';


 }


var optype;

/*function setView()
{
	optype=parent.frames[0].document.forms[0].operstntype.value;
	if (optype=='I')
	{
		document.getElementById('inpat_act_tab_vw').scrollIntoView();
		document.getElementById('create_booking_yn').focus();
	}
	else if(optype=='O')
	{
		document.getElementById('outpat_act_tab_vw').scrollIntoView();
		document.getElementById('book_appt_yn').focus();
	}
}*/


function codeArrestforScroll(e)
{
	
	alert(getMessage("WELCOME","Common"));
	return false;
}
   	
 

function chkDetails(obj)
{
	
	if (document.forms[0].function_name.value!='insert')
	{
		if(document.forms[0].FORCED_BOOK_APPT_YN)
		{
		if (obj.checked==true)	
			document.forms[0].FORCED_BOOK_APPT_YN.value="Y";
		else if (obj.checked==false)	
			document.forms[0].FORCED_BOOK_APPT_YN.value="N";
		}
	}	
	if (document.forms[0].function_name.value!='insert')
	{
		if(document.forms[0].MAINTAIN_DEATH_REGISTER_YN)
		{
		if (obj.checked==true)	
			document.forms[0].MAINTAIN_DEATH_REGISTER_YN.value="Y";
		else if (obj.checked==false)	
			document.forms[0].MAINTAIN_DEATH_REGISTER_YN.value="N";
		}		
	}	
	
	if (document.forms[0].function_name.value!='insert')
	{
		if (obj.name=='pract_tfr_yn')			
		{			
			if (parseInt(document.forms[0].PTFR_YN_CNT.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		//9/16/2008 chking validation for CancelReserve bed start
		
		if (obj.name=='cancel_reBeds_yn')			
		{
			//alert(document.forms[0].CRB__YN_CNT.value);
		
			if (parseInt(document.forms[0].CRB__YN_CNT.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		//9/16/2008 chking validation for CancelReserve bed end
		else if (obj.name=='BED_CLASS_CHANGE_YN')			
		{
			if (parseInt(document.forms[0].BC_CNT.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}		
		else if (obj.name=='book_appt_yn')			
		{
			if (parseInt(document.forms[0].book_appt_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}		
		else if (obj.name=='book_appt_wo_pid_yn')
		{		
			if (parseInt(document.forms[0].book_appt_wo_pid_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='obook_appt_yn')
		{		
			if (parseInt(document.forms[0].obook_appt_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
				
		else if (obj.name=='FORCED_BOOK_APPT_YN')
		{		
			if (parseInt(document.forms[0].FORCED_BOOK_APPT_YN_CNT.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}	///Newly added on 09/01/2005
		else if (obj.name=='create_wait_list_yn')
		{		
			if (parseInt(document.forms[0].create_wait_list_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='modify_wait_list_yn')
		{		
			if (parseInt(document.forms[0].modify_wait_list_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='cancel_wait_list_yn')
		{		
			if (parseInt(document.forms[0].cancel_wait_list_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='GLOBAL_BOOK_APPT_YN')
		{			
			var flag="Y";
			if (parseInt(document.forms[0].GLOBAL_BOOK_APPT_YN_CNT.value) > 0)
			{					
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
				flag="N";
			}
			if(document.forms[0].GLOBAL_BOOK_APPT_YN.checked==false){ 
				if ((parseInt(document.forms[0].GLOBAL_LOCN_APPT_YN_CNT.value) > 0)&& (flag=="Y"))
				{				
					alert(getMessage("CANNOT_DISABLE_OPER_STN_LOCN","AM"));
					obj.checked=true;
				}
			}
		}
		
		else if (obj.name=='tfr_appt_yn')
		{		
			if (parseInt(document.forms[0].tfr_appt_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		/*else if (obj.name=='tfr_appt_across_catg_yn')
		{		
			if (parseInt(document.forms[0].tfr_appt_across_catg_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}*/
		else if (obj.name=='canc_appt_yn')
		{		
			if (parseInt(document.forms[0].canc_appt_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='register_visit_yn')
		{		
			if (parseInt(document.forms[0].register_visit_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='register_pat_yn')
		{		
			if (parseInt(document.forms[0].register_pat_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='cancel_visit_yn')
		{		
			if (parseInt(document.forms[0].cancel_visit_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='revise_visit_yn')
		{		
			if (parseInt(document.forms[0].revise_visit_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='manage_queue_yn')
		{		
			if (parseInt(document.forms[0].manage_queue_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='checkout_pat_yn')
		{		
			if (parseInt(document.forms[0].checkout_pat_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='create_booking_yn')
		{		
			if (parseInt(document.forms[0].create_booking_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='revise_booking_yn')
		{		
			if (parseInt(document.forms[0].revise_booking_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='canc_booking_yn')
		{		
			if (parseInt(document.forms[0].canc_booking_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='CONFIRM_BOOKING_YN')
		{		
			if (parseInt(document.forms[0].CONFIRM_BOOKING_YN_CNT.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='admit_pat_yn')
		{		
			if (parseInt(document.forms[0].admit_pat_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='quick_admission_yn')
		{	//this condtion added for this CRF Bru-HIMS-CRF-261	
			if (parseInt(document.forms[0].quick_admission_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='register_pat_in_admn_yn')
		{		
			if (parseInt(document.forms[0].register_pat_in_admn_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='assign_bed_yn')
		{		
			if (parseInt(document.forms[0].assign_bed_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='assign_treat_pract_yn')
		{		
			if (parseInt(document.forms[0].assign_treat_pract_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='canc_admission_yn')
		{		
			if (parseInt(document.forms[0].canc_admission_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='emergency_tfr_yn')
		{		
			if (parseInt(document.forms[0].emergency_tfr_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='routine_tfr_yn')
		{		
			if (parseInt(document.forms[0].routine_tfr_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='discharge_pat_yn')
		{		
			if (parseInt(document.forms[0].discharge_pat_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='revise_leave_yn')
		{		
			if (parseInt(document.forms[0].revise_leave_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='check_lodger_yn')
		{		
			if (parseInt(document.forms[0].check_lodger_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='block_bed_yn')
		{		
			if (parseInt(document.forms[0].block_bed_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='release_bed_yn')
		{
			if (parseInt(document.forms[0].release_bed_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='register_visit_walkin_yn')
		{
			if (parseInt(document.forms[0].register_visit_walkin_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='register_visit_referral_yn')
		{
			if (parseInt(document.forms[0].register_visit_referral_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='canc_req_yn')			
		{
			if (parseInt(document.forms[0].CRQ_YN_CNT.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='cfrm_req_yn')			
		{
			if (parseInt(document.forms[0].CFQ_YN_CNT.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='TRANSFER_OUT_PATIENT_YN')			
		{
			if (parseInt(document.forms[0].TRANSFER_OUT_PATIENT_YN_CNT.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='can_tfr_out_yn')			
		{
			if (parseInt(document.forms[0].CTO_YN_CNT.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='TRANSFER_OUT_PATIENT_YN')			
		{
			if (parseInt(document.forms[0].TRANSFER_OUT_PATIENT_YN_CNT.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='TRANSFER_IN_PATIENT_YN')			
		{
			if (parseInt(document.forms[0].TRANSFER_IN_PATIENT_YN_CNT.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='SWAP_BED_YN')			
		{
			if (parseInt(document.forms[0].SWAP_BED_YN_CNT.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='ADMIT_PATIENT_WITH_BED_YN')			
		{
			if (parseInt(document.forms[0].ADMIT_PATIENT_WITH_BED_YN_CNT.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='CHG_NURS_UNIT_IN_ASSIGN_BED_YN')			
		{
			if (parseInt(document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN_CNT.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='BACKDATED_ADMISSION_YN')			
		{
			if (parseInt(document.forms[0].BA_CNT.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='dchrg_adv_yn')			
		{
			if (parseInt(document.forms[0].DADV_YN_CNT.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}else if (obj.name=='LINK_BABY_TO_MOTHER_YN')			
		{
			if (parseInt(document.forms[0].link_baby_to_mother_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='REG_NEWBORN_FOR_IP_YN')			
		{
			if (parseInt(document.forms[0].reg_newborn_for_ip_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}else if (obj.name=='DISCHARGE_CHECKLIST_YN')			
		{
			if (parseInt(document.forms[0].discharge_checklist_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}else if(obj.name=='CANCEL_DISCHARGE_YN')
		{
			
			if (parseInt(document.forms[0].cancel_discharge_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='RESERVE_BED_BAY_YN')			
		{
			if (parseInt(document.forms[0].reserve_bed_bay_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='RELEASE_BED_BAY_YN')			
		{
			if (parseInt(document.forms[0].release_bed_bay_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}


else if (obj.name=='DIAG_PROC_RECODE_FOR_OP_YN')			
		{
			if (parseInt(document.forms[0].dia_proc_recode_for_op_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}


   else if (obj.name=='DIAG_PROC_RECODE_FOR_IP_YN')			
		{
	   		if (parseInt(document.forms[0].dia_proc_recode_for_ip_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				
				obj.checked=true;
			}
		}

		else if (obj.name=='REG_IP_REFERRAL_YN')			
		{
			if (parseInt(document.forms[0].reg_ip_referral_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='CONFIRM_BEDSIDE_REFERRAL_YN')			
		{
			if (parseInt(document.forms[0].conf_bed_ref_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}

		else if (obj.name=='OVERRIDE_WALKIN_YN')			
		{
			if (parseInt(document.forms[0].override_walkin_yn_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		
		else if (obj.name=='CANCEL_CHECKOUT_YN')			
		{
			if (parseInt(document.forms[0].CANCEL_CHECKOUT_YN.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if (obj.name=='MAINTAIN_DEATH_REGISTER_YN')			
		{			
			if (parseInt(document.forms[0].MAINTAIN_DEATH_REGISTER_YN_CNT.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
		}
		else if(obj.name=='BOOK_APPT_ACROSS_CATG_YN'){
			if(obj.checked==true){
				obj.value='Y';
			}else{
				obj.value='N';
			}
		}
		
		if (obj.name=='emergency_transfer_yn')			
		{	        
			if (parseInt(document.forms[0].emergency_transfer_cnt.value) > 0)
			{
				alert(getMessage("CANNOT_DISABLE_OPER_STN","AM"));
				obj.checked=true;
			}
			
		}

	}
}



function chngadmtassign()
{   
	       /*Below line modified for this CRF Bru-HIMS-CRF-261*/
	        if(document.forms[0].admit_pat_yn.checked==true)
				{  
					if(document.forms[0].admit_pat_yn.disabled==false)
					document.forms[0].ADMIT_PATIENT_WITH_BED_YN.disabled=false;
					if(document.forms[0].admit_pat_yn.disabled==false)
					document.forms[0].quick_admission_yn.disabled=false;
				}
				else
				{
				  if(document.forms[0].ADMIT_PATIENT_WITH_BED_YN.checked==true)
					{
				      document.forms[0].ADMIT_PATIENT_WITH_BED_YN.checked=false;
					}
				   document.forms[0].ADMIT_PATIENT_WITH_BED_YN.disabled=true;
				   
				   if(document.forms[0].quick_admission_yn.checked)
					{
				      document.forms[0].quick_admission_yn.checked=false;
					  
					}
					document.forms[0].quick_admission_yn.disabled=true;
					//else{
				     //  document.forms[0].quick_admission_yn.disabled=true;
				  // }
				}
	if(document.forms[0].assign_bed_yn.checked==true)
		{
			if(document.forms[0].assign_bed_yn.diabled==false)
			document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.disabled=false;
		}
	else
		{
		   if(document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.checked==true)
			{
		   document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.checked=false;
			}
		   document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.disabled=true;
		}
}

   	</script>
   	</head>
     <body OnMouseDown="CodeArrest()"  onKeyDown = 'lockKey()' onclick ="CodeArrest()" onSelect="codeArrestThruSelect();" >

      <%

		 String oper_stn_id="";
		 
		 String operstntype="";
		 String disabled="";
		 String book_appt_chk="";
		 String trans_appt_chk="";
		 String register_chk="";
		 String override_dis="";
		 
		 String admit_chk="";//this line Added for this CRF Bru-HIMS-CRF-261
	
		
			
		
		 
   	 	 String rule="";
   	 	String chk = ""; 
   	 	String dis = ""; 
   	 	String chkCancel = ""; 

		 oper_stn_id=request.getParameter("oper_stn_id");
		 if(oper_stn_id==null) oper_stn_id="";
		String facilityId=request.getParameter("facility_id");
		 if(facilityId ==null) facilityId="";
		
		 operstntype=request.getParameter("oper_stn_type");

	
		

		
	 	 Connection conn = null;
	 

		 String recordexists = "N";

		 String eff_status = request.getParameter("eff_status");
			if(eff_status == null) eff_status="";
		
		 ResultSet rs= null;
		 ResultSet rset=null;
		 Statement stmt = null;
		 PreparedStatement pstmt = null;


try{
	conn = ConnectionManager.getConnection(request);
	stmt=conn.createStatement();
	if(!oper_stn_id.equals(""))
	{
		   /*Below query Modified for this CRF Br-HIMS-CRF-261*/
			
			String sql ="select facility_id,oper_stn_id,long_desc,short_desc,nurs_unit_code "+
						" ,shift_operated_yn,shift_group,ws_no,eff_status "+
						" ,nvl(book_appt_yn,'N') book_appt_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and book_appt_yn ='Y') book_appt_yn_cnt "+
						" ,nvl(create_wait_list_yn,'N') create_wait_list_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and create_wait_list_yn ='Y') create_wait_list_yn_cnt "+
                       " , nvl(cancel_wait_list_yn,'N') cancel_wait_list_yn, nvl(modify_wait_list_yn,'N') modify_wait_list_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and modify_wait_list_yn ='Y') modify_wait_list_yn_cnt, "+
						" (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and CANCEL_WAIT_LIST_YN ='Y') cancel_wait_list_yn_cnt "+
						" ,nvl(book_appt_wo_pid_yn,'N') book_appt_wo_pid_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and book_appt_wo_pid_yn ='Y') book_appt_wo_pid_yn_cnt,  nvl(obook_appt_yn,'N') obook_appt_yn, (SELECT COUNT(1) FROM   AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and obook_appt_yn ='Y') obook_appt_yn_cnt, nvl(book_appt_across_catg_yn ,'N') book_appt_across_catg_yn "+
						" , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and book_appt_across_catg_yn ='Y') book_appt_across_catg_yn_cnt,nvl(FORCED_BOOK_APPT_YN ,'N') FORCED_BOOK_APPT_YN "+",(SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and FORCED_BOOK_APPT_YN ='Y') FORCED_BOOK_CNT,nvl(CONFIRM_BOOKING_YN ,'N') CONFIRM_BOOKING "+
						" , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and CONFIRM_BOOKING_YN ='Y') CON_CNT,nvl(CREATE_BOOKING_WITH_CONF_YN ,'N') CR_B_WH_C_YN "+
						" , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and CREATE_BOOKING_WITH_CONF_YN ='Y') CR_B_WH_C_CNT,  nvl(GLOBAL_BOOK_APPT_YN ,'N') GLOBAL_BOOK_APPT_YN "+
						" , (SELECT COUNT (1) FROM am_restrn_for_oper_stn a WHERE a.facility_id = ?   AND a.oper_stn_id = ? AND a.global_book_appt_yn = 'Y') GLOBAL_BOOK_CNT, (SELECT COUNT (1) FROM am_locn_for_oper_stn b WHERE b.facility_id = ? AND b.oper_stn_id = ? AND b.global_locn_yn = 'Y') GLOBAL_LOCN_CNT, nvl(tfr_appt_yn,'N') tfr_appt_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and tfr_appt_yn ='Y') tfr_appt_yn_cnt, nvl(tfr_appt_across_catg_yn,'N') tfr_appt_across_catg_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and tfr_appt_across_catg_yn ='Y') tfr_appt_across_catg_yn_cnt, nvl(canc_appt_yn,'N') canc_appt_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and canc_appt_yn ='Y') canc_appt_yn_cnt, nvl(register_visit_yn ,'N') register_visit_yn "+
						" , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and register_visit_yn ='Y') register_visit_yn_cnt, nvl(register_pat_yn,'N') register_pat_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and register_pat_yn ='Y') register_pat_yn_cnt, nvl(cancel_visit_yn,'N') cancel_visit_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  cancel_visit_yn ='Y')  cancel_visit_yn_cnt, nvl(revise_visit_yn,'N') revise_visit_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and revise_visit_yn ='Y') revise_visit_yn_cnt, nvl(manage_queue_yn ,'N') manage_queue_yn "+
						" , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and manage_queue_yn ='Y') manage_queue_yn_cnt, nvl(checkout_pat_yn,'N') checkout_pat_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and checkout_pat_yn ='Y') checkout_pat_yn_cnt, oper_stn_type,nvl(create_booking_yn,'N') create_booking_yn, "+
						"(SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and create_booking_yn ='Y') create_booking_yn_cnt, nvl(revise_booking_yn ,'N') revise_booking_yn "+
						" , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and revise_booking_yn ='Y') revise_booking_yn_cnt, nvl(canc_booking_yn,'N') canc_booking_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and canc_booking_yn ='Y') canc_booking_yn_cnt, nvl(ADMIT_PATIENT_WITH_BED_YN,'N') ADMIT_PATIENT_WITH_BED_YN, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and ADMIT_PATIENT_WITH_BED_YN ='Y') ADMIT_PATIENT_CNT, nvl(CHG_NURS_UNIT_IN_ASSIGN_BED_YN,'N') CHG_NURS_UNIT_IN_ASSIGN_BED_YN, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and CHG_NURS_UNIT_IN_ASSIGN_BED_YN ='Y') CHG_NURS_UNIT_IN_CNT, nvl(TRANSFER_OUT_PATIENT_YN,'N') TRANSFER_OUT_PATIENT_YN, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and TRANSFER_OUT_PATIENT_YN ='Y') TRANSFER_OUT_CNT,	nvl(TRANSFER_IN_PATIENT_YN,'N') TRANSFER_IN_PATIENT_YN, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and TRANSFER_IN_PATIENT_YN ='Y') TRANSFER_IN_CNT,	 nvl(SWAP_BED_YN,'N') SWAP_BED_YN, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and SWAP_BED_YN ='Y') SWAP_CNT,nvl(BACKDATED_ADMISSION_YN,'N') BACKDATED_ADMISSION_YN, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and BACKDATED_ADMISSION_YN ='Y') BA_CNT,nvl(BED_CLASS_CHANGE_YN,'N') BED_CLASS_CHANGE_YN, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and BED_CLASS_CHANGE_YN ='Y') BC_CNT,nvl(CANCEL_REQUEST_YN,'N') canc_req_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and CANCEL_REQUEST_YN ='Y') CRQ_CNT,nvl(CANCEL_TRANSFER_OUT_YN,'N')can_tfr_out_yn , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and CANCEL_TRANSFER_OUT_YN ='Y') CTO_CNT,nvl(PRACT_TRANSFER_YN,'N') pract_tfr_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and PRACT_TRANSFER_YN ='Y') PTFR_CNT,nvl(CONFIRM_REQUEST_YN,'N') cfrm_req_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and CONFIRM_REQUEST_YN ='Y') CFQ_CNT,nvl(DISCHARGE_ADVICE_YN,'N') DCHRG_ADV_YN, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and DISCHARGE_ADVICE_YN ='Y') DADV_CNT, nvl(reject_admission_yn,'N') reject_admission_yn, (SELECT COUNT(1) FROM 		 AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and reject_admission_yn ='Y') reject_admission_yn_cnt, nvl(admit_pat_yn,'N') admit_pat_yn,  (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and admit_pat_yn ='Y') admit_pat_yn_cnt,nvl(quick_admission_yn,'N') quick_admission_yn,  (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and quick_admission_yn ='Y') quick_admission_yn_cnt, nvl(register_pat_in_admn_yn,'N') register_pat_in_admn_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and register_pat_in_admn_yn ='Y') register_pat_in_admn_yn_cnt, nvl(assign_bed_yn ,'N') assign_bed_yn "+
						" , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and assign_bed_yn ='Y') assign_bed_yn_cnt, nvl(assign_treat_pract_yn,'N') assign_treat_pract_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and assign_treat_pract_yn ='Y') assign_treat_pract_yn_cnt, nvl(revise_admission_yn,'N') revise_admission_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and revise_admission_yn ='Y') revise_admission_yn_cnt, nvl(canc_admission_yn,'N') canc_admission_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and canc_admission_yn ='Y') canc_admission_yn_cnt, nvl(emergency_tfr_yn,'N') emergency_tfr_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and emergency_tfr_yn ='Y') emergency_tfr_yn_cnt, nvl(routine_tfr_yn ,'N') routine_tfr_yn "+
						" , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and routine_tfr_yn ='Y') routine_tfr_yn_cnt, nvl(discharge_pat_yn,'N') discharge_pat_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and discharge_pat_yn ='Y') discharge_pat_yn_cnt, nvl(revise_leave_yn,'N')revise_leave_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and revise_leave_yn ='Y') revise_leave_yn_cnt, nvl(check_lodger_yn,'N')  check_lodger_yn,  (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and check_lodger_yn ='Y') check_lodger_yn_cnt, nvl(block_bed_yn,'N') block_bed_yn,  (SELECT COUNT(1) FROM   AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and block_bed_yn ='Y') block_bed_yn_cnt, "+
						" nvl(release_bed_yn,'N') release_bed_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and release_bed_yn ='Y') release_bed_yn_cnt,"+"nvl(DIAG_PROC_RECODE_FOR_OP_YN,'N') DIAG_PROC_RECODE_FOR_OP_YN, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and DIAG_PROC_RECODE_FOR_OP_YN ='Y') dia_proc_recode_for_op_cnt , nvl(register_visit_walkin_yn,'N') register_visit_walkin_yn , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and register_visit_walkin_yn ='Y') register_visit_walkin_yn_cnt,nvl(register_visit_referral_yn,'N') register_visit_referral_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and register_visit_referral_yn ='Y')register_visit_referral_yn_cnt ,nvl(LINK_BABY_TO_MOTHER_YN,'N') link_baby_to_mother_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  LINK_BABY_TO_MOTHER_YN ='Y')  link_baby_to_mother_yn_cnt ,nvl(REG_NEWBORN_FOR_IP_YN,'N') reg_newborn_for_ip_yn,(SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  REG_NEWBORN_FOR_IP_YN   ='Y')  reg_newborn_for_ip_yn_cnt,nvl(DISCHARGE_CHECKLIST_YN,'N') discharge_checklist_yn,(SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  DISCHARGE_CHECKLIST_YN ='Y')  discharge_checklist_yn_cnt,nvl(CANCEL_DISCHARGE_YN,'N') CANCEL_DISCHARGE_YN,(SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  CANCEL_DISCHARGE_YN ='Y')  CANCEL_DISCHARGE_YN_CNT,nvl(RESERVE_BED_BAY_YN,'N') reserve_bed_bay_yn,(SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  RESERVE_BED_BAY_YN ='Y')  reserve_bed_bay_yn_cnt,nvl(RELEASE_BED_BAY_YN,'N') release_bed_bay_yn,(SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  RELEASE_BED_BAY_YN ='Y')  release_bed_bay_yn_cnt,nvl(REG_IP_REFERRAL_YN,'N') reg_ip_referral_yn,(SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  REG_IP_REFERRAL_YN ='Y')  reg_ip_referral_yn_cnt,nvl(CONFIRM_BEDSIDE_REFERRAL_YN,'N') confirm_bedside_referral_yn,(SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  CONFIRM_BEDSIDE_REFERRAL_YN ='Y')  conf_bed_ref_yn_cnt,nvl(DIAG_PROC_RECODE_FOR_IP_YN,'N') DIAG_PROC_RECODE_FOR_IP_YN,(SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  DIAG_PROC_RECODE_FOR_IP_YN ='Y') dia_proc_recode_for_ip_cnt, nvl(OVERRIDE_WALKIN_YN,'N') OVERRIDE_WALKIN_YN, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  OVERRIDE_WALKIN_YN ='Y')  override_walkin_yn_cnt,nvl(CANCEL_CHECKOUT_YN,'N') CANCEL_CHECKOUT_YN, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  CANCEL_CHECKOUT_YN ='Y')  CANCEL_CHECKOUT_YN_CNT "+",nvl(CANCEL_RESERVE_BED_YN,'N') cancel_reserve_bed, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  CANCEL_RESERVE_BED_YN ='Y')  CANCEL_RESERVE_BED_YN "+",nvl(EMERGENCY_TRANSFER_YN,'N') emergency_transfer, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  EMERGENCY_TRANSFER_YN ='Y')  EMERGENCY_TRANSFER_YN_CNT "+" ,nvl(MAINTAIN_DEATH_REGISTER_YN,'N') MAINTAIN_DEATH_REGISTER_YN, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  MAINTAIN_DEATH_REGISTER_YN ='Y')  MAINTAIN_DEATH_REGISTER_YN_CNT "+"  	from am_oper_stn  "+" where facility_id = ? and oper_stn_id=? ";
						
						
				//rset = stmt.executeQuery(sql);
				
				pstmt   = conn.prepareStatement(sql);
				pstmt.setString	(	1,	facilityId		);
				pstmt.setString	(	2,	oper_stn_id		);
				pstmt.setString	(	3,	facilityId		);
				pstmt.setString	(	4,	oper_stn_id		);
				pstmt.setString	(	5,	facilityId		);
				pstmt.setString	(	6,	oper_stn_id		);
				pstmt.setString	(	7,	facilityId		);
				pstmt.setString	(	8,	oper_stn_id		);
				pstmt.setString	(	9,	facilityId		);
				pstmt.setString	(	10,	oper_stn_id		);
				pstmt.setString	(	11,	facilityId		);
				pstmt.setString	(	12,	oper_stn_id		);
				pstmt.setString	(	13,	facilityId		);
				pstmt.setString	(	14,	oper_stn_id		);
				pstmt.setString	(	15,	facilityId		);
				pstmt.setString	(	16,	oper_stn_id		);
				pstmt.setString	(	17,	facilityId		);
				pstmt.setString	(	18,	oper_stn_id		);
				pstmt.setString	(	19,	facilityId		);
				pstmt.setString	(	20,	oper_stn_id		);
				pstmt.setString	(	21,	facilityId		);
				pstmt.setString	(	22,	oper_stn_id		);
				pstmt.setString	(	23,	facilityId		);
				pstmt.setString	(	24,	oper_stn_id		);
				pstmt.setString	(	25,	facilityId		);
				pstmt.setString	(	26,	oper_stn_id		);
				pstmt.setString	(	27,	facilityId		);
				pstmt.setString	(	28,	oper_stn_id		);
				pstmt.setString	(	29,	facilityId		);
				pstmt.setString	(	30,	oper_stn_id		);
				pstmt.setString	(	31,	facilityId		);
				pstmt.setString	(	32,	oper_stn_id		);
				pstmt.setString	(	33,	facilityId		);
				pstmt.setString	(	34,	oper_stn_id		);
				pstmt.setString	(	35,	facilityId		);
				pstmt.setString	(	36,	oper_stn_id		);
				pstmt.setString	(	37,	facilityId		);
				pstmt.setString	(	38,	oper_stn_id		);
				pstmt.setString	(	39,	facilityId		);
				pstmt.setString	(	40,	oper_stn_id		);
				pstmt.setString	(	41,	facilityId		);
				pstmt.setString	(	42,	oper_stn_id		);
				pstmt.setString	(	43,	facilityId		);
				pstmt.setString	(	44,	oper_stn_id		);
				pstmt.setString	(	45,	facilityId		);
				pstmt.setString	(	46,	oper_stn_id		);
				pstmt.setString	(	47,	facilityId		);
				pstmt.setString	(	48,	oper_stn_id		);
				pstmt.setString	(	49,	facilityId		);
				pstmt.setString	(	50,	oper_stn_id		);
				pstmt.setString	(	51,	facilityId		);
				pstmt.setString	(	52,	oper_stn_id		);
				pstmt.setString	(	53,	facilityId		);
				pstmt.setString	(	54,	oper_stn_id		);
				pstmt.setString	(	55,	facilityId		);
				pstmt.setString	(	56,	oper_stn_id		);
				pstmt.setString	(	57,	facilityId		);
				pstmt.setString	(	58,	oper_stn_id		);
				pstmt.setString	(	59,	facilityId		);
				pstmt.setString	(	60,	oper_stn_id		);
				pstmt.setString	(	61,	facilityId		);
				pstmt.setString	(	62,	oper_stn_id		);
				pstmt.setString	(	63,	facilityId		);
				pstmt.setString	(	64,	oper_stn_id		);
				pstmt.setString	(	65,	facilityId		);
				pstmt.setString	(	66,	oper_stn_id		);
				pstmt.setString	(	67,	facilityId		);
				pstmt.setString	(	68,	oper_stn_id		);
				pstmt.setString	(	69,	facilityId		);
				pstmt.setString	(	70,	oper_stn_id		);
				pstmt.setString	(	71,	facilityId		);
				pstmt.setString	(	72,	oper_stn_id		);
				pstmt.setString	(	73,	facilityId		);
				pstmt.setString	(	74,	oper_stn_id		);
				pstmt.setString	(	75,	facilityId		);
				pstmt.setString	(	76,	oper_stn_id		);
				pstmt.setString	(	77,	facilityId		);
				pstmt.setString	(	78,	oper_stn_id		);
				pstmt.setString	(	79,	facilityId		);
				pstmt.setString	(	80,	oper_stn_id		);
				pstmt.setString	(	81,	facilityId		);
				pstmt.setString	(	82,	oper_stn_id		);
				pstmt.setString	(	83,	facilityId		);
				pstmt.setString	(	84,	oper_stn_id		);
				pstmt.setString	(	85,	facilityId		);
				pstmt.setString	(	86,	oper_stn_id		);
				pstmt.setString	(	87,	facilityId		);
				pstmt.setString	(	88,	oper_stn_id		);
				pstmt.setString	(	89,	facilityId		);
				pstmt.setString	(	90,	oper_stn_id		);
				pstmt.setString	(	91,	facilityId		);
				pstmt.setString	(	92,	oper_stn_id		);
				pstmt.setString	(	93,	facilityId		);
				pstmt.setString	(	94,	oper_stn_id		);
				pstmt.setString	(	95,	facilityId		);
				pstmt.setString	(	96,	oper_stn_id		);
				pstmt.setString	(	97,	facilityId		);
				pstmt.setString	(	98,	oper_stn_id		);
				pstmt.setString	(	99,	facilityId		);
				pstmt.setString	(	100,	oper_stn_id		);
				pstmt.setString	(	101,	facilityId		);
				pstmt.setString	(	102,	oper_stn_id		);
				pstmt.setString	(	103,	facilityId		);
				pstmt.setString	(	104,	oper_stn_id		);
				pstmt.setString	(	105,	facilityId		);
				pstmt.setString	(	106,	oper_stn_id		);
				pstmt.setString	(	107,	facilityId		);
				pstmt.setString	(	108,	oper_stn_id		);
				pstmt.setString	(	109,	facilityId		);
				pstmt.setString	(	110,	oper_stn_id		);
				pstmt.setString	(	111,	facilityId		);
				pstmt.setString	(	112,	oper_stn_id		);
				pstmt.setString	(	113,	facilityId		);
				pstmt.setString	(	114,	oper_stn_id		);
				pstmt.setString	(	115,	facilityId		);
				pstmt.setString	(	116,	oper_stn_id		);
				pstmt.setString	(	117,	facilityId		);
				pstmt.setString	(	118,	oper_stn_id		);
				pstmt.setString	(	119,	facilityId		);
				pstmt.setString	(	120,	oper_stn_id		);
				pstmt.setString	(	121,	facilityId		);
				pstmt.setString	(	122,	oper_stn_id		);
				pstmt.setString	(	123,	facilityId		);
				pstmt.setString	(	124,	oper_stn_id		);
				pstmt.setString	(	125,	facilityId		);
				pstmt.setString	(	126,	oper_stn_id		);
				pstmt.setString	(	127,	facilityId		);
				pstmt.setString	(	128,	oper_stn_id		);
				pstmt.setString	(	129,	facilityId		);
				pstmt.setString	(	130,	oper_stn_id		);
				pstmt.setString	(	131,	facilityId		);
				pstmt.setString	(	132,	oper_stn_id		);
				pstmt.setString	(	133,	facilityId		);
				pstmt.setString	(	134,	oper_stn_id		);
				pstmt.setString	(	135,	facilityId		);
				pstmt.setString	(	136,	oper_stn_id		);
				pstmt.setString	(	137,	facilityId		);
				pstmt.setString	(	138,	oper_stn_id		);
				rset		 = pstmt.executeQuery();
				

				if(rset !=null && rset.next())
				{
					recordexists = "Y";
					//operationtype = "modify";
					eff_status = rset.getString("eff_status");				
					
				}
				
		}
%>	
<form name='opstn_detail_form' id='opstn_detail_form' action='../../servlet/eAM.OperatorStationServlet' method='post' target='messageFrame'>

<a name= 'outpat_act_tab_vw' id= 'outpat_act_tab_vw' >

<table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='0' width='100%' align='center'>
<tr>
<%if(recordexists.equals("Y")) { %>

<input type='hidden' name='book_appt_yn_cnt' id='book_appt_yn_cnt' value='<%=rset.getString("book_appt_yn_cnt")%>'>

<input type='hidden' name='create_wait_list_yn_cnt' id='create_wait_list_yn_cnt' value='<%=rset.getString("create_wait_list_yn_cnt")%>'>

<input type='hidden' name='modify_wait_list_yn_cnt' id='modify_wait_list_yn_cnt' value='<%=rset.getString("modify_wait_list_yn_cnt")%>'>

<input type='hidden' name='cancel_wait_list_yn_cnt' id='cancel_wait_list_yn_cnt' value='<%=rset.getString("cancel_wait_list_yn_cnt")%>'>



<input type='hidden' name='book_appt_wo_pid_yn_cnt' id='book_appt_wo_pid_yn_cnt' value='<%=rset.getString("book_appt_wo_pid_yn_cnt")%>'>
<input type='hidden' name='obook_appt_yn_cnt' id='obook_appt_yn_cnt' value='<%=rset.getString("obook_appt_yn_cnt")%>'>
<input type='hidden' name='book_appt_across_catg_yn_cnt' id='book_appt_across_catg_yn_cnt' value='<%=rset.getString("book_appt_across_catg_yn_cnt")%>'>
<input type='hidden' name='tfr_appt_yn_cnt' id='tfr_appt_yn_cnt' value='<%=rset.getString("tfr_appt_yn_cnt")%>'>
<input type='hidden' name='tfr_appt_across_catg_yn_cnt' id='tfr_appt_across_catg_yn_cnt' value='<%=rset.getString("tfr_appt_across_catg_yn_cnt")%>'>
<input type='hidden' name='canc_appt_yn_cnt' id='canc_appt_yn_cnt' value='<%=rset.getString("canc_appt_yn_cnt")%>'>
<input type='hidden' name='register_visit_yn_cnt' id='register_visit_yn_cnt' value='<%=rset.getString("register_visit_yn_cnt")%>'>
<input type='hidden' name='register_pat_yn_cnt' id='register_pat_yn_cnt' value='<%=rset.getString("register_pat_yn_cnt")%>'>
<input type='hidden' name='cancel_visit_yn_cnt' id='cancel_visit_yn_cnt' value='<%=rset.getString("cancel_visit_yn_cnt")%>'>
<input type='hidden' name='revise_visit_yn_cnt' id='revise_visit_yn_cnt' value='<%=rset.getString("revise_visit_yn_cnt")%>'>
<input type='hidden' name='manage_queue_yn_cnt' id='manage_queue_yn_cnt' value='<%=rset.getString("manage_queue_yn_cnt")%>'>
<input type='hidden' name='checkout_pat_yn_cnt' id='checkout_pat_yn_cnt' value='<%=rset.getString("checkout_pat_yn_cnt")%>'>
<input type='hidden' name='CANCEL_CHECKOUT_YN_CNT' id='CANCEL_CHECKOUT_YN_CNT' value='<%=rset.getString("CANCEL_CHECKOUT_YN_CNT")%>'>

<input type='hidden' name='create_booking_yn_cnt' id='create_booking_yn_cnt' value='<%=rset.getString("create_booking_yn_cnt")%>'>
<input type='hidden' name='revise_booking_yn_cnt' id='revise_booking_yn_cnt' value='<%=rset.getString("revise_booking_yn_cnt")%>'>
<input type='hidden' name='canc_booking_yn_cnt' id='canc_booking_yn_cnt' value='<%=rset.getString("canc_booking_yn_cnt")%>'>

<input type='hidden' name='ADMIT_PATIENT_WITH_BED_YN_CNT' id='ADMIT_PATIENT_WITH_BED_YN_CNT' value='<%=rset.getString("ADMIT_PATIENT_CNT")%>'>

<input type='hidden' name='CHG_NURS_UNIT_IN_ASSIGN_BED_YN_CNT' id='CHG_NURS_UNIT_IN_ASSIGN_BED_YN_CNT' value='<%=rset.getString("CHG_NURS_UNIT_IN_CNT")%>'> 

<input type='hidden' name='TRANSFER_OUT_PATIENT_YN_CNT' id='TRANSFER_OUT_PATIENT_YN_CNT' value='<%=rset.getString("TRANSFER_OUT_CNT")%>'>


<input type='hidden' name='SWAP_BED_YN_CNT' id='SWAP_BED_YN_CNT' value='<%=rset.getString("SWAP_CNT")%>'>
<input type='hidden' name='BA_CNT' id='BA_CNT' value='<%=rset.getString("BA_CNT")%>'>
<input type='hidden' name='BC_CNT' id='BC_CNT' value='<%=rset.getString("BC_CNT")%>'>

<input type='hidden' name='CRQ_YN_CNT' id='CRQ_YN_CNT' value='<%=rset.getString("CRQ_CNT")%>'>

<input type='hidden' name='CTO_YN_CNT' id='CTO_YN_CNT' value='<%=rset.getString("CTO_CNT")%>'>

<input type='hidden' name='CFQ_YN_CNT' id='CFQ_YN_CNT' value='<%=rset.getString("CFQ_CNT")%>'>

<input type='hidden' name='DADV_YN_CNT' id='DADV_YN_CNT' value='<%=rset.getString("DADV_CNT")%>'>

<input type='hidden' name='PTFR_YN_CNT' id='PTFR_YN_CNT' value= '<%=rset.getString("PTFR_CNT")%>'>
<!--
9/16/2008 hidden field for cancelreserve bed for operation restriction start

-->
<input type='hidden' name='CRB__YN_CNT' id='CRB__YN_CNT' value= '<%=rset.getString("CANCEL_RESERVE_BED_YN")%>'>
<!--
9/16/2008 hidden field for cancelreserve bed for operation restriction end

-->

<input type='hidden' name='TRANSFER_IN_PATIENT_YN_CNT' id='TRANSFER_IN_PATIENT_YN_CNT' value='<%=rset.getString("TRANSFER_IN_CNT")%>'>

<input type='hidden' name='FORCED_BOOK_APPT_YN_CNT' id='FORCED_BOOK_APPT_YN_CNT' value='<%=rset.getString("FORCED_BOOK_CNT")%>'>

<input type='hidden' name='GLOBAL_BOOK_APPT_YN_CNT' id='GLOBAL_BOOK_APPT_YN_CNT' value='<%=rset.getString("GLOBAL_BOOK_CNT")%>'>
<input type='hidden' name='GLOBAL_LOCN_APPT_YN_CNT' id='GLOBAL_LOCN_APPT_YN_CNT' value='<%=rset.getString("GLOBAL_LOCN_CNT")%>'>
<input type='hidden' name='CREATE_BOOKING_WITH_CONF_YN_CNT' id='CREATE_BOOKING_WITH_CONF_YN_CNT' value='<%=rset.getString("CR_B_WH_C_CNT")%>'>

<input type='hidden' name='CONFIRM_BOOKING_YN_CNT' id='CONFIRM_BOOKING_YN_CNT' value='<%=rset.getString("CON_CNT")%>'>


<input type='hidden' name='reject_admission_yn_cnt' id='reject_admission_yn_cnt' value='<%=rset.getString("reject_admission_yn_cnt")%>'>
<input type='hidden' name='admit_pat_yn_cnt' id='admit_pat_yn_cnt' value='<%=rset.getString("admit_pat_yn_cnt")%>'>
<input type='hidden' name='register_pat_in_admn_yn_cnt' id='register_pat_in_admn_yn_cnt' value='<%=rset.getString("register_pat_in_admn_yn_cnt")%>'>
<!--Below line Added for this CRF Bru-HIMS-CRF-261 -->
 <input type='hidden' name='quick_admission_yn_cnt' id='quick_admission_yn_cnt' value='<%=rset.getString("quick_admission_yn_cnt")%>'>

<input type='hidden' name='assign_bed_yn_cnt' id='assign_bed_yn_cnt' value='<%=rset.getString("assign_bed_yn_cnt")%>'>

<input type='hidden' name='assign_treat_pract_yn_cnt' id='assign_treat_pract_yn_cnt' value='<%=rset.getString("assign_treat_pract_yn_cnt")%>'>
<input type='hidden' name='revise_admission_yn_cnt' id='revise_admission_yn_cnt' value='<%=rset.getString("revise_admission_yn_cnt")%>'>
<input type='hidden' name='canc_admission_yn_cnt' id='canc_admission_yn_cnt' value='<%=rset.getString("canc_admission_yn_cnt")%>'>
<input type='hidden' name='emergency_tfr_yn_cnt' id='emergency_tfr_yn_cnt' value='<%=rset.getString("emergency_tfr_yn_cnt")%>'>
<input type='hidden' name='routine_tfr_yn_cnt' id='routine_tfr_yn_cnt' value='<%=rset.getString("routine_tfr_yn_cnt")%>'>
<input type='hidden' name='discharge_pat_yn_cnt' id='discharge_pat_yn_cnt' value='<%=rset.getString("discharge_pat_yn_cnt")%>'>
<input type='hidden' name='revise_leave_yn_cnt' id='revise_leave_yn_cnt' value='<%=rset.getString("revise_leave_yn_cnt")%>'>
<input type='hidden' name='check_lodger_yn_cnt' id='check_lodger_yn_cnt' value='<%=rset.getString("check_lodger_yn_cnt")%>'>
<input type='hidden' name='block_bed_yn_cnt' id='block_bed_yn_cnt' value='<%=rset.getString("block_bed_yn_cnt")%>'>
<input type='hidden' name='release_bed_yn_cnt' id='release_bed_yn_cnt' value='<%=rset.getString("release_bed_yn_cnt")%>'>
<input type='hidden' name='register_visit_walkin_yn_cnt' id='register_visit_walkin_yn_cnt' value='<%=rset.getString("register_visit_walkin_yn_cnt")%>'>
<input type='hidden' name='register_visit_referral_yn_cnt' id='register_visit_referral_yn_cnt' value='<%=rset.getString("register_visit_referral_yn_cnt")%>'>
<input type='hidden' name='link_baby_to_mother_yn_cnt' id='link_baby_to_mother_yn_cnt' value='<%=rset.getString("link_baby_to_mother_yn_cnt")%>'>
<input type='hidden' name='reg_newborn_for_ip_yn_cnt' id='reg_newborn_for_ip_yn_cnt' value='<%=rset.getString("reg_newborn_for_ip_yn_cnt")%>'>
<input type='hidden' name='discharge_checklist_yn_cnt' id='discharge_checklist_yn_cnt' value='<%=rset.getString("discharge_checklist_yn_cnt")%>'>
<input type='hidden' name='cancel_discharge_yn_cnt' id='cancel_discharge_yn_cnt' value='<%=rset.getString("CANCEL_DISCHARGE_YN_CNT")%>'>
<input type='hidden' name='reserve_bed_bay_yn_cnt' id='reserve_bed_bay_yn_cnt' value='<%=rset.getString("reserve_bed_bay_yn_cnt")%>'>
<input type='hidden' name='release_bed_bay_yn_cnt' id='release_bed_bay_yn_cnt' value='<%=rset.getString("release_bed_bay_yn_cnt")%>'>

<input type='hidden' name='dia_proc_recode_for_op_cnt' id='dia_proc_recode_for_op_cnt' value='<%=rset.getString("dia_proc_recode_for_op_cnt")%>'>

<input type='hidden' name='reg_ip_referral_yn_cnt' id='reg_ip_referral_yn_cnt' value='<%=rset.getString("reg_ip_referral_yn_cnt")%>'>
<input type='hidden' name='conf_bed_ref_yn_cnt' id='conf_bed_ref_yn_cnt' value='<%=rset.getString("conf_bed_ref_yn_cnt")%>'>
<input type='hidden' name='dia_proc_recode_for_ip_cnt' id='dia_proc_recode_for_ip_cnt' value='<%=rset.getString("dia_proc_recode_for_ip_cnt")%>'>

<input type='hidden' name='override_walkin_yn_cnt' id='override_walkin_yn_cnt' value='<%=rset.getString("override_walkin_yn_cnt")%>'>
<input type='hidden' name='emergency_transfer_cnt' id='emergency_transfer_cnt' value= '<%=rset.getString("EMERGENCY_TRANSFER_YN_CNT")%>'>
<input type='hidden' name='MAINTAIN_DEATH_REGISTER_YN_CNT' id='MAINTAIN_DEATH_REGISTER_YN_CNT' value= '<%=rset.getString("MAINTAIN_DEATH_REGISTER_YN_CNT")%>'>
<%
	
}
else
{
	
%>
<input type='hidden' name='CONFIRM_BOOKING_YN_CNT' id='CONFIRM_BOOKING_YN_CNT' value='0'>
<input type='hidden' name='book_appt_yn_cnt' id='book_appt_yn_cnt' value='0'>
<input type='hidden' name='book_appt_wo_pid_yn_cnt' id='book_appt_wo_pid_yn_cnt' value='0'>
<input type='hidden' name='obook_appt_yn_cnt' id='obook_appt_yn_cnt' value='0'>
<input type='hidden' name='book_appt_across_catg_yn_cnt' id='book_appt_across_catg_yn_cnt' value='0'>
<input type='hidden' name='tfr_appt_yn_cnt' id='tfr_appt_yn_cnt' value='0'>
<input type='hidden' name='tfr_appt_across_catg_yn_cnt' id='tfr_appt_across_catg_yn_cnt' value='0'>
<input type='hidden' name='canc_appt_yn_cnt' id='canc_appt_yn_cnt' value='0'>
<input type='hidden' name='register_visit_yn_cnt' id='register_visit_yn_cnt' value='0'>
<input type='hidden' name='register_pat_yn_cnt' id='register_pat_yn_cnt' value='0'>
<input type='hidden' name='cancel_visit_yn_cnt' id='cancel_visit_yn_cnt' value='0'>
<input type='hidden' name='revise_visit_yn_cnt' id='revise_visit_yn_cnt' value='0'>
<input type='hidden' name='manage_queue_yn_cnt' id='manage_queue_yn_cnt' value='0'>
<input type='hidden' name='checkout_pat_yn_cnt' id='checkout_pat_yn_cnt' value='0'>
<input type='hidden' name='CANCEL_CHECKOUT_YN_CNT' id='CANCEL_CHECKOUT_YN_CNT' value='0'>


<input type='hidden' name='create_booking_yn_cnt' id='create_booking_yn_cnt' value='0'>
<input type='hidden' name='revise_booking_yn_cnt' id='revise_booking_yn_cnt' value='0'>
<input type='hidden' name='canc_booking_yn_cnt' id='canc_booking_yn_cnt' value='0'>
<input type='hidden' name='reject_admission_yn_cnt' id='reject_admission_yn_cnt' value='0'>
<input type='hidden' name='admit_pat_yn_cnt' id='admit_pat_yn_cnt' value='0'>
<input type='hidden' name='register_pat_in_admn_yn_cnt' id='register_pat_in_admn_yn_cnt' value='0'>

<!--Below line Added for this CRF Bru-HIMS-CRF- 261-->
<input type='hidden' name='quick_admission_yn_cnt' id='quick_admission_yn_cnt' value='0'>

<input type='hidden' name='assign_bed_yn_cnt' id='assign_bed_yn_cnt' value='0'>
<input type='hidden' name='assign_treat_pract_yn_cnt' id='assign_treat_pract_yn_cnt' value='0'>
<input type='hidden' name='revise_admission_yn_cnt' id='revise_admission_yn_cnt' value='0'>
<input type='hidden' name='canc_admission_yn_cnt' id='canc_admission_yn_cnt' value='0'>
<input type='hidden' name='emergency_tfr_yn_cnt' id='emergency_tfr_yn_cnt' value='0'>
<input type='hidden' name='routine_tfr_yn_cnt' id='routine_tfr_yn_cnt' value='0'>
<input type='hidden' name='discharge_pat_yn_cnt' id='discharge_pat_yn_cnt' value=''>
<input type='hidden' name='revise_leave_yn_cnt' id='revise_leave_yn_cnt' value='0'>
<input type='hidden' name='check_lodger_yn_cnt' id='check_lodger_yn_cnt' value='0'>
<input type='hidden' name='block_bed_yn_cnt' id='block_bed_yn_cnt' value='0'>
<input type='hidden' name='release_bed_yn_cnt' id='release_bed_yn_cnt' value='0'>
<input type='hidden' name='register_visit_walkin_yn_cnt' id='register_visit_walkin_yn_cnt' value='0'>
<input type='hidden' name='register_visit_referral_yn_cnt' id='register_visit_referral_yn_cnt' value='0'>
<input type='hidden' name='create_wait_list_yn_cnt' id='create_wait_list_yn_cnt' value='0'>
<input type='hidden' name='modify_wait_list_yn_cnt' id='modify_wait_list_yn_cnt' value='0'>
<input type='hidden' name='cancel_wait_list_yn_cnt' id='cancel_wait_list_yn_cnt' value='0'>
<input type='hidden' name='FORCED_BOOK_APPT_YN_CNT' id='FORCED_BOOK_APPT_YN_CNT' value='0'>
<input type='hidden' name='GLOBAL_BOOK_APPT_YN_CNT' id='GLOBAL_BOOK_APPT_YN_CNT' value='0'>
<input type='hidden' name='GLOBAL_LOCN_APPT_YN_CNT' id='GLOBAL_LOCN_APPT_YN_CNT' value='0'>
<input type='hidden' name='TRANSFER_IN_PATIENT_YN_CNT' id='TRANSFER_IN_PATIENT_YN_CNT' value='0'>
<input type='hidden' name='TRANSFER_OUT_PATIENT_YN_CNT' id='TRANSFER_OUT_PATIENT_YN_CNT' value='0'>
<input type='hidden' name='SWAP_BED_YN_CNT' id='SWAP_BED_YN_CNT' value='0'>
<input type='hidden' name='CRQ_YN_CNT' id='CRQ_YN_CNT' value='0'>
<input type='hidden' name='BA_CNT' id='BA_CNT' value='0'>
<input type='hidden' name='BC_CNT' id='BC_CNT' value='0'>
<input type='hidden' name='CTO_YN_CNT' id='CTO_YN_CNT' value='0'>
<input type='hidden' name='ADMIT_PATIENT_WITH_BED_YN_CNT' id='ADMIT_PATIENT_WITH_BED_YN_CNT' value='0'>

<input type='hidden' name='CFQ_YN_CNT' id='CFQ_YN_CNT' value='0'>

<input type='hidden' name='DADV_YN_CNT' id='DADV_YN_CNT' value='0'>

<input type='hidden' name='PTFR_YN_CNT' id='PTFR_YN_CNT' value= '0'>
<!--9/16/2008 for CANCEL_RESERVE_BED_YN gives hidden field start
-->
<input type='hidden' name='CRB__YN_CNT' id='CRB__YN_CNT' value= '0'>
<!--9/16/2008 for CANCEL_RESERVE_BED_YN gives hidden field start
-->
<input type='hidden' name='link_baby_to_mother_yn_cnt' id='link_baby_to_mother_yn_cnt' value='0'>
<input type='hidden' name='reg_newborn_for_ip_yn_cnt' id='reg_newborn_for_ip_yn_cnt' value='0'>
<input type='hidden' name='discharge_checklist_yn_cnt' id='discharge_checklist_yn_cnt' value='0'>
<input type='hidden' name='cancel_discharge_yn_cnt' id='cancel_discharge_yn_cnt'value='0'>
<input type='hidden' name='reserve_bed_bay_yn_cnt' id='reserve_bed_bay_yn_cnt' value='0'>
<input type='hidden' name='release_bed_bay_yn_cnt' id='release_bed_bay_yn_cnt' value='0'>

<input type='hidden' name='dia_proc_recode_for_op_yn' id='dia_proc_recode_for_op_yn' value='0'>

<input type='hidden' name='reg_ip_referral_yn_cnt' id='reg_ip_referral_yn_cnt' value='0'>
<input type='hidden' name='conf_bed_ref_yn_cnt' id='conf_bed_ref_yn_cnt' value='0'>
<input type='hidden' name='dia_proc_recode_for_ip_yn' id='dia_proc_recode_for_ip_yn' value='0'>
<input type='hidden' name='override_walkin_yn_cnt' id='override_walkin_yn_cnt' value='0'>
<input type='hidden' name='emergency_transfer_cnt' id='emergency_transfer_cnt' value= '0'>
<input type='hidden' name='MAINTAIN_DEATH_REGISTER_YN_CNT' id='MAINTAIN_DEATH_REGISTER_YN_CNT' value= '0'>

<%	}
	%>
 </table>

<%if(!operstntype.equals("I")) {%>
<a name='appointment' id='appointment'>
 <table name='appt_tab_table' id='appt_tab_table' cellspacing='0' cellpadding='0' border='1' width='100%' align='center'>

<td class='columnheader'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
 
<tr>
<%if(recordexists.equals("Y")) { if(rset.getString("book_appt_yn").equals("Y")){ chk=" checked ";}else{ chk=""; book_appt_chk="disabled";}}%>
	
<TD class = 'QRYODD'  ><fmt:message key="Common.bookappointment.label" bundle="${common_labels}"/> </TD>		
<TD class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="book_appt_yn" id="book_appt_yn" <%=chk%> onclick='chkDetails(this);chk_others(this);' ></TD>

</tr>

<tr>


 <%if(recordexists.equals("Y")){ if(rset.getString("book_appt_wo_pid_yn").equals("Y")){ chk=" checked "; disabled="";}else{chk="";disabled=book_appt_chk;}
     }
     else{
     disabled="disabled";
	 }%> 
	
<TD class = 'QRYEVEN' ><fmt:message key="eAM.BookAppointmentwithoutPatientID.label" bundle="${am_labels}"/> </TD>		
<TD  class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="book_appt_wo_pid_yn" id="book_appt_wo_pid_yn"  <%=chk%> <%=disabled%> onclick='chkDetails(this);'></TD>

</tr>

<tr>
 <%if(recordexists.equals("Y")){ if(rset.getString("obook_appt_yn").equals("Y")){ chk=" checked "; disabled="";}else{chk="";disabled=book_appt_chk;}
     }
     else{
     disabled="disabled";
	 }%> 
	
	
<TD  class = 'QRYODD'><fmt:message key="eAM.OverbookAppointment.label" bundle="${am_labels}"/> </TD>		
<TD  class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="obook_appt_yn" id="obook_appt_yn"  <%=chk%> <%=disabled%> onclick='chkDetails(this);'></TD>
				
</tr>



<%if(recordexists.equals("Y")) { if(rset.getString("FORCED_BOOK_APPT_YN").equals("Y")) chk="checked"; else chk=""; }%>		

<TD class = 'QRYEVEN' > <fmt:message key="eAM.AllowForcedinAppointment.label" bundle="${am_labels}"/></TD>		
<TD  class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="FORCED_BOOK_APPT_YN" id="FORCED_BOOK_APPT_YN"  <%=chk%> <%=disabled%> onclick='chkDetails(this);' ></TD>
</tr>

<tr>
<%if(recordexists.equals("Y")) { if(rset.getString("GLOBAL_BOOK_APPT_YN").equals("Y")) chk=" checked "; else chk=""; }%>		
<TD class = 'QRYODD' >  <fmt:message key="eAM.AllowGlobalBooking.label" bundle="${am_labels}"/></TD>		
<TD  class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="GLOBAL_BOOK_APPT_YN" id="GLOBAL_BOOK_APPT_YN"  <%=chk%> <%=disabled%> onclick='chkDetails(this);'></TD>
</tr>

<tr>
<%if(recordexists.equals("Y")) { if(rset.getString("tfr_appt_yn").equals("Y")){ chk=" checked ";}else{chk="";  trans_appt_chk="disabled";} }%>

<TD class = 'QRYEVEN'><fmt:message key="Common.TransferAppointment.label" bundle="${common_labels}"/></TD>		
<TD class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="tfr_appt_yn" id="tfr_appt_yn"  <%=chk%> onclick='chkDetails(this);chk_others(this)';></TD>
</tr>



<tr>
<%if(recordexists.equals("Y")) { if(rset.getString("canc_appt_yn").equals("Y")) chk=" checked "; else chk=""; }%>		

<TD  class = 'QRYODD'><fmt:message key="Common.CancelAppointment.label" bundle="${common_labels}"/> </TD>		
<TD  class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="canc_appt_yn" id="canc_appt_yn" onclick='chkDetails(this);' <%=chk%>></TD>


</tr>

<tr>
 <%if(recordexists.equals("Y")) { if(rset.getString("create_wait_list_yn").equals("Y")) chk=" checked "; else chk=""; }%>
 
<TD  class = 'QRYEVEN'><fmt:message key="Common.CreateWaitList.label" bundle="${common_labels}"/></TD>		
<TD  class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="create_wait_list_yn" id="create_wait_list_yn" onclick='chkDetails(this);' <%=chk%>></TD>
</tr>

<tr>
<%if(recordexists.equals("Y")) { if(rset.getString("modify_wait_list_yn").equals("Y")) chk=" checked "; else chk=""; }%>
	
<TD  class = 'QRYODD'><fmt:message key="Common.ModifyWaitList.label" bundle="${common_labels}"/></TD>
<TD  class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="modify_wait_list_yn" id="modify_wait_list_yn" onclick='chkDetails(this);' <%=chk%>></TD>

</tr>

<tr>

 <%if(recordexists.equals("Y")) { if(rset.getString("cancel_wait_list_yn").equals("Y")) chk=" checked "; else chk=""; }%>
	
<TD  class = 'QRYEVEN'><fmt:message key="Common.CancelWaitList.label" bundle="${common_labels}"/></TD>
<TD  class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="cancel_wait_list_yn" id="cancel_wait_list_yn" onclick='chkDetails(this);' <%=chk%>></TD>

</tr>
<tr>
<%if(recordexists.equals("Y")) { if(rset.getString("BOOK_APPT_ACROSS_CATG_YN").equals("Y")) chk=" checked "; else chk=""; }%>		
<TD class = 'QRYODD' ><fmt:message key="eAM.OverrideAllocationRuleforBookAppointment.label" bundle="${am_labels}"/></TD>		
<TD  class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="BOOK_APPT_ACROSS_CATG_YN" id="BOOK_APPT_ACROSS_CATG_YN"  <%=chk%> onclick='chkDetails(this);'></TD>
</tr>


</table>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br>	

<a name='visit' id='visit'></a>

<table name='visit_tab_table' id='visit_tab_table' cellspacing='0' cellpadding='0' border='1' width='100%' align='center'>
 
<td class='columnheader' colspan='2'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>

<tr>
<%if(recordexists.equals("Y")) { if(rset.getString("register_visit_yn").equals("Y")) 			{chk=" checked "; }else{ chk=""; register_chk="disabled";}}%>

<TD class = 'QRYODD' colspan='2'><fmt:message key="Common.RegisterVisit.label" bundle="${common_labels}"/> </TD>		
<TD  class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="register_visit_yn" id="register_visit_yn"  <%=chk%> onclick='chkDetails(this);chk_others(this)';></TD>

</tr>

<tr>

<%if(recordexists.equals("Y")) { if(rset.getString("register_visit_walkin_yn").equals("Y")){ chk=" checked ";override_dis="";}else{ chk=""; disabled=register_chk;override_dis="disabled";}}%>


<TD class = 'QRYEVEN' colspan='2'><fmt:message key="eAM.RegisterWalkIn.label" bundle="${am_labels}"/></TD>		
<TD  class='QRYEVEN'><INPUT TYPE="checkbox" value="Y"   name="register_visit_walkin_yn" id="register_visit_walkin_yn"  <%=chk%> <%=disabled%> onclick='chkDetails(this);chk_others(this)'></TD>

</tr>


<tr>
<%if(recordexists.equals("Y")) { if(rset.getString("OVERRIDE_WALKIN_YN").equals("Y")){ chk=" checked ";} else{ chk=""; disabled=override_dis;}}%>
<td class='QRYODD' colspan='2'><fmt:message key="eOP.OverrideWalkIn.label" bundle="${op_labels}"/></td>
<TD class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="OVERRIDE_WALKIN_YN" id="OVERRIDE_WALKIN_YN"  <%=chk%> onclick='chkDetails(this);' <%=disabled%>></TD>
		
</tr>

<tr>

<%if(recordexists.equals("Y")) { if(rset.getString("register_visit_referral_yn").equals("Y")){ chk=" checked ";}else{ chk=""; disabled=register_chk;}}%>
		<TD class = 'QRYEVEN' colspan='2'><fmt:message key="eAM.RegisterReferral.label" bundle="${am_labels}"/></TD>		
		<TD class = 'QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="register_visit_referral_yn" id="register_visit_referral_yn"  <%=chk%> <%=disabled%> onclick='chkDetails(this);'></TD>
				
</tr>

<tr>

<%if(recordexists.equals("Y")) { if(rset.getString("register_pat_yn").equals("Y")){ chk=" checked ";}else{ chk=""; disabled=register_chk;}}%>

	<TD class = 'QRYODD'colspan='2' ><fmt:message key="eAM.RegisterPatientfromRegisterVisit.label" bundle="${am_labels}"/> </TD>		
	<TD  class='QRYODD' ><INPUT TYPE="checkbox" value="Y" name="register_pat_yn" id="register_pat_yn"  <%=chk%> <%=disabled%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

<%if(recordexists.equals("Y")) { if(rset.getString("manage_queue_yn").equals("Y")) chk=" checked "; else chk=""; }
		
		%>
<td  class='QRYEVEN' colspan='2'> <fmt:message key="Common.ManageQueue.label" bundle="${common_labels}"/></td>
	
<TD  class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="manage_queue_yn" id="manage_queue_yn"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>
<%if(recordexists.equals("Y")) { if(rset.getString("cancel_visit_yn").equals("Y")) chk=" checked "; else chk=""; }%>
		
<td   class='QRYODD' colspan='2'><fmt:message key="eAM.CancelVisit.label" bundle="${am_labels}"/></td>
<TD class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="cancel_visit_yn" id="cancel_visit_yn"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>
<%if(recordexists.equals("Y")) { if(rset.getString("revise_visit_yn").equals("Y")) chk=" checked "; else chk=""; }%>

<td  class='QRYEVEN' colspan='2'><fmt:message key="Common.ReviseVisit.label" bundle="${common_labels}"/></td>
<TD  class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="revise_visit_yn" id="revise_visit_yn"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

<%if(recordexists.equals("Y")) { if(rset.getString("checkout_pat_yn").equals("Y")) chk=" checked "; else chk=""; }%>

<td  class='QRYODD' colspan='2'><fmt:message key="eAM.CheckoutPatient.label" bundle="${am_labels}"/></td>

<TD  class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="checkout_pat_yn" id="checkout_pat_yn"  <%=chk%> onclick='chkDetails(this);' ></TD>

</tr>
<tr>

<%if(recordexists.equals("Y")) { if(rset.getString("CANCEL_CHECKOUT_YN").equals("Y")) chkCancel=" checked "; else chkCancel=""; }%>

<td  class='QRYEVEN' colspan='2'><fmt:message key="Common.CancelCheckout.label" bundle="${common_labels}"/></td>

<TD  class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="CANCEL_CHECKOUT_YN" id="CANCEL_CHECKOUT_YN"  <%=chkCancel%> onclick='cancelCheckout(this);chkDetails(this);' /></TD>

</tr>

<tr>
<%if(recordexists.equals("Y")) { if(rset.getString("RESERVE_BED_BAY_YN").equals("Y")) chk=" checked "; else chk=""; }%>

<TD class = 'QRYODD' colspan='2'><fmt:message key="eAM.ReserveBedBay.label" bundle="${am_labels}"/> </TD>		
<TD  class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="RESERVE_BED_BAY_YN" id="RESERVE_BED_BAY_YN" <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>
<%if(recordexists.equals("Y")) { if(rset.getString("RELEASE_BED_BAY_YN").equals("Y")) chk=" checked "; else chk=""; }%>

<td  class='QRYEVEN' colspan='2'><fmt:message key="eAM.ReleaseBedBay.label" bundle="${am_labels}"/> </td>
<TD  class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="RELEASE_BED_BAY_YN" id="RELEASE_BED_BAY_YN"  <%=chk%> onclick='chkDetails(this);'></TD>
		
</tr>


</TABLE>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br>

<a name='others1' id='others1'></a>

<table name='others_tab_table' id='others_tab_table' cellspacing='0' cellpadding='0' border='1' width='100%' align='center'>
 
<td class='columnheader' colspan='2'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
<tr>
<%if(recordexists.equals("Y")) { if(rset.getString("DIAG_PROC_RECODE_FOR_OP_YN").equals("Y")) chk=" checked "; else chk=""; }%>
<TD class = 'QRYEVEN'colspan='2'><fmt:message key="eMR.DiagnosisProcedureRecode.label" bundle="${mr_labels}"/></TD>
<TD class = 'QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="DIAG_PROC_RECODE_FOR_OP_YN" id="DIAG_PROC_RECODE_FOR_OP_YN"  <%=chk%> onclick='chkDetails(this);'></TD>
</tr>

</table>






<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>	
<%}%>


<a name='inpat_act_tab_vw' id='inpat_act_tab_vw'>


<a name='booking' id='booking' >

<table name='booking_tab_table' id='booking_tab_table' cellspacing='0' cellpadding='0' border='1' width='100%' align='center'>

<td class='columnheader'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
<tr>

<TD class = 'QRYEVEN' ><fmt:message key="Common.CreateBooking.label" bundle="${common_labels}"/></TD>		
	   
		<%if(recordexists.equals("Y")) { if(rset.getString("create_booking_yn").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class = 'QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="create_booking_yn" id="create_booking_yn"  <%=chk%>  onclick='chkDetails(this);disencfrm()'></TD>

</tr>

<tr>

<TD class = 'QRYODD'><fmt:message key="Common.revisebooking.label" bundle="${common_labels}"/></TD>		
		
<%if(recordexists.equals("Y")) { if(rset.getString("revise_booking_yn").equals("Y")) chk=" checked "; else chk=""; }%>

<TD class = 'QRYODD'><INPUT TYPE="checkbox" value="Y" name="revise_booking_yn" id="revise_booking_yn"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

<TD class = 'QRYEVEN'><fmt:message key="Common.CancelBooking.label" bundle="${common_labels}"/></TD>		
		<%if(recordexists.equals("Y")) { if(rset.getString("canc_booking_yn").equals("Y")) chk=" checked "; else chk=""; }%>
	
<TD class = 'QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="canc_booking_yn" id="canc_booking_yn"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

<TD class = 'QRYODD'><fmt:message key="Common.ConfirmBooking.label" bundle="${common_labels}"/></TD>		
		<%if(recordexists.equals("Y")) { if(rset.getString("CONFIRM_BOOKING").equals("Y")) chk=" checked "; else chk=""; }%>
		
<TD  class = 'QRYODD'><INPUT TYPE="checkbox" value="Y" name="CONFIRM_BOOKING_YN" id="CONFIRM_BOOKING_YN"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

<TD class = 'QRYEVEN' ><fmt:message key="eAM.ConfirmonCreatebooking.label" bundle="${am_labels}"/> </TD>
		<%if(recordexists.equals("Y")) { if(rset.getString("CR_B_WH_C_YN").equals("Y")) chk=" checked "; else chk=""; }%>
		<%if(recordexists.equals("Y")) { if(rset.getString("create_booking_yn").equals("Y")) dis=" disabled "; else dis=""; }%>               
		
<TD class = 'QRYEVEN' ><INPUT TYPE="checkbox" value="Y" name="CREATE_BOOKING_WITH_CONF_YN" id="CREATE_BOOKING_WITH_CONF_YN"  <%=chk%> <%=dis%> onclick='chkDetails(this);disencr();'></TD>	

</tr>
</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br>
<a name='transfer' id='transfer' >


<table name='transfer_tab_table' id='transfer_tab_table' cellspacing='0' cellpadding='0' border='1' width='100%' align='center'>

<td class='columnheader'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
<tr>

<TD class = 'QRYEVEN' ><fmt:message key="Common.TransferPatient.label" bundle="${common_labels}"/></TD>		
		<%if(recordexists.equals("Y")) { if(rset.getString("emergency_tfr_yn").equals("Y")) chk=" checked "; else chk=""; }%>

<TD class = 'QRYEVEN' ><INPUT TYPE="checkbox" value="Y" name="emergency_tfr_yn" id="emergency_tfr_yn"  <%=chk%> onclick='chkDetails(this);'></TD> 

</tr>

<tr>

<TD class = 'QRYODD' ><fmt:message key="Common.RequestforTransfer.label" bundle="${common_labels}"/></TD>	
		<%if(recordexists.equals("Y")) { if(rset.getString("routine_tfr_yn").equals("Y")) chk=" checked "; else chk=""; }%>

<TD class = 'QRYODD'><INPUT TYPE="checkbox" value="Y" name="routine_tfr_yn" id="routine_tfr_yn"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

<TD class = 'QRYEVEN' ><fmt:message key="Common.CancelRequest.label" bundle="${common_labels}"/></TD>		
	    <%if(recordexists.equals("Y")) { if(rset.getString("canc_req_yn").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class = 'QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="canc_req_yn" id="canc_req_yn"  <%=chk%> onclick='chkDetails(this);'></TD>


</tr>

<tr>

<TD class = 'QRYODD' ><fmt:message key="eAM.ConfirmRequest.label" bundle="${am_labels}"/></td>
		<%if(recordexists.equals("Y")) { if(rset.getString("cfrm_req_yn").equals("Y")) chk=" checked "; else chk=""; }%>
		
<TD class = 'QRYODD'><INPUT TYPE="checkbox" value="Y" name="cfrm_req_yn" id="cfrm_req_yn"   <%=chk%> onclick='chkDetails(this);'></TD>
</tr>

<tr>
<TD class = 'QRYEVEN' ><fmt:message key="Common.TransferOut.label" bundle="${common_labels}"/></td>	
		<%if(recordexists.equals("Y")) { if(rset.getString("TRANSFER_OUT_PATIENT_YN").equals("Y")) chk=" checked "; else chk=""; }%>
		
<TD class = 'QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="TRANSFER_OUT_PATIENT_YN" id="TRANSFER_OUT_PATIENT_YN"   <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>
<TD class = 'QRYODD'  width='auto' nowrap><fmt:message key="eAM.CancelTransferOut.label" bundle="${am_labels}"/></TD>		
	    <%if(recordexists.equals("Y")) { if(rset.getString("can_tfr_out_yn").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class = 'QRYODD'><INPUT TYPE="checkbox" value="Y" name="can_tfr_out_yn" id="can_tfr_out_yn"  <%=chk%> onclick='chkDetails(this);'></TD>


</tr>

<tr>
<TD class = 'QRYEVEN' ><fmt:message key="eAM.TransferIn.label" bundle="${am_labels}"/> </TD>		
	    <%if(recordexists.equals("Y")) { if(rset.getString("TRANSFER_IN_PATIENT_YN").equals("Y")) chk=" checked "; else chk=""; }%>               
		
<TD class = 'QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="TRANSFER_IN_PATIENT_YN" id="TRANSFER_IN_PATIENT_YN"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>
<TD class = 'QRYODD' ><fmt:message key="eAM.SwapBed.label" bundle="${am_labels}"/></TD>		
	    <%if(recordexists.equals("Y")) { if(rset.getString("SWAP_BED_YN").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class = 'QRYODD' ><INPUT TYPE="checkbox" value="Y" name="SWAP_BED_YN" id="SWAP_BED_YN"  <%=chk%> onclick='chkDetails(this);'></TD>
</tr>
<tr>
<TD class = 'QRYEVEN' ><fmt:message key="eIP.EmergencyTransfer.label" bundle="${ip_labels}"/></TD>		
	    <%if(recordexists.equals("Y")) { if(rset.getString("emergency_transfer").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD  class = 'QRYEVEN' ><INPUT TYPE="checkbox" value="Y" name="emergency_transfer_yn" id="emergency_transfer_yn"  <%=chk%> onclick='chkDetails(this);'></TD>
</tr>
<tr>
<TD class = 'QRYODD' ><fmt:message key="Common.PractitionerTransfer.label" bundle="${common_labels}"/></TD>		
	    <%if(recordexists.equals("Y")) { if(rset.getString("pract_tfr_yn").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD  class = 'QRYODD' ><INPUT TYPE="checkbox" value="Y" name="pract_tfr_yn" id="pract_tfr_yn"  <%=chk%> onclick='chkDetails(this);'></TD>
</tr>
<!--
New Row append for CancelReservBeds start 15 -sep-2008
-->
<tr>
<TD class = 'QRYEVEN' ><fmt:message key="Common.CancelReservBeds.label" bundle="${common_labels}"/></TD>		
	    <%if(recordexists.equals("Y")) { if(rset.getString("cancel_reserve_bed").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD  class = 'QRYEVEN' ><INPUT TYPE="checkbox" value="Y" name="cancel_reBeds_yn" id="cancel_reBeds_yn"  <%=chk%> onclick='chkDetails(this);'></TD>
</tr>
<!--
New Row append for CancelReservBeds end  15 -sep-2008
-->
</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<a name='admission' id='admission' >



<table name='admission_tab_table' id='admission_tab_table' cellspacing='0' cellpadding='0' border='1' width='100%' align='center'>

<td class='columnheader'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
<tr>

<TD class = 'QRYEVEN' ><fmt:message key="Common.AdmitPatient.label" bundle="${common_labels}"/></TD>		
	    <%if(recordexists.equals("Y")) { if(rset.getString("admit_pat_yn").equals("Y")) {chk=" checked ";}else{ chk=""; admit_chk="disabled";}} %>               
<TD class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="admit_pat_yn" id="admit_pat_yn"  <%=chk%> onclick='chkDetails(this);chngadmtassign();'></TD>

</tr>
<!--Below line Added for this CRF  Bru-HIMS-CRF-261-->
<tr>

<TD class = 'QRYEVEN' ><fmt:message key="eMP.QuickAdmission.label" bundle="${mp_labels}"/></TD>		
	    <%if(recordexists.equals("Y")) { if(rset.getString("quick_admission_yn").equals("Y")){chk=" checked "; disabled="";}else{chk="";disabled=admit_chk;}
     }
     else{
     disabled="disabled";
	 }%>               
<TD class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="quick_admission_yn" id="quick_admission_yn"  <%=chk%> <%=disabled%> onclick='chkDetails(this);' ></TD>

</tr>
<!--End this CRF Bru-HIMS-CRF-261 -->
<!--Below line modified for this CRF  Bru-HIMS-CRF-261-->
<tr>

<TD class = 'QRYODD'><fmt:message key="eAM.AdmitPatientwithBed.label" bundle="${am_labels}"/></TD>		
		<%if(recordexists.equals("Y")) { if(rset.getString("ADMIT_PATIENT_WITH_BED_YN").equals("Y")) {chk=" checked "; disabled="";}else{chk="";disabled=admit_chk;}
     }
     else{
     disabled="disabled";
	 }%>
<TD  class = 'QRYODD'><INPUT TYPE="checkbox" value="Y" name="ADMIT_PATIENT_WITH_BED_YN" id="ADMIT_PATIENT_WITH_BED_YN"  <%=chk%> <%=disabled%> onclick='chkDetails(this);'></TD>

</tr>
<!--End Bru-HIMS-CRF-261 -->
<tr>

<TD class = 'QRYEVEN' ><fmt:message key="eAM.RegisterPatientFromAdmitPatient.label" bundle="${am_labels}"/></TD>		
		<%if(recordexists.equals("Y")) { if(rset.getString("register_pat_in_admn_yn").equals("Y")) chk=" checked "; else chk=""; }%>
<TD class = 'QRYEVEN' ><INPUT TYPE="checkbox" value="Y" name="register_pat_in_admn_yn" id="register_pat_in_admn_yn"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

<TD class = 'QRYODD' ><fmt:message key="Common.AssignBed.label" bundle="${common_labels}"/></TD>		
		<%if(recordexists.equals("Y")) { if(rset.getString("assign_bed_yn").equals("Y")) chk=" checked "; else chk=""; }%>
<TD class = 'QRYODD'><INPUT TYPE="checkbox" value="Y" name="assign_bed_yn" id="assign_bed_yn"  <%=chk%> onclick='chkDetails(this);chngadmtassign();'></TD>

</tr>

<tr>

<td class = 'QRYEVEN' ><fmt:message key="eAM.AllowChangingNursingUnitinAssignBed.label" bundle="${am_labels}"/></TD>
		<%if(recordexists.equals("Y")) { if(rset.getString("CHG_NURS_UNIT_IN_ASSIGN_BED_YN").equals("Y"))
			chk=" checked "; else chk=""; }%>
<TD class = 'QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="CHG_NURS_UNIT_IN_ASSIGN_BED_YN" id="CHG_NURS_UNIT_IN_ASSIGN_BED_YN"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

 <TD class = 'QRYODD' ><fmt:message key="Common.AssignTreatingPractitioner.label" bundle="${common_labels}"/></TD>		
		<%if(recordexists.equals("Y")) { if(rset.getString("assign_treat_pract_yn").equals("Y")) chk=" checked "; else chk=""; }%>
<TD class = 'QRYODD'><INPUT TYPE="checkbox" value="Y" name="assign_treat_pract_yn" id="assign_treat_pract_yn"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

<TD class = 'QRYEVEN' ><fmt:message key="eAM.ChangeAdmDtls.label" bundle="${common_labels}"/></TD>		
	    <%if(recordexists.equals("Y")) { if(rset.getString("revise_admission_yn").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class = 'QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="revise_admission_yn" id="revise_admission_yn"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

<TD class = 'QRYODD' ><fmt:message key="Common.CancelAdmission.label" bundle="${common_labels}"/></TD>		
	    <%if(recordexists.equals("Y")) { if(rset.getString("canc_admission_yn").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class = 'QRYODD'><INPUT TYPE="checkbox" value="Y" name="canc_admission_yn" id="canc_admission_yn"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

 <TD class = 'QRYEVEN'  width='auto' nowrap><fmt:message key="eAM.BackdatedAdmission.label" bundle="${am_labels}"/></TD>		
	    <%if(recordexists.equals("Y")) { if(rset.getString("BACKDATED_ADMISSION_YN").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class = 'QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="BACKDATED_ADMISSION_YN" id="BACKDATED_ADMISSION_YN"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

 <TD class = 'QRYODD' ><fmt:message key="Common.LinkBabyToMother.label" bundle="${common_labels}"/></TD>		
		
	   <%if(recordexists.equals("Y")) { if(rset.getString("link_baby_to_mother_yn").equals("Y")) chk=" checked "; else chk=""; }%>      
	         
<TD  class = 'QRYODD'><INPUT TYPE="checkbox" value="Y" name="LINK_BABY_TO_MOTHER_YN" id="LINK_BABY_TO_MOTHER_YN" <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

 <TD class = 'QRYEVEN'><fmt:message key="eAM.RegisterNewbornforIP.label" bundle="${am_labels}"/></TD>		
	 <%if(recordexists.equals("Y")) { if(rset.getString("reg_newborn_for_ip_yn").equals("Y")) chk=" checked "; else chk=""; }%>    
           
<TD class = 'QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="REG_NEWBORN_FOR_IP_YN" id="REG_NEWBORN_FOR_IP_YN"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<a name='discharge' id='discharge'  >



<table name='discharge_tab_table' id='discharge_tab_table' cellspacing='0' cellpadding='0' border='1' width='100%' align='center'>

<td class='columnheader'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
<tr>
<TD class = 'QRYEVEN'><fmt:message key="Common.DischargeAdvice.label" bundle="${common_labels}"/></td>		
		
<%if(recordexists.equals("Y")) { if(rset.getString("dchrg_adv_yn").equals("Y")) chk=" checked "; else chk=""; }%>
		
<TD class = 'QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="dchrg_adv_yn" id="dchrg_adv_yn"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>
<TD class = 'QRYODD'  ><fmt:message key="Common.DischargePatient.label" bundle="${common_labels}"/></TD>	

<%if(recordexists.equals("Y")) { if(rset.getString("discharge_pat_yn").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="discharge_pat_yn" id="discharge_pat_yn"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>
<TD class = 'QRYEVEN' ><fmt:message key="eAM.BedClasschange.label" bundle="${am_labels}"/></TD>	

<%if(recordexists.equals("Y")) { if(rset.getString("BED_CLASS_CHANGE_YN").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="BED_CLASS_CHANGE_YN" id="BED_CLASS_CHANGE_YN"  <%=chk%> onclick='chkDetails(this);'></TD>
</tr>

<tr>
<TD class = 'QRYODD' ><fmt:message key="eAM.Dischargechecklist.label" bundle="${am_labels}"/></TD>		

<%if(recordexists.equals("Y")) { if(rset.getString("DISCHARGE_CHECKLIST_YN").equals("Y")) chk=" checked "; else chk=""; }%>
               
 <TD class='QRYODD' ><INPUT TYPE="checkbox" value="Y" name="DISCHARGE_CHECKLIST_YN" id="DISCHARGE_CHECKLIST_YN"  <%=chk%>
		 onclick='chkDetails(this);'></TD>
</tr>

<tr>
<TD class='QRYEVEN'  ><fmt:message key="Common.CancelDischarge.label" bundle="${common_labels}"/></TD>

<%	if(recordexists.equals("Y")) 
	{ 
		if(rset.getString("cancel_discharge_yn").equals("Y"))
			chk=" checked "; 
		else 
			chk=""; 
	}	%>

	<TD class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="CANCEL_DISCHARGE_YN" id="CANCEL_DISCHARGE_YN" <%=chk%> onClick='chkDetails(this);'></TD>

	</tr>
  </table>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<a name='others' id='others' >

<table name='others_tab_table' id='others_tab_table' cellspacing='0' cellpadding='0' border='1' width='100%' align='center'>

<td class='columnheader'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
<tr>
<TD class = 'QRYEVEN' ><fmt:message key="eIP.BlockBed.label" bundle="${ip_labels}"/></td>		
	    <%if(recordexists.equals("Y")) { if(rset.getString("block_bed_yn").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class = 'QRYEVEN' ><INPUT TYPE="checkbox" value="Y" name="block_bed_yn" id="block_bed_yn"  <%=chk%>  onclick='chkDetails(this);'></TD>

</tr>

<tr>

<TD class = 'QRYODD' ><fmt:message key="Common.ReleaseBed.label" bundle="${common_labels}"/></TD>		
		<%if(recordexists.equals("Y")) { if(rset.getString("release_bed_yn").equals("Y")) chk=" checked "; else chk=""; }%>
		
<TD class = 'QRYODD'><INPUT TYPE="checkbox" value="Y" name="release_bed_yn" id="release_bed_yn"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

<TD class = 'QRYEVEN' ><fmt:message key="eAM.RecordAmendLeave.label" bundle="${am_labels}"/></td>		
	    <%if(recordexists.equals("Y")) { if(rset.getString("revise_leave_yn").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class = 'QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="revise_leave_yn" id="revise_leave_yn"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

<TD class = 'QRYODD'><fmt:message key="eAM.CheckInCheckOutLodger.label" bundle="${am_labels}"/></td>		
	    <%if(recordexists.equals("Y")) { if(rset.getString("check_lodger_yn").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class = 'QRYODD'><INPUT TYPE="checkbox" value="Y" name="check_lodger_yn" id="check_lodger_yn"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

<TD class = 'QRYEVEN' ><fmt:message key="Common.RegisterInpatientReferral.label" bundle="${common_labels}"/></td>		
   <%if(recordexists.equals("Y")) { if(rset.getString("REG_IP_REFERRAL_YN").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class = 'QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="REG_IP_REFERRAL_YN" id="REG_IP_REFERRAL_YN"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

<TD class = 'QRYODD'><fmt:message key="Common.ConfirmBedsideReferral.label" bundle="${common_labels}"/></td>		

<%if(recordexists.equals("Y")) { if(rset.getString("CONFIRM_BEDSIDE_REFERRAL_YN").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class = 'QRYODD'><INPUT TYPE="checkbox" value="Y" name="CONFIRM_BEDSIDE_REFERRAL_YN" id="CONFIRM_BEDSIDE_REFERRAL_YN"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

<tr>

<TD class = 'QRYEVEN'><fmt:message key="eMR.DiagnosisProcedureRecode.label" bundle="${mr_labels}"/></td>		

 <%if(recordexists.equals("Y")) { if(rset.getString("DIAG_PROC_RECODE_FOR_IP_YN").equals("Y")) chk=" checked "; else chk=""; }%>              
<TD class = 'QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="DIAG_PROC_RECODE_FOR_IP_YN" id="DIAG_PROC_RECODE_FOR_IP_YN"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>
<tr>

<TD class = 'QRYODD'><fmt:message key="eMR.MaintainDeathRegister.label" bundle="${mr_labels}"/></td>		

 <%if(recordexists.equals("Y")) { if(rset.getString("MAINTAIN_DEATH_REGISTER_YN").equals("Y")) chk=" checked "; else chk=""; }%>

<TD class = 'QRYODD'><INPUT TYPE="checkbox" value="Y" name="MAINTAIN_DEATH_REGISTER_YN" id="MAINTAIN_DEATH_REGISTER_YN"  <%=chk%> onclick='chkDetails(this);'></TD>

</tr>

</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>





<%

}
   catch(Exception e){
	out.println(e);
	e.printStackTrace();
}
finally
{
	try
	{
	if (rset!= null) rset.close();
	if (stmt != null) stmt.close();
	if (rs != null) rs.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	ConnectionManager.returnConnection(conn,request);

}
%>

<input type='hidden' name='rule' id='rule' value=<%=rule%>>
<input type='hidden' name='function_name' id='function_name' value=''>
<input type='hidden' name='operstntype' id='operstntype' value=''>
<input type='hidden' name='short_desc' id='short_desc' value=''>
<input type='hidden' name='long_desc' id='long_desc' value=''>
<input type='hidden' name='oper_stn_id' id='oper_stn_id' value=''>
<input type='hidden' name='ws_no' id='ws_no' value=''>
<input type='hidden' name='eff_status' id='eff_status' value='<%=eff_status%>' >
<input type='hidden' name='facility_id' id='facility_id' value="<%=facilityId%>" >

<%
	if(eff_status.equals("D"))
	{
	out.println("<script>");
	out.println("for(j=0;j<document.forms[0].elements.length;j++) document.forms[0].elements[j].disabled=true;");
	out.println("</script>");
	
	}
%>

</form>
</body>
</html>

