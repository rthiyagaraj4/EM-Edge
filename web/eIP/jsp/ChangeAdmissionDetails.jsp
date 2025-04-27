<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,com.ehis.util.*,java.text.*,javax.servlet.jsp.*" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../js/IPPractitionerComponent.js' language='javascript'></script>
	<script src='../js/ReviseAdmission.js' language='javascript'></script>
	<script type="text/javascript">
	function closew()
	{
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close(); 
	}
	</script>
</head>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
Connection con							  = null;
PreparedStatement stmt	= null,bl_chrg_pt = null,bl_prcs_pt =	null,bl_adm_pt=null,trnsfr_pst=null;
ResultSet rs							  = null,bl_chrg_rs = null,bl_prcs_rs  = null,bl_adm_rs=null,trnsfr_rslt=null;
String facilityID			              =	(String)session.getValue("facility_id");
String locale							  = (String)session.getAttribute("LOCALE");
String loginUser						  = (String)session.getValue("login_user");
String install_yn						  = (String)session.getValue("bl_operational");
String customer_id						  = (String)session.getValue("CUSTOMER_ID");
String encounterID						  =	checkForNull(request.getParameter("encounter_id"));
String patientid						  =	checkForNull(request.getParameter("patient_id"));
String oper_stn_id						  = checkForNull(request.getParameter("oper_stn_id"));
String call_function					  = checkForNull(request.getParameter("call_function"));
String bl_instal						  = checkForNull(request.getParameter("bl_instal"),"N");
String deactivate_pseudo_bed_yn		      =	checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
String pat_check_in_allowed_yn			  =	checkForNull(request.getParameter("pat_check_in_allowed_yn"),"N");
String bl_interfaced_yn					  =	checkForNull(request.getParameter("bl_interfaced_yn"),"N");
int cutt_off_time						  =	Integer.parseInt(request.getParameter("cutt_off_time"));
int change_adm_dtls_duration			  =	Integer.parseInt(request.getParameter("change_adm_dtls_duration"));
int max_disch_period_for_dc				  = Integer.parseInt(request.getParameter("max_disch_period_for_dc")==null?"0":request.getParameter("max_disch_period_for_dc"));
boolean adm_time_xcd 				      =	true;					
										
String admission_date_time1			      = "";
String admission_date_time			      = "";
String specialty_code					  = "";
String specialty_short_desc			      = "";
String nursing_unit_code				  = "";
String nursing_unit_short_desc		      = "";
String service_code						  = "";
String service_short_desc				  = "";
String subservice_code					  = "";
String subservice_short_desc		      = "";
String bed_class_code					  = "";
String bed_class_short_desc			      = "";
String bed_type_code					  = "";
String bed_type_short_desc			      = "";
String bed_no							  = "";
String room_no							  = "";
String exp_discharge_date_time	          = "";
String exp_discharge_date_time1	          = "";
String referral_id1						  = "";
String OT_date_time						  = "";
String OT_date_time1					  = "";
String admission_type					  = "";
String admission_short_desc				  = "";
String admit_practitioner_id			  = "";
String admit_practitioner_name		      = "";
String ambulatory_status_code		      = "";
String ambulatory_status				  = "";
String practitioner_id					  = "";
String practitioner_name				  = "";
String patient_class					  = "";
String revision_resn_code				  = "";
String revision_resn_desc				  = "";
String adt_status						  = "";
String Gender							  = "";

boolean  err_status						  =	true;
boolean  tr_err_status					  =	true;
String Enable_Fields					  =	"";
String disable_Fields					  =	"";
String Enable_Field						  =	"";
String disable_Field					  =	"";
String checkForBilling					  =	"N";
String tr_err_Code				          =	"";
String tfr_req_status				      =	"";
PreparedStatement stm					  = null;
PreparedStatement stm1					  = null;
ResultSet res							  = null;
ResultSet res1							  = null;

String max_param_date					  = "";
String valid							  = "";
String from_time						  = "";
String valid_date						  = "";
String dis_bed_room_no					  = "";
StringBuffer sqlSB						  = new StringBuffer();
int TR_Count							  = 0;
String p_service_charge_YN				  =	"";
String disableReferral					  = "" ;
String admission_remarks				  = "" ;
String admission_approval_details         = ""; //Added by Suji Keerthi for MMS-DM-CRF-0191 US002

Boolean isInvokeUploadDocAppl = false; //Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11

try{
	con = ConnectionManager.getConnection(request);

	//Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11
	isInvokeUploadDocAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"MP","INVOKE_UPLOAD_DOCUMENT");
		
	if(sqlSB.length() > 0) sqlSB.delete(0,sqlSB.length());
	sqlSB.append("SELECT A.adt_status, to_char(A.admission_date_time,'dd/mm/yyyy hh24:MI')admission_date_time,A.specialty_code,am_get_desc.am_speciality(A.specialty_code,'"+locale+"',2)specialty_short_desc,A.nursing_unit_code,ip_get_desc.ip_nursing_unit(A.facility_id,A.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc,A.service_code,am_get_desc.am_service (A.service_code,'"+locale+"',2) service_short_desc,A.subservice_code,am_get_desc.am_subservice (A.subservice_code,a.service_code,'"+locale+"',2)  subservice_short_desc,A.bed_class_code,ip_get_desc.ip_bed_class (A.bed_class_code,'"+locale+"',2)   bed_class_short_desc,A.bed_type_code,ip_get_desc.ip_bed_type (A.bed_type_code,'"+locale+"',2) bed_type_short_desc,nvl(A.bed_num,A.BLOCKED_BED_NO)bed_no,A.room_num,A.admission_type,ip_get_desc.ip_admission_type (A.admission_type,'"+locale+"',2) admission_short_desc,A.admit_practitioner_id,am_get_desc.am_practitioner(A.admit_practitioner_id,'"+locale+"',1) admit_practitioner_name,A.attend_practitioner_id practitioner_id,am_get_desc.am_practitioner(A.attend_practitioner_id,'"+locale+"',1) practitioner_name,A.patient_class,D.sex Gender,B.ambulatory_status ambulatory_status_code ,B.referral_id,am_get_desc.am_ambulatory_status(B.ambulatory_status,'"+locale+"',2)ambulatory_status,to_char(B.exp_discharge_date_time,'dd/mm/yyyy hh24:MI')exp_discharge_date_time,to_char(C.ot_date_time,'dd/mm/yyyy hh24:MI')ot_date_time,B.contact_reason_code revision_resn_code ,am_get_desc.am_contact_reason(B.contact_reason_code,'"+locale+"',1)revision_resn_desc,a.tfr_req_status ");
	/*Tuesday, May 18, 2010 , added for PE*/
	sqlSB.append(",TO_CHAR((SELECT MAX (trn_date_time) FROM IP_ADT_TRN WHERE facility_id = A.facility_id AND encounter_id = A.encounter_id ), 'dd/mm/rrrr hh24:mi') FROM_TIME,TO_CHAR(A.admission_date_time + (1 / 24) * '"+max_disch_period_for_dc+"', 'dd/mm/rrrr hh24:mi' ) MAX_PARAM_DATE ,(CASE WHEN TRUNC (TO_DATE(A.admission_date_time, 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE (A.admission_date_time, 'dd/mm/rrrr hh24:mi')) THEN 'N' ELSE 'Y' END ) VALID");
	sqlSB.append (",TO_CHAR((CASE WHEN TRUNC (  TO_DATE (A.admission_date_time, 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE (A.admission_date_time, 'dd/mm/rrrr hh24:mi')) THEN trunc(TO_DATE(A.admission_date_time, 'DD/MM/rrrr hh24:mi')) ELSE TO_DATE(A.admission_date_time, 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"' END), 'dd/mm/rrrr') VALID_DATE ");
	
	sqlSB.append(",(select count(1) from ip_adt_trn where facility_id=A.facility_id and encounter_id=A.encounter_id)tr_cnt");
	sqlSB.append(",b.admission_approval_details admission_approval_details "); //Added by Suji Keerthi for MMS-DM-CRF-0191 US002
	if(install_yn.equals("Y"))
	{
		sqlSB.append(", BL_IP_DETAILS.BL_CHECK_SERVICE_EXISTS(a.facility_id , a.patient_id , 'I' , a.encounter_id) p_service_charge_YN ");
	}
	/**/
	if(customer_id.equals("AMRI"))
	{
		sqlSB.append(",b.admission_remarks admission_remarks ");
	}
	sqlSB.append (" from ip_open_encounter A, pr_encounter B, ip_adt_trn C,MP_PATIENT D  where  A.facility_id='"+facilityID+"' and A.encounter_id='"+encounterID+"' and A.encounter_id=B.encounter_id and A.facility_id=B.facility_id and   A.facility_id = C.facility_id and A.encounter_id=C.encounter_id AND A.PATIENT_ID=D.PATIENT_ID");

	stmt=con.prepareStatement(sqlSB.toString());
	rs=stmt.executeQuery();
	if(rs!=null && rs.next()){
		admission_date_time1			=	checkForNull(rs.getString("admission_date_time"));
		specialty_code					=	checkForNull(rs.getString("specialty_code"));
		specialty_short_desc			=	checkForNull(rs.getString("specialty_short_desc"));
		nursing_unit_code				=	checkForNull(rs.getString("nursing_unit_code"));
		nursing_unit_short_desc			=	checkForNull(rs.getString("nursing_unit_short_desc"));
		referral_id1					=	checkForNull(rs.getString("referral_id"));
		
		service_code					=	checkForNull(rs.getString("service_code"));
		service_short_desc				=	checkForNull(rs.getString("service_short_desc"));
		subservice_code					=	checkForNull(rs.getString("subservice_code"));
		subservice_short_desc			=	checkForNull(rs.getString("subservice_short_desc"));
		bed_class_code					=	checkForNull(rs.getString("bed_class_code"));
		bed_class_short_desc			=	checkForNull(rs.getString("bed_class_short_desc"));
		bed_type_code					=	checkForNull(rs.getString("bed_type_code"));
		bed_type_short_desc				=	checkForNull(rs.getString("bed_type_short_desc"));
		bed_no							=	checkForNull(rs.getString("bed_no"));
		room_no							=	checkForNull(rs.getString("room_num"));
		admission_type					=	checkForNull(rs.getString("admission_type"));
		admission_short_desc			=	checkForNull(rs.getString("admission_short_desc"));
		exp_discharge_date_time1		=	checkForNull(rs.getString("exp_discharge_date_time"));
		admit_practitioner_id			=	checkForNull(rs.getString("admit_practitioner_id"));
		admit_practitioner_name			=	checkForNull(rs.getString("admit_practitioner_name"));
		practitioner_id					=	checkForNull(rs.getString("practitioner_id"));
		practitioner_name				=	checkForNull(rs.getString("practitioner_name"));
		patient_class					=	checkForNull(rs.getString("patient_class"));
		ambulatory_status_code			=	checkForNull(rs.getString("ambulatory_status_code"));
		ambulatory_status				=	checkForNull(rs.getString("ambulatory_status"));
		OT_date_time1					=	checkForNull(rs.getString("ot_date_time"));
		revision_resn_code				=	checkForNull(rs.getString("revision_resn_code"));
		revision_resn_desc				=	checkForNull(rs.getString("revision_resn_desc"));
		adt_status						=	checkForNull(rs.getString("adt_status"));
		Gender							=	checkForNull(rs.getString("Gender"));
		tfr_req_status					=	checkForNull(rs.getString("tfr_req_status"));
		valid							=	checkForNull(rs.getString("VALID"));
		from_time						=	checkForNull(rs.getString("FROM_TIME"));
		max_param_date					=	checkForNull(rs.getString("MAX_PARAM_DATE"));
		valid_date						=	checkForNull(rs.getString("VALID_DATE"));
		admission_approval_details		=	checkForNull(rs.getString("admission_approval_details")); //Added by Suji Keerthi for MMS-DM-CRF-0191 US002
		TR_Count						=	rs.getInt("tr_cnt");
		if(install_yn.equals("Y"))
		{
			p_service_charge_YN			=	checkForNull(rs.getString("p_service_charge_YN"),"N");
		}
		if(customer_id.equals("AMRI"))
		{
			admission_remarks				=	checkForNull(rs.getString("admission_remarks"));
		}
	}
		//valid_date						= valid_date+ " 23:59";
		valid_date = max_param_date; //Modified for AAKH-SCF-0093
	if(patient_class.equals("DC"))
		disableReferral = "disabled";
	else 
		disableReferral = "";

/*Monday, May 17, 2010 , commented for PE , value will be passed from InpatientLookupQueryResult.jsp*/
	/*
String str="Select max_disch_period_for_dc from IP_PARAM where facility_id='"+facilityID+"' ";
//out.println(str);
stm=con.prepareStatement(str);
	res=stm.executeQuery();
	if(res!=null )
		{
			while(res.next())
			{
max_disch_period_for_dc	= res.getInt("max_disch_period_for_dc"); 
			}
		}
*/

exp_discharge_date_time = DateUtils.convertDate(exp_discharge_date_time1,"DMYHM","en",locale); 			
OT_date_time = DateUtils.convertDate(OT_date_time1,"DMYHM","en",locale); 	
admission_date_time = DateUtils.convertDate(admission_date_time1,"DMYHM","en",locale); 	

/*Tuesday, May 18, 2010 , commented for PE and moved to line no 104*/
/*
String str1= "SELECT TO_CHAR((SELECT MAX (trn_date_time) FROM IP_ADT_TRN WHERE facility_id = '"+facilityID+"' AND encounter_id = '"+encounterID+"' ), 'dd/mm/rrrr hh24:mi') FROM_TIME,TO_CHAR(TO_DATE('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"', 'dd/mm/rrrr hh24:mi' ) MAX_PARAM_DATE,(CASE WHEN TRUNC (TO_DATE('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE ('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')) THEN 'N' ELSE 'Y' END ) VALID,TO_CHAR((CASE WHEN TRUNC (  TO_DATE ('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE ('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')) THEN trunc(TO_DATE('"+admission_date_time+"', 'DD/MM/rrrr hh24:mi')) ELSE TO_DATE('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"' END), 'dd/mm/rrrr') VALID_DATE from IP_OPEN_ENCOUNTER_VW WHERE  facility_id = '"+facilityID+"' AND encounter_id = '"+encounterID+"' ";
stm1=con.prepareStatement(str1);
	res1=stm1.executeQuery();
			if ((res1 != null) && (res1.next()))
			{
				

				valid			= res1.getString("VALID");
				from_time		= res1.getString("FROM_TIME");
				max_param_date	= res1.getString("MAX_PARAM_DATE");
				valid_date		= res1.getString("VALID_DATE");
				
				//out.println("valid=="+valid);
				
			}

*/
/*Before Changing Details,
	Billing Validations & Transfer Count are to be checked,
	Once the seclected Patient is through with validation  Recording is Allowed */
try{
StringBuffer billing_SQL		= new StringBuffer();
String p_Unprcs_Servc_YN		=	"";
String p_adm_deposit_YN			=	"";
String bl_err_Code				=	"";

/**/
if(cutt_off_time > change_adm_dtls_duration)
{
	adm_time_xcd	 =	false;
	tr_err_status	 =	false; // 17th sep 09
	if(customer_id.equals("AMRI"))
	{
		out.println("<script>parent.frames[2].alert(getMessage('ADMIN_TIME_EXCEEDED_AMRI','IP'));</script>");
	}else{
		out.println("<script>parent.frames[2].alert(getMessage('ADMISSION_TIME_EXCEEDED','IP'));</script>");
	}
}
if(adm_time_xcd)
{
			/*Tuesday, May 18, 2010 , commented for PE moved to line no 105*/
			/*
			query_for_transfer=	"select count(*) tr_cnt from ip_adt_trn where facility_id='"+facilityID+"' and encounter_id='"+encounterID+"' ";
			stmt	=	con.prepareStatement(query_for_transfer);
			rs	=	stmt.executeQuery();
			if(rs!=null&&rs.next()){
				TR_Count	=	rs.getInt("tr_cnt");
			}*/
			 if(TR_Count>1){
					tr_err_status	 =	false;
					if(customer_id.equals("AMRI"))
					{
						tr_err_Code		 = "PATIENT_TRANSFFERED_AMRI";
					}else
					{
						tr_err_Code		 = "PATIENT_IS_TRANSFFERED";
					}
					%>
					<script>
								parent.frames[2].alert(getMessage('<%=tr_err_Code%>','IP'));
					</script>
					<%
				}
}
if(tr_err_status)
{
/*Tuesday, May 18, 2010 , commented for PE , moved to line no 109*/
/*
billing_SQL.append("Select BL_IP_DETAILS.BL_CHECK_SERVICE_EXISTS(?,?,'I',?)p_service_charge_YN from dual");

if (install_yn.equals("Y")){
		bl_chrg_pt	=	con.prepareStatement(billing_SQL.toString());
		bl_chrg_pt.setString(1,facilityID);
		bl_chrg_pt.setString(2,patientid);
		bl_chrg_pt.setString(3,encounterID);
		bl_chrg_rs	=	bl_chrg_pt.executeQuery();
		if(bl_chrg_rs!=null && bl_chrg_rs.next()){
			p_service_charge_YN	=	checkForNull(bl_chrg_rs.getString("p_service_charge_YN"));
		}
*/
		if (install_yn.equals("Y")){
			if(p_service_charge_YN.equals("Y")){
				err_status			= false;
				checkForBilling		= "Y";
				if(customer_id.equals("AMRI"))
				{
					bl_err_Code			=	"SERVICE_CHARGE_EXISTS_AMRI";
				}else
				{
					bl_err_Code			=	"SERVICE_CHARGE_EXISTS"	;
				}
							%>
							<script>

								parent.frames[2].alert(getMessage('<%=bl_err_Code%>','IP'));
							</script>
						<%
// Charged Sercvice Ends
			}else{
					if(billing_SQL.length()>0)billing_SQL.delete(0,billing_SQL.length());
					billing_SQL.append("Select  BL_IP_DETAILS.BL_CHECK_UNPROCESSED_EXISTS (?,?,'I',?) P_UNPROCESSED_SERVICE_YN  from dual");
					bl_prcs_pt	=	con.prepareStatement(billing_SQL.toString());
					bl_prcs_pt.setString(1,facilityID);      
					bl_prcs_pt.setString(	2,patientid); 
					bl_prcs_pt.setString(	3,encounterID);      
					bl_prcs_rs	=	bl_prcs_pt.executeQuery();
						if(bl_prcs_rs!=null && bl_prcs_rs.next()){
							p_Unprcs_Servc_YN	=	checkForNull(bl_prcs_rs.getString("P_UNPROCESSED_SERVICE_YN"));
						}
						if (p_Unprcs_Servc_YN.equals("Y")){
							err_status			=	false;
							checkForBilling		= "Y";
							if(customer_id.equals("AMRI"))
							{
								bl_err_Code			=	"UNPROCESSED_SERVICE_EXISTS_AMRI";
							}
							else
							{
								bl_err_Code			=	"UNPROCESSED_SERVICE_EXISTS";
							}
							%>
							<script>

								parent.frames[2].alert(getMessage('<%=bl_err_Code%>','IP'));
							</script>
						<%
						//UN Processed Srvice Ends
							}else{
							if(billing_SQL.length()>0)billing_SQL.delete(0,billing_SQL.length());
								billing_SQL.append("Select  bl_ip_details.BL_CHECK_ADM_DEPOSIT_EXISTS(?,?) P_ADM_DEPOSIT_YN  from dual");
								bl_adm_pt	=	con.prepareStatement(billing_SQL.toString());
								bl_adm_pt.setString(1,facilityID);      
								bl_adm_pt.setString(	2,encounterID); 
								bl_adm_rs	=	bl_adm_pt.executeQuery();
								if(bl_adm_rs!=null && bl_adm_rs.next()){
										p_adm_deposit_YN	=	checkForNull(bl_adm_rs.getString("P_ADM_DEPOSIT_YN"));
								}
								if (p_adm_deposit_YN.equals("Y")){
										err_status	 =	false;
										checkForBilling="Y";
										if(customer_id.equals("AMRI"))
											bl_err_Code	 =	"DEPOSIT_EXISTS_AMRI";
										else
											bl_err_Code	 =	"DEPOSIT_EXISTS";
										//ADM Deposit Ends
									%>
									<script>
										parent.frames[2].alert(getMessage('<%=bl_err_Code%>','IP'));
									</script>
								<%

							}
					}
			}
	}
}
//Inner Try Ends
}catch(Exception Billex){
		Billex.printStackTrace();
	}finally{
		if(bl_chrg_pt	 != null)bl_chrg_pt.close();
		if(bl_chrg_rs  != null)bl_chrg_rs.close();
		if(bl_prcs_pt  != null)bl_prcs_pt.close();
		if(bl_prcs_rs  != null)bl_prcs_rs.close();
		if(bl_adm_pt  != null)bl_adm_pt.close();
		if(bl_adm_rs  != null)bl_adm_rs.close();
		if(rs  != null)rs.close();
		if(stmt  != null)stmt.close();
		if(trnsfr_pst  != null)trnsfr_pst.close();
		if(trnsfr_rslt  != null)trnsfr_rslt.close();
}


if(adm_time_xcd){
	if(tr_err_Code.equals("")){
		if(err_status){
			Enable_Fields="";
			disable_Fields="";
		}else{
		
		disable_Fields="disabled";
		}
	}else{
		if(tr_err_status){
			Enable_Field="";
			disable_Field="";
		}else{
		
		disable_Field="disabled";
		}
	}


	if(!bed_no.equals("") && bl_instal.equals("N") && install_yn.equals("N") && tr_err_status == true) {
		dis_bed_room_no = "";
	} else {
		dis_bed_room_no = "disabled";
	}


} else {
	disable_Field="disabled";
	dis_bed_room_no = "disabled";
} 

//out.println("<script>alert('"+disable_Fields+"')</script>");
//out.println("<script>alert('"+Enable_Field+"')</script>");


//out.println("<script>alert('"+disable_Field+"')</script>");

%>
	<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
		<form name='Change_Adm_Dtls_Form' id='Change_Adm_Dtls_Form' method="post" <%if(tr_err_Code.equals("PATIENT_IS_TRANSFFERED")){%>action="../../servlet/eIP.ModifyServiceServlet"<%}else{%>action="../../servlet/eIP.ChangeAdmissionDtlsServlet" <%}%>target="messageFrame" >
				<input type='hidden' name='bedtypecode' id='bedtypecode' value = ''>
			<table border='0' cellpadding='0' cellspacing='0' width='100%'  align='center'>
				<tr>
					<td nowrap class="label" width='30%'><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>
					<td class='querydata'><b color='blue'><%=admission_date_time%></b></td>
					<!--Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11-->
					<%
					int ins_count = eMP.MPCommonBean.getInsuranceCount(con,encounterID,patientid);

					if(isInvokeUploadDocAppl && ins_count > 0){%>
						<td class='CAGROUPHEADING' nowrap><a href="javascript:UploadDocument();"><b><fmt:message key="Common.UploadInsDoc.label" bundle="${common_labels}"/>&nbsp;</b></a></td>
					<%}%>
				</tr>
			</table>
			<table border='1' cellpadding='4' cellspacing='0' width='100%' align='center'>
			<TR>
			<td class = 'columnheader' width = '25%'>&nbsp;</td>
			<td class="columnheader" width='35%'><fmt:message key="eIP.CurrentAdmissionDetails.label" bundle="${ip_labels}"/></td><td class="columnheader" width='35%'><fmt:message key="eIP.ChangeAdmissionDetails.label" bundle="${ip_labels}"/></td></TR>

								<tr>
									<td class='label'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
									<td class='querydata' ><b><%=nursing_unit_short_desc%>&nbsp;</b></td>
									<td class="fields">
										<input type='text' name="nursing_unit_desc" id="nursing_unit_desc" maxlength=15 size=15  value="<%=nursing_unit_short_desc%>" onblur="if(this.value==''){document.forms[0].nursing_unit.value='';};BeforeNursingUnitLookup('<%=facilityID%>','<%=loginUser%>','<%=oper_stn_id%>');CheckNursingUnit();" <%=disable_Fields%><%=disable_Field%>  ><input type='button' class='BUTTON' name="nursing_unit_lookup" id="nursing_unit_lookup" value='?' onClick="if(document.forms[0].nursing_unit_desc.value == '') NursingUnitLookup('<%=facilityID%>','<%=loginUser%>','<%=oper_stn_id%>');" <%=disable_Fields%><%=disable_Field%>><input type='hidden' name="nursing_unit" id="nursing_unit" value='<%=nursing_unit_code%>'><img src="../../eCommon/images/mandatory.gif"><input type='hidden' name="nurs_unit_desc_hid" id="nurs_unit_desc_hid" value='<%=nursing_unit_short_desc%>'><input type="hidden" name="ServiceFocus" id="ServiceFocus" value="N">
										<input type="hidden" name="NUnit_Chk" id="NUnit_Chk" value="<%=nursing_unit_code%>">
							</td>
								</tr>
								<tr>
									<td class='label' ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
									<td class='querydata' ><b><%=service_short_desc%>&nbsp;</b></td>
									<td nowrap class="fields">
									<!-- 	<select name="service" id="service" onChange='onServiceChange()'onmousewheel='return false;'  <%=disable_Fields%>><option value="" >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option> -->
									<select name="service" id="service" onChange='onServiceChange()'onmousewheel='return false;'  ><option value="" >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
								<%

								StringBuffer sql=new StringBuffer();
								Statement stmt1=null;
								ResultSet rset=null;
								String Code="";
								String Desc="";
								String sel="";
										sql.append(" select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURS_UNIT_FOR_SERVICE where facility_id = '"+facilityID+"' and nursing_unit_code = '"+nursing_unit_code+"' union select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURSING_UNIT where facility_id = '"+facilityID+"' and EFF_STATUS = 'E' and nursing_unit_code = '"+nursing_unit_code+"' order by 2");
										stmt1 = con.createStatement();
										rset = stmt1.executeQuery(sql.toString());	
										if(rset!=null ){
											while (rset.next()){
												Code			=	checkForNull(rset.getString("service_code"));
												Desc	 			=	checkForNull(rset.getString("service_short_desc"));
													if (Code.equals(service_code)){
													sel = "selected";
													}else{sel = "";}
													out.print("<option value=\""+Code+"\" "+sel+">"+Desc+"");
										}
									}
									if(stmt1!=null)stmt1.close();
									if(rset!=null)rset.close();
									%>
									</select><img src='../../eCommon/images/mandatory.gif'>
									<input type="hidden" name="Servic_Chk" id="Servic_Chk" value="<%=service_code%>">

								   </td>

								</tr>
								<tr>
									<td class='label' ><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
									<td class='querydata' ><b><%=subservice_short_desc%>&nbsp;</b></td>
									<td nowrap class="fields" >
										<!-- <select name="sub_service" id="sub_service" <%=disable_Fields%>  ><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option> -->
									<select name="sub_service" id="sub_service"  ><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
										<%
												if(sql.length() > 0) sql.delete(0,sql.length());
												sql.append("SELECT service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"',2 )service_short_desc, subservice_code, am_get_desc.AM_SUBSERVICE(SERVICE_CODE,SUBSERVICE_CODE,'"+locale+"',2 ) subservice_short_desc FROM am_facility_subsrvc WHERE operating_facility_id = '"+facilityID+"' AND service_code = '"+service_code+"' and eff_status = 'E'");
												stmt1 = con.createStatement();
												rset = stmt1.executeQuery(sql.toString());	
												if(rset!=null ){
													while (rset.next()){
														Code			=	checkForNull(rset.getString("subservice_code"));
														Desc	 			=	checkForNull(rset.getString("subservice_short_desc"));
															if (Code.equals(subservice_code)){
															sel = "selected";
															}else{sel = "";}
															out.print("<option value=\""+Code+"\" "+sel+">"+Desc+"");
										}
									}
									if(stmt1!=null)stmt1.close();
									if(rset!=null)rset.close();
									%>
										</select>
									<input type="hidden" name="SubServ_Chk" id="SubServ_Chk" value="<%=subservice_code%>">

									</td>

								</tr>
								<tr>
									<td class='label' ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
									<td class='querydata' ><b><%=bed_class_short_desc%>&nbsp;</b></td>
									<td nowrap class="fields" >
										<select name='Bedcode' id='Bedcode' onChange='onBedClassChange(this)' onmousewheel='return false;' <%=disable_Fields%><%=disable_Field%> ><option value="" selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option> 
										<%
												if(sql.length() > 0) sql.delete(0,sql.length());
												sql.append("SELECT DISTINCT a.bed_class_code bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facilityID+"' AND a.eff_status = 'E' AND a.nursing_unit_code = '"+nursing_unit_code+"' ORDER BY short_desc ");
												stmt1 = con.createStatement();
												rset = stmt1.executeQuery(sql.toString());	
												if(rset!=null ){
													while (rset.next()){
														Code			=	checkForNull(rset.getString("bed_class_code"));
														Desc	 			=	checkForNull(rset.getString("short_desc"));
															if (Code.equals(bed_class_code)){
															sel = "selected";
															}else{sel = "";}
															out.print("<option value=\""+Code+"\" "+sel+">"+Desc+"");
										}
									}
									if(stmt1!=null)stmt1.close();
									if(rset!=null)rset.close();
									%>
										</select><img  src='../../eCommon/images/mandatory.gif'> 
									<input type="hidden" name="BedCls_Chk" id="BedCls_Chk" value="<%=bed_class_code%>">

								 </td>

								</tr>
                                <!--Below added by Suji Keerthi for MMS-DM-CRF-0191 US002-->
								<tr>
									<td class='label' ><fmt:message key="eIP.AdmissionApprovalDtls.label" bundle="${ip_labels}"/></td>
									<td style='word-wrap: break-word;width:500px;' class='querydata' ><b><%=admission_approval_details%>&nbsp;</b></td>
									<td nowrap class="fields" >
										<input type="text" name="admission_approval_details" id="admission_approval_details" value="<%=admission_approval_details%>" size=10 maxlength=100 onKeyPress="return CheckForSpecCharsValidation1(event);" onBlur='CheckSplCharsValidation(this);'>
										<input type="hidden" name="AdmApprDtls_Chk" id="AdmApprDtls_Chk" value="<%=admission_approval_details%>">
									</td>
								</tr>
								<!--Ended by Suji Keerthi for MMS-DM-CRF-0191 US002-->
								<tr>
									<td class='label' ><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
									<td class='querydata' ><b><%=bed_type_short_desc%>&nbsp;</b></td>
									<td nowrap class="fields" >
										<select name="bed_type" id="bed_type" <%=disable_Fields%><%=disable_Field%>><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
										<%
												if(sql.length() > 0) sql.delete(0,sql.length());
												sql.append("SELECT DISTINCT a.bed_type_code bed_type_code, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2)  bed_type_short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facilityID+"' AND a.nursing_unit_code = '"+nursing_unit_code+"' AND a.bed_class_code = '"+bed_class_code+"' AND a.eff_status='E'  ORDER BY bed_type_short_desc");
												stmt1 = con.createStatement();
												rset = stmt1.executeQuery(sql.toString());	
												if(rset!=null ){
													while (rset.next()){
														Code			=	checkForNull(rset.getString("bed_type_code"));
														Desc	 			=	checkForNull(rset.getString("bed_type_short_desc"));
															if (Code.equals(bed_type_code)){
															sel = "selected";
															}else{sel = "";}
															out.print("<option value=\""+Code+"\" "+sel+">"+Desc+"");
										}
									}
									if(stmt1!=null)stmt1.close();
									if(rset!=null)rset.close();
									%>

										</select><img src='../../eCommon/images/mandatory.gif'>
									<input type="hidden" name="BedTyp_Chk" id="BedTyp_Chk" value="<%=bed_type_code%>">

								  </td>

								</tr>
								<tr>
									<td class='label' ><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
									<td class='querydata' ><b><%=bed_no%>&nbsp;</b></td>
									<td nowrap class="fields" >
										<input type="text" name="bed_no" id="bed_no" value="<%=bed_no%>" readonly size='8' maxlength='8' <%=dis_bed_room_no%> ><input type="button" class="button" name='bed_avail_chart' id='bed_avail_chart' value="?" onclick="callModal('BED_AVAIL')" <%=dis_bed_room_no%> >
										<%if(adt_status.equals("01") && !bed_no.equals("")){%>
											<img id='bed_img' src='../../eCommon/images/mandatory.gif'> 
										<%}%>											
										<input type="hidden" name="BedNo_Chk" id="BedNo_Chk" value="<%=bed_no%>">

								  </td>
								</tr>
								<tr>
									<td class='label' ><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
									<td class='querydata' ><b><%=room_no%>&nbsp;</b></td>
									<td nowrap class="fields" >
										<input type="text" name="room_no" id="room_no" value="<%=room_no%>" size=10 maxlength=10 readonly onBlur="" onKeyPress='return CheckForSpecChars(event)' <%=dis_bed_room_no%>> 
										<%if(adt_status.equals("01") && !bed_no.equals("")){ %>
											<img id='room_img' src='../../eCommon/images/mandatory.gif'>
										<%}%>
										<input type="hidden" name="RoomNo_Chk" id="RoomNo_Chk" value="<%=room_no%>">
										
								  </td>

								</tr>

								<tr>
									<td class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
									<td class='querydata' ><b color='blue'><%=specialty_short_desc%>&nbsp;</b></td>
									<td class='querydata'>					
									<input type='text' size='15' maxLength='15' name='SplDesc' id='SplDesc'  value="<%=specialty_short_desc%>" onblur="BeforegetSpecialty('<%=facilityID%>');" <%=Enable_Fields%><%=disable_Field%> ><input type='button' class='BUTTON' name='specialty_search' id='specialty_search' value='?' onClick="if(document.forms[0].SplDesc.value == '') getSpecialty('<%=facilityID%>');"  <%=Enable_Fields%><%=disable_Field%>><img src="../../eCommon/images/mandatory.gif">
									<input type='hidden' name='Splcode' id='Splcode' value="<%=specialty_code%>"><input type='hidden' name='SplDesc_hid' id='SplDesc_hid' value="<%=specialty_short_desc%>">	<input type="hidden" name="Splty_Chk" id="Splty_Chk" value="<%=specialty_code%>">

							</td>
								</tr>
								<tr>
									<td class='label' ><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
									<td class='querydata' ><b><%=admission_short_desc%>&nbsp;</b></td>
									<td nowrap class="fields" >
										<select name="visit_adm_type" id="visit_adm_type"  onChange="return validateFields(this)" <%=disable_Fields%><%=disable_Field%> ><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
										<%
												if(sql.length() > 0) sql.delete(0,sql.length());
												if(!admission_type.equals("")){
												sql.append("SELECT   admission_type_code,ip_get_desc.ip_admission_type(admission_type_code,'"+locale+"',2) short_desc FROM ip_admission_type WHERE eff_status = 'E' ORDER BY short_desc");
												stmt1 = con.createStatement();
												rset = stmt1.executeQuery(sql.toString());	
												if(rset!=null ){
													while (rset.next()){
														Code			=	checkForNull(rset.getString("admission_type_code"));
														Desc	 			=	checkForNull(rset.getString("short_desc"));
														if (Code.equals(admission_type)){
														sel = "selected";
														}else{sel = "";}
														out.print("<option value=\""+Code+"\" "+sel+">"+Desc+"");

										}
									}
								}
									if(stmt1!=null)stmt1.close();
									if(rset!=null)rset.close();
									%>
										</select><img src="../../eCommon/images/mandatory.gif"> 
									<input type="hidden" name="AdmTyp_Chk" id="AdmTyp_Chk" value="<%=admission_type%>">

								  </td>

								</tr>
								<tr>
									<td class='label' ><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/></td>
									<td class='querydata' ><b><%=ambulatory_status%>&nbsp;</b></td>
									<td nowrap class="fields" >
										<select name="ambulatory_status" id="ambulatory_status" <%=disable_Fields%><%=disable_Field%> ><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option> 
										<%
												if(sql.length() > 0) sql.delete(0,sql.length());
												sql.append("SELECT   ambulatory_status, am_get_desc.am_ambulatory_status(ambulatory_status,'"+locale+"',2)short_desc FROM am_ambulatory_status WHERE eff_status = 'E' ORDER BY short_desc");
												stmt1 = con.createStatement();
												rset = stmt1.executeQuery(sql.toString());	
												if(rset!=null ){
													while (rset.next()){
														Code			=	checkForNull(rset.getString("ambulatory_status"));
														Desc	 			=	checkForNull(rset.getString("short_desc"));
														if (Code.equals(ambulatory_status_code)){
														sel = "selected";
														}else{sel = "";}
														out.print("<option value=\""+Code+"\" "+sel+">"+Desc+"");
										}
									}
									if(stmt1!=null)stmt1.close();
									if(rset!=null)rset.close();
									%>
										</select>
									<input type="hidden" name="AmblSts_Chk" id="AmblSts_Chk" value="<%=ambulatory_status_code%>">

								  </td>
								</tr>
<!-- 								<tr>
									<td class='label' ><fmt:message key="eIP.ExpdaysofStay.label" bundle="${ip_labels}"/></td>
									<td class='querydata' >&nbsp;</td>
									<td nowrap class="fields" width='25%'>
										<input type='text' name='exp_days_stay' id='exp_days_stay' size='3' maxlength='3' value="" onKeyPress='return CheckForSpecChars(event)'  onBlur='' >
								  </td>

								</tr>
 -->								<tr>
									<td class='label' ><fmt:message key="eIP.ExpectesDischargeDate.label" bundle="${ip_labels}"/></td>
									<td class='querydata'><b><%=exp_discharge_date_time%>&nbsp;</b></td>
									<td nowrap class="fields" >
										<input type='text'  name='expecteddischargedate' id='expecteddischargedate' size=15 maxlength='16' value='<%=exp_discharge_date_time%>' onBlur='validateExpDate(this);' <%=Enable_Fields%>>
										<img src='../../eCommon/images/CommonCalendar.gif' id='ExpdisDate'  name='ExpdisDate' onClick="document.forms[0].expecteddischargedate.select();return showCalendar('expecteddischargedate',null,'hh:mm');" <%=Enable_Fields%> ><input type="hidden" name="EDD_Chk" id="EDD_Chk" value="<%=exp_discharge_date_time%>">
									</td>
								</tr>
								<tr>
									<td class='label' ><fmt:message key="eIP.ProcedureSurgeryDateTime.label" bundle="${ip_labels}"/></td>
									<td class='querydata' ><%=OT_date_time%>&nbsp;</td>
									<td nowrap class="fields" >
										<input type="text"  name="ot_date_time" id="ot_date_time" size=16 maxlength=16  onBlur="doOTDateTimeChk(this)" value ="<%=OT_date_time%>" <%=disable_Fields%><%=disable_Field%>><img src='../../eCommon/images/CommonCalendar.gif' id='OTDate'  name='OTDate' onClick="if ('<%=disable_Field%>' !== 'disabled'){document.forms[0].ot_date_time.select();return showCalendar('ot_date_time',null,'hh:mm');}" <%=disable_Fields%><%=disable_Field%> ><input type="hidden" name="OTD_Chk" id="OTD_Chk" value="<%=OT_date_time%>">
									</td>
								</tr>
								<tr>
									<td class='label' ><fmt:message key="eIP.AdmittingPractitioner.label" bundle="${ip_labels}"/></td>
									<td class='querydata' ><b><%=admit_practitioner_name%>&nbsp;</b></td>
									<td nowrap class="fields" >
									<!--Below line  modified for this CRF AMRI-CRF-0284 [IN:049116] -->
										<input type='text' name='practid_desc' id='practid_desc' value="<%=admit_practitioner_name%>" size='15' maxlength='30'  onblur="if(this.value==''){document.forms[0].practid.value='';document.forms[0].practid_desc_hid.value=''};BeforeGetPractID1(document.forms[0].pract_id_search,practid_desc);"  ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="if(document.forms[0].practid_desc.value == '') getPractID(this,practid_desc);"  ><img src="../../eCommon/images/mandatory.gif"><input type='hidden' name='practid' id='practid' value="<%=admit_practitioner_id%>" size='15' maxlength='15'  ><input type='hidden' name='practid_desc_hid' id='practid_desc_hid' value="<%=admit_practitioner_name%>" >
										<input type="hidden" name="Admtprct_Chk" id="Admtprct_Chk" value="<%=admit_practitioner_id%>">
									</td>
								</tr>

								<tr>
								
									<td class='label' ><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>
									<td class='querydata' ><b><%=practitioner_name%>&nbsp;</b></td>
									<td nowrap class="fields">
										<input type='text' name='att_practid_desc' id='att_practid_desc' value="<%=practitioner_name%>" size='15' maxlength='30'  onblur="if(this.value==''){document.forms[0].att_practid.value=''};BeforeGetPractID2(document.forms[0].att_pract_id_search,att_practid_desc);" <%=disable_Fields%><%=disable_Field%> ><input type='button' name='att_pract_id_search' id='att_pract_id_search' value='?' class='button' onClick="if(document.forms[0].att_practid_desc.value == '')getPractID(this,att_practid_desc);" <%=disable_Fields%><%=disable_Field%> ><img <%if(adt_status.equals("01") && !bed_no.equals("")){%>style='visibility:visible'<%}else{%>style='visibility:hidden'<%}%>id='attend_img' src="../../eCommon/images/mandatory.gif"><input type='hidden' name='att_practid' id='att_practid' value="<%=practitioner_id%>" size='15' maxlength='15'><input type='hidden' name='att_practid_desc_hid' id='att_practid_desc_hid' value="<%=practitioner_name%>" ><input type='hidden' name='d_referral_id' id='d_referral_id' value=''><input type='hidden' name='d_clinic_code' id='d_clinic_code' value=''>
										<input type="hidden" name="Attndprct_Chk" id="Attndprct_Chk" value="<%=practitioner_id%>">

								 </td>
								</tr>
								<tr><td class='label' ><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td>
									<td  class='querydata' ><b><%=referral_id1%>&nbsp;</b></td>
									<td nowrap class="fields">
									<input type='text' name='referral_id' id='referral_id' value='<%=referral_id1%>'  <%=disableReferral%>  maxlength='20' size='25' onblur='searchReferral(this)'><input type='button' class='button' value='?'  <%=disableReferral%> name='ref_id_search' onClick='getReferralID()'></td>
									<input type="hidden" name="refId_Chk" id="refId_Chk" value="<%=referral_id1%>">
								</tr>
								<%if(customer_id.equals("AMRI")){%>
								<tr>
									<td class='label' ><fmt:message key="Common.admission.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
									<td class='querydata' maxlength='250' style = 'word-break:break-all;'><%=admission_remarks%>&nbsp;</td>
									<td class="fields" width = "35%">
										<textarea name="admission_remarks" width = "35%" rows="3" cols = "35" maxlength='250'   onBlur="makeValidString(this);" onkeyup="return imposeMaxLength(this);"><%=admission_remarks%></textarea>
									</td><input type="hidden" name="admin_remarks_Chk" id="admin_remarks_Chk" value="<%=admission_remarks%>">
								</tr>
								<%}%>
								<tr>
									<td class='label' ><fmt:message key="eIP.ReasonforChangeAdmission.label" bundle="${ip_labels}"/></td>
									<td class='querydata' ><%=revision_resn_desc%>&nbsp;</td>
									<td nowrap class="fields">
										<input type="text" name='revision_resn_desc' id='revision_resn_desc' size="30" maxLength="200" onblur="BeforeReasonLookup();" value="<%=revision_resn_desc%>" ><input type=button name='revis_resn_lookup' id='revis_resn_lookup' value='?' class=button onClick="if(document.forms[0].revision_resn_desc.value == '') ReasonLookup();" ><img src="../../eCommon/images/mandatory.gif"><input type=hidden name='revision_resn_code' id='revision_resn_code' value="<%=revision_resn_code%>"><input type=hidden name='revision_resn_hid_desc' id='revision_resn_hid_desc' >
									</td>
								</tr>
		
			</table>
			<table border='0' cellpadding='0' cellspacing='0' width='100%'  align='left'>
				<tr>
					<td class='label' width = '85%'>&nbsp;</td>
					<td class='fields' width = '15%'>
					<input type='button'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' name='chkIn_Lodger' class='button' onClick="apply()"><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' name='cancel' class='button' onclick='closew()'>
				</td>                 
			</tr>
			</table>

			<!--Common Hidden Vairables Declaration-->
			<input type ='hidden' name='locale' id='locale' value='<%=locale%>'>
			<input type ='hidden' name='patient_class' id='patient_class' value='<%=patient_class%>'>
			<input type ='hidden' name='call_function' id='call_function' value='<%=call_function%>'>
			<input type='hidden'  name='adt_status' id='adt_status' value='<%=adt_status%>'>
			<input type ='hidden' name='admission_date_time' id='admission_date_time' value='<%=admission_date_time%>'>
			<input type ="hidden" name="patient_id" id="patient_id" value="<%=patientid%>">
			<input type ="hidden" name="facility_id" id="facility_id" value="<%=facilityID%>">
			<input type ='hidden' name= 'sStyle' id='sStyle' value="<%=sStyle%>">  
			<input type ='hidden' name= 'encounter_id' id='encounter_id' value="<%=encounterID%>">  
			<input type ='hidden' name= 'bl_instal' id='bl_instal' value="<%=bl_instal%>">  
			<input type ='hidden' name= 'bl_interfaced_yn' id='bl_interfaced_yn' value="<%=bl_interfaced_yn%>">  
			<input type ='hidden' name= 'deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value="<%=deactivate_pseudo_bed_yn%>"> 
			<input type ='hidden' name='to_speciality_code' id='to_speciality_code' value=''>
			<input type ='hidden' name= 'nurs_unt_auth_val' id='nurs_unt_auth_val' value="">  
			<input type ='hidden' name= 'ancillary_yn' id='ancillary_yn' value="">  
			<input type ='hidden' name="baby_flag" id="baby_flag" value="">
			<input type ='hidden' name="gender" id="gender" value="<%=Gender%>">
			<input type='hidden'  name="age" id="age" value="">
			<input type='hidden'  name  ="checkForBilling"  id ="checkForBilling" value="<%=checkForBilling%>">
			<input type='hidden'  name='pat_check_in_allowed_yn' id='pat_check_in_allowed_yn' value='<%=pat_check_in_allowed_yn%>'>
			<!--Hidden Vairables for From Values-->
			<input type='hidden' name='frm_specialty_code' id='frm_specialty_code' value='<%=specialty_code%>'>
			<input type='hidden' name='frm_nursing_unit_code' id='frm_nursing_unit_code' value='<%=nursing_unit_code%>'>
			<input type='hidden' name='frm_service_code' id='frm_service_code' value='<%=service_code%>'>
			<input type='hidden' name='frm_subservice_code' id='frm_subservice_code' value='<%=subservice_code%>'>
			<input type='hidden' name='frm_bed_class_code' id='frm_bed_class_code' value='<%=bed_class_code%>'>
			<input type='hidden' name='frm_bed_type_code' id='frm_bed_type_code' value='<%=bed_type_code%>'>
			<input type='hidden' name='frm_bed_no' id='frm_bed_no' value='<%=bed_no%>'>
			<input type='hidden' name='frm_room_no' id='frm_room_no' value='<%=room_no%>'>
			<input type='hidden' name='frm_admission_type' id='frm_admission_type' value='<%=admission_type%>'>
			<input type='hidden' name='frm_exp_discharge_date_time' id='frm_exp_discharge_date_time' value='<%=exp_discharge_date_time%>'>
			<input type='hidden' name='frm_admit_practitioner_id' id='frm_admit_practitioner_id' value='<%=admit_practitioner_id%>'>
			<input type='hidden' name='frm_practitioner_id' id='frm_practitioner_id' value='<%=practitioner_id%>'>
			<input type='hidden' name='frm_ot_date_time' id='frm_ot_date_time' value='<%=OT_date_time%>'>
			<input type='hidden' name='frm_revision_resn_code' id='frm_revision_resn_code' value='<%=revision_resn_code%>'>
			<input type='hidden' name='frm_ambulatory_status_code' id='frm_ambulatory_status_code' value='<%=ambulatory_status_code%>'>
			<input type='hidden' name='confirm_flag' id='confirm_flag' value='Y'>
			<input type='hidden' name='r_bed_no' id='r_bed_no' value=''>
			<input type='hidden' name='disable_Fields' id='disable_Fields' value='<%=disable_Fields%>'>
			<input type='hidden' name='err_status' id='err_status' value='<%=err_status%>'>
			<input type='hidden' name='att_practitioner_name' id='att_practitioner_name' value='<%=practitioner_name%>'>
			<input type='hidden' name='att_practitioner_id' id='att_practitioner_id' value='<%=practitioner_id%>'>
			<input type='hidden' name='tfr_req_status' id='tfr_req_status' value='<%=tfr_req_status%>'>
			<input type="hidden" name="patient_class_value" id="patient_class_value" value="<%=patient_class%>" >
			<input type='hidden' name="valid" id="valid" value="<%=valid%>">
			<input type='hidden' name="from_time" id="from_time" value="<%=from_time%>">
			<input type='hidden' name="max_param_date" id="max_param_date" value="<%=max_param_date%>">
			<input type='hidden' name="valid_date" id="valid_date" value="<%=valid_date%>">
			<input type='hidden' name="referral_id_old" id="referral_id_old" value="<%=referral_id1%>">
			<input type='hidden' name="customer_id" id="customer_id" value="<%=customer_id%>">



		</form>
	</body>
	<script>			
		if('<%=bl_instal%>' =='Y' && '<%=install_yn%>'=='Y') {
				document.getElementById('nursing_unit_desc').disabled = true;
				document.getElementById('nursing_unit_lookup').disabled = true;
				document.getElementById('Bedcode').disabled = true;
				document.getElementById("bed_type").disabled = true;	 
			} else {
				/*Friday, July 09, 2010 , condition added since if billing is not installed and admission time exceeds over parameter value or patient is transfered , system enables nursing unit,bed class and bed type.*/
				if('<%=adm_time_xcd%>' == 'true' && '<%=tr_err_status%>' == 'true'){
					document.getElementById('nursing_unit_desc').disabled = false;
					document.getElementById('nursing_unit_lookup').disabled = false;
					document.getElementById('Bedcode').disabled = false;
					document.getElementById("bed_type").disabled = false;
				}else
				{
					document.getElementById('nursing_unit_desc').disabled = true;
					document.getElementById('nursing_unit_lookup').disabled = true;
					document.getElementById('Bedcode').disabled = true;
					document.getElementById("bed_type").disabled = true;
				}
			} 				
	</script>
	<%}catch(Exception ex){
	ex.printStackTrace();
	}finally{
	if(stmt!= null)stmt.close();
	if(rs!= null)rs.close();
	if(stm!= null)stm.close();
	if(res!= null)res.close();
	if(stm1!= null)stm1.close();
	if(res1!= null)res1.close();
	ConnectionManager.returnConnection(con,request); 
}%>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

