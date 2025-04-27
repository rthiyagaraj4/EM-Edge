<!DOCTYPE html>
<%--
FileName	: addOperatorStationRstrnDetails.jsp
Version	    : 3	
Modified On	: 23-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");%>

<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js' ></script>
		
<script language="JavaScript">
 





//THE FOLLOWING CHECKING IS NOT NECESSARY
function chk_book(obj)
{
	if(obj.checked==true)
	{
	}else{
	}
}

function chk_transfer(obj){
if(obj.checked==true){
}else{
}
}
function chk_register(obj){
if(obj.checked==true){
}else{
}
}


function disencfrm()
{
	if(document.forms[0].create_booking_with_conf_yn_hdd.value == 'Y')
		document.forms[0].CREATE_BOOKING_WITH_CONF_YN.disabled = false;
	else
		document.forms[0].CREATE_BOOKING_WITH_CONF_YN.disabled = true;
}

function disencr()
{
	if(document.forms[0].create_booking_yn_hdd.value == 'Y')
		document.getElementById('create_booking_yn').disabled = false;
	else
		document.getElementById('create_booking_yn').disabled = true;
}



function codeArrestforScroll(e)
{
	//alert('Welcome to eHIS');
	alert(getMessage("WELCOME","Common"));
	return false;
}

function ckhValue(Obj)
{
	if(Obj.checked)
		Obj.value='Y'
	else
		Obj.value='N'
}

function chngadmtassign(obj)
{   /*Below line modified for this CRF Bru-HIMS-CRF-261*/
	if(obj.name == 'admit_pat_yn')
	{
		if(obj.checked == true)
		{
			if(document.forms[0].admit_patient_with_bed_yn_hdd)
			{
			if(document.forms[0].admit_patient_with_bed_yn_hdd.value == 'Y')
				document.forms[0].ADMIT_PATIENT_WITH_BED_YN.disabled = false;
			else
				document.forms[0].ADMIT_PATIENT_WITH_BED_YN.disabled = true;
			}
			if(document.forms[0].quick_admission_yn)
			document.forms[0].quick_admission_yn.disabled=false;  //this line Added for this CRF Bru-HIMS-CRF-261
		}
		else
		{
			if(document.forms[0].ADMIT_PATIENT_WITH_BED_YN)
			{
				document.forms[0].ADMIT_PATIENT_WITH_BED_YN.checked = false;
				document.forms[0].ADMIT_PATIENT_WITH_BED_YN.disabled = true;
			}
			 //this line Added for this CRF Bru-HIMS-CRF-261
			if(document.forms[0].quick_admission_yn){
			document.forms[0].quick_admission_yn.checked=false;
			document.forms[0].quick_admission_yn.disabled=true;
			}
			//End Bru-HIMS-CRF-261
		}
	}
	else if(obj.name == 'assign_bed_yn')
	{
		if(obj.checked == true)
		{
			if(document.forms[0].chg_nurs_unit_in_assign_bed_yn_hdd)
			{
			if(document.forms[0].chg_nurs_unit_in_assign_bed_yn_hdd.value == 'Y')
				document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.disabled = false;
			else
				document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.disabled = true;
			}
		}
		else
		{
			if(document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN)
			{
			document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.checked = false;
			document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.disabled = true;
			}
		}
	}
	else
	{
		if(document.forms[0].admit_pat_yn)
		{
		if(document.forms[0].admit_pat_yn.checked==true)
		{
			if(document.forms[0].admit_patient_with_bed_yn_hdd)
			{	
			if(document.forms[0].admit_patient_with_bed_yn_hdd.value == 'Y')
				document.forms[0].ADMIT_PATIENT_WITH_BED_YN.disabled = false;
			else
				document.forms[0].ADMIT_PATIENT_WITH_BED_YN.disabled = true;
			}

			if(document.forms[0].register_pat_in_admn_yn_hdd)
			{			
			if(document.forms[0].register_pat_in_admn_yn_hdd.value == 'Y')
				document.getElementById("register_pat_in_admn_yn").disabled = false; 
			else
				document.getElementById("register_pat_in_admn_yn").disabled = true; 
			}
		}
		}
		else
		{
			if(document.forms[0].ADMIT_PATIENT_WITH_BED_YN)
			{
				if(document.forms[0].ADMIT_PATIENT_WITH_BED_YN.checked==true)
			{
				document.forms[0].ADMIT_PATIENT_WITH_BED_YN.checked=false;
			}
			
			document.forms[0].ADMIT_PATIENT_WITH_BED_YN.disabled = true;
			}
			if(document.getElementById("register_pat_in_admn_yn"))
			{
				document.getElementById("register_pat_in_admn_yn").disabled = true;
			}
		}

	}
}

function chkUnchkValue(Obj)
{
	if(Obj.name == 'register_visit_yn')
	{
		if(Obj.checked == true)
		{
			if(document.forms[0].register_visit_walkin_yn_hdd.value == 'Y')
				document.forms[0].register_visit_walkin_yn.disabled = false;
			else
				document.forms[0].register_visit_walkin_yn.disabled = true;

			if(document.forms[0].register_visit_referral_yn_hdd.value == 'Y')
				document.forms[0].register_visit_referral_yn.disabled = false;
			else
				document.forms[0].register_visit_referral_yn.disabled = true;

			if(document.forms[0].register_pat_yn_hdd.value == 'Y')
				document.forms[0].register_pat_yn.disabled = false;
			else
				document.forms[0].register_pat_yn.disabled = true;

		}
		else
		{
			document.forms[0].register_visit_walkin_yn.checked   = false;
			document.forms[0].register_visit_referral_yn.checked = false;
			document.forms[0].register_pat_yn.checked			 = false;
			document.forms[0].register_visit_walkin_yn.disabled   = true;
			document.forms[0].register_visit_referral_yn.disabled = true;
			document.forms[0].register_pat_yn.disabled			  = true;
		}
	}

	if(Obj.name == 'register_visit_walkin_yn')
	{
		if(Obj.checked == true)
		{
			Obj.value='Y';
			if(document.forms[0].OVERRIDE_WALKIN_YN_HDD.value == 'Y')
				document.forms[0].OVERRIDE_WALKIN_YN.disabled = false;
			else
				document.forms[0].OVERRIDE_WALKIN_YN.disabled = true;	
		}
		else
		{
			Obj.value='N';
			document.forms[0].OVERRIDE_WALKIN_YN.checked   = false;			
			document.forms[0].OVERRIDE_WALKIN_YN.disabled  = true;			
		}
	}
}

</script>
</head>
<%
Connection con = null; 
ResultSet rset = null;
PreparedStatement pstmt = null;
PreparedStatement pstmt1 = null;
Statement stmt = null;
ResultSet rset1 = null;
Statement stmt1 = null;
String recordexists = "N";
String location_type = "";
String valueexits = "N";
String dis = "disabled";
String chk = "";
String bkwipd="";
String obappt="";     
String bkapptac="";
String tfrappt="";  
String regvis="";
String a1="";
String a2="";
String reg_dis = "";
String chkoutpatchk = "";
String cancelvisitchk = "";
String appluserid="";
ResultSet rschk = null;
Statement stchk = null;
String quick_admission_yn="";

	String mode = checkForNull(request.getParameter("mode"));
	if(mode.equals("update"))
	{
		location_type = request.getParameter("location_type")==null?"":request.getParameter("location_type"); 
	}
	else
	{
		location_type = request.getParameter("locationtype")==null?"":request.getParameter("locationtype"); 
	}

	String facilityID = request.getParameter("facility_id");
		if(facilityID == null) facilityID="";
	String operationtype = request.getParameter("operationtype");
		if(operationtype == null ) operationtype ="insert";


try
{
	con = ConnectionManager.getConnection(request);
	String operstntype = request.getParameter("oper_stn_type")==null?"B":request.getParameter("oper_stn_type");
	String operstnid = request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
	 appluserid = request.getParameter("user")==null?"":request.getParameter("user");
	//String locncode = request.getParameter("location_type")==null?"":request.getParameter("location_type"); 
	//String user =request.getParameter("appluserid1") == null?"":request.getParameter("appluserid1");
	String locationid=request.getParameter("locncode1") == null?"":request.getParameter("locncode1");

		stmt = con.createStatement();
		stmt1 = con.createStatement();

		StringBuffer stringBuffer = new StringBuffer("");
		
		/*Below line Modified for this CRF Bru-HIMS-CRF-261*/

		stringBuffer.append(" SELECT facility_id, oper_stn_id, long_desc, short_desc, nurs_unit_code, ");
		stringBuffer.append(" shift_operated_yn, shift_group, ws_no, eff_status, ");
		stringBuffer.append(" NVL (book_appt_yn, 'N') book_appt_yn, ");
		stringBuffer.append(" NVL (book_appt_wo_pid_yn, 'N') book_appt_wo_pid_yn,");
		stringBuffer.append(" NVL (obook_appt_yn, 'N') obook_appt_yn,");
		stringBuffer.append(" NVL (forced_book_appt_yn, 'N') forced_book_appt_yn,");
		stringBuffer.append(" NVL (create_wait_list_yn, 'N') create_wait_list_yn,");
		stringBuffer.append(" NVL (modify_wait_list_yn, 'N') modify_wait_list_yn,");
		stringBuffer.append(" NVL (cancel_wait_list_yn, 'N') cancel_wait_list_yn,");
		stringBuffer.append(" NVL (cancel_checkout_yn, 'N') cancel_checkout_yn,");
		//16-sep-2008 CANCEL_RESERVE_BED_YN has
		stringBuffer.append(" NVL (CANCEL_RESERVE_BED_YN, 'N') CANCEL_RESERVE_BED_YN,");
		stringBuffer.append(" NVL (create_booking_with_conf_yn, 'N') create_booking_with_conf_yn,");
		stringBuffer.append(" NVL (global_book_appt_yn, 'N') global_book_appt_yn,");
		stringBuffer.append(" NVL (transfer_out_patient_yn, 'N') transfer_out_patient_yn,");
		stringBuffer.append(" NVL (transfer_in_patient_yn, 'N') transfer_in_patient_yn,");		stringBuffer.append("NVL(chg_nurs_unit_in_assign_bed_yn,'N')chg_nurs_unit_in_assign_bed_yn,");
		stringBuffer.append(" NVL (admit_patient_with_bed_yn, 'N') admit_patient_with_bed_yn,");
		stringBuffer.append(" NVL (swap_bed_yn, 'N') swap_bed_yn,");
		stringBuffer.append(" NVL (backdated_admission_yn, 'N') backdated_admission_yn,");
		stringBuffer.append(" NVL (bed_class_change_yn, 'N') bed_class_change_yn,");
		stringBuffer.append(" NVL (confirm_request_yn, 'N') confirm_request_yn,");
		stringBuffer.append(" NVL (cancel_request_yn, 'N') cancel_request_yn,");
		stringBuffer.append(" NVL (cancel_transfer_out_yn, 'N') cancel_transfer_out_yn,");
		stringBuffer.append(" NVL (pract_transfer_yn, 'N') pract_transfer_yn,");
		stringBuffer.append(" NVL (discharge_advice_yn, 'N') discharge_advice_yn,");
		stringBuffer.append(" NVL (book_appt_across_catg_yn, 'N') book_appt_across_catg_yn,");
		stringBuffer.append(" NVL (tfr_appt_yn, 'N') tfr_appt_yn,");
		stringBuffer.append(" NVL (tfr_appt_across_catg_yn, 'N') tfr_appt_across_catg_yn,");
		stringBuffer.append(" NVL (canc_appt_yn, 'N') canc_appt_yn,");
		stringBuffer.append(" NVL (register_visit_yn, 'N') register_visit_yn,");
		stringBuffer.append(" NVL (register_pat_yn, 'N') register_pat_yn,");
		stringBuffer.append(" NVL (cancel_visit_yn, 'N') cancel_visit_yn,");
		stringBuffer.append(" NVL (revise_visit_yn, 'N') revise_visit_yn,");
		stringBuffer.append(" NVL (manage_queue_yn, 'N') manage_queue_yn,");
		stringBuffer.append(" NVL (checkout_pat_yn, 'N') checkout_pat_yn, oper_stn_type,");
		stringBuffer.append(" NVL (create_booking_yn, 'N') create_booking_yn,");
		stringBuffer.append(" NVL (revise_booking_yn, 'N') revise_booking_yn,");
		stringBuffer.append(" NVL (canc_booking_yn, 'N') canc_booking_yn,");
		stringBuffer.append(" NVL (confirm_booking_yn, 'N') confirm_booking_yn,");
		stringBuffer.append(" NVL (admit_pat_yn, 'N') admit_pat_yn,");
		stringBuffer.append(" NVL (register_pat_in_admn_yn, 'N') register_pat_in_admn_yn,");
		stringBuffer.append(" NVL (assign_bed_yn, 'N') assign_bed_yn,");
		stringBuffer.append(" NVL (assign_treat_pract_yn, 'N') assign_treat_pract_yn,");
		stringBuffer.append(" NVL (revise_admission_yn, 'N') revise_admission_yn,");
		stringBuffer.append(" NVL (canc_admission_yn, 'N') canc_admission_yn,");
		stringBuffer.append(" NVL (emergency_tfr_yn, 'N') emergency_tfr_yn,");
		stringBuffer.append(" NVL (MAINTAIN_DEATH_REGISTER_YN, 'N') MAINTAIN_DEATH_REGISTER_YN,");
		stringBuffer.append(" NVL (routine_tfr_yn, 'N') routine_tfr_yn,");
		stringBuffer.append(" NVL (discharge_pat_yn, 'N') discharge_pat_yn,");
		stringBuffer.append(" NVL (revise_leave_yn, 'N') revise_leave_yn,");
		stringBuffer.append(" NVL (check_lodger_yn, 'N') check_lodger_yn,");
		stringBuffer.append(" NVL (block_bed_yn, 'N') block_bed_yn,");
		stringBuffer.append(" NVL (release_bed_yn, 'N') release_bed_yn,");
		stringBuffer.append(" NVL (register_visit_walkin_yn, 'N') register_visit_walkin_yn,");
		stringBuffer.append(" NVL (register_visit_referral_yn, 'N') register_visit_referral_yn ,");
		stringBuffer.append(" NVL (LINK_BABY_TO_MOTHER_YN, 'N') LINK_BABY_TO_MOTHER_YN,");
		stringBuffer.append(" NVL (REG_NEWBORN_FOR_IP_YN, 'N') REG_NEWBORN_FOR_IP_YN,");
		stringBuffer.append(" NVL (DISCHARGE_CHECKLIST_YN, 'N') DISCHARGE_CHECKLIST_YN,");
		stringBuffer.append(" NVL (RESERVE_BED_BAY_YN, 'N') RESERVE_BED_BAY_YN,");
		stringBuffer.append(" NVL (RELEASE_BED_BAY_YN, 'N') RELEASE_BED_BAY_YN, ");
		stringBuffer.append(" NVL (REG_IP_REFERRAL_YN, 'N') REG_IP_REFERRAL_YN,");
		stringBuffer.append(" NVL (CONFIRM_BEDSIDE_REFERRAL_YN, 'N') CONFIRM_BEDSIDE_REFERRAL_YN, ");
		stringBuffer.append(" NVL (CANCEL_DISCHARGE_YN, 'N') CANCEL_DISCHARGE_YN , NVL (OVERRIDE_WALKIN_YN, 'N') OVERRIDE_WALKIN_YN, NVL (DIAG_PROC_RECODE_FOR_IP_YN, 'N') DIAG_PROC_RECODE_FOR_IP_YN, NVL (DIAG_PROC_RECODE_FOR_OP_YN, 'N') DIAG_PROC_RECODE_FOR_OP_YN  ");
		stringBuffer.append(" ,NVL (emergency_transfer_yn, 'N') emergency_transfer_yn,nvl(quick_admission_yn,'N') quick_admission_yn");
		stringBuffer.append(" FROM AM_OPER_STN ");
		stringBuffer.append(" WHERE oper_stn_id =? AND facility_id =?");
		//rset = stmt.executeQuery(stringBuffer.toString());
		
		
		pstmt   = con.prepareStatement(stringBuffer.toString());
		pstmt.setString	(	1,	operstnid		);
		pstmt.setString	(	2,	facilityID		);
		rset		 = pstmt.executeQuery();

		if(rset !=null && rset.next())
		{
			bkwipd	= rset.getString("book_appt_wo_pid_yn");
			obappt	= rset.getString("obook_appt_yn");       
			bkapptac= rset.getString("book_appt_across_catg_yn");
			tfrappt	= rset.getString("tfr_appt_across_catg_yn");
			regvis	= rset.getString("register_pat_yn");
			quick_admission_yn	= rset.getString("quick_admission_yn");

			recordexists = "Y";
		}

		String sql1 ="select facility_id ,nvl(book_appt_yn,'N') book_appt_yn  ,nvl(book_appt_wo_pid_yn,'N') book_appt_wo_pid_yn,nvl(obook_appt_yn,'N') obook_appt_yn,nvl(book_appt_across_catg_yn ,'N') book_appt_across_catg_yn ,nvl(tfr_appt_yn,'N') tfr_appt_yn,nvl(tfr_appt_across_catg_yn,'N') tfr_appt_across_catg_yn,nvl(canc_appt_yn,'N') canc_appt_yn,nvl(FORCED_BOOK_APPT_YN,'N') FORCED_BOOK_APPT_YN, nvl(GLOBAL_BOOK_APPT_YN,'N') GLOBAL_BOOK_APPT_YN, nvl(create_wait_list_yn,'N') create_wait_list_yn, nvl(modify_wait_list_yn,'N') modify_wait_list_yn, nvl(cancel_wait_list_yn,'N') cancel_wait_list_yn,nvl(cancel_checkout_yn,'N') cancel_checkout_yn,nvl(CANCEL_RESERVE_BED_YN,'N') CANCEL_RESERVE_BED_YN,nvl(LINK_BABY_TO_MOTHER_YN,'N') LINK_BABY_TO_MOTHER_YN, nvl(REG_NEWBORN_FOR_IP_YN,'N') REG_NEWBORN_FOR_IP_YN,nvl(DISCHARGE_CHECKLIST_YN,'N') DISCHARGE_CHECKLIST_YN,nvl(RESERVE_BED_BAY_YN,'N') RESERVE_BED_BAY_YN,nvl(RELEASE_BED_BAY_YN,'N') RELEASE_BED_BAY_YN,nvl(REG_IP_REFERRAL_YN,'N') REG_IP_REFERRAL_YN,nvl(CONFIRM_BEDSIDE_REFERRAL_YN,'N') CONFIRM_BEDSIDE_REFERRAL_YN,nvl(CREATE_BOOKING_WITH_CONF_YN,'N') CREATE_BOOKING_WITH_CONF_YN, nvl(TRANSFER_OUT_PATIENT_YN,'N') TRANSFER_OUT_PATIENT_YN, nvl(TRANSFER_IN_PATIENT_YN,'N')   TRANSFER_IN_PATIENT_YN , nvl(CHG_NURS_UNIT_IN_ASSIGN_BED_YN,'N') CHG_NURS_UNIT_IN_ASSIGN_BED_YN, nvl(ADMIT_PATIENT_WITH_BED_YN,'N') ADMIT_PATIENT_WITH_BED_YN, nvl(SWAP_BED_YN,'N') SWAP_BED_YN,nvl(BACKDATED_ADMISSION_YN,'N') BACKDATED_ADMISSION_YN,nvl(BED_CLASS_CHANGE_YN,'N') BED_CLASS_CHANGE_YN,nvl(CONFIRM_REQUEST_YN,'N') CONFIRM_REQUEST_YN,nvl(CANCEL_REQUEST_YN,'N') CANCEL_REQUEST_YN,nvl(CANCEL_TRANSFER_OUT_YN,'N') CANCEL_TRANSFER_OUT_YN,nvl(PRACT_TRANSFER_YN,'N') PRACT_TRANSFER_YN,nvl(DISCHARGE_ADVICE_YN,'N') DISCHARGE_ADVICE_YN, nvl(register_visit_yn ,'N') register_visit_yn ,nvl(register_pat_yn,'N') register_pat_yn,nvl(cancel_visit_yn,'N') cancel_visit_yn,nvl(revise_visit_yn,'N') revise_visit_yn,nvl(manage_queue_yn ,'N') manage_queue_yn ,nvl(checkout_pat_yn,'N') checkout_pat_yn,nvl(create_booking_yn,'N') create_booking_yn,nvl(revise_booking_yn ,'N') revise_booking_yn ,nvl(canc_booking_yn,'N') canc_booking_yn,nvl(CONFIRM_BOOKING_YN,'N') CONFIRM_BOOKING_YN,nvl(admit_pat_yn,'N') admit_pat_yn,nvl(register_pat_in_admn_yn,'N') register_pat_in_admn_yn,nvl(assign_bed_yn ,'N') assign_bed_yn  ,nvl(assign_treat_pract_yn,'N') assign_treat_pract_yn,nvl(revise_admission_yn,'N') revise_admission_yn,nvl(canc_admission_yn,'N') canc_admission_yn,nvl(emergency_tfr_yn,'N') emergency_tfr_yn,nvl(MAINTAIN_DEATH_REGISTER_YN,'N') MAINTAIN_DEATH_REGISTER_YN,nvl(routine_tfr_yn ,'N') routine_tfr_yn  ,nvl(discharge_pat_yn,'N') discharge_pat_yn,nvl(revise_leave_yn,'N') revise_leave_yn,nvl(check_lodger_yn,'N')  check_lodger_yn, nvl(block_bed_yn,'N') block_bed_yn,  nvl(release_bed_yn,'N') release_bed_yn,NVL (register_visit_walkin_yn, 'N') register_visit_walkin_yn, NVL (register_visit_referral_yn, 'N') register_visit_referral_yn ,NVL (LINK_BABY_TO_MOTHER_YN, 'N') LINK_BABY_TO_MOTHER_YN,NVL (REG_NEWBORN_FOR_IP_YN, 'N') REG_NEWBORN_FOR_IP_YN, NVL (DISCHARGE_CHECKLIST_YN, 'N') DISCHARGE_CHECKLIST_YN, NVL(RESERVE_BED_BAY_YN, 'N') RESERVE_BED_BAY_YN,NVL (RELEASE_BED_BAY_YN, 'N') RELEASE_BED_BAY_YN, NVL (REG_IP_REFERRAL_YN, 'N') REG_IP_REFERRAL_YN, NVL (CONFIRM_BEDSIDE_REFERRAL_YN, 'N') CONFIRM_BEDSIDE_REFERRAL_YN ,added_by_id,added_date,added_at_ws_no,added_facility_id ,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id ,nvl(register_visit_walkin_yn,'N') register_visit_walkin_yn ,nvl(register_visit_referral_yn,'N') register_visit_referral_yn ,nvl(cancel_discharge_yn,'n') cancel_discharge_yn, nvl(OVERRIDE_WALKIN_YN,'n') OVERRIDE_WALKIN_YN, nvl(DIAG_PROC_RECODE_FOR_IP_YN,'n') DIAG_PROC_RECODE_FOR_IP_YN, nvl(DIAG_PROC_RECODE_FOR_OP_YN,'n') DIAG_PROC_RECODE_FOR_OP_YN,nvl(emergency_transfer_yn,'N') emergency_transfer_yn,nvl(quick_admission_yn,'N') quick_admission_yn from  AM_RESTRN_FOR_OPER_STN where oper_stn_id=? and facility_id=? and appl_user_id = ?  and locn_code = ? and LOCN_TYPE=?";	

		
		//rset1 = stmt1.executeQuery(sql1);
		pstmt1   = con.prepareStatement(sql1);
		pstmt1.setString	(	1,	operstnid		);
		pstmt1.setString	(	2,	facilityID		);
		pstmt1.setString	(	3,	appluserid		);
		pstmt1.setString	(	4,	locationid		);
		pstmt1.setString	(	5,	location_type		);
		rset1		 = pstmt1.executeQuery();


		if(rset1.next())
		{		
			a1=rset1.getString("FORCED_BOOK_APPT_YN");
			if(a1 .equals("Y"))
			{
				dis = "disabled = false";
				chk = "checked = true";
			}
		
			if((a1 .equals("N")) || (a1 .equals("")))
			{
				dis = "disabled = true";
				chk = "checked = false";
			}
			a2=rset1.getString("GLOBAL_BOOK_APPT_YN");
			if(a2 .equals("Y"))
			{
				dis = "disabled = false";
				chk = "checked = true";
			}
			
			if(a2 .equals("N"))
			{
				dis = "disabled = true";
				chk = "checked = false";
			}
	
			if(rset1.getString("checkout_pat_yn").equals("Y"))
				chkoutpatchk = "checked";
			if(rset1.getString("cancel_visit_yn").equals("Y"))
				cancelvisitchk = "checked";

			valueexits = "Y";

		}	%>

		
<script>
function chk_others(obj)
{
	if(obj.name=='book_appt_yn')
	{
		if(obj.checked==true)
		{
			if(document.forms[0].book_appt_wo_pid_yn_hdd)
			{
				if(document.forms[0].book_appt_wo_pid_yn_hdd.value == 'Y')
				document.forms[0].book_appt_wo_pid_yn.disabled = false;
			else
			if(document.forms[0].book_appt_wo_pid_yn)	
			document.forms[0].book_appt_wo_pid_yn.disabled = true;
			}
	
			if(document.forms[0].obook_appt_yn_hdd)
			{
				if(document.forms[0].obook_appt_yn_hdd.value == 'Y')
				document.forms[0].obook_appt_yn.disabled = false;
			else
			if(document.forms[0].obook_appt_yn)	
			document.forms[0].obook_appt_yn.disabled = true;
			}

			if(document.forms[0].book_appt_across_catg_yn_hdd)
			{
				if(document.forms[0].book_appt_across_catg_yn_hdd.value == 'Y')
				document.forms[0].book_appt_across_catg_yn.disabled = false;
			else
			if(document.forms[0].book_appt_across_catg_yn)	
			document.forms[0].book_appt_across_catg_yn.disabled = true;
			}

			if(document.forms[0].forced_book_appt_yn_hdd)
			{
				if(document.forms[0].forced_book_appt_yn_hdd.value == 'Y')
				document.forms[0].FORCED_BOOK_APPT_YN.disabled = false;
			else
				document.forms[0].FORCED_BOOK_APPT_YN.disabled = true;
			}

			if(document.forms[0].global_book_appt_yn_hdd)
			{
				if(document.forms[0].global_book_appt_yn_hdd.value == 'Y')
				document.forms[0].GLOBAL_BOOK_APPT_YN.disabled = false;
			else
			if(document.forms[0].GLOBAL_BOOK_APPT_YN)	
			document.forms[0].GLOBAL_BOOK_APPT_YN.disabled = true;
			}

		}
		else
		{
			if(document.forms[0].book_appt_wo_pid_yn)
				document.forms[0].book_appt_wo_pid_yn.checked=false;
			if(document.forms[0].book_appt_wo_pid_yn)
			document.forms[0].book_appt_wo_pid_yn.disabled=true;
			if(document.forms[0].FORCED_BOOK_APPT_YN)
			document.forms[0].FORCED_BOOK_APPT_YN.checked=false;
			if(document.forms[0].FORCED_BOOK_APPT_YN)
			document.forms[0].FORCED_BOOK_APPT_YN.disabled=true;
			if(document.forms[0].GLOBAL_BOOK_APPT_YN)
			document.forms[0].GLOBAL_BOOK_APPT_YN.checked=false;
			if(document.forms[0].GLOBAL_BOOK_APPT_YN)
			document.forms[0].GLOBAL_BOOK_APPT_YN.disabled=true;
			if(document.forms[0].obook_appt_yn)
			document.forms[0].obook_appt_yn.checked=false;
			if(document.forms[0].obook_appt_yn)
			document.forms[0].obook_appt_yn.disabled=true;
			if(document.forms[0].book_appt_across_catg_yn)
			document.forms[0].book_appt_across_catg_yn.checked=false;
			if(document.forms[0].book_appt_across_catg_yn)
			document.forms[0].book_appt_across_catg_yn.disabled=true; 

		}
	}
	else if(obj.name=='tfr_appt_yn')
	{
		if(obj.checked==true)
		{
			if(document.forms[0].tfr_appt_across_catg_yn_hdd)
			{
			if(document.forms[0].tfr_appt_across_catg_yn_hdd.value == 'Y')
				document.forms[0].tfr_appt_across_catg_yn.disabled = false;
			}
			else
			if(document.forms[0].tfr_appt_across_catg_yn)
			document.forms[0].tfr_appt_across_catg_yn.disabled = true;
		}
		else
		{
			if(document.forms[0].tfr_appt_across_catg_yn)
			{
			document.forms[0].tfr_appt_across_catg_yn.checked=false;
			document.forms[0].tfr_appt_across_catg_yn.disabled=true;
			}
		}
	} 
	else if(obj.name=='register_visit_yn')
	{
		if(obj.checked==true)
		{
			if(document.forms[0].regvis.value=='Y')
			{
				document.forms[0].register_pat_yn.disabled=false;
				document.forms[0].register_visit_walkin_yn.disabled=false;
				document.forms[0].register_visit_referral_yn.disabled=false;
			}
		}
		else
		{
			document.forms[0].register_pat_yn.checked=false;
			document.forms[0].register_pat_yn.disabled=true;
			document.forms[0].register_visit_walkin_yn.checked=false;
			document.forms[0].register_visit_walkin_yn.disabled=true;
			document.forms[0].register_visit_referral_yn.checked=false;
			document.forms[0].register_visit_referral_yn.disabled=true;
		}
	}
}
</script>

	<body  OnMouseDown="CodeArrest()" onSelect="codeArrestforScroll(this.event)" onKeyDown = 'lockKey()' onload="chngadmtassign('');" >
		<form name='opstn_detail_form' id='opstn_detail_form' action='../../servlet/eAM.OperatorStationRstrnServlet' method='post' target='messageFrame' >
		<%if (!location_type.equals("N"))
	{%>
		<a name='appointment' id='appointment'>

		<table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='1' width='100%' align='center'>
		
		
		<tr>

<td class='columnheader'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>

</tr>


<TR>
	<%if(recordexists.equals("Y") && rset.getString("book_appt_yn").equals("Y")) dis=""; else dis="disabled"; 
		
	if(valueexits.equals("Y") && rset1.getString("book_appt_yn").equals("Y")) chk="checked"; else 	chk=""; %>
			
	<TD class ='QRYEVEN'><fmt:message key="Common.bookappointment.label" bundle="${common_labels}"/> </TD>		
			
	<TD class ='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="book_appt_yn" id="book_appt_yn" <%=chk%>  <%=dis%> onclick='chk_others(this);' ></TD>

</tr>

<tr>
	<%if(recordexists.equals("Y") && rset.getString("book_appt_wo_pid_yn").equals("Y")) dis=""; else dis=" disabled "; %>
			
	<%if(valueexits.equals("Y")) { if(rset1.getString("book_appt_wo_pid_yn").equals("Y")) chk=" checked "; else chk=""; }%>
			
	<TD class='QRYODD'><fmt:message key="eAM.BookAppointmentwithoutPatientID.label" bundle="${am_labels}"/> </TD>		
		
	<TD class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="book_appt_wo_pid_yn" id="book_appt_wo_pid_yn"  <%=dis%> <%=chk%>  onclick='chk_book(this)'; ></TD>

</tr>

<tr>

	<%if(recordexists.equals("Y") && rset.getString("obook_appt_yn").equals("Y")) dis=""; else dis=" disabled "; %>
			
	<%if(valueexits.equals("Y")) { if(rset1.getString("obook_appt_yn").equals("Y")) chk=" checked "; else chk=""; }%>
			
	<TD class ='QRYEVEN' ><fmt:message key="eAM.OverbookAppointment.label" bundle="${am_labels}"/> </TD>		
			
	<TD class ='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="obook_appt_yn" id="obook_appt_yn"  <%=dis%> <%=chk%> onclick='chk_book(this)';></TD>
</tr>



<tr>

	<%if(recordexists.equals("Y")) { if(rset.getString("FORCED_BOOK_APPT_YN").equals("Y"))  dis=""; else dis=" disabled "; }
		
	if(valueexits.equals("Y")) { if(rset1.getString("FORCED_BOOK_APPT_YN").equals("Y")) chk=" checked "; else chk=""; } %>
			
	<TD class='QRYODD' ><fmt:message key="eAM.AllowForcedinAppointment.label" bundle="${am_labels}"/></TD>		
			
	<TD class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="FORCED_BOOK_APPT_YN" id="FORCED_BOOK_APPT_YN"  <%=dis%> <%=chk%> ></TD>

</tr>

<tr>

	<% if(recordexists.equals("Y")) {if(rset.getString("GLOBAL_BOOK_APPT_YN").equals("Y")) dis=""; else dis=" disabled "; }
			
	if(valueexits.equals("Y")) { if(rset1.getString("GLOBAL_BOOK_APPT_YN").equals("Y")) chk=" checked "; else chk=""; } 	%>	
			
	<TD class ='QRYEVEN' ><fmt:message key="eAM.AllowGlobalBooking.label" bundle="${am_labels}"/></TD>		
	
	<TD class ='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="GLOBAL_BOOK_APPT_YN" id="GLOBAL_BOOK_APPT_YN" <%=dis%> <%=chk%> ></TD>

</tr>

<tr>

	<% if(recordexists.equals("Y")) {if(rset.getString("BOOK_APPT_ACROSS_CATG_YN").equals("Y")) dis=""; else dis=" disabled "; }
			
	if(valueexits.equals("Y")) { if(rset1.getString("BOOK_APPT_ACROSS_CATG_YN").equals("Y")) chk=" checked "; else chk=""; } 	%>	
			
	<TD class ='QRYODD' >Override Allocation Rule For book appointment</TD>		
	
	<TD class ='QRYODD'><INPUT TYPE="checkbox" value="Y" name="book_appt_across_catg_yn" id="book_appt_across_catg_yn" <%=dis%> <%=chk%> ></TD>

</tr>

<tr>

	<%if(recordexists.equals("Y") && rset.getString("tfr_appt_yn").equals("Y")) dis=""; else dis=" disabled "; %>
			
	<%if(valueexits.equals("Y")) { if(rset1.getString("tfr_appt_yn").equals("Y")) chk=" checked "; else chk=""; }%>
			
	<TD class='QRYEVEN'><fmt:message key="Common.TransferAppointment.label" bundle="${common_labels}"/></TD>		
			
	<TD class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="tfr_appt_yn" id="tfr_appt_yn"  <%=chk%> <%=dis%> onclick='chk_others(this)';></TD>

</tr>


<tr>

	<%if(recordexists.equals("Y")) { if(rset.getString("canc_appt_yn").equals("Y")) dis=""; else dis=" disabled "; }%>
		
	<%if(valueexits.equals("Y")) { if(rset1.getString("canc_appt_yn").equals("Y")) chk=" checked "; else chk=""; }%>
			
	<TD class ='QRYODD' ><fmt:message key="Common.CancelAppointment.label" bundle="${common_labels}"/> </TD>		
			
	<TD class ='QRYODD'><INPUT TYPE="checkbox" value="Y" name="canc_appt_yn" id="canc_appt_yn"  <%=dis%> <%=chk%>></TD>

</tr>

<tr>

	<%if(recordexists.equals("Y")) { if(rset.getString("create_wait_list_yn").equals("Y")) dis=""; else dis=" disabled "; }%>
			
	<%if(valueexits.equals("Y")) { if(rset1.getString("create_wait_list_yn").equals("Y")) chk=" checked "; else chk=""; }%>
		
	<TD class='QRYEVEN'><fmt:message key="Common.CreateWaitList.label" bundle="${common_labels}"/></TD>		
			
	<TD class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="create_wait_list_yn" id="create_wait_list_yn"  <%=dis%> <%=chk%>></TD>

</tr>

<tr>

	<%if(recordexists.equals("Y")) { if(rset.getString("modify_wait_list_yn").equals("Y")) dis=""; else dis=" disabled "; }%>
			
	<%if(valueexits.equals("Y")) { if(rset1.getString("modify_wait_list_yn").equals("Y")) chk=" checked "; else chk=""; }%>
			
	<TD class ='QRYODD'><fmt:message key="Common.ModifyWaitList.label" bundle="${common_labels}"/></TD>
		
	<TD class ='QRYODD'><INPUT TYPE="checkbox" value="Y" name="modify_wait_list_yn" id="modify_wait_list_yn"  <%=dis%> <%=chk%>></TD>

</tr>

<tr>

	<%if(recordexists.equals("Y")) { if(rset.getString("cancel_wait_list_yn").equals("Y")) dis=""; else dis=" disabled "; }%>
			
	<%if(valueexits.equals("Y")) { if(rset1.getString("cancel_wait_list_yn").equals("Y")) chk=" checked "; else chk=""; }%>
			
	<TD class='QRYEVEN'><fmt:message key="Common.CancelWaitList.label" bundle="${common_labels}"/></TD>
			
	<TD class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="cancel_wait_list_yn" id="cancel_wait_list_yn"  <%=dis%> <%=chk%>></TD>

</tr>

</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<a name= 'visit' id= 'visit'>

<table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='1' width='100%' align='center'>

<tr>

<td class='columnheader' colspan='2'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>

</tr>

<tr>

	<%if(recordexists.equals("Y")) { if(rset.getString("register_visit_yn").equals("Y")) dis=""; else dis=" disabled "; }%>
			
	<%if(valueexits.equals("Y")){ if(rset1.getString("register_visit_yn").equals("Y")) {chk=" checked ";reg_dis = "";}else chk=""; }%>	
			
	<TD class ='QRYEVEN' colspan='2'><fmt:message key="Common.RegisterVisit.label" bundle="${common_labels}"/> </TD>		
			
	<TD class ='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="register_visit_yn" id="register_visit_yn"  onClick='chkUnchkValue(this);' <%=dis%> <%=chk%>></TD>

</tr>

<tr>

	<% if(recordexists.equals("Y") && rset.getString("register_visit_walkin_yn").equals("Y")) dis=""; else dis="disabled"; %>
	
	<%if(valueexits.equals("Y")) { if(rset1.getString("register_visit_walkin_yn").equals("Y")) chk=" checked "; else chk=""; }%>

	<TD class='QRYODD' width ='5%'>&nbsp;</TD>
			
	<TD class='QRYODD'><fmt:message key="eAM.RegisterWalkIn.label" bundle="${am_labels}"/></TD>		
			
	<TD class='QRYODD'><INPUT TYPE="checkbox" value="Y" onclick='chkUnchkValue(this);' name="register_visit_walkin_yn" id="register_visit_walkin_yn"  <%=dis%> <%=chk%> <%=reg_dis%> ></TD>


</tr>

<tr>

	<%
		if(valueexits.equals("Y")) 
		{ 
			if(rset1.getString("register_visit_walkin_yn").equals("Y"))
			{
				if(recordexists.equals("Y") && rset.getString("OVERRIDE_WALKIN_YN").equals("Y"))	
				{
					dis="";		
				}	
				else
				{					
					dis=" disabled "; 
				}
				if(valueexits.equals("Y") && rset1.getString("OVERRIDE_WALKIN_YN").equals("Y"))	
				{
					chk="checked";	
				}	
				else
				{
					chk="";
				}
			}
			else
			{
				dis=" disabled ";
				chk="";
			}

		}
	%>

	<TD class='QRYEVEN' width ='5%'>&nbsp;</TD>
			
	<TD class='QRYEVEN'><fmt:message key="eOP.OverrideWalkIn.label" bundle="${op_labels}"/></TD>		
	
	<TD class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="OVERRIDE_WALKIN_YN" id="OVERRIDE_WALKIN_YN" <%=dis%> <%=chk%> ></TD>

</tr>

<tr>

	<% if(recordexists.equals("Y") && rset.getString("register_visit_referral_yn").equals("Y")) dis=""; else dis="disabled"; %>
			
	<%if(valueexits.equals("Y")) { if(rset1.getString("register_visit_referral_yn").equals("Y")){ chk="CHECKED ";}else{ chk=""; }}%>

	<TD class='QRYODD' width ='5%'>&nbsp;</TD>
			
	<TD class ='QRYODD'><fmt:message key="eAM.RegisterReferral.label" bundle="${am_labels}"/> </TD>		
			
	<TD class ='QRYODD'><INPUT TYPE="checkbox" value="Y" onclick='ckhValue(this)' name="register_visit_referral_yn" id="register_visit_referral_yn" <%=dis%> <%=chk%> <%=reg_dis%> ></TD>

</tr>

<tr>

	<% if(recordexists.equals("Y") && rset.getString("register_pat_yn").equals("Y")) dis=""; else dis="disabled"; %>			
	<%if(valueexits.equals("Y")) { if(rset1.getString("register_pat_yn").equals("Y")) chk=" checked "; else chk=""; }%>

	<TD class='QRYEVEN' width ='5%'>&nbsp;</TD>
		
	<TD class='QRYEVEN'><fmt:message key="eAM.RegisterPatientfromRegisterVisit.label" bundle="${am_labels}"/> </TD>		
	
	<TD class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="register_pat_yn" id="register_pat_yn"  <%=reg_dis%> <%=chk%>  <%=dis%> onclick='chk_register(this)';></TD>

</tr>

<tr>

	<%if(recordexists.equals("Y")) { if(rset.getString("manage_queue_yn").equals("Y")) dis=""; else dis="disabled "; }%>
		
	<%if(valueexits.equals("Y")) { if(rset1.getString("manage_queue_yn").equals("Y")){ chk=" checked ";}else{ chk="";}}%>
					
	<TD class ='QRYODD' colspan='2'><fmt:message key="Common.ManageQueue.label" bundle="${common_labels}"/> </TD>	
	
	<TD class ='QRYODD'><INPUT TYPE="checkbox" value="Y" name="manage_queue_yn" id="manage_queue_yn"  <%=dis%> <%=chk%>></TD>

</tr>

<tr>

	<%if(recordexists.equals("Y")) { if(rset.getString("cancel_visit_yn").equals("Y")) dis=""; else dis=" disabled "; }%>
		
	<% if(valueexits.equals("Y") && rset1.getString("cancel_visit_yn").equals("Y")) chk="checked"; else chk=""; %>
			
	<TD class='QRYEVEN' colspan='2'><fmt:message key="eAM.CancelVisit.label" bundle="${am_labels}"/> </TD>		
			
	<TD class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="cancel_visit_yn" id="cancel_visit_yn"  <%=dis%> <%=cancelvisitchk%>></TD>

</tr>

<tr>

	<% if(recordexists.equals("Y") && rset.getString("revise_visit_yn").equals("Y")) dis=""; else dis="disabled"; %>
		
	<%if(valueexits.equals("Y")) { if(rset1.getString("revise_visit_yn").equals("Y")) chk=" checked "; else chk=""; }%>
		
	<TD class ='QRYODD' colspan='2'><fmt:message key="Common.ReviseVisit.label" bundle="${common_labels}"/> </TD>		
			
	<TD class ='QRYODD'><INPUT TYPE="checkbox" value="Y" name="revise_visit_yn" id="revise_visit_yn"  <%=dis%> <%=chk%>></TD>

</tr>

<tr>

	<%	if(recordexists.equals("Y")) { if(rset.getString("checkout_pat_yn").equals("Y"))	{		dis="";		}		else	dis=" disabled "; 	}	%>
		
	<% if(valueexits.equals("Y") && rset1.getString("checkout_pat_yn").equals("Y")) chk="checked"; else chk=""; %>
		
	<TD class='QRYEVEN' colspan='2'><fmt:message key="eAM.CheckoutPatient.label" bundle="${am_labels}"/> </TD>		
		
	<TD class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="checkout_pat_yn" id="checkout_pat_yn"  <%=dis%> <%=chkoutpatchk%>></TD>


</tr>
<tr>

<%if(valueexits.equals("Y")) { if(rset1.getString("cancel_checkout_yn").equals("Y")) chk=" checked "; else chk=""; }%>
			
	<TD class ='QRYODD' colspan='2'><fmt:message key="Common.CancelCheckout.label" bundle="${common_labels}"/></TD>
			
	<TD class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="cancel_checkout_yn" id="cancel_checkout_yn" <%=chk%> ></TD>

</tr>

<tr>

	<% if(recordexists.equals("Y") && rset.getString("RESERVE_BED_BAY_YN").equals("Y")) dis=""; else dis="disabled"; %>			
	<%if(valueexits.equals("Y")) { if(rset1.getString("RESERVE_BED_BAY_YN").equals("Y")) chk=" checked "; else chk=""; }%>
	
	<TD class ='QRYEVEN' colspan='2'><fmt:message key="eAM.ReserveBedBay.label" bundle="${am_labels}"/> </TD>		
			
	<TD class ='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="RESERVE_BED_BAY_YN" id="RESERVE_BED_BAY_YN" <%=reg_dis%> <%=chk%>  <%=dis%> ></TD>

</tr>

<tr>

	<%if(recordexists.equals("Y")) { if(rset.getString("RELEASE_BED_BAY_YN").equals("Y"))	{		dis="";		}		else	dis=" disabled "; 	}	%>
	
	<% if(valueexits.equals("Y") && rset1.getString("RELEASE_BED_BAY_YN").equals("Y")) chk="checked"; else chk=""; %>
			
	<TD class='QRYODD' colspan='2'><fmt:message key="eAM.ReleaseBedBay.label" bundle="${am_labels}"/></TD>		
	
	<TD class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="RELEASE_BED_BAY_YN" id="RELEASE_BED_BAY_YN" <%=dis%> <%=chk%> ></TD>

</tr>		
		</TABLE>
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		<br><br><br><br><br><br><br><br><br>
		<br><br><br>

		<a name= 'others' id= 'others'>

<table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='1' width='100%' align='center'>

<tr>
<td class='columnheader' colspan='2'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
</tr>

<tr>
   <% if(recordexists.equals("Y") && rset.getString("DIAG_PROC_RECODE_FOR_OP_YN").equals("Y")) dis=""; else dis="disabled"; %>
		
<%if(valueexits.equals("Y")) { if(rset1.getString("DIAG_PROC_RECODE_FOR_OP_YN").equals("Y")) chk=" checked "; else chk=""; }%>

    	
	<TD class ='QRYEVEN' colspan='2'><fmt:message key="eMR.DiagnosisProcedureRecode.label" bundle="${mr_labels}"/> </TD>	
	<TD class ='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="diag_proc_recode_for_op_yn" id="diag_proc_recode_for_op_yn" <%=dis%> <%=chk%> ></TD>

</tr>
<!-- <tr>
 

 <% if(recordexists.equals("Y") && rset.getString("MAINTAIN_DEATH_REGISTER_YN").equals("Y")) dis=""; else dis="disabled"; %>

 <%if(valueexits.equals("Y")) { if(rset1.getString("MAINTAIN_DEATH_REGISTER_YN").equals("Y")) chk=" checked "; else chk=""; }%>

<TD class = 'QRYEVEN' colspan='2'><fmt:message key="eMR.MaintainDeathRegister.label" bundle="${mr_labels}"/></TD>	
<TD class = 'QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="MAINTAIN_DEATH_REGISTER_YN" id="MAINTAIN_DEATH_REGISTER_YN"  <%=chk%> <%=dis%>></TD>

</tr> -->
</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<%}else {%>		
	

<a name='booking' id='booking' >

<table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='1' width='100%' align='center'>

<tr>

<td class='columnheader'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>

</tr>

<tr>

<%if(recordexists.equals("Y")) { if(rset.getString("create_booking_yn").equals("Y")) dis=""; else dis="disabled"; }%>               
<%if(valueexits.equals("Y")) { if(rset1.getString("create_booking_yn").equals("Y")) chk="checked"; else chk=""; }%>

<TD class ='QRYEVEN'><fmt:message key="Common.CreateBooking.label" bundle="${common_labels}"/></TD>		

<TD class ='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="create_booking_yn" id="create_booking_yn"  <%=dis%> <%=chk%> onclick="disencfrm()"></TD>

</tr>

<tr>

<%if(recordexists.equals("Y")) { if(rset.getString("revise_booking_yn").equals("Y")) dis=""; else dis=" disabled "; }%>
			
<%if(valueexits.equals("Y")) { if(rset1.getString("revise_booking_yn").equals("Y")) chk=" checked "; else chk=""; }%>

<TD class='QRYODD'><fmt:message key="Common.revisebooking.label" bundle="${common_labels}"/></TD>
			
<TD class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="revise_booking_yn" id="revise_booking_yn"  <%=dis%> <%=chk%>></TD>

</tr>

<tr>

<%if(recordexists.equals("Y")) { if(rset.getString("canc_booking_yn").equals("Y")) dis=""; else dis=" disabled "; }%>

<%if(valueexits.equals("Y")) { if(rset1.getString("canc_booking_yn").equals("Y")) chk=" checked "; else chk=""; }%>

<TD class ='QRYEVEN'><fmt:message key="Common.CancelBooking.label" bundle="${common_labels}"/></TD>
			
<TD class ='QRYEVEN'><INPUT TYPE="checkbox"  value="Y" name="canc_booking_yn" id="canc_booking_yn"  <%=dis%> <%=chk%> ></TD>

</tr>

<tr>

<TD class='QRYODD'><fmt:message key="Common.ConfirmBooking.label" bundle="${common_labels}"/></TD>		
		
<%if(recordexists.equals("Y")) { if(rset.getString("CONFIRM_BOOKING_YN").equals("Y")) dis=""; else dis= "disabled"; }%>
			
<%if(valueexits.equals("Y")) { if(rset1.getString("CONFIRM_BOOKING_YN").equals("Y")) chk=" checked "; else chk=""; }%>
			
<TD class='QRYODD'><INPUT TYPE="checkbox"  value="Y" name="CONFIRM_BOOKING_YN" id="CONFIRM_BOOKING_YN"   <%=chk%> <%=dis%>></TD>

</tr>

<tr>

<% if(recordexists.equals("Y") && rset.getString("CREATE_BOOKING_WITH_CONF_YN").equals("Y")) dis=""; else dis="disabled"; %>
		
<%if(valueexits.equals("Y")) { if(rset1.getString("CREATE_BOOKING_WITH_CONF_YN").equals("Y")) chk=" checked "; else chk=""; }%>

<TD class ='QRYEVEN'><fmt:message key="eAM.ConfirmonCreatebooking.label" bundle="${am_labels}"/></TD>	

<TD class ='QRYEVEN'><INPUT TYPE="checkbox"  value="Y" name="CREATE_BOOKING_WITH_CONF_YN" id="CREATE_BOOKING_WITH_CONF_YN"  <%=dis%> <%=chk%> onclick = "disencr();"></TD>

</tr>

</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<a name= 'admission' id= 'admission'>

<table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='1' width='100%' align='center'>

<tr>

<td class='columnheader'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>

</tr>

<tr>

<TD class ='QRYEVEN'><fmt:message key="Common.AdmitPatient.label" bundle="${common_labels}"/></TD>		

<%if(recordexists.equals("Y")) { if(rset.getString("admit_pat_yn").equals("Y")) dis=""; else dis=" disabled "; }%>               
<%if(valueexits.equals("Y")) { if(rset1.getString("admit_pat_yn").equals("Y")) chk=" checked "; else chk=""; }%>

<TD class ='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="admit_pat_yn" id="admit_pat_yn"  <%=dis%> <%=chk%>  onclick='chngadmtassign(this);'></TD>

</tr>

<!--Below line Added for this CRF  Bru-HIMS-CRF-261-->
<tr>
<TD class = 'QRYEVEN' ><fmt:message key="eMP.QuickAdmission.label" bundle="${mp_labels}"/></TD>		
  <%if(recordexists.equals("Y")) { if(rset.getString("quick_admission_yn").equals("Y"))dis=""; else dis=dis;}%> 

<%if(valueexits.equals("Y")) { if(rset1.getString("quick_admission_yn").equals("Y")) chk=" checked "; else chk=""; }%>            
<TD class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="quick_admission_yn" id="quick_admission_yn"  <%=dis%>  <%=chk%>  ></TD>
</tr>
<!--End this CRF Bru-HIMS-CRF-261 -->

<tr>

<TD class='QRYODD'><fmt:message key="eAM.AdmitPatientwithBed.label" bundle="${am_labels}"/></TD>	

<%if(recordexists.equals("Y")) { if(rset.getString("ADMIT_PATIENT_WITH_BED_YN").equals("Y")) dis=""; else dis=" disabled "; }%> 

<%if(valueexits.equals("Y")) { if(rset1.getString("ADMIT_PATIENT_WITH_BED_YN").equals("Y")) chk=" checked "; else chk=""; }%>
	
<TD class='QRYODD'><INPUT TYPE="checkbox" value="Y"  name="ADMIT_PATIENT_WITH_BED_YN" id="ADMIT_PATIENT_WITH_BED_YN"  <%=dis%> <%=chk%> ></TD>

</tr>

<tr>

<TD class ='QRYEVEN'><fmt:message key="eAM.RegisterPatientFromAdmitPatient.label" bundle="${am_labels}"/></TD>		
		
<%if(recordexists.equals("Y")) { if(rset.getString("register_pat_in_admn_yn").equals("Y")) dis=""; else dis=" disabled "; }%>               
<%if(valueexits.equals("Y")) { if(rset1.getString("register_pat_in_admn_yn").equals("Y")) chk=" checked "; else chk=""; }%>
			
<TD class ='QRYEVEN'><INPUT TYPE="checkbox"  value="Y" name="register_pat_in_admn_yn" id="register_pat_in_admn_yn"  <%=dis%> <%=chk%>></TD>

</tr>

<tr>

<TD class='QRYODD'><fmt:message key="Common.AssignBed.label" bundle="${common_labels}"/></TD>		

<%if(recordexists.equals("Y")) { if(rset.getString("assign_bed_yn").equals("Y")) dis=""; else dis=" disabled "; }%>

<%if(valueexits.equals("Y")) { if(rset1.getString("assign_bed_yn").equals("Y")) chk=" checked "; else chk=""; }%>
		
<TD class='QRYODD'><INPUT TYPE="checkbox"  value="Y" name="assign_bed_yn" id="assign_bed_yn"  <%=dis%> <%=chk%> onclick='chngadmtassign(this);'></TD>

</tr>

<tr>

<td class ='QRYEVEN'>	<fmt:message key="eAM.AllowChangingNursingUnitinAssignBed.label" bundle="${am_labels}"/></TD>
		
<% if(recordexists.equals("Y") && rset.getString("CHG_NURS_UNIT_IN_ASSIGN_BED_YN").equals("Y")) dis=""; else dis="disabled"; %>	

<%if(valueexits.equals("Y")) { if(rset1.getString("CHG_NURS_UNIT_IN_ASSIGN_BED_YN").equals("Y")) chk=" checked "; else chk=""; }%>
	
<TD class ='QRYEVEN'><INPUT TYPE="checkbox"  value="Y" name="CHG_NURS_UNIT_IN_ASSIGN_BED_YN" id="CHG_NURS_UNIT_IN_ASSIGN_BED_YN"  <%=dis%> <%=chk%>></TD>

</tr>

<tr>

<TD class='QRYODD'><fmt:message key="Common.AssignTreatingPractitioner.label" bundle="${common_labels}"/></TD>		
		
<%if(recordexists.equals("Y")) { if(rset.getString("assign_treat_pract_yn").equals("Y")) dis=""; else dis=" disabled "; }%>
		
<%if(valueexits.equals("Y")) { if(rset1.getString("assign_treat_pract_yn").equals("Y")) chk=" checked "; else chk=""; }%>
			
<TD class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="assign_treat_pract_yn" id="assign_treat_pract_yn"  <%=chk%> <%=dis%> ></TD>

</tr>


<tr>

<TD class='QRYEVEN'><fmt:message key="eAM.ChangeAdmDtls.label" bundle="${common_labels}"/></TD>		
		
<%if(recordexists.equals("Y")) { if(rset.getString("revise_admission_yn").equals("Y")) dis=""; else dis=" disabled "; }%>
		
<%if(valueexits.equals("Y")) { if(rset1.getString("revise_admission_yn").equals("Y")) chk=" checked "; else chk=""; }%>
			
<TD class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="revise_admission_yn" id="revise_admission_yn"  <%=chk%> <%=dis%> ></TD>

</tr>


<tr>

<TD class ='QRYODD'><fmt:message key="Common.CancelAdmission.label" bundle="${common_labels}"/></TD>		
		
<%if(recordexists.equals("Y")) { if(rset.getString("canc_admission_yn").equals("Y")) dis=""; else dis=" disabled "; }%>
			
<%if(valueexits.equals("Y")) { if(rset1.getString("canc_admission_yn").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class ='QRYODD'><INPUT TYPE="checkbox"  value="Y" name="canc_admission_yn" id="canc_admission_yn"  <%=chk%> <%=dis%>></TD>

</tr>

<tr>

<TD class='QRYEVEN'><fmt:message key="eAM.BackdatedAdmission.label" bundle="${am_labels}"/></TD>		
		
<%if(recordexists.equals("Y")) { if(rset.getString("BACKDATED_ADMISSION_YN").equals("Y")) dis=""; else dis=" disabled "; }%>               
<%if(valueexits.equals("Y")) { if(rset1.getString("BACKDATED_ADMISSION_YN").equals("Y")) chk=" checked "; else chk=""; }%>                
<TD class='QRYEVEN'><INPUT TYPE="checkbox"  value="Y" name="BACKDATED_ADMISSION_YN" id="BACKDATED_ADMISSION_YN"  <%=chk%> <%=dis%>></TD>

</tr>

<tr>

<TD class ='QRYODD'><fmt:message key="Common.LinkBabyToMother.label" bundle="${common_labels}"/></TD>	
		
<%if(recordexists.equals("Y")) { if(rset.getString("LINK_BABY_TO_MOTHER_YN").equals("Y")) dis=""; else dis=" disabled "; }%>               
<%if(valueexits.equals("Y")) { if(rset1.getString("LINK_BABY_TO_MOTHER_YN").equals("Y")) chk=" checked "; else chk=""; }%> 
		
<TD class ='QRYODD'><INPUT TYPE="checkbox"  value="Y" name="LINK_BABY_TO_MOTHER_YN" id="LINK_BABY_TO_MOTHER_YN" <%=chk%> <%=dis%> ></TD>

</tr>

<tr>

<TD class='QRYEVEN'><fmt:message key="eAM.RegisterNewbornforIP.label" bundle="${am_labels}"/></TD>
		
<%if(recordexists.equals("Y")) { if(rset.getString("REG_NEWBORN_FOR_IP_YN").equals("Y")) dis=""; else dis=" disabled "; }%>               
<%if(valueexits.equals("Y")) { if(rset1.getString("REG_NEWBORN_FOR_IP_YN").equals("Y")) chk=" checked "; else chk=""; }%>      
<TD class='QRYEVEN'><INPUT TYPE="checkbox"  value="Y" name="REG_NEWBORN_FOR_IP_YN" id="REG_NEWBORN_FOR_IP_YN" <%=chk%> <%=dis%> ></TD>

</tr>

</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<a name= 'transfer' id= 'transfer'>

<table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='1' width='100%' align='center'>

<tr>

<td class='columnheader'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>

</tr>

<tr>

<TD class ='QRYEVEN'><fmt:message key="Common.TransferPatient.label" bundle="${common_labels}"/></TD>	
		
<%if(recordexists.equals("Y")) { if(rset.getString("emergency_tfr_yn").equals("Y")) dis=""; else dis=" disabled "; }%>
		
<%if(valueexits.equals("Y")) { if(rset1.getString("emergency_tfr_yn").equals("Y")) chk=" checked "; else chk=""; }%>
			
<TD class ='QRYEVEN'><INPUT TYPE="checkbox"  value="Y" name="emergency_tfr_yn" id="emergency_tfr_yn" <%=dis%> <%=chk%> ></TD>

</tr>

<tr>

<TD class='QRYODD'><fmt:message key="Common.RequestforTransfer.label" bundle="${common_labels}"/></TD>	
			
<%if(recordexists.equals("Y")) { if(rset.getString("routine_tfr_yn").equals("Y")) dis=""; else dis=" disabled "; }%>
			
<%if(valueexits.equals("Y")) { if(rset1.getString("routine_tfr_yn").equals("Y")) chk=" checked "; else chk=""; }%>
			
<TD class='QRYODD'><INPUT TYPE="checkbox"  value="Y" name="routine_tfr_yn" id="routine_tfr_yn"  <%=chk%> <%=dis%> ></TD>

</tr>

<tr>

<TD class ='QRYEVEN'> <fmt:message key="Common.CancelRequest.label" bundle="${common_labels}"/></TD>	
			
<%if(recordexists.equals("Y")) { if(rset.getString("CANCEL_REQUEST_YN").equals("Y")) dis=""; else dis=" disabled "; }%>               
<%if(valueexits.equals("Y")) { if(rset1.getString("CANCEL_REQUEST_YN").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class ='QRYEVEN'><INPUT TYPE="checkbox"  value="Y" name="canc_req_yn" id="canc_req_yn"  <%=chk%> <%=dis%> ></TD>

</tr>

<tr>

<TD class='QRYODD'> <fmt:message key="eAM.ConfirmRequest.label" bundle="${am_labels}"/></td>
			
<%if(recordexists.equals("Y")) { if(rset.getString("CONFIRM_REQUEST_YN").equals("Y")) dis=""; else dis=" disabled "; }%>               
<%if(valueexits.equals("Y")) { if(rset1.getString("CONFIRM_REQUEST_YN").equals("Y")) chk=" checked "; else chk=""; }%>   
			
<TD class='QRYODD'><INPUT TYPE="checkbox"  value="Y" name="cfrm_req_yn" id="cfrm_req_yn"   <%=chk%> <%=dis%> ></TD>

</tr>

<tr>

<TD class ='QRYEVEN'><fmt:message key="Common.TransferOut.label" bundle="${common_labels}"/></td>	
		
<%if(recordexists.equals("Y") && rset.getString("TRANSFER_OUT_PATIENT_YN").equals("Y")) dis=""; else dis="disabled"; %>
			
<%if(valueexits.equals("Y")) { if(rset1.getString("TRANSFER_OUT_PATIENT_YN").equals("Y")) chk=" checked "; else chk=""; }%>
			
<TD class ='QRYEVEN'><INPUT TYPE="checkbox"  value="Y" name="TRANSFER_OUT_PATIENT_YN" id="TRANSFER_OUT_PATIENT_YN" <%=dis%> <%=chk%>></TD>

</tr>

<tr>

<TD class='QRYODD'><fmt:message key="eAM.CancelTransferOut.label" bundle="${am_labels}"/></TD>		
			
<%if(recordexists.equals("Y")) { if(rset.getString("CANCEL_TRANSFER_OUT_YN").equals("Y")) dis=""; else dis=" disabled "; }%>               
<%if(valueexits.equals("Y")) { if(rset1.getString("CANCEL_TRANSFER_OUT_YN").equals("Y")) chk=" checked "; else chk=""; }%>                
<TD class='QRYODD'><INPUT TYPE="checkbox"  value="Y" name="can_tfr_out_yn" id="can_tfr_out_yn"  <%=chk%>  <%=dis%> ></TD>

</tr>

<tr>

<TD class ='QRYEVEN'><fmt:message key="eAM.TransferIn.label" bundle="${am_labels}"/> </TD>		

<% if(recordexists.equals("Y") && rset.getString("TRANSFER_IN_PATIENT_YN").equals("Y")) dis=""; else dis="disabled"; %>
		
<%if(valueexits.equals("Y")) { if(rset1.getString("TRANSFER_IN_PATIENT_YN").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class ='QRYEVEN'><INPUT TYPE="checkbox"  value="Y" name="TRANSFER_IN_PATIENT_YN" id="TRANSFER_IN_PATIENT_YN"  <%=dis%> <%=chk%> ></TD>

</tr>

<tr>

<TD class='QRYODD'><fmt:message key="eAM.SwapBed.label" bundle="${am_labels}"/></TD>		
		
<% if(recordexists.equals("Y") && rset.getString("SWAP_BED_YN").equals("Y")) dis=""; else dis="disabled"; %>
			
<%if(valueexits.equals("Y")) { if(rset1.getString("SWAP_BED_YN").equals("Y")) chk=" checked "; else chk=""; }%>
			
<TD class='QRYODD'><INPUT TYPE="checkbox"  value="Y" name="SWAP_BED_YN" id="SWAP_BED_YN"   <%=chk%> <%=dis%> ></TD>

</tr>

<tr>
<%if(recordexists.equals("Y")) { if(rset.getString("emergency_transfer_yn").equals("Y")) dis=""; else dis=" disabled "; }%>

<%if(valueexits.equals("Y")) { if(rset1.getString("emergency_transfer_yn").equals("Y")) chk=" checked "; else chk=""; }%>

<TD class='QRYEVEN'><fmt:message key="eIP.EmergencyTransfer.label" bundle="${ip_labels}"/></TD>
			
	<TD class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="emergency_transfer_yn" id="emergency_transfer_yn"  <%=dis%> <%=chk%>></TD>
	</tr>

<tr>

<TD class ='QRYODD'><fmt:message key="Common.PractitionerTransfer.label" bundle="${common_labels}"/></TD>		
		
<%if(recordexists.equals("Y")) { if(rset.getString("PRACT_TRANSFER_YN").equals("Y")) dis=""; else dis=" disabled "; }%>               
<%if(valueexits.equals("Y")) { if(rset1.getString("PRACT_TRANSFER_YN").equals("Y")) chk=" checked "; else chk=""; }%>                
<TD class ='QRYODD'><INPUT TYPE="checkbox"  value="Y" name="pract_tfr_yn" id="pract_tfr_yn"  <%=chk%> <%=dis%> ></TD>

</tr>

<!--
Cancel ReserveBed function append start
-->
<tr>
<%if(recordexists.equals("Y")) { if(rset.getString("CANCEL_RESERVE_BED_YN").equals("Y")) dis=""; else dis=" disabled "; }%>

<%if(valueexits.equals("Y")) { if(rset1.getString("CANCEL_RESERVE_BED_YN").equals("Y")) chk=" checked "; else chk=""; }%>

<TD class='QRYEVEN'><fmt:message key="Common.CancelReservBeds.label" bundle="${common_labels}"/></TD>
			
	<TD class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="CANCEL_RESERVE_BED_YN" id="CANCEL_RESERVE_BED_YN"  <%=dis%> <%=chk%>></TD>
	</tr>
<!--
Cancel ReserveBed function append End
-->

</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>


<a name= 'discharge' id= 'discharge'>

<table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='1' width='100%' align='center'>


<tr>

<td class='columnheader'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>

</tr>

<tr>

<TD class ='QRYEVEN'><fmt:message key="Common.DischargeAdvice.label" bundle="${common_labels}"/></td>		
		
<% if(recordexists.equals("Y") && rset.getString("DISCHARGE_ADVICE_YN").equals("Y")) dis=""; else dis="disabled"; %>
			
<%if(valueexits.equals("Y")) { if(rset1.getString("DISCHARGE_ADVICE_YN").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class ='QRYEVEN'><INPUT TYPE="checkbox"  value="Y" name="dchrg_adv_yn" id="dchrg_adv_yn"  <%=chk%> <%=dis%>></TD>

</tr>

<tr>

<TD class='QRYODD'><fmt:message key="Common.DischargePatient.label" bundle="${common_labels}"/></TD>	

<%if(recordexists.equals("Y")) { if(rset.getString("discharge_pat_yn").equals("Y")) dis=""; else dis=" disabled "; }%>
			
<%if(valueexits.equals("Y")) { if(rset1.getString("discharge_pat_yn").equals("Y")) chk=" checked "; else chk=""; }%>        
			
<TD class='QRYODD'><INPUT TYPE="checkbox"  value="Y" name="discharge_pat_yn" id="discharge_pat_yn"  <%=dis%> <%=chk%> ></TD>

</tr>

<tr>

<TD class ='QRYEVEN'><fmt:message key="eAM.BedClasschange.label" bundle="${am_labels}"/></TD>		
			
<%if(recordexists.equals("Y")) { if(rset.getString("BED_CLASS_CHANGE_YN").equals("Y")) dis=""; else dis=" disabled "; }%>
			
<%if(valueexits.equals("Y")) { if(rset1.getString("BED_CLASS_CHANGE_YN").equals("Y")) chk=" checked "; else chk=""; }%>
			
<TD class ='QRYEVEN'><INPUT TYPE="checkbox"  value="Y" name="BED_CLASS_CHANGE_YN" id="BED_CLASS_CHANGE_YN"  <%=chk%> <%=dis%>></TD>

</tr>

<tr>

<TD class='QRYODD'><fmt:message key="eAM.Dischargechecklist.label" bundle="${am_labels}"/></TD>		

<%
		
if(recordexists.equals("Y")) { if(rset.getString("DISCHARGE_CHECKLIST_YN").equals("Y")) dis=""; else dis=" disabled "; }%>
			
<%if(valueexits.equals("Y")) { if(rset1.getString("DISCHARGE_CHECKLIST_YN").equals("Y")) chk=" checked "; else chk=""; }%>
			
<TD class='QRYODD'><INPUT TYPE="checkbox"  value="Y" name="DISCHARGE_CHECKLIST_YN" id="DISCHARGE_CHECKLIST_YN" <%=chk%> <%=dis%> ></TD>

</tr>

<tr>

<TD class='QRYEVEN'><fmt:message key="Common.CancelDischarge.label"
bundle="${common_labels}"/></TD>	

<%

if(recordexists.equals("Y")) { if(rset.getString("CANCEL_DISCHARGE_YN").equals("Y")) dis=""; else dis=" disabled "; }%>
			
<%if(valueexits.equals("Y")) { if(rset1.getString("cancel_discharge_yn").equals("Y")) chk=" checked "; else chk=""; }%>
			
<TD class='QRYEVEN'><INPUT TYPE="checkbox"  value="Y" name="cancel_discharge_yn" id="cancel_discharge_yn" <%=chk%> <%=dis%> ></TD>

</tr>


</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>


<a name= 'others' id= 'others'>

<table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='1' width='100%' align='center'>

<tr>

<td class='columnheader'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>

</tr>


<tr>

<TD class ='QRYEVEN'><fmt:message key="eIP.BlockBed.label" bundle="${ip_labels}"/></td>		
			
<%if(recordexists.equals("Y")) { if(rset.getString("block_bed_yn").equals("Y")) dis=""; else dis=" disabled "; }%>
		
<%if(valueexits.equals("Y")) { if(rset1.getString("block_bed_yn").equals("Y")) chk=" checked "; else chk=""; }%>               
<TD class ='QRYEVEN'><INPUT TYPE="checkbox"  value="Y" name="block_bed_yn" id="block_bed_yn"  <%=chk%>  <%=dis%>></TD>

</tr>

<tr>

<TD class='QRYODD'><fmt:message key="Common.ReleaseBed.label" bundle="${common_labels}"/></TD>
				
<%if(recordexists.equals("Y")) { if(rset.getString("RELEASE_BED_YN").equals("Y")) dis=""; else dis=" disabled "; }%>
			
<%if(valueexits.equals("Y")) { if(rset1.getString("RELEASE_BED_YN").equals("Y")) chk=" checked "; else chk=""; }%>
			
<TD class='QRYODD'><INPUT TYPE="checkbox"  value="Y" name="release_bed_yn" id="release_bed_yn"  <%=chk%> <%=dis%> ></TD>

</tr>

<tr>

<TD class ='QRYEVEN'><fmt:message key="eAM.RecordAmendLeave.label" bundle="${am_labels}"/></td>		
			
<%if(recordexists.equals("Y")) { if(rset.getString("revise_leave_yn").equals("Y")) dis=""; else dis=" disabled "; }%>
			
<%if(valueexits.equals("Y")) { if(rset1.getString("revise_leave_yn").equals("Y")) chk=" checked "; else chk=""; }%>
			
<TD class ='QRYEVEN'><INPUT TYPE="checkbox"  value="Y" name="revise_leave_yn" id="revise_leave_yn"  <%=dis%> <%=chk%> ></TD>

</tr>

<tr>

<TD class='QRYODD'><fmt:message key="eAM.CheckInCheckOutLodger.label" bundle="${am_labels}"/></td>		

<%if(recordexists.equals("Y")) { if(rset.getString("check_lodger_yn").equals("Y")) dis=""; else dis=" disabled "; }%>
			
<%if(valueexits.equals("Y")) { if(rset1.getString("check_lodger_yn").equals("Y")) chk=" checked "; else chk=""; }%>
		
<TD class='QRYODD'><INPUT TYPE="checkbox"  value="Y" name="check_lodger_yn" id="check_lodger_yn"   <%=dis%> <%=chk%> ></TD>

</tr>

<tr>

 <TD class ='QRYEVEN'><fmt:message key="Common.RegisterInpatientReferral.label" bundle="${common_labels}"/></TD>	
			
<%if(recordexists.equals("Y")) { if(rset.getString("REG_IP_REFERRAL_YN").equals("Y")) dis=""; else dis=" disabled "; }%>
			
<%if(valueexits.equals("Y")) { if(rset1.getString("REG_IP_REFERRAL_YN").equals("Y")) chk=" checked "; else chk=""; }%>
			
<TD class ='QRYEVEN'><INPUT TYPE="checkbox"  value="Y" name="REG_IP_REFERRAL_YN" id="REG_IP_REFERRAL_YN" <%=chk%> <%=dis%> ></TD>

</tr>

<tr>

<TD class='QRYODD'><fmt:message key="Common.ConfirmBedsideReferral.label" bundle="${common_labels}"/></TD>
		
<%if(recordexists.equals("Y")) { if(rset.getString("CONFIRM_BEDSIDE_REFERRAL_YN").equals("Y")) dis=""; else dis=" disabled "; }%>
		
<%if(valueexits.equals("Y")) { if(rset1.getString("CONFIRM_BEDSIDE_REFERRAL_YN").equals("Y")) chk=" checked "; else chk=""; }%>
			
<TD class='QRYODD'><INPUT TYPE="checkbox"  value="Y" name="CONFIRM_BEDSIDE_REFERRAL_YN" id="CONFIRM_BEDSIDE_REFERRAL_YN" <%=chk%> <%=dis%> ></TD>

</tr>
<!-- <tr>

	<%if(recordexists.equals("Y")) { if(rset.getString("CANCEL_CHECKOUT_YN").equals("Y")) dis=""; else dis=" disabled "; }%>
			
	<%if(valueexits.equals("Y")) { if(rset1.getString("CANCEL_CHECKOUT_YN").equals("Y")) chk=" checked "; else chk=""; }%>
			
	<TD class='QRYODD'><fmt:message key="Common.CancelCheckout.label" bundle="${common_labels}"/></TD>
			
	<TD class='QRYODD'><INPUT TYPE="checkbox" value="Y" name="CANCEL_CHECKOUT_YN" id="CANCEL_CHECKOUT_YN"  <%=dis%> <%=chk%>></TD>

</tr> -->

<tr>
<%
if(recordexists.equals("Y")) { if(rset.getString("DIAG_PROC_RECODE_FOR_IP_YN").equals("Y")) dis=""; else dis=" disabled "; }%>
			
<%if(valueexits.equals("Y")) { if(rset1.getString("DIAG_PROC_RECODE_FOR_IP_YN").equals("Y")) chk=" checked "; else chk=""; }%>
   


	<TD class='QRYEVEN'><fmt:message key="eMR.DiagnosisProcedureRecode.label" bundle="${mr_labels}"/></TD>
	<TD class='QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="diag_proc_recode_for_ip_yn" id="diag_proc_recode_for_ip_yn"  <%=dis%> <%=chk%>></TD>

</tr>

<tr>
 

 <% if(recordexists.equals("Y") && rset.getString("MAINTAIN_DEATH_REGISTER_YN").equals("Y")) dis=""; else dis="disabled"; %>

 <%if(valueexits.equals("Y")) { if(rset1.getString("MAINTAIN_DEATH_REGISTER_YN").equals("Y")) chk=" checked "; else chk=""; }%>

<TD class = 'QRYEVEN'><fmt:message key="eMR.MaintainDeathRegister.label" bundle="${mr_labels}"/></TD>	
<TD class = 'QRYEVEN'><INPUT TYPE="checkbox" value="Y" name="MAINTAIN_DEATH_REGISTER_YN" id="MAINTAIN_DEATH_REGISTER_YN"  <%=chk%> <%=dis%>></TD>

</tr>


</table>

<%}%>		



<input type="hidden" name="tfr_appt_across_catg_yn_hdd" id="tfr_appt_across_catg_yn_hdd" value="<%=rset.getString("tfr_appt_across_catg_yn")%>">
<input type="hidden" name="create_booking_with_conf_yn_hdd" id="create_booking_with_conf_yn_hdd" value="<%=rset.getString("create_booking_with_conf_yn")%>">
<input type="hidden" name="create_booking_yn_hdd" id="create_booking_yn_hdd" value="<%=rset.getString("create_booking_yn")%>">
<input type="hidden" name="book_appt_wo_pid_yn_hdd" id="book_appt_wo_pid_yn_hdd" value="<%=rset.getString("book_appt_wo_pid_yn")%>">
<input type="hidden" name="book_appt_across_catg_yn_hdd" id="book_appt_across_catg_yn_hdd" value="<%=rset.getString("book_appt_across_catg_yn")%>">
<input type="hidden" name="forced_book_appt_yn_hdd" id="forced_book_appt_yn_hdd" value="<%=rset.getString("forced_book_appt_yn")%>">
<input type="hidden" name="global_book_appt_yn_hdd" id="global_book_appt_yn_hdd" value="<%=rset.getString("global_book_appt_yn")%>">
<input type="hidden" name="obook_appt_yn_hdd" id="obook_appt_yn_hdd" value="<%=rset.getString("obook_appt_yn")%>">
<input type="hidden" name="tfr_appt_yn_hdd" id="tfr_appt_yn_hdd" value="<%=rset.getString("tfr_appt_yn")%>">

<input type="hidden" name="register_visit_yn_hdd" id="register_visit_yn_hdd" value="<%=rset.getString("register_visit_yn")%>">
<input type="hidden" name="register_pat_in_admn_yn_hdd" id="register_pat_in_admn_yn_hdd" value="<%=rset.getString("register_pat_in_admn_yn")%>">
<input type="hidden" name="register_visit_walkin_yn_hdd" id="register_visit_walkin_yn_hdd" value="<%=rset.getString("register_visit_walkin_yn")%>">
<input type="hidden" name="register_visit_referral_yn_hdd" id="register_visit_referral_yn_hdd" value="<%=rset.getString("register_visit_referral_yn")%>">
<input type="hidden" name="register_pat_yn_hdd" id="register_pat_yn_hdd" value="<%=rset.getString("register_pat_yn")%>">
<input type="hidden" name="admit_patient_with_bed_yn_hdd" id="admit_patient_with_bed_yn_hdd" value="<%=rset.getString("admit_patient_with_bed_yn")%>">
<input type="hidden" name="chg_nurs_unit_in_assign_bed_yn_hdd" id="chg_nurs_unit_in_assign_bed_yn_hdd" value="<%=rset.getString("chg_nurs_unit_in_assign_bed_yn")%>">

<input type="hidden" name="LINK_BABY_TO_MOTHER_YN_HDD" id="LINK_BABY_TO_MOTHER_YN_HDD" value="<%=rset.getString("LINK_BABY_TO_MOTHER_YN")%>">
<input type="hidden" name="REG_NEWBORN_FOR_IP_YN_HDD" id="REG_NEWBORN_FOR_IP_YN_HDD" value="<%=rset.getString("REG_NEWBORN_FOR_IP_YN")%>">
<input type="hidden" name="DISCHARGE_CHECKLIST_YN_HDD" id="DISCHARGE_CHECKLIST_YN_HDD" value="<%=rset.getString("DISCHARGE_CHECKLIST_YN")%>">
<input type="hidden" name="CANCEL_DISCHARGE_YN_HDD" id="CANCEL_DISCHARGE_YN_HDD" value="<%=rset.getString("CANCEL_DISCHARGE_YN")%>">

<input type="hidden" name="RESERVE_BED_BAY_YN_HDD" id="RESERVE_BED_BAY_YN_HDD" value="<%=rset.getString("RESERVE_BED_BAY_YN")%>">
<input type="hidden" name="RELEASE_BED_BAY_YN_HDD" id="RELEASE_BED_BAY_YN_HDD" value="<%=rset.getString("RELEASE_BED_BAY_YN")%>">

<input type="hidden" name="REG_IP_REFERRAL_YN_HDD" id="REG_IP_REFERRAL_YN_HDD" value="<%=rset.getString("REG_IP_REFERRAL_YN")%>">
<input type="hidden" name="CONFIRM_BEDSIDE_REFERRAL_YN_HDD" id="CONFIRM_BEDSIDE_REFERRAL_YN_HDD" value="<%=rset.getString("CONFIRM_BEDSIDE_REFERRAL_YN")%>">
<input type="hidden" name="OVERRIDE_WALKIN_YN_HDD" id="OVERRIDE_WALKIN_YN_HDD" value="<%=rset.getString("OVERRIDE_WALKIN_YN")%>">

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		<%

	/*	if(location_type.equals("N"))
			out.println("<script>tab_click('additional_tab')</script>");
		else
			out.println("<script>tab_click('search_tab')</script>");     */

		out.println("<input type=\"hidden\" name=\"operstntype\" value="+operstntype+">");

		if(mode.equals("insert"))
		{
			
			if(location_type.equals("N"))
			{
				//out.println("<script>alert(' location insert')</script>");

				if(rset.getString("create_booking_with_conf_yn").equals("Y"))
				out.println("<script>document.forms[0].CREATE_BOOKING_WITH_CONF_YN.checked = true;</script>");
				if(rset.getString("transfer_out_patient_yn").equals("Y"))
				out.println("<script>document.forms[0].TRANSFER_OUT_PATIENT_YN.checked = true;</script>");
				if(rset.getString("transfer_in_patient_yn").equals("Y"))
				out.println("<script>document.forms[0].TRANSFER_IN_PATIENT_YN.checked = true;</script>");
				if(rset.getString("chg_nurs_unit_in_assign_bed_yn").equals("Y"))
				out.println("<script>document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.checked = true;</script>");
				if(rset.getString("admit_patient_with_bed_yn").equals("Y"))
				out.println("<script>document.forms[0].ADMIT_PATIENT_WITH_BED_YN.checked = true;</script>");
				
				/*Below line Added for this CRF Bru-HIMS-CRF-261*/
				if(rset.getString("quick_admission_yn").equals("Y"))
				out.println("<script>if(document.forms[0].quick_admission_yn)document.forms[0].quick_admission_yn.checked = true;</script>");
				//End Bru-HIMS-CRF-261
				
				if(rset.getString("swap_bed_yn").equals("Y"))
				out.println("<script>document.forms[0].SWAP_BED_YN.checked = true;</script>");
				if(rset.getString("backdated_admission_yn").equals("Y"))
				out.println("<script>document.forms[0].BACKDATED_ADMISSION_YN.checked = true;</script>");
				if(rset.getString("bed_class_change_yn").equals("Y"))
				out.println("<script>document.forms[0].BED_CLASS_CHANGE_YN.checked = true;</script>");
				if(rset.getString("confirm_request_yn").equals("Y"))
				out.println("<script>document.forms[0].cfrm_req_yn.checked = true;</script>");
				if(rset.getString("cancel_request_yn").equals("Y"))
				out.println("<script>document.forms[0].canc_req_yn.checked = true;</script>");
				if(rset.getString("cancel_transfer_out_yn").equals("Y"))
				out.println("<script>document.forms[0].can_tfr_out_yn.checked = true;</script>");
				if(rset.getString("pract_transfer_yn").equals("Y"))
				out.println("<script>document.forms[0].pract_tfr_yn.checked = true;</script>");
				if(rset.getString("discharge_advice_yn").equals("Y"))
				out.println("<script>document.forms[0].dchrg_adv_yn.checked = true;</script>");
				if(rset.getString("create_booking_yn").equals("Y"))
				out.println("<script>document.forms[0].create_booking_yn.checked = true;</script>");
				if(rset.getString("revise_booking_yn").equals("Y"))
				out.println("<script>document.forms[0].revise_booking_yn.checked = true;</script>");
				if(rset.getString("canc_booking_yn").equals("Y"))
				out.println("<script>document.forms[0].canc_booking_yn.checked = true;</script>");
				if(rset.getString("confirm_booking_yn").equals("Y"))
				out.println("<script>document.forms[0].CONFIRM_BOOKING_YN.checked = true;</script>");
				if(rset.getString("admit_pat_yn").equals("Y"))
				out.println("<script>document.forms[0].admit_pat_yn.checked = true;</script>");
				if(rset.getString("register_pat_in_admn_yn").equals("Y"))
				out.println("<script>document.forms[0].register_pat_in_admn_yn.checked = true;</script>");
				if(rset.getString("assign_bed_yn").equals("Y"))
				out.println("<script>document.forms[0].assign_bed_yn.checked = true;</script>");
				if(rset.getString("assign_treat_pract_yn").equals("Y"))
				out.println("<script>document.forms[0].assign_treat_pract_yn.checked = true;</script>");
                if(rset.getString("revise_admission_yn").equals("Y"))
				out.println("<script>document.forms[0].revise_admission_yn.checked = true;</script>");
				if(rset.getString("canc_admission_yn").equals("Y"))
				out.println("<script>document.forms[0].canc_admission_yn.checked = true;</script>");
				if(rset.getString("emergency_tfr_yn").equals("Y"))
				out.println("<script>document.forms[0].emergency_tfr_yn.checked = true;</script>");
				if(rset.getString("MAINTAIN_DEATH_REGISTER_YN").equals("Y"))
				out.println("<script>document.forms[0].MAINTAIN_DEATH_REGISTER_YN.checked = true;</script>");
				if(rset.getString("routine_tfr_yn").equals("Y"))
				out.println("<script>document.forms[0].routine_tfr_yn.checked = true;</script>");
				if(rset.getString("discharge_pat_yn").equals("Y"))
				out.println("<script>document.forms[0].discharge_pat_yn.checked = true;</script>");
				if(rset.getString("revise_leave_yn").equals("Y"))
				out.println("<script>document.forms[0].revise_leave_yn.checked = true;</script>");
				if(rset.getString("check_lodger_yn").equals("Y"))
				out.println("<script>document.forms[0].check_lodger_yn.checked = true;</script>");
				if(rset.getString("block_bed_yn").equals("Y"))
				out.println("<script>document.forms[0].block_bed_yn.checked = true;</script>");
				if(rset.getString("release_bed_yn").equals("Y"))
				out.println("<script>document.forms[0].release_bed_yn.checked = true;</script>");
				if(rset.getString("cancel_discharge_yn").equals("Y"))
				out.println("<script>document.forms[0].cancel_discharge_yn.checked = true;</script>");

				if(rset.getString("CANCEL_RESERVE_BED_YN").equals("Y"))
				out.println("<script>document.forms[0].CANCEL_RESERVE_BED_YN.checked = true;</script>");
				
				if(rset.getString("emergency_transfer_yn").equals("Y"))
				out.println("<script>document.forms[0].emergency_transfer_yn.checked = true;</script>");

				/*out.println("<script>document.forms[0].book_appt_wo_pid_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].book_appt_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].tfr_appt_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].tfr_appt_across_catg_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].obook_appt_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].book_appt_across_catg_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].canc_appt_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].FORCED_BOOK_APPT_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].GLOBAL_BOOK_APPT_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].create_wait_list_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].modify_wait_list_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].cancel_wait_list_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].register_visit_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].manage_queue_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].register_visit_walkin_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].register_pat_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].cancel_visit_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].revise_visit_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].register_visit_referral_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].checkout_pat_yn.value = 'N';</script>");*/

				
			}
			else
			{
				if(rset.getString("book_appt_wo_pid_yn").equals("Y"))
			//out.println("<script>alert('book_appt_wo_pid_yn')</script>");	
				out.println("<script>document.forms[0].book_appt_wo_pid_yn.checked = true;</script>");
				if(rset.getString("book_appt_yn").equals("Y"))
				out.println("<script>document.forms[0].book_appt_yn.checked = true;</script>");
				if(rset.getString("tfr_appt_yn").equals("Y"))
				out.println("<script>document.forms[0].tfr_appt_yn.checked = true;</script>");
				if(rset.getString("tfr_appt_across_catg_yn").equals("Y"))
				out.println("<script>document.forms[0].tfr_appt_across_catg_yn.checked = true;</script>");
				if(rset.getString("obook_appt_yn").equals("Y"))
				out.println("<script>document.forms[0].obook_appt_yn.checked = true;</script>");
				if(rset.getString("book_appt_across_catg_yn").equals("Y"))
				out.println("<script>document.forms[0].book_appt_across_catg_yn.checked = true;</script>");
				if(rset.getString("canc_appt_yn").equals("Y"))
				out.println("<script>document.forms[0].canc_appt_yn.checked = true;</script>");
				if(rset.getString("forced_book_appt_yn").equals("Y"))
				out.println("<script>document.forms[0].FORCED_BOOK_APPT_YN.checked = true;</script>");
				if(rset.getString("global_book_appt_yn").equals("Y"))
				out.println("<script>document.forms[0].GLOBAL_BOOK_APPT_YN.checked = true;</script>");
				if(rset.getString("create_wait_list_yn").equals("Y"))
				out.println("<script>document.forms[0].create_wait_list_yn.checked = true;</script>");
				if(rset.getString("modify_wait_list_yn").equals("Y"))
				out.println("<script>document.forms[0].modify_wait_list_yn.checked = true;</script>");
				if(rset.getString("cancel_wait_list_yn").equals("Y"))
				out.println("<script>document.forms[0].cancel_wait_list_yn.checked = true;</script>");
				
				

//cancel checkout
                if(rset.getString("cancel_checkout_yn").equals("Y"))
				out.println("<script>document.forms[0].cancel_checkout_yn.checked = true;</script>");

				if(rset.getString("register_visit_yn").equals("Y"))
				out.println("<script>document.forms[0].register_visit_yn.checked = true;</script>");
				if(rset.getString("manage_queue_yn").equals("Y"))
				out.println("<script>document.forms[0].manage_queue_yn.checked = true;</script>");
				if(rset.getString("register_visit_walkin_yn").equals("Y"))
				out.println("<script>document.forms[0].register_visit_walkin_yn.checked = true;</script>");
				if(rset.getString("register_pat_yn").equals("Y"))
				out.println("<script>document.forms[0].register_pat_yn.checked = true;</script>");
				if(rset.getString("cancel_visit_yn").equals("Y"))
				out.println("<script>document.forms[0].cancel_visit_yn.checked = true;</script>");
				if(rset.getString("revise_visit_yn").equals("Y"))
				out.println("<script>document.forms[0].revise_visit_yn.checked = true;</script>");
				if(rset.getString("register_visit_referral_yn").equals("Y"))
				out.println("<script>document.forms[0].register_visit_referral_yn.checked = true;</script>");
				if(rset.getString("checkout_pat_yn").equals("Y"))
				out.println("<script>document.forms[0].checkout_pat_yn.checked = true;</script>");

				
			/*	out.println("<script>document.forms[0].CREATE_BOOKING_WITH_CONF_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].TRANSFER_OUT_PATIENT_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].TRANSFER_IN_PATIENT_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].ADMIT_PATIENT_WITH_BED_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].SWAP_BED_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].BACKDATED_ADMISSION_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].BED_CLASS_CHANGE_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].cfrm_req_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].canc_req_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].can_tfr_out_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].pract_tfr_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].dchrg_adv_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].create_booking_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].revise_booking_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].canc_booking_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].CONFIRM_BOOKING_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].admit_pat_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].register_pat_in_admn_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].assign_bed_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].assign_treat_pract_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].canc_admission_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].emergency_tfr_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].routine_tfr_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].discharge_pat_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].revise_leave_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].check_lodger_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].block_bed_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].release_bed_yn.value = 'N';</script>");*/
			}
		}
	//} ///// EOF MAIN ELSE 
}catch(Exception e){
	//out.println(e.toString());
	e.printStackTrace();
}
finally 
{
	try
	{
		if ( rschk != null)  rschk.close();
		if ( stchk != null)  stchk.close();
		if (stmt != null) stmt.close();
		if (pstmt != null) pstmt.close();
		if (rset != null)   rset.close();
		if (stmt1 != null) stmt1.close();
		if (pstmt1 != null) pstmt1.close();
		if (rset1 != null)   rset1.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	ConnectionManager.returnConnection(con,request);
}
%>
<input type="hidden" name="oprstn" id="oprstn">
<input type="hidden" name="locid" id="locid">
<input type="hidden" name="loctype" id="loctype">
<input type="hidden" name="user" id="user" value='<%=appluserid%>'>
<input type="hidden" name="ws_no" id="ws_no">
<input type="hidden" name="operation_type" id="operation_type">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityID%>">
<input type="hidden" name="location_type" id="location_type" value="<%=location_type%>">
<input type="hidden" name="bkwipd" id="bkwipd" value='<%=bkwipd%>'>
<input type="hidden" name="bkwipd" id="bkwipd" value='<%=bkwipd%>'>
<input type="hidden" name="a1" id="a1" value='<%=a1%>'>
<input type="hidden" name="a2" id="a2" value='<%=a2%>'>
<input type="hidden" name="obappt" id="obappt" value='<%=obappt%>'>
<input type="hidden" name="bkapptac" id="bkapptac"  value='<%=bkapptac%>' >
<input type="hidden" name="tfrappt" id="tfrappt" value='<%=tfrappt%>'>
<input type="hidden" name="regvis" id="regvis" value='<%=regvis%>'>
</form>
</body>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

